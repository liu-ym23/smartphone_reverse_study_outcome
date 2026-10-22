package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.media.MediaScene;
import com.ss.android.lark.camera_export.CameraParam;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSMessageType;", "", "", "msgType", "Ljava/lang/String;", "getMsgType", "()Ljava/lang/String;", "CHAT", "GIFT", MediaScene.SYSTEM, FlowDoraWifiScene.OTHER, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSMessageType extends Enum<PSMessageType> {
    public static final PSMessageType CHAT = null;
    public static final PSMessageType GIFT = null;
    public static final PSMessageType OTHER = null;
    public static final PSMessageType SYSTEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSMessageType[] f133344a = null;
    private final String msgType;

    static {
        PSMessageType r100 = new PSMessageType("CHAT", 0, "chat");
        CHAT = r100;
        PSMessageType r101 = new PSMessageType("GIFT", 1, PbRequest.SwitchType.GIFT);
        GIFT = r101;
        PSMessageType r102 = new PSMessageType(MediaScene.SYSTEM, 2, CameraParam.TYPE_SYSTEM_CAMERA);
        SYSTEM = r102;
        PSMessageType r103 = new PSMessageType(FlowDoraWifiScene.OTHER, 3, "other");
        OTHER = r103;
        f133344a = new PSMessageType[]{r100, r101, r102, r103};
    }

    public static PSMessageType valueOf(String r100) {
        return (PSMessageType) a.a(PSMessageType.class, r100);
    }

    public static PSMessageType[] values() {
        return (PSMessageType[]) f133344a.clone();
    }

    public final String getMsgType() {
        return this.msgType;
    }

    public PSMessageType(String r100, int r101, String r102) {
        super(r100, r101);
        this.msgType = r102;
    }
}
