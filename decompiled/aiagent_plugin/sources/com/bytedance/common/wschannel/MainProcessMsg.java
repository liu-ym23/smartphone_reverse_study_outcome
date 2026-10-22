package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class MainProcessMsg extends WsChannelMsg {
    private final f mListener;
    private final WsChannelMsg origin;

    MainProcessMsg(WsChannelMsg r3, f r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        super(r3);
        this.origin = r3;
        this.mListener = r5;
    }

    WsChannelMsg getOrigin() {
        return this.origin;
    }

    public f getListener() {
        return this.mListener;
    }
}
