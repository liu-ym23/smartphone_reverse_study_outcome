package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/CPositionToEnlargePosition;", "", "", "value", "J", "getValue", "()J", "Default", "Left", "Right", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CPositionToEnlargePosition extends Enum<CPositionToEnlargePosition> {
    public static final CPositionToEnlargePosition Default = null;
    public static final CPositionToEnlargePosition Left = null;
    public static final CPositionToEnlargePosition Right = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CPositionToEnlargePosition[] f72164a = null;
    private final long value;

    static {
        CPositionToEnlargePosition r100 = new CPositionToEnlargePosition("Default", 0, 0);
        Default = r100;
        CPositionToEnlargePosition r101 = new CPositionToEnlargePosition("Left", 1, 0);
        Left = r101;
        CPositionToEnlargePosition r102 = new CPositionToEnlargePosition("Right", 2, 1);
        Right = r102;
        f72164a = new CPositionToEnlargePosition[]{r100, r101, r102};
    }

    public static CPositionToEnlargePosition valueOf(String r100) {
        return (CPositionToEnlargePosition) r27.a.a(CPositionToEnlargePosition.class, r100);
    }

    public static CPositionToEnlargePosition[] values() {
        return (CPositionToEnlargePosition[]) f72164a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public CPositionToEnlargePosition(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
