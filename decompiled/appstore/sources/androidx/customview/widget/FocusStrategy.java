package androidx.customview.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public abstract class FocusStrategy {

    public interface BoundsAdapter<T> {
        void obtainBounds(T r10, Rect r11);
    }

    public interface CollectionAdapter<T, V> {
        V get(T r10, int r11);

        int size(T r10);
    }

    public static class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f2849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f2850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BoundsAdapter f2852d;

        public a(boolean r10, BoundsAdapter r11) {
            this.f2849a = new Rect();
            this.f2850b = new Rect();
            this.f2851c = r10;
            this.f2852d = r11;
        }

        @Override // java.util.Comparator
        public int compare(Object r10, Object r11) {
            Rect r12 = this.f2849a;
            Rect r13 = this.f2850b;
            this.f2852d.obtainBounds(r10, r12);
            this.f2852d.obtainBounds(r11, r13);
            int r14 = r12.top;
            int r15 = r13.top;
            if (r14 >= r15) goto L6;
            return -1;
        L6:
            if (r14 <= r15) goto L8;
            return 1;
        L8:
            int r16 = r12.left;
            int r17 = r13.left;
            if (r16 < r17) goto L11;
            if (r16 > r17) goto L16;
            int r18 = r12.bottom;
            int r19 = r13.bottom;
            if (r18 >= r19) goto L23;
            return -1;
        L23:
            if (r18 <= r19) goto L25;
            return 1;
        L25:
            int r20 = r12.right;
            int r21 = r13.right;
            if (r20 < r21) goto L28;
            if (r20 > r21) goto L33;
            return 0;
        L33:
            if (this.f2851c == false) goto L36;
            return -1;
        L36:
            return 1;
        L28:
            if (this.f2851c == true) goto L30;
            return -1;
        L30:
            return 1;
        L16:
            if (this.f2851c == false) goto L19;
            return -1;
        L19:
            return 1;
        L11:
            if (this.f2851c == true) goto L13;
            return -1;
        L13:
            return 1;
        }
    }

    public static boolean a(int r10, Rect r11, Rect r12, Rect r13) {
        boolean r14 = b(r10, r11, r12);
        if (b(r10, r11, r13) == true) goto L19;
        if (r14 == false) goto L19;
        if (j(r10, r11, r13) == true) goto L10;
        return true;
    L10:
        if (r10 != 17) goto L12;
    L18:
        return true;
    L12:
        if (r10 == 66) goto L18;
        if (k(r10, r11, r12) < m(r10, r11, r13)) goto L17;
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    public static boolean b(int r10, Rect r11, Rect r12) {
        if (r10 == 17) goto L20;
        if (r10 == 33) goto L14;
        if (r10 == 66) goto L20;
        if (r10 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        if (r12.right >= r11.left) goto L16;
        return false;
    L16:
        if (r12.left <= r11.right) goto L18;
        return false;
    L18:
        return true;
    L20:
        if (r12.bottom >= r11.top) goto L22;
        return false;
    L22:
        if (r12.top <= r11.bottom) goto L24;
        return false;
    L24:
        return true;
    }

    public static Object c(Object r10, CollectionAdapter r11, BoundsAdapter r12, Object r13, Rect r14, int r15) {
        Rect r16 = new Rect(r14);
        int r17 = 0;
        if (r15 != 17) goto L5;
        r16.offset(r14.width() + 1, 0);
    L16:
        int r18 = r11.size(r10);
        Rect r19 = new Rect();
        Object r20 = null;
    L17:
        if (r17 >= r18) goto L25;
        Object r21 = r11.get(r10, r17);
        if (r21 == r13) goto L24;
        r12.obtainBounds(r21, r19);
        if (h(r15, r14, r19, r16) == false) goto L24;
        r16.set(r19);
        r20 = r21;
    L24:
        r17 = r17 + 1;
        goto L17
    L25:
        return r20;
    L5:
        if (r15 != 33) goto L7;
        r16.offset(0, r14.height() + 1);
        goto L16
    L7:
        if (r15 != 66) goto L9;
        r16.offset(-(r14.width() + 1), 0);
        goto L16
    L9:
        if (r15 != 130) goto L12;
        r16.offset(0, -(r14.height() + 1));
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static Object d(Object r10, CollectionAdapter r11, BoundsAdapter r12, Object r13, int r14, boolean r15, boolean r16) {
        int r17 = r11.size(r10);
        ArrayList r18 = new ArrayList(r17);
        int r19 = 0;
    L3:
        if (r19 >= r17) goto L5;
        r18.add(r11.get(r10, r19));
        r19 = r19 + 1;
        goto L3
    L5:
        Collections.sort(r18, new a(r15, r12));
        if (r14 == 1) goto L14;
        if (r14 != 2) goto L12;
        return e(r13, r18, r16);
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    L14:
        return f(r13, r18, r16);
    }

    public static Object e(Object r10, ArrayList r11, boolean r12) {
        int r13 = r11.size();
        if (r10 != null) goto L5;
        int r14 = -1;
    L6:
        int r15 = r14 + 1;
        if (r15 < r13) goto L9;
        if (r12 == false) goto L14;
        if (r13 > 0) goto L13;
        return null;
    L13:
        return r11.get(0);
    L14:
        return null;
    L9:
        return r11.get(r15);
    L5:
        r14 = r11.lastIndexOf(r10);
        goto L6
    }

    public static Object f(Object r10, ArrayList r11, boolean r12) {
        int r13 = r11.size();
        if (r10 != null) goto L5;
        int r14 = r13;
    L6:
        int r15 = r14 - 1;
        if (r15 >= 0) goto L9;
        if (r12 == false) goto L14;
        if (r13 > 0) goto L13;
        return null;
    L13:
        return r11.get(r13 - 1);
    L14:
        return null;
    L9:
        return r11.get(r15);
    L5:
        r14 = r11.indexOf(r10);
        goto L6
    }

    public static int g(int r10, int r11) {
        return ((r10 * 13) * r10) + (r11 * r11);
    }

    public static boolean h(int r10, Rect r11, Rect r12, Rect r13) {
        if (i(r11, r12, r10) == true) goto L6;
        return false;
    L6:
        if (i(r11, r13, r10) == true) goto L9;
        return true;
    L9:
        if (a(r10, r11, r12, r13) == false) goto L12;
        return true;
    L12:
        if (a(r10, r11, r13, r12) == false) goto L15;
        return false;
    L15:
        if (g(k(r10, r11, r12), o(r10, r11, r12)) < g(k(r10, r11, r13), o(r10, r11, r13))) goto L17;
        return false;
    L17:
        return true;
    }

    public static boolean i(Rect r10, Rect r11, int r12) {
        if (r12 != 17) goto L5;
        int r13 = r10.right;
        int r14 = r11.right;
        if (r13 > r14) goto L41;
        if (r10.left >= r14) goto L41;
        return false;
    L41:
        if (r10.left > r11.left) goto L43;
        return false;
    L43:
        return true;
    L5:
        if (r12 != 33) goto L7;
        int r15 = r10.bottom;
        int r16 = r11.bottom;
        if (r15 > r16) goto L33;
        if (r10.top >= r16) goto L33;
        return false;
    L33:
        if (r10.top > r11.top) goto L35;
        return false;
    L35:
        return true;
    L7:
        if (r12 != 66) goto L9;
        int r17 = r10.left;
        int r18 = r11.left;
        if (r17 < r18) goto L25;
        if (r10.right <= r18) goto L25;
        return false;
    L25:
        if (r10.right < r11.right) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r12 != 130) goto L19;
        int r19 = r10.top;
        int r20 = r11.top;
        if (r19 < r20) goto L15;
        if (r10.bottom <= r20) goto L15;
        return false;
    L15:
        if (r10.bottom < r11.bottom) goto L17;
        return false;
    L17:
        return true;
    L19:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static boolean j(int r10, Rect r11, Rect r12) {
        if (r10 == 17) goto L25;
        if (r10 == 33) goto L21;
        if (r10 == 66) goto L17;
        if (r10 != 130) goto L15;
        if (r11.bottom <= r12.top) goto L13;
        return false;
    L13:
        return true;
    L15:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L17:
        if (r11.right <= r12.left) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (r11.top >= r12.bottom) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (r11.left >= r12.right) goto L27;
        return false;
    L27:
        return true;
    }

    public static int k(int r10, Rect r11, Rect r12) {
        return Math.max(0, l(r10, r11, r12));
    }

    public static int l(int r10, Rect r11, Rect r12) {
        if (r10 != 17) goto L5;
        int r13 = r11.left;
        int r14 = r12.right;
    L12:
        return r13 - r14;
    L5:
        if (r10 != 33) goto L7;
        r13 = r11.top;
        r14 = r12.bottom;
        goto L12
    L7:
        if (r10 != 66) goto L9;
        r13 = r12.left;
        r14 = r11.right;
        goto L12
    L9:
        if (r10 != 130) goto L14;
        r13 = r12.top;
        r14 = r11.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static int m(int r10, Rect r11, Rect r12) {
        return Math.max(1, n(r10, r11, r12));
    }

    public static int n(int r10, Rect r11, Rect r12) {
        if (r10 != 17) goto L5;
        int r13 = r11.left;
        int r14 = r12.left;
    L12:
        return r13 - r14;
    L5:
        if (r10 != 33) goto L7;
        r13 = r11.top;
        r14 = r12.top;
        goto L12
    L7:
        if (r10 != 66) goto L9;
        r13 = r12.right;
        r14 = r11.right;
        goto L12
    L9:
        if (r10 != 130) goto L14;
        r13 = r12.bottom;
        r14 = r11.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static int o(int r10, Rect r11, Rect r12) {
        if (r10 == 17) goto L16;
        if (r10 == 33) goto L14;
        if (r10 == 66) goto L16;
        if (r10 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        return Math.abs((r11.left + (r11.width() / 2)) - (r12.left + (r12.width() / 2)));
    L16:
        return Math.abs((r11.top + (r11.height() / 2)) - (r12.top + (r12.height() / 2)));
    }
}
