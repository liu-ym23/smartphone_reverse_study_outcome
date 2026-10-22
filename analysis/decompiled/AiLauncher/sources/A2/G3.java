package A2;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class G3 extends C0623h4 {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f362a = new Object[4];

    /* renamed from: b, reason: collision with root package name */
    public int f363b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f364c;

    public G3(int i10) {
    }

    public final G3 a(Object obj) {
        obj.getClass();
        b(this.f363b + 1);
        Object[] objArr = this.f362a;
        int i10 = this.f363b;
        this.f363b = i10 + 1;
        objArr[i10] = obj;
        return this;
    }

    public final void b(int i10) {
        Object[] objArr = this.f362a;
        int length = objArr.length;
        if (length >= i10) {
            if (this.f364c) {
                this.f362a = (Object[]) objArr.clone();
                this.f364c = false;
                return;
            }
            return;
        }
        int i11 = length + (length >> 1) + 1;
        if (i11 < i10) {
            int iHighestOneBit = Integer.highestOneBit(i10 - 1);
            i11 = iHighestOneBit + iHighestOneBit;
        }
        if (i11 < 0) {
            i11 = Integer.MAX_VALUE;
        }
        this.f362a = Arrays.copyOf(objArr, i11);
        this.f364c = false;
    }
}
