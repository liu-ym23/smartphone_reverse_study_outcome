package p3;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.stepos.widget.button.StepOSButton;
import l3.C0844b;
import p3.j;

/* loaded from: classes.dex */
public class j extends Dialog implements DialogInterface {

    /* renamed from: b, reason: collision with root package name */
    public static final b f19511b = new b(null);

    /* renamed from: a, reason: collision with root package name */
    private final g f19512a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f19513a;

        /* renamed from: b, reason: collision with root package name */
        private final o f19514b;

        /* renamed from: p3.j$a$a, reason: collision with other inner class name */
        public interface InterfaceC0232a<T extends j> {
            T newDialog(Context context, int i5);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            this(context, 0, 2, null);
            j4.k.g(context, "context");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final j d(Context context, int i5) {
            j4.k.g(context, "context");
            return new j(context, i5);
        }

        public j b() {
            return c(new InterfaceC0232a() { // from class: p3.i
                @Override // p3.j.a.InterfaceC0232a
                public final j newDialog(Context context, int i5) {
                    return j.a.d(context, i5);
                }
            });
        }

        public final <T extends j> T c(InterfaceC0232a<T> interfaceC0232a) throws Resources.NotFoundException {
            j4.k.g(interfaceC0232a, "factory");
            T t5 = (T) interfaceC0232a.newDialog(this.f19514b.f(), this.f19513a);
            this.f19514b.a(((j) t5).f19512a);
            t5.setCancelable(this.f19514b.c());
            if (this.f19514b.c()) {
                t5.setCanceledOnTouchOutside(true);
            }
            t5.setOnCancelListener(this.f19514b.n());
            t5.setOnDismissListener(this.f19514b.q());
            DialogInterface.OnKeyListener onKeyListenerS = this.f19514b.s();
            if (onKeyListenerS != null) {
                t5.setOnKeyListener(onKeyListenerS);
            }
            return t5;
        }

        public final Context e() {
            return this.f19514b.f();
        }

        public a f(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.f19514b.z(charSequence);
            this.f19514b.y(onClickListener);
            return this;
        }

        public a g(int i5, DialogInterface.OnClickListener onClickListener) {
            o oVar = this.f19514b;
            oVar.B(oVar.f().getText(i5));
            this.f19514b.A(onClickListener);
            return this;
        }

        public a h(int i5) {
            o oVar = this.f19514b;
            oVar.C(oVar.f().getText(i5));
            return this;
        }

        public a i(View view) {
            this.f19514b.D(view);
            this.f19514b.E(0);
            this.f19514b.F(false);
            return this;
        }

        public a(Context context, int i5) {
            j4.k.g(context, "context");
            this.f19513a = i5;
            this.f19514b = new o(new ContextThemeWrapper(context, j.f19511b.a(context, i5)));
        }

        public /* synthetic */ a(Context context, int i5, int i6, j4.g gVar) {
            this(context, (i6 & 2) != 0 ? 0 : i5);
        }
    }

    public static final class b {
        public /* synthetic */ b(j4.g gVar) {
            this();
        }

        public final int a(Context context, int i5) {
            j4.k.g(context, "context");
            if (((i5 >>> 24) & 255) >= 1) {
                return i5;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C0844b.f18281b, typedValue, true);
            int i6 = typedValue.resourceId;
            return i6 != 0 ? i6 : l3.l.f18487j;
        }

        private b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected j(Context context, int i5) {
        super(context, f19511b.a(context, i5));
        j4.k.g(context, "context");
        Context context2 = getContext();
        j4.k.f(context2, "getContext(...)");
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog window is null; check the dialog theme");
        }
        this.f19512a = new g(context2, this, window);
    }

    public StepOSButton b(int i5) {
        return this.f19512a.w(i5);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f19512a.o();
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        this.f19512a.z();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        j4.k.g(keyEvent, "event");
        return this.f19512a.C(keyEvent) || super.onKeyDown(i5, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i5, KeyEvent keyEvent) {
        j4.k.g(keyEvent, "event");
        return this.f19512a.D(keyEvent) || super.onKeyUp(i5, keyEvent);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.f19512a.i0();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        this.f19512a.o();
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) throws Resources.NotFoundException {
        super.setTitle(charSequence);
        this.f19512a.f0(charSequence);
    }

    @Override // android.app.Dialog
    public void setTitle(int i5) throws Resources.NotFoundException {
        setTitle(getContext().getText(i5));
    }
}
