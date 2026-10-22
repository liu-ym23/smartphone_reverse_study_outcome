package androidx.camera.core.impl.utils;

import M.b;
import M.g;
import M.h;
import androidx.camera.core.impl.utils.ExifData;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends FilterOutputStream {

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f11520g = "Exif\u0000\u0000".getBytes(g.f4475e);

    /* renamed from: a, reason: collision with root package name */
    public final ExifData f11521a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f11522b;

    /* renamed from: c, reason: collision with root package name */
    public final ByteBuffer f11523c;

    /* renamed from: d, reason: collision with root package name */
    public int f11524d;

    /* renamed from: e, reason: collision with root package name */
    public int f11525e;

    /* renamed from: f, reason: collision with root package name */
    public int f11526f;

    /* renamed from: androidx.camera.core.impl.utils.a$a, reason: collision with other inner class name */
    public static final class C0150a {
        public static boolean a(short s10) {
            return (s10 < -64 || s10 > -49 || s10 == -60 || s10 == -56 || s10 == -52) ? false : true;
        }
    }

    public a(OutputStream outputStream, ExifData exifData) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.f11522b = new byte[1];
        this.f11523c = ByteBuffer.allocate(4);
        this.f11524d = 0;
        this.f11521a = exifData;
    }

    public final int b(int i10, byte[] bArr, int i11, int i12) {
        int iMin = Math.min(i12, i10 - this.f11523c.position());
        this.f11523c.put(bArr, i11, iMin);
        return iMin;
    }

    public final void e(b bVar) throws IOException {
        h[][] hVarArr = ExifData.f11503i;
        int[] iArr = new int[hVarArr.length];
        int[] iArr2 = new int[hVarArr.length];
        for (h hVar : ExifData.f11501g) {
            for (int i10 = 0; i10 < ExifData.f11503i.length; i10++) {
                this.f11521a.d(i10).remove(hVar.f4484b);
            }
        }
        if (!this.f11521a.d(1).isEmpty()) {
            this.f11521a.d(0).put(ExifData.f11501g[1].f4484b, g.f(0L, this.f11521a.e()));
        }
        if (!this.f11521a.d(2).isEmpty()) {
            this.f11521a.d(0).put(ExifData.f11501g[2].f4484b, g.f(0L, this.f11521a.e()));
        }
        if (!this.f11521a.d(3).isEmpty()) {
            this.f11521a.d(1).put(ExifData.f11501g[3].f4484b, g.f(0L, this.f11521a.e()));
        }
        for (int i11 = 0; i11 < ExifData.f11503i.length; i11++) {
            Iterator<Map.Entry<String, g>> it = this.f11521a.d(i11).entrySet().iterator();
            int i12 = 0;
            while (it.hasNext()) {
                int iJ = it.next().getValue().j();
                if (iJ > 4) {
                    i12 += iJ;
                }
            }
            iArr2[i11] = iArr2[i11] + i12;
        }
        int size = 8;
        for (int i13 = 0; i13 < ExifData.f11503i.length; i13++) {
            if (!this.f11521a.d(i13).isEmpty()) {
                iArr[i13] = size;
                size += (this.f11521a.d(i13).size() * 12) + 6 + iArr2[i13];
            }
        }
        int i14 = size + 8;
        if (!this.f11521a.d(1).isEmpty()) {
            this.f11521a.d(0).put(ExifData.f11501g[1].f4484b, g.f(iArr[1], this.f11521a.e()));
        }
        if (!this.f11521a.d(2).isEmpty()) {
            this.f11521a.d(0).put(ExifData.f11501g[2].f4484b, g.f(iArr[2], this.f11521a.e()));
        }
        if (!this.f11521a.d(3).isEmpty()) {
            this.f11521a.d(1).put(ExifData.f11501g[3].f4484b, g.f(iArr[3], this.f11521a.e()));
        }
        bVar.i(i14);
        bVar.write(f11520g);
        bVar.writeShort(this.f11521a.e() == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        bVar.b(this.f11521a.e());
        bVar.i(42);
        bVar.g(8L);
        for (int i15 = 0; i15 < ExifData.f11503i.length; i15++) {
            if (!this.f11521a.d(i15).isEmpty()) {
                bVar.i(this.f11521a.d(i15).size());
                int size2 = iArr[i15] + 2 + (this.f11521a.d(i15).size() * 12) + 4;
                for (Map.Entry<String, g> entry : this.f11521a.d(i15).entrySet()) {
                    int i16 = ((h) B0.h.g(ExifData.b.f11512f.get(i15).get(entry.getKey()), "Tag not supported: " + entry.getKey() + ". Tag needs to be ported from ExifInterface to ExifData.")).f4483a;
                    g value = entry.getValue();
                    int iJ2 = value.j();
                    bVar.i(i16);
                    bVar.i(value.f4479a);
                    bVar.writeInt(value.f4480b);
                    if (iJ2 > 4) {
                        bVar.g(size2);
                        size2 += iJ2;
                    } else {
                        bVar.write(value.f4482d);
                        if (iJ2 < 4) {
                            while (iJ2 < 4) {
                                bVar.e(0);
                                iJ2++;
                            }
                        }
                    }
                }
                bVar.g(0L);
                Iterator<Map.Entry<String, g>> it2 = this.f11521a.d(i15).entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = it2.next().getValue().f4482d;
                    if (bArr.length > 4) {
                        bVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        bVar.b(ByteOrder.BIG_ENDIAN);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0108, code lost:
    
        if (r9 <= 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010a, code lost:
    
        ((java.io.FilterOutputStream) r6).out.write(r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.a.write(byte[], int, int):void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f11522b;
        bArr[0] = (byte) (i10 & 255);
        write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
