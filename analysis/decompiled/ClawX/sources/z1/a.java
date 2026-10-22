package z1;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import k2.b0;
import k2.j0;
import k2.l1;
import k2.o1;
import k2.r1;
import k2.t1;
import k2.x;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {
    static {
        d2.a[] aVarArr = {new d2.a(y1.a.class, 3)};
        HashMap map = new HashMap();
        d2.a aVar = aVarArr[0];
        Class cls = aVar.f1783a;
        if (map.containsKey(cls)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls.getCanonicalName());
        }
        map.put(cls, aVar);
        Class cls2 = aVarArr[0].f1783a;
        Collections.unmodifiableMap(map);
        d2.a[] aVarArr2 = {new d2.a(y1.a.class, 6)};
        HashMap map2 = new HashMap();
        d2.a aVar2 = aVarArr2[0];
        Class cls3 = aVar2.f1783a;
        if (map2.containsKey(cls3)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls3.getCanonicalName());
        }
        map2.put(cls3, aVar2);
        Class cls4 = aVarArr2[0].f1783a;
        Collections.unmodifiableMap(map2);
        d2.a[] aVarArr3 = {new d2.a(y1.a.class, 7)};
        HashMap map3 = new HashMap();
        d2.a aVar3 = aVarArr3[0];
        Class cls5 = aVar3.f1783a;
        if (map3.containsKey(cls5)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls5.getCanonicalName());
        }
        map3.put(cls5, aVar3);
        Class cls6 = aVarArr3[0].f1783a;
        Collections.unmodifiableMap(map3);
        d2.a[] aVarArr4 = {new d2.a(y1.a.class, 5)};
        HashMap map4 = new HashMap();
        d2.a aVar4 = aVarArr4[0];
        Class cls7 = aVar4.f1783a;
        if (map4.containsKey(cls7)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls7.getCanonicalName());
        }
        map4.put(cls7, aVar4);
        Class cls8 = aVarArr4[0].f1783a;
        Collections.unmodifiableMap(map4);
        d2.a[] aVarArr5 = {new d2.a(y1.a.class, 9)};
        HashMap map5 = new HashMap();
        d2.a aVar5 = aVarArr5[0];
        Class cls9 = aVar5.f1783a;
        if (map5.containsKey(cls9)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls9.getCanonicalName());
        }
        map5.put(cls9, aVar5);
        Class cls10 = aVarArr5[0].f1783a;
        Collections.unmodifiableMap(map5);
        d2.a[] aVarArr6 = {new d2.a(y1.a.class, 10)};
        HashMap map6 = new HashMap();
        d2.a aVar6 = aVarArr6[0];
        Class cls11 = aVar6.f1783a;
        if (map6.containsKey(cls11)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls11.getCanonicalName());
        }
        map6.put(cls11, aVar6);
        Class cls12 = aVarArr6[0].f1783a;
        Collections.unmodifiableMap(map6);
        d2.a[] aVarArr7 = {new d2.a(y1.a.class, 8)};
        HashMap map7 = new HashMap();
        d2.a aVar7 = aVarArr7[0];
        Class cls13 = aVar7.f1783a;
        if (map7.containsKey(cls13)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls13.getCanonicalName());
        }
        map7.put(cls13, aVar7);
        Class cls14 = aVarArr7[0].f1783a;
        Collections.unmodifiableMap(map7);
        d2.a[] aVarArr8 = {new d2.a(y1.a.class, 11)};
        HashMap map8 = new HashMap();
        d2.a aVar8 = aVarArr8[0];
        Class cls15 = aVar8.f1783a;
        if (map8.containsKey(cls15)) {
            throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + cls15.getCanonicalName());
        }
        map8.put(cls15, aVar8);
        Class cls16 = aVarArr8[0].f1783a;
        Collections.unmodifiableMap(map8);
        int i8 = r1.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e9) {
            throw new ExceptionInInitializerError(e9);
        }
    }

    public static void a() throws NoSuchPaddingException, NoSuchAlgorithmException {
        y1.n.h(d.f6367b);
        g2.l.a();
        y1.n.f(new d2.c(k2.h.class, new d2.a[]{new d2.a(y1.a.class, 3)}, 1), true);
        int i8 = 6;
        Class<x> cls = x.class;
        y1.n.f(new d2.c(cls, new d2.a[]{new d2.a(y1.a.class, 6)}, 3), true);
        f2.l lVar = k.f6393a;
        f2.j jVar = f2.j.f2563b;
        jVar.e(k.f6393a);
        jVar.d(k.f6394b);
        jVar.c(k.f6395c);
        jVar.b(k.d);
        if (c2.a.a()) {
            return;
        }
        int i9 = 5;
        y1.n.f(new d2.c(k2.r.class, new d2.a[]{new d2.a(y1.a.class, 5)}, 2), true);
        jVar.e(h.f6387a);
        jVar.d(h.f6388b);
        jVar.c(h.f6389c);
        jVar.b(h.d);
        int i10 = 7;
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            y1.n.f(new d2.c(b0.class, new d2.a[]{new d2.a(y1.a.class, 7)}, 4), true);
            jVar.e(n.f6398a);
            jVar.d(n.f6399b);
            jVar.c(n.f6400c);
            jVar.b(n.d);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
        }
        y1.n.f(new d2.c(j0.class, new d2.a[]{new d2.a(y1.a.class, 8)}, i9), true);
        f2.l lVar2 = q.f6401a;
        f2.j jVar2 = f2.j.f2563b;
        jVar2.e(q.f6401a);
        jVar2.d(q.f6402b);
        jVar2.c(q.f6403c);
        jVar2.b(q.d);
        y1.n.f(new d2.c(l1.class, new d2.a[]{new d2.a(y1.a.class, 9)}, i8), true);
        y1.n.f(new d2.c(o1.class, new d2.a[]{new d2.a(y1.a.class, 10)}, i10), true);
        Class<t1> cls2 = t1.class;
        y1.n.f(new d2.c(cls2, new d2.a[]{new d2.a(y1.a.class, 11)}, 8), true);
        jVar2.e(u.f6407a);
        jVar2.d(u.f6408b);
        jVar2.c(u.f6409c);
        jVar2.b(u.d);
    }
}
