package com.bytedance.android.live.base.model.feedback;

import am3.g;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.FeedbackCard.Condition")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0016\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/Condition;", "", "", "toString", "", "fromTime", "Ljava/lang/Long;", "toTime", "", "actionIds", "Ljava/util/List;", ReportConstant.COMMON_ACTION_TYPE, "previewTime", "J", "pcuLowerThreshold", "Lcom/bytedance/android/live/base/model/feedback/ClientImpression;", "clientImpression", "Lcom/bytedance/android/live/base/model/feedback/ClientImpression;", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Condition implements h {

    @SerializedName("action_ids")
    public List<Long> actionIds;

    @SerializedName("action_type")
    public Long actionType;

    @IgnoreProtoFieldCheck
    @SerializedName("client_impression")
    public ClientImpression clientImpression;

    @SerializedName("from_time")
    public Long fromTime;

    @IgnoreProtoFieldCheck
    @SerializedName("pcu_lower_threshold")
    public long pcuLowerThreshold;

    @IgnoreProtoFieldCheck
    @SerializedName("preview_time")
    public long previewTime;

    @SerializedName("to_time")
    public Long toTime;

    public Condition() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("{fromTime:");
        r100.append(this.fromTime);
        r100.append(",toTime:");
        r100.append(this.toTime);
        r100.append(",actionIds:");
        List<Long> r101 = this.actionIds;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append(",actionType:");
        r100.append(this.actionType);
        r100.append(i.f25855d);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public Condition(g r100) {
        this.actionIds = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.clientImpression = new ClientImpression(r100);
        goto L3
    L8:
        this.pcuLowerThreshold = r100.j();
        goto L3
    L9:
        this.previewTime = r100.j();
        goto L3
    L10:
        this.actionType = Long.valueOf(r100.j());
        goto L3
    L11:
        this.actionIds.add(Long.valueOf(r100.j()));
        goto L3
    L12:
        this.toTime = Long.valueOf(r100.j());
        goto L3
    L13:
        this.fromTime = Long.valueOf(r100.j());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }
}
