package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class ImmLeaksCleaner implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Field f129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Activity f130e;

    static {
    }

    ImmLeaksCleaner(Activity r3) {
        this.f130e = ZeusTransformUtils.wrapperContext2Activity((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r3, i.a r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        if (r4 == i.a.ON_DESTROY) goto L6;
        return;
    L6:
        if (f126a != 0) goto L9;
        a();
    L9:
        if (f126a != 1) goto L36;
        InputMethodManager r2 = (InputMethodManager) ZeusTransformUtils.preCheckCast(this.f130e.getSystemService("input_method"), InputMethodManager.class, "com.obric.aiagent.plugin");
        Object r6 = f127b.get(r2);     // Catch: IllegalAccessException -> L37
        if (r6 != null) goto L14;
        return;
    L14:
        monitor-enter(r6);
        View r7 = (View) ZeusTransformUtils.preCheckCast(f128c.get(r2), View.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28 ClassCastException -> L30 IllegalAccessException -> L32
        if (r7 != null) goto L20;
        monitor-exit(r6);     // Catch: Throwable -> L28
        return;
    L20:
        if (r7.isAttachedToWindow() == false) goto L39;
        monitor-exit(r6);     // Catch: Throwable -> L28
        return;
    L39:
        f129d.set(r2, null);     // Catch: IllegalAccessException -> L26 Throwable -> L28
        monitor-exit(r6);     // Catch: Throwable -> L28
        r2.isActive();
        return;
    L27:
        return;
    L28:
        th = move-exception;
        throw th;
    L31:
        return;
    L33:
        return;
    L45:
        return;
    }

    private static void a() {
        f126a = 2;     // Catch: NoSuchFieldException -> L5
        Field r0 = InputMethodManager.class.getDeclaredField("mServedView");     // Catch: NoSuchFieldException -> L5
        f128c = r0;     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r1 = InputMethodManager.class.getDeclaredField("mNextServedView");     // Catch: NoSuchFieldException -> L5
        f129d = r1;     // Catch: NoSuchFieldException -> L5
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r2 = InputMethodManager.class.getDeclaredField("mH");     // Catch: NoSuchFieldException -> L5
        f127b = r2;     // Catch: NoSuchFieldException -> L5
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        f126a = 1;     // Catch: NoSuchFieldException -> L5
        return;
    }
}
