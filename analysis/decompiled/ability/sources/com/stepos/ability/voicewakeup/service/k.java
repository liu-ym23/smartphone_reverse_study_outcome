package com.stepos.ability.voicewakeup.service;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3332a;
    public final int b;

    public k(boolean z10, int i) {
        this.f3332a = z10;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f3332a == kVar.f3332a && this.b == kVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Boolean.hashCode(this.f3332a) * 31);
    }

    public final String toString() {
        return "IntentSnapshot(enabled=" + this.f3332a + ", generation=" + this.b + ")";
    }
}
