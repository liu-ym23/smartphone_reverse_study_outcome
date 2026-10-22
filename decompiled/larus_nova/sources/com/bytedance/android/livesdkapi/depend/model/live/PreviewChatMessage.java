package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.ChatMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewChatMessage;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewChatMessage;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "nickName", "getNickName", "setNickName", "nickNameColor", "getNickNameColor", "setNickNameColor", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewChatMessage extends FlexModelBase<IPreviewChatMessage> implements IPreviewChatMessage, h {

    @SerializedName("content")
    protected String content;

    @SerializedName("nick_name")
    protected String nickName;

    @SerializedName("nick_name_color")
    protected String nickNameColor;

    public PreviewChatMessage() {
        super(IPreviewChatMessage.class);
    }

    public PreviewChatMessage(g r100) {
        super(IPreviewChatMessage.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.nickName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.nickNameColor = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.content = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewChatMessage
    public String getContent() {
        return this.content;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewChatMessage
    public String getNickName() {
        return this.nickName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewChatMessage
    public String getNickNameColor() {
        return this.nickNameColor;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setNickName(String r100) {
        this.nickName = r100;
    }

    public void setNickNameColor(String r100) {
        this.nickNameColor = r100;
    }
}
