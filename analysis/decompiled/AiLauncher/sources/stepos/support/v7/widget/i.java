package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import stepos.support.v7.widget.w;

/* loaded from: classes5.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public h f41641a;

    /* renamed from: b, reason: collision with root package name */
    public View.OnClickListener f41642b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnClickListener f41643c;

    /* renamed from: d, reason: collision with root package name */
    public w.e f41644d;

    /* renamed from: e, reason: collision with root package name */
    public w.e f41645e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f41646f = false;

    /* renamed from: g, reason: collision with root package name */
    public CharSequence f41647g;

    public void a(int i10, w.e eVar, View.OnClickListener onClickListener) {
        eVar.d(this);
        if (i10 == 1) {
            this.f41644d = eVar;
            this.f41642b = onClickListener;
        } else {
            this.f41645e = eVar;
            this.f41643c = onClickListener;
        }
    }

    public h b(Context context) {
        if (this.f41641a == null) {
            this.f41641a = new h(context);
        }
        return this.f41641a;
    }

    public void c() {
        int id;
        String title;
        Drawable icon;
        Drawable icon2;
        if (this.f41646f) {
            return;
        }
        this.f41641a.setTitle(this.f41647g);
        w.e eVar = this.f41644d;
        int id2 = -1;
        String title2 = null;
        if (eVar != null) {
            id = eVar.getId();
            title = this.f41644d.getTitle();
            icon = this.f41644d.getIcon();
        } else {
            id = -1;
            title = null;
            icon = null;
        }
        w.e eVar2 = this.f41645e;
        if (eVar2 != null) {
            id2 = eVar2.getId();
            title2 = this.f41645e.getTitle();
            icon2 = this.f41645e.getIcon();
        } else {
            icon2 = null;
        }
        this.f41641a.n(0, title2, icon2, this.f41643c);
        this.f41641a.n(1, title, icon, this.f41642b);
        View positiveItemView = this.f41641a.getPositiveItemView();
        positiveItemView.setEnabled(this.f41644d.b());
        positiveItemView.setId(id);
        if (!this.f41644d.c() || (this.f41644d.getIcon() == null && TextUtils.isEmpty(this.f41644d.getTitle()))) {
            positiveItemView.setVisibility(8);
        } else {
            positiveItemView.setVisibility(0);
        }
        View negativeItemView = this.f41641a.getNegativeItemView();
        negativeItemView.setEnabled(this.f41645e.b());
        negativeItemView.setId(id2);
        if (!this.f41645e.c() || (this.f41645e.getIcon() == null && TextUtils.isEmpty(this.f41645e.getTitle()))) {
            negativeItemView.setVisibility(8);
        } else {
            negativeItemView.setVisibility(0);
        }
    }

    public void d(CharSequence charSequence) {
        this.f41647g = charSequence;
        h hVar = this.f41641a;
        if (hVar != null) {
            hVar.setTitle(charSequence);
        }
    }

    public void e() {
        this.f41646f = false;
        c();
    }

    public void f() {
        if (this.f41646f) {
            return;
        }
        this.f41646f = true;
    }
}
