package com.android.ttcjpaysdk.base.ui.widget;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/FakeBoldColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "strokeWidth", "", "color", "", "(FI)V", "getColor", "()I", "getStrokeWidth", "()F", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeBoldColorSpan extends ForegroundColorSpan {
    private final int color;
    private final float strokeWidth;

    public FakeBoldColorSpan() {
        float r100 = 0.0f;
        int r101 = 0;
        this(r100, r101, 3, null);
    }

    public final int getColor() {
        return this.color;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setStyle(Paint.Style.FILL_AND_STROKE);
        r100.setStrokeWidth(this.strokeWidth);
    }

    public FakeBoldColorSpan(float r100, int r101) {
        super(r101);
        this.strokeWidth = r100;
        this.color = r101;
    }

    public /* synthetic */ FakeBoldColorSpan(float r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0.5f;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = ColorProtector.parseColor("#161823");
    L8:
        this(r100, r101);
    }
}
