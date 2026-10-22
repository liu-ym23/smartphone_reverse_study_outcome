package b46;

import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f17544c;

    public static final class a {
    }

    static {
    }

    public j() {
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }
}
