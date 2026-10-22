package l2;

import com.google.android.gms.common.api.internal.p;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class g {
    public static void a(StepOSNestedScrollView stepOSNestedScrollView, StepOSScrollBarView stepOSScrollBarView) {
        stepOSScrollBarView.setScrollableView(stepOSNestedScrollView);
        if (stepOSNestedScrollView instanceof StepOSNestedScrollView) {
            f fVar = new f(stepOSScrollBarView);
            N3.d dVar = stepOSNestedScrollView.f11431F;
            if (dVar.f1515s == null) {
                dVar.f1515s = new ArrayList();
            }
            dVar.f1515s.add(fVar);
        }
        stepOSNestedScrollView.setOnScrollChangeListener(new p(16, stepOSScrollBarView));
    }
}
