package com.android.server.policy.role;

import android.R;
import android.app.admin.DevicePolicyManagerInternal;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.CollectionUtils;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.role.RoleServicePlatformHelper;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import libcore.util.HexEncoding;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class RoleServicePlatformHelperImpl implements RoleServicePlatformHelper {
    private static final String ATTRIBUTE_NAME = "name";
    private static final String LOG_TAG = null;
    private static final String ROLES_FILE_NAME = "roles.xml";
    private static final String TAG_HOLDER = "holder";
    private static final String TAG_ROLE = "role";
    private static final String TAG_ROLES = "roles";
    private final Context mContext;

    private static class MessageDigestOutputStream extends OutputStream {
        private final MessageDigest mMessageDigest;

        MessageDigestOutputStream() {
            this.mMessageDigest = MessageDigest.getInstance("SHA256");     // Catch: NoSuchAlgorithmException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException("Failed to create MessageDigest", e);
        }

        String getDigestAsString() {
            return HexEncoding.encodeToString(this.mMessageDigest.digest(), true);
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            this.mMessageDigest.update((byte) b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b) throws IOException {
            this.mMessageDigest.update(b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) throws IOException {
            this.mMessageDigest.update(b, off, len);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$iHIoFGt-sugSqlklSHHOwdIQL9Y, reason: not valid java name */
    public static /* synthetic */ void m7307$r8$lambda$iHIoFGtsugSqlklSHHOwdIQL9Y(DataOutputStream r0, PackageManagerInternal r1, int r2, AndroidPackage r3) {
        lambda$computePackageStateHash$0(r0, r1, r2, r3);
    }

    static {
        LOG_TAG = RoleServicePlatformHelperImpl.class.getSimpleName();
    }

    public RoleServicePlatformHelperImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.android.server.role.RoleServicePlatformHelper
    public Map<String, Set<String>> getLegacyRoleState(int userId) {
        Map<String, Set<String>> roles = readFile(userId);
        if (roles == null) goto L5;
        return roles;
    L5:
        return readFromLegacySettings(userId);
    }

    private Map<String, Set<String>> readFile(int userId) {
        File file = getFile(userId);
        FileInputStream in = new AtomicFile(file).openRead();     // Catch: Throwable -> L8 FileNotFoundException -> L10
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L13
        parser.setInput(in, null);     // Catch: Throwable -> L13
        Map<String, Set<String>> roles = parseXml(parser);     // Catch: Throwable -> L13
        Slog.i(LOG_TAG, "Read legacy roles.xml successfully");     // Catch: Throwable -> L13
        if (in == null) goto L12;
        in.close();     // Catch: Throwable -> L8 Throwable -> L8 FileNotFoundException -> L10
    L12:
        return roles;
    L13:
        th = move-exception;
        if (in != null) goto L25;
    L20:
        throw th;     // Catch: Throwable -> L8 Throwable -> L8 FileNotFoundException -> L10
    L25:
        in.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8 Throwable -> L8 FileNotFoundException -> L10
    L8:
        e = move-exception;
        Slog.wtf(LOG_TAG, "Failed to parse legacy roles.xml: " + file, e);
        return null;
    L23:
        Slog.i(LOG_TAG, "Legacy roles.xml not found");
        return null;
    }

    private Map<String, Set<String>> parseXml(XmlPullParser parser) throws IOException, XmlPullParserException {
        int innerDepth = parser.getDepth() + 1;
    L3:
        int type = parser.next();
        if (type == 1) goto L19;
        int depth = parser.getDepth();
        if (depth < innerDepth) goto L8;
    L10:
        if (depth > innerDepth) goto L3;
        if (type != 2) goto L3;
        if (parser.getName().equals(TAG_ROLES) == false) goto L3;
        return parseRoles(parser);
    L8:
        if (type != 3) goto L10;
    L19:
        throw new IOException("Missing <roles> in roles.xml");
    }

    private Map<String, Set<String>> parseRoles(XmlPullParser parser) throws IOException, XmlPullParserException {
        Map<String, Set<String>> roles = new ArrayMap();
        int innerDepth = parser.getDepth() + 1;
    L3:
        int type = parser.next();
        if (type == 1) goto L17;
        int depth = parser.getDepth();
        if (depth < innerDepth) goto L8;
    L10:
        if (depth > innerDepth) goto L3;
        if (type != 2) goto L3;
        if (parser.getName().equals(TAG_ROLE) == false) goto L3;
        String roleName = parser.getAttributeValue(null, "name");
        Set<String> roleHolders = parseRoleHoldersLocked(parser);
        roles.put(roleName, roleHolders);
        goto L3
    L8:
        if (type != 3) goto L10;
    L17:
        return roles;
    }

    private Set<String> parseRoleHoldersLocked(XmlPullParser parser) throws IOException, XmlPullParserException {
        Set<String> roleHolders = new ArraySet();
        int innerDepth = parser.getDepth() + 1;
    L3:
        int type = parser.next();
        if (type == 1) goto L17;
        int depth = parser.getDepth();
        if (depth < innerDepth) goto L8;
    L10:
        if (depth > innerDepth) goto L3;
        if (type != 2) goto L3;
        if (parser.getName().equals(TAG_HOLDER) == false) goto L3;
        String roleHolder = parser.getAttributeValue(null, "name");
        roleHolders.add(roleHolder);
        goto L3
    L8:
        if (type != 3) goto L10;
    L17:
        return roleHolders;
    }

    private static File getFile(int userId) {
        return new File(Environment.getUserSystemDirectory(userId), ROLES_FILE_NAME);
    }

    private Map<String, Set<String>> readFromLegacySettings(int userId) {
        Map<String, Set<String>> roles = new ArrayMap();
        ContentResolver contentResolver = this.mContext.getContentResolver();
        String assistantSetting = Settings.Secure.getStringForUser(contentResolver, "assistant", userId);
        PackageManager packageManager = this.mContext.getPackageManager();
        String homePackageName = null;
        if (assistantSetting == null) goto L13;
        if (assistantSetting.isEmpty() == true) goto L11;
        ComponentName componentName = ComponentName.unflattenFromString(assistantSetting);
        if (componentName == null) goto L9;
        String assistantPackageName = componentName.getPackageName();
    L20:
        if (assistantPackageName == null) goto L22;
        roles.put("android.app.role.ASSISTANT", Collections.singleton(assistantPackageName));
    L22:
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        String browserPackageName = packageManagerInternal.removeLegacyDefaultBrowserPackageName(userId);
        if (browserPackageName == null) goto L25;
        roles.put("android.app.role.BROWSER", Collections.singleton(browserPackageName));
    L25:
        String dialerSetting = Settings.Secure.getStringForUser(contentResolver, "dialer_default_application", userId);
        if (TextUtils.isEmpty(dialerSetting) == true) goto L29;
        String dialerPackageName = dialerSetting;
    L32:
        if (dialerPackageName == null) goto L34;
        roles.put("android.app.role.DIALER", Collections.singleton(dialerPackageName));
    L34:
        String smsSetting = Settings.Secure.getStringForUser(contentResolver, "sms_default_application", userId);
        if (TextUtils.isEmpty(smsSetting) == true) goto L38;
        String smsPackageName = smsSetting;
    L41:
        if (smsPackageName == null) goto L44;
        roles.put("android.app.role.SMS", Collections.singleton(smsPackageName));
    L44:
        if (packageManager.isDeviceUpgrading() == false) goto L57;
        ResolveInfo resolveInfo = packageManager.resolveActivityAsUser(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME"), 851968, userId);
        if (resolveInfo != null) goto L48;
    L52:
        if (homePackageName != null) goto L54;
    L58:
        if (homePackageName == null) goto L60;
        roles.put("android.app.role.HOME", Collections.singleton(homePackageName));
    L60:
        String emergencyPackageName = Settings.Secure.getStringForUser(contentResolver, "emergency_assistance_application", userId);
        if (emergencyPackageName == null) goto L63;
        roles.put("android.app.role.EMERGENCY", Collections.singleton(emergencyPackageName));
    L63:
        return roles;
    L54:
        if (isSettingsApplication(homePackageName, userId) == false) goto L58;
        homePackageName = null;
        goto L58
    L48:
        if (resolveInfo.activityInfo == null) goto L52;
        homePackageName = resolveInfo.activityInfo.packageName;
        goto L52
    L57:
        homePackageName = null;
        goto L58
    L38:
        if (this.mContext.getPackageManager().isDeviceUpgrading() == false) goto L40;
        smsPackageName = this.mContext.getString(R.string.config_defaultSms);
        goto L41
    L40:
        smsPackageName = null;
        goto L41
    L29:
        if (packageManager.isDeviceUpgrading() == false) goto L31;
        dialerPackageName = this.mContext.getString(R.string.config_defaultDialer);
        goto L32
    L31:
        dialerPackageName = null;
        goto L32
    L9:
        assistantPackageName = null;
        goto L20
    L11:
        assistantPackageName = null;
        goto L20
    L13:
        if (packageManager.isDeviceUpgrading() == false) goto L19;
        String defaultAssistant = this.mContext.getString(R.string.config_defaultAssistant);
        if (TextUtils.isEmpty(defaultAssistant) == true) goto L17;
        assistantPackageName = defaultAssistant;
        goto L20
    L17:
        assistantPackageName = null;
        goto L20
    L19:
        assistantPackageName = null;
        goto L20
    }

    private boolean isSettingsApplication(String packageName, int userId) {
        PackageManager packageManager = this.mContext.getPackageManager();
        ResolveInfo resolveInfo = packageManager.resolveActivityAsUser(new Intent("android.settings.SETTINGS"), 851968, userId);
        if (resolveInfo != null) goto L5;
        return false;
    L5:
        if (resolveInfo.activityInfo != null) goto L8;
        return false;
    L8:
        return Objects.equals(packageName, resolveInfo.activityInfo.packageName);
    }

    @Override // com.android.server.role.RoleServicePlatformHelper
    public String computePackageStateHash(final int userId) {
        final PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        DevicePolicyManagerInternal devicePolicyManagerInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        MessageDigestOutputStream mdos = new MessageDigestOutputStream();
        final DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(mdos));
        packageManagerInternal.forEachInstalledPackage(new RoleServicePlatformHelperImpl$$ExternalSyntheticLambda0(dataOutputStream, packageManagerInternal, userId), userId);
        String profileOwner = "";
        String deviceOwner = "";
        if (devicePolicyManagerInternal != null) goto L21;
    L11:
        dataOutputStream.writeUTF(deviceOwner);     // Catch: IOException -> L9
        if (devicePolicyManagerInternal == null) goto L16;
        ComponentName profileOwnerComponent = devicePolicyManagerInternal.getProfileOwnerAsUser(userId);     // Catch: IOException -> L9
        if (profileOwnerComponent == null) goto L16;
        profileOwner = profileOwnerComponent.getPackageName();     // Catch: IOException -> L9
    L16:
        dataOutputStream.writeUTF(profileOwner);     // Catch: IOException -> L9
        dataOutputStream.writeInt(Settings.Global.getInt(this.mContext.getContentResolver(), "device_demo_mode", 0));     // Catch: IOException -> L9
        dataOutputStream.writeBoolean(true);     // Catch: IOException -> L9
        dataOutputStream.flush();     // Catch: IOException -> L9
        return mdos.getDigestAsString();
    L9:
        e = move-exception;
        throw new AssertionError(e);
    L21:
        if (devicePolicyManagerInternal.getDeviceOwnerUserId() != userId) goto L11;
        ComponentName deviceOwnerComponent = devicePolicyManagerInternal.getDeviceOwnerComponent(false);     // Catch: IOException -> L9
        if (deviceOwnerComponent == null) goto L11;
        deviceOwner = deviceOwnerComponent.getPackageName();     // Catch: IOException -> L9
        goto L11
    }

    private static /* synthetic */ void lambda$computePackageStateHash$0(DataOutputStream dataOutputStream, PackageManagerInternal packageManagerInternal, int userId, AndroidPackage pkg) {
        dataOutputStream.writeUTF(pkg.getPath());     // Catch: IOException -> L5
        dataOutputStream.writeInt(packageManagerInternal.getApplicationEnabledState(pkg.getPackageName(), userId));     // Catch: IOException -> L5
        ArraySet<String> enabledComponents = packageManagerInternal.getEnabledComponents(pkg.getPackageName(), userId);     // Catch: IOException -> L5
        int enabledComponentsSize = CollectionUtils.size(enabledComponents);     // Catch: IOException -> L5
        dataOutputStream.writeInt(enabledComponentsSize);     // Catch: IOException -> L5
        int i = 0;
    L3:
        if (i >= enabledComponentsSize) goto L7;
        dataOutputStream.writeUTF(enabledComponents.valueAt(i));     // Catch: IOException -> L5
        i = i + 1;     // Catch: IOException -> L5
        goto L3
    L7:
        ArraySet<String> disabledComponents = packageManagerInternal.getDisabledComponents(pkg.getPackageName(), userId);     // Catch: IOException -> L5
        int disabledComponentsSize = CollectionUtils.size(disabledComponents);     // Catch: IOException -> L5
        int i2 = 0;
    L8:
        if (i2 >= disabledComponentsSize) goto L12;
        dataOutputStream.writeUTF(disabledComponents.valueAt(i2));     // Catch: IOException -> L5
        i2 = i2 + 1;
        goto L8
    L12:
        return;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }
}
