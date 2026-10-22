package bd3;

import com.bytedance.android.shopping.deepfeed.slice.view.indicator.DeepFeedSlcIndicatorView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedSlcIndicatorView f18649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18650b;

    public b(DeepFeedSlcIndicatorView r100, int r101) {
        this.f18649a = r100;
        this.f18650b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18649a.f173549a.b(this.f18650b, 0.0f);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
