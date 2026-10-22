package P4;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b implements Handler.Callback {

    /* renamed from: c, reason: collision with root package name */
    private static final b f4852c = new b();

    /* renamed from: b, reason: collision with root package name */
    private final Map<FragmentManager, c> f4854b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final Handler f4853a = new Handler(Looper.getMainLooper(), this);

    private b() {
    }

    public static b a() {
        return f4852c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(View view) {
        if ((view.getContext() instanceof Activity) && (view instanceof d)) {
            Activity activity = (Activity) view.getContext();
            if (activity.isDestroyed()) {
                return;
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            c cVar = this.f4854b.get(fragmentManager);
            if (cVar == null) {
                c cVar2 = (c) fragmentManager.findFragmentByTag("io.pag.manager");
                if (cVar2 == null) {
                    cVar2 = new c();
                    this.f4854b.put(fragmentManager, cVar2);
                    fragmentManager.beginTransaction().add(cVar2, "io.pag.manager").commitAllowingStateLoss();
                    this.f4853a.obtainMessage(1, fragmentManager).sendToTarget();
                }
                cVar = cVar2;
            }
            cVar.a((d) view);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        FragmentManager fragmentManager = (FragmentManager) message.obj;
        c cVar = (c) fragmentManager.findFragmentByTag("io.pag.manager");
        if (fragmentManager.isDestroyed()) {
            Log.w("Lifecycle", "Parent was destroyed before our Fragment could be added.");
        } else if (cVar != this.f4854b.get(fragmentManager)) {
            Log.w("Lifecycle", "adding Fragment failed.");
        }
        this.f4854b.remove(fragmentManager);
        return true;
    }
}
