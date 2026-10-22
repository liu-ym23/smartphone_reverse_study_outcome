package com.android.server.pm.verify.domain;

import android.content.Context;
import android.content.Intent;
import android.content.UriRelativeFilterGroup;
import android.content.UriRelativeFilterGroupParcel;
import android.content.pm.IntentFilterVerificationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.verify.domain.DomainOwner;
import android.content.pm.verify.domain.DomainSet;
import android.content.pm.verify.domain.DomainVerificationInfo;
import android.content.pm.verify.domain.DomainVerificationState;
import android.content.pm.verify.domain.DomainVerificationUserState;
import android.content.pm.verify.domain.IDomainVerificationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.PackageUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.util.CollectionUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.compat.PlatformCompat;
import com.android.server.pm.Computer;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUtils;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.PackageUserStateUtils;
import com.android.server.pm.verify.domain.models.DomainVerificationInternalUserState;
import com.android.server.pm.verify.domain.models.DomainVerificationPkgState;
import com.android.server.pm.verify.domain.models.DomainVerificationStateMap;
import com.android.server.pm.verify.domain.proxy.DomainVerificationProxy;
import com.android.server.pm.verify.domain.proxy.DomainVerificationProxyUnavailable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationService extends SystemService implements DomainVerificationManagerInternal, DomainVerificationShell.Callback {
    public static final boolean DEBUG_APPROVAL = false;
    private static final long SETTINGS_API_V2 = 178111421;
    private static final String TAG = "DomainVerificationService";
    private final DomainVerificationStateMap<DomainVerificationPkgState> mAttachedPkgStates;
    private boolean mCanSendBroadcasts;
    private final DomainVerificationCollector mCollector;
    private DomainVerificationManagerInternal.Connection mConnection;
    private final DomainVerificationDebug mDebug;
    private final DomainVerificationEnforcer mEnforcer;
    private final DomainVerificationLegacySettings mLegacySettings;
    private final Object mLock;
    private final PlatformCompat mPlatformCompat;
    private DomainVerificationProxy mProxy;
    private final DomainVerificationSettings mSettings;
    private final DomainVerificationShell mShell;
    private final IDomainVerificationManager.Stub mStub;
    private final SystemConfig mSystemConfig;

    private static class GetAttachedResult {
        private final int mErrorCode;
        private final DomainVerificationPkgState mPkgState;

        GetAttachedResult(DomainVerificationPkgState pkgState, int errorCode) {
            this.mPkgState = pkgState;
            this.mErrorCode = errorCode;
        }

        static GetAttachedResult error(int errorCode) {
            return new GetAttachedResult(null, errorCode);
        }

        static GetAttachedResult success(DomainVerificationPkgState pkgState) {
            return new GetAttachedResult(pkgState, 0);
        }

        DomainVerificationPkgState getPkgState() {
            return this.mPkgState;
        }

        boolean isError() {
            if (this.mErrorCode == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Mtb76nFNJ-m498VOcWtBBVrvhSY, reason: not valid java name */
    public static /* synthetic */ int m7120$r8$lambda$Mtb76nFNJm498VOcWtBBVrvhSY(Computer r0, int r1, String r2, String r3) {
        return lambda$getOwnersForDomainInternal$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$gIxTAFuj4DHILVBtedKn8-tgd0U, reason: not valid java name */
    public static /* synthetic */ String m7121$r8$lambda$gIxTAFuj4DHILVBtedKn8tgd0U(Computer r0, String r1) {
        return lambda$writeSettings$1(r0, r1);
    }

    public DomainVerificationService(Context context, SystemConfig systemConfig, PlatformCompat platformCompat) {
        super(context);
        this.mAttachedPkgStates = new DomainVerificationStateMap();
        this.mLock = new Object();
        this.mStub = new DomainVerificationManagerStub(this);
        this.mProxy = new DomainVerificationProxyUnavailable();
        this.mSystemConfig = systemConfig;
        this.mPlatformCompat = platformCompat;
        this.mCollector = new DomainVerificationCollector(platformCompat, systemConfig);
        this.mSettings = new DomainVerificationSettings(this.mCollector);
        this.mEnforcer = new DomainVerificationEnforcer(context);
        this.mDebug = new DomainVerificationDebug(this.mCollector);
        this.mShell = new DomainVerificationShell(this);
        this.mLegacySettings = new DomainVerificationLegacySettings();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("domain_verification", this.mStub);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void setConnection(DomainVerificationManagerInternal.Connection connection) {
        this.mConnection = connection;
        this.mEnforcer.setCallback(this.mConnection);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public DomainVerificationProxy getProxy() {
        return this.mProxy;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        super.onBootPhase(phase);
        if (hasRealVerifier() == true) goto L5;
        return;
    L5:
        switch(phase) {
            case 550: goto L8;
            case 1000: goto L7;
            default: goto L11;
        };
    L7:
        verifyPackages(null, false);
        return;
    L8:
        this.mCanSendBroadcasts = true;
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocked(SystemService.TargetUser user) {
        super.onUserUnlocked(user);
        verifyPackages(null, false);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void setProxy(DomainVerificationProxy proxy) {
        this.mProxy = proxy;
    }

    public void setUriRelativeFilterGroups(String packageName, Bundle bundle) throws PackageManager.NameNotFoundException {
        getContext().enforceCallingOrSelfPermission("android.permission.DOMAIN_VERIFICATION_AGENT", "Caller " + this.mConnection.getCallingUid() + " does not hold android.permission.DOMAIN_VERIFICATION_AGENT");
        if (bundle.isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L21
        if (pkgState == null) goto L28;
        Map<String, List<UriRelativeFilterGroup>> domainToGroupsMap = pkgState.getUriRelativeFilterGroupMap();     // Catch: Throwable -> L21
        Iterator<String> r3 = bundle.keySet().iterator();     // Catch: Throwable -> L21
    L11:
        if (r3.hasNext() == false) goto L25;
        String domain = r3.next();     // Catch: Throwable -> L21
        if (DomainVerificationUtils.isValidDomain(domain) == false) goto L11;
        ArrayList<UriRelativeFilterGroupParcel> parcels = bundle.getParcelableArrayList(domain, UriRelativeFilterGroupParcel.class);     // Catch: Throwable -> L21
        List<UriRelativeFilterGroup> groups = UriRelativeFilterGroup.parcelsToGroups(parcels);     // Catch: Throwable -> L21
        if (groups == null) goto L23;
        if (groups.isEmpty() == true) goto L23;
        domainToGroupsMap.put(domain, groups);     // Catch: Throwable -> L21
    L23:
        domainToGroupsMap.remove(domain);     // Catch: Throwable -> L21
        goto L11
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L28:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public Bundle getUriRelativeFilterGroups(String packageName, List<String> domains) {
        Bundle bundle = new Bundle();
        Object r1 = this.mLock;
        monitor-enter(r1);
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L12
        if (pkgState == null) goto L15;
        Map<String, List<UriRelativeFilterGroup>> map = pkgState.getUriRelativeFilterGroupMap();     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= domains.size()) goto L15;
        if (map.containsKey(domains.get(i)) == false) goto L14;
        List<UriRelativeFilterGroup> groups = map.get(domains.get(i));     // Catch: Throwable -> L12
        bundle.putParcelableList(domains.get(i), UriRelativeFilterGroup.groupsToParcels(groups));     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return bundle;
    L12:
        th = move-exception;
        throw th;
    }

    private List<UriRelativeFilterGroup> getUriRelativeFilterGroups(String packageName, String domain) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L10
        if (pkgState == null) goto L20;
        Map<String, List<UriRelativeFilterGroup>> groupMap = pkgState.getUriRelativeFilterGroupMap();     // Catch: Throwable -> L10
        List<UriRelativeFilterGroup> groups = groupMap.get(domain);     // Catch: Throwable -> L10
        if (groups == null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return groups;
    L12:
        int first = domain.indexOf(".");     // Catch: Throwable -> L10
        int second = domain.indexOf(46, first + 1);     // Catch: Throwable -> L10
    L13:
        if (first <= 0) goto L20;
        if (second <= 0) goto L20;
        List<UriRelativeFilterGroup> groups2 = groupMap.get(SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER + domain.substring(first));     // Catch: Throwable -> L10
        if (groups2 != null) goto L17;
        first = second;
        second = domain.indexOf(46, second + 1);     // Catch: Throwable -> L10
        goto L13
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return groups2;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return Collections.emptyList();
    L10:
        th = move-exception;
        throw th;
    }

    public List<String> queryValidVerificationPackageNames() {
        this.mEnforcer.assertApprovedVerifier(this.mConnection.getCallingUid(), this.mProxy);
        List<String> packageNames = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int size = this.mAttachedPkgStates.size();     // Catch: Throwable -> L9
        int index = 0;
    L5:
        if (index >= size) goto L13;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.valueAt(index);     // Catch: Throwable -> L9
        if (pkgState.isHasAutoVerifyDomains() == false) goto L11;
        packageNames.add(pkgState.getPackageName());     // Catch: Throwable -> L9
    L11:
        index = index + 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return packageNames;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public UUID getDomainVerificationInfoId(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L9
        if (pkgState == null) goto L11;
        UUID r2 = pkgState.getId();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public DomainVerificationInfo getDomainVerificationInfo(String packageName) throws PackageManager.NameNotFoundException {
        this.mEnforcer.assertApprovedQuerent(this.mConnection.getCallingUid(), this.mProxy);
        Computer snapshot = this.mConnection.snapshot();
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(packageName);     // Catch: Throwable -> L13
        if (pkgSetting != null) goto L7;
        AndroidPackage pkg = null;
    L8:
        if (pkg == null) goto L29;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L13
        if (pkgState != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return null;
    L15:
        ArrayMap<String, Integer> hostToStateMap = new ArrayMap(pkgState.getStateMap());     // Catch: Throwable -> L13
        ArraySet<String> domains = this.mCollector.collectValidAutoVerifyDomains(pkg);     // Catch: Throwable -> L13
        if (domains.isEmpty() == false) goto L19;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return null;
    L19:
        int size = domains.size();     // Catch: Throwable -> L13
        int index = 0;
    L20:
        if (index >= size) goto L22;
        hostToStateMap.putIfAbsent(domains.valueAt(index), 0);     // Catch: Throwable -> L13
        index = index + 1;     // Catch: Throwable -> L13
        goto L20
    L22:
        int mapSize = hostToStateMap.size();     // Catch: Throwable -> L13
        int index2 = 0;
    L23:
        if (index2 >= mapSize) goto L25;
        int internalValue = hostToStateMap.valueAt(index2).intValue();     // Catch: Throwable -> L13
        int publicValue = DomainVerificationState.convertToInfoState(internalValue);     // Catch: Throwable -> L13
        hostToStateMap.setValueAt(index2, Integer.valueOf(publicValue));     // Catch: Throwable -> L13
        index2 = index2 + 1;     // Catch: Throwable -> L13
        goto L23
    L25:
        DomainVerificationInfo r9 = new DomainVerificationInfo(pkgState.getId(), packageName, hostToStateMap);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r9;
    L29:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L13
    L7:
        pkg = pkgSetting.getPkg();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public int setDomainVerificationStatus(UUID domainSetId, Set<String> domains, int state) throws PackageManager.NameNotFoundException {
        if (state >= 1024) goto L10;
        if (state == 1) goto L10;
        throw new IllegalArgumentException("Caller is not allowed to set state code " + state);
    L10:
        return setDomainVerificationStatusInternal(this.mConnection.getCallingUid(), domainSetId, domains, state);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public int setDomainVerificationStatusInternal(int callingUid, UUID domainSetId, Set<String> domains, int state) throws PackageManager.NameNotFoundException {
        this.mEnforcer.assertApprovedVerifier(callingUid, this.mProxy);
        Computer snapshot = this.mConnection.snapshot();
        Object r8 = this.mLock;
        monitor-enter(r8);
        List<String> newlyVerifiedDomains = new ArrayList();     // Catch: Throwable -> L37
        GetAttachedResult result = getAndValidateAttachedLocked(domainSetId, domains, true, callingUid, null, snapshot);     // Catch: Throwable -> L11
        if (result.isError() == false) goto L13;
        int r13 = result.getErrorCode();     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return r13;
    L13:
        DomainVerificationPkgState pkgState = result.getPkgState();     // Catch: Throwable -> L11
        ArrayMap<String, Integer> stateMap = pkgState.getStateMap();     // Catch: Throwable -> L11
        Iterator<String> r4 = domains.iterator();     // Catch: Throwable -> L11
    L15:
        if (r4.hasNext() == false) goto L30;
        String domain = r4.next();     // Catch: Throwable -> L11
        Integer previousState = stateMap.get(domain);     // Catch: Throwable -> L11
        if (previousState == null) goto L24;
        if (previousState.intValue() == state) goto L15;
        if (DomainVerificationState.isModifiable(previousState.intValue()) == false) goto L15;
    L24:
        if (DomainVerificationState.isVerified(state) == false) goto L29;
        if (previousState != null) goto L27;
    L28:
        newlyVerifiedDomains.add(domain);     // Catch: Throwable -> L11
        goto L29
    L27:
        if (DomainVerificationState.isVerified(previousState.intValue()) == false) goto L28;
    L29:
        stateMap.put(domain, Integer.valueOf(state));     // Catch: Throwable -> L11
        goto L15
    L30:
        int size = newlyVerifiedDomains.size();     // Catch: Throwable -> L11
        int index = 0;
    L31:
        if (index >= size) goto L34;
        removeUserStatesForDomain(pkgState, newlyVerifiedDomains.get(index));     // Catch: Throwable -> L11
        index = index + 1;     // Catch: Throwable -> L11
        goto L31
    L34:
        monitor-exit(r8);     // Catch: Throwable -> L11
        this.mConnection.scheduleWriteSettings();
        return 0;
    L37:
        th = move-exception;
        Throwable r12 = th;
    L39:
        monitor-exit(r8);     // Catch: Throwable -> L11
        throw r12;
    L11:
        th = move-exception;
        r12 = th;
        goto L39
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void setDomainVerificationStatusInternal(String packageName, int state, ArraySet<String> domains) throws PackageManager.NameNotFoundException {
        this.mEnforcer.assertInternal(this.mConnection.getCallingUid());
        switch(state) {
            case 0: goto L7;
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            default: goto L5;
        };
    L7:
        if (packageName != null) goto L30;
        Computer snapshot = this.mConnection.snapshot();
        Object r6 = this.mLock;
        monitor-enter(r6);
        ArraySet<String> validDomains = new ArraySet();     // Catch: Throwable -> L20
        int size = this.mAttachedPkgStates.size();     // Catch: Throwable -> L20
        int index = 0;
    L11:
        if (index >= size) goto L26;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.valueAt(index);     // Catch: Throwable -> L20
        String pkgName = pkgState.getPackageName();     // Catch: Throwable -> L20
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(pkgName);     // Catch: Throwable -> L20
        if (pkgSetting == null) goto L24;
        if (pkgSetting.getPkg() == null) goto L24;
        AndroidPackage pkg = pkgSetting.getPkg();     // Catch: Throwable -> L20
        validDomains.clear();     // Catch: Throwable -> L20
        ArraySet<String> autoVerifyDomains = this.mCollector.collectValidAutoVerifyDomains(pkg);     // Catch: Throwable -> L20
        if (domains != null) goto L22;
        validDomains.addAll(autoVerifyDomains);     // Catch: Throwable -> L20
    L23:
        setDomainVerificationStatusInternal(pkgState, state, validDomains);     // Catch: Throwable -> L20
        goto L24
    L22:
        validDomains.addAll(domains);     // Catch: Throwable -> L20
        validDomains.retainAll(autoVerifyDomains);     // Catch: Throwable -> L20
    L24:
        index = index + 1;     // Catch: Throwable -> L20
        goto L11
    L26:
        monitor-exit(r6);     // Catch: Throwable -> L20
    L60:
        this.mConnection.scheduleWriteSettings();
        return;
    L20:
        th = move-exception;
        throw th;
    L30:
        Computer snapshot2 = this.mConnection.snapshot();
        Object r7 = this.mLock;
        monitor-enter(r7);
        DomainVerificationPkgState pkgState2 = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L41
        if (pkgState2 == null) goto L65;
        PackageStateInternal pkgSetting2 = snapshot2.getPackageStateInternal(packageName);     // Catch: Throwable -> L41
        if (pkgSetting2 == null) goto L63;
        if (pkgSetting2.getPkg() == null) goto L63;
        AndroidPackage pkg2 = pkgSetting2.getPkg();     // Catch: Throwable -> L41
        if (domains != null) goto L43;
        ArraySet<String> validDomains2 = this.mCollector.collectValidAutoVerifyDomains(pkg2);     // Catch: Throwable -> L41
    L44:
        ArraySet<String> newlyVerifiedDomains = null;
        if (DomainVerificationState.isVerified(state) == false) goto L54;
        newlyVerifiedDomains = new ArraySet();     // Catch: Throwable -> L41
        ArrayMap<String, Integer> stateMap = pkgState2.getStateMap();     // Catch: Throwable -> L41
        int domainsSize = validDomains2.size();     // Catch: Throwable -> L41
        int domainIndex = 0;
    L47:
        if (domainIndex >= domainsSize) goto L54;
        String domain = validDomains2.valueAt(domainIndex);     // Catch: Throwable -> L41
        Integer oldState = stateMap.get(domain);     // Catch: Throwable -> L41
        if (oldState != null) goto L51;
    L52:
        newlyVerifiedDomains.add(domain);     // Catch: Throwable -> L41
    L53:
        domainIndex = domainIndex + 1;     // Catch: Throwable -> L41
        goto L47
    L51:
        if (DomainVerificationState.isVerified(oldState.intValue()) == true) goto L53;
    L54:
        setDomainVerificationStatusInternal(pkgState2, state, validDomains2);     // Catch: Throwable -> L41
        if (newlyVerifiedDomains == null) goto L59;
        int domainsSize2 = newlyVerifiedDomains.size();     // Catch: Throwable -> L41
        int domainIndex2 = 0;
    L57:
        if (domainIndex2 >= domainsSize2) goto L59;
        removeUserStatesForDomain(pkgState2, newlyVerifiedDomains.valueAt(domainIndex2));     // Catch: Throwable -> L41
        domainIndex2 = domainIndex2 + 1;     // Catch: Throwable -> L41
    L59:
        monitor-exit(r7);     // Catch: Throwable -> L41
        goto L60
    L43:
        validDomains2 = domains;
        validDomains2.retainAll(this.mCollector.collectValidAutoVerifyDomains(pkg2));     // Catch: Throwable -> L41
    L63:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L41
    L65:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    L5:
        throw new IllegalArgumentException("State must be one of NO_RESPONSE, SUCCESS, APPROVED, or DENIED");
    }

    private void setDomainVerificationStatusInternal(DomainVerificationPkgState pkgState, int state, ArraySet<String> validDomains) {
        ArrayMap<String, Integer> stateMap = pkgState.getStateMap();
        int size = validDomains.size();
        int index = 0;
    L3:
        if (index >= size) goto L6;
        stateMap.put(validDomains.valueAt(index), Integer.valueOf(state));
        index = index + 1;
        goto L3
    }

    private void removeUserStatesForDomain(DomainVerificationPkgState owningPkgState, String domain) {
        SparseArray<DomainVerificationInternalUserState> owningUserStates = owningPkgState.getUserStates();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int size = this.mAttachedPkgStates.size();     // Catch: Throwable -> L13
        int index = 0;
    L5:
        if (index >= size) goto L19;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.valueAt(index);     // Catch: Throwable -> L13
        SparseArray<DomainVerificationInternalUserState> array = pkgState.getUserStates();     // Catch: Throwable -> L13
        int arraySize = array.size();     // Catch: Throwable -> L13
        int arrayIndex = 0;
    L7:
        if (arrayIndex >= arraySize) goto L17;
        int userId = array.keyAt(arrayIndex);     // Catch: Throwable -> L13
        DomainVerificationInternalUserState owningUserState = owningUserStates.get(userId);     // Catch: Throwable -> L13
        if (owningUserState != null) goto L11;
    L15:
        array.valueAt(arrayIndex).removeHost(domain);     // Catch: Throwable -> L13
    L16:
        arrayIndex = arrayIndex + 1;     // Catch: Throwable -> L13
        goto L7
    L11:
        if (owningUserState.isLinkHandlingAllowed() == true) goto L15;
    L17:
        index = index + 1;     // Catch: Throwable -> L13
        goto L5
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void setDomainVerificationLinkHandlingAllowed(String packageName, boolean allowed, int userId) throws PackageManager.NameNotFoundException {
        if (this.mEnforcer.assertApprovedUserSelector(this.mConnection.getCallingUid(), this.mConnection.getCallingUserId(), packageName, userId) == false) goto L19;
        Object r0 = this.mLock;
        monitor-enter(r0);
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L12
        if (pkgState == null) goto L15;
        pkgState.getOrCreateUserState(userId).setLinkHandlingAllowed(allowed);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mConnection.scheduleWriteSettings();
        return;
    L15:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L19:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void setDomainVerificationLinkHandlingAllowedInternal(String packageName, boolean allowed, int userId) throws PackageManager.NameNotFoundException {
        this.mEnforcer.assertInternal(this.mConnection.getCallingUid());
        int r0 = 0;
        if (packageName != null) goto L22;
        Object r2 = this.mLock;
        monitor-enter(r2);
        int pkgStateSize = this.mAttachedPkgStates.size();     // Catch: Throwable -> L13
        int pkgStateIndex = 0;
    L7:
        if (pkgStateIndex >= pkgStateSize) goto L18;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.valueAt(pkgStateIndex);     // Catch: Throwable -> L13
        if (userId != (-1)) goto L15;
        int[] r6 = this.mConnection.getAllUserIds();     // Catch: Throwable -> L13
        int r7 = r6.length;     // Catch: Throwable -> L13
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L16;
        int aUserId = r6[r8];     // Catch: Throwable -> L13
        pkgState.getOrCreateUserState(aUserId).setLinkHandlingAllowed(allowed);     // Catch: Throwable -> L13
        r8 = r8 + 1;     // Catch: Throwable -> L13
    L16:
        pkgStateIndex = pkgStateIndex + 1;     // Catch: Throwable -> L13
        goto L7
    L15:
        pkgState.getOrCreateUserState(userId).setLinkHandlingAllowed(allowed);     // Catch: Throwable -> L13
        goto L16
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L13
    L34:
        this.mConnection.scheduleWriteSettings();
        return;
    L13:
        th = move-exception;
        throw th;
    L22:
        Object r3 = this.mLock;
        monitor-enter(r3);
        DomainVerificationPkgState pkgState2 = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L30
        if (pkgState2 == null) goto L37;
        if (userId != (-1)) goto L32;
        int[] r1 = this.mConnection.getAllUserIds();     // Catch: Throwable -> L30
        int r4 = r1.length;     // Catch: Throwable -> L30
    L28:
        if (r0 >= r4) goto L33;
        int aUserId2 = r1[r0];     // Catch: Throwable -> L30
        pkgState2.getOrCreateUserState(aUserId2).setLinkHandlingAllowed(allowed);     // Catch: Throwable -> L30
        r0 = r0 + 1;     // Catch: Throwable -> L30
    L33:
        monitor-exit(r3);     // Catch: Throwable -> L30
        goto L34
    L32:
        pkgState2.getOrCreateUserState(userId).setLinkHandlingAllowed(allowed);     // Catch: Throwable -> L30
        goto L33
    L37:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public int setDomainVerificationUserSelection(UUID domainSetId, Set<String> domains, boolean enabled, int userId) throws PackageManager.NameNotFoundException {
        int callingUid = this.mConnection.getCallingUid();
        if (this.mEnforcer.assertApprovedUserSelector(callingUid, this.mConnection.getCallingUserId(), null, userId) == true) goto L6;
        return 1;
    L6:
        Computer snapshot = this.mConnection.snapshot();
        Object r8 = this.mLock;
        monitor-enter(r8);
        GetAttachedResult result = getAndValidateAttachedLocked(domainSetId, domains, false, callingUid, Integer.valueOf(userId), snapshot);     // Catch: Throwable -> L15
        if (result.isError() == false) goto L17;
        int r11 = result.getErrorCode();     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        return r11;
    L17:
        DomainVerificationPkgState pkgState = result.getPkgState();     // Catch: Throwable -> L15
        DomainVerificationInternalUserState userState = pkgState.getOrCreateUserState(userId);     // Catch: Throwable -> L15
        if (enabled == false) goto L23;
        int statusCode = revokeOtherUserSelectionsLocked(userState, userId, domains, snapshot);     // Catch: Throwable -> L15
        if (statusCode == 0) goto L23;
        monitor-exit(r8);     // Catch: Throwable -> L15
        return statusCode;
    L23:
        if (enabled == false) goto L25;
        userState.addHosts(domains);     // Catch: Throwable -> L15
    L26:
        monitor-exit(r8);     // Catch: Throwable -> L15
        this.mConnection.scheduleWriteSettings();
        return 0;
    L25:
        userState.removeHosts(domains);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Throwable r10 = th;
    L31:
        monitor-exit(r8);     // Catch: Throwable -> L15
        throw r10;
    L29:
        th = move-exception;
        r10 = th;
        goto L31
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void setDomainVerificationUserSelectionInternal(int userId, String packageName, boolean enabled, ArraySet<String> domains) throws PackageManager.NameNotFoundException {
        this.mEnforcer.assertInternal(this.mConnection.getCallingUid());
        Computer snapshot = this.mConnection.snapshot();
        Object r1 = this.mLock;
        monitor-enter(r1);
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L13
        if (pkgState == null) goto L35;
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(packageName);     // Catch: Throwable -> L13
        if (pkgSetting != null) goto L9;
        AndroidPackage pkg = null;
    L10:
        if (pkg == null) goto L33;
        if (domains != null) goto L15;
        Set<String> validDomains = this.mCollector.collectAllWebDomains(pkg);     // Catch: Throwable -> L13
    L16:
        validDomains.retainAll(this.mCollector.collectAllWebDomains(pkg));     // Catch: Throwable -> L13
        if (userId != (-1)) goto L25;
        int[] r6 = this.mConnection.getAllUserIds();     // Catch: Throwable -> L13
        int r7 = r6.length;     // Catch: Throwable -> L13
        int r8 = 0;
    L19:
        if (r8 >= r7) goto L29;
        int aUserId = r6[r8];     // Catch: Throwable -> L13
        DomainVerificationInternalUserState userState = pkgState.getOrCreateUserState(aUserId);     // Catch: Throwable -> L13
        revokeOtherUserSelectionsLocked(userState, aUserId, validDomains, snapshot);     // Catch: Throwable -> L13
        if (enabled == false) goto L23;
        userState.addHosts(validDomains);     // Catch: Throwable -> L13
    L24:
        r8 = r8 + 1;     // Catch: Throwable -> L13
        goto L19
    L23:
        userState.removeHosts(validDomains);     // Catch: Throwable -> L13
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L13
        this.mConnection.scheduleWriteSettings();
        return;
    L25:
        DomainVerificationInternalUserState userState2 = pkgState.getOrCreateUserState(userId);     // Catch: Throwable -> L13
        revokeOtherUserSelectionsLocked(userState2, userId, validDomains, snapshot);     // Catch: Throwable -> L13
        if (enabled == false) goto L28;
        userState2.addHosts(validDomains);     // Catch: Throwable -> L13
        goto L29
    L28:
        userState2.removeHosts(validDomains);     // Catch: Throwable -> L13
        goto L29
    L15:
        validDomains = domains;
        goto L16
    L33:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L13
    L9:
        pkg = pkgSetting.getPkg();     // Catch: Throwable -> L13
        goto L10
    L35:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private int revokeOtherUserSelectionsLocked(DomainVerificationInternalUserState userState, int userId, Set<String> domains, Computer snapshot) {
        ArrayMap<String, List<String>> domainToApprovedPackages = new ArrayMap();
        Iterator<String> r1 = domains.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        String domain = r1.next();
        if (userState.getEnabledHosts().contains(domain) == true) goto L4;
        Pair<List<String>, Integer> packagesToLevel = getApprovedPackagesLocked(domain, userId, 1, snapshot);
        int highestApproval = ((Integer) packagesToLevel.second).intValue();
        if (highestApproval > 3) goto L10;
        domainToApprovedPackages.put(domain, (List) packagesToLevel.first);
        goto L4
    L10:
        return 3;
    L12:
        int mapSize = domainToApprovedPackages.size();
        int mapIndex = 0;
    L13:
        if (mapIndex >= mapSize) goto L25;
        String domain2 = domainToApprovedPackages.keyAt(mapIndex);
        List<String> approvedPackages = domainToApprovedPackages.valueAt(mapIndex);
        int approvedSize = approvedPackages.size();
        int approvedIndex = 0;
    L15:
        if (approvedIndex >= approvedSize) goto L24;
        String approvedPackage = approvedPackages.get(approvedIndex);
        DomainVerificationPkgState approvedPkgState = this.mAttachedPkgStates.get(approvedPackage);
        if (approvedPkgState == null) goto L23;
        DomainVerificationInternalUserState approvedUserState = approvedPkgState.getUserState(userId);
        if (approvedUserState == null) goto L23;
        approvedUserState.removeHost(domain2);
    L23:
        approvedIndex = approvedIndex + 1;
        goto L15
    L24:
        mapIndex = mapIndex + 1;
        goto L13
    L25:
        return 0;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public DomainVerificationUserState getDomainVerificationUserState(String packageName, int userId) throws PackageManager.NameNotFoundException {
        if (this.mEnforcer.assertApprovedUserStateQuerent(this.mConnection.getCallingUid(), this.mConnection.getCallingUserId(), packageName, userId) == false) goto L50;
        Computer snapshot = this.mConnection.snapshot();
        Object r10 = this.mLock;
        monitor-enter(r10);
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(packageName);     // Catch: Throwable -> L16
        if (pkgSetting != null) goto L9;
        AndroidPackageInternal r3 = null;
    L10:
        AndroidPackageInternal r11 = r3;
        if (r11 == null) goto L46;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L16
        if (pkgState != null) goto L18;
        monitor-exit(r10);     // Catch: Throwable -> L16
        return null;
    L18:
        ArraySet<String> webDomains = this.mCollector.collectAllWebDomains(r11);     // Catch: Throwable -> L16
        int webDomainsSize = webDomains.size();     // Catch: Throwable -> L16
        Map<String, Integer> domains = new ArrayMap(webDomainsSize);     // Catch: Throwable -> L16
        ArrayMap<String, Integer> stateMap = pkgState.getStateMap();     // Catch: Throwable -> L16
        DomainVerificationInternalUserState userState = pkgState.getUserState(userId);     // Catch: Throwable -> L16
        if (userState != null) goto L21;
        Set<String> enabledHosts = Collections.emptySet();     // Catch: Throwable -> L16
    L22:
        int index = 0;
    L23:
        if (index >= webDomainsSize) goto L35;
        String host = webDomains.valueAt(index);     // Catch: Throwable -> L16
        Integer state = stateMap.get(host);     // Catch: Throwable -> L16
        if (state == null) goto L30;
        if (DomainVerificationState.isVerified(state.intValue()) == false) goto L30;
        int domainState = 2;
    L33:
        domains.put(host, Integer.valueOf(domainState));     // Catch: Throwable -> L16
        index = index + 1;     // Catch: Throwable -> L16
        pkgSetting = pkgSetting;
    L30:
        if (enabledHosts.contains(host) == false) goto L32;
        domainState = 1;
        goto L33
    L32:
        domainState = 0;
        goto L33
    L35:
        if (userState != null) goto L37;
    L41:
        boolean r0 = true;
    L40:
        boolean linkHandlingAllowed = r0;
        DomainVerificationUserState r2 = new DomainVerificationUserState(pkgState.getId(), packageName, UserHandle.of(userId), linkHandlingAllowed, domains);     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return r2;
    L37:
        if (userState.isLinkHandlingAllowed() == true) goto L41;
        r0 = false;
        goto L40
    L21:
        enabledHosts = userState.getEnabledHosts();     // Catch: Throwable -> L16
        goto L22
    L46:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);     // Catch: Throwable -> L16
    L9:
        r3 = pkgSetting.getPkg();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L50:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);
    }

    public List<DomainOwner> getOwnersForDomain(String domain, int userId) {
        domain.getClass();
        this.mEnforcer.assertOwnerQuerent(this.mConnection.getCallingUid(), this.mConnection.getCallingUserId(), userId);
        Computer snapshot = this.mConnection.snapshot();
        SparseArray<List<String>> levelToPackages = getOwnersForDomainInternal(domain, false, userId, snapshot);
        if (levelToPackages.size() == 0) goto L5;
        List<DomainOwner> owners = new ArrayList();
        int size = levelToPackages.size();
        int index = 0;
    L7:
        if (index >= size) goto L17;
        int level = levelToPackages.keyAt(index);
        if (level > 3) goto L11;
        boolean overrideable = true;
    L12:
        List<String> packages = levelToPackages.valueAt(index);
        int packagesSize = packages.size();
        int packageIndex = 0;
    L13:
        if (packageIndex >= packagesSize) goto L15;
        owners.add(new DomainOwner(packages.get(packageIndex), overrideable));
        packageIndex = packageIndex + 1;
        goto L13
    L15:
        index = index + 1;
        goto L7
    L11:
        overrideable = false;
        goto L12
    L17:
        return owners;
    L5:
        return Collections.emptyList();
    }

    private SparseArray<List<String>> getOwnersForDomainInternal(String domain, boolean includeNegative, final int userId, final Computer snapshot) {
        SparseArray<List<String>> levelToPackages = new SparseArray();
        Object r10 = this.mLock;
        monitor-enter(r10);
        int size = this.mAttachedPkgStates.size();     // Catch: Throwable -> L16
        int index = 0;
    L5:
        if (index >= size) goto L21;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.valueAt(index);     // Catch: Throwable -> L16
        String packageName = pkgState.getPackageName();     // Catch: Throwable -> L16
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(packageName);     // Catch: Throwable -> L16
        if (pkgSetting == null) goto L19;
        int level = approvalLevelForDomain(pkgSetting, domain, includeNegative, userId, false, domain);     // Catch: Throwable -> L16
        if (includeNegative == true) goto L13;
        if (level <= 0) goto L19;
    L13:
        List<String> list = levelToPackages.get(level);     // Catch: Throwable -> L16
        if (list != null) goto L18;
        list = new ArrayList();     // Catch: Throwable -> L16
        levelToPackages.put(level, list);     // Catch: Throwable -> L16
    L18:
        list.add(packageName);     // Catch: Throwable -> L16
    L19:
        index = index + 1;     // Catch: Throwable -> L16
        goto L5
    L21:
        monitor-exit(r10);     // Catch: Throwable -> L16
        int size2 = levelToPackages.size();
        if (size2 != 0) goto L25;
        return levelToPackages;
    L25:
        int index2 = 0;
    L26:
        if (index2 >= size2) goto L29;
        levelToPackages.valueAt(index2).sort(new DomainVerificationService$$ExternalSyntheticLambda1(snapshot, userId));
        index2 = index2 + 1;
        goto L26
    L29:
        return levelToPackages;
    L16:
        th = th;
    L34:
        throw th;
    L32:
        th = th;
        goto L34
    }

    private static /* synthetic */ int lambda$getOwnersForDomainInternal$0(Computer snapshot, int userId, String first, String second) {
        PackageStateInternal firstPkgSetting = snapshot.getPackageStateInternal(first);
        PackageStateInternal secondPkgSetting = snapshot.getPackageStateInternal(second);
        long secondInstallTime = -1;
        if (firstPkgSetting != null) goto L5;
        long firstInstallTime = -1;
    L7:
        if (secondPkgSetting == null) goto L11;
        secondInstallTime = secondPkgSetting.getUserStateOrDefault(userId).getFirstInstallTimeMillis();
    L11:
        if (firstInstallTime == secondInstallTime) goto L15;
        return (int) (firstInstallTime - secondInstallTime);
    L15:
        return first.compareToIgnoreCase(second);
    L5:
        firstInstallTime = firstPkgSetting.getUserStateOrDefault(userId).getFirstInstallTimeMillis();
        goto L7
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public UUID generateNewId() {
        return UUID.randomUUID();
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void migrateState(PackageStateInternal oldPkgSetting, PackageStateInternal newPkgSetting, DomainSet preVerifiedDomains) {
        String pkgName = newPkgSetting.getPackageName();
        Object r11 = this.mLock;
        monitor-enter(r11);
        UUID oldDomainSetId = oldPkgSetting.getDomainSetId();     // Catch: Throwable -> L51
        UUID newDomainSetId = newPkgSetting.getDomainSetId();     // Catch: Throwable -> L51
        DomainVerificationPkgState oldPkgState = this.mAttachedPkgStates.remove(oldDomainSetId);     // Catch: Throwable -> L51
        AndroidPackageInternal r3 = oldPkgSetting.getPkg();     // Catch: Throwable -> L51
        AndroidPackage newPkg = newPkgSetting.getPkg();     // Catch: Throwable -> L51
        ArrayMap<String, Integer> newStateMap = new ArrayMap();     // Catch: Throwable -> L51
        SparseArray<DomainVerificationInternalUserState> newUserStates = new SparseArray();     // Catch: Throwable -> L51
        if (oldPkgState == null) goto L56;
        if (r3 == null) goto L56;
        if (newPkg == null) goto L56;
        ArrayMap<String, Integer> oldStateMap = oldPkgState.getStateMap();     // Catch: Throwable -> L51
        ArrayMap<String, List<UriRelativeFilterGroup>> oldGroups = oldPkgState.getUriRelativeFilterGroupMap();     // Catch: Throwable -> L51
        ArraySet<String> newAutoVerifyDomains = this.mCollector.collectValidAutoVerifyDomains(newPkg);     // Catch: Throwable -> L51
        int newDomainsSize = newAutoVerifyDomains.size();     // Catch: Throwable -> L51
        int newDomainsIndex = 0;
    L11:
        if (newDomainsIndex >= newDomainsSize) goto L26;
        String domain = newAutoVerifyDomains.valueAt(newDomainsIndex);     // Catch: Throwable -> L22
        UUID oldDomainSetId2 = oldDomainSetId;
        Integer oldStateInteger = oldStateMap.get(domain);     // Catch: Throwable -> L22
        if (oldStateInteger == null) goto L24;
        int oldState = oldStateInteger.intValue();     // Catch: Throwable -> L22
        if (DomainVerificationState.shouldMigrate(oldState) == false) goto L21;
        String pkgName2 = pkgName;
        newStateMap.put(domain, Integer.valueOf(oldState));     // Catch: Throwable -> L19
    L25:
        newDomainsIndex = newDomainsIndex + 1;
        oldDomainSetId = oldDomainSetId2;
        pkgName = pkgName2;
    L19:
        th = th;
    L62:
        monitor-exit(r11);     // Catch: Throwable -> L61
        throw th;
    L21:
        pkgName2 = pkgName;
        goto L25
    L24:
        pkgName2 = pkgName;
    L22:
        th = th;
        goto L62
    L26:
        pkgName2 = pkgName;
        SparseArray<DomainVerificationInternalUserState> oldUserStates = oldPkgState.getUserStates();     // Catch: Throwable -> L53
        int oldUserStatesSize = oldUserStates.size();     // Catch: Throwable -> L53
        if (oldUserStatesSize <= 0) goto L34;
        Collection<?> newWebDomains = this.mCollector.collectAllWebDomains(newPkg);     // Catch: Throwable -> L19
        int oldUserStatesIndex = 0;
    L30:
        if (oldUserStatesIndex >= oldUserStatesSize) goto L33;
        int userId = oldUserStates.keyAt(oldUserStatesIndex);     // Catch: Throwable -> L19
        DomainVerificationInternalUserState oldUserState = oldUserStates.valueAt(oldUserStatesIndex);     // Catch: Throwable -> L19
        ArraySet<String> oldEnabledHosts = oldUserState.getEnabledHosts();     // Catch: Throwable -> L19
        SparseArray<DomainVerificationInternalUserState> oldUserStates2 = oldUserStates;
        int oldUserStatesSize2 = oldUserStatesSize;
        ArraySet<String> newEnabledHosts = new ArraySet(oldEnabledHosts);     // Catch: Throwable -> L19
        newEnabledHosts.retainAll(newWebDomains);     // Catch: Throwable -> L19
        int oldUserStatesIndex2 = oldUserStatesIndex;
        int newDomainsSize2 = newDomainsSize;
        DomainVerificationInternalUserState newUserState = new DomainVerificationInternalUserState(userId, newEnabledHosts, oldUserState.isLinkHandlingAllowed());     // Catch: Throwable -> L19
        newUserStates.put(userId, newUserState);     // Catch: Throwable -> L19
        oldUserStatesIndex = oldUserStatesIndex2 + 1;
        oldUserStates = oldUserStates2;
        oldUserStatesSize = oldUserStatesSize2;
        newDomainsSize = newDomainsSize2;
        goto L30
    L33:
        int newDomainsSize3 = newDomainsSize;
    L35:
        boolean sendBroadcast = false;
        if (newDomainsSize3 <= 0) goto L38;
        boolean hasAutoVerifyDomains = true;
    L40:
        boolean needsBroadcast = applyImmutableState(newPkgSetting, newStateMap, newAutoVerifyDomains);     // Catch: Throwable -> L53
        if (hasAutoVerifyDomains == false) goto L44;
        if (needsBroadcast == false) goto L44;
        sendBroadcast = true;
    L44:
        applyPreVerifiedState(newStateMap, newAutoVerifyDomains, preVerifiedDomains);     // Catch: Throwable -> L53
        boolean sendBroadcast2 = sendBroadcast;
        this.mAttachedPkgStates.put(pkgName2, newDomainSetId, new DomainVerificationPkgState(pkgName2, newDomainSetId, hasAutoVerifyDomains, newStateMap, newUserStates, null, oldGroups));     // Catch: Throwable -> L51
        monitor-exit(r11);     // Catch: Throwable -> L51
        if (sendBroadcast2 == false) goto L77;
        sendBroadcast(pkgName2);
        return;
    L77:
        return;
    L38:
        hasAutoVerifyDomains = false;
        goto L40
    L34:
        newDomainsSize3 = newDomainsSize;
    L53:
        th = th;
    L56:
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L51
        r4.append("Invalid state nullability old state = ");     // Catch: Throwable -> L51
        r4.append(oldPkgState);     // Catch: Throwable -> L51
        r4.append(", old pkgSetting = ");     // Catch: Throwable -> L51
        r4.append(oldPkgSetting);     // Catch: Throwable -> L61
        r4.append(", new pkgSetting = ");     // Catch: Throwable -> L61
        r4.append(newPkgSetting);     // Catch: Throwable -> L61
        r4.append(", old pkg = ");     // Catch: Throwable -> L61
        r4.append(r3);     // Catch: Throwable -> L61
        r4.append(", new pkg = ");     // Catch: Throwable -> L61
        r4.append(newPkg);     // Catch: Throwable -> L61
        Slog.wtf(TAG, r4.toString(), new Exception());     // Catch: Throwable -> L61
        DomainVerificationPkgState newPkgState = new DomainVerificationPkgState(pkgName, newDomainSetId, true, newStateMap, newUserStates, null);     // Catch: Throwable -> L61
        this.mAttachedPkgStates.put(pkgName, newDomainSetId, newPkgState);     // Catch: Throwable -> L61
        monitor-exit(r11);     // Catch: Throwable -> L61
        return;
    L51:
        th = th;
    L61:
        th = th;
        goto L62
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void addPackage(PackageStateInternal newPkgSetting, DomainSet preVerifiedDomains) {
        UUID domainSetId = newPkgSetting.getDomainSetId();
        String pkgName = newPkgSetting.getPackageName();
        DomainVerificationPkgState pkgState = this.mSettings.removePendingState(pkgName);
        if (pkgState == null) goto L5;
        boolean sendBroadcast = false;
        DomainVerificationPkgState pkgState2 = pkgState;
    L11:
        AndroidPackage pkg = newPkgSetting.getPkg();
        ArraySet<String> autoVerifyDomains = this.mCollector.collectValidAutoVerifyDomains(pkg);
        boolean isPendingOrRestored = true;
        boolean hasAutoVerifyDomains = !autoVerifyDomains.isEmpty();
        int userStateSize = 0;
        if (pkgState2 != null) goto L15;
        isPendingOrRestored = false;
    L15:
        if (isPendingOrRestored == false) goto L20;
        DomainVerificationPkgState pkgState3 = new DomainVerificationPkgState(pkgState2, domainSetId, hasAutoVerifyDomains);
        pkgState3.getStateMap().retainAll(autoVerifyDomains);
        Set<String> webDomains = this.mCollector.collectAllWebDomains(pkg);
        SparseArray<DomainVerificationInternalUserState> userStates = pkgState3.getUserStates();
        int size = userStates.size();
        int index = 0;
    L17:
        if (index >= size) goto L21;
        userStates.valueAt(index).retainHosts(webDomains);
        index = index + 1;
    L21:
        boolean needsBroadcast = applyImmutableState(newPkgSetting, pkgState3.getStateMap(), autoVerifyDomains);
        if (needsBroadcast == false) goto L49;
        if (isPendingOrRestored == true) goto L49;
        ArraySet<String> webDomains2 = null;
        SparseIntArray legacyUserStates = this.mLegacySettings.getUserStates(pkgName);
        if (legacyUserStates == null) goto L28;
        userStateSize = legacyUserStates.size();
    L28:
        int index2 = 0;
    L29:
        if (index2 >= userStateSize) goto L38;
        int userId = legacyUserStates.keyAt(index2);
        ArraySet<String> webDomains3 = webDomains2;
        int legacyStatus = legacyUserStates.valueAt(index2);
        boolean sendBroadcast2 = sendBroadcast;
        if (legacyStatus != 2) goto L36;
        if (webDomains3 != null) goto L34;
        ArraySet<String> webDomains4 = this.mCollector.collectAllWebDomains(pkg);
    L35:
        pkgState3.getOrCreateUserState(userId).addHosts(webDomains4);
        webDomains2 = webDomains4;
    L37:
        index2 = index2 + 1;
        sendBroadcast = sendBroadcast2;
        goto L29
    L34:
        webDomains4 = webDomains3;
        goto L35
    L36:
        webDomains2 = webDomains3;
        goto L37
    L38:
        boolean sendBroadcast3 = sendBroadcast;
        IntentFilterVerificationInfo legacyInfo = this.mLegacySettings.remove(pkgName);
        if (legacyInfo == null) goto L48;
        if (legacyInfo.getStatus() != 2) goto L48;
        ArrayMap<String, Integer> stateMap = pkgState3.getStateMap();
        int domainsSize = autoVerifyDomains.size();
        int index3 = 0;
    L43:
        if (index3 >= domainsSize) goto L48;
        stateMap.put(autoVerifyDomains.valueAt(index3), 4);
        index3 = index3 + 1;
        legacyInfo = legacyInfo;
        pkg = pkg;
    L48:
        applyPreVerifiedState(pkgState3.getStateMap(), autoVerifyDomains, preVerifiedDomains);
    L50:
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mAttachedPkgStates.put(pkgName, domainSetId, pkgState3);     // Catch: Throwable -> L58
        monitor-exit(r5);     // Catch: Throwable -> L58
        if (sendBroadcast3 == false) goto L68;
        if (hasAutoVerifyDomains == false) goto L69;
        sendBroadcast(pkgName);
        return;
    L69:
        return;
    L68:
        return;
    L58:
        th = move-exception;
        throw th;
    L49:
        sendBroadcast3 = sendBroadcast;
        goto L50
    L20:
        pkgState3 = new DomainVerificationPkgState(pkgName, domainSetId, hasAutoVerifyDomains);
        goto L21
    L5:
        DomainVerificationPkgState pkgState4 = this.mSettings.removeRestoredState(pkgName);
        if (pkgState4 != null) goto L8;
    L10:
        sendBroadcast = true;
        pkgState2 = pkgState4;
        goto L11
    L8:
        if (Objects.equals(pkgState4.getBackupSignatureHash(), PackageUtils.computeSignaturesSha256Digest(newPkgSetting.getSigningDetails().getSignatures())) == true) goto L10;
        sendBroadcast = true;
        pkgState2 = null;
        goto L11
    }

    private void applyPreVerifiedState(ArrayMap<String, Integer> stateMap, ArraySet<String> autoVerifyDomains, DomainSet preVerifiedDomains) {
        if (preVerifiedDomains != null) goto L4;
        return;
    L4:
        if (autoVerifyDomains.isEmpty() == true) goto L22;
        Iterator r0 = preVerifiedDomains.getDomains().iterator();
    L7:
        if (r0.hasNext() == false) goto L23;
        String preVerifiedDomain = (String) r0.next();
        if (autoVerifyDomains.contains(preVerifiedDomain) == false) goto L7;
        if (stateMap.containsKey(preVerifiedDomain) == true) goto L7;
        stateMap.put(preVerifiedDomain, 8);
        goto L7
    L23:
        return;
    }

    private boolean applyImmutableState(PackageStateInternal pkgSetting, ArrayMap<String, Integer> stateMap, ArraySet<String> autoVerifyDomains) {
        if (pkgSetting.isSystem() == true) goto L5;
    L11:
        int size = stateMap.size();
        int index = size - 1;
    L12:
        if (index < 0) goto L17;
        Integer state = stateMap.valueAt(index);
        if (state.intValue() != 7) goto L16;
        stateMap.removeAt(index);
    L16:
        index = index - 1;
        goto L12
    L17:
        return true;
    L5:
        if (this.mSystemConfig.getLinkedApps().contains(pkgSetting.getPackageName()) == false) goto L11;
        int domainsSize = autoVerifyDomains.size();
        int index2 = 0;
    L7:
        if (index2 >= domainsSize) goto L9;
        stateMap.put(autoVerifyDomains.valueAt(index2), 7);
        index2 = index2 + 1;
        goto L7
    L9:
        return false;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void writeSettings(final Computer snapshot, TypedXmlSerializer serializer, boolean includeSignatures, int userId) throws IOException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Function<String, String> pkgNameToSignature = null;
        if (includeSignatures == true) goto L15;
    L9:
        this.mSettings.writeSettings(serializer, this.mAttachedPkgStates, userId, pkgNameToSignature);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mLegacySettings.writeSettings(serializer);
        return;
    L7:
        th = move-exception;
        throw th;
    L15:
        pkgNameToSignature = new DomainVerificationService$$ExternalSyntheticLambda0(snapshot);     // Catch: Throwable -> L7
        goto L9
    }

    private static /* synthetic */ String lambda$writeSettings$1(Computer snapshot, String pkgName) {
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(pkgName);
        if (pkgSetting != null) goto L7;
        return null;
    L7:
        return PackageUtils.computeSignaturesSha256Digest(pkgSetting.getSigningDetails().getSignatures());
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void readSettings(Computer snapshot, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSettings.readSettings(parser, this.mAttachedPkgStates, snapshot);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void readLegacySettings(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        this.mLegacySettings.readSettings(parser);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void restoreSettings(Computer snapshot, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSettings.restoreSettings(parser, this.mAttachedPkgStates, snapshot);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void addLegacySetting(String packageName, IntentFilterVerificationInfo info) {
        this.mLegacySettings.add(packageName, info);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public boolean setLegacyUserState(String packageName, int userId, int state) {
        if (this.mEnforcer.callerIsLegacyUserSelector(this.mConnection.getCallingUid(), this.mConnection.getCallingUserId(), packageName, userId) == true) goto L6;
        return false;
    L6:
        this.mLegacySettings.add(packageName, userId, state);
        this.mConnection.scheduleWriteSettings();
        return true;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public int getLegacyState(String packageName, int userId) {
        if (this.mEnforcer.callerIsLegacyUserQuerent(this.mConnection.getCallingUid(), this.mConnection.getCallingUserId(), packageName, userId) == true) goto L7;
        return 0;
    L7:
        return this.mLegacySettings.getUserState(packageName, userId);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void clearPackage(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAttachedPkgStates.remove(packageName);     // Catch: Throwable -> L8
        this.mSettings.removePackage(packageName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mConnection.scheduleWriteSettings();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void clearPackageForUser(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L7
        if (pkgState == null) goto L9;
        pkgState.removeUser(userId);     // Catch: Throwable -> L7
    L9:
        this.mSettings.removePackageForUser(packageName, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mConnection.scheduleWriteSettings();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void clearUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int attachedSize = this.mAttachedPkgStates.size();     // Catch: Throwable -> L7
        int index = 0;
    L5:
        if (index >= attachedSize) goto L9;
        this.mAttachedPkgStates.valueAt(index).removeUser(userId);     // Catch: Throwable -> L7
        index = index + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mSettings.removeUser(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mConnection.scheduleWriteSettings();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public boolean runMessage(int messageCode, Object object) {
        return this.mProxy.runMessage(messageCode, object);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void printState(IndentingPrintWriter writer, String packageName, Integer userId) throws PackageManager.NameNotFoundException {
        printState(this.mConnection.snapshot(), writer, packageName, userId);
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public void printState(Computer snapshot, IndentingPrintWriter writer, String packageName, Integer userId) throws PackageManager.NameNotFoundException {
        this.mEnforcer.assertApprovedQuerent(this.mConnection.getCallingUid(), this.mProxy);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mDebug.printState(writer, packageName, userId, snapshot, this.mAttachedPkgStates);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void printOwnersForPackage(IndentingPrintWriter writer, String packageName, Integer userId) throws PackageManager.NameNotFoundException {
        this.mEnforcer.assertApprovedQuerent(this.mConnection.getCallingUid(), this.mProxy);
        Computer snapshot = this.mConnection.snapshot();
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (packageName != null) goto L15;
        int size = this.mAttachedPkgStates.size();     // Catch: Throwable -> L10
        int index = 0;
    L7:
        if (index >= size) goto L16;
        printOwnersForPackage(writer, this.mAttachedPkgStates.valueAt(index).getPackageName(), userId, snapshot);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12
    L13:
        index = index + 1;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L15:
        printOwnersForPackage(writer, packageName, userId, snapshot);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void printOwnersForPackage(IndentingPrintWriter writer, String packageName, Integer userId, Computer snapshot) throws PackageManager.NameNotFoundException {
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(packageName);
        if (pkgSetting != null) goto L5;
        AndroidPackage pkg = null;
    L6:
        if (pkg == null) goto L16;
        ArraySet<String> domains = this.mCollector.collectAllWebDomains(pkg);
        int size = domains.size();
        if (size != 0) goto L10;
        return;
    L10:
        writer.println(packageName + ":");
        writer.increaseIndent();
        int index = 0;
    L11:
        if (index >= size) goto L13;
        printOwnersForDomain(writer, domains.valueAt(index), userId, snapshot);
        index = index + 1;
        goto L11
    L13:
        writer.decreaseIndent();
        return;
    L16:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);
    L5:
        pkg = pkgSetting.getPkg();
        goto L6
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void printOwnersForDomains(IndentingPrintWriter writer, List<String> domains, Integer userId) {
        this.mEnforcer.assertApprovedQuerent(this.mConnection.getCallingUid(), this.mProxy);
        Computer snapshot = this.mConnection.snapshot();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int size = domains.size();     // Catch: Throwable -> L7
        int index = 0;
    L5:
        if (index >= size) goto L10;
        printOwnersForDomain(writer, domains.get(index), userId, snapshot);     // Catch: Throwable -> L7
        index = index + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void printOwnersForDomain(IndentingPrintWriter writer, String domain, Integer userId, Computer snapshot) {
        SparseArray<SparseArray<List<String>>> userIdToApprovalLevelToOwners = new SparseArray();
        if (userId != null) goto L5;
    L8:
        int[] r2 = this.mConnection.getAllUserIds();
        int r3 = r2.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L12;
        int aUserId = r2[r4];
        userIdToApprovalLevelToOwners.put(aUserId, getOwnersForDomainInternal(domain, true, aUserId, snapshot));
        r4 = r4 + 1;
    L12:
        this.mDebug.printOwners(writer, domain, userIdToApprovalLevelToOwners);
        return;
    L5:
        if (userId.intValue() == (-1)) goto L8;
        userIdToApprovalLevelToOwners.put(userId.intValue(), getOwnersForDomainInternal(domain, true, userId.intValue(), snapshot));
        goto L12
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public DomainVerificationShell getShell() {
        return this.mShell;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public DomainVerificationCollector getCollector() {
        return this.mCollector;
    }

    private void sendBroadcast(String packageName) {
        sendBroadcast(Collections.singleton(packageName));
    }

    private void sendBroadcast(Set<String> packageNames) {
        if (this.mCanSendBroadcasts == true) goto L5;
        return;
    L5:
        this.mProxy.sendBroadcastForPackages(packageNames);
    }

    private boolean hasRealVerifier() {
        return !(this.mProxy instanceof DomainVerificationProxyUnavailable);
    }

    private GetAttachedResult getAndValidateAttachedLocked(UUID domainSetId, Set<String> domains, boolean forAutoVerify, int callingUid, Integer userIdForFilter, Computer snapshot) throws PackageManager.NameNotFoundException {
        if (domainSetId == null) goto L34;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(domainSetId);
        if (pkgState == null) goto L6;
        String pkgName = pkgState.getPackageName();
        if (userIdForFilter != null) goto L10;
    L13:
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(pkgName);
        if (pkgSetting == null) goto L32;
        if (pkgSetting.getPkg() == null) goto L32;
        if (CollectionUtils.isEmpty(domains) == true) goto L30;
        AndroidPackage pkg = pkgSetting.getPkg();
        if (forAutoVerify == false) goto L22;
        ArraySet<String> declaredDomains = this.mCollector.collectValidAutoVerifyDomains(pkg);
    L24:
        if (domains.retainAll(declaredDomains) == false) goto L28;
        return GetAttachedResult.error(2);
    L28:
        return GetAttachedResult.success(pkgState);
    L22:
        declaredDomains = this.mCollector.collectAllWebDomains(pkg);
        goto L24
    L30:
        throw new IllegalArgumentException("Provided domain set cannot be empty");
    L32:
        throw DomainVerificationUtils.throwPackageUnavailable(pkgName);
    L10:
        if (this.mConnection.filterAppAccess(pkgName, callingUid, userIdForFilter.intValue()) == false) goto L13;
        return GetAttachedResult.error(1);
    L6:
        return GetAttachedResult.error(1);
    L34:
        throw new IllegalArgumentException("domainSetId cannot be null");
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void verifyPackages(List<String> packageNames, boolean reVerify) {
        this.mEnforcer.assertInternal(this.mConnection.getCallingUid());
        Set<String> packagesToBroadcast = new ArraySet();
        if (packageNames != null) goto L16;
        Object r1 = this.mLock;
        monitor-enter(r1);
        int pkgStatesSize = this.mAttachedPkgStates.size();     // Catch: Throwable -> L9
        int pkgStateIndex = 0;
    L7:
        if (pkgStateIndex >= pkgStatesSize) goto L12;
        addIfShouldBroadcastLocked(packagesToBroadcast, this.mAttachedPkgStates.valueAt(pkgStateIndex), reVerify);     // Catch: Throwable -> L9
        pkgStateIndex = pkgStateIndex + 1;     // Catch: Throwable -> L9
        goto L7
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L9
    L29:
        if (packagesToBroadcast.isEmpty() == true) goto L42;
        sendBroadcast(packagesToBroadcast);
        return;
    L42:
        return;
    L9:
        th = move-exception;
        throw th;
    L16:
        Object r2 = this.mLock;
        monitor-enter(r2);
        int size = packageNames.size();     // Catch: Throwable -> L23
        int index = 0;
    L19:
        if (index >= size) goto L27;
        String packageName = packageNames.get(index);     // Catch: Throwable -> L23
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L23
        if (pkgState == null) goto L25;
        addIfShouldBroadcastLocked(packagesToBroadcast, pkgState, reVerify);     // Catch: Throwable -> L23
    L25:
        index = index + 1;     // Catch: Throwable -> L23
        goto L19
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private void addIfShouldBroadcastLocked(Collection<String> packageNames, DomainVerificationPkgState pkgState, boolean reVerify) {
        if (reVerify == false) goto L6;
        if (pkgState.isHasAutoVerifyDomains() == false) goto L6;
    L7:
        packageNames.add(pkgState.getPackageName());
        return;
    L6:
        if (shouldReBroadcastPackage(pkgState) == true) goto L7;
    }

    private boolean shouldReBroadcastPackage(DomainVerificationPkgState pkgState) {
        if (pkgState.isHasAutoVerifyDomains() == true) goto L5;
        return false;
    L5:
        ArrayMap<String, Integer> stateMap = pkgState.getStateMap();
        int statesSize = stateMap.size();
        int stateIndex = 0;
    L6:
        if (stateIndex >= statesSize) goto L11;
        Integer state = stateMap.valueAt(stateIndex);
        if (DomainVerificationState.isDefault(state.intValue()) == false) goto L9;
        stateIndex = stateIndex + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void clearDomainVerificationState(List<String> packageNames) {
        this.mEnforcer.assertInternal(this.mConnection.getCallingUid());
        Computer snapshot = this.mConnection.snapshot();
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (packageNames != null) goto L17;
        int size = this.mAttachedPkgStates.size();     // Catch: Throwable -> L13
        int index = 0;
    L6:
        if (index >= size) goto L26;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.valueAt(index);     // Catch: Throwable -> L13
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(pkgState.getPackageName());     // Catch: Throwable -> L13
        if (pkgSetting == null) goto L15;
        if (pkgSetting.getPkg() == null) goto L15;
        resetDomainState(pkgState.getStateMap(), pkgSetting);     // Catch: Throwable -> L13
    L15:
        index = index + 1;     // Catch: Throwable -> L13
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L13
        this.mConnection.scheduleWriteSettings();
        return;
    L17:
        int size2 = packageNames.size();     // Catch: Throwable -> L13
        int index2 = 0;
    L18:
        if (index2 >= size2) goto L26;
        String pkgName = packageNames.get(index2);     // Catch: Throwable -> L13
        DomainVerificationPkgState pkgState2 = this.mAttachedPkgStates.get(pkgName);     // Catch: Throwable -> L13
        PackageStateInternal pkgSetting2 = snapshot.getPackageStateInternal(pkgName);     // Catch: Throwable -> L13
        if (pkgSetting2 == null) goto L25;
        if (pkgSetting2.getPkg() == null) goto L25;
        resetDomainState(pkgState2.getStateMap(), pkgSetting2);     // Catch: Throwable -> L13
    L25:
        index2 = index2 + 1;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void resetDomainState(ArrayMap<String, Integer> stateMap, PackageStateInternal pkgSetting) {
        int size = stateMap.size();
        int index = size - 1;
    L3:
        if (index < 0) goto L15;
        Integer state = stateMap.valueAt(index);
        switch(state.intValue()) {
            case 1: goto L11;
            case 5: goto L11;
            default: goto L7;
        };
    L11:
        boolean reset = true;
    L12:
        if (reset == false) goto L14;
        stateMap.removeAt(index);
    L14:
        index = index - 1;
        goto L3
    L7:
        if (state.intValue() < 1024) goto L9;
        reset = true;
        goto L12
    L9:
        reset = false;
        goto L12
    L15:
        applyImmutableState(pkgSetting, stateMap, this.mCollector.collectValidAutoVerifyDomains(pkgSetting.getPkg()));
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationShell.Callback
    public void clearUserStates(List<String> packageNames, int userId) {
        this.mEnforcer.assertInternal(this.mConnection.getCallingUid());
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (packageNames != null) goto L16;
        int size = this.mAttachedPkgStates.size();     // Catch: Throwable -> L11
        int index = 0;
    L7:
        if (index >= size) goto L23;
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.valueAt(index);     // Catch: Throwable -> L11
        if (userId != (-1)) goto L13;
        pkgState.removeAllUsers();     // Catch: Throwable -> L11
    L14:
        index = index + 1;     // Catch: Throwable -> L11
        goto L7
    L13:
        pkgState.removeUser(userId);     // Catch: Throwable -> L11
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mConnection.scheduleWriteSettings();
        return;
    L16:
        int size2 = packageNames.size();     // Catch: Throwable -> L11
        int index2 = 0;
    L17:
        if (index2 >= size2) goto L23;
        String pkgName = packageNames.get(index2);     // Catch: Throwable -> L11
        DomainVerificationPkgState pkgState2 = this.mAttachedPkgStates.get(pkgName);     // Catch: Throwable -> L11
        if (userId != (-1)) goto L21;
        pkgState2.removeAllUsers();     // Catch: Throwable -> L11
    L22:
        index2 = index2 + 1;     // Catch: Throwable -> L11
        goto L17
    L21:
        pkgState2.removeUser(userId);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public Pair<List<ResolveInfo>, Integer> filterToApprovedApp(Intent intent, List<ResolveInfo> infos, int userId, Function<String, PackageStateInternal> pkgSettingFunction) {
        ArrayMap<ResolveInfo, Integer> infoApprovals = new ArrayMap();
        int infosSize = infos.size();
        int index = 0;
    L3:
        if (index >= infosSize) goto L8;
        ResolveInfo info = infos.get(index);
        if (info.isAutoResolutionAllowed() == false) goto L7;
        infoApprovals.put(info, null);
    L7:
        index = index + 1;
        goto L3
    L8:
        int highestApproval = fillMapWithApprovalLevels(infoApprovals, intent.getData(), userId, pkgSettingFunction);
        if (highestApproval <= 0) goto L11;
        int index2 = infoApprovals.size() - 1;
    L13:
        if (index2 < 0) goto L19;
        if (infoApprovals.valueAt(index2).intValue() == highestApproval) goto L17;
        infoApprovals.removeAt(index2);
    L17:
        index2 = index2 - 1;
        goto L13
    L19:
        if (highestApproval == 1) goto L21;
        filterToLastFirstInstalled(infoApprovals, pkgSettingFunction);
    L21:
        int size = infoApprovals.size();
        List<ResolveInfo> finalList = new ArrayList(size);
        int index3 = 0;
    L22:
        if (index3 >= size) goto L25;
        finalList.add(infoApprovals.keyAt(index3));
        index3 = index3 + 1;
        goto L22
    L25:
        if (highestApproval == 1) goto L28;
        filterToLastDeclared(finalList, pkgSettingFunction);
    L28:
        return Pair.create(finalList, Integer.valueOf(highestApproval));
    L11:
        return Pair.create(Collections.emptyList(), Integer.valueOf(highestApproval));
    }

    private boolean matchUriRelativeFilterGroups(Uri uri, String pkgName) {
        if (uri.getHost() != null) goto L6;
        return false;
    L6:
        List<UriRelativeFilterGroup> groups = getUriRelativeFilterGroups(pkgName, uri.getHost());
        if (groups.isEmpty() == false) goto L11;
        return true;
    L11:
        return UriRelativeFilterGroup.matchGroupsToUri(groups, uri);
    }

    private int fillMapWithApprovalLevels(ArrayMap<ResolveInfo, Integer> inputMap, Uri uri, int userId, Function<String, PackageStateInternal> pkgSettingFunction) {
        int highestApproval = 0;
        int size = inputMap.size();
        int index = 0;
    L3:
        if (index >= size) goto L17;
        if (inputMap.valueAt(index) != null) goto L15;
        ResolveInfo info = inputMap.keyAt(index);
        String packageName = info.getComponentInfo().packageName;
        PackageStateInternal pkgSetting = pkgSettingFunction.apply(packageName);
        if (pkgSetting == null) goto L14;
        if (matchUriRelativeFilterGroups(uri, packageName) == false) goto L14;
        int approval = approvalLevelForDomain(pkgSetting, uri.getHost(), false, userId, false, uri.getHost());
        highestApproval = Math.max(highestApproval, approval);
        fillInfoMapForSamePackage(inputMap, packageName, approval);
    L14:
        fillInfoMapForSamePackage(inputMap, packageName, 0);
    L15:
        index = index + 1;
        goto L3
    L17:
        return highestApproval;
    }

    private void fillInfoMapForSamePackage(ArrayMap<ResolveInfo, Integer> inputMap, String targetPackageName, int level) {
        int size = inputMap.size();
        int index = 0;
    L3:
        if (index >= size) goto L9;
        String packageName = inputMap.keyAt(index).getComponentInfo().packageName;
        if (Objects.equals(targetPackageName, packageName) == false) goto L7;
        inputMap.setValueAt(index, Integer.valueOf(level));
    L7:
        index = index + 1;
        goto L3
    }

    private void filterToLastFirstInstalled(ArrayMap<ResolveInfo, Integer> inputMap, Function<String, PackageStateInternal> pkgSettingFunction) {
        String targetPackageName = null;
        long latestInstall = Long.MIN_VALUE;
        int size = inputMap.size();
        int index = 0;
    L3:
        if (index >= size) goto L11;
        ResolveInfo info = inputMap.keyAt(index);
        String packageName = info.getComponentInfo().packageName;
        PackageStateInternal pkgSetting = pkgSettingFunction.apply(packageName);
        if (pkgSetting == null) goto L10;
        long installTime = PackageStateUtils.getEarliestFirstInstallTime(pkgSetting.getUserStates());
        if (installTime <= latestInstall) goto L10;
        latestInstall = installTime;
        targetPackageName = packageName;
    L10:
        index = index + 1;
        goto L3
    L11:
        int index2 = inputMap.size();
        int index3 = index2 - 1;
    L12:
        if (index3 < 0) goto L18;
        ResolveInfo info2 = inputMap.keyAt(index3);
        if (Objects.equals(targetPackageName, info2.getComponentInfo().packageName) == true) goto L16;
        inputMap.removeAt(index3);
    L16:
        index3 = index3 - 1;
        goto L12
    }

    private void filterToLastDeclared(List<ResolveInfo> inputList, Function<String, PackageStateInternal> pkgSettingFunction) {
        int index = 0;
    L4:
        if (index >= inputList.size()) goto L25;
        ResolveInfo info = inputList.get(index);
        String targetPackageName = info.getComponentInfo().packageName;
        PackageStateInternal pkgSetting = pkgSettingFunction.apply(targetPackageName);
        if (pkgSetting != null) goto L8;
        AndroidPackage pkg = null;
    L9:
        if (pkg == null) goto L23;
        ResolveInfo result = info;
        int highestIndex = indexOfIntentFilterEntry(pkg, result);
        int searchIndex = inputList.size();
    L12:
        searchIndex = searchIndex - 1;
        if (searchIndex < (index + 1)) goto L22;
        ResolveInfo searchInfo = inputList.get(searchIndex);
        if (Objects.equals(targetPackageName, searchInfo.getComponentInfo().packageName) == false) goto L12;
        int entryIndex = indexOfIntentFilterEntry(pkg, searchInfo);
        if (entryIndex <= highestIndex) goto L20;
        highestIndex = entryIndex;
        result = searchInfo;
    L20:
        inputList.remove(searchIndex);
        goto L12
    L22:
        inputList.set(index, result);
    L23:
        index = index + 1;
        goto L4
    L8:
        pkg = pkgSetting.getPkg();
        goto L9
    }

    private int indexOfIntentFilterEntry(AndroidPackage pkg, ResolveInfo target) {
        List<ParsedActivity> activities = pkg.getActivities();
        int activitiesSize = activities.size();
        int activityIndex = 0;
    L3:
        if (activityIndex >= activitiesSize) goto L8;
        if (Objects.equals(activities.get(activityIndex).getComponentName(), target.getComponentInfo().getComponentName()) == true) goto L6;
        activityIndex = activityIndex + 1;
        goto L3
    L6:
        return activityIndex;
    L8:
        return -1;
    }

    @Override // com.android.server.pm.verify.domain.DomainVerificationManagerInternal
    public int approvalLevelForDomain(PackageStateInternal pkgSetting, Intent intent, long resolveInfoFlags, int userId) {
        String packageName = pkgSetting.getPackageName();
        if ((intent.getFlags() & 8) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean debug = r0;
        if (DomainVerificationUtils.isDomainVerificationIntent(intent, resolveInfoFlags) == true) goto L11;
        if (debug == false) goto L10;
        debugApproval(packageName, intent, userId, false, "not valid intent");
    L10:
        return 0;
    L11:
        int approvalLevel = approvalLevelForDomain(pkgSetting, intent.getData().getHost(), false, userId, debug, intent);
        if (debug == false) goto L14;
        Slog.d("DomainVerificationServiceApproval", "Final approval level for " + pkgSetting.getPackageName() + " for host " + intent.getData().getHost() + " is " + approvalLevel);
    L14:
        return approvalLevel;
    L5:
        r0 = false;
        goto L6
    }

    private int approvalLevelForDomain(PackageStateInternal pkgSetting, String host, boolean includeNegative, int userId, boolean debug, Object debugObject) {
        int approvalLevel = approvalLevelForDomainInternal(pkgSetting, host, includeNegative, userId, debug, debugObject);
        if (includeNegative == false) goto L19;
        if (approvalLevel != 0) goto L19;
        PackageUserStateInternal pkgUserState = pkgSetting.getUserStateOrDefault(userId);
        if (pkgUserState.isInstalled() == true) goto L9;
        return -4;
    L9:
        AndroidPackageInternal r3 = pkgSetting.getPkg();
        if (r3 == null) goto L19;
        if (PackageUserStateUtils.isPackageEnabled(pkgUserState, r3) == true) goto L16;
        return -3;
    L16:
        if (this.mCollector.containsAutoVerifyDomain(pkgSetting.getPkg(), host) == false) goto L19;
        return -1;
    L19:
        return approvalLevel;
    }

    private int approvalLevelForDomainInternal(PackageStateInternal pkgSetting, String host, boolean includeNegative, int userId, boolean debug, Object debugObject) {
        String packageName = pkgSetting.getPackageName();
        AndroidPackage pkg = pkgSetting.getPkg();
        if (pkg == null) goto L12;
        if (includeNegative == false) goto L12;
        if (this.mCollector.containsWebDomain(pkg, host) == true) goto L12;
        if (debug == false) goto L10;
        debugApproval(packageName, debugObject, userId, false, "domain not declared");
        return -2;
    L10:
        return -2;
    L12:
        PackageUserStateInternal pkgUserState = pkgSetting.getUserStates().get(userId);
        int stateMapSize = 0;
        if (pkgUserState != null) goto L18;
        if (debug == false) goto L16;
        debugApproval(packageName, debugObject, userId, false, "PackageUserState unavailable");
    L16:
        return 0;
    L18:
        if (pkgUserState.isInstalled() == true) goto L23;
        if (debug == false) goto L21;
        debugApproval(packageName, debugObject, userId, false, "package not installed for user");
    L21:
        return 0;
    L23:
        if (PackageUserStateUtils.isPackageEnabled(pkgUserState, pkg) == true) goto L28;
        if (debug == false) goto L26;
        debugApproval(packageName, debugObject, userId, false, "package not enabled for user");
    L26:
        return 0;
    L28:
        if (pkgUserState.isSuspended() == false) goto L34;
        if (debug == false) goto L32;
        debugApproval(packageName, debugObject, userId, false, "package suspended for user");
    L32:
        return 0;
    L34:
        if (pkg != null) goto L36;
    L44:
        Object r10 = this.mLock;
        monitor-enter(r10);
        DomainVerificationPkgState pkgState = this.mAttachedPkgStates.get(packageName);     // Catch: Throwable -> L50
        if (pkgState != null) goto L54;
        if (debug == false) goto L52;
        debugApproval(packageName, debugObject, userId, false, "pkgState unavailable");     // Catch: Throwable -> L50
    L52:
        monitor-exit(r10);     // Catch: Throwable -> L50
        return 0;
    L54:
        DomainVerificationInternalUserState userState = pkgState.getUserState(userId);     // Catch: Throwable -> L50
        if (userState == null) goto L69;
        if (userState.isLinkHandlingAllowed() == true) goto L69;
        if (debug == false) goto L66;
        debugApproval(packageName, debugObject, userId, false, "link handling not allowed");     // Catch: Throwable -> L50
    L66:
        monitor-exit(r10);     // Catch: Throwable -> L50
        return 0;
    L63:
        th = th;
    L141:
        monitor-exit(r10);     // Catch: Throwable -> L78
        throw th;
    L69:
        if (pkg == null) goto L81;
        if (pkgSetting.getUserStateOrDefault(userId).isInstantApp() == false) goto L81;
        if (this.mCollector.collectValidAutoVerifyDomains(pkg).contains(host) == false) goto L81;
        monitor-exit(r10);     // Catch: Throwable -> L78
        return 5;
    L81:
        ArrayMap<String, Integer> stateMap = pkgState.getStateMap();     // Catch: Throwable -> L78
        Integer state = stateMap.get(host);     // Catch: Throwable -> L78
        if (state != null) goto L84;
    L89:
        int stateMapSize2 = stateMap.size();     // Catch: Throwable -> L78
        int index = 0;
    L90:
        if (index >= stateMapSize2) goto L109;
        if (DomainVerificationState.isVerified(stateMap.valueAt(index).intValue()) == true) goto L94;
        int r17 = stateMapSize;
    L108:
        index = index + 1;     // Catch: Throwable -> L78
        stateMapSize2 = stateMapSize2;
        stateMapSize = r17;
        goto L90
    L94:
        String domain = stateMap.keyAt(index);     // Catch: Throwable -> L78
        r17 = stateMapSize;
        if (domain.startsWith("*.") == false) goto L108;
        if (host.endsWith(domain.substring(1)) == true) goto L102;
        if (host.equals(domain.substring(2)) == false) goto L108;
    L102:
        if (debug == false) goto L105;
        debugApproval(packageName, debugObject, userId, true, "host verified by wildcard");     // Catch: Throwable -> L78
    L105:
        monitor-exit(r10);     // Catch: Throwable -> L78
        return 4;
    L109:
        int r18 = stateMapSize;
        int stateMapSize3 = stateMapSize2;
        if (userState != null) goto L115;
        if (debug == false) goto L113;
        debugApproval(packageName, debugObject, userId, false, "userState unavailable");     // Catch: Throwable -> L78
    L113:
        monitor-exit(r10);     // Catch: Throwable -> L78
        return r18;
    L115:
        ArraySet<String> enabledHosts = userState.getEnabledHosts();     // Catch: Throwable -> L78
        if (enabledHosts.contains(host) == false) goto L122;
        if (debug == false) goto L120;
        debugApproval(packageName, debugObject, userId, true, "host enabled by user exactly");     // Catch: Throwable -> L78
    L120:
        monitor-exit(r10);     // Catch: Throwable -> L78
        return 3;
    L122:
        ArraySet<String> enabledHosts2 = enabledHosts;
        int enabledHostsSize = enabledHosts2.size();     // Catch: Throwable -> L78
        int index2 = 0;
    L123:
        if (index2 >= enabledHostsSize) goto L137;
        ArraySet<String> enabledHosts3 = enabledHosts2;
        String domain2 = enabledHosts3.valueAt(index2);     // Catch: Throwable -> L78
        if (domain2.startsWith("*.") == false) goto L135;
        if (host.endsWith(domain2.substring(2)) == false) goto L135;
        if (debug == false) goto L131;
        debugApproval(packageName, debugObject, userId, true, "host enabled by user through wildcard");     // Catch: Throwable -> L78
    L131:
        monitor-exit(r10);     // Catch: Throwable -> L78
        return 3;
    L135:
        index2 = index2 + 1;     // Catch: Throwable -> L78
        enabledHosts2 = enabledHosts3;
        stateMapSize3 = stateMapSize3;
        enabledHostsSize = enabledHostsSize;
        goto L123
    L137:
        if (debug == false) goto L139;
        debugApproval(packageName, debugObject, userId, false, "not approved");     // Catch: Throwable -> L78
    L139:
        monitor-exit(r10);     // Catch: Throwable -> L78
        return r18;
    L84:
        if (DomainVerificationState.isVerified(state.intValue()) == false) goto L89;
        if (debug == false) goto L87;
        debugApproval(packageName, debugObject, userId, true, "host verified exactly");     // Catch: Throwable -> L78
    L87:
        monitor-exit(r10);     // Catch: Throwable -> L78
        return 4;
    L78:
        th = th;
    L50:
        th = th;
        goto L141
    L36:
        if (DomainVerificationUtils.isChangeEnabled(this.mPlatformCompat, pkg, SETTINGS_API_V2) == true) goto L44;
        switch(this.mLegacySettings.getUserState(packageName, userId)) {
            case 0: goto L44;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L42;
            default: goto L44;
        };
    L40:
        return 0;
    L41:
        return 2;
    L42:
        return 1;
    }

    private Pair<List<String>, Integer> getApprovedPackagesLocked(String domain, int userId, int minimumApproval, Computer snapshot) {
        DomainVerificationService r0 = this;
        if (minimumApproval >= 0) goto L5;
        boolean includeNegative = true;
    L6:
        List<String> approvedPackages = Collections.emptyList();
        int size = r0.mAttachedPkgStates.size();
        int highestApproval = minimumApproval;
        List<String> approvedPackages2 = approvedPackages;
        int index = 0;
    L7:
        if (index >= size) goto L20;
        DomainVerificationPkgState pkgState = r0.mAttachedPkgStates.valueAt(index);
        String packageName = pkgState.getPackageName();
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(packageName);
        if (pkgSetting == null) goto L18;
        int level = r0.approvalLevelForDomain(pkgSetting, domain, includeNegative, userId, false, domain);
        if (level < minimumApproval) goto L18;
        if (level <= highestApproval) goto L16;
        approvedPackages2.clear();
        approvedPackages2 = CollectionUtils.add(approvedPackages2, packageName);
        highestApproval = level;
        goto L18
    L16:
        if (level != highestApproval) goto L18;
        approvedPackages2 = CollectionUtils.add(approvedPackages2, packageName);
    L18:
        index = index + 1;
        r0 = this;
        goto L7
    L20:
        if (approvedPackages2.isEmpty() == true) goto L22;
        List<String> filteredPackages = new ArrayList();
        long latestInstall = Long.MIN_VALUE;
        int approvedSize = approvedPackages2.size();
        int index2 = 0;
    L24:
        if (index2 >= approvedSize) goto L36;
        String packageName2 = approvedPackages2.get(index2);
        PackageStateInternal pkgSetting2 = snapshot.getPackageStateInternal(packageName2);
        if (pkgSetting2 == null) goto L34;
        long installTime = pkgSetting2.getUserStateOrDefault(userId).getFirstInstallTimeMillis();
        if (installTime <= latestInstall) goto L32;
        latestInstall = installTime;
        filteredPackages.clear();
        filteredPackages.add(packageName2);
        goto L34
    L32:
        if (installTime != latestInstall) goto L34;
        filteredPackages.add(packageName2);
    L34:
        index2 = index2 + 1;
        goto L24
    L36:
        return Pair.create(filteredPackages, Integer.valueOf(highestApproval));
    L22:
        return Pair.create(approvedPackages2, 0);
    L5:
        includeNegative = false;
        goto L6
    }

    private void debugApproval(String packageName, Object debugObject, int userId, boolean approved, String reason) {
        if (approved == false) goto L4;
        String approvalString = "approved";
    L5:
        Slog.d("DomainVerificationServiceApproval", packageName + " was " + approvalString + " for " + debugObject + " for user " + userId + ": " + reason);
        return;
    L4:
        approvalString = "denied";
        goto L5
    }
}
