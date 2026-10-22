package G1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.EnumSet;

/* loaded from: classes.dex */
public final class e implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f591a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Type f592b;

    public /* synthetic */ e(int i4, Type type) {
        this.f591a = i4;
        this.f592b = type;
    }

    @Override // G1.p
    public final Object i() {
        int i4 = this.f591a;
        Type type = this.f592b;
        switch (i4) {
            case 0:
                if (!(type instanceof ParameterizedType)) {
                    throw new F1.q("Invalid EnumSet type: " + type.toString(), 5);
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new F1.q("Invalid EnumSet type: " + type.toString(), 5);
            default:
                if (!(type instanceof ParameterizedType)) {
                    throw new F1.q("Invalid EnumMap type: " + type.toString(), 5);
                }
                Type type3 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type3 instanceof Class) {
                    return new EnumMap((Class) type3);
                }
                throw new F1.q("Invalid EnumMap type: " + type.toString(), 5);
        }
    }
}
