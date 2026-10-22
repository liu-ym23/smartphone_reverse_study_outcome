package sa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f24673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObricAppItemView f24674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f24675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f24676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScrollView f24677e;

    public s(LinearLayout r10, ObricAppItemView r11, View r12, LinearLayout r13, ScrollView r14) {
        this.f24673a = r10;
        this.f24674b = r11;
        this.f24675c = r12;
        this.f24676d = r13;
        this.f24677e = r14;
    }

    public static s a(View r10) {
        int r11 = R.id.appinfo_item;
        ObricAppItemView r12 = (ObricAppItemView) i0.a.a(r10, r11);
        if (r12 == null) goto L13;
        r11 = R.id.margin_view;
        View r13 = i0.a.a(r10, r11);
        if (r13 == null) goto L13;
        r11 = R.id.perms_container;
        LinearLayout r14 = (LinearLayout) i0.a.a(r10, r11);
        if (r14 == null) goto L13;
        r11 = R.id.scrollview;
        ScrollView r15 = (ScrollView) i0.a.a(r10, r11);
        if (r15 == null) goto L13;
        return new s((LinearLayout) r10, r12, r13, r14, r15);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    public LinearLayout b() {
        return this.f24673a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
