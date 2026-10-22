package androidx.compose.runtime;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1747a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f1747a = i;
        this.b = obj;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f1747a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((ComposerImpl) obj).currentStackTrace();
            case 1:
                return ((ComposerImpl) obj).currentStackTrace();
            default:
                return Recomposer.broadcastFrameClock$lambda$2((Recomposer) obj);
        }
    }
}
