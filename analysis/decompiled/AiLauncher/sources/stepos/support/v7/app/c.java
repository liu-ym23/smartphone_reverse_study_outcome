package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.R$attr;
import stepos.support.v7.app.b;

/* loaded from: classes5.dex */
public class c extends k implements DialogInterface {
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
        public final b.C0523b f40493a;

        /* renamed from: b, reason: collision with root package name */
        public final int f40494b;

        /* renamed from: stepos.support.v7.app.c$a$a, reason: collision with other inner class name */
        public class C0525a implements b<c> {
            public C0525a() {
            }

            @Override // stepos.support.v7.app.c.a.b
            public c newDialog(Context context, int i10) {
                return new c(a.this.f40493a.f40454a, a.this.f40494b);
            }
        }

        public interface b<T extends c> {
            T newDialog(Context context, int i10);
        }

        public a(Context context) {
            this(context, c.resolveDialogTheme(context, 0));
        }

        public c c() {
            return d(new C0525a());
        }

        public <T extends c> T d(b<T> bVar) throws Resources.NotFoundException {
            T t10 = (T) bVar.newDialog(this.f40493a.f40454a, this.f40494b);
            this.f40493a.a(t10.mAlert);
            t10.setCancelable(this.f40493a.f40471r);
            if (this.f40493a.f40471r) {
                t10.setCanceledOnTouchOutside(true);
            }
            t10.setOnCancelListener(this.f40493a.f40472s);
            t10.setOnDismissListener(this.f40493a.f40473t);
            DialogInterface.OnKeyListener onKeyListener = this.f40493a.f40474u;
            if (onKeyListener != null) {
                t10.setOnKeyListener(onKeyListener);
            }
            return t10;
        }

        public Context e() {
            return this.f40493a.f40454a;
        }

        public a f(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40476w = listAdapter;
            c0523b.f40477x = onClickListener;
            return this;
        }

        public a g(boolean z10) {
            this.f40493a.f40471r = z10;
            return this;
        }

        public a h(View view) {
            this.f40493a.f40460g = view;
            return this;
        }

        public a i(int i10, int i11) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40450U = i10;
            c0523b.f40451V = i11;
            return this;
        }

        public a j(Drawable drawable) {
            this.f40493a.f40457d = drawable;
            return this;
        }

        public a k(int i10) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40461h = c0523b.f40454a.getText(i10);
            return this;
        }

        public a l(CharSequence charSequence) {
            this.f40493a.f40461h = charSequence;
            return this;
        }

        public a m(int i10, DialogInterface.OnClickListener onClickListener) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40465l = c0523b.f40454a.getText(i10);
            this.f40493a.f40467n = onClickListener;
            return this;
        }

        public a n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40465l = charSequence;
            c0523b.f40467n = onClickListener;
            return this;
        }

        public a o(DialogInterface.OnCancelListener onCancelListener) {
            this.f40493a.f40472s = onCancelListener;
            return this;
        }

        public a p(DialogInterface.OnDismissListener onDismissListener) {
            this.f40493a.f40473t = onDismissListener;
            return this;
        }

        public a q(DialogInterface.OnKeyListener onKeyListener) {
            this.f40493a.f40474u = onKeyListener;
            return this;
        }

        public a r(int i10, DialogInterface.OnClickListener onClickListener) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40462i = c0523b.f40454a.getText(i10);
            this.f40493a.f40464k = onClickListener;
            return this;
        }

        public a s(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40462i = charSequence;
            c0523b.f40464k = onClickListener;
            return this;
        }

        public a t(int i10) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40459f = c0523b.f40454a.getText(i10);
            return this;
        }

        public a u(CharSequence charSequence) {
            this.f40493a.f40459f = charSequence;
            return this;
        }

        public a v(View view) {
            b.C0523b c0523b = this.f40493a;
            c0523b.f40479z = view;
            c0523b.f40478y = 0;
            c0523b.f40434E = false;
            return this;
        }

        public a(Context context, int i10) {
            this.f40493a = new b.C0523b(new ContextThemeWrapper(context, c.resolveDialogTheme(context, i10)));
            this.f40494b = i10;
        }
    }

    public c(Context context) {
        this(context, 0);
    }

    public static final b create(Context context, k kVar, Window window) {
        return new StepOSAlertController(context, kVar, window);
    }

    public static int resolveDialogTheme(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public b getAlertController() {
        return this.mAlert;
    }

    public Button getButton(int i10) {
        return this.mAlert.a(i10);
    }

    public ListView getListView() {
        return this.mAlert.c();
    }

    @Override // stepos.support.v7.app.k, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.d();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.mAlert.e(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.mAlert.f(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b alertController = getAlertController();
        if (alertController instanceof StepOSAlertController) {
            ((StepOSAlertController) alertController).h0();
        }
    }

    public void setAutoShowSoftInput(boolean z10) {
        this.mAlert.g(z10);
    }

    public void setButton(int i10, CharSequence charSequence, Message message) {
        this.mAlert.h(i10, charSequence, null, message, null);
    }

    public void setButtonPanelLayoutHint(int i10) {
        this.mAlert.i(i10);
    }

    public void setButtonTextColor(int i10, int i11) {
        this.mAlert.j(i10, i11);
    }

    public void setCustomPaddingRule(int i10, int i11, int i12, int i13) {
        this.mAlert.k(i10, i11, i12, i13);
    }

    public void setCustomTitle(View view) {
        this.mAlert.l(view);
    }

    public void setHighLightButton(int i10, int i11) {
        this.mAlert.m(i10, i11);
    }

    public void setIcon(int i10) {
        this.mAlert.n(i10);
    }

    public void setIconAttribute(int i10) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i10, typedValue, true);
        this.mAlert.n(typedValue.resourceId);
    }

    public void setMaxHeight(int i10) {
        this.mAlert.p(i10);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.q(charSequence);
    }

    public void setMessageMovementMethod(MovementMethod movementMethod) {
        this.mAlert.r(movementMethod);
    }

    @Override // stepos.support.v7.app.k, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.s(charSequence);
    }

    public void setView(View view) {
        this.mAlert.u(view);
    }

    public c(Context context, int i10) {
        super(context, resolveDialogTheme(context, i10));
        this.mAlert = create(getContext(), this, getWindow());
    }

    public void setButton(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.h(i10, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.o(drawable);
    }

    public void setView(View view, int i10, int i11, int i12, int i13) {
        this.mAlert.v(view, i10, i11, i12, i13);
    }

    public void setButton(int i10, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.h(i10, charSequence, onClickListener, null, drawable);
    }

    public c(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z10);
        setOnCancelListener(onCancelListener);
    }
}
