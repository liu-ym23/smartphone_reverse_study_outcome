package com.obric.autogui.operator.a.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: ImageProcessorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "ImageProcessorFactory";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f29536a = null;

    /* JADX INFO: compiled from: ImageProcessorFactory.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29537a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f29538b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f29539c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f29540d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f29537a, f29538b};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f29537a = new a("ANDROID_NATIVE", 0);
            f29538b = new a("OPENCV", 1);
            a[] r0 = a();
            f29539c = r0;
            f29540d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f29539c.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ImageProcessorFactory.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29541a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f29537a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[a.f29538b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f29541a = r0;
        }
    }

    static {
        f29536a = new c();
    }

    private c() {
    }

    public static /* synthetic */ com.obric.autogui.operator.a.b.b.b a(c r0, a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = a.f29537a;
    L6:
        return r0.a(r1);
    }

    public final com.obric.autogui.operator.a.b.b.b a(a r2) {
        o.e(r2, "type");
        int r1 = b.f29541a[r2.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return (com.obric.autogui.operator.a.b.b.b) ZeusTransformUtils.preCheckCast(new e(), com.obric.autogui.operator.a.b.b.b.class, "com.obric.aiagent.plugin");
    L8:
        throw new k();
    L10:
        return (com.obric.autogui.operator.a.b.b.b) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.b.a(), com.obric.autogui.operator.a.b.b.b.class, "com.obric.aiagent.plugin");
    }
}
