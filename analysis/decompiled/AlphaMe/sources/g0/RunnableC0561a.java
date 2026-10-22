package g0;

import java.io.Serializable;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0561a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12614a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12615b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12616c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12617d;

    public /* synthetic */ RunnableC0561a(Object obj, int i4, Serializable serializable, int i5) {
        this.f12614a = i5;
        this.f12617d = obj;
        this.f12615b = i4;
        this.f12616c = serializable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f12614a;
        Object obj = this.f12616c;
        int i5 = this.f12615b;
        Object obj2 = this.f12617d;
        switch (i4) {
            case 0:
                ((C0562b) obj2).f12619b.j(i5, obj);
                break;
            default:
                ((InterfaceC0564d) obj2).j(i5, obj);
                break;
        }
    }
}
