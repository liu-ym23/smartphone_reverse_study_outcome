package o0;

import java.util.ArrayList;

/* renamed from: o0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0805k extends t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f13718a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f13719b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13720c = null;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f13721d = null;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f13722e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f13723f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m f13724g;

    public C0805k(m mVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.f13724g = mVar;
        this.f13718a = obj;
        this.f13719b = arrayList;
        this.f13722e = obj2;
        this.f13723f = arrayList2;
    }

    @Override // o0.t, o0.q
    public final void e(s sVar) {
        m mVar = this.f13724g;
        Object obj = this.f13718a;
        if (obj != null) {
            mVar.s(obj, this.f13719b, null);
        }
        Object obj2 = this.f13720c;
        if (obj2 != null) {
            mVar.s(obj2, this.f13721d, null);
        }
        Object obj3 = this.f13722e;
        if (obj3 != null) {
            mVar.s(obj3, this.f13723f, null);
        }
    }

    @Override // o0.q
    public final void f(s sVar) {
        sVar.y(this);
    }
}
