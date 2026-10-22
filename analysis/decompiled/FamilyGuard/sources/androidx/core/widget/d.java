package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final EdgeEffect f9896a;

    private static class a {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f5, float f6) {
            try {
                return edgeEffect.onPullDistance(f5, f6);
            } catch (Throwable unused) {
                edgeEffect.onPull(f5, f6);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public d(Context context) {
        this.f9896a = new EdgeEffect(context);
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        return a.a(context, attributeSet);
    }

    public static float b(EdgeEffect edgeEffect) {
        return a.b(edgeEffect);
    }

    public static float d(EdgeEffect edgeEffect, float f5, float f6) {
        return a.c(edgeEffect, f5, f6);
    }

    @Deprecated
    public boolean c(float f5) {
        this.f9896a.onPull(f5);
        return true;
    }

    @Deprecated
    public boolean e() {
        this.f9896a.onRelease();
        return this.f9896a.isFinished();
    }
}
