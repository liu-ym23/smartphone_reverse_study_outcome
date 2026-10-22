package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.GraphemeClusterSegmentFinder;
import android.text.SegmentFinder;
import androidx.compose.ui.text.android.selection.Api34SegmentFinder;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/android/AndroidLayoutApi34;", "", "<init>", "()V", "getRangeForRect", "", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "rectF", "Landroid/graphics/RectF;", "granularity", "", "inclusionStrategy", "Lkotlin/Function2;", "", "getRangeForRect$ui_text", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidLayoutApi34 {
    public static final int $stable = 0;
    public static final AndroidLayoutApi34 INSTANCE = null;

    static {
        INSTANCE = new AndroidLayoutApi34();
    }

    private AndroidLayoutApi34() {
    }

    public static /* synthetic */ boolean a(Function2 r100, RectF r101, RectF r102) {
        return getRangeForRect$lambda$0(r100, r101, r102);
    }

    private static final boolean getRangeForRect$lambda$0(Function2 r100, RectF r101, RectF r102) {
        return ((Boolean) r100.invoke(r101, r102)).booleanValue();
    }

    public final int[] getRangeForRect$ui_text(TextLayout r100, RectF r101, int r102, final Function2<? super RectF, ? super RectF, Boolean> r103) {
        if (r102 != 1) goto L5;
        SegmentFinder r104 = Api34SegmentFinder.INSTANCE.toAndroidSegmentFinder$ui_text(new WordSegmentFinder(r100.getText(), r100.getWordIterator()));
    L7:
        return r100.getLayout().getRangeForRect(r101, r104, new a(r103));
    L5:
        r104 = new GraphemeClusterSegmentFinder(r100.getText(), r100.getTextPaint());
        goto L7
    }
}
