package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Set;
import z2.AbstractC6073Q;
import z2.C6070N;

/* loaded from: classes2.dex */
public abstract class zzcv extends zzcn implements Set {

    /* renamed from: b, reason: collision with root package name */
    public transient zzcs f19992b;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return C6070N.b(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return C6070N.a(this);
    }

    public final zzcs j() {
        zzcs zzcsVar = this.f19992b;
        if (zzcsVar != null) {
            return zzcsVar;
        }
        zzcs zzcsVarK = k();
        this.f19992b = zzcsVarK;
        return zzcsVarK;
    }

    public zzcs k() {
        Object[] array = toArray();
        AbstractC6073Q abstractC6073Q = zzcs.f19988b;
        return zzcs.k(array, array.length);
    }
}
