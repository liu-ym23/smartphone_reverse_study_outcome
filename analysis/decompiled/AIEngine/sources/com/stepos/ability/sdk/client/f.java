package com.stepos.ability.sdk.client;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f5589a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5590b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5591c;

    /* renamed from: d, reason: collision with root package name */
    public final e f5592d;

    public f(String name, String str, String str2, e eVar) {
        g.f(name, "name");
        this.f5589a = name;
        this.f5590b = str;
        this.f5591c = str2;
        this.f5592d = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return g.b(this.f5589a, fVar.f5589a) && this.f5590b.equals(fVar.f5590b) && g.b(this.f5591c, fVar.f5591c) && this.f5592d.equals(fVar.f5592d);
    }

    public final int hashCode() {
        int iA = v1.d.a(this.f5589a.hashCode() * 31, 31, this.f5590b);
        String str = this.f5591c;
        return this.f5592d.hashCode() + ((iA + (str == null ? 0 : str.hashCode())) * 29791);
    }

    public final String toString() {
        StringBuilder sbS = ai.onnxruntime.a.s("ToolTaskConfig(name=", this.f5589a, ", toolcallId=", this.f5590b, ", params=");
        sbS.append(this.f5591c);
        sbS.append(", abilityId=null, conversionId=null, commonConfig=");
        sbS.append(this.f5592d);
        sbS.append(")");
        return sbS.toString();
    }
}
