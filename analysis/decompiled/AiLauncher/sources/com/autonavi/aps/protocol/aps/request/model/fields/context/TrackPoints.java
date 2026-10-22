package com.autonavi.aps.protocol.aps.request.model.fields.context;

import com.autonavi.aps.protocol.aps.response.model.vo.fields.Retype;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TrackPoints extends ArrayList<a> {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private double f19028a = 0.0d;

        /* renamed from: b, reason: collision with root package name */
        private double f19029b = 0.0d;

        /* renamed from: c, reason: collision with root package name */
        private short f19030c = 0;

        /* renamed from: d, reason: collision with root package name */
        private Retype f19031d = Retype.GPS;

        /* renamed from: e, reason: collision with root package name */
        private short f19032e = 0;

        public double a() {
            return this.f19028a;
        }

        public double b() {
            return this.f19029b;
        }

        public short c() {
            return this.f19030c;
        }

        public Retype d() {
            return this.f19031d;
        }

        public short e() {
            return this.f19032e;
        }

        public int f() {
            return 13;
        }

        public void a(double d10) {
            this.f19028a = d10;
        }

        public void b(double d10) {
            this.f19029b = d10;
        }

        public void a(short s10) {
            this.f19030c = s10;
        }

        public void b(short s10) {
            this.f19032e = s10;
        }

        public void a(Retype retype) {
            this.f19031d = retype;
        }

        public void b(ByteBuffer byteBuffer) {
            this.f19028a = byteBuffer.getInt() / 1200000.0d;
            this.f19029b = byteBuffer.getInt() / 1000000.0d;
            this.f19030c = byteBuffer.getShort();
            this.f19031d = Retype.fromByte(Byte.valueOf(byteBuffer.get()));
            this.f19032e = byteBuffer.getShort();
        }

        public void a(ByteBuffer byteBuffer) {
            byteBuffer.putInt((int) (this.f19028a * 1200000.0d));
            byteBuffer.putInt((int) (this.f19029b * 1000000.0d));
            byteBuffer.putShort(this.f19030c);
            byteBuffer.put(this.f19031d.getCode().byteValue());
            byteBuffer.putShort(this.f19032e);
        }
    }

    public static TrackPoints createFromByteBuffer(ByteBuffer byteBuffer) {
        TrackPoints trackPoints = new TrackPoints();
        trackPoints.fromByteBuffer(byteBuffer);
        if (trackPoints.size() == 0) {
            return null;
        }
        return trackPoints;
    }

    public void fromByteBuffer(ByteBuffer byteBuffer) {
        clear();
        byte b10 = byteBuffer.get();
        for (int i10 = 0; i10 < b10; i10++) {
            a aVar = new a();
            aVar.b(byteBuffer);
            add(aVar);
        }
    }

    public int getByteSize() {
        Iterator<a> it = iterator();
        int iF = 1;
        while (it.hasNext()) {
            iF += it.next().f();
        }
        return iF;
    }

    public byte[] toBytes() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getByteSize());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        toBytes(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return com.autonavi.aps.protocol.aps.common.e.d.a().b(toBytes());
    }

    public void toBytes(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) size());
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            it.next().a(byteBuffer);
        }
    }
}
