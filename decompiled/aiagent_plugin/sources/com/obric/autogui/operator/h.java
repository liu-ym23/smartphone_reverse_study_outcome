package com.obric.autogui.operator;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements c, k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f29935d;

    @Override // com.obric.autogui.operator.c
    public boolean a() {
        return true;
    }

    public h(int r2, String r3, String r4) {
        d.h.b.o.e(r4, "reason");
        this.f29933b = r2;
        this.f29934c = r3;
        this.f29935d = r4;
    }

    public /* synthetic */ h(int r1, String r2, String r3, int r4, d.h.b.h r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = "aborted";
    L8:
        this(r1, r2, r3);
    }

    @Override // com.obric.autogui.operator.c
    public int b() {
        return c.b.a(this);
    }

    @Override // com.obric.autogui.operator.c
    public c.EnumC0779c c() {
        return c.EnumC0779c.f29878b;
    }

    @Override // com.obric.autogui.operator.c
    public String d() {
        return this.f29935d;
    }

    @Override // com.obric.autogui.operator.c
    public String e() {
        return this.f29934c;
    }

    @Override // com.obric.autogui.operator.k
    public String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        String r2 = r4.getString(this.f29933b);
        d.h.b.o.c(r2, "getString(...)");
        return r2;
    }
}
