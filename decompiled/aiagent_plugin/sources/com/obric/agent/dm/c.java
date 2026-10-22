package com.obric.agent.dm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.HashMap;

/* JADX INFO: compiled from: ECA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("value")
    private final HashMap<String, String> f14429a;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14429a, r6.f14429a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        HashMap<String, String> r0 = this.f14429a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ECAActionTarget(value=" + this.f14429a + ')';
    }

    public c(HashMap<String, String> r1) {
        this.f14429a = r1;
    }

    public /* synthetic */ c(HashMap r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
