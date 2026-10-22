package b20;

import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewPager f16981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16982b;

    public c(ViewPager r100, int r101) {
        this.f16981a = r100;
        this.f16982b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16981a.setCurrentItem(this.f16982b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
