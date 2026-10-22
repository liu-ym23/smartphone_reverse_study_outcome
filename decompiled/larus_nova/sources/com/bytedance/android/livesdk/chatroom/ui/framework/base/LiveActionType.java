package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/LiveActionType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CLICK", "DRAW", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveActionType extends Enum<LiveActionType> {
    public static final LiveActionType CLICK = null;
    public static final LiveActionType DRAW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveActionType[] f112888a = null;
    private final String value;

    static {
        LiveActionType r100 = new LiveActionType("CLICK", 0, "click");
        CLICK = r100;
        LiveActionType r101 = new LiveActionType("DRAW", 1, "draw");
        DRAW = r101;
        f112888a = new LiveActionType[]{r100, r101};
    }

    public static LiveActionType valueOf(String r100) {
        return (LiveActionType) r27.a.a(LiveActionType.class, r100);
    }

    public static LiveActionType[] values() {
        return (LiveActionType[]) f112888a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public LiveActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
