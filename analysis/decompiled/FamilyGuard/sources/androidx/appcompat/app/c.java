package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import g.C0728a;

/* loaded from: classes.dex */
public class c extends l implements DialogInterface {

    /* renamed from: f, reason: collision with root package name */
    final AlertController f7518f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.b f7519a;

        /* renamed from: b, reason: collision with root package name */
        private final int f7520b;

        public a(Context context) {
            this(context, c.n(context, 0));
        }

        public c a() {
            c cVar = new c(this.f7519a.f7478a, this.f7520b);
            this.f7519a.a(cVar.f7518f);
            cVar.setCancelable(this.f7519a.f7495r);
            if (this.f7519a.f7495r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f7519a.f7496s);
            cVar.setOnDismissListener(this.f7519a.f7497t);
            DialogInterface.OnKeyListener onKeyListener = this.f7519a.f7498u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context b() {
            return this.f7519a.f7478a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7519a;
            bVar.f7500w = listAdapter;
            bVar.f7501x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f7519a.f7484g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f7519a.f7481d = drawable;
            return this;
        }

        public a f(CharSequence charSequence) {
            this.f7519a.f7485h = charSequence;
            return this;
        }

        public a g(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f7519a;
            bVar.f7499v = charSequenceArr;
            bVar.f7472J = onMultiChoiceClickListener;
            bVar.f7468F = zArr;
            bVar.f7469G = true;
            return this;
        }

        public a h(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7519a;
            bVar.f7489l = charSequence;
            bVar.f7491n = onClickListener;
            return this;
        }

        public a i(DialogInterface.OnKeyListener onKeyListener) {
            this.f7519a.f7498u = onKeyListener;
            return this;
        }

        public a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7519a;
            bVar.f7486i = charSequence;
            bVar.f7488k = onClickListener;
            return this;
        }

        public a k(ListAdapter listAdapter, int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7519a;
            bVar.f7500w = listAdapter;
            bVar.f7501x = onClickListener;
            bVar.f7471I = i5;
            bVar.f7470H = true;
            return this;
        }

        public a l(CharSequence[] charSequenceArr, int i5, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7519a;
            bVar.f7499v = charSequenceArr;
            bVar.f7501x = onClickListener;
            bVar.f7471I = i5;
            bVar.f7470H = true;
            return this;
        }

        public a m(CharSequence charSequence) {
            this.f7519a.f7483f = charSequence;
            return this;
        }

        public a n(View view) {
            AlertController.b bVar = this.f7519a;
            bVar.f7503z = view;
            bVar.f7502y = 0;
            bVar.f7467E = false;
            return this;
        }

        public a(Context context, int i5) {
            this.f7519a = new AlertController.b(new ContextThemeWrapper(context, c.n(context, i5)));
            this.f7520b = i5;
        }
    }

    protected c(Context context, int i5) {
        super(context, n(context, i5));
        this.f7518f = new AlertController(getContext(), this, getWindow());
    }

    static int n(Context context, int i5) {
        if (((i5 >>> 24) & 255) >= 1) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0728a.f16840q, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView m() {
        return this.f7518f.d();
    }

    @Override // androidx.appcompat.app.l, androidx.activity.k, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7518f.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (this.f7518f.f(i5, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i5, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i5, KeyEvent keyEvent) {
        if (this.f7518f.g(i5, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i5, keyEvent);
    }

    @Override // androidx.appcompat.app.l, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f7518f.p(charSequence);
    }
}
