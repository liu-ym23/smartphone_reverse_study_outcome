package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u001bR\u001c\u0010#\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u001bR\u001a\u0010(\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0006\u001a\u0004\b%\u0010&R\u001a\u0010+\u001a\u00020\u00198&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0006\u001a\u0004\b)\u0010\u001bR\u001e\u00101\u001a\u00060,j\u0002`-8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0006\u001a\u0004\b.\u0010/R\u001a\u00106\u001a\u0002028&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0006\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/s8;", "Lvh7/c;", "", "isUnlockedRank", "()Z", "isUnlockedRank$annotations", "()V", "getEnableTab", "getEnableTab$annotations", "enableTab", "Lcom/bytedance/android/livesdk/link/model/g8;", "getRankInfo", "()Lcom/bytedance/android/livesdk/link/model/g8;", "getRankInfo$annotations", "rankInfo", "Lcom/bytedance/android/livesdk/link/model/f8;", "getQualifyInfo", "()Lcom/bytedance/android/livesdk/link/model/f8;", "getQualifyInfo$annotations", "qualifyInfo", "Lcom/bytedance/android/livesdk/link/model/d9;", "getScoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d9;", "getScoreInfo$annotations", "scoreInfo", "", "getRuleSchema", "()Ljava/lang/String;", "getRuleSchema$annotations", "ruleSchema", "getRankSchema", "getRankSchema$annotations", "rankSchema", "getUnLockTxt", "getUnLockTxt$annotations", "unLockTxt", "", "getSeasonStatus", "()I", "getSeasonStatus$annotations", "seasonStatus", "getButtonText", "getButtonText$annotations", "buttonText", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBgImg", "()Lpy/k;", "getBgImg$annotations", "bgImg", "Lcom/bytedance/android/livesdk/link/model/h8;", "getButton", "()Lcom/bytedance/android/livesdk/link/model/h8;", "getButton$annotations", "button", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s8 extends vh7.c<s8> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_img")
    py.k getBgImg();

    @FieldName(name = "button")
    h8 getButton();

    @FieldName(name = "button_text")
    String getButtonText();

    @FieldName(name = "enable_season_tab")
    boolean getEnableTab();

    @FieldName(name = "qualify_info")
    f8 getQualifyInfo();

    @FieldName(name = "rank_info")
    g8 getRankInfo();

    @FieldName(name = "detail_scheme")
    String getRankSchema();

    @FieldName(name = "rule_scheme")
    String getRuleSchema();

    @FieldName(name = "score_info")
    d9 getScoreInfo();

    @FieldName(name = "season_status")
    int getSeasonStatus();

    @FieldName(name = "unlocked_content")
    String getUnLockTxt();

    @FieldName(name = "is_unlocked_rank")
    boolean isUnlockedRank();
}
