package com.android.server.pm;

import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.util.Slog;
import android.util.Xml;
import com.android.server.compat.PlatformCompat;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.SharedUserApi;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class SELinuxMMAC {
    private static final boolean DEBUG_POLICY = false;
    private static final boolean DEBUG_POLICY_INSTALL = false;
    private static final boolean DEBUG_POLICY_ORDER = false;
    private static final String DEFAULT_SEINFO = "default";
    private static final String PARTITION_STR = ":partition=";
    private static final String PRIVILEGED_APP_STR = ":privapp";
    static final long SELINUX_LATEST_CHANGES = 143539591;
    static final long SELINUX_R_CHANGES = 168782947;
    static final String TAG = "SELinuxMMAC";
    private static final String TARGETSDKVERSION_STR = ":targetSdkVersion=";
    private static final List<File> sMacPermissions = null;
    private static final List<Policy> sPolicies = null;
    private static boolean sPolicyRead;

    public SELinuxMMAC() {
    }

    static {
        sPolicies = new ArrayList();
        sMacPermissions = new ArrayList();
        sMacPermissions.add(new File(Environment.getRootDirectory(), "/etc/selinux/plat_mac_permissions.xml"));
        File systemExtMacPermission = new File(Environment.getSystemExtDirectory(), "/etc/selinux/system_ext_mac_permissions.xml");
        if (systemExtMacPermission.exists() == false) goto L5;
        sMacPermissions.add(systemExtMacPermission);
    L5:
        File productMacPermission = new File(Environment.getProductDirectory(), "/etc/selinux/product_mac_permissions.xml");
        if (productMacPermission.exists() == false) goto L8;
        sMacPermissions.add(productMacPermission);
    L8:
        File vendorMacPermission = new File(Environment.getVendorDirectory(), "/etc/selinux/vendor_mac_permissions.xml");
        if (vendorMacPermission.exists() == false) goto L11;
        sMacPermissions.add(vendorMacPermission);
    L11:
        File odmMacPermission = new File(Environment.getOdmDirectory(), "/etc/selinux/odm_mac_permissions.xml");
        if (odmMacPermission.exists() == false) goto L15;
        sMacPermissions.add(odmMacPermission);
        return;
    }

    public static boolean readInstallPolicy() {
        List<Policy> r0 = sPolicies;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sPolicyRead == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        List<Policy> policies = new ArrayList();
        XmlPullParser parser = Xml.newPullParser();
        int count = sMacPermissions.size();
        FileReader policyFile = null;
        int i = 0;
    L13:
        if (i >= count) goto L49;
        File macPermission = sMacPermissions.get(i);
        policyFile = new FileReader(macPermission);     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
        Slog.d(TAG, "Using policy file " + macPermission);     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
        parser.setInput(policyFile);     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
        parser.nextTag();     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
        parser.require(2, null, "policy");     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
    L17:
        if (parser.next() == 3) goto L38;
        if (parser.getEventType() != 2) goto L17;
        String r8 = parser.getName();     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
        switch(r8.hashCode()) {
            case -902467798: goto L25;
            default: goto L27;
        };     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
    L27:
        byte r9 = -1;
    L28:
        switch(r9) {
            case 0: goto L36;
            default: goto L29;
        };     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
    L36:
        policies.add(readSignerOrThrow(parser));     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
        goto L17
    L29:
        skip(parser);     // Catch: Throwable -> L30 IOException -> L32 Throwable -> L34
        goto L17
    L25:
        if (r8.equals("signer") == false) goto L27;
        r9 = 0;
        goto L28
    L38:
        IoUtils.closeQuietly(policyFile);
        i = i + 1;
    L30:
        th = move-exception;
        IoUtils.closeQuietly(policyFile);
        throw th;
    L32:
        ioe = move-exception;
        Slog.w(TAG, "Exception parsing " + macPermission, ioe);     // Catch: Throwable -> L30
        IoUtils.closeQuietly(policyFile);
        return false;
    L34:
        ex = move-exception;
        Slog.w(TAG, "Exception @" + parser.getPositionDescription() + " while parsing " + macPermission + ":" + ex);     // Catch: Throwable -> L30
        IoUtils.closeQuietly(policyFile);
        return false;
    L49:
        PolicyComparator policySort = new PolicyComparator();
        Collections.sort(policies, policySort);
        if (policySort.foundDuplicate() == false) goto L53;
        Slog.w(TAG, "ERROR! Duplicate entries found parsing mac_permissions.xml files");
        return false;
    L53:
        List<Policy> r6 = sPolicies;
        monitor-enter(r6);
        sPolicies.clear();     // Catch: Throwable -> L58
        sPolicies.addAll(policies);     // Catch: Throwable -> L58
        sPolicyRead = true;     // Catch: Throwable -> L58
        monitor-exit(r6);     // Catch: Throwable -> L58
        return true;
    L58:
        th = move-exception;
        throw th;
    }

    private static Policy readSignerOrThrow(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(2, null, "signer");
        Policy.PolicyBuilder pb = new Policy.PolicyBuilder();
        String cert = parser.getAttributeValue(null, "signature");
        if (cert == null) goto L6;
        pb.addSignature(cert);
    L6:
        if (parser.next() == 3) goto L22;
        if (parser.getEventType() != 2) goto L6;
        String tagName = parser.getName();
        if ("seinfo".equals(tagName) == true) goto L12;
        if (Settings.ATTR_PACKAGE.equals(tagName) == true) goto L15;
        if ("cert".equals(tagName) == true) goto L18;
        skip(parser);
        goto L6
    L18:
        String sig = parser.getAttributeValue(null, "signature");
        pb.addSignature(sig);
        readCert(parser);
        goto L6
    L15:
        readPackageOrThrow(parser, pb);
        goto L6
    L12:
        String seinfo = parser.getAttributeValue(null, "value");
        pb.setGlobalSeinfoOrThrow(seinfo);
        readSeinfo(parser);
        goto L6
    L22:
        return pb.build();
    }

    private static void readPackageOrThrow(XmlPullParser parser, Policy.PolicyBuilder pb) throws IOException, XmlPullParserException {
        parser.require(2, null, Settings.ATTR_PACKAGE);
        String pkgName = parser.getAttributeValue(null, "name");
    L4:
        if (parser.next() == 3) goto L13;
        if (parser.getEventType() != 2) goto L4;
        String tagName = parser.getName();
        if ("seinfo".equals(tagName) == true) goto L10;
        skip(parser);
        goto L4
    L10:
        String seinfo = parser.getAttributeValue(null, "value");
        pb.addInnerPackageMapOrThrow(pkgName, seinfo);
        readSeinfo(parser);
        goto L4
    }

    private static void readCert(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(2, null, "cert");
        parser.nextTag();
    }

    private static void readSeinfo(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(2, null, "seinfo");
        parser.nextTag();
    }

    private static void skip(XmlPullParser p) throws IOException, XmlPullParserException {
        if (p.getEventType() != 2) goto L14;
        int depth = 1;
    L5:
        if (depth == 0) goto L12;
        switch(p.next()) {
            case 2: goto L10;
            case 3: goto L9;
            default: goto L5;
        };
    L9:
        depth = depth - 1;
        goto L5
    L10:
        depth = depth + 1;
        goto L5
    L12:
        return;
    L14:
        throw new IllegalStateException();
    }

    private static int getTargetSdkVersionForSeInfo(AndroidPackage pkg, SharedUserApi sharedUser, PlatformCompat compatibility) {
        if (sharedUser != null) goto L4;
    L7:
        ApplicationInfo appInfo = AndroidPackageUtils.generateAppInfoWithoutState(pkg);
        if (compatibility.isChangeEnabledInternal(SELINUX_LATEST_CHANGES, appInfo) == false) goto L12;
        return Math.max(10000, pkg.getTargetSdkVersion());
    L12:
        if (compatibility.isChangeEnabledInternal(SELINUX_R_CHANGES, appInfo) == false) goto L16;
        return Math.max(30, pkg.getTargetSdkVersion());
    L16:
        return pkg.getTargetSdkVersion();
    L4:
        if (sharedUser.getPackages().size() == 0) goto L7;
        return sharedUser.getSeInfoTargetSdkVersion();
    }

    private static String getPartition(PackageState state) {
        if (state.isSystemExt() == false) goto L7;
        return "system_ext";
    L7:
        if (state.isProduct() == false) goto L11;
        return "product";
    L11:
        if (state.isVendor() == false) goto L15;
        return "vendor";
    L15:
        if (state.isOem() == false) goto L19;
        return "oem";
    L19:
        if (state.isOdm() == false) goto L23;
        return "odm";
    L23:
        if (state.isSystem() == false) goto L26;
        return "system";
    L26:
        return "";
    }

    public static String getSeInfo(PackageState packageState, AndroidPackage pkg, SharedUserApi sharedUser, PlatformCompat compatibility) {
        int targetSdkVersion = getTargetSdkVersionForSeInfo(pkg, sharedUser, compatibility);
        if (sharedUser == null) goto L5;
        boolean isPrivileged = sharedUser.isPrivileged() | packageState.isPrivileged();
    L7:
        return getSeInfo(packageState, pkg, isPrivileged, targetSdkVersion);
    L5:
        isPrivileged = packageState.isPrivileged();
        goto L7
    }

    public static String getSeInfo(PackageState packageState, AndroidPackage pkg, boolean isPrivileged, int targetSdkVersion) {
        String seInfo = null;
        List<Policy> r1 = sPolicies;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sPolicyRead == false) goto L16;
        Iterator<Policy> r2 = sPolicies.iterator();     // Catch: Throwable -> L14
    L9:
        if (r2.hasNext() == false) goto L16;
        Policy policy = r2.next();     // Catch: Throwable -> L14
        seInfo = policy.getMatchedSeInfo(pkg);     // Catch: Throwable -> L14
        if (seInfo == null) goto L9;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (seInfo != null) goto L19;
        seInfo = "default";
    L19:
        if (isPrivileged == false) goto L22;
        seInfo = seInfo + PRIVILEGED_APP_STR;
    L22:
        String seInfo2 = seInfo + TARGETSDKVERSION_STR + targetSdkVersion;
        String partition = getPartition(packageState);
        if (partition.isEmpty() == false) goto L25;
        return seInfo2;
    L25:
        return seInfo2 + PARTITION_STR + partition;
    }
}
