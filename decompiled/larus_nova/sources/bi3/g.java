package bi3;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g extends k43.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Window f19099b;

    public final void f(int r100) {
        Window r101 = this.f19099b;     // Catch: Exception -> L9
        if (r101 == null) goto L5;
        r101.addFlags(2);     // Catch: Exception -> L9
    L5:
        Window r102 = this.f19099b;     // Catch: Exception -> L9
        if (r102 == null) goto L14;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, Color.alpha(r100) / 255.0f});     // Catch: Exception -> L9
        r103.setDuration(390);     // Catch: Exception -> L9
        r103.setInterpolator(new DecelerateInterpolator());     // Catch: Exception -> L9
        r103.addUpdateListener(new f(r102));     // Catch: Exception -> L9
        r103.start();     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public g(Window r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "platformView");
        super(r101);
        this.f19099b = r100;
    }
}
