package com.bytedance.android.livesdkapi.room.handler.viewinterface;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/ExternalViewGroupAction;", "", "(Ljava/lang/String;I)V", "Add", "Remove", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExternalViewGroupAction extends Enum<ExternalViewGroupAction> {
    private static final /* synthetic */ ExternalViewGroupAction[] $VALUES = null;
    public static final ExternalViewGroupAction Add = null;
    public static final ExternalViewGroupAction Remove = null;

    static {
        ExternalViewGroupAction r100 = new ExternalViewGroupAction("Add", 0);
        Add = r100;
        ExternalViewGroupAction r101 = new ExternalViewGroupAction("Remove", 1);
        Remove = r101;
        $VALUES = new ExternalViewGroupAction[]{r100, r101};
    }

    public static ExternalViewGroupAction valueOf(String r100) {
        return (ExternalViewGroupAction) a.a(ExternalViewGroupAction.class, r100);
    }

    public static ExternalViewGroupAction[] values() {
        return (ExternalViewGroupAction[]) $VALUES.clone();
    }

    private ExternalViewGroupAction(String r100, int r101) {
        super(r100, r101);
    }
}
