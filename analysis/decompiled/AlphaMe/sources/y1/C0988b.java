package y1;

import android.graphics.RectF;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;

/* renamed from: y1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0988b implements InterfaceC0990d {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0990d f16197a;

    /* renamed from: b, reason: collision with root package name */
    public final float f16198b;

    public C0988b(float f4, InterfaceC0990d interfaceC0990d) {
        while (interfaceC0990d instanceof C0988b) {
            interfaceC0990d = ((C0988b) interfaceC0990d).f16197a;
            f4 += ((C0988b) interfaceC0990d).f16198b;
        }
        this.f16197a = interfaceC0990d;
        this.f16198b = f4;
    }

    @Override // y1.InterfaceC0990d
    public final float a(RectF rectF) {
        return Math.max(Property.DEFAULT_FLOAT_VALUE, this.f16197a.a(rectF) + this.f16198b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0988b)) {
            return false;
        }
        C0988b c0988b = (C0988b) obj;
        return this.f16197a.equals(c0988b.f16197a) && this.f16198b == c0988b.f16198b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f16197a, Float.valueOf(this.f16198b)});
    }
}
