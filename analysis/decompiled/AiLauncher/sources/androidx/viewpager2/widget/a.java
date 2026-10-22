package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f15134b;

    /* renamed from: a, reason: collision with root package name */
    public LinearLayoutManager f15135a;

    /* renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    public class C0188a implements Comparator<int[]> {
        public C0188a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f15134b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public a(LinearLayoutManager linearLayoutManager) {
        this.f15135a = linearLayoutManager;
    }

    public static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean a() {
        int top;
        int i10;
        int bottom;
        int i11;
        int childCount = this.f15135a.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z10 = this.f15135a.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, childCount, 2);
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = this.f15135a.getChildAt(i12);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f15134b;
            int[] iArr2 = iArr[i12];
            if (z10) {
                top = childAt.getLeft();
                i10 = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i10 = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i10;
            int[] iArr3 = iArr[i12];
            if (z10) {
                bottom = childAt.getRight();
                i11 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i11 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i11;
        }
        Arrays.sort(iArr, new C0188a());
        for (int i13 = 1; i13 < childCount; i13++) {
            if (iArr[i13 - 1][1] != iArr[i13][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i14 = iArr4[1];
        int i15 = iArr4[0];
        return i15 <= 0 && iArr[childCount - 1][1] >= i14 - i15;
    }

    public final boolean b() {
        int childCount = this.f15135a.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (c(this.f15135a.getChildAt(i10))) {
                return true;
            }
        }
        return false;
    }

    public boolean d() {
        return (!a() || this.f15135a.getChildCount() <= 1) && b();
    }
}
