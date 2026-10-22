package android.view;

import C7.r;
import H7.c;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.d;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/app/Activity;", "Landroid/view/View;", "view", "LC7/r;", "trackPipAnimationHintView", "(Landroid/app/Activity;Landroid/view/View;LH7/c;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.activity.PipHintTrackerKt, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class Activity {
    @RequiresApi(26)
    public static final Object trackPipAnimationHintView(final android.app.Activity activity, View view, c<? super r> cVar) {
        Object objCollect = d.c(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).collect(new p9.d() { // from class: androidx.activity.PipHintTrackerKt.trackPipAnimationHintView.2
            public final Object emit(Rect rect, c<? super r> cVar2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return r.f317a;
            }

            @Override // p9.d
            public /* bridge */ /* synthetic */ Object emit(Object obj, c cVar2) {
                return emit((Rect) obj, (c<? super r>) cVar2);
            }
        }, cVar);
        return objCollect == CoroutineSingletons.f4909a ? objCollect : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
