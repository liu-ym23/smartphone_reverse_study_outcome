package r;

import androidx.compose.foundation.layout.LayoutWeightElement;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f8876a = new j0();

    public static n0.m a() {
        if (1.0f > 0.0d) {
            return new LayoutWeightElement(1.0f);
        }
        throw new IllegalArgumentException("invalid weight 1.0; must be greater than zero".toString());
    }
}
