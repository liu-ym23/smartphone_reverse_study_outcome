package com.bytedance.android.live.liveinteract.plantform.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/monitor/MultiLinkEventType;", "", "", "getName", "mName", "Ljava/lang/String;", "getMName", "()Ljava/lang/String;", "BUSSINESS_API_CALL", "SERVER_API_CALL", "MESSAGE_RECEIVED", "SDK_INTERFACE_CALL", "SDK_CALLBACK", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkEventType extends Enum<MultiLinkEventType> {
    public static final MultiLinkEventType BUSSINESS_API_CALL = null;
    public static final MultiLinkEventType MESSAGE_RECEIVED = null;
    public static final MultiLinkEventType SDK_CALLBACK = null;
    public static final MultiLinkEventType SDK_INTERFACE_CALL = null;
    public static final MultiLinkEventType SERVER_API_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkEventType[] f77262a = null;
    private final String mName;

    static {
        MultiLinkEventType r100 = new MultiLinkEventType("BUSSINESS_API_CALL", 0, "bussiness_api_call");
        BUSSINESS_API_CALL = r100;
        MultiLinkEventType r101 = new MultiLinkEventType("SERVER_API_CALL", 1, "server_api_call");
        SERVER_API_CALL = r101;
        MultiLinkEventType r102 = new MultiLinkEventType("MESSAGE_RECEIVED", 2, "message_received");
        MESSAGE_RECEIVED = r102;
        MultiLinkEventType r103 = new MultiLinkEventType("SDK_INTERFACE_CALL", 3, "sdk_interface_call");
        SDK_INTERFACE_CALL = r103;
        MultiLinkEventType r104 = new MultiLinkEventType("SDK_CALLBACK", 4, "sdk_callback");
        SDK_CALLBACK = r104;
        f77262a = new MultiLinkEventType[]{r100, r101, r102, r103, r104};
    }

    public static MultiLinkEventType valueOf(String r100) {
        return (MultiLinkEventType) a.a(MultiLinkEventType.class, r100);
    }

    public static MultiLinkEventType[] values() {
        return (MultiLinkEventType[]) f77262a.clone();
    }

    public final String getMName() {
        return this.mName;
    }

    public final String getName() {
        return this.mName;
    }

    public MultiLinkEventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mName = r102;
    }
}
