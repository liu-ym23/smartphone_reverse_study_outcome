package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"trackPipAnimationHintView", "", "Landroid/app/Activity;", "view", "Landroid/view/View;", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PipHintTrackerKt {
    public static final /* synthetic */ Rect access$trackPipAnimationHintView$positionInWindow(View r100) {
        return trackPipAnimationHintView$positionInWindow(r100);
    }

    private static final Rect trackPipAnimationHintView$positionInWindow(View r100) {
        Rect r101 = new Rect();
        r100.getGlobalVisibleRect(r101);
        return r101;
    }

    public static final Object trackPipAnimationHintView(final Activity r100, View r101, Continuation<? super Unit> r102) {
        Object r103 = kotlinx.coroutines.flow.e.e(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(r101, null)).collect(new AnonymousClass2(r100), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }
}
