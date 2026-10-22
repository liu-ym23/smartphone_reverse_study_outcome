package x0;

import android.content.Context;
import android.content.SharedPreferences;
import d2.f;
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
import k2.f0;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import y1.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6243a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f6244b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final String f6245c;
    public final y1.a d;

    /* renamed from: e, reason: collision with root package name */
    public final y1.c f6246e;

    public b(String str, SharedPreferences sharedPreferences, y1.a aVar, y1.c cVar) {
        this.f6245c = str;
        this.f6243a = sharedPreferences;
        this.d = aVar;
        this.f6246e = cVar;
    }

    public static b a(Context context, String str, c cVar) throws NoSuchPaddingException, NoSuchAlgorithmException {
        a4.d dVarC;
        a4.d dVarC2;
        String str2 = cVar.f6247a;
        int i8 = d2.d.f1786a;
        n.h(f.f1791b);
        int i9 = 0;
        if (!c2.a.a()) {
            n.f(new d2.c(f0.class, new d2.a[]{new d2.a(y1.c.class, 0)}, i9), true);
        }
        z1.a.a();
        Context applicationContext = context.getApplicationContext();
        g3.c cVar2 = new g3.c(1);
        cVar2.f2958f = y1.b.a("AES256_SIV");
        if (applicationContext == null) {
            throw new IllegalArgumentException("need an Android context");
        }
        cVar2.f2954a = applicationContext;
        cVar2.f2955b = "__androidx_security_crypto_encrypted_prefs_key_keyset__";
        cVar2.f2956c = str;
        String strC = m0.f.c("android-keystore://", str2);
        if (!strC.startsWith("android-keystore://")) {
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }
        cVar2.d = strC;
        e2.a aVarF = cVar2.f();
        synchronized (aVarF) {
            dVarC = aVarF.f2349a.c();
        }
        g3.c cVar3 = new g3.c(1);
        cVar3.f2958f = y1.b.a("AES256_GCM");
        cVar3.f2954a = applicationContext;
        cVar3.f2955b = "__androidx_security_crypto_encrypted_prefs_value_keyset__";
        cVar3.f2956c = str;
        String strC2 = m0.f.c("android-keystore://", str2);
        if (!strC2.startsWith("android-keystore://")) {
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        }
        cVar3.d = strC2;
        e2.a aVarF2 = cVar3.f();
        synchronized (aVarF2) {
            dVarC2 = aVarF2.f2349a.c();
        }
        y1.c cVar4 = (y1.c) dVarC.w(y1.c.class);
        return new b(str, applicationContext.getSharedPreferences(str, 0), (y1.a) dVarC2.w(y1.a.class), cVar4);
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
                return new String(l2.f.b(this.f6246e.a(str.getBytes(StandardCharsets.UTF_8), this.f6245c.getBytes())), "US-ASCII");
            } catch (UnsupportedEncodingException e9) {
                throw new AssertionError(e9);
            }
        } catch (GeneralSecurityException e10) {
            throw new SecurityException("Could not encrypt key. " + e10.getMessage(), e10);
        }
    }

    public final Object c(String str) {
        String str2;
        if (d(str)) {
            throw new SecurityException(a8.b.n(str, " is a reserved key for the encryption keyset."));
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strB = b(str);
            String string = this.f6243a.getString(strB, null);
            if (string != null) {
                byte[] bArrA = l2.f.a(string);
                y1.a aVar = this.d;
                Charset charset = StandardCharsets.UTF_8;
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(aVar.b(bArrA, strB.getBytes(charset)));
                byteBufferWrap.position(0);
                int i8 = byteBufferWrap.getInt();
                int i9 = i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? 0 : 6 : 5 : 4 : 3 : 2 : 1;
                if (i9 == 0) {
                    throw new SecurityException("Unknown type ID for encrypted pref value: " + i8);
                }
                int iA = m.f.a(i9);
                if (iA == 0) {
                    int i10 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                    byteBufferWrap.limit(i10);
                    String string2 = charset.decode(byteBufferSlice).toString();
                    if (!string2.equals("__NULL__")) {
                        return string2;
                    }
                } else {
                    if (iA != 1) {
                        if (iA == 2) {
                            return Integer.valueOf(byteBufferWrap.getInt());
                        }
                        if (iA == 3) {
                            return Long.valueOf(byteBufferWrap.getLong());
                        }
                        if (iA == 4) {
                            return Float.valueOf(byteBufferWrap.getFloat());
                        }
                        if (iA == 5) {
                            return Boolean.valueOf(byteBufferWrap.get() != 0);
                        }
                        switch (i9) {
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
                                str2 = AbstractJsonLexerKt.NULL;
                                break;
                        }
                        throw new SecurityException("Unhandled type for encrypted pref value: ".concat(str2));
                    }
                    j.f fVar = new j.f();
                    while (byteBufferWrap.hasRemaining()) {
                        int i11 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                        byteBufferSlice2.limit(i11);
                        byteBufferWrap.position(byteBufferWrap.position() + i11);
                        fVar.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                    }
                    if (fVar.f3292c != 1 || !"__NULL__".equals(fVar.f3291b[0])) {
                        return fVar;
                    }
                }
            }
            return null;
        } catch (GeneralSecurityException e9) {
            throw new SecurityException("Could not decrypt value. " + e9.getMessage(), e9);
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        if (d(str)) {
            throw new SecurityException(a8.b.n(str, " is a reserved key for the encryption keyset."));
        }
        return this.f6243a.contains(b(str));
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(this, this.f6243a.edit());
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.f6243a.getAll().entrySet()) {
            if (!d(entry.getKey())) {
                try {
                    String str = new String(this.f6246e.b(l2.f.a(entry.getKey()), this.f6245c.getBytes()), StandardCharsets.UTF_8);
                    if (str.equals("__NULL__")) {
                        str = null;
                    }
                    map.put(str, c(str));
                } catch (GeneralSecurityException e9) {
                    throw new SecurityException("Could not decrypt key. " + e9.getMessage(), e9);
                }
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        Object objC = c(str);
        return objC instanceof Boolean ? ((Boolean) objC).booleanValue() : z;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f3) {
        Object objC = c(str);
        return objC instanceof Float ? ((Float) objC).floatValue() : f3;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i8) {
        Object objC = c(str);
        return objC instanceof Integer ? ((Integer) objC).intValue() : i8;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j4) {
        Object objC = c(str);
        return objC instanceof Long ? ((Long) objC).longValue() : j4;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object objC = c(str);
        return objC instanceof String ? (String) objC : str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Object objC = c(str);
        Set fVar = objC instanceof Set ? (Set) objC : new j.f();
        return fVar.size() > 0 ? fVar : set;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f6244b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f6244b.remove(onSharedPreferenceChangeListener);
    }
}
