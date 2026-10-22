package k7;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import k.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f7272a = {R.attr.theme, com.stepos.agentsafetycenter.R.attr.theme};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f7273b = {com.stepos.agentsafetycenter.R.attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i, int i3, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7273b, i, i3);
        int[] iArr2 = {typedArrayObtainStyledAttributes.getResourceId(0, 0)};
        typedArrayObtainStyledAttributes.recycle();
        int i10 = iArr2[0];
        boolean z10 = (context instanceof c) && ((c) context).f6800a == i10;
        if (i10 == 0 || z10) {
            return context;
        }
        c cVar = new c(context, i10);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i, i3);
            for (int i11 = 0; i11 < iArr.length; i11++) {
                iArr3[i11] = typedArrayObtainStyledAttributes2.getResourceId(i11, 0);
            }
            typedArrayObtainStyledAttributes2.recycle();
        }
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = iArr3[i12];
            if (i13 != 0) {
                cVar.getTheme().applyStyle(i13, true);
            }
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f7272a);
        int resourceId = typedArrayObtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(1, 0);
        typedArrayObtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            cVar.getTheme().applyStyle(resourceId, true);
        }
        return cVar;
    }
}
