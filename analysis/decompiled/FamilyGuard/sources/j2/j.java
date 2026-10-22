package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.common.widget.StepOSButton;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17718a;

    /* renamed from: b, reason: collision with root package name */
    public final StepOSButton f17719b;

    /* renamed from: c, reason: collision with root package name */
    public final G f17720c;

    /* renamed from: d, reason: collision with root package name */
    public final G f17721d;

    /* renamed from: e, reason: collision with root package name */
    public final G f17722e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f17723f;

    private j(ConstraintLayout constraintLayout, StepOSButton stepOSButton, G g5, G g6, G g7, TextView textView) {
        this.f17718a = constraintLayout;
        this.f17719b = stepOSButton;
        this.f17720c = g5;
        this.f17721d = g6;
        this.f17722e = g7;
        this.f17723f = textView;
    }

    public static j a(View view) {
        int i5 = R.id.btn;
        StepOSButton stepOSButton = (StepOSButton) C0756a.a(view, R.id.btn);
        if (stepOSButton != null) {
            i5 = R.id.item1;
            View viewA = C0756a.a(view, R.id.item1);
            if (viewA != null) {
                G gA = G.a(viewA);
                i5 = R.id.item2;
                View viewA2 = C0756a.a(view, R.id.item2);
                if (viewA2 != null) {
                    G gA2 = G.a(viewA2);
                    i5 = R.id.item3;
                    View viewA3 = C0756a.a(view, R.id.item3);
                    if (viewA3 != null) {
                        G gA3 = G.a(viewA3);
                        i5 = R.id.title;
                        TextView textView = (TextView) C0756a.a(view, R.id.title);
                        if (textView != null) {
                            return new j((ConstraintLayout) view, stepOSButton, gA, gA2, gA3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_reopen_digital_wellbeing, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.f17718a;
    }
}
