package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.model.live.ICrossRoomRTCInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CrossRoomRTCInfoContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/CrossRoomRTCInfoContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ICrossRoomRTCInfoContent;", "()V", "multiChannelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "setMultiChannelInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;)V", "otherMultiChannelInfo", "getOtherMultiChannelInfo", "setOtherMultiChannelInfo", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CrossRoomRTCInfoContent extends FlexModelBase<ICrossRoomRTCInfoContent> implements ICrossRoomRTCInfoContent, vh7.h {

    @SerializedName("multi_channel_info")
    protected MultiChannelInfo multiChannelInfo;

    @SerializedName("other_multi_channel_info")
    protected MultiChannelInfo otherMultiChannelInfo;

    public CrossRoomRTCInfoContent() {
        super(ICrossRoomRTCInfoContent.class);
    }

    public CrossRoomRTCInfoContent(am3.g r100) {
        super(ICrossRoomRTCInfoContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.multiChannelInfo = new MultiChannelInfo(r100);
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.otherMultiChannelInfo = new MultiChannelInfo(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final MultiChannelInfo getMultiChannelInfo() {
        return this.multiChannelInfo;
    }

    public final MultiChannelInfo getOtherMultiChannelInfo() {
        return this.otherMultiChannelInfo;
    }

    public final void setMultiChannelInfo(MultiChannelInfo r100) {
        this.multiChannelInfo = r100;
    }

    public final void setOtherMultiChannelInfo(MultiChannelInfo r100) {
        this.otherMultiChannelInfo = r100;
    }
}
