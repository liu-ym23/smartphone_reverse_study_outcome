package com.obric.aiagent.skill.manager.impl;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: compiled from: SkillPerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class eb {

    /* JADX INFO: compiled from: SkillPerformanceTracking.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19802a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19803b = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.manager.api.r.values().length];
            r0[com.obric.aiagent.skill.manager.api.r.f19300a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L52
        L100:
            r0[com.obric.aiagent.skill.manager.api.r.f19301b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L53
        L112:
            r0[com.obric.aiagent.skill.manager.api.r.f19302c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L54
        L126:
            r0[com.obric.aiagent.skill.manager.api.r.f19303d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L55
        L128:
            r0[com.obric.aiagent.skill.manager.api.r.f19304e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L56
        L132:
            r0[com.obric.aiagent.skill.manager.api.r.k.ordinal()] = 6;     // Catch: NoSuchFieldError -> L57
        L140:
            r0[com.obric.aiagent.skill.manager.api.r.f.ordinal()] = 7;     // Catch: NoSuchFieldError -> L58
        L92:
            r0[com.obric.aiagent.skill.manager.api.r.g.ordinal()] = 8;     // Catch: NoSuchFieldError -> L59
        L102:
            r0[com.obric.aiagent.skill.manager.api.r.h.ordinal()] = 9;     // Catch: NoSuchFieldError -> L60
        L108:
            r0[com.obric.aiagent.skill.manager.api.r.j.ordinal()] = 10;     // Catch: NoSuchFieldError -> L61
        L118:
            r0[com.obric.aiagent.skill.manager.api.r.i.ordinal()] = 11;     // Catch: NoSuchFieldError -> L62
        L134:
            r0[com.obric.aiagent.skill.manager.api.r.l.ordinal()] = 12;     // Catch: NoSuchFieldError -> L63
        L142:
            r0[com.obric.aiagent.skill.manager.api.r.m.ordinal()] = 13;     // Catch: NoSuchFieldError -> L64
        L84:
            r0[com.obric.aiagent.skill.manager.api.r.n.ordinal()] = 14;     // Catch: NoSuchFieldError -> L65
        L90:
            r0[com.obric.aiagent.skill.manager.api.r.o.ordinal()] = 15;     // Catch: NoSuchFieldError -> L66
        L110:
            r0[com.obric.aiagent.skill.manager.api.r.p.ordinal()] = 16;     // Catch: NoSuchFieldError -> L67
        L120:
            r0[com.obric.aiagent.skill.manager.api.r.q.ordinal()] = 17;     // Catch: NoSuchFieldError -> L68
        L34:
            f19802a = r0;
            int[] r1 = new int[dw.values().length];
            r1[dw.f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L69
        L146:
            r1[dw.g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L70
        L88:
            r1[dw.h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L71
        L98:
            r1[dw.i.ordinal()] = 4;     // Catch: NoSuchFieldError -> L72
        L106:
            r1[dw.j.ordinal()] = 5;     // Catch: NoSuchFieldError -> L73
        L116:
            r1[dw.k.ordinal()] = 6;     // Catch: NoSuchFieldError -> L74
        L124:
            r1[dw.o.ordinal()] = 7;     // Catch: NoSuchFieldError -> L75
        L130:
            r1[dw.f19776a.ordinal()] = 8;     // Catch: NoSuchFieldError -> L76
        L136:
            r1[dw.f19777b.ordinal()] = 9;     // Catch: NoSuchFieldError -> L77
        L144:
            r1[dw.f19778c.ordinal()] = 10;     // Catch: NoSuchFieldError -> L78
        L86:
            r1[dw.f19779d.ordinal()] = 11;     // Catch: NoSuchFieldError -> L79
        L96:
            r1[dw.f19780e.ordinal()] = 12;     // Catch: NoSuchFieldError -> L80
        L104:
            r1[dw.l.ordinal()] = 13;     // Catch: NoSuchFieldError -> L81
        L114:
            r1[dw.m.ordinal()] = 14;     // Catch: NoSuchFieldError -> L82
        L122:
            r1[dw.n.ordinal()] = 15;     // Catch: NoSuchFieldError -> L83
        L50:
            f19803b = r1;
        }
    }

    public static /* synthetic */ Throwable lambda$DCBPeogmb556m4_L5bOTRGCRQGQ(Throwable r0) {
        return b(r0);
    }

    public static final String a() {
        String r0 = UUID.randomUUID().toString();
        d.h.b.o.c(r0, "toString(...)");
        return r0;
    }

    public static final long a(long r2) {
        return d.l.n.a(SystemClock.elapsedRealtime() - r2, 0);
    }

    public static final dw a(com.obric.aiagent.skill.manager.api.u.a r1) {
        d.h.b.o.e(r1, "failure");
        com.obric.aiagent.skill.manager.api.r r2 = r1.a();
        switch(a.f19802a[r2.ordinal()]) {
            case 1: goto L17;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L26;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L20;
            case 16: goto L19;
            case 17: goto L18;
            default: goto L5;
        };
    L5:
        throw new d.k();
    L18:
        return dw.o;
    L19:
        return dw.j;
    L20:
        return dw.i;
    L21:
        return dw.g;
    L22:
        return dw.h;
    L23:
        return dw.f19780e;
    L24:
        return dw.g;
    L25:
        return dw.l;
    L26:
        return dw.f19778c;
    L27:
        return dw.f19777b;
    L17:
        return dw.f19776a;
    }

    public static final dw a(Throwable r7) {
        d.h.b.o.e(r7, WsConstants.KEY_CONNECTION_ERROR);
        List r8 = d.n.m.g(d.n.m.c(d.n.m.a(r7, $$Lambda$eb$DCBPeogmb556m4_L5bOTRGCRQGQ.INSTANCE), 16));
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r3 = r1.next();
        if (ZeusTransformUtils.instanceOf(r3, bu.class) == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        bu r4 = (bu) ZeusTransformUtils.preCheckCast(d.a.p.l((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin")), bu.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        bt r5 = r4.a();
    L12:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        boolean r9 = true;
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L15;
    L17:
        Iterator r10 = r6.iterator();
    L19:
        if (r10.hasNext() == false) goto L16;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r10.next(), Throwable.class, "com.obric.aiagent.plugin"), InterruptedIOException.class) == false) goto L19;
        boolean r11 = true;
    L23:
        if (r11 == true) goto L140;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L28;
    L30:
        Iterator r13 = r12.iterator();
    L32:
        if (r13.hasNext() == false) goto L29;
        Throwable r14 = (Throwable) ZeusTransformUtils.preCheckCast(r13.next(), Throwable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, UnknownHostException.class) == false) goto L36;
    L43:
        boolean r15 = true;
    L44:
        if (r15 == false) goto L32;
        boolean r16 = true;
    L46:
        if (r16 == false) goto L49;
        return dw.g;
    L49:
        if (d.h.b.o.a(r5, bt.y.f19617a) == false) goto L52;
        return dw.f19779d;
    L52:
        if (d.h.b.o.a(r5, bt.g.f19599a) == true) goto L114;
        if (d.h.b.o.a(r5, bt.t.f19612a) == true) goto L114;
        if (d.h.b.o.a(r5, bt.j.f19602a) == true) goto L143;
        if (r5 != null) goto L144;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L64;
    L66:
        Iterator r18 = r17.iterator();
    L68:
        if (r18.hasNext() == false) goto L65;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r18.next(), Throwable.class, "com.obric.aiagent.plugin"), cd.class) == false) goto L68;
        boolean r19 = true;
    L72:
        if (r19 == true) goto L145;
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r20, Collection.class) == true) goto L77;
    L79:
        Iterator r21 = r20.iterator();
    L81:
        if (r21.hasNext() == false) goto L78;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r21.next(), Throwable.class, "com.obric.aiagent.plugin"), SecurityException.class) == false) goto L81;
        boolean r22 = true;
    L85:
        if (r22 == true) goto L146;
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r23, Collection.class) == true) goto L90;
    L92:
        Iterator r24 = r23.iterator();
    L94:
        if (r24.hasNext() == false) goto L91;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r24.next(), Throwable.class, "com.obric.aiagent.plugin"), IOException.class) == false) goto L94;
        boolean r25 = true;
    L98:
        if (r25 == true) goto L147;
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r26, Collection.class) == true) goto L103;
    L105:
        Iterator r27 = r26.iterator();
    L107:
        if (r27.hasNext() == false) goto L104;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r27.next(), Throwable.class, "com.obric.aiagent.plugin"), IllegalArgumentException.class) == false) goto L107;
    L110:
        if (r9 == false) goto L149;
        return dw.f19776a;
    L149:
        return dw.o;
    L104:
        r9 = false;
        goto L110
    L103:
        if (((Collection) ZeusTransformUtils.preCheckCast(r26, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L105;
    L147:
        return dw.i;
    L91:
        r25 = false;
        goto L98
    L90:
        if (((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L92;
    L146:
        return dw.f19779d;
    L78:
        r22 = false;
        goto L85
    L77:
        if (((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L79;
    L145:
        return dw.f19778c;
    L65:
        r19 = false;
        goto L72
    L64:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L66;
    L144:
        return dw.f19776a;
    L143:
        return dw.o;
    L114:
        return dw.i;
    L36:
        if (ZeusTransformUtils.instanceOf(r14, ConnectException.class) == true) goto L43;
        if (ZeusTransformUtils.instanceOf(r14, NoRouteToHostException.class) == true) goto L43;
        if (ZeusTransformUtils.instanceOf(r14, SocketException.class) == true) goto L43;
        r15 = false;
    L29:
        r16 = false;
        goto L46
    L28:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L30;
    L140:
        return dw.f;
    L16:
        r11 = false;
        goto L23
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L17;
    L11:
        r5 = null;
        goto L12
    }

    private static final Throwable b(Throwable r1) {
        d.h.b.o.e(r1, "it");
        return r1.getCause();
    }

    public static final boolean a(dw r1) {
        d.h.b.o.e(r1, "<this>");
        switch(a.f19803b[r1.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            default: goto L5;
        };
    L6:
        return false;
    L7:
        return true;
    L5:
        throw new d.k();
    }

    public static final boolean a(bt r1) {
        d.h.b.o.e(r1, "<this>");
        if (d.h.b.o.a(r1, bt.s.f19611a) == false) goto L5;
    L65:
        return true;
    L5:
        if (d.h.b.o.a(r1, bt.g.f19599a) == true) goto L65;
        if (d.h.b.o.a(r1, bt.t.f19612a) == true) goto L65;
        if (d.h.b.o.a(r1, bt.j.f19602a) == true) goto L65;
        if (ZeusTransformUtils.instanceOf(r1, bt.z.class) == false) goto L14;
    L64:
        return false;
    L14:
        if (d.h.b.o.a(r1, bt.m.f19605a) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.w.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.v.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.aa.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.ab.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.ac.class) == true) goto L64;
        if (d.h.b.o.a(r1, bt.l.f19604a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.y.f19617a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.f.f19598a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.x.f19616a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.n.f19606a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.o.f19607a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.k.f19603a) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.u.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.a.class) == true) goto L64;
        if (d.h.b.o.a(r1, bt.h.f19600a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.i.f19601a) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.e.class) == true) goto L64;
        if (d.h.b.o.a(r1, bt.q.f19609a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.p.f19608a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.c.f19595a) == true) goto L64;
        if (d.h.b.o.a(r1, bt.b.f19594a) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.r.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r1, bt.d.class) == true) goto L64;
        throw new d.k();
    }

    public static final Map<String, Object> a(l r10) {
        d.h.b.o.e(r10, "summary");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r10.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((q) ZeusTransformUtils.preCheckCast(r1.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20133a) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        d.a.p.d();
        goto L9
    L13:
        r5 = false;
    L18:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r10.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L21;
    L23:
        Iterator r4 = r3.iterator();
        int r6 = 0;
    L25:
        if (r4.hasNext() == false) goto L34;
        if (((q) ZeusTransformUtils.preCheckCast(r4.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20134b) goto L29;
        boolean r7 = true;
    L30:
        if (r7 == false) goto L25;
        r6 = r6 + 1;
        if (r6 >= 0) goto L25;
        d.a.p.d();
        goto L25
    L29:
        r7 = false;
    L34:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r10.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L37;
    L39:
        Iterator r9 = r8.iterator();
        int r11 = 0;
    L41:
        if (r9.hasNext() == false) goto L50;
        if (((q) ZeusTransformUtils.preCheckCast(r9.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20135c) goto L45;
        boolean r12 = true;
    L46:
        if (r12 == false) goto L41;
        r11 = r11 + 1;
        if (r11 >= 0) goto L41;
        d.a.p.d();
        goto L41
    L45:
        r12 = false;
    L50:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10.a(), Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L53;
    L55:
        Iterator r14 = r13.iterator();
        int r15 = 0;
    L57:
        if (r14.hasNext() == false) goto L66;
        if (((q) ZeusTransformUtils.preCheckCast(r14.next(), q.class, "com.obric.aiagent.plugin")).a() != n.f20136d) goto L61;
        boolean r16 = true;
    L62:
        if (r16 == false) goto L57;
        r15 = r15 + 1;
        if (r15 >= 0) goto L57;
        d.a.p.d();
        goto L57
    L61:
        r16 = false;
    L66:
        d.m[] r17 = new d.m[6];
        r17[0] = d.s.a("cli_package_count", Integer.valueOf(r10.a().size()));
        r17[1] = d.s.a("updated_count", Integer.valueOf(r2));
        r17[2] = d.s.a("up_to_date_count", Integer.valueOf(r6));
        r17[3] = d.s.a("failed_count", Integer.valueOf(r11));
        r17[4] = d.s.a("invalid_count", Integer.valueOf(r15));
        int r18 = r11 + r15;
        if (r18 == r10.a().size()) goto L69;
    L71:
        if (r18 <= 0) goto L73;
        String r19 = "partial";
    L76:
        r17[5] = d.s.a("business_result", r19);
        return d.a.ao.a(r17);
    L73:
        if (r2 <= 0) goto L75;
        r19 = "updated";
        goto L76
    L75:
        r19 = "up_to_date";
        goto L76
    L69:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10.a(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L71;
        r19 = "fail";
        goto L76
    L53:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L55;
        r15 = 0;
        goto L66
    L37:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L39;
        r11 = 0;
        goto L50
    L21:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L23;
        r6 = 0;
        goto L34
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        r2 = 0;
        goto L18
    }

    public static final JSONArray a(Collection<? extends bf> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "fields");
        JSONArray r0 = new JSONArray();
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(bf.b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        if (r7.contains((bf) ZeusTransformUtils.preCheckCast(r5, bf.class, "com.obric.aiagent.plugin")) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        r0.put(((bf) ZeusTransformUtils.preCheckCast(r8.next(), bf.class, "com.obric.aiagent.plugin")).a());
        goto L10
    L12:
        return r0;
    }

    public static final String a(com.obric.aiagent.skill.manager.api.aj r2) {
        com.obric.aiagent.skill.manager.api.aj r3 = (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (d.h.b.o.a(r3, com.obric.aiagent.skill.manager.api.aj.c.f19187a) == false) goto L6;
        return "not_required";
    L6:
        if (d.h.b.o.a(r3, com.obric.aiagent.skill.manager.api.aj.d.f19189a) == false) goto L9;
        return "not_started";
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.e.class) == false) goto L12;
        return "scanning";
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.a.class) == false) goto L15;
        return "completed";
    L15:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.skill.manager.api.aj.b.class) == false) goto L19;
        return WsConstants.KEY_CONNECTION_ERROR;
    L19:
        throw new d.k();
    }
}
