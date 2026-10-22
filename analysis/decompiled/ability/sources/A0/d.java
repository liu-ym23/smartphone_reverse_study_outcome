package A0;

import H8.AbstractC0241b;
import H8.AbstractC0244e;
import N9.j;
import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int f70a;
    public int b;
    public Object c;
    public Object d;

    public static int e(int i, int i6) {
        return g(i6) + l(i);
    }

    public static int f(int i, int i6) {
        return g(i6) + l(i);
    }

    public static int g(int i) {
        if (i >= 0) {
            return j(i);
        }
        return 10;
    }

    public static int h(int i, AbstractC0241b abstractC0241b) {
        return i(abstractC0241b) + l(i);
    }

    public static int i(AbstractC0241b abstractC0241b) {
        int iA = abstractC0241b.a();
        return j(iA) + iA;
    }

    public static int j(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int k(long j5) {
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (((-16384) & j5) == 0) {
            return 2;
        }
        if (((-2097152) & j5) == 0) {
            return 3;
        }
        if (((-268435456) & j5) == 0) {
            return 4;
        }
        if (((-34359738368L) & j5) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j5) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j5) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j5) == 0) {
            return 8;
        }
        return (j5 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int l(int i) {
        return j(i << 3);
    }

    public static d n(OutputStream outputStream, int i) {
        byte[] bArr = new byte[i];
        d dVar = new d();
        dVar.d = outputStream;
        dVar.c = bArr;
        dVar.b = 0;
        dVar.f70a = bArr.length;
        return dVar;
    }

    public void A(long j5) throws IOException {
        while (((-128) & j5) != 0) {
            u((((int) j5) & 127) | 128);
            j5 >>>= 7;
        }
        u((int) j5);
    }

    public void B(int i, int i6) throws IOException {
        z((i << 3) | i6);
    }

    public ArrayList a() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.d;
        int i = 0;
        if (arrayList2.size() == this.f70a) {
            for (int i6 = this.b; i6 < arrayList2.size(); i6++) {
                arrayList.add((h2.f) arrayList2.get(i6));
            }
            while (i < this.b - 1) {
                arrayList.add((h2.f) arrayList2.get(i));
                i++;
            }
        } else {
            while (i < arrayList2.size()) {
                arrayList.add(arrayList2.get(i));
                i++;
            }
        }
        return arrayList;
    }

    public synchronized void b(long j5, String str) {
        try {
            if (((HashMap) this.d) == null) {
                this.d = new HashMap();
            }
            if (((HashMap) this.d).containsKey(str)) {
                h hVar = (h) ((HashMap) this.d).get(str);
                hVar.c++;
                hVar.d = System.currentTimeMillis();
                int i = hVar.c;
                if (i > this.b) {
                    this.b = i;
                }
            } else {
                HashMap map = (HashMap) this.c;
                if (map != null) {
                    String str2 = null;
                    long j6 = Long.MAX_VALUE;
                    if (map.containsKey(str)) {
                        h hVar2 = (h) ((HashMap) this.c).get(str);
                        int i6 = hVar2.c;
                        hVar2.c = i6 + 1;
                        hVar2.d = System.currentTimeMillis();
                        if (i6 > this.f70a) {
                            ((HashMap) this.c).remove(str);
                            if (((HashMap) this.d).size() >= 20) {
                                long jCurrentTimeMillis = System.currentTimeMillis() / 2;
                                for (Map.Entry entry : ((HashMap) this.d).entrySet()) {
                                    if (((h) entry.getValue()).d < jCurrentTimeMillis && ((h) entry.getValue()).c < j6) {
                                        j6 = ((h) entry.getValue()).c;
                                        str2 = ((h) entry.getValue()).f74a;
                                    }
                                }
                                if (str2 != null) {
                                    ((HashMap) this.d).remove(str2);
                                }
                            }
                            ((HashMap) this.d).put(str, hVar2);
                        }
                    } else {
                        if (((HashMap) this.c).size() >= 50) {
                            for (Map.Entry entry2 : ((HashMap) this.c).entrySet()) {
                                if (((h) entry2.getValue()).d < j6) {
                                    j6 = ((h) entry2.getValue()).d;
                                    str2 = ((h) entry2.getValue()).f74a;
                                }
                            }
                            if (str2 != null) {
                                ((HashMap) this.c).remove(str2);
                            }
                        }
                        ((HashMap) this.c).put(str, new h(str, j5));
                    }
                } else {
                    HashMap map2 = new HashMap();
                    this.c = map2;
                    map2.put(str, new h(str, j5));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void c(File file) {
        File file2 = new File(j.C((Context) this.d), "apminsight/issueCrashTimes");
        file.renameTo(new File(file2, String.valueOf(System.currentTimeMillis())));
        String[] list = file2.list();
        if (list != null && list.length > 5) {
            Arrays.sort(list);
            new File(file2, list[0]).delete();
        }
    }

    public boolean d(String str) {
        HashMap map = (HashMap) this.c;
        if (str == null) {
            str = "default";
        }
        return U7.a.d(map, str).longValue() < ((long) this.f70a) && U7.a.d(map, "all").longValue() < ((long) this.b);
    }

    public void m() throws IOException {
        if (((OutputStream) this.d) != null) {
            o();
        }
    }

    public void o() throws IOException {
        OutputStream outputStream = (OutputStream) this.d;
        if (outputStream == null) {
            throw new IOException() { // from class: kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream$OutOfSpaceException
            };
        }
        outputStream.write((byte[]) this.c, 0, this.b);
        this.b = 0;
    }

    public void p(int i, int i6) throws IOException {
        B(i, 0);
        r(i6);
    }

    public void q(int i, int i6) throws IOException {
        B(i, 0);
        r(i6);
    }

    public void r(int i) throws IOException {
        if (i >= 0) {
            z(i);
        } else {
            A(i);
        }
    }

    public void s(int i, AbstractC0241b abstractC0241b) throws IOException {
        B(i, 2);
        t(abstractC0241b);
    }

    public void t(AbstractC0241b abstractC0241b) throws IOException {
        z(abstractC0241b.a());
        abstractC0241b.d(this);
    }

    public void u(int i) throws IOException {
        byte b = (byte) i;
        if (this.b == this.f70a) {
            o();
        }
        byte[] bArr = (byte[]) this.c;
        int i6 = this.b;
        this.b = i6 + 1;
        bArr[i6] = b;
    }

    public void v(AbstractC0244e abstractC0244e) throws IOException {
        int size = abstractC0244e.size();
        byte[] bArr = (byte[]) this.c;
        int i = this.f70a;
        int i6 = this.b;
        int i10 = i - i6;
        if (i10 >= size) {
            abstractC0244e.e(bArr, 0, i6, size);
            this.b += size;
            return;
        }
        abstractC0244e.e(bArr, 0, i6, i10);
        int i11 = size - i10;
        this.b = i;
        o();
        if (i11 <= i) {
            abstractC0244e.e(bArr, i10, 0, i11);
            this.b = i11;
            return;
        }
        OutputStream outputStream = (OutputStream) this.d;
        if (i10 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i10);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append("Length < 0: ");
            sb2.append(i11);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i12 = i10 + i11;
        if (i12 <= abstractC0244e.size()) {
            if (i11 > 0) {
                abstractC0244e.r(outputStream, i10, i11);
            }
        } else {
            StringBuilder sb3 = new StringBuilder(39);
            sb3.append("Source end offset exceeded: ");
            sb3.append(i12);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public void w(byte[] bArr) throws IOException {
        int length = bArr.length;
        byte[] bArr2 = (byte[]) this.c;
        int i = this.f70a;
        int i6 = this.b;
        int i10 = i - i6;
        if (i10 >= length) {
            System.arraycopy(bArr, 0, bArr2, i6, length);
            this.b += length;
            return;
        }
        System.arraycopy(bArr, 0, bArr2, i6, i10);
        int i11 = length - i10;
        this.b = i;
        o();
        if (i11 > i) {
            ((OutputStream) this.d).write(bArr, i10, i11);
        } else {
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            this.b = i11;
        }
    }

    public void x(int i) throws IOException {
        u(i & 255);
        u((i >> 8) & 255);
        u((i >> 16) & 255);
        u((i >> 24) & 255);
    }

    public void y(long j5) throws IOException {
        u(((int) j5) & 255);
        u(((int) (j5 >> 8)) & 255);
        u(((int) (j5 >> 16)) & 255);
        u(((int) (j5 >> 24)) & 255);
        u(((int) (j5 >> 32)) & 255);
        u(((int) (j5 >> 40)) & 255);
        u(((int) (j5 >> 48)) & 255);
        u(((int) (j5 >> 56)) & 255);
    }

    public void z(int i) throws IOException {
        while ((i & (-128)) != 0) {
            u((i & 127) | 128);
            i >>>= 7;
        }
        u(i);
    }
}
