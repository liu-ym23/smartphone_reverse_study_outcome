package androidx.customview.widget;

import android.graphics.Rect;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes17.dex */
class FocusStrategy {

    public interface BoundsAdapter<T> {
        void obtainBounds(T r100, Rect r101);
    }

    public interface CollectionAdapter<T, V> {
        V get(T r100, int r101);

        int size(T r100);
    }

    public static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1;
        private final Rect mTemp2;

        public SequentialComparator(boolean r100, BoundsAdapter<T> r101) {
            this.mTemp1 = new Rect();
            this.mTemp2 = new Rect();
            this.mIsLayoutRtl = r100;
            this.mAdapter = r101;
        }

        @Override // java.util.Comparator
        public int compare(T r100, T r101) {
            Rect r102 = this.mTemp1;
            Rect r103 = this.mTemp2;
            this.mAdapter.obtainBounds(r100, r102);
            this.mAdapter.obtainBounds(r101, r103);
            int r104 = r102.top;
            int r105 = r103.top;
            if (r104 >= r105) goto L6;
            return -1;
        L6:
            if (r104 <= r105) goto L8;
            return 1;
        L8:
            int r106 = r102.left;
            int r107 = r103.left;
            if (r106 < r107) goto L11;
            if (r106 > r107) goto L16;
            int r108 = r102.bottom;
            int r109 = r103.bottom;
            if (r108 >= r109) goto L23;
            return -1;
        L23:
            if (r108 <= r109) goto L25;
            return 1;
        L25:
            int r110 = r102.right;
            int r111 = r103.right;
            if (r110 < r111) goto L28;
            if (r110 > r111) goto L33;
            return 0;
        L33:
            if (this.mIsLayoutRtl == true) goto L42;
            return 1;
        L42:
            return -1;
        L28:
            if (this.mIsLayoutRtl == false) goto L41;
            return 1;
        L41:
            return -1;
        L16:
            if (this.mIsLayoutRtl == true) goto L40;
            return 1;
        L40:
            return -1;
        L11:
            if (this.mIsLayoutRtl == false) goto L39;
            return 1;
        L39:
            return -1;
        }
    }

    private static int getWeightedDistanceFor(int r100, int r101) {
        return ((r100 * 13) * r100) + (r101 * r101);
    }

    private FocusStrategy() {
    }

    private static boolean beamsOverlap(int r100, Rect r101, Rect r102) {
        if (r100 == 17) goto L21;
        if (r100 == 33) goto L14;
        if (r100 == 66) goto L21;
        if (r100 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        if (r102.right >= r101.left) goto L16;
    L18:
        return false;
    L16:
        if (r102.left > r101.right) goto L18;
        return true;
    L21:
        if (r102.bottom >= r101.top) goto L23;
    L25:
        return false;
    L23:
        if (r102.top > r101.bottom) goto L25;
        return true;
    }

    private static <T> T getNextFocusable(T r100, ArrayList<T> r101, boolean r102) {
        int r103 = r101.size();
        if (r100 != null) goto L5;
        int r104 = -1;
    L6:
        int r105 = r104 + 1;
        if (r105 < r103) goto L9;
        if (r102 == false) goto L14;
        if (r103 > 0) goto L13;
        return null;
    L13:
        return (T) ListProtector.get(r101, 0);
    L14:
        return null;
    L9:
        return (T) ListProtector.get(r101, r105);
    L5:
        r104 = r101.lastIndexOf(r100);
        goto L6
    }

    private static <T> T getPreviousFocusable(T r100, ArrayList<T> r101, boolean r102) {
        int r103 = r101.size();
        if (r100 != null) goto L5;
        int r104 = r103;
    L6:
        int r105 = r104 - 1;
        if (r105 >= 0) goto L9;
        if (r102 == false) goto L14;
        if (r103 > 0) goto L13;
        return null;
    L13:
        return (T) ListProtector.get(r101, r103 - 1);
    L14:
        return null;
    L9:
        return (T) ListProtector.get(r101, r105);
    L5:
        r104 = r101.indexOf(r100);
        goto L6
    }

    private static boolean isCandidate(Rect r100, Rect r101, int r102) {
        if (r102 != 17) goto L5;
        int r103 = r100.right;
        int r104 = r101.right;
        if (r103 > r104) goto L44;
        if (r100.left >= r104) goto L44;
    L46:
        return false;
    L44:
        if (r100.left <= r101.left) goto L46;
        return true;
    L5:
        if (r102 != 33) goto L7;
        int r105 = r100.bottom;
        int r106 = r101.bottom;
        if (r105 > r106) goto L35;
        if (r100.top >= r106) goto L35;
    L37:
        return false;
    L35:
        if (r100.top <= r101.top) goto L37;
        return true;
    L7:
        if (r102 != 66) goto L9;
        int r107 = r100.left;
        int r108 = r101.left;
        if (r107 < r108) goto L26;
        if (r100.right <= r108) goto L26;
    L28:
        return false;
    L26:
        if (r100.right >= r101.right) goto L28;
        return true;
    L9:
        if (r102 != 130) goto L20;
        int r109 = r100.top;
        int r110 = r101.top;
        if (r109 < r110) goto L15;
        if (r100.bottom <= r110) goto L15;
    L17:
        return false;
    L15:
        if (r100.bottom >= r101.bottom) goto L17;
        return true;
    L20:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static boolean isToDirectionOf(int r100, Rect r101, Rect r102) {
        if (r100 == 17) goto L28;
        if (r100 == 33) goto L23;
        if (r100 == 66) goto L18;
        if (r100 != 130) goto L16;
        if (r101.bottom <= r102.top) goto L32;
        return false;
    L32:
        return true;
    L16:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L18:
        if (r101.right <= r102.left) goto L33;
        return false;
    L33:
        return true;
    L23:
        if (r101.top >= r102.bottom) goto L34;
        return false;
    L34:
        return true;
    L28:
        if (r101.left >= r102.right) goto L35;
        return false;
    L35:
        return true;
    }

    private static int majorAxisDistance(int r100, Rect r101, Rect r102) {
        return Math.max(0, majorAxisDistanceRaw(r100, r101, r102));
    }

    private static int majorAxisDistanceRaw(int r100, Rect r101, Rect r102) {
        if (r100 != 17) goto L5;
        int r103 = r101.left;
        int r104 = r102.right;
    L12:
        return r103 - r104;
    L5:
        if (r100 != 33) goto L7;
        r103 = r101.top;
        r104 = r102.bottom;
        goto L12
    L7:
        if (r100 != 66) goto L9;
        r103 = r102.left;
        r104 = r101.right;
        goto L12
    L9:
        if (r100 != 130) goto L14;
        r103 = r102.top;
        r104 = r101.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int majorAxisDistanceToFarEdge(int r100, Rect r101, Rect r102) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(r100, r101, r102));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int r100, Rect r101, Rect r102) {
        if (r100 != 17) goto L5;
        int r103 = r101.left;
        int r104 = r102.left;
    L12:
        return r103 - r104;
    L5:
        if (r100 != 33) goto L7;
        r103 = r101.top;
        r104 = r102.top;
        goto L12
    L7:
        if (r100 != 66) goto L9;
        r103 = r102.right;
        r104 = r101.right;
        goto L12
    L9:
        if (r100 != 130) goto L14;
        r103 = r102.bottom;
        r104 = r101.bottom;
        goto L12
    L14:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int minorAxisDistance(int r100, Rect r101, Rect r102) {
        if (r100 == 17) goto L16;
        if (r100 == 33) goto L14;
        if (r100 == 66) goto L16;
        if (r100 == 130) goto L14;
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L14:
        return Math.abs((r101.left + (r101.width() / 2)) - (r102.left + (r102.width() / 2)));
    L16:
        return Math.abs((r101.top + (r101.height() / 2)) - (r102.top + (r102.height() / 2)));
    }

    private static boolean beamBeats(int r100, Rect r101, Rect r102, Rect r103) {
        boolean r104 = beamsOverlap(r100, r101, r102);
        if (beamsOverlap(r100, r101, r103) == true) goto L19;
        if (r104 == false) goto L19;
        if (isToDirectionOf(r100, r101, r103) == true) goto L10;
        return true;
    L10:
        if (r100 != 17) goto L12;
    L18:
        return true;
    L12:
        if (r100 == 66) goto L18;
        if (majorAxisDistance(r100, r101, r102) >= majorAxisDistanceToFarEdge(r100, r101, r103)) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    }

    private static boolean isBetterCandidate(int r100, Rect r101, Rect r102, Rect r103) {
        if (isCandidate(r101, r102, r100) == true) goto L6;
        return false;
    L6:
        if (isCandidate(r101, r103, r100) == true) goto L9;
        return true;
    L9:
        if (beamBeats(r100, r101, r102, r103) == false) goto L12;
        return true;
    L12:
        if (beamBeats(r100, r101, r103, r102) == false) goto L15;
        return false;
    L15:
        if (getWeightedDistanceFor(majorAxisDistance(r100, r101, r102), minorAxisDistance(r100, r101, r102)) >= getWeightedDistanceFor(majorAxisDistance(r100, r101, r103), minorAxisDistance(r100, r101, r103))) goto L18;
        return true;
    L18:
        return false;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(L r100, CollectionAdapter<L, T> r101, BoundsAdapter<T> r102, T r110, Rect r111, int r112) {
        Rect r103 = new Rect(r111);
        int r104 = 0;
        if (r112 != 17) goto L5;
        r103.offset(r111.width() + 1, 0);
    L16:
        int r105 = r101.size(r100);
        Rect r106 = new Rect();
        T r107 = null;
    L17:
        if (r104 >= r105) goto L25;
        T r108 = r101.get(r100, r104);
        if (r108 == r110) goto L24;
        r102.obtainBounds(r108, r106);
        if (isBetterCandidate(r112, r111, r106, r103) == false) goto L24;
        r103.set(r106);
        r107 = r108;
    L24:
        r104 = r104 + 1;
        goto L17
    L25:
        return r107;
    L5:
        if (r112 != 33) goto L7;
        r103.offset(0, r111.height() + 1);
        goto L16
    L7:
        if (r112 != 66) goto L9;
        r103.offset(-(r111.width() + 1), 0);
        goto L16
    L9:
        if (r112 != 130) goto L12;
        r103.offset(0, -(r111.height() + 1));
        goto L16
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    public static <L, T> T findNextFocusInRelativeDirection(L r100, CollectionAdapter<L, T> r101, BoundsAdapter<T> r102, T r103, int r104, boolean r105, boolean r110) {
        int r106 = r101.size(r100);
        ArrayList r107 = new ArrayList(r106);
        int r108 = 0;
    L3:
        if (r108 >= r106) goto L5;
        r107.add(r101.get(r100, r108));
        r108 = r108 + 1;
        goto L3
    L5:
        Collections.sort(r107, new SequentialComparator(r105, r102));
        if (r104 == 1) goto L14;
        if (r104 != 2) goto L12;
        return (T) getNextFocusable(r103, r107, r110);
    L12:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    L14:
        return (T) getPreviousFocusable(r103, r107, r110);
    }
}
