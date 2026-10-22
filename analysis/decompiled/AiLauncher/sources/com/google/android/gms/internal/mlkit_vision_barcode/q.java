package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Map;
import z2.AbstractC6225p;
import z2.C6175k;

/* loaded from: classes2.dex */
public final class q extends AbstractC6225p {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19966a;

    /* renamed from: b, reason: collision with root package name */
    public int f19967b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzci f19968c;

    public q(zzci zzciVar, int i10) {
        this.f19968c = zzciVar;
        this.f19966a = zzci.m(zzciVar, i10);
        this.f19967b = i10;
    }

    public final void a() {
        int i10 = this.f19967b;
        if (i10 == -1 || i10 >= this.f19968c.size() || !C6175k.a(this.f19966a, zzci.m(this.f19968c, this.f19967b))) {
            this.f19967b = this.f19968c.H(this.f19966a);
        }
    }

    @Override // z2.AbstractC6225p, java.util.Map.Entry
    public final Object getKey() {
        return this.f19966a;
    }

    @Override // z2.AbstractC6225p, java.util.Map.Entry
    public final Object getValue() {
        Map mapU = this.f19968c.u();
        if (mapU != null) {
            return mapU.get(this.f19966a);
        }
        a();
        int i10 = this.f19967b;
        if (i10 == -1) {
            return null;
        }
        return zzci.s(this.f19968c, i10);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapU = this.f19968c.u();
        if (mapU != null) {
            return mapU.put(this.f19966a, obj);
        }
        a();
        int i10 = this.f19967b;
        if (i10 == -1) {
            this.f19968c.put(this.f19966a, obj);
            return null;
        }
        zzci zzciVar = this.f19968c;
        Object objS = zzci.s(zzciVar, i10);
        zzci.w(zzciVar, this.f19967b, obj);
        return objS;
    }
}
