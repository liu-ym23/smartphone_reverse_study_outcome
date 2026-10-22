package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.common.widget.StepOSEditInputView;
import com.stepos.familyguard.R;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i0.C0756a;

/* renamed from: j2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0789f {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17704a;

    /* renamed from: b, reason: collision with root package name */
    public final StepOSEditInputView f17705b;

    /* renamed from: c, reason: collision with root package name */
    public final StepOSEditInputView f17706c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17707d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f17708e;

    /* renamed from: f, reason: collision with root package name */
    public final StepOSTitleBar f17709f;

    /* renamed from: g, reason: collision with root package name */
    public final StepOSButton f17710g;

    private C0789f(LinearLayout linearLayout, StepOSEditInputView stepOSEditInputView, StepOSEditInputView stepOSEditInputView2, TextView textView, TextView textView2, StepOSTitleBar stepOSTitleBar, StepOSButton stepOSButton) {
        this.f17704a = linearLayout;
        this.f17705b = stepOSEditInputView;
        this.f17706c = stepOSEditInputView2;
        this.f17707d = textView;
        this.f17708e = textView2;
        this.f17709f = stepOSTitleBar;
        this.f17710g = stepOSButton;
    }

    public static C0789f a(View view) {
        int i5 = R.id.input_phone;
        StepOSEditInputView stepOSEditInputView = (StepOSEditInputView) C0756a.a(view, R.id.input_phone);
        if (stepOSEditInputView != null) {
            i5 = R.id.input_verify_code;
            StepOSEditInputView stepOSEditInputView2 = (StepOSEditInputView) C0756a.a(view, R.id.input_verify_code);
            if (stepOSEditInputView2 != null) {
                i5 = R.id.sub_title;
                TextView textView = (TextView) C0756a.a(view, R.id.sub_title);
                if (textView != null) {
                    i5 = R.id.title;
                    TextView textView2 = (TextView) C0756a.a(view, R.id.title);
                    if (textView2 != null) {
                        i5 = R.id.title_bar;
                        StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C0756a.a(view, R.id.title_bar);
                        if (stepOSTitleBar != null) {
                            i5 = R.id.verify;
                            StepOSButton stepOSButton = (StepOSButton) C0756a.a(view, R.id.verify);
                            if (stepOSButton != null) {
                                return new C0789f((LinearLayout) view, stepOSEditInputView, stepOSEditInputView2, textView, textView2, stepOSTitleBar, stepOSButton);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C0789f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0789f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_minor_verify, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.f17704a;
    }
}
