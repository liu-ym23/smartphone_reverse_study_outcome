package stepos.support.v7.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.Window;

/* renamed from: stepos.support.v7.app.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1966o extends AbstractC1964m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6316a;
    public final Window b;
    public final Window.Callback c;
    public final Window.Callback d;
    public final Object e;
    public AbstractC1955d f;
    public Ua.k g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6317j;
    public boolean k;
    public boolean l;
    public boolean m;
    public CharSequence n;
    public boolean o;
    public int p;

    public AbstractC1966o(Context context, Window window, InterfaceC1963l interfaceC1963l) {
        this.f6316a = context;
        this.b = window;
        this.e = interfaceC1963l;
        Window.Callback callback = window.getCallback();
        this.c = callback;
        if (callback instanceof C1967p) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callbackN = n(callback);
        this.d = callbackN;
        window.setCallback(callbackN);
    }

    public abstract boolean j(KeyEvent keyEvent);

    public final Context l() {
        m();
        AbstractC1955d abstractC1955d = this.f;
        Context contextD = abstractC1955d != null ? abstractC1955d.d() : null;
        return contextD == null ? this.f6316a : contextD;
    }

    public abstract void m();

    public abstract Window.Callback n(Window.Callback callback);
}
