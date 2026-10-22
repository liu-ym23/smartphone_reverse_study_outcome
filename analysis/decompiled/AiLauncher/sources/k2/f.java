package k2;

import com.google.android.datatransport.runtime.backends.BackendResponse;
import m2.InterfaceC4893a;

/* loaded from: classes2.dex */
public final /* synthetic */ class f implements InterfaceC4893a.InterfaceC0472a {

    /* renamed from: a, reason: collision with root package name */
    public final i f34601a;

    /* renamed from: b, reason: collision with root package name */
    public final BackendResponse f34602b;

    /* renamed from: c, reason: collision with root package name */
    public final Iterable f34603c;

    /* renamed from: d, reason: collision with root package name */
    public final e2.m f34604d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34605e;

    public f(i iVar, BackendResponse backendResponse, Iterable iterable, e2.m mVar, int i10) {
        this.f34601a = iVar;
        this.f34602b = backendResponse;
        this.f34603c = iterable;
        this.f34604d = mVar;
        this.f34605e = i10;
    }

    public static InterfaceC4893a.InterfaceC0472a a(i iVar, BackendResponse backendResponse, Iterable iterable, e2.m mVar, int i10) {
        return new f(iVar, backendResponse, iterable, mVar, i10);
    }

    @Override // m2.InterfaceC4893a.InterfaceC0472a
    public Object execute() {
        return i.c(this.f34601a, this.f34602b, this.f34603c, this.f34604d, this.f34605e);
    }
}
