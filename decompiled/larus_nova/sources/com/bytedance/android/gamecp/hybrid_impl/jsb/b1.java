package com.bytedance.android.gamecp.hybrid_impl.jsb;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b1 implements com.bytedance.android.gamecp.base.core.service.depend.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f57493a;

    public b1(a1 r100) {
        this.f57493a = r100;
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.q
    public final void onFail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "errorInfo");
        a1 r101 = this.f57493a;
        n4 r102 = new n4();
        r102.a(-1);
        n4.a r103 = new n4.a();
        r103.a(-1);
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
    }

    @Override // com.bytedance.android.gamecp.base.core.service.depend.q
    public final void onSuccess(JSONObject r100) {
        a1 r101 = this.f57493a;
        n4 r102 = new n4();
        r102.a(1);
        n4.a r103 = new n4.a();
        r103.a(1);
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
    }
}
