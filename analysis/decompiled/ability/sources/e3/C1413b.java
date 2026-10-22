package e3;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: e3.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1413b implements InterfaceC1415d {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1415d f4342a;
    public final float b;

    public C1413b(float f, InterfaceC1415d interfaceC1415d) {
        while (interfaceC1415d instanceof C1413b) {
            interfaceC1415d = ((C1413b) interfaceC1415d).f4342a;
            f += ((C1413b) interfaceC1415d).b;
        }
        this.f4342a = interfaceC1415d;
        this.b = f;
    }

    @Override // e3.InterfaceC1415d
    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f4342a.a(rectF) + this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1413b)) {
            return false;
        }
        C1413b c1413b = (C1413b) obj;
        return this.f4342a.equals(c1413b.f4342a) && this.b == c1413b.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4342a, Float.valueOf(this.b)});
    }
}
