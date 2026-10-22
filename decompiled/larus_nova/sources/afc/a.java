package afc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.wheelpicker.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f3243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WheelView f3244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3245c;

    public final void a() {
        if (this.f3245c != 2.1474836E9f) goto L12;
        if (Math.abs(this.f3243a) > 2000.0f) goto L7;
        this.f3245c = this.f3243a;
        goto L12
    L7:
        if (this.f3243a <= 0.0f) goto L9;
        this.f3245c = 2000.0f;
        goto L12
    L9:
        this.f3245c = -2000.0f;
    L12:
        if (Math.abs(this.f3245c) >= 0.0f) goto L14;
    L17:
        int r100 = (int) ((this.f3245c * 40.0f) / 1000.0f);
        WheelView r101 = this.f3244b;
        float r102 = r100;
        r101.f449102n -= r102;
        if (r101.f449101m == true) goto L31;
        float r103 = (-r101.f449103o) * 0.0f;
        int r104 = r101.getItemsCount() - 1;
        WheelView r105 = this.f3244b;
        float r106 = (r104 - r105.f449103o) * 0.0f;
        float r107 = r105.f449102n;
        double r108 = r107;
        double r110 = ((double) 0.0f) * 0.25d;
        if ((r108 - r110) >= r103) goto L23;
        r103 = r107 + r102;
    L26:
        if (r107 > r103) goto L29;
        this.f3245c = 40.0f;
        r105.f449102n = (int) r103;
        goto L31
    L29:
        if (r107 < r106) goto L31;
        r105.f449102n = (int) r106;
        this.f3245c = -40.0f;
        goto L31
    L23:
        if ((r108 + r110) <= r106) goto L26;
        r106 = r107 + r102;
    L31:
        float r109 = this.f3245c;
        if (r109 >= 0.0f) goto L34;
        this.f3245c = r109 + 20.0f;
    L35:
        this.f3244b.f449090b.sendEmptyMessage(1000);
        return;
    L34:
        this.f3245c = r109 - 20.0f;
        goto L35
    L14:
        if (Math.abs(this.f3245c) > 20.0f) goto L17;
        this.f3244b.a();
        this.f3244b.f449090b.sendEmptyMessage(2000);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(WheelView r100, float r101) {
        this.f3244b = r100;
        this.f3243a = r101;
        this.f3245c = 2.1474836E9f;
    }
}
