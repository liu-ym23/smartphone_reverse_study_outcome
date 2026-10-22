package com.bytedance.android.shopping.deepfeed.slice.view.gradienttext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\n\u000bB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/gradienttext/DeepFeedGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedGradientTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f173536a;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView$a$a, reason: collision with other inner class name */
        public static final class C2594a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f173537a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2594a) == true) goto L6;
                return false;
            L6:
                if (Float.compare(this.f173537a, ((C2594a) r100).f173537a) == 0) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.f173537a);
            }

            public final String toString() {
                return "Percent(value=" + this.f173537a + ")";
            }

            public C2594a(float r100) {
                this.f173537a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f173538a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == true) goto L6;
                return false;
            L6:
                if (Float.compare(this.f173538a, ((b) r100).f173538a) == 0) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.f173538a);
            }

            public final String toString() {
                return "Px(value=" + this.f173538a + ")";
            }

            public b(float r100) {
                this.f173538a = r100;
            }
        }

        public a() {
        }

        public final float a(float r100) {
            if ((this instanceof b) == false) goto L6;
            return ((b) this).f173538a;
        L6:
            if ((this instanceof C2594a) == false) goto L10;
            return r100 * ((C2594a) this).f173537a;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int[] f173539a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final float[] f173540b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final float f173541c;

            public final int hashCode() {
                int[] r100 = this.f173539a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = Arrays.hashCode(r100);
            L6:
                int r103 = r102 * 31;
                float[] r104 = this.f173540b;
                if (r104 == null) goto L10;
                r101 = Arrays.hashCode(r104);
            L10:
                return ((r103 + r101) * 31) + Float.floatToIntBits(this.f173541c);
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Linear(colors=" + Arrays.toString(this.f173539a) + ", stops=" + Arrays.toString(this.f173540b) + ", angle=" + this.f173541c + ")";
            }

            @Override // com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView.b
            public final int[] a() {
                return this.f173539a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L12;
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f173539a, r101.f173539a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f173540b, r101.f173540b) == true) goto L10;
                return false;
            L10:
                if (Float.compare(this.f173541c, r101.f173541c) == 0) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public a(int[] r100, float[] r101, float r102) {
                Intrinsics.checkNotNullParameter(r100, "colors");
                super(r100);
                this.f173539a = r100;
                this.f173540b = r101;
                this.f173541c = r102;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView$b$b, reason: collision with other inner class name */
        public static final class C2595b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int[] f173542a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final float[] f173543b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final a f173544c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final a f173545d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final a f173546e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final a f173547f;

            public final int hashCode() {
                int[] r100 = this.f173542a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = Arrays.hashCode(r100);
            L6:
                int r103 = r102 * 31;
                float[] r104 = this.f173543b;
                if (r104 == null) goto L9;
                int r105 = Arrays.hashCode(r104);
            L10:
                int r106 = (r103 + r105) * 31;
                a r107 = this.f173544c;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                a r110 = this.f173545d;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                a r113 = this.f173546e;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                a r116 = this.f173547f;
                if (r116 == null) goto L26;
                r101 = r116.hashCode();
            L26:
                return r115 + r101;
            L21:
                r114 = 0;
                goto L22
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Radial(colors=" + Arrays.toString(this.f173542a) + ", stops=" + Arrays.toString(this.f173543b) + ", centerX=" + this.f173544c + ", centerY=" + this.f173545d + ", radiusX=" + this.f173546e + ", radiusY=" + this.f173547f + ")";
            }

            @Override // com.bytedance.android.shopping.deepfeed.slice.view.gradienttext.DeepFeedGradientTextView.b
            public final int[] a() {
                return this.f173542a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C2595b) == false) goto L18;
                C2595b r101 = (C2595b) r100;
                if (Intrinsics.areEqual(this.f173542a, r101.f173542a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f173543b, r101.f173543b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f173544c, r101.f173544c) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f173545d, r101.f173545d) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.f173546e, r101.f173546e) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.f173547f, r101.f173547f) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public C2595b(int[] r100, float[] r101, a r102, a r103, a r104, a r105) {
                Intrinsics.checkNotNullParameter(r100, "colors");
                Intrinsics.checkNotNullParameter(r102, "centerX");
                Intrinsics.checkNotNullParameter(r103, "centerY");
                Intrinsics.checkNotNullParameter(r104, "radiusX");
                Intrinsics.checkNotNullParameter(r105, "radiusY");
                super(r100);
                this.f173542a = r100;
                this.f173543b = r101;
                this.f173544c = r102;
                this.f173545d = r103;
                this.f173546e = r104;
                this.f173547f = r105;
            }
        }

        public abstract int[] a();

        public b(int[] r100) {
        }
    }

    public DeepFeedGradientTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedGradientTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public static Integer x(Object r100) {
        if ((r100 instanceof Number) == true) goto L20;
        Object r101 = null;
        if ((r100 instanceof String) == false) goto L17;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor((String) r100)));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == true) goto L21;
        r101 = r103;
    L21:
        return (Integer) r101;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L17:
        return null;
    L20:
        return Integer.valueOf(((Number) r100).intValue());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        TextPaint r100 = getPaint();
        float r101 = getWidth();
        float r102 = getHeight();
        b r103 = this.f173536a;
        if (r103 != null) goto L6;
    L4:
        Shader r104 = null;
    L24:
        r100.setShader(r104);
        super.onDraw(r210);
        getPaint().setShader(null);
        return;
    L6:
        if (r101 <= 0.0f) goto L4;
        if (r102 <= 0.0f) goto L4;
        if (r103.a().length < 2) goto L4;
        if ((r103 instanceof b.a) == false) goto L16;
        b.a r105 = (b.a) r103;
        double r106 = Math.toRadians(r105.f173541c);
        float r110 = r101 / 2.0f;
        float r111 = r102 / 2.0f;
        float r107 = (((float) Math.cos(r106)) * r101) / 2.0f;
        float r108 = (((float) Math.sin(r106)) * r102) / 2.0f;
        Shader r211 = new LinearGradient(r110 - r107, r111 - r108, r110 + r107, r111 + r108, r105.f173539a, r105.f173540b, Shader.TileMode.CLAMP);
    L21:
        r104 = r211;
        goto L24
    L16:
        if ((r103 instanceof b.C2595b) == false) goto L23;
        b.C2595b r109 = (b.C2595b) r103;
        float r112 = r109.f173544c.a(r101);
        float r113 = r109.f173545d.a(r102);
        float r114 = Math.max(r109.f173546e.a(r101), 1.0f);
        float r115 = Math.max(r109.f173547f.a(r102), 1.0f);
        float r116 = Math.max(r114, r115);
        RadialGradient r117 = new RadialGradient(r112, r113, r116, r109.f173542a, r109.f173543b, Shader.TileMode.CLAMP);
        if (r114 == r115) goto L20;
        Matrix r118 = new Matrix();
        r118.setScale(r114 / r116, r115 / r116, r112, r113);
        r117.setLocalMatrix(r118);
    L20:
        r211 = r117;
        goto L21
    L23:
        throw new NoWhenBranchMatchedException();
    }

    public static a A(Object r100, a.C2594a r101) {
        if ((r100 instanceof Number) == false) goto L6;
        return new a.b(((Number) r100).floatValue());
    L6:
        if ((r100 instanceof String) == false) goto L19;
        String r102 = (String) r100;
        if (StringsKt.endsWith$default(r102, GXTemplateKey.GAIAX_PE, false, 2, null) == false) goto L13;
        Float r103 = StringsKt.toFloatOrNull(StringsKt.removeSuffix(r102, GXTemplateKey.GAIAX_PE));
        if (r103 == null) goto L12;
        a r104 = new a.C2594a(r103.floatValue() / 100.0f);
    L17:
        return r104;
    L12:
        return r101;
    L13:
        Float r105 = StringsKt.toFloatOrNull(r102);
        if (r105 == null) goto L20;
        r104 = new a.b(r105.floatValue());
        goto L17
    L20:
        return r101;
    L19:
        return r101;
    }

    public final Float y(Map<String, ? extends Object> r100, String r101) {
        Object r102 = r100.get(r101);
        if ((r102 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r102).floatValue());
    L6:
        if ((r102 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toFloatOrNull((String) r102);
    }

    public final Integer z(Map<String, ? extends Object> r100, String r101) {
        Object r102 = r100.get(r101);
        if ((r102 instanceof Number) == false) goto L6;
        return Integer.valueOf(((Number) r102).intValue());
    L6:
        if ((r102 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toIntOrNull((String) r102);
    }

    public DeepFeedGradientTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ DeepFeedGradientTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        invalidate();
    }
}
