package org.tensorflow.lite.task.core.a;

import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ImageProcessingOptions.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Rect f40629a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final EnumC1100b f40630b = null;

    /* JADX INFO: compiled from: ImageProcessingOptions.java */
    public static abstract class a {
        abstract Rect a();

        public abstract a a(Rect r1);

        public abstract a a(EnumC1100b r1);

        abstract b b();

        public a() {
        }

        public b c() {
            a(new Rect(a()));
            return b();
        }
    }

    /* JADX INFO: renamed from: org.tensorflow.lite.task.core.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImageProcessingOptions.java */
    public static final enum EnumC1100b extends Enum<EnumC1100b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC1100b f40631a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC1100b f40632b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC1100b f40633c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC1100b f40634d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC1100b f40635e = null;
        public static final EnumC1100b f = null;
        public static final EnumC1100b g = null;
        public static final EnumC1100b h = null;
        private static final /* synthetic */ EnumC1100b[] j = null;
        private final int i;

        public static EnumC1100b valueOf(String r2) {
            return (EnumC1100b) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC1100b.class, r2), EnumC1100b.class, "com.obric.aiagent.plugin");
        }

        public static EnumC1100b[] values() {
            return (EnumC1100b[]) ZeusTransformUtils.preCheckCast(j.clone(), EnumC1100b[].class, "com.obric.aiagent.plugin");
        }

        static {
            EnumC1100b r0 = new EnumC1100b("TOP_LEFT", 0, 0);
            f40631a = r0;
            EnumC1100b r1 = new EnumC1100b("TOP_RIGHT", 1, 1);
            f40632b = r1;
            EnumC1100b r3 = new EnumC1100b("BOTTOM_RIGHT", 2, 2);
            f40633c = r3;
            EnumC1100b r5 = new EnumC1100b("BOTTOM_LEFT", 3, 3);
            f40634d = r5;
            EnumC1100b r7 = new EnumC1100b("LEFT_TOP", 4, 4);
            f40635e = r7;
            EnumC1100b r9 = new EnumC1100b("RIGHT_TOP", 5, 5);
            f = r9;
            EnumC1100b r11 = new EnumC1100b("RIGHT_BOTTOM", 6, 6);
            g = r11;
            EnumC1100b r13 = new EnumC1100b("LEFT_BOTTOM", 7, 7);
            h = r13;
            j = new EnumC1100b[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private EnumC1100b(String r1, int r2, int r3) {
            super(r1, r2);
            this.i = r3;
        }

        public int a() {
            return this.i;
        }
    }

    public abstract Rect a();

    public abstract EnumC1100b b();

    public b() {
    }

    static {
        f40629a = new Rect();
        f40630b = EnumC1100b.f40631a;
    }

    public static a c() {
        return new org.tensorflow.lite.task.core.a.a.C1099a().a(f40629a).a(f40630b);
    }
}
