package stepos.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import stepos.support.v7.widget.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public h f12806a;

    /* renamed from: b, reason: collision with root package name */
    public View.OnClickListener f12807b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnClickListener f12808c;

    /* renamed from: d, reason: collision with root package name */
    public e0.d f12809d;

    /* renamed from: e, reason: collision with root package name */
    public e0.d f12810e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12811f;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f12812g;

    public final void a() {
        int i10;
        Drawable drawable;
        String str;
        Drawable drawable2;
        if (this.f12811f) {
            return;
        }
        this.f12806a.setTitle(this.f12812g);
        e0.d dVar = this.f12809d;
        int i11 = -1;
        String str2 = null;
        if (dVar != null) {
            i10 = dVar.f12785b;
            str = dVar.f12784a;
            drawable = dVar.f12786c;
        } else {
            i10 = -1;
            drawable = null;
            str = null;
        }
        e0.d dVar2 = this.f12810e;
        if (dVar2 != null) {
            i11 = dVar2.f12785b;
            str2 = dVar2.f12784a;
            drawable2 = dVar2.f12786c;
        } else {
            drawable2 = null;
        }
        this.f12806a.o(0, str2, drawable2, this.f12808c);
        this.f12806a.o(1, str, drawable, this.f12807b);
        View positiveItemView = this.f12806a.getPositiveItemView();
        this.f12809d.getClass();
        positiveItemView.setEnabled(true);
        positiveItemView.setId(i10);
        this.f12809d.getClass();
        e0.d dVar3 = this.f12809d;
        if (dVar3.f12786c == null && TextUtils.isEmpty(dVar3.f12784a)) {
            positiveItemView.setVisibility(8);
        } else {
            positiveItemView.setVisibility(0);
        }
        View negativeItemView = this.f12806a.getNegativeItemView();
        this.f12810e.getClass();
        negativeItemView.setEnabled(true);
        negativeItemView.setId(i11);
        this.f12810e.getClass();
        e0.d dVar4 = this.f12810e;
        if (dVar4.f12786c == null && TextUtils.isEmpty(dVar4.f12784a)) {
            negativeItemView.setVisibility(8);
        } else {
            negativeItemView.setVisibility(0);
        }
    }
}
