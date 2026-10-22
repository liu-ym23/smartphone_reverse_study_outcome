package D8;

import D7.q;
import D7.r;
import D7.v;
import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f407a;
    public final int b;
    public final int c;
    public final int d;
    public final List e;

    public a(int... numbers) {
        List listF1;
        kotlin.jvm.internal.k.f(numbers, "numbers");
        this.f407a = numbers;
        Integer numR0 = q.r0(numbers, 0);
        this.b = numR0 != null ? numR0.intValue() : -1;
        Integer numR02 = q.r0(numbers, 1);
        this.c = numR02 != null ? numR02.intValue() : -1;
        Integer numR03 = q.r0(numbers, 2);
        this.d = numR03 != null ? numR03.intValue() : -1;
        if (numbers.length <= 3) {
            listF1 = EmptyList.f4893a;
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException(B7.a.o(new StringBuilder("BinaryVersion with length more than 1024 are not supported. Provided length "), numbers.length, '.'));
            }
            listF1 = v.f1(new r(numbers, 0).subList(3, numbers.length));
        }
        this.e = listF1;
    }

    public final boolean a(int i, int i6, int i10) {
        int i11 = this.b;
        if (i11 > i) {
            return true;
        }
        if (i11 < i) {
            return false;
        }
        int i12 = this.c;
        if (i12 > i6) {
            return true;
        }
        return i12 >= i6 && this.d >= i10;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && kotlin.jvm.internal.k.b(this.e, aVar.e);
    }

    public final int hashCode() {
        int i = this.b;
        int i6 = (i * 31) + this.c + i;
        int i10 = (i6 * 31) + this.d + i6;
        return this.e.hashCode() + (i10 * 31) + i10;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        for (int i : this.f407a) {
            if (i == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList.isEmpty() ? EnvironmentCompat.MEDIA_UNKNOWN : v.I0(arrayList, ".", null, null, null, 62);
    }
}
