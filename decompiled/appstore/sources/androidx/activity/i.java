package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import com.ttnet.org.chromium.net.PrivateKeyType;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f173a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f174b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static EdgeToEdgeImpl f175c;

    static {
        f173a = Color.argb(230, PrivateKeyType.INVALID, PrivateKeyType.INVALID, PrivateKeyType.INVALID);
        f174b = Color.argb(128, 27, 27, 27);
    }

    public static final void a(ComponentActivity r10, SystemBarStyle r11, SystemBarStyle r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "statusBarStyle");
        kotlin.jvm.internal.q.g(r12, "navigationBarStyle");
        View r13 = r10.getWindow().getDecorView();
        kotlin.jvm.internal.q.f(r13, "window.decorView");
        Function1 r14 = r11.a();
        Resources r15 = r13.getResources();
        kotlin.jvm.internal.q.f(r15, "view.resources");
        boolean r16 = ((Boolean) r14.invoke(r15)).booleanValue();
        Function1 r17 = r12.a();
        Resources r18 = r13.getResources();
        kotlin.jvm.internal.q.f(r18, "view.resources");
        boolean r19 = ((Boolean) r17.invoke(r18)).booleanValue();
        EdgeToEdgeImpl r20 = f175c;
        if (r20 != null) goto L5;
        r20 = new j();
    L5:
        Window r21 = r10.getWindow();
        kotlin.jvm.internal.q.f(r21, "window");
        r20.setUp(r11, r12, r21, r13, r16, r19);
    }

    public static /* synthetic */ void b(ComponentActivity r10, SystemBarStyle r11, SystemBarStyle r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = SystemBarStyle.Companion.b(SystemBarStyle.f158e, 0, 0, null, 4, null);
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = SystemBarStyle.Companion.b(SystemBarStyle.f158e, f173a, f174b, null, 4, null);
    L8:
        a(r10, r11, r12);
    }
}
