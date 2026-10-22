package a1;

import android.view.KeyEvent;
import j1.u;
import n0.l;

/* loaded from: classes.dex */
public final class e extends l implements d {

    /* renamed from: t, reason: collision with root package name */
    public u f156t;

    @Override // a1.d
    public final boolean B(KeyEvent keyEvent) {
        u uVar = this.f156t;
        if (uVar != null) {
            return ((Boolean) uVar.invoke(new c(keyEvent))).booleanValue();
        }
        return false;
    }

    @Override // a1.d
    public final boolean i(KeyEvent keyEvent) {
        return false;
    }
}
