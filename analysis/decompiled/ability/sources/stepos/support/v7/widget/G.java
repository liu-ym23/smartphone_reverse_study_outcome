package stepos.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;

/* loaded from: classes4.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public F f6461a;
    public View.OnClickListener b;
    public View.OnClickListener c;
    public U.f d;
    public U.f e;
    public boolean f;
    public CharSequence g;

    public final void a() {
        int i;
        Drawable drawable;
        String str;
        Drawable drawable2;
        if (this.f) {
            return;
        }
        this.f6461a.setTitle(this.g);
        U.f fVar = this.d;
        int i6 = -1;
        String str2 = null;
        if (fVar != null) {
            i = fVar.b;
            str = fVar.f1245a;
            drawable = (Drawable) fVar.c;
        } else {
            i = -1;
            drawable = null;
            str = null;
        }
        U.f fVar2 = this.e;
        if (fVar2 != null) {
            i6 = fVar2.b;
            str2 = fVar2.f1245a;
            drawable2 = (Drawable) fVar2.c;
        } else {
            drawable2 = null;
        }
        this.f6461a.f(0, str2, drawable2, this.c);
        this.f6461a.f(1, str, drawable, this.b);
        View positiveItemView = this.f6461a.getPositiveItemView();
        this.d.getClass();
        positiveItemView.setEnabled(true);
        positiveItemView.setId(i);
        this.d.getClass();
        U.f fVar3 = this.d;
        if (((Drawable) fVar3.c) == null && TextUtils.isEmpty(fVar3.f1245a)) {
            positiveItemView.setVisibility(8);
        } else {
            positiveItemView.setVisibility(0);
        }
        View negativeItemView = this.f6461a.getNegativeItemView();
        this.e.getClass();
        negativeItemView.setEnabled(true);
        negativeItemView.setId(i6);
        this.e.getClass();
        U.f fVar4 = this.e;
        if (((Drawable) fVar4.c) == null && TextUtils.isEmpty(fVar4.f1245a)) {
            negativeItemView.setVisibility(8);
        } else {
            negativeItemView.setVisibility(0);
        }
    }
}
