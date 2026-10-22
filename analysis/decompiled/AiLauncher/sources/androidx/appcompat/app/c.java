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
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class c extends k implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    public final AlertController f8417a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final AlertController.b f8418a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8419b;

        public a(Context context) {
            this(context, c.j(context, 0));
        }

        public c a() {
            c cVar = new c(this.f8418a.f8277a, this.f8419b);
            this.f8418a.a(cVar.f8417a);
            cVar.setCancelable(this.f8418a.f8294r);
            if (this.f8418a.f8294r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f8418a.f8295s);
            cVar.setOnDismissListener(this.f8418a.f8296t);
            DialogInterface.OnKeyListener onKeyListener = this.f8418a.f8297u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context b() {
            return this.f8418a.f8277a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f8418a;
            bVar.f8299w = listAdapter;
            bVar.f8300x = onClickListener;
            return this;
        }

        public a d(View view) {
            this.f8418a.f8283g = view;
            return this;
        }

        public a e(Drawable drawable) {
            this.f8418a.f8280d = drawable;
            return this;
        }

        public a f(int i10) {
            AlertController.b bVar = this.f8418a;
            bVar.f8284h = bVar.f8277a.getText(i10);
            return this;
        }

        public a g(CharSequence charSequence) {
            this.f8418a.f8284h = charSequence;
            return this;
        }

        public a h(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f8418a;
            bVar.f8298v = charSequenceArr;
            bVar.f8271J = onMultiChoiceClickListener;
            bVar.f8267F = zArr;
            bVar.f8268G = true;
            return this;
        }

        public a i(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f8418a;
            bVar.f8288l = bVar.f8277a.getText(i10);
            this.f8418a.f8290n = onClickListener;
            return this;
        }

        public a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f8418a;
            bVar.f8288l = charSequence;
            bVar.f8290n = onClickListener;
            return this;
        }

        public a k(DialogInterface.OnKeyListener onKeyListener) {
            this.f8418a.f8297u = onKeyListener;
            return this;
        }

        public a l(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f8418a;
            bVar.f8285i = bVar.f8277a.getText(i10);
            this.f8418a.f8287k = onClickListener;
            return this;
        }

        public a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f8418a;
            bVar.f8285i = charSequence;
            bVar.f8287k = onClickListener;
            return this;
        }

        public a n(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f8418a;
            bVar.f8299w = listAdapter;
            bVar.f8300x = onClickListener;
            bVar.f8270I = i10;
            bVar.f8269H = true;
            return this;
        }

        public a o(CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f8418a;
            bVar.f8298v = charSequenceArr;
            bVar.f8300x = onClickListener;
            bVar.f8270I = i10;
            bVar.f8269H = true;
            return this;
        }

        public a p(int i10) {
            AlertController.b bVar = this.f8418a;
            bVar.f8282f = bVar.f8277a.getText(i10);
            return this;
        }

        public a q(CharSequence charSequence) {
            this.f8418a.f8282f = charSequence;
            return this;
        }

        public a r(View view) {
            AlertController.b bVar = this.f8418a;
            bVar.f8302z = view;
            bVar.f8301y = 0;
            bVar.f8266E = false;
            return this;
        }

        public c s() {
            c cVarA = a();
            cVarA.show();
            return cVarA;
        }

        public a(Context context, int i10) {
            this.f8418a = new AlertController.b(new ContextThemeWrapper(context, c.j(context, i10)));
            this.f8419b = i10;
        }
    }

    public c(Context context, int i10) {
        super(context, j(context, i10));
        this.f8417a = new AlertController(getContext(), this, getWindow());
    }

    public static int j(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView i() {
        return this.f8417a.d();
    }

    @Override // androidx.appcompat.app.k, b.v, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8417a.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f8417a.f(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f8417a.g(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // androidx.appcompat.app.k, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f8417a.p(charSequence);
    }
}
