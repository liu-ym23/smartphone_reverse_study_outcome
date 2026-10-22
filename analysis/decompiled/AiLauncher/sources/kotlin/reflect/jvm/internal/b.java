package kotlin.reflect.jvm.internal;

import K9.C0925f;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import fa.AbstractC4067d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import z9.C6425l;
import z9.C6427m;
import z9.Z0;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/b;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "e", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, "Lkotlin/reflect/jvm/internal/b$a;", "Lkotlin/reflect/jvm/internal/b$b;", "Lkotlin/reflect/jvm/internal/b$c;", "Lkotlin/reflect/jvm/internal/b$d;", "Lkotlin/reflect/jvm/internal/b$e;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class b {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlin/reflect/jvm/internal/b$a;", "Lkotlin/reflect/jvm/internal/b;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", SystemDeleteBroadcastReceiver.EXTRA_METHODS, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Class<?> jClass;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final List<Method> methods;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: kotlin.reflect.jvm.internal.b$a$a, reason: collision with other inner class name */
        public static final class C0432a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b9.b.d(((Method) t10).getName(), ((Method) t11).getName());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Class<?> jClass) throws SecurityException {
            super(null);
            kotlin.jvm.internal.p.i(jClass, "jClass");
            this.jClass = jClass;
            Method[] declaredMethods = jClass.getDeclaredMethods();
            kotlin.jvm.internal.p.h(declaredMethods, "getDeclaredMethods(...)");
            this.methods = Z8.r.I0(declaredMethods, new C0432a());
        }

        public static final CharSequence c(Method method) {
            Class<?> returnType = method.getReturnType();
            kotlin.jvm.internal.p.h(returnType, "getReturnType(...)");
            return C0925f.f(returnType);
        }

        @Override // kotlin.reflect.jvm.internal.b
        /* renamed from: a */
        public String get_signature() {
            return F.A0(this.methods, "", "<init>(", ")V", 0, null, C6425l.f45367a, 24, null);
        }

        public final List<Method> d() {
            return this.methods;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/b$b;", "Lkotlin/reflect/jvm/internal/b;", "Ljava/lang/reflect/Constructor;", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/lang/reflect/Constructor;", Const.INTENT_KEY_UMID, "()Ljava/lang/reflect/Constructor;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.reflect.jvm.internal.b$b, reason: collision with other inner class name */
    public static final class C0433b extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Constructor<?> constructor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0433b(Constructor<?> constructor) {
            super(null);
            kotlin.jvm.internal.p.i(constructor, "constructor");
            this.constructor = constructor;
        }

        public static final CharSequence c(Class cls) {
            kotlin.jvm.internal.p.f(cls);
            return C0925f.f(cls);
        }

        @Override // kotlin.reflect.jvm.internal.b
        /* renamed from: a */
        public String get_signature() {
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            kotlin.jvm.internal.p.h(parameterTypes, "getParameterTypes(...)");
            return Z8.r.w0(parameterTypes, "", "<init>(", ")V", 0, null, C6427m.f45369a, 24, null);
        }

        public final Constructor<?> d() {
            return this.constructor;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/b$c;", "Lkotlin/reflect/jvm/internal/b;", "Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/reflect/Method;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Method method;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Method method) {
            super(null);
            kotlin.jvm.internal.p.i(method, "method");
            this.method = method;
        }

        @Override // kotlin.reflect.jvm.internal.b
        /* renamed from: a */
        public String get_signature() {
            return Z0.d(this.method);
        }

        /* renamed from: b, reason: from getter */
        public final Method getMethod() {
            return this.method;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/b$d;", "Lkotlin/reflect/jvm/internal/b;", "Lfa/d$b;", "signature", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Lfa/d$b;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "_signature", "constructorDesc", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final AbstractC4067d.b signature;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String _signature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbstractC4067d.b signature) {
            super(null);
            kotlin.jvm.internal.p.i(signature, "signature");
            this.signature = signature;
            this._signature = signature.a();
        }

        @Override // kotlin.reflect.jvm.internal.b
        /* renamed from: a, reason: from getter */
        public String get_signature() {
            return this._signature;
        }

        public final String b() {
            return this.signature.d();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/b$e;", "Lkotlin/reflect/jvm/internal/b;", "Lfa/d$b;", "signature", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Lfa/d$b;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "_signature", "c", "methodName", "methodDesc", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final AbstractC4067d.b signature;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String _signature;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbstractC4067d.b signature) {
            super(null);
            kotlin.jvm.internal.p.i(signature, "signature");
            this.signature = signature;
            this._signature = signature.a();
        }

        @Override // kotlin.reflect.jvm.internal.b
        /* renamed from: a, reason: from getter */
        public String get_signature() {
            return this._signature;
        }

        public final String b() {
            return this.signature.d();
        }

        public final String c() {
            return this.signature.e();
        }
    }

    public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
        this();
    }

    /* renamed from: a */
    public abstract String get_signature();

    public b() {
    }
}
