package kotlin.reflect.jvm.internal;

import E9.C0810o;
import E9.InterfaceC0803h;
import E9.O;
import K9.C0925f;
import S9.E;
import com.autonavi.aps.amapapi.config.Const;
import ea.InterfaceC4020d;
import fa.AbstractC4067d;
import fa.C4071h;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.b;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import wa.C5770L;
import wa.InterfaceC5793q;
import z9.Z0;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0007\b\u0005\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/c;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "Lkotlin/reflect/jvm/internal/c$a;", "Lkotlin/reflect/jvm/internal/c$b;", "Lkotlin/reflect/jvm/internal/c$c;", "Lkotlin/reflect/jvm/internal/c$d;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class c {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/c$a;", "Lkotlin/reflect/jvm/internal/c;", "Ljava/lang/reflect/Field;", "field", "<init>", "(Ljava/lang/reflect/Field;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/lang/reflect/Field;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/reflect/Field;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Field field;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Field field) {
            super(null);
            kotlin.jvm.internal.p.i(field, "field");
            this.field = field;
        }

        @Override // kotlin.reflect.jvm.internal.c
        /* renamed from: a */
        public String getString() {
            StringBuilder sb2 = new StringBuilder();
            String name = this.field.getName();
            kotlin.jvm.internal.p.h(name, "getName(...)");
            sb2.append(E.b(name));
            sb2.append("()");
            Class<?> type = this.field.getType();
            kotlin.jvm.internal.p.h(type, "getType(...)");
            sb2.append(C0925f.f(type));
            return sb2.toString();
        }

        /* renamed from: b, reason: from getter */
        public final Field getField() {
            return this.field;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/c$b;", "Lkotlin/reflect/jvm/internal/c;", "Ljava/lang/reflect/Method;", "getterMethod", "setterMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/reflect/Method;", "c", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Method getterMethod;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Method setterMethod;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method getterMethod, Method method) {
            super(null);
            kotlin.jvm.internal.p.i(getterMethod, "getterMethod");
            this.getterMethod = getterMethod;
            this.setterMethod = method;
        }

        @Override // kotlin.reflect.jvm.internal.c
        /* renamed from: a */
        public String getString() {
            return Z0.d(this.getterMethod);
        }

        /* renamed from: b, reason: from getter */
        public final Method getGetterMethod() {
            return this.getterMethod;
        }

        /* renamed from: c, reason: from getter */
        public final Method getSetterMethod() {
            return this.setterMethod;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lkotlin/reflect/jvm/internal/c$c;", "Lkotlin/reflect/jvm/internal/c;", "LE9/O;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "signature", "Lea/d;", "nameResolver", "Lea/h;", "typeTable", "<init>", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "c", "LE9/O;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", Const.INTENT_KEY_PKGNAME, "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "getProto", "()Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$JvmPropertySignature;", Const.INTENT_KEY_UMID, "Lea/d;", "getNameResolver", "()Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;", "e", "Lea/h;", "getTypeTable", "()Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;", "f", "Ljava/lang/String;", "string", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.reflect.jvm.internal.c$c, reason: collision with other inner class name */
    public static final class C0434c extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final O descriptor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final ProtoBuf$Property proto;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final JvmProtoBuf.JvmPropertySignature signature;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC4020d nameResolver;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final ea.h typeTable;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final String string;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0434c(O descriptor, ProtoBuf$Property proto, JvmProtoBuf.JvmPropertySignature signature, InterfaceC4020d nameResolver, ea.h typeTable) {
            String str;
            super(null);
            kotlin.jvm.internal.p.i(descriptor, "descriptor");
            kotlin.jvm.internal.p.i(proto, "proto");
            kotlin.jvm.internal.p.i(signature, "signature");
            kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
            kotlin.jvm.internal.p.i(typeTable, "typeTable");
            this.descriptor = descriptor;
            this.proto = proto;
            this.signature = signature;
            this.nameResolver = nameResolver;
            this.typeTable = typeTable;
            if (signature.F()) {
                str = nameResolver.getString(signature.z().v()) + nameResolver.getString(signature.z().u());
            } else {
                AbstractC4067d.a aVarD = C4071h.d(C4071h.f32594a, proto, nameResolver, typeTable, false, 8, null);
                if (aVarD == null) {
                    throw new KotlinReflectionInternalError("No field signature for property: " + descriptor);
                }
                String strB = aVarD.b();
                str = E.b(strB) + c() + "()" + aVarD.c();
            }
            this.string = str;
        }

        @Override // kotlin.reflect.jvm.internal.c
        /* renamed from: a, reason: from getter */
        public String getString() {
            return this.string;
        }

        /* renamed from: b, reason: from getter */
        public final O getDescriptor() {
            return this.descriptor;
        }

        public final String c() {
            String string;
            InterfaceC0803h interfaceC0803hB = this.descriptor.b();
            kotlin.jvm.internal.p.h(interfaceC0803hB, "getContainingDeclaration(...)");
            if (kotlin.jvm.internal.p.d(this.descriptor.getVisibility(), C0810o.f2472d) && (interfaceC0803hB instanceof DeserializedClassDescriptor)) {
                ProtoBuf$Class protoBuf$ClassY0 = ((DeserializedClassDescriptor) interfaceC0803hB).Y0();
                GeneratedMessageLite.e<ProtoBuf$Class, Integer> classModuleName = JvmProtoBuf.f35746i;
                kotlin.jvm.internal.p.h(classModuleName, "classModuleName");
                Integer num = (Integer) ea.f.a(protoBuf$ClassY0, classModuleName);
                if (num == null || (string = this.nameResolver.getString(num.intValue())) == null) {
                    string = "main";
                }
                return '$' + ga.f.b(string);
            }
            if (!kotlin.jvm.internal.p.d(this.descriptor.getVisibility(), C0810o.f2469a) || !(interfaceC0803hB instanceof E9.E)) {
                return "";
            }
            O o10 = this.descriptor;
            kotlin.jvm.internal.p.g(o10, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedPropertyDescriptor");
            InterfaceC5793q interfaceC5793qG = ((C5770L) o10).G();
            if (!(interfaceC5793qG instanceof ba.l)) {
                return "";
            }
            ba.l lVar = (ba.l) interfaceC5793qG;
            if (lVar.f() == null) {
                return "";
            }
            return '$' + lVar.h().b();
        }

        /* renamed from: d, reason: from getter */
        public final InterfaceC4020d getNameResolver() {
            return this.nameResolver;
        }

        /* renamed from: e, reason: from getter */
        public final ProtoBuf$Property getProto() {
            return this.proto;
        }

        /* renamed from: f, reason: from getter */
        public final JvmProtoBuf.JvmPropertySignature getSignature() {
            return this.signature;
        }

        /* renamed from: g, reason: from getter */
        public final ea.h getTypeTable() {
            return this.typeTable;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/c$d;", "Lkotlin/reflect/jvm/internal/c;", "Lkotlin/reflect/jvm/internal/b$e;", "getterSignature", "setterSignature", "<init>", "(Lkotlin/reflect/jvm/internal/b$e;Lkotlin/reflect/jvm/internal/b$e;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/b$e;", Const.INTENT_KEY_PKGNAME, "()Lkotlin/reflect/jvm/internal/b$e;", "c", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final b.e getterSignature;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final b.e setterSignature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b.e getterSignature, b.e eVar) {
            super(null);
            kotlin.jvm.internal.p.i(getterSignature, "getterSignature");
            this.getterSignature = getterSignature;
            this.setterSignature = eVar;
        }

        @Override // kotlin.reflect.jvm.internal.c
        /* renamed from: a */
        public String getString() {
            return this.getterSignature.get_signature();
        }

        /* renamed from: b, reason: from getter */
        public final b.e getGetterSignature() {
            return this.getterSignature;
        }

        /* renamed from: c, reason: from getter */
        public final b.e getSetterSignature() {
            return this.setterSignature;
        }
    }

    public /* synthetic */ c(kotlin.jvm.internal.i iVar) {
        this();
    }

    /* renamed from: a */
    public abstract String getString();

    public c() {
    }
}
