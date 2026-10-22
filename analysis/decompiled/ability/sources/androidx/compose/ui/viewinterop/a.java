package androidx.compose.ui.viewinterop;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1907a;
    public final /* synthetic */ S7.a b;

    public /* synthetic */ a(int i, S7.a aVar) {
        this.f1907a = i;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1907a;
        S7.a aVar = this.b;
        switch (i) {
            case 0:
                aVar.invoke();
                break;
            default:
                aVar.invoke();
                break;
        }
    }
}
