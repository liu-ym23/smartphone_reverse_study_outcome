package stepos.support.v7.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ListPopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class P extends ListPopupWindow {
    public static final Field b;
    public static final Method c;

    /* renamed from: a, reason: collision with root package name */
    public PopupWindow f6475a;

    static {
        try {
            Field declaredField = ListPopupWindow.class.getDeclaredField("mPopup");
            b = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        try {
            Method method = PopupWindow.class.getMethod("applyFlymeAnimation", Integer.TYPE);
            c = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
    }

    public final void a(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        PopupWindow popupWindow = this.f6475a;
        if (popupWindow == null || (method = c) == null) {
            return;
        }
        try {
            method.invoke(popupWindow, Integer.valueOf(i));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        this.f6475a.setInputMethodMode(0);
        super.show();
        View view = (View) getListView().getParent();
        if (view != null) {
            view.setOutlineProvider(new A6.k(this, 3));
            view.setClipToOutline(true);
        }
    }
}
