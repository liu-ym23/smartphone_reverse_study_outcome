package j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.ProgressBar;
import com.stepos.familyguard.ui.widget.RoundedImageView;
import i0.C0756a;

/* renamed from: j2.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0782E {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17645a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f17646b;

    /* renamed from: c, reason: collision with root package name */
    public final RoundedImageView f17647c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17648d;

    /* renamed from: e, reason: collision with root package name */
    public final ProgressBar f17649e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f17650f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f17651g;

    private C0782E(ConstraintLayout constraintLayout, ImageView imageView, RoundedImageView roundedImageView, TextView textView, ProgressBar progressBar, TextView textView2, TextView textView3) {
        this.f17645a = constraintLayout;
        this.f17646b = imageView;
        this.f17647c = roundedImageView;
        this.f17648d = textView;
        this.f17649e = progressBar;
        this.f17650f = textView2;
        this.f17651g = textView3;
    }

    public static C0782E a(View view) {
        int i5 = R.id.arrow;
        ImageView imageView = (ImageView) C0756a.a(view, R.id.arrow);
        if (imageView != null) {
            i5 = R.id.icon;
            RoundedImageView roundedImageView = (RoundedImageView) C0756a.a(view, R.id.icon);
            if (roundedImageView != null) {
                i5 = R.id.limit;
                TextView textView = (TextView) C0756a.a(view, R.id.limit);
                if (textView != null) {
                    i5 = R.id.progress;
                    ProgressBar progressBar = (ProgressBar) C0756a.a(view, R.id.progress);
                    if (progressBar != null) {
                        i5 = R.id.time;
                        TextView textView2 = (TextView) C0756a.a(view, R.id.time);
                        if (textView2 != null) {
                            i5 = R.id.title;
                            TextView textView3 = (TextView) C0756a.a(view, R.id.title);
                            if (textView3 != null) {
                                return new C0782E((ConstraintLayout) view, imageView, roundedImageView, textView, progressBar, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public ConstraintLayout b() {
        return this.f17645a;
    }
}
