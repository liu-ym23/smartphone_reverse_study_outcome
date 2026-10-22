package m1;

import android.view.KeyEvent;
import java.lang.invoke.VarHandle;
import v1.p;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends l implements c {

    /* renamed from: s, reason: collision with root package name */
    public p f8188s;

    @Override // m1.c
    public final boolean h(KeyEvent keyEvent) {
        return false;
    }

    @Override // m1.c
    public final boolean y(KeyEvent keyEvent) {
        p pVar = this.f8188s;
        if (pVar == null) {
            return false;
        }
        b bVar = new b();
        bVar.f8187a = keyEvent;
        VarHandle.storeStoreFence();
        return ((Boolean) pVar.invoke(bVar)).booleanValue();
    }
}
