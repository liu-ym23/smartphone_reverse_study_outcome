package com.obric.autogui.agents.a.j;

import com.obric.autogui.agents.a.a.f;
import com.obric.autogui.agents.a.f.d;
import com.obric.autogui.agents.a.f.e;
import com.obric.autogui.agents.a.f.i;
import com.obric.autogui.agents.a.f.k;
import com.obric.autogui.operator.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectResultFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f26524a = null;

    /* JADX INFO: compiled from: ActionEffectResultFactory.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26525a = null;

        static {
            int[] r0 = new int[k.values().length];
            r0[k.f26445d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[k.f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[k.f26444c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[k.f26446e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[k.f26442a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[k.f26443b.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f26525a = r0;
        }
    }

    static {
        f26524a = new b();
    }

    private b() {
    }

    public final g a(g r11, f r12, i r13) {
        g r10 = (g) ZeusTransformUtils.wrapperContextForParams(r11, g.class, "com.obric.aiagent.plugin");
        o.e(r10, "original");
        o.e(r12, "input");
        o.e(r13, "outcome");
        e r14 = r13.h();
        if (r14 == null) goto L5;
    L11:
        e r3 = r14;
        c.a r15 = c.f26526a;
        String r4 = r12.j().a();
        String r5 = r12.b();
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r13.e(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r16, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L13:
        if (r17.hasNext() == false) goto L16;
        com.obric.autogui.agents.a.f.b r6 = (com.obric.autogui.agents.a.f.b) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.autogui.agents.a.f.b.class, "com.obric.aiagent.plugin");
        r1.add(r6.a().a() + ':' + r6.b() + ':' + r6.c());
        goto L13
    L16:
        return (g) ZeusTransformUtils.preCheckCast(r15.a(r10, new d(null, r3, r4, r5, (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), r13.f(), 1, null), r13.g()), g.class, "com.obric.aiagent.plugin");
    L5:
        switch(a.f26525a[r13.b().ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        r14 = e.f26415d;
        goto L11
    L9:
        r14 = e.f26413b;
        goto L11
    L10:
        r14 = e.f26412a;
        goto L11
    L7:
        throw new d.k();
    }
}
