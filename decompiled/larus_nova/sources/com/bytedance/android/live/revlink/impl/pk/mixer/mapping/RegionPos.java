package com.bytedance.android.live.revlink.impl.pk.mixer.mapping;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/mixer/mapping/RegionPos;", "", "SELF", FlowDoraWifiScene.OTHER, "GUEST1", "GUEST2", "O_GUEST1", "O_GUEST2", "OTHER_WITH_GUEST", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RegionPos extends Enum<RegionPos> {
    public static final RegionPos GUEST1 = null;
    public static final RegionPos GUEST2 = null;
    public static final RegionPos OTHER = null;
    public static final RegionPos OTHER_WITH_GUEST = null;
    public static final RegionPos O_GUEST1 = null;
    public static final RegionPos O_GUEST2 = null;
    public static final RegionPos SELF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RegionPos[] f96723a = null;

    static {
        RegionPos r100 = new RegionPos("SELF", 0);
        SELF = r100;
        RegionPos r101 = new RegionPos(FlowDoraWifiScene.OTHER, 1);
        OTHER = r101;
        RegionPos r102 = new RegionPos("GUEST1", 2);
        GUEST1 = r102;
        RegionPos r103 = new RegionPos("GUEST2", 3);
        GUEST2 = r103;
        RegionPos r104 = new RegionPos("O_GUEST1", 4);
        O_GUEST1 = r104;
        RegionPos r105 = new RegionPos("O_GUEST2", 5);
        O_GUEST2 = r105;
        RegionPos r106 = new RegionPos("OTHER_WITH_GUEST", 6);
        OTHER_WITH_GUEST = r106;
        f96723a = new RegionPos[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static RegionPos valueOf(String r100) {
        return (RegionPos) a.a(RegionPos.class, r100);
    }

    public static RegionPos[] values() {
        return (RegionPos[]) f96723a.clone();
    }

    public RegionPos(String r100, int r101) {
        super(r100, r101);
    }
}
