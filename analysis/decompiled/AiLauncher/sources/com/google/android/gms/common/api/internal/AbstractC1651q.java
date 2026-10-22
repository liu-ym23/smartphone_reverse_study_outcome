package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.internal.C1669j;

/* renamed from: com.google.android.gms.common.api.internal.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1651q<A extends a.b, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    public final Feature[] f19662a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19663b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19664c;

    /* renamed from: com.google.android.gms.common.api.internal.q$a */
    public static class a<A extends a.b, ResultT> {

        /* renamed from: a, reason: collision with root package name */
        public InterfaceC1649o f19665a;

        /* renamed from: c, reason: collision with root package name */
        public Feature[] f19667c;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19666b = true;

        /* renamed from: d, reason: collision with root package name */
        public int f19668d = 0;

        public /* synthetic */ a(j0 j0Var) {
        }

        public AbstractC1651q<A, ResultT> a() {
            C1669j.b(this.f19665a != null, "execute parameter required");
            return new i0(this, this.f19667c, this.f19666b, this.f19668d);
        }

        public a<A, ResultT> b(InterfaceC1649o<A, D2.j<ResultT>> interfaceC1649o) {
            this.f19665a = interfaceC1649o;
            return this;
        }

        public a<A, ResultT> c(boolean z10) {
            this.f19666b = z10;
            return this;
        }

        public a<A, ResultT> d(Feature... featureArr) {
            this.f19667c = featureArr;
            return this;
        }

        public a<A, ResultT> e(int i10) {
            this.f19668d = i10;
            return this;
        }
    }

    public AbstractC1651q(Feature[] featureArr, boolean z10, int i10) {
        this.f19662a = featureArr;
        boolean z11 = false;
        if (featureArr != null && z10) {
            z11 = true;
        }
        this.f19663b = z11;
        this.f19664c = i10;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>(null);
    }

    public abstract void b(A a10, D2.j<ResultT> jVar) throws RemoteException;

    public boolean c() {
        return this.f19663b;
    }

    public final int d() {
        return this.f19664c;
    }

    public final Feature[] e() {
        return this.f19662a;
    }
}
