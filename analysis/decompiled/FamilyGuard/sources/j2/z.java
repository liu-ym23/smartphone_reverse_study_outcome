package j2;

import android.view.View;
import android.widget.TextView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.TimeDisplayView;
import i0.C0756a;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private final TimeDisplayView f17807a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f17808b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f17809c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17810d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f17811e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f17812f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f17813g;

    private z(TimeDisplayView timeDisplayView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.f17807a = timeDisplayView;
        this.f17808b = textView;
        this.f17809c = textView2;
        this.f17810d = textView3;
        this.f17811e = textView4;
        this.f17812f = textView5;
        this.f17813g = textView6;
    }

    public static z a(View view) {
        int i5 = R.id.digit_1;
        TextView textView = (TextView) C0756a.a(view, R.id.digit_1);
        if (textView != null) {
            i5 = R.id.digit_1_label;
            TextView textView2 = (TextView) C0756a.a(view, R.id.digit_1_label);
            if (textView2 != null) {
                i5 = R.id.digit_2;
                TextView textView3 = (TextView) C0756a.a(view, R.id.digit_2);
                if (textView3 != null) {
                    i5 = R.id.digit_2_label;
                    TextView textView4 = (TextView) C0756a.a(view, R.id.digit_2_label);
                    if (textView4 != null) {
                        i5 = R.id.digit_3;
                        TextView textView5 = (TextView) C0756a.a(view, R.id.digit_3);
                        if (textView5 != null) {
                            i5 = R.id.digit_3_label;
                            TextView textView6 = (TextView) C0756a.a(view, R.id.digit_3_label);
                            if (textView6 != null) {
                                return new z((TimeDisplayView) view, textView, textView2, textView3, textView4, textView5, textView6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public TimeDisplayView b() {
        return this.f17807a;
    }
}
