package r;

import androidx.compose.foundation.layout.LayoutWeightElement;

/* loaded from: classes.dex */
public interface s {
    static n0.m a() {
        if (1.0f > 0.0d) {
            return new LayoutWeightElement(1.0f);
        }
        throw new IllegalArgumentException("invalid weight 1.0; must be greater than zero".toString());
    }
}
