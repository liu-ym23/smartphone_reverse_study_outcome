package l3;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g extends f {

    /* renamed from: d, reason: collision with root package name */
    public final String f10202d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10203e;

    public g(JavaType javaType, TypeFactory typeFactory, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory, polymorphicTypeValidator);
        String name = javaType.f3690a.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            this.f10202d = "";
            this.f10203e = ".";
        } else {
            this.f10203e = name.substring(0, iLastIndexOf + 1);
            this.f10202d = name.substring(0, iLastIndexOf);
        }
    }

    @Override // l3.f, k3.c
    public final String a(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.f10203e) ? name.substring(r1.length() - 1) : name;
    }

    @Override // l3.f
    public final JavaType g(String str, b3.b bVar) {
        if (str.startsWith(".")) {
            int length = str.length();
            String str2 = this.f10202d;
            StringBuilder sb2 = new StringBuilder(str2.length() + length);
            if (str2.isEmpty()) {
                sb2.append(str.substring(1));
            } else {
                sb2.append(str2);
                sb2.append(str);
            }
            str = sb2.toString();
        }
        return super.g(str, bVar);
    }
}
