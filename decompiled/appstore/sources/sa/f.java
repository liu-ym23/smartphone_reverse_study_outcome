package sa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.appstore.R;
import com.obric.oui.layout.OUIConstraintLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f24578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OUIConstraintLayout f24579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OUIConstraintLayout f24580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f24581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f24582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f24583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OUIConstraintLayout f24584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f24585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f24586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f24587j;

    public f(ConstraintLayout r10, OUIConstraintLayout r11, OUIConstraintLayout r12, ImageView r13, ImageView r14, ImageView r15, OUIConstraintLayout r16, TextView r17, TextView r18, TextView r19) {
        this.f24578a = r10;
        this.f24579b = r11;
        this.f24580c = r12;
        this.f24581d = r13;
        this.f24582e = r14;
        this.f24583f = r15;
        this.f24584g = r16;
        this.f24585h = r17;
        this.f24586i = r18;
        this.f24587j = r19;
    }

    public static f a(View r13) {
        int r10 = R.id.entrance_app;
        OUIConstraintLayout r11 = (OUIConstraintLayout) i0.a.a(r13, r10);
        if (r11 == null) goto L23;
        r10 = R.id.entrance_game;
        OUIConstraintLayout r12 = (OUIConstraintLayout) i0.a.a(r13, r10);
        if (r12 == null) goto L23;
        r10 = R.id.entrance_ic_1;
        ImageView r14 = (ImageView) i0.a.a(r13, r10);
        if (r14 == null) goto L23;
        r10 = R.id.entrance_ic_2;
        ImageView r15 = (ImageView) i0.a.a(r13, r10);
        if (r15 == null) goto L23;
        r10 = R.id.entrance_ic_3;
        ImageView r16 = (ImageView) i0.a.a(r13, r10);
        if (r16 == null) goto L23;
        r10 = R.id.entrance_rank_list;
        OUIConstraintLayout r17 = (OUIConstraintLayout) i0.a.a(r13, r10);
        if (r17 == null) goto L23;
        r10 = R.id.entrance_txt_1;
        TextView r18 = (TextView) i0.a.a(r13, r10);
        if (r18 == null) goto L23;
        r10 = R.id.entrance_txt_2;
        TextView r19 = (TextView) i0.a.a(r13, r10);
        if (r19 == null) goto L23;
        r10 = R.id.entrance_txt_3;
        TextView r110 = (TextView) i0.a.a(r13, r10);
        if (r110 == null) goto L23;
        return new f((ConstraintLayout) r13, r11, r12, r14, r15, r16, r17, r18, r19, r110);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r10)));
    }

    public static f c(LayoutInflater r10, ViewGroup r11, boolean r12) {
        View r13 = r10.inflate(R.layout.item_fixed_entrance_view, r11, false);
        if (r12 == false) goto L6;
        r11.addView(r13);
    L6:
        return a(r13);
    }

    public ConstraintLayout b() {
        return this.f24578a;
    }

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
