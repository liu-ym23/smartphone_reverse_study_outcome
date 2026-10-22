package com.obric.autogui.common.api.platform.tracking;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: IAutoActionTrackingApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionTrackingApi {

    /* JADX INFO: compiled from: IAutoActionTrackingApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void reportEvent$default(IAutoActionTrackingApi r6, String r7, JSONObject r8, boolean r9, boolean r10, TrackingReportTarget r11, int r12, Object r13) {
            IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.wrapperContextForParams(r6, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L18;
            if ((r12 & 4) == 0) goto L7;
            boolean r3 = true;
        L9:
            if ((r12 & 8) == 0) goto L11;
            boolean r4 = true;
        L13:
            if ((r12 & 16) == 0) goto L15;
            r11 = TrackingReportTarget.DEFAULT;
        L15:
            r0.reportEvent(r7, r8, r3, r4, r11);
            return;
        L11:
            r4 = r10;
            goto L13
        L7:
            r3 = r9;
            goto L9
        L18:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportEvent");
        }
    }

    void init(Context r1);

    void reportEvent(String r1, JSONObject r2, boolean r3, boolean r4, TrackingReportTarget r5);
}
