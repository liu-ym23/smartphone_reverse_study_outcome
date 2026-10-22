package A3;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class o extends AtomicBoolean implements t3.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f122a;

    /* renamed from: b, reason: collision with root package name */
    public final p f123b;

    /* renamed from: c, reason: collision with root package name */
    public final t3.h f124c;

    public /* synthetic */ o(p pVar, t3.h hVar, int i4) {
        this.f122a = i4;
        this.f123b = pVar;
        this.f124c = hVar;
    }

    @Override // t3.h
    public final boolean a() {
        int i4 = this.f122a;
        p pVar = this.f123b;
        switch (i4) {
        }
        return pVar.f125a.a();
    }

    @Override // t3.h
    public final void c() {
        int i4 = this.f122a;
        p pVar = this.f123b;
        t3.h hVar = this.f124c;
        switch (i4) {
            case 0:
                if (compareAndSet(false, true)) {
                    ((B3.l) hVar).d(pVar);
                    break;
                }
                break;
            default:
                if (compareAndSet(false, true)) {
                    ((B3.l) hVar).d(pVar);
                    break;
                }
                break;
        }
    }
}
