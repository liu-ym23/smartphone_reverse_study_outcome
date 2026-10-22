package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class E implements k0.i, k0.h {

    /* renamed from: i, reason: collision with root package name */
    public static final TreeMap f4184i = new TreeMap();

    /* renamed from: a, reason: collision with root package name */
    public final int f4185a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f4186b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f4187c;

    /* renamed from: d, reason: collision with root package name */
    public final double[] f4188d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f4189e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[][] f4190f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f4191g;

    /* renamed from: h, reason: collision with root package name */
    public int f4192h;

    public E(int i4) {
        this.f4185a = i4;
        int i5 = i4 + 1;
        this.f4191g = new int[i5];
        this.f4187c = new long[i5];
        this.f4188d = new double[i5];
        this.f4189e = new String[i5];
        this.f4190f = new byte[i5][];
    }

    public static final E d(int i4, String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        TreeMap treeMap = f4184i;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i4));
            if (entryCeilingEntry == null) {
                Unit unit = Unit.INSTANCE;
                E e4 = new E(i4);
                Intrinsics.checkNotNullParameter(query, "query");
                e4.f4186b = query;
                e4.f4192h = i4;
                return e4;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            E sqliteQuery = (E) entryCeilingEntry.getValue();
            sqliteQuery.getClass();
            Intrinsics.checkNotNullParameter(query, "query");
            sqliteQuery.f4186b = query;
            sqliteQuery.f4192h = i4;
            Intrinsics.checkNotNullExpressionValue(sqliteQuery, "sqliteQuery");
            return sqliteQuery;
        }
    }

    @Override // k0.i
    public final void a(k0.h statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        int i4 = this.f4192h;
        if (1 > i4) {
            return;
        }
        int i5 = 1;
        while (true) {
            int i6 = this.f4191g[i5];
            if (i6 == 1) {
                statement.bindNull(i5);
            } else if (i6 == 2) {
                statement.bindLong(i5, this.f4187c[i5]);
            } else if (i6 == 3) {
                statement.bindDouble(i5, this.f4188d[i5]);
            } else if (i6 == 4) {
                String str = this.f4189e[i5];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.bindString(i5, str);
            } else if (i6 == 5) {
                byte[] bArr = this.f4190f[i5];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                statement.bindBlob(i5, bArr);
            }
            if (i5 == i4) {
                return;
            } else {
                i5++;
            }
        }
    }

    @Override // k0.i
    public final String b() {
        String str = this.f4186b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // k0.h
    public final void bindBlob(int i4, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f4191g[i4] = 5;
        this.f4190f[i4] = value;
    }

    @Override // k0.h
    public final void bindDouble(int i4, double d4) {
        this.f4191g[i4] = 3;
        this.f4188d[i4] = d4;
    }

    @Override // k0.h
    public final void bindLong(int i4, long j4) {
        this.f4191g[i4] = 2;
        this.f4187c[i4] = j4;
    }

    @Override // k0.h
    public final void bindNull(int i4) {
        this.f4191g[i4] = 1;
    }

    @Override // k0.h
    public final void bindString(int i4, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f4191g[i4] = 4;
        this.f4189e[i4] = value;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final void e() {
        TreeMap treeMap = f4184i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f4185a), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i4 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i4;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
