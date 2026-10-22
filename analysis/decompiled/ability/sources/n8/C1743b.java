package n8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* renamed from: n8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1743b implements S7.k {
    public static final C1743b b = new C1743b(0);
    public static final C1743b c = new C1743b(1);
    public static final C1743b d = new C1743b(2);
    public static final C1743b e = new C1743b(3);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5354a;

    public /* synthetic */ C1743b(int i) {
        this.f5354a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f5354a) {
            case 0:
                ParameterizedType it = (ParameterizedType) obj;
                List list = AbstractC1744c.f5355a;
                kotlin.jvm.internal.k.f(it, "it");
                Type ownerType = it.getOwnerType();
                if (ownerType instanceof ParameterizedType) {
                    return (ParameterizedType) ownerType;
                }
                return null;
            case 1:
                ParameterizedType it2 = (ParameterizedType) obj;
                List list2 = AbstractC1744c.f5355a;
                kotlin.jvm.internal.k.f(it2, "it");
                Type[] actualTypeArguments = it2.getActualTypeArguments();
                kotlin.jvm.internal.k.e(actualTypeArguments, "getActualTypeArguments(...)");
                return D7.q.M(actualTypeArguments);
            case 2:
                return Boolean.valueOf(((Class) obj).getSimpleName().length() == 0);
            default:
                String simpleName = ((Class) obj).getSimpleName();
                if (!G8.f.f(simpleName)) {
                    simpleName = null;
                }
                if (simpleName != null) {
                    return G8.f.e(simpleName);
                }
                return null;
        }
    }
}
