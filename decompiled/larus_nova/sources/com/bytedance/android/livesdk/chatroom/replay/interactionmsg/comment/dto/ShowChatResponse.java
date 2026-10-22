package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.dto;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.p1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.episode.CommentMedal;
import com.bytedance.android.livesdkapi.depend.model.live.episode._CommentMedal_ProtoDecoder;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.g;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bO\u0010PJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N¨\u0006Q"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/comment/dto/ShowChatResponse;", "", "", "convertShowCommentEffectType", "id", "J", "getId", "()J", "setId", "(J)V", RemoteMessageConst.MSGID, "getMsgId", "setMsgId", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "Lpy/k;", "background", "Lpy/k;", "getBackground", "()Lpy/k;", "setBackground", "(Lpy/k;)V", "fullScreenTextColor", "getFullScreenTextColor", "setFullScreenTextColor", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "", "colorValueForDamu", "Ljava/util/List;", "getColorValueForDamu", "()Ljava/util/List;", "setColorValueForDamu", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/base/model/message/p1;", "landscapeAreaCommon", "Lcom/bytedance/android/live/base/model/message/p1;", "getLandscapeAreaCommon", "()Lcom/bytedance/android/live/base/model/message/p1;", "setLandscapeAreaCommon", "(Lcom/bytedance/android/live/base/model/message/p1;)V", "Lpy/g;", "commentRoleConfig", "Lpy/g;", "getCommentRoleConfig", "()Lpy/g;", "setCommentRoleConfig", "(Lpy/g;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/CommentMedal;", "medal", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/CommentMedal;", "getMedal", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/CommentMedal;", "setMedal", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/CommentMedal;)V", "", "effectType", "I", "getEffectType", "()I", "setEffectType", "(I)V", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowChatResponse implements h {

    @SerializedName("background_image")
    protected k background;

    @SerializedName("color_value")
    protected List<String> colorValueForDamu;

    @SerializedName("comment_role")
    protected g commentRoleConfig;

    @SerializedName("content")
    protected String content;

    @SerializedName("display_text")
    protected a5 displayText;

    @SerializedName("effect_type")
    protected int effectType;

    @SerializedName("fullscreen_text_color")
    protected String fullScreenTextColor;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f108874id;

    @SerializedName("landscape_area_common")
    protected p1 landscapeAreaCommon;

    @SerializedName("medal")
    protected CommentMedal medal;

    @SerializedName("msg_id")
    protected long msgId;

    @SerializedName("user")
    protected IBaseUser user;

    public ShowChatResponse() {
    }

    public final long convertShowCommentEffectType() {
        return ReplayMsgShowCommentEffectType.TYPE_NOT_SET.value;
    }

    public final k getBackground() {
        return this.background;
    }

    public final List<String> getColorValueForDamu() {
        return this.colorValueForDamu;
    }

    public final g getCommentRoleConfig() {
        return this.commentRoleConfig;
    }

    public final String getContent() {
        return this.content;
    }

    public final a5 getDisplayText() {
        return this.displayText;
    }

    public final int getEffectType() {
        return this.effectType;
    }

    public final String getFullScreenTextColor() {
        return this.fullScreenTextColor;
    }

    public final long getId() {
        return this.f108874id;
    }

    public final p1 getLandscapeAreaCommon() {
        return this.landscapeAreaCommon;
    }

    public final CommentMedal getMedal() {
        return this.medal;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final IBaseUser getUser() {
        return this.user;
    }

    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.live.base.model.message.p1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, py.g] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public ShowChatResponse(am3.g r100) {
        this.colorValueForDamu = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L6;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L6;
            case 14: goto L7;
            default: goto L6;
        };
    L7:
        this.effectType = r100.i();
        goto L3
    L8:
        this.medal = _CommentMedal_ProtoDecoder.decodeStatic(r100);
        goto L3
    L9:
        this.commentRoleConfig = f.a(r100, g.class);
        goto L3
    L10:
        this.landscapeAreaCommon = f.a(r100, p1.class);
        goto L3
    L11:
        this.colorValueForDamu.add(am3.h.c(r100));
        goto L3
    L12:
        this.fullScreenTextColor = am3.h.c(r100);
        goto L3
    L13:
        this.background = f.a(r100, k.class);
        goto L3
    L14:
        this.user = f.a(r100, IBaseUser.class);
        goto L3
    L15:
        this.displayText = f.a(r100, a5.class);
        goto L3
    L16:
        this.content = am3.h.c(r100);
        goto L3
    L17:
        this.msgId = r100.j();
        goto L3
    L18:
        this.f108874id = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r101);
    }

    public final void setBackground(k r100) {
        this.background = r100;
    }

    public final void setColorValueForDamu(List<String> r100) {
        this.colorValueForDamu = r100;
    }

    public final void setCommentRoleConfig(g r100) {
        this.commentRoleConfig = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setDisplayText(a5 r100) {
        this.displayText = r100;
    }

    public final void setEffectType(int r100) {
        this.effectType = r100;
    }

    public final void setFullScreenTextColor(String r100) {
        this.fullScreenTextColor = r100;
    }

    public final void setId(long r100) {
        this.f108874id = r100;
    }

    public final void setLandscapeAreaCommon(p1 r100) {
        this.landscapeAreaCommon = r100;
    }

    public final void setMedal(CommentMedal r100) {
        this.medal = r100;
    }

    public final void setMsgId(long r100) {
        this.msgId = r100;
    }

    public final void setUser(IBaseUser r100) {
        this.user = r100;
    }
}
