package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f11735b;

    /* renamed from: a, reason: collision with root package name */
    private LinearLayoutManager f11736a;

    /* renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    class C0152a implements Comparator<int[]> {
        C0152a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f11735b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.f11736a = linearLayoutManager;
    }

    private boolean a() {
        int top;
        int i5;
        int bottom;
        int i6;
        int childCount = this.f11736a.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z5 = this.f11736a.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, childCount, 2);
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = this.f11736a.getChildAt(i7);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f11735b;
            int[] iArr2 = iArr[i7];
            if (z5) {
                top = childAt.getLeft();
                i5 = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i5 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i5;
            int[] iArr3 = iArr[i7];
            if (z5) {
                bottom = childAt.getRight();
                i6 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i6 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i6;
        }
        Arrays.sort(iArr, new C0152a());
        for (int i8 = 1; i8 < childCount; i8++) {
            if (iArr[i8 - 1][1] != iArr[i8][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i9 = iArr4[1];
        int i10 = iArr4[0];
        return i10 <= 0 && iArr[childCount - 1][1] >= i9 - i10;
    }

    private boolean b() {
        int childCount = this.f11736a.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (c(this.f11736a.getChildAt(i5))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                if (c(viewGroup.getChildAt(i5))) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean d() {
        return (!a() || this.f11736a.getChildCount() <= 1) && b();
    }
}
