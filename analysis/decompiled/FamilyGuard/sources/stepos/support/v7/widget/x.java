package stepos.support.v7.widget;

import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class x {
    public static RecyclerView.AdapterDataObserver a(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mObserver");
            declaredField.setAccessible(true);
            return (RecyclerView.AdapterDataObserver) declaredField.get(stepOSRecyclerView);
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "getRecyclerViewDataObserver ex" + e6.toString());
            return null;
        }
    }

    public static int b(Class cls, RecyclerView.State state) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mLayoutStep");
            declaredField.setAccessible(true);
            return ((Integer) declaredField.get(state)).intValue();
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "getRvStateStepField ex" + e6.toString());
            return 0;
        }
    }

    public static RecyclerView.State c(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return (RecyclerView.State) declaredField.get(stepOSRecyclerView);
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "getStateField ex" + e6.toString());
            return null;
        }
    }

    public static Interpolator d(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("sQuinticInterpolator");
            declaredField.setAccessible(true);
            return (Interpolator) declaredField.get(stepOSRecyclerView);
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "getsQuinticInterpolator ex" + e6.toString());
            return null;
        }
    }

    public static void e(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mRecycler");
            declaredField.setAccessible(true);
            ((RecyclerView.Recycler) declaredField.get(stepOSRecyclerView)).clear();
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvRecyclerVClear ex" + e6.toString());
        }
    }

    public static boolean f(int i5, int i6, MotionEvent motionEvent, int i7, Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchMethodException, SecurityException {
        try {
            Class cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("scrollByInternal", cls2, cls2, MotionEvent.class, cls2);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(stepOSRecyclerView, Integer.valueOf(i5), Integer.valueOf(i6), motionEvent, Integer.valueOf(i7))).booleanValue();
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvScrollByInternal ex" + e6.toString());
            return false;
        }
    }

    public static void g(int i5, Class cls, StepOSRecyclerView stepOSRecyclerView) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ");
            Method declaredMethod = cls.getDeclaredMethod("setScrollState", Integer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(stepOSRecyclerView, Integer.valueOf(i5));
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ex" + e6.toString());
        }
    }

    public static boolean h(Class cls, StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = cls.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return ((RecyclerView.State) declaredField.get(stepOSRecyclerView)).didStructureChange();
        } catch (Exception e6) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvStateDidStructureChange ex" + e6.toString());
            return false;
        }
    }

    public static void i(Class cls, StepOSRecyclerView stepOSRecyclerView, o oVar) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = cls.getDeclaredField("mAdapter");
            declaredField.setAccessible(true);
            declaredField.set(stepOSRecyclerView, oVar);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
