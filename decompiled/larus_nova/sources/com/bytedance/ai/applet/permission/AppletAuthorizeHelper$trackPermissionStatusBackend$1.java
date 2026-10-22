package com.bytedance.ai.applet.permission;

import com.bytedance.keva.Keva;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper", f = "AppletAuthorizeHelper.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS}, m = "trackPermissionStatusBackend", n = {"authTaskSession", "permissionCheckSession", "startTs"}, s = {"L$0", "L$1", "J$0"})
public final class AppletAuthorizeHelper$trackPermissionStatusBackend$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$trackPermissionStatusBackend$1(AppletAuthorizeHelper r100, Continuation<? super AppletAuthorizeHelper$trackPermissionStatusBackend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AppletAuthorizeHelper r101 = this.this$0;
        Lazy<Keva> r102 = AppletAuthorizeHelper.f34919d;
        return r101.j(null, null, null, this);
    }
}
