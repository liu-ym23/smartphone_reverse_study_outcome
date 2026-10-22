package com.bytedance.android.livesdkapi.depend.model.live.pay;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
public class SubscribeMemberMark extends FlexModelBase<ISubscribeMemberMark> implements ISubscribeMemberMark {

    @SerializedName("subscribe_member_watch_free")
    public boolean subscribeMemberFree;

    public SubscribeMemberMark() {
        super(ISubscribeMemberMark.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.pay.ISubscribeMemberMark
    public boolean getSubscribeMemberFree() {
        return this.subscribeMemberFree;
    }
}
