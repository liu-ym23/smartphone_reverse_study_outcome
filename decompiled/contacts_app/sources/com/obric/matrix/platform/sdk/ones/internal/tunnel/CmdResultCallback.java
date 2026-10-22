package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.matrix.proto.Response;
import kotlin.Metadata;

/* JADX INFO: compiled from: CmdResultCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/CmdResultCallback;", "", "onResult", "", EventConstants.EVENT_KEY_CMD, "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/obric/matrix/proto/Response;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CmdResultCallback {
    void onResult(int r1, Response r2);
}
