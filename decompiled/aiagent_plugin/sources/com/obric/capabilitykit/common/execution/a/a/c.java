package com.obric.capabilitykit.common.execution.a.a;

import com.google.gson.JsonElement;
import d.h.b.h;

/* JADX INFO: loaded from: classes3.dex */
public class c extends com.obric.capabilitykit.common.execution.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JsonElement f32050a;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public c(JsonElement r1) {
        this.f32050a = r1;
    }

    public /* synthetic */ c(JsonElement r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final JsonElement a() {
        return this.f32050a;
    }
}
