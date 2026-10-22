package b9;

import android.view.View;
import com.bytedanceos.common.R$id;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5948a = -1073741824;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5949b = Integer.MIN_VALUE;

    static {
    }

    public static void a(View r10, boolean r11) {
        int r12 = c(r10);
        if (r11 == false) goto L5;
        h(r10, f5948a, r12 + 1);
        return;
    L5:
        h(r10, f5949b, r12);
    }

    public static int b(int r10) {
        return r10 & (~f5948a);
    }

    public static int c(View r10) {
        return d(r10, 1);
    }

    public static int d(View r10, int r11) {
        Objects.requireNonNull(r10);
        Object r12 = r10.getTag(R$id.app_list_page);
        if (r12 != null) goto L6;
        return r11;
    L6:
        return b(Integer.parseInt(r12.toString()));
    }

    public static boolean e(View r10) {
        if (c(r10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static int f(int r10, int r11) {
        int r12 = f5948a;
        return (r10 & r12) | (r11 & (~r12));
    }

    public static void g(View r10, int r11) {
        h(r10, c(r10), r11);
    }

    public static void h(View r10, int r11, int r12) {
        Objects.requireNonNull(r10);
        r10.setTag(R$id.app_list_page, Integer.valueOf(f(r11, r12)));
    }
}
