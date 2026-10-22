package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CommonTextMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/l3;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/l0;", "Lcom/bytedance/android/live/base/model/user/User;", "_user", "Lcom/bytedance/android/live/base/model/user/User;", "get_user", "()Lcom/bytedance/android/live/base/model/user/User;", "set_user", "(Lcom/bytedance/android/live/base/model/user/User;)V", "", "_scene", "Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/String;", "set_scene", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "_publicAreaCommon", "Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "get_publicAreaCommon", "()Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "set_publicAreaCommon", "(Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l3 extends o0 implements com.bytedance.android.live.base.model.message.l0, vh7.h {

    @SerializedName("public_area_common")
    protected PublicAreaCommon _publicAreaCommon;

    @SerializedName("scene")
    protected String _scene;

    @SerializedName("user")
    protected User _user;

    @Override // com.bytedance.android.live.base.model.message.u3
    public final IPublicAreaCommon getOrInitPublicAreaCommon() {
        if (this._publicAreaCommon != null) goto L6;
        this._publicAreaCommon = new PublicAreaCommon();
    L6:
        return this._publicAreaCommon;
    }

    public l3() {
        this.type = MessageType.COMMON_TEXT;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean canText() {
        CommonMessageData r100 = getBaseMessage();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.supportDisplayText() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        CommonMessageData r100 = getBaseMessage();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.supportDisplayText() != true) goto L7;
        return true;
    }

    public final String E() {
        return this._scene;
    }

    @Override // com.bytedance.android.live.base.model.message.l0
    public final IBaseUser getUser() {
        return this._user;
    }

    @Override // com.bytedance.android.live.base.model.message.u3
    public final IBaseUser getUserInMessage() {
        return this._user;
    }

    public l3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._user = new User(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._scene = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._publicAreaCommon = new PublicAreaCommon(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.COMMON_TEXT;
    }
}
