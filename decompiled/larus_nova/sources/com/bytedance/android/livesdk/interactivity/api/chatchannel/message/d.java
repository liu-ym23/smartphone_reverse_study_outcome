package com.bytedance.android.livesdk.interactivity.api.chatchannel.message;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.im.RoomChannelChatMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/d;", "Ly32/a;", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "getUser", "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/message/Text;", "rtfContentV2", "Lcom/bytedance/android/livesdkapi/message/Text;", "G", "()Lcom/bytedance/android/livesdkapi/message/Text;", "P", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", "", "needShowIdentity", "I", "getNeedShowIdentity", "()I", FaceService.neutralLabel, "(I)V", "", "isMention", "Z", "()Z", "setMention", "(Z)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d extends y32.a implements vh7.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f132923b;

    @SerializedName("content")
    protected String content;

    @SerializedName("mention")
    protected boolean isMention;

    @SerializedName("show_identity")
    protected int needShowIdentity;

    @SerializedName("rtf_content_v2")
    protected Text rtfContentV2;

    @SerializedName("user")
    protected User user;

    public d() {
    }

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.RoomChannelChat;
    }

    public final Text G() {
        return this.rtfContentV2;
    }

    public final String getContent() {
        return this.content;
    }

    public final User getUser() {
        return this.user;
    }

    public d(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.user = new User(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.content = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.needShowIdentity = r100.i();
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.isMention = am3.h.a(r100);
        goto L3
    L16:
        if (r102 != 7) goto L17;
        this.rtfContentV2 = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
    }

    public final void H(int r100) {
        this.needShowIdentity = r100;
    }

    public final void P(Text r100) {
        this.rtfContentV2 = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setUser(User r100) {
        this.user = r100;
    }
}
