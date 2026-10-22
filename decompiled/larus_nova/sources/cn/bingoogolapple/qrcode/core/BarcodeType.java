package cn.bingoogolapple.qrcode.core;

import com.obric.miniapp.alarm.AccountType;

/* JADX INFO: loaded from: classes28.dex */
public final enum BarcodeType extends Enum<BarcodeType> {
    public static final BarcodeType ALL = null;
    public static final BarcodeType CUSTOM = null;
    public static final BarcodeType HIGH_FREQUENCY = null;
    public static final BarcodeType ONE_DIMENSION = null;
    public static final BarcodeType ONLY_CODE_128 = null;
    public static final BarcodeType ONLY_EAN_13 = null;
    public static final BarcodeType ONLY_QR_CODE = null;
    public static final BarcodeType TWO_DIMENSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BarcodeType[] f24311a = null;

    static {
        BarcodeType r100 = new BarcodeType(AccountType.ALL, 0);
        ALL = r100;
        BarcodeType r101 = new BarcodeType("ONE_DIMENSION", 1);
        ONE_DIMENSION = r101;
        BarcodeType r102 = new BarcodeType("TWO_DIMENSION", 2);
        TWO_DIMENSION = r102;
        BarcodeType r103 = new BarcodeType("ONLY_QR_CODE", 3);
        ONLY_QR_CODE = r103;
        BarcodeType r104 = new BarcodeType("ONLY_CODE_128", 4);
        ONLY_CODE_128 = r104;
        BarcodeType r105 = new BarcodeType("ONLY_EAN_13", 5);
        ONLY_EAN_13 = r105;
        BarcodeType r110 = new BarcodeType("HIGH_FREQUENCY", 6);
        HIGH_FREQUENCY = r110;
        BarcodeType r111 = new BarcodeType("CUSTOM", 7);
        CUSTOM = r111;
        f24311a = new BarcodeType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static BarcodeType[] values() {
        return (BarcodeType[]) f24311a.clone();
    }

    public static BarcodeType valueOf(String r100) {
        return (BarcodeType) r27.a.a(BarcodeType.class, r100);
    }

    public BarcodeType(String r100, int r101) {
        super(r100, r101);
    }
}
