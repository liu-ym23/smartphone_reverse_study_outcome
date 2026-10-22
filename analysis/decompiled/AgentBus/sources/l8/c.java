package l8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class c extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final c f5851h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f5852i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f5853j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f5854k;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5855g;

    static {
        int i2 = 1;
        f5851h = new c(i2, 0);
        f5852i = new c(i2, 1);
        f5853j = new c(i2, 2);
        f5854k = new c(i2, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i2, int i10) {
        super(i2);
        this.f5855g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f5855g) {
            case 0:
                ParameterizedType parameterizedType = (ParameterizedType) obj;
                q7.k.e(parameterizedType, "it");
                Type ownerType = parameterizedType.getOwnerType();
                if (ownerType instanceof ParameterizedType) {
                    return (ParameterizedType) ownerType;
                }
                return null;
            case 1:
                ParameterizedType parameterizedType2 = (ParameterizedType) obj;
                q7.k.e(parameterizedType2, "it");
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                q7.k.d(actualTypeArguments, "it.actualTypeArguments");
                return d7.n.T(actualTypeArguments);
            case 2:
                return Boolean.valueOf(((Class) obj).getSimpleName().length() == 0);
            default:
                String simpleName = ((Class) obj).getSimpleName();
                if (!e9.f.f(simpleName)) {
                    simpleName = null;
                }
                if (simpleName != null) {
                    return e9.f.e(simpleName);
                }
                return null;
        }
    }
}
