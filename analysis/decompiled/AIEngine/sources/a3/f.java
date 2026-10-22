package a3;

import a3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f<F extends e> {

    /* renamed from: a, reason: collision with root package name */
    public final int f19a;

    public f(int i10) {
        this.f19a = i10;
    }

    public static <F extends e> f<F> a(F[] fArr) {
        if (fArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", fArr[0].getClass().getName(), Integer.valueOf(fArr.length)));
        }
        int iB = 0;
        for (F f8 : fArr) {
            if (f8.a()) {
                iB |= f8.b();
            }
        }
        return new f<>(iB);
    }
}
