package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRealtimeValueNode;", "", "", "valueNodeName", "Ljava/lang/String;", "getValueNodeName", "()Ljava/lang/String;", "MsgCount", "EnqueueCount", "ShowCount", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRealtimeValueNode extends Enum<PSRealtimeValueNode> {
    public static final PSRealtimeValueNode EnqueueCount = null;
    public static final PSRealtimeValueNode MsgCount = null;
    public static final PSRealtimeValueNode ShowCount = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSRealtimeValueNode[] f133348a = null;
    private final String valueNodeName;

    static {
        PSRealtimeValueNode r100 = new PSRealtimeValueNode("MsgCount", 0, "period_msg_count");
        MsgCount = r100;
        PSRealtimeValueNode r101 = new PSRealtimeValueNode("EnqueueCount", 1, "period_enqueue_count");
        EnqueueCount = r101;
        PSRealtimeValueNode r102 = new PSRealtimeValueNode("ShowCount", 2, "period_show_count");
        ShowCount = r102;
        f133348a = new PSRealtimeValueNode[]{r100, r101, r102};
    }

    public static PSRealtimeValueNode valueOf(String r100) {
        return (PSRealtimeValueNode) a.a(PSRealtimeValueNode.class, r100);
    }

    public static PSRealtimeValueNode[] values() {
        return (PSRealtimeValueNode[]) f133348a.clone();
    }

    public final String getValueNodeName() {
        return this.valueNodeName;
    }

    public PSRealtimeValueNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.valueNodeName = r102;
    }
}
