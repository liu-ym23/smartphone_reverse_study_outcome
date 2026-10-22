package com.baidu.b.b;

import B0.g;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.AbstractC0351g;
import com.baidu.b.a.e;
import com.baidu.b.b.a;
import com.baidu.b.h;
import com.stepos.activeview.utils.Constants;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;

/* loaded from: classes.dex */
public class e extends com.baidu.b.b.a {

    /* renamed from: d, reason: collision with root package name */
    private Context f4769d;

    /* renamed from: e, reason: collision with root package name */
    private f f4770e;

    public static final class a implements Comparable {

        /* renamed from: a, reason: collision with root package name */
        private static final String[] f4771a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: b, reason: collision with root package name */
        private final int f4772b;

        private a(int i4) {
            this.f4772b = i4;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return this.f4772b - aVar.f4772b;
        }

        public byte b() {
            return (byte) this.f4772b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && a.class == obj.getClass() && this.f4772b == ((a) obj).f4772b;
        }

        public int hashCode() {
            return this.f4772b;
        }

        public static a a(byte b4, boolean z4) {
            return a(z4 ? (b4 & UByte.MAX_VALUE) >> 4 : b4 & 15);
        }

        public static a a(int i4) {
            if (i4 < 0 || i4 >= 16) {
                throw new IllegalArgumentException(AbstractC0351g.m("invalid idx ", i4));
            }
            return new a(i4);
        }

        public String a() {
            return f4771a[this.f4772b];
        }
    }

    public class b {

        /* renamed from: b, reason: collision with root package name */
        private int f4774b = 33;

        /* renamed from: c, reason: collision with root package name */
        private a[] f4775c = new a[33];

        /* renamed from: d, reason: collision with root package name */
        private int f4776d;

        public b() {
        }

        private void b(int i4) {
            a[] aVarArr = this.f4775c;
            if (i4 - aVarArr.length > 0) {
                int length = aVarArr.length;
                int i5 = length + (length >> 1);
                if (i5 - i4 >= 0) {
                    i4 = i5;
                }
                this.f4775c = (a[]) Arrays.copyOf(aVarArr, i4);
            }
        }

        public int a() {
            return this.f4776d;
        }

        public a a(int i4) {
            if (i4 < this.f4776d) {
                return this.f4775c[i4];
            }
            StringBuilder sbT = g.t("idx ", i4, " size ");
            sbT.append(this.f4776d);
            throw new IndexOutOfBoundsException(sbT.toString());
        }

        public byte[] b() {
            int i4;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i5 = 0;
            while (true) {
                i4 = this.f4776d;
                if (i5 >= i4 / 2) {
                    break;
                }
                int i6 = i5 * 2;
                byteArrayOutputStream.write((byte) (((a(i6 + 1).b() & UByte.MAX_VALUE) << 4) | (a(i6).b() & UByte.MAX_VALUE)));
                i5++;
            }
            if (i4 % 2 != 0) {
                byteArrayOutputStream.write((byte) (a(i4 - 1).b() & UByte.MAX_VALUE));
            }
            return byteArrayOutputStream.toByteArray();
        }

        public void a(a aVar) {
            b(this.f4776d + 1);
            a[] aVarArr = this.f4775c;
            int i4 = this.f4776d;
            this.f4776d = i4 + 1;
            aVarArr[i4] = aVar;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private List f4777a = new ArrayList();

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f4778a;

            /* renamed from: b, reason: collision with root package name */
            private a f4779b;

            public a(a aVar) {
                this.f4779b = aVar;
            }

            public void a() {
                this.f4778a++;
            }
        }

        public List a() {
            ArrayList arrayList = new ArrayList(this.f4777a);
            Collections.sort(arrayList, new com.baidu.b.b.f(this));
            return arrayList;
        }

        public void a(a aVar) {
            this.f4777a.add(new a(aVar));
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        byte[] f4780a;

        /* renamed from: b, reason: collision with root package name */
        byte f4781b;

        /* renamed from: c, reason: collision with root package name */
        byte[] f4782c;

        public d(byte[] bArr, byte b4, byte[] bArr2) {
            this.f4780a = bArr;
            this.f4781b = b4;
            this.f4782c = bArr2;
        }

        public h.a a() {
            try {
                String strA = com.baidu.b.d.b.a(this.f4780a, "", true);
                String str = new String(new byte[]{this.f4781b}, Constants.UTF_8_CODE);
                byte[] bArr = this.f4782c;
                return h.a(strA, str, bArr != null ? new String(bArr, Constants.UTF_8_CODE) : null);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* renamed from: com.baidu.b.b.e$e, reason: collision with other inner class name */
    public static class C0006e {

        /* renamed from: a, reason: collision with root package name */
        public int f4783a;

        /* renamed from: b, reason: collision with root package name */
        public int f4784b;

        /* renamed from: c, reason: collision with root package name */
        public int f4785c = 16;

        public String toString() {
            return "";
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private Method f4786a;

        /* renamed from: b, reason: collision with root package name */
        private Method f4787b;

        /* renamed from: c, reason: collision with root package name */
        private Method f4788c;

        /* renamed from: d, reason: collision with root package name */
        private Method f4789d;

        /* renamed from: e, reason: collision with root package name */
        private Method f4790e;

        public int a(Context context, Uri uri, int i4, int i5, int i6) throws e.a {
            try {
                return ((Integer) this.f4786a.invoke(context, uri, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6))).intValue();
            } catch (Exception e4) {
                throw new e.a(e4);
            }
        }

        public void a() {
            try {
                String strA = com.baidu.b.a.e.a(com.baidu.b.a.d.d());
                Class cls = Integer.TYPE;
                this.f4786a = com.baidu.b.a.e.a(Context.class, strA, new Class[]{Uri.class, cls, cls, cls});
                this.f4787b = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.e()), new Class[]{String.class, Uri.class, cls});
                this.f4788c = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(com.baidu.b.a.d.f()), new Class[]{Uri.class, cls});
                this.f4789d = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(com.baidu.b.a.d.g()), new Class[]{Uri.class, cls});
                this.f4790e = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(com.baidu.b.a.d.h()), new Class[]{Uri.class, cls});
            } catch (Exception unused) {
            }
        }
    }

    public e() {
        super("upc", 9000000L);
        f fVar = new f();
        this.f4770e = fVar;
        fVar.a();
    }

    @Override // com.baidu.b.b.a
    public a.e a(String str, a.d dVar) throws PackageManager.NameNotFoundException {
        int packageUid;
        byte[] bArrB;
        int i4;
        Byte bValueOf;
        Byte bValueOf2;
        int i5 = 3;
        boolean z4 = false;
        try {
            packageUid = this.f4769d.getPackageManager().getPackageUid(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageUid = -1;
        }
        int i6 = packageUid;
        if (i6 < 0) {
            return a.e.a();
        }
        C0006e c0006e = new C0006e();
        b bVar = new b();
        c cVar = new c();
        c cVar2 = new c();
        for (int i7 = 0; i7 < 16; i7++) {
            a aVarA = a.a(i7);
            if (a(str, aVarA, i6)) {
                cVar.a(aVarA);
            } else {
                cVar2.a(aVarA);
            }
        }
        int i8 = 0;
        while (true) {
            int i9 = 32;
            if (i8 >= 32) {
                byte[] bArrB2 = bVar.b();
                byte[] bArr = {"0".getBytes()[0], "O".getBytes()[0], ExifInterface.GPS_MEASUREMENT_INTERRUPTED.getBytes()[0]};
                int i10 = 0;
                while (true) {
                    bArrB = null;
                    if (i10 >= i5) {
                        i4 = i9;
                        bValueOf = null;
                        break;
                    }
                    byte b4 = bArr[i10];
                    a aVarA2 = a.a(b4, false);
                    int i11 = i10;
                    i4 = i9;
                    byte[] bArr2 = bArr;
                    if (a(str, 32, aVarA2, i6, c0006e)) {
                        a aVarA3 = a.a(b4, true);
                        if (a(str, 33, aVarA3, i6, c0006e)) {
                            b bVar2 = new b();
                            bVar2.a(aVarA2);
                            bVar2.a(aVarA3);
                            bValueOf = Byte.valueOf(bVar2.b()[0]);
                            break;
                        }
                    }
                    i10 = i11 + 1;
                    i9 = i4;
                    bArr = bArr2;
                    i5 = 3;
                }
                if (bValueOf == null) {
                    b bVar3 = new b();
                    int i12 = i4;
                    for (int i13 = 34; i12 < i13; i13 = 34) {
                        int i14 = i12;
                        b bVar4 = bVar3;
                        a aVarA4 = a(str, i12, cVar.a(), i6, c0006e);
                        if (aVarA4 == null) {
                            aVarA4 = a(str, i14, cVar2.a(), i6, c0006e);
                        }
                        if (aVarA4 == null) {
                            return a.e.a();
                        }
                        bVar4.a(aVarA4);
                        i12 = i14 + 1;
                        bVar3 = bVar4;
                    }
                    bValueOf2 = Byte.valueOf(bVar3.b()[0]);
                    z4 = true;
                } else {
                    bValueOf2 = bValueOf;
                }
                if (z4) {
                    b bVar5 = new b();
                    int i15 = 34;
                    while (i15 < 94) {
                        int i16 = i15;
                        a aVarA5 = a(str, i15, cVar.a(), i6, c0006e);
                        if (aVarA5 == null) {
                            aVarA5 = a(str, i16, cVar2.a(), i6, c0006e);
                        }
                        if (aVarA5 == null) {
                            break;
                        }
                        bVar5.a(aVarA5);
                        i15 = i16 + 1;
                    }
                    if (bVar5.a() > 0) {
                        bArrB = bVar5.b();
                    }
                }
                return a.e.a(new d(bArrB2, bValueOf2.byteValue(), bArrB).a());
            }
            int i17 = i8;
            a aVarA6 = a(str, i8, cVar.a(), i6, c0006e);
            if (aVarA6 == null) {
                aVarA6 = a(str, i17, cVar2.a(), i6, c0006e);
            }
            if (aVarA6 == null) {
                return a.e.a();
            }
            bVar.a(aVarA6);
            i8 = i17 + 1;
        }
    }

    private a a(String str, int i4, List list, int i5, C0006e c0006e) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c.a aVar = (c.a) it.next();
            if (a(str, i4, aVar.f4779b, i5, c0006e)) {
                aVar.a();
                return aVar.f4779b;
            }
        }
        return null;
    }

    private String a(String str) {
        return AbstractC0351g.p(str, ".cesium");
    }

    private String a(String str, int i4, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", a(str), Integer.valueOf(i4), aVar.a());
    }

    private String a(String str, a aVar) {
        return "content://" + a(str) + "/dic/v1/" + aVar.a();
    }

    @Override // com.baidu.b.b.a
    public void a(a.c cVar) {
        this.f4769d = this.f4737b.f4741a;
    }

    private boolean a(String str, int i4, a aVar, int i5, C0006e c0006e) throws InterruptedException {
        Uri uri = Uri.parse(a(str, i4, aVar));
        int i6 = 0;
        while (true) {
            if (i6 >= 2) {
                break;
            }
            if (c0006e != null) {
                try {
                    c0006e.f4783a++;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i6++;
                }
            }
            if (this.f4770e.a(this.f4769d, uri, 0, i5, 1) == 0) {
                return true;
            }
        }
        if (c0006e != null) {
            c0006e.f4784b++;
        }
        return false;
    }

    private boolean a(String str, a aVar, int i4) throws InterruptedException {
        Uri uri = Uri.parse(a(str, aVar));
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                break;
            }
            try {
                if (this.f4770e.a(this.f4769d, uri, 0, i4, 1) == 0) {
                    return true;
                }
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5L);
                } catch (Exception unused2) {
                }
                i5++;
            }
        }
        return false;
    }
}
