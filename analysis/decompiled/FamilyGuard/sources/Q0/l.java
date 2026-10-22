package Q0;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.ActivityC0516k;
import androidx.fragment.app.ComponentCallbacksC0511f;
import androidx.fragment.app.x;
import java.util.HashMap;
import java.util.Map;
import q.C0933a;
import v0.ComponentCallbacks2C1180c;

/* loaded from: classes.dex */
public class l implements Handler.Callback {

    /* renamed from: i, reason: collision with root package name */
    private static final b f4883i = new a();

    /* renamed from: a, reason: collision with root package name */
    private volatile v0.j f4884a;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f4887d;

    /* renamed from: e, reason: collision with root package name */
    private final b f4888e;

    /* renamed from: b, reason: collision with root package name */
    final Map<FragmentManager, k> f4885b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final Map<x, o> f4886c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final C0933a<View, ComponentCallbacksC0511f> f4889f = new C0933a<>();

    /* renamed from: g, reason: collision with root package name */
    private final C0933a<View, Fragment> f4890g = new C0933a<>();

    /* renamed from: h, reason: collision with root package name */
    private final Bundle f4891h = new Bundle();

    class a implements b {
        a() {
        }

        @Override // Q0.l.b
        public v0.j a(ComponentCallbacks2C1180c componentCallbacks2C1180c, h hVar, m mVar, Context context) {
            return new v0.j(componentCallbacks2C1180c, hVar, mVar, context);
        }
    }

    public interface b {
        v0.j a(ComponentCallbacks2C1180c componentCallbacks2C1180c, h hVar, m mVar, Context context);
    }

    public l(b bVar) {
        this.f4888e = bVar == null ? f4883i : bVar;
        this.f4887d = new Handler(Looper.getMainLooper(), this);
    }

    private static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Deprecated
    private v0.j b(Context context, FragmentManager fragmentManager, Fragment fragment, boolean z5) {
        k kVarH = h(fragmentManager, fragment, z5);
        v0.j jVarD = kVarH.d();
        if (jVarD != null) {
            return jVarD;
        }
        v0.j jVarA = this.f4888e.a(ComponentCallbacks2C1180c.c(context), kVarH.b(), kVarH.e(), context);
        kVarH.i(jVarA);
        return jVarA;
    }

    private v0.j f(Context context) {
        if (this.f4884a == null) {
            synchronized (this) {
                try {
                    if (this.f4884a == null) {
                        this.f4884a = this.f4888e.a(ComponentCallbacks2C1180c.c(context.getApplicationContext()), new Q0.b(), new g(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f4884a;
    }

    private k h(FragmentManager fragmentManager, Fragment fragment, boolean z5) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f4885b.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.h(fragment);
            if (z5) {
                kVar.b().d();
            }
            this.f4885b.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f4887d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    private o j(x xVar, ComponentCallbacksC0511f componentCallbacksC0511f, boolean z5) {
        o oVar = (o) xVar.g0("com.bumptech.glide.manager");
        if (oVar == null && (oVar = this.f4886c.get(xVar)) == null) {
            oVar = new o();
            oVar.b2(componentCallbacksC0511f);
            if (z5) {
                oVar.V1().d();
            }
            this.f4886c.put(xVar, oVar);
            xVar.m().e(oVar, "com.bumptech.glide.manager").j();
            this.f4887d.obtainMessage(2, xVar).sendToTarget();
        }
        return oVar;
    }

    private static boolean k(Activity activity) {
        return !activity.isFinishing();
    }

    private v0.j l(Context context, x xVar, ComponentCallbacksC0511f componentCallbacksC0511f, boolean z5) {
        o oVarJ = j(xVar, componentCallbacksC0511f, z5);
        v0.j jVarX1 = oVarJ.X1();
        if (jVarX1 != null) {
            return jVarX1;
        }
        v0.j jVarA = this.f4888e.a(ComponentCallbacks2C1180c.c(context), oVarJ.V1(), oVarJ.Y1(), context);
        oVarJ.c2(jVarA);
        return jVarA;
    }

    public v0.j c(Activity activity) {
        if (X0.k.p()) {
            return d(activity.getApplicationContext());
        }
        a(activity);
        return b(activity, activity.getFragmentManager(), null, k(activity));
    }

    public v0.j d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (X0.k.q() && !(context instanceof Application)) {
            if (context instanceof ActivityC0516k) {
                return e((ActivityC0516k) context);
            }
            if (context instanceof Activity) {
                return c((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return d(((ContextWrapper) context).getBaseContext());
            }
        }
        return f(context);
    }

    public v0.j e(ActivityC0516k activityC0516k) {
        if (X0.k.p()) {
            return d(activityC0516k.getApplicationContext());
        }
        a(activityC0516k);
        return l(activityC0516k, activityC0516k.getSupportFragmentManager(), null, k(activityC0516k));
    }

    @Deprecated
    k g(Activity activity) {
        return h(activity.getFragmentManager(), null, k(activity));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        ComponentCallbacks componentCallbacksRemove;
        int i5 = message.what;
        boolean z5 = true;
        if (i5 == 1) {
            obj = (FragmentManager) message.obj;
            componentCallbacksRemove = this.f4885b.remove(obj);
        } else if (i5 != 2) {
            componentCallbacksRemove = null;
            z5 = false;
            obj = null;
        } else {
            obj = (x) message.obj;
            componentCallbacksRemove = this.f4886c.remove(obj);
        }
        if (z5 && componentCallbacksRemove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z5;
    }

    o i(ActivityC0516k activityC0516k) {
        return j(activityC0516k.getSupportFragmentManager(), null, k(activityC0516k));
    }
}
