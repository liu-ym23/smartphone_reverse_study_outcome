package A;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ch.qos.logback.core.CoreConstants;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import z.AbstractC0992a;

/* loaded from: classes.dex */
public final class d extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public b f5a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11g;

    /* renamed from: h, reason: collision with root package name */
    public int f12h;

    /* renamed from: i, reason: collision with root package name */
    public int f13i;

    /* renamed from: j, reason: collision with root package name */
    public int f14j;

    /* renamed from: k, reason: collision with root package name */
    public View f15k;

    /* renamed from: l, reason: collision with root package name */
    public View f16l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f17m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f18n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f19o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f21q;

    /* renamed from: r, reason: collision with root package name */
    public Object f22r;

    public d() {
        super(-2, -2);
        this.f6b = false;
        this.f7c = 0;
        this.f8d = 0;
        this.f9e = -1;
        this.f10f = -1;
        this.f11g = 0;
        this.f12h = 0;
        this.f21q = new Rect();
    }

    public final boolean a(int i4) {
        if (i4 == 0) {
            return this.f18n;
        }
        if (i4 != 1) {
            return false;
        }
        return this.f19o;
    }

    public d(Context context, AttributeSet attributeSet) throws NoSuchMethodException, SecurityException {
        b bVar;
        super(context, attributeSet);
        this.f6b = false;
        this.f7c = 0;
        this.f8d = 0;
        this.f9e = -1;
        this.f10f = -1;
        this.f11g = 0;
        this.f12h = 0;
        this.f21q = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0992a.f16391b);
        this.f7c = typedArrayObtainStyledAttributes.getInteger(0, 0);
        this.f10f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f8d = typedArrayObtainStyledAttributes.getInteger(2, 0);
        this.f9e = typedArrayObtainStyledAttributes.getInteger(6, -1);
        this.f11g = typedArrayObtainStyledAttributes.getInt(5, 0);
        this.f12h = typedArrayObtainStyledAttributes.getInt(4, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
        this.f6b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.f3246u;
            if (TextUtils.isEmpty(string)) {
                bVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.f3246u;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + CoreConstants.DOT + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.f3248w;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f3247v);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    bVar = (b) constructor.newInstance(context, attributeSet);
                } catch (Exception e4) {
                    throw new RuntimeException(B0.g.m("Could not inflate Behavior subclass ", string), e4);
                }
            }
            this.f5a = bVar;
        }
        typedArrayObtainStyledAttributes.recycle();
        b bVar2 = this.f5a;
        if (bVar2 != null) {
            bVar2.onAttachedToLayoutParams(this);
        }
    }

    public d(d dVar) {
        super((ViewGroup.MarginLayoutParams) dVar);
        this.f6b = false;
        this.f7c = 0;
        this.f8d = 0;
        this.f9e = -1;
        this.f10f = -1;
        this.f11g = 0;
        this.f12h = 0;
        this.f21q = new Rect();
    }

    public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f6b = false;
        this.f7c = 0;
        this.f8d = 0;
        this.f9e = -1;
        this.f10f = -1;
        this.f11g = 0;
        this.f12h = 0;
        this.f21q = new Rect();
    }

    public d(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f6b = false;
        this.f7c = 0;
        this.f8d = 0;
        this.f9e = -1;
        this.f10f = -1;
        this.f11g = 0;
        this.f12h = 0;
        this.f21q = new Rect();
    }
}
