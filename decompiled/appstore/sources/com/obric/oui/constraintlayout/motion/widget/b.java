package com.obric.oui.constraintlayout.motion.widget;

import android.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f13637f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap f13638g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f13639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13643e;

    static {
        HashMap r10 = new HashMap();
        f13637f = r10;
        HashMap r11 = new HashMap();
        f13638g = r11;
        r10.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r10.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r10.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r10.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r10.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r10.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r10.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r10.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r10.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r10.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r10.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r10.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r10.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r11.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r11.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r11.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r11.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r11.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r11.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r11.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r11.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r11.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r11.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r11.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r11.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public b(MotionLayout r10) {
        this.f13640b = null;
        this.f13641c = null;
        this.f13642d = -1;
        this.f13643e = -1;
        this.f13639a = r10;
    }
}
