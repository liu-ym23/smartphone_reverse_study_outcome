package com.alibaba.gaiax.render.view.basic.spannable;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/StrikethroughSpan;", "Landroid/text/style/MetricAffectingSpan;", "()V", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class StrikethroughSpan extends MetricAffectingSpan {
    public StrikethroughSpan() {
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        r100.setStrikeThruText(true);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "textPaint");
        r100.setStrikeThruText(true);
    }
}
