package i3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?>[] f9507c = new Class[0];

    /* renamed from: a, reason: collision with root package name */
    public final String f9508a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<?>[] f9509b;

    public g(Method method) {
        this(method.getName(), method.getParameterTypes());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != g.class) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.f9508a.equals(gVar.f9508a)) {
            return false;
        }
        Class<?>[] clsArr = gVar.f9509b;
        Class<?>[] clsArr2 = this.f9509b;
        int length = clsArr2.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (clsArr[i10] != clsArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f9508a.hashCode() + this.f9509b.length;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f9508a);
        sb2.append("(");
        return ai.onnxruntime.a.j("-args)", this.f9509b.length, sb2);
    }

    public g(Constructor<?> constructor) {
        this("", constructor.getParameterTypes());
    }

    public g(String str, Class<?>[] clsArr) {
        this.f9508a = str;
        this.f9509b = clsArr == null ? f9507c : clsArr;
    }
}
