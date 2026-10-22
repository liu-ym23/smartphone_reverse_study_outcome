package com.autonavi.aps.protocol.aps.response.model.vo.fields;

/* loaded from: classes.dex */
public enum ReSubtype {
    NULL((byte) 0, "没有子算法类型"),
    MPOS((byte) 1, "m算法"),
    PDR_SUBWAY((byte) 2, "pdr或subway算法"),
    INDOOR_SERVICE((byte) 3, "indoorService算法"),
    INBUILDING_V1((byte) 4, "inbuilding算法"),
    INBUILDING_V2((byte) 5, "inbuilding算法（版本2）"),
    STORE_IDENTIFICATION((byte) 6, "到店识别"),
    SEMANTICS((byte) 7, "语义定位"),
    BLUETOOTH((byte) 8, "蓝牙定位");


    /* renamed from: a, reason: collision with root package name */
    private Byte f19114a;

    /* renamed from: b, reason: collision with root package name */
    private String f19115b;

    ReSubtype(Byte b10, String str) {
        this.f19114a = b10;
        this.f19115b = str;
    }

    public static ReSubtype fromByte(Byte b10) {
        switch (b10.byteValue()) {
            case 0:
                return NULL;
            case 1:
                return MPOS;
            case 2:
                return PDR_SUBWAY;
            case 3:
                return INDOOR_SERVICE;
            case 4:
                return INBUILDING_V1;
            case 5:
                return INBUILDING_V2;
            case 6:
                return STORE_IDENTIFICATION;
            case 7:
                return SEMANTICS;
            case 8:
                return BLUETOOTH;
            default:
                return null;
        }
    }

    public static ReSubtype fromString(String str) {
        try {
            return fromByte(Byte.valueOf(Byte.parseByte(str)));
        } catch (Exception unused) {
            return null;
        }
    }

    public Byte getCode() {
        return this.f19114a;
    }

    public String getDescription() {
        return this.f19115b;
    }
}
