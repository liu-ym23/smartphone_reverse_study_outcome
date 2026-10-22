package androidx.graphics.shapes;

import D7.F;
import H4.o;
import androidx.collection.FloatList;
import g1.AbstractC1451a;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u000b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "progress", "progressFrom", "progressTo", "", "progressInRange", "(FFF)Z", "Landroidx/collection/FloatList;", "xValues", "yValues", "x", "linearMap", "(Landroidx/collection/FloatList;Landroidx/collection/FloatList;F)F", "p", "LC7/r;", "validateProgress", "(Landroidx/collection/FloatList;)V", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatMappingKt {
    public static final float linearMap(FloatList xValues, FloatList yValues, float f) {
        k.f(xValues, "xValues");
        k.f(yValues, "yValues");
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f).toString());
        }
        Iterator it = AbstractC1451a.X(0, xValues._size).iterator();
        while (it.hasNext()) {
            int iNextInt = ((F) it).nextInt();
            int i = iNextInt + 1;
            if (progressInRange(f, xValues.get(iNextInt), xValues.get(i % xValues.getSize()))) {
                int size = i % xValues.getSize();
                float fPositiveModulo = Utils.positiveModulo(xValues.get(size) - xValues.get(iNextInt), 1.0f);
                return Utils.positiveModulo((Utils.positiveModulo(yValues.get(size) - yValues.get(iNextInt), 1.0f) * (fPositiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f - xValues.get(iNextInt), 1.0f) / fPositiveModulo)) + yValues.get(iNextInt), 1.0f);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final boolean progressInRange(float f, float f7, float f9) {
        return f9 >= f7 ? f7 <= f && f <= f9 : f >= f7 || f <= f9;
    }

    public static final void validateProgress(FloatList p) {
        int i;
        k.f(p, "p");
        Boolean boolValueOf = Boolean.TRUE;
        float[] fArr = p.content;
        int i6 = p._size;
        int i10 = 0;
        while (true) {
            boolean z10 = true;
            if (i10 >= i6) {
                break;
            }
            float f = fArr[i10];
            if (!boolValueOf.booleanValue() || 0.0f > f || f > 1.0f) {
                z10 = false;
            }
            boolValueOf = Boolean.valueOf(z10);
            i10++;
        }
        if (!boolValueOf.booleanValue()) {
            throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
        }
        Iterable iterableX = AbstractC1451a.X(1, p.getSize());
        if ((iterableX instanceof Collection) && ((Collection) iterableX).isEmpty()) {
            i = 0;
        } else {
            Iterator it = iterableX.iterator();
            i = 0;
            while (it.hasNext()) {
                int iNextInt = ((F) it).nextInt();
                if (p.get(iNextInt) < p.get(iNextInt - 1) && (i = i + 1) < 0) {
                    o.W();
                    throw null;
                }
            }
        }
        if (i <= 1) {
            return;
        }
        throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
    }
}
