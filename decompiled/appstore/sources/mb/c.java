package mb;

import com.obric.common.oea.foundation.animation.token.Easing;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    public static final class a implements Easing {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22264a = null;

        static {
            f22264a = new a();
        }

        public a() {
        }

        @Override // com.obric.common.oea.foundation.animation.token.Easing
        public final float transform(float r10) {
            return r10;
        }
    }

    public static final mb.a a(Token$Easing r10) {
        q.g(r10, "$this$toCubicBezierEasing");
        if (r10.getValues().length != 4) goto L7;
        return new mb.a(r10.getValues()[0], r10.getValues()[1], r10.getValues()[2], r10.getValues()[3]);
    L7:
        throw new IllegalArgumentException("Easing values must contain exactly 4 floats for cubic bezier.");
    }

    public static final Easing b(Token$Easing r10) {
        q.g(r10, "$this$toLinearEasing");
        return a.f22264a;
    }
}
