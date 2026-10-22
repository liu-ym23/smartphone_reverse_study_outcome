package w7;

import androidx.room.t;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public l3.d f15306a;

    /* renamed from: b, reason: collision with root package name */
    public f8.b f15307b;

    /* renamed from: c, reason: collision with root package name */
    public t f15308c;

    /* renamed from: d, reason: collision with root package name */
    public List f15309d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f15310e;

    /* renamed from: f, reason: collision with root package name */
    public c8.a f15311f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayDeque f15312g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayDeque f15313h;
    public Boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15314j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f15315k;

    public final void a(e eVar) {
        this.f15309d.add(eVar);
        if (g()) {
            g gVar = new g();
            Objects.requireNonNull(eVar);
            gVar.f15316c = eVar;
            VarHandle.storeStoreFence();
            throw gVar;
        }
    }

    public final void b(int i) {
        this.f15311f = this.f15311f.a(i);
    }

    public final void c(String str) {
        this.f15311f = this.f15311f.b(str);
    }

    public final void d() {
        this.f15311f = this.f15311f.f2224f;
    }

    public final t e() {
        if (this.f15308c == null) {
            t tVar = new t(3);
            tVar.f1627b = new LinkedHashMap();
            VarHandle.storeStoreFence();
            this.f15308c = tVar;
        }
        return this.f15308c;
    }

    public final f8.b f() {
        if (this.f15307b == null) {
            this.f15307b = i8.a.f5825a;
        }
        return this.f15307b;
    }

    public final boolean g() {
        if (this.i == null) {
            this.i = Boolean.valueOf(this.f15306a.f7720c);
        }
        return this.i.booleanValue();
    }

    public final void h(boolean z10) {
        this.i = Boolean.valueOf(z10);
    }
}
