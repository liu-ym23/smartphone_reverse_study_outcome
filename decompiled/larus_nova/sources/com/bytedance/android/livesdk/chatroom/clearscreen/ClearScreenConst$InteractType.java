package com.bytedance.android.livesdk.chatroom.clearscreen;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"com/bytedance/android/livesdk/chatroom/clearscreen/ClearScreenConst$InteractType", "", "Lcom/bytedance/android/livesdk/chatroom/clearscreen/ClearScreenConst$InteractType;", "", "id", "I", "getId", "()I", "", "canShowClearLayer", "Z", "getCanShowClearLayer", "()Z", "INTERACT_SHOW", "ORIGIN_CLEAR", "PURE_CLEAR", "SIMPLE_CLEAR", "VR_MODE", "FEEDBACK", "MERGE_DRAWER", "PINCH_CLEAR", "AUDIENCE_PS_CONFIG_DIALOG_SHOW", "IMAGE_RECOGNITION_DIALOG_SHOW", "SCROLL_CLEAR", "GAME_PANEL_CLEAR", "ZOOM_MODE_CLEAR", "FOCUS_MODE_CLEAR", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClearScreenConst$InteractType extends Enum<ClearScreenConst$InteractType> {
    public static final ClearScreenConst$InteractType AUDIENCE_PS_CONFIG_DIALOG_SHOW = null;
    public static final ClearScreenConst$InteractType FEEDBACK = null;
    public static final ClearScreenConst$InteractType FOCUS_MODE_CLEAR = null;
    public static final ClearScreenConst$InteractType GAME_PANEL_CLEAR = null;
    public static final ClearScreenConst$InteractType IMAGE_RECOGNITION_DIALOG_SHOW = null;
    public static final ClearScreenConst$InteractType INTERACT_SHOW = null;
    public static final ClearScreenConst$InteractType MERGE_DRAWER = null;
    public static final ClearScreenConst$InteractType ORIGIN_CLEAR = null;
    public static final ClearScreenConst$InteractType PINCH_CLEAR = null;
    public static final ClearScreenConst$InteractType PURE_CLEAR = null;
    public static final ClearScreenConst$InteractType SCROLL_CLEAR = null;
    public static final ClearScreenConst$InteractType SIMPLE_CLEAR = null;
    public static final ClearScreenConst$InteractType VR_MODE = null;
    public static final ClearScreenConst$InteractType ZOOM_MODE_CLEAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClearScreenConst$InteractType[] f105594a = null;
    private final boolean canShowClearLayer;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f105595id;

    public static ClearScreenConst$InteractType valueOf(String r100) {
        return (ClearScreenConst$InteractType) a.a(ClearScreenConst$InteractType.class, r100);
    }

    public static ClearScreenConst$InteractType[] values() {
        return (ClearScreenConst$InteractType[]) f105594a.clone();
    }

    static {
        ClearScreenConst$InteractType r100 = new ClearScreenConst$InteractType("INTERACT_SHOW", 0, 0, false);
        INTERACT_SHOW = r100;
        ClearScreenConst$InteractType r101 = new ClearScreenConst$InteractType("ORIGIN_CLEAR", 1, 1, true);
        ORIGIN_CLEAR = r101;
        ClearScreenConst$InteractType r102 = new ClearScreenConst$InteractType("PURE_CLEAR", 2, 2, true);
        PURE_CLEAR = r102;
        ClearScreenConst$InteractType r103 = new ClearScreenConst$InteractType("SIMPLE_CLEAR", 3, 3, true);
        SIMPLE_CLEAR = r103;
        ClearScreenConst$InteractType r104 = new ClearScreenConst$InteractType("VR_MODE", 4, 4, false);
        VR_MODE = r104;
        ClearScreenConst$InteractType r105 = new ClearScreenConst$InteractType("FEEDBACK", 5, 5, false);
        FEEDBACK = r105;
        ClearScreenConst$InteractType r106 = new ClearScreenConst$InteractType("MERGE_DRAWER", 6, 6, false);
        MERGE_DRAWER = r106;
        ClearScreenConst$InteractType r107 = new ClearScreenConst$InteractType("PINCH_CLEAR", 7, 7, true);
        PINCH_CLEAR = r107;
        ClearScreenConst$InteractType r108 = new ClearScreenConst$InteractType("AUDIENCE_PS_CONFIG_DIALOG_SHOW", 8, 8, false);
        AUDIENCE_PS_CONFIG_DIALOG_SHOW = r108;
        ClearScreenConst$InteractType r109 = new ClearScreenConst$InteractType("IMAGE_RECOGNITION_DIALOG_SHOW", 9, 9, false);
        IMAGE_RECOGNITION_DIALOG_SHOW = r109;
        ClearScreenConst$InteractType r110 = new ClearScreenConst$InteractType("SCROLL_CLEAR", 10, 10, false);
        SCROLL_CLEAR = r110;
        ClearScreenConst$InteractType r111 = new ClearScreenConst$InteractType("GAME_PANEL_CLEAR", 11, 11, false);
        GAME_PANEL_CLEAR = r111;
        ClearScreenConst$InteractType r112 = new ClearScreenConst$InteractType("ZOOM_MODE_CLEAR", 12, 12, false);
        ZOOM_MODE_CLEAR = r112;
        ClearScreenConst$InteractType r113 = new ClearScreenConst$InteractType("FOCUS_MODE_CLEAR", 13, 13, true);
        FOCUS_MODE_CLEAR = r113;
        f105594a = new ClearScreenConst$InteractType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113};
    }

    public final boolean getCanShowClearLayer() {
        return this.canShowClearLayer;
    }

    public final int getId() {
        return this.f105595id;
    }

    public ClearScreenConst$InteractType(String r100, int r101, int r102, boolean r103) {
        super(r100, r101);
        this.f105595id = r102;
        this.canShowClearLayer = r103;
    }
}
