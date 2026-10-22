package j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.RoundedImageView;
import i0.C0756a;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17801a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f17802b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundedImageView f17803c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17804d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f17805e;

    /* renamed from: f, reason: collision with root package name */
    public final View f17806f;

    private y(ConstraintLayout constraintLayout, ImageView imageView, RoundedImageView roundedImageView, TextView textView, TextView textView2, View view) {
        this.f17801a = constraintLayout;
        this.f17802b = imageView;
        this.f17803c = roundedImageView;
        this.f17804d = textView;
        this.f17805e = textView2;
        this.f17806f = view;
    }

    public static y a(View view) {
        int i5 = R.id.arrow;
        ImageView imageView = (ImageView) C0756a.a(view, R.id.arrow);
        if (imageView != null) {
            i5 = R.id.icon;
            RoundedImageView roundedImageView = (RoundedImageView) C0756a.a(view, R.id.icon);
            if (roundedImageView != null) {
                i5 = R.id.limit;
                TextView textView = (TextView) C0756a.a(view, R.id.limit);
                if (textView != null) {
                    i5 = R.id.name;
                    TextView textView2 = (TextView) C0756a.a(view, R.id.name);
                    if (textView2 != null) {
                        i5 = R.id.row_divider;
                        View viewA = C0756a.a(view, R.id.row_divider);
                        if (viewA != null) {
                            return new y((ConstraintLayout) view, imageView, roundedImageView, textView, textView2, viewA);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }
}
