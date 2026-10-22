package com.bytedance.android.ec.model.response.anchorv3;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/ProductLeaderBoardEntryStruct;", "Ljava/io/Serializable;", "()V", "bgIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBgIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "content", "", "getContent", "()Ljava/lang/String;", "icon", "getIcon", "isShowProductLeaderBoard", "", "()Z", "setShowProductLeaderBoard", "(Z)V", "rank", "", "getRank", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "rankIcon", "getRankIcon", "rankId", "getRankId", "rankStyle", "getRankStyle", "schema", "getSchema", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ProductLeaderBoardEntryStruct implements Serializable {

    @SerializedName("bg_icon")
    private final ECUrlModel bgIcon;

    @SerializedName("name")
    private final String content;

    @SerializedName("icon")
    private final ECUrlModel icon;
    private boolean isShowProductLeaderBoard;

    @SerializedName("rank")
    private final Integer rank;

    @SerializedName("rank_icon")
    private final ECUrlModel rankIcon;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RANK_ID)
    private final String rankId;

    @SerializedName("rank_style")
    private final Integer rankStyle;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private final String schema;

    public ProductLeaderBoardEntryStruct() {
        this.isShowProductLeaderBoard = true;
    }

    public final ECUrlModel getBgIcon() {
        return this.bgIcon;
    }

    public final String getContent() {
        return this.content;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final Integer getRank() {
        return this.rank;
    }

    public final ECUrlModel getRankIcon() {
        return this.rankIcon;
    }

    public final String getRankId() {
        return this.rankId;
    }

    public final Integer getRankStyle() {
        return this.rankStyle;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final boolean isShowProductLeaderBoard() {
        return this.isShowProductLeaderBoard;
    }

    public final void setShowProductLeaderBoard(boolean r100) {
        this.isShowProductLeaderBoard = r100;
    }
}
