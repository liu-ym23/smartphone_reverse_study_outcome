package l3;

import android.content.SharedPreferences;
import android.util.Pair;
import h4.j;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class d implements SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public final e f5833a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences.Editor f5834b;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f5836d = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f5835c = new CopyOnWriteArrayList();

    public d(e eVar, SharedPreferences.Editor editor) {
        this.f5833a = eVar;
        this.f5834b = editor;
    }

    public final void a() {
        if (this.f5836d.getAndSet(false)) {
            e eVar = this.f5833a;
            for (String str : ((HashMap) eVar.getAll()).keySet()) {
                if (!this.f5835c.contains(str) && !e.d(str)) {
                    this.f5834b.remove(eVar.b(str));
                }
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        a();
        this.f5834b.apply();
        b();
        this.f5835c.clear();
    }

    public final void b() {
        e eVar = this.f5833a;
        Iterator it = eVar.f5838b.iterator();
        while (it.hasNext()) {
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
            Iterator it2 = this.f5835c.iterator();
            while (it2.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(eVar, (String) it2.next());
            }
        }
    }

    public final void c(String str, byte[] bArr) {
        e eVar = this.f5833a;
        eVar.getClass();
        if (e.d(str)) {
            throw new SecurityException(a1.a.i(str, " is a reserved key for the encryption keyset."));
        }
        this.f5835c.add(str);
        if (str == null) {
            str = "__NULL__";
        }
        try {
            String strB = eVar.b(str);
            try {
                Pair pair = new Pair(strB, new String(j.b(eVar.f5840d.a(bArr, strB.getBytes(StandardCharsets.UTF_8))), "US-ASCII"));
                this.f5834b.putString((String) pair.first, (String) pair.second);
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        } catch (GeneralSecurityException e11) {
            throw new SecurityException("Could not encrypt data: " + e11.getMessage(), e11);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.f5836d.set(true);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5835c;
        a();
        try {
            return this.f5834b.commit();
        } finally {
            b();
            copyOnWriteArrayList.clear();
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        byteBufferAllocate.putInt(5);
        byteBufferAllocate.put(z4 ? (byte) 1 : (byte) 0);
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(4);
        byteBufferAllocate.putFloat(f10);
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(2);
        byteBufferAllocate.putInt(i2);
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.putInt(3);
        byteBufferAllocate.putLong(j2);
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
        if (set == null) {
            set = new k.f(0);
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
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            byte[] bArr = (byte[]) it2.next();
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        c(str, byteBufferAllocate.array());
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        e eVar = this.f5833a;
        eVar.getClass();
        if (e.d(str)) {
            throw new SecurityException(a1.a.i(str, " is a reserved key for the encryption keyset."));
        }
        this.f5834b.remove(eVar.b(str));
        this.f5835c.add(str);
        return this;
    }
}
