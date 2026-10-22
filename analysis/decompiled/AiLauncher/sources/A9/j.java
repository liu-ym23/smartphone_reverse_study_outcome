package A9;

import A9.h;
import Z8.C1168p;
import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u0011\u000fB\u001f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0001\u0002\u001b\u001c¨\u0006\u001d"}, d2 = {"LA9/j;", "LA9/g;", "Ljava/lang/reflect/Method;", "unboxMethod", "", "Ljava/lang/reflect/Type;", "parameterTypes", "<init>", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "", "instance", "", "args", "c", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Ljava/lang/reflect/Method;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "()Ljava/util/List;", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/reflect/Method;", "member", "LA9/j$a;", "LA9/j$b;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class j implements g<Method> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Method unboxMethod;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<Type> parameterTypes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Type returnType;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LA9/j$a;", "LA9/j;", "LA9/f;", "Ljava/lang/reflect/Method;", "unboxMethod", "", "boundReceiver", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "", "args", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends j implements f {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final Object boundReceiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method unboxMethod, Object obj) {
            super(unboxMethod, C1173v.m(), null);
            p.i(unboxMethod, "unboxMethod");
            this.boundReceiver = obj;
        }

        @Override // A9.g
        public Object call(Object[] args) {
            p.i(args, "args");
            d(args);
            return c(this.boundReceiver, args);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"LA9/j$b;", "LA9/j;", "Ljava/lang/reflect/Method;", "unboxMethod", "<init>", "(Ljava/lang/reflect/Method;)V", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method unboxMethod) {
            super(unboxMethod, C1172u.e(unboxMethod.getDeclaringClass()), null);
            p.i(unboxMethod, "unboxMethod");
        }

        @Override // A9.g
        public Object call(Object[] args) {
            p.i(args, "args");
            d(args);
            Object obj = args[0];
            h.Companion companion = h.INSTANCE;
            return c(obj, args.length <= 1 ? new Object[0] : C1168p.q(args, 1, args.length));
        }
    }

    public /* synthetic */ j(Method method, List list, kotlin.jvm.internal.i iVar) {
        this(method, list);
    }

    @Override // A9.g
    public final List<Type> a() {
        return this.parameterTypes;
    }

    @Override // A9.g
    public /* bridge */ boolean b() {
        return f();
    }

    public final Object c(Object instance, Object[] args) {
        p.i(args, "args");
        return this.unboxMethod.invoke(instance, Arrays.copyOf(args, args.length));
    }

    public /* bridge */ void d(Object[] objArr) {
        e(objArr);
    }

    public void e(Object[] args) {
        p.i(args, "args");
        if (i.a(this) == args.length) {
            return;
        }
        throw new IllegalArgumentException("Callable expects " + i.a(this) + " arguments, but " + args.length + " were provided.");
    }

    public boolean f() {
        return false;
    }

    @Override // A9.g
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Method getMember() {
        return null;
    }

    @Override // A9.g
    public final Type getReturnType() {
        return this.returnType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Method method, List<? extends Type> list) {
        this.unboxMethod = method;
        this.parameterTypes = list;
        Class<?> returnType = method.getReturnType();
        p.h(returnType, "getReturnType(...)");
        this.returnType = returnType;
    }
}
