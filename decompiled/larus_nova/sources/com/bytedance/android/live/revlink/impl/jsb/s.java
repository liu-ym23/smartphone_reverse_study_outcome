package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.ObserveRevenueInteractDataResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.zb;

/* JADX INFO: loaded from: classes47.dex */
public final class s extends wy0.b<zb, ObserveRevenueInteractDataResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f92623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a f92624b;

    @Override // wy0.b
    public final Type k() {
        return this.f92623a;
    }

    public s(com.bytedance.android.live.revlink.impl.lynxcontainer.a r100) {
        this.f92624b = r100;
        this.f92623a = TypesJVMKt.getJavaType(Reflection.typeOf(zb.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r100, CallContext r101) {
        zb r102 = (zb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ObserveRevenueInteractDataResultModel r103 = new ObserveRevenueInteractDataResultModel();
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r104 = this.f92624b;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101.f249269d != null) goto L5;
        finishWithFailure();
    L5:
        if (r104 != null) goto L8;
        r103.a(ObserveRevenueInteractDataResultModel.Code.Failed);
        finishWithResult(r103);
        Unit r105 = Unit.INSTANCE;
    L8:
        if (r102.getType() != 0) goto L12;
        List<String> r106 = CollectionsKt.toList(r102.getTags());
        if (r104 == null) goto L14;
        r104.d(r101, r106);
    L14:
        r103.a(ObserveRevenueInteractDataResultModel.Code.Success);
        finishWithResult(r103);
        return;
    L12:
        if (r104 == null) goto L14;
        r104.l(r101);
        goto L14
    }
}
