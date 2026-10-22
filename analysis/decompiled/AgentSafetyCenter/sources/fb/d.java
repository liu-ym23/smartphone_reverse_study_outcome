package fb;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.stepos.widget.toolbar.StepOSTitleBar;
import java.util.ArrayList;
import yb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StepOSTitleBar f4056c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(StepOSTitleBar stepOSTitleBar, Context context) {
        super(context);
        this.f4056c = stepOSTitleBar;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        view.getClass();
        super.onViewRemoved(view);
        StepOSTitleBar stepOSTitleBar = this.f4056c;
        ArrayList arrayList = stepOSTitleBar.f2901k;
        x.a(arrayList);
        arrayList.remove(view);
        ArrayList arrayList2 = stepOSTitleBar.f2902l;
        x.a(arrayList2);
        arrayList2.remove(view);
        if (view instanceof LinearLayout) {
            stepOSTitleBar.f2903m.remove(view);
        }
    }
}
