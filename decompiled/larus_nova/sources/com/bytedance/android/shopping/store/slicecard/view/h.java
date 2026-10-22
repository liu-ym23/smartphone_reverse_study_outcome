package com.bytedance.android.shopping.store.slicecard.view;

import android.graphics.Typeface;
import com.bytedance.android.ec.model.ECUrlModel;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECUrlModel f186399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ECUrlModel f186400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f186401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f186402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f186403e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f186404f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f186405g;

        public a() {
            this(null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L20;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f186399a, r101.f186399a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f186400b, r101.f186400b) == true) goto L10;
            return false;
        L10:
            if (Float.compare(this.f186401c, r101.f186401c) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f186402d, r101.f186402d) == 0) goto L14;
            return false;
        L14:
            if (Float.compare(this.f186403e, r101.f186403e) == 0) goto L16;
            return false;
        L16:
            if (Float.compare(this.f186404f, r101.f186404f) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f186405g, r101.f186405g) == 0) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            ECUrlModel r100 = this.f186399a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            ECUrlModel r104 = this.f186400b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return ((((((((((r103 + r101) * 31) + Float.floatToIntBits(this.f186401c)) * 31) + Float.floatToIntBits(this.f186402d)) * 31) + Float.floatToIntBits(this.f186403e)) * 31) + Float.floatToIntBits(this.f186404f)) * 31) + Float.floatToIntBits(this.f186405g);
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Icon(image=" + this.f186399a + ", immersiveImage=" + this.f186400b + ", widthPx=" + this.f186401c + ", heightPx=" + this.f186402d + ", marginLeftPx=" + this.f186403e + ", marginRightPx=" + this.f186404f + ", drawWidth=" + this.f186405g + ")";
        }

        public a(ECUrlModel r100, ECUrlModel r101, float r102, float r103, float r104, float r105, float r106) {
            this.f186399a = r100;
            this.f186400b = r101;
            this.f186401c = r102;
            this.f186402d = r103;
            this.f186403e = r104;
            this.f186404f = r105;
            this.f186405g = r106;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f186406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f186407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f186408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f186409d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float[] f186410e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Float f186411f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Typeface f186412g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f186413h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f186414i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L24;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f186406a, r101.f186406a) == true) goto L8;
            return false;
        L8:
            if (this.f186407b == r101.f186407b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f186408c, r101.f186408c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f186409d, r101.f186409d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f186410e, r101.f186410e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f186411f, r101.f186411f) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f186412g, r101.f186412g) == true) goto L20;
            return false;
        L20:
            if (Float.compare(this.f186413h, r101.f186413h) == 0) goto L22;
            return false;
        L22:
            if (Float.compare(this.f186414i, r101.f186414i) == 0) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        public final int hashCode() {
            String r100 = this.f186406a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            boolean r104 = this.f186407b;
            ?? r105 = r104;
            if (r104 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f186408c;
            if (r107 == null) goto L12;
            int r108 = r107.hashCode();
        L13:
            int r109 = (r106 + r108) * 31;
            int[] r110 = this.f186409d;
            if (r110 == null) goto L16;
            int r111 = Arrays.hashCode(r110);
        L17:
            int r112 = (r109 + r111) * 31;
            float[] r113 = this.f186410e;
            if (r113 == null) goto L20;
            int r114 = Arrays.hashCode(r113);
        L21:
            int r115 = (r112 + r114) * 31;
            Float r116 = this.f186411f;
            if (r116 == null) goto L24;
            int r117 = r116.hashCode();
        L25:
            int r118 = (r115 + r117) * 31;
            Typeface r119 = this.f186412g;
            if (r119 == null) goto L29;
            r101 = r119.hashCode();
        L29:
            return ((((r118 + r101) * 31) + Float.floatToIntBits(this.f186413h)) * 31) + Float.floatToIntBits(this.f186414i);
        L24:
            r117 = 0;
            goto L25
        L20:
            r114 = 0;
            goto L21
        L16:
            r111 = 0;
            goto L17
        L12:
            r108 = 0;
            goto L13
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Text(text=" + this.f186406a + ", gradient=" + this.f186407b + ", color=" + this.f186408c + ", gradientColors=" + Arrays.toString(this.f186409d) + ", gradientPositions=" + Arrays.toString(this.f186410e) + ", textSizePx=" + this.f186411f + ", typeface=" + this.f186412g + ", gradientOrientation=" + this.f186413h + ", drawWidth=" + this.f186414i + ")";
        }

        public /* synthetic */ b(String r110, boolean r111, Integer r112, int[] r113, float[] r114, Float r115, Typeface r116, float r117) {
            this(r110, r111, r112, r113, r114, r115, r116, r117, 0.0f);
        }

        public b(String r100, boolean r101, Integer r102, int[] r103, float[] r104, Float r105, Typeface r106, float r107, float r110) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f186406a = r100;
            this.f186407b = r101;
            this.f186408c = r102;
            this.f186409d = r103;
            this.f186410e = r104;
            this.f186411f = r105;
            this.f186412g = r106;
            this.f186413h = r107;
            this.f186414i = r110;
        }
    }

    public h() {
    }
}
