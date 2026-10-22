package com.bytedance.android.livesdk.chatroom.clearscreen;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/android/livesdk/chatroom/clearscreen/ClearScreenConst$GuideType", "", "Lcom/bytedance/android/livesdk/chatroom/clearscreen/ClearScreenConst$GuideType;", "", "id", "I", "getId", "()I", "SHOW_CLEAR", "CLEAR_MODE_CHECK", "ZOOM", "SHOW_CLICK_CLEAR", "SHOW_CLICK_CLEAR_ENTER_ROOM", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClearScreenConst$GuideType extends Enum<ClearScreenConst$GuideType> {
    public static final ClearScreenConst$GuideType CLEAR_MODE_CHECK = null;
    public static final ClearScreenConst$GuideType SHOW_CLEAR = null;
    public static final ClearScreenConst$GuideType SHOW_CLICK_CLEAR = null;
    public static final ClearScreenConst$GuideType SHOW_CLICK_CLEAR_ENTER_ROOM = null;
    public static final ClearScreenConst$GuideType ZOOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClearScreenConst$GuideType[] f105592a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f105593id;

    static {
        ClearScreenConst$GuideType r100 = new ClearScreenConst$GuideType("SHOW_CLEAR", 0, 0);
        SHOW_CLEAR = r100;
        ClearScreenConst$GuideType r101 = new ClearScreenConst$GuideType("CLEAR_MODE_CHECK", 1, 1);
        CLEAR_MODE_CHECK = r101;
        ClearScreenConst$GuideType r102 = new ClearScreenConst$GuideType("ZOOM", 2, 2);
        ZOOM = r102;
        ClearScreenConst$GuideType r103 = new ClearScreenConst$GuideType("SHOW_CLICK_CLEAR", 3, 3);
        SHOW_CLICK_CLEAR = r103;
        ClearScreenConst$GuideType r104 = new ClearScreenConst$GuideType("SHOW_CLICK_CLEAR_ENTER_ROOM", 4, 4);
        SHOW_CLICK_CLEAR_ENTER_ROOM = r104;
        f105592a = new ClearScreenConst$GuideType[]{r100, r101, r102, r103, r104};
    }

    public static ClearScreenConst$GuideType valueOf(String r100) {
        return (ClearScreenConst$GuideType) a.a(ClearScreenConst$GuideType.class, r100);
    }

    public static ClearScreenConst$GuideType[] values() {
        return (ClearScreenConst$GuideType[]) f105592a.clone();
    }

    public final int getId() {
        return this.f105593id;
    }

    public ClearScreenConst$GuideType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f105593id = r102;
    }
}
