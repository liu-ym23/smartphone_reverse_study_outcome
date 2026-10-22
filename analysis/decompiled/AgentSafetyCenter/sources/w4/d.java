package w4;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.crypto.tink.subtle.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public e f15218a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f15219b;

    /* renamed from: c, reason: collision with root package name */
    public CopyOnWriteArrayList f15220c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicBoolean f15221d;

    public final void a() {
        e eVar = this.f15218a;
        if (this.f15221d.getAndSet(false)) {
            for (String str : ((HashMap) eVar.getAll()).keySet()) {
                if (!this.f15220c.contains(str) && !e.c(str)) {
                    this.f15219b.remove(eVar.a(str));
                }
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        a();
        this.f15219b.apply();
        b();
        this.f15220c.clear();
    }

    public final void b() {
        e eVar = this.f15218a;
        Iterator it = eVar.f15223b.iterator();
        while (it.hasNext()) {
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
            Iterator it2 = this.f15220c.iterator();
            while (it2.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(eVar, (String) it2.next());
            }
        }
    }

    public final void c(String str, byte[] bArr) {
        e eVar = this.f15218a;
        eVar.getClass();
        if (e.c(str)) {
            throw new SecurityException(k0.a.n(str, " is a reserved key for the encryption keyset."));
        }
        this.f15220c.add(str);
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strA = eVar.a(str);
            Pair pair = new Pair(strA, Base64.encode(eVar.f15225d.encrypt(bArr, strA.getBytes(StandardCharsets.UTF_8))));
            this.f15219b.putString((String) pair.first, (String) pair.second);
        } catch (GeneralSecurityException e10) {
            od.f.i(e10, e10.getMessage(), "Could not encrypt data: ");
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.f15221d.set(true);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f15220c;
        a();
        try {
            return this.f15219b.commit();
        } finally {
            b();
            copyOnWriteArrayList.clear();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        byteBufferAllocate.putInt(5);
        byteBufferAllocate.put(z10 ? (byte) 1 : (byte) 0);
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f5) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(4);
        byteBufferAllocate.putFloat(f5);
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(2);
        byteBufferAllocate.putInt(i);
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.putInt(3);
        byteBufferAllocate.putLong(j10);
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        if (str2 == null) {
            str2 = "__NULL__";
        }
        byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
        int length = bytes.length;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.put(bytes);
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        int i = 0;
        if (set == null) {
            set = new p.f(0);
            set.add("__NULL__");
        }
        ArrayList arrayList = new ArrayList(set.size());
        int size = set.size() * 4;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            byte[] bytes = ((String) it.next()).getBytes(StandardCharsets.UTF_8);
            arrayList.add(bytes);
            size += bytes.length;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(size + 4);
        byteBufferAllocate.putInt(1);
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            byte[] bArr = (byte[]) obj;
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        e eVar = this.f15218a;
        eVar.getClass();
        if (e.c(str)) {
            throw new SecurityException(k0.a.n(str, " is a reserved key for the encryption keyset."));
        }
        this.f15219b.remove(eVar.a(str));
        this.f15220c.add(str);
        return this;
    }
}
