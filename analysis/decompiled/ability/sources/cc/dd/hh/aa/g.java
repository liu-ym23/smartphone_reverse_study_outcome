package cc.dd.hh.aa;

import java.util.HashMap;

/* loaded from: classes2.dex */
public enum g {
    /* JADX INFO: Fake field, exist only in values array */
    OBJECT(2, 0),
    /* JADX INFO: Fake field, exist only in values array */
    BOOLEAN(4, 1),
    CHAR(5, 2),
    /* JADX INFO: Fake field, exist only in values array */
    FLOAT(6, 4),
    /* JADX INFO: Fake field, exist only in values array */
    DOUBLE(7, 8),
    BYTE(8, 1),
    /* JADX INFO: Fake field, exist only in values array */
    SHORT(9, 2),
    /* JADX INFO: Fake field, exist only in values array */
    INT(10, 4),
    /* JADX INFO: Fake field, exist only in values array */
    LONG(11, 8);

    public static final HashMap e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final int f2144a;
    public final int b;

    static {
        g[] gVarArrValues = values();
        for (int i = 0; i < 9; i++) {
            g gVar = gVarArrValues[i];
            e.put(Integer.valueOf(gVar.f2144a), gVar);
        }
    }

    g(int i, int i6) {
        this.f2144a = i;
        this.b = i6;
    }

    public static g a(int i) {
        return (g) e.get(Integer.valueOf(i));
    }
}
