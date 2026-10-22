package bp5;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.widget.statusbar.StatusBarView;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements a {
    public e() {
    }

    @Override // bp5.a
    public final void a(Window r100, int r101) {
        d.a(r100, 67108864);
        View r102 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L7:
        ViewGroup r104 = (ViewGroup) r102;
        View r105 = r104.findViewWithTag("ghStatusBarView");
        if (r105 != null) goto L10;
        r105 = new StatusBarView(r100.getContext());
        r105.setTag("ghStatusBarView");
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-1, -2);
        r106.gravity = 48;
        r105.setLayoutParams(r106);
        r104.addView(r105);
    L10:
        r105.setBackgroundColor(r101);
        View r107 = ((ViewGroup) r100.findViewById(R.id.content)).getChildAt(0);
        if (r107 == null) goto L14;
        r107.setFitsSystemWindows(true);
        return;
    }
}
