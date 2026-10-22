package x1;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6249a = {R.attr.theme, com.stepos.stepclaw.R.attr.theme};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f6250b = {com.stepos.stepclaw.R.attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i8, int i9) {
        return b(context, attributeSet, i8, i9, new int[0]);
    }

    public static Context b(Context context, AttributeSet attributeSet, int i8, int i9, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f6250b, i8, i9);
        int[] iArr2 = {typedArrayObtainStyledAttributes.getResourceId(0, 0)};
        typedArrayObtainStyledAttributes.recycle();
        int i10 = iArr2[0];
        boolean z = (context instanceof e.a) && ((e.a) context).f2250a == i10;
        if (i10 == 0 || z) {
            return context;
        }
        e.a aVar = new e.a(context);
        aVar.f2250a = i10;
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i8, i9);
            for (int i11 = 0; i11 < iArr.length; i11++) {
                iArr3[i11] = typedArrayObtainStyledAttributes2.getResourceId(i11, 0);
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = iArr3[i12];
            if (i13 != 0) {
                aVar.getTheme().applyStyle(i13, true);
            }
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f6249a);
        int resourceId = typedArrayObtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(1, 0);
        typedArrayObtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            aVar.getTheme().applyStyle(resourceId, true);
        }
        return aVar;
    }
}
