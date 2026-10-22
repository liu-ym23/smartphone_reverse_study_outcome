package q3;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public androidx.appcompat.widget.l f11562a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.appcompat.widget.l f11563b;

    /* renamed from: c, reason: collision with root package name */
    public int f11564c;

    /* renamed from: d, reason: collision with root package name */
    public Object[] f11565d;

    public final void a(Object obj, Object[] objArr, int i10, int i11) {
        int i12 = 0;
        for (androidx.appcompat.widget.l lVar = this.f11562a; lVar != null; lVar = (androidx.appcompat.widget.l) lVar.h) {
            Object[] objArr2 = (Object[]) lVar.f887g;
            int length = objArr2.length;
            System.arraycopy(objArr2, 0, obj, i12, length);
            i12 += length;
        }
        System.arraycopy(objArr, 0, obj, i12, i11);
        int i13 = i12 + i11;
        if (i13 != i10) {
            throw new IllegalStateException(a0.a.f("Should have gotten ", i10, i13, " entries, got "));
        }
    }

    public final void b() {
        androidx.appcompat.widget.l lVar = this.f11563b;
        if (lVar != null) {
            this.f11565d = (Object[]) lVar.f887g;
        }
        this.f11563b = null;
        this.f11562a = null;
        this.f11564c = 0;
    }

    public final Object[] c(Object[] objArr) {
        androidx.appcompat.widget.l lVar = new androidx.appcompat.widget.l(objArr, (Object) null);
        if (this.f11562a == null) {
            this.f11563b = lVar;
            this.f11562a = lVar;
        } else {
            androidx.appcompat.widget.l lVar2 = this.f11563b;
            if (((androidx.appcompat.widget.l) lVar2.h) != null) {
                throw new IllegalStateException();
            }
            lVar2.h = lVar;
            this.f11563b = lVar;
        }
        int length = objArr.length;
        this.f11564c += length;
        if (length < 16384) {
            length += length;
        } else if (length < 262144) {
            length += length >> 2;
        }
        return new Object[length];
    }

    public final void d(Object[] objArr, int i10, ArrayList arrayList) {
        int i11;
        androidx.appcompat.widget.l lVar = this.f11562a;
        while (true) {
            i11 = 0;
            if (lVar == null) {
                break;
            }
            Object[] objArr2 = (Object[]) lVar.f887g;
            int length = objArr2.length;
            while (i11 < length) {
                arrayList.add(objArr2[i11]);
                i11++;
            }
            lVar = (androidx.appcompat.widget.l) lVar.h;
        }
        while (i11 < i10) {
            arrayList.add(objArr[i11]);
            i11++;
        }
        b();
    }

    public final Object[] e(Object[] objArr, int i10) {
        int i11 = this.f11564c + i10;
        Object[] objArr2 = new Object[i11];
        a(objArr2, objArr, i11, i10);
        b();
        return objArr2;
    }

    public final <T> T[] f(Object[] objArr, int i10, Class<T> cls) {
        int i11 = this.f11564c + i10;
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i11));
        a(tArr, objArr, i11, i10);
        b();
        return tArr;
    }

    public final Object[] g() {
        b();
        Object[] objArr = this.f11565d;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[12];
        this.f11565d = objArr2;
        return objArr2;
    }

    public final Object[] h(Object[] objArr, int i10) {
        b();
        Object[] objArr2 = this.f11565d;
        if (objArr2 == null || objArr2.length < i10) {
            this.f11565d = new Object[Math.max(12, i10)];
        }
        System.arraycopy(objArr, 0, this.f11565d, 0, i10);
        return this.f11565d;
    }
}
