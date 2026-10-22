package stepos.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.appcompat.R$attr;

/* loaded from: classes5.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f41738a = {R$attr.colorPrimary};

    public static void a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f41738a);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        if (!zHasValue) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
