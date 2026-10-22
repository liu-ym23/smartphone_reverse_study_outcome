package Z;

import d0.InterfaceC0649d;
import d0.InterfaceC0650e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class j implements InterfaceC0650e, InterfaceC0649d {

    /* renamed from: i, reason: collision with root package name */
    static final TreeMap<Integer, j> f6598i = new TreeMap<>();

    /* renamed from: a, reason: collision with root package name */
    private volatile String f6599a;

    /* renamed from: b, reason: collision with root package name */
    final long[] f6600b;

    /* renamed from: c, reason: collision with root package name */
    final double[] f6601c;

    /* renamed from: d, reason: collision with root package name */
    final String[] f6602d;

    /* renamed from: e, reason: collision with root package name */
    final byte[][] f6603e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f6604f;

    /* renamed from: g, reason: collision with root package name */
    final int f6605g;

    /* renamed from: h, reason: collision with root package name */
    int f6606h;

    private j(int i5) {
        this.f6605g = i5;
        int i6 = i5 + 1;
        this.f6604f = new int[i6];
        this.f6600b = new long[i6];
        this.f6601c = new double[i6];
        this.f6602d = new String[i6];
        this.f6603e = new byte[i6][];
    }

    public static j f(String str, int i5) {
        TreeMap<Integer, j> treeMap = f6598i;
        synchronized (treeMap) {
            try {
                Map.Entry<Integer, j> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i5));
                if (entryCeilingEntry == null) {
                    j jVar = new j(i5);
                    jVar.m(str, i5);
                    return jVar;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                j value = entryCeilingEntry.getValue();
                value.m(str, i5);
                return value;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void o() {
        TreeMap<Integer, j> treeMap = f6598i;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator<Integer> it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i5 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i5;
        }
    }

    @Override // d0.InterfaceC0649d
    public void F(int i5, byte[] bArr) {
        this.f6604f[i5] = 5;
        this.f6603e[i5] = bArr;
    }

    @Override // d0.InterfaceC0649d
    public void Z(int i5) {
        this.f6604f[i5] = 1;
    }

    @Override // d0.InterfaceC0650e
    public void a(InterfaceC0649d interfaceC0649d) {
        for (int i5 = 1; i5 <= this.f6606h; i5++) {
            int i6 = this.f6604f[i5];
            if (i6 == 1) {
                interfaceC0649d.Z(i5);
            } else if (i6 == 2) {
                interfaceC0649d.z(i5, this.f6600b[i5]);
            } else if (i6 == 3) {
                interfaceC0649d.q(i5, this.f6601c[i5]);
            } else if (i6 == 4) {
                interfaceC0649d.l(i5, this.f6602d[i5]);
            } else if (i6 == 5) {
                interfaceC0649d.F(i5, this.f6603e[i5]);
            }
        }
    }

    @Override // d0.InterfaceC0650e
    public String c() {
        return this.f6599a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // d0.InterfaceC0649d
    public void l(int i5, String str) {
        this.f6604f[i5] = 4;
        this.f6602d[i5] = str;
    }

    void m(String str, int i5) {
        this.f6599a = str;
        this.f6606h = i5;
    }

    @Override // d0.InterfaceC0649d
    public void q(int i5, double d6) {
        this.f6604f[i5] = 3;
        this.f6601c[i5] = d6;
    }

    public void r() {
        TreeMap<Integer, j> treeMap = f6598i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f6605g), this);
            o();
        }
    }

    @Override // d0.InterfaceC0649d
    public void z(int i5, long j5) {
        this.f6604f[i5] = 2;
        this.f6600b[i5] = j5;
    }
}
