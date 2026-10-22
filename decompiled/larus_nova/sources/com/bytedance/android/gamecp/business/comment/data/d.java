package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.CommentEntranceInfo")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/d;", "", "", "scoreGuidePrompt", "Ljava/lang/String;", "contentGuidePrompt", "", "showEntrance", "Ljava/lang/Boolean;", "deviceSeries", "Lcom/bytedance/android/gamecp/business/comment/data/a;", "sendCharNumCheck", "Lcom/bytedance/android/gamecp/business/comment/data/a;", "Lcom/bytedance/android/gamecp/business/comment/data/p;", "firstMakeCommentGuide", "Lcom/bytedance/android/gamecp/business/comment/data/p;", "Lcom/bytedance/android/gamecp/business/comment/data/u;", "scoreGuide", "Lcom/bytedance/android/gamecp/business/comment/data/u;", "", "commentGuideTagList", "Ljava/util/List;", "Lcom/bytedance/android/gamecp/business/comment/data/f;", "gameInfo", "Lcom/bytedance/android/gamecp/business/comment/data/f;", "Lcom/bytedance/android/gamecp/business/comment/data/o;", "userScoreEvaluation", "Lcom/bytedance/android/gamecp/business/comment/data/o;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements vh7.h {

    @SerializedName("make_comment_guide_tag_list")
    public List<String> commentGuideTagList;

    @SerializedName("content_guide_prompt")
    public String contentGuidePrompt;

    @SerializedName("device_series")
    public String deviceSeries;

    @SerializedName("first_make_comment_guide")
    public p firstMakeCommentGuide;

    @SerializedName("game_info")
    public f gameInfo;

    @SerializedName("score_guide")
    public u scoreGuide;

    @SerializedName("score_guide_prompt")
    public String scoreGuidePrompt;

    @SerializedName("char_num_check_prompt")
    public a sendCharNumCheck;

    @SerializedName("show_entrance")
    public Boolean showEntrance;

    @SerializedName("user_score_evaluation")
    public o userScoreEvaluation;

    public d() {
        this.scoreGuidePrompt = "";
        this.contentGuidePrompt = "";
        this.showEntrance = Boolean.FALSE;
        this.deviceSeries = "";
    }

    public d(am3.g r100) {
        this.commentGuideTagList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.userScoreEvaluation = new o(r100);
        goto L3
    L8:
        this.gameInfo = new f(r100);
        goto L3
    L9:
        this.commentGuideTagList.add(am3.h.c(r100));
        goto L3
    L10:
        this.scoreGuide = new u(r100);
        goto L3
    L11:
        this.firstMakeCommentGuide = new p(r100);
        goto L3
    L12:
        this.sendCharNumCheck = new a(r100);
        goto L3
    L13:
        this.deviceSeries = am3.h.c(r100);
        goto L3
    L14:
        this.showEntrance = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L15:
        this.contentGuidePrompt = am3.h.c(r100);
        goto L3
    L16:
        this.scoreGuidePrompt = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.scoreGuidePrompt != null) goto L21;
        this.scoreGuidePrompt = "";
    L21:
        if (this.contentGuidePrompt != null) goto L24;
        this.contentGuidePrompt = "";
    L24:
        if (this.showEntrance != null) goto L27;
        this.showEntrance = Boolean.FALSE;
    L27:
        if (this.deviceSeries != null) goto L54;
        this.deviceSeries = "";
        return;
    }
}
