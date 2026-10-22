package com.bytedance.android.livesdk.schema;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/schema/MultiLinkOpenPanelType;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "INVITE_PANEL", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MultiLinkOpenPanelType extends Enum<MultiLinkOpenPanelType> {
    private static final /* synthetic */ MultiLinkOpenPanelType[] $VALUES = null;
    public static final MultiLinkOpenPanelType INVITE_PANEL = null;
    public static final MultiLinkOpenPanelType UNKNOWN = null;

    static {
        MultiLinkOpenPanelType r100 = new MultiLinkOpenPanelType("UNKNOWN", 0);
        UNKNOWN = r100;
        MultiLinkOpenPanelType r101 = new MultiLinkOpenPanelType("INVITE_PANEL", 1);
        INVITE_PANEL = r101;
        $VALUES = new MultiLinkOpenPanelType[]{r100, r101};
    }

    public static MultiLinkOpenPanelType valueOf(String r100) {
        return (MultiLinkOpenPanelType) r27.a.a(MultiLinkOpenPanelType.class, r100);
    }

    public static MultiLinkOpenPanelType[] values() {
        return (MultiLinkOpenPanelType[]) $VALUES.clone();
    }

    private MultiLinkOpenPanelType(String r100, int r101) {
        super(r100, r101);
    }
}
