package com.bytedance.android.ec.core.cps;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0082@"}, d2 = {"", "key", "Lkotlin/coroutines/Continuation;", "continuation", "", "paramsOfKey"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionInjectorKt", f = "CyberProtectionInjector.kt", i = {}, l = {315, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 324, 325, 326, 327, 331, 334, 337, 338, 340}, m = "paramsOfKey", n = {}, s = {})
final class CyberProtectionInjectorKt$paramsOfKey$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public CyberProtectionInjectorKt$paramsOfKey$1(Continuation r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return c.c(null, this);
    }
}
