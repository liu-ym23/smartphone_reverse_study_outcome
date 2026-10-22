package stepos.support.v7.app;

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
import b5.b;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static int f20760a = -1;

    f() {
    }

    public static f e(Activity activity, e eVar) {
        return g(activity, activity.getWindow(), eVar);
    }

    public static f f(Dialog dialog, e eVar) {
        return g(dialog.getContext(), dialog.getWindow(), eVar);
    }

    private static f g(Context context, Window window, e eVar) {
        return new j(context, window, eVar);
    }

    public static int i() {
        return f20760a;
    }

    public abstract void A(View view);

    public abstract void B(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void C(Toolbar toolbar);

    public abstract void D(CharSequence charSequence);

    public abstract void E(int i5);

    public abstract void F();

    public abstract b5.b G(b.InterfaceC0154b interfaceC0154b);

    public abstract b5.b H(b.InterfaceC0154b interfaceC0154b);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean b();

    public abstract <T extends View> T h(int i5);

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

    public abstract boolean w(int i5);

    public abstract void x(Drawable drawable);

    public abstract void y(boolean z5);

    public abstract void z(int i5);
}
