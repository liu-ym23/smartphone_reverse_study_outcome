package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIMInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomIMInfo;", "()V", "hideGiftMessage", "", "getHideGiftMessage", "()Ljava/lang/String;", "setHideGiftMessage", "(Ljava/lang/String;)V", "roomTag", "getRoomTag", "setRoomTag", "welcomeMessage", "", "getWelcomeMessage", "()Ljava/util/List;", "setWelcomeMessage", "(Ljava/util/List;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomIMInfo extends FlexModelBase<IRoomIMInfo> implements IRoomIMInfo, h {

    @SerializedName("hide_gift_message")
    protected String hideGiftMessage;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG)
    protected String roomTag;

    @SerializedName("welcome_messages")
    protected List<String> welcomeMessage;

    public RoomIMInfo() {
        super(IRoomIMInfo.class);
    }

    public RoomIMInfo(g r100) {
        super(IRoomIMInfo.class);
        this.welcomeMessage = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.welcomeMessage.add(am3.h.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.roomTag = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.hideGiftMessage = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomIMInfo
    public String getHideGiftMessage() {
        return this.hideGiftMessage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomIMInfo
    public String getRoomTag() {
        return this.roomTag;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomIMInfo
    public List<String> getWelcomeMessage() {
        return this.welcomeMessage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomIMInfo
    public void setHideGiftMessage(String r100) {
        this.hideGiftMessage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomIMInfo
    public void setRoomTag(String r100) {
        this.roomTag = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomIMInfo
    public void setWelcomeMessage(List<String> r100) {
        this.welcomeMessage = r100;
    }
}
