package o7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.EnumSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9239c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Type f9240f;

    @Override // o7.o
    public final Object b() {
        int i = this.f9239c;
        Type type = this.f9240f;
        switch (i) {
            case 0:
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type2 instanceof Class) {
                        return EnumSet.noneOf((Class) type2);
                    }
                    g5.f.t(type, "Invalid EnumSet type: ");
                } else {
                    g5.f.t(type, "Invalid EnumSet type: ");
                }
                return null;
            default:
                if (type instanceof ParameterizedType) {
                    Type type3 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type3 instanceof Class) {
                        return new EnumMap((Class) type3);
                    }
                    g5.f.t(type, "Invalid EnumMap type: ");
                } else {
                    g5.f.t(type, "Invalid EnumMap type: ");
                }
                return null;
        }
    }
}
