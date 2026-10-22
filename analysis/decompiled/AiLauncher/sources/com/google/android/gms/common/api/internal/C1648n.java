package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.C1643i;
import com.google.android.gms.common.internal.C1669j;

/* renamed from: com.google.android.gms.common.api.internal.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1648n<A extends a.b, L> {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1647m<A, L> f19647a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC1652s f19648b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f19649c;

    /* renamed from: com.google.android.gms.common.api.internal.n$a */
    public static class a<A extends a.b, L> {

        /* renamed from: a, reason: collision with root package name */
        public InterfaceC1649o f19650a;

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC1649o f19651b;

        /* renamed from: d, reason: collision with root package name */
        public C1643i f19653d;

        /* renamed from: e, reason: collision with root package name */
        public Feature[] f19654e;

        /* renamed from: g, reason: collision with root package name */
        public int f19656g;

        /* renamed from: c, reason: collision with root package name */
        public Runnable f19652c = new Runnable() { // from class: com.google.android.gms.common.api.internal.a0
            @Override // java.lang.Runnable
            public final void run() {
            }
        };

        /* renamed from: f, reason: collision with root package name */
        public boolean f19655f = true;

        public /* synthetic */ a(d0 d0Var) {
        }

        public C1648n<A, L> a() {
            C1669j.b(this.f19650a != null, "Must set register function");
            C1669j.b(this.f19651b != null, "Must set unregister function");
            C1669j.b(this.f19653d != null, "Must set holder");
            return new C1648n<>(new C1636b0(this, this.f19653d, this.f19654e, this.f19655f, this.f19656g), new c0(this, (C1643i.a) C1669j.l(this.f19653d.b(), "Key must not be null")), this.f19652c, null);
        }

        public a<A, L> b(InterfaceC1649o<A, D2.j<Void>> interfaceC1649o) {
            this.f19650a = interfaceC1649o;
            return this;
        }

        public a<A, L> c(boolean z10) {
            this.f19655f = z10;
            return this;
        }

        public a<A, L> d(Feature... featureArr) {
            this.f19654e = featureArr;
            return this;
        }

        public a<A, L> e(int i10) {
            this.f19656g = i10;
            return this;
        }

        public a<A, L> f(InterfaceC1649o<A, D2.j<Boolean>> interfaceC1649o) {
            this.f19651b = interfaceC1649o;
            return this;
        }

        public a<A, L> g(C1643i<L> c1643i) {
            this.f19653d = c1643i;
            return this;
        }
    }

    public /* synthetic */ C1648n(AbstractC1647m abstractC1647m, AbstractC1652s abstractC1652s, Runnable runnable, e0 e0Var) {
        this.f19647a = abstractC1647m;
        this.f19648b = abstractC1652s;
        this.f19649c = runnable;
    }

    public static <A extends a.b, L> a<A, L> a() {
        return new a<>(null);
    }
}
