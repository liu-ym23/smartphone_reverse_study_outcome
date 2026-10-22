package K9;

import K9.D;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public final class v extends x implements Z9.n {

    /* renamed from: a, reason: collision with root package name */
    public final Field f4192a;

    public v(Field member) {
        kotlin.jvm.internal.p.i(member, "member");
        this.f4192a = member;
    }

    @Override // Z9.n
    public boolean E() {
        return N().isEnumConstant();
    }

    @Override // Z9.n
    public boolean K() {
        return false;
    }

    @Override // K9.x
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public Field N() {
        return this.f4192a;
    }

    @Override // Z9.n
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public D getType() {
        D.a aVar = D.f4146a;
        Type genericType = N().getGenericType();
        kotlin.jvm.internal.p.h(genericType, "getGenericType(...)");
        return aVar.a(genericType);
    }
}
