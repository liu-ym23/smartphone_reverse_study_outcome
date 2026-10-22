package j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17787a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f17788b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f17789c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f17790d;

    private s(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ImageView imageView2) {
        this.f17787a = constraintLayout;
        this.f17788b = textView;
        this.f17789c = imageView;
        this.f17790d = imageView2;
    }

    public static s a(View view) {
        int i5 = R.id.app_name;
        TextView textView = (TextView) C0756a.a(view, R.id.app_name);
        if (textView != null) {
            i5 = R.id.btn;
            ImageView imageView = (ImageView) C0756a.a(view, R.id.btn);
            if (imageView != null) {
                i5 = R.id.icon;
                ImageView imageView2 = (ImageView) C0756a.a(view, R.id.icon);
                if (imageView2 != null) {
                    return new s((ConstraintLayout) view, textView, imageView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }
}
