package com.android.server.pm.verify.domain.models;

import android.annotation.NonNull;
import android.content.UriRelativeFilterGroup;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.android.internal.util.AnnotationValidations;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationPkgState {
    private final String mBackupSignatureHash;
    private final boolean mHasAutoVerifyDomains;
    private final UUID mId;
    private final String mPackageName;
    private final ArrayMap<String, Integer> mStateMap;
    private final ArrayMap<String, List<UriRelativeFilterGroup>> mUriRelativeFilterGroupMap;
    private final SparseArray<DomainVerificationInternalUserState> mUserStates;

    public DomainVerificationPkgState(String packageName, UUID id, boolean hasAutoVerifyDomains) {
        this(packageName, id, hasAutoVerifyDomains, new ArrayMap(0), new SparseArray(0), null, new ArrayMap());
    }

    public DomainVerificationPkgState(DomainVerificationPkgState pkgState, UUID id, boolean hasAutoVerifyDomains) {
        this(pkgState.getPackageName(), id, hasAutoVerifyDomains, pkgState.getStateMap(), pkgState.getUserStates(), null, new ArrayMap());
    }

    public DomainVerificationPkgState(String packageName, UUID id, boolean hasAutoVerifyDomains, ArrayMap<String, Integer> stateMap, SparseArray<DomainVerificationInternalUserState> userStates, String backupSignatureHash) {
        this(packageName, id, hasAutoVerifyDomains, stateMap, userStates, backupSignatureHash, new ArrayMap());
    }

    public DomainVerificationInternalUserState getUserState(int userId) {
        return this.mUserStates.get(userId);
    }

    public DomainVerificationInternalUserState getOrCreateUserState(int userId) {
        DomainVerificationInternalUserState userState = this.mUserStates.get(userId);
        if (userState != null) goto L6;
        DomainVerificationInternalUserState userState2 = new DomainVerificationInternalUserState(userId);
        this.mUserStates.put(userId, userState2);
        return userState2;
    L6:
        return userState;
    }

    public void removeUser(int userId) {
        this.mUserStates.remove(userId);
    }

    public void removeAllUsers() {
        this.mUserStates.clear();
    }

    private int userStatesHashCode() {
        return this.mUserStates.contentHashCode();
    }

    private boolean userStatesEquals(SparseArray<DomainVerificationInternalUserState> other) {
        return this.mUserStates.contentEquals(other);
    }

    public DomainVerificationPkgState(String packageName, UUID id, boolean hasAutoVerifyDomains, ArrayMap<String, Integer> stateMap, SparseArray<DomainVerificationInternalUserState> userStates, String backupSignatureHash, ArrayMap<String, List<UriRelativeFilterGroup>> uriRelativeFilterGroupMap) {
        this.mPackageName = packageName;
        AnnotationValidations.validate(NonNull.class, null, this.mPackageName);
        this.mId = id;
        AnnotationValidations.validate(NonNull.class, null, this.mId);
        this.mHasAutoVerifyDomains = hasAutoVerifyDomains;
        this.mStateMap = stateMap;
        AnnotationValidations.validate(NonNull.class, null, this.mStateMap);
        this.mUserStates = userStates;
        AnnotationValidations.validate(NonNull.class, null, this.mUserStates);
        this.mBackupSignatureHash = backupSignatureHash;
        this.mUriRelativeFilterGroupMap = uriRelativeFilterGroupMap;
        AnnotationValidations.validate(NonNull.class, null, this.mUriRelativeFilterGroupMap);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public UUID getId() {
        return this.mId;
    }

    public boolean isHasAutoVerifyDomains() {
        return this.mHasAutoVerifyDomains;
    }

    public ArrayMap<String, Integer> getStateMap() {
        return this.mStateMap;
    }

    public SparseArray<DomainVerificationInternalUserState> getUserStates() {
        return this.mUserStates;
    }

    public String getBackupSignatureHash() {
        return this.mBackupSignatureHash;
    }

    public ArrayMap<String, List<UriRelativeFilterGroup>> getUriRelativeFilterGroupMap() {
        return this.mUriRelativeFilterGroupMap;
    }

    public String toString() {
        return "DomainVerificationPkgState { packageName = " + this.mPackageName + ", id = " + this.mId + ", hasAutoVerifyDomains = " + this.mHasAutoVerifyDomains + ", stateMap = " + this.mStateMap + ", userStates = " + this.mUserStates + ", backupSignatureHash = " + this.mBackupSignatureHash + ", uriRelativeFilterGroupMap = " + this.mUriRelativeFilterGroupMap + " }";
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L27:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L27;
        DomainVerificationPkgState that = (DomainVerificationPkgState) o;
        if (Objects.equals(this.mPackageName, that.mPackageName) == false) goto L26;
        if (Objects.equals(this.mId, that.mId) == false) goto L26;
        if (this.mHasAutoVerifyDomains != that.mHasAutoVerifyDomains) goto L26;
        if (Objects.equals(this.mStateMap, that.mStateMap) == false) goto L26;
        if (userStatesEquals(that.mUserStates) == false) goto L26;
        if (Objects.equals(this.mBackupSignatureHash, that.mBackupSignatureHash) == false) goto L26;
        if (Objects.equals(this.mUriRelativeFilterGroupMap, that.mUriRelativeFilterGroupMap) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + Objects.hashCode(this.mPackageName);
        return (((((((((((_hash * 31) + Objects.hashCode(this.mId)) * 31) + Boolean.hashCode(this.mHasAutoVerifyDomains)) * 31) + Objects.hashCode(this.mStateMap)) * 31) + userStatesHashCode()) * 31) + Objects.hashCode(this.mBackupSignatureHash)) * 31) + Objects.hashCode(this.mUriRelativeFilterGroupMap);
    }

    @Deprecated
    private void __metadata() {
    }
}
