package com.bytedance.android.livesdk.castscreen.guide;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/guide/PadAndPcGuideExpandType;", "", "None", "Pc", "Pad", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PadAndPcGuideExpandType extends Enum<PadAndPcGuideExpandType> {
    public static final PadAndPcGuideExpandType None = null;
    public static final PadAndPcGuideExpandType Pad = null;
    public static final PadAndPcGuideExpandType Pc = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PadAndPcGuideExpandType[] f104461a = null;

    static {
        PadAndPcGuideExpandType r100 = new PadAndPcGuideExpandType("None", 0);
        None = r100;
        PadAndPcGuideExpandType r101 = new PadAndPcGuideExpandType("Pc", 1);
        Pc = r101;
        PadAndPcGuideExpandType r102 = new PadAndPcGuideExpandType("Pad", 2);
        Pad = r102;
        f104461a = new PadAndPcGuideExpandType[]{r100, r101, r102};
    }

    public static PadAndPcGuideExpandType valueOf(String r100) {
        return (PadAndPcGuideExpandType) r27.a.a(PadAndPcGuideExpandType.class, r100);
    }

    public static PadAndPcGuideExpandType[] values() {
        return (PadAndPcGuideExpandType[]) f104461a.clone();
    }

    public PadAndPcGuideExpandType(String r100, int r101) {
        super(r100, r101);
    }
}
