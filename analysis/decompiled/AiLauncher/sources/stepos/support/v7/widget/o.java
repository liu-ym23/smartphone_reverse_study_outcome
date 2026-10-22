package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.PopupWindow;
import androidx.appcompat.widget.F;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class o extends F {

    /* renamed from: H, reason: collision with root package name */
    public static Field f41660H;

    /* renamed from: I, reason: collision with root package name */
    public static Method f41661I;

    /* renamed from: G, reason: collision with root package name */
    public PopupWindow f41662G;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            float radius;
            Drawable drawableF = o.this.f();
            if (drawableF != null) {
                Outline outline2 = new Outline();
                drawableF.getOutline(outline2);
                radius = outline2.getRadius();
            } else {
                radius = 0.0f;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
        }
    }

    static {
        try {
            Field declaredField = F.class.getDeclaredField("F");
            f41660H = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        try {
            Method method = PopupWindow.class.getMethod("applyFlymeAnimation", Integer.TYPE);
            f41661I = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
    }

    public o(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        try {
            this.f41662G = (PopupWindow) f41660H.get(this);
        } catch (Exception unused) {
        }
    }

    public void Q(int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        PopupWindow popupWindow = this.f41662G;
        if (popupWindow == null || (method = f41661I) == null) {
            return;
        }
        try {
            method.invoke(popupWindow, Integer.valueOf(i10));
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
        }
    }

    public void R(boolean z10) {
        PopupWindow popupWindow = this.f41662G;
        if (popupWindow != null) {
            popupWindow.setClippingEnabled(z10);
        }
    }

    @Override // androidx.appcompat.widget.F, j.InterfaceC4741f
    public void show() {
        this.f41662G.setInputMethodMode(0);
        super.show();
        View view = (View) n().getParent();
        if (view != null) {
            view.setOutlineProvider(new a());
            view.setClipToOutline(true);
        }
    }
}
