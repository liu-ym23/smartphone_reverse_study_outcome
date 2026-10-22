package com.bytedance.android.livesdk.revenue.service.livecore;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IVideoQualityEnumParam;", "", "MIN", "GUEST_NORMAL", "GUEST_HIGH", "ANCHOR_NORMAL", "ANCHOR_HIGH", "HORIZONTAL_4_3", "HORIZONTAL_16_9", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IVideoQualityEnumParam extends Enum<IVideoQualityEnumParam> {
    public static final IVideoQualityEnumParam ANCHOR_HIGH = null;
    public static final IVideoQualityEnumParam ANCHOR_NORMAL = null;
    public static final IVideoQualityEnumParam GUEST_HIGH = null;
    public static final IVideoQualityEnumParam GUEST_NORMAL = null;
    public static final IVideoQualityEnumParam HORIZONTAL_16_9 = null;
    public static final IVideoQualityEnumParam HORIZONTAL_4_3 = null;
    public static final IVideoQualityEnumParam MIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IVideoQualityEnumParam[] f157404a = null;

    static {
        IVideoQualityEnumParam r100 = new IVideoQualityEnumParam("MIN", 0);
        MIN = r100;
        IVideoQualityEnumParam r101 = new IVideoQualityEnumParam("GUEST_NORMAL", 1);
        GUEST_NORMAL = r101;
        IVideoQualityEnumParam r102 = new IVideoQualityEnumParam("GUEST_HIGH", 2);
        GUEST_HIGH = r102;
        IVideoQualityEnumParam r103 = new IVideoQualityEnumParam("ANCHOR_NORMAL", 3);
        ANCHOR_NORMAL = r103;
        IVideoQualityEnumParam r104 = new IVideoQualityEnumParam("ANCHOR_HIGH", 4);
        ANCHOR_HIGH = r104;
        IVideoQualityEnumParam r105 = new IVideoQualityEnumParam("HORIZONTAL_4_3", 5);
        HORIZONTAL_4_3 = r105;
        IVideoQualityEnumParam r106 = new IVideoQualityEnumParam("HORIZONTAL_16_9", 6);
        HORIZONTAL_16_9 = r106;
        f157404a = new IVideoQualityEnumParam[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static IVideoQualityEnumParam valueOf(String r100) {
        return (IVideoQualityEnumParam) a.a(IVideoQualityEnumParam.class, r100);
    }

    public static IVideoQualityEnumParam[] values() {
        return (IVideoQualityEnumParam[]) f157404a.clone();
    }

    public IVideoQualityEnumParam(String r100, int r101) {
        super(r100, r101);
    }
}
