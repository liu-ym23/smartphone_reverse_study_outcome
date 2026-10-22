package e3;

import android.graphics.RectF;
import androidx.core.math.MathUtils;
import java.util.Arrays;

/* renamed from: e3.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1414c implements InterfaceC1415d {

    /* renamed from: a, reason: collision with root package name */
    public final float f4343a;

    public C1414c(float f) {
        this.f4343a = f;
    }

    @Override // e3.InterfaceC1415d
    public final float a(RectF rectF) {
        return MathUtils.clamp(this.f4343a, 0.0f, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1414c) && this.f4343a == ((C1414c) obj).f4343a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4343a)});
    }
}
