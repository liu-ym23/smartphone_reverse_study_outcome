package com.bytedance.android.livesdk.link.model.bridge;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.UserVersionInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/bridge/IUserVersionInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "", "clientVersion$delegate", "Ljava/lang/Object;", "getClientVersion", "()J", "clientVersion", "webcastVersion$delegate", "getWebcastVersion", "webcastVersion", "appId$delegate", "getAppId", "appId", "", "devicePlatform$delegate", "getDevicePlatform", "()Ljava/lang/String;", "devicePlatform", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IUserVersionInfoFlexImpl extends FlexModelBase<k2> implements k2, vh7.h {

    @SerializedName("app_id")
    protected long _$$appId;

    @SerializedName("client_version")
    protected long _$$clientVersion;

    @SerializedName("device_platform")
    protected String _$$devicePlatform;

    @SerializedName("webcast_version")
    protected long _$$webcastVersion;

    public IUserVersionInfoFlexImpl() {
        super(k2.class);
        this._$$devicePlatform = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k2
    public final long getAppId() {
        return this._$$appId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k2
    public final long getClientVersion() {
        return this._$$clientVersion;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k2
    public final String getDevicePlatform() {
        return this._$$devicePlatform;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.k2
    public final long getWebcastVersion() {
        return this._$$webcastVersion;
    }

    public IUserVersionInfoFlexImpl(am3.g r100) {
        super(k2.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$clientVersion = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$webcastVersion = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$appId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$devicePlatform = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$devicePlatform != null) goto L37;
        this._$$devicePlatform = "";
        return;
    }
}
