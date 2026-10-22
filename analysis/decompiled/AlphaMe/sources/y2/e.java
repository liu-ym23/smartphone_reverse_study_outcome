package y2;

import com.stepos.alphame.utils.Consts;
import com.stepos.alphame.utils.Property;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final float f16340a = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public final float f16341b = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public final float f16342c = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public final float f16343d = 1.0f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Float.floatToRawIntBits(this.f16343d) == Float.floatToRawIntBits(eVar.f16343d) && Float.floatToRawIntBits(this.f16340a) == Float.floatToRawIntBits(eVar.f16340a) && Float.floatToRawIntBits(this.f16341b) == Float.floatToRawIntBits(eVar.f16341b) && Float.floatToRawIntBits(this.f16342c) == Float.floatToRawIntBits(eVar.f16342c);
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f16342c) + ((Float.floatToRawIntBits(this.f16341b) + ((Float.floatToRawIntBits(this.f16340a) + ((Float.floatToRawIntBits(this.f16343d) + 31) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "[" + this.f16340a + Consts.SPLITTER_DETAIL + this.f16341b + Consts.SPLITTER_DETAIL + this.f16342c + Consts.SPLITTER_DETAIL + this.f16343d + "]";
    }
}
