package Ic;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
import stepos.support.v7.app.q;

/* loaded from: classes5.dex */
public class c extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final d f3435a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f3436a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3437b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f3438c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f3439d;

        /* renamed from: e, reason: collision with root package name */
        public String f3440e;

        /* renamed from: f, reason: collision with root package name */
        public String f3441f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f3442g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f3443h = true;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3444i;

        /* renamed from: j, reason: collision with root package name */
        public List<Pair<String, String>> f3445j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f3446k;

        public void a(c cVar) {
            cVar.setPermissionDialogBuild(this);
        }

        public a b(boolean z10) {
            this.f3444i = z10;
            return this;
        }

        public a c(List<Pair<String, String>> list) {
            this.f3445j = list;
            return this;
        }

        public a d(String str) {
            this.f3436a = str;
            return this;
        }

        public a e(CharSequence charSequence) {
            this.f3446k = charSequence;
            return this;
        }

        public a f(boolean z10) {
            this.f3442g = z10;
            return this;
        }

        public a g(String str) {
            this.f3440e = str;
            return this;
        }

        public a h(String[] strArr, String[] strArr2) {
            this.f3438c = strArr;
            this.f3439d = strArr2;
            return this;
        }

        public a i(String str) {
            this.f3441f = str;
            return this;
        }

        public a j(boolean z10) {
            this.f3437b = z10;
            return this;
        }

        public a k(boolean z10) {
            this.f3443h = z10;
            return this;
        }
    }

    public c(Context context) {
        this(context, null);
    }

    public CheckBox getCheckBox() {
        return this.f3435a.getCheckBox();
    }

    public Map<String, Boolean> getItemCheckedMap() {
        d dVar = this.f3435a;
        if (dVar instanceof g) {
            return ((g) dVar).j();
        }
        return null;
    }

    public List<stepos.support.v7.permission.d> getPermissions() {
        return this.f3435a.getPermissions();
    }

    public TextView getTermsView() {
        return this.f3435a.getTermsView();
    }

    public void setPermissionDialogBuild(a aVar) {
        this.f3435a.a(aVar);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        if (q.f40710z) {
            this.f3435a = new h(context);
        } else {
            this.f3435a = new g(context);
        }
        addView(this.f3435a.createView(this));
    }
}
