package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.FlexImageModel;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ScreenChatMessage.Effect")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/b2;", "Lcom/bytedance/android/live/base/model/message/v;", "Lcom/bytedance/android/live/base/model/FlexImageModel;", "_gradeBackground", "Lcom/bytedance/android/live/base/model/FlexImageModel;", "get_gradeBackground", "()Lcom/bytedance/android/live/base/model/FlexImageModel;", "set_gradeBackground", "(Lcom/bytedance/android/live/base/model/FlexImageModel;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_avatarBorder", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_avatarBorder", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_avatarBorder", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "_backgroundColor", "Ljava/lang/String;", "get_backgroundColor", "()Ljava/lang/String;", "set_backgroundColor", "(Ljava/lang/String;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b2 implements com.bytedance.android.live.base.model.message.v, vh7.h {

    @SerializedName("avatar_icon")
    protected ImageModel _avatarBorder;

    @SerializedName("background_color")
    protected String _backgroundColor;

    @SerializedName("icon")
    protected FlexImageModel _gradeBackground;

    public b2() {
    }

    public b2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this._gradeBackground = com.bytedance.android.live.base.model.v.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._avatarBorder = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._backgroundColor = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    @Override // com.bytedance.android.live.base.model.message.v
    public final String getBackgroundColor() {
        return this._backgroundColor;
    }
}
