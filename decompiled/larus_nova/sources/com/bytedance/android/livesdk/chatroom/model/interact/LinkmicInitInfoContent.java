package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/LinkmicInitInfoContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/u0;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/InitInfoSetting;", "videoChatInitInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/InitInfoSetting;", "getVideoChatInitInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/InitInfoSetting;", "setVideoChatInitInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/InitInfoSetting;)V", "audioChatInitInfo", "getAudioChatInitInfo", "setAudioChatInitInfo", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicInitInfoContent extends FlexModelBase<u0> implements u0, vh7.h {

    @SerializedName("audio_chat_init_info")
    protected InitInfoSetting audioChatInitInfo;

    @SerializedName("video_chat_init_info")
    protected InitInfoSetting videoChatInitInfo;

    public LinkmicInitInfoContent() {
        super(u0.class);
    }

    public LinkmicInitInfoContent(am3.g r100) {
        super(u0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.videoChatInitInfo = new InitInfoSetting(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.audioChatInitInfo = new InitInfoSetting(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.u0
    public /* bridge */ /* synthetic */ g0 getAudioChatInitInfo() {
        return getAudioChatInitInfo();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.u0
    public /* bridge */ /* synthetic */ g0 getVideoChatInitInfo() {
        return getVideoChatInitInfo();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.u0
    public InitInfoSetting getAudioChatInitInfo() {
        return this.audioChatInitInfo;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.u0
    public InitInfoSetting getVideoChatInitInfo() {
        return this.videoChatInitInfo;
    }

    public void setAudioChatInitInfo(InitInfoSetting r100) {
        this.audioChatInitInfo = r100;
    }

    public void setVideoChatInitInfo(InitInfoSetting r100) {
        this.videoChatInitInfo = r100;
    }
}
