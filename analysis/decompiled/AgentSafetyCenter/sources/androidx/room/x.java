package androidx.room;

import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x implements y4.e, y4.d {

    /* renamed from: m, reason: collision with root package name */
    public static final TreeMap f1644m = new TreeMap();

    /* renamed from: c, reason: collision with root package name */
    public int f1645c;

    /* renamed from: f, reason: collision with root package name */
    public volatile String f1646f;

    /* renamed from: g, reason: collision with root package name */
    public long[] f1647g;

    /* renamed from: h, reason: collision with root package name */
    public double[] f1648h;
    public String[] i;

    /* renamed from: j, reason: collision with root package name */
    public byte[][] f1649j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f1650k;

    /* renamed from: l, reason: collision with root package name */
    public int f1651l;

    public static final x d(int i, String str) {
        TreeMap treeMap = f1644m;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (entryCeilingEntry != null) {
                treeMap.remove(entryCeilingEntry.getKey());
                x xVar = (x) entryCeilingEntry.getValue();
                xVar.getClass();
                xVar.f1646f = str;
                xVar.f1651l = i;
                return xVar;
            }
            x xVar2 = new x();
            xVar2.f1645c = i;
            int i3 = i + 1;
            xVar2.f1650k = new int[i3];
            xVar2.f1647g = new long[i3];
            xVar2.f1648h = new double[i3];
            xVar2.i = new String[i3];
            xVar2.f1649j = new byte[i3][];
            VarHandle.storeStoreFence();
            xVar2.f1646f = str;
            xVar2.f1651l = i;
            return xVar2;
        }
    }

    @Override // y4.d
    public final void B(int i) {
        this.f1650k[i] = 1;
    }

    @Override // y4.d
    public final void c(int i, long j10) {
        this.f1650k[i] = 2;
        this.f1647g[i] = j10;
    }

    public final void e() {
        TreeMap treeMap = f1644m;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f1645c), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                it.getClass();
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i;
                }
            }
        }
    }

    @Override // y4.e
    public final void g(y4.d dVar) {
        int i = this.f1651l;
        if (1 > i) {
            return;
        }
        int i3 = 1;
        while (true) {
            int i10 = this.f1650k[i3];
            if (i10 == 1) {
                dVar.B(i3);
            } else if (i10 == 2) {
                dVar.c(i3, this.f1647g[i3]);
            } else if (i10 == 3) {
                dVar.j(i3, this.f1648h[i3]);
            } else if (i10 == 4) {
                String str = this.i[i3];
                if (str == null) {
                    g5.f.s("Required value was null.");
                    return;
                }
                dVar.h(i3, str);
            } else if (i10 == 5) {
                byte[] bArr = this.f1649j[i3];
                if (bArr == null) {
                    g5.f.s("Required value was null.");
                    return;
                }
                dVar.s(i3, bArr);
            }
            if (i3 == i) {
                return;
            } else {
                i3++;
            }
        }
    }

    @Override // y4.d
    public final void h(int i, String str) {
        str.getClass();
        this.f1650k[i] = 4;
        this.i[i] = str;
    }

    @Override // y4.d
    public final void j(int i, double d7) {
        this.f1650k[i] = 3;
        this.f1648h[i] = d7;
    }

    @Override // y4.e
    public final String n() {
        String str = this.f1646f;
        if (str != null) {
            return str;
        }
        od.f.e("Required value was null.");
        return null;
    }

    @Override // y4.d
    public final void s(int i, byte[] bArr) {
        this.f1650k[i] = 5;
        this.f1649j[i] = bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
