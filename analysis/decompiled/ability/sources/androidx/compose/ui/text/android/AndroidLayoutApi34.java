package androidx.compose.ui.text.android;

import S7.n;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SegmentFinder;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.text.input.internal.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.selection.Api34SegmentFinder;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@RequiresApi(34)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/android/AndroidLayoutApi34;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/text/android/TextLayout;", "layout", "Landroid/graphics/RectF;", "rectF", "", "granularity", "Lkotlin/Function2;", "", "inclusionStrategy", "", "getRangeForRect$ui_text", "(Landroidx/compose/ui/text/android/TextLayout;Landroid/graphics/RectF;ILS7/n;)[I", "getRangeForRect", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidLayoutApi34 {
    public static final int $stable = 0;
    public static final AndroidLayoutApi34 INSTANCE = new AndroidLayoutApi34();

    private AndroidLayoutApi34() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRangeForRect$lambda$0(n nVar, RectF rectF, RectF rectF2) {
        return ((Boolean) nVar.invoke(rectF, rectF2)).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.text.android.a] */
    public final int[] getRangeForRect$ui_text(TextLayout layout, RectF rectF, int granularity, final n inclusionStrategy) {
        SegmentFinder segmentFinderM;
        if (granularity == 1) {
            segmentFinderM = Api34SegmentFinder.INSTANCE.toAndroidSegmentFinder$ui_text(new WordSegmentFinder(layout.getText(), layout.getWordIterator()));
        } else {
            e.q();
            segmentFinderM = e.m(e.l(layout.getText(), layout.getTextPaint()));
        }
        return layout.getLayout().getRangeForRect(rectF, segmentFinderM, new Layout.TextInclusionStrategy() { // from class: androidx.compose.ui.text.android.a
            @Override // android.text.Layout.TextInclusionStrategy
            public final boolean isSegmentInside(RectF rectF2, RectF rectF3) {
                return AndroidLayoutApi34.getRangeForRect$lambda$0(inclusionStrategy, rectF2, rectF3);
            }
        });
    }
}
