package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.RivalExtraInfo.LinkerInfo.UserInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkedUserInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/t5;", "Lpy/k;", "avatarThumb", "Lpy/k;", "getAvatarThumb", "()Lpy/k;", "setAvatarThumb", "(Lpy/k;)V", "", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "userId", "nickName$delegate", "getNickName", "nickName", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkedUserInfoFlexImpl extends FlexModelBase<t5> implements t5, vh7.h {

    @SerializedName("nick_name")
    protected String _$$nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String _$$userId;

    @SerializedName("avatar_thumb")
    protected py.k avatarThumb;

    public ILinkedUserInfoFlexImpl() {
        super(t5.class);
        this._$$userId = "";
        this._$$nickName = "";
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public ILinkedUserInfoFlexImpl(am3.g r100) {
        super(t5.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 2) goto L8;
        this._$$nickName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.avatarThumb = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        this._$$userId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$userId != null) goto L19;
        this._$$userId = "";
    L19:
        if (this._$$nickName != null) goto L34;
        this._$$nickName = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.t5
    public py.k getAvatarThumb() {
        return this.avatarThumb;
    }

    @Override // com.bytedance.android.livesdk.link.model.t5
    public final String getNickName() {
        return this._$$nickName;
    }

    @Override // com.bytedance.android.livesdk.link.model.t5
    public final String getUserId() {
        return this._$$userId;
    }

    public void setAvatarThumb(py.k r100) {
        this.avatarThumb = r100;
    }
}
