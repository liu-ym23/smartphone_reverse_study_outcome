package t1;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: t1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1110c implements InterfaceC1111d {

    /* renamed from: a, reason: collision with root package name */
    private final float f22320a;

    public C1110c(float f5) {
        this.f22320a = f5;
    }

    private static float b(RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // t1.InterfaceC1111d
    public float a(RectF rectF) {
        return B.a.a(this.f22320a, 0.0f, b(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1110c) && this.f22320a == ((C1110c) obj).f22320a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f22320a)});
    }
}
