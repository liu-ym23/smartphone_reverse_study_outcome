package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import stepos.support.v7.widget.A;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private i f22072a;

    /* renamed from: b, reason: collision with root package name */
    private View.OnClickListener f22073b;

    /* renamed from: c, reason: collision with root package name */
    private View.OnClickListener f22074c;

    /* renamed from: d, reason: collision with root package name */
    private A.e f22075d;

    /* renamed from: e, reason: collision with root package name */
    private A.e f22076e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22077f = false;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f22078g;

    public void a(int i5, A.e eVar, View.OnClickListener onClickListener) {
        eVar.e(this);
        if (i5 == 1) {
            this.f22075d = eVar;
            this.f22073b = onClickListener;
        } else {
            this.f22076e = eVar;
            this.f22074c = onClickListener;
        }
    }

    public i b(Context context) {
        if (this.f22072a == null) {
            this.f22072a = new i(context);
        }
        return this.f22072a;
    }

    public void c() {
        int id;
        String title;
        Drawable icon;
        Drawable icon2;
        if (this.f22077f) {
            return;
        }
        this.f22072a.setTitle(this.f22078g);
        A.e eVar = this.f22075d;
        int id2 = -1;
        String title2 = null;
        if (eVar != null) {
            id = eVar.getId();
            title = this.f22075d.getTitle();
            icon = this.f22075d.getIcon();
        } else {
            id = -1;
            title = null;
            icon = null;
        }
        A.e eVar2 = this.f22076e;
        if (eVar2 != null) {
            id2 = eVar2.getId();
            title2 = this.f22076e.getTitle();
            icon2 = this.f22076e.getIcon();
        } else {
            icon2 = null;
        }
        this.f22072a.I(0, title2, icon2, this.f22074c);
        this.f22072a.I(1, title, icon, this.f22073b);
        View positiveItemView = this.f22072a.getPositiveItemView();
        positiveItemView.setEnabled(this.f22075d.c());
        positiveItemView.setId(id);
        if (!this.f22075d.d() || (this.f22075d.getIcon() == null && TextUtils.isEmpty(this.f22075d.getTitle()))) {
            positiveItemView.setVisibility(8);
        } else {
            positiveItemView.setVisibility(0);
        }
        View negativeItemView = this.f22072a.getNegativeItemView();
        negativeItemView.setEnabled(this.f22076e.c());
        negativeItemView.setId(id2);
        if (!this.f22076e.d() || (this.f22076e.getIcon() == null && TextUtils.isEmpty(this.f22076e.getTitle()))) {
            negativeItemView.setVisibility(8);
        } else {
            negativeItemView.setVisibility(0);
        }
    }

    public void d(CharSequence charSequence) {
        this.f22078g = charSequence;
        i iVar = this.f22072a;
        if (iVar != null) {
            iVar.setTitle(charSequence);
        }
    }

    public void e() {
        this.f22077f = false;
        c();
    }

    public void f() {
        if (this.f22077f) {
            return;
        }
        this.f22077f = true;
    }
}
