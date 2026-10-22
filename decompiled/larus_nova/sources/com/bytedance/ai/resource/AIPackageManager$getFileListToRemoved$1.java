package com.bytedance.ai.resource;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {0, 0, 1, 1, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, MediaPlayer.MEDIA_PLAYER_OPTION_AE_SRC_LUFS}, m = "getFileListToRemoved", n = {"fileListToDelete", "aiPackage", "fileListToDelete", "aiPackage", "installedPackage", "fileListToDelete"}, s = {"L$0", "L$2", "L$0", "L$2", "L$3", "L$0"})
public final class AIPackageManager$getFileListToRemoved$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageManager this$0;

    public AIPackageManager$getFileListToRemoved$1(AIPackageManager r100, Continuation<? super AIPackageManager$getFileListToRemoved$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AIPackageManager r101 = this.this$0;
        AIPackageManager r102 = AIPackageManager.f37254a;
        return r101.f(null, this);
    }
}
