package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.stepos.common.widget.StepOSEditInputView;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17727a;

    /* renamed from: b, reason: collision with root package name */
    public final StepOSEditInputView f17728b;

    private l(LinearLayout linearLayout, StepOSEditInputView stepOSEditInputView) {
        this.f17727a = linearLayout;
        this.f17728b = stepOSEditInputView;
    }

    public static l a(View view) {
        StepOSEditInputView stepOSEditInputView = (StepOSEditInputView) C0756a.a(view, R.id.stepos_edit_input_view);
        if (stepOSEditInputView != null) {
            return new l((LinearLayout) view, stepOSEditInputView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.stepos_edit_input_view)));
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.alert_dialog_text_entry_singleline, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.f17727a;
    }
}
