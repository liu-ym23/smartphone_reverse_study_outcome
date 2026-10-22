package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipException;

/* JADX INFO: compiled from: SkillInstallTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cn {

    /* JADX INFO: compiled from: SkillInstallTracking.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19683a = null;

        static {
            int[] r0 = new int[cj.values().length];
            r0[cj.f19665a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[cj.f19666b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[cj.f19667c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[cj.f19668d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[cj.f19669e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[cj.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f19683a = r0;
        }
    }

    public static final /* synthetic */ String a(cj r0) {
        return b(r0);
    }

    public static final /* synthetic */ Map a(cl r0) {
        return b(r0);
    }

    private static final String b(cj r1) {
        switch(a.f19683a[r1.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return "import_persist";
    L7:
        return "update_persist";
    L8:
        return "create_persist";
    L9:
        return "store_package_persist";
    L10:
        return "temp_file_write";
    L11:
        return "remote_download";
    L5:
        throw new d.k();
    }

    private static final Map<String, Object> b(cl r4) {
        Map r0 = d.a.ao.a();
        r0.put("install_method", r4.a().a());
        String r1 = r4.g();
        if (r1 == null) goto L12;
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r2 == null) goto L12;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        r0.put("entry_source", r2);
    L12:
        gs r5 = r4.e();
        if (r5 == null) goto L16;
        r0.put("install_type", r5.a().a());
        r0.put("target_version", Integer.valueOf(r5.b()));
    L16:
        return d.a.ao.a(r0);
    }

    public static final ci a(com.obric.aiagent.skill.manager.api.q r2, cj r3, Throwable r4) {
        d.h.b.o.e(r2, "installMethod");
        d.h.b.o.e(r3, "stage");
        d.h.b.o.e(r4, "throwable");
        if (a(r3, r2) == false) goto L5;
        List<Throwable> r5 = a(r4);
        switch(a.f19683a[r3.ordinal()]) {
            case 1: goto L13;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L31;
            case 6: goto L31;
            default: goto L9;
        };
    L13:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L16;
    L18:
        Iterator r7 = r6.iterator();
    L20:
        if (r7.hasNext() == false) goto L24;
        if (b((Throwable) ZeusTransformUtils.preCheckCast(r7.next(), Throwable.class, "com.obric.aiagent.plugin")) == false) goto L20;
        r0 = true;
    L24:
        if (r0 == false) goto L27;
        return ci.h;
    L27:
        return ci.f19663d;
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L18;
    L9:
        throw new d.k();
    L31:
        return a(r5, ci.f19660a);
    L32:
        return a(r5, ci.f);
    L33:
        return ci.f19664e;
    L5:
        return ci.i;
    }

    private static final ci a(List<? extends Throwable> r6, ci r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r1.next(), Throwable.class, "com.obric.aiagent.plugin"), cd.class) == false) goto L9;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L107;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L18;
    L20:
        Iterator r5 = r4.iterator();
    L22:
        if (r5.hasNext() == false) goto L19;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r5.next(), Throwable.class, "com.obric.aiagent.plugin"), SecurityException.class) == false) goto L22;
        boolean r9 = true;
    L26:
        if (r9 == true) goto L108;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L31;
    L33:
        Iterator r11 = r10.iterator();
    L35:
        if (r11.hasNext() == false) goto L32;
        Throwable r12 = (Throwable) ZeusTransformUtils.preCheckCast(r11.next(), Throwable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, ZipException.class) == false) goto L39;
    L42:
        boolean r13 = true;
    L43:
        if (r13 == false) goto L35;
        boolean r14 = true;
    L45:
        if (r14 == true) goto L109;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L50;
    L52:
        Iterator r16 = r15.iterator();
    L54:
        if (r16.hasNext() == false) goto L51;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r16.next(), Throwable.class, "com.obric.aiagent.plugin"), IOException.class) == false) goto L54;
        boolean r17 = true;
    L58:
        if (r17 == true) goto L110;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r18, Collection.class) == true) goto L63;
    L65:
        Iterator r19 = r18.iterator();
    L67:
        if (r19.hasNext() == false) goto L64;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r19.next(), Throwable.class, "com.obric.aiagent.plugin"), IllegalArgumentException.class) == false) goto L67;
        boolean r20 = true;
    L71:
        if (r20 == true) goto L112;
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r21, Collection.class) == true) goto L76;
    L78:
        Iterator r22 = r21.iterator();
    L80:
        if (r22.hasNext() == false) goto L77;
        if (ZeusTransformUtils.instanceOf((Throwable) ZeusTransformUtils.preCheckCast(r22.next(), Throwable.class, "com.obric.aiagent.plugin"), IllegalStateException.class) == false) goto L80;
    L83:
        if (r3 == false) goto L86;
        return ci.f19664e;
    L86:
        return ci.i;
    L77:
        r3 = false;
        goto L83
    L76:
        if (((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L78;
    L112:
        return r7;
    L64:
        r20 = false;
        goto L71
    L63:
        if (((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L65;
    L110:
        return ci.f19664e;
    L51:
        r17 = false;
        goto L58
    L50:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L52;
    L109:
        return ci.f;
    L39:
        if (ZeusTransformUtils.instanceOf(r12, EOFException.class) == true) goto L42;
        r13 = false;
    L32:
        r14 = false;
        goto L45
    L31:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L33;
    L108:
        return ci.g;
    L19:
        r9 = false;
        goto L26
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L20;
    L107:
        return ci.f19661b;
    L6:
        r2 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private static final boolean a(cj r2, com.obric.aiagent.skill.manager.api.q r3) {
        switch(a.f19683a[r2.ordinal()]) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L18;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        throw new d.k();
    L7:
        if (r3 != com.obric.aiagent.skill.manager.api.q.f19295a) goto L9;
        return true;
    L9:
        if (r3 != com.obric.aiagent.skill.manager.api.q.h) goto L11;
        return true;
    L11:
        if (r3 != com.obric.aiagent.skill.manager.api.q.f19298d) goto L13;
        return true;
    L13:
        if (r3 != com.obric.aiagent.skill.manager.api.q.f19299e) goto L15;
        return true;
    L15:
        if (r3 != com.obric.aiagent.skill.manager.api.q.i) goto L29;
        return true;
    L29:
        return false;
    L18:
        if (r3 != com.obric.aiagent.skill.manager.api.q.f19297c) goto L29;
        return true;
    L21:
        if (r3 != com.obric.aiagent.skill.manager.api.q.g) goto L23;
        return true;
    L23:
        if (r3 != com.obric.aiagent.skill.manager.api.q.f19296b) goto L29;
        return true;
    L26:
        if (r3 != com.obric.aiagent.skill.manager.api.q.f) goto L29;
        return true;
    }

    private static final List<Throwable> a(Throwable r4) {
        List<Throwable> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Set r1 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    L3:
        if (r4 == null) goto L7;
        if (r1.add(r4) == false) goto L7;
        ((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).add(r4);
        r4 = r4.getCause();
    L7:
        return r0;
    }

    private static final boolean b(Throwable r1) {
        if (ZeusTransformUtils.instanceOf(r1, UnknownHostException.class) == false) goto L5;
    L14:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, ConnectException.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r1, NoRouteToHostException.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r1, SocketException.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r1, InterruptedIOException.class) == true) goto L14;
        return false;
    }
}
