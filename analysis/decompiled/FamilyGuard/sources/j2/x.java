package j2;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17798a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f17799b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f17800c;

    private x(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.f17798a = constraintLayout;
        this.f17799b = textView;
        this.f17800c = textView2;
    }

    public static x a(View view) {
        int i5 = R.id.category_des;
        TextView textView = (TextView) C0756a.a(view, R.id.category_des);
        if (textView != null) {
            i5 = R.id.category_title;
            TextView textView2 = (TextView) C0756a.a(view, R.id.category_title);
            if (textView2 != null) {
                return new x((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }
}
