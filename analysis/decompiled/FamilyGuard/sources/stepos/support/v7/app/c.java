package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.method.MovementMethod;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import g.C0728a;
import stepos.support.v7.app.b;

/* loaded from: classes.dex */
public class c extends l implements DialogInterface {
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_NORMAL = 0;
    public static final int COLOR_POLESTAR = 3;
    public static final int COLOR_RED = 2;
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    public static final int STEP_OS_DIALOG_CONTROLLER = 1;
    public static final int SUPPORT_DIALOG_CONTROLLER = 0;
    final b mAlert;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final b.C0241b f20757a;

        /* renamed from: b, reason: collision with root package name */
        private final int f20758b;

        /* renamed from: stepos.support.v7.app.c$a$a, reason: collision with other inner class name */
        class C0243a implements b<c> {
            C0243a() {
            }

            @Override // stepos.support.v7.app.c.a.b
            public c newDialog(Context context, int i5) {
                return new c(a.this.f20757a.f20718a, a.this.f20758b);
            }
        }

        public interface b<T extends c> {
            T newDialog(Context context, int i5);
        }

        public a(Context context) {
            this(context, c.resolveDialogTheme(context, 0));
        }

        public c A() {
            c cVarC = c();
            cVarC.show();
            return cVarC;
        }

        public c c() {
            return d(new C0243a());
        }

        public <T extends c> T d(b<T> bVar) throws Resources.NotFoundException {
            T t5 = (T) bVar.newDialog(this.f20757a.f20718a, this.f20758b);
            this.f20757a.a(t5.mAlert);
            t5.setCancelable(this.f20757a.f20735r);
            if (this.f20757a.f20735r) {
                t5.setCanceledOnTouchOutside(true);
            }
            t5.setOnCancelListener(this.f20757a.f20736s);
            t5.setOnDismissListener(this.f20757a.f20737t);
            DialogInterface.OnKeyListener onKeyListener = this.f20757a.f20738u;
            if (onKeyListener != null) {
                t5.setOnKeyListener(onKeyListener);
            }
            return t5;
        }

        public Context e() {
            return this.f20757a.f20718a;
        }

        public a f(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20740w = listAdapter;
            c0241b.f20741x = onClickListener;
            return this;
        }

        public a g(boolean z5) {
            this.f20757a.f20735r = z5;
            return this;
        }

        public a h(View view) {
            this.f20757a.f20724g = view;
            return this;
        }

        public a i(int i5, int i6) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20714U = i5;
            c0241b.f20715V = i6;
            return this;
        }

        public a j(Drawable drawable) {
            this.f20757a.f20721d = drawable;
            return this;
        }

        public a k(int i5) {
            TypedValue typedValue = new TypedValue();
            this.f20757a.f20718a.getTheme().resolveAttribute(i5, typedValue, true);
            this.f20757a.f20720c = typedValue.resourceId;
            return this;
        }

        public a l(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener, boolean z5, ColorStateList[] colorStateListArr) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20739v = charSequenceArr;
            c0241b.f20741x = onClickListener;
            c0241b.f20709P = z5;
            c0241b.f20710Q = colorStateListArr;
            return this;
        }

        public a m(int i5) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20725h = c0241b.f20718a.getText(i5);
            return this;
        }

        public a n(CharSequence charSequence) {
            this.f20757a.f20725h = charSequence;
            return this;
        }

        public a o(int i5, DialogInterface.OnClickListener onClickListener) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20729l = c0241b.f20718a.getText(i5);
            this.f20757a.f20731n = onClickListener;
            return this;
        }

        public a p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20729l = charSequence;
            c0241b.f20731n = onClickListener;
            return this;
        }

        public a q(int i5, DialogInterface.OnClickListener onClickListener) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20732o = c0241b.f20718a.getText(i5);
            this.f20757a.f20734q = onClickListener;
            return this;
        }

        public a r(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20732o = charSequence;
            c0241b.f20734q = onClickListener;
            return this;
        }

        public a s(DialogInterface.OnCancelListener onCancelListener) {
            this.f20757a.f20736s = onCancelListener;
            return this;
        }

        public a t(DialogInterface.OnKeyListener onKeyListener) {
            this.f20757a.f20738u = onKeyListener;
            return this;
        }

        public a u(int i5, DialogInterface.OnClickListener onClickListener) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20726i = c0241b.f20718a.getText(i5);
            this.f20757a.f20728k = onClickListener;
            return this;
        }

        public a v(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20726i = charSequence;
            c0241b.f20728k = onClickListener;
            return this;
        }

        public a w(CharSequence[] charSequenceArr, int i5, DialogInterface.OnClickListener onClickListener) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20739v = charSequenceArr;
            c0241b.f20741x = onClickListener;
            c0241b.f20702I = i5;
            c0241b.f20701H = true;
            return this;
        }

        public a x(int i5) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20723f = c0241b.f20718a.getText(i5);
            return this;
        }

        public a y(CharSequence charSequence) {
            this.f20757a.f20723f = charSequence;
            return this;
        }

        public a z(View view) {
            b.C0241b c0241b = this.f20757a;
            c0241b.f20743z = view;
            c0241b.f20742y = 0;
            c0241b.f20698E = false;
            return this;
        }

        public a(Context context, int i5) {
            this.f20757a = new b.C0241b(new ContextThemeWrapper(context, c.resolveDialogTheme(context, i5)));
            this.f20758b = i5;
        }
    }

    protected c(Context context) {
        this(context, 0);
    }

    public static final b create(Context context, l lVar, Window window) {
        return new StepOSAlertController(context, lVar, window);
    }

    static int resolveDialogTheme(Context context, int i5) {
        if (((i5 >>> 24) & 255) >= 1) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0728a.f16840q, typedValue, true);
        return typedValue.resourceId;
    }

    public b getAlertController() {
        return this.mAlert;
    }

    public Button getButton(int i5) {
        return this.mAlert.a(i5);
    }

    public ListView getListView() {
        return this.mAlert.c();
    }

    @Override // stepos.support.v7.app.l, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.d();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (this.mAlert.e(i5, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i5, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i5, KeyEvent keyEvent) {
        if (this.mAlert.f(i5, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i5, keyEvent);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        b alertController = getAlertController();
        if (alertController instanceof StepOSAlertController) {
            ((StepOSAlertController) alertController).h0();
        }
    }

    public void setAutoShowSoftInput(boolean z5) {
        this.mAlert.g(z5);
    }

    public void setButton(int i5, CharSequence charSequence, Message message) {
        this.mAlert.h(i5, charSequence, null, message, null);
    }

    void setButtonPanelLayoutHint(int i5) {
        this.mAlert.i(i5);
    }

    public void setButtonTextColor(int i5, int i6) {
        this.mAlert.j(i5, i6);
    }

    public void setCustomPaddingRule(int i5, int i6, int i7, int i8) {
        this.mAlert.k(i5, i6, i7, i8);
    }

    public void setCustomTitle(View view) {
        this.mAlert.l(view);
    }

    public void setHighLightButton(int i5, int i6) {
        this.mAlert.m(i5, i6);
    }

    public void setIcon(int i5) {
        this.mAlert.n(i5);
    }

    public void setIconAttribute(int i5) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i5, typedValue, true);
        this.mAlert.n(typedValue.resourceId);
    }

    public void setMaxHeight(int i5) {
        this.mAlert.p(i5);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.q(charSequence);
    }

    public void setMessageMovementMethod(MovementMethod movementMethod) {
        this.mAlert.r(movementMethod);
    }

    @Override // stepos.support.v7.app.l, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.s(charSequence);
    }

    public void setView(View view) {
        this.mAlert.u(view);
    }

    protected c(Context context, int i5) {
        super(context, resolveDialogTheme(context, i5));
        this.mAlert = create(getContext(), this, getWindow());
    }

    public void setButton(int i5, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.h(i5, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.o(drawable);
    }

    public void setView(View view, int i5, int i6, int i7, int i8) {
        this.mAlert.v(view, i5, i6, i7, i8);
    }

    public void setButton(int i5, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.h(i5, charSequence, onClickListener, null, drawable);
    }

    protected c(Context context, boolean z5, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z5);
        setOnCancelListener(onCancelListener);
    }
}
