package com.fasterxml.jackson.databind.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CompactStringObjectMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final i f13030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object[] f13033d;

    private static final int a(int r1) {
        if (r1 > 5) goto L7;
        return 8;
    L7:
        if (r1 > 12) goto L10;
        return 16;
    L10:
        int r0 = 32;
    L11:
        if (r0 >= (r1 + (r1 >> 2))) goto L13;
        r0 = r0 + r0;
        goto L11
    L13:
        return r0;
    }

    static {
        f13030a = new i(1, 0, new Object[4]);
    }

    private i(int r1, int r2, Object[] r3) {
        this.f13031b = r1;
        this.f13032c = r2;
        this.f13033d = r3;
    }

    public static <T> i a(Map<String, T> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if (r12.isEmpty() == true) goto L5;
        int r0 = a(r12.size());
        int r2 = r0 - 1;
        int r3 = (r0 >> 1) + r0;
        Object[] r4 = new Object[r3 * 2];
        int r5 = 0;
        Iterator r13 = r12.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L21;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L8;
        int r8 = r7.hashCode() & r2;
        int r9 = r8 + r8;
        if (r4[r9] == null) goto L19;
        r9 = ((r8 >> 1) + r0) << 1;
        if (r4[r9] == null) goto L19;
        r9 = (r3 << 1) + r5;
        r5 = r5 + 2;
        if (r9 < r4.length) goto L19;
        r4 = Arrays.copyOf(r4, r4.length + 4);
    L19:
        r4[r9] = r7;
        r4[r9 + 1] = r6.getValue();
        goto L8
    L21:
        return new i(r2, r5, r4);
    L5:
        return f13030a;
    }

    public Object a(String r5) {
        int r0 = r5.hashCode() & this.f13031b;
        int r1 = r0 << 1;
        Object r2 = this.f13033d[r1];
        if (r2 == r5) goto L10;
        if (r5.equals(r2) == true) goto L10;
        return a(r5, r0, r2);
    L10:
        return this.f13033d[r1 + 1];
    }

    private final Object a(String r4, int r5, Object r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        int r7 = this.f13031b + 1;
        int r8 = ((r5 >> 1) + r7) << 1;
        Object r1 = this.f13033d[r8];
        if (r4.equals(r1) == true) goto L8;
        if (r1 == null) goto L20;
        int r9 = (r7 + (r7 >> 1)) << 1;
        int r10 = this.f13032c + r9;
    L11:
        if (r9 >= r10) goto L20;
        Object r2 = this.f13033d[r9];
        if (r2 == r4) goto L19;
        if (r4.equals(r2) == true) goto L19;
        r9 = r9 + 2;
    L19:
        return this.f13033d[r9 + 1];
    L20:
        return null;
    L8:
        return this.f13033d[r8 + 1];
    }

    public Object b(String r6) {
        int r0 = this.f13033d.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Object r2 = this.f13033d[r1];
        if (r2 == null) goto L10;
        if (((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).equalsIgnoreCase(r6) == false) goto L10;
        return this.f13033d[r1 + 1];
    L10:
        r1 = r1 + 2;
        goto L3
    L11:
        return null;
    }

    public List<String> a() {
        int r0 = this.f13033d.length;
        ArrayList r1 = new ArrayList(r0 >> 2);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Object r3 = this.f13033d[r2];
        if (r3 == null) goto L7;
        r1.add((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
    L7:
        r2 = r2 + 2;
        goto L3
    L8:
        return r1;
    }
}
