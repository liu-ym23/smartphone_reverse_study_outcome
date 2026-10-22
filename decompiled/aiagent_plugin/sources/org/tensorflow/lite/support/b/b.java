package org.tensorflow.lite.support.b;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ColorSpaceType.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f40599b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f40600c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f40601d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f40602e = null;
    public static final b f = null;
    public static final b g = null;
    private static final /* synthetic */ b[] i = null;
    private final int h;

    /* JADX INFO: renamed from: org.tensorflow.lite.support.b.b$8, reason: invalid class name */
    /* JADX INFO: compiled from: ColorSpaceType.java */
    static /* synthetic */ class AnonymousClass8 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40603a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            f40603a = r0;
            r0[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f40603a[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    /* synthetic */ b(String r1, int r2, int r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(i.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        final String r1 = "RGB";
        final int r2 = 0;
        b r0 = new AnonymousClass1(r1, r2, r2);
        f40598a = r0;
        final String r3 = "GRAYSCALE";
        final int r4 = 1;
        b r5 = new AnonymousClass2(r3, r4, r4);
        f40599b = r5;
        final String r6 = "NV12";
        final int r7 = 2;
        b r8 = new AnonymousClass3(r6, r7, r7);
        f40600c = r8;
        final String r9 = "NV21";
        final int r10 = 3;
        b r11 = new AnonymousClass4(r9, r10, r10);
        f40601d = r11;
        final String r12 = "YV12";
        final int r13 = 4;
        b r14 = new AnonymousClass5(r12, r13, r13);
        f40602e = r14;
        final String r15 = "YV21";
        final int r16 = 5;
        b r17 = new AnonymousClass6(r15, r16, r16);
        f = r17;
        final String r18 = "YUV_420_888";
        final int r19 = 6;
        b r110 = new AnonymousClass7(r18, r19, r19);
        g = r110;
        i = new b[]{r0, r5, r8, r11, r14, r17, r110};
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
        this.h = r3;
    }

    static b a(Bitmap.Config r3) {
        int r0 = AnonymousClass8.f40603a[r3.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L9;
        return f40599b;
    L9:
        throw new IllegalArgumentException("Bitmap configuration: " + r3 + ", is not supported yet.");
    L11:
        return f40598a;
    }

    public int a() {
        return this.h;
    }
}
