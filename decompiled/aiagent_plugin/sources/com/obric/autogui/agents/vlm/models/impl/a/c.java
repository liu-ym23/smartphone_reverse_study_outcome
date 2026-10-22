package com.obric.autogui.agents.vlm.models.impl.a;

import android.content.Context;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Collection;

/* JADX INFO: compiled from: StandardModelSingleStepHolderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.obric.autogui.agents.vlm.models.impl.a.a {
    private static final String TAG = "M-Std/StepsHolder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27304a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.obric.autogui.agents.vlm.models.impl.a.a.C0684a f27305e = null;
    private static final com.obric.autogui.agents.vlm.models.impl.a.a.C0684a f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f27307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f27308d;

    /* JADX INFO: compiled from: StandardModelSingleStepHolderImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public c(String r2, g r3) {
        o.e(r2, "stepId");
        this.f27306b = r2;
        this.f27307c = r3;
    }

    static {
        f27304a = new a(null);
        f27305e = new com.obric.autogui.agents.vlm.models.impl.a.a.C0684a(false, -1, "");
        f = new com.obric.autogui.agents.vlm.models.impl.a.a.C0684a(false, -2, "此动作未执行。");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public String a() {
        return this.f27306b;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public boolean b() {
        if (this.f27308d == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f27307c == null) goto L7;
        return true;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public g c() {
        if (b() == false) goto L7;
        this.f27308d = true;
        g r1 = this.f27307c;
        o.a(r1);
        return r1;
    L7:
        throw new IllegalAccessException("Attempting to fetch the next step when `hasNext()` is false.");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public void d() {
        if (b() == true) goto L5;
        return;
    L5:
        this.f27308d = true;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public void a(d.h.a.b<? super g, x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "runnable");
        g r2 = this.f27307c;
        if (r2 == null) goto L6;
        r4.invoke(r2);
        return;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public Collection<com.obric.autogui.agents.vlm.models.impl.a.a.C0684a> a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        g r0 = this.f27307c;
        if (r0 == null) goto L5;
        boolean r2 = true;
        if ((r0.u() & 1) == 0) goto L10;
        Loog.INSTANCE.i(TAG, "added ADJUSTED step result (step=" + this.f27307c + ").");
        return (Collection) ZeusTransformUtils.preCheckCast(p.a(f), Collection.class, "com.obric.aiagent.plugin");
    L10:
        com.obric.autogui.operator.g r1 = this.f27307c.t();
        if (r1 != null) goto L14;
        com.obric.autogui.agents.vlm.models.impl.a.a.C0684a r5 = f27305e;
    L22:
        return (Collection) ZeusTransformUtils.preCheckCast(p.a(r5), Collection.class, "com.obric.aiagent.plugin");
    L14:
        if (r1.b().ordinal() >= com.obric.autogui.operator.g.c.f29924c.ordinal()) goto L17;
        r2 = false;
    L17:
        int r3 = r1.d();
        String r8 = this.f27307c.a(r7);
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        r5 = new com.obric.autogui.agents.vlm.models.impl.a.a.C0684a(r2, r3, r8);
        goto L22
    L5:
        return (Collection) ZeusTransformUtils.preCheckCast(p.b(), Collection.class, "com.obric.aiagent.plugin");
    }
}
