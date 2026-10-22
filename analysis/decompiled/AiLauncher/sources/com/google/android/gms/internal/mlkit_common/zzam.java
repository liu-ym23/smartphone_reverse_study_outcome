package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractMap;
import java.util.Objects;
import y2.L;

/* loaded from: classes2.dex */
final class zzam extends zzaf {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzan f19924c;

    public zzam(zzan zzanVar) {
        this.f19924c = zzanVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i10) {
        L.a(i10, this.f19924c.f19927e, "index");
        int i11 = i10 + i10;
        Object obj = this.f19924c.f19926d[i11];
        Objects.requireNonNull(obj);
        Object obj2 = this.f19924c.f19926d[i11 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19924c.f19927e;
    }
}
