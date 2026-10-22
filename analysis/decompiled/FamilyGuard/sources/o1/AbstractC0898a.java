package o1;

import a1.C0409b;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;

/* renamed from: o1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0898a<V extends View> {

    /* renamed from: a, reason: collision with root package name */
    private final TimeInterpolator f19057a = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    protected final V f19058b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f19059c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f19060d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f19061e;

    public AbstractC0898a(V v5) {
        this.f19058b = v5;
        Context context = v5.getContext();
        this.f19059c = e.f(context, C0409b.f6738y, 300);
        this.f19060d = e.f(context, C0409b.f6692B, 150);
        this.f19061e = e.f(context, C0409b.f6691A, 100);
    }
}
