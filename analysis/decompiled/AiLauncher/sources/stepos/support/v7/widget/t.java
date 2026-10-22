package stepos.support.v7.widget;

import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class t {
    public static int a(Class cls, RecyclerView.State state) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mLayoutStep");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(state)).intValue();
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "getRvStateStepField ex" + e10.toString());
            return 0;
        }
    }

    public static RecyclerView.State b(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return (RecyclerView.State) declaredField.get(stepOSRecyclerView);
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "getStateField ex" + e10.toString());
            return null;
        }
    }

    public static Interpolator c(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("sQuinticInterpolator");
            declaredField.setAccessible(true);
            return (Interpolator) declaredField.get(stepOSRecyclerView);
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "getsQuinticInterpolator ex" + e10.toString());
            return null;
        }
    }

    public static void d(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mRecycler");
            declaredField.setAccessible(true);
            ((RecyclerView.Recycler) declaredField.get(stepOSRecyclerView)).clear();
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvRecyclerVClear ex" + e10.toString());
        }
    }

    public static boolean e(int i10, int i11, MotionEvent motionEvent, int i12, Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchMethodException, SecurityException {
        try {
            Class cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("scrollByInternal", cls2, cls2, MotionEvent.class, cls2);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(stepOSRecyclerView, Integer.valueOf(i10), Integer.valueOf(i11), motionEvent, Integer.valueOf(i12))).booleanValue();
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvScrollByInternal ex" + e10.toString());
            return false;
        }
    }

    public static void f(int i10, Class cls, StepOSRecyclerView stepOSRecyclerView) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ");
            Method declaredMethod = cls.getDeclaredMethod("setScrollState", Integer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(stepOSRecyclerView, Integer.valueOf(i10));
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ex" + e10.toString());
        }
    }

    public static boolean g(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return ((RecyclerView.State) declaredField.get(stepOSRecyclerView)).didStructureChange();
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvStateDidStructureChange ex" + e10.toString());
            return false;
        }
    }
}
