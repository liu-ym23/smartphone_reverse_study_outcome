package com.bytedance.android.livesdkapi.model.gamecp;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.gamecp.api.FeaturedContent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/gamecp/FeatureContent;", "", "()V", "contentList", "", "Lcom/bytedance/android/livesdkapi/model/gamecp/Content;", "rotationTime", "", "Ljava/lang/Integer;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeatureContent implements h {

    @SerializedName("contents")
    public List<Content> contentList;

    @SerializedName("rotation_time")
    public Integer rotationTime;

    public FeatureContent() {
    }

    public FeatureContent(g r100) {
        this.contentList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.rotationTime = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.contentList.add(new Content(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
