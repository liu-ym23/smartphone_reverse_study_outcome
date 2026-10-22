package o8;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.stepos.agentsafetycenter.MainActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import nc.f0;
import nc.k0;
import nc.t0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Stack f9321a = new Stack();

    /* renamed from: b, reason: collision with root package name */
    public static final t0 f9322b;

    /* renamed from: c, reason: collision with root package name */
    public static final f0 f9323c;

    /* renamed from: d, reason: collision with root package name */
    public static int f9324d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f9325e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f9326f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile boolean f9327g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f9328h;
    public static boolean i;

    /* renamed from: j, reason: collision with root package name */
    public static final Handler f9329j;

    /* renamed from: k, reason: collision with root package name */
    public static e3.j f9330k;

    static {
        t0 t0VarA = k0.a(Boolean.FALSE);
        f9322b = t0VarA;
        f9323c = new f0(t0VarA);
        f9329j = new Handler(Looper.getMainLooper());
    }

    public static boolean a() {
        return ((Boolean) f9322b.getValue()).booleanValue();
    }

    public static void b() {
        f9325e = false;
        c(false);
        f9326f = false;
        f9327g = false;
        List listL0 = kb.l.L0(f9321a);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listL0) {
            Activity activity = (Activity) obj;
            if ((activity instanceof MainActivity) && !activity.isFinishing()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            Activity activity2 = (Activity) obj2;
            Log.d("ScreenLockAuthManager", "finish content for lock: ".concat(activity2.getClass().getSimpleName()));
            activity2.finish();
            activity2.overridePendingTransition(0, 0);
        }
    }

    public static void c(boolean z10) {
        Boolean boolValueOf = Boolean.valueOf(z10);
        t0 t0Var = f9322b;
        t0Var.getClass();
        t0Var.g(null, boolValueOf);
    }
}
