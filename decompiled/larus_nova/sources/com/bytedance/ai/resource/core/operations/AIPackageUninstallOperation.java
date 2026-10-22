package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.utils.g;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AIPackageUninstallOperation extends AbsAIPackageOperation {
    public AIPackageUninstallOperation() {
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.DELETING;
    }

    @Override // com.bytedance.ai.resource.core.operations.AbsAIPackageOperation
    public final Object g(Continuation<? super AbsAIPackageOperation.a> r110) {
        if ((r110 instanceof AIPackageUninstallOperation$run$1) == false) goto L7;
        AIPackageUninstallOperation$run$1 r100 = (AIPackageUninstallOperation$run$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L22:
        if (((Boolean) r111).booleanValue() == false) goto L24;
        int r112 = 0;
    L26:
        return AbsAIPackageOperation.b(this, null, r112);
    L24:
        r112 = 5;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        String r113 = d().getPackageName();
        String r104 = d().getAppId();
        if (Intrinsics.areEqual(r113, r104) == false) goto L17;
        AIPackage.AIPackageType r105 = AIPackage.AIPackageType.APPLET;
    L18:
        AIPackageManager.a r106 = new AIPackageManager.a(r104, r113);
        g.f37637a.d("AIPackageManager", "packageName: " + r113 + ", appId: " + r104 + ", type: " + r105 + " ===> markPackageAsDeleted");
        AIPackageStorage r114 = AIPackageStorage.f37323a;
        r100.label = 1;
        r111 = r114.f(r106, r105, r100);
        if (r111 != r102) goto L22;
        return r102;
    L17:
        r105 = AIPackage.AIPackageType.WIDGET;
    L7:
        r100 = new AIPackageUninstallOperation$run$1(this, r110);
        goto L8
    }
}
