package androidx.compose.ui.platform;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1888a;
    public final /* synthetic */ S7.a b;

    public /* synthetic */ f(int i, S7.a aVar) {
        this.f1888a = i;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1888a;
        S7.a aVar = this.b;
        switch (i) {
            case 0:
                aVar.invoke();
                break;
            default:
                AndroidComposeView.schedule$lambda$38(aVar);
                break;
        }
    }
}
