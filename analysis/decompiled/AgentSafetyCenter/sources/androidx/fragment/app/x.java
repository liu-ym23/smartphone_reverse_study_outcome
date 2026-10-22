package androidx.fragment.app;

import androidx.lifecycle.a1;
import androidx.lifecycle.y0;
import java.lang.invoke.VarHandle;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x implements a1 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1337c;

    @Override // androidx.lifecycle.a1
    public final y0 a(Class cls) {
        switch (this.f1337c) {
            case 0:
                y yVar = new y();
                yVar.f1339b = new HashMap();
                yVar.f1340c = new HashMap();
                yVar.f1341d = new HashMap();
                yVar.f1342e = false;
                VarHandle.storeStoreFence();
                return yVar;
            default:
                return new k4.b();
        }
    }
}
