package com.bytedance.ai.applet.domain;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.domain.AppletDomainPolicyManager", f = "AppletDomainPolicyManager.kt", i = {0, 0, 0}, l = {173}, m = "ensureSocketAllowed", n = {"url", "normalizedAppKey", PlayerResolution.SDKKEY.ORIGIN}, s = {"L$0", "L$1", "L$2"})
public final class AppletDomainPolicyManager$ensureSocketAllowed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDomainPolicyManager this$0;

    public AppletDomainPolicyManager$ensureSocketAllowed$1(AppletDomainPolicyManager r100, Continuation<? super AppletDomainPolicyManager$ensureSocketAllowed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
