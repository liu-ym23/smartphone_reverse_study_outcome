package com.obric.autogui.agents.vlm.models.impl.e.c;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.agents.vlm.models.impl.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LoopGuardImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autogui.agents.vlm.models.impl.e.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27837a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<Integer> f27838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<Integer> f27839c;

    /* JADX INFO: compiled from: LoopGuardImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ String a(a r0, int r1) {
            return r0.a(r1);
        }

        private final String a(int r2) {
            return "已连续调用同一剧本" + r2 + "次，请检查是否仍有执行进展，避免无效重复调用。";
        }
    }

    static {
        f27837a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ int lambda$DeL0baljVCZEYS5S_r7cOiqbXWI() {
        return b();
    }

    public static /* synthetic */ int lambda$mYY4ISFQVB8vINiLul0ROxUfNqQ() {
        return a();
    }

    public b(d.h.a.a<Integer> r3, d.h.a.a<Integer> r4) {
        d.h.a.a<Integer> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<Integer> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r5, "blockThresholdProvider");
        o.e(r6, "warningThresholdProvider");
        this.f27838b = r5;
        this.f27839c = r6;
    }

    public /* synthetic */ b(d.h.a.a r2, d.h.a.a r3, int r4, h r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = $$Lambda$b$mYY4ISFQVB8vINiLul0ROxUfNqQ.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = $$Lambda$b$DeL0baljVCZEYS5S_r7cOiqbXWI.INSTANCE;
    L8:
        this(r6, r7);
    }

    private static final int a() {
        return com.obric.autogui.agents.scripted.c.b.f26918a.v();
    }

    private static final int b() {
        return com.obric.autogui.agents.scripted.c.b.f26918a.u();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.e.c.a
    public c a(com.obric.autogui.session.a r10, String r11) {
        o.e(r10, SensitiveType.SESSION);
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        String r4 = null;
        if (r1 == true) goto L12;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(p.h(r10.p()), Iterable.class, "com.obric.aiagent.plugin");
        ArrayList r5 = new ArrayList();
        Iterator r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L27;
        Object r6 = r3.next();
        com.obric.autogui.operator.e r7 = (com.obric.autogui.operator.e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.operator.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, l.class) == false) goto L19;
        l r8 = (l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.aiagent.plugin");
    L20:
        if (r8 == null) goto L22;
        String r9 = r8.E();
    L24:
        if (o.a(r9, r11) == false) goto L27;
        r5.add(r6);
        goto L15
    L22:
        r9 = null;
        goto L24
    L19:
        r8 = null;
    L27:
        int r12 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).size();
        int r13 = r12 + 1;
        Integer r14 = this.f27838b.invoke();
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L30;
        boolean r15 = true;
    L31:
        if (r15 == true) goto L34;
        r14 = null;
    L34:
        Integer r16 = (Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L37;
        int r17 = r16.intValue();
    L38:
        Integer r18 = this.f27839c.invoke();
        if (((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L41;
        boolean r19 = true;
    L42:
        if (r19 == true) goto L45;
        r18 = null;
    L45:
        Integer r20 = (Integer) ZeusTransformUtils.preCheckCast(r18, Integer.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L48;
        int r21 = r20.intValue();
    L49:
        String r22 = a.a(f27837a, r13);
        if (r13 <= r17) goto L52;
        boolean r23 = true;
    L53:
        if (r23 == false) goto L57;
        r10.e(r11);
        return new c(false, r22);
    L57:
        if (r12 < r21) goto L60;
        r4 = r22;
    L60:
        return new c(true, r4);
    L52:
        r23 = false;
        goto L53
    L48:
        r21 = 5;
        goto L49
    L41:
        r19 = false;
        goto L42
    L37:
        r17 = 10;
        goto L38
    L30:
        r15 = false;
        goto L31
    L12:
        return new c(true, null, 2, null);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
