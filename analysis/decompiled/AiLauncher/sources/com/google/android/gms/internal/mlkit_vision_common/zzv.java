package com.google.android.gms.internal.mlkit_vision_common;

import A2.F1;
import java.util.AbstractMap;

/* loaded from: classes2.dex */
final class zzv extends zzp {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzw f20181c;

    public zzv(zzw zzwVar) {
        this.f20181c = zzwVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        F1.a(i10, this.f20181c.f20184e, "index");
        zzw zzwVar = this.f20181c;
        int i11 = i10 + i10;
        Object obj = zzwVar.f20183d[i11];
        obj.getClass();
        Object obj2 = zzwVar.f20183d[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f20181c.f20184e;
    }
}
