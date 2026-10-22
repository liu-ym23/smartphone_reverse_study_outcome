package l3;

import a7.g;
import android.content.Context;
import android.content.SharedPreferences;
import f4.r0;
import f8.x;
import h4.j;
import i5.l;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.crypto.NoSuchPaddingException;
import t3.n;

/* loaded from: classes.dex */
public final class e implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f5837a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f5838b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final String f5839c;

    /* renamed from: d, reason: collision with root package name */
    public final t3.a f5840d;

    /* renamed from: e, reason: collision with root package name */
    public final t3.c f5841e;

    public e(String str, SharedPreferences sharedPreferences, t3.a aVar, t3.c cVar) {
        this.f5839c = str;
        this.f5837a = sharedPreferences;
        this.f5840d = aVar;
        this.f5841e = cVar;
    }

    public static e a(Context context, String str, x xVar) throws NoSuchPaddingException, NoSuchAlgorithmException {
        l lVarC;
        l lVarC2;
        String str2 = xVar.f3520g;
        int i2 = y3.a.f11546a;
        n.g(y3.c.f11551b);
        if (!x3.a.a()) {
            n.e(new g4.a(r0.class, new b4.c[]{new b4.c(t3.c.class, 13)}, 10), true);
        }
        u3.a.a();
        Context applicationContext = context.getApplicationContext();
        g gVar = new g(3);
        gVar.f423l = t3.b.a("AES256_SIV");
        gVar.A(applicationContext, "__androidx_security_crypto_encrypted_prefs_key_keyset__", str);
        gVar.z("android-keystore://" + str2);
        z3.a aVarI = gVar.i();
        synchronized (aVarI) {
            lVarC = aVarI.f11800a.c();
        }
        g gVar2 = new g(3);
        gVar2.f423l = t3.b.a("AES256_GCM");
        gVar2.A(applicationContext, "__androidx_security_crypto_encrypted_prefs_value_keyset__", str);
        gVar2.z("android-keystore://" + str2);
        z3.a aVarI2 = gVar2.i();
        synchronized (aVarI2) {
            lVarC2 = aVarI2.f11800a.c();
        }
        return new e(str, applicationContext.getSharedPreferences(str, 0), (t3.a) lVarC2.A(t3.a.class), (t3.c) lVarC.A(t3.c.class));
    }

    public static boolean d(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    public final String b(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            try {
                return new String(j.b(this.f5841e.a(str.getBytes(StandardCharsets.UTF_8), this.f5839c.getBytes())), "US-ASCII");
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        } catch (GeneralSecurityException e11) {
            throw new SecurityException("Could not encrypt key. " + e11.getMessage(), e11);
        }
    }

    public final Object c(String str) {
        String str2;
        if (d(str)) {
            throw new SecurityException(a1.a.i(str, " is a reserved key for the encryption keyset."));
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strB = b(str);
            String string = this.f5837a.getString(strB, null);
            if (string != null) {
                byte[] bArrA = j.a(string);
                t3.a aVar = this.f5840d;
                Charset charset = StandardCharsets.UTF_8;
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(aVar.b(bArrA, strB.getBytes(charset)));
                byteBufferWrap.position(0);
                int i2 = byteBufferWrap.getInt();
                int i10 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? 0 : 6 : 5 : 4 : 3 : 2 : 1;
                if (i10 == 0) {
                    throw new SecurityException("Unknown type ID for encrypted pref value: " + i2);
                }
                int iD = n.f.d(i10);
                if (iD == 0) {
                    int i11 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                    byteBufferWrap.limit(i11);
                    String string2 = charset.decode(byteBufferSlice).toString();
                    if (!string2.equals("__NULL__")) {
                        return string2;
                    }
                } else {
                    if (iD != 1) {
                        if (iD == 2) {
                            return Integer.valueOf(byteBufferWrap.getInt());
                        }
                        if (iD == 3) {
                            return Long.valueOf(byteBufferWrap.getLong());
                        }
                        if (iD == 4) {
                            return Float.valueOf(byteBufferWrap.getFloat());
                        }
                        if (iD == 5) {
                            return Boolean.valueOf(byteBufferWrap.get() != 0);
                        }
                        switch (i10) {
                            case 1:
                                str2 = "STRING";
                                break;
                            case 2:
                                str2 = "STRING_SET";
                                break;
                            case 3:
                                str2 = "INT";
                                break;
                            case 4:
                                str2 = "LONG";
                                break;
                            case 5:
                                str2 = "FLOAT";
                                break;
                            case 6:
                                str2 = "BOOLEAN";
                                break;
                            default:
                                str2 = "null";
                                break;
                        }
                        throw new SecurityException("Unhandled type for encrypted pref value: ".concat(str2));
                    }
                    k.f fVar = new k.f(0);
                    while (byteBufferWrap.hasRemaining()) {
                        int i12 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                        byteBufferSlice2.limit(i12);
                        byteBufferWrap.position(byteBufferWrap.position() + i12);
                        fVar.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                    }
                    if (fVar.f5486h != 1 || !"__NULL__".equals(fVar.f5485g[0])) {
                        return fVar;
                    }
                }
            }
            return null;
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not decrypt value. " + e10.getMessage(), e10);
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        if (d(str)) {
            throw new SecurityException(a1.a.i(str, " is a reserved key for the encryption keyset."));
        }
        return this.f5837a.contains(b(str));
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new d(this, this.f5837a.edit());
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.f5837a.getAll().entrySet()) {
            if (!d(entry.getKey())) {
                try {
                    String str = new String(this.f5841e.b(j.a(entry.getKey()), this.f5839c.getBytes()), StandardCharsets.UTF_8);
                    if (str.equals("__NULL__")) {
                        str = null;
                    }
                    map.put(str, c(str));
                } catch (GeneralSecurityException e10) {
                    throw new SecurityException("Could not decrypt key. " + e10.getMessage(), e10);
                }
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z4) {
        Object objC = c(str);
        return objC instanceof Boolean ? ((Boolean) objC).booleanValue() : z4;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f10) {
        Object objC = c(str);
        return objC instanceof Float ? ((Float) objC).floatValue() : f10;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i2) {
        Object objC = c(str);
        return objC instanceof Integer ? ((Integer) objC).intValue() : i2;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j2) {
        Object objC = c(str);
        return objC instanceof Long ? ((Long) objC).longValue() : j2;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object objC = c(str);
        return objC instanceof String ? (String) objC : str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Object objC = c(str);
        Set fVar = objC instanceof Set ? (Set) objC : new k.f(0);
        return fVar.size() > 0 ? fVar : set;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f5838b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f5838b.remove(onSharedPreferenceChangeListener);
    }
}
