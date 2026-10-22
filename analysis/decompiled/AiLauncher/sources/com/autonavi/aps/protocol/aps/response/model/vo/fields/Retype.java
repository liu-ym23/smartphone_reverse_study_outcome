package com.autonavi.aps.protocol.aps.response.model.vo.fields;

/* loaded from: classes.dex */
public enum Retype {
    GPS((byte) 0, "gps定位"),
    WIFI((byte) 1, "wifi定位"),
    MIX((byte) 2, "混合定位"),
    CELL((byte) 3, "细指纹定位结果-基站定位"),
    SECTOR((byte) 4, "细指纹定位结果-相邻扇区定位"),
    CDMA_LNGLAT((byte) 5, "cdma自带经纬度定位"),
    CITY((byte) 7, "城市定位类型"),
    FAILUR((byte) 8, "定位失败的的类型"),
    COSITE((byte) 9, "细指纹定位结果-同址基站定位"),
    SF_WIFI((byte) 14, "细指纹定位结果-wifi定位"),
    SF_CELL((byte) 24, "细指纹定位结果-混合定位"),
    INDOOR((byte) -1, "室内定位"),
    GOOGLE((byte) -2, "google定位"),
    SKYHOOK((byte) -4, "skyhook定位"),
    ACCURATE((byte) -5, "L算法、 M算法"),
    IOS((byte) -6, "iOS粗定位"),
    UNKNOWN((byte) -99, "未知类型");


    /* renamed from: a, reason: collision with root package name */
    private Byte f19120a;

    /* renamed from: b, reason: collision with root package name */
    private String f19121b;

    /* renamed from: c, reason: collision with root package name */
    private Retype f19122c;

    Retype(Byte b10, String str) {
        this.f19120a = b10;
        this.f19121b = str;
        byte bByteValue = (byte) (b10.byteValue() / 10);
        if (bByteValue == 0) {
            this.f19122c = this;
        } else {
            this.f19122c = fromByte(Byte.valueOf(bByteValue));
        }
    }

    public static Retype fromByte(Byte b10) {
        byte bByteValue = b10.byteValue();
        if (bByteValue == 14) {
            return SF_WIFI;
        }
        if (bByteValue == 24) {
            return SF_CELL;
        }
        if (bByteValue == -6) {
            return IOS;
        }
        if (bByteValue == -5) {
            return ACCURATE;
        }
        if (bByteValue == -4) {
            return SKYHOOK;
        }
        switch (bByteValue) {
            case -2:
                return GOOGLE;
            case -1:
                return INDOOR;
            case 0:
                return GPS;
            case 1:
                return WIFI;
            case 2:
                return MIX;
            case 3:
                return CELL;
            case 4:
                return SECTOR;
            case 5:
                return CDMA_LNGLAT;
            default:
                return bByteValue != 7 ? bByteValue != 8 ? bByteValue != 9 ? UNKNOWN : COSITE : FAILUR : CITY;
        }
    }

    public static Retype fromString(String str) {
        try {
            return fromByte(Byte.valueOf(Byte.parseByte(str)));
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }

    public static void main(String[] strArr) {
        System.out.println(fromByte(null));
    }

    public Byte getCode() {
        return this.f19120a;
    }

    public String getDescription() {
        return this.f19121b;
    }

    public Retype getSuperRetype() {
        return this.f19122c;
    }

    public boolean isCellRetype() {
        return CELL == this || COSITE == this || SECTOR == this;
    }
}
