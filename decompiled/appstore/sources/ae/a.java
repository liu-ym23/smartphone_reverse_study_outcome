package ae;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.Log;
import android.view.WindowManager;
import com.obric.oui.window.bean.WindowSizeClass;
import com.obric.oui.window.interfaces.OnWindowConfigChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.u;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import xd.f;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f85a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile WindowSizeClass f86b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f87c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static xd.a f88d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static xd.a f89e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f90f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f91g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f92h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Set f93i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ArrayList f94j;

    static {
        f85a = new a();
        f86b = WindowSizeClass.MINUS_ERROR_SIZE;
        f87c = 1;
        xd.a r10 = new xd.a(0.0f, 0.0f);
        f88d = r10;
        f89e = r10;
        f90f = -1;
        f93i = new LinkedHashSet();
        f94j = new ArrayList();
    }

    public a() {
    }

    public final void a(Activity r10, int r11, int r12) {
        q.g(r10, "activity");
        f(r10);
        Pair r13 = e(r10);
        int r14 = 0;
        if (r10.isInMultiWindowMode() == true) goto L5;
        f91g = false;
        f92h = false;
    L13:
        f90f = r14;
        return;
    L5:
        if (b(f93i, r11, r13) == false) goto L8;
        f91g = true;
        f92h = false;
    L11:
        r14 = 2;
        goto L13
    L8:
        if (b(f93i, r12, r13) == false) goto L10;
        f91g = false;
        f92h = true;
        goto L11
    L10:
        f91g = false;
        f92h = false;
        goto L11
    }

    public final void addListener(@NotNull OnWindowConfigChangeListener r10) {
        q.g(r10, "listener");
        f94j.add(r10);
    }

    public final boolean b(Set r10, int r11, Pair r12) {
        if (r10.contains(Integer.valueOf(r11)) == true) goto L24;
        Set r13 = r10;
        ArrayList r14 = new ArrayList(u.r(r13, 10));
        Iterator r15 = r13.iterator();
    L6:
        if (r15.hasNext() == false) goto L9;
        r14.add(Integer.valueOf((((Number) r15.next()).intValue() - ((Number) r12.getSecond()).intValue()) - ((Number) r12.getFirst()).intValue()));
        goto L6
    L9:
        if (r14.contains(Integer.valueOf(r11)) == true) goto L24;
        ArrayList r16 = new ArrayList(u.r(r13, 10));
        Iterator r17 = r13.iterator();
    L12:
        if (r17.hasNext() == false) goto L15;
        r16.add(Integer.valueOf(((Number) r17.next()).intValue() - ((Number) r12.getSecond()).intValue()));
        goto L12
    L15:
        if (r16.contains(Integer.valueOf(r11)) == true) goto L24;
        ArrayList r18 = new ArrayList(u.r(r13, 10));
        Iterator r19 = r13.iterator();
    L18:
        if (r19.hasNext() == false) goto L21;
        r18.add(Integer.valueOf(((Number) r19.next()).intValue() - ((Number) r12.getFirst()).intValue()));
        goto L18
    L21:
        if (r18.contains(Integer.valueOf(r11)) == true) goto L24;
        return false;
    L24:
        return true;
    }

    public final xd.a c() {
        return f88d;
    }

    public final WindowSizeClass d() {
        return f86b;
    }

    public final Pair e(Activity r10) {
        q.g(r10, "activity");
        Resources r11 = r10.getResources();
        return new Pair(Integer.valueOf(r11.getDimensionPixelSize(r11.getIdentifier("status_bar_height", "dimen", "android"))), Integer.valueOf(r11.getDimensionPixelSize(r11.getIdentifier("navigation_bar_height", "dimen", "android"))));
    }

    public final void f(Context r10) {
        if (f93i.isEmpty() == true) goto L5;
        return;
    L5:
        WindowManager r11 = null;
        if (r10 != null) goto L8;
        Object r12 = null;
    L10:
        if ((r12 instanceof WindowManager) == false) goto L12;
        r11 = (WindowManager) r12;
    L12:
        if (r11 == null) goto L16;
        Point r13 = new Point();
        r11.getDefaultDisplay().getRealSize(r13);
        f93i.add(Integer.valueOf(r13.x));
        f93i.add(Integer.valueOf(r13.y));
        return;
    L16:
        return;
    L8:
        r12 = r10.getSystemService("window");
        goto L10
    }

    public final void g() {
        Iterator r10 = f94j.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((OnWindowConfigChangeListener) r10.next()).onChange(new f(f86b, f88d));
        goto L4
    }

    public final WindowSizeClass h(Activity r10, int r11, int r12, boolean r13) {
        if (r10 == null) goto L58;
        float r14 = Resources.getSystem().getDisplayMetrics().density;
        float r15 = r11 / r14;
        float r16 = r12 / r14;
        Log.d("AdaptedWindowSize", "setCurrentWindowSize: widthDP = " + r15 + ",heightDp = " + r16);
        f88d = new xd.a(r15, r16);
        WindowSizeClass r17 = WindowSizeClass.FLOATING_WINDOW;
        if (r15 >= r17.getDpSize()) goto L8;
        Log.e("AdaptedWindowSize", "error,can not be minus status!!");
        r17 = WindowSizeClass.MINUS_ERROR_SIZE;
    L44:
        if (f86b == r17) goto L48;
        if (r17 == WindowSizeClass.MINUS_ERROR_SIZE) goto L48;
    L49:
        f86b = r17;
        Resources r18 = r10.getResources();
        int r19 = 1;
        if (r18 == null) goto L56;
        Configuration r20 = r18.getConfiguration();
        if (r20 == null) goto L56;
        r19 = r20.orientation;
    L56:
        f87c = r19;
        Log.d("AdaptedWindowSize", q.p("windowMsg = ", "当前档位：" + f86b.getBaseGridConfig().a() + "\n当前页面可用宽高：" + r15 + ',' + r16 + "\ndecorViewWidth：" + r11 + "，decorVideHeight: " + r12 + "\nmultiWindowMode = " + r10.isInMultiWindowMode() + '\n'));
    L48:
        if (f87c == r10.getResources().getConfiguration().orientation) goto L58;
    L8:
        if (r15 >= r17.getDpSize()) goto L10;
    L12:
        r17 = WindowSizeClass.SMALL_SPLIT_SCREEN;
        if (r15 >= r17.getDpSize()) goto L15;
    L17:
        r17 = WindowSizeClass.SMALLER_ANDROID_SCREEN;
        if (r15 >= r17.getDpSize()) goto L20;
    L22:
        r17 = WindowSizeClass.SMALL;
        if (r15 >= r17.getDpSize()) goto L25;
    L27:
        r17 = WindowSizeClass.STANDARD;
        if (r15 >= r17.getDpSize()) goto L30;
    L32:
        r17 = WindowSizeClass.NORMAL;
        if (r15 >= r17.getDpSize()) goto L35;
    L37:
        r17 = WindowSizeClass.LARGE;
        if (r15 >= r17.getDpSize()) goto L40;
    L42:
        r17 = WindowSizeClass.OVERSIZE;
        goto L44
    L40:
        if (r15 >= WindowSizeClass.OVERSIZE.getDpSize()) goto L42;
    L35:
        if (r15 >= WindowSizeClass.LARGE.getDpSize()) goto L37;
    L30:
        if (r15 >= WindowSizeClass.NORMAL.getDpSize()) goto L32;
    L25:
        if (r15 >= WindowSizeClass.STANDARD.getDpSize()) goto L27;
    L20:
        if (r15 >= WindowSizeClass.SMALL.getDpSize()) goto L22;
    L15:
        if (r15 >= WindowSizeClass.SMALLER_ANDROID_SCREEN.getDpSize()) goto L17;
    L10:
        if (r15 >= WindowSizeClass.SMALL_SPLIT_SCREEN.getDpSize()) goto L12;
    L58:
        return f86b;
    }

    public final void removeListener(@NotNull OnWindowConfigChangeListener r10) {
        q.g(r10, "listener");
        f94j.remove(r10);
    }
}
