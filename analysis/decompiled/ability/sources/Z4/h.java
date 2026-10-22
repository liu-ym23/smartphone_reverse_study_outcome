package Z4;

import androidx.core.widget.NestedScrollView;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class h {
    public static void a(NestedScrollView nestedScrollView, StepOSScrollBarView stepOSScrollBarView) {
        stepOSScrollBarView.setScrollableView(nestedScrollView);
        if (nestedScrollView instanceof StepOSNestedScrollView) {
            f fVar = new f(stepOSScrollBarView);
            Xa.e eVar = ((StepOSNestedScrollView) nestedScrollView).f3620a;
            if (eVar.f1550s == null) {
                eVar.f1550s = new ArrayList();
            }
            eVar.f1550s.add(fVar);
        }
        nestedScrollView.setOnScrollChangeListener(new g(stepOSScrollBarView));
    }
}
