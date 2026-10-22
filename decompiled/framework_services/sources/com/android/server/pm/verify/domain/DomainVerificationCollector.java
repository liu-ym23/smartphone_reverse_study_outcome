package com.android.server.pm.verify.domain;

import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Patterns;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.server.SystemConfig;
import com.android.server.compat.PlatformCompat;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationCollector {
    private static final BiFunction<ArraySet<String>, String, Boolean> ARRAY_SET_COLLECTOR = null;
    private static final Pattern DOMAIN_NAME_WITH_WILDCARD = null;
    private static final int MAX_DOMAINS_BYTE_SIZE = 1048576;
    public static final long RESTRICT_DOMAINS = 175408749;
    private final Matcher mDomainMatcher;
    private final PlatformCompat mPlatformCompat;
    private final SystemConfig mSystemConfig;

    public static /* synthetic */ Boolean $r8$lambda$batCCh6Ga6j4xiWi4NlYNy9upmc(ArraySet r0, String r1) {
        return lambda$static$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$d-9e3d0EUMBHIP8n7OmBcLw9esQ, reason: not valid java name */
    public static /* synthetic */ Boolean m7118$r8$lambda$d9e3d0EUMBHIP8n7OmBcLw9esQ(String r0, Void r1, String r2) {
        return lambda$containsWebDomain$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$l_-JJzVBim96J2VNXwL1vO01Oog, reason: not valid java name */
    public static /* synthetic */ Boolean m7119$r8$lambda$l_JJzVBim96J2VNXwL1vO01Oog(String r0, Void r1, String r2) {
        return lambda$containsAutoVerifyDomain$2(r0, r1, r2);
    }

    static {
        DOMAIN_NAME_WITH_WILDCARD = Pattern.compile("(\\*\\.)?" + Patterns.DOMAIN_NAME.pattern());
        ARRAY_SET_COLLECTOR = new DomainVerificationCollector$$ExternalSyntheticLambda0();
    }

    private static /* synthetic */ Boolean lambda$static$0(ArraySet set, String domain) {
        set.add(domain);
        return null;
    }

    public DomainVerificationCollector(PlatformCompat platformCompat, SystemConfig systemConfig) {
        this.mPlatformCompat = platformCompat;
        this.mSystemConfig = systemConfig;
        this.mDomainMatcher = DOMAIN_NAME_WITH_WILDCARD.matcher("");
    }

    public ArraySet<String> collectAllWebDomains(AndroidPackage pkg) {
        return collectDomains(pkg, false, true);
    }

    public ArraySet<String> collectValidAutoVerifyDomains(AndroidPackage pkg) {
        return collectDomains(pkg, true, true);
    }

    public ArraySet<String> collectInvalidAutoVerifyDomains(AndroidPackage pkg) {
        return collectDomains(pkg, true, false);
    }

    public boolean containsWebDomain(AndroidPackage pkg, final String targetDomain) {
        if (collectDomains(pkg, false, true, null, new DomainVerificationCollector$$ExternalSyntheticLambda1(targetDomain)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ Boolean lambda$containsWebDomain$1(String targetDomain, Void unused, String domain) {
        if (Objects.equals(targetDomain, domain) == true) goto L5;
        return null;
    L5:
        return true;
    }

    public boolean containsAutoVerifyDomain(AndroidPackage pkg, final String targetDomain) {
        if (collectDomains(pkg, true, true, null, new DomainVerificationCollector$$ExternalSyntheticLambda2(targetDomain)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ Boolean lambda$containsAutoVerifyDomain$2(String targetDomain, Void unused, String domain) {
        if (Objects.equals(targetDomain, domain) == true) goto L5;
        return null;
    L5:
        return true;
    }

    private ArraySet<String> collectDomains(AndroidPackage pkg, boolean checkAutoVerify, boolean valid) {
        ArraySet<String> domains = new ArraySet();
        collectDomains(pkg, checkAutoVerify, valid, domains, ARRAY_SET_COLLECTOR);
        return domains;
    }

    private <InitialValue, ReturnValue> ReturnValue collectDomains(AndroidPackage r4, boolean r5, boolean r6, InitialValue r7, BiFunction<InitialValue, String, ReturnValue> r8) {
        if (DomainVerificationUtils.isChangeEnabled(this.mPlatformCompat, r4, RESTRICT_DOMAINS) == false) goto L7;
        return (ReturnValue) collectDomainsInternal(r4, r5, r6, r7, r8);
    L7:
        return (ReturnValue) collectDomainsLegacy(r4, r5, r6, r7, r8);
    }

    private <InitialValue, ReturnValue> ReturnValue collectDomainsLegacy(AndroidPackage r22, boolean r23, boolean r24, InitialValue r25, BiFunction<InitialValue, String, ReturnValue> r26) {
        if (r23 == false) goto L4;
        DomainVerificationCollector r0 = this;
        List r1 = r22.getActivities();
        int r2 = r1.size();
        boolean r3 = r0.mSystemConfig.getLinkedApps().contains(r22.getPackageName());
        ReturnValue r4 = null;
        if (r3 == true) goto L17;
        int r5 = 0;
    L8:
        if (r5 >= r2) goto L15;
        if (r3 == true) goto L15;
        List r7 = ((ParsedActivity) r1.get(r5)).getIntents();
        int r8 = r7.size();
        int r9 = 0;
    L11:
        if (r9 >= r8) goto L14;
        if (r3 == true) goto L14;
        r3 = ((ParsedIntentInfo) r7.get(r9)).getIntentFilter().needsVerification();
        r9 = r9 + 1;
    L14:
        r5 = r5 + 1;
    L15:
        if (r3 == true) goto L17;
        return null;
    L17:
        int r6 = 0;
        boolean r10 = true;
        int r11 = 0;
    L18:
        if (r11 >= r2) goto L44;
        if (r10 == false) goto L44;
        List r12 = ((ParsedActivity) r1.get(r11)).getIntents();
        int r13 = r12.size();
        int r14 = 0;
    L21:
        if (r14 >= r13) goto L42;
        if (r10 == false) goto L42;
        IntentFilter r15 = ((ParsedIntentInfo) r12.get(r14)).getIntentFilter();
        if (r15.handlesWebUris(false) == false) goto L40;
        int r16 = r15.countDataAuthorities();
        int r17 = 0;
    L26:
        if (r17 >= r16) goto L39;
        String r18 = r15.getDataAuthority(r17).getHost();
        List r19 = r1;
        int r110 = r2;
        if (r0.isValidHost(r18) != r24) goto L38;
        r6 = r6 + r0.byteSizeOf(r18);
        if (r6 >= 1048576) goto L32;
        boolean r20 = true;
    L33:
        ReturnValue r111 = r26.apply(r25, r18);
        if (r111 != null) goto L35;
        r10 = r20;
        goto L38
    L35:
        return r111;
    L32:
        r20 = false;
    L38:
        r17 = r17 + 1;
        r0 = this;
        r1 = r19;
        r2 = r110;
        goto L26
    L39:
        List r112 = r1;
        int r113 = r2;
    L41:
        r14 = r14 + 1;
        r0 = this;
        r4 = r4;
        r1 = r112;
        r2 = r113;
        goto L21
    L40:
        r112 = r1;
        r113 = r2;
    L42:
        r11 = r11 + 1;
        r0 = this;
        r4 = r4;
        r1 = r1;
        r2 = r2;
    L44:
        return r4;
    L4:
        return (ReturnValue) collectDomainsInternal(r22, false, true, r25, r26);
    }

    private <InitialValue, ReturnValue> ReturnValue collectDomainsInternal(AndroidPackage pkg, boolean checkAutoVerify, boolean valid, InitialValue initialValue, BiFunction<InitialValue, String, ReturnValue> domainCollector) {
        int totalSize = 0;
        boolean underMaxSize = true;
        List<ParsedActivity> activities = pkg.getActivities();
        int activitiesSize = activities.size();
        int activityIndex = 0;
    L3:
        if (activityIndex >= activitiesSize) goto L39;
        if (underMaxSize == false) goto L39;
        ParsedActivity activity = activities.get(activityIndex);
        List<ParsedIntentInfo> intents = activity.getIntents();
        int intentsSize = intents.size();
        int intentIndex = 0;
    L6:
        if (intentIndex >= intentsSize) goto L37;
        if (underMaxSize == false) goto L37;
        ParsedIntentInfo intent = intents.get(intentIndex);
        IntentFilter intentFilter = intent.getIntentFilter();
        if (checkAutoVerify == false) goto L14;
        if (intentFilter.getAutoVerify() == true) goto L14;
    L35:
        int totalSize2 = totalSize;
    L36:
        intentIndex = intentIndex + 1;
        DomainVerificationCollector this = this;
        checkAutoVerify = checkAutoVerify;
        totalSize = totalSize2;
    L14:
        if (intentFilter.hasCategory("android.intent.category.DEFAULT") == false) goto L35;
        if (intentFilter.handlesWebUris(checkAutoVerify) == false) goto L35;
        int authorityCount = intentFilter.countDataAuthorities();
        int index = 0;
    L19:
        if (index >= authorityCount) goto L33;
        if (underMaxSize == false) goto L33;
        String host = intentFilter.getDataAuthority(index).getHost();
        int totalSize3 = totalSize;
        if (this.isValidHost(host) != valid) goto L32;
        int totalSize4 = totalSize3 + this.byteSizeOf(host);
        if (totalSize4 >= 1048576) goto L26;
        boolean underMaxSize2 = true;
    L27:
        boolean underMaxSize3 = underMaxSize2;
        ReturnValue returnValue = domainCollector.apply(initialValue, host);
        if (returnValue != null) goto L29;
        underMaxSize = underMaxSize3;
        totalSize3 = totalSize4;
        goto L32
    L29:
        return returnValue;
    L26:
        underMaxSize2 = false;
    L32:
        index = index + 1;
        this = this;
        totalSize = totalSize3;
    L33:
        totalSize2 = totalSize;
    L37:
        activityIndex = activityIndex + 1;
        totalSize = totalSize;
    L39:
        return null;
    }

    private int byteSizeOf(String string) {
        return android.content.pm.verify.domain.DomainVerificationUtils.estimatedByteSizeOf(string);
    }

    private boolean isValidHost(String host) {
        if (TextUtils.isEmpty(host) == false) goto L6;
        return false;
    L6:
        this.mDomainMatcher.reset(host);
        return this.mDomainMatcher.matches();
    }
}
