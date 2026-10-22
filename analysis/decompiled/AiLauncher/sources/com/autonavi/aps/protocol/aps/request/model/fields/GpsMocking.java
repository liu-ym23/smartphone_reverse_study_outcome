package com.autonavi.aps.protocol.aps.request.model.fields;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public enum GpsMocking {
    Undefined((byte) -1, "未定义"),
    Real((byte) 0, "真实定位"),
    Mocking((byte) 1, "模拟GPS");


    /* renamed from: a, reason: collision with root package name */
    private byte f18927a;

    /* renamed from: b, reason: collision with root package name */
    private String f18928b;

    GpsMocking(byte b10, String str) {
        this.f18927a = b10;
        this.f18928b = str;
    }

    public static GpsMocking fromByte(byte b10) {
        if (b10 == 0) {
            return Real;
        }
        if (b10 == 1) {
            return Mocking;
        }
        GpsMocking gpsMocking = Undefined;
        gpsMocking.f18927a = b10;
        return gpsMocking;
    }

    public static GpsMocking fromByteBuffer(ByteBuffer byteBuffer) {
        return fromByte(byteBuffer.get());
    }

    public String getDescription() {
        return this.f18928b;
    }

    public byte toByte() {
        return this.f18927a;
    }
}
