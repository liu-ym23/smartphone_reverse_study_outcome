package com.bytedance.android.livesdk.interactivity.api.degrade.model;

import com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/DegradeFeature;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "TAP_LIKE", "FLOW_LIKE", "LIKE", "HOT_COMMENT_TRAY", "ENTER_ANIM", "COMMENT_CARNIVAL", "PUBLIC_SCREEN", "PORARAIT_DANMAKU", "ENTER_ROOM_DURATION", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DegradeFeature extends Enum<DegradeFeature> {
    public static final DegradeFeature COMMENT_CARNIVAL = null;
    public static final DegradeFeature ENTER_ANIM = null;
    public static final DegradeFeature ENTER_ROOM_DURATION = null;
    public static final DegradeFeature FLOW_LIKE = null;
    public static final DegradeFeature HOT_COMMENT_TRAY = null;
    public static final DegradeFeature LIKE = null;
    public static final DegradeFeature PORARAIT_DANMAKU = null;
    public static final DegradeFeature PUBLIC_SCREEN = null;
    public static final DegradeFeature TAP_LIKE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DegradeFeature[] f133099a = null;
    private final String scene;

    public static DegradeFeature valueOf(String r100) {
        return (DegradeFeature) a.a(DegradeFeature.class, r100);
    }

    public static DegradeFeature[] values() {
        return (DegradeFeature[]) f133099a.clone();
    }

    static {
        DegradeFeature r100 = new DegradeFeature("TAP_LIKE", 0, "tap_like");
        TAP_LIKE = r100;
        DegradeFeature r101 = new DegradeFeature("FLOW_LIKE", 1, "flow_like");
        FLOW_LIKE = r101;
        DegradeFeature r102 = new DegradeFeature("LIKE", 2, IStrategyStateSupplier.KEY_INFO_LIKE);
        LIKE = r102;
        DegradeFeature r103 = new DegradeFeature("HOT_COMMENT_TRAY", 3, "hot_comment_tray");
        HOT_COMMENT_TRAY = r103;
        DegradeFeature r104 = new DegradeFeature("ENTER_ANIM", 4, "flow_screen_message");
        ENTER_ANIM = r104;
        DegradeFeature r105 = new DegradeFeature("COMMENT_CARNIVAL", 5, "comment_carnival");
        COMMENT_CARNIVAL = r105;
        DegradeFeature r106 = new DegradeFeature("PUBLIC_SCREEN", 6, "public_screen");
        PUBLIC_SCREEN = r106;
        DegradeFeature r107 = new DegradeFeature("PORARAIT_DANMAKU", 7, "portrait_danmaku");
        PORARAIT_DANMAKU = r107;
        DegradeFeature r108 = new DegradeFeature("ENTER_ROOM_DURATION", 8, "enter_room_duration");
        ENTER_ROOM_DURATION = r108;
        f133099a = new DegradeFeature[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getScene() {
        return this.scene;
    }

    public DegradeFeature(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
