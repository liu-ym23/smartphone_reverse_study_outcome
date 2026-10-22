package t1;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: t1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1109b implements InterfaceC1111d {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC1111d f22318a;

    /* renamed from: b, reason: collision with root package name */
    private final float f22319b;

    public C1109b(float f5, InterfaceC1111d interfaceC1111d) {
        while (interfaceC1111d instanceof C1109b) {
            interfaceC1111d = ((C1109b) interfaceC1111d).f22318a;
            f5 += ((C1109b) interfaceC1111d).f22319b;
        }
        this.f22318a = interfaceC1111d;
        this.f22319b = f5;
    }

    @Override // t1.InterfaceC1111d
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f22318a.a(rectF) + this.f22319b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1109b)) {
            return false;
        }
        C1109b c1109b = (C1109b) obj;
        return this.f22318a.equals(c1109b.f22318a) && this.f22319b == c1109b.f22319b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f22318a, Float.valueOf(this.f22319b)});
    }
}
