package com.bytedance.safetyguard.lxc.internal.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HelloHandshake.kt */
/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0225a f9807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9808b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f9809c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f9810d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f9811e = null;
    public static final a f = null;
    private static final /* synthetic */ a[] h = null;
    private static final /* synthetic */ d.d.a i = null;
    private final int g;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HelloHandshake.kt */
    public static final class C0225a {
        public /* synthetic */ C0225a(d.h.b.h r1) {
            this();
        }

        private C0225a() {
        }
    }

    private static final /* synthetic */ a[] b() {
        return new a[]{f9808b, f9809c, f9810d, f9811e, f};
    }

    public static a valueOf(String r2) {
        return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
    }

    public static a[] values() {
        return (a[]) ZeusTransformUtils.preCheckCast(h.clone(), a[].class, "com.obric.aiagent.plugin");
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.g = r3;
    }

    public final int a() {
        return this.g;
    }

    static {
        f9808b = new a("OK", 0, 0);
        f9809c = new a("UNSUPPORTED_VERSION", 1, 1);
        f9810d = new a("UNSUPPORTED_FEATURE", 2, 2);
        f9811e = new a("INVALID_LIMIT", 3, 3);
        f = new a("INTERNAL_ERROR", 4, 4);
        a[] r0 = b();
        h = r0;
        i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f9807a = new C0225a(null);
    }
}
