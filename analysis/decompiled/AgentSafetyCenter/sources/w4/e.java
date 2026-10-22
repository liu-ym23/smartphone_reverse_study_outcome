package w4;

import android.content.SharedPreferences;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.subtle.Base64;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f15222a;

    /* renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList f15223b;

    /* renamed from: c, reason: collision with root package name */
    public String f15224c;

    /* renamed from: d, reason: collision with root package name */
    public Aead f15225d;

    /* renamed from: e, reason: collision with root package name */
    public DeterministicAead f15226e;

    public static boolean c(String str) {
        return "__androidx_security_crypto_encrypted_prefs_key_keyset__".equals(str) || "__androidx_security_crypto_encrypted_prefs_value_keyset__".equals(str);
    }

    public final String a(String str) {
        if (str == null) {
            str = "__NULL__";
        }
        try {
            return Base64.encode(this.f15226e.encryptDeterministically(str.getBytes(StandardCharsets.UTF_8), this.f15224c.getBytes()));
        } catch (GeneralSecurityException e10) {
            od.f.i(e10, e10.getMessage(), "Could not encrypt key. ");
            return null;
        }
    }

    public final Object b(String str) {
        String str2;
        if (c(str)) {
            throw new SecurityException(k0.a.n(str, " is a reserved key for the encryption keyset."));
        }
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strA = a(str);
            String string = this.f15222a.getString(strA, null);
            if (string != null) {
                byte[] bArrDecode = Base64.decode(string, 0);
                Aead aead = this.f15225d;
                Charset charset = StandardCharsets.UTF_8;
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(aead.decrypt(bArrDecode, strA.getBytes(charset)));
                byteBufferWrap.position(0);
                int i = byteBufferWrap.getInt();
                int i3 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? 0 : 6 : 5 : 4 : 3 : 2 : 1;
                if (i3 == 0) {
                    throw new SecurityException("Unknown type ID for encrypted pref value: " + i);
                }
                int iC = s.f.c(i3);
                if (iC == 0) {
                    int i10 = byteBufferWrap.getInt();
                    ByteBuffer byteBufferSlice = byteBufferWrap.slice();
                    byteBufferWrap.limit(i10);
                    String string2 = charset.decode(byteBufferSlice).toString();
                    if (!string2.equals("__NULL__")) {
                        return string2;
                    }
                } else {
                    if (iC != 1) {
                        if (iC == 2) {
                            return Integer.valueOf(byteBufferWrap.getInt());
                        }
                        if (iC == 3) {
                            return Long.valueOf(byteBufferWrap.getLong());
                        }
                        if (iC == 4) {
                            return Float.valueOf(byteBufferWrap.getFloat());
                        }
                        if (iC == 5) {
                            return Boolean.valueOf(byteBufferWrap.get() != 0);
                        }
                        switch (i3) {
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
                    p.f fVar = new p.f(0);
                    while (byteBufferWrap.hasRemaining()) {
                        int i11 = byteBufferWrap.getInt();
                        ByteBuffer byteBufferSlice2 = byteBufferWrap.slice();
                        byteBufferSlice2.limit(i11);
                        byteBufferWrap.position(byteBufferWrap.position() + i11);
                        fVar.add(StandardCharsets.UTF_8.decode(byteBufferSlice2).toString());
                    }
                    if (fVar.f9551g != 1 || !"__NULL__".equals(fVar.f9550f[0])) {
                        return fVar;
                    }
                }
            }
            return null;
        } catch (GeneralSecurityException e10) {
            od.f.i(e10, e10.getMessage(), "Could not decrypt value. ");
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        if (c(str)) {
            throw new SecurityException(k0.a.n(str, " is a reserved key for the encryption keyset."));
        }
        return this.f15222a.contains(a(str));
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        SharedPreferences.Editor editorEdit = this.f15222a.edit();
        d dVar = new d();
        dVar.f15221d = new AtomicBoolean(false);
        dVar.f15218a = this;
        dVar.f15219b = editorEdit;
        dVar.f15220c = new CopyOnWriteArrayList();
        VarHandle.storeStoreFence();
        return dVar;
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : this.f15222a.getAll().entrySet()) {
            if (!c(entry.getKey())) {
                try {
                    String str = new String(this.f15226e.decryptDeterministically(Base64.decode(entry.getKey(), 0), this.f15224c.getBytes()), StandardCharsets.UTF_8);
                    if (str.equals("__NULL__")) {
                        str = null;
                    }
                    map.put(str, b(str));
                } catch (GeneralSecurityException e10) {
                    od.f.i(e10, e10.getMessage(), "Could not decrypt key. ");
                    return null;
                }
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z10) {
        Object objB = b(str);
        return objB instanceof Boolean ? ((Boolean) objB).booleanValue() : z10;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f5) {
        Object objB = b(str);
        return objB instanceof Float ? ((Float) objB).floatValue() : f5;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        Object objB = b(str);
        return objB instanceof Integer ? ((Integer) objB).intValue() : i;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j10) {
        Object objB = b(str);
        return objB instanceof Long ? ((Long) objB).longValue() : j10;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Object objB = b(str);
        return objB instanceof String ? (String) objB : str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Object objB = b(str);
        Set fVar = objB instanceof Set ? (Set) objB : new p.f(0);
        return fVar.size() > 0 ? fVar : set;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f15223b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f15223b.remove(onSharedPreferenceChangeListener);
    }
}
