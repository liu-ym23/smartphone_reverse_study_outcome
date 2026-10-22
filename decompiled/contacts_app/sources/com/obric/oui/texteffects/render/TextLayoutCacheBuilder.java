package com.obric.oui.texteffects.render;

import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextLayoutCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/texteffects/render/TextLayoutCacheBuilder;", "", "()V", "build", "Lcom/obric/oui/texteffects/render/TextLayoutCache;", "text", "", "paint", "Landroid/text/TextPaint;", "contentWidth", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "startXForWidth", "Lkotlin/Function1;", "gradientFactory", "Landroid/graphics/LinearGradient;", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextLayoutCacheBuilder {
    public static final TextLayoutCacheBuilder INSTANCE = null;

    static {
        INSTANCE = new TextLayoutCacheBuilder();
    }

    private TextLayoutCacheBuilder() {
    }

    public final TextLayoutCache build(CharSequence r16, TextPaint r17, float r18, TextUtils.TruncateAt r19, Function1<? super Float, Float> r20, Function1<? super TextLayoutCache, ? extends LinearGradient> r21) {
        Intrinsics.checkNotNullParameter(r16, "text");
        Intrinsics.checkNotNullParameter(r17, "paint");
        Intrinsics.checkNotNullParameter(r20, "startXForWidth");
        Intrinsics.checkNotNullParameter(r21, "gradientFactory");
        if (r19 != null) goto L5;
    L7:
        CharSequence r6 = r16;
    L8:
        char[] r7 = r6.toString().toCharArray();
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).toCharArray()");
        float[] r8 = new float[r7.length];
        if (r7.length != 0) goto L11;
        boolean r3 = true;
    L13:
        if ((!r3) == false) goto L15;
        r17.getTextWidths(r7, 0, r7.length, r8);
    L15:
        float r12 = ArraysKt.sum(r8);
        Intrinsics.checkNotNullExpressionValue(r6, "displayText");
        TextLayoutCache r4 = new TextLayoutCache(r16, r6, r7, r8, r18, r19, r17.getTextSize(), r12, r20.invoke(Float.valueOf(r12)).floatValue(), null);
        r4.setGradientShader(r21.invoke(r4));
        return r4;
    L11:
        r3 = false;
        goto L13
    L5:
        if (r18 <= 0.0f) goto L7;
        r6 = TextUtils.ellipsize(r16, r17, r18, r19);
        goto L8
    }
}
