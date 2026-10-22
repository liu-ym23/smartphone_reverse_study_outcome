package com.bytedance.android.live.livelink.multilink;

import android.content.Context;
import bn0.b;
import com.bytedance.kmp.live.livelink.api.multilink.config.MultiLinkConfig;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import vb6.c;
import vb6.d;
import vb6.f;
import vb6.g;
import yb6.e;

/* JADX INFO: loaded from: classes46.dex */
public final class MultiLinkService extends c implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f81261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f81262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f81263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f81264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f81265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f81266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f81267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f81268i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final fc6.a f81269j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f81270k;

    public static final class a {
    }

    static {
    }

    public final cc6.a i() {
        return (cc6.a) this.f81265f.getValue();
    }

    @Override // vb6.g
    public final ac6.a a() {
        return (ac6.a) this.f81263d.getValue();
    }

    @Override // vb6.e
    public final void attach() {
        d((wb6.a) this.f81261b.getValue());
        d((ac6.a) this.f81263d.getValue());
        d((bc6.a) this.f81262c.getValue());
        d(i());
        d((e) this.f81264e.getValue());
    }

    public final void e() {
        if (this.f81266g.get() == true) goto L6;
        LinkMonitor.a("MultiLinkService", "MultiLinkService is not Init", "invoke init() first " + ExceptionsKt.stackTraceToString(new Throwable()), null, null, false, 120);
        return;
    }

    @Override // vb6.g
    public final wb6.a f() {
        return (wb6.a) this.f81261b.getValue();
    }

    @Override // vb6.g
    public final e j() {
        return (e) this.f81264e.getValue();
    }

    public final Context getContext() {
        return this.f81267h;
    }

    @Override // vb6.g
    public final void E0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        i().E0(r100);
    }

    @Override // vb6.g
    public final void a1(f r100) {
        i().a1(r100);
    }

    @Override // vb6.g
    public final void c1(int r100) {
        e();
        i().c1(r100);
    }

    @Override // vb6.g
    public final void f1(xb6.b r100) {
        i().f1(r100);
    }

    @Override // vb6.g
    public final void g(f r100) {
        i().g(r100);
    }

    @Override // vb6.g
    public final void g1(xb6.a r100) {
        i().g1(r100);
    }

    @Override // vb6.e
    public final void h(xb6.b r100) {
        Iterator<d> r101 = this.f554065a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().h(r100);
        goto L4
    L6:
        this.f554065a.clear();
        this.f81266g.set(false);
    }

    @Override // vb6.g
    public final void W0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r101, "source");
        i().W0(r100, r101);
    }

    @Override // vb6.g
    public final void X0(f r100, boolean r101) {
        e();
        i().X0(r100, r101);
    }

    @Override // vb6.g
    public final void b1(xb6.a r100, boolean r101) {
        e();
        i().b1(r100, r101);
    }

    @Override // vb6.g
    public final void d1(int r100, int r101) {
        e();
        i().d1(r100, r101);
    }

    @Override // vb6.g
    public final void e1(xb6.b r100, boolean r101) {
        e();
        i().e1(r100, r101);
    }

    @Override // vb6.g
    public final void i1(String r100, boolean r101) {
        e();
        i().i1(r100, r101);
    }

    @Override // vb6.g
    public final void O0(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r101, "rtcExtInfo");
        i().O0(r100, r101, r102);
    }

    @Override // vb6.g
    public final void b(long r100, String r101, xb6.c r102) {
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        this.f81266g.set(true);
        MultiLinkConfig r103 = new MultiLinkConfig(this.f81268i, r100, r101);
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "preRtcInfo");
        r103.f252221l = r102;
    L5:
        i().k1(r103);
    }

    @Override // vb6.g
    public final void h1(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "liveCoreExtInfo");
        Intrinsics.checkNotNullParameter(r101, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r102, "source");
        i().h1(r100, r101, r102);
    }

    public MultiLinkService(Context r100, boolean r101, fc6.a r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "hostService");
        Intrinsics.checkNotNullParameter(r103, "multiLinkRoomScope");
        this.f81267h = r100;
        this.f81268i = r101;
        this.f81269j = r102;
        this.f81270k = r103;
        this.f81261b = LazyKt.lazy(new MultiLinkService$mApiManager$2(this));
        this.f81262c = LazyKt.lazy(new MultiLinkService$mPermissionManager$2(this));
        this.f81263d = LazyKt.lazy(MultiLinkService$mMsgManager$2.INSTANCE);
        this.f81264e = LazyKt.lazy(new MultiLinkService$mMediaManager$2(this));
        this.f81265f = LazyKt.lazy(new MultiLinkService$mPipelineManager$2(this));
        this.f81266g = new AtomicBoolean(false);
    }

    @Override // vb6.g
    public final void Y0(boolean r100, boolean r101, boolean r110, boolean r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "source");
        i().Y0(r111, r101, r110, r100, r112);
    }

    @Override // vb6.g
    public final void c(int r100, String r101, String r102, int r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r101, "replySecToUserId");
        Intrinsics.checkNotNullParameter(r102, "replyToUserIdString");
        e();
        i().j1(r100, r101, r102, r110, r112);
    }
}
