package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import com.stepos.widget.button.StepOSButton;
import i0.C0756a;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17735a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f17736b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f17737c;

    /* renamed from: d, reason: collision with root package name */
    public final StepOSButton f17738d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearLayout f17739e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f17740f;

    /* renamed from: g, reason: collision with root package name */
    public final LinearLayout f17741g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f17742h;

    /* renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f17743i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f17744j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f17745k;

    private n(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, StepOSButton stepOSButton, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3) {
        this.f17735a = constraintLayout;
        this.f17736b = imageView;
        this.f17737c = imageView2;
        this.f17738d = stepOSButton;
        this.f17739e = linearLayout;
        this.f17740f = linearLayout2;
        this.f17741g = linearLayout3;
        this.f17742h = textView;
        this.f17743i = constraintLayout2;
        this.f17744j = textView2;
        this.f17745k = textView3;
    }

    public static n a(View view) {
        int i5 = R.id.avatar;
        ImageView imageView = (ImageView) C0756a.a(view, R.id.avatar);
        if (imageView != null) {
            i5 = R.id.btn_edit_name;
            ImageView imageView2 = (ImageView) C0756a.a(view, R.id.btn_edit_name);
            if (imageView2 != null) {
                i5 = R.id.btn_save;
                StepOSButton stepOSButton = (StepOSButton) C0756a.a(view, R.id.btn_save);
                if (stepOSButton != null) {
                    i5 = R.id.layout_birth;
                    LinearLayout linearLayout = (LinearLayout) C0756a.a(view, R.id.layout_birth);
                    if (linearLayout != null) {
                        i5 = R.id.layout_birth_type;
                        LinearLayout linearLayout2 = (LinearLayout) C0756a.a(view, R.id.layout_birth_type);
                        if (linearLayout2 != null) {
                            i5 = R.id.layout_birth_value;
                            LinearLayout linearLayout3 = (LinearLayout) C0756a.a(view, R.id.layout_birth_value);
                            if (linearLayout3 != null) {
                                i5 = R.id.name;
                                TextView textView = (TextView) C0756a.a(view, R.id.name);
                                if (textView != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    i5 = R.id.txt_birth_type;
                                    TextView textView2 = (TextView) C0756a.a(view, R.id.txt_birth_type);
                                    if (textView2 != null) {
                                        i5 = R.id.txt_birth_value;
                                        TextView textView3 = (TextView) C0756a.a(view, R.id.txt_birth_value);
                                        if (textView3 != null) {
                                            return new n(constraintLayout, imageView, imageView2, stepOSButton, linearLayout, linearLayout2, linearLayout3, textView, constraintLayout, textView2, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_edit_minor, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public ConstraintLayout b() {
        return this.f17735a;
    }
}
