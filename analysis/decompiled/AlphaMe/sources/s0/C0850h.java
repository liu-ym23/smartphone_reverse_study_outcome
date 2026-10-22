package s0;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: s0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0850h {

    /* renamed from: b, reason: collision with root package name */
    public static final String f14199b = t.f("Data");

    /* renamed from: c, reason: collision with root package name */
    public static final C0850h f14200c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f14201a;

    static {
        C0850h c0850h = new C0850h(new HashMap());
        b(c0850h);
        f14200c = c0850h;
    }

    public C0850h(C0850h c0850h) {
        this.f14201a = new HashMap(c0850h.f14201a);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x003e -> B:33:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s0.C0850h a(byte[] r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            java.lang.String r1 = s0.C0850h.f14199b
            int r2 = r8.length
            r3 = 10240(0x2800, float:1.4349E-41)
            if (r2 > r3) goto L73
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream
            r3.<init>(r8)
            r8 = 0
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L42 java.lang.Throwable -> L46
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Throwable -> L46
            int r8 = r4.readInt()     // Catch: java.lang.Throwable -> L2d java.lang.Throwable -> L2f
        L1d:
            if (r8 <= 0) goto L31
            java.lang.String r5 = r4.readUTF()     // Catch: java.lang.Throwable -> L2d java.lang.Throwable -> L2f
            java.lang.Object r6 = r4.readObject()     // Catch: java.lang.Throwable -> L2d java.lang.Throwable -> L2f
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L2d java.lang.Throwable -> L2f
            int r8 = r8 + (-1)
            goto L1d
        L2d:
            r8 = move-exception
            goto L60
        L2f:
            r8 = move-exception
            goto L4a
        L31:
            r4.close()     // Catch: java.io.IOException -> L35
            goto L39
        L35:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L39:
            r3.close()     // Catch: java.io.IOException -> L3d
            goto L5a
        L3d:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
            goto L5a
        L42:
            r2 = move-exception
            r4 = r8
            r8 = r2
            goto L60
        L46:
            r4 = move-exception
            r7 = r4
            r4 = r8
            r8 = r7
        L4a:
            android.util.Log.e(r1, r0, r8)     // Catch: java.lang.Throwable -> L2d
            if (r4 == 0) goto L57
            r4.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r8 = move-exception
            android.util.Log.e(r1, r0, r8)
        L57:
            r3.close()     // Catch: java.io.IOException -> L3d
        L5a:
            s0.h r8 = new s0.h
            r8.<init>(r2)
            return r8
        L60:
            if (r4 == 0) goto L6a
            r4.close()     // Catch: java.io.IOException -> L66
            goto L6a
        L66:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L6a:
            r3.close()     // Catch: java.io.IOException -> L6e
            goto L72
        L6e:
            r2 = move-exception
            android.util.Log.e(r1, r0, r2)
        L72:
            throw r8
        L73:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.C0850h.a(byte[]):s0.h");
    }

    public static byte[] b(C0850h c0850h) throws Throwable {
        ObjectOutputStream objectOutputStream;
        String str = f14199b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e4) {
            e = e4;
        }
        try {
            objectOutputStream.writeInt(c0850h.f14201a.size());
            for (Map.Entry entry : c0850h.f14201a.entrySet()) {
                objectOutputStream.writeUTF((String) entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e5) {
                Log.e(str, "Error in Data#toByteArray: ", e5);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e6) {
                Log.e(str, "Error in Data#toByteArray: ", e6);
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException e7) {
            e = e7;
            objectOutputStream2 = objectOutputStream;
            Log.e(str, "Error in Data#toByteArray: ", e);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e8) {
                    Log.e(str, "Error in Data#toByteArray: ", e8);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e9) {
                Log.e(str, "Error in Data#toByteArray: ", e9);
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e10) {
                    Log.e(str, "Error in Data#toByteArray: ", e10);
                }
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (IOException e11) {
                Log.e(str, "Error in Data#toByteArray: ", e11);
                throw th;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0850h.class != obj.getClass()) {
            return false;
        }
        HashMap map = this.f14201a;
        Set<String> setKeySet = map.keySet();
        HashMap map2 = ((C0850h) obj).f14201a;
        if (!setKeySet.equals(map2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            Object obj2 = map.get(str);
            Object obj3 = map2.get(str);
            if (obj2 == null || obj3 == null) {
                if (obj2 != obj3) {
                    return false;
                }
            } else {
                if (!(((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f14201a.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        HashMap map = this.f14201a;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = map.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public C0850h(HashMap map) {
        this.f14201a = new HashMap(map);
    }
}
