package com.bytedance.android.live.base.model.banner;

import am3.g;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.feed.RankRoundBanner")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/banner/c;", "", "", "flipInterval", "I", "getFlipInterval", "()I", "setFlipInterval", "(I)V", "", "Lcom/bytedance/android/live/base/model/live/c;", "rankList", "Ljava/util/List;", "getRankList", "()Ljava/util/List;", "setRankList", "(Ljava/util/List;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("change_time")
    protected int flipInterval;

    @SerializedName(PbRequest.SwitchType.RANK_LIST)
    protected List<com.bytedance.android.live.base.model.live.c> rankList;

    public c() {
    }

    public c(g r100) {
        this.rankList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.rankList.add(new com.bytedance.android.live.base.model.live.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.flipInterval = (int) r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
