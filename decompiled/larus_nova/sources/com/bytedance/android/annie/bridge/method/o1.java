package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PrerenderResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o1 implements s9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p1 f38741a;

    public o1(p1 r100) {
        this.f38741a = r100;
    }

    @Override // s9.e
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        p1 r101 = this.f38741a;
        PrerenderResultModel r102 = new PrerenderResultModel();
        r102.a(PrerenderResultModel.Code.Success);
        r102.b("Success!!!");
        r101.finishWithResult(r102);
    }

    @Override // s9.e
    public final void onFailed(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "reason");
        p1 r102 = this.f38741a;
        PrerenderResultModel r103 = new PrerenderResultModel();
        r103.a(PrerenderResultModel.Code.Failed);
        r103.b(r101 + "with schema: " + r100);
        r102.finishWithResult(r103);
    }
}
