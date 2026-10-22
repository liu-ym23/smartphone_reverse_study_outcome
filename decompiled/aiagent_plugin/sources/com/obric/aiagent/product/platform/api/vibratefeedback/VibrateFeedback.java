package com.obric.aiagent.product.platform.api.vibratefeedback;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.feature.impl.a;
import com.obric.aiagent.product.platform.impl.f.b;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: VibrateFeedback.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VibrateFeedback implements IVibrateFeedback {
    public static final VibrateFeedback INSTANCE = null;
    private static final String TAG = "VibrateFeedback";
    private static IVibrateFeedback instance;

    public static /* synthetic */ Object lambda$AejTGs9GkDrLZGcSbIFl6Bt2ado() {
        return _init_$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$sPnO-N08ijKj4e6gPhEit-OnRik, reason: not valid java name */
    public static /* synthetic */ Object m224lambda$sPnON08ijKj4e6gPhEitOnRik() {
        return _init_$lambda$0();
    }

    private VibrateFeedback() {
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(String r1) {
        IVibrateFeedback.DefaultImpls.performVibratorSmtFeedback(this, r1);
    }

    static {
        INSTANCE = new VibrateFeedback();
    L15:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "init failed", th);
    L17:
        instance = (IVibrateFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IVibrateFeedback.class, false), IVibrateFeedback.class, "com.obric.aiagent.plugin");
        return;
    L4:
        if (a.f18789a.a().isObricOs() == true) goto L21;
        ServiceManager.get().bind(IVibrateFeedback.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$VibrateFeedback$AejTGs9GkDrLZGcSbIFl6Bt2ado.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        ILogDepend.Companion.i(TAG, "bind CommonVibrateFeedback");     // Catch: Throwable -> L12
    L23:
    L12:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind CommonVibrateFeedback failed", th);     // Catch: Throwable -> L15
        goto L23
    L21:
        ServiceManager.get().bind(IVibrateFeedback.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$VibrateFeedback$sPnON08ijKj4e6gPhEitOnRik.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        ILogDepend.Companion.i(TAG, "bind PacificVibrateFeedback");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind PacificVibrateFeedback failed", th);     // Catch: Throwable -> L15
        goto L23
    }

    private static final Object _init_$lambda$0() {
        return new b();
    }

    private static final Object _init_$lambda$1() {
        return new com.obric.aiagent.product.platform.impl.f.a();
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(FeedbackType r1) {
        o.e(r1, "feedbackType");
        IVibrateFeedback r0 = instance;
        if (r0 == null) goto L6;
        r0.performVibratorSmtFeedback(r1);
        return;
    }
}
