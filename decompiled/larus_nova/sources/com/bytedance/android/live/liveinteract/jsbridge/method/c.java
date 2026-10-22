package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.browser.jsbridge.base.GetLinkmicStatusResultModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.voicechat.radio.context.RadioStageContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import w20.o9;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends w20.l1<o9, GetLinkmicStatusResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f74208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f74209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f74210c;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        o9 r102 = (o9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r102.a();
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        JsonObject r106 = r102.b();
        Intrinsics.checkNotNullParameter(r104, "bizId");
        JsonObject r107 = null;
        if (Intrinsics.areEqual(r104, "dynamic_center") == false) goto L17;
        my.b r108 = new my.b(DynamicCenterGetType.valueOf(r103), r104, r106);
        s r109 = this.f74210c;
        if (r109 == null) goto L14;
        JsonObject r110 = r109.C(r108);
    L30:
        GetLinkmicStatusResultModel r111 = new GetLinkmicStatusResultModel();
        r111.b(GetLinkmicStatusResultModel.Code.Success);
        r111.c(r110);
        r111.d("get success");
        Objects.toString(r111.a());
        finishWithResult(r111);
        return;
    L14:
        iy.g r112 = com.bytedance.android.live.anchormodelink.linkroom.a.f58739a;
        iy.g r113 = com.bytedance.android.live.anchormodelink.linkroom.a.a(this.f74208a);
        if (r113 == null) goto L28;
        r107 = r113.C(r108);
    L28:
        r110 = r107;
        goto L30
    L17:
        ih0.e r114 = new ih0.e(DynamicGetType.valueOf(r103.toUpperCase(Locale.ROOT)), r104, r106);
        ih0.b r115 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.f74208a);
        t r116 = this.f74209b;
        if (r116 == null) goto L20;
        JsonObject r117 = r116.T(r114);
    L23:
        if (r117 != null) goto L29;
        if (r115 != null) goto L29;
        jk0.c r118 = RadioStageContext.Companion.a();
        if (r118 == null) goto L28;
        r107 = r118.T(r114);
    L29:
        r110 = r117;
        goto L30
    L20:
        if (r115 == null) goto L22;
        r117 = r115.T(r114);
        goto L23
    L22:
        r117 = null;
        goto L23
    }

    public c(DataCenter r100, t r101, s r102) {
        this.f74208a = r100;
        this.f74209b = r101;
        this.f74210c = r102;
    }

    public /* synthetic */ c(DataCenter r100, boolean r101, s r102, int r103) {
        if ((r103 & 8) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, null, r102);
    }
}
