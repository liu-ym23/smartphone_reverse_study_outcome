package wa;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final ua.d[] f10971a = new ua.d[0];

    public static final void a(int i2, int i10, ua.d dVar) {
        q7.k.e(dVar, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i11 = (~i2) & i10;
        for (int i12 = 0; i12 < 32; i12++) {
            if ((i11 & 1) != 0) {
                arrayList.add(dVar.d(i12));
            }
            i11 >>>= 1;
        }
        String strB = dVar.b();
        q7.k.e(strB, "serialName");
        throw new sa.b(arrayList, arrayList.size() == 1 ? "Field '" + ((String) arrayList.get(0)) + "' is required for type with serial name '" + strB + "', but it was missing" : "Fields " + arrayList + " are required for type with serial name '" + strB + "', but they were missing", null);
    }
}
