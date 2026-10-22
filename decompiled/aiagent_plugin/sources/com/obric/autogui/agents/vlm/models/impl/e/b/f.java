package com.obric.autogui.agents.vlm.models.impl.e.b;

import com.obric.autogui.operator.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import java.util.List;

/* JADX INFO: compiled from: ScriptSuccessStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements a, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27833a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f27834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f27835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f27836e;

    public f() {
        this(null, null, null, null, 15, null);
    }

    @Override // com.obric.autogui.operator.g
    public boolean a() {
        return false;
    }

    public f(String r3, List<String> r4, String r5, String r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f27833a = r3;
        this.f27834c = r7;
        this.f27835d = r5;
        this.f27836e = r6;
    }

    public /* synthetic */ f(String r2, List r3, String r4, String r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r8, r4, r5);
    }

    @Override // com.obric.autogui.operator.g
    public int d() {
        return g.b.b(this);
    }

    @Override // com.obric.autogui.operator.g
    public g.e e() {
        return g.b.c(this);
    }

    @Override // com.obric.autogui.operator.g
    public Object f() {
        return g.b.d(this);
    }

    @Override // com.obric.autogui.operator.g
    public com.obric.autogui.operator.f g() {
        return g.b.e(this);
    }

    @Override // com.obric.autogui.operator.g
    public String c() {
        return this.f27833a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.b.a
    public List<String> h() {
        return this.f27834c;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.b.a
    public String i() {
        return this.f27835d;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.b.a
    public String j() {
        return this.f27836e;
    }

    @Override // com.obric.autogui.operator.g
    public g.c b() {
        return g.c.f29925d;
    }
}
