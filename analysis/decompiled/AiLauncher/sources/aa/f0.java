package aa;

import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f8129a;

    /* renamed from: b, reason: collision with root package name */
    public final List<p0> f8130b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8131c;

    /* renamed from: d, reason: collision with root package name */
    public final f0 f8132d;

    public f0() {
        this(null, null, null, 7, null);
    }

    public final String a() {
        return this.f8131c;
    }

    public final List<p0> b() {
        return this.f8130b;
    }

    public final p0 c() {
        return this.f8129a;
    }

    public final f0 d() {
        return this.f8132d;
    }

    public f0(p0 p0Var, List<p0> parametersInfo, String str) {
        kotlin.jvm.internal.p.i(parametersInfo, "parametersInfo");
        this.f8129a = p0Var;
        this.f8130b = parametersInfo;
        this.f8131c = str;
        f0 f0Var = null;
        if (str != null) {
            p0 p0VarA = p0Var != null ? p0Var.a() : null;
            List<p0> list = parametersInfo;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (p0 p0Var2 : list) {
                arrayList.add(p0Var2 != null ? p0Var2.a() : null);
            }
            f0Var = new f0(p0VarA, arrayList, null);
        }
        this.f8132d = f0Var;
    }

    public /* synthetic */ f0(p0 p0Var, List list, String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : p0Var, (i10 & 2) != 0 ? C1173v.m() : list, (i10 & 4) != 0 ? null : str);
    }
}
