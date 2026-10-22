package afc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.wheelpicker.WheelView;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WheelView f3247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3250d;

    public final void a() {
        if (this.f3248b != Integer.MAX_VALUE) goto L5;
        this.f3248b = this.f3250d;
    L5:
        int r100 = this.f3248b;
        int r101 = (int) (r100 * 0.1f);
        this.f3249c = r101;
        if (r101 != 0) goto L11;
        if (r100 >= 0) goto L9;
        this.f3249c = -1;
        goto L11
    L9:
        this.f3249c = 1;
    L11:
        if (Math.abs(r100) > 1) goto L13;
        this.f3247a.a();
        this.f3247a.f449090b.sendEmptyMessage(3000);
        return;
    L13:
        WheelView r102 = this.f3247a;
        r102.f449102n += this.f3249c;
        if (r102.f449101m == true) goto L21;
        float r103 = (-r102.f449103o) * 0.0f;
        int r104 = r102.getItemsCount() - 1;
        WheelView r105 = this.f3247a;
        float r106 = (r104 - r105.f449103o) * 0.0f;
        float r107 = r105.f449102n;
        if (r107 > r103) goto L18;
    L19:
        r105.f449102n = r107 - this.f3249c;
        r105.a();
        this.f3247a.f449090b.sendEmptyMessage(3000);
        return;
    L18:
        if (r107 >= r106) goto L19;
    L21:
        this.f3247a.f449090b.sendEmptyMessage(1000);
        this.f3248b -= this.f3249c;
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

    public d(WheelView r100, int r101) {
        this.f3247a = r100;
        this.f3250d = r101;
        this.f3248b = Integer.MAX_VALUE;
        this.f3249c = 0;
    }
}
