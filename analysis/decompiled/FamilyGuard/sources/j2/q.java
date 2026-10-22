package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.MyRecyclerView;
import com.stepos.widget.button.StepOSButton;
import i0.C0756a;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17776a;

    /* renamed from: b, reason: collision with root package name */
    public final StepOSButton f17777b;

    /* renamed from: c, reason: collision with root package name */
    public final MyRecyclerView f17778c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f17779d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f17780e;

    private q(ConstraintLayout constraintLayout, StepOSButton stepOSButton, MyRecyclerView myRecyclerView, ConstraintLayout constraintLayout2, TextView textView) {
        this.f17776a = constraintLayout;
        this.f17777b = stepOSButton;
        this.f17778c = myRecyclerView;
        this.f17779d = constraintLayout2;
        this.f17780e = textView;
    }

    public static q a(View view) {
        int i5 = R.id.btn_turn_on;
        StepOSButton stepOSButton = (StepOSButton) C0756a.a(view, R.id.btn_turn_on);
        if (stepOSButton != null) {
            i5 = R.id.recycler_view;
            MyRecyclerView myRecyclerView = (MyRecyclerView) C0756a.a(view, R.id.recycler_view);
            if (myRecyclerView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i5 = R.id.txt_select_title;
                TextView textView = (TextView) C0756a.a(view, R.id.txt_select_title);
                if (textView != null) {
                    return new q(constraintLayout, stepOSButton, myRecyclerView, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static q c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_select_minor, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.f17776a;
    }
}
