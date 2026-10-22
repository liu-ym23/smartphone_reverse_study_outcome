package cd3;

import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcScrollingView f23376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f23377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f23378c;

    public e(SlcScrollingView r100, int r101, int r102) {
        this.f23376a = r100;
        this.f23377b = r101;
        this.f23378c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SlcScrollingView r100 = this.f23376a;     // Catch: Throwable -> L4
        int r101 = this.f23377b;     // Catch: Throwable -> L4
        int r102 = this.f23378c;     // Catch: Throwable -> L4
        int r103 = SlcScrollingView.f173629g;     // Catch: Throwable -> L4
        r100.a(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
