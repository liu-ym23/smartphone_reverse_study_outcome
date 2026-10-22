package com.bytedanceos.appstore.buss.utilities.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bytedance.keva.KevaImpl;
import com.bytedanceos.appstore.buss.utilities.g;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class RoundedAppIconCornersTransformation extends com.bytedanceos.appstore.buss.utilities.image.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CornerType f8847d;

    public static final enum CornerType extends Enum<CornerType> {
        private static final /* synthetic */ CornerType[] $VALUES = null;
        public static final CornerType ALL = null;
        public static final CornerType BOTTOM = null;
        public static final CornerType BOTTOM_LEFT = null;
        public static final CornerType BOTTOM_RIGHT = null;
        public static final CornerType DIAGONAL_FROM_TOP_LEFT = null;
        public static final CornerType DIAGONAL_FROM_TOP_RIGHT = null;
        public static final CornerType LEFT = null;
        public static final CornerType OTHER_BOTTOM_LEFT = null;
        public static final CornerType OTHER_BOTTOM_RIGHT = null;
        public static final CornerType OTHER_TOP_LEFT = null;
        public static final CornerType OTHER_TOP_RIGHT = null;
        public static final CornerType RIGHT = null;
        public static final CornerType TOP = null;
        public static final CornerType TOP_LEFT = null;
        public static final CornerType TOP_RIGHT = null;

        private static /* synthetic */ CornerType[] $values() {
            return new CornerType[]{ALL, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, TOP, BOTTOM, LEFT, RIGHT, OTHER_TOP_LEFT, OTHER_TOP_RIGHT, OTHER_BOTTOM_LEFT, OTHER_BOTTOM_RIGHT, DIAGONAL_FROM_TOP_LEFT, DIAGONAL_FROM_TOP_RIGHT};
        }

        static {
            ALL = new CornerType("ALL", 0);
            TOP_LEFT = new CornerType("TOP_LEFT", 1);
            TOP_RIGHT = new CornerType("TOP_RIGHT", 2);
            BOTTOM_LEFT = new CornerType("BOTTOM_LEFT", 3);
            BOTTOM_RIGHT = new CornerType("BOTTOM_RIGHT", 4);
            TOP = new CornerType("TOP", 5);
            BOTTOM = new CornerType("BOTTOM", 6);
            LEFT = new CornerType("LEFT", 7);
            RIGHT = new CornerType("RIGHT", 8);
            OTHER_TOP_LEFT = new CornerType("OTHER_TOP_LEFT", 9);
            OTHER_TOP_RIGHT = new CornerType("OTHER_TOP_RIGHT", 10);
            OTHER_BOTTOM_LEFT = new CornerType("OTHER_BOTTOM_LEFT", 11);
            OTHER_BOTTOM_RIGHT = new CornerType("OTHER_BOTTOM_RIGHT", 12);
            DIAGONAL_FROM_TOP_LEFT = new CornerType("DIAGONAL_FROM_TOP_LEFT", 13);
            DIAGONAL_FROM_TOP_RIGHT = new CornerType("DIAGONAL_FROM_TOP_RIGHT", 14);
            $VALUES = $values();
        }

        private CornerType(String r10, int r11) {
            super(r10, r11);
        }

        public static CornerType valueOf(String r10) {
            return (CornerType) Enum.valueOf(CornerType.class, r10);
        }

        public static CornerType[] values() {
            return (CornerType[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8848a = null;

        static {
            int[] r10 = new int[CornerType.values().length];
            f8848a = r10;
            r10[CornerType.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L54:
            f8848a[CornerType.TOP_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L38:
            f8848a[CornerType.TOP_RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L50:
            f8848a[CornerType.BOTTOM_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L56:
            f8848a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L40:
            f8848a[CornerType.TOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L44:
            f8848a[CornerType.BOTTOM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L62:
            f8848a[CornerType.LEFT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L34:
            f8848a[CornerType.RIGHT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L58:
            f8848a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L60:
            f8848a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L46:
            f8848a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L52:
            f8848a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L36:
            f8848a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L42:
            f8848a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public RoundedAppIconCornersTransformation(int r10, int r11) {
        this(r10, r11, CornerType.ALL);
    }

    @Override // com.bytedanceos.appstore.buss.utilities.image.a
    public Bitmap b(Context r10, BitmapPool r11, Bitmap r12, int r13, int r14) {
        int r15 = r12.getWidth();
        int r16 = r12.getHeight();
        Bitmap r17 = r11.get(r15, r16, Bitmap.Config.ARGB_8888);
        r17.setHasAlpha(true);
        Canvas r18 = new Canvas(r17);
        Paint r19 = new Paint();
        r19.setAntiAlias(true);
        Shader.TileMode r20 = Shader.TileMode.CLAMP;
        r19.setShader(new BitmapShader(r12, r20, r20));
        n(r18, r19, r15, r16);
        return r17;
    }

    public final void c(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        int r15 = this.f8845b;
        RectF r16 = new RectF(r14, r13 - r15, r14 + r15, r13);
        int r17 = this.f8844a;
        r10.drawRoundRect(r16, r17, r17, r11);
        int r18 = this.f8846c;
        r10.drawRect(new RectF(r18, r18, r18 + this.f8845b, r13 - this.f8844a), r11);
        int r19 = this.f8846c;
        r10.drawRect(new RectF(this.f8844a + r19, r19, r12, r13), r11);
    }

    public final void d(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8845b;
        RectF r15 = new RectF(r12 - r14, r13 - r14, r12, r13);
        int r16 = this.f8844a;
        r10.drawRoundRect(r15, r16, r16, r11);
        int r17 = this.f8846c;
        r10.drawRect(new RectF(r17, r17, r12 - this.f8844a, r13), r11);
        int r18 = this.f8844a;
        r10.drawRect(new RectF(r12 - r18, this.f8846c, r12, r13 - r18), r11);
    }

    public final void e(Canvas r10, Paint r11, float r12, float r13) {
        RectF r14 = new RectF(this.f8846c, r13 - this.f8845b, r12, r13);
        int r15 = this.f8844a;
        r10.drawRoundRect(r14, r15, r15, r11);
        int r16 = this.f8846c;
        r10.drawRect(new RectF(r16, r16, r12, r13 - this.f8844a), r11);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r10) {
        if ((r10 instanceof RoundedAppIconCornersTransformation) == false) goto L13;
        RoundedAppIconCornersTransformation r11 = (RoundedAppIconCornersTransformation) r10;
        if (r11.f8844a != this.f8844a) goto L13;
        if (r11.f8845b != this.f8845b) goto L13;
        if (r11.f8846c != this.f8846c) goto L13;
        if (r11.f8847d != this.f8847d) goto L13;
        return true;
    L13:
        return false;
    }

    public final void f(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        int r15 = this.f8845b;
        RectF r16 = new RectF(r14, r14, r14 + r15, r14 + r15);
        int r17 = this.f8844a;
        r10.drawRoundRect(r16, r17, r17, r11);
        int r18 = this.f8845b;
        RectF r19 = new RectF(r12 - r18, r13 - r18, r12, r13);
        int r20 = this.f8844a;
        r10.drawRoundRect(r19, r20, r20, r11);
        int r21 = this.f8846c;
        r10.drawRect(new RectF(r21, r21 + this.f8844a, r12 - this.f8845b, r13), r11);
        int r22 = this.f8846c;
        r10.drawRect(new RectF(this.f8845b + r22, r22, r12, r13 - this.f8844a), r11);
    }

    public final void g(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8845b;
        int r15 = this.f8846c;
        RectF r16 = new RectF(r12 - r14, r15, r12, r15 + r14);
        int r17 = this.f8844a;
        r10.drawRoundRect(r16, r17, r17, r11);
        int r18 = this.f8846c;
        int r19 = this.f8845b;
        RectF r20 = new RectF(r18, r13 - r19, r18 + r19, r13);
        int r21 = this.f8844a;
        r10.drawRoundRect(r20, r21, r21, r11);
        int r22 = this.f8846c;
        int r23 = this.f8844a;
        r10.drawRect(new RectF(r22, r22, r12 - r23, r13 - r23), r11);
        int r24 = this.f8846c;
        int r25 = this.f8844a;
        r10.drawRect(new RectF(r24 + r25, r24 + r25, r12, r13), r11);
    }

    public final void h(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        RectF r15 = new RectF(r14, r14, r14 + this.f8845b, r13);
        int r16 = this.f8844a;
        r10.drawRoundRect(r15, r16, r16, r11);
        int r17 = this.f8846c;
        r10.drawRect(new RectF(this.f8844a + r17, r17, r12, r13), r11);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (((425235636 + (this.f8844a * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD)) + (this.f8845b * 1000)) + (this.f8846c * 100)) + (this.f8847d.ordinal() * 10);
    }

    public final void i(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        RectF r15 = new RectF(r14, r14, r12, r14 + this.f8845b);
        int r16 = this.f8844a;
        r10.drawRoundRect(r15, r16, r16, r11);
        RectF r17 = new RectF(r12 - this.f8845b, this.f8846c, r12, r13);
        int r18 = this.f8844a;
        r10.drawRoundRect(r17, r18, r18, r11);
        int r19 = this.f8846c;
        int r20 = this.f8844a;
        r10.drawRect(new RectF(r19, r19 + r20, r12 - r20, r13), r11);
    }

    public final void j(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        RectF r15 = new RectF(r14, r14, r12, r14 + this.f8845b);
        int r16 = this.f8844a;
        r10.drawRoundRect(r15, r16, r16, r11);
        int r17 = this.f8846c;
        RectF r18 = new RectF(r17, r17, r17 + this.f8845b, r13);
        int r19 = this.f8844a;
        r10.drawRoundRect(r18, r19, r19, r11);
        int r20 = this.f8846c;
        int r21 = this.f8844a;
        r10.drawRect(new RectF(r20 + r21, r20 + r21, r12, r13), r11);
    }

    public final void k(Canvas r10, Paint r11, float r12, float r13) {
        RectF r14 = new RectF(this.f8846c, r13 - this.f8845b, r12, r13);
        int r15 = this.f8844a;
        r10.drawRoundRect(r14, r15, r15, r11);
        RectF r16 = new RectF(r12 - this.f8845b, this.f8846c, r12, r13);
        int r17 = this.f8844a;
        r10.drawRoundRect(r16, r17, r17, r11);
        int r18 = this.f8846c;
        int r19 = this.f8844a;
        r10.drawRect(new RectF(r18, r18, r12 - r19, r13 - r19), r11);
    }

    public final void l(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        RectF r15 = new RectF(r14, r14, r14 + this.f8845b, r13);
        int r16 = this.f8844a;
        r10.drawRoundRect(r15, r16, r16, r11);
        RectF r17 = new RectF(this.f8846c, r13 - this.f8845b, r12, r13);
        int r18 = this.f8844a;
        r10.drawRoundRect(r17, r18, r18, r11);
        int r19 = this.f8846c;
        int r20 = this.f8844a;
        r10.drawRect(new RectF(r19 + r20, r19, r12, r13 - r20), r11);
    }

    public final void m(Canvas r10, Paint r11, float r12, float r13) {
        RectF r14 = new RectF(r12 - this.f8845b, this.f8846c, r12, r13);
        int r15 = this.f8844a;
        r10.drawRoundRect(r14, r15, r15, r11);
        int r16 = this.f8846c;
        r10.drawRect(new RectF(r16, r16, r12 - this.f8844a, r13), r11);
    }

    public final void n(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        float r15 = r12 - r14;
        float r16 = r13 - r14;
        switch(a.f8848a[this.f8847d.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L4;
        };
    L4:
        int r17 = this.f8846c;
        RectF r18 = new RectF(r17, r17, r15, r16);
        int r19 = this.f8844a;
        r10.drawRoundRect(r18, r19, r19, r11);
        return;
    L5:
        g(r10, r11, r15, r16);
        return;
    L6:
        f(r10, r11, r15, r16);
        return;
    L7:
        j(r10, r11, r15, r16);
        return;
    L8:
        i(r10, r11, r15, r16);
        return;
    L9:
        l(r10, r11, r15, r16);
        return;
    L10:
        k(r10, r11, r15, r16);
        return;
    L11:
        m(r10, r11, r15, r16);
        return;
    L12:
        h(r10, r11, r15, r16);
        return;
    L13:
        e(r10, r11, r15, r16);
        return;
    L14:
        q(r10, r11, r15, r16);
        return;
    L15:
        d(r10, r11, r15, r16);
        return;
    L16:
        c(r10, r11, r15, r16);
        return;
    L17:
        p(r10, r11, r15, r16);
        return;
    L18:
        o(r10, r11, r15, r16);
        return;
    L19:
        float r20 = (r12 * 0.02f) / 2.0f;
        int r21 = this.f8846c;
        RectF r22 = new RectF(r21 + r20, r21 + r20, r15 - r20, r16 - ((r13 * 0.02f) / 2.0f));
        int r23 = this.f8844a;
        r10.drawRoundRect(r22, r23, r23, r11);
        Paint r24 = new Paint();
        r24.setStyle(Paint.Style.STROKE);
        r24.setColor(BaseApplication.c().getResources().getColor(R.color.tv_app_item_stroke_color));
        r24.setStrokeWidth(g.b(1));
        int r25 = this.f8844a;
        r10.drawRoundRect(r22, r25, r25, r24);
    }

    public final void o(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        int r15 = this.f8845b;
        RectF r16 = new RectF(r14, r14, r14 + r15, r14 + r15);
        int r17 = this.f8844a;
        r10.drawRoundRect(r16, r17, r17, r11);
        int r18 = this.f8846c;
        int r19 = this.f8844a;
        r10.drawRect(new RectF(r18, r18 + r19, r18 + r19, r13), r11);
        int r20 = this.f8846c;
        r10.drawRect(new RectF(this.f8844a + r20, r20, r12, r13), r11);
    }

    public final void p(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8845b;
        int r15 = this.f8846c;
        RectF r16 = new RectF(r12 - r14, r15, r12, r15 + r14);
        int r17 = this.f8844a;
        r10.drawRoundRect(r16, r17, r17, r11);
        int r18 = this.f8846c;
        r10.drawRect(new RectF(r18, r18, r12 - this.f8844a, r13), r11);
        int r19 = this.f8844a;
        r10.drawRect(new RectF(r12 - r19, this.f8846c + r19, r12, r13), r11);
    }

    public final void q(Canvas r10, Paint r11, float r12, float r13) {
        int r14 = this.f8846c;
        RectF r15 = new RectF(r14, r14, r12, r14 + this.f8845b);
        int r16 = this.f8844a;
        r10.drawRoundRect(r15, r16, r16, r11);
        int r17 = this.f8846c;
        r10.drawRect(new RectF(r17, r17 + this.f8844a, r12, r13), r11);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.f8844a + ", margin=" + this.f8846c + ", diameter=" + this.f8845b + ", cornerType=" + this.f8847d.name() + ")";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r10) {
        r10.update(("jp.wasabeef.glide.transformations.RoundedCornersTransformation.1" + this.f8844a + this.f8845b + this.f8846c + this.f8847d).getBytes(Key.CHARSET));
    }

    public RoundedAppIconCornersTransformation(int r10, int r11, CornerType r12) {
        this.f8844a = r10;
        this.f8845b = r10 * 2;
        this.f8846c = r11;
        this.f8847d = r12;
    }
}
