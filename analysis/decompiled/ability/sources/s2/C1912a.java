package s2;

import D7.q;
import H.h;
import H4.o;
import W9.b;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.text.TextUtils;
import com.stepos.aiengine.args.SingleFileBundle;
import j9.AbstractC1607a;
import java.io.File;
import java.util.Arrays;
import java.util.UUID;
import kotlin.jvm.internal.k;
import l2.C1655a;
import okio.ByteString;
import org.json.JSONObject;
import u1.c;
import u1.d;

/* renamed from: s2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1912a implements J0.a, c, com.apm.insight.c {

    /* renamed from: a, reason: collision with root package name */
    public static volatile UUID f5979a = null;
    public static String b = "";

    public C1912a(Context context) {
        String strW;
        if (f5979a == null) {
            synchronized (C1912a.class) {
                if (f5979a == null) {
                    d dVarB = d.B();
                    dVarB.getClass();
                    String string = null;
                    try {
                        strW = M.a.w(((File) dVarB.d).getAbsolutePath());
                    } catch (Throwable unused) {
                        strW = null;
                    }
                    if (strW != null) {
                        f5979a = UUID.fromString(strW);
                    } else {
                        try {
                            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        } catch (Throwable unused2) {
                        }
                        try {
                            f5979a = string != null ? UUID.nameUUIDFromBytes(string.getBytes("utf8")) : UUID.randomUUID();
                        } catch (Throwable unused3) {
                        }
                        try {
                            d dVarB2 = d.B();
                            String string2 = f5979a.toString();
                            dVarB2.getClass();
                            M.a.t(string2, (File) dVarB2.d, false);
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
        }
    }

    public static synchronized String a(Context context) {
        try {
            if (TextUtils.isEmpty(b)) {
                new C1912a(context);
                UUID uuid = f5979a;
                if (uuid != null) {
                    b = uuid.toString();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public static String f(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    public static ByteString g(String str) {
        int i;
        char cCharAt;
        byte[] bArr = V9.a.f1412a;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i6 = (int) ((length * 6) / 8);
        byte[] bArrCopyOf = new byte[i6];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i10 < length) {
                char cCharAt2 = str.charAt(i10);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    i = cCharAt2 - 'A';
                } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i = cCharAt2 - 'G';
                } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                    i = cCharAt2 + 4;
                } else if (cCharAt2 != '+' && cCharAt2 != '-') {
                    if (cCharAt2 != '/' && cCharAt2 != '_') {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            break;
                        }
                        i10++;
                    } else {
                        i = 63;
                    }
                } else {
                    i = 62;
                }
                i12 = (i12 << 6) | i;
                i11++;
                if (i11 % 4 == 0) {
                    bArrCopyOf[i13] = (byte) (i12 >> 16);
                    int i14 = i13 + 2;
                    bArrCopyOf[i13 + 1] = (byte) (i12 >> 8);
                    i13 += 3;
                    bArrCopyOf[i14] = (byte) i12;
                }
                i10++;
            } else {
                int i15 = i11 % 4;
                if (i15 != 1) {
                    if (i15 == 2) {
                        bArrCopyOf[i13] = (byte) ((i12 << 12) >> 16);
                        i13++;
                    } else if (i15 == 3) {
                        int i16 = i12 << 6;
                        int i17 = i13 + 1;
                        bArrCopyOf[i13] = (byte) (i16 >> 16);
                        i13 += 2;
                        bArrCopyOf[i17] = (byte) (i16 >> 8);
                    }
                    if (i13 != i6) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i13);
                        k.e(bArrCopyOf, "copyOf(this, newSize)");
                    }
                }
            }
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new ByteString(bArrCopyOf);
        }
        return null;
    }

    public static ByteString h(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i6 = i * 2;
            bArr[i] = (byte) (b.a(str.charAt(i6 + 1)) + (b.a(str.charAt(i6)) << 4));
        }
        return new ByteString(bArr);
    }

    public static ByteString i(String str) {
        k.f(str, "<this>");
        byte[] bytes = str.getBytes(AbstractC1607a.f4778a);
        k.e(bytes, "this as java.lang.String).getBytes(charset)");
        ByteString byteString = new ByteString(bytes);
        byteString.c = str;
        return byteString;
    }

    public static za.d j(String message) {
        k.f(message, "message");
        return new za.d(18, (String) null, message, false);
    }

    public static ByteString k(byte[] bArr) {
        ByteString byteString = ByteString.d;
        int length = bArr.length;
        o.t(bArr.length, 0, length);
        return new ByteString(q.c0(bArr, 0, length));
    }

    public static za.d l(String sessionId, String str) {
        k.f(sessionId, "sessionId");
        return new za.d(16, sessionId, str, true);
    }

    public static za.d m(String sessionId, String message) {
        k.f(sessionId, "sessionId");
        k.f(message, "message");
        return new za.d(true, sessionId, message, true);
    }

    @Override // J0.a
    public boolean b(String str) {
        return false;
    }

    @Override // u1.c
    public boolean c(Context context) {
        return false;
    }

    public void d(SQLiteDatabase sQLiteDatabase, C1655a c1655a) throws SQLException {
        if (e(sQLiteDatabase, c1655a.f5272a)) {
            return;
        }
        if (sQLiteDatabase != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(SingleFileBundle.KEY_PATH, c1655a.f5272a);
                contentValues.put("insert_time", Long.valueOf(c1655a.b));
                sQLiteDatabase.insert("duplicatelog", null, contentValues);
            } catch (Throwable th) {
                S0.b.p0(th);
            }
        }
        try {
            sQLiteDatabase.execSQL("delete from duplicatelog where _id in (select _id from duplicatelog order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e) {
            S0.b.p0(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.database.sqlite.SQLiteDatabase r10, java.lang.String r11) {
        /*
            r9 = this;
            r9 = 0
            if (r10 == 0) goto L2f
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto La
            goto L2f
        La:
            java.lang.String r2 = "duplicatelog"
            java.lang.String r4 = "path=?"
            java.lang.String[] r5 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L26
            r7 = 0
            r8 = 0
            r3 = 0
            r6 = 0
            r1 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L26
            int r11 = r10.getCount()     // Catch: java.lang.Throwable -> L26
            r10.close()     // Catch: java.lang.Throwable -> L23
            goto L2c
        L23:
            r0 = move-exception
            r10 = r0
            goto L29
        L26:
            r0 = move-exception
            r10 = r0
            r11 = r9
        L29:
            S0.b.p0(r10)
        L2c:
            if (r11 <= 0) goto L2f
            r9 = 1
        L2f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.C1912a.e(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    @Override // J0.a
    public boolean getLogTypeSwitch(String str) {
        return false;
    }

    @Override // J0.a
    public boolean getServiceSwitch(String str) {
        return false;
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            L.a aVar = h.e;
            if (aVar != null) {
                jSONObject.put("user_unique_id", aVar.b());
                jSONObject.put("ab_sdk_version", h.e.a());
                jSONObject.put("ssid", h.e.c());
                jSONObject.put("user_id", h.e.getUserId());
                jSONObject.put("device_id", h.e.getDid());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // J0.a
    public boolean c(String str) {
        return false;
    }

    @Override // J0.a
    public boolean a(String str) {
        return false;
    }

    @Override // J0.a
    public boolean a(String str, String str2) {
        return false;
    }
}
