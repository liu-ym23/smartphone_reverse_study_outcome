package a8;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class v extends r {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f458g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(Method method, boolean z4, int i2, int i10) {
        super(method, z4, i2);
        this.f458g = i10;
    }

    @Override // a8.r, a8.h
    public final Object h(Object[] objArr) {
        switch (this.f458g) {
            case 0:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                return c(objArr.length <= 1 ? new Object[0] : d7.n.c0(objArr, 1, objArr.length), objArr[0]);
            case 1:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                b(d7.n.h0(objArr));
                return c(objArr.length <= 1 ? new Object[0] : d7.n.c0(objArr, 1, objArr.length), null);
            default:
                q7.k.e(objArr, "args");
                g.checkArguments(this, objArr);
                return c(objArr, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(Method method) {
        super(method, false, 6);
        this.f458g = 0;
        q7.k.e(method, "method");
    }
}
