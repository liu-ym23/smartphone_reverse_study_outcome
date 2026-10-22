package t1;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: t1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1108a implements InterfaceC1111d {

    /* renamed from: a, reason: collision with root package name */
    private final float f22317a;

    public C1108a(float f5) {
        this.f22317a = f5;
    }

    @Override // t1.InterfaceC1111d
    public float a(RectF rectF) {
        return this.f22317a;
    }

    public float b() {
        return this.f22317a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1108a) && this.f22317a == ((C1108a) obj).f22317a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f22317a)});
    }

    public String toString() {
        return b() + "px";
    }
}
