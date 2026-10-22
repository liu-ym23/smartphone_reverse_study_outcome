package j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.RoundedImageView;
import i0.C0756a;

/* renamed from: j2.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0781D {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17639a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f17640b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundedImageView f17641c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17642d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f17643e;

    /* renamed from: f, reason: collision with root package name */
    public final View f17644f;

    private C0781D(ConstraintLayout constraintLayout, ImageView imageView, RoundedImageView roundedImageView, TextView textView, TextView textView2, View view) {
        this.f17639a = constraintLayout;
        this.f17640b = imageView;
        this.f17641c = roundedImageView;
        this.f17642d = textView;
        this.f17643e = textView2;
        this.f17644f = view;
    }

    public static C0781D a(View view) {
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
                            return new C0781D((ConstraintLayout) view, imageView, roundedImageView, textView, textView2, viewA);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }
}
