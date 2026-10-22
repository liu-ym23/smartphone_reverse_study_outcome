package com.alibaba.gaiax.render.view.basic.spannable;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/spannable/LetterSpacingSpan;", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "", "(F)V", e1.REPLY_ACTION_APPLY, "", "paint", "Landroid/text/TextPaint;", "updateDrawState", "updateMeasureState", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LetterSpacingSpan extends MetricAffectingSpan {
    private final float letterSpacing;

    public LetterSpacingSpan(float r100) {
        this.letterSpacing = r100;
    }

    private final void apply(TextPaint r100) {
        r100.setLetterSpacing(this.letterSpacing);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        apply(r100);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        apply(r100);
    }
}
