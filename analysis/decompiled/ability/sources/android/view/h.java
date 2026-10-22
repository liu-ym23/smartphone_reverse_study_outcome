package android.view;

import android.view.ComponentActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1672a;
    public final /* synthetic */ Object b;

    public /* synthetic */ h(Object obj, int i) {
        this.f1672a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1672a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ComponentActivity.ReportFullyDrawnExecutorImpl.execute$lambda$0((ComponentActivity.ReportFullyDrawnExecutorImpl) obj);
                break;
            case 1:
                super/*android.app.Dialog*/.onBackPressed();
                break;
            default:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) obj);
                break;
        }
    }
}
