package stepos.support.v7.app;

import android.view.View;
import java.security.InvalidParameterException;

/* loaded from: classes2.dex */
public final class K implements K.g0, InterfaceC0856a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M f14291a;

    @Override // stepos.support.v7.app.InterfaceC0856a
    public final void a(int i4, y.g gVar) {
        this.f14291a.getClass();
        if (i4 != 0 && i4 != 1) {
            throw new InvalidParameterException();
        }
    }

    @Override // K.g0
    public final void l() {
        ((View) this.f14291a.f14305f.getParent()).invalidate();
    }
}
