package com.android.server.updates;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.util.Slog;
import com.android.internal.util.HexDump;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import libcore.io.IoUtils;
import libcore.io.Streams;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigUpdateInstallReceiver extends BroadcastReceiver {
    private static final String EXTRA_REQUIRED_HASH = "REQUIRED_HASH";
    private static final String EXTRA_VERSION_NUMBER = "VERSION";
    private static final String TAG = "ConfigUpdateInstallReceiver";
    protected final File updateContent;
    protected final File updateDir;
    protected final File updateVersion;

    /* JADX INFO: renamed from: -$$Nest$mgetAltContent, reason: not valid java name */
    static /* bridge */ /* synthetic */ BufferedInputStream m9036$$Nest$mgetAltContent(ConfigUpdateInstallReceiver r0, Context r1, Intent r2) {
        return r0.getAltContent(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentContent, reason: not valid java name */
    static /* bridge */ /* synthetic */ byte[] m9037$$Nest$mgetCurrentContent(ConfigUpdateInstallReceiver r0) {
        return r0.getCurrentContent();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9038$$Nest$mgetCurrentVersion(ConfigUpdateInstallReceiver r0) {
        return r0.getCurrentVersion();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRequiredHashFromIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9039$$Nest$mgetRequiredHashFromIntent(ConfigUpdateInstallReceiver r0, Intent r1) {
        return r0.getRequiredHashFromIntent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetVersionFromIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9040$$Nest$mgetVersionFromIntent(ConfigUpdateInstallReceiver r0, Intent r1) {
        return r0.getVersionFromIntent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mverifyPreviousHash, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9041$$Nest$mverifyPreviousHash(ConfigUpdateInstallReceiver r0, String r1, String r2) {
        return r0.verifyPreviousHash(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetCurrentHash, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9042$$Nest$smgetCurrentHash(byte[] r0) {
        return getCurrentHash(r0);
    }

    public ConfigUpdateInstallReceiver(String updateDir, String updateContentPath, String updateMetadataPath, String updateVersionPath) {
        this.updateDir = new File(updateDir);
        this.updateContent = new File(updateDir, updateContentPath);
        File updateMetadataDir = new File(updateDir, updateMetadataPath);
        this.updateVersion = new File(updateMetadataDir, updateVersionPath);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        new AnonymousClass1(this, intent, context).start();
    }

    private Uri getContentFromIntent(Intent i) {
        Uri data = i.getData();
        if (data == null) goto L6;
        return data;
    L6:
        throw new IllegalStateException("Missing required content path, ignoring.");
    }

    private int getVersionFromIntent(Intent i) throws NumberFormatException {
        String extraValue = i.getStringExtra(EXTRA_VERSION_NUMBER);
        if (extraValue == null) goto L7;
        return Integer.parseInt(extraValue.trim());
    L7:
        throw new IllegalStateException("Missing required version number, ignoring.");
    }

    private String getRequiredHashFromIntent(Intent i) {
        String extraValue = i.getStringExtra(EXTRA_REQUIRED_HASH);
        if (extraValue == null) goto L7;
        return extraValue.trim();
    L7:
        throw new IllegalStateException("Missing required previous hash, ignoring.");
    }

    private int getCurrentVersion() throws NumberFormatException {
        String strVersion = IoUtils.readFileAsString(this.updateVersion.getCanonicalPath()).trim();     // Catch: IOException -> L4
        return Integer.parseInt(strVersion);
    L5:
        Slog.i(TAG, "Couldn't find current metadata, assuming first update");
        return 0;
    }

    private BufferedInputStream getAltContent(Context c, Intent i) throws IOException {
        Uri content = getContentFromIntent(i);
        Binder.allowBlockingForCurrentThread();
        BufferedInputStream r1 = new BufferedInputStream(c.getContentResolver().openInputStream(content));     // Catch: Throwable -> L6
        Binder.defaultBlockingForCurrentThread();
        return r1;
    L6:
        th = move-exception;
        Binder.defaultBlockingForCurrentThread();
        throw th;
    }

    private byte[] getCurrentContent() {
        return IoUtils.readFileAsByteArray(this.updateContent.getCanonicalPath());
    L5:
        Slog.i(TAG, "Failed to read current content, assuming first update!");
        return null;
    }

    private static String getCurrentHash(byte[] content) {
        if (content != null) goto L10;
        return "0";
    L10:
        MessageDigest dgst = MessageDigest.getInstance("SHA512");     // Catch: NoSuchAlgorithmException -> L7
        byte[] fingerprint = dgst.digest(content);     // Catch: NoSuchAlgorithmException -> L7
        return HexDump.toHexString(fingerprint, false);
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    protected boolean verifyVersion(int current, int alternative) {
        if (current >= alternative) goto L4;
        return true;
    L4:
        return false;
    }

    private boolean verifyPreviousHash(String current, String required) {
        if (required.equals("NONE") == false) goto L7;
        return true;
    L7:
        return current.equals(required);
    }

    protected void writeUpdate(File dir, File file, InputStream inputStream) throws IOException {
        File tmp = null;
        File parent = file.getParentFile();     // Catch: Throwable -> L8
        parent.mkdirs();     // Catch: Throwable -> L8
        if (parent.exists() == false) goto L17;
    L6:
        if (parent.equals(this.updateDir) == true) goto L10;
        parent.setExecutable(true, false);     // Catch: Throwable -> L8
        parent = parent.getParentFile();     // Catch: Throwable -> L8
        goto L6
    L10:
        File tmp2 = File.createTempFile("journal", "", dir);     // Catch: Throwable -> L8
        tmp2.setReadable(true, false);     // Catch: Throwable -> L8
        FileOutputStream out = new FileOutputStream(tmp2);     // Catch: Throwable -> L8
        Streams.copy(inputStream, out);     // Catch: Throwable -> L8
        out.getFD().sync();     // Catch: Throwable -> L8
        if (tmp2.renameTo(file) == false) goto L15;
        tmp2.delete();
        IoUtils.closeQuietly(out);
        return;
    L15:
        throw new IOException("Failed to atomically rename " + file.getCanonicalPath());     // Catch: Throwable -> L8
    L17:
        throw new IOException("Failed to create directory " + parent.getCanonicalPath());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (0 == 0) goto L20;
        tmp.delete();
    L20:
        IoUtils.closeQuietly(null);
        throw th;
    }

    protected void install(InputStream inputStream, int version) throws IOException {
        writeUpdate(this.updateDir, this.updateContent, inputStream);
        writeUpdate(this.updateDir, this.updateVersion, new ByteArrayInputStream(Long.toString(version).getBytes()));
    }

    protected void postInstall(Context context, Intent intent) {
    }
}
