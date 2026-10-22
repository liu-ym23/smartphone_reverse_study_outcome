package O9;

import P9.n;
import Z8.C1173v;
import ea.InterfaceC4020d;
import ea.h;
import ea.j;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4020d f5293a;

    /* renamed from: b, reason: collision with root package name */
    public final h f5294b;

    /* renamed from: c, reason: collision with root package name */
    public final j f5295c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5296d;

    /* renamed from: e, reason: collision with root package name */
    public final d f5297e;

    /* renamed from: f, reason: collision with root package name */
    public final List<Object> f5298f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<Integer, Integer> f5299g;

    /* renamed from: h, reason: collision with root package name */
    public final List<n> f5300h;

    public d(InterfaceC4020d strings, h types, j versionRequirements, boolean z10, d dVar, List<? extends Object> contextExtensions) {
        p.i(strings, "strings");
        p.i(types, "types");
        p.i(versionRequirements, "versionRequirements");
        p.i(contextExtensions, "contextExtensions");
        this.f5293a = strings;
        this.f5294b = types;
        this.f5295c = versionRequirements;
        this.f5296d = z10;
        this.f5297e = dVar;
        this.f5298f = contextExtensions;
        this.f5299g = new LinkedHashMap();
        this.f5300h = n.f5383a.c();
    }

    public final String a(int i10) {
        return e.a(this.f5293a, i10);
    }

    public final String b(int i10) {
        return this.f5293a.getString(i10);
    }

    public final List<n> c() {
        return this.f5300h;
    }

    public final boolean d() {
        return this.f5296d;
    }

    public final InterfaceC4020d e() {
        return this.f5293a;
    }

    public final Integer f(int i10) {
        Integer num = this.f5299g.get(Integer.valueOf(i10));
        if (num != null) {
            return num;
        }
        d dVar = this.f5297e;
        if (dVar != null) {
            return dVar.f(i10);
        }
        return null;
    }

    public final h g() {
        return this.f5294b;
    }

    public final j h() {
        return this.f5295c;
    }

    public final d i(List<ProtoBuf$TypeParameter> typeParameters) {
        p.i(typeParameters, "typeParameters");
        d dVar = new d(this.f5293a, this.f5294b, this.f5295c, this.f5296d, this, this.f5298f);
        for (ProtoBuf$TypeParameter protoBuf$TypeParameter : typeParameters) {
            dVar.f5299g.put(Integer.valueOf(protoBuf$TypeParameter.N()), Integer.valueOf(protoBuf$TypeParameter.M()));
        }
        return dVar;
    }

    public /* synthetic */ d(InterfaceC4020d interfaceC4020d, h hVar, j jVar, boolean z10, d dVar, List list, int i10, i iVar) {
        this(interfaceC4020d, hVar, jVar, z10, (i10 & 16) != 0 ? null : dVar, (i10 & 32) != 0 ? C1173v.m() : list);
    }
}
