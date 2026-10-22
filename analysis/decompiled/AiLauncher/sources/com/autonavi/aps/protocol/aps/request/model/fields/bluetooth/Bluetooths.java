package com.autonavi.aps.protocol.aps.request.model.fields.bluetooth;

import O6.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Bluetooths extends ArrayList<a> {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private com.autonavi.aps.protocol.aps.request.model.fields.wifi.a f18954a = new com.autonavi.aps.protocol.aps.request.model.fields.wifi.a();

        /* renamed from: b, reason: collision with root package name */
        private String f18955b = "00000000000000000000000000000000";

        /* renamed from: c, reason: collision with root package name */
        private int f18956c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f18957d = 0;

        /* renamed from: e, reason: collision with root package name */
        private byte f18958e = 0;

        /* renamed from: f, reason: collision with root package name */
        private int f18959f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f18960g = 0;

        /* renamed from: h, reason: collision with root package name */
        private String f18961h;

        /* renamed from: i, reason: collision with root package name */
        private int f18962i;

        /* renamed from: j, reason: collision with root package name */
        private int f18963j;

        /* renamed from: k, reason: collision with root package name */
        private int f18964k;

        /* renamed from: l, reason: collision with root package name */
        private int f18965l;

        public com.autonavi.aps.protocol.aps.request.model.fields.wifi.a a() {
            return this.f18954a;
        }

        public String b() {
            return this.f18955b;
        }

        public int c() {
            return this.f18956c;
        }

        public int d() {
            return this.f18957d;
        }

        public byte e() {
            return this.f18958e;
        }

        public int f() {
            return this.f18959f;
        }

        public int g() {
            return this.f18960g;
        }

        public String h() {
            return this.f18961h;
        }

        public int i() {
            return this.f18962i;
        }

        public int j() {
            return this.f18963j;
        }

        public int k() {
            return this.f18964k;
        }

        public int l() {
            return this.f18965l;
        }

        public int m() {
            return this.f18954a.b() + this.f18955b.getBytes(Charset.forName("UTF-8")).length + 17;
        }

        public String toString() {
            return "Bluetooth{mac=" + this.f18954a + ", uuid='" + this.f18955b + "', major=" + this.f18956c + ", minor=" + this.f18957d + ", rssi=" + ((int) this.f18958e) + ", power=" + this.f18959f + ", accuracy=" + this.f18960g + ", name='" + this.f18961h + "', type=" + this.f18962i + ", connect=" + this.f18963j + ", mainDeviceType=" + this.f18964k + ", subDeviceType=" + this.f18965l + '}';
        }

        public void a(com.autonavi.aps.protocol.aps.request.model.fields.wifi.a aVar) {
            this.f18954a = aVar;
        }

        public void b(int i10) {
            this.f18957d = i10;
        }

        public void c(int i10) {
            this.f18959f = i10;
        }

        public void d(int i10) {
            this.f18962i = i10;
        }

        public void e(int i10) {
            this.f18963j = i10;
        }

        public void f(int i10) {
            this.f18964k = i10;
        }

        public void g(int i10) {
            this.f18965l = i10;
        }

        public void a(String str) {
            if (str.replaceAll(l.DATE_SEPARATOR, "").getBytes(Charset.forName("UTF-8")).length == 32) {
                this.f18955b = str;
            }
        }

        public void b(String str) {
            this.f18961h = str;
        }

        public void b(ByteBuffer byteBuffer) {
            this.f18954a.b(byteBuffer);
            byte[] bArr = new byte[32];
            byteBuffer.get(bArr, 0, 32);
            this.f18955b = new String(bArr, Charset.forName("UTF-8"));
            this.f18956c = byteBuffer.getInt();
            this.f18957d = byteBuffer.getInt();
            this.f18958e = byteBuffer.get();
            this.f18959f = byteBuffer.getInt();
            this.f18960g = byteBuffer.getInt();
        }

        public void a(int i10) {
            this.f18956c = i10;
        }

        public void a(byte b10) {
            this.f18958e = b10;
        }

        public void a(ByteBuffer byteBuffer) {
            this.f18954a.a(byteBuffer);
            byteBuffer.put(this.f18955b.getBytes(Charset.forName("UTF-8")));
            byteBuffer.putInt(this.f18956c);
            byteBuffer.putInt(this.f18957d);
            byteBuffer.put(this.f18958e);
            byteBuffer.putInt(this.f18959f);
            byteBuffer.putInt(this.f18960g);
        }
    }

    public static Bluetooths createFromByteBuffer(ByteBuffer byteBuffer) {
        Bluetooths bluetooths = new Bluetooths();
        bluetooths.fromByteBuffer(byteBuffer);
        if (bluetooths.size() == 0) {
            return null;
        }
        return bluetooths;
    }

    public void fromByteBuffer(ByteBuffer byteBuffer) {
        clear();
        short s10 = byteBuffer.getShort();
        for (int i10 = 0; i10 < s10; i10++) {
            a aVar = new a();
            aVar.b(byteBuffer);
            add(aVar);
        }
    }

    public int getByteSize() {
        Iterator<a> it = iterator();
        int iM = 2;
        while (it.hasNext()) {
            iM += it.next().m();
        }
        return iM;
    }

    public byte[] toBytes() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(getByteSize());
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        toBytes(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "Bluetooths{" + super.toString() + "modCount=" + ((ArrayList) this).modCount + '}';
    }

    public void toBytes(ByteBuffer byteBuffer) {
        byteBuffer.putShort((short) size());
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            it.next().a(byteBuffer);
        }
    }
}
