package kb;

import com.obric.common.oea.foundation.animation.spec.spring.b;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final b a(float r10, float r11, int r12) {
        return new b(r10, r11, r12, 0.0f, 8, null);
    }

    public static final b b(Token$Bounce r10, Token$Duration r11, int r12) {
        q.g(r10, "bounce");
        q.g(r11, "duration");
        return new b(r10.getDampingRatio(), r11.getStiffness(), r12, 0.0f, 8, null);
    }

    public static /* synthetic */ b c(float r10, float r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 1.0f;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = 1500.0f;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = 0;
    L12:
        return a(r10, r11, r12);
    }

    public static /* synthetic */ b d(Token$Bounce r10, Token$Duration r11, int r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = 0;
    L6:
        return b(r10, r11, r12);
    }

    public static final lb.a e(Token$Duration r10, Token$Delay r11, Token$Easing r12) {
        q.g(r10, "duration");
        q.g(r11, "delay");
        q.g(r12, "easing");
        return new lb.a(r10.getDuration(), r11.getValue(), r12);
    }
}
