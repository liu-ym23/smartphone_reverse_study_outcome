package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRoomStatDescNode;", "", "", "descName", "Ljava/lang/String;", "getDescName", "()Ljava/lang/String;", "PublicScreenShowStatus", "PublicScreenReceiveFirstMessageType", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRoomStatDescNode extends Enum<PSRoomStatDescNode> {
    public static final PSRoomStatDescNode PublicScreenReceiveFirstMessageType = null;
    public static final PSRoomStatDescNode PublicScreenShowStatus = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSRoomStatDescNode[] f133351a = null;
    private final String descName;

    static {
        PSRoomStatDescNode r100 = new PSRoomStatDescNode("PublicScreenShowStatus", 0, "public_screen_show_status");
        PublicScreenShowStatus = r100;
        PSRoomStatDescNode r101 = new PSRoomStatDescNode("PublicScreenReceiveFirstMessageType", 1, "public_screen_first_message_type");
        PublicScreenReceiveFirstMessageType = r101;
        f133351a = new PSRoomStatDescNode[]{r100, r101};
    }

    public static PSRoomStatDescNode valueOf(String r100) {
        return (PSRoomStatDescNode) a.a(PSRoomStatDescNode.class, r100);
    }

    public static PSRoomStatDescNode[] values() {
        return (PSRoomStatDescNode[]) f133351a.clone();
    }

    public final String getDescName() {
        return this.descName;
    }

    public PSRoomStatDescNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.descName = r102;
    }
}
