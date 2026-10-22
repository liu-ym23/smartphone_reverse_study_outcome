package w7;

import b8.q0;
import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public String f15290a;

    /* renamed from: b, reason: collision with root package name */
    public c8.a f15291b;

    /* renamed from: c, reason: collision with root package name */
    public n f15292c;

    /* renamed from: d, reason: collision with root package name */
    public c8.a f15293d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f15294e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f15295f;

    /* renamed from: g, reason: collision with root package name */
    public String f15296g;

    /* renamed from: h, reason: collision with root package name */
    public b.b f15297h;
    public String i;

    /* JADX WARN: Multi-variable type inference failed */
    public e a() {
        g8.a aVar;
        String str = this.i;
        String str2 = this.f15296g;
        if (str2 == null || str2.trim().isEmpty()) {
            c cVar = new c(1);
            cVar.f15289f = this;
            VarHandle.storeStoreFence();
            aVar = new g8.a(cVar);
        } else {
            str = this.f15296g;
            if (str.contains("{")) {
                c cVar2 = new c(0);
                cVar2.f15289f = this;
                VarHandle.storeStoreFence();
                aVar = new g8.a(cVar2);
            } else {
                String str3 = this.f15296g;
                Objects.requireNonNull(str3);
                q0 q0Var = new q0(5);
                q0Var.f2013f = str3;
                VarHandle.storeStoreFence();
                aVar = q0Var;
            }
        }
        String str4 = this.f15290a;
        c8.a aVar2 = this.f15291b;
        n nVar = this.f15292c;
        c8.a aVar3 = this.f15293d;
        Object[] objArr = this.f15294e;
        HashMap map = this.f15295f;
        e eVar = new e();
        eVar.f15298a = str4;
        eVar.f15301d = aVar3;
        eVar.f15300c = nVar;
        eVar.f15299b = aVar2;
        eVar.f15302e = objArr;
        eVar.f15305h = map;
        eVar.f15303f = str;
        eVar.f15304g = aVar;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public final Object b(String str) {
        if (this.f15295f == null) {
            this.f15295f = new HashMap();
        }
        this.f15295f.put("property", str);
        return (j) this;
    }
}
