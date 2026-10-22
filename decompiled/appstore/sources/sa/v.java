package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.divider.ODivider;
import com.obric.oui.layout.OUIFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUIFrameLayout f24684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f24685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ODivider f24686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OUIFrameLayout f24687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f24688e;

    public v(OUIFrameLayout r10, RelativeLayout r11, ODivider r12, OUIFrameLayout r13, TextView r14) {
        this.f24684a = r10;
        this.f24685b = r11;
        this.f24686c = r12;
        this.f24687d = r13;
        this.f24688e = r14;
    }

    public static v a(View r10) {
        int r11 = R.id.search_suggest_container;
        RelativeLayout r12 = (RelativeLayout) i0.a.a(r10, r11);
        if (r12 == null) goto L11;
        r11 = R.id.search_suggest_divider;
        ODivider r13 = (ODivider) i0.a.a(r10, r11);
        if (r13 == null) goto L11;
        OUIFrameLayout r14 = (OUIFrameLayout) r10;
        r11 = R.id.search_suggest_text;
        TextView r15 = (TextView) i0.a.a(r10, r11);
        if (r15 == null) goto L11;
        return new v(r14, r12, r13, r14, r15);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public static v c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.search_suggest_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public OUIFrameLayout b() {
        return this.f24684a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
