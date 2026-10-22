package butterknife;

import android.util.Property;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class ViewCollections {
    private ViewCollections() {
    }

    @SafeVarargs
    public static <T extends View> void run(List<T> r100, Action<? super T>... r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        int r104 = r101.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L7;
        r101[r105].apply((View) ListProtector.get(r100, r103), r103);
        r105 = r105 + 1;
        goto L5
    L7:
        r103 = r103 + 1;
        goto L3
    }

    @SafeVarargs
    public static <T extends View> void run(T[] r100, Action<? super T>... r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        int r104 = r101.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L7;
        r101[r105].apply(r100[r103], r103);
        r105 = r105 + 1;
        goto L5
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public static <T extends View> void run(List<T> r100, Action<? super T> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.apply((View) ListProtector.get(r100, r103), r103);
        r103 = r103 + 1;
        goto L3
    }

    @SafeVarargs
    public static <T extends View> void run(T r100, Action<? super T>... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101[r103].apply(r100, 0);
        r103 = r103 + 1;
        goto L3
    }

    public static <T extends View> void run(T[] r100, Action<? super T> r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.apply(r100[r103], r103);
        r103 = r103 + 1;
        goto L3
    }

    public static <T extends View> void run(T r100, Action<? super T> r101) {
        r101.apply(r100, 0);
    }

    public static <T extends View, V> void set(List<T> r100, Setter<? super T, V> r101, V r102) {
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.set((View) ListProtector.get(r100, r104), r102, r104);
        r104 = r104 + 1;
        goto L3
    }

    public static <T extends View, V> void set(List<T> r100, Property<? super T, V> r101, V r102) {
        int r103 = r100.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.set((Object) ListProtector.get(r100, r104), r102);
        r104 = r104 + 1;
        goto L3
    }

    public static <T extends View, V> void set(T[] r100, Property<? super T, V> r101, V r102) {
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.set(r100[r104], r102);
        r104 = r104 + 1;
        goto L3
    }

    public static <T extends View, V> void set(T[] r100, Setter<? super T, V> r101, V r102) {
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.set(r100[r104], r102, r104);
        r104 = r104 + 1;
        goto L3
    }

    public static <T extends View, V> void set(T r100, Setter<? super T, V> r101, V r102) {
        r101.set(r100, r102, 0);
    }

    public static <T extends View, V> void set(T r100, Property<? super T, V> r101, V r102) {
        r101.set(r100, r102);
    }
}
