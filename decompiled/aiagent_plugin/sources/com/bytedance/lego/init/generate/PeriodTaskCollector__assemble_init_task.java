package com.bytedance.lego.init.generate;

import com.bytedance.lego.init.IPeriodTaskCollector;
import com.bytedance.lego.init.model.PeriodTaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PeriodTaskCollector__assemble_init_task implements IPeriodTaskCollector {
    @Override // com.bytedance.lego.init.IPeriodTaskCollector
    public void collectPeriodTask(List<PeriodTaskInfo> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
    }

    public PeriodTaskCollector__assemble_init_task() {
    }
}
