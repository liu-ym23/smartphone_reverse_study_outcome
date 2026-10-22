package stepos.support.v7.widget;

import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class j0 extends m.w1 {
    public static final Field F;
    public static final Method G;
    public PopupWindow E;

    static {
        try {
            Field declaredField = m.w1.class.getDeclaredField("D");
            F = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        try {
            Method method = PopupWindow.class.getMethod("applyFlymeAnimation", Integer.TYPE);
            G = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
    }

    @Override // m.w1, l.b0
    public final void f() {
        this.E.setInputMethodMode(0);
        super.f();
        View view = (View) this.f8116g.getParent();
        if (view != null) {
            view.setOutlineProvider(new com.stepos.common.widget.l(this, 1));
            view.setClipToOutline(true);
        }
    }

    public final void s(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        PopupWindow popupWindow = this.E;
        if (popupWindow == null || (method = G) == null) {
            return;
        }
        try {
            method.invoke(popupWindow, Integer.valueOf(i));
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
        }
    }
}
