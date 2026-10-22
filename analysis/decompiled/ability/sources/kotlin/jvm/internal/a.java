package kotlin.jvm.internal;

import D7.F;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class a extends F {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f4921a;
    public int b;

    public a(int[] array) {
        k.f(array, "array");
        this.f4921a = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f4921a.length;
    }

    @Override // D7.F
    public final int nextInt() {
        try {
            int[] iArr = this.f4921a;
            int i = this.b;
            this.b = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
