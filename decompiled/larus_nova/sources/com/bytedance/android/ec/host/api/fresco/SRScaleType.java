package com.bytedance.android.ec.host.api.fresco;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/host/api/fresco/SRScaleType;", "", "TYPE_1_1", "TYPE_1_2", "TYPE_1_3", "TYPE_1_4", "TYPE_1_5", "TYPE_2", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SRScaleType extends Enum<SRScaleType> {
    public static final SRScaleType TYPE_1_1 = null;
    public static final SRScaleType TYPE_1_2 = null;
    public static final SRScaleType TYPE_1_3 = null;
    public static final SRScaleType TYPE_1_4 = null;
    public static final SRScaleType TYPE_1_5 = null;
    public static final SRScaleType TYPE_2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SRScaleType[] f46172a = null;

    static {
        SRScaleType r100 = new SRScaleType("TYPE_1_1", 0);
        TYPE_1_1 = r100;
        SRScaleType r101 = new SRScaleType("TYPE_1_2", 1);
        TYPE_1_2 = r101;
        SRScaleType r102 = new SRScaleType("TYPE_1_3", 2);
        TYPE_1_3 = r102;
        SRScaleType r103 = new SRScaleType("TYPE_1_4", 3);
        TYPE_1_4 = r103;
        SRScaleType r104 = new SRScaleType("TYPE_1_5", 4);
        TYPE_1_5 = r104;
        SRScaleType r105 = new SRScaleType("TYPE_2", 5);
        TYPE_2 = r105;
        f46172a = new SRScaleType[]{r100, r101, r102, r103, r104, r105};
    }

    public static SRScaleType valueOf(String r100) {
        return (SRScaleType) a.a(SRScaleType.class, r100);
    }

    public static SRScaleType[] values() {
        return (SRScaleType[]) f46172a.clone();
    }

    public SRScaleType(String r100, int r101) {
        super(r100, r101);
    }
}
