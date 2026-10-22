package b5;

import android.content.Context;
import android.content.res.TypedArray;
import g.C0728a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f11833a;

    private a(Context context) {
        this.f11833a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f11833a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        TypedArray typedArrayObtainStyledAttributes = this.f11833a.obtainStyledAttributes(null, X4.l.f6196T4, N1.a.c() ? X4.a.f5823A : C0728a.f16823T, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(g.j.f17128g3, this.f11833a.getResources().getDimensionPixelSize(X4.d.f5919s));
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public int d() {
        return this.f11833a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int e() {
        return this.f11833a.getResources().getInteger(X4.g.f6028a);
    }

    public int f() {
        return this.f11833a.getResources().getDimensionPixelSize(X4.d.f5925y);
    }

    public int g() {
        return this.f11833a.getResources().getDimensionPixelSize(g.d.f16860b);
    }

    public int h() {
        return this.f11833a.getResources().getDimensionPixelSize(X4.d.f5892b);
    }

    public boolean i() {
        return this.f11833a.getApplicationInfo().targetSdkVersion >= 16 ? this.f11833a.getResources().getBoolean(g.b.f16850a) : this.f11833a.getResources().getBoolean(X4.b.f5851a);
    }

    public boolean j() {
        return true;
    }
}
