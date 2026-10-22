package com.obric.autogui.agents.a.b;

import com.obric.autogui.agents.a.a.a.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ScrollDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements com.obric.autogui.agents.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f26282a = null;

    /* JADX INFO: compiled from: ScrollDetector.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26283a = null;

        static {
            int[] r0 = new int[com.obric.autogui.operator.a.b.e.a.values().length];
            r0[com.obric.autogui.operator.a.b.e.a.f29659b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[com.obric.autogui.operator.a.b.e.a.f29661d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[com.obric.autogui.operator.a.b.e.a.f29660c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[com.obric.autogui.operator.a.b.e.a.f29662e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[com.obric.autogui.operator.a.b.e.a.f29658a.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f26283a = r0;
        }
    }

    static {
        f26282a = new i();
    }

    private i() {
    }

    @Override // com.obric.autogui.agents.a.b.a
    public Object a(b r21, d.c.d<? super com.obric.autogui.agents.a.f.b> r22) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.a.a.a.a r1 = r21.a().d();
        List r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, l.class) == true) goto L5;
        r1 = null;
    L5:
        l r2 = (l) ZeusTransformUtils.preCheckCast((com.obric.autogui.agents.a.a.a.a) ZeusTransformUtils.preCheckCast((l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.a.a.a.a.class, "com.obric.aiagent.plugin"), l.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        com.obric.autogui.agents.a.n.a.f r4 = r2.b();
        if (r4 == null) goto L12;
        List<com.obric.autogui.agents.a.n.a.f> r5 = com.obric.autogui.agents.a.n.a.f26730a.f(r21.b().b());
        if (r5 == null) goto L22;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L17:
        if (r8.hasNext() == false) goto L21;
        Object r9 = r8.next();
        if (o.a(((com.obric.autogui.agents.a.n.a.f) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.agents.a.n.a.f.class, "com.obric.aiagent.plugin")).a(), r4.a()) == false) goto L17;
        r7.add(r9);
        goto L17
    L21:
        r3 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L22:
        if (r3 != null) goto L24;
        r3 = p.b();
    L24:
        com.obric.autogui.agents.a.n.a.f r10 = (com.obric.autogui.agents.a.n.a.f) ZeusTransformUtils.preCheckCast(p.l(r3), com.obric.autogui.agents.a.n.a.f.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L36;
        com.obric.autogui.agents.a.f.k r12 = com.obric.autogui.agents.a.f.k.f;
        StringBuilder r11 = new StringBuilder().append("direction=").append(r2.a()).append(", target_key_hash=").append(r4.a().hashCode()).append(", after_scroll_state_count=");
        if (r5 == null) goto L29;
        int r13 = r5.size();
    L30:
        StringBuilder r14 = r11.append(r13).append(", same_key_count=").append(r3.size()).append(", after_viewtree_available=");
        if (r21.b().b() == null) goto L33;
        boolean r15 = true;
    L35:
        return d.a(r21, r12, "same scroll container unavailable", null, r14.append(r15).toString(), 4, null);
    L33:
        r15 = false;
        goto L35
    L29:
        r13 = 0;
        goto L30
    L36:
        long r16 = ((long) r10.b()) - ((long) r4.b());
        long r17 = ((long) r10.c()) - ((long) r4.c());
        long r18 = ((long) r10.d()) - ((long) r4.d());
        boolean r19 = com.obric.autogui.agents.a.n.a.f26730a.a(r4, r2.a());
        boolean r110 = com.obric.autogui.agents.a.n.a.f26730a.a(r10, r2.a());
        StringBuilder r111 = new StringBuilder();
        StringBuilder r20 = r111.append("direction=").append(r2.a()).append(", target_key_hash=").append(r4.a().hashCode()).append(", after_scroll_state_count=");
        if (r5 == null) goto L39;
        int r23 = r5.size();
    L40:
        StringBuilder r24 = r20.append(r23).append(", same_key_count=").append(r3.size()).append(", before_offset=").append(r4.b()).append(", after_offset=").append(r10.b()).append(", offset_changed=");
        if (r16 == 0) goto L43;
        boolean r25 = true;
    L44:
        r24.append(r25).append(", offset_delta=").append(r16).append(", offset_direction_matches=").append(a(r2.a(), r16)).append(", before_range=").append(r4.c()).append(", after_range=").append(r10.c()).append(", range_changed=");
        if (r17 == 0) goto L47;
        boolean r26 = true;
    L48:
        StringBuilder r27 = r111.append(r26).append(", range_delta=").append(r17).append(", before_extent=").append(r4.d()).append(", after_extent=").append(r10.d()).append(", extent_changed=");
        if (r18 == 0) goto L51;
        boolean r28 = true;
    L52:
        r27.append(r28).append(", extent_delta=").append(r18).append(", before_can_scroll=").append(r19).append(", after_can_scroll=").append(r110).append(", before_udlr=").append(r4.e()).append(':').append(r4.f()).append(':').append(r4.g()).append(':').append(r4.h());
        r111.append(", after_udlr=").append(r10.e()).append(':').append(r10.f()).append(':').append(r10.g()).append(':').append(r10.h());
        String r29 = r111.toString();
        if (r4.b() != r10.b()) goto L62;
        if (r4.c() != r10.c()) goto L62;
        if (r4.d() != r10.d()) goto L62;
        return d.a(r21, com.obric.autogui.agents.a.f.k.f26444c, "scroll offset unchanged", null, r29, 4, null);
    L62:
        return d.a(r21, com.obric.autogui.agents.a.f.k.f26442a, "target scroll metadata changed", null, r29, 4, null);
    L51:
        r28 = false;
        goto L52
    L47:
        r26 = false;
        goto L48
    L43:
        r25 = false;
        goto L44
    L39:
        r23 = 0;
        goto L40
    L12:
        return d.a(r21, com.obric.autogui.agents.a.f.k.f, "target scroll container unavailable", null, null, 12, null);
    L8:
        return d.a(r21, com.obric.autogui.agents.a.f.k.f, "swipe action evidence unavailable", null, null, 12, null);
    }

    private final Boolean a(com.obric.autogui.operator.a.b.e.a r3, long r4) {
        if (r4 != 0) goto L6;
        return null;
    L6:
        if (r3 != null) goto L8;
        int r5 = -1;
    L9:
        if (r5 == (-1)) goto L30;
        boolean r6 = false;
        if (r5 != 1) goto L13;
    L26:
        if (r4 <= 0) goto L29;
        r6 = true;
    L29:
        return Boolean.valueOf(r6);
    L13:
        if (r5 == 2) goto L26;
        if (r5 != 3) goto L17;
    L23:
        if (r4 >= 0) goto L31;
        r6 = true;
    L31:
        return Boolean.valueOf(r6);
    L17:
        if (r5 == 4) goto L23;
        if (r5 != 5) goto L22;
        return null;
    L22:
        throw new d.k();
    L30:
        return null;
    L8:
        r5 = a.f26283a[r3.ordinal()];
        goto L9
    }
}
