package com.android.server.pm;

import android.content.pm.PackageInfo;
import android.content.pm.ShortcutInfo;
import android.graphics.Bitmap;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.Preconditions;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
abstract class ShortcutPackageItem {
    private static final String KEY_NAME = "name";
    private static final String TAG = "ShortcutService";
    private final ShortcutPackageInfo mPackageInfo;
    protected final Object mPackageItemLock;
    private final String mPackageName;
    private final int mPackageUserId;
    private final Runnable mSaveShortcutPackageRunner;
    protected final ShortcutBitmapSaver mShortcutBitmapSaver;
    protected ShortcutUser mShortcutUser;

    protected abstract boolean canRestoreAnyVersion();

    public abstract int getOwnerUserId();

    protected abstract File getShortcutPackageItemFile();

    protected abstract void onRestored(int r1);

    public abstract void saveToXml(TypedXmlSerializer r1, boolean r2) throws IOException, XmlPullParserException;

    protected ShortcutPackageItem(ShortcutUser shortcutUser, int packageUserId, String packageName, ShortcutPackageInfo packageInfo) {
        this.mPackageItemLock = new Object();
        this.mSaveShortcutPackageRunner = new ShortcutPackageItem$$ExternalSyntheticLambda0(this);
        this.mShortcutUser = shortcutUser;
        this.mPackageUserId = packageUserId;
        this.mPackageName = (String) Preconditions.checkStringNotEmpty(packageName);
        packageInfo.getClass();
        this.mPackageInfo = packageInfo;
        this.mShortcutBitmapSaver = new ShortcutBitmapSaver(shortcutUser.mService);
    }

    public void replaceUser(ShortcutUser user) {
        this.mShortcutUser = user;
    }

    public ShortcutUser getUser() {
        return this.mShortcutUser;
    }

    public int getPackageUserId() {
        return this.mPackageUserId;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public ShortcutPackageInfo getPackageInfo() {
        return this.mPackageInfo;
    }

    public void refreshPackageSignatureAndSave() {
        if (this.mPackageInfo.isShadow() == false) goto L5;
        return;
    L5:
        ShortcutService s = this.mShortcutUser.mService;
        this.mPackageInfo.refreshSignature(s, this);
        scheduleSave();
    }

    public void attemptToRestoreIfNeededAndSave() {
        if (this.mPackageInfo.isShadow() == true) goto L5;
        return;
    L5:
        ShortcutService s = this.mShortcutUser.mService;
        if (s.isPackageInstalled(this.mPackageName, this.mPackageUserId) == true) goto L9;
        return;
    L9:
        if (this.mPackageInfo.hasSignatures() == true) goto L11;
        s.wtf("Attempted to restore package " + this.mPackageName + "/u" + this.mPackageUserId + " but signatures not found in the restore data.");
        int restoreBlockReason = 102;
    L12:
        onRestored(restoreBlockReason);
        this.mPackageInfo.setShadow(false);
        scheduleSave();
        return;
    L11:
        PackageInfo pi = s.getPackageInfoWithSignatures(this.mPackageName, this.mPackageUserId);
        pi.getLongVersionCode();
        restoreBlockReason = this.mPackageInfo.canRestoreTo(s, pi, canRestoreAnyVersion());
        goto L12
    }

    public void saveToFileLocked(File path, boolean forBackup) {
        ResilientAtomicFile file = getResilientFile(path);
        FileOutputStream os = null;
        os = file.startWrite();     // Catch: Throwable -> L6 Throwable -> L8
        if (forBackup == false) goto L10;
        TypedXmlSerializer itemOut = Xml.newFastSerializer();     // Catch: Throwable -> L6 Throwable -> L8
        itemOut.setOutput(os, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L6 Throwable -> L8
    L11:
        itemOut.startDocument(null, true);     // Catch: Throwable -> L6 Throwable -> L8
        saveToXml(itemOut, forBackup);     // Catch: Throwable -> L6 Throwable -> L8
        itemOut.endDocument();     // Catch: Throwable -> L6 Throwable -> L8
        os.flush();     // Catch: Throwable -> L6 Throwable -> L8
        this.mShortcutUser.mService.injectFinishWrite(file, os);     // Catch: Throwable -> L6 Throwable -> L8
    L15:
        if (file == null) goto L28;
        file.close();
        return;
    L28:
        return;
    L10:
        itemOut = Xml.resolveSerializer(os);     // Catch: Throwable -> L6 Throwable -> L8
    L6:
        th = move-exception;
        if (file != null) goto L24;
    L23:
        throw th;
    L24:
        file.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to write to file " + file.getBaseFile(), e);     // Catch: Throwable -> L6
        file.failWrite(os);     // Catch: Throwable -> L6
        goto L15
    }

    public JSONObject dumpCheckin(boolean clear) throws JSONException {
        JSONObject result = new JSONObject();
        result.put("name", this.mPackageName);
        return result;
    }

    public void verifyStates() {
    }

    public void scheduleSave() {
        this.mShortcutUser.mService.injectPostToHandlerDebounced(this.mSaveShortcutPackageRunner, this.mSaveShortcutPackageRunner);
    }

    void saveShortcutPackageItem() {
        waitForBitmapSaves();
        File path = getShortcutPackageItemFile();
        Object r1 = this.mPackageItemLock;
        monitor-enter(r1);
        path.getParentFile().mkdirs();     // Catch: Throwable -> L7
        saveToFileLocked(path, false);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean waitForBitmapSaves() {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        boolean r1 = this.mShortcutBitmapSaver.waitForAllSavesLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void saveBitmap(ShortcutInfo shortcut, int maxDimension, Bitmap.CompressFormat format, int quality) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        this.mShortcutBitmapSaver.saveBitmapLocked(shortcut, maxDimension, format, quality);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String getBitmapPathMayWait(ShortcutInfo shortcut) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        String r1 = this.mShortcutBitmapSaver.getBitmapPathMayWaitLocked(shortcut);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeIcon(ShortcutInfo shortcut) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        this.mShortcutBitmapSaver.removeIcon(shortcut);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeShortcutPackageItem() {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        getResilientFile(getShortcutPackageItemFile()).delete();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected static ResilientAtomicFile getResilientFile(File file) {
        String path = file.getPath();
        File temporaryBackup = new File(path + ".backup");
        File reserveCopy = new File(path + ".reservecopy");
        return new ResilientAtomicFile(file, temporaryBackup, reserveCopy, 505, "shortcut package item", null);
    }
}
