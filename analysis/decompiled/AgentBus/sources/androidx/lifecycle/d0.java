package androidx.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import androidx.lifecycle.f0;

/* loaded from: classes.dex */
public abstract class d0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, p pVar) {
        q7.k.e(pVar, "event");
        if (activity instanceof v) {
            x xVarA = ((v) activity).a();
            if (xVarA instanceof x) {
                xVarA.d(pVar);
            }
        }
    }

    public static void b(Activity activity) {
        f0.a.Companion.getClass();
        activity.registerActivityLifecycleCallbacks(new f0.a());
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new f0(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
