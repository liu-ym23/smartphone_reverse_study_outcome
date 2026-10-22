package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.UserPrivilegeChangeMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/UserPrivilegeChangeMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "userPrivilegeType", "I", FaceService.neutralLabel, "()I", "setUserPrivilegeType", "(I)V", "", "userId", "J", "", "userOpenId", "Ljava/lang/String;", "getUserOpenId", "()Ljava/lang/String;", "setUserOpenId", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "avatarBorder", "Lcom/bytedance/android/live/base/model/ImageModel;", ExifInterface.LONGITUDE_EAST, "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatarBorder", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "thumbAvatarBorder", "G", "setThumbAvatarBorder", "<init>", "()V", "UserPrivilegeType", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserPrivilegeChangeMessage extends o0 implements vh7.h {

    @SerializedName("avatar_border")
    protected ImageModel avatarBorder;

    @SerializedName("thumb_avatar_border")
    protected ImageModel thumbAvatarBorder;

    @SerializedName("user_id")
    protected long userId;

    @SerializedName("user_open_id")
    protected String userOpenId;

    @SerializedName("user_privilege_type")
    protected int userPrivilegeType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/UserPrivilegeChangeMessage$UserPrivilegeType;", "", "", "value", "I", "getValue", "()I", "Unknown", "AvatarBorder", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum UserPrivilegeType extends Enum<UserPrivilegeType> {
        public static final UserPrivilegeType AvatarBorder = null;
        public static final UserPrivilegeType Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UserPrivilegeType[] f153622a = null;
        private final int value;

        static {
            UserPrivilegeType r100 = new UserPrivilegeType("Unknown", 0, 0);
            Unknown = r100;
            UserPrivilegeType r101 = new UserPrivilegeType("AvatarBorder", 1, 1);
            AvatarBorder = r101;
            f153622a = new UserPrivilegeType[]{r100, r101};
        }

        public static UserPrivilegeType valueOf(String r100) {
            return (UserPrivilegeType) r27.a.a(UserPrivilegeType.class, r100);
        }

        public static UserPrivilegeType[] values() {
            return (UserPrivilegeType[]) f153622a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public UserPrivilegeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public final String getUserIdStr() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.userId);
        String r102 = this.userOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public UserPrivilegeChangeMessage() {
        setType(MessageType.USER_PRIVILEGE_CHANGE);
    }

    public final ImageModel E() {
        return this.avatarBorder;
    }

    public final ImageModel G() {
        return this.thumbAvatarBorder;
    }

    public final int H() {
        return this.userPrivilegeType;
    }

    public UserPrivilegeChangeMessage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.userPrivilegeType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.userId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.avatarBorder = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.thumbAvatarBorder = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this.userOpenId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        setType(MessageType.USER_PRIVILEGE_CHANGE);
    }
}
