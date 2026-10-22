package com.bytedance.applet.event;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.BaseAppActionListener", f = "BaseAppActionListener.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 290}, m = "processUIAction", n = {"botId", "appId", "apiName", "param", "featureMap", RemoteMessageConst.MSGID, "questionId", "createTime", "responseCallback", "botId", "appId", "apiName", "param", "featureMap", RemoteMessageConst.MSGID, "questionId", "createTime", "responseCallback"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
final class BaseAppActionListener$processUIAction$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    public BaseAppActionListener$processUIAction$1(e r100, Continuation<? super BaseAppActionListener$processUIAction$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return e.d(this.this$0, null, null, null, null, null, null, null, null, null, null, this);
    }
}
