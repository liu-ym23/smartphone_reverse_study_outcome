package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/platform/style/DrawStyleSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "<init>", "(Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {
    public static final int $stable = 8;
    private final DrawStyle drawStyle;

    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    public DrawStyleSpan(DrawStyle r100) {
        this.drawStyle = r100;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        if (r100 == null) goto L15;
        DrawStyle r101 = this.drawStyle;
        if (Intrinsics.areEqual(r101, Fill.INSTANCE) == false) goto L7;
        r100.setStyle(Paint.Style.FILL);
        return;
    L7:
        if ((r101 instanceof Stroke) == false) goto L14;
        r100.setStyle(Paint.Style.STROKE);
        r100.setStrokeWidth(((Stroke) this.drawStyle).getWidth());
        r100.setStrokeMiter(((Stroke) this.drawStyle).getMiter());
        r100.setStrokeJoin(DrawStyleSpan_androidKt.m7287toAndroidJoinWw9F2mQ(((Stroke) this.drawStyle).m5480getJoinLxFBmk8()));
        r100.setStrokeCap(DrawStyleSpan_androidKt.m7286toAndroidCapBeK7IIE(((Stroke) this.drawStyle).m5479getCapKaPHkGw()));
        PathEffect r102 = ((Stroke) this.drawStyle).getPathEffect();
        if (r102 == null) goto L11;
        android.graphics.PathEffect r103 = AndroidPathEffect_androidKt.asAndroidPathEffect(r102);
    L12:
        r100.setPathEffect(r103);
        return;
    L11:
        r103 = null;
        goto L12
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
