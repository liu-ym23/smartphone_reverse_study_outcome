package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AIPackageUpdateOperation extends AbsAIPackageOperation {
    public AIPackageUpdateOperation() {
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.UPDATING;
    }

    public static void l(AIPackage r100) {
        AIManager r101 = AIManager.f37211a;
        Intrinsics.checkNotNullParameter(r100, "packageInfo");
        g.f37637a.d("AIManager", "===onAIPackageUpdateCompleted: " + r100.f36895b + ", appId: " + r100.a() + ", packageType: " + r100.c().name());
        Iterator<AIManager.c> r102 = AIManager.f37214d.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(r100.f36895b, r100.a());
        goto L4
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object g(Continuation<? super AbsAIPackageOperation.a> r100) {
        if (this.f37459a == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        g.f37637a.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> update failed : AIPackage not installed");
        return AbsAIPackageOperation.b(this, null, 7);
    L10:
        if (k() == true) goto L14;
        return AbsAIPackageOperation.b(this, e(), 11);
    L14:
        return m(r100);
    L5:
        r101 = false;
        goto L6
    }

    public final Object m(Continuation<? super AbsAIPackageOperation.a> r110) {
        if ((r110 instanceof AIPackageUpdateOperation$updateAIPackage$1) == false) goto L7;
        AIPackageUpdateOperation$updateAIPackage$1 r100 = (AIPackageUpdateOperation$updateAIPackage$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        AIPackage r105 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L35:
        if (((Boolean) r102).booleanValue() == false) goto L38;
        g.f37637a.i("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> update end");
        String r106 = com.bytedance.ai.resource.core.a.f37325a;
        f.d(com.bytedance.ai.resource.core.a.f(d()));
        l(r105);
        return AbsAIPackageOperation.b(this, r105, 0);
    L38:
        g.f37637a.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> update db failed");
        l(e());
        return AbsAIPackageOperation.b(this, e(), 5);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        g r107 = g.f37637a;
        r107.d("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> start update");
        AIPackageManifestBean r108 = this.f37460b;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("packageManifest");
        r108 = null;
    L18:
        AIPackage r109 = a(r108, "inactive");
        if (r109 != null) goto L22;
        r107.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> update failed : create AIPackage is null");
        return AbsAIPackageOperation.b(this, e(), 8);
    L22:
        r109.f36910q = e().f36910q;
        r109.f36911r = e().f36911r;
        r109.f36914u = e().f36914u;
        r109.f36913t = e().f36913t;
        r109.f36912s = System.currentTimeMillis() / 1000;
        String r111 = com.bytedance.ai.resource.core.a.f37325a;
        r109.f36909p = f.f(new PolarisFileWrapper(com.bytedance.ai.resource.core.a.e(d())));
        AIManager r112 = AIManager.f37211a;
        String r113 = r109.f36895b;
        String r114 = r109.a();
        AIPackage.AIPackageType r115 = r109.c();
        Intrinsics.checkNotNullParameter(r113, "packageName");
        Intrinsics.checkNotNullParameter(r114, "appId");
        Intrinsics.checkNotNullParameter(r115, "packageType");
        r107.d("AIManager", "===onAIPackageUpdatePrepared: " + r113 + ", appId: " + r114 + ", packageType: " + r115.name());
        Iterator<AIManager.c> r116 = AIManager.f37214d.iterator();
    L24:
        if (r116.hasNext() == false) goto L26;
        r116.next().c(r113, r114);
        goto L24
    L26:
        String r117 = e().f36895b;
        String r118 = e().a();
        AIPackage.AIPackageType r119 = e().c();
        AIManager r120 = AIManager.f37211a;
        Intrinsics.checkNotNullParameter(r117, "packageName");
        Intrinsics.checkNotNullParameter(r118, "appId");
        Intrinsics.checkNotNullParameter(r119, "packageType");
        g.f37637a.d("AIManager", "===onAIPackageUpdateStarted: " + r117 + ", appId: " + r118 + ", packageType: " + r119.name());
        Iterator<AIManager.c> r121 = AIManager.f37214d.iterator();
    L28:
        if (r121.hasNext() == false) goto L30;
        r121.next().b(r117, r118);
        goto L28
    L30:
        AIPackageStorage r122 = AIPackageStorage.f37323a;
        r100.L$0 = r109;
        r100.label = 1;
        r102 = r122.e(r109, r100);
        if (r102 != r103) goto L33;
        return r103;
    L33:
        r105 = r109;
    L7:
        r100 = new AIPackageUpdateOperation$updateAIPackage$1(this, r110);
        goto L8
    }
}
