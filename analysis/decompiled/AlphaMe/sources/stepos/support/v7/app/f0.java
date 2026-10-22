package stepos.support.v7.app;

import android.view.View;
import java.security.InvalidParameterException;

/* loaded from: classes2.dex */
public final class f0 implements K.g0, InterfaceC0856a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f14471a;

    @Override // stepos.support.v7.app.InterfaceC0856a
    public final void a(int i4, y.g gVar) {
        this.f14471a.getClass();
        if (i4 != 0 && i4 != 1) {
            throw new InvalidParameterException();
        }
    }

    @Override // K.g0
    public final void l() {
        ((View) this.f14471a.f14483d.getParent()).invalidate();
    }
}
