package M;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f4464a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, WeakReference<Context>> f4465b = new HashMap();

    public static class a {
        public static Context a(Context context, String str) {
            return context.createAttributionContext(str);
        }

        public static String b(Context context) {
            return context.getAttributionTag();
        }
    }

    public static class b {
        public static Context a(Context context, int i10) {
            return context.createDeviceContext(i10);
        }

        public static int b(Context context) {
            return context.getDeviceId();
        }
    }

    public static Application a(Context context) {
        for (Context applicationContext = context.getApplicationContext(); applicationContext instanceof ContextWrapper; applicationContext = ((ContextWrapper) applicationContext).getBaseContext()) {
            if (applicationContext instanceof Application) {
                return (Application) applicationContext;
            }
        }
        return null;
    }

    public static String b(Context context) {
        int iHashCode = context.getApplicationContext().hashCode();
        int iE = e(context);
        return String.format("%d-%d-%s", Integer.valueOf(iHashCode), Integer.valueOf(iE), a.b(context));
    }

    public static Context c(String str) {
        Map<String, WeakReference<Context>> map = f4465b;
        WeakReference<Context> weakReference = map.get(str);
        if (weakReference == null) {
            return null;
        }
        Context context = weakReference.get();
        if (context != null) {
            return context;
        }
        map.remove(str);
        return null;
    }

    public static int d() {
        return 0;
    }

    public static int e(Context context) {
        return b.b(context);
    }

    public static Context f(Context context) {
        Context applicationContext = context.getApplicationContext();
        String strB = b(context);
        synchronized (f4464a) {
            try {
                Context contextC = c(strB);
                if (contextC != null) {
                    return contextC;
                }
                Context contextA = b.a(applicationContext, b.b(context));
                String strB2 = a.b(context);
                if (!Objects.equals(strB2, a.b(contextA))) {
                    contextA = a.a(contextA, strB2);
                }
                f4465b.put(strB, new WeakReference<>(contextA));
                return contextA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
