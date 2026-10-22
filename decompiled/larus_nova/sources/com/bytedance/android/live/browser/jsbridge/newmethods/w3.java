package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class w3 extends d<x3, GetBackAnchorResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f63698a;

    public w3(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "mDataCenter");
        this.f63698a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        x3 r102 = (x3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IVSPlayerService r103 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r103 == null) goto L12;
        IPlayerProgressService r104 = r103.provideVSProgressService(this.f63698a);
        if (r104 == null) goto L13;
        Integer r105 = r102.a();
        if (r105 == null) goto L9;
        long r106 = r105.intValue();
    L10:
        r104.seekTo(r106 * 1000);
        return;
    L9:
        r106 = 0;
        goto L10
    L13:
        return;
    }
}
