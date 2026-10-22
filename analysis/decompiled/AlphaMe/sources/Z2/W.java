package Z2;

import kotlin.Unit;

/* loaded from: classes2.dex */
public final class W extends Y {

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0126g f2197c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0115a0 f2198d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(AbstractC0115a0 abstractC0115a0, long j4, C0128h c0128h) {
        super(j4);
        this.f2198d = abstractC0115a0;
        this.f2197c = c0128h;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2197c.j(this.f2198d, Unit.INSTANCE);
    }

    @Override // Z2.Y
    public final String toString() {
        return super.toString() + this.f2197c;
    }
}
