package com.obric.capabilitykit;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f32148b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f32149c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ j[] f32150d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f32151e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public final j a(String r4) {
            d.h.b.o.e(r4, "value");
            j[] r3 = j.values();
            int r0 = 0;
        L4:
            if (r0 >= 2) goto L9;
            j r1 = r3[r0];
            if (d.h.b.o.a(r1.a(), r4) == true) goto L13;
            r0 = r0 + 1;
            goto L4
        L13:
            return r1;
        L9:
            return null;
        }
    }

    static {
        f32148b = new j("INDEX", 0, "index");
        f32149c = new j("DELETE", 1, "delete");
        f32150d = b();
        f32147a = new a(null);
    }

    private j(String r1, int r2, String r3) {
        super(r1, r2);
        this.f32151e = r3;
    }

    private static final /* synthetic */ j[] b() {
        return new j[]{f32148b, f32149c};
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f32150d.clone(), j[].class, "com.obric.aiagent.plugin");
    }

    public final String a() {
        return this.f32151e;
    }
}
