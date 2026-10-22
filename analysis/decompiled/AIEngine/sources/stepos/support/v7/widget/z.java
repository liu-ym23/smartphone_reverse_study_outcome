package stepos.support.v7.widget;

import android.util.Log;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class z {
    public static RecyclerView.State a(StepOSRecyclerView stepOSRecyclerView) {
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return (RecyclerView.State) declaredField.get(stepOSRecyclerView);
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "getStateField ex" + e10.toString());
            return null;
        }
    }

    public static boolean b(int i10, StepOSRecyclerView stepOSRecyclerView) {
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = RecyclerView.class.getDeclaredMethod("scrollByInternal", cls, cls, MotionEvent.class, cls);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(stepOSRecyclerView, 0, Integer.valueOf(i10), null, 0)).booleanValue();
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvScrollByInternal ex" + e10.toString());
            return false;
        }
    }

    public static void c(StepOSRecyclerView stepOSRecyclerView) {
        try {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ");
            Method declaredMethod = RecyclerView.class.getDeclaredMethod("setScrollState", Integer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(stepOSRecyclerView, 0);
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ex" + e10.toString());
        }
    }

    public static boolean d(StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mState");
            declaredField.setAccessible(true);
            return ((RecyclerView.State) declaredField.get(stepOSRecyclerView)).didStructureChange();
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvStateDidStructureChange ex" + e10.toString());
            return false;
        }
    }
}
