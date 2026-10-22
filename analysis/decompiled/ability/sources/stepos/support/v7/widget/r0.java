package stepos.support.v7.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f6628a = new HashMap();
    public TimeInterpolator b;
    public int c;
    public ValueAnimator d;
    public int e;
    public int f;
    public boolean g;

    public r0(StepOSRecyclerView stepOSRecyclerView) {
        new ArrayList();
        this.b = new LinearInterpolator();
        this.c = 500;
        this.e = 3;
        this.g = true;
    }
}
