package com.android.server.pm.verify.domain;

import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.SparseArray;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.Computer;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.verify.domain.models.DomainVerificationInternalUserState;
import com.android.server.pm.verify.domain.models.DomainVerificationPkgState;
import com.android.server.pm.verify.domain.models.DomainVerificationStateMap;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.function.Function;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class DomainVerificationSettings {
    private final DomainVerificationCollector mCollector;
    private final Object mLock;
    private final ArrayMap<String, DomainVerificationPkgState> mPendingPkgStates;
    private final ArrayMap<String, DomainVerificationPkgState> mRestoredPkgStates;

    public DomainVerificationSettings(DomainVerificationCollector collector) {
        this.mPendingPkgStates = new ArrayMap();
        this.mRestoredPkgStates = new ArrayMap();
        this.mLock = new Object();
        this.mCollector = collector;
    }

    public void writeSettings(TypedXmlSerializer xmlSerializer, DomainVerificationStateMap<DomainVerificationPkgState> liveState, Function<String, String> pkgSignatureFunction) {
    }

    public void writeSettings(TypedXmlSerializer xmlSerializer, DomainVerificationStateMap<DomainVerificationPkgState> liveState, int userId, Function<String, String> pkgSignatureFunction) throws IOException {
        Object r1 = this.mLock;
        monitor-enter(r1);
        DomainVerificationPersistence.writeToXml(xmlSerializer, liveState, this.mPendingPkgStates, this.mRestoredPkgStates, userId, pkgSignatureFunction);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void readSettings(TypedXmlPullParser parser, DomainVerificationStateMap<DomainVerificationPkgState> liveState, Computer snapshot) throws IOException, XmlPullParserException {
        DomainVerificationPersistence.ReadResult result = DomainVerificationPersistence.readFromXml(parser);
        ArrayMap<String, DomainVerificationPkgState> active = result.active;
        ArrayMap<String, DomainVerificationPkgState> restored = result.restored;
        Object r3 = this.mLock;
        monitor-enter(r3);
        int activeSize = active.size();     // Catch: Throwable -> L11
        int activeIndex = 0;
    L5:
        if (activeIndex >= activeSize) goto L15;
        DomainVerificationPkgState pkgState = active.valueAt(activeIndex);     // Catch: Throwable -> L11
        String pkgName = pkgState.getPackageName();     // Catch: Throwable -> L11
        DomainVerificationPkgState existingState = liveState.get(pkgName);     // Catch: Throwable -> L11
        if (existingState != null) goto L9;
        this.mPendingPkgStates.put(pkgName, pkgState);     // Catch: Throwable -> L11
    L14:
        activeIndex = activeIndex + 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        if (existingState.getId().equals(pkgState.getId()) == true) goto L14;
        mergePkgState(existingState, pkgState, snapshot);     // Catch: Throwable -> L11
        goto L14
    L15:
        int restoredSize = restored.size();     // Catch: Throwable -> L11
        int restoredIndex = 0;
    L16:
        if (restoredIndex >= restoredSize) goto L19;
        DomainVerificationPkgState pkgState2 = restored.valueAt(restoredIndex);     // Catch: Throwable -> L11
        this.mRestoredPkgStates.put(pkgState2.getPackageName(), pkgState2);     // Catch: Throwable -> L11
        restoredIndex = restoredIndex + 1;     // Catch: Throwable -> L11
        goto L16
    L19:
        monitor-exit(r3);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void restoreSettings(TypedXmlPullParser parser, DomainVerificationStateMap<DomainVerificationPkgState> liveState, Computer snapshot) throws IOException, XmlPullParserException {
        DomainVerificationPersistence.ReadResult result = DomainVerificationPersistence.readFromXml(parser);
        ArrayMap<String, DomainVerificationPkgState> stateList = result.restored;
        stateList.putAll(result.active);
        Object r4 = this.mLock;
        monitor-enter(r4);
        int stateIndex = 0;
    L45:
    L36:
        th = th;
    L41:
        monitor-exit(r4);     // Catch: Throwable -> L20
        throw th;
    L6:
        if (stateIndex >= stateList.size()) goto L39;
        DomainVerificationPkgState newState = stateList.valueAt(stateIndex);     // Catch: Throwable -> L36
        String pkgName = newState.getPackageName();     // Catch: Throwable -> L36
        DomainVerificationPkgState existingState = liveState.get(pkgName);     // Catch: Throwable -> L12
        if (existingState != null) goto L14;
        existingState = this.mPendingPkgStates.get(pkgName);     // Catch: Throwable -> L12
    L14:
        if (existingState == null) goto L16;
    L17:
        if (existingState != null) goto L47;
        ArrayMap<String, Integer> stateMap = newState.getStateMap();     // Catch: Throwable -> L20
        int size = stateMap.size();     // Catch: Throwable -> L20
        int index = size - 1;     // Catch: Throwable -> L20
    L23:
        if (index < 0) goto L34;
        Integer stateInteger = stateMap.valueAt(index);     // Catch: Throwable -> L20
        if (stateInteger == null) goto L33;
        int state = stateInteger.intValue();     // Catch: Throwable -> L20
        if (state == 1) goto L32;
        if (state == 5) goto L32;
        stateMap.removeAt(index);     // Catch: Throwable -> L20
    L32:
        stateMap.setValueAt(index, 5);     // Catch: Throwable -> L20
    L33:
        index = index - 1;     // Catch: Throwable -> L20
        goto L23
    L34:
        this.mRestoredPkgStates.put(pkgName, newState);     // Catch: Throwable -> L20
    L35:
        stateIndex = stateIndex + 1;     // Catch: Throwable -> L20
        goto L45
    L47:
        mergePkgState(existingState, newState, snapshot);     // Catch: Throwable -> L20
    L20:
        th = th;
        goto L41
    L16:
        existingState = this.mRestoredPkgStates.get(pkgName);     // Catch: Throwable -> L12
    L12:
        th = th;
        goto L41
    L39:
        monitor-exit(r4);     // Catch: Throwable -> L20
    }

    public void mergePkgState(DomainVerificationPkgState oldState, DomainVerificationPkgState newState, Computer snapshot) {
        PackageStateInternal pkgSetting = snapshot.getPackageStateInternal(oldState.getPackageName());
        if (pkgSetting != null) goto L5;
        AndroidPackage pkg = null;
    L6:
        if (pkg != null) goto L8;
        Set<String> validDomains = Collections.emptySet();
    L9:
        ArrayMap<String, Integer> oldStateMap = oldState.getStateMap();
        ArrayMap<String, Integer> newStateMap = newState.getStateMap();
        int size = newStateMap.size();
        int index = 0;
    L10:
        if (index >= size) goto L24;
        String domain = newStateMap.keyAt(index);
        Integer newStateCode = newStateMap.valueAt(index);
        if (validDomains.contains(domain) == false) goto L23;
        Integer oldStateCode = oldStateMap.get(domain);
        if (oldStateCode == null) goto L19;
        if (oldStateCode.intValue() != 0) goto L23;
    L19:
        if (newStateCode.intValue() != 1) goto L21;
    L22:
        oldStateMap.put(domain, 5);
        goto L23
    L21:
        if (newStateCode.intValue() == 5) goto L22;
    L23:
        index = index + 1;
        goto L10
    L24:
        SparseArray<DomainVerificationInternalUserState> oldSelectionStates = oldState.getUserStates();
        SparseArray<DomainVerificationInternalUserState> newSelectionStates = newState.getUserStates();
        int userStateSize = newSelectionStates.size();
        int index2 = 0;
    L25:
        if (index2 >= userStateSize) goto L35;
        int userId = newSelectionStates.keyAt(index2);
        DomainVerificationInternalUserState newUserState = newSelectionStates.valueAt(index2);
        if (newUserState == null) goto L32;
        ArraySet<String> newEnabledHosts = newUserState.getEnabledHosts();
        DomainVerificationInternalUserState oldUserState = oldSelectionStates.get(userId);
        PackageStateInternal pkgSetting2 = pkgSetting;
        boolean linkHandlingAllowed = newUserState.isLinkHandlingAllowed();
        if (oldUserState != null) goto L31;
        oldSelectionStates.put(userId, new DomainVerificationInternalUserState(userId, newEnabledHosts, linkHandlingAllowed));
    L33:
        index2 = index2 + 1;
        pkgSetting = pkgSetting2;
        goto L25
    L31:
        oldUserState.addHosts(newEnabledHosts).setLinkHandlingAllowed(linkHandlingAllowed);
        goto L33
    L32:
        pkgSetting2 = pkgSetting;
        goto L33
    L35:
        return;
    L8:
        validDomains = this.mCollector.collectValidAutoVerifyDomains(pkg);
        goto L9
    L5:
        pkg = pkgSetting.getPkg();
        goto L6
    }

    public void removePackage(String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPendingPkgStates.remove(packageName);     // Catch: Throwable -> L7
        this.mRestoredPkgStates.remove(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removePackageForUser(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DomainVerificationPkgState pendingPkgState = this.mPendingPkgStates.get(packageName);     // Catch: Throwable -> L7
        if (pendingPkgState == null) goto L9;
        pendingPkgState.removeUser(userId);     // Catch: Throwable -> L7
    L9:
        DomainVerificationPkgState restoredPkgState = this.mRestoredPkgStates.get(packageName);     // Catch: Throwable -> L7
        if (restoredPkgState == null) goto L12;
        restoredPkgState.removeUser(userId);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int pendingSize = this.mPendingPkgStates.size();     // Catch: Throwable -> L7
        int index = 0;
    L5:
        if (index >= pendingSize) goto L9;
        this.mPendingPkgStates.valueAt(index).removeUser(userId);     // Catch: Throwable -> L7
        index = index + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        int restoredSize = this.mRestoredPkgStates.size();     // Catch: Throwable -> L7
        int index2 = 0;
    L10:
        if (index2 >= restoredSize) goto L13;
        this.mRestoredPkgStates.valueAt(index2).removeUser(userId);     // Catch: Throwable -> L7
        index2 = index2 + 1;     // Catch: Throwable -> L7
        goto L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public DomainVerificationPkgState removePendingState(String pkgName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DomainVerificationPkgState r1 = this.mPendingPkgStates.remove(pkgName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public DomainVerificationPkgState removeRestoredState(String pkgName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DomainVerificationPkgState r1 = this.mRestoredPkgStates.remove(pkgName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
