package com.stepos.familyguard.ui.base;

import android.app.Application;
import android.content.DialogInterface;
import androidx.lifecycle.AbstractC0545z;
import androidx.lifecycle.B;
import androidx.lifecycle.C0521a;
import m2.C0858a;

/* loaded from: classes.dex */
public class j extends C0521a {

    /* renamed from: d, reason: collision with root package name */
    private static final b f14800d = new b(0);

    /* renamed from: c, reason: collision with root package name */
    protected final B<b> f14801c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f14802a;

        /* renamed from: b, reason: collision with root package name */
        private final j f14803b;

        /* renamed from: c, reason: collision with root package name */
        private String f14804c;

        /* renamed from: d, reason: collision with root package name */
        private String f14805d;

        /* renamed from: e, reason: collision with root package name */
        private DialogInterface.OnClickListener f14806e;

        /* renamed from: f, reason: collision with root package name */
        private String f14807f;

        /* renamed from: g, reason: collision with root package name */
        private DialogInterface.OnClickListener f14808g;

        /* renamed from: h, reason: collision with root package name */
        private Object f14809h;

        a(int i5, j jVar) {
            this.f14802a = i5;
            this.f14803b = jVar;
        }

        public void a() {
            this.f14803b.f14801c.k(new b(this.f14802a, this.f14803b, this.f14804c, this.f14805d, this.f14806e, this.f14807f, this.f14808g, this.f14809h));
        }

        public a b(String str) {
            this.f14804c = str;
            return this;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f14810a;

        /* renamed from: b, reason: collision with root package name */
        public final j f14811b;

        /* renamed from: c, reason: collision with root package name */
        public final String f14812c;

        /* renamed from: d, reason: collision with root package name */
        public final String f14813d;

        /* renamed from: e, reason: collision with root package name */
        public final DialogInterface.OnClickListener f14814e;

        /* renamed from: f, reason: collision with root package name */
        public final String f14815f;

        /* renamed from: g, reason: collision with root package name */
        public final DialogInterface.OnClickListener f14816g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f14817h;

        b(int i5) {
            this(i5, null, null, null, null, null, null, null);
        }

        public String toString() {
            return "DialogState{state=" + this.f14810a + ", viewModel=" + this.f14811b + ", message='" + this.f14812c + "', positiveStr='" + this.f14813d + "', positiveListener=" + this.f14814e + ", negativeStr='" + this.f14815f + "', negativeListener=" + this.f14816g + ", data=" + this.f14817h + '}';
        }

        b(int i5, j jVar, String str, String str2, DialogInterface.OnClickListener onClickListener, String str3, DialogInterface.OnClickListener onClickListener2, Object obj) {
            this.f14810a = i5;
            this.f14811b = jVar;
            this.f14812c = str;
            this.f14813d = str2;
            this.f14814e = onClickListener;
            this.f14815f = str3;
            this.f14816g = onClickListener2;
            this.f14817h = obj;
        }
    }

    public j(Application application) {
        super(application);
        this.f14801c = new B<>();
    }

    public static /* synthetic */ void M(Q1.b bVar, Object obj) {
        if (bVar != null) {
            bVar.accept(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(Q1.b bVar, Throwable th) {
        if (bVar != null) {
            bVar.accept(th);
        }
        P(3).b(C0858a.b(th)).a();
    }

    public AbstractC0545z<b> N() {
        return this.f14801c;
    }

    protected a P(int i5) {
        return new a(i5, this);
    }

    public void Q() {
        this.f14801c.k(f14800d);
    }

    protected <T> A3.c R(x3.f<T> fVar, Q1.b<T> bVar, Q1.b<Throwable> bVar2) {
        P(1).a();
        return fVar.X(T3.a.c()).T(T(bVar), S(bVar2));
    }

    protected D3.c<Throwable> S(final Q1.b<Throwable> bVar) {
        return S1.a.c(new D3.c() { // from class: r2.y
            @Override // D3.c
            public final void accept(Object obj) {
                this.f19997a.O(bVar, (Throwable) obj);
            }
        });
    }

    protected <T> D3.c<T> T(final Q1.b<T> bVar) {
        return new D3.c() { // from class: r2.x
            @Override // D3.c
            public final void accept(Object obj) {
                com.stepos.familyguard.ui.base.j.M(bVar, obj);
            }
        };
    }
}
