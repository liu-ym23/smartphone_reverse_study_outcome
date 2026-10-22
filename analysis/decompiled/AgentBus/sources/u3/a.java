package u3;

import f4.a2;
import f4.d2;
import f4.f2;
import f4.j0;
import f4.n0;
import f4.v0;
import f4.x1;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import m.x;

/* loaded from: classes.dex */
public abstract class a {
    static {
        b4.c[] cVarArr = {new b4.c(t3.a.class, 4)};
        HashMap map = new HashMap();
        b4.c cVar = cVarArr[0];
        Class cls = cVar.f1487a;
        if (map.containsKey(cls)) {
            throw new IllegalArgumentException(x.j(cls, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map.put(cls, cVar);
        Class cls2 = cVarArr[0].f1487a;
        Collections.unmodifiableMap(map);
        b4.c[] cVarArr2 = {new b4.c(t3.a.class, 7)};
        HashMap map2 = new HashMap();
        b4.c cVar2 = cVarArr2[0];
        Class cls3 = cVar2.f1487a;
        if (map2.containsKey(cls3)) {
            throw new IllegalArgumentException(x.j(cls3, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map2.put(cls3, cVar2);
        Class cls4 = cVarArr2[0].f1487a;
        Collections.unmodifiableMap(map2);
        b4.c[] cVarArr3 = {new b4.c(t3.a.class, 8)};
        HashMap map3 = new HashMap();
        b4.c cVar3 = cVarArr3[0];
        Class cls5 = cVar3.f1487a;
        if (map3.containsKey(cls5)) {
            throw new IllegalArgumentException(x.j(cls5, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map3.put(cls5, cVar3);
        Class cls6 = cVarArr3[0].f1487a;
        Collections.unmodifiableMap(map3);
        b4.c[] cVarArr4 = {new b4.c(t3.a.class, 6)};
        HashMap map4 = new HashMap();
        b4.c cVar4 = cVarArr4[0];
        Class cls7 = cVar4.f1487a;
        if (map4.containsKey(cls7)) {
            throw new IllegalArgumentException(x.j(cls7, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map4.put(cls7, cVar4);
        Class cls8 = cVarArr4[0].f1487a;
        Collections.unmodifiableMap(map4);
        b4.c[] cVarArr5 = {new b4.c(t3.a.class, 10)};
        HashMap map5 = new HashMap();
        b4.c cVar5 = cVarArr5[0];
        Class cls9 = cVar5.f1487a;
        if (map5.containsKey(cls9)) {
            throw new IllegalArgumentException(x.j(cls9, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map5.put(cls9, cVar5);
        Class cls10 = cVarArr5[0].f1487a;
        Collections.unmodifiableMap(map5);
        b4.c[] cVarArr6 = {new b4.c(t3.a.class, 11)};
        HashMap map6 = new HashMap();
        b4.c cVar6 = cVarArr6[0];
        Class cls11 = cVar6.f1487a;
        if (map6.containsKey(cls11)) {
            throw new IllegalArgumentException(x.j(cls11, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map6.put(cls11, cVar6);
        Class cls12 = cVarArr6[0].f1487a;
        Collections.unmodifiableMap(map6);
        b4.c[] cVarArr7 = {new b4.c(t3.a.class, 9)};
        HashMap map7 = new HashMap();
        b4.c cVar7 = cVarArr7[0];
        Class cls13 = cVar7.f1487a;
        if (map7.containsKey(cls13)) {
            throw new IllegalArgumentException(x.j(cls13, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map7.put(cls13, cVar7);
        Class cls14 = cVarArr7[0].f1487a;
        Collections.unmodifiableMap(map7);
        b4.c[] cVarArr8 = {new b4.c(t3.a.class, 12)};
        HashMap map8 = new HashMap();
        b4.c cVar8 = cVarArr8[0];
        Class cls15 = cVar8.f1487a;
        if (map8.containsKey(cls15)) {
            throw new IllegalArgumentException(x.j(cls15, new StringBuilder("KeyTypeManager constructed with duplicate factories for primitive ")));
        }
        map8.put(cls15, cVar8);
        Class cls16 = cVarArr8[0].f1487a;
        Collections.unmodifiableMap(map8);
        int i2 = d2.CONFIG_NAME_FIELD_NUMBER;
        try {
            a();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    public static void a() throws NoSuchPaddingException, NoSuchAlgorithmException {
        t3.n.g(d.f10006b);
        b4.o.a();
        t3.n.e(new g4.a(f4.h.class, new b4.c[]{new b4.c(t3.a.class, 4)}, 2), true);
        int i2 = 7;
        Class<j0> cls = j0.class;
        t3.n.e(new g4.a(cls, new b4.c[]{new b4.c(t3.a.class, 7)}, 4), true);
        a4.l lVar = k.f10036a;
        a4.j jVar = a4.j.f182b;
        jVar.e(k.f10036a);
        jVar.d(k.f10037b);
        jVar.c(k.f10038c);
        jVar.b(k.f10039d);
        if (x3.a.a()) {
            return;
        }
        int i10 = 6;
        t3.n.e(new g4.a(f4.x.class, new b4.c[]{new b4.c(t3.a.class, 6)}, 3), true);
        jVar.e(h.f10028a);
        jVar.d(h.f10029b);
        jVar.c(h.f10030c);
        jVar.b(h.f10031d);
        int i11 = 8;
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            t3.n.e(new g4.a(n0.class, new b4.c[]{new b4.c(t3.a.class, 8)}, 5), true);
            jVar.e(n.f10042a);
            jVar.d(n.f10043b);
            jVar.c(n.f10044c);
            jVar.b(n.f10045d);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
        }
        t3.n.e(new g4.a(v0.class, new b4.c[]{new b4.c(t3.a.class, 9)}, i10), true);
        a4.l lVar2 = q.f10046a;
        a4.j jVar2 = a4.j.f182b;
        jVar2.e(q.f10046a);
        jVar2.d(q.f10047b);
        jVar2.c(q.f10048c);
        jVar2.b(q.f10049d);
        t3.n.e(new g4.a(x1.class, new b4.c[]{new b4.c(t3.a.class, 10)}, i2), true);
        t3.n.e(new g4.a(a2.class, new b4.c[]{new b4.c(t3.a.class, 11)}, i11), true);
        Class<f2> cls2 = f2.class;
        t3.n.e(new g4.a(cls2, new b4.c[]{new b4.c(t3.a.class, 12)}, 9), true);
        jVar2.e(u.f10053a);
        jVar2.d(u.f10054b);
        jVar2.c(u.f10055c);
        jVar2.b(u.f10056d);
    }
}
