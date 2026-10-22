package com.obric.capabilitykit.search;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Similarity {
    private final List<PhotoScore> photo;
    private final List<VideoScore> video;

    public Similarity(List<? extends PhotoScore> r3, List<VideoScore> r4) {
        List<PhotoScore> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<VideoScore> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "photo");
        o.e(r6, "video");
        this.photo = r5;
        this.video = r6;
    }

    public final List<PhotoScore> getPhoto() {
        return this.photo;
    }

    public final List<VideoScore> getVideo() {
        return this.video;
    }
}
