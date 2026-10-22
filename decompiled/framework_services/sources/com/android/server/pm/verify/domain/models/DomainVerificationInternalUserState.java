package com.android.server.pm.verify.domain.models;

import android.annotation.NonNull;
import android.annotation.UserIdInt;
import android.util.ArraySet;
import com.android.internal.util.AnnotationValidations;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationInternalUserState {
    private final ArraySet<String> mEnabledHosts;
    private boolean mLinkHandlingAllowed;
    private final int mUserId;

    public DomainVerificationInternalUserState(int userId) {
        this.mLinkHandlingAllowed = true;
        this.mUserId = userId;
        this.mEnabledHosts = new ArraySet();
    }

    public DomainVerificationInternalUserState addHosts(ArraySet<String> newHosts) {
        this.mEnabledHosts.addAll(newHosts);
        return this;
    }

    public DomainVerificationInternalUserState addHosts(Set<String> newHosts) {
        this.mEnabledHosts.addAll(newHosts);
        return this;
    }

    public DomainVerificationInternalUserState removeHost(String host) {
        this.mEnabledHosts.remove(host);
        return this;
    }

    public DomainVerificationInternalUserState removeHosts(ArraySet<String> newHosts) {
        this.mEnabledHosts.removeAll(newHosts);
        return this;
    }

    public DomainVerificationInternalUserState removeHosts(Set<String> newHosts) {
        this.mEnabledHosts.removeAll(newHosts);
        return this;
    }

    public DomainVerificationInternalUserState retainHosts(Set<String> hosts) {
        this.mEnabledHosts.retainAll(hosts);
        return this;
    }

    public DomainVerificationInternalUserState(int userId, ArraySet<String> enabledHosts, boolean linkHandlingAllowed) {
        this.mLinkHandlingAllowed = true;
        this.mUserId = userId;
        AnnotationValidations.validate(UserIdInt.class, null, this.mUserId);
        this.mEnabledHosts = enabledHosts;
        AnnotationValidations.validate(NonNull.class, null, this.mEnabledHosts);
        this.mLinkHandlingAllowed = linkHandlingAllowed;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public ArraySet<String> getEnabledHosts() {
        return this.mEnabledHosts;
    }

    public boolean isLinkHandlingAllowed() {
        return this.mLinkHandlingAllowed;
    }

    public DomainVerificationInternalUserState setLinkHandlingAllowed(boolean value) {
        this.mLinkHandlingAllowed = value;
        return this;
    }

    public String toString() {
        return "DomainVerificationInternalUserState { userId = " + this.mUserId + ", enabledHosts = " + this.mEnabledHosts + ", linkHandlingAllowed = " + this.mLinkHandlingAllowed + " }";
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L19;
        DomainVerificationInternalUserState that = (DomainVerificationInternalUserState) o;
        if (this.mUserId != that.mUserId) goto L18;
        if (Objects.equals(this.mEnabledHosts, that.mEnabledHosts) == false) goto L18;
        if (this.mLinkHandlingAllowed != that.mLinkHandlingAllowed) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int _hash = (1 * 31) + this.mUserId;
        return (((_hash * 31) + Objects.hashCode(this.mEnabledHosts)) * 31) + Boolean.hashCode(this.mLinkHandlingAllowed);
    }

    @Deprecated
    private void __metadata() {
    }
}
