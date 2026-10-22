package com.bytedance.ai.resource.core;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.AIPackageOperationGroup", f = "AIPackageOperationGroup.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS}, m = "loadManifestBean", n = {"deploymentInfo"}, s = {"L$0"})
public final class AIPackageOperationGroup$loadManifestBean$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageOperationGroup this$0;

    public AIPackageOperationGroup$loadManifestBean$1(AIPackageOperationGroup r100, Continuation<? super AIPackageOperationGroup$loadManifestBean$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
