package com.android.server.appop;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.server.LocalServices;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class AppOpsServiceZteHook {
    private static final String APPOPS_POLICY = "/system/etc/zte_access_appops_mode_policy.xml";
    private static final boolean DEBUG = false;
    static final String TAG = "AppOpsServiceZteHook";
    private static ArrayList<ZtePermBase> mAppOpsPolicy;
    private static AppOpsServiceZteHook sInstance;
    private static final Object sInstanceLock = null;
    private final Context mContext;
    private final PackageManagerInternal mPmInternal;

    public static class ZtePermBase {
        public int appOps_opValue;
        public String packageName;
        public String permName;
        public boolean pregrant;
        public String sig_SHA256;

        public ZtePermBase() {
            this.packageName = null;
            this.sig_SHA256 = null;
            this.appOps_opValue = -1;
            this.permName = null;
            this.pregrant = false;
        }
    }

    static {
        mAppOpsPolicy = new ArrayList();
        sInstance = null;
        sInstanceLock = new Object();
    }

    private AppOpsServiceZteHook(Context context) {
        this.mContext = context;
        this.mPmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        mAppOpsPolicy = pullParseSecurityPolicyXml(APPOPS_POLICY);
    }

    public static AppOpsServiceZteHook getInstance(Context context) {
        if (sInstance != null) goto L16;
        Object r0 = sInstanceLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new AppOpsServiceZteHook(context);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public static boolean enforceManageAppOpsModesForZte(Context context, int callingPid, int callingUid, int targetUid, String packageName, int code) {
        AppOpsServiceZteHook instance = getInstance(context);     // Catch: Exception -> L10
        if (instance != null) goto L6;
        return false;
    L6:
        if (instance.checkAccesAppOpsForZte(packageName, code) == false) goto L19;
        Slog.w(TAG, "enforceManageAppOpsModesForZte allow " + packageName + " to access AppOps Mode");     // Catch: Exception -> L10
        return true;
    L19:
        return false;
    L10:
        e = move-exception;
        Slog.w(TAG, "enforceManageAppOpsModesForZte e=" + e);
        return false;
    }

    private boolean checkAccesAppOpsForZte(String packageName, int op) {
        if (mAppOpsPolicy != null) goto L5;
    L25:
        return false;
    L5:
        if (mAppOpsPolicy.size() == 0) goto L25;
        if (packageName != null) goto L9;
    L24:
        return false;
    L9:
        if (op == (-1)) goto L24;
        Iterator<ZtePermBase> r0 = mAppOpsPolicy.iterator();
    L13:
        if (r0.hasNext() == false) goto L23;
        ZtePermBase pkg = r0.next();
        if (packageName.equals(pkg.packageName) == false) goto L13;
        if (checkPkgSig256Legal(packageName, pkg.sig_SHA256) == false) goto L13;
        if (op != pkg.appOps_opValue) goto L13;
        return true;
    L23:
        return false;
    }

    private static ArrayList<ZtePermBase> pullParseSecurityPolicyXml(String policyXmlPath) {
        ArrayList<ZtePermBase> pkgLists = new ArrayList();
        File policyFile = new File(policyXmlPath);
        if (policyFile.exists() == true) goto L40;
        Slog.d(TAG, "policy xml not exsit: " + policyXmlPath);
        return null;
    L40:
        FileReader policyReader = new FileReader(policyFile);     // Catch: Exception -> L27
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L13
        parser.setInput(policyReader);     // Catch: Throwable -> L13
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L13
    L8:
        boolean r7 = true;
        if (parser.getEventType() == 1) goto L25;
        if ("policy".equals(parser.getName()) == false) goto L12;
        ZtePermBase pkg = new ZtePermBase();     // Catch: Throwable -> L13
        pkg.packageName = parser.getAttributeValue(null, "packageName");     // Catch: Throwable -> L13
        pkg.sig_SHA256 = parser.getAttributeValue(null, "sig_sha256");     // Catch: Throwable -> L13
        String opValue = parser.getAttributeValue(null, "appOps_opValue");     // Catch: Throwable -> L13
        if (opValue != null) goto L18;
        int r9 = -1;
    L19:
        pkg.appOps_opValue = r9;     // Catch: Throwable -> L13
        pkg.permName = parser.getAttributeValue(null, "permName");     // Catch: Throwable -> L13
        String pregrant = parser.getAttributeValue(null, "pregrant");     // Catch: Throwable -> L13
        if ("true".equals(pregrant) == true) goto L23;
        r7 = false;
    L23:
        pkg.pregrant = r7;     // Catch: Throwable -> L13
        pkgLists.add(pkg);     // Catch: Throwable -> L13
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L13
        goto L8
    L18:
        r9 = Integer.parseInt(opValue);     // Catch: Throwable -> L13
        goto L19
    L12:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L13
        goto L8
    L25:
        policyReader.close();     // Catch: Exception -> L27
    L35:
        return pkgLists;
    L13:
        th = move-exception;
        policyReader.close();     // Catch: Throwable -> L31
    L33:
        throw th;     // Catch: Exception -> L27
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L27
    L27:
        e = move-exception;
        Slog.e(TAG, "read security policy xml fail e :" + e.toString());
        e.printStackTrace();
        goto L35
    }

    private boolean checkPkgSig256Legal(String packageName, String pkgSHA) {
        if (packageName != null) goto L5;
        return false;
    L5:
        if (pkgSHA == null) goto L7;
        byte[] authorizedShaSumArray = hexStringToByteArray(pkgSHA);
        if (authorizedShaSumArray != null) goto L11;
        return false;
    L11:
        long token = Binder.clearCallingIdentity();
        PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(packageName, 64);     // Catch: Throwable -> L27 Exception -> L29
        if (packageInfo.signatures != null) goto L18;
        Binder.restoreCallingIdentity(token);
        return false;
    L18:
        if (packageInfo.signatures.length <= 1) goto L21;
        Binder.restoreCallingIdentity(token);
        return false;
    L21:
        MessageDigest md = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L27 Exception -> L29
        byte[] binaryCert = packageInfo.signatures[0].toByteArray();     // Catch: Throwable -> L27 Exception -> L29
        byte[] pkgShaSumArray = md.digest(binaryCert);     // Catch: Throwable -> L27 Exception -> L29
        if (MessageDigest.isEqual(pkgShaSumArray, authorizedShaSumArray) == false) goto L26;
        Binder.restoreCallingIdentity(token);
        return true;
    L26:
        Binder.restoreCallingIdentity(token);
        return false;
    L29:
        e = move-exception;
        Slog.e(TAG, "check signature fail, e= " + e);     // Catch: Throwable -> L27
        e.printStackTrace();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L7:
        return this.mPmInternal.isPlatformSigned(packageName);
    }

    private byte[] hexStringToByteArray(String str) {
        if (str != null) goto L4;
        return null;
    L4:
        if (str.isEmpty() == false) goto L6;
        return null;
    L6:
        if ((str.length() % 2) != 0) goto L18;
        byte[] result = new byte[str.length() / 2];
        int i = 0;
    L10:
        if (i >= str.length()) goto L13;
        int digit = Character.digit(str.charAt(i), 16);
        int digit2 = (digit << 4) + Character.digit(str.charAt(i + 1), 16);
        result[i / 2] = (byte) digit2;
        i = i + 2;
        goto L10
    L13:
        return result;
    L18:
        return null;
    }
}
