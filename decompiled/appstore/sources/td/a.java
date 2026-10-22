package td;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.appcompat.app.AppCompatDelegate;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24794a = null;

    static {
        f24794a = new a();
    }

    public a() {
    }

    public static final void a(Activity r10) {
        q.g(r10, "<this>");
        Window r11 = r10.getWindow();
        if (r11 != null) goto L5;
        WindowInsetsController r12 = null;
    L6:
        if (r12 != null) goto L8;
        return;
    L8:
        if (c() == false) goto L10;
    L13:
        r12.setSystemBarsAppearance(0, 8);
        r12.setSystemBarsAppearance(0, 16);
        return;
    L10:
        if (b() == true) goto L13;
        r12.setSystemBarsAppearance(8, 8);
        r12.setSystemBarsAppearance(16, 16);
        return;
    L5:
        r12 = r11.getInsetsController();
        goto L6
    }

    public static final boolean b() {
        if (AppCompatDelegate.k() != 2) goto L5;
        boolean r10 = true;
    L6:
        L.a("ActivityUtils", q.p("isAppInDarkTheme: ", Boolean.valueOf(r10)));
        return r10;
    L5:
        r10 = false;
        goto L6
    }

    public static final boolean c() {
        int r10 = Resources.getSystem().getConfiguration().uiMode & 48;
        if (r10 != 32) goto L5;
        boolean r11 = true;
    L6:
        L.a("ActivityUtils", "isSystemInDarkTheme: " + r11 + ", currentNightMode" + r10);
        return r11;
    L5:
        r11 = false;
        goto L6
    }
}
