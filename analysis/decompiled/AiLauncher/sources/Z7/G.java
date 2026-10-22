package Z7;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class G extends F {

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, byte[]> f7317f = null;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<String, Object> f7318g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public K f7319h = new K();

    @Override // Z7.F
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    @Override // Z7.F
    public <T> void b(String str, T t10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, UnsupportedEncodingException {
        if (this.f7317f == null) {
            super.b(str, t10);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t10 == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t10 instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        L l10 = new L();
        l10.a(this.f7315d);
        l10.i(t10, 0);
        this.f7317f.put(str, M.e(l10.f7332a));
    }

    public final <T> T d(String str, T t10) throws com.tencent.bugly.proguard.b {
        HashMap<String, byte[]> map = this.f7317f;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (this.f7318g.containsKey(str)) {
                return (T) this.f7318g.get(str);
            }
            try {
                this.f7319h.r(this.f7317f.get(str));
                this.f7319h.f(this.f7315d);
                T t11 = (T) this.f7319h.i(t10, 0, true);
                if (t11 != null) {
                    f(str, t11);
                }
                return t11;
            } catch (Exception e10) {
                throw new com.tencent.bugly.proguard.b(e10);
            }
        }
        if (!this.f7312a.containsKey(str)) {
            return null;
        }
        if (this.f7318g.containsKey(str)) {
            return (T) this.f7318g.get(str);
        }
        byte[] value = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f7312a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            value = next.getValue();
        }
        try {
            this.f7319h.r(value);
            this.f7319h.f(this.f7315d);
            T t12 = (T) this.f7319h.i(t10, 0, true);
            f(str, t12);
            return t12;
        } catch (Exception e11) {
            throw new com.tencent.bugly.proguard.b(e11);
        }
    }

    public void e() {
        this.f7317f = new HashMap<>();
    }

    public final void f(String str, Object obj) {
        this.f7318g.put(str, obj);
    }
}
