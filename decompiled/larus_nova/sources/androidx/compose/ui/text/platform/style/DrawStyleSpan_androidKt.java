package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DrawStyleSpan_androidKt {
    /* JADX INFO: renamed from: toAndroidCap-BeK7IIE, reason: not valid java name */
    public static final Paint.Cap m7286toAndroidCapBeK7IIE(int r100) {
        StrokeCap.Companion r101 = StrokeCap.Companion;
        if (StrokeCap.m5202equalsimpl0(r100, r101.m5206getButtKaPHkGw()) == false) goto L6;
        return Paint.Cap.BUTT;
    L6:
        if (StrokeCap.m5202equalsimpl0(r100, r101.m5207getRoundKaPHkGw()) == false) goto L9;
        return Paint.Cap.ROUND;
    L9:
        if (StrokeCap.m5202equalsimpl0(r100, r101.m5208getSquareKaPHkGw()) == false) goto L12;
        return Paint.Cap.SQUARE;
    L12:
        return Paint.Cap.BUTT;
    }

    /* JADX INFO: renamed from: toAndroidJoin-Ww9F2mQ, reason: not valid java name */
    public static final Paint.Join m7287toAndroidJoinWw9F2mQ(int r100) {
        StrokeJoin.Companion r101 = StrokeJoin.Companion;
        if (StrokeJoin.m5212equalsimpl0(r100, r101.m5217getMiterLxFBmk8()) == false) goto L6;
        return Paint.Join.MITER;
    L6:
        if (StrokeJoin.m5212equalsimpl0(r100, r101.m5218getRoundLxFBmk8()) == false) goto L9;
        return Paint.Join.ROUND;
    L9:
        if (StrokeJoin.m5212equalsimpl0(r100, r101.m5216getBevelLxFBmk8()) == false) goto L12;
        return Paint.Join.BEVEL;
    L12:
        return Paint.Join.MITER;
    }
}
