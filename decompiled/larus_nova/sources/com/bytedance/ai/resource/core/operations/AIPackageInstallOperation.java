package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AIPackageInstallOperation extends AbsAIPackageOperation {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f37458h;

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.INSTALLING;
    }

    public AIPackageInstallOperation(String r100) {
        Intrinsics.checkNotNullParameter(r100, ForwardDependency$ForwardLocation.FLAG);
        this.f37458h = r100;
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object g(Continuation<? super AbsAIPackageOperation.a> r100) {
        AIPackageManifestBean r101 = null;
        if (k() == false) goto L5;
        AIPackageManifestBean r102 = this.f37460b;
        if (r102 == null) goto L9;
        r101 = r102;
    L11:
        return l(r101, r100);
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("packageManifest");
        goto L11
    L5:
        return AbsAIPackageOperation.b(this, null, 11);
    }

    public final Object l(AIPackageManifestBean r110, Continuation<? super AbsAIPackageOperation.a> r111) {
        if ((r111 instanceof AIPackageInstallOperation$installAIPackage$1) == false) goto L7;
        AIPackageInstallOperation$installAIPackage$1 r100 = (AIPackageInstallOperation$installAIPackage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        AIPackage r105 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L33:
        if (((Boolean) r102).booleanValue() == false) goto L35;
        g.f37637a.i("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> install end");
        String r106 = com.bytedance.ai.resource.core.a.f37325a;
        f.d(com.bytedance.ai.resource.core.a.f(d()));
        return AbsAIPackageOperation.b(this, r105, 0);
    L35:
        g.f37637a.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> insert db failed");
        return AbsAIPackageOperation.b(this, null, 4);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackage r107 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L28:
        long r112 = System.currentTimeMillis() / 1000;
        r107.f36910q = r112;
        r107.f36911r = r112;
        r107.f36912s = r112;
        r107.f36914u = r112;
        r107.f36913t = r112;
        String r108 = com.bytedance.ai.resource.core.a.f37325a;
        r107.f36909p = f.f(new PolarisFileWrapper(com.bytedance.ai.resource.core.a.e(d())));
        AIPackageStorage r109 = AIPackageStorage.f37323a;
        r100.L$0 = r107;
        r100.label = 2;
        r102 = r109.d(r107, r100);
        if (r102 != r103) goto L31;
        return r103;
    L31:
        r105 = r107;
        goto L33
    L16:
        ResultKt.throwOnFailure(r102);
        g r113 = g.f37637a;
        r113.d("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> start install");
        r107 = a(r110, this.f37458h);
        if (r107 != null) goto L21;
        r113.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> install failed : create AIPackage is null");
        return AbsAIPackageOperation.b(this, null, 8);
    L21:
        if (this.f37459a == null) goto L23;
        boolean r114 = true;
    L24:
        if (r114 == false) goto L28;
        r113.d("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> delete old AIPackage");
        AIPackageStorage r115 = AIPackageStorage.f37323a;
        AIPackageManager.a r116 = new AIPackageManager.a(r107.a(), r107.f36895b);
        AIPackage.AIPackageType r117 = r107.c();
        r100.L$0 = r107;
        r100.label = 1;
        if (r115.b(r116, r117, r100) != r103) goto L28;
        return r103;
    L23:
        r114 = false;
    L7:
        r100 = new AIPackageInstallOperation$installAIPackage$1(this, r111);
        goto L8
    }
}
