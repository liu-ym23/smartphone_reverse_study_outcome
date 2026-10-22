package com.bytedance.android.format.model.message;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\bR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001e\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveMsgSugResp;", "Ljava/io/Serializable;", "()V", "expireSeconds", "", "getExpireSeconds", "()I", "isForOpening", "", "()Z", RemoteMessageConst.MSGID, "", "getMsgId", "()Ljava/lang/String;", "multiContentSugs", "", "Lcom/bytedance/android/format/model/message/MultiContentSug;", "getMultiContentSugs", "()Ljava/util/List;", "setMultiContentSugs", "(Ljava/util/List;)V", "queryMsgId", "getQueryMsgId", "sugType", "getSugType", "setSugType", "(I)V", "sugs", "getSugs", "hasSug", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMsgSugResp implements Serializable {

    @SerializedName("expire_seconds")
    private final int expireSeconds;

    @SerializedName("is_for_opening")
    private final boolean isForOpening;

    @SerializedName("msg_id")
    private final String msgId;

    @SerializedName("multi_content_sugs")
    private List<MultiContentSug> multiContentSugs;

    @SerializedName("query_msg_id")
    private final String queryMsgId;

    @SerializedName("sug_type")
    private int sugType;

    @SerializedName("sugs")
    private final List<String> sugs;

    public final boolean hasSug() {
        List<String> r100 = this.sugs;
        if (r100 != null) goto L5;
    L6:
        List<MultiContentSug> r101 = this.multiContentSugs;
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if ((!r101.isEmpty()) != true) goto L11;
        return true;
    L5:
        if ((!r100.isEmpty()) != true) goto L6;
        return true;
    }

    public LiveMsgSugResp() {
        this.sugType = LiveMsgSugType.SugType_Invalid.getType();
        this.expireSeconds = -1;
    }

    public final int getExpireSeconds() {
        return this.expireSeconds;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final List<MultiContentSug> getMultiContentSugs() {
        return this.multiContentSugs;
    }

    public final String getQueryMsgId() {
        return this.queryMsgId;
    }

    public final int getSugType() {
        return this.sugType;
    }

    public final List<String> getSugs() {
        return this.sugs;
    }

    public final boolean isForOpening() {
        return this.isForOpening;
    }

    public final void setMultiContentSugs(List<MultiContentSug> r100) {
        this.multiContentSugs = r100;
    }

    public final void setSugType(int r100) {
        this.sugType = r100;
    }
}
