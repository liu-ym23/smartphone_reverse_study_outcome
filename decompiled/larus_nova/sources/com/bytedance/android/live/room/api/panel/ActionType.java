package com.bytedance.android.live.room.api.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/api/panel/ActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "Open", "Close", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType Close = null;
    public static final ActionType Open = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f99040a = null;
    private final String type;

    static {
        ActionType r100 = new ActionType("Open", 0, "Open");
        Open = r100;
        ActionType r101 = new ActionType("Close", 1, "Close");
        Close = r101;
        f99040a = new ActionType[]{r100, r101};
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) r27.a.a(ActionType.class, r100);
    }

    public static ActionType[] values() {
        return (ActionType[]) f99040a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public ActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
