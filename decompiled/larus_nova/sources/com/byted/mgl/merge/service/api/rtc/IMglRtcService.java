package com.byted.mgl.merge.service.api.rtc;

import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/byted/mgl/merge/service/api/rtc/IMglRtcService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "createRtcEngine", "Lcom/byted/mgl/merge/service/api/rtc/IMglRtcEngine;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "appId", "", "handler", "Lcom/byted/mgl/merge/service/api/rtc/IMglRtcEventHandler;", "businessId", "isFeatureSupport", "", "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface IMglRtcService extends IBdpService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 18})
    public static final class DefaultImpls {
        public static /* synthetic */ IMglRtcEngine createRtcEngine$default(IMglRtcService r100, Context r101, String r102, IMglRtcEventHandler r103, String r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 8) == 0) goto L7;
            r104 = null;
        L7:
            return r100.createRtcEngine(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRtcEngine");
        }
    }

    IMglRtcEngine createRtcEngine(Context r100, String r101, IMglRtcEventHandler r102, String r103);

    boolean isFeatureSupport();
}
