package sa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f24663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OInputView f24664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f24665d;

    public q(LinearLayout r10, TextView r11, OInputView r12, TextView r13) {
        this.f24662a = r10;
        this.f24663b = r11;
        this.f24664c = r12;
        this.f24665d = r13;
    }

    public static q a(View r10) {
        int r11 = R.id.commit_txt;
        TextView r12 = (TextView) i0.a.a(r10, r11);
        if (r12 == null) goto L11;
        r11 = R.id.input_view;
        OInputView r13 = (OInputView) i0.a.a(r10, r11);
        if (r13 == null) goto L11;
        r11 = R.id.version_txt;
        TextView r14 = (TextView) i0.a.a(r10, r11);
        if (r14 == null) goto L11;
        return new q((LinearLayout) r10, r12, r13, r14);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LinearLayout b() {
        return this.f24662a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
