package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSNoMessageValueNode;", "", "", "valueNodeName", "Ljava/lang/String;", "getValueNodeName", "()Ljava/lang/String;", "MemberMessageCount", "RoomMessageCount", "ChatMessageCount", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSNoMessageValueNode extends Enum<PSNoMessageValueNode> {
    public static final PSNoMessageValueNode ChatMessageCount = null;
    public static final PSNoMessageValueNode MemberMessageCount = null;
    public static final PSNoMessageValueNode RoomMessageCount = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSNoMessageValueNode[] f133345a = null;
    private final String valueNodeName;

    static {
        PSNoMessageValueNode r100 = new PSNoMessageValueNode("MemberMessageCount", 0, "member_message_count");
        MemberMessageCount = r100;
        PSNoMessageValueNode r101 = new PSNoMessageValueNode("RoomMessageCount", 1, "room_message_count");
        RoomMessageCount = r101;
        PSNoMessageValueNode r102 = new PSNoMessageValueNode("ChatMessageCount", 2, "chat_message_count");
        ChatMessageCount = r102;
        f133345a = new PSNoMessageValueNode[]{r100, r101, r102};
    }

    public static PSNoMessageValueNode valueOf(String r100) {
        return (PSNoMessageValueNode) a.a(PSNoMessageValueNode.class, r100);
    }

    public static PSNoMessageValueNode[] values() {
        return (PSNoMessageValueNode[]) f133345a.clone();
    }

    public final String getValueNodeName() {
        return this.valueNodeName;
    }

    public PSNoMessageValueNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.valueNodeName = r102;
    }
}
