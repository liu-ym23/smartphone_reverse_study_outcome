package com.stepos.ailauncher.sheet.internal;

import Z8.C1173v;
import android.graphics.Region;
import android.util.Log;
import android.view.AttachedSurfaceControl;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/J;", "", "<init>", "()V", "", UxipConstants.f30680s, "LY8/t;", "k", "(Z)V", "Landroid/view/Window;", "window", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/Window;)V", "", "minBottomInsetPx", Const.INTENT_KEY_UMID, "(Landroid/view/Window;I)V", "Landroid/graphics/Region;", WeatherCardProvider.KEY_REGION, "watchOutside", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/Window;Landroid/graphics/Region;Z)Z", "Landroidx/core/view/a0;", "insets", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroidx/core/view/a0;I)I", "Landroid/view/View;", "decor", "l", "(Landroid/view/View;Landroid/graphics/Region;)Z", "m", "", "TAG", "Ljava/lang/String;", "layoutListenerKey", "I", "suspended", "Z", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J {
    private static final String TAG = "NavGesturePass";
    private static volatile boolean suspended;
    public static final J INSTANCE = new J();
    private static final int layoutListenerKey = 2147483586;

    public static final void e(View view, int i10) {
        if (suspended) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        a0 a0VarB = androidx.core.view.N.B(view);
        J j10 = INSTANCE;
        int iJ = j10.j(a0VarB, i10);
        int iF = C5685n.f(height - iJ, 1);
        Region region = new Region(0, 0, width, iF);
        if (!j10.l(view, region) && !j10.m(view, region)) {
            Log.w(TAG, "setTouchableRegion unavailable, reserve=" + iJ);
            return;
        }
        Log.d(TAG, "touchableRegion=0,0," + width + Const.STR_MART_COMMA + iF + " reserve=" + iJ);
    }

    public static final void f(Runnable runnable, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        runnable.run();
    }

    public static /* synthetic */ boolean h(J j10, Window window, Region region, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return j10.g(window, region, z10);
    }

    public static final Object n(Method method, int i10, Field field, Region region, Object obj, Method method2, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!kotlin.jvm.internal.p.d(method2.getName(), "onComputeInternalInsets") || objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return null;
        }
        Object obj2 = objArr[0];
        method.invoke(obj2, Integer.valueOf(i10));
        Object obj3 = field.get(obj2);
        kotlin.jvm.internal.p.g(obj3, "null cannot be cast to non-null type android.graphics.Region");
        ((Region) obj3).set(region);
        return null;
    }

    public final void d(Window window, final int minBottomInsetPx) {
        kotlin.jvm.internal.p.i(window, "window");
        final View decorView = window.getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        decorView.setSystemGestureExclusionRects(C1173v.m());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = (attributes.flags | 32) & (-262161);
        window.setAttributes(attributes);
        final Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.sheet.internal.G
            @Override // java.lang.Runnable
            public final void run() {
                J.e(decorView, minBottomInsetPx);
            }
        };
        if (decorView.getWidth() <= 0 || decorView.getHeight() <= 0) {
            decorView.post(runnable);
        } else {
            runnable.run();
        }
        int i10 = layoutListenerKey;
        Object tag = decorView.getTag(i10);
        Boolean bool = Boolean.TRUE;
        if (kotlin.jvm.internal.p.d(tag, bool)) {
            return;
        }
        decorView.setTag(i10, bool);
        decorView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.sheet.internal.H
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                J.f(runnable, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        });
    }

    public final boolean g(Window window, Region region, boolean watchOutside) {
        kotlin.jvm.internal.p.i(window, "window");
        kotlin.jvm.internal.p.i(region, "region");
        View decorView = window.getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        decorView.setSystemGestureExclusionRects(C1173v.m());
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i10 = attributes.flags | 32;
        int i11 = i10 & (-17);
        attributes.flags = i11;
        attributes.flags = watchOutside ? 262144 | i11 : (-262161) & i10;
        window.setAttributes(attributes);
        return l(decorView, region) || m(decorView, region);
    }

    public final void i(Window window) {
        kotlin.jvm.internal.p.i(window, "window");
        View decorView = window.getDecorView();
        kotlin.jvm.internal.p.h(decorView, "getDecorView(...)");
        Region region = new Region();
        if (l(decorView, region)) {
            return;
        }
        m(decorView, region);
    }

    public final int j(a0 insets, int minBottomInsetPx) {
        if (insets == null) {
            return minBottomInsetPx;
        }
        int i10 = insets.f(a0.o.h()).f41980d;
        int i11 = insets.f(a0.o.d()).f41980d;
        return Math.max(Math.max(Math.max(i10, i11), insets.f(a0.o.e()).f41980d), minBottomInsetPx);
    }

    public final void k(boolean value) {
        suspended = value;
    }

    public final boolean l(View decor, Region region) {
        Method method;
        try {
            AttachedSurfaceControl rootSurfaceControl = decor.getRootSurfaceControl();
            if (rootSurfaceControl != null) {
                rootSurfaceControl.setTouchableRegion(region);
                return true;
            }
        } catch (Throwable th) {
            Log.d(TAG, "rootSurfaceControl.setTouchableRegion: " + th.getMessage());
        }
        ViewParent parent = decor.getRootView().getParent();
        if (parent == null) {
            return false;
        }
        try {
            Method[] methods = parent.getClass().getMethods();
            kotlin.jvm.internal.p.h(methods, "getMethods(...)");
            int length = methods.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    method = null;
                    break;
                }
                method = methods[i10];
                if (kotlin.jvm.internal.p.d(method.getName(), "setTouchableRegion") && method.getParameterTypes().length == 1 && method.getParameterTypes()[0].isAssignableFrom(Region.class)) {
                    break;
                }
                i10++;
            }
            if (method == null) {
                return false;
            }
            method.setAccessible(true);
            method.invoke(parent, region);
            return true;
        } catch (Throwable th2) {
            Log.w(TAG, "ViewRootImpl.setTouchableRegion failed: " + th2.getMessage());
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int] */
    /* JADX WARN: Type inference failed for: r5v6 */
    public final boolean m(View decor, final Region region) {
        boolean z10;
        try {
            ViewTreeObserver viewTreeObserver = decor.getViewTreeObserver();
            Class<?> cls = Class.forName("android.view.ViewTreeObserver$OnComputeInternalInsetsListener");
            Class<?> cls2 = Class.forName("android.view.ViewTreeObserver$InternalInsetsInfo");
            Method method = null;
            final int i10 = cls2.getField("TOUCHABLE_INSETS_REGION").getInt(null);
            final Method method2 = cls2.getMethod("setTouchableInsets", Integer.TYPE);
            final Field field = cls2.getField("touchableRegion");
            Object tag = decor.getTag(layoutListenerKey + 1);
            if (tag != null) {
                Method[] methods = viewTreeObserver.getClass().getMethods();
                kotlin.jvm.internal.p.h(methods, "getMethods(...)");
                int length = methods.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        z10 = false;
                        break;
                    }
                    Method method3 = methods[i11];
                    z10 = false;
                    try {
                        if (kotlin.jvm.internal.p.d(method3.getName(), "removeOnComputeInternalInsetsListener") && method3.getParameterTypes().length == 1) {
                            method = method3;
                            break;
                        }
                        i11++;
                    } catch (Throwable th) {
                        th = th;
                        Log.d(TAG, "ComputeInternalInsets path failed: " + th.getMessage());
                        return z10;
                    }
                }
                if (method != null) {
                    method.invoke(viewTreeObserver, tag);
                }
            } else {
                z10 = false;
            }
            Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.stepos.ailauncher.sheet.internal.I
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method4, Object[] objArr) {
                    return J.n(method2, i10, field, region, obj, method4, objArr);
                }
            });
            Method[] methods2 = viewTreeObserver.getClass().getMethods();
            kotlin.jvm.internal.p.h(methods2, "getMethods(...)");
            int length2 = methods2.length;
            for (?? r52 = z10; r52 < length2; r52++) {
                Method method4 = methods2[r52];
                if (kotlin.jvm.internal.p.d(method4.getName(), "addOnComputeInternalInsetsListener") && method4.getParameterTypes().length == 1) {
                    method4.invoke(viewTreeObserver, objNewProxyInstance);
                    decor.setTag(layoutListenerKey + 1, objNewProxyInstance);
                    return true;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
    }
}
