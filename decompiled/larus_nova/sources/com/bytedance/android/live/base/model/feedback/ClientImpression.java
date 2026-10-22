package com.bytedance.android.live.base.model.feedback;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.FeedbackCard.ClientImpression")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/ClientImpression;", "", "()V", "ignoreCounts", "", "Ljava/lang/Long;", "ignoreInterval", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClientImpression implements h {

    @IgnoreProtoFieldCheck
    @SerializedName("ignore_submit_counts")
    public Long ignoreCounts;

    @IgnoreProtoFieldCheck
    @SerializedName("ignore_submit_show_interval")
    public Long ignoreInterval;

    public ClientImpression() {
    }

    public ClientImpression(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.ignoreCounts = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.ignoreInterval = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
