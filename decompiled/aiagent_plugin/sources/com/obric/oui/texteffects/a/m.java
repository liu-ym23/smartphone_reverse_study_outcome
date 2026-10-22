package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f36415a = null;

        static {
            f36415a = new a();
        }

        private a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.oui.texteffects.a.b f36416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.oui.texteffects.a.b f36417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f36418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f36419d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f36416a == r6.f36416a) goto L12;
            return false;
        L12:
            if (this.f36417b == r6.f36417b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(Float.valueOf(this.f36418c), Float.valueOf(r6.f36418c)) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(Float.valueOf(this.f36419d), Float.valueOf(r6.f36419d)) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f36416a.hashCode() * 31) + this.f36417b.hashCode()) * 31) + Float.hashCode(this.f36418c)) * 31) + Float.hashCode(this.f36419d);
        }

        public String toString() {
            return "ScanWindow(direction=" + this.f36416a + ", gradientAlphaDirection=" + this.f36417b + ", featherRatio=" + this.f36418c + ", minFeatherDp=" + this.f36419d + ')';
        }

        public final com.obric.oui.texteffects.a.b a() {
            return this.f36416a;
        }

        public final com.obric.oui.texteffects.a.b b() {
            return this.f36417b;
        }

        public final float c() {
            return this.f36418c;
        }

        public final float d() {
            return this.f36419d;
        }

        public b(com.obric.oui.texteffects.a.b r2, com.obric.oui.texteffects.a.b r3, float r4, float r5) {
            d.h.b.o.e(r2, "direction");
            d.h.b.o.e(r3, "gradientAlphaDirection");
            super(null);
            this.f36416a = r2;
            this.f36417b = r3;
            this.f36418c = r4;
            this.f36419d = r5;
        }
    }

    public /* synthetic */ m(d.h.b.h r1) {
        this();
    }

    private m() {
    }
}
