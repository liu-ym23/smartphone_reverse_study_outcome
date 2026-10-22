package com.android.server.pm;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PackageManagerService$$ExternalSyntheticLambda17 implements ApkChecksums.Injector.Producer {
    public final /* synthetic */ PackageManagerServiceInjector f$0;

    public /* synthetic */ PackageManagerService$$ExternalSyntheticLambda17(PackageManagerServiceInjector r1) {
        this.f$0 = r1;
    }

    @Override // com.android.server.pm.ApkChecksums.Injector.Producer
    public final Object produce() {
        return this.f$0.getIncrementalManager();
    }
}
