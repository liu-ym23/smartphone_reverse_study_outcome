package stepos.support.v7.app;

import android.content.Context;
import android.view.KeyEvent;
import android.view.Window;

/* renamed from: stepos.support.v7.app.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0870o extends AbstractC0868m {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14509a;

    /* renamed from: b, reason: collision with root package name */
    public final Window f14510b;

    /* renamed from: c, reason: collision with root package name */
    public final Window.Callback f14511c;

    /* renamed from: d, reason: collision with root package name */
    public final Window.Callback f14512d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0867l f14513e;

    /* renamed from: f, reason: collision with root package name */
    public AbstractC0860e f14514f;

    /* renamed from: g, reason: collision with root package name */
    public K3.k f14515g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14516h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14517i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14518j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14519k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14520l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14521m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f14522n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f14523o;

    /* renamed from: p, reason: collision with root package name */
    public int f14524p;

    public AbstractC0870o(Context context, Window window, InterfaceC0867l interfaceC0867l) {
        this.f14509a = context;
        this.f14510b = window;
        this.f14513e = interfaceC0867l;
        Window.Callback callback = window.getCallback();
        this.f14511c = callback;
        if (callback instanceof AbstractC0869n) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callbackM = m(callback);
        this.f14512d = callbackM;
        window.setCallback(callbackM);
    }

    public abstract boolean k(KeyEvent keyEvent);

    public abstract void l();

    public abstract Window.Callback m(Window.Callback callback);
}
