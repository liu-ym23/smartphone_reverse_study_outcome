package e1;

import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.statsrpk.c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f12502a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f12503b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f12504c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f12505d;

    static {
        Method method;
        Method method2;
        Method method3;
        Process.myUid();
        Method method4 = null;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f12502a = method;
        try {
            method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        f12503b = method2;
        try {
            method3 = WorkSource.class.getMethod(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, new Class[0]);
        } catch (Exception unused3) {
            method3 = null;
        }
        f12504c = method3;
        try {
            WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused4) {
        }
        try {
            WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception unused5) {
        }
        try {
            WorkSource.class.getMethod("createWorkChain", new Class[0]);
        } catch (Exception e4) {
            Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e4);
        }
        try {
            Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
        } catch (Exception e5) {
            Log.w("WorkSourceUtil", "Missing WorkChain class", e5);
        }
        try {
            method4 = WorkSource.class.getMethod("isEmpty", new Class[0]);
            method4.setAccessible(true);
        } catch (Exception unused6) {
        }
        f12505d = method4;
    }

    public static boolean a(WorkSource workSource) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f12505d;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, new Object[0]);
                c.l(objInvoke);
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e4) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e4);
            }
        }
        Method method2 = f12504c;
        if (method2 == null) {
            return true;
        }
        try {
            Object objInvoke2 = method2.invoke(workSource, new Object[0]);
            c.l(objInvoke2);
            return ((Integer) objInvoke2).intValue() == 0;
        } catch (Exception e5) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
            return true;
        }
    }
}
