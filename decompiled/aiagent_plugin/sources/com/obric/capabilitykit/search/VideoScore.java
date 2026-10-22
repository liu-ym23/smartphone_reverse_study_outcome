package com.obric.capabilitykit.search;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class VideoScore {
    private String entityId;
    private List<FrameScore> frameList;

    public VideoScore(String r3, List<FrameScore> r4) {
        List<FrameScore> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "entityId");
        o.e(r5, "frameList");
        this.entityId = r3;
        this.frameList = r5;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final List<FrameScore> getFrameList() {
        return this.frameList;
    }

    public final void setEntityId(String r2) {
        o.e(r2, "<set-?>");
        this.entityId = r2;
    }

    public final void setFrameList(List<FrameScore> r3) {
        List<FrameScore> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.frameList = r4;
    }
}
