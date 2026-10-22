package U8;

import H8.h;
import H8.l;
import com.fasterxml.jackson.core.JsonPointer;
import j9.t;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a extends S8.a {
    public static final a m;

    static {
        h hVar = new h();
        C8.b.a(hVar);
        l packageFqName = C8.b.f318a;
        k.e(packageFqName, "packageFqName");
        l constructorAnnotation = C8.b.c;
        k.e(constructorAnnotation, "constructorAnnotation");
        l classAnnotation = C8.b.b;
        k.e(classAnnotation, "classAnnotation");
        l functionAnnotation = C8.b.d;
        k.e(functionAnnotation, "functionAnnotation");
        l propertyAnnotation = C8.b.e;
        k.e(propertyAnnotation, "propertyAnnotation");
        l propertyGetterAnnotation = C8.b.f;
        k.e(propertyGetterAnnotation, "propertyGetterAnnotation");
        l propertySetterAnnotation = C8.b.g;
        k.e(propertySetterAnnotation, "propertySetterAnnotation");
        l enumEntryAnnotation = C8.b.i;
        k.e(enumEntryAnnotation, "enumEntryAnnotation");
        l compileTimeValue = C8.b.h;
        k.e(compileTimeValue, "compileTimeValue");
        l parameterAnnotation = C8.b.f319j;
        k.e(parameterAnnotation, "parameterAnnotation");
        l typeAnnotation = C8.b.k;
        k.e(typeAnnotation, "typeAnnotation");
        l typeParameterAnnotation = C8.b.l;
        k.e(typeParameterAnnotation, "typeParameterAnnotation");
        m = new a(hVar, packageFqName, constructorAnnotation, classAnnotation, functionAnnotation, propertyAnnotation, propertyGetterAnnotation, propertySetterAnnotation, enumEntryAnnotation, compileTimeValue, parameterAnnotation, typeAnnotation, typeParameterAnnotation);
    }

    public static String a(G8.c fqName) {
        String strB;
        k.f(fqName, "fqName");
        StringBuilder sb = new StringBuilder();
        sb.append(t.b0(fqName.b(), '.', JsonPointer.SEPARATOR));
        sb.append(JsonPointer.SEPARATOR);
        if (fqName.d()) {
            strB = "default-package";
        } else {
            strB = fqName.f().b();
            k.e(strB, "asString(...)");
        }
        sb.append(strB.concat(".kotlin_builtins"));
        return sb.toString();
    }
}
