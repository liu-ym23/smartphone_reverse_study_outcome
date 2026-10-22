package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import i0.C0756a;

/* renamed from: j2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0790g {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17711a;

    /* renamed from: b, reason: collision with root package name */
    public final MyRecyclerView f17712b;

    private C0790g(ConstraintLayout constraintLayout, MyRecyclerView myRecyclerView) {
        this.f17711a = constraintLayout;
        this.f17712b = myRecyclerView;
    }

    public static C0790g a(View view) {
        MyRecyclerView myRecyclerView = (MyRecyclerView) C0756a.a(view, R.id.recycler_view);
        if (myRecyclerView != null) {
            return new C0790g((ConstraintLayout) view, myRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.recycler_view)));
    }

    public static C0790g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0790g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_minor_whitelist_app, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.f17711a;
    }
}
