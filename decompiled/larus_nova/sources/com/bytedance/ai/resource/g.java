package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements AIPackageManager.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Boolean, String, Unit> f37493a;

    /* JADX WARN: Multi-variable type inference failed */
    public g(Function2<? super Boolean, ? super String, Unit> r100) {
        this.f37493a = r100;
    }

    @Override // com.bytedance.ai.resource.AIPackageManager.b
    public final void a(AIPackage r100, String r101, String r102, AIPackage.AIPackageType r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "packageType");
        if (r104 != 0) goto L9;
        if (r100 == null) goto L9;
        String r106 = "install package success: packageName: " + r101 + ", appId = " + r102;
        Function2<Boolean, String, Unit> r107 = this.f37493a;
        if (r107 == null) goto L8;
        r107.invoke(Boolean.TRUE, r106);
    L8:
        com.bytedance.ai.utils.g.f37637a.d("AIManager", r106);
        return;
    L9:
        String r108 = "install package failed: packageName: " + r101 + ", appId = " + r102;
        Function2<Boolean, String, Unit> r109 = this.f37493a;
        if (r109 == null) goto L12;
        r109.invoke(Boolean.TRUE, r108);
    L12:
        com.bytedance.ai.utils.g.f37637a.d("AIManager", r108);
    }
}
