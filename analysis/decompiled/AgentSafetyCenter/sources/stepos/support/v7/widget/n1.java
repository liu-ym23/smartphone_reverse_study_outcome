package stepos.support.v7.widget;

import android.util.Log;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class n1 {
    public static boolean a(int i, StepOSRecyclerView stepOSRecyclerView) throws NoSuchMethodException, SecurityException {
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = RecyclerView.class.getDeclaredMethod("scrollByInternal", cls, cls, MotionEvent.class, cls);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(stepOSRecyclerView, 0, Integer.valueOf(i), null, 0)).booleanValue();
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvScrollByInternal ex" + e10.toString());
            return false;
        }
    }

    public static void b(StepOSRecyclerView stepOSRecyclerView) {
        try {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ");
            Method declaredMethod = RecyclerView.class.getDeclaredMethod("setScrollState", Integer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(stepOSRecyclerView, 0);
        } catch (Exception e10) {
            Log.e("StepOSRecyclerViewHelper", "invokeRvSetScrollState ex" + e10.toString());
        }
    }

    public static boolean c(StepOSRecyclerView stepOSRecyclerView) throws NoSuchFieldException, SecurityException {
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
