package com.bytedance.lego.init.generate;

import com.bytedance.lego.init.IFeedShowTaskCollector;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FeedShowTaskCollector__assemble_init_task implements IFeedShowTaskCollector {
    @Override // com.bytedance.lego.init.IFeedShowTaskCollector
    public void collectTask(List<FeedShowTaskInfo> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
    }

    public FeedShowTaskCollector__assemble_init_task() {
    }
}
