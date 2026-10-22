package H4;

/* loaded from: classes3.dex */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f750a;
    public final /* synthetic */ S7.a b;

    public /* synthetic */ r(int i, S7.a aVar) {
        this.f750a = i;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f750a;
        S7.a aVar = this.b;
        switch (i) {
            case 0:
                aVar.invoke();
                break;
            case 1:
                aVar.invoke();
                break;
            case 2:
                aVar.invoke();
                break;
            case 3:
                aVar.invoke();
                break;
            case 4:
                aVar.invoke();
                break;
            case 5:
                com.stepos.ability.voicewakeup.service.l.d = Thread.currentThread();
                aVar.invoke();
                break;
            case 6:
                aVar.invoke();
                break;
            default:
                aVar.invoke();
                break;
        }
    }
}
