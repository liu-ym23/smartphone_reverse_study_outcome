package androidx.core.app;

import android.view.FrameMetrics;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
class FrameMetricsAggregator$FrameMetricsApi24Impl$1 implements Window.OnFrameMetricsAvailableListener {
    final /* synthetic */ e.a this$0;

    FrameMetricsAggregator$FrameMetricsApi24Impl$1(e.a r1) {
        this.this$0 = r1;
    }

    @Override // android.view.Window.OnFrameMetricsAvailableListener
    public void onFrameMetricsAvailable(Window r9, FrameMetrics r10, int r11) {
        if ((this.this$0.f1078a & 1) == 0) goto L6;
        e.a r12 = this.this$0;
        r12.a(r12.f1079b[0], r10.getMetric(8));
    L6:
        if ((this.this$0.f1078a & 2) == 0) goto L9;
        e.a r13 = this.this$0;
        r13.a(r13.f1079b[1], r10.getMetric(1));
    L9:
        if ((this.this$0.f1078a & 4) == 0) goto L12;
        e.a r14 = this.this$0;
        r14.a(r14.f1079b[2], r10.getMetric(3));
    L12:
        if ((this.this$0.f1078a & 8) == 0) goto L15;
        e.a r15 = this.this$0;
        r15.a(r15.f1079b[3], r10.getMetric(4));
    L15:
        if ((this.this$0.f1078a & 16) == 0) goto L18;
        e.a r16 = this.this$0;
        r16.a(r16.f1079b[4], r10.getMetric(5));
    L18:
        if ((this.this$0.f1078a & 64) == 0) goto L21;
        e.a r17 = this.this$0;
        r17.a(r17.f1079b[6], r10.getMetric(7));
    L21:
        if ((this.this$0.f1078a & 32) == 0) goto L24;
        e.a r18 = this.this$0;
        r18.a(r18.f1079b[5], r10.getMetric(6));
    L24:
        if ((this.this$0.f1078a & 128) == 0) goto L27;
        e.a r19 = this.this$0;
        r19.a(r19.f1079b[7], r10.getMetric(0));
    L27:
        if ((this.this$0.f1078a & 256) == 0) goto L30;
        e.a r8 = this.this$0;
        r8.a(r8.f1079b[8], r10.getMetric(2));
        return;
    }
}
