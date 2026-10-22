package com.stepos.ability.sdk.client;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f3252a;
    public final String b;
    public final f c;

    public g(String toolCallId, String str, f fVar) {
        k.f(toolCallId, "toolCallId");
        this.f3252a = toolCallId;
        this.b = str;
        this.c = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return k.b(this.f3252a, gVar.f3252a) && k.b(this.b, gVar.b) && this.c.equals(gVar.c);
    }

    public final int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(0, androidx.constraintlayout.core.dsl.a.a(2, this.f3252a.hashCode() * 29791, 31), 31);
        String str = this.b;
        return this.c.hashCode() + ((iA + (str != null ? str.hashCode() : 0)) * 961);
    }

    public final String toString() {
        StringBuilder sbW = B7.a.w("GuiTaskConfig(toolCallId=", this.f3252a, ", surface=null, conversionId=null, guiTaskType=2, startMode=0, params=", this.b, ", modelName=null, commonConfig=");
        sbW.append(this.c);
        sbW.append(")");
        return sbW.toString();
    }
}
