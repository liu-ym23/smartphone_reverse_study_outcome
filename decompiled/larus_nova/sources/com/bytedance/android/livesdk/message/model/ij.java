package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RedPacket")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001e¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ij;", "", "", "mRedPacketId", "J", "getMRedPacketId", "()J", "setMRedPacketId", "(J)V", "mBonusType", "getMBonusType", "setMBonusType", "mComboCount", "getMComboCount", "setMComboCount", "mBonusCount", "getMBonusCount", "setMBonusCount", "mCountDown", "getMCountDown", "setMCountDown", "mRushTime", "getMRushTime", "setMRushTime", "", "mIconUrl", "Ljava/lang/String;", "getMIconUrl", "()Ljava/lang/String;", "setMIconUrl", "(Ljava/lang/String;)V", "mDisappearTime", "getMDisappearTime", "setMDisappearTime", "Lcom/bytedance/android/livesdk/message/model/ij$a;", "mFromUser", "Lcom/bytedance/android/livesdk/message/model/ij$a;", "getMFromUser", "()Lcom/bytedance/android/livesdk/message/model/ij$a;", "setMFromUser", "(Lcom/bytedance/android/livesdk/message/model/ij$a;)V", "mTotalCountDown", "getMTotalCountDown", "setMTotalCountDown", "mSourceGiftName", "getMSourceGiftName", "setMSourceGiftName", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ij implements vh7.h {

    @SerializedName("bonus_count")
    protected long mBonusCount;

    @SerializedName("bonus_type")
    protected long mBonusType;

    @SerializedName("combo_count")
    protected long mComboCount;

    @SerializedName("count_down")
    protected long mCountDown;

    @SerializedName("disappear_time")
    protected long mDisappearTime;

    @SerializedName("owner")
    protected a mFromUser;

    @SerializedName("icon_url")
    protected String mIconUrl;

    @SerializedName("red_packet_group_id")
    protected long mRedPacketId;

    @SerializedName("rush_time")
    protected long mRushTime;

    @SerializedName("red_packet_source")
    protected String mSourceGiftName;

    @SerializedName("total_count_down")
    protected long mTotalCountDown;

    @ProtoMessage("webcast.data.User")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ij$a;", "", "", "mJsonUserId", "J", "getMJsonUserId", "()J", "setMJsonUserId", "(J)V", "", "userOpenId", "Ljava/lang/String;", "getUserOpenId", "()Ljava/lang/String;", "setUserOpenId", "(Ljava/lang/String;)V", "mJsonName", "getMJsonName", "setMJsonName", "mAvatarUrl", "getMAvatarUrl", "setMAvatarUrl", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("avatar_url")
        @IgnoreProtoDecode
        private String mAvatarUrl;

        @SerializedName("name")
        @IgnoreProtoDecode
        private String mJsonName;

        @SerializedName("user_id")
        @IgnoreProtoDecode
        private long mJsonUserId;

        @SerializedName("user_open_id")
        protected String userOpenId;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            r100.j();
            goto L3
        L8:
            if (r102 != 3) goto L10;
            am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 9) goto L12;
            com.bytedance.android.live.base.model.x.a(r100);
            goto L3
        L12:
            if (r102 != 5000) goto L13;
            this.userOpenId = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }
    }

    public ij() {
    }

    public ij(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this.mSourceGiftName = am3.h.c(r100);
        goto L3
    L8:
        this.mTotalCountDown = r100.j();
        goto L3
    L9:
        this.mFromUser = new a(r100);
        goto L3
    L10:
        this.mDisappearTime = r100.j();
        goto L3
    L11:
        this.mIconUrl = am3.h.c(r100);
        goto L3
    L12:
        this.mRushTime = r100.j();
        goto L3
    L13:
        this.mCountDown = r100.j();
        goto L3
    L14:
        this.mBonusCount = r100.j();
        goto L3
    L15:
        this.mComboCount = r100.j();
        goto L3
    L16:
        this.mBonusType = r100.j();
        goto L3
    L17:
        this.mRedPacketId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
