package com.obric.autogui.operator;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AOOperationResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.common.e f29943b;

    /* JADX INFO: compiled from: AOOperationResult.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29944a = null;

        static {
            int[] r0 = new int[com.obric.autogui.common.a.b.values().length];
            r0[com.obric.autogui.common.a.b.f28963a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[com.obric.autogui.common.a.b.f28964b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f29944a = r0;
        }
    }

    public n(com.obric.autogui.common.e r2) {
        d.h.b.o.e(r2, "opStatusMessage");
        this.f29943b = r2;
    }

    @Override // com.obric.autogui.operator.c
    public int b() {
        return c.b.a(this);
    }

    @Override // com.obric.autogui.operator.c
    public String d() {
        return c.b.c(this);
    }

    @Override // com.obric.autogui.operator.c
    public String e() {
        return c.b.d(this);
    }

    public final com.obric.autogui.common.e f() {
        return this.f29943b;
    }

    @Override // com.obric.autogui.operator.c
    public boolean a() {
        return !this.f29943b.g();
    }

    @Override // com.obric.autogui.operator.c
    public c.EnumC0779c c() {
        if (this.f29943b.g() == false) goto L7;
        return c.EnumC0779c.f29877a;
    L7:
        if (ZeusTransformUtils.instanceOf(this.f29943b, com.obric.autogui.common.a.class) == false) goto L18;
        com.obric.autogui.common.a.b r2 = ((com.obric.autogui.common.a) ZeusTransformUtils.preCheckCast(this.f29943b, com.obric.autogui.common.a.class, "com.obric.aiagent.plugin")).d();
        int r3 = a.f29944a[r2.ordinal()];
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L14;
        return c.EnumC0779c.f29879c;
    L14:
        throw new d.k();
    L16:
        return c.EnumC0779c.f29878b;
    L18:
        return c.b.b(this);
    }
}
