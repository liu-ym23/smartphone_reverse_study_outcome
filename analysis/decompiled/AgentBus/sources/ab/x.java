package ab;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.ProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.crypto.KeyGenerator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f667a;

    /* renamed from: b, reason: collision with root package name */
    public int f668b;

    /* renamed from: c, reason: collision with root package name */
    public Object f669c;

    /* renamed from: d, reason: collision with root package name */
    public Object f670d;

    public /* synthetic */ x(int i2, byte b10) {
        this.f667a = i2;
    }

    public static x b(String str) throws JSONException {
        x xVar = new x(6, (byte) 0);
        xVar.f668b = 0;
        try {
        } catch (Exception e10) {
            j6.a.c("NotificationCoreData", "create error " + e10.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return xVar;
        }
        JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject("extra");
        xVar.f670d = jSONObject.getString("se");
        if (jSONObject.has("no")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("no");
            xVar.f668b = jSONObject2.optInt("ni");
            xVar.f669c = jSONObject2.optString("nk");
        }
        j6.a.b("NotificationCoreData", "current notify option is " + xVar);
        return xVar;
    }

    public static void c(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length) {
            boolean z10 = q7.k.f(str.charAt(!z4 ? i2 : length), 32) <= 0;
            if (z4) {
                if (!z10) {
                    break;
                } else {
                    length--;
                }
            } else if (z10) {
                i2++;
            } else {
                z4 = true;
            }
        }
        if (str.subSequence(i2, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e10) {
            Log.w("SupportSQLite", "delete failed: ", e10);
        }
    }

    public f8.x a() {
        int i2 = this.f668b;
        if (i2 == 0 && ((KeyGenParameterSpec) this.f670d) == null) {
            throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
        }
        if (i2 == 1) {
            this.f670d = new KeyGenParameterSpec.Builder((String) this.f669c, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build();
        }
        KeyGenParameterSpec keyGenParameterSpec = (KeyGenParameterSpec) this.f670d;
        if (keyGenParameterSpec == null) {
            throw new NullPointerException("KeyGenParameterSpec was null after build() check");
        }
        Object obj = l3.f.f5842a;
        if (keyGenParameterSpec.getKeySize() != 256) {
            throw new IllegalArgumentException("invalid key size, want 256 bits got " + keyGenParameterSpec.getKeySize() + " bits");
        }
        if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{"GCM"})) {
            throw new IllegalArgumentException("invalid block mode, want GCM got " + Arrays.toString(keyGenParameterSpec.getBlockModes()));
        }
        if (keyGenParameterSpec.getPurposes() != 3) {
            throw new IllegalArgumentException("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got " + keyGenParameterSpec.getPurposes());
        }
        if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            throw new IllegalArgumentException("invalid padding mode, want NoPadding got " + Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
        }
        if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
            throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
        }
        synchronized (l3.f.f5842a) {
            String keystoreAlias = keyGenParameterSpec.getKeystoreAlias();
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!keyStore.containsAlias(keystoreAlias)) {
                try {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                    keyGenerator.init(keyGenParameterSpec);
                    keyGenerator.generateKey();
                } catch (ProviderException e10) {
                    throw new GeneralSecurityException(e10.getMessage(), e10);
                }
            }
        }
        return new f8.x((KeyGenParameterSpec) this.f670d, keyGenParameterSpec.getKeystoreAlias());
    }

    public String d() {
        StringBuilder sb2 = new StringBuilder("$");
        int i2 = this.f668b + 1;
        for (int i10 = 0; i10 < i2; i10++) {
            Object obj = ((Object[]) this.f669c)[i10];
            if (obj instanceof ua.d) {
                ua.d dVar = (ua.d) obj;
                if (!q7.k.a(dVar.getKind(), ua.f.f10217c)) {
                    int i11 = ((int[]) this.f670d)[i10];
                    if (i11 >= 0) {
                        sb2.append(".");
                        sb2.append(dVar.d(i11));
                    }
                } else if (((int[]) this.f670d)[i10] != -1) {
                    sb2.append("[");
                    sb2.append(((int[]) this.f670d)[i10]);
                    sb2.append("]");
                }
            } else if (obj != ya.g.f11737a) {
                sb2.append("['");
                sb2.append(obj);
                sb2.append("']");
            }
        }
        return sb2.toString();
    }

    public void e(int i2, int i10, int i11, int i12, int i13, int i14, boolean z4, boolean z10) {
        long[] jArr = (long[]) this.f669c;
        int i15 = this.f668b;
        int i16 = i15 + 3;
        this.f668b = i16;
        int length = jArr.length;
        if (length <= i16) {
            int iMax = Math.max(length * 2, i16);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            q7.k.d(jArrCopyOf, "copyOf(...)");
            this.f669c = jArrCopyOf;
            long[] jArrCopyOf2 = Arrays.copyOf((long[]) this.f670d, iMax);
            q7.k.d(jArrCopyOf2, "copyOf(...)");
            this.f670d = jArrCopyOf2;
        }
        long[] jArr2 = (long[]) this.f669c;
        jArr2[i15] = (i10 << 32) | (i11 & 4294967295L);
        jArr2[i15 + 1] = (i12 << 32) | (i13 & 4294967295L);
        int i17 = i14 & 67108863;
        jArr2[i15 + 2] = ((z10 ? 1L : 0L) << 63) | ((z4 ? 1L : 0L) << 62) | (1 << 61) | (0 << 52) | (i17 << 26) | (i2 & 67108863);
        if (i14 < 0) {
            return;
        }
        for (int i18 = i15 - 3; i18 >= 0; i18 -= 3) {
            int i19 = i18 + 2;
            long j2 = jArr2[i19];
            if ((((int) j2) & 67108863) == i17) {
                jArr2[i19] = (j2 & (-2301339409586323457L)) | (((i15 - i18) & 511) << 52);
                return;
            }
        }
    }

    public void f(n3.c cVar) {
    }

    public void g(n3.c cVar) throws IOException, SQLException {
        a7.d dVar = (a7.d) this.f670d;
        Cursor cursorN = cVar.n("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z4 = false;
            if (cursorN.moveToFirst()) {
                if (cursorN.getInt(0) == 0) {
                    z4 = true;
                }
            }
            cursorN.close();
            cVar.g("CREATE TABLE IF NOT EXISTS `offline_frame` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `frame_json` TEXT NOT NULL, `size_bytes` INTEGER NOT NULL, `created_at` INTEGER NOT NULL, `ttl_expires_at` INTEGER NOT NULL, `target_kind` TEXT NOT NULL)");
            cVar.g("CREATE TABLE IF NOT EXISTS `offline_frame_tombstone` (`frame_id` TEXT NOT NULL, `reason` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `expires_at` INTEGER NOT NULL, PRIMARY KEY(`frame_id`))");
            cVar.g("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            cVar.g("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0fc615975e3ad8f759cb4cb93f88f109')");
            if (!z4) {
                a7.c cVarZ = a7.d.z(cVar);
                if (!cVarZ.f408b) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + ((String) cVarZ.f409c));
                }
            }
            cVar.g("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            cVar.g("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '0fc615975e3ad8f759cb4cb93f88f109')");
            ArrayList arrayList = ((OfflineQueueDatabase_Impl) dVar.f411g).f2671f;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                n7.b.d(cursorN, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(n3.c r7) throws java.io.IOException, android.database.SQLException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.x.h(n3.c):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x008f A[EDGE_INSN: B:95:0x008f->B:36:0x008f BREAK  A[LOOP:3: B:11:0x002e->B:98:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(n3.c r17, int r18, int r19) throws java.io.IOException, android.database.SQLException {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.x.i(n3.c, int, int):void");
    }

    public void j() {
        if (n.f.d(1) != 0) {
            throw new IllegalArgumentException("Unsupported scheme: ".concat("AES256_GCM"));
        }
        if (((KeyGenParameterSpec) this.f670d) != null) {
            throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
        }
        this.f668b = 1;
    }

    public void k(int i2, p7.p pVar) {
        int i10 = i2 & 67108863;
        long[] jArr = (long[]) this.f669c;
        int i11 = this.f668b;
        for (int i12 = 0; i12 < jArr.length - 2 && i12 < i11; i12 += 3) {
            if ((((int) jArr[i12 + 2]) & 67108863) == i10) {
                long j2 = jArr[i12];
                long j4 = jArr[i12 + 1];
                pVar.u(Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2), Integer.valueOf((int) (j4 >> 32)), Integer.valueOf((int) j4));
                return;
            }
        }
    }

    public String toString() {
        switch (this.f667a) {
            case 1:
                StringBuilder sb2 = new StringBuilder();
                if (((u) this.f669c) == u.HTTP_1_0) {
                    sb2.append("HTTP/1.0");
                } else {
                    sb2.append("HTTP/1.1");
                }
                sb2.append(' ');
                sb2.append(this.f668b);
                sb2.append(' ');
                sb2.append((String) this.f670d);
                String string = sb2.toString();
                q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            case 6:
                StringBuilder sb3 = new StringBuilder("NotificationCoreData(notifyId=");
                sb3.append(this.f668b);
                sb3.append(", notifyKey=");
                sb3.append((String) this.f669c);
                sb3.append(", securityEncryption=");
                return a1.a.m(sb3, (String) this.f670d, ")");
            case 7:
                return d();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ x(Object obj, int i2, Serializable serializable, int i10) {
        this.f667a = i10;
        this.f669c = obj;
        this.f668b = i2;
        this.f670d = serializable;
    }

    public x(g3.e eVar, a7.d dVar) {
        this.f667a = 2;
        this.f667a = 2;
        this.f668b = 2;
        this.f669c = eVar;
        this.f670d = dVar;
    }

    public x(Context context, int i2) {
        this.f667a = 4;
        context.getApplicationContext();
        this.f669c = "_androidx_security_master_key_";
    }
}
