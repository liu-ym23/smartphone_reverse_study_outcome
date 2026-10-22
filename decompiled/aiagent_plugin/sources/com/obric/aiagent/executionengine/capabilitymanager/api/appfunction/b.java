package com.obric.aiagent.executionengine.capabilitymanager.api.appfunction;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.o;
import d.o.d;
import d.o.k;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionToolName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final k f16415b = null;

    public static /* synthetic */ CharSequence lambda$xikb08qk5GKYADmNVA8ojGAjaSk(byte r0) {
        return a(r0);
    }

    private b() {
    }

    public final String a(String r11, String r12, String r13) {
        o.e(r13, "functionId");
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        String r3 = "";
        if (r14 == true) goto L16;
        StringBuilder r15 = new StringBuilder().append(r11).append('_');
        if (r12 != null) goto L15;
        r12 = "";
    L15:
        return r15.append(r12).toString();
    L16:
        String r16 = f16415b.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), "_");
        List r17 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"_"}, false, 0, 6, null);
        int r18 = ((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).size() - 1;
        if (r18 < 0) goto L33;
        String r5 = "";
    L19:
        int r6 = r18 - 1;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17.get(r18), String.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
        String r8 = "";
    L27:
        if (((r5.length() + r8.length()) + r19.length()) > 64) goto L32;
        r5 = r19 + r8 + r5;
        if (r6 < 0) goto L32;
        r18 = r6;
    L32:
        r3 = r5;
        goto L33
    L25:
        r8 = "_";
        goto L27
    L22:
        r7 = false;
    L33:
        CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r110.length() != 0) goto L36;
        r1 = true;
    L36:
        if (r1 == false) goto L39;
        r110 = d.o.o.f(r16, 64);
    L39:
        return (String) ZeusTransformUtils.preCheckCast(r110, String.class, "com.obric.aiagent.plugin");
    L5:
        if (d.o.o.d(r10) == true) goto L8;
        r14 = false;
        goto L9
    }

    public final String a(String r20, String r21) {
        o.e(r20, "packageName");
        o.e(r21, "functionId");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L27:
        return null;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.c(r21, '#', null, 2, null), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L27;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin");
        k r7 = f16415b;
        String r8 = r7.a(r6, "_");
        String r10 = r7.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.c(d.o.o.c(r21, '#', ""), '.', null, 2, null), CharSequence.class, "com.obric.aiagent.plugin"), "_");
        String r1 = r7.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.c(r21, '#', null, 2, null), CharSequence.class, "com.obric.aiagent.plugin"), "_");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(p.b(new String[]{r8, r10, r1}), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L16;
        Object r11 = r3.next();
        if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L13;
        boolean r12 = true;
    L14:
        if (r12 == false) goto L9;
        r5.add(r11);
        goto L9
    L13:
        r12 = false;
        goto L14
    L16:
        String r4 = p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("_", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        if (r4.length() > 64) goto L19;
        return r4;
    L19:
        String r9 = r8 + '_' + r1;
        if (r9.length() > 64) goto L22;
        return r9;
    L22:
        int r13 = 63 - r1.length();
        if (r13 > 5) goto L25;
        return null;
    L25:
        MessageDigest r14 = MessageDigest.getInstance("SHA-256");
        byte[] r0 = r20.getBytes(d.f38623b);
        o.c(r0, "getBytes(...)");
        byte[] r15 = r14.digest(r0);
        o.c(r15, "digest(...)");
        return d.o.o.e(i.a(r15, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$b$xikb08qk5GKYADmNVA8ojGAjaSk.INSTANCE, 30, null), Math.min(10, r13)) + '_' + r1;
    }

    private static final CharSequence a(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    static {
        f16414a = new b();
        f16415b = new k("[^a-zA-Z0-9_]");
    }
}
