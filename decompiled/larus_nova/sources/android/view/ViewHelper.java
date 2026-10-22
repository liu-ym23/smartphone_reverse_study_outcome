package android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ViewHelper extends View {
    public ViewHelper(Context r100) {
        super(r100);
    }

    public static void finishInflate(View r100) {
        r100.onFinishInflate();
    }

    public static Object getScrollCache(View r100) {
        Field r101 = View.class.getDeclaredField("mScrollCache");     // Catch: Exception -> L4
        r101.setAccessible(true);     // Catch: Exception -> L4
        Object r102 = r101.get(r100);     // Catch: Exception -> L4
        Field r103 = r102.getClass().getDeclaredField("scrollBar");     // Catch: Exception -> L4
        r103.setAccessible(true);     // Catch: Exception -> L4
        return r103.get(r102);
    L5:
        throw new IllegalStateException("reflect mScrollCache failed");
    }

    public static int getAttrColor(Context r100, int r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(new int[]{r101});
        int r103 = r102.getColor(0, 0);
        r102.recycle();
        return r103;
    }

    public static ColorStateList getAttrColorStateList(Context r100, int r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(new int[]{r101});
        ColorStateList r103 = r102.getColorStateList(0);
        r102.recycle();
        return r103;
    }

    public static float getAttrDimen(Context r100, int r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(new int[]{r101});
        float r103 = r102.getDimension(0, 0.0f);
        r102.recycle();
        return r103;
    }

    public static Drawable getAttrDrawable(Context r100, int r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(new int[]{r101});
        Drawable r103 = r102.getDrawable(0);
        r102.recycle();
        return r103;
    }

    public static float getAttrFloat(Context r100, int r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(new int[]{r101});
        float r103 = r102.getFloat(0, 0.0f);
        r102.recycle();
        return r103;
    }

    public static int getAttrResourceId(Context r100, int r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(new int[]{r101});
        int r103 = r102.getResourceId(0, 0);
        r102.recycle();
        return r103;
    }

    public static String getAttrString(Context r100, int r101) {
        TypedArray r102 = r100.getTheme().obtainStyledAttributes(new int[]{r101});
        String r103 = r102.getString(0);
        r102.recycle();
        return r103;
    }

    public static void setIndeterminateDrawable(ProgressBar r100, Drawable r101) {
        r100.setIndeterminateDrawableTiled(r101);
    }

    public static void setMinHeight(View r100, int r101) {
        ((TextView) r100).setMinHeight(r101);
    }

    public static void setMinWidth(View r100, int r101) {
        ((TextView) r100).setMinWidth(r101);
    }

    public static ViewGroup.MarginLayoutParams getLayoutParam(ViewGroup r100, int r101, int r102) {
        if ((r100 instanceof RelativeLayout) == false) goto L7;
        return new RelativeLayout.LayoutParams(r101, r102);
    L7:
        if ((r100 instanceof LinearLayout) == false) goto L11;
        return new LinearLayout.LayoutParams(r101, r102);
    L11:
        if ((r100 instanceof FrameLayout) == false) goto L15;
        return new FrameLayout.LayoutParams(r101, r102);
    L15:
        if ((r100 instanceof ConstraintLayout) == false) goto L19;
        return new ConstraintLayout.LayoutParams(r101, r102);
    L19:
        return new ViewGroup.MarginLayoutParams(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method getMethod(Class r100, String r101, Class r102) {
        Method r103 = r100.getDeclaredMethod(r101, new Class[]{r102});     // Catch: NoSuchMethodException -> L5
        r103.setAccessible(true);     // Catch: NoSuchMethodException -> L5
        return r103;
    L6:
        throw new IllegalStateException("getMethod failed " + r101);
    }

    public static void invokeOnClick(final Object r100, final String r101, final View r102) throws Exception {
        r102.setOnClickListener(new AnonymousClass1(r100, r101, r102));
    }

    public static void setField(Class r100, String r101, Object r102, Object r103) throws Exception {
        Field r104 = r100.getDeclaredField(r101);
        r104.setAccessible(true);
        r104.set(r102, r103);
    }
}
