package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.obric.appstore.R;
import kotlin.jvm.internal.q;
import pa.a;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f5916c;

    static {
        f5914a = new b();
    }

    public b() {
    }

    public final int a() {
        int r10 = f5916c;
        if (r10 != 0) goto L6;
        int r11 = a.f23414a.a().getResources().getDimensionPixelSize(R.dimen.common_app_item_margin_vertical);
        f5916c = r11;
        return r11;
    L6:
        return r10;
    }

    public final int b() {
        int r10 = f5915b;
        if (r10 != 0) goto L6;
        int r11 = a.f23414a.a().getResources().getDimensionPixelSize(R.dimen.common_app_item_padding_left);
        f5915b = r11;
        return r11;
    L6:
        return r10;
    }

    public final int c(Context r10) {
        Point r11 = new Point();
        if (r10 == null) goto L5;
        Object r12 = r10.getSystemService("window");
    L6:
        q.e(r12, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) r12).getDefaultDisplay().getSize(r11);
        return r11.x;
    L5:
        r12 = null;
        goto L6
    }
}
