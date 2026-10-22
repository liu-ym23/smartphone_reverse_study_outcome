package com.bytedance.securityguardkit.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.l.n;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: ContentCategory.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0252a f11125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11126b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11127c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11128d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f11129e = null;
    public static final a f = null;
    public static final a g = null;
    public static final a h = null;
    public static final a i = null;
    public static final a j = null;
    public static final a k = null;
    private static final Map<Integer, a> n = null;
    private static final /* synthetic */ a[] o = null;
    private final int l;
    private final String m;

    /* JADX INFO: renamed from: com.bytedance.securityguardkit.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContentCategory.kt */
    public static final class C0252a {
        public /* synthetic */ C0252a(h r1) {
            this();
        }

        private C0252a() {
        }

        public final a a(int r2) {
            return (a) ZeusTransformUtils.preCheckCast(a.b().get(Integer.valueOf(r2)), a.class, "com.obric.aiagent.plugin");
        }
    }

    public static final a a(int r1) {
        return f11125a.a(r1);
    }

    private static final /* synthetic */ a[] c() {
        return new a[]{f11126b, f11127c, f11128d, f11129e, f, g, h, i, j, k};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(o.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.l = r3;
        this.m = r4;
    }

    public static final /* synthetic */ Map b() {
        return n;
    }

    public final String a() {
        return this.m;
    }

    static {
        int r2 = 0;
        f11126b = new a("SECURITY", 0, 0, "security");
        f11127c = new a("ABUSE", 1, 1, "abuse");
        f11128d = new a("DISCRIMINATE", 2, 2, "discriminate");
        f11129e = new a("PORNOGRAPHY", 3, 3, "pornography");
        f = new a("DRUGS", 4, 4, "drugs");
        g = new a("CRIMINAL", 5, 5, "criminal");
        h = new a("REACTIONARY", 6, 6, "reactionary");
        i = new a("LEADER", 7, 7, "leader");
        j = new a("LEADER_POSITIVE", 8, 8, "leader_positive");
        k = new a("REACTIONARY_POSITIVE", 9, 9, "reactionary_positive");
        o = c();
        f11125a = new C0252a(null);
        a[] r0 = values();
        Map<Integer, a> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(r0.length), 16)), Map.class, "com.obric.aiagent.plugin");
        int r3 = r0.length;
    L3:
        if (r2 >= r3) goto L5;
        a r4 = r0[r2];
        r1.put(Integer.valueOf(r4.l), r4);
        r2 = r2 + 1;
        goto L3
    L5:
        n = r1;
    }
}
