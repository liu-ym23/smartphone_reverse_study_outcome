package stepos.support.v7.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.widget.G0;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public final class K extends G0 {

    /* renamed from: B, reason: collision with root package name */
    public static final Field f14831B;

    /* renamed from: C, reason: collision with root package name */
    public static final Method f14832C;

    /* renamed from: A, reason: collision with root package name */
    public PopupWindow f14833A;

    static {
        try {
            Field declaredField = G0.class.getDeclaredField(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z);
            f14831B = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        try {
            Method method = PopupWindow.class.getMethod("applyFlymeAnimation", Integer.TYPE);
            f14832C = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
    }

    @Override // androidx.appcompat.widget.G0, k.InterfaceC0644E
    public final void g() {
        this.f14833A.setInputMethodMode(0);
        super.g();
        View view = (View) this.f2823c.getParent();
        if (view != null) {
            view.setOutlineProvider(new r1.c(2, this));
            view.setClipToOutline(true);
        }
    }

    public final void s(int i4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        PopupWindow popupWindow = this.f14833A;
        if (popupWindow == null || (method = f14832C) == null) {
            return;
        }
        try {
            method.invoke(popupWindow, Integer.valueOf(i4));
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }
}
