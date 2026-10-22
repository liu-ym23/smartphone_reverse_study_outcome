package com.obric.autogui.operator;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends i implements k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b.EnumC0777b f29940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f29941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f29942e;
    private final String f;
    private final o g;

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public String c() {
        return this.f;
    }

    public m(b.EnumC0777b r9, c r10, boolean r11, boolean r12, String r13) {
        c r14 = (c) ZeusTransformUtils.wrapperContextForParams(r10, c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "lastOp");
        d.h.b.o.e(r14, "lastOpResult");
        super(r14.a(), r12, 0, 4, null);
        this.f29940c = r9;
        this.f29941d = r14;
        this.f29942e = r11;
        this.f = r13;
        if (ZeusTransformUtils.instanceOf(r14, n.class) == false) goto L5;
        o r15 = new o(((n) ZeusTransformUtils.preCheckCast(r14, n.class, "com.obric.aiagent.plugin")).f(), r12);
    L6:
        this.g = r15;
        return;
    L5:
        r15 = null;
        goto L6
    }

    public final c h() {
        c r0 = this.f29941d;
        if (this.f29942e == true) goto L7;
        return null;
    L7:
        return r0;
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public g.c b() {
        o r0 = this.g;
        if (r0 == null) goto L7;
        return r0.b();
    L7:
        return super.b();
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public int d() {
        o r0 = this.g;
        if (r0 == null) goto L7;
        return r0.d();
    L7:
        return this.f29941d.b();
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.k
    public String a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        o r0 = this.g;
        if (r0 == null) goto L7;
        return r0.a(r5);
    L7:
        if (ZeusTransformUtils.instanceOf(this.f29941d, k.class) == false) goto L11;
        return ((k) ZeusTransformUtils.preCheckCast(this.f29941d, k.class, "com.obric.aiagent.plugin")).a(r5);
    L11:
        return super.a(r5);
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public g.e e() {
        if (this.f29941d.a() == false) goto L9;
        if (this.f29941d.c() != c.EnumC0779c.f29879c) goto L9;
        return g.e.f29928a;
    L9:
        return super.e();
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public Object f() {
        o r0 = this.g;
        if (r0 == null) goto L7;
        return r0.f();
    L7:
        return super.f();
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public f g() {
        o r0 = this.g;
        if (r0 != null) goto L5;
        String r1 = this.f29941d.d();
        if (r1 == null) goto L11;
        return new f(r1, this.f29941d.e());
    L11:
        return super.g();
    L5:
        return r0.g();
    }
}
