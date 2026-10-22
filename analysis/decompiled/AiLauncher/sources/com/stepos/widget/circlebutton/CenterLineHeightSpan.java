package com.stepos.widget.circlebutton;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JA\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/widget/circlebutton/CenterLineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "", "lineHeightPx", "<init>", "(I)V", "", "text", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "spanstartv", "lineHeight", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "LY8/t;", "chooseHeight", "(Ljava/lang/CharSequence;IIIILandroid/graphics/Paint$FontMetricsInt;)V", "I", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class CenterLineHeightSpan implements LineHeightSpan {
    private final int lineHeightPx;

    public CenterLineHeightSpan(int i10) {
        this.lineHeightPx = i10;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence text, int start, int end, int spanstartv, int lineHeight, Paint.FontMetricsInt fm) {
        int i10;
        p.i(fm, "fm");
        int i11 = fm.descent;
        int i12 = fm.ascent;
        int i13 = i11 - i12;
        if (i13 <= 0 || (i10 = this.lineHeightPx) <= 0) {
            return;
        }
        int i14 = i10 - i13;
        int i15 = i14 / 2;
        fm.ascent = i12 - i15;
        fm.descent = i11 + (i14 - i15);
    }
}
