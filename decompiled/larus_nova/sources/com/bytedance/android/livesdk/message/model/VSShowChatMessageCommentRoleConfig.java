package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CommentRoleConfig")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/VSShowChatMessageCommentRoleConfig;", "Lcom/bytedance/android/live/base/model/message/r5;", "", "getCharactorName", "Lpy/k;", "characterAvatar", "", "setCharacterAvatar", "Lcom/bytedance/android/live/base/model/ImageModel;", "getCharactorAvatar", "name", "setCharacterName", "", "getId", "id", "setId", "_charactorName", "Ljava/lang/String;", "get_charactorName", "()Ljava/lang/String;", "set_charactorName", "(Ljava/lang/String;)V", "_charactorAvatar", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_charactorAvatar", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_charactorAvatar", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_roleId", "J", "get_roleId", "()J", "set_roleId", "(J)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSShowChatMessageCommentRoleConfig implements com.bytedance.android.live.base.model.message.r5, vh7.h {

    @SerializedName("avatar")
    protected ImageModel _charactorAvatar;

    @SerializedName("name")
    protected String _charactorName;
    private long _roleId;

    public VSShowChatMessageCommentRoleConfig() {
    }

    public VSShowChatMessageCommentRoleConfig(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this._charactorName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._charactorAvatar = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    @Override // com.bytedance.android.live.base.model.message.r5
    public /* bridge */ /* synthetic */ py.k getCharactorAvatar() {
        return getCharactorAvatar();
    }

    @Override // com.bytedance.android.live.base.model.message.r5
    public String getCharactorName() {
        return this._charactorName;
    }

    public long getId() {
        return this._roleId;
    }

    public final ImageModel get_charactorAvatar() {
        return this._charactorAvatar;
    }

    public final String get_charactorName() {
        return this._charactorName;
    }

    public final long get_roleId() {
        return this._roleId;
    }

    @Override // com.bytedance.android.live.base.model.message.r5
    public ImageModel getCharactorAvatar() {
        return this._charactorAvatar;
    }

    @Override // com.bytedance.android.live.base.model.message.r5
    public void setCharacterAvatar(py.k r100) {
        if ((r100 instanceof ImageModel) == true) goto L5;
        r100 = null;
    L5:
        this._charactorAvatar = (ImageModel) r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r5
    public void setCharacterName(String r100) {
        this._charactorName = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.r5
    public void setId(long r100) {
        this._roleId = r100;
    }

    public final void set_charactorAvatar(ImageModel r100) {
        this._charactorAvatar = r100;
    }

    public final void set_charactorName(String r100) {
        this._charactorName = r100;
    }

    public final void set_roleId(long r100) {
        this._roleId = r100;
    }
}
