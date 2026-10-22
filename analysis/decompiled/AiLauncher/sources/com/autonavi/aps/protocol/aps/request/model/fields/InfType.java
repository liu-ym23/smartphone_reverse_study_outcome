package com.autonavi.aps.protocol.aps.request.model.fields;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public enum InfType {
    Undefined((byte) -1, "未定义"),
    Unknown((byte) 0, "未知"),
    Cellular((byte) 1, "蜂窝网络"),
    Wifi((byte) 2, "Wifi");


    /* renamed from: a, reason: collision with root package name */
    private byte f18941a;

    /* renamed from: b, reason: collision with root package name */
    private String f18942b;

    InfType(byte b10, String str) {
        this.f18941a = b10;
        this.f18942b = str;
    }

    public static InfType fromByte(byte b10) {
        if (b10 == 0) {
            return Unknown;
        }
        if (b10 == 1) {
            return Cellular;
        }
        if (b10 == 2) {
            return Wifi;
        }
        InfType infType = Undefined;
        infType.f18941a = b10;
        return infType;
    }

    public static InfType fromByteBuffer(ByteBuffer byteBuffer) {
        return fromByte(byteBuffer.get());
    }

    public String getDescription() {
        return this.f18942b;
    }

    public byte toByte() {
        return this.f18941a;
    }
}
