package com.bytedance.android.ec.core.frontier;

import com.bytedance.common.wschannel.MsgSendListener;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements MsgSendListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f44044a = null;

    static {
        f44044a = new e();
    }

    public e() {
    }

    @Override // com.bytedance.common.wschannel.MsgSendListener
    public final void onSendResult(WsChannelMsg r100, boolean r101) {
        if (r100 == null) goto L8;
        byte[] r102 = r100.getPayload();
        if (r102 == null) goto L9;
        new String(r102, Charsets.UTF_8);
        return;
    L9:
        return;
    }
}
