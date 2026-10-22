package com.android.server;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.FastXmlSerializer;
import com.android.server.am.HostingRecord;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class BlockPackageHelper {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_VERSION = "version";
    private static final boolean DBG = false;
    private static final int DB_VERSION = 1;
    private static final String TAG = "BlockPackageHelper";
    private static final String TAG_BLOCKED_PKGS = "blocked-packages";
    private static final String TAG_BODY = "redirection-policy";
    private static final String TAG_PACKAGE = "package";
    private HashSet<String> mBlockedPackages;
    private Context mContext;
    private AtomicFile mPolicyFile;

    public BlockPackageHelper(Context context) {
        this.mBlockedPackages = new HashSet();
        this.mContext = context;
        loadBlockDb();
    }

    private void checkCallerIsSystem() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.CHANGE_CONFIGURATION", null);
        int uid = Binder.getCallingUid();
        if (UserHandle.getAppId(uid) == 1000) goto L8;
        if (uid != 0) goto L7;
        return;
    L7:
        throw new SecurityException("Disallowed call for uid " + uid);
    }

    public void setThemeBlockedForPackage(String pkg, boolean blocked) {
        checkCallerIsSystem();
        if (blocked == false) goto L5;
        this.mBlockedPackages.add(pkg);
        return;
    L5:
        this.mBlockedPackages.remove(pkg);
    }

    public boolean isThemeBlockedForPackage(String pkg) {
        boolean blocked = this.mBlockedPackages.contains(pkg);
        return blocked;
    }

    public void persistentThemeBlockingInfo() {
        checkCallerIsSystem();
        writeBlockDb();
        ActivityManager r0 = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        Configuration config = null;
        config = ActivityManager.getService().getConfiguration();     // Catch: RemoteException -> L5
    L7:
        if (config != null) goto L9;
        return;
    L9:
        config.getSmtEx().updateIconSeq++;
        ActivityManager.getService().updateConfiguration(config);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void reloadBlockDb() {
        checkCallerIsSystem();
        loadBlockDb();
    }

    private void loadBlockDb() {
        HashSet<String> r0 = this.mBlockedPackages;
        monitor-enter(r0);
        File dir = new File("/data/system");     // Catch: Throwable -> L39
        this.mPolicyFile = new AtomicFile(new File(dir, "redirection_policy.xml"));     // Catch: Throwable -> L39
        this.mBlockedPackages.clear();     // Catch: Throwable -> L39
        FileInputStream infile = null;
        infile = this.mPolicyFile.openRead();     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
        parser.setInput(infile, null);     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
    L7:
        int type = parser.next();     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
        if (type == 1) goto L37;
        String tag = parser.getName();     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
        if (type != 2) goto L7;
        if (TAG_BODY.equals(tag) == true) goto L13;
        if (TAG_BLOCKED_PKGS.equals(tag) == false) goto L7;
    L26:
        int type2 = parser.next();     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
        if (type2 == 1) goto L7;
        String tag2 = parser.getName();     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
        if ("package".equals(tag2) == true) goto L30;
        if (TAG_BLOCKED_PKGS.equals(tag2) == false) goto L26;
        if (type2 != 3) goto L26;
    L30:
        this.mBlockedPackages.add(parser.getAttributeValue(null, "name"));     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
        goto L26
    L13:
        int r8 = Integer.parseInt(parser.getAttributeValue(null, ATTR_VERSION));     // Catch: Throwable -> L14 XmlPullParserException -> L16 NumberFormatException -> L18 IOException -> L20 FileNotFoundException -> L22
        goto L7
    L37:
        IoUtils.closeQuietly(infile);     // Catch: Throwable -> L39
    L51:
        monitor-exit(r0);     // Catch: Throwable -> L39
        return;
    L14:
        th = move-exception;
        IoUtils.closeQuietly(infile);     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L20:
        e = move-exception;
        Slog.e(TAG, "Unable to read blocked notifications database", e);     // Catch: Throwable -> L14
    L16:
        e = move-exception;
        Slog.e(TAG, "Unable to parse blocked notifications database", e);     // Catch: Throwable -> L14
    L18:
        e = move-exception;
        Slog.e(TAG, "Unable to parse blocked notifications database", e);     // Catch: Throwable -> L14
    L43:
        IoUtils.closeQuietly(infile);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;
    }

    private void writeBlockDb() {
        HashSet<String> r0 = this.mBlockedPackages;
        monitor-enter(r0);
        Iterator<String> it = this.mBlockedPackages.iterator();     // Catch: Throwable -> L11
    L6:
        if (it.hasNext() == false) goto L14;
        String pkg = it.next();     // Catch: Throwable -> L11
        if (isPackageExisting(pkg) == true) goto L6;
        it.remove();     // Catch: Throwable -> L11
        goto L6
    L14:
        FileOutputStream outfile = null;
        outfile = this.mPolicyFile.startWrite();     // Catch: Throwable -> L11 IOException -> L19
        FastXmlSerializer r3 = new FastXmlSerializer();     // Catch: Throwable -> L11 IOException -> L19
        r3.setOutput(outfile, "utf-8");     // Catch: Throwable -> L11 IOException -> L19
        r3.startDocument(null, true);     // Catch: Throwable -> L11 IOException -> L19
        r3.startTag(null, TAG_BODY);     // Catch: Throwable -> L11 IOException -> L19
        r3.attribute(null, ATTR_VERSION, String.valueOf(1));     // Catch: Throwable -> L11 IOException -> L19
        r3.startTag(null, TAG_BLOCKED_PKGS);     // Catch: Throwable -> L11 IOException -> L19
        Iterator<String> r4 = this.mBlockedPackages.iterator();     // Catch: Throwable -> L11 IOException -> L19
    L17:
        if (r4.hasNext() == false) goto L21;
        String pkg2 = r4.next();     // Catch: Throwable -> L11 IOException -> L19
        r3.startTag(null, "package");     // Catch: Throwable -> L11 IOException -> L19
        r3.attribute(null, "name", pkg2);     // Catch: Throwable -> L11 IOException -> L19
        r3.endTag(null, "package");     // Catch: Throwable -> L11 IOException -> L19
        goto L17
    L21:
        r3.endTag(null, TAG_BLOCKED_PKGS);     // Catch: Throwable -> L11 IOException -> L19
        r3.endTag(null, TAG_BODY);     // Catch: Throwable -> L11 IOException -> L19
        r3.endDocument();     // Catch: Throwable -> L11 IOException -> L19
        this.mPolicyFile.finishWrite(outfile);     // Catch: Throwable -> L11 IOException -> L19
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L24:
        if (outfile == null) goto L26;
        this.mPolicyFile.failWrite(outfile);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isPackageExisting(String pkg) {
        if (TextUtils.isEmpty(pkg) == false) goto L10;
        return false;
    L10:
        this.mContext.getPackageManager().getApplicationInfo(pkg, 8192);     // Catch: PackageManager.NameNotFoundException -> L8
        return true;
    L9:
        return false;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix);
        pw.println("block package size: " + this.mBlockedPackages.size());
        Iterator<String> it = this.mBlockedPackages.iterator();
    L4:
        if (it.hasNext() == false) goto L6;
        String pkg = it.next();
        pw.println(pkg);
        goto L4
    }
}
