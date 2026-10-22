package com.bytedance.apm.trace.model;

import com.bytedance.apm.trace.a.c;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbsTracing.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected List<String> f4956a;

    public abstract void a(long r1, JSONObject r3, boolean r4);

    public c a(String r8, long r9) {
        return new b(r8, "tracer_window_span", this, r9);
    }

    void a(String r2) {
        if (this.f4956a.contains(r2) == false) goto L5;
        return;
    L5:
        this.f4956a.add(r2);
    }
}
