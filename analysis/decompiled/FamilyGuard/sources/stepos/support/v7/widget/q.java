package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.PopupWindow;
import androidx.appcompat.widget.M;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class q extends M {

    /* renamed from: H, reason: collision with root package name */
    private static Field f22091H;

    /* renamed from: I, reason: collision with root package name */
    private static Method f22092I;

    /* renamed from: G, reason: collision with root package name */
    PopupWindow f22093G;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            float radius;
            Drawable drawableL = q.this.l();
            if (drawableL != null) {
                Outline outline2 = new Outline();
                drawableL.getOutline(outline2);
                radius = outline2.getRadius();
            } else {
                radius = 0.0f;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
        }
    }

    static {
        try {
            Field declaredField = M.class.getDeclaredField("F");
            f22091H = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        try {
            Method method = PopupWindow.class.getMethod("applyFlymeAnimation", Integer.TYPE);
            f22092I = method;
            method.setAccessible(true);
        } catch (NoSuchMethodException unused2) {
        }
    }

    public q(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        try {
            this.f22093G = (PopupWindow) f22091H.get(this);
        } catch (Exception unused) {
        }
    }

    public void S(int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        PopupWindow popupWindow = this.f22093G;
        if (popupWindow == null || (method = f22092I) == null) {
            return;
        }
        try {
            method.invoke(popupWindow, Integer.valueOf(i5));
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
        }
    }

    public void T(boolean z5) {
        PopupWindow popupWindow = this.f22093G;
        if (popupWindow != null) {
            popupWindow.setClippingEnabled(z5);
        }
    }

    @Override // androidx.appcompat.widget.M, l.InterfaceC0820e
    public void a() {
        this.f22093G.setInputMethodMode(0);
        super.a();
        View view = (View) m().getParent();
        if (view != null) {
            view.setOutlineProvider(new a());
            view.setClipToOutline(true);
        }
    }
}
