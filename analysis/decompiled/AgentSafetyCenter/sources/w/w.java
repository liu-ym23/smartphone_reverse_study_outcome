package w;

import androidx.compose.foundation.layout.LayoutWeightElement;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final w f15059a = new w();

    public static w0.m a() {
        if (1.0f > 0.0d) {
            return new LayoutWeightElement(1.0f, true);
        }
        g5.f.s("invalid weight 1.0; must be greater than zero");
        return null;
    }
}
