package com.google.android.gms.internal.mlkit_vision_common;

import A2.C0576b;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class zzs extends zzl implements Set {

    /* renamed from: b, reason: collision with root package name */
    public transient zzp f20177b;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return C0576b.a(this);
    }

    public final zzp i() {
        zzp zzpVar = this.f20177b;
        if (zzpVar != null) {
            return zzpVar;
        }
        zzp zzpVarJ = j();
        this.f20177b = zzpVarJ;
        return zzpVarJ;
    }

    public zzp j() {
        return zzp.j(toArray());
    }
}
