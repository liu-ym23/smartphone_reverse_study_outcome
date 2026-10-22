package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f14104b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Callback f14105c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f14106d;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1, Callback callback, Object obj, int i4) {
        this.f14103a = i4;
        this.f14104b = anonymousClass1;
        this.f14105c = callback;
        this.f14106d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f14103a;
        Callback callback = this.f14105c;
        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1 = this.f14104b;
        Object obj = this.f14106d;
        switch (i4) {
            case 0:
                anonymousClass1.lambda$onResponse$0(callback, (Response) obj);
                break;
            default:
                anonymousClass1.lambda$onFailure$1(callback, (Throwable) obj);
                break;
        }
    }
}
