package com.alibaba.gaiax.render.view.basic.spannable;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/TypefaceSpan;", "Landroid/text/style/MetricAffectingSpan;", "typeface", "Landroid/graphics/Typeface;", "(Landroid/graphics/Typeface;)V", "getTypeface", "()Landroid/graphics/Typeface;", e1.REPLY_ACTION_APPLY, "", "paint", "Landroid/text/TextPaint;", "updateDrawState", "ds", "updateMeasureState", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TypefaceSpan extends MetricAffectingSpan {
    private final Typeface typeface;

    public final Typeface getTypeface() {
        return this.typeface;
    }

    public TypefaceSpan(Typeface r100) {
        Intrinsics.checkNotNullParameter(r100, "typeface");
        this.typeface = r100;
    }

    private final void apply(TextPaint r100) {
        r100.setTypeface(this.typeface);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        apply(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        apply(r100);
    }
}
