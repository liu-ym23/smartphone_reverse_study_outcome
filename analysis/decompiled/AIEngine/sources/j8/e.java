package j8;

import androidx.core.widget.NestedScrollView;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {
    public static void a(NestedScrollView nestedScrollView, StepOSScrollBarView stepOSScrollBarView) {
        stepOSScrollBarView.setScrollableView(nestedScrollView);
        if (nestedScrollView instanceof StepOSNestedScrollView) {
            c cVar = new c(stepOSScrollBarView);
            ie.d dVar = ((StepOSNestedScrollView) nestedScrollView).J;
            if (dVar.f9613s == null) {
                dVar.f9613s = new ArrayList();
            }
            dVar.f9613s.add(cVar);
        }
        nestedScrollView.setOnScrollChangeListener(new d(stepOSScrollBarView));
    }
}
