package b;

import android.view.View;
import android.view.Window;
import androidx.core.view.Y;
import androidx.core.view.b0;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lb/x;", "Lb/B;", "<init>", "()V", "Lb/N;", "statusBarStyle", "navigationBarStyle", "Landroid/view/Window;", "window", "Landroid/view/View;", "view", "", "statusBarIsDark", "navigationBarIsDark", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lb/N;Lb/N;Landroid/view/Window;Landroid/view/View;ZZ)V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class x extends C1412B {
    @Override // b.InterfaceC1413C
    public void a(N statusBarStyle, N navigationBarStyle, Window window, View view, boolean statusBarIsDark, boolean navigationBarIsDark) {
        kotlin.jvm.internal.p.i(statusBarStyle, "statusBarStyle");
        kotlin.jvm.internal.p.i(navigationBarStyle, "navigationBarStyle");
        kotlin.jvm.internal.p.i(window, "window");
        kotlin.jvm.internal.p.i(view, "view");
        Y.b(window, false);
        window.setStatusBarColor(statusBarStyle.c(statusBarIsDark));
        window.setNavigationBarColor(navigationBarStyle.c(navigationBarIsDark));
        b0 b0Var = new b0(window, view);
        b0Var.e(!statusBarIsDark);
        b0Var.d(!navigationBarIsDark);
    }
}
