package va;

import La.D;
import com.fasterxml.jackson.core.JsonPointer;
import da.C3964b;
import ga.c;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import ta.C5527a;

/* renamed from: va.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5686a extends C5527a {

    /* renamed from: r, reason: collision with root package name */
    public static final C5686a f42871r = new C5686a();

    /* JADX WARN: Illegal instructions before constructor call */
    public C5686a() {
        d dVarD = d.d();
        C3964b.a(dVarD);
        p.h(dVarD, "apply(...)");
        GeneratedMessageLite.e<ProtoBuf$Package, Integer> packageFqName = C3964b.f32149a;
        p.h(packageFqName, "packageFqName");
        GeneratedMessageLite.e<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> constructorAnnotation = C3964b.f32151c;
        p.h(constructorAnnotation, "constructorAnnotation");
        GeneratedMessageLite.e<ProtoBuf$Class, List<ProtoBuf$Annotation>> classAnnotation = C3964b.f32150b;
        p.h(classAnnotation, "classAnnotation");
        GeneratedMessageLite.e<ProtoBuf$Function, List<ProtoBuf$Annotation>> functionAnnotation = C3964b.f32152d;
        p.h(functionAnnotation, "functionAnnotation");
        GeneratedMessageLite.e<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyAnnotation = C3964b.f32153e;
        p.h(propertyAnnotation, "propertyAnnotation");
        GeneratedMessageLite.e<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyGetterAnnotation = C3964b.f32154f;
        p.h(propertyGetterAnnotation, "propertyGetterAnnotation");
        GeneratedMessageLite.e<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertySetterAnnotation = C3964b.f32155g;
        p.h(propertySetterAnnotation, "propertySetterAnnotation");
        GeneratedMessageLite.e<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> enumEntryAnnotation = C3964b.f32157i;
        p.h(enumEntryAnnotation, "enumEntryAnnotation");
        GeneratedMessageLite.e<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> compileTimeValue = C3964b.f32156h;
        p.h(compileTimeValue, "compileTimeValue");
        GeneratedMessageLite.e<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> parameterAnnotation = C3964b.f32158j;
        p.h(parameterAnnotation, "parameterAnnotation");
        GeneratedMessageLite.e<ProtoBuf$Type, List<ProtoBuf$Annotation>> typeAnnotation = C3964b.f32159k;
        p.h(typeAnnotation, "typeAnnotation");
        GeneratedMessageLite.e<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> typeParameterAnnotation = C3964b.f32160l;
        p.h(typeParameterAnnotation, "typeParameterAnnotation");
        super(dVarD, packageFqName, constructorAnnotation, classAnnotation, functionAnnotation, null, propertyAnnotation, propertyGetterAnnotation, propertySetterAnnotation, null, null, null, enumEntryAnnotation, compileTimeValue, parameterAnnotation, typeAnnotation, typeParameterAnnotation);
    }

    public final String q(c fqName) {
        p.i(fqName, "fqName");
        return s(fqName) + ".kotlin_builtins";
    }

    public final String r(c fqName) {
        p.i(fqName, "fqName");
        return D.S(fqName.a(), '.', JsonPointer.SEPARATOR, false, 4, null) + JsonPointer.SEPARATOR + q(fqName);
    }

    public final String s(c cVar) {
        if (cVar.c()) {
            return "default-package";
        }
        String strB = cVar.f().b();
        p.h(strB, "asString(...)");
        return strB;
    }
}
