package androidx.room;

import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final u f1524a;

    /* renamed from: b, reason: collision with root package name */
    public final n0 f1525b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f1526c;

    /* renamed from: d, reason: collision with root package name */
    public final ReentrantLock f1527d;

    /* renamed from: e, reason: collision with root package name */
    public final c f1528e;

    /* renamed from: f, reason: collision with root package name */
    public final c f1529f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f1530g;

    public f(u uVar, HashMap map, HashMap map2, String... strArr) {
        String lowerCase;
        this.f1524a = uVar;
        boolean z10 = uVar.f1637k;
        d dVar = new d(1, this, f.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0, 0, 0);
        n0 n0Var = new n0();
        n0Var.f1586a = uVar;
        n0Var.f1587b = map2;
        n0Var.f1588c = z10;
        n0Var.f1589d = dVar;
        n0Var.i = new AtomicBoolean(false);
        int i = 1;
        n0Var.f1594j = new c(1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        n0Var.f1590e = linkedHashMap;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Locale locale = Locale.ROOT;
            String lowerCase2 = str.toLowerCase(locale);
            lowerCase2.getClass();
            linkedHashMap.put(lowerCase2, Integer.valueOf(i3));
            String str2 = (String) map.get(strArr[i3]);
            if (str2 != null) {
                lowerCase = str2.toLowerCase(locale);
                lowerCase.getClass();
            } else {
                lowerCase = null;
            }
            if (lowerCase != null) {
                lowerCase2 = lowerCase;
            }
            strArr2[i3] = lowerCase2;
        }
        n0Var.f1591f = strArr2;
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = str3.toLowerCase(locale2);
            lowerCase3.getClass();
            if (linkedHashMap.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                lowerCase4.getClass();
                linkedHashMap.put(lowerCase4, kb.w.M(linkedHashMap, lowerCase3));
            }
        }
        int length2 = strArr2.length;
        ab.c cVar = new ab.c();
        cVar.f383b = new ReentrantLock();
        cVar.f384c = new long[length2];
        cVar.f385d = new boolean[length2];
        VarHandle.storeStoreFence();
        n0Var.f1592g = cVar;
        int length3 = strArr2.length;
        k kVar = new k();
        kVar.f1564a = nc.k0.a(new int[length3]);
        VarHandle.storeStoreFence();
        n0Var.f1593h = kVar;
        VarHandle.storeStoreFence();
        this.f1525b = n0Var;
        this.f1526c = new LinkedHashMap();
        this.f1527d = new ReentrantLock();
        c cVar2 = new c(0);
        VarHandle.storeStoreFence();
        this.f1528e = cVar2;
        c cVar3 = new c(0);
        VarHandle.storeStoreFence();
        this.f1529f = cVar3;
        Collections.newSetFromMap(new IdentityHashMap()).getClass();
        this.f1530g = new Object();
        ab.e eVar = new ab.e(i);
        eVar.f393f = this;
        VarHandle.storeStoreFence();
        n0Var.f1594j = eVar;
    }
}
