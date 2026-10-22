package com.obric.matrix.platform.sdk.ones.ws;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/IWsBridge;", "", "onWsMsgReceived", "", "channelId", "", "seqId", "", "logId", "service", "method", "encoding", "", "type", WsConstants.KEY_PAYLOAD, "", "headers", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWsBridge {
    void onWsMsgReceived(int r10, long r11, long r12, int r13, int r14, @Nullable String r15, @Nullable String r16, @Nullable byte[] r17, @Nullable Map<String, String> r18);
}
