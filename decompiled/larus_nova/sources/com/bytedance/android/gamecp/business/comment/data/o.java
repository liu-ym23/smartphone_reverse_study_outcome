package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.gamecp.host_api.model.ImageModelLive;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.EvaluationInfo")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0007R\u0016\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/o;", "", "", "evaluationId", "J", "", "evalId", "Ljava/lang/String;", "gameId", "evaluationType", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "D", "content", "", "Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "imageList", "Ljava/util/List;", "submitTime", "likeCount", "dislikeCount", "relationTypeFlag", "commentCount", "deviceSeries", "", "isSelected", "Z", "isOwnEvaluation", "Ljava/lang/Boolean;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o implements vh7.h {

    @SerializedName("comment_count")
    public long commentCount;

    @SerializedName("content")
    public String content;

    @SerializedName("device_series")
    public String deviceSeries;

    @SerializedName("bury_count")
    public long dislikeCount;

    @SerializedName("eval_id")
    public String evalId;

    @SerializedName("evaluation_id")
    public long evaluationId;

    @SerializedName("evaluation_type")
    public long evaluationType;

    @SerializedName("game_id")
    public String gameId;

    @SerializedName("image_list")
    public List<ImageModelLive> imageList;

    @SerializedName("is_own_evaluation")
    public Boolean isOwnEvaluation;

    @SerializedName("selected")
    public boolean isSelected;

    @SerializedName("like_count")
    public long likeCount;

    @SerializedName("relation_type_flag")
    public long relationTypeFlag;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    public double score;

    @SerializedName("submit_time")
    public long submitTime;

    public o() {
        this.evalId = "";
        this.gameId = "";
        this.content = "";
        this.deviceSeries = "";
        this.isOwnEvaluation = Boolean.FALSE;
    }

    public o(am3.g r100) {
        this.imageList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        switch(r102) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L6;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L6;
            case 16: goto L8;
            case 17: goto L7;
            default: goto L6;
        };
    L7:
        this.isOwnEvaluation = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        this.dislikeCount = r100.j();
        goto L3
    L9:
        this.isSelected = am3.h.a(r100);
        goto L3
    L10:
        this.deviceSeries = am3.h.c(r100);
        goto L3
    L11:
        this.imageList.add(new ImageModelLive(r100));
        goto L3
    L12:
        this.evalId = am3.h.c(r100);
        goto L3
    L13:
        this.commentCount = r100.j();
        goto L3
    L14:
        this.relationTypeFlag = r100.j();
        goto L3
    L15:
        this.likeCount = r100.j();
        goto L3
    L16:
        this.submitTime = r100.j();
        goto L3
    L17:
        this.content = am3.h.c(r100);
        goto L3
    L18:
        this.score = Double.longBitsToDouble(r100.h());
        goto L3
    L19:
        this.evaluationType = r100.j();
        goto L3
    L20:
        this.gameId = am3.h.c(r100);
        goto L3
    L21:
        this.evaluationId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L22:
        r100.d(r101);
        if (this.evalId != null) goto L26;
        this.evalId = "";
    L26:
        if (this.gameId != null) goto L29;
        this.gameId = "";
    L29:
        if (this.content != null) goto L32;
        this.content = "";
    L32:
        if (this.deviceSeries != null) goto L35;
        this.deviceSeries = "";
    L35:
        if (this.isOwnEvaluation != null) goto L72;
        this.isOwnEvaluation = Boolean.FALSE;
        return;
    }
}
