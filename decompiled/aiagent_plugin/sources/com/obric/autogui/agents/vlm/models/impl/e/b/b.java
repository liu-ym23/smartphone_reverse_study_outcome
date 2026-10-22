package com.obric.autogui.agents.vlm.models.impl.e.b;

import android.content.Context;
import com.obric.autogui.operator.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ScriptFailedStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends i implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f27812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f27813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<String> f27814e;
    private final String f;
    private final String g;

    public /* synthetic */ b(c r8, String r9, List r10, String r11, String r12, int r13, h r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 2) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        List r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        String r6 = null;
    L18:
        this(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r15;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.b.a
    public List<String> h() {
        return this.f27814e;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.b.a
    public String i() {
        return this.f;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.b.a
    public String j() {
        return this.g;
    }

    public b(c r8, String r9, List<String> r10, String r11, String r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "reason");
        super(true, false, 0, 4, null);
        this.f27812c = r8;
        this.f27813d = r9;
        this.f27814e = r13;
        this.f = r11;
        this.g = r12;
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.k
    public String a(Context r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        return this.f27812c.a();
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public com.obric.autogui.operator.f g() {
        if (this.f27813d == null) goto L5;
        String r0 = this.f27812c.b() + ": " + this.f27813d;
    L7:
        return new com.obric.autogui.operator.f(this.f27812c.name(), r0);
    L5:
        r0 = this.f27812c.b();
        goto L7
    }
}
