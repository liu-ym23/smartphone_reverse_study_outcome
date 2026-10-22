package com.android.server.pm.verify.domain;

import android.content.pm.PackageManager;
import android.content.pm.verify.domain.DomainOwner;
import android.content.pm.verify.domain.DomainSet;
import android.content.pm.verify.domain.DomainVerificationInfo;
import android.content.pm.verify.domain.DomainVerificationUserState;
import android.content.pm.verify.domain.IDomainVerificationManager;
import android.os.Bundle;
import android.os.ServiceSpecificException;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationManagerStub extends IDomainVerificationManager.Stub {
    private final DomainVerificationService mService;

    public DomainVerificationManagerStub(DomainVerificationService service) {
        this.mService = service;
    }

    public void setUriRelativeFilterGroups(String packageName, Bundle domainToGroupsBundle) {
        this.mService.setUriRelativeFilterGroups(packageName, domainToGroupsBundle);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    public Bundle getUriRelativeFilterGroups(String packageName, List<String> domains) {
        return this.mService.getUriRelativeFilterGroups(packageName, domains);
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    public List<String> queryValidVerificationPackageNames() {
        return this.mService.queryValidVerificationPackageNames();
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    public DomainVerificationInfo getDomainVerificationInfo(String packageName) {
        return this.mService.getDomainVerificationInfo(packageName);
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    public int setDomainVerificationStatus(String domainSetId, DomainSet domainSet, int state) {
        return this.mService.setDomainVerificationStatus(UUID.fromString(domainSetId), domainSet.getDomains(), state);
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    public void setDomainVerificationLinkHandlingAllowed(String packageName, boolean allowed, int userId) {
        this.mService.setDomainVerificationLinkHandlingAllowed(packageName, allowed, userId);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    public int setDomainVerificationUserSelection(String domainSetId, DomainSet domainSet, boolean enabled, int userId) {
        return this.mService.setDomainVerificationUserSelection(UUID.fromString(domainSetId), domainSet.getDomains(), enabled, userId);
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    public DomainVerificationUserState getDomainVerificationUserState(String packageName, int userId) {
        return this.mService.getDomainVerificationUserState(packageName, userId);
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    public List<DomainOwner> getOwnersForDomain(String domain, int userId) {
        domain.getClass();     // Catch: Exception -> L4
        return this.mService.getOwnersForDomain(domain, userId);
    L4:
        e = move-exception;
        throw rethrow(e);
    }

    private RuntimeException rethrow(Exception exception) throws RuntimeException {
        if ((exception instanceof PackageManager.NameNotFoundException) == false) goto L7;
        return new ServiceSpecificException(1);
    L7:
        if ((exception instanceof RuntimeException) == false) goto L11;
        return (RuntimeException) exception;
    L11:
        return new RuntimeException(exception);
    }
}
