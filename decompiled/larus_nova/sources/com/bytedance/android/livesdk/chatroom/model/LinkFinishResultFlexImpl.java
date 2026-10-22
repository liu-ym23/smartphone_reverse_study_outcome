package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.FinishResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkFinishResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/LinkFinishResult;", "", "<set-?>", "totalApplyNum$delegate", "Ljava/lang/Object;", "getTotalApplyNum", "()J", "setTotalApplyNum", "(J)V", "totalApplyNum", "totalLinkedNum$delegate", "getTotalLinkedNum", "setTotalLinkedNum", "totalLinkedNum", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkFinishResultFlexImpl extends FlexModelBase<LinkFinishResult> implements LinkFinishResult, vh7.h {

    @SerializedName("total_apply")
    protected long _$$totalApplyNum;

    @SerializedName("total_linked")
    protected long _$$totalLinkedNum;

    public LinkFinishResultFlexImpl() {
        super(LinkFinishResult.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkFinishResult
    public final long getTotalApplyNum() {
        return this._$$totalApplyNum;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkFinishResult
    public final long getTotalLinkedNum() {
        return this._$$totalLinkedNum;
    }

    public LinkFinishResultFlexImpl(am3.g r100) {
        super(LinkFinishResult.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$totalApplyNum = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$totalLinkedNum = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkFinishResult
    public final void setTotalApplyNum(long r100) {
        this._$$totalApplyNum = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkFinishResult
    public final void setTotalLinkedNum(long r100) {
        this._$$totalLinkedNum = r100;
    }
}
