package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRoomStatConstantNode;", "", "", "nodeName", "Ljava/lang/String;", "getNodeName", "()Ljava/lang/String;", "FirstMessageShowDelay", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRoomStatConstantNode extends Enum<PSRoomStatConstantNode> {
    public static final PSRoomStatConstantNode FirstMessageShowDelay = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSRoomStatConstantNode[] f133350a = null;
    private final String nodeName;

    static {
        PSRoomStatConstantNode r100 = new PSRoomStatConstantNode();
        FirstMessageShowDelay = r100;
        f133350a = new PSRoomStatConstantNode[]{r100};
    }

    public static PSRoomStatConstantNode valueOf(String r100) {
        return (PSRoomStatConstantNode) a.a(PSRoomStatConstantNode.class, r100);
    }

    public static PSRoomStatConstantNode[] values() {
        return (PSRoomStatConstantNode[]) f133350a.clone();
    }

    public PSRoomStatConstantNode() {
        super("FirstMessageShowDelay", 0);
        this.nodeName = "first_message_show_delay";
    }

    public final String getNodeName() {
        return this.nodeName;
    }
}
