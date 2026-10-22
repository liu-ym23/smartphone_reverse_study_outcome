package t9;

import androidx.core.widget.NestedScrollView;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g {
    public static void a(NestedScrollView nestedScrollView, StepOSScrollBarView stepOSScrollBarView) {
        stepOSScrollBarView.setScrollableView(nestedScrollView);
        if (nestedScrollView instanceof StepOSNestedScrollView) {
            f fVar = new f();
            fVar.f13290c = stepOSScrollBarView;
            VarHandle.storeStoreFence();
            ve.d dVar = ((StepOSNestedScrollView) nestedScrollView).K;
            if (dVar.f14940s == null) {
                dVar.f14940s = new ArrayList();
            }
            dVar.f14940s.add(fVar);
        }
        sa.c cVar = new sa.c(4, false);
        cVar.f12170f = stepOSScrollBarView;
        VarHandle.storeStoreFence();
        nestedScrollView.setOnScrollChangeListener(cVar);
    }
}
