package com.bytedance.android.gamecp.business;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.EvaluationVideoList")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/business/h;", "", "", "title", "Ljava/lang/String;", "", "Lcom/bytedance/android/gamecp/business/g;", "assessVideo", "Ljava/util/List;", "", "totalCount", "Ljava/lang/Long;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("evaluation_videos")
    public List<g> assessVideo;

    @SerializedName("title")
    public String title;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT)
    public Long totalCount;

    public h() {
        this.title = "";
        this.totalCount = 0L;
    }

    public h(am3.g r100) {
        this.assessVideo = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.assessVideo.add(new g(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.totalCount = Long.valueOf(r100.j());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.title != null) goto L19;
        this.title = "";
    L19:
        if (this.totalCount != null) goto L34;
        this.totalCount = 0L;
        return;
    }
}
