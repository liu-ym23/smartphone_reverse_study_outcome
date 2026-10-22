package j2;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.familyguard.R;
import i0.C0756a;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17781a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f17782b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f17783c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f17784d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f17785e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f17786f;

    private r(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.f17781a = linearLayout;
        this.f17782b = imageView;
        this.f17783c = imageView2;
        this.f17784d = textView;
        this.f17785e = textView2;
        this.f17786f = textView3;
    }

    public static r a(View view) {
        int i5 = R.id.img;
        ImageView imageView = (ImageView) C0756a.a(view, R.id.img);
        if (imageView != null) {
            i5 = R.id.img_avatar;
            ImageView imageView2 = (ImageView) C0756a.a(view, R.id.img_avatar);
            if (imageView2 != null) {
                i5 = R.id.text1;
                TextView textView = (TextView) C0756a.a(view, R.id.text1);
                if (textView != null) {
                    i5 = R.id.text2;
                    TextView textView2 = (TextView) C0756a.a(view, R.id.text2);
                    if (textView2 != null) {
                        i5 = R.id.text3;
                        TextView textView3 = (TextView) C0756a.a(view, R.id.text3);
                        if (textView3 != null) {
                            return new r((LinearLayout) view, imageView, imageView2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public LinearLayout b() {
        return this.f17781a;
    }
}
