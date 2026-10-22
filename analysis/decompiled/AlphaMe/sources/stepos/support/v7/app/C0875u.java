package stepos.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.Window;

/* renamed from: stepos.support.v7.app.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0875u extends AbstractC0873s {

    /* renamed from: U, reason: collision with root package name */
    public final UiModeManager f14589U;

    public C0875u(Context context, Window window, InterfaceC0867l interfaceC0867l) {
        super(context, window, interfaceC0867l);
        this.f14589U = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
    }

    @Override // stepos.support.v7.app.AbstractC0873s
    public final int C(int i4) {
        if (i4 == 0 && this.f14589U.getNightMode() == 0) {
            return -1;
        }
        return super.C(i4);
    }

    @Override // stepos.support.v7.app.AbstractC0870o
    public final Window.Callback m(Window.Callback callback) {
        return new C0874t(this, callback);
    }
}
