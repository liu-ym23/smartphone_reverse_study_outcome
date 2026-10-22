package com.bytedance.android.livesdkapi.distribution;

import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/EXTERNAL_CONFIG_TYPE;", "", "(Ljava/lang/String;I)V", "LivePage", LinkConstant.SWITCH_LAYOUT_ORIENTATION_CHANGE, "Gesture", "Guide", "LongPressPanel", "Component", "Service", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EXTERNAL_CONFIG_TYPE extends Enum<EXTERNAL_CONFIG_TYPE> {
    private static final /* synthetic */ EXTERNAL_CONFIG_TYPE[] $VALUES = null;
    public static final EXTERNAL_CONFIG_TYPE Component = null;
    public static final EXTERNAL_CONFIG_TYPE Gesture = null;
    public static final EXTERNAL_CONFIG_TYPE Guide = null;
    public static final EXTERNAL_CONFIG_TYPE LivePage = null;
    public static final EXTERNAL_CONFIG_TYPE LongPressPanel = null;
    public static final EXTERNAL_CONFIG_TYPE OrientationChange = null;
    public static final EXTERNAL_CONFIG_TYPE Service = null;

    static {
        EXTERNAL_CONFIG_TYPE r100 = new EXTERNAL_CONFIG_TYPE("LivePage", 0);
        LivePage = r100;
        EXTERNAL_CONFIG_TYPE r101 = new EXTERNAL_CONFIG_TYPE(LinkConstant.SWITCH_LAYOUT_ORIENTATION_CHANGE, 1);
        OrientationChange = r101;
        EXTERNAL_CONFIG_TYPE r102 = new EXTERNAL_CONFIG_TYPE("Gesture", 2);
        Gesture = r102;
        EXTERNAL_CONFIG_TYPE r103 = new EXTERNAL_CONFIG_TYPE("Guide", 3);
        Guide = r103;
        EXTERNAL_CONFIG_TYPE r104 = new EXTERNAL_CONFIG_TYPE("LongPressPanel", 4);
        LongPressPanel = r104;
        EXTERNAL_CONFIG_TYPE r105 = new EXTERNAL_CONFIG_TYPE("Component", 5);
        Component = r105;
        EXTERNAL_CONFIG_TYPE r106 = new EXTERNAL_CONFIG_TYPE("Service", 6);
        Service = r106;
        $VALUES = new EXTERNAL_CONFIG_TYPE[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static EXTERNAL_CONFIG_TYPE valueOf(String r100) {
        return (EXTERNAL_CONFIG_TYPE) a.a(EXTERNAL_CONFIG_TYPE.class, r100);
    }

    public static EXTERNAL_CONFIG_TYPE[] values() {
        return (EXTERNAL_CONFIG_TYPE[]) $VALUES.clone();
    }

    private EXTERNAL_CONFIG_TYPE(String r100, int r101) {
        super(r100, r101);
    }
}
