package v0;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f5940a;

    public /* synthetic */ u(RecyclerView recyclerView) {
        this.f5940a = recyclerView;
    }

    public void a(int i8) {
        RecyclerView recyclerView = this.f5940a;
        View childAt = recyclerView.getChildAt(i8);
        if (childAt != null) {
            RecyclerView.s(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i8);
    }
}
