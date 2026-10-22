package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f25562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f25563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25564d;

    public f1(LinearLayout r10, ImageView r11, TextView r12, TextView r13) {
        this.f25561a = r10;
        this.f25562b = r11;
        this.f25563c = r12;
        this.f25564d = r13;
    }

    public static f1 a(View r10) {
        int r11 = R.id.iv_gift_pic;
        ImageView r12 = (ImageView) i0.a.a(r10, R.id.iv_gift_pic);
        if (r12 == null) goto L11;
        r11 = R.id.tv_gift_name;
        TextView r13 = (TextView) i0.a.a(r10, R.id.tv_gift_name);
        if (r13 == null) goto L11;
        r11 = R.id.tv_gift_num;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_gift_num);
        if (r14 == null) goto L11;
        return new f1((LinearLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static f1 c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.tv_item_view_sub_gift, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25561a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
