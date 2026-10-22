package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.C1643i;

/* renamed from: com.google.android.gms.common.api.internal.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1647m<A extends a.b, L> {

    /* renamed from: a, reason: collision with root package name */
    public final C1643i f19642a;

    /* renamed from: b, reason: collision with root package name */
    public final Feature[] f19643b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19644c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19645d;

    public AbstractC1647m(C1643i<L> c1643i, Feature[] featureArr, boolean z10, int i10) {
        this.f19642a = c1643i;
        this.f19643b = featureArr;
        this.f19644c = z10;
        this.f19645d = i10;
    }

    public void a() {
        this.f19642a.a();
    }

    public C1643i.a<L> b() {
        return this.f19642a.b();
    }

    public Feature[] c() {
        return this.f19643b;
    }

    public abstract void d(A a10, D2.j<Void> jVar) throws RemoteException;

    public final int e() {
        return this.f19645d;
    }

    public final boolean f() {
        return this.f19644c;
    }
}
