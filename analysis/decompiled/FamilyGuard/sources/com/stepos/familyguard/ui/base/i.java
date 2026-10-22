package com.stepos.familyguard.ui.base;

import V1.l;
import android.app.Application;
import androidx.lifecycle.B;
import com.stepos.familyguard.R;
import com.stepos.familyguard.net.entity.BaseEntity;
import f2.C0702g;
import java.util.concurrent.TimeUnit;
import m2.C0858a;

/* loaded from: classes.dex */
public abstract class i<CR, VR> extends j {

    /* renamed from: e, reason: collision with root package name */
    protected Q1.c<A3.c> f14796e;

    /* renamed from: f, reason: collision with root package name */
    protected Q1.c<A3.c> f14797f;

    /* renamed from: g, reason: collision with root package name */
    private a f14798g;

    /* renamed from: h, reason: collision with root package name */
    private b<VR> f14799h;

    public interface a {
        void a(boolean z5);
    }

    public interface b<VR> {
        void a(boolean z5, String str, String str2, VR vr);
    }

    public i(Application application) {
        super(application);
        this.f14796e = Q1.c.a();
        this.f14797f = Q1.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(int i5, Long l5) {
        a0().k(Long.valueOf(i5 - l5.longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(String str, String str2, BaseEntity baseEntity) {
        P(2).a();
        j0(str, str2, baseEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(String str, String str2, Throwable th) {
        P(3).b(l0(th)).a();
        i0(str, str2, th);
    }

    private String l0(Throwable th) {
        return (C0858a.a(th) != 0 || C0858a.d(th)) ? C0858a.b(th) : K().getString(R.string.fg_error_login_code_invalid);
    }

    public void X() {
        final int iY = Y();
        Z().c(new l());
        m0(Q1.c.e(x3.f.y(0L, 1L, TimeUnit.SECONDS).Z(iY + 1).T(new D3.c() { // from class: r2.w
            @Override // D3.c
            public final void accept(Object obj) {
                this.f19994a.d0(iY, (Long) obj);
            }
        }, S1.a.b())));
    }

    public int Y() {
        return 60;
    }

    public abstract Q1.c<A3.c> Z();

    public abstract B<Long> a0();

    protected abstract x3.f<BaseEntity<CR>> b0(String str);

    protected abstract x3.f<BaseEntity<VR>> c0(String str, String str2);

    protected void g0(Throwable th) {
        C0702g.b("BaseVerifyCodeModel", "onRequestVerifyCodeError() called with: throwable = [" + th + "]");
        P(3).b(C0858a.b(th)).a();
        a aVar = this.f14798g;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    protected void h0(BaseEntity<CR> baseEntity) {
        P(2).a();
        C0702g.b("BaseVerifyCodeModel", "onRequestVerifyCodeSucceed() called with: result = [" + baseEntity + "]");
        if (baseEntity == null || baseEntity.code != 200) {
            return;
        }
        X();
        a aVar = this.f14798g;
        if (aVar != null) {
            aVar.a(true);
        }
    }

    protected void i0(String str, String str2, Throwable th) {
        C0702g.b("BaseVerifyCodeModel", "onVerifyError() called with: throwable = [" + th + "]");
        b<VR> bVar = this.f14799h;
        if (bVar != null) {
            bVar.a(false, str, str2, null);
        }
    }

    protected void j0(String str, String str2, BaseEntity<VR> baseEntity) {
        b<VR> bVar;
        C0702g.b("BaseVerifyCodeModel", "onVerifySucceed() called with: result = [" + baseEntity + "]");
        if (baseEntity == null || baseEntity.code != 200 || (bVar = this.f14799h) == null) {
            return;
        }
        bVar.a(true, str, str2, baseEntity.value);
    }

    public void k0(String str) {
        this.f14796e.c(new l());
        this.f14796e = Q1.c.e(R(b0(str), new Q1.b() { // from class: com.stepos.familyguard.ui.base.g
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f14794a.h0((BaseEntity) obj);
            }
        }, new Q1.b() { // from class: com.stepos.familyguard.ui.base.h
            @Override // Q1.b
            public final void accept(Object obj) {
                this.f14795a.g0((Throwable) obj);
            }
        }));
    }

    public abstract void m0(Q1.c<A3.c> cVar);

    public void n0(a aVar) {
        this.f14798g = aVar;
    }

    public void o0(b<VR> bVar) {
        this.f14799h = bVar;
    }

    public void p0(final String str, final String str2) {
        this.f14797f.c(new l());
        P(1).a();
        this.f14797f = Q1.c.e(c0(str, str2).X(T3.a.c()).T(new D3.c() { // from class: r2.u
            @Override // D3.c
            public final void accept(Object obj) {
                this.f19988a.e0(str, str2, (BaseEntity) obj);
            }
        }, S1.a.c(new D3.c() { // from class: r2.v
            @Override // D3.c
            public final void accept(Object obj) {
                this.f19991a.f0(str, str2, (Throwable) obj);
            }
        })));
    }
}
