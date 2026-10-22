package y8;

import D7.D;
import D7.E;
import D7.s;
import D7.w;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* renamed from: y8.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2149l {

    /* renamed from: a, reason: collision with root package name */
    public final String f6919a;
    public final ArrayList b = new ArrayList();
    public Pair c = new Pair(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);

    public C2149l(O2.a aVar, String str, String str2) {
        this.f6919a = str2;
    }

    public final void a(String type, C2141d... c2141dArr) {
        C2150m c2150m;
        kotlin.jvm.internal.k.f(type, "type");
        if (c2141dArr.length == 0) {
            c2150m = null;
        } else {
            s sVar = new s(new D6.i(c2141dArr, 1), 5);
            int iP = kotlin.collections.a.P(w.c0(sVar, 10));
            if (iP < 16) {
                iP = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
            Iterator it = sVar.iterator();
            while (true) {
                E e = (E) it;
                if (!e.b.hasNext()) {
                    break;
                }
                D d = (D) e.next();
                linkedHashMap.put(Integer.valueOf(d.f393a), (C2141d) d.b);
            }
            c2150m = new C2150m(linkedHashMap);
        }
        this.b.add(new Pair(type, c2150m));
    }

    public final void b(String type, C2141d... c2141dArr) {
        kotlin.jvm.internal.k.f(type, "type");
        s sVar = new s(new D6.i(c2141dArr, 1), 5);
        int iP = kotlin.collections.a.P(w.c0(sVar, 10));
        if (iP < 16) {
            iP = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
        Iterator it = sVar.iterator();
        while (true) {
            E e = (E) it;
            if (!e.b.hasNext()) {
                this.c = new Pair(type, new C2150m(linkedHashMap));
                return;
            } else {
                D d = (D) e.next();
                linkedHashMap.put(Integer.valueOf(d.f393a), (C2141d) d.b);
            }
        }
    }

    public final void c(JvmPrimitiveType type) {
        kotlin.jvm.internal.k.f(type, "type");
        String strC = type.c();
        kotlin.jvm.internal.k.e(strC, "getDesc(...)");
        this.c = new Pair(strC, null);
    }
}
