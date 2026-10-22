package com.obric.autogui.operator;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOStepResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public class o extends i implements k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.common.e f29945c;

    /* JADX INFO: compiled from: AOStepResult.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29946a = null;

        static {
            int[] r0 = new int[com.obric.autogui.common.a.b.values().length];
            r0[com.obric.autogui.common.a.b.f28963a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.obric.autogui.common.a.b.f28964b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f29946a = r0;
        }
    }

    public o(com.obric.autogui.common.e r8, boolean r9) {
        d.h.b.o.e(r8, "opStatusMessage");
        super(!r8.g(), r9, 0, 4, null);
        this.f29945c = r8;
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public g.c b() {
        if (ZeusTransformUtils.instanceOf(this.f29945c, com.obric.autogui.common.a.class) == false) goto L9;
        if (((com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(this.f29945c, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin")).e() == true) goto L9;
        return g.c.f29922a;
    L9:
        return super.b();
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.k
    public String a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        CharSequence r0 = this.f29945c.a(r4);
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        return r0.toString();
    L10:
        return super.a(r4);
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public int d() {
        if (ZeusTransformUtils.instanceOf(this.f29945c, com.obric.autogui.common.a.class) == false) goto L9;
        if (((com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(this.f29945c, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin")).f() == Integer.MIN_VALUE) goto L9;
        return ((com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(this.f29945c, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin")).f();
    L9:
        return super.d();
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public g.e e() {
        if (ZeusTransformUtils.instanceOf(this.f29945c, com.obric.autogui.common.a.class) == false) goto L14;
        com.obric.autogui.common.a.b r2 = ((com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(this.f29945c, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin")).d();
        int r3 = a.f29946a[r2.ordinal()];
        if (r3 == 1) goto L12;
        if (r3 != 2) goto L10;
        return g.e.f29928a;
    L10:
        throw new d.k();
    L12:
        return g.e.f29929b;
    L14:
        return super.e();
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public Object f() {
        if (ZeusTransformUtils.instanceOf(this.f29945c, com.obric.autogui.common.c.class) == false) goto L5;
        com.obric.autogui.common.e r2 = ((com.obric.autogui.common.c) ZeusTransformUtils.preCheckCast(this.f29945c, com.obric.autogui.common.c.class, "com.obric.aiagent.plugin")).a();
    L7:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autogui.common.d.class) == true) goto L9;
        return null;
    L9:
        return ((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a();
    L5:
        r2 = this.f29945c;
        goto L7
    }

    @Override // com.obric.autogui.operator.i, com.obric.autogui.operator.g
    public f g() {
        if (ZeusTransformUtils.instanceOf(this.f29945c, com.obric.autogui.common.a.class) == false) goto L8;
        String r0 = ((com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(this.f29945c, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin")).b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new f(r0, ((com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(this.f29945c, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin")).c());
    L8:
        return null;
    }
}
