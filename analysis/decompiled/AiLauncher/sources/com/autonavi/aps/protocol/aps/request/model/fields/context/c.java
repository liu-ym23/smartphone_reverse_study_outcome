package com.autonavi.aps.protocol.aps.request.model.fields.context;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f19040a = new byte[0];

    public void a(byte[] bArr) {
        this.f19040a = bArr;
    }

    public byte[] b() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(c());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        a(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    public int c() {
        return this.f19040a.length + 2;
    }

    public String toString() {
        return com.autonavi.aps.protocol.aps.common.e.d.a().b(b());
    }

    public byte[] a() {
        return this.f19040a;
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short) this.f19040a.length);
        byteBuffer.put(this.f19040a);
    }
}
