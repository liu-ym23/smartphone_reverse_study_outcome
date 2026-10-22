package nc;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class g implements c {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f37300a;

    /* renamed from: b, reason: collision with root package name */
    public TreeMap<String, String> f37301b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // nc.c
    public void a(String str, String str2) {
        this.f37301b.put(str, str2);
    }

    @Override // nc.f
    public boolean c(String str) {
        return this.f37301b.containsKey(str);
    }

    @Override // nc.f
    public Iterator<String> e() {
        return Collections.unmodifiableSet(this.f37301b.keySet()).iterator();
    }

    @Override // nc.f
    public byte[] getContent() {
        return this.f37300a;
    }

    @Override // nc.f
    public String i(String str) {
        String str2 = this.f37301b.get(str);
        return str2 == null ? "" : str2;
    }
}
