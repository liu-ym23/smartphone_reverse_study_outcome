package a6;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f170a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f171b;

    public /* synthetic */ i(int i8, Object obj) {
        this.f170a = i8;
        this.f171b = obj;
    }

    @Override // a6.j
    public final void a(Throwable th) {
        switch (this.f170a) {
            case 0:
                ((p5.l) this.f171b).invoke(th);
                break;
            default:
                ((s0) this.f171b).b();
                break;
        }
    }

    public final String toString() {
        switch (this.f170a) {
            case 0:
                return "CancelHandler.UserSupplied[" + ((p5.l) this.f171b).getClass().getSimpleName() + '@' + i0.k(this) + AbstractJsonLexerKt.END_LIST;
            default:
                return "DisposeOnCancel[" + ((s0) this.f171b) + AbstractJsonLexerKt.END_LIST;
        }
    }
}
