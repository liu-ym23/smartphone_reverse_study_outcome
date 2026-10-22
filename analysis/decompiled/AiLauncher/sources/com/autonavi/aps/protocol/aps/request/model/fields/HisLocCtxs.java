package com.autonavi.aps.protocol.aps.request.model.fields;

import com.autonavi.aps.protocol.aps.common.e.g;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class HisLocCtxs extends ArrayList<a> {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f18932a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f18933b = 0;

        /* renamed from: c, reason: collision with root package name */
        private int f18934c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f18935d = 0;

        /* renamed from: e, reason: collision with root package name */
        private C0214a f18936e = null;

        /* renamed from: com.autonavi.aps.protocol.aps.request.model.fields.HisLocCtxs$a$a, reason: collision with other inner class name */
        public static class C0214a {

            /* renamed from: a, reason: collision with root package name */
            private int f18937a = 0;

            /* renamed from: b, reason: collision with root package name */
            private int f18938b = 63;

            /* renamed from: c, reason: collision with root package name */
            private int f18939c = 0;

            public C0214a(int i10, int i11, int i12) {
                a(i10);
                b(i11);
                c(i12);
            }

            public int a() {
                return this.f18937a;
            }

            public int b() {
                return this.f18938b;
            }

            public int c() {
                return this.f18939c;
            }

            public String toString() {
                return "Type{locType=" + this.f18937a + ", algType=" + this.f18938b + ", algSubType=" + this.f18939c + '}';
            }

            public void a(int i10) {
                if (i10 < 0 || i10 > 7) {
                    return;
                }
                this.f18937a = i10;
            }

            public void b(int i10) {
                if (i10 < -64 || i10 > 63) {
                    return;
                }
                this.f18938b = i10;
            }

            public void c(int i10) {
                if (i10 < 0 || i10 > 63) {
                    return;
                }
                this.f18939c = i10;
            }
        }

        private static short a(int i10, int i11, int i12) {
            return (short) (((i10 << 13) | ((i11 + 64) << 6) | i12) & 65535);
        }

        public int b() {
            return this.f18933b;
        }

        public int c() {
            return this.f18934c;
        }

        public int d() {
            return this.f18935d;
        }

        public C0214a e() {
            return this.f18936e;
        }

        public int f() {
            return 14;
        }

        public String toString() {
            return "HisLocCtx{deltaTime=" + this.f18932a + ", lon=" + this.f18933b + ", lat=" + this.f18934c + ", radius=" + this.f18935d + ", type=" + this.f18936e + '}';
        }

        public int a() {
            return this.f18932a;
        }

        public void b(double d10) {
            this.f18934c = (int) Math.round(BigDecimal.valueOf(d10).setScale(7, 4).doubleValue() * 1.0E7d);
        }

        public void a(int i10) {
            if (i10 >= 0 && i10 <= 65535) {
                this.f18932a = i10;
            } else if (i10 > 65535) {
                this.f18932a = 65535;
            }
        }

        public void b(int i10) {
            if (i10 >= 0 && i10 <= 65535) {
                this.f18935d = i10;
            } else if (i10 > 65535) {
                this.f18935d = 65535;
            }
        }

        public void a(double d10) {
            this.f18933b = (int) Math.round(BigDecimal.valueOf(d10).setScale(7, 4).doubleValue() * 1.0E7d);
        }

        public void b(ByteBuffer byteBuffer) {
            this.f18932a = g.a(byteBuffer.getShort());
            this.f18933b = byteBuffer.getInt();
            this.f18934c = byteBuffer.getInt();
            this.f18935d = g.a(byteBuffer.getShort());
            short s10 = byteBuffer.getShort();
            int[] iArr = {(s10 >>> 13) & 7, ((s10 >>> 6) & 127) - 64, s10 & 63};
            this.f18936e = new C0214a(iArr[0], iArr[1], iArr[2]);
        }

        public void a(C0214a c0214a) {
            this.f18936e = c0214a;
        }

        public void a(ByteBuffer byteBuffer) {
            byteBuffer.putShort((short) this.f18932a);
            byteBuffer.putInt(this.f18933b);
            byteBuffer.putInt(this.f18934c);
            byteBuffer.putShort((short) this.f18935d);
            byteBuffer.putShort(a(this.f18936e.a(), this.f18936e.b(), this.f18936e.c()));
        }

        public static short b(C0214a c0214a) {
            return a(c0214a.a(), c0214a.b(), c0214a.c());
        }
    }

    public static HisLocCtxs createFromByteBuffer(ByteBuffer byteBuffer) {
        HisLocCtxs hisLocCtxs = new HisLocCtxs();
        hisLocCtxs.fromByteBuffer(byteBuffer);
        if (hisLocCtxs.size() == 0) {
            return null;
        }
        return hisLocCtxs;
    }

    public void fromByteBuffer(ByteBuffer byteBuffer) {
        byte b10 = byteBuffer.get();
        clear();
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

    public void toBytes(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) size());
        Iterator<a> it = iterator();
        while (it.hasNext()) {
            it.next().a(byteBuffer);
        }
    }
}
