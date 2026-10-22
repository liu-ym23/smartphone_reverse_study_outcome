package o3;

import b3.f;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import v2.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final JavaType f10737a;

    /* renamed from: b, reason: collision with root package name */
    public final e f10738b;

    /* renamed from: c, reason: collision with root package name */
    public final ObjectIdGenerator<?> f10739c;

    /* renamed from: d, reason: collision with root package name */
    public final f<Object> f10740d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10741e;

    public a(JavaType javaType, e eVar, ObjectIdGenerator<?> objectIdGenerator, f<?> fVar, boolean z) {
        this.f10737a = javaType;
        this.f10738b = eVar;
        this.f10739c = objectIdGenerator;
        this.f10740d = fVar;
        this.f10741e = z;
    }

    public static a a(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, boolean z) {
        String str = propertyName == null ? null : propertyName.f3755a;
        return new a(javaType, str != null ? new SerializedString(str) : null, objectIdGenerator, null, z);
    }
}
