package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.C1668i;

/* loaded from: classes2.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public final C1635b f19555a;

    /* renamed from: b, reason: collision with root package name */
    public final Feature f19556b;

    public /* synthetic */ L(C1635b c1635b, Feature feature, K k10) {
        this.f19555a = c1635b;
        this.f19556b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof L)) {
            L l10 = (L) obj;
            if (C1668i.a(this.f19555a, l10.f19555a) && C1668i.a(this.f19556b, l10.f19556b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return C1668i.b(this.f19555a, this.f19556b);
    }

    public final String toString() {
        return C1668i.c(this).a("key", this.f19555a).a("feature", this.f19556b).toString();
    }
}
