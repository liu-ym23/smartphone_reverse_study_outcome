package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import g.C0728a;
import g.j;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f7706a;

    private a(Context context) {
        this.f7706a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f7706a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f7706a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f7706a.getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        int i6 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i5 > 600) {
            return 5;
        }
        if (i5 > 960 && i6 > 720) {
            return 5;
        }
        if (i5 > 720 && i6 > 960) {
            return 5;
        }
        if (i5 >= 500) {
            return 4;
        }
        if (i5 > 640 && i6 > 480) {
            return 4;
        }
        if (i5 <= 480 || i6 <= 640) {
            return i5 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f7706a.getResources().getDimensionPixelSize(g.d.f16860b);
    }

    public int f() {
        TypedArray typedArrayObtainStyledAttributes = this.f7706a.obtainStyledAttributes(null, j.f17094a, C0728a.f16826c, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(j.f17139j, 0);
        Resources resources = this.f7706a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(g.d.f16859a));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f7706a.getResources().getBoolean(g.b.f16850a);
    }

    public boolean h() {
        return true;
    }
}
