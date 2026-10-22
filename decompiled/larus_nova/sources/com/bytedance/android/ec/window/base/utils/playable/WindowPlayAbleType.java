package com.bytedance.android.ec.window.base.utils.playable;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/window/base/utils/playable/WindowPlayAbleType;", "", FlowDoraWifiScene.OTHER, "VIDEO", "MAIN_IMAGE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowPlayAbleType extends Enum<WindowPlayAbleType> {
    public static final WindowPlayAbleType MAIN_IMAGE = null;
    public static final WindowPlayAbleType OTHER = null;
    public static final WindowPlayAbleType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowPlayAbleType[] f49731a = null;

    static {
        WindowPlayAbleType r100 = new WindowPlayAbleType(FlowDoraWifiScene.OTHER, 0);
        OTHER = r100;
        WindowPlayAbleType r101 = new WindowPlayAbleType("VIDEO", 1);
        VIDEO = r101;
        WindowPlayAbleType r102 = new WindowPlayAbleType("MAIN_IMAGE", 2);
        MAIN_IMAGE = r102;
        f49731a = new WindowPlayAbleType[]{r100, r101, r102};
    }

    public static WindowPlayAbleType valueOf(String r100) {
        return (WindowPlayAbleType) a.a(WindowPlayAbleType.class, r100);
    }

    public static WindowPlayAbleType[] values() {
        return (WindowPlayAbleType[]) f49731a.clone();
    }

    public WindowPlayAbleType(String r100, int r101) {
        super(r100, r101);
    }
}
