package aaa;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f2373b = null;

    public c() {
    }

    static {
        f2372a = new c();
        ServiceManager.get().bind(a.class, new SingletonProvider(new b()));     // Catch: Exception -> L9
        Object r100 = ServiceManager.get().getService(a.class, false);     // Catch: Exception -> L9
        if (((a) r100) != null) goto L6;
        ILogDepend.f384986a.w("WindowEffects", "bind WindowEffectsImpl failed");     // Catch: Exception -> L9
    L7:
        a r101 = (a) r100;     // Catch: Exception -> L9
    L11:
        f2373b = r101;
        return;
    L6:
        ILogDepend.f384986a.i("WindowEffects", "bind WindowEffectsImpl success");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        ILogDepend.f384986a.e("WindowEffects", "bind WindowEffectsImpl failed", e);
        r101 = null;
        goto L11
    }

    @Override // aaa.a
    public final void stopActivateEffect() {
        a r100 = f2373b;
        if (r100 == null) goto L6;
        r100.stopActivateEffect();
        return;
    }

    @Override // aaa.a
    public final void startActivateEffect(boolean r100) {
        a r101 = f2373b;
        if (r101 == null) goto L6;
        r101.startActivateEffect(r100);
        return;
    }

    @Override // aaa.a
    public final void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "windowLayerName");
        a r102 = f2373b;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // aaa.a
    public final void b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "windowLayerName");
        a r102 = f2373b;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }
}
