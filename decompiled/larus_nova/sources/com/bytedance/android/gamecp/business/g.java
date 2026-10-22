package com.bytedance.android.gamecp.business;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.EvaluationVideo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/gamecp/business/g;", "", "", "videoId", "Ljava/lang/String;", "Lcom/bytedance/android/gamecp/business/b;", "evaluationVideoAuthor", "Lcom/bytedance/android/gamecp/business/b;", "content", "coverUrl", "", "likeCount", "Ljava/lang/Integer;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g implements vh7.h {

    @SerializedName("title")
    public String content;

    @SerializedName("cover_url")
    public String coverUrl;

    @SerializedName("author")
    public b evaluationVideoAuthor;

    @SerializedName("digg_count")
    public Integer likeCount;

    @SerializedName("item_id")
    public String videoId;

    public g() {
        this.videoId = "";
        this.content = "";
        this.coverUrl = "";
        this.likeCount = 0;
    }

    public g(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.videoId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.evaluationVideoAuthor = new b(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.content = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.coverUrl = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.likeCount = Integer.valueOf(r100.i());
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.videoId != null) goto L25;
        this.videoId = "";
    L25:
        if (this.content != null) goto L28;
        this.content = "";
    L28:
        if (this.coverUrl != null) goto L31;
        this.coverUrl = "";
    L31:
        if (this.likeCount != null) goto L52;
        this.likeCount = 0;
        return;
    }
}
