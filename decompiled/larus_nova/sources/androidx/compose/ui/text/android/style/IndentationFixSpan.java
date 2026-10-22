package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Jp\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/android/style/IndentationFixSpan;", "Landroid/text/style/LeadingMarginSpan;", "<init>", "()V", "getLeadingMargin", "", "firstLine", "", "drawLeadingMargin", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "left", MapBundleKey.MapObjKey.OBJ_DIR, "top", "baseline", "bottom", "text", "", "start", "end", SoloKtvContext.SOLO_PAGE_FIRST, "layout", "Landroid/text/Layout;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IndentationFixSpan implements LeadingMarginSpan {
    public static final int $stable = 0;

    public IndentationFixSpan() {
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r100) {
        return 0;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        if (r112 == null) goto L15;
        if (r101 == null) goto L16;
        int r109 = r112.getLineForOffset(r108);
        boolean r113 = true;
        if (r109 == (r112.getLineCount() - 1)) goto L7;
        return;
    L7:
        if (TextLayout_androidKt.isLineEllipsized(r112, r109) == false) goto L18;
        float r114 = IndentationFixSpan_androidKt.getEllipsizedLeftPadding(r112, r109, r101) + IndentationFixSpan_androidKt.getEllipsizedRightPadding(r112, r109, r101);
        if (r114 == 0.0f) goto L12;
        r113 = false;
    L12:
        if (r113 == true) goto L19;
        Intrinsics.checkNotNull(r100);
        r100.translate(r114, 0.0f);
        return;
    L19:
        return;
    L18:
        return;
    L16:
        return;
    }
}
