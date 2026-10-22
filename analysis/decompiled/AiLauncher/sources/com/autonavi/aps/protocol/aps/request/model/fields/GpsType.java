package com.autonavi.aps.protocol.aps.request.model.fields;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public enum GpsType {
    Undefined((byte) -1, "未定义"),
    None((byte) 0, "没有"),
    Hardware((byte) 1, "硬件"),
    ThirdParty((byte) 2, "第三方");


    /* renamed from: a, reason: collision with root package name */
    private byte f18930a;

    /* renamed from: b, reason: collision with root package name */
    private String f18931b;

    GpsType(byte b10, String str) {
        this.f18930a = b10;
        this.f18931b = str;
    }

    public static GpsType fromByte(byte b10) {
        if (b10 == 0) {
            return None;
        }
        if (b10 == 1) {
            return Hardware;
        }
        if (b10 == 2) {
            return ThirdParty;
        }
        GpsType gpsType = Undefined;
        gpsType.f18930a = b10;
        return gpsType;
    }

    public static GpsType fromByteBuffer(ByteBuffer byteBuffer) {
        return fromByte(byteBuffer.get());
    }

    public String getDescription() {
        return this.f18931b;
    }

    public byte toByte() {
        return this.f18930a;
    }
}
