package e;

import com.bytedance.crash.dumper.Scraps;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ForwardingTimeout.kt */
/* JADX INFO: loaded from: classes4.dex */
public class k extends ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ab f38729a;

    public final ab a() {
        return this.f38729a;
    }

    public k(ab r2) {
        d.h.b.o.e(r2, "delegate");
        this.f38729a = r2;
    }

    public final k a(ab r2) {
        d.h.b.o.e(r2, "delegate");
        this.f38729a = r2;
        return this;
    }

    @Override // e.ab
    public ab a(long r2, TimeUnit r4) {
        d.h.b.o.e(r4, Scraps.INNER_UNIT);
        return this.f38729a.a(r2, r4);
    }

    @Override // e.ab
    public long y_() {
        return this.f38729a.y_();
    }

    @Override // e.ab
    public boolean u_() {
        return this.f38729a.u_();
    }

    @Override // e.ab
    public long d() {
        return this.f38729a.d();
    }

    @Override // e.ab
    public ab a(long r1) {
        return this.f38729a.a(r1);
    }

    @Override // e.ab
    public ab v_() {
        return this.f38729a.v_();
    }

    @Override // e.ab
    public ab w_() {
        return this.f38729a.w_();
    }

    @Override // e.ab
    public void x_() {
        this.f38729a.x_();
    }
}
