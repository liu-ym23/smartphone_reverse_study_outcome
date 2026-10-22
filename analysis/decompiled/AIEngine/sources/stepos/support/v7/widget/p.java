package stepos.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.PopupWindow;
import androidx.appcompat.widget.k0;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p extends k0 {
    public static final Field E;
    public static final Field F;
    public PopupWindow D;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            float radius;
            Drawable background = p.this.C.getBackground();
            if (background != null) {
                Outline outline2 = new Outline();
                background.getOutline(outline2);
                radius = outline2.getRadius();
            } else {
                radius = 0.0f;
            }
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
        }
    }

    static {
        try {
            Field declaredField = k0.class.getDeclaredField("C");
            E = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
        try {
            Field declaredField2 = PopupWindow.class.getDeclaredField("mStepOSPopupWindowExt");
            F = declaredField2;
            declaredField2.setAccessible(true);
        } catch (NoSuchFieldException unused2) {
        }
    }

    public final void f(int i10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Field field;
        PopupWindow popupWindow = this.D;
        if (popupWindow == null || (field = F) == null) {
            return;
        }
        try {
            Object obj = field.get(popupWindow);
            if (obj == null) {
                return;
            }
            obj.getClass().getMethod("applyStepOSAnimation", Integer.TYPE).invoke(obj, Integer.valueOf(i10));
            Log.d("ListPopupWindow", "applyStepOSAnimation success, ext=" + obj + ", style=" + i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.appcompat.widget.k0, l.f
    public final void show() {
        this.D.setInputMethodMode(0);
        super.show();
        View view = (View) this.f864c.getParent();
        if (view != null) {
            view.setOutlineProvider(new a());
            view.setClipToOutline(true);
        }
    }
}
