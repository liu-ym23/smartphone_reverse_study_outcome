package androidx.customview.widget;

import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: FocusStrategy.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: compiled from: FocusStrategy.java */
    public interface a<T> {
        void a(T r1, Rect r2);
    }

    /* JADX INFO: renamed from: androidx.customview.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FocusStrategy.java */
    public interface InterfaceC0046b<T, V> {
        int a(T r1);

        V a(T r1, int r2);
    }

    /* JADX INFO: compiled from: FocusStrategy.java */
    private static class c<T> implements Comparator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f1556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f1557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f1558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final a<T> f1559d;

        c(boolean r3, a<T> r4) {
            a<T> r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
            this.f1556a = new Rect();
            this.f1557b = new Rect();
            this.f1558c = r3;
            this.f1559d = r5;
        }

        @Override // java.util.Comparator
        public int compare(T r5, T r6) {
            Rect r0 = this.f1556a;
            Rect r1 = this.f1557b;
            this.f1559d.a(r5, r0);
            this.f1559d.a(r6, r1);
            if (r0.top >= r1.top) goto L6;
            return -1;
        L6:
            if (r0.top <= r1.top) goto L9;
            return 1;
        L9:
            if (r0.left >= r1.left) goto L15;
            if (this.f1558c == true) goto L13;
            return -1;
        L13:
            return 1;
        L15:
            if (r0.left <= r1.left) goto L22;
            if (this.f1558c == false) goto L20;
            return -1;
        L20:
            return 1;
        L22:
            if (r0.bottom >= r1.bottom) goto L25;
            return -1;
        L25:
            if (r0.bottom <= r1.bottom) goto L28;
            return 1;
        L28:
            if (r0.right >= r1.right) goto L34;
            if (this.f1558c == true) goto L32;
            return -1;
        L32:
            return 1;
        L34:
            if (r0.right > r1.right) goto L36;
            return 0;
        L36:
            if (this.f1558c == false) goto L39;
            return -1;
        L39:
            return 1;
        }
    }

    private static int a(int r1, int r2) {
        return ((r1 * 13) * r1) + (r2 * r2);
    }

    public static <L, T> T a(L r4, InterfaceC0046b<L, T> r5, a<T> r6, T r7, int r8, boolean r9, boolean r10) {
        InterfaceC0046b r11 = (InterfaceC0046b) ZeusTransformUtils.wrapperContextForParams(r5, InterfaceC0046b.class, "com.obric.aiagent.plugin");
        a r12 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        int r0 = r11.a(r4);
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1.add(r11.a(r4, r2));
        r2 = r2 + 1;
        goto L3
    L5:
        Collections.sort(r1, new c(r9, r12));
        if (r8 == 1) goto L14;
        if (r8 != 2) goto L12;
        return (T) a(r7, r1, r10);
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    L14:
        return (T) b(r7, r1, r10);
    }

    private static <T> T a(T r1, ArrayList<T> r2, boolean r3) {
        int r0 = r2.size();
        if (r1 != null) goto L5;
        int r4 = -1;
    L6:
        int r5 = r4 + 1;
        if (r5 < r0) goto L9;
        if (r3 == false) goto L14;
        if (r0 > 0) goto L13;
        return null;
    L13:
        return r2.get(0);
    L14:
        return null;
    L9:
        return r2.get(r5);
    L5:
        r4 = r2.lastIndexOf(r1);
        goto L6
    }

    private static <T> T b(T r1, ArrayList<T> r2, boolean r3) {
        int r0 = r2.size();
        if (r1 != null) goto L5;
        int r4 = r0;
    L6:
        int r5 = r4 - 1;
        if (r5 >= 0) goto L9;
        if (r3 == false) goto L14;
        if (r0 > 0) goto L13;
        return null;
    L13:
        return r2.get(r0 - 1);
    L14:
        return null;
    L9:
        return r2.get(r5);
    L5:
        r4 = r2.indexOf(r1);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L, T> T a(L r7, InterfaceC0046b<L, T> r8, a<T> r9, T r10, Rect r11, int r12) {
        InterfaceC0046b r13 = (InterfaceC0046b) ZeusTransformUtils.wrapperContextForParams(r8, InterfaceC0046b.class, "com.obric.aiagent.plugin");
        a r14 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.aiagent.plugin");
        Rect r0 = new Rect(r11);
        int r2 = 0;
        if (r12 != 17) goto L5;
        r0.offset(r11.width() + 1, 0);
    L16:
        T r1 = null;
        int r3 = r13.a(r7);
        Rect r4 = new Rect();
    L17:
        if (r2 >= r3) goto L25;
        Object r5 = r13.a(r7, r2);
        if (r5 == r10) goto L24;
        r14.a(r5, r4);
        if (a(r12, r11, r4, r0) == false) goto L24;
        r0.set(r4);
        r1 = (T) r5;
    L24:
        r2 = r2 + 1;
        goto L17
    L25:
        return r1;
    L5:
        if (r12 != 33) goto L7;
        r0.offset(0, r11.height() + 1);
        goto L16
    L7:
        if (r12 != 66) goto L9;
        r0.offset(-(r11.width() + 1), 0);
        goto L16
    L9:
        if (r12 != 130) goto L12;
        r0.offset(0, -(r11.height() + 1));
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static boolean a(int r3, Rect r4, Rect r5, Rect r6) {
        if (a(r4, r5, r3) == true) goto L6;
        return false;
    L6:
        if (a(r4, r6, r3) == true) goto L9;
        return true;
    L9:
        if (b(r3, r4, r5, r6) == false) goto L12;
        return true;
    L12:
        if (b(r3, r4, r6, r5) == false) goto L15;
        return false;
    L15:
        if (a(c(r3, r4, r5), g(r3, r4, r5)) < a(c(r3, r4, r6), g(r3, r4, r6))) goto L17;
        return false;
    L17:
        return true;
    }

    private static boolean b(int r3, Rect r4, Rect r5, Rect r6) {
        boolean r0 = a(r3, r4, r5);
        if (a(r3, r4, r6) == true) goto L19;
        if (r0 == false) goto L19;
        if (b(r3, r4, r6) == true) goto L10;
        return true;
    L10:
        if (r3 != 17) goto L12;
    L18:
        return true;
    L12:
        if (r3 == 66) goto L18;
        if (c(r3, r4, r5) < e(r3, r4, r6)) goto L17;
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    private static boolean a(Rect r3, Rect r4, int r5) {
        if (r5 == 17) goto L40;
        if (r5 == 33) goto L31;
        if (r5 == 66) goto L22;
        if (r5 != 130) goto L20;
        if (r3.top < r4.top) goto L15;
        if (r3.bottom <= r4.top) goto L15;
    L18:
        return false;
    L15:
        if (r3.bottom >= r4.bottom) goto L18;
        return true;
    L20:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L22:
        if (r3.left < r4.left) goto L26;
        if (r3.right <= r4.left) goto L26;
    L29:
        return false;
    L26:
        if (r3.right >= r4.right) goto L29;
        return true;
    L31:
        if (r3.bottom > r4.bottom) goto L35;
        if (r3.top >= r4.bottom) goto L35;
    L38:
        return false;
    L35:
        if (r3.top <= r4.top) goto L38;
        return true;
    L40:
        if (r3.right > r4.right) goto L44;
        if (r3.left >= r4.right) goto L44;
    L47:
        return false;
    L44:
        if (r3.left <= r4.left) goto L47;
        return true;
    }

    private static boolean a(int r3, Rect r4, Rect r5) {
        if (r3 == 17) goto L21;
        if (r3 == 33) goto L14;
        if (r3 == 66) goto L21;
        if (r3 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        if (r5.right < r4.left) goto L19;
        if (r5.left > r4.right) goto L19;
        return true;
    L19:
        return false;
    L21:
        if (r5.bottom < r4.top) goto L26;
        if (r5.top > r4.bottom) goto L26;
        return true;
    L26:
        return false;
    }

    private static boolean b(int r3, Rect r4, Rect r5) {
        if (r3 == 17) goto L28;
        if (r3 == 33) goto L23;
        if (r3 == 66) goto L18;
        if (r3 != 130) goto L16;
        if (r4.bottom > r5.top) goto L14;
        return true;
    L14:
        return false;
    L16:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L18:
        if (r4.right > r5.left) goto L21;
        return true;
    L21:
        return false;
    L23:
        if (r4.top < r5.bottom) goto L26;
        return true;
    L26:
        return false;
    L28:
        if (r4.left < r5.right) goto L31;
        return true;
    L31:
        return false;
    }

    private static int c(int r0, Rect r1, Rect r2) {
        return Math.max(0, d(r0, r1, r2));
    }

    private static int d(int r1, Rect r2, Rect r3) {
        if (r1 != 17) goto L5;
        int r4 = r2.left;
        int r5 = r3.right;
    L12:
        return r4 - r5;
    L5:
        if (r1 != 33) goto L7;
        r4 = r2.top;
        r5 = r3.bottom;
        goto L12
    L7:
        if (r1 != 66) goto L9;
        r4 = r3.left;
        r5 = r2.right;
        goto L12
    L9:
        if (r1 != 130) goto L14;
        r4 = r3.top;
        r5 = r2.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int e(int r0, Rect r1, Rect r2) {
        return Math.max(1, f(r0, r1, r2));
    }

    private static int f(int r1, Rect r2, Rect r3) {
        if (r1 != 17) goto L5;
        int r4 = r2.left;
        int r5 = r3.left;
    L12:
        return r4 - r5;
    L5:
        if (r1 != 33) goto L7;
        r4 = r2.top;
        r5 = r3.top;
        goto L12
    L7:
        if (r1 != 66) goto L9;
        r4 = r3.right;
        r5 = r2.right;
        goto L12
    L9:
        if (r1 != 130) goto L14;
        r4 = r3.bottom;
        r5 = r2.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int g(int r1, Rect r2, Rect r3) {
        if (r1 == 17) goto L16;
        if (r1 == 33) goto L14;
        if (r1 == 66) goto L16;
        if (r1 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        return Math.abs((r2.left + (r2.width() / 2)) - (r3.left + (r3.width() / 2)));
    L16:
        return Math.abs((r2.top + (r2.height() / 2)) - (r3.top + (r3.height() / 2)));
    }
}
