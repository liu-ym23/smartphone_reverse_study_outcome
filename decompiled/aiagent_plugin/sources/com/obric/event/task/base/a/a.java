package com.obric.event.task.base.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ConfigKey.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0896a f32662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f32664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final T f32665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f32666e;

    /* JADX INFO: renamed from: com.obric.event.task.base.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConfigKey.kt */
    public static final class C0896a {
        public /* synthetic */ C0896a(h r1) {
            this();
        }

        private C0896a() {
        }

        public final a<Integer> a(String r2, int r3, boolean r4) {
            o.e(r2, "name");
            return new a(r2, b.f32668b, Integer.valueOf(r3), r4);
        }
    }

    /* JADX INFO: compiled from: ConfigKey.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f32667a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f32668b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f32669c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f32670d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f32671e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f32667a, f32668b, f32669c, f32670d};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f32667a = new b("BOOLEAN", 0);
            f32668b = new b("INT", 1);
            f32669c = new b("STRING", 2);
            f32670d = new b("JSON", 3);
            b[] r0 = a();
            f32671e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f32671e.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        f32662a = new C0896a(null);
    }

    public a(String r2, b r3, T r4, boolean r5) {
        o.e(r2, "name");
        o.e(r3, "type");
        o.e(r4, "defaultValue");
        this.f32663b = r2;
        this.f32664c = r3;
        this.f32665d = r4;
        this.f32666e = r5;
    }

    public final String a() {
        return this.f32663b;
    }

    public final b getType() {
        return this.f32664c;
    }

    public final T b() {
        return this.f32665d;
    }

    public final boolean c() {
        return this.f32666e;
    }
}
