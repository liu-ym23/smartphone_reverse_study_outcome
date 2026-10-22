package com.android.server.devicepolicy;

import android.app.admin.StartInstallingUpdateCallback;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.UpdateEngine;
import android.os.UpdateEngineCallback;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
class AbUpdateInstaller extends UpdateInstaller {
    private static final int DOWNLOAD_STATE_INITIALIZATION_ERROR = 20;
    private static final int OFFSET_TO_FILE_NAME = 30;
    private static final String PAYLOAD_BIN = "payload.bin";
    private static final String PAYLOAD_PROPERTIES_TXT = "payload_properties.txt";
    public static final String UNKNOWN_ERROR = "Unknown error with error code = ";
    private static final Map<Integer, Integer> errorCodesMap = null;
    private static final Map<Integer, String> errorStringsMap = null;
    private Enumeration<? extends ZipEntry> mEntries;
    private long mOffsetForUpdate;
    private ZipFile mPackedUpdateFile;
    private List<String> mProperties;
    private long mSizeForUpdate;
    private boolean mUpdateInstalled;

    private static class DelegatingUpdateEngineCallback extends UpdateEngineCallback {
        private UpdateEngine mUpdateEngine;
        private UpdateInstaller mUpdateInstaller;

        DelegatingUpdateEngineCallback(UpdateInstaller updateInstaller, UpdateEngine updateEngine) {
            this.mUpdateInstaller = updateInstaller;
            this.mUpdateEngine = updateEngine;
        }

        public void onStatusUpdate(int statusCode, float percentage) {
        }

        public void onPayloadApplicationComplete(int errorCode) {
            this.mUpdateEngine.unbind();
            if (errorCode != 0) goto L5;
            this.mUpdateInstaller.notifyCallbackOnSuccess();
            return;
        L5:
            this.mUpdateInstaller.notifyCallbackOnError(((Integer) AbUpdateInstaller.m3320$$Nest$sfgeterrorCodesMap().getOrDefault(Integer.valueOf(errorCode), 1)).intValue(), (String) AbUpdateInstaller.m3321$$Nest$sfgeterrorStringsMap().getOrDefault(Integer.valueOf(errorCode), AbUpdateInstaller.UNKNOWN_ERROR + errorCode));
        }
    }

    public static /* synthetic */ String[] $r8$lambda$tzOuLVWONxpsTAMbpVm243Bk_aQ(int r0) {
        return lambda$applyPayload$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgeterrorCodesMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3320$$Nest$sfgeterrorCodesMap() {
        return errorCodesMap;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgeterrorStringsMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m3321$$Nest$sfgeterrorStringsMap() {
        return errorStringsMap;
    }

    static {
        errorCodesMap = buildErrorCodesMap();
        errorStringsMap = buildErrorStringsMap();
    }

    private static Map<Integer, Integer> buildErrorCodesMap() {
        Map<Integer, Integer> map = new HashMap();
        map.put(1, 1);
        map.put(20, 2);
        map.put(51, 2);
        map.put(12, 3);
        map.put(11, 3);
        map.put(6, 3);
        map.put(10, 3);
        map.put(26, 3);
        map.put(5, 1);
        map.put(7, 1);
        map.put(9, 1);
        map.put(52, 1);
        return map;
    }

    private static Map<Integer, String> buildErrorStringsMap() {
        Map<Integer, String> map = new HashMap();
        map.put(1, UNKNOWN_ERROR);
        map.put(20, "The delta update payload was targeted for another version or the source partitionwas modified after it was installed");
        map.put(5, "Failed to finish the configured postinstall works.");
        map.put(7, "Failed to open one of the partitions it tried to write to or read data from.");
        map.put(6, "Payload mismatch error.");
        map.put(9, "Failed to read the payload data from the given URL.");
        map.put(10, "Payload hash error.");
        map.put(11, "Payload size mismatch error.");
        map.put(12, "Failed to verify the signature of the payload.");
        map.put(52, "The payload has been successfully installed,but the active slot was not flipped.");
        return map;
    }

    AbUpdateInstaller(Context context, ParcelFileDescriptor updateFileDescriptor, StartInstallingUpdateCallback callback, DevicePolicyManagerService.Injector injector, DevicePolicyConstants constants) {
        super(context, updateFileDescriptor, callback, injector, constants);
        this.mUpdateInstalled = false;
    }

    @Override // com.android.server.devicepolicy.UpdateInstaller
    public void installUpdateInThread() {
        if (this.mUpdateInstalled == true) goto L14;
        setState();     // Catch: IOException -> L6 ZipException -> L8
        applyPayload(Paths.get(this.mCopiedUpdateFile.getAbsolutePath(), new String[0]).toUri().toString());     // Catch: IOException -> L6 ZipException -> L8
    L17:
        return;
    L8:
        e = move-exception;
        Log.w("UpdateInstaller", e);
        notifyCallbackOnError(3, Log.getStackTraceString(e));
        return;
    L6:
        e = move-exception;
        Log.w("UpdateInstaller", e);
        notifyCallbackOnError(1, Log.getStackTraceString(e));
        return;
    L14:
        throw new IllegalStateException("installUpdateInThread can be called only once.");
    }

    private void setState() throws IOException {
        this.mUpdateInstalled = true;
        this.mPackedUpdateFile = new ZipFile(this.mCopiedUpdateFile);
        this.mProperties = new ArrayList();
        this.mSizeForUpdate = -1;
        this.mOffsetForUpdate = 0;
        this.mEntries = this.mPackedUpdateFile.entries();
    }

    private UpdateEngine buildBoundUpdateEngine() {
        UpdateEngine updateEngine = new UpdateEngine();
        updateEngine.bind(new DelegatingUpdateEngineCallback(this, updateEngine));
        return updateEngine;
    }

    private void applyPayload(String updatePath) throws IOException {
        if (updateStateForPayload() == true) goto L5;
        return;
    L5:
        String[] headerKeyValuePairs = (String[]) this.mProperties.stream().toArray(new AbUpdateInstaller$$ExternalSyntheticLambda0());
        if (this.mSizeForUpdate != (-1)) goto L9;
        Log.w("UpdateInstaller", "Failed to find payload entry in the given package.");
        notifyCallbackOnError(3, "Failed to find payload entry in the given package.");
        return;
    L9:
        UpdateEngine updateEngine = buildBoundUpdateEngine();
        updateEngine.applyPayload(updatePath, this.mOffsetForUpdate, this.mSizeForUpdate, headerKeyValuePairs);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Exception e = e;
    L18:
        Log.w("UpdateInstaller", "Failed to install update from file.", e);
        notifyCallbackOnError(1, "Failed to install update from file.");
        return;
    L16:
        e = move-exception;
        e = e;
        goto L18
    }

    private static /* synthetic */ String[] lambda$applyPayload$0(int x$0) {
        return new String[x$0];
    }

    private boolean updateStateForPayload() throws IOException {
        long offset = 0;
    L4:
        if (this.mEntries.hasMoreElements() == false) goto L19;
        ZipEntry entry = this.mEntries.nextElement();
        String name = entry.getName();
        offset = offset + buildOffsetForEntry(entry, name);
        if (entry.isDirectory() == true) goto L7;
        if (PAYLOAD_BIN.equals(name) == true) goto L11;
        if (PAYLOAD_PROPERTIES_TXT.equals(name) == false) goto L4;
        updatePropertiesForEntry(entry);
        goto L4
    L11:
        if (entry.getMethod() != 0) goto L12;
        this.mSizeForUpdate = entry.getCompressedSize();
        this.mOffsetForUpdate = offset - entry.getCompressedSize();
        goto L4
    L12:
        Log.w("UpdateInstaller", "Invalid compression method.");
        notifyCallbackOnError(3, "Invalid compression method.");
        return false;
    L7:
        offset = offset - entry.getCompressedSize();
        goto L4
    L19:
        return true;
    }

    private long buildOffsetForEntry(ZipEntry entry, String name) {
        long r0 = ((long) (name.length() + 30)) + entry.getCompressedSize();
        if (entry.getExtra() != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + ((long) r2);
    L5:
        r2 = entry.getExtra().length;
        goto L7
    }

    private void updatePropertiesForEntry(ZipEntry entry) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.mPackedUpdateFile.getInputStream(entry)));
    L18:
        String line = bufferedReader.readLine();     // Catch: Throwable -> L7
        if (line == null) goto L9;
        this.mProperties.add(line);     // Catch: Throwable -> L7
        goto L18
    L9:
        bufferedReader.close();
        return;
    L7:
        th = move-exception;
        bufferedReader.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }
}
