package l3;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class j implements k3.c {

    /* renamed from: a, reason: collision with root package name */
    public final TypeFactory f10212a;

    /* renamed from: b, reason: collision with root package name */
    public final JavaType f10213b;

    public j(JavaType javaType, TypeFactory typeFactory) {
        this.f10213b = javaType;
        this.f10212a = typeFactory;
    }

    @Override // k3.c
    public final String d() {
        return e(this.f10213b.f3690a, null);
    }
}
