package com.bytedance.android.ec.core.widget.price;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;
import android.text.style.ReplacementSpan;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.services.apm.api.EnsureManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f46156a = 0;

    public static class a extends MetricAffectingSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f46157a;

        public a(float r100) {
            this.f46157a = r100;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "textPaint");
            r100.baselineShift += (int) ((r100.ascent() + r100.descent()) * this.f46157a);
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "textPaint");
            r100.baselineShift += (int) ((r100.ascent() + r100.descent()) * this.f46157a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.widget.price.b$b, reason: collision with other inner class name */
    public static final class C0813b extends CharacterStyle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.ec.core.widget.price.a.b f46158a;

        public C0813b(com.bytedance.android.ec.core.widget.price.a.b r100) {
            Intrinsics.checkNotNullParameter(r100, GXViewKey.VIEW_TYPE_SHADOW_LAYOUT);
            this.f46158a = r100;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            if (r100 == null) goto L5;
            com.bytedance.android.ec.core.widget.price.a.b r101 = this.f46158a;
            r100.setShadowLayer(r101.f46150a, r101.f46151b, r101.f46152c, r101.f46153d);
            return;
        }
    }

    public static final class c extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Paint f46159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f46160b;

        public c(int r100) {
            this.f46160b = r100;
            Paint r101 = new Paint();
            this.f46159a = r101;
            r101.setColor(0);
            r101.setStyle(Paint.Style.FILL);
        }

        @Override // android.text.style.ReplacementSpan
        public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
            Intrinsics.checkNotNullParameter(r100, "paint");
            Intrinsics.checkNotNullParameter(r101, "text");
            return this.f46160b;
        }

        @Override // android.text.style.ReplacementSpan
        public final void draw(Canvas r100, CharSequence r101, int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
            Intrinsics.checkNotNullParameter(r100, "canvas");
            Intrinsics.checkNotNullParameter(r101, "text");
            Intrinsics.checkNotNullParameter(r115, "paint");
            r100.drawRect(r111, r112, r111 + this.f46160b, r114, this.f46159a);
        }
    }

    static {
    }

    @JvmStatic
    public static final long a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        if (r100 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        long r103 = 0;
    L13:
        Object r104 = Result.m9449constructorimpl(Long.valueOf(r103));     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r104) == false) goto L20;
        r104 = null;
    L20:
        Long r105 = (Long) r104;
        if (r105 != null) goto L27;
        EnsureManager.ensureNotReachHere("price is illegal, it is " + r100);
        return 0;
    L27:
        return r105.longValue();
    L12:
        r103 = new BigDecimal(r100).multiply(new BigDecimal(100)).longValue();     // Catch: Throwable -> L15
        goto L13
    L6:
        if (StringsKt.isBlank(r100) == true) goto L9;
        r102 = false;
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public static String b(long r110, boolean r111) {
        if (r111 == false) goto L5;
        StringCompanionObject r112 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r110 / 100.0d)}, 1));
    L5:
        long r100 = 100;
        if ((r110 % r100) != 0) goto L9;
        return String.valueOf(r110 / r100);
    L9:
        if ((r110 % ((long) 10)) != 0) goto L11;
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r110 / 100.0d)}, 1));
    L11:
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r110 / 100.0d)}, 1));
    }
}
