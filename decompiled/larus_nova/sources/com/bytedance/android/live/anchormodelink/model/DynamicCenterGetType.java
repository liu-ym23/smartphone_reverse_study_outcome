package com.bytedance.android.live.anchormodelink.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/model/DynamicCenterGetType;", "", UserProfileEvent.POSITION_NONE, "latestSEI", "liveLink", "common_get_data", "linkmic", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicCenterGetType extends Enum<DynamicCenterGetType> {
    public static final DynamicCenterGetType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DynamicCenterGetType[] f58787a = null;
    public static final DynamicCenterGetType common_get_data = null;
    public static final DynamicCenterGetType latestSEI = null;
    public static final DynamicCenterGetType linkmic = null;
    public static final DynamicCenterGetType liveLink = null;

    static {
        DynamicCenterGetType r100 = new DynamicCenterGetType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        DynamicCenterGetType r101 = new DynamicCenterGetType("latestSEI", 1);
        latestSEI = r101;
        DynamicCenterGetType r102 = new DynamicCenterGetType("liveLink", 2);
        liveLink = r102;
        DynamicCenterGetType r103 = new DynamicCenterGetType("common_get_data", 3);
        common_get_data = r103;
        DynamicCenterGetType r104 = new DynamicCenterGetType("linkmic", 4);
        linkmic = r104;
        f58787a = new DynamicCenterGetType[]{r100, r101, r102, r103, r104};
    }

    public static DynamicCenterGetType valueOf(String r100) {
        return (DynamicCenterGetType) a.a(DynamicCenterGetType.class, r100);
    }

    public static DynamicCenterGetType[] values() {
        return (DynamicCenterGetType[]) f58787a.clone();
    }

    public DynamicCenterGetType(String r100, int r101) {
        super(r100, r101);
    }
}
