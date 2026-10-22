package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.room.b0 f4885c;

    /* renamed from: f, reason: collision with root package name */
    public static final int f4886f;

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f4887g;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f4888h;
    public static final p.f i;

    /* renamed from: j, reason: collision with root package name */
    public static final Object f4889j;

    static {
        p pVar = new p();
        androidx.room.b0 b0Var = new androidx.room.b0(1);
        b0Var.f1509f = new Object();
        b0Var.f1510g = new ArrayDeque();
        b0Var.i = pVar;
        VarHandle.storeStoreFence();
        f4885c = b0Var;
        f4886f = -100;
        f4887g = null;
        f4888h = false;
        i = new p.f(0);
        f4889j = new Object();
    }

    public static boolean b(Context context) {
        if (f4887g == null) {
            try {
                int i3 = j0.f4844c;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) j0.class), i0.a() | 128).metaData;
                if (bundle != null) {
                    f4887g = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f4887g = Boolean.FALSE;
            }
        }
        return f4887g.booleanValue();
    }

    public static void e(e0 e0Var) {
        synchronized (f4889j) {
            try {
                p.f fVar = i;
                fVar.getClass();
                p.a aVar = new p.a(fVar);
                while (aVar.hasNext()) {
                    q qVar = (q) ((WeakReference) aVar.next()).get();
                    if (qVar == e0Var || qVar == null) {
                        aVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void c();

    public abstract void d();

    public abstract boolean g(int i3);

    public abstract void h(int i3);

    public abstract void i(View view);

    public abstract void k(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void l(CharSequence charSequence);
}
