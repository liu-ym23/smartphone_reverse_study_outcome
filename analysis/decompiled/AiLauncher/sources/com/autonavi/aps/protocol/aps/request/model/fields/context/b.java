package com.autonavi.aps.protocol.aps.request.model.fields.context;

import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.protocol.aps.common.e.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import net.jafama.FastMath;

/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private byte f19038d = 1;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f19039e = null;

    /* renamed from: a, reason: collision with root package name */
    private d f19035a = null;

    /* renamed from: b, reason: collision with root package name */
    private f f19036b = new f();

    /* renamed from: c, reason: collision with root package name */
    private e f19037c = new e();

    private byte[] e() {
        if (c() != 1) {
            throw new RuntimeException("Unknown context version(" + ((int) c()) + ")");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(256);
        byteBufferAllocate.put(c());
        byte b10 = this.f19035a != null ? (byte) 1 : (byte) 0;
        ArrayList arrayList = new ArrayList();
        f fVar = this.f19036b;
        if (fVar != null) {
            Iterator<g> it = fVar.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        byte size = (byte) ((arrayList.size() << 1) | b10);
        e eVar = this.f19037c;
        if (eVar != null) {
            size = (byte) (size | (eVar.a() << 5));
        }
        byteBufferAllocate.put(size);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        d dVar = this.f19035a;
        if (dVar != null) {
            arrayList2.add(Integer.valueOf((int) (dVar.a() * 100000.0d)));
            arrayList3.add(Integer.valueOf((int) (this.f19035a.b() * 100000.0d)));
            arrayList4.add(Integer.valueOf(this.f19035a.c()));
            arrayList5.add(Integer.valueOf((int) (this.f19035a.e() * 100.0d)));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            g gVar = (g) it2.next();
            arrayList2.add(Integer.valueOf((int) (gVar.a() * 100000.0d)));
            arrayList3.add(Integer.valueOf((int) (gVar.b() * 100000.0d)));
            arrayList4.add(Integer.valueOf(gVar.c()));
            arrayList5.add(Integer.valueOf((int) (gVar.d() * 100.0d)));
        }
        e eVar2 = this.f19037c;
        if (eVar2 != null) {
            Iterator<a> it3 = eVar2.f19047a.iterator();
            while (it3.hasNext()) {
                arrayList4.add(Integer.valueOf(it3.next().f19034b));
            }
        }
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            iMin2 = FastMath.min(iMin2, ((Integer) arrayList2.get(i10)).intValue());
            iMin = FastMath.min(iMin, ((Integer) arrayList3.get(i10)).intValue());
        }
        int iMax = 0;
        for (int i11 = 0; i11 < arrayList4.size(); i11++) {
            iMax = FastMath.max(iMax, ((Integer) arrayList4.get(i11)).intValue());
        }
        if (arrayList4.size() <= 0) {
            return new byte[0];
        }
        byteBufferAllocate.putInt(iMin2);
        byteBufferAllocate.putInt(iMin);
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            com.autonavi.aps.protocol.aps.common.e.e.a(byteBufferAllocate, ((Integer) arrayList2.get(i12)).intValue() - iMin2);
            com.autonavi.aps.protocol.aps.common.e.e.a(byteBufferAllocate, ((Integer) arrayList3.get(i12)).intValue() - iMin);
        }
        byteBufferAllocate.putInt(iMax);
        for (int i13 = 0; i13 < arrayList4.size(); i13++) {
            com.autonavi.aps.protocol.aps.common.e.e.a(byteBufferAllocate, iMax - ((Integer) arrayList4.get(i13)).intValue());
        }
        for (int i14 = 0; i14 < arrayList5.size(); i14++) {
            byteBufferAllocate.put(((Integer) arrayList5.get(i14)).byteValue());
        }
        d dVar2 = this.f19035a;
        if (dVar2 != null) {
            byteBufferAllocate.put(dVar2.d());
            byteBufferAllocate.putShort((short) (this.f19035a.f() - 32768));
        }
        e eVar3 = this.f19037c;
        if (eVar3 != null) {
            Iterator<a> it4 = eVar3.f19047a.iterator();
            while (it4.hasNext()) {
                byteBufferAllocate.putShort((short) (it4.next().f19033a - 32768));
            }
        }
        int iPosition = byteBufferAllocate.position();
        byte[] bArr = new byte[iPosition];
        byteBufferAllocate.position(0);
        byteBufferAllocate.get(bArr, 0, iPosition);
        return bArr;
    }

    public byte[] a() {
        if (this.f19039e == null) {
            this.f19039e = e();
        }
        return this.f19039e;
    }

    public e b() {
        return this.f19037c;
    }

    public byte c() {
        return this.f19038d;
    }

    public f d() {
        return this.f19036b;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        Iterator<g> it = d().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a> it2 = this.f19037c.f19047a.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().toString());
        }
        Byte bValueOf = Byte.valueOf(this.f19038d);
        d dVar = this.f19035a;
        return h.a(new Object[]{bValueOf, dVar == null ? null : dVar.toString(), h.a(arrayList, Const.STR_MART_COMMA), h.a(arrayList2, Const.STR_MART_COMMA)}, Const.STR_MART_SEMICOLON);
    }

    public void a(byte[] bArr) {
        int i10;
        int i11;
        this.f19039e = bArr;
        if (bArr == null || bArr.length == 0) {
            return;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte b10 = byteBufferWrap.get();
        a(b10);
        if (b10 == 1) {
            byte b11 = byteBufferWrap.get();
            int i12 = (b11 & 1) == 1 ? 1 : 0;
            int i13 = (b11 & 30) >> 1;
            int i14 = (b11 & 96) >> 5;
            int i15 = i14 + i13 + i12;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (i15 > 0) {
                int i16 = byteBufferWrap.getInt();
                int i17 = byteBufferWrap.getInt();
                int i18 = 0;
                while (true) {
                    i11 = i13 + i12;
                    if (i18 >= i11) {
                        break;
                    }
                    int iA = com.autonavi.aps.protocol.aps.common.e.e.a(byteBufferWrap);
                    int iA2 = com.autonavi.aps.protocol.aps.common.e.e.a(byteBufferWrap);
                    arrayList.add(Double.valueOf(((iA + i16) * 1.0d) / 100000.0d));
                    arrayList2.add(Double.valueOf(((i17 + iA2) * 1.0d) / 100000.0d));
                    i18++;
                    i15 = i15;
                }
                int i19 = byteBufferWrap.getInt();
                for (int i20 = 0; i20 < i15; i20++) {
                    arrayList3.add(Integer.valueOf(i19 - com.autonavi.aps.protocol.aps.common.e.e.a(byteBufferWrap)));
                }
                for (int i21 = 0; i21 < i11; i21++) {
                    arrayList4.add(Double.valueOf((byteBufferWrap.get() * 1.0d) / 100.0d));
                }
            }
            if (i12 != 0) {
                i10 = 0;
                a(new d(((Double) arrayList.get(0)).doubleValue(), ((Double) arrayList2.get(0)).doubleValue(), ((Integer) arrayList3.get(0)).intValue(), byteBufferWrap.get(), ((Double) arrayList4.get(0)).doubleValue(), byteBufferWrap.getShort() + Short.MIN_VALUE));
            } else {
                i10 = 0;
            }
            ArrayList arrayList5 = new ArrayList();
            for (int i22 = i10; i22 < i14; i22++) {
                arrayList5.add(Integer.valueOf(byteBufferWrap.getShort() + Short.MIN_VALUE));
            }
            if (byteBufferWrap.hasRemaining()) {
                return;
            }
            f fVar = new f();
            for (int i23 = i12; i23 < i13 + i12; i23++) {
                fVar.a(new g(((Double) arrayList.get(i23)).doubleValue(), ((Double) arrayList2.get(i23)).doubleValue(), ((Integer) arrayList3.get(i23)).intValue(), ((Double) arrayList4.get(i23)).doubleValue()));
            }
            a(fVar);
            for (int i24 = i10; i24 < i14; i24++) {
                b().a(((Integer) arrayList5.get(i24)).intValue(), ((Integer) arrayList3.get(i24 + i13 + i12)).intValue());
            }
        }
    }

    public void a(byte b10) {
        this.f19038d = b10;
    }

    public void a(f fVar) {
        this.f19036b = fVar;
    }

    public void a(d dVar) {
        this.f19035a = dVar;
    }
}
