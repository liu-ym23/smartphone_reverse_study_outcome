package stepos.support.v7.app;

import Ic.b;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes5.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static int f40496a = -1;

    public static f e(Activity activity, e eVar) {
        return g(activity, activity.getWindow(), eVar);
    }

    public static f f(Dialog dialog, e eVar) {
        return g(dialog.getContext(), dialog.getWindow(), eVar);
    }

    public static f g(Context context, Window window, e eVar) {
        return new j(context, window, eVar);
    }

    public static int i() {
        return f40496a;
    }

    public abstract void A(View view);

    public abstract void B(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void C(Toolbar toolbar);

    public abstract void D(CharSequence charSequence);

    public abstract void E(int i10);

    public abstract void F();

    public abstract Ic.b G(b.InterfaceC0060b interfaceC0060b);

    public abstract Ic.b H(b.InterfaceC0060b interfaceC0060b);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean d();

    public abstract <T extends View> T h(int i10);

    public abstract androidx.appcompat.app.b j();

    public abstract MenuInflater k();

    public abstract a l();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void p(Configuration configuration);

    public abstract void q(Bundle bundle);

    public abstract void r();

    public abstract void s(Bundle bundle);

    public abstract void t();

    public abstract void u(Bundle bundle);

    public abstract void v();

    public abstract boolean w(int i10);

    public abstract void x(Drawable drawable);

    public abstract void y(boolean z10);

    public abstract void z(int i10);
}
