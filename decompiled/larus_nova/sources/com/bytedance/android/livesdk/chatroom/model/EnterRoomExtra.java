package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.EnterRoomResponse.EnterRoomExtra")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0018R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0018¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/EnterRoomExtra;", "Lcom/bytedance/android/live/base/model/Extra;", "", "isVSType", "", "diggColor", "I", "", "payScores", "J", "Lcom/bytedance/android/livesdk/message/model/MemberMessage;", "memberMessage", "Lcom/bytedance/android/livesdk/message/model/MemberMessage;", "isOfficialChannel", "Z", "Lcom/bytedance/android/livesdk/chatroom/model/ConnectPage;", "mConnectPage", "Lcom/bytedance/android/livesdk/chatroom/model/ConnectPage;", "getMConnectPage", "()Lcom/bytedance/android/livesdk/chatroom/model/ConnectPage;", "setMConnectPage", "(Lcom/bytedance/android/livesdk/chatroom/model/ConnectPage;)V", "", "cityName", "Ljava/lang/String;", "vsType", "getVsType", "()Ljava/lang/String;", "setVsType", "(Ljava/lang/String;)V", "errorMsg", "getErrorMsg", "setErrorMsg", "unableRetry", "rSignature", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterRoomExtra extends Extra implements vh7.h {
    public static final a Companion = null;
    public static final String VS_TYPE_LIVE = "live";
    public static final String VS_TYPE_PREMIERE = "premiere";

    @SerializedName("city_name")
    public String cityName;

    @SerializedName("digg_color")
    public int diggColor;

    @IgnoreProtoFieldCheck
    private String errorMsg;

    @SerializedName("is_official_channel")
    public boolean isOfficialChannel;

    @SerializedName("connect_page")
    protected ConnectPage mConnectPage;

    @SerializedName("enter_msg")
    public MemberMessage memberMessage;

    @SerializedName("pay_scores")
    public long payScores;

    @IgnoreProtoFieldCheck
    @SerializedName("signature")
    public String rSignature;

    @IgnoreProtoFieldCheck
    @SerializedName("unable_retry")
    public String unableRetry;

    @IgnoreProtoFieldCheck
    @SerializedName("vs_type")
    private String vsType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isVSType() {
        String r100 = this.vsType;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.vsType, "live") == false) goto L13;
    L14:
        return true;
    L13:
        if (Intrinsics.areEqual(this.vsType, VS_TYPE_PREMIERE) == true) goto L14;
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public EnterRoomExtra() {
        this.payScores = -1;
        this.cityName = "";
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final ConnectPage getMConnectPage() {
        return this.mConnectPage;
    }

    public final String getVsType() {
        return this.vsType;
    }

    public EnterRoomExtra(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L6;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.cityName = am3.h.c(r100);
        goto L3
    L8:
        this.rSignature = am3.h.c(r100);
        goto L3
    L9:
        this.mConnectPage = new ConnectPage(r100);
        goto L3
    L10:
        this.isOfficialChannel = am3.h.a(r100);
        goto L3
    L11:
        this.memberMessage = new MemberMessage(r100);
        goto L3
    L12:
        this.payScores = r100.j();
        r102 = r102 | true;
        goto L3
    L13:
        this.diggColor = (int) r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & true) == true) goto L18;
        this.payScores = -1;
    L18:
        if (this.cityName != null) goto L39;
        this.cityName = "";
        return;
    }

    public final void setErrorMsg(String r100) {
        this.errorMsg = r100;
    }

    public final void setMConnectPage(ConnectPage r100) {
        this.mConnectPage = r100;
    }

    public final void setVsType(String r100) {
        this.vsType = r100;
    }
}
