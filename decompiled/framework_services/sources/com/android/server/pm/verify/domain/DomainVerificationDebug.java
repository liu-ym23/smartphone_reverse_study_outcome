package com.android.server.pm.verify.domain;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.verify.domain.DomainVerificationState;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.PackageUtils;
import android.util.SparseArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.CollectionUtils;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.pm.Computer;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.verify.domain.models.DomainVerificationInternalUserState;
import com.android.server.pm.verify.domain.models.DomainVerificationPkgState;
import com.android.server.pm.verify.domain.models.DomainVerificationStateMap;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationDebug {
    public static final boolean DEBUG_ALL = false;
    public static final boolean DEBUG_ANY = false;
    public static final boolean DEBUG_APPROVAL = false;
    public static final boolean DEBUG_BROADCASTS = false;
    public static final boolean DEBUG_PROXIES = false;
    private final DomainVerificationCollector mCollector;

    DomainVerificationDebug(DomainVerificationCollector collector) {
        this.mCollector = collector;
    }

    public void printState(IndentingPrintWriter writer, String packageName, Integer userId, Computer snapshot, DomainVerificationStateMap<DomainVerificationPkgState> stateMap) throws PackageManager.NameNotFoundException {
        ArrayMap<String, Integer> reusedMap = new ArrayMap();
        ArraySet<String> reusedSet = new ArraySet();
        if (packageName != null) goto L15;
        int size = stateMap.size();
        int index = 0;
    L5:
        if (index >= size) goto L31;
        DomainVerificationPkgState pkgState = stateMap.valueAt(index);
        String pkgName = pkgState.getPackageName();
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(pkgName);
        if (pkgSetting == null) goto L13;
        if (pkgSetting.getPkg() == null) goto L13;
        boolean wasHeaderPrinted = printState(writer, pkgState, pkgSetting.getPkg(), reusedMap, false);
        printState(writer, pkgState, pkgSetting.getPkg(), userId, reusedSet, wasHeaderPrinted);
    L13:
        index = index + 1;
        goto L5
    L31:
        return;
    L15:
        DomainVerificationPkgState pkgState2 = stateMap.get(packageName);
        if (pkgState2 == null) goto L26;
        PackageStateInternal pkgSetting2 = snapshot.getPackageStateInternal(packageName);
        if (pkgSetting2 == null) goto L24;
        if (pkgSetting2.getPkg() == null) goto L24;
        AndroidPackageInternal r12 = pkgSetting2.getPkg();
        printState(writer, pkgState2, r12, reusedMap, false);
        printState(writer, pkgState2, r12, userId, reusedSet, true);
        return;
    L24:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);
    L26:
        throw DomainVerificationUtils.throwPackageUnavailable(packageName);
    }

    public void printOwners(IndentingPrintWriter writer, String domain, SparseArray<SparseArray<List<String>>> userIdToApprovalLevelToOwners) {
        SparseArray<SparseArray<List<String>>> r1 = userIdToApprovalLevelToOwners;
        writer.println(domain + ":");
        writer.increaseIndent();
        if (r1.size() != 0) goto L6;
        writer.println("none");
        writer.decreaseIndent();
        return;
    L6:
        int usersSize = r1.size();
        int userIndex = 0;
    L7:
        if (userIndex >= usersSize) goto L30;
        int userId = r1.keyAt(userIndex);
        SparseArray<List<String>> approvalLevelToOwners = r1.valueAt(userIndex);
        if (approvalLevelToOwners.size() == 0) goto L29;
        boolean printedUserHeader = false;
        int approvalsSize = approvalLevelToOwners.size();
        int approvalIndex = 0;
    L12:
        if (approvalIndex >= approvalsSize) goto L27;
        int approvalLevel = approvalLevelToOwners.keyAt(approvalIndex);
        if (approvalLevel < (-1)) goto L25;
        if (printedUserHeader == true) goto L18;
        writer.println("User " + userId + ":");
        writer.increaseIndent();
        printedUserHeader = true;
    L18:
        String approvalString = DomainVerificationManagerInternal.approvalLevelToDebugString(approvalLevel);
        List<String> owners = approvalLevelToOwners.valueAt(approvalIndex);
        writer.println(approvalString + "[" + approvalLevel + "]:");
        writer.increaseIndent();
        if (owners.size() != 0) goto L21;
        writer.println("none");
        writer.decreaseIndent();
        goto L25
    L21:
        int ownersSize = owners.size();
        int ownersIndex = 0;
    L22:
        if (ownersIndex >= ownersSize) goto L24;
        writer.println(owners.get(ownersIndex));
        ownersIndex = ownersIndex + 1;
        ownersSize = ownersSize;
        goto L22
    L24:
        writer.decreaseIndent();
    L25:
        approvalIndex = approvalIndex + 1;
        goto L12
    L27:
        if (printedUserHeader == false) goto L29;
        writer.decreaseIndent();
    L29:
        userIndex = userIndex + 1;
        r1 = userIdToApprovalLevelToOwners;
        goto L7
    L30:
        writer.decreaseIndent();
    }

    boolean printState(IndentingPrintWriter writer, DomainVerificationPkgState pkgState, AndroidPackage pkg, ArrayMap<String, Integer> reusedMap, boolean wasHeaderPrinted) {
        reusedMap.clear();
        reusedMap.putAll(pkgState.getStateMap());
        ArraySet<String> declaredDomains = this.mCollector.collectValidAutoVerifyDomains(pkg);
        int declaredSize = declaredDomains.size();
        int declaredIndex = 0;
    L3:
        if (declaredIndex >= declaredSize) goto L5;
        String domain = declaredDomains.valueAt(declaredIndex);
        reusedMap.putIfAbsent(domain, 0);
        declaredIndex = declaredIndex + 1;
        goto L3
    L5:
        boolean printedHeader = false;
        if (reusedMap.isEmpty() == true) goto L23;
        if (wasHeaderPrinted == true) goto L13;
        Signature[] signatures = pkg.getSigningDetails().getSignatures();
        if (signatures != null) goto L11;
        String signaturesDigest = null;
    L12:
        writer.println(pkgState.getPackageName() + ":");
        writer.increaseIndent();
        writer.println("ID: " + pkgState.getId());
        writer.println("Signatures: " + signaturesDigest);
        writer.decreaseIndent();
        printedHeader = true;
        goto L13
    L11:
        signaturesDigest = Arrays.toString(PackageUtils.computeSignaturesSha256Digests(pkg.getSigningDetails().getSignatures(), ":"));
    L13:
        writer.increaseIndent();
        ArraySet<String> invalidDomains = this.mCollector.collectInvalidAutoVerifyDomains(pkg);
        if (invalidDomains.isEmpty() == true) goto L19;
        writer.println("Invalid autoVerify domains:");
        writer.increaseIndent();
        int size = invalidDomains.size();
        int index = 0;
    L16:
        if (index >= size) goto L18;
        writer.println(invalidDomains.valueAt(index));
        index = index + 1;
        goto L16
    L18:
        writer.decreaseIndent();
    L19:
        writer.println("Domain verification state:");
        writer.increaseIndent();
        int stateSize = reusedMap.size();
        int stateIndex = 0;
    L20:
        if (stateIndex >= stateSize) goto L22;
        String domain2 = reusedMap.keyAt(stateIndex);
        Integer state = reusedMap.valueAt(stateIndex);
        writer.print(domain2);
        writer.print(": ");
        writer.println(DomainVerificationState.stateToDebugString(state.intValue()));
        stateIndex = stateIndex + 1;
        goto L20
    L22:
        writer.decreaseIndent();
        writer.decreaseIndent();
    L23:
        return printedHeader;
    }

    void printState(IndentingPrintWriter writer, DomainVerificationPkgState pkgState, AndroidPackage pkg, Integer userId, ArraySet<String> reusedSet, boolean wasHeaderPrinted) {
        if (userId != null) goto L4;
        return;
    L4:
        ArraySet<String> allWebDomains = this.mCollector.collectAllWebDomains(pkg);
        SparseArray<DomainVerificationInternalUserState> userStates = pkgState.getUserStates();
        if (userId.intValue() != (-1)) goto L13;
        int size = userStates.size();
        if (size != 0) goto L9;
        printState(writer, pkgState, userId.intValue(), null, reusedSet, allWebDomains, wasHeaderPrinted);
        return;
    L9:
        int index = 0;
    L10:
        if (index >= size) goto L17;
        DomainVerificationInternalUserState userState = userStates.valueAt(index);
        printState(writer, pkgState, userState.getUserId(), userState, reusedSet, allWebDomains, wasHeaderPrinted);
        index = index + 1;
        goto L10
    L17:
        return;
    L13:
        printState(writer, pkgState, userId.intValue(), userStates.get(userId.intValue()), reusedSet, allWebDomains, wasHeaderPrinted);
    }

    boolean printState(IndentingPrintWriter writer, DomainVerificationPkgState pkgState, int userId, DomainVerificationInternalUserState userState, ArraySet<String> reusedSet, ArraySet<String> allWebDomains, boolean wasHeaderPrinted) {
        reusedSet.clear();
        reusedSet.addAll(allWebDomains);
        if (userState == null) goto L5;
        reusedSet.removeAll(userState.getEnabledHosts());
    L5:
        boolean printedHeader = false;
        if (userState != null) goto L8;
        ArraySet<String> enabledHosts = null;
    L9:
        int enabledSize = CollectionUtils.size(enabledHosts);
        int disabledSize = reusedSet.size();
        if (enabledSize > 0) goto L13;
        if (disabledSize > 0) goto L13;
    L37:
        return printedHeader;
    L13:
        if (wasHeaderPrinted == true) goto L15;
        writer.println(pkgState.getPackageName() + " " + pkgState.getId() + ":");
        printedHeader = true;
    L15:
        if (userState != null) goto L17;
    L20:
        boolean isLinkHandlingAllowed = true;
    L21:
        writer.increaseIndent();
        writer.print("User ");
        if (userId != (-1)) goto L24;
        Object r6 = IZswContentProviderHelper.DUMP_ALL;
    L25:
        writer.print(r6);
        writer.println(":");
        writer.increaseIndent();
        writer.print("Verification link handling allowed: ");
        writer.println(isLinkHandlingAllowed);
        writer.println("Selection state:");
        writer.increaseIndent();
        if (enabledSize <= 0) goto L31;
        writer.println("Enabled:");
        writer.increaseIndent();
        int enabledIndex = 0;
    L28:
        if (enabledIndex >= enabledSize) goto L30;
        writer.println(enabledHosts.valueAt(enabledIndex));
        enabledIndex = enabledIndex + 1;
        goto L28
    L30:
        writer.decreaseIndent();
    L31:
        if (disabledSize <= 0) goto L36;
        writer.println("Disabled:");
        writer.increaseIndent();
        int disabledIndex = 0;
    L33:
        if (disabledIndex >= disabledSize) goto L35;
        writer.println(reusedSet.valueAt(disabledIndex));
        disabledIndex = disabledIndex + 1;
        goto L33
    L35:
        writer.decreaseIndent();
    L36:
        writer.decreaseIndent();
        writer.decreaseIndent();
        writer.decreaseIndent();
        goto L37
    L24:
        r6 = Integer.valueOf(userId);
        goto L25
    L17:
        if (userState.isLinkHandlingAllowed() == true) goto L20;
        isLinkHandlingAllowed = false;
        goto L21
    L8:
        enabledHosts = userState.getEnabledHosts();
        goto L9
    }
}
