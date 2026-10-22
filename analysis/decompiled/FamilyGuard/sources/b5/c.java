package b5;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
import stepos.support.v7.app.r;

/* loaded from: classes.dex */
public class c extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private final d f11838a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f11839a;

        /* renamed from: b, reason: collision with root package name */
        boolean f11840b;

        /* renamed from: c, reason: collision with root package name */
        String[] f11841c;

        /* renamed from: d, reason: collision with root package name */
        String[] f11842d;

        /* renamed from: e, reason: collision with root package name */
        String f11843e;

        /* renamed from: f, reason: collision with root package name */
        String f11844f;

        /* renamed from: g, reason: collision with root package name */
        boolean f11845g;

        /* renamed from: h, reason: collision with root package name */
        boolean f11846h = true;

        /* renamed from: i, reason: collision with root package name */
        boolean f11847i;

        /* renamed from: j, reason: collision with root package name */
        List<Pair<String, String>> f11848j;

        /* renamed from: k, reason: collision with root package name */
        CharSequence f11849k;

        public void a(c cVar) {
            cVar.setPermissionDialogBuild(this);
        }

        public a b(boolean z5) {
            this.f11847i = z5;
            return this;
        }

        public a c(List<Pair<String, String>> list) {
            this.f11848j = list;
            return this;
        }

        public a d(String str) {
            this.f11839a = str;
            return this;
        }

        public a e(CharSequence charSequence) {
            this.f11849k = charSequence;
            return this;
        }

        public a f(boolean z5) {
            this.f11845g = z5;
            return this;
        }

        public a g(String str) {
            this.f11843e = str;
            return this;
        }

        public a h(String[] strArr, String[] strArr2) {
            this.f11841c = strArr;
            this.f11842d = strArr2;
            return this;
        }

        public a i(String str) {
            this.f11844f = str;
            return this;
        }

        public a j(boolean z5) {
            this.f11840b = z5;
            return this;
        }

        public a k(boolean z5) {
            this.f11846h = z5;
            return this;
        }
    }

    public c(Context context) {
        this(context, null);
    }

    public CheckBox getCheckBox() {
        return this.f11838a.getCheckBox();
    }

    public Map<String, Boolean> getItemCheckedMap() {
        d dVar = this.f11838a;
        if (dVar instanceof g) {
            return ((g) dVar).j();
        }
        return null;
    }

    public List<Z4.d> getPermissions() {
        return this.f11838a.getPermissions();
    }

    public TextView getTermsView() {
        return this.f11838a.getTermsView();
    }

    public void setPermissionDialogBuild(a aVar) {
        this.f11838a.a(aVar);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        if (r.f21050z) {
            this.f11838a = new h(context);
        } else {
            this.f11838a = new g(context);
        }
        addView(this.f11838a.createView(this));
    }
}
