package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_profit.GetPaidInfoBeforeApplyResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/PaidInfoResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/h1;", "", "numOfLink", "Ljava/lang/Long;", "getNumOfLink", "()Ljava/lang/Long;", "setNumOfLink", "(Ljava/lang/Long;)V", "", "avgGrade", "Ljava/lang/Float;", "getAvgGrade", "()Ljava/lang/Float;", "setAvgGrade", "(Ljava/lang/Float;)V", "paidCount", "getPaidCount", "setPaidCount", "limitedTime", "getLimitedTime", "setLimitedTime", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/PaidLinkmicTag;", "paidTags", "Ljava/util/List;", "getPaidTags", "()Ljava/util/List;", "setPaidTags", "(Ljava/util/List;)V", "", "paidDesc", "Ljava/lang/String;", "getPaidDesc", "()Ljava/lang/String;", "setPaidDesc", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidInfoResponse extends FlexModelBase<h1> implements h1, vh7.h {

    @SerializedName("avg_grade")
    protected Float avgGrade;

    @SerializedName("limited_time")
    protected Long limitedTime;

    @SerializedName("num_of_link")
    protected Long numOfLink;

    @SerializedName("paid_count")
    protected Long paidCount;

    @SerializedName("paid_desc")
    protected String paidDesc;

    @SerializedName("paid_tags")
    protected List<PaidLinkmicTag> paidTags;

    public PaidInfoResponse() {
        super(h1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.h1
    public Float getAvgGrade() {
        return this.avgGrade;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.h1
    public Long getLimitedTime() {
        return this.limitedTime;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.h1
    public Long getNumOfLink() {
        return this.numOfLink;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.h1
    public Long getPaidCount() {
        return this.paidCount;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.h1
    public String getPaidDesc() {
        return this.paidDesc;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.h1
    public List<PaidLinkmicTag> getPaidTags() {
        return this.paidTags;
    }

    public PaidInfoResponse(am3.g r100) {
        super(h1.class);
        this.paidTags = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.paidDesc = am3.h.c(r100);
        goto L3
    L9:
        this.paidTags.add(new PaidLinkmicTag(r100));
        goto L3
    L10:
        this.limitedTime = Long.valueOf(r100.j());
        goto L3
    L11:
        this.paidCount = Long.valueOf(r100.j());
        goto L3
    L12:
        this.avgGrade = Float.valueOf(Float.intBitsToFloat(r100.g()));
        goto L3
    L13:
        this.numOfLink = Long.valueOf(r100.j());
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setAvgGrade(Float r100) {
        this.avgGrade = r100;
    }

    public void setLimitedTime(Long r100) {
        this.limitedTime = r100;
    }

    public void setNumOfLink(Long r100) {
        this.numOfLink = r100;
    }

    public void setPaidCount(Long r100) {
        this.paidCount = r100;
    }

    public void setPaidDesc(String r100) {
        this.paidDesc = r100;
    }

    public void setPaidTags(List<PaidLinkmicTag> r100) {
        this.paidTags = r100;
    }
}
