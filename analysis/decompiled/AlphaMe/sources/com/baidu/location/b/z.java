package com.baidu.location.b;

import android.location.Location;
import android.net.wifi.ScanResult;
import com.baidu.location.Jni;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class z {

    /* renamed from: B, reason: collision with root package name */
    private int f5532B;

    /* renamed from: a, reason: collision with root package name */
    long f5533a = 0;

    /* renamed from: z, reason: collision with root package name */
    private a f5534z;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<String> f5508b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<String> f5509c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<String> f5510d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private static String f5511e = B0.g.r(new StringBuilder(), com.baidu.location.e.g.f5888a, "/yo.dat");

    /* renamed from: f, reason: collision with root package name */
    private static String f5512f = B0.g.r(new StringBuilder(), com.baidu.location.e.g.f5888a, "/yoh.dat");

    /* renamed from: g, reason: collision with root package name */
    private static String f5513g = B0.g.r(new StringBuilder(), com.baidu.location.e.g.f5888a, "/yom.dat");

    /* renamed from: h, reason: collision with root package name */
    private static String f5514h = B0.g.r(new StringBuilder(), com.baidu.location.e.g.f5888a, "/yol.dat");

    /* renamed from: i, reason: collision with root package name */
    private static String f5515i = B0.g.r(new StringBuilder(), com.baidu.location.e.g.f5888a, "/yor.dat");

    /* renamed from: j, reason: collision with root package name */
    private static File f5516j = null;

    /* renamed from: k, reason: collision with root package name */
    private static int f5517k = 8;

    /* renamed from: l, reason: collision with root package name */
    private static int f5518l = 8;

    /* renamed from: m, reason: collision with root package name */
    private static int f5519m = 16;

    /* renamed from: n, reason: collision with root package name */
    private static int f5520n = 2048;

    /* renamed from: o, reason: collision with root package name */
    private static double f5521o = 0.0d;

    /* renamed from: p, reason: collision with root package name */
    private static double f5522p = 0.1d;

    /* renamed from: q, reason: collision with root package name */
    private static double f5523q = 30.0d;

    /* renamed from: r, reason: collision with root package name */
    private static double f5524r = 100.0d;

    /* renamed from: s, reason: collision with root package name */
    private static int f5525s = 0;

    /* renamed from: t, reason: collision with root package name */
    private static int f5526t = 64;

    /* renamed from: u, reason: collision with root package name */
    private static int f5527u = 128;

    /* renamed from: v, reason: collision with root package name */
    private static Location f5528v = null;

    /* renamed from: w, reason: collision with root package name */
    private static Location f5529w = null;

    /* renamed from: x, reason: collision with root package name */
    private static Location f5530x = null;

    /* renamed from: y, reason: collision with root package name */
    private static com.baidu.location.c.k f5531y = null;

    /* renamed from: A, reason: collision with root package name */
    private static z f5506A = null;

    /* renamed from: C, reason: collision with root package name */
    private static long f5507C = 0;

    private z() {
        this.f5534z = null;
        this.f5532B = 0;
        this.f5534z = new a();
        this.f5532B = 0;
        String strI = com.baidu.location.e.h.i();
        if (strI != null) {
            f5511e = strI.concat("/yo2.dat");
            f5512f = strI.concat("/yoh2.dat");
            f5513g = strI.concat("/yom2.dat");
            f5514h = strI.concat("/yol2.dat");
            f5515i = strI.concat("/yor2.dat");
        }
    }

    private static synchronized int a(List<String> list, int i4) {
        if (list != null && i4 <= 256) {
            if (i4 >= 0) {
                try {
                    if (f5516j == null) {
                        File file = new File(f5511e);
                        f5516j = file;
                        if (!file.exists()) {
                            f5516j = null;
                            return -2;
                        }
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(f5516j, "rw");
                    if (randomAccessFile.length() < 1) {
                        randomAccessFile.close();
                        return -3;
                    }
                    long j4 = i4;
                    randomAccessFile.seek(j4);
                    int i5 = randomAccessFile.readInt();
                    int i6 = randomAccessFile.readInt();
                    int i7 = randomAccessFile.readInt();
                    int i8 = randomAccessFile.readInt();
                    long j5 = randomAccessFile.readLong();
                    long j6 = j5;
                    if (a(i5, i6, i7, i8, j5)) {
                        int i9 = 1;
                        if (i6 >= 1) {
                            byte[] bArr = new byte[f5520n];
                            int i10 = f5517k;
                            while (i10 > 0 && i6 > 0) {
                                long j7 = (((i5 + i6) - i9) % i7) * i8;
                                byte[] bArr2 = bArr;
                                long j8 = j6;
                                randomAccessFile.seek(j7 + j8);
                                int i11 = randomAccessFile.readInt();
                                if (i11 > 0 && i11 < i8) {
                                    randomAccessFile.read(bArr2, 0, i11);
                                    int i12 = i11 - 1;
                                    if (bArr2[i12] == 0) {
                                        list.add(new String(bArr2, 0, i12));
                                    }
                                }
                                i10--;
                                i6--;
                                j6 = j8;
                                bArr = bArr2;
                                i9 = 1;
                            }
                            randomAccessFile.seek(j4);
                            randomAccessFile.writeInt(i5);
                            randomAccessFile.writeInt(i6);
                            randomAccessFile.writeInt(i7);
                            randomAccessFile.writeInt(i8);
                            randomAccessFile.writeLong(j6);
                            randomAccessFile.close();
                            return f5517k - i10;
                        }
                    }
                    randomAccessFile.close();
                    return -4;
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return -5;
                }
            }
        }
        return -1;
    }

    public static String b() {
        return f();
    }

    public static void d() {
        f5518l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        f5518l = 8;
    }

    public static String e() throws IOException {
        File file = new File(f5513g);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20L);
                int i4 = randomAccessFile.readInt();
                if (i4 > 128) {
                    String str = "&p1=" + i4;
                    randomAccessFile.seek(20L);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.close();
                    return str;
                }
                randomAccessFile.close();
            } catch (Exception unused) {
            }
        }
        File file2 = new File(f5514h);
        if (file2.exists()) {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                randomAccessFile2.seek(20L);
                int i5 = randomAccessFile2.readInt();
                if (i5 > 256) {
                    String str2 = "&p2=" + i5;
                    randomAccessFile2.seek(20L);
                    randomAccessFile2.writeInt(0);
                    randomAccessFile2.close();
                    return str2;
                }
                randomAccessFile2.close();
            } catch (Exception unused2) {
            }
        }
        File file3 = new File(f5515i);
        if (file3.exists()) {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, "rw");
                randomAccessFile3.seek(20L);
                int i6 = randomAccessFile3.readInt();
                if (i6 > 512) {
                    String str3 = "&p3=" + i6;
                    randomAccessFile3.seek(20L);
                    randomAccessFile3.writeInt(0);
                    randomAccessFile3.close();
                    return str3;
                }
                randomAccessFile3.close();
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    private static String f() throws IOException {
        String strA = null;
        for (int i4 = 1; i4 < 5; i4++) {
            strA = a(i4);
            if (strA != null) {
                return strA;
            }
        }
        a(f5510d, f5526t);
        try {
            if (f5510d.size() > 0) {
                String str = f5510d.get(0);
                try {
                    f5510d.remove(0);
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                strA = str;
            }
        } catch (ArrayIndexOutOfBoundsException unused2) {
        }
        if (strA != null) {
            return strA;
        }
        a(f5510d, f5525s);
        try {
            if (f5510d.size() > 0) {
                String str2 = f5510d.get(0);
                try {
                    f5510d.remove(0);
                } catch (ArrayIndexOutOfBoundsException unused3) {
                }
                strA = str2;
            }
        } catch (ArrayIndexOutOfBoundsException unused4) {
        }
        if (strA != null) {
            return strA;
        }
        a(f5510d, f5527u);
        try {
            if (f5510d.size() <= 0) {
                return strA;
            }
            String str3 = f5510d.get(0);
            try {
                f5510d.remove(0);
            } catch (ArrayIndexOutOfBoundsException unused5) {
            }
            return str3;
        } catch (ArrayIndexOutOfBoundsException unused6) {
            return strA;
        }
    }

    public void c() {
        if (com.baidu.location.c.f.a().l() && !com.baidu.location.e.h.b()) {
            this.f5534z.b();
        }
    }

    public static synchronized z a() {
        try {
            if (f5506A == null) {
                f5506A = new z();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5506A;
    }

    private static void b(String str) {
        e(str);
    }

    private static void c(String str) {
        e(str);
    }

    private static void d(String str) throws IOException {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.e.g.f5888a);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(32);
            randomAccessFile.writeInt(2048);
            randomAccessFile.writeInt(BmLocated.HALF_LEFT_TOP);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    private static synchronized void e(String str) {
        ArrayList<String> arrayList;
        try {
            if (str.contains("err!")) {
                return;
            }
            int i4 = com.baidu.location.e.h.f5930p;
            if (i4 == 1) {
                arrayList = f5508b;
            } else if (i4 == 2) {
                arrayList = f5509c;
            } else if (i4 != 3) {
                return;
            } else {
                arrayList = f5510d;
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() <= f5519m) {
                arrayList.add(str);
            }
            if (arrayList.size() >= f5519m) {
                a(i4, false);
            }
            while (arrayList.size() > f5519m) {
                arrayList.remove(0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static String a(int i4) throws IOException {
        String str;
        ArrayList<String> arrayList;
        String str2 = null;
        if (i4 == 1) {
            str = f5512f;
            arrayList = f5508b;
        } else if (i4 == 2) {
            str = f5513g;
            arrayList = f5509c;
        } else {
            if (i4 == 3) {
                str = f5514h;
            } else {
                if (i4 != 4) {
                    return null;
                }
                str = f5515i;
            }
            arrayList = f5510d;
        }
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() < 1) {
            a(str, arrayList);
        }
        synchronized (z.class) {
            int size = arrayList.size();
            if (size > 0) {
                int i5 = size - 1;
                try {
                    String str3 = arrayList.get(i5);
                    try {
                        arrayList.remove(i5);
                    } catch (Exception unused) {
                    }
                    str2 = str3;
                } catch (Exception unused2) {
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce A[EDGE_INSN: B:51:0x00ce->B:42:0x00ce BREAK  A[LOOP:0: B:28:0x005b->B:40:0x00ca], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(int r14, boolean r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.z.a(int, boolean):void");
    }

    public static void a(com.baidu.location.c.a aVar, com.baidu.location.c.k kVar, Location location, String str, String str2) {
        if ((com.baidu.location.e.h.f5935u == 3 && !a(location, kVar) && !a(location, false)) || aVar == null || aVar.c()) {
            return;
        }
        if (aVar.a()) {
            if (!a(location, kVar)) {
                kVar = null;
            }
            String strR = B0.g.r(new StringBuilder(), com.baidu.location.e.h.a(aVar, kVar, location, str, 1), str2);
            if (strR != null) {
                a(Jni.encodeTp4(strR));
                f5529w = location;
                f5528v = location;
                if (kVar != null) {
                    f5531y = kVar;
                    return;
                }
                return;
            }
            return;
        }
        if (kVar != null && kVar.c() && a(location, kVar)) {
            if (!a(location) && !com.baidu.location.c.f.a().e()) {
                str = B0.g.m("&cfr=1", str);
            } else if (!a(location) && com.baidu.location.c.f.a().e()) {
                str = B0.g.m("&cfr=3", str);
            } else if (com.baidu.location.c.f.a().e()) {
                str = B0.g.m("&cfr=2", str);
            }
            String strR2 = B0.g.r(new StringBuilder(), com.baidu.location.e.h.a(aVar, kVar, location, str, 2), str2);
            if (strR2 != null) {
                b(Jni.encodeTp4(strR2));
                f5530x = location;
                f5528v = location;
                f5531y = kVar;
                return;
            }
            return;
        }
        if (!a(location) && !com.baidu.location.c.f.a().e()) {
            str = B0.g.m("&cfr=1", str);
        } else if (!a(location) && com.baidu.location.c.f.a().e()) {
            str = B0.g.m("&cfr=3", str);
        } else if (com.baidu.location.c.f.a().e()) {
            str = B0.g.m("&cfr=2", str);
        }
        if (!a(location, kVar)) {
            kVar = null;
        }
        String strR3 = B0.g.r(new StringBuilder(), com.baidu.location.e.h.a(aVar, kVar, location, str, 3), str2);
        if (strR3 != null) {
            c(Jni.encodeTp4(strR3));
            f5528v = location;
            if (kVar != null) {
                f5531y = kVar;
            }
        }
    }

    public class a extends com.baidu.location.e.f {

        /* renamed from: a, reason: collision with root package name */
        boolean f5535a = false;

        /* renamed from: b, reason: collision with root package name */
        int f5536b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f5537c = 0;

        /* renamed from: e, reason: collision with root package name */
        private ArrayList<String> f5539e = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name */
        private boolean f5540f = true;

        public a() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            Map<String, Object> map;
            String str;
            if (this.f5536b != 1) {
                this.eh = com.baidu.location.e.h.d();
            }
            this.ei = 2;
            if (this.f5539e != null) {
                for (int i4 = 0; i4 < this.f5539e.size(); i4++) {
                    if (this.f5536b == 1) {
                        map = this.el;
                        str = "cldc[";
                    } else {
                        map = this.el;
                        str = "cltr[";
                    }
                    map.put(B0.g.j(str, i4, "]"), this.f5539e.get(i4));
                }
                this.el.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
                if (this.f5536b != 1) {
                    this.el.put("qt", "cltrg");
                }
            }
        }

        public synchronized void b() {
            ExecutorService executorServiceC;
            String strD;
            String strD2;
            int i4;
            if (this.f5535a) {
                return;
            }
            int i5 = com.baidu.location.e.f.et;
            if (i5 > 4 && (i4 = this.f5537c) < i5) {
                this.f5537c = i4 + 1;
                return;
            }
            this.f5537c = 0;
            this.f5535a = true;
            this.f5536b = 0;
            try {
                ArrayList<String> arrayList = this.f5539e;
                if (arrayList == null || arrayList.size() < 1) {
                    if (this.f5539e == null) {
                        this.f5539e = new ArrayList<>();
                    }
                    this.f5536b = 0;
                    int length = 0;
                    while (true) {
                        String strA = null;
                        String strB = this.f5536b < 2 ? z.b() : null;
                        if (strB == null && this.f5536b != 1 && this.f5540f) {
                            this.f5536b = 2;
                            try {
                                strA = j.a();
                            } catch (Exception unused) {
                            }
                        } else {
                            this.f5536b = 1;
                            strA = strB;
                        }
                        if (strA == null) {
                            break;
                        }
                        if (!strA.contains("err!")) {
                            this.f5539e.add(strA);
                            length += strA.length();
                            if (length >= com.baidu.location.e.a.f5781h) {
                                break;
                            }
                        }
                    }
                }
                ArrayList<String> arrayList2 = this.f5539e;
                if (arrayList2 == null || arrayList2.size() < 1) {
                    ArrayList<String> arrayList3 = this.f5539e;
                    if (arrayList3 != null) {
                        arrayList3.clear();
                    }
                    this.f5535a = false;
                    return;
                }
                if (this.f5536b != 1) {
                    executorServiceC = x.a().c();
                    if (executorServiceC != null) {
                        strD2 = com.baidu.location.e.h.d();
                        a(executorServiceC, strD2);
                    } else {
                        strD = com.baidu.location.e.h.d();
                        b(strD);
                    }
                } else {
                    executorServiceC = x.a().c();
                    if (executorServiceC != null) {
                        strD2 = com.baidu.location.e.d.f5843e;
                        a(executorServiceC, strD2);
                    } else {
                        strD = com.baidu.location.e.d.f5843e;
                        b(strD);
                    }
                }
            } catch (Exception unused2) {
                ArrayList<String> arrayList4 = this.f5539e;
                if (arrayList4 != null) {
                    arrayList4.clear();
                }
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z4) {
            if (z4 && this.ej != null) {
                ArrayList<String> arrayList = this.f5539e;
                if (arrayList != null) {
                    arrayList.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.ej);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f5540f = false;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
            this.f5535a = false;
        }
    }

    private static void a(String str) {
        e(str);
    }

    private static boolean a(int i4, int i5, int i6, int i7, long j4) {
        return i4 >= 0 && i4 < i6 && i5 >= 0 && i5 <= i6 && i6 >= 0 && i6 <= 1024 && i7 >= 128 && i7 <= 1024;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        Location location2 = f5529w;
        if (location2 == null || f5528v == null) {
            f5529w = location;
            return true;
        }
        double dDistanceTo = location.distanceTo(location2);
        return ((double) location.distanceTo(f5528v)) > ((((double) com.baidu.location.e.h.T) * dDistanceTo) + ((((double) com.baidu.location.e.h.f5908S) * dDistanceTo) * dDistanceTo)) + ((double) com.baidu.location.e.h.f5909U);
    }

    private static boolean a(Location location, com.baidu.location.c.k kVar) {
        List<ScanResult> list;
        boolean z4 = false;
        if (location != null && kVar != null && (list = kVar.f5755a) != null && !list.isEmpty()) {
            if (kVar.a(f5531y)) {
                return false;
            }
            z4 = true;
            if (f5530x == null) {
                f5530x = location;
            }
        }
        return z4;
    }

    public static boolean a(Location location, boolean z4) {
        return com.baidu.location.c.d.a(f5528v, location, z4);
    }

    private static boolean a(String str, List<String> list) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(8L);
            int i4 = randomAccessFile.readInt();
            int i5 = randomAccessFile.readInt();
            int i6 = randomAccessFile.readInt();
            byte[] bArr = new byte[f5520n];
            int i7 = f5518l + 1;
            boolean z4 = false;
            while (i7 > 0 && i5 > 0) {
                if (i5 < i6) {
                    i6 = 0;
                }
                try {
                    randomAccessFile.seek(((i5 - 1) * i4) + 128);
                    int i8 = randomAccessFile.readInt();
                    if (i8 > 0 && i8 < i4) {
                        randomAccessFile.read(bArr, 0, i8);
                        int i9 = i8 - 1;
                        if (bArr[i9] == 0) {
                            list.add(0, new String(bArr, 0, i9));
                            z4 = true;
                        }
                    }
                    i7--;
                    i5--;
                } catch (Exception unused) {
                    return z4;
                }
            }
            randomAccessFile.seek(12L);
            randomAccessFile.writeInt(i5);
            randomAccessFile.writeInt(i6);
            randomAccessFile.close();
            return z4;
        } catch (Exception unused2) {
            return false;
        }
    }
}
