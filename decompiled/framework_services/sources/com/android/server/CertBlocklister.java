package com.android.server;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Binder;
import android.os.FileUtils;
import android.provider.Settings;
import android.util.Slog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public class CertBlocklister extends Binder {
    private static final String DENYLIST_ROOT = null;
    public static final String PUBKEY_BLOCKLIST_KEY = "pubkey_blacklist";
    public static final String PUBKEY_PATH = null;
    public static final String SERIAL_BLOCKLIST_KEY = "serial_blacklist";
    public static final String SERIAL_PATH = null;
    private static final String TAG = "CertBlocklister";

    private static class BlocklistObserver extends ContentObserver {
        private final ContentResolver mContentResolver;
        private final String mKey;
        private final String mName;
        private final String mPath;
        private final File mTmpDir;

        /* JADX INFO: renamed from: -$$Nest$mwriteDenylist, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m146$$Nest$mwriteDenylist(BlocklistObserver r0) {
            r0.writeDenylist();
        }

        BlocklistObserver(String key, String name, String path, ContentResolver cr) {
            super(null);
            this.mKey = key;
            this.mName = name;
            this.mPath = path;
            this.mTmpDir = new File(this.mPath).getParentFile();
            this.mContentResolver = cr;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            final String r1 = "BlocklistUpdater";
            new AnonymousClass1(this, r1).start();
        }

        public String getValue() {
            return Settings.Secure.getStringForUser(this.mContentResolver, this.mKey, this.mContentResolver.getUserId());
        }

        private void writeDenylist() {
            File r0 = this.mTmpDir;
            monitor-enter(r0);
            String blocklist = getValue();     // Catch: Throwable -> L8
            if (blocklist != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.mPath.equals(CertBlocklister.SERIAL_PATH) == false) goto L13;
            Slog.w(CertBlocklister.TAG, "The certificate blocklist based on serials is deprecated. Please use the pubkey blocklist instead.");     // Catch: Throwable -> L8
        L13:
            Slog.i(CertBlocklister.TAG, "Certificate blocklist changed, updating...");     // Catch: Throwable -> L8
            FileOutputStream out = null;
            File tmp = File.createTempFile("journal", "", this.mTmpDir);     // Catch: Throwable -> L18 IOException -> L20
            tmp.setReadable(true, false);     // Catch: Throwable -> L18 IOException -> L20
            out = new FileOutputStream(tmp);     // Catch: Throwable -> L18 IOException -> L20
            out.write(blocklist.getBytes());     // Catch: Throwable -> L18 IOException -> L20
            FileUtils.sync(out);     // Catch: Throwable -> L18 IOException -> L20
            tmp.renameTo(new File(this.mPath));     // Catch: Throwable -> L18 IOException -> L20
            Slog.i(CertBlocklister.TAG, "Certificate blocklist updated");     // Catch: Throwable -> L18 IOException -> L20
        L16:
            IoUtils.closeQuietly(out);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L18:
            th = move-exception;
            IoUtils.closeQuietly(out);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L20:
            e = move-exception;
            Slog.e(CertBlocklister.TAG, "Failed to write blocklist", e);     // Catch: Throwable -> L18
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        DENYLIST_ROOT = System.getenv("ANDROID_DATA") + "/misc/keychain/";
        PUBKEY_PATH = DENYLIST_ROOT + "pubkey_blacklist.txt";
        SERIAL_PATH = DENYLIST_ROOT + "serial_blacklist.txt";
    }

    public CertBlocklister(Context context) {
        registerObservers(context.getContentResolver());
    }

    private BlocklistObserver buildPubkeyObserver(ContentResolver cr) {
        return new BlocklistObserver(PUBKEY_BLOCKLIST_KEY, "pubkey", PUBKEY_PATH, cr);
    }

    private BlocklistObserver buildSerialObserver(ContentResolver cr) {
        return new BlocklistObserver(SERIAL_BLOCKLIST_KEY, "serial", SERIAL_PATH, cr);
    }

    private void registerObservers(ContentResolver cr) {
        cr.registerContentObserver(Settings.Secure.getUriFor(PUBKEY_BLOCKLIST_KEY), true, buildPubkeyObserver(cr));
        cr.registerContentObserver(Settings.Secure.getUriFor(SERIAL_BLOCKLIST_KEY), true, buildSerialObserver(cr));
    }
}
