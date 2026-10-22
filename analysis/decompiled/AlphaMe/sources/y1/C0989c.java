package y1;

import android.graphics.RectF;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.Arrays;

/* renamed from: y1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0989c implements InterfaceC0990d {

    /* renamed from: a, reason: collision with root package name */
    public final float f16199a;

    public C0989c(float f4) {
        this.f16199a = f4;
    }

    @Override // y1.InterfaceC0990d
    public final float a(RectF rectF) {
        return AbstractC0557a.n(this.f16199a, Property.DEFAULT_FLOAT_VALUE, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0989c) && this.f16199a == ((C0989c) obj).f16199a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f16199a)});
    }
}
