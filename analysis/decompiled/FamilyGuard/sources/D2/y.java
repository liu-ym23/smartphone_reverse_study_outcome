package D2;

import android.util.LruCache;

/* loaded from: classes.dex */
public class y implements i<String, String> {

    /* renamed from: a, reason: collision with root package name */
    private final LruCache<String, String> f1201a = new LruCache<>(200);

    @Override // D2.i
    public void a() {
        this.f1201a.evictAll();
    }

    @Override // D2.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get(String str) {
        return this.f1201a.get(str);
    }

    @Override // D2.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String put(String str, String str2) {
        return this.f1201a.put(str, str2);
    }
}
