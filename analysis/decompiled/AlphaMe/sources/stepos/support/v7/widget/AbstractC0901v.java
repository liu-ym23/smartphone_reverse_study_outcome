package stepos.support.v7.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import c0.C0386a;
import c0.C0387b;
import c0.C0388c;
import com.stepos.alphame.utils.Property;

/* renamed from: stepos.support.v7.widget.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0901v {

    /* renamed from: a, reason: collision with root package name */
    public static final C0386a f15154a;

    /* renamed from: b, reason: collision with root package name */
    public static final C0388c f15155b;

    /* renamed from: c, reason: collision with root package name */
    public static final Interpolator f15156c;

    /* renamed from: d, reason: collision with root package name */
    public static final Interpolator f15157d;

    static {
        new LinearInterpolator();
        new C0387b();
        f15154a = new C0386a();
        f15155b = new C0388c();
        new DecelerateInterpolator();
        new AccelerateDecelerateInterpolator();
        M.a.b(Property.DEFAULT_FLOAT_VALUE, 0.33f, 0.1f, 1.0f);
        M.a.b(Property.DEFAULT_FLOAT_VALUE, 0.66f, 0.66f, 1.0f);
        f15156c = M.a.b(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0.6f, 1.0f);
        f15157d = M.a.b(0.4f, Property.DEFAULT_FLOAT_VALUE, 0.4f, 1.0f);
    }
}
