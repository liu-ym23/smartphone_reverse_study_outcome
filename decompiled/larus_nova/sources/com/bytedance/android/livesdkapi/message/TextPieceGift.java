package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.p3;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TextPieceGift extends FlexModelBase<e5> implements e5 {

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    long giftId;

    @SerializedName("name_ref")
    PatternRef nameRef;

    public TextPieceGift() {
        super(e5.class);
    }

    @Override // com.bytedance.android.live.base.model.message.e5
    public /* bridge */ /* synthetic */ p3 getNameRef() {
        return getNameRef();
    }

    @Override // com.bytedance.android.live.base.model.message.e5
    public long getGiftId() {
        return this.giftId;
    }

    @Override // com.bytedance.android.live.base.model.message.e5
    public PatternRef getNameRef() {
        return this.nameRef;
    }

    public void setGiftId(long r100) {
        this.giftId = r100;
    }

    public void setNameRef(PatternRef r100) {
        this.nameRef = r100;
    }
}
