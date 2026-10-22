package m;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f7914a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f7915b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f7916c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f7917d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            Class cls3 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
            f7914a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f7915b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f7916c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f7917d = true;
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        }
    }
}
