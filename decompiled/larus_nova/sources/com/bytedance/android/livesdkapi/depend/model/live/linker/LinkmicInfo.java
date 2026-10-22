package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkmicInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010'\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001a¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkmicInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkMicInfo;", "()V", "isJoinable", "", "()Z", "setJoinable", "(Z)V", "mAccessKey", "", "getMAccessKey", "()Ljava/lang/String;", "setMAccessKey", "(Ljava/lang/String;)V", "mAppId", "getMAppId", "setMAppId", "mAppSign", "getMAppSign", "setMAppSign", "mConfluenceType", "", "getMConfluenceType", "()I", "setMConfluenceType", "(I)V", "mInteractId", "", "getMInteractId", "()J", "setMInteractId", "(J)V", "mInteractIdStr", "getMInteractIdStr", "setMInteractIdStr", "mRtcInfo", "getMRtcInfo", "setMRtcInfo", "mVendor", "getMVendor", "setMVendor", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkmicInfo extends FlexModelBase<ILinkMicInfo> implements ILinkMicInfo, h {

    @SerializedName("joinable")
    protected boolean isJoinable;

    @SerializedName("access_key")
    protected String mAccessKey;

    @SerializedName("rtc_app_id")
    protected String mAppId;

    @SerializedName("rtc_app_sign")
    protected String mAppSign;

    @SerializedName("confluence_type")
    protected int mConfluenceType;

    @SerializedName("link_mic_id")
    protected long mInteractId;

    @SerializedName("linkmic_id_str")
    protected String mInteractIdStr;

    @SerializedName("rtc_ext_info")
    protected String mRtcInfo;

    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    protected int mVendor;

    public LinkmicInfo() {
        super(ILinkMicInfo.class);
    }

    public final String getMAccessKey() {
        return this.mAccessKey;
    }

    public final String getMAppId() {
        return this.mAppId;
    }

    public final String getMAppSign() {
        return this.mAppSign;
    }

    public final int getMConfluenceType() {
        return this.mConfluenceType;
    }

    public final long getMInteractId() {
        return this.mInteractId;
    }

    public final String getMInteractIdStr() {
        return this.mInteractIdStr;
    }

    public final String getMRtcInfo() {
        return this.mRtcInfo;
    }

    public final int getMVendor() {
        return this.mVendor;
    }

    public final boolean isJoinable() {
        return this.isJoinable;
    }

    public LinkmicInfo(g r100) {
        super(ILinkMicInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this.mVendor = (int) r100.j();
        goto L3
    L9:
        this.mInteractIdStr = am3.h.c(r100);
        goto L3
    L10:
        this.mAppSign = am3.h.c(r100);
        goto L3
    L11:
        this.mAppId = am3.h.c(r100);
        goto L3
    L12:
        this.mRtcInfo = am3.h.c(r100);
        goto L3
    L13:
        this.mConfluenceType = r100.i();
        goto L3
    L14:
        this.isJoinable = am3.h.a(r100);
        goto L3
    L15:
        this.mInteractId = r100.j();
        goto L3
    L16:
        this.mAccessKey = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L17:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setJoinable(boolean r100) {
        this.isJoinable = r100;
    }

    public final void setMAccessKey(String r100) {
        this.mAccessKey = r100;
    }

    public final void setMAppId(String r100) {
        this.mAppId = r100;
    }

    public final void setMAppSign(String r100) {
        this.mAppSign = r100;
    }

    public final void setMConfluenceType(int r100) {
        this.mConfluenceType = r100;
    }

    public final void setMInteractId(long r100) {
        this.mInteractId = r100;
    }

    public final void setMInteractIdStr(String r100) {
        this.mInteractIdStr = r100;
    }

    public final void setMRtcInfo(String r100) {
        this.mRtcInfo = r100;
    }

    public final void setMVendor(int r100) {
        this.mVendor = r100;
    }
}
