package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {
    private static final int INIT_FAILED = 2;
    private static final int INIT_SUCCESS = 1;
    private static final int NOT_INITIALIAZED = 0;
    private static Field sHField;
    private static Field sNextServedViewField;
    private static int sReflectedFieldsInitialized;
    private static Field sServedViewField;
    private Activity mActivity;

    private static void initializeReflectiveFields() {
        sReflectedFieldsInitialized = 2;     // Catch: NoSuchFieldException -> L5
        Field r100 = InputMethodManager.class.getDeclaredField("mServedView");     // Catch: NoSuchFieldException -> L5
        sServedViewField = r100;     // Catch: NoSuchFieldException -> L5
        r100.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r101 = InputMethodManager.class.getDeclaredField("mNextServedView");     // Catch: NoSuchFieldException -> L5
        sNextServedViewField = r101;     // Catch: NoSuchFieldException -> L5
        r101.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r102 = InputMethodManager.class.getDeclaredField("mH");     // Catch: NoSuchFieldException -> L5
        sHField = r102;     // Catch: NoSuchFieldException -> L5
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        sReflectedFieldsInitialized = 1;     // Catch: NoSuchFieldException -> L5
        return;
    }

    public ImmLeaksCleaner(Activity r100) {
        this.mActivity = r100;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        if (r101 == Lifecycle.Event.ON_DESTROY) goto L6;
        return;
    L6:
        if (sReflectedFieldsInitialized != 0) goto L9;
        initializeReflectiveFields();
    L9:
        if (sReflectedFieldsInitialized != 1) goto L36;
        InputMethodManager r102 = (InputMethodManager) this.mActivity.getSystemService("input_method");
        Object r103 = sHField.get(r102);     // Catch: IllegalAccessException -> L37
        if (r103 != null) goto L14;
        return;
    L14:
        monitor-enter(r103);
        View r104 = (View) sServedViewField.get(r102);     // Catch: Throwable -> L28 ClassCastException -> L30 IllegalAccessException -> L32
        if (r104 != null) goto L20;
        monitor-exit(r103);     // Catch: Throwable -> L28
        return;
    L20:
        if (r104.isAttachedToWindow() == false) goto L38;
        monitor-exit(r103);     // Catch: Throwable -> L28
        return;
    L38:
        sNextServedViewField.set(r102, null);     // Catch: IllegalAccessException -> L26 Throwable -> L28
        monitor-exit(r103);     // Catch: Throwable -> L28
        r102.isActive();
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
}
