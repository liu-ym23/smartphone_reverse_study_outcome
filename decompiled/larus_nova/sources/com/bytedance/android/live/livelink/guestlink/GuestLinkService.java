package com.bytedance.android.live.livelink.guestlink;

import android.content.Context;
import com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.GuestLinkMainPageDialogForLinker;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import lb6.c;
import lb6.d;
import sb6.b;

/* JADX INFO: loaded from: classes46.dex */
public final class GuestLinkService extends c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f81191k = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f81192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f81193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f81194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f81195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f81196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f81197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f81198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f81199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final fc6.a f81200j;

    public static final class a {
    }

    static {
    }

    public final b q() {
        return (b) this.f81197g.getValue();
    }

    @Override // lb6.e
    public final void detach() {
        jy0.b.d("GuestLinkService", "detach");
        Iterator<d> r100 = this.f508351a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().detach();
        goto L4
    L6:
        this.f508351a.clear();
        this.f81198h.set(false);
    }

    @Override // lb6.g
    public final mb6.b f() {
        return (mb6.b) this.f81192b.getValue();
    }

    @Override // lb6.g
    public final ob6.a j() {
        return (ob6.a) this.f81195e.getValue();
    }

    public final void o() {
        jy0.b.d("GuestLinkService", LynxViewpagerItem.BIND_ON_ATTACH);
        n((mb6.b) this.f81192b.getValue());
        n((qb6.a) this.f81194d.getValue());
        n((rb6.a) this.f81193c.getValue());
        n(q());
        n((ob6.a) this.f81195e.getValue());
    }

    public final void p() {
        if (this.f81198h.get() == true) goto L6;
        LinkMonitor.a("GuestLinkService", "GuestLinkService is not Init", "invoke init() first " + ExceptionsKt.stackTraceToString(new Throwable()), null, null, false, 120);
        return;
    }

    @Override // lb6.g
    public final boolean e() {
        p();
        return q().e();
    }

    @Override // lb6.g
    public final sb6.a getLinkState() {
        return q().getLinkState();
    }

    @Override // lb6.g
    public final void b(lb6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        q().b(r100);
    }

    @Override // lb6.g
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        p();
        q().k(r100);
    }

    @Override // lb6.g
    public final void a(int r100, GuestLinkMainPageDialogForLinker.g r101) {
        q().a(r100, r101);
    }

    @Override // lb6.g
    public final void d(lb6.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        p();
        q().d(r100, r101);
    }

    @Override // lb6.g
    public final void m(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        this.f81198h.set(true);
        nb6.a r102 = new nb6.a(r101);
        q().j(r102);
    }

    public GuestLinkService(final Context r100, boolean r101, fc6.a r102, bn0.b r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "hostService");
        Intrinsics.checkNotNullParameter(r103, "multiLinkRoomScope");
        this.f81199i = r101;
        this.f81200j = r102;
        this.f81192b = LazyKt.lazy(GuestLinkService$mApiManager$2.INSTANCE);
        this.f81193c = LazyKt.lazy(new GuestLinkService$mPermissionManager$2(this));
        this.f81194d = LazyKt.lazy(new GuestLinkService$mMsgManager$2(r100));
        this.f81195e = LazyKt.lazy(new GuestLinkService$mMediaManager$2(this, r100));
        this.f81196f = LazyKt.lazy(GuestLinkService$mCountDownManager$2.INSTANCE);
        this.f81197g = LazyKt.lazy(new GuestLinkService$mPipelineManager$2(this, r100));
        this.f81198h = new AtomicBoolean(false);
    }

    @Override // lb6.g
    public final void g(long r100, long r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "source");
        p();
        q().g(r100, r110, r111, r112);
    }

    @Override // lb6.g
    public final void h(long r100, long r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "source");
        Intrinsics.checkNotNullParameter(r112, "requestSource");
        q().h(r100, r110, r111, r112);
    }

    @Override // lb6.g
    public final void i(long r110, long r111, long r112, long r113) {
        p();
        q().i(r110, r111, r112, r113);
    }

    @Override // lb6.g
    public final void c(long r110, long r111, String r112, String r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r112, "source");
        Intrinsics.checkNotNullParameter(r113, "requestSource");
        p();
        q().c(r110, r111, r112, r113, r114);
    }

    @Override // lb6.g
    public final void l(long r110, long r111, int r112, int r113, String r210, String r211, long r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, "rtcExtInfo");
        p();
        q().l(r110, r111, r112, r113, r210, r211, r212, r213);
    }
}
