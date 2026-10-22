package t;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class f implements J.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15294a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f15295b;

    /* renamed from: c, reason: collision with root package name */
    public int f15296c;

    public f(int i4, int i5) {
        this.f15294a = i5;
        if (i5 != 1) {
            if (i4 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f15295b = new Object[i4];
        } else {
            if (i4 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0".toString());
            }
            this.f15295b = new Object[i4];
        }
    }

    @Override // J.c
    public boolean a(Object instance) {
        boolean z4;
        int i4 = this.f15294a;
        Object[] objArr = this.f15295b;
        switch (i4) {
            case 0:
                int i5 = this.f15296c;
                if (i5 >= objArr.length) {
                    return false;
                }
                objArr[i5] = instance;
                this.f15296c = i5 + 1;
                return true;
            default:
                Intrinsics.checkNotNullParameter(instance, "instance");
                int i6 = this.f15296c;
                int i7 = 0;
                while (true) {
                    if (i7 >= i6) {
                        z4 = false;
                    } else if (objArr[i7] == instance) {
                        z4 = true;
                    } else {
                        i7++;
                    }
                }
                if (!(!z4)) {
                    throw new IllegalStateException("Already in the pool!".toString());
                }
                int i8 = this.f15296c;
                if (i8 >= objArr.length) {
                    return false;
                }
                objArr[i8] = instance;
                this.f15296c = i8 + 1;
                return true;
        }
    }

    @Override // J.c
    public Object b() {
        int i4 = this.f15294a;
        Object[] objArr = this.f15295b;
        switch (i4) {
            case 0:
                int i5 = this.f15296c;
                if (i5 <= 0) {
                    return null;
                }
                int i6 = i5 - 1;
                Object obj = objArr[i6];
                objArr[i6] = null;
                this.f15296c = i6;
                return obj;
            default:
                int i7 = this.f15296c;
                if (i7 <= 0) {
                    return null;
                }
                int i8 = i7 - 1;
                Object obj2 = objArr[i8];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                objArr[i8] = null;
                this.f15296c--;
                return obj2;
        }
    }
}
