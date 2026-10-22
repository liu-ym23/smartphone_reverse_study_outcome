package com.bytedanceos.common.ad.entity.req;

import com.bytedanceos.common.networkv2.entity.req.ReportCommonParams;
import com.bytedanceos.common.networkv2.entity.req.ReportCustomParams;

/* JADX INFO: loaded from: classes2.dex */
public class ReqReportEntity {
    private ReportCommonParams common_params;
    private ReportCustomParams custom_params;

    public ReqReportEntity() {
    }

    public ReportCommonParams getCommon_params() {
        return this.common_params;
    }

    public ReportCustomParams getCustom_params() {
        return this.custom_params;
    }

    public void setCommon_params(ReportCommonParams r10) {
        this.common_params = r10;
    }

    public void setCustom_params(ReportCustomParams r10) {
        this.custom_params = r10;
    }
}
