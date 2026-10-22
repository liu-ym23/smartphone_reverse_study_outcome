package q7;

import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c implements w7.c, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public transient w7.c f8800f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f8801g;

    /* renamed from: h, reason: collision with root package name */
    public final Class f8802h;

    /* renamed from: i, reason: collision with root package name */
    public final String f8803i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8804j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f8805k;

    public c(Object obj, Class cls, String str, String str2, boolean z4) {
        this.f8801g = obj;
        this.f8802h = cls;
        this.f8803i = str;
        this.f8804j = str2;
        this.f8805k = z4;
    }

    public String A() {
        return this.f8804j;
    }

    public w7.c a() {
        w7.c cVar = this.f8800f;
        if (cVar != null) {
            return cVar;
        }
        w7.c cVarX = x();
        this.f8800f = cVarX;
        return cVarX;
    }

    @Override // w7.c
    public final w7.u f() {
        return z().f();
    }

    @Override // w7.c
    public String getName() {
        return this.f8803i;
    }

    @Override // w7.c
    public final List getParameters() {
        return z().getParameters();
    }

    @Override // w7.c
    public final Object h(Object... objArr) {
        return z().h(objArr);
    }

    @Override // w7.c
    public final Object n(KotlinJsonAdapter.IndexedParameterMap indexedParameterMap) {
        return z().n(indexedParameterMap);
    }

    @Override // w7.b
    public final List w() {
        return z().w();
    }

    public abstract w7.c x();

    public w7.f y() {
        Class cls = this.f8802h;
        if (cls == null) {
            return null;
        }
        return this.f8805k ? w.f8821a.c(cls, "") : w.f8821a.b(cls);
    }

    public abstract w7.c z();
}
