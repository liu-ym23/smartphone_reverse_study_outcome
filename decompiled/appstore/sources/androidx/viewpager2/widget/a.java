package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f5196b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayoutManager f5197a;

    /* JADX INFO: renamed from: androidx.viewpager2.widget.a$a, reason: collision with other inner class name */
    public class C0053a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f5198a;

        public C0053a(a r10) {
            this.f5198a = r10;
        }

        public int a(int[] r10, int[] r11) {
            return r10[0] - r11[0];
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((int[]) r10, (int[]) r11);
        }
    }

    static {
        ViewGroup.MarginLayoutParams r10 = new ViewGroup.MarginLayoutParams(-1, -1);
        f5196b = r10;
        r10.setMargins(0, 0, 0, 0);
    }

    public a(LinearLayoutManager r10) {
        this.f5197a = r10;
    }

    public static boolean c(View r10) {
        if ((r10 instanceof ViewGroup) == false) goto L15;
        ViewGroup r11 = (ViewGroup) r10;
        LayoutTransition r12 = r11.getLayoutTransition();
        if (r12 != null) goto L7;
    L9:
        int r13 = r11.getChildCount();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L15;
        if (c(r11.getChildAt(r14)) == true) goto L13;
        r14 = r14 + 1;
        goto L10
    L13:
        return true;
    L7:
        if (r12.isChangingLayout() == false) goto L9;
        return true;
    L15:
        return false;
    }

    public final boolean a() {
        int r10 = this.f5197a.getChildCount();
        if (r10 != 0) goto L6;
        return true;
    L6:
        if (this.f5197a.getOrientation() != 0) goto L8;
        boolean r11 = true;
    L9:
        int[][] r12 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r10, 2});
        int r13 = 0;
    L10:
        if (r13 >= r10) goto L30;
        View r14 = this.f5197a.getChildAt(r13);
        if (r14 == null) goto L29;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
    L17:
        int[] r17 = r12[r13];
        if (r11 == false) goto L21;
        int r18 = r14.getLeft();
        int r19 = r16.leftMargin;
    L22:
        r17[0] = r18 - r19;
        int[] r20 = r12[r13];
        if (r11 == false) goto L26;
        int r21 = r14.getRight();
        int r22 = r16.rightMargin;
    L27:
        r20[1] = r21 + r22;
        r13 = r13 + 1;
        goto L10
    L26:
        r21 = r14.getBottom();
        r22 = r16.bottomMargin;
        goto L27
    L21:
        r18 = r14.getTop();
        r19 = r16.topMargin;
        goto L22
    L16:
        r16 = f5196b;
        goto L17
    L29:
        throw new IllegalStateException("null view contained in the view hierarchy");
    L30:
        Arrays.sort(r12, new C0053a(this));
        int r110 = 1;
    L31:
        if (r110 >= r10) goto L36;
        if (r12[r110 - 1][1] != r12[r110][0]) goto L34;
        r110 = r110 + 1;
        goto L31
    L34:
        return false;
    L36:
        int[] r111 = r12[0];
        int r23 = r111[1];
        int r112 = r111[0];
        int r24 = r23 - r112;
        if (r112 <= 0) goto L39;
    L42:
        return false;
    L39:
        if (r12[r10 - 1][1] < r24) goto L42;
        return true;
    L8:
        r11 = false;
        goto L9
    }

    public final boolean b() {
        int r10 = this.f5197a.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (c(this.f5197a.getChildAt(r11)) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean d() {
        if (a() == false) goto L7;
        if (this.f5197a.getChildCount() <= 1) goto L7;
    L9:
        return false;
    L7:
        if (b() == false) goto L9;
        return true;
    }
}
