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
@ProtoMessage("webcast.api.linkmic_audience.GetGuestBattleConfResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016R*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/GuestBattleConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/y;", "", "toString", "", "", "durationList", "Ljava/util/List;", "getDurationList", "()Ljava/util/List;", "setDurationList", "(Ljava/util/List;)V", "dressId", "Ljava/lang/String;", "getDressId", "()Ljava/lang/String;", "setDressId", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/c0;", "scoreInfoList", "getScoreInfoList", "setScoreInfoList", "", "recommendScoreType", "I", "getRecommendScoreType", "()I", "setRecommendScoreType", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuestBattleConfig extends FlexModelBase<y> implements y, vh7.h {

    @SerializedName("dress_id")
    protected String dressId;

    @SerializedName("duration_list")
    protected List<Long> durationList;

    @SerializedName("recommend_score_type")
    protected int recommendScoreType;

    @SerializedName("score_list")
    protected List<? extends c0> scoreInfoList;

    public GuestBattleConfig() {
        super(y.class);
    }

    public String toString() {
        return "GuestBattleConfig{durationList=" + getDurationList() + ", dressId='" + getDressId() + "', scoreInfoList=" + getScoreInfoList() + ", recommendScoreType=" + getRecommendScoreType() + '}';
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.y
    public String getDressId() {
        return this.dressId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.y
    public List<Long> getDurationList() {
        return this.durationList;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.y
    public int getRecommendScoreType() {
        return this.recommendScoreType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.y
    public List<c0> getScoreInfoList() {
        return this.scoreInfoList;
    }

    public GuestBattleConfig(am3.g r100) {
        super(y.class);
        this.durationList = new ArrayList();
        this.scoreInfoList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 == 1) goto L17;
        if (r102 != 2) goto L10;
        this.dressId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        List r104 = this.scoreInfoList;
        Object r105 = vh7.f.a(r100, c0.class);
    L18:
        r104.add(r105);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.recommendScoreType = (int) r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L17:
        r104 = this.durationList;
        r105 = Long.valueOf(r100.j());
        goto L18
    L19:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setDressId(String r100) {
        this.dressId = r100;
    }

    public void setDurationList(List<Long> r100) {
        this.durationList = r100;
    }

    public void setRecommendScoreType(int r100) {
        this.recommendScoreType = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.y
    public void setScoreInfoList(List<? extends c0> r100) {
        this.scoreInfoList = r100;
    }
}
