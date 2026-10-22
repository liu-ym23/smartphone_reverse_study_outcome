package T2;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import b.C1423c;
import com.google.android.material.R$attr;
import com.stepos.ailauncher.chat.wake.circle.F;

/* loaded from: classes2.dex */
public abstract class a<V extends View> {

    /* renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f5844a = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);

    /* renamed from: b, reason: collision with root package name */
    public final V f5845b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5846c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5847d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5848e;

    /* renamed from: f, reason: collision with root package name */
    public C1423c f5849f;

    public a(V v10) {
        this.f5845b = v10;
        Context context = v10.getContext();
        this.f5846c = h.f(context, R$attr.motionDurationMedium2, 300);
        this.f5847d = h.f(context, R$attr.motionDurationShort3, F.GESTURE_HEIGHT_DP);
        this.f5848e = h.f(context, R$attr.motionDurationShort2, 100);
    }

    public float a(float f10) {
        return this.f5844a.getInterpolation(f10);
    }

    public C1423c b() {
        if (this.f5849f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        C1423c c1423c = this.f5849f;
        this.f5849f = null;
        return c1423c;
    }

    public C1423c c() {
        C1423c c1423c = this.f5849f;
        this.f5849f = null;
        return c1423c;
    }

    public void d(C1423c c1423c) {
        this.f5849f = c1423c;
    }

    public C1423c e(C1423c c1423c) {
        if (this.f5849f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        C1423c c1423c2 = this.f5849f;
        this.f5849f = c1423c;
        return c1423c2;
    }
}
