package u3;

import com.networknt.schema.FailFastAssertionException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public B0.f f6698a;
    public A3.a f;
    public h2.d b = null;
    public v3.b c = null;
    public List d = new ArrayList();
    public final HashMap e = new HashMap();
    public final ArrayDeque g = new ArrayDeque(64);
    public final ArrayDeque h = new ArrayDeque(64);
    public Boolean i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6699j = false;
    public boolean k = false;

    public f(B0.f fVar) {
        this.f6698a = fVar;
    }

    public final void a(e eVar) {
        this.d.add(eVar);
        if (g()) {
            throw new FailFastAssertionException(eVar);
        }
    }

    public final void b(int i) {
        A3.a aVar = this.f;
        aVar.getClass();
        this.f = new A3.a(aVar, i);
    }

    public final void c(String str) {
        A3.a aVar = this.f;
        aVar.getClass();
        this.f = new A3.a(aVar, str);
    }

    public final void d() {
        this.f = this.f.b;
    }

    public final v3.b e() {
        if (this.c == null) {
            this.c = new v3.b(0);
        }
        return this.c;
    }

    public final h2.d f() {
        if (this.b == null) {
            this.b = G3.b.f663a;
        }
        return this.b;
    }

    public final boolean g() {
        if (this.i == null) {
            this.i = Boolean.valueOf(this.f6698a.b);
        }
        return this.i.booleanValue();
    }

    public final void h(boolean z10) {
        this.i = Boolean.valueOf(z10);
    }
}
