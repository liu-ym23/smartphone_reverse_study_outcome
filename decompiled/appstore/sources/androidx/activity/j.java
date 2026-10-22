package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class j implements EdgeToEdgeImpl {
    public j() {
    }

    @Override // androidx.activity.EdgeToEdgeImpl
    @DoNotInline
    public void setUp(@NotNull SystemBarStyle r10, @NotNull SystemBarStyle r11, @NotNull Window r12, @NotNull View r13, boolean r14, boolean r15) {
        kotlin.jvm.internal.q.g(r10, "statusBarStyle");
        kotlin.jvm.internal.q.g(r11, "navigationBarStyle");
        kotlin.jvm.internal.q.g(r12, "window");
        kotlin.jvm.internal.q.g(r13, "view");
        boolean r16 = false;
        t.b(r12, false);
        r12.setStatusBarColor(r10.c(r14));
        r12.setNavigationBarColor(r11.c(r15));
        r12.setStatusBarContrastEnforced(false);
        if (r11.b() != 0) goto L5;
        r16 = true;
    L5:
        r12.setNavigationBarContrastEnforced(r16);
        WindowInsetsControllerCompat r17 = new WindowInsetsControllerCompat(r12, r13);
        r17.c(!r14);
        r17.b(!r15);
    }
}
