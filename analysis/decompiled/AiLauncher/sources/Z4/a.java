package Z4;

import android.app.Application;
import android.provider.Settings;
import android.view.WindowManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"LZ4/a;", "", "<init>", "()V", "LY8/t;", "e", "c", "LZ4/e;", "task", Const.INTENT_KEY_APIKEY, "(LZ4/e;)V", "", "taskId", "f", "(Ljava/lang/String;)V", "", Const.INTENT_KEY_UMID, "()Z", "TAG", "Ljava/lang/String;", "LZ4/d;", "dynamicIslandView", "LZ4/d;", "isShowing", "Z", "Landroid/view/WindowManager;", Const.INTENT_KEY_PKGNAME, "()Landroid/view/WindowManager;", "windowManager", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String TAG = "AgentSpaceWM";
    private static d dynamicIslandView;
    private static boolean isShowing;

    public final void a(TaskIconInfo task) {
        p.i(task, "task");
        d dVar = dynamicIslandView;
        if (dVar != null) {
            dVar.d(task);
        }
    }

    public final WindowManager b() {
        Object systemService = C3197a.INSTANCE.a().getSystemService((Class<Object>) WindowManager.class);
        p.h(systemService, "getSystemService(...)");
        return (WindowManager) systemService;
    }

    public final void c() {
        d dVar = dynamicIslandView;
        if (dVar == null) {
            return;
        }
        b().removeView(dVar);
        dynamicIslandView = null;
        isShowing = false;
        C4148a.d(TAG, "Dynamic island hidden", false, 4, null);
    }

    public final boolean d() {
        return isShowing;
    }

    public final void e() {
        if (isShowing) {
            C4148a.d(TAG, "Already showing", false, 4, null);
            return;
        }
        Application applicationA = C3197a.INSTANCE.a();
        d dVar = new d(applicationA, null, 0, 6, null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2017, 776, -3);
        layoutParams.gravity = 49;
        layoutParams.y = 0;
        try {
            b().addView(dVar, layoutParams);
            C4148a.d(TAG, "Dynamic island shown with TYPE_SYSTEM_ALERT", false, 4, null);
        } catch (Exception e10) {
            C4148a.t(TAG, "TYPE_SYSTEM_ALERT failed, fallback to TYPE_APPLICATION_OVERLAY", e10, false, 8, null);
            if (!Settings.canDrawOverlays(applicationA)) {
                C4148a.h(TAG, "No overlay permission, cannot show dynamic island", false, 4, null);
                return;
            } else {
                b().addView(dVar, layoutParams);
                C4148a.d(TAG, "Dynamic island shown with TYPE_APPLICATION_OVERLAY", false, 4, null);
            }
        }
        dynamicIslandView = dVar;
        isShowing = true;
    }

    public final void f(String taskId) {
        p.i(taskId, "taskId");
        d dVar = dynamicIslandView;
        if (dVar != null) {
            dVar.g(taskId);
        }
    }
}
