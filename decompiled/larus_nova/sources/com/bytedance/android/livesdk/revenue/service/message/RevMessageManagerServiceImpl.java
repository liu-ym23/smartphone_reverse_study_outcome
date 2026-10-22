package com.bytedance.android.livesdk.revenue.service.message;

import com.bytedance.android.live.revenue.core.util.AsyncService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.ek;
import com.bytedance.android.livesdk.revenue.message.n;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class RevMessageManagerServiceImpl extends AsyncService implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.revenue.message.i f157407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f157408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.revenue.message.l f157409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.revenue.message.g f157410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public emc.a f157411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f157412i;

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService, com.bytedance.android.scope.o
    public final void onStop() {
        super.onStop();
        this.f157407d = null;
        com.bytedance.android.livesdk.revenue.message.l r100 = this.f157409f;
        if (r100 == null) goto L5;
        r100.f157195c.dispose();
        r100.f157194b = null;
        r100.f157193a.clear();
    L5:
        this.f157409f = null;
        com.bytedance.android.livesdk.revenue.message.g r101 = this.f157410g;
        if (r101 == null) goto L12;
        Iterator r102 = ((LinkedHashMap) r101.f157182a).entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.f157184c.m((String) r103.getKey(), r101.f157183b);
        goto L9
    L11:
        ((LinkedHashMap) r101.f157182a).clear();
    L12:
        this.f157410g = null;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.d
    public final com.bytedance.android.livesdk.revenue.message.g Ih() {
        return this.f157410g;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.d
    public final emc.a Kk() {
        return this.f157411h;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.d
    public final com.bytedance.android.livesdk.revenue.message.l c2() {
        return this.f157409f;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.d
    public final com.bytedance.android.livesdk.revenue.message.i getMessageManager() {
        return this.f157407d;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.d
    public final n xj() {
        return this.f157408e;
    }

    public RevMessageManagerServiceImpl(com.bytedance.live.kmp.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f157412i = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.d
    public final void i1(String r100) {
        Intrinsics.checkNotNullParameter("WebcastLuckyBoxMessage", com.alipay.sdk.m.p.e.f25671s);
        im2.d.f490459e.getClass();
        im2.d.a.d("WebcastLuckyBoxMessage");
    }

    @Override // com.bytedance.android.live.revenue.core.util.AsyncService
    public final Object o0(Continuation<? super Unit> r110) {
        if ((r110 instanceof RevMessageManagerServiceImpl$onStartAsync$1) == false) goto L7;
        RevMessageManagerServiceImpl$onStartAsync$1 r100 = (RevMessageManagerServiceImpl$onStartAsync$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L19;
        if (r103 == 4) goto L18;
        if (r103 != 5) goto L17;
        boolean r104 = r100.Z$0;
        com.bytedance.live.datacontext.n<vlc.d> r105 = (com.bytedance.live.datacontext.n) r100.L$1;
        RevMessageManagerServiceImpl r106 = (RevMessageManagerServiceImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L54:
        emc.a r107 = (emc.a) r111;
        RevMessageManagerServiceImpl r108 = r106;
        boolean r112 = r104;
    L55:
        if (r107 == null) goto L57;
        r108.f157411h = r107;
    L57:
        if (r112 != true) goto L60;
        if (r105 == null) goto L60;
        r108.f157409f = new com.bytedance.android.livesdk.revenue.message.l(r105);
    L60:
        r108.f157410g = new com.bytedance.android.livesdk.revenue.message.g(com.ss.ugc.live.sdk.platform.a.f458524f);
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r105 = (com.bytedance.live.datacontext.n) r100.L$2;
        RoomContext r109 = (RoomContext) r100.L$1;
        r108 = (RevMessageManagerServiceImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L48:
        r112 = ((Boolean) r111).booleanValue();
        r107 = null;
        if (r112 == true) goto L55;
        com.bytedance.live.datacontext.j<emc.a> r113 = r109.getStreamMessageManager();
        r100.L$0 = r108;
        r100.L$1 = r105;
        r100.L$2 = null;
        r100.Z$0 = r112;
        r100.label = 5;
        Object r114 = ey0.e.a(r113, r100);
        if (r114 != r102) goto L53;
        return r102;
    L53:
        r104 = r112;
        r111 = r114;
        r106 = r108;
        goto L54
    L19:
        vlc.d r115 = (vlc.d) r100.L$2;
        RoomContext r116 = (RoomContext) r100.L$1;
        RevMessageManagerServiceImpl r117 = (RevMessageManagerServiceImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L34:
        ylc.e r118 = (ylc.e) r111;
        com.bytedance.live.datacontext.n<vlc.d> r119 = r116.getRtcRoomMessageManager();
        if (r115 == null) goto L37;
        r117.f157407d = new com.bytedance.android.livesdk.revenue.message.i(r115);
    L37:
        if (r118 == null) goto L39;
        r117.f157408e = new n(r118);
    L39:
        com.bytedance.live.datacontext.i<Boolean> r120 = r116.isAnchor();
        r100.L$0 = r117;
        r100.L$1 = r116;
        r100.L$2 = r119;
        r100.label = 4;
        Boolean r121 = r120.getValue();
        if (r120.hasValue() == false) goto L42;
        r111 = r121;
    L45:
        if (r111 != r102) goto L47;
        return r102;
    L47:
        r109 = r116;
        r108 = r117;
        r105 = r119;
        goto L48
    L42:
        SafeContinuation r122 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        r120.b().subscribe(new ey0.d(r122, r120));
        r111 = r122.getOrThrow();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L45;
        DebugProbesKt.probeCoroutineSuspended(r100);
        goto L45
    L20:
        RoomContext r123 = (RoomContext) r100.L$1;
        r117 = (RevMessageManagerServiceImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L30:
        vlc.d r124 = (vlc.d) r111;
        com.bytedance.live.datacontext.j<ylc.e> r125 = r123.getWrdsManager();
        r100.L$0 = r117;
        r100.L$1 = r123;
        r100.L$2 = r124;
        r100.label = 3;
        Object r126 = ey0.e.a(r125, r100);
        if (r126 != r102) goto L33;
        return r102;
    L33:
        RoomContext r127 = r123;
        r115 = r124;
        r111 = r126;
        r116 = r127;
        goto L34
    L21:
        RevMessageManagerServiceImpl r128 = (RevMessageManagerServiceImpl) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L26:
        RoomContext r129 = (RoomContext) r111;
        com.bytedance.live.datacontext.j<vlc.d> r130 = r129.getMessageManager();
        r100.L$0 = r128;
        r100.L$1 = r129;
        r100.label = 2;
        Object r131 = ey0.e.a(r130, r100);
        if (r131 != r102) goto L29;
        return r102;
    L29:
        RevMessageManagerServiceImpl r132 = r128;
        r123 = r129;
        r111 = r131;
        r117 = r132;
        goto L30
    L22:
        ResultKt.throwOnFailure(r111);
        vh6.a r133 = this.f157412i.a();
        vh6.d<RoomContext> r134 = vp2.a.f556608a;
        r100.L$0 = this;
        r100.label = 1;
        r111 = r133.a(r134, r100);
        if (r111 != r102) goto L25;
        return r102;
    L25:
        r128 = this;
    L7:
        r100 = new RevMessageManagerServiceImpl$onStartAsync$1(this, r110);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.d
    public final ek u4(String r100, String r101) {
        if (this.f157407d == null) goto L9;
        Long r102 = StringsKt.toLongOrNull(r100);
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
    L11:
        return ag1.c.c(r103, r101);
    L7:
        r103 = 0;
        goto L11
    L9:
        return null;
    }
}
