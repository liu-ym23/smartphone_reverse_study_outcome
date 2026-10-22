package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap<Pair<Integer, Integer>, String> f12230f;

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap<String, String> f12231g;

    /* renamed from: a, reason: collision with root package name */
    public final MotionLayout f12232a;

    /* renamed from: b, reason: collision with root package name */
    public String f12233b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f12234c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f12235d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f12236e = -1;

    static {
        HashMap<Pair<Integer, Integer>, String> map = new HashMap<>();
        f12230f = map;
        HashMap<String, String> map2 = new HashMap<>();
        f12231g = map2;
        map.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        map.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        map.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        map.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        map.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        map.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        map.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        map.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        map.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        map.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        map.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        map.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        map.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        map2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        map2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        map2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        map2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        map2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        map2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        map2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        map2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        map2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        map2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        map2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        map2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public b(MotionLayout motionLayout) {
        this.f12232a = motionLayout;
    }
}
