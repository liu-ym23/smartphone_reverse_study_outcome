package e3;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: e3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1412a implements InterfaceC1415d {

    /* renamed from: a, reason: collision with root package name */
    public final float f4341a;

    public C1412a(float f) {
        this.f4341a = f;
    }

    @Override // e3.InterfaceC1415d
    public final float a(RectF rectF) {
        return this.f4341a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1412a) && this.f4341a == ((C1412a) obj).f4341a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f4341a)});
    }

    public final String toString() {
        return androidx.compose.foundation.b.u(new StringBuilder(), "px", this.f4341a);
    }
}
