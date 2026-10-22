package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f347a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f348b;

    public /* synthetic */ p(Object obj, int i10) {
        this.f347a = i10;
        this.f348b = obj;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        int i10 = this.f347a;
        Object obj = this.f348b;
        switch (i10) {
            case 0:
                ((AppCompatDelegateImpl) obj).I();
                break;
            case 1:
                ((Runnable) obj).run();
                break;
            default:
                ((b.q) obj).invoke();
                break;
        }
    }
}
