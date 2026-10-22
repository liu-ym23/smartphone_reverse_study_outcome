package com.stepos.ability.sdk.client;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f3253a;
    public final String b;
    public final String c;
    public final Long d;
    public final f e;

    public h(String name, String toolcallId, String str, Long l, f fVar) {
        k.f(name, "name");
        k.f(toolcallId, "toolcallId");
        this.f3253a = name;
        this.b = toolcallId;
        this.c = str;
        this.d = l;
        this.e = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return k.b(this.f3253a, hVar.f3253a) && k.b(this.b, hVar.b) && k.b(this.c, hVar.c) && k.b(this.d, hVar.d) && this.e.equals(hVar.e);
    }

    public final int hashCode() {
        int iC = B7.a.c(this.f3253a.hashCode() * 31, 31, this.b);
        String str = this.c;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.d;
        return this.e.hashCode() + ((iHashCode + (l != null ? l.hashCode() : 0)) * 961);
    }

    public final String toString() {
        boolean z10 = this.d != null;
        String str = this.c;
        boolean z11 = !(str == null || str.length() == 0);
        boolean z12 = this.e.c != null;
        StringBuilder sbW = B7.a.w("ToolTaskConfig(name=", this.f3253a, ", toolcallId=", this.b, ", abilityId=<redacted>, hasAbilityId=");
        sbW.append(z10);
        sbW.append(", conversionId=null, params=<redacted>, hasParams=");
        sbW.append(z11);
        sbW.append(", hasExtra=");
        return B7.a.s(sbW, z12, ")");
    }
}
