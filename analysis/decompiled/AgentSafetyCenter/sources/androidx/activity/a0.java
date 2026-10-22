package androidx.activity;

import android.window.OnBackInvokedCallback;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f650a = new a0();

    public final OnBackInvokedCallback a(xb.l lVar, xb.l lVar2, xb.a aVar, xb.a aVar2) {
        lVar.getClass();
        lVar2.getClass();
        aVar.getClass();
        aVar2.getClass();
        z zVar = new z();
        zVar.f709a = lVar;
        zVar.f710b = lVar2;
        zVar.f711c = aVar;
        zVar.f712d = aVar2;
        VarHandle.storeStoreFence();
        return zVar;
    }
}
