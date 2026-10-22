package android.view;

/* renamed from: androidx.lifecycle.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC0766a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1972a;
    public final /* synthetic */ Object b;

    public /* synthetic */ RunnableC0766a(Object obj, int i) {
        this.f1972a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1972a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ComputableLiveData.refreshRunnable$lambda$0((ComputableLiveData) obj);
                break;
            case 1:
                ComputableLiveData.invalidationRunnable$lambda$1((ComputableLiveData) obj);
                break;
            default:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) obj);
                break;
        }
    }
}
