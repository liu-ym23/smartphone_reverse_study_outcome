package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.android.livesdk.message.model.qa;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class RedPacketIconModelLoadService implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f88550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f88551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y0 f88552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bv0.b f88553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c01.a f88554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final yz0.k f88555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RedPacketHybridService f88556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r0 f88557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ny0.a f88558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LuckyBoxClientService f88559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final yz0.l f88560k;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RedPacketIconModelLoadService f88561a;

        public a(RedPacketIconModelLoadService r100) {
            this.f88561a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RedPacketIconModelLoadService r101 = this.f88561a;
            com.bytedance.android.live.profit.redpacket.model.e r102 = new com.bytedance.android.live.profit.redpacket.model.e();
            r102.c(((qa) r100).getRawPayload());
            Unit r103 = Unit.INSTANCE;
            r101.c(r102);
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (this.f88551b.p().f88651a == false) goto L10;
        this.f88554e.D9(b1.class, new AnonymousClass1(this));
        if (this.f88551b.p().f88653c == false) goto L12;
        com.bytedance.android.livesdk.revenue.service.message.d r100 = (com.bytedance.android.livesdk.revenue.service.message.d) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.message.d.class));
        if (r100 == null) goto L9;
        r100.i1("WebcastLuckyBoxMessage");
    L9:
        RxUtilKt.c(new RedPacketIMDataSource(this.f88560k, this.f88550a).f88512d.take(1).subscribe(new a(this)), this.f88550a);
        com.bytedance.android.livesdk.revenue.service.room.b.a.a((com.bytedance.android.livesdk.revenue.service.room.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class), this.f88555f.getRoom().getRoomId(), com.bytedance.android.live.profit.redpacket.model.b.class, new RedPacketIconModelLoadService$runWithBackendData$1(this), null, null, new RedPacketIconModelLoadService$runWithBackendData$2(this), this.f88550a, 24);
        return;
    L12:
        return;
    L10:
        this.f88554e.D9(RedPacketIconModel.class, new AnonymousClass3(this));
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f88550a.dispose();
    }

    public static final void a(RedPacketIconModelLoadService r100) {
        r100.getClass();
        int r101 = h.f88608a;
        RxUtilKt.c(h.b(r100.f88555f.getRoom().getId()).subscribe(new m0(r100)), r100.f88550a);
    }

    public final void c(com.bytedance.android.live.profit.redpacket.model.e r100) {
        lz0.a r101 = (lz0.a) this.f88558i.x(Reflection.getOrCreateKotlinClass(lz0.a.class), CenterServiceType.CENTER_SERVICE);
        lz0.b r102 = new lz0.b();
        r102.c();
        if (r100 == null) goto L5;
        uh7.c.f550106d.getClass();
        byte[] r103 = uh7.c.f(r100);
    L6:
        r102.d(r103);
        Unit r104 = Unit.INSTANCE;
        RxUtilKt.c(r101.load(r102).subscribe(), this.f88550a);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public RedPacketIconModelLoadService(w0 r100, y0 r101, bv0.b r102, c01.a r103, yz0.k r104, RedPacketHybridService r105, r0 r106, ny0.a r107, LuckyBoxClientService r110, yz0.l r111) {
        Intrinsics.checkNotNullParameter(r100, "redPacketScope");
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "redPacketDressService");
        Intrinsics.checkNotNullParameter(r103, "stiService");
        Intrinsics.checkNotNullParameter(r104, "roomDataService");
        Intrinsics.checkNotNullParameter(r105, "redPackerHybridService");
        Intrinsics.checkNotNullParameter(r106, "redPacketRepository");
        Intrinsics.checkNotNullParameter(r107, "rpcService");
        Intrinsics.checkNotNullParameter(r110, "clientService");
        Intrinsics.checkNotNullParameter(r111, "messageService");
        this.f88551b = r100;
        this.f88552c = r101;
        this.f88553d = r102;
        this.f88554e = r103;
        this.f88555f = r104;
        this.f88556g = r105;
        this.f88557h = r106;
        this.f88558i = r107;
        this.f88559j = r110;
        this.f88560k = r111;
        this.f88550a = new CompositeDisposable();
    }
}
