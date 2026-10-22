package j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f17660a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f17661b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f17662c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17663d;

    private G(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2) {
        this.f17660a = constraintLayout;
        this.f17661b = textView;
        this.f17662c = imageView;
        this.f17663d = textView2;
    }

    public static G a(View view) {
        int i5 = R.id.des;
        TextView textView = (TextView) C0756a.a(view, R.id.des);
        if (textView != null) {
            i5 = R.id.icon;
            ImageView imageView = (ImageView) C0756a.a(view, R.id.icon);
            if (imageView != null) {
                i5 = R.id.title;
                TextView textView2 = (TextView) C0756a.a(view, R.id.title);
                if (textView2 != null) {
                    return new G((ConstraintLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }
}
