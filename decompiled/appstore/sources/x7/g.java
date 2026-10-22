package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f25566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RatingBar f25567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f25568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f25569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f25570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f25571g;

    public g(LinearLayout r10, EditText r11, RatingBar r12, TextView r13, TextView r14, TextView r15, TextView r16) {
        this.f25565a = r10;
        this.f25566b = r11;
        this.f25567c = r12;
        this.f25568d = r13;
        this.f25569e = r14;
        this.f25570f = r15;
        this.f25571g = r16;
    }

    public static g a(View r10) {
        int r11 = R.id.et_dialog_comment;
        EditText r12 = (EditText) i0.a.a(r10, R.id.et_dialog_comment);
        if (r12 == null) goto L17;
        r11 = R.id.rb_dialog_rate;
        RatingBar r13 = (RatingBar) i0.a.a(r10, R.id.rb_dialog_rate);
        if (r13 == null) goto L17;
        r11 = R.id.tv_dialog_cancel;
        TextView r14 = (TextView) i0.a.a(r10, R.id.tv_dialog_cancel);
        if (r14 == null) goto L17;
        r11 = R.id.tv_dialog_confirm;
        TextView r15 = (TextView) i0.a.a(r10, R.id.tv_dialog_confirm);
        if (r15 == null) goto L17;
        r11 = R.id.tv_dialog_tip;
        TextView r16 = (TextView) i0.a.a(r10, R.id.tv_dialog_tip);
        if (r16 == null) goto L17;
        r11 = R.id.tv_dialog_title;
        TextView r17 = (TextView) i0.a.a(r10, R.id.tv_dialog_title);
        if (r17 == null) goto L17;
        return new g((LinearLayout) r10, r12, r13, r14, r15, r16, r17);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static g c(LayoutInflater r10) {
        return d(r10, null, false);
    }

    public static g d(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.dialog_tv_add_comment_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25565a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
