package v0;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e extends ContextWrapper {

    /* renamed from: j, reason: collision with root package name */
    static final k<?, ?> f23244j = new C1179b();

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f23245a;

    /* renamed from: b, reason: collision with root package name */
    private final h f23246b;

    /* renamed from: c, reason: collision with root package name */
    private final U0.b f23247c;

    /* renamed from: d, reason: collision with root package name */
    private final T0.h f23248d;

    /* renamed from: e, reason: collision with root package name */
    private final List<T0.g<Object>> f23249e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f23250f;

    /* renamed from: g, reason: collision with root package name */
    private final C0.k f23251g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f23252h;

    /* renamed from: i, reason: collision with root package name */
    private final int f23253i;

    public e(Context context, D0.b bVar, h hVar, U0.b bVar2, T0.h hVar2, Map<Class<?>, k<?, ?>> map, List<T0.g<Object>> list, C0.k kVar, boolean z5, int i5) {
        super(context.getApplicationContext());
        this.f23245a = bVar;
        this.f23246b = hVar;
        this.f23247c = bVar2;
        this.f23248d = hVar2;
        this.f23249e = list;
        this.f23250f = map;
        this.f23251g = kVar;
        this.f23252h = z5;
        this.f23253i = i5;
    }

    public D0.b a() {
        return this.f23245a;
    }

    public List<T0.g<Object>> b() {
        return this.f23249e;
    }

    public T0.h c() {
        return this.f23248d;
    }

    public <T> k<?, T> d(Class<T> cls) {
        k<?, T> kVar = (k) this.f23250f.get(cls);
        if (kVar == null) {
            for (Map.Entry<Class<?>, k<?, ?>> entry : this.f23250f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    kVar = (k) entry.getValue();
                }
            }
        }
        return kVar == null ? (k<?, T>) f23244j : kVar;
    }

    public C0.k e() {
        return this.f23251g;
    }

    public int f() {
        return this.f23253i;
    }

    public h g() {
        return this.f23246b;
    }

    public boolean h() {
        return this.f23252h;
    }
}
