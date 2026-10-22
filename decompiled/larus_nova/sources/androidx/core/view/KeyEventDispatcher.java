package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes17.dex */
public class KeyEventDispatcher {
    private static boolean sActionBarFieldsFetched;
    private static Method sActionBarOnMenuKeyMethod;
    private static boolean sDialogFieldsFetched;
    private static Field sDialogKeyListenerField;

    /* JADX INFO: loaded from: classes.dex */
    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent r100);
    }

    private KeyEventDispatcher() {
    }

    public static View INVOKEVIRTUAL_androidx_core_view_KeyEventDispatcher_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog r100) {
        if (sDialogFieldsFetched == false) goto L17;
    L7:
        Field r101 = sDialogKeyListenerField;
        if (r101 != null) goto L15;
        return null;
    L15:
        return (DialogInterface.OnKeyListener) r101.get(r100);
    L19:
        return null;
    L17:
        Field r102 = Dialog.class.getDeclaredField("mOnKeyListener");     // Catch: NoSuchFieldException -> L13
        sDialogKeyListenerField = r102;     // Catch: NoSuchFieldException -> L13
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L13
    L6:
        sDialogFieldsFetched = true;
        goto L7
    }

    private static boolean actionBarOnMenuKeyEventPre28(ActionBar r100, KeyEvent r101) {
        if (sActionBarFieldsFetched == false) goto L16;
    L6:
        Method r102 = sActionBarOnMenuKeyMethod;
        if (r102 != null) goto L18;
    L13:
        return false;
    L18:
        Object r103 = r102.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L14
        if (r103 != null) goto L11;
        return false;
    L11:
        return ((Boolean) r103).booleanValue();
    L16:
        sActionBarOnMenuKeyMethod = r100.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});     // Catch: NoSuchMethodException -> L15
    L5:
        sActionBarFieldsFetched = true;
        goto L6
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity r100, KeyEvent r101) {
        r100.onUserInteraction();
        Window r102 = r100.getWindow();
        if (r102.hasFeature(8) == false) goto L11;
        ActionBar r103 = r100.getActionBar();
        if (r101.getKeyCode() != 82) goto L11;
        if (r103 == null) goto L11;
        if (actionBarOnMenuKeyEventPre28(r103, r101) == false) goto L11;
        return true;
    L11:
        if (r102.superDispatchKeyEvent(r101) == false) goto L13;
        return true;
    L13:
        View r104 = INVOKEVIRTUAL_androidx_core_view_KeyEventDispatcher_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r102);
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r104, r101) == false) goto L16;
        return true;
    L16:
        if (r104 == null) goto L18;
        KeyEvent.DispatcherState r105 = r104.getKeyDispatcherState();
    L20:
        return r101.dispatch(r100, r105, r100);
    L18:
        r105 = null;
        goto L20
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog r100, KeyEvent r101) {
        DialogInterface.OnKeyListener r102 = getDialogKeyListenerPre28(r100);
        if (r102 != null) goto L5;
    L7:
        Window r103 = r100.getWindow();
        if (r103.superDispatchKeyEvent(r101) == false) goto L10;
        return true;
    L10:
        View r104 = INVOKEVIRTUAL_androidx_core_view_KeyEventDispatcher_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103);
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r104, r101) == false) goto L13;
        return true;
    L13:
        if (r104 == null) goto L15;
        KeyEvent.DispatcherState r105 = r104.getKeyDispatcherState();
    L17:
        return r101.dispatch(r100, r105, r100);
    L15:
        r105 = null;
        goto L17
    L5:
        if (r102.onKey(r100, r101.getKeyCode(), r101) == false) goto L7;
        return true;
    }

    public static boolean dispatchBeforeHierarchy(View r100, KeyEvent r101) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(r100, r101);
    }

    public static boolean dispatchKeyEvent(Component r100, View r101, Window.Callback r102, KeyEvent r103) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L10;
        return r100.superDispatchKeyEvent(r103);
    L10:
        if ((r102 instanceof Activity) == false) goto L14;
        return activitySuperDispatchKeyEventPre28((Activity) r102, r103);
    L14:
        if ((r102 instanceof Dialog) == true) goto L16;
        if (r101 == null) goto L21;
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r101, r103) == false) goto L21;
    L22:
        return true;
    L21:
        if (r100.superDispatchKeyEvent(r103) == true) goto L22;
        return false;
    L16:
        return dialogSuperDispatchKeyEventPre28((Dialog) r102, r103);
    }
}
