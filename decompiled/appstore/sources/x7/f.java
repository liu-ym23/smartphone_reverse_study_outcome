package x7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f25554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CheckBox f25555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OTextView f25556c;

    public f(LinearLayout r10, CheckBox r11, OTextView r12) {
        this.f25554a = r10;
        this.f25555b = r11;
        this.f25556c = r12;
    }

    public static f a(View r10) {
        int r11 = R.id.check_record;
        CheckBox r12 = (CheckBox) i0.a.a(r10, R.id.check_record);
        if (r12 == null) goto L9;
        r11 = R.id.total_flow;
        OTextView r13 = (OTextView) i0.a.a(r10, R.id.total_flow);
        if (r13 == null) goto L9;
        return new f((LinearLayout) r10, r12, r13);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static f c(LayoutInflater r10) {
        return d(r10, null, false);
    }

    public static f d(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.dialog_mobile_tip, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public LinearLayout b() {
        return this.f25554a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
