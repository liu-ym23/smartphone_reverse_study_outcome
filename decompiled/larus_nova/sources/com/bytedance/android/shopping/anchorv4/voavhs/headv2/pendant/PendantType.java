package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/pendant/PendantType;", "", "TYPE_NATIVE", "TYPE_SLICE", "TYPE_LYNX", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PendantType extends Enum<PendantType> {
    public static final PendantType TYPE_LYNX = null;
    public static final PendantType TYPE_NATIVE = null;
    public static final PendantType TYPE_SLICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PendantType[] f169844a = null;

    static {
        PendantType r100 = new PendantType("TYPE_NATIVE", 0);
        TYPE_NATIVE = r100;
        PendantType r101 = new PendantType("TYPE_SLICE", 1);
        TYPE_SLICE = r101;
        PendantType r102 = new PendantType("TYPE_LYNX", 2);
        TYPE_LYNX = r102;
        f169844a = new PendantType[]{r100, r101, r102};
    }

    public static PendantType valueOf(String r100) {
        return (PendantType) r27.a.a(PendantType.class, r100);
    }

    public static PendantType[] values() {
        return (PendantType[]) f169844a.clone();
    }

    public PendantType(String r100, int r101) {
        super(r100, r101);
    }
}
