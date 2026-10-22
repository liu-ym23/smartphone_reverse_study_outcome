package x1;

import a1.C0409b;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.d;
import g.C0728a;

/* renamed from: x1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1282a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f23783a = {R.attr.theme, C0728a.f16821R};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f23784b = {C0409b.f6734u};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f23783a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int[] b(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6) {
        int[] iArr2 = new int[iArr.length];
        if (iArr.length > 0) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
            for (int i7 = 0; i7 < iArr.length; i7++) {
                iArr2[i7] = typedArrayObtainStyledAttributes.getResourceId(i7, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        return iArr2;
    }

    private static int c(Context context, AttributeSet attributeSet, int i5, int i6) {
        return b(context, attributeSet, f23784b, i5, i6)[0];
    }

    public static Context d(Context context, AttributeSet attributeSet, int i5, int i6) {
        return e(context, attributeSet, i5, i6, new int[0]);
    }

    public static Context e(Context context, AttributeSet attributeSet, int i5, int i6, int[] iArr) {
        int iC = c(context, attributeSet, i5, i6);
        boolean z5 = (context instanceof d) && ((d) context).c() == iC;
        if (iC == 0 || z5) {
            return context;
        }
        d dVar = new d(context, iC);
        for (int i7 : b(context, attributeSet, iArr, i5, i6)) {
            if (i7 != 0) {
                dVar.getTheme().applyStyle(i7, true);
            }
        }
        int iA = a(context, attributeSet);
        if (iA != 0) {
            dVar.getTheme().applyStyle(iA, true);
        }
        return dVar;
    }
}
