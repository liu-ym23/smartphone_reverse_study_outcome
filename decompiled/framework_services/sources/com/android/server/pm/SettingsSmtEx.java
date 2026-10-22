package com.android.server.pm;

import android.content.ComponentName;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.CustomizedStatusBarUtil;
import com.android.internal.util.XmlUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsSmtEx {
    private static final String ATTR_BYTEDANCE_NAME = "name";
    private static final String ATTR_CODE = "code";
    private static final String ATTR_CUSTOMIZED_STATUS_BAR = "customized-sb";
    private static final String ATTR_NOTCH_STATE = "notch-state";
    static final String ATTR_NOT_ACTIVE = "na";
    static final String ATTR_USER_ORIENTATION = "user-orientation";
    static final String ATTR_USER_ORIENTATION_ACTIVITY = "user-orientation-activity";
    private static final boolean DEBUG_LOCK_ALL = false;
    protected static final String TAG = "SettingsSmtEx";
    private static final String TAG_BYTEDANCE_INTERNAL_PACKAGE_RESTRICTIONS = "bytedance-internal-package-restrictions";
    private static final String TAG_BYTEDANCE_PACKAGE = "pkg";
    private HashSet<String> mActiveMonitorPackages;
    final SparseArray<HashSet<String>> mAllLockedPackages;
    final SparseArray<HashMap<String, Integer>> mChosenActivities;
    final ArrayMap<String, String> mRemovedSystemPackages;
    final SparseArray<HashSet<String>> mSessionUnlockedPackages;
    private final Settings mSettings;

    public SettingsSmtEx(Settings settings) {
        this.mRemovedSystemPackages = new ArrayMap();
        this.mChosenActivities = new SparseArray();
        this.mActiveMonitorPackages = new HashSet();
        this.mAllLockedPackages = new SparseArray();
        this.mSessionUnlockedPackages = new SparseArray();
        this.mSettings = settings;
    }

    boolean setPackageActiveStateLPw(PackageManagerService service, String packageName, boolean active, boolean allowedByPermission, int uid, int userId) {
        int appId = UserHandle.getAppId(uid);
        boolean notActive = !active;
        PackageSetting pkgSetting = this.mSettings.mPackages.get(packageName);
        if (pkgSetting == null) goto L26;
        if (allowedByPermission == true) goto L12;
        if (appId == pkgSetting.getAppId()) goto L12;
        throw new SecurityException("Permission Denial: attempt to change stopped state from pid=" + Binder.getCallingPid() + ", uid=" + uid + ", package uid=" + pkgSetting.getAppId());
    L12:
        if (pkgSetting.getSmtEx().getNotActive(userId) == notActive) goto L24;
        if (notActive == true) goto L21;
        if (pkgSetting.isSystem() == false) goto L21;
        if (this.mActiveMonitorPackages.contains(pkgSetting.getName()) == false) goto L21;
        Bundle extras = new Bundle();
        extras.putString("com.bytedanceos.intent.extra.PACKAGE_ACTIVE", pkgSetting.getPkg().getPath());
        service.mBroadcastHelper.sendPackageBroadcast("com.bytedanceos.intent.extra.PACKAGE_ACTIVE", pkgSetting.getName(), extras, 0, null, null, new int[]{userId}, null, null, null, null, null);
    L21:
        pkgSetting.getSmtEx().setNotActive(notActive, userId);
        return true;
    L24:
        return false;
    L26:
        throw new IllegalArgumentException("Unknown package: " + packageName);
    }

    int getPackageActiveStateLPw(String packageName, int userId) {
        PackageSetting pkgSetting = this.mSettings.mPackages.get(packageName);
        if (pkgSetting != null) goto L7;
        return 0;
    L7:
        if (pkgSetting.getSmtEx().getNotActive(userId) == false) goto L9;
        return 1;
    L9:
        return 2;
    }

    void readActiveMonitorList() {
        File file = new File(Environment.getRootDirectory(), "etc/active_monitor.xml");
        if (file.exists() == true) goto L5;
    L6:
        Slog.w(TAG, "packages can't be read");
    L7:
        FileInputStream fis = null;
        fis = new FileInputStream(file);     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        parser.setInput(fis, null);     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        XmlUtils.beginDocument(parser, "packages");     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
    L9:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        goto L60
    L11:
        if (parser.getEventType() == 1) goto L12;
        String name = parser.getName();     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        if ("pkg".equals(name) == true) goto L18;
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        goto L9
    L18:
        String pkg = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        if (pkg != null) goto L27;
        Slog.w(TAG, "<pkg> without name at " + parser.getPositionDescription());     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
    L28:
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        goto L9
    L27:
        this.mActiveMonitorPackages.add(pkg);     // Catch: Throwable -> L21 IOException -> L23 XmlPullParserException -> L25
        goto L28
    L12:
        fis.close();     // Catch: IOException -> L14
        return;
    L23:
        e = move-exception;
        Slog.w(TAG, "Got execption parsing active monitor.", e);     // Catch: Throwable -> L21
        if (fis == null) goto L41;
        fis.close();     // Catch: IOException -> L14
        return;
    L41:
        return;
    L25:
        e = move-exception;
        Slog.w(TAG, "Got execption parsing active monitor.", e);     // Catch: Throwable -> L21
        if (fis == null) goto L58;
        fis.close();     // Catch: IOException -> L14
        return;
    L58:
        return;
    L60:
        return;
    L21:
        th = move-exception;
        if (0 != 0) goto L47;
    L46:
        throw th;
    L47:
        fis.close();     // Catch: IOException -> L45
        goto L46
    L5:
        if (file.canRead() == true) goto L7;
        goto L6
    }

    void lockPackageLPw(String packageName, int userId) {
        if (TextUtils.isEmpty(packageName) == false) goto L5;
        return;
    L5:
        HashSet<String> lockedPackages = this.mAllLockedPackages.get(userId);
        if (lockedPackages != null) goto L8;
        lockedPackages = new HashSet();
        this.mAllLockedPackages.put(userId, lockedPackages);
    L8:
        lockedPackages.add(packageName);
    }

    void unlockPackageLPw(String packageName, int userId) {
        HashSet<String> lockedPackages = this.mAllLockedPackages.get(userId);
        if (lockedPackages == null) goto L6;
        lockedPackages.remove(packageName);
        return;
    }

    void unlockAllPackagesLPw(int userId) {
        HashSet<String> lockedPackages = this.mAllLockedPackages.get(userId);
        if (lockedPackages == null) goto L6;
        lockedPackages.clear();
        return;
    }

    void sessionUnlockPackageLPw(String packageName, int userId) {
        HashSet<String> unlockedPackages = this.mSessionUnlockedPackages.get(userId);
        if (unlockedPackages != null) goto L5;
        unlockedPackages = new HashSet();
        this.mSessionUnlockedPackages.put(userId, unlockedPackages);
    L5:
        unlockedPackages.add(packageName);
    }

    void sessionUnlockAllPackagesLPw(int userId) {
        HashSet<String> lockedPackages = this.mAllLockedPackages.get(userId);
        HashSet<String> r1 = this.mSessionUnlockedPackages.get(userId);
        if (lockedPackages != null) goto L5;
        return;
    L5:
        if (lockedPackages.isEmpty() == true) goto L10;
        HashSet<String> unlockedPackages = new HashSet(lockedPackages);
        this.mSessionUnlockedPackages.put(userId, unlockedPackages);
        return;
    }

    void clearSessionUnlockPackageLPw() {
        int i = 0;
    L4:
        if (i >= this.mSessionUnlockedPackages.size()) goto L7;
        int key = this.mSessionUnlockedPackages.keyAt(i);
        HashSet<String> packages = this.mSessionUnlockedPackages.get(key);
        packages.clear();
        i = i + 1;
        goto L4
    }

    boolean isPackageLockedLPw(String packageName, int userId) {
        HashSet<String> lockedPackages = this.mAllLockedPackages.get(userId);
        HashSet<String> unlockedPackages = this.mSessionUnlockedPackages.get(userId);
        if (lockedPackages != null) goto L5;
        return false;
    L5:
        if (lockedPackages.contains(packageName) == false) goto L14;
        if (unlockedPackages != null) goto L8;
        return true;
    L8:
        if (unlockedPackages.contains(packageName) == true) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    boolean isPackageAlreadyLockedLPw(String packageName, int userId) {
        HashSet<String> lockedPackages = this.mAllLockedPackages.get(userId);
        if (lockedPackages != null) goto L5;
        return false;
    L5:
        if (lockedPackages.contains(packageName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    void wirteLockPackageLPr(XmlSerializer serializer, int userId) throws IllegalArgumentException, IllegalStateException, IOException {
        serializer.startTag(null, "locked-packages");
        HashSet<String> lps = this.mAllLockedPackages.get(userId);
        if (lps == null) goto L8;
        Iterator<String> r3 = lps.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        String lp = r3.next();
        serializer.startTag(null, "pkg");
        serializer.attribute(null, "name", lp);
        serializer.endTag(null, "pkg");
    L8:
        serializer.endTag(null, "locked-packages");
    }

    void readLockPackageLPr(XmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("pkg") == true) goto L16;
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <preferred-activities>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        String packageName = parser.getAttributeValue(null, "name");
        lockPackageLPw(packageName, userId);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    boolean hasLockedPackages(int userId) {
        HashSet<String> lockedPackages = this.mAllLockedPackages.get(userId);
        HashSet<String> unlockedPackages = this.mSessionUnlockedPackages.get(userId);
        if (lockedPackages != null) goto L5;
        return false;
    L5:
        if (unlockedPackages == null) goto L17;
        if (unlockedPackages.isEmpty() == true) goto L17;
        Iterator<String> it = lockedPackages.iterator();
    L10:
        if (it.hasNext() == false) goto L15;
        String packageName = it.next();
        if (unlockedPackages.contains(packageName) == true) goto L10;
        return true;
    L15:
        return false;
    L17:
        return !lockedPackages.isEmpty();
    }

    HashSet<String> getSessionUnlockedPackagesLPw() {
        HashSet<String> sessionUnlockedPackages = new HashSet();
        int i = 0;
    L4:
        if (i >= this.mSessionUnlockedPackages.size()) goto L10;
        int key = this.mSessionUnlockedPackages.keyAt(i);
        HashSet<String> packages = this.mSessionUnlockedPackages.get(key);
        if (packages.isEmpty() == true) goto L8;
        sessionUnlockedPackages.addAll(packages);
        packages.clear();
    L8:
        i = i + 1;
        goto L4
    L10:
        if (sessionUnlockedPackages.isEmpty() == false) goto L13;
        return null;
    L13:
        return sessionUnlockedPackages;
    }

    void writeAllUsersBytedanceInternalPackageRestrictionsLPr() {
        List<UserInfo> users = Settings.getAllUsers(UserManagerService.getInstance());
        if (users != null) goto L5;
        return;
    }

    public boolean isExcludedCustomizedApp(PackageSetting pkg) {
        if (pkg != null) goto L6;
        return true;
    L6:
        if (CustomizedStatusBarUtil.DEFAULT_DISABLED_LIST.contains(pkg.getName()) == false) goto L8;
    L10:
        return false;
    L8:
        if (pkg.isSystem() == false) goto L10;
        return true;
    }

    String addSystemPackageBackLPw(String name) {
        return this.mRemovedSystemPackages.remove(name);
    }

    String getRemovedSystemPackagePath(String name) {
        return this.mRemovedSystemPackages.get(name);
    }

    void removeSystemPackageLPw(String name, String path) {
        if (path != null) goto L4;
        return;
    L4:
        if (path.startsWith("/data/") == true) goto L8;
        this.mRemovedSystemPackages.put(name, path);
        return;
    }

    boolean isRemovedSystemPackage(String name) {
        return this.mRemovedSystemPackages.containsKey(name);
    }

    void deleteSettingsFile() {
    }

    void writeRemovedSystemPackageLPr(XmlSerializer serializer, Map.Entry<String, String> entry) throws IOException {
        serializer.startTag(null, "removed-package");
        serializer.attribute(null, "name", entry.getKey());
        serializer.attribute(null, "path", entry.getValue());
        serializer.endTag(null, "removed-package");
    }

    void readRemovedSystemPackage(XmlPullParser parser) throws XmlPullParserException, IOException {
        String name = parser.getAttributeValue(null, "name");
        String path = parser.getAttributeValue(null, "path");
        if (path != null) goto L5;
        return;
    L5:
        if (path.startsWith("/data/") == true) goto L9;
        this.mRemovedSystemPackages.put(name, path);
        return;
    }

    void writeChosenActivitiesLPr(XmlSerializer serializer, int userId) throws IllegalArgumentException, IllegalStateException, IOException {
        serializer.startTag(null, "chosen-activities");
        HashMap<String, Integer> hsi = null;
        SparseArray<HashMap<String, Integer>> r2 = this.mChosenActivities;
        monitor-enter(r2);
        HashMap<String, Integer> tmp = this.mChosenActivities.get(userId);     // Catch: Throwable -> L9
        if (tmp != null) goto L7;
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        if (hsi == null) goto L17;
        Iterator<Map.Entry<String, Integer>> r3 = hsi.entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L17;
        Map.Entry<String, Integer> entry = r3.next();
        serializer.startTag(null, Settings.TAG_ITEM);
        serializer.attribute(null, "name", entry.getKey());
        serializer.attribute(null, ATTR_CODE, entry.getValue().toString());
        serializer.endTag(null, Settings.TAG_ITEM);
    L17:
        serializer.endTag(null, "chosen-activities");
        return;
    L7:
        if (tmp.isEmpty() == true) goto L11;
        hsi = new HashMap(tmp);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    void readChosenActivitiesLPw(XmlPullParser parser, int userId) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L23;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals(Settings.TAG_ITEM) == true) goto L16;
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <chosen-activities>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        String name = parser.getAttributeValue(null, "name");
        if (ComponentName.unflattenFromString(name) != null) goto L18;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <chosen-activity> Bad activity name " + name + " at " + parser.getPositionDescription());
        goto L3
    L18:
        Integer code = new Integer(parser.getAttributeValue(null, ATTR_CODE));
        updateChosenActivities(name, code.intValue(), userId);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    HashMap<String, Integer> editChosenActivitiesLPw(int userId) {
        SparseArray<HashMap<String, Integer>> r0 = this.mChosenActivities;
        monitor-enter(r0);
        HashMap<String, Integer> hsi = this.mChosenActivities.get(userId);     // Catch: Throwable -> L7
        if (hsi != null) goto L9;
        hsi = new HashMap();     // Catch: Throwable -> L7
        this.mChosenActivities.put(userId, hsi);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return hsi;
    L7:
        th = move-exception;
        throw th;
    }

    public SparseArray<HashMap<String, Integer>> getChosenActivities() {
        SparseArray<HashMap<String, Integer>> r0 = this.mChosenActivities;
        monitor-enter(r0);
        SparseArray<HashMap<String, Integer>> r1 = this.mChosenActivities;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void updateChosenActivities(String componentName, int code, int userId) {
        SparseArray<HashMap<String, Integer>> r0 = this.mChosenActivities;
        monitor-enter(r0);
        editChosenActivitiesLPw(userId).put(componentName, Integer.valueOf(code));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getChosenPriority(String componentName, int userId) {
        SparseArray<HashMap<String, Integer>> r0 = this.mChosenActivities;
        monitor-enter(r0);
        HashMap<String, Integer> hsi = this.mChosenActivities.get(userId);     // Catch: Throwable -> L11
        if (hsi == null) goto L13;
        Integer code = hsi.get(componentName);     // Catch: Throwable -> L11
        if (code == null) goto L13;
        int r3 = code.intValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return 0;
    L11:
        th = move-exception;
        throw th;
    }

    void removePkgFromSharedUser(PackageSetting p, SharedUserSetting sharedUser) {
    }
}
