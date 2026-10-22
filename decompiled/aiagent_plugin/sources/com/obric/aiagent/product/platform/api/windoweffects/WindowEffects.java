package com.obric.aiagent.product.platform.api.windoweffects;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.impl.windoweffects.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: WindowEffects.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WindowEffects implements IWindowEffects {
    public static final WindowEffects INSTANCE = null;
    private static final String TAG = "WindowEffects";
    private static final IWindowEffects instance = null;

    public static /* synthetic */ Object lambda$jP7eOuSnjQNoseK1OpG_uhDfVms() {
        return instance$lambda$0();
    }

    private WindowEffects() {
    }

    static {
        INSTANCE = new WindowEffects();
        ServiceManager.get().bind(IWindowEffects.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$WindowEffects$jP7eOuSnjQNoseK1OpG_uhDfVms.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L9
        Object r3 = ServiceManager.get().getService(IWindowEffects.class, false);     // Catch: Exception -> L9
        if (((IWindowEffects) ZeusTransformUtils.preCheckCast(r3, IWindowEffects.class, "com.obric.aiagent.plugin")) != null) goto L6;
        ILogDepend.Companion.w(TAG, "bind WindowEffectsImpl failed");     // Catch: Exception -> L9
    L7:
        IWindowEffects r4 = (IWindowEffects) ZeusTransformUtils.preCheckCast(r3, IWindowEffects.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
    L11:
        instance = r4;
        return;
    L6:
        ILogDepend.Companion.i(TAG, "bind WindowEffectsImpl success");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "bind WindowEffectsImpl failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r4 = null;
        goto L11
    }

    private static final Object instance$lambda$0() {
        return new a();
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void startActivateEffect(boolean r1) {
        IWindowEffects r0 = instance;
        if (r0 == null) goto L6;
        r0.startActivateEffect(r1);
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void stopActivateEffect() {
        IWindowEffects r0 = instance;
        if (r0 == null) goto L6;
        r0.stopActivateEffect();
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void showScreenShotEffect(boolean r1, String r2) {
        o.e(r2, "windowLayerName");
        IWindowEffects r0 = instance;
        if (r0 == null) goto L6;
        r0.showScreenShotEffect(r1, r2);
        return;
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void playRippleEffect(boolean r1, String r2) {
        o.e(r2, "windowLayerName");
        IWindowEffects r0 = instance;
        if (r0 == null) goto L6;
        r0.playRippleEffect(r1, r2);
        return;
    }
}
