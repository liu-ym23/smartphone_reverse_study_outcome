package p9;

import d2.y;
import hc.h;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Set;
import kb.k;
import kb.l;
import kb.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f9925a = k.v0(new String[]{"authorization", "cookie", "set-cookie", "zy-user-id", "device_id", "zy-device-id", "zy-device-oaid", "oaid", "x-auth-token", "proxy-authorization"});

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [kb.s] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    public static String a(String str, String str2) {
        Iterable arrayList;
        str.getClass();
        if (str.length() == 0) {
            return str2.concat(" (empty)");
        }
        int length = str.length();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(hc.a.f5448a);
        bytes.getClass();
        byte[] bArrDigest = messageDigest.digest(bytes);
        bArrDigest.getClass();
        int i = 0;
        if (8 >= bArrDigest.length) {
            int length2 = bArrDigest.length;
            if (length2 == 0) {
                arrayList = s.f7404c;
            } else if (length2 != 1) {
                arrayList = new ArrayList(bArrDigest.length);
                int length3 = bArrDigest.length;
                while (i < length3) {
                    arrayList.add(Byte.valueOf(bArrDigest[i]));
                    i++;
                }
            } else {
                arrayList = ac.a.E(Byte.valueOf(bArrDigest[0]));
            }
        } else {
            arrayList = new ArrayList(8);
            int length4 = bArrDigest.length;
            int i3 = 0;
            while (i < length4) {
                arrayList.add(Byte.valueOf(bArrDigest[i]));
                i3++;
                if (i3 == 8) {
                    break;
                }
                i++;
            }
        }
        return str2 + " bytes=" + length + " sha256=" + l.B0(arrayList, "", null, null, new y(22), 30);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject b(ad.n r10) {
        /*
            r10.getClass()
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            int r1 = r10.size()
            r2 = 0
            r3 = r2
        Le:
            if (r3 >= r1) goto L79
            java.lang.String r4 = r10.b(r3)
            java.lang.String r5 = r10.d(r3)
            r4.getClass()
            r5.getClass()
            boolean r6 = hc.h.g0(r5)
            if (r6 == 0) goto L27
            java.lang.String r5 = "<empty>"
            goto L73
        L27:
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r7 = r4.toLowerCase(r6)
            r7.getClass()
            java.util.Set r8 = p9.a.f9925a
            boolean r7 = r8.contains(r7)
            java.lang.String r8 = "authorization"
            if (r7 != 0) goto L56
            java.lang.String r7 = r4.toLowerCase(r6)
            r7.getClass()
            boolean r7 = hc.h.X(r7, r8, r2)
            if (r7 != 0) goto L56
            java.lang.String r7 = r4.toLowerCase(r6)
            r7.getClass()
            java.lang.String r9 = "oaid"
            boolean r7 = hc.h.X(r7, r9, r2)
            if (r7 == 0) goto L73
        L56:
            java.lang.String r7 = "Authorization"
            boolean r7 = r4.equalsIgnoreCase(r7)
            if (r7 != 0) goto L6f
            java.lang.String r6 = r4.toLowerCase(r6)
            r6.getClass()
            boolean r6 = hc.h.X(r6, r8, r2)
            if (r6 == 0) goto L6c
            goto L6f
        L6c:
            java.lang.String r5 = "***"
            goto L73
        L6f:
            java.lang.String r5 = c(r5)
        L73:
            r0.put(r4, r5)
            int r3 = r3 + 1
            goto Le
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.a.b(ad.n):org.json.JSONObject");
    }

    public static String c(String str) {
        return h.g0(str) ? "<empty>" : k0.a.k(h.w0(h.l0(h.l0(h.w0(str).toString(), "Bearer "), "bearer ")).toString().length(), "Bearer ***(len=", ")");
    }

    public static String d(String str) {
        if (str == null || h.g0(str)) {
            return "-";
        }
        String name = new File(str).getName();
        name.getClass();
        return h.g0(name) ? "***" : "…/".concat(name);
    }
}
