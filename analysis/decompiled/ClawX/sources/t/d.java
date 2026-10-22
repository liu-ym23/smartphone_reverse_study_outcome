package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public a f5389a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5390b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5391c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5392e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5393f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5394g;

    /* renamed from: h, reason: collision with root package name */
    public int f5395h;

    /* renamed from: i, reason: collision with root package name */
    public int f5396i;

    /* renamed from: j, reason: collision with root package name */
    public int f5397j;

    /* renamed from: k, reason: collision with root package name */
    public View f5398k;

    /* renamed from: l, reason: collision with root package name */
    public View f5399l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5400m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5401n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f5402o;

    public d() {
        super(-2, -2);
        this.f5390b = false;
        this.f5391c = 0;
        this.d = 0;
        this.f5392e = -1;
        this.f5393f = -1;
        this.f5394g = 0;
        this.f5395h = 0;
        this.f5402o = new Rect();
    }

    public final boolean a(int i8) {
        if (i8 == 0) {
            return this.f5400m;
        }
        if (i8 != 1) {
            return false;
        }
        return this.f5401n;
    }

    public d(Context context, AttributeSet attributeSet) throws NoSuchMethodException, SecurityException {
        a aVar;
        super(context, attributeSet);
        this.f5390b = false;
        this.f5391c = 0;
        this.d = 0;
        this.f5392e = -1;
        this.f5393f = -1;
        this.f5394g = 0;
        this.f5395h = 0;
        this.f5402o = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.a.f5229b);
        this.f5391c = typedArrayObtainStyledAttributes.getInteger(0, 0);
        this.f5393f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.d = typedArrayObtainStyledAttributes.getInteger(2, 0);
        this.f5392e = typedArrayObtainStyledAttributes.getInteger(6, -1);
        this.f5394g = typedArrayObtainStyledAttributes.getInt(5, 0);
        this.f5395h = typedArrayObtainStyledAttributes.getInt(4, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
        this.f5390b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.f376u;
            if (TextUtils.isEmpty(string)) {
                aVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.f376u;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.f378w;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f377v);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    aVar = (a) constructor.newInstance(context, attributeSet);
                } catch (Exception e9) {
                    throw new RuntimeException(m0.f.c("Could not inflate Behavior subclass ", string), e9);
                }
            }
            this.f5389a = aVar;
        }
        typedArrayObtainStyledAttributes.recycle();
        a aVar2 = this.f5389a;
        if (aVar2 != null) {
            aVar2.c(this);
        }
    }

    public d(d dVar) {
        super((ViewGroup.MarginLayoutParams) dVar);
        this.f5390b = false;
        this.f5391c = 0;
        this.d = 0;
        this.f5392e = -1;
        this.f5393f = -1;
        this.f5394g = 0;
        this.f5395h = 0;
        this.f5402o = new Rect();
    }

    public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f5390b = false;
        this.f5391c = 0;
        this.d = 0;
        this.f5392e = -1;
        this.f5393f = -1;
        this.f5394g = 0;
        this.f5395h = 0;
        this.f5402o = new Rect();
    }

    public d(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f5390b = false;
        this.f5391c = 0;
        this.d = 0;
        this.f5392e = -1;
        this.f5393f = -1;
        this.f5394g = 0;
        this.f5395h = 0;
        this.f5402o = new Rect();
    }
}
