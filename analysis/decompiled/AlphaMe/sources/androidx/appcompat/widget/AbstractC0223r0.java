package androidx.appcompat.widget;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.widget.r0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0223r0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f3156a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f3157b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f3158c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f3159d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f3156a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f3157b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f3158c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f3159d = true;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        }
    }
}
