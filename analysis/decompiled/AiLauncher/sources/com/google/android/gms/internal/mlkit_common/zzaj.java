package com.google.android.gms.internal.mlkit_common;

import java.util.Set;
import y2.AbstractC5927h;
import y2.C5925f;

/* loaded from: classes2.dex */
public abstract class zzaj extends zzab implements Set {

    /* renamed from: b, reason: collision with root package name */
    public transient zzaf f19920b;

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
        return C5925f.a(this);
    }

    public final zzaf i() {
        zzaf zzafVar = this.f19920b;
        if (zzafVar != null) {
            return zzafVar;
        }
        zzaf zzafVarJ = j();
        this.f19920b = zzafVarJ;
        return zzafVarJ;
    }

    public zzaf j() {
        Object[] array = toArray();
        AbstractC5927h abstractC5927h = zzaf.f19916b;
        return zzaf.j(array, array.length);
    }
}
