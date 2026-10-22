package com.bytedance.android.livesdk.rank.setting.participate.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.ranklist.GetRankListsStatusResponse.ResponseData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/rank/setting/participate/model/ParticipateSettingModel;", "", "()V", "description", "", "statusList", "", "Lcom/bytedance/android/livesdk/rank/setting/participate/model/ParticipateStatusModel;", "title", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParticipateSettingModel implements h {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String description;

    @SerializedName("ranks")
    public List<ParticipateStatusModel> statusList;

    @SerializedName("title")
    public String title;

    public ParticipateSettingModel() {
        this.title = "";
        this.description = "";
    }

    public ParticipateSettingModel(g r100) {
        this.statusList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.statusList.add(new ParticipateStatusModel(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.title = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.description = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.title != null) goto L19;
        this.title = "";
    L19:
        if (this.description != null) goto L34;
        this.description = "";
        return;
    }
}
