package androidx.preference;

import K.C0069b;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class I extends C0069b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f4032a;

    public I(J j4) {
        this.f4032a = j4;
    }

    @Override // K.C0069b
    public final void onInitializeAccessibilityNodeInfo(View view, L.g gVar) {
        J j4 = this.f4032a;
        j4.f4034b.onInitializeAccessibilityNodeInfo(view, gVar);
        int childAdapterPosition = j4.f4033a.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = j4.f4033a.getAdapter();
        if (adapter instanceof C) {
            ((C) adapter).getItem(childAdapterPosition);
        }
    }

    @Override // K.C0069b
    public final boolean performAccessibilityAction(View view, int i4, Bundle bundle) {
        return this.f4032a.f4034b.performAccessibilityAction(view, i4, bundle);
    }
}
