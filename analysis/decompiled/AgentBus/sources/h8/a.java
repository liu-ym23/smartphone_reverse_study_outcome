package h8;

import d7.z;
import e9.f;
import java.util.Collection;
import q7.k;
import t9.r;

/* loaded from: classes.dex */
public final class a implements b, d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4222b = new a(0);

    /* renamed from: c, reason: collision with root package name */
    public static final a f4223c = new a(1);

    /* renamed from: d, reason: collision with root package name */
    public static final a f4224d = new a(2);

    /* renamed from: e, reason: collision with root package name */
    public static final a f4225e = new a(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4226a;

    public /* synthetic */ a(int i2) {
        this.f4226a = i2;
    }

    @Override // h8.b
    public Collection a(f8.e eVar) {
        return z.f2978f;
    }

    @Override // h8.d
    public boolean b(f8.e eVar, r rVar) {
        switch (this.f4226a) {
            case 1:
                k.e(eVar, "classDescriptor");
                return true;
            default:
                k.e(eVar, "classDescriptor");
                return !rVar.getAnnotations().g(e.f4227a);
        }
    }

    @Override // h8.b
    public Collection c(f8.e eVar) {
        return z.f2978f;
    }

    @Override // h8.b
    public Collection d(f fVar, f8.e eVar) {
        k.e(fVar, "name");
        k.e(eVar, "classDescriptor");
        return z.f2978f;
    }

    @Override // h8.b
    public Collection e(f8.e eVar) {
        k.e(eVar, "classDescriptor");
        return z.f2978f;
    }
}
