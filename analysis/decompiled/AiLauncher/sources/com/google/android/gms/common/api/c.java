package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.AbstractC1651q;
import com.google.android.gms.common.api.internal.C1633a;
import com.google.android.gms.common.api.internal.C1635b;
import com.google.android.gms.common.api.internal.C1640f;
import com.google.android.gms.common.api.internal.C1643i;
import com.google.android.gms.common.api.internal.C1644j;
import com.google.android.gms.common.api.internal.C1648n;
import com.google.android.gms.common.api.internal.C1655v;
import com.google.android.gms.common.api.internal.InterfaceC1650p;
import com.google.android.gms.common.api.internal.J;
import com.google.android.gms.common.api.internal.O;
import com.google.android.gms.common.api.internal.ServiceConnectionC1645k;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.AbstractC1662c;
import com.google.android.gms.common.internal.C1663d;
import com.google.android.gms.common.internal.C1669j;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* loaded from: classes2.dex */
public abstract class c<O extends a.d> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19496a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19497b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.a f19498c;

    /* renamed from: d, reason: collision with root package name */
    public final a.d f19499d;

    /* renamed from: e, reason: collision with root package name */
    public final C1635b f19500e;

    /* renamed from: f, reason: collision with root package name */
    public final Looper f19501f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19502g;

    /* renamed from: h, reason: collision with root package name */
    @NotOnlyInitialized
    public final d f19503h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC1650p f19504i;

    /* renamed from: j, reason: collision with root package name */
    public final C1640f f19505j;

    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final a f19506c = new C0226a().a();

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1650p f19507a;

        /* renamed from: b, reason: collision with root package name */
        public final Looper f19508b;

        /* renamed from: com.google.android.gms.common.api.c$a$a, reason: collision with other inner class name */
        public static class C0226a {

            /* renamed from: a, reason: collision with root package name */
            public InterfaceC1650p f19509a;

            /* renamed from: b, reason: collision with root package name */
            public Looper f19510b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.f19509a == null) {
                    this.f19509a = new C1633a();
                }
                if (this.f19510b == null) {
                    this.f19510b = Looper.getMainLooper();
                }
                return new a(this.f19509a, this.f19510b);
            }
        }

        public a(InterfaceC1650p interfaceC1650p, Account account, Looper looper) {
            this.f19507a = interfaceC1650p;
            this.f19508b = looper;
        }
    }

    public c(Context context, Activity activity, com.google.android.gms.common.api.a aVar, a.d dVar, a aVar2) {
        C1669j.l(context, "Null context is not permitted.");
        C1669j.l(aVar, "Api must not be null.");
        C1669j.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) C1669j.l(context.getApplicationContext(), "The provided context did not have an application context.");
        this.f19496a = context2;
        String attributionTag = context.getAttributionTag();
        this.f19497b = attributionTag;
        this.f19498c = aVar;
        this.f19499d = dVar;
        this.f19501f = aVar2.f19508b;
        C1635b c1635bA = C1635b.a(aVar, dVar, attributionTag);
        this.f19500e = c1635bA;
        this.f19503h = new O(this);
        C1640f c1640fT = C1640f.t(context2);
        this.f19505j = c1640fT;
        this.f19502g = c1640fT.k();
        this.f19504i = aVar2.f19507a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            C1655v.u(activity, c1640fT, c1635bA);
        }
        c1640fT.F(this);
    }

    public C1663d.a d() {
        Account account;
        GoogleSignInAccount googleSignInAccountB;
        GoogleSignInAccount googleSignInAccountB2;
        C1663d.a aVar = new C1663d.a();
        a.d dVar = this.f19499d;
        if (!(dVar instanceof a.d.b) || (googleSignInAccountB2 = ((a.d.b) dVar).b()) == null) {
            a.d dVar2 = this.f19499d;
            account = dVar2 instanceof a.d.InterfaceC0225a ? ((a.d.InterfaceC0225a) dVar2).getAccount() : null;
        } else {
            account = googleSignInAccountB2.getAccount();
        }
        aVar.d(account);
        a.d dVar3 = this.f19499d;
        Set<Scope> requestedScopes = (!(dVar3 instanceof a.d.b) || (googleSignInAccountB = ((a.d.b) dVar3).b()) == null) ? Collections.EMPTY_SET : googleSignInAccountB.getRequestedScopes();
        aVar.c(requestedScopes);
        aVar.e(this.f19496a.getClass().getName());
        aVar.b(this.f19496a.getPackageName());
        return aVar;
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends a.b> D2.i<TResult> e(AbstractC1651q<A, TResult> abstractC1651q) {
        return o(2, abstractC1651q);
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends a.b> D2.i<TResult> f(AbstractC1651q<A, TResult> abstractC1651q) {
        return o(0, abstractC1651q);
    }

    @ResultIgnorabilityUnspecified
    public <A extends a.b> D2.i<Void> g(C1648n<A, ?> c1648n) {
        C1669j.k(c1648n);
        C1669j.l(c1648n.f19647a.b(), "Listener has already been released.");
        C1669j.l(c1648n.f19648b.a(), "Listener has already been released.");
        return this.f19505j.v(this, c1648n.f19647a, c1648n.f19648b, c1648n.f19649c);
    }

    @ResultIgnorabilityUnspecified
    public D2.i<Boolean> h(C1643i.a<?> aVar, int i10) {
        C1669j.l(aVar, "Listener key cannot be null.");
        return this.f19505j.w(this, aVar, i10);
    }

    public final C1635b<O> i() {
        return this.f19500e;
    }

    public String j() {
        return this.f19497b;
    }

    public <L> C1643i<L> k(L l10, String str) {
        return C1644j.a(l10, this.f19501f, str);
    }

    public final int l() {
        return this.f19502g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f m(Looper looper, J j10) {
        C1663d c1663dA = d().a();
        a.f fVarA = ((a.AbstractC0224a) C1669j.k(this.f19498c.a())).a(this.f19496a, looper, c1663dA, this.f19499d, j10, j10);
        String strJ = j();
        if (strJ != null && (fVarA instanceof AbstractC1662c)) {
            ((AbstractC1662c) fVarA).M(strJ);
        }
        if (strJ != null && (fVarA instanceof ServiceConnectionC1645k)) {
            ((ServiceConnectionC1645k) fVarA).p(strJ);
        }
        return fVarA;
    }

    public final zact n(Context context, Handler handler) {
        return new zact(context, handler, d().a());
    }

    public final D2.i o(int i10, AbstractC1651q abstractC1651q) {
        D2.j jVar = new D2.j();
        this.f19505j.B(this, i10, abstractC1651q, jVar, this.f19504i);
        return jVar.a();
    }

    public c(Context context, com.google.android.gms.common.api.a<O> aVar, O o10, a aVar2) {
        this(context, null, aVar, o10, aVar2);
    }
}
