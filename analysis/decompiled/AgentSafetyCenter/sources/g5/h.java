package g5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final h f4318b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4319a;

    static {
        h hVar = new h(new LinkedHashMap());
        ac.a.c0(hVar);
        f4318b = hVar;
    }

    public h(h hVar) {
        hVar.getClass();
        this.f4319a = new HashMap(hVar.f4319a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final g5.h a(byte[] r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            r7.getClass()
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto Lcd
            int r1 = r7.length
            if (r1 != 0) goto L10
            g5.h r7 = g5.h.f4318b
            return r7
        L10:
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            r2.<init>(r7)     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            r7 = 2
            byte[] r7 = new byte[r7]     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            r2.read(r7)     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            r3 = -21267(0xffffffffffffaced, float:NaN)
            byte r3 = (byte) r3     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            r4 = 16777132(0xffffac, float:2.350977E-38)
            byte r4 = (byte) r4     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            r5 = 0
            r6 = r7[r5]     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            if (r6 != r4) goto L32
            r4 = 1
            r7 = r7[r4]     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            if (r7 != r3) goto L32
            goto L33
        L32:
            r4 = r5
        L33:
            r2.reset()     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            if (r4 == 0) goto L65
            java.io.ObjectInputStream r7 = new java.io.ObjectInputStream     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            r7.<init>(r2)     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            int r2 = r7.readInt()     // Catch: java.lang.Throwable -> L54
        L41:
            if (r5 >= r2) goto L56
            java.lang.String r3 = r7.readUTF()     // Catch: java.lang.Throwable -> L54
            r3.getClass()     // Catch: java.lang.Throwable -> L54
            java.lang.Object r4 = r7.readObject()     // Catch: java.lang.Throwable -> L54
            r1.put(r3, r4)     // Catch: java.lang.Throwable -> L54
            int r5 = r5 + 1
            goto L41
        L54:
            r2 = move-exception
            goto L5f
        L56:
            r7.close()     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            goto Lc7
        L5b:
            r7 = move-exception
            goto Lb4
        L5d:
            r7 = move-exception
            goto Lbe
        L5f:
            throw r2     // Catch: java.lang.Throwable -> L60
        L60:
            r3 = move-exception
            t.o.d(r7, r2)     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            throw r3     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
        L65:
            java.io.DataInputStream r7 = new java.io.DataInputStream     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            r7.<init>(r2)     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            short r2 = r7.readShort()     // Catch: java.lang.Throwable -> La8
            r3 = -21521(0xffffffffffffabef, float:NaN)
            if (r2 != r3) goto L84
            short r2 = r7.readShort()     // Catch: java.lang.Throwable -> La8
            r3 = 1
            if (r2 != r3) goto L7a
            goto L8d
        L7a:
            java.lang.String r3 = "Unsupported version number: "
            java.lang.String r2 = k0.a.j(r2, r3)     // Catch: java.lang.Throwable -> La8
            b8.z.j(r2)     // Catch: java.lang.Throwable -> La8
            goto L8d
        L84:
            java.lang.String r3 = "Magic number doesn't match: "
            java.lang.String r2 = k0.a.j(r2, r3)     // Catch: java.lang.Throwable -> La8
            b8.z.j(r2)     // Catch: java.lang.Throwable -> La8
        L8d:
            int r2 = r7.readInt()     // Catch: java.lang.Throwable -> La8
        L91:
            if (r5 >= r2) goto Laa
            byte r3 = r7.readByte()     // Catch: java.lang.Throwable -> La8
            java.io.Serializable r3 = ac.a.s(r7, r3)     // Catch: java.lang.Throwable -> La8
            java.lang.String r4 = r7.readUTF()     // Catch: java.lang.Throwable -> La8
            r4.getClass()     // Catch: java.lang.Throwable -> La8
            r1.put(r4, r3)     // Catch: java.lang.Throwable -> La8
            int r5 = r5 + 1
            goto L91
        La8:
            r2 = move-exception
            goto Lae
        Laa:
            r7.close()     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            goto Lc7
        Lae:
            throw r2     // Catch: java.lang.Throwable -> Laf
        Laf:
            r3 = move-exception
            t.o.d(r7, r2)     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
            throw r3     // Catch: java.lang.ClassNotFoundException -> L5b java.io.IOException -> L5d
        Lb4:
            java.lang.String r2 = g5.i.f4320a
            g5.u r3 = g5.u.d()
            r3.c(r2, r0, r7)
            goto Lc7
        Lbe:
            java.lang.String r2 = g5.i.f4320a
            g5.u r3 = g5.u.d()
            r3.c(r2, r0, r7)
        Lc7:
            g5.h r7 = new g5.h
            r7.<init>(r1)
            return r7
        Lcd:
            java.lang.String r7 = "Data cannot occupy more than 10240 bytes when serialized"
            od.f.e(r7)
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.h.a(byte[]):g5.h");
    }

    public final boolean b(String str) {
        Object obj = this.f4319a.get(str);
        return obj != null && String.class.isAssignableFrom(obj.getClass());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L5
            goto L66
        L5:
            r1 = 0
            if (r8 == 0) goto L67
            java.lang.Class<g5.h> r2 = g5.h.class
            java.lang.Class r3 = r8.getClass()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L15
            goto L67
        L15:
            g5.h r8 = (g5.h) r8
            java.util.HashMap r8 = r8.f4319a
            java.util.HashMap r7 = r7.f4319a
            java.util.Set r2 = r7.keySet()
            java.util.Set r3 = r8.keySet()
            boolean r3 = yb.k.a(r2, r3)
            if (r3 != 0) goto L2a
            goto L67
        L2a:
            java.util.Iterator r2 = r2.iterator()
        L2e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L66
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r7.get(r3)
            java.lang.Object r3 = r8.get(r3)
            if (r4 == 0) goto L5e
            if (r3 != 0) goto L47
            goto L5e
        L47:
            boolean r5 = r4 instanceof java.lang.Object[]
            if (r5 == 0) goto L59
            r5 = r4
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            boolean r6 = r3 instanceof java.lang.Object[]
            if (r6 == 0) goto L59
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            boolean r3 = kb.k.e0(r5, r3)
            goto L63
        L59:
            boolean r3 = r4.equals(r3)
            goto L63
        L5e:
            if (r4 != r3) goto L62
            r3 = r0
            goto L63
        L62:
            r3 = r1
        L63:
            if (r3 != 0) goto L2e
            goto L67
        L66:
            return r0
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.h.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.f4319a.entrySet()) {
            Object value = entry.getValue();
            iHashCode += value instanceof Object[] ? Objects.hashCode(entry.getKey()) ^ Arrays.deepHashCode((Object[]) value) : entry.hashCode();
        }
        return iHashCode * 31;
    }

    public final String toString() {
        return androidx.activity.b.n(new StringBuilder("Data {"), kb.l.B0(this.f4319a.entrySet(), null, null, null, g.f4316c, 31), "}");
    }

    public h(LinkedHashMap linkedHashMap) {
        linkedHashMap.getClass();
        this.f4319a = new HashMap(linkedHashMap);
    }
}
