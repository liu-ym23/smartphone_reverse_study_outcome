package com.bytedance.android.ec.core.cps;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@"}, d2 = {"Lcom/bytedance/android/ec/core/cps/d;", "dynamicEventConfig", "Lcom/bytedance/android/ec/core/cps/f;", "dynamicProguardConfig", "", "", "rules", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "parseInitConfig"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionInjector", f = "CyberProtectionInjector.kt", i = {0, 0, 0, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL}, m = "parseInitConfig", n = {"hashEncoder", "paramsSort", "destination$iv$iv", "hashEncoder", "paramsSort", "deviceParams"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class CyberProtectionInjector$parseInitConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CyberProtectionInjector this$0;

    public CyberProtectionInjector$parseInitConfig$1(CyberProtectionInjector r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CyberProtectionInjector r101 = this.this$0;
        boolean r102 = CyberProtectionInjector.f43924a;
        return r101.e(null, null, null, this);
    }
}
