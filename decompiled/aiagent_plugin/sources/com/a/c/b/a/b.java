package com.a.c.b.a;

import com.a.c.b.d.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: FieldConstraintsBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f3098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, Integer> f3099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3102e;
    private final Set<c> f;

    /* JADX INFO: renamed from: com.a.c.b.a.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: FieldConstraintsBuilder.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3103a = null;

        static {
            int[] r0 = new int[com.a.c.b.b.values().length];
            f3103a = r0;
            r0[com.a.c.b.b.f3104a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f3103a[com.a.c.b.b.f3105b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f3103a[com.a.c.b.b.f3106c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f3103a[com.a.c.b.b.f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f3103a[com.a.c.b.b.f3107d.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f3103a[com.a.c.b.b.f3108e.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f3103a[com.a.c.b.b.h.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private b() {
        this.f3098a = new HashMap();
        this.f3099b = new HashMap();
        this.f3100c = 0;
        this.f3101d = Integer.MAX_VALUE;
        this.f3102e = false;
        HashSet r0 = new HashSet();
        this.f = r0;
        r0.add(c.f);
    }

    public b a(com.a.c.b.b r2) {
        switch(AnonymousClass1.f3103a[r2.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return this;
    L5:
        this.f3100c = 1;
        this.f3101d = 366;
        return this;
    L7:
        this.f3098a = j();
        this.f3100c = 1;
        this.f3101d = 12;
        return this;
    L9:
        this.f3100c = 1;
        this.f3101d = 31;
        return this;
    L11:
        this.f3098a = i();
        this.f3101d = 6;
        return this;
    L13:
        this.f3101d = 23;
        return this;
    L15:
        this.f3101d = 59;
        return this;
    }

    public b a() {
        this.f.add(c.f3135d);
        return this;
    }

    public b b() {
        this.f.add(c.f3133b);
        return this;
    }

    public b c() {
        this.f.add(c.f3134c);
        return this;
    }

    public b d() {
        this.f.add(c.f3132a);
        return this;
    }

    public b e() {
        this.f.add(c.f3136e);
        return this;
    }

    public b a(int r2, int r3) {
        this.f3099b.put(Integer.valueOf(r2), Integer.valueOf(r3));
        return this;
    }

    public b b(int r1, int r2) {
        this.f3100c = r1;
        this.f3101d = r2;
        return this;
    }

    public b f() {
        this.f3102e = true;
        return this;
    }

    public b a(int r6) {
        if (r6 <= 0) goto L4;
    L5:
        Iterator<Map.Entry<String, Integer>> r0 = this.f3098a.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r2 = ((Integer) ZeusTransformUtils.preCheckCast(r1.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue() + r6;
        int r3 = this.f3101d;
        if (r2 <= r3) goto L11;
        r2 = r2 - this.f3098a.size();
    L14:
        Map<String, Integer> r4 = this.f3098a;
        Object r5 = r1.getKey();
        String r7 = (String) r5;
        r4.put(r7, Integer.valueOf(r2));
        goto L7
    L11:
        int r8 = this.f3100c;
        if (r2 >= r8) goto L14;
        r2 = r2 + (r8 - r3);
    L15:
        return this;
    L4:
        if (this.f3101d >= this.f3098a.size()) goto L15;
        goto L5
    }

    public a g() {
        return new a(this.f3098a, this.f3099b, this.f, this.f3100c, this.f3101d, this.f3102e);
    }

    private static Map<String, Integer> i() {
        HashMap r0 = new HashMap();
        r0.put("MON", 1);
        r0.put("TUE", 2);
        r0.put("WED", 3);
        r0.put("THU", 4);
        r0.put("FRI", 5);
        r0.put("SAT", 6);
        r0.put("SUN", 7);
        return r0;
    }

    private static Map<String, Integer> j() {
        HashMap r0 = new HashMap();
        r0.put("JAN", 1);
        r0.put("FEB", 2);
        r0.put("MAR", 3);
        r0.put("APR", 4);
        r0.put("MAY", 5);
        r0.put("JUN", 6);
        r0.put("JUL", 7);
        r0.put("AUG", 8);
        r0.put("SEP", 9);
        r0.put("OCT", 10);
        r0.put("NOV", 11);
        r0.put("DEC", 12);
        return r0;
    }

    public static b h() {
        return new b();
    }
}
