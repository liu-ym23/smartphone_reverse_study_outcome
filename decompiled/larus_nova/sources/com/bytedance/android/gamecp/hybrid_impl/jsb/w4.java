package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b<\u0010=R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\b¨\u0006?"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/w4;", "", "", "gameId", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gameName", "getGameName", "setGameName", "gameIcon", "getGameIcon", "setGameIcon", "gamePoint", "getGamePoint", "setGamePoint", "", "displayRating", "Ljava/lang/Integer;", "getDisplayRating", "()Ljava/lang/Integer;", "setDisplayRating", "(Ljava/lang/Integer;)V", "scoreGuidePrompt", "getScoreGuidePrompt", "setScoreGuidePrompt", "contentGuidePrompt", "getContentGuidePrompt", "setContentGuidePrompt", "deviceSeries", "getDeviceSeries", "setDeviceSeries", "minNum", "getMinNum", "setMinNum", "toast", "getToast", "setToast", "needRatingToast", "getNeedRatingToast", "setNeedRatingToast", "", "makeCommentGuideTagListArray", "Ljava/util/List;", "getMakeCommentGuideTagListArray", "()Ljava/util/List;", "setMakeCommentGuideTagListArray", "(Ljava/util/List;)V", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/w4$a;", "firstMakeCommentGuide", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/w4$a;", "getFirstMakeCommentGuide", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/w4$a;", "setFirstMakeCommentGuide", "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/w4$a;)V", "starPrompts", "getStarPrompts", "setStarPrompts", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w4 {

    @SerializedName("contentGuidePrompt")
    private String contentGuidePrompt;

    @SerializedName("deviceSeries")
    private String deviceSeries;

    @SerializedName("displayRating")
    private Integer displayRating;

    @SerializedName("firstMakeCommentGuide")
    private a firstMakeCommentGuide;

    @SerializedName("gameIcon")
    private String gameIcon;

    @SerializedName("gameId")
    private String gameId;

    @SerializedName("gameName")
    private String gameName;

    @SerializedName("gamePoint")
    private String gamePoint;

    @SerializedName("makeCommentGuideTagListArray")
    private List<String> makeCommentGuideTagListArray;

    @SerializedName("minNum")
    private Integer minNum;

    @SerializedName("needRatingToast")
    private String needRatingToast;

    @SerializedName("scoreGuidePrompt")
    private String scoreGuidePrompt;

    @SerializedName("starPrompts")
    private String starPrompts;

    @SerializedName("toast")
    private String toast;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/w4$a;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "content", "getContent", "setContent", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("content")
        private String content;

        @SerializedName("title")
        private String title;

        public a() {
        }
    }

    public w4() {
    }
}
