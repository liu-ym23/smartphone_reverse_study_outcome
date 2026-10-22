package yb;

import java.io.Serializable;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c implements fc.a, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public transient fc.a f16082c;

    /* renamed from: f, reason: collision with root package name */
    public final Object f16083f;

    /* renamed from: g, reason: collision with root package name */
    public final Class f16084g;

    /* renamed from: h, reason: collision with root package name */
    public final String f16085h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f16086j;

    public c(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f16083f = obj;
        this.f16084g = cls;
        this.f16085h = str;
        this.i = str2;
        this.f16086j = z10;
    }

    public abstract fc.a a();

    public final d d() {
        boolean z10 = this.f16086j;
        Class cls = this.f16084g;
        if (!z10) {
            return v.a(cls);
        }
        v.f16099a.getClass();
        n nVar = new n();
        nVar.f16092a = cls;
        VarHandle.storeStoreFence();
        return nVar;
    }
}
