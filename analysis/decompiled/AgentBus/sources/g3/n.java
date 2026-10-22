package g3;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class n implements m3.c, m3.b {

    /* renamed from: n, reason: collision with root package name */
    public static final TreeMap f3825n = new TreeMap();

    /* renamed from: f, reason: collision with root package name */
    public final int f3826f;

    /* renamed from: g, reason: collision with root package name */
    public volatile String f3827g;

    /* renamed from: h, reason: collision with root package name */
    public final long[] f3828h;

    /* renamed from: i, reason: collision with root package name */
    public final double[] f3829i;

    /* renamed from: j, reason: collision with root package name */
    public final String[] f3830j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[][] f3831k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f3832l;

    /* renamed from: m, reason: collision with root package name */
    public int f3833m;

    public n(int i2) {
        this.f3826f = i2;
        int i10 = i2 + 1;
        this.f3832l = new int[i10];
        this.f3828h = new long[i10];
        this.f3829i = new double[i10];
        this.f3830j = new String[i10];
        this.f3831k = new byte[i10][];
    }

    public static final n d(int i2, String str) {
        TreeMap treeMap = f3825n;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (entryCeilingEntry == null) {
                n nVar = new n(i2);
                nVar.f3827g = str;
                nVar.f3833m = i2;
                return nVar;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            n nVar2 = (n) entryCeilingEntry.getValue();
            nVar2.f3827g = str;
            nVar2.f3833m = i2;
            return nVar2;
        }
    }

    @Override // m3.b
    public final void G(int i2, long j2) {
        this.f3832l[i2] = 2;
        this.f3828h[i2] = j2;
    }

    @Override // m3.b
    public final void I(int i2, byte[] bArr) {
        this.f3832l[i2] = 5;
        this.f3831k[i2] = bArr;
    }

    @Override // m3.c
    public final String a() {
        String str = this.f3827g;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // m3.c
    public final void b(m3.b bVar) {
        int i2 = this.f3833m;
        if (1 > i2) {
            return;
        }
        int i10 = 1;
        while (true) {
            int i11 = this.f3832l[i10];
            if (i11 == 1) {
                bVar.u(i10);
            } else if (i11 == 2) {
                bVar.G(i10, this.f3828h[i10]);
            } else if (i11 == 3) {
                bVar.x(i10, this.f3829i[i10]);
            } else if (i11 == 4) {
                String str = this.f3830j[i10];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                bVar.l(i10, str);
            } else if (i11 == 5) {
                byte[] bArr = this.f3831k[i10];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                bVar.I(i10, bArr);
            }
            if (i10 == i2) {
                return;
            } else {
                i10++;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final void e() {
        TreeMap treeMap = f3825n;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f3826f), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                q7.k.d(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i2 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i2;
                }
            }
        }
    }

    @Override // m3.b
    public final void l(int i2, String str) {
        q7.k.e(str, "value");
        this.f3832l[i2] = 4;
        this.f3830j[i2] = str;
    }

    @Override // m3.b
    public final void u(int i2) {
        this.f3832l[i2] = 1;
    }

    @Override // m3.b
    public final void x(int i2, double d6) {
        this.f3832l[i2] = 3;
        this.f3829i[i2] = d6;
    }
}
