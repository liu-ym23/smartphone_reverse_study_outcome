package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import g.C0728a;

/* loaded from: classes.dex */
class z {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f22289a = {C0728a.f16805B};

    static void a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f22289a);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        if (!zHasValue) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
