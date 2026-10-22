package com.android.server.pm.verify.domain;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Patterns;
import com.android.internal.util.CollectionUtils;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.compat.PlatformCompat;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.Set;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes2.dex */
public final class DomainVerificationUtils {
    public static final int MAX_DOMAIN_LABEL_LENGTH = 63;
    public static final int MAX_DOMAIN_LENGTH = 254;
    private static final ThreadLocal<Matcher> sCachedMatcher = null;

    public static /* synthetic */ Matcher $r8$lambda$INVzaUi9srP2OAr1xKQiXsvKY3Y() {
        return lambda$static$0();
    }

    public DomainVerificationUtils() {
    }

    static {
        sCachedMatcher = ThreadLocal.withInitial(new DomainVerificationUtils$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ Matcher lambda$static$0() {
        return Patterns.DOMAIN_NAME.matcher("");
    }

    static PackageManager.NameNotFoundException throwPackageUnavailable(String packageName) throws PackageManager.NameNotFoundException {
        throw new PackageManager.NameNotFoundException("Package " + packageName + " unavailable");
    }

    public static boolean isDomainVerificationIntent(Intent intent, long resolveInfoFlags) {
        boolean matchDefaultByFlags = false;
        if (intent.isWebIntent() == true) goto L5;
        return false;
    L5:
        String host = intent.getData().getHost();
        if (TextUtils.isEmpty(host) == false) goto L9;
        return false;
    L9:
        if (sCachedMatcher.get().reset(host).matches() == true) goto L11;
        return false;
    L11:
        Set<String> categories = intent.getCategories();
        int categoriesSize = CollectionUtils.size(categories);
        if (categoriesSize <= 2) goto L15;
        return false;
    L15:
        if (categoriesSize != 2) goto L24;
        if (intent.hasCategory("android.intent.category.DEFAULT") == true) goto L19;
        return false;
    L19:
        if (intent.hasCategory("android.intent.category.BROWSABLE") == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        if ((65536 & resolveInfoFlags) == 0) goto L26;
        matchDefaultByFlags = true;
    L26:
        if (categoriesSize != 0) goto L29;
        return matchDefaultByFlags;
    L29:
        if (intent.hasCategory("android.intent.category.BROWSABLE") == false) goto L32;
        return matchDefaultByFlags;
    L32:
        return intent.hasCategory("android.intent.category.DEFAULT");
    }

    static boolean isChangeEnabled(PlatformCompat platformCompat, AndroidPackage pkg, long changeId) {
        return platformCompat.isChangeEnabledInternalNoLogging(changeId, buildMockAppInfo(pkg));
    }

    private static ApplicationInfo buildMockAppInfo(AndroidPackage pkg) {
        ApplicationInfo appInfo = new ApplicationInfo();
        appInfo.packageName = pkg.getPackageName();
        appInfo.targetSdkVersion = pkg.getTargetSdkVersion();
        return appInfo;
    }

    static boolean isValidDomain(String domain) {
        if (domain.length() <= 254) goto L5;
    L37:
        return false;
    L5:
        if (domain.equals(SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER) == true) goto L37;
        if (domain.charAt(0) == '*') goto L10;
    L13:
        int labels = 1;
        int labelStart = -1;
        int i = 0;
    L15:
        if (i >= domain.length()) goto L29;
        char c = domain.charAt(i);
        if (c != '.') goto L26;
        int labelLength = (i - labelStart) - 1;
        if (labelLength == 0) goto L24;
        if (labelLength > 63) goto L24;
        labelStart = i;
        labels = labels + 1;
    L28:
        i = i + 1;
    L24:
        return false;
    L26:
        if (isValidDomainChar(c) == true) goto L28;
        return false;
    L29:
        int lastLabelLength = (domain.length() - labelStart) - 1;
        if (lastLabelLength == 0) goto L36;
        if (lastLabelLength > 63) goto L36;
        if (labels > 1) goto L35;
        return false;
    L35:
        return true;
    L36:
        return false;
    L10:
        if (domain.charAt(1) == '.') goto L12;
        return false;
    L12:
        domain = domain.substring(2);
        goto L13
    }

    private static boolean isValidDomainChar(char c) {
        if (c < 'a') goto L7;
        if (c > 'z') goto L7;
    L16:
        return true;
    L7:
        if (c < 'A') goto L11;
        if (c <= 'Z') goto L16;
    L11:
        if (c < '0') goto L15;
        if (c <= '9') goto L16;
    L15:
        if (c == '-') goto L16;
        return false;
    }
}
