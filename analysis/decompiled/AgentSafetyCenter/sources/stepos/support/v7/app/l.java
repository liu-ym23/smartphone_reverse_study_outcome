package stepos.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class l {
    public static o b(Context context, Window window, k kVar) {
        o oVar = new o();
        oVar.f12387c = context;
        oVar.f12388f = window;
        oVar.i = kVar;
        Window.Callback callback = window.getCallback();
        oVar.f12389g = callback;
        if (callback instanceof n) {
            od.f.e("AppCompat has already installed itself into the Window");
            return null;
        }
        n nVar = new n(oVar, callback);
        oVar.f12390h = nVar;
        window.setCallback(nVar);
        oVar.B = null;
        p pVar = new p(0);
        pVar.f12410f = oVar;
        VarHandle.storeStoreFence();
        oVar.O = pVar;
        q qVar = new q();
        qVar.f12451c = oVar;
        VarHandle.storeStoreFence();
        oVar.S = qVar;
        h.b bVar = new h.b(3);
        bVar.f4749f = oVar;
        VarHandle.storeStoreFence();
        oVar.T = bVar;
        oVar.U = -100;
        oVar.V = true;
        m mVar = new m();
        mVar.f12342c = oVar;
        VarHandle.storeStoreFence();
        oVar.W = mVar;
        oVar.X = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        VarHandle.storeStoreFence();
        return oVar;
    }

    public abstract boolean a();

    public abstract void e();

    public abstract void f(Bundle bundle);

    public abstract boolean g(int i);

    public abstract void h(int i);

    public abstract se.b i(se.a aVar);

    public abstract se.b j(se.a aVar);
}
