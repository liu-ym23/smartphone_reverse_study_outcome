package cc6;

import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f23304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f23305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f23306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f23307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f23308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f23309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f23310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f23311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f23312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f23313j;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "inReplyLink " + this.f23304a + " inApplyLink " + this.f23305b + " inJoinLink " + this.f23306c;
    }

    public c() {
        this.f23304a = new AtomicBoolean(false);
        this.f23305b = new AtomicBoolean(false);
        this.f23306c = new AtomicBoolean(false);
        this.f23307d = new AtomicBoolean(false);
        this.f23308e = new AtomicBoolean(false);
        this.f23309f = new AtomicBoolean(false);
        this.f23310g = new AtomicBoolean(false);
        this.f23311h = new AtomicBoolean(false);
        this.f23312i = new AtomicBoolean(false);
        this.f23313j = new AtomicBoolean(false);
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        LinkMonitor.a("LinkState", "resetLinkState", r100, null, null, false, 120);
        this.f23304a.set(false);
        this.f23305b.set(false);
        this.f23306c.set(false);
        this.f23308e.set(false);
        this.f23309f.set(false);
        this.f23307d.set(false);
        this.f23310g.set(false);
        this.f23311h.set(false);
        this.f23312i.set(false);
        this.f23313j.set(false);
    }

    public final void b(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        LinkMonitor.a("LinkState", "setInApplyLink", r100 + " : " + r110, null, null, false, 120);
        this.f23305b.set(r100);
    }

    public final void c(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        LinkMonitor.a("LinkState", "setInReplyLink", r100 + " : " + r110, null, null, false, 120);
        this.f23304a.set(r100);
    }

    public final void d(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        LinkMonitor.a("LinkState", "setIsApplyAutoLinkEarlyInitRtc", r100 + " : " + r110, null, null, false, 120);
        this.f23310g.set(r100);
    }

    public final void e(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        LinkMonitor.a("LinkState", "setIsApplyNormalEarlyInitRtc", r100 + " : " + r110, null, null, false, 120);
        this.f23313j.set(r100);
    }

    public final void f(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        LinkMonitor.a("LinkState", "setIsCloseLink", r100 + " : " + r110, null, null, false, 120);
        this.f23307d.set(r100);
    }

    public final void g(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        LinkMonitor.a("LinkState", "setIsJoinChannelFinish", " " + r100 + " : " + r110, null, null, false, 120);
        this.f23308e.set(r100);
    }

    public final void h(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        LinkMonitor.a("LinkState", "setIsJoiningChannel", " " + r100 + " : " + r110, null, null, false, 120);
        this.f23309f.set(r100);
    }

    public final void i(boolean r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        LinkMonitor.a("LinkState", "setIsReplyMergeJoinChannel", r100 + " : " + r110, null, null, false, 120);
        this.f23311h.set(r100);
    }
}
