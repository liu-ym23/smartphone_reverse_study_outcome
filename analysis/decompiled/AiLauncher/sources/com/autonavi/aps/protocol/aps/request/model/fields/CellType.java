package com.autonavi.aps.protocol.aps.request.model.fields;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public enum CellType {
    Undefined((byte) -1, "未定义"),
    Gsm((byte) 1, "Gsm"),
    Cdma((byte) 2, "Cdma"),
    Lte((byte) 3, "Lte"),
    Wcdma((byte) 4, "Wcdma"),
    Nr((byte) 5, "Nr");


    /* renamed from: a, reason: collision with root package name */
    private byte f18924a;

    /* renamed from: b, reason: collision with root package name */
    private String f18925b;

    CellType(byte b10, String str) {
        this.f18924a = b10;
        this.f18925b = str;
    }

    public static CellType fromByte(byte b10) {
        byte b11 = (byte) (b10 & 7);
        if (b11 == 1) {
            return Gsm;
        }
        if (b11 == 2) {
            return Cdma;
        }
        if (b11 == 3) {
            return Lte;
        }
        if (b11 == 4) {
            return Wcdma;
        }
        if (b11 == 5) {
            return Nr;
        }
        CellType cellType = Undefined;
        cellType.f18924a = b11;
        return cellType;
    }

    public static CellType fromByteBuffer(ByteBuffer byteBuffer) {
        return fromByte(byteBuffer.get());
    }

    public String getDescription() {
        return this.f18925b;
    }

    public byte toByte() {
        return this.f18924a;
    }
}
