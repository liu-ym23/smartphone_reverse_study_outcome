package com.obric.autogui.agents.vlm.models.impl.a;

import android.content.Context;
import com.obric.autogui.agents.vlm.models.impl.g;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: StandardModelMultipleStepsHolderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autogui.agents.vlm.models.impl.a.a {
    private static final String TAG = "M-Std/StepsHolder-Multiple";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27299a = null;
    private static final com.obric.autogui.agents.vlm.models.impl.a.a.C0684a g = null;
    private static final com.obric.autogui.agents.vlm.models.impl.a.a.C0684a h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.impl.d.b.a f27301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Iterator<? extends g> f27302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<g> f27303e;
    private final g f;

    /* JADX INFO: compiled from: StandardModelMultipleStepsHolderImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public b(String r3, com.obric.autogui.agents.vlm.models.impl.d.b.a r4) {
        com.obric.autogui.agents.vlm.models.impl.d.b.a r5 = (com.obric.autogui.agents.vlm.models.impl.d.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.autogui.agents.vlm.models.impl.d.b.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "stepId");
        o.e(r5, "stepResult");
        this.f27300b = r3;
        this.f27301c = r5;
        this.f27302d = r5.d().a();
        this.f27303e = new ArrayList(r5.c());
        if (this.f27302d.hasNext() == false) goto L5;
        g r6 = (g) ZeusTransformUtils.preCheckCast(this.f27302d.next(), g.class, "com.obric.aiagent.plugin");
    L6:
        this.f = r6;
        return;
    L5:
        r6 = null;
        goto L6
    }

    static {
        f27299a = new a(null);
        g = new com.obric.autogui.agents.vlm.models.impl.a.a.C0684a(false, -1, "");
        h = new com.obric.autogui.agents.vlm.models.impl.a.a.C0684a(false, -2, "此动作未执行。");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public String a() {
        return this.f27300b;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public boolean b() {
        if (this.f != null) goto L7;
        return false;
    L7:
        if (this.f27303e.size() > 0) goto L11;
        return true;
    L11:
        return this.f27302d.hasNext();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public g c() {
        if (b() == false) goto L11;
        if (this.f27303e.size() > 0) goto L7;
        g r0 = this.f;
        o.a(r0);
    L8:
        r0.f(this.f27303e.size());
        r0.g(this.f27301c.c());
        r0.h(hashCode());
        this.f27303e.add(r0);
        return r0;
    L7:
        r0 = (g) ZeusTransformUtils.preCheckCast(this.f27302d.next(), g.class, "com.obric.aiagent.plugin");
        goto L8
    L11:
        throw new IllegalAccessException("Attempting to fetch the next step when `hasNext()` is false.");
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public void d() {
        if (b() == true) goto L6;
        return;
    L6:
        if (this.f27302d.hasNext() == false) goto L8;
        this.f27302d.next();
        goto L6
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public void a(d.h.a.b<? super g, x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "runnable");
        g r2 = this.f;
        if (r2 == null) goto L6;
        r4.invoke(r2);
        return;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.a.a
    public Collection<com.obric.autogui.agents.vlm.models.impl.a.a.C0684a> a(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        ArrayList r0 = new ArrayList(this.f27301c.c());
        Iterator<g> r2 = this.f27303e.iterator();
        o.c(r2, "iterator(...)");
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r2.hasNext() == false) goto L19;
        g r5 = r2.next();
        o.c(r5, "next(...)");
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        r4 = r4 + 1;
        boolean r8 = true;
        if ((r6.u() & 1) != 0) goto L7;
        com.obric.autogui.operator.g r7 = r6.t();
        if (r7 == null) goto L10;
        if (r7.b().ordinal() >= com.obric.autogui.operator.g.c.f29924c.ordinal()) goto L15;
        r8 = false;
    L15:
        int r9 = r7.d();
        String r10 = r6.a(r13);
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        r0.add(new com.obric.autogui.agents.vlm.models.impl.a.a.C0684a(r8, r9, r10));
        goto L4
    L10:
        Loog.INSTANCE.e(TAG, "added a null step result (step=" + r6 + ").");
        r0.add(g);
        goto L19
    L7:
        Loog.INSTANCE.i(TAG, "added ADJUSTED step result (step=" + r6 + ").");
        r0.add(h);
    L19:
        int r11 = this.f27301c.c() - r4;
        if (r11 <= 0) goto L25;
        Loog.INSTANCE.i(TAG, "added " + r11 + " NOT_EXECUTED step results.");
    L22:
        if (r3 >= r11) goto L25;
        r0.add(g);
        r3 = r3 + 1;
    L25:
        return (Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin");
    }
}
