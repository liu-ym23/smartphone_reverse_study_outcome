package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int[] f36402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float[] f36403b;

        public String toString() {
            return "LinearGradient(colors=" + Arrays.toString(this.f36402a) + ", positions=" + Arrays.toString(this.f36403b) + ')';
        }

        public final int[] a() {
            return this.f36402a;
        }

        public final float[] b() {
            return this.f36403b;
        }

        public a(int[] r2, float[] r3) {
            d.h.b.o.e(r2, "colors");
            d.h.b.o.e(r3, "positions");
            super(null);
            this.f36402a = r2;
            this.f36403b = r3;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L9;
            return false;
        L9:
            if (Arrays.equals(this.f36402a, ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).f36402a) == false) goto L14;
            if (Arrays.equals(this.f36403b, ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin")).f36403b) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f36402a) * 31) + Arrays.hashCode(this.f36403b);
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36404a = null;

        static {
            f36404a = new b();
        }

        private b() {
            super(null);
        }
    }

    public /* synthetic */ h(d.h.b.h r1) {
        this();
    }

    private h() {
    }
}
