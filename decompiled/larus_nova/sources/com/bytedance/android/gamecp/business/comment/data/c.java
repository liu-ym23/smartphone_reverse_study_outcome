package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.game_evaluation.api.GetEvaluationListResponse.Data")
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/c;", "", "", "total", "Ljava/lang/Long;", "", "hasMore", "Ljava/lang/Boolean;", "", "Lcom/bytedance/android/gamecp/business/comment/data/b;", "detailList", "Ljava/util/List;", "userDetailList", "Lcom/bytedance/android/gamecp/business/comment/data/d;", "commentEntrance", "Lcom/bytedance/android/gamecp/business/comment/data/d;", "Lcom/bytedance/android/gamecp/business/comment/data/g;", "gradeInfo", "Lcom/bytedance/android/gamecp/business/comment/data/g;", "", "Lcom/bytedance/android/gamecp/business/comment/data/j;", "tagList", "Lcom/bytedance/android/gamecp/business/comment/data/e;", "commentFeedbackInfo", "Lcom/bytedance/android/gamecp/business/comment/data/e;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements vh7.h {

    @SerializedName("comment_entrance_info")
    public d commentEntrance;

    @SerializedName("comment_nps_entrance")
    public e commentFeedbackInfo;

    @SerializedName("evaluation_detail")
    public List<? extends b> detailList;

    @SerializedName("grade_info")
    public g gradeInfo;

    @SerializedName("has_more")
    public Boolean hasMore;

    @SerializedName("tag_list")
    public List<j> tagList;

    @SerializedName("total")
    public Long total;

    @SerializedName("user_evaluation_detail")
    public List<? extends b> userDetailList;

    public c() {
        this.total = 0L;
        this.hasMore = Boolean.FALSE;
        this.tagList = new ArrayList();
    }

    public c(am3.g r100) {
        this.detailList = new ArrayList();
        this.userDetailList = new ArrayList();
        this.tagList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.commentFeedbackInfo = new e(r100);
        goto L3
    L8:
        this.gradeInfo = new g(r100);
        goto L3
    L9:
        List r103 = this.tagList;
        vh7.h r104 = new j(r100);
    L13:
        r103.add(r104);
        goto L3
    L10:
        this.commentEntrance = new d(r100);
        goto L3
    L11:
        r103 = this.userDetailList;
        r104 = new b(r100);
        goto L13
    L12:
        r103 = this.detailList;
        r104 = new b(r100);
        goto L13
    L14:
        this.hasMore = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L15:
        this.total = Long.valueOf(r100.j());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if (this.total != null) goto L20;
        this.total = 0L;
    L20:
        if (this.hasMore != null) goto L23;
        this.hasMore = Boolean.FALSE;
    L23:
        if (this.tagList.isEmpty() == false) goto L44;
        this.tagList = new ArrayList();
        return;
    }
}
