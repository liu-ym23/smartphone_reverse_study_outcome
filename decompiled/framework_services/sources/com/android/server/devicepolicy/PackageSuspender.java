package com.android.server.devicepolicy;

import android.content.pm.PackageManagerInternal;
import android.util.ArraySet;
import com.android.server.utils.Slogf;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PackageSuspender {
    private final List<String> mExemptedPackages;
    private final PackageManagerInternal mPackageManager;
    private final Set<String> mSuspendedPackageAfter;
    private final Set<String> mSuspendedPackageBefore;
    private final int mUserId;

    /* JADX INFO: renamed from: $r8$lambda$HQxzXzbTjOguRBc9Qc-pVBAl9q4, reason: not valid java name */
    public static /* synthetic */ String[] m3515$r8$lambda$HQxzXzbTjOguRBc9QcpVBAl9q4(int r0) {
        return lambda$suspendWithExemption$1(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$QpUODY9mhRVgRDMIPM7V_dWstAI(int r0) {
        return lambda$unsuspendWithExemption$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$YroST8Dx-uOOccEMlZ8zW2iE0Uo, reason: not valid java name */
    public static /* synthetic */ String[] m3516$r8$lambda$YroST8DxuOOccEMlZ8zW2iE0Uo(int r0) {
        return lambda$unsuspend$2(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$iMt5C6vc7eRJ2c1gEiBsKJOJpXI(int r0) {
        return lambda$suspend$0(r0);
    }

    public PackageSuspender(Set<String> suspendedPackageBefore, Set<String> suspendedPackageAfter, List<String> exemptedPackages, PackageManagerInternal pmi, int userId) {
        if (suspendedPackageBefore == null) goto L5;
        Set<String> r0 = suspendedPackageBefore;
    L6:
        this.mSuspendedPackageBefore = r0;
        if (suspendedPackageAfter == null) goto L9;
        Set<String> r1 = suspendedPackageAfter;
    L10:
        this.mSuspendedPackageAfter = r1;
        this.mExemptedPackages = exemptedPackages;
        this.mPackageManager = pmi;
        this.mUserId = userId;
        return;
    L9:
        r1 = Collections.emptySet();
        goto L10
    L5:
        r0 = Collections.emptySet();
        goto L6
    }

    public String[] suspend(Set<String> packages) {
        Set<String> result = suspendWithExemption(packages);
        return (String[]) result.toArray(new PackageSuspender$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ String[] lambda$suspend$0(int x$0) {
        return new String[x$0];
    }

    private Set<String> suspendWithExemption(Set<String> packages) {
        Set<String> packagesToSuspend = new ArraySet(packages);
        Set<String> result = new ArraySet(this.mExemptedPackages);
        result.retainAll(packagesToSuspend);
        packagesToSuspend.removeAll(this.mExemptedPackages);
        String[] failedPackages = this.mPackageManager.setPackagesSuspendedByAdmin(this.mUserId, (String[]) packagesToSuspend.toArray(new PackageSuspender$$ExternalSyntheticLambda1()), true);
        if (failedPackages != null) goto L6;
        Slogf.w("DevicePolicyManager", "PM failed to suspend packages (%s)", new Object[]{packages});
        return packages;
    L6:
        result.addAll(Arrays.asList(failedPackages));
        return result;
    }

    private static /* synthetic */ String[] lambda$suspendWithExemption$1(int x$0) {
        return new String[x$0];
    }

    public String[] unsuspend(Set<String> packages) {
        Set<String> packagesToUnsuspend = new ArraySet(packages);
        packagesToUnsuspend.removeAll(this.mSuspendedPackageAfter);
        Set<String> result = new ArraySet(packages);
        result.retainAll(this.mSuspendedPackageAfter);
        result.removeAll(this.mExemptedPackages);
        result.addAll(unsuspendWithExemption(packagesToUnsuspend));
        return (String[]) result.toArray(new PackageSuspender$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ String[] lambda$unsuspend$2(int x$0) {
        return new String[x$0];
    }

    private Set<String> unsuspendWithExemption(Set<String> packages) {
        String[] failedPackages = this.mPackageManager.setPackagesSuspendedByAdmin(this.mUserId, (String[]) packages.toArray(new PackageSuspender$$ExternalSyntheticLambda3()), false);
        if (failedPackages != null) goto L6;
        Slogf.w("DevicePolicyManager", "PM failed to unsuspend packages (%s)", new Object[]{packages});
    L6:
        return new ArraySet(failedPackages);
    }

    private static /* synthetic */ String[] lambda$unsuspendWithExemption$3(int x$0) {
        return new String[x$0];
    }
}
