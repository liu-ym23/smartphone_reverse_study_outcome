package aab;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.View;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2374a = 0;

    static {
    }

    public static ImageSpan b(Layout r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        CharSequence r103 = r100.getText();
        if ((r103 instanceof Spanned) == false) goto L5;
        Spanned r104 = (Spanned) r103;
    L6:
        if (r104 == null) goto L8;
        ImageSpan[] r105 = (ImageSpan[]) r104.getSpans(r101, r102, ImageSpan.class);
    L9:
        boolean r106 = true;
        if (r105 != null) goto L12;
    L18:
        if (r106 == false) goto L21;
        return null;
    L21:
        return (ImageSpan) ArraysKt.first(r105);
    L12:
        if (r105.length != 0) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == true) goto L18;
        r106 = false;
        goto L18
    L14:
        r107 = false;
        goto L15
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    public static Rect a(ImageSpan r100, View r101, Layout r102, int r103, int r110) {
        Intrinsics.checkNotNullParameter(r100, "imageSpan");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "layout");
        Rect r104 = new Rect();
        Drawable r105 = r100.getDrawable();
        int r106 = r102.getLineForOffset(r103);
        float r107 = r102.getPrimaryHorizontal(r103);
        float r111 = r102.getPrimaryHorizontal(r110);
        r102.getLineBounds(r106, r104);
        int r108 = r100.getVerticalAlignment();
        if (r108 == 1) goto L7;
        if (r108 == 2) goto L6;
        r104.top += r104.height() - r105.getIntrinsicHeight();
    L8:
        int[] r109 = new int[2];
        r101.getLocationOnScreen(r109);
        int r112 = (r109[1] - r101.getScrollY()) + r101.getPaddingTop();
        r104.top += r112;
        r104.bottom += r112;
        int r113 = r104.left + MathKt.roundToInt(((r109[0] + r107) + r101.getPaddingLeft()) - r101.getScrollX());
        r104.left = r113;
        r104.right = MathKt.roundToInt((r113 + r111) - r107);
        return r104;
    L6:
        int r114 = (r104.height() - r105.getIntrinsicHeight()) / 2;
        r104.top += r114;
        r104.bottom -= r114;
        goto L8
    L7:
        r104.top += (r104.height() - r105.getIntrinsicHeight()) / 2;
        r104.offset(0, r102.getLineDescent(r106) * (-1));
        goto L8
    }
}
