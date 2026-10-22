package com.android.server.pm;

import java.util.function.Supplier;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DistractingPackageHelper$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ PackageManagerService f$0;

    public /* synthetic */ DistractingPackageHelper$$ExternalSyntheticLambda1(PackageManagerService r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f$0.snapshotComputer();
    }
}
