package stepos.support.v7.widget;

import android.util.Log;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public abstract class n0 {
    public static boolean a(int i4, StepOSRecyclerView stepOSRecyclerView) throws NoSuchMethodException, SecurityException {
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = RecyclerView.class.getDeclaredMethod("scrollByInternal", cls, cls, MotionEvent.class, cls);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(stepOSRecyclerView, 0, Integer.valueOf(i4), null, 0)).booleanValue();
        } catch (Exception e4) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvScrollByInternal ex" + e4.toString());
            return false;
        }
    }

    public static void b(StepOSRecyclerView stepOSRecyclerView) {
        try {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ");
            Method declaredMethod = RecyclerView.class.getDeclaredMethod("setScrollState", Integer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(stepOSRecyclerView, 0);
        } catch (Exception e4) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ex" + e4.toString());
        }
    }

    public static boolean c(StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return ((RecyclerView.State) declaredField.get(stepOSRecyclerView)).didStructureChange();
        } catch (Exception e4) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvStateDidStructureChange ex" + e4.toString());
            return false;
        }
    }
}
