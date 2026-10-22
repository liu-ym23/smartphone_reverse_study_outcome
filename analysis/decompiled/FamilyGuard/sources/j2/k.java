package j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17724a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f17725b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f17726c;

    private k(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.f17724a = constraintLayout;
        this.f17725b = imageView;
        this.f17726c = textView;
    }

    public static k a(View view) {
        int i5 = R.id.icon;
        ImageView imageView = (ImageView) C0756a.a(view, R.id.icon);
        if (imageView != null) {
            i5 = R.id.label;
            TextView textView = (TextView) C0756a.a(view, R.id.label);
            if (textView != null) {
                return new k((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public ConstraintLayout b() {
        return this.f17724a;
    }
}
