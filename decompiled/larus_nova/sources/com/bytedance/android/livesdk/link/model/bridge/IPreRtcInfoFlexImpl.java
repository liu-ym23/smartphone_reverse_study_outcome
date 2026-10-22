package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.PreRTCInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R)\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000e\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/IPreRtcInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "", "", "Lcom/bytedance/android/livesdk/link/model/bridge/IPreRTCLinkUserInfoFlexImpl;", "preRtcUserInfo$delegate", "Ljava/lang/Object;", "getPreRtcUserInfo", "()Ljava/util/Map;", "preRtcUserInfo", "version$delegate", "getVersion", "()J", "version", "", "rtcJoinChannel$delegate", "getRtcJoinChannel", "()Z", "rtcJoinChannel", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPreRtcInfoFlexImpl extends FlexModelBase<b2> implements b2, vh7.h {

    @SerializedName("pre_rtc_user_info")
    protected Map<Long, IPreRTCLinkUserInfoFlexImpl> _$$preRtcUserInfo;

    @SerializedName("rtc_join_channel")
    protected boolean _$$rtcJoinChannel;

    @SerializedName("version")
    protected long _$$version;

    public IPreRtcInfoFlexImpl() {
        super(b2.class);
        this._$$rtcJoinChannel = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.b2
    public final Map<Long, IPreRTCLinkUserInfoFlexImpl> getPreRtcUserInfo() {
        return this._$$preRtcUserInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.b2
    public final boolean getRtcJoinChannel() {
        return this._$$rtcJoinChannel;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.b2
    public final long getVersion() {
        return this._$$version;
    }

    public IPreRtcInfoFlexImpl(am3.g r110) {
        super(b2.class);
        this._$$preRtcUserInfo = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
        int r101 = 0;
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L30;
        am3.g.a r103 = decodeExtensionFields(r102, r110);
        if (r102 != 1) goto L8;
        long r104 = r110.c();
        Long r105 = null;
        IPreRTCLinkUserInfoFlexImpl r111 = null;
    L15:
        int r112 = r110.f();
        if (r112 == (-1)) goto L22;
        if (r112 != 1) goto L18;
        r105 = Long.valueOf(r110.j());
        goto L15
    L18:
        if (r112 != 2) goto L19;
        r111 = new IPreRTCLinkUserInfoFlexImpl(r110);
        goto L15
    L19:
        am3.h.e(r110);
        goto L15
    L22:
        r110.d(r104);
        Map<Long, IPreRTCLinkUserInfoFlexImpl> r106 = this._$$preRtcUserInfo;
        if (r105 == null) goto L29;
        if (r111 == null) goto L27;
        r106.put(r105, r111);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L8:
        if (r102 != 3) goto L10;
        this._$$version = r110.j();
        r101 = r101 | 1;
        goto L3
    L10:
        if (r102 != 4) goto L11;
        this._$$rtcJoinChannel = am3.h.a(r110);
        r101 = r101 | 2;
        goto L3
    L11:
        am3.h.d(r103, r110);
        goto L3
    L30:
        r110.d(r100);
        setThreadSafe(true);
        if ((r101 & 2) != 0) goto L57;
        this._$$rtcJoinChannel = false;
        return;
    }
}
