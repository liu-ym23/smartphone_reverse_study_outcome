package stepos.support.v7.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f15088a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public TimeInterpolator f15089b;

    /* renamed from: c, reason: collision with root package name */
    public int f15090c;

    /* renamed from: d, reason: collision with root package name */
    public ValueAnimator f15091d;

    /* renamed from: e, reason: collision with root package name */
    public int f15092e;

    /* renamed from: f, reason: collision with root package name */
    public int f15093f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15094g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f15095h;

    public j0(StepOSRecyclerView stepOSRecyclerView) {
        this.f15095h = stepOSRecyclerView;
        new ArrayList();
        this.f15089b = new LinearInterpolator();
        this.f15090c = 500;
        this.f15092e = 3;
        this.f15094g = true;
    }
}
