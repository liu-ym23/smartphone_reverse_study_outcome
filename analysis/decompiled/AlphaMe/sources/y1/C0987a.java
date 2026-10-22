package y1;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: y1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0987a implements InterfaceC0990d {

    /* renamed from: a, reason: collision with root package name */
    public final float f16196a;

    public C0987a(float f4) {
        this.f16196a = f4;
    }

    @Override // y1.InterfaceC0990d
    public final float a(RectF rectF) {
        return this.f16196a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0987a) && this.f16196a == ((C0987a) obj).f16196a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f16196a)});
    }

    public final String toString() {
        return this.f16196a + "px";
    }
}
