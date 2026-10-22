package stepos.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

/* loaded from: classes2.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public A f14809a;

    /* renamed from: b, reason: collision with root package name */
    public View.OnClickListener f14810b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnClickListener f14811c;

    /* renamed from: d, reason: collision with root package name */
    public y.g f14812d;

    /* renamed from: e, reason: collision with root package name */
    public y.g f14813e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14814f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f14815g;

    public final void a() {
        int i4;
        Drawable drawable;
        String str;
        Drawable drawable2;
        if (this.f14814f) {
            return;
        }
        this.f14809a.setTitle(this.f14815g);
        y.g gVar = this.f14812d;
        int i5 = -1;
        String str2 = null;
        if (gVar != null) {
            i4 = gVar.f16025a;
            str = (String) gVar.f16027c;
            drawable = (Drawable) gVar.f16028d;
        } else {
            i4 = -1;
            drawable = null;
            str = null;
        }
        y.g gVar2 = this.f14813e;
        if (gVar2 != null) {
            i5 = gVar2.f16025a;
            str2 = (String) gVar2.f16027c;
            drawable2 = (Drawable) gVar2.f16028d;
        } else {
            drawable2 = null;
        }
        this.f14809a.q(0, str2, drawable2, this.f14811c);
        this.f14809a.q(1, str, drawable, this.f14810b);
        View positiveItemView = this.f14809a.getPositiveItemView();
        positiveItemView.setEnabled((this.f14812d.f16026b & 16) != 0);
        positiveItemView.setId(i4);
        y.g gVar3 = this.f14812d;
        if (!((gVar3.f16026b & 8) == 0) || (((Drawable) gVar3.f16028d) == null && TextUtils.isEmpty((String) gVar3.f16027c))) {
            positiveItemView.setVisibility(8);
        } else {
            positiveItemView.setVisibility(0);
        }
        View negativeItemView = this.f14809a.getNegativeItemView();
        negativeItemView.setEnabled((this.f14813e.f16026b & 16) != 0);
        negativeItemView.setId(i5);
        y.g gVar4 = this.f14813e;
        if ((gVar4.f16026b & 8) != 0 || (((Drawable) gVar4.f16028d) == null && TextUtils.isEmpty((String) gVar4.f16027c))) {
            negativeItemView.setVisibility(8);
        } else {
            negativeItemView.setVisibility(0);
        }
    }
}
