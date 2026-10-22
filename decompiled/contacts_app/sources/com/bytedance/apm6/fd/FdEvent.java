package com.bytedance.apm6.fd;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import com.bytedance.apm6.util.ListUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FdEvent extends PerfBaseEvent {
    private static final String KEY_FD_COUNT = "fd_count";
    private static final String KEY_FD_DETAIL = "fd_detail";
    private static final String PERF_KEY_FD = "fd";
    private int fdCount;
    private List<String> fdNames;
    private boolean isFront;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "fd";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public FdEvent(int r1, List<String> r2, boolean r3) {
        this.fdCount = r1;
        this.fdNames = r2;
        this.isFront = r3;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject createRootJSONObject() {
        JSONObject r0 = new JSONObject();
        r0.put(KEY_FD_COUNT, this.fdCount);     // Catch: Exception -> L7
        if (ListUtils.isEmpty(this.fdNames) == true) goto L6;
        r0.put(KEY_FD_DETAIL, ListUtils.listToString(this.fdNames, "\n"));     // Catch: Exception -> L7
    L6:
        return r0;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
        JSONObject r0 = super.getExtraStatus();
        if (r0 == null) goto L8;
    L5:
        r0.put(CommonKey.KEY_IS_FRONT, this.isFront);     // Catch: Exception -> L7
    L6:
        return r0;
    L8:
        r0 = new JSONObject();     // Catch: Exception -> L7
        goto L5
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        return PerfFilterManager.getInstance().getPerfFiltersJson();
    }
}
