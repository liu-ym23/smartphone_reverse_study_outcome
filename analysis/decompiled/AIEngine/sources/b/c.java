package b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2991a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f2992b;

    public /* synthetic */ c(k kVar, int i10) {
        this.f2991a = i10;
        this.f2992b = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f2991a;
        k kVar = this.f2992b;
        switch (i10) {
            case 0:
                kVar.invalidateMenu();
                break;
            default:
                k.onBackPressedDispatcher_delegate$lambda$13$lambda$10(kVar);
                break;
        }
    }
}
