package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ActivityCouponInvalidMessage")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/OpenPlatformCouponInvalidMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "roomId", "Ljava/lang/String;", "", "invalidType", "I", "content", "<init>", "()V", "InvalidType", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformCouponInvalidMessage extends o0 implements vh7.h {

    @SerializedName("anchor_toast_content")
    public String content;

    @SerializedName("invalid_type")
    public int invalidType;

    @SerializedName("room_id")
    public String roomId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/OpenPlatformCouponInvalidMessage$InvalidType;", "", "", "value", "I", "getValue", "()I", "UnknownInvalidType", "CouponTemplateDeleted", "CouponTemplateExpired", "MountPrivilegeRevoked", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum InvalidType extends Enum<InvalidType> {
        public static final InvalidType CouponTemplateDeleted = null;
        public static final InvalidType CouponTemplateExpired = null;
        public static final InvalidType MountPrivilegeRevoked = null;
        public static final InvalidType UnknownInvalidType = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InvalidType[] f153607a = null;
        private final int value;

        static {
            InvalidType r100 = new InvalidType("UnknownInvalidType", 0, 0);
            UnknownInvalidType = r100;
            InvalidType r101 = new InvalidType("CouponTemplateDeleted", 1, 1);
            CouponTemplateDeleted = r101;
            InvalidType r102 = new InvalidType("CouponTemplateExpired", 2, 2);
            CouponTemplateExpired = r102;
            InvalidType r103 = new InvalidType("MountPrivilegeRevoked", 3, 3);
            MountPrivilegeRevoked = r103;
            f153607a = new InvalidType[]{r100, r101, r102, r103};
        }

        public static InvalidType valueOf(String r100) {
            return (InvalidType) r27.a.a(InvalidType.class, r100);
        }

        public static InvalidType[] values() {
            return (InvalidType[]) f153607a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public InvalidType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public OpenPlatformCouponInvalidMessage() {
        this.invalidType = InvalidType.UnknownInvalidType.getValue();
        this.type = MessageType.OPEN_PLATFORM_COUPON_INVALID_MESSAGE;
    }

    public OpenPlatformCouponInvalidMessage(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.roomId = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.invalidType = r100.i();
        r102 = r102 | true;
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.content = am3.h.c(r100);
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if ((r102 & true) == true) goto L20;
        this.invalidType = InvalidType.UnknownInvalidType.getValue();
    L20:
        this.type = MessageType.OPEN_PLATFORM_COUPON_INVALID_MESSAGE;
    }
}
