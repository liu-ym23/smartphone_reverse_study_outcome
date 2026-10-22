package i9;

import La.MatchGroup;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;
import t9.C5525b;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Li9/a;", "", "<init>", "()V", "", "cause", "exception", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "LLa/j;", "c", "(Ljava/util/regex/MatchResult;Ljava/lang/String;)LLa/j;", "Lkotlin/random/Random;", Const.INTENT_KEY_PKGNAME, "()Lkotlin/random/Random;", "LMa/a;", Const.INTENT_KEY_UMID, "()LMa/a;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: i9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4178a {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Li9/a$a;", "", "<init>", "()V", "Ljava/lang/reflect/Method;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/reflect/Method;", "addSuppressed", "c", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: i9.a$a, reason: collision with other inner class name */
    public static final class C0407a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0407a f33077a = new C0407a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Method addSuppressed;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final Method getSuppressed;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            p.f(methods);
            int length = methods.length;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                method = null;
                if (i11 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i11];
                if (p.d(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    p.h(parameterTypes, "getParameterTypes(...)");
                    if (p.d(r.F0(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i11++;
            }
            addSuppressed = method2;
            int length2 = methods.length;
            while (true) {
                if (i10 >= length2) {
                    break;
                }
                Method method3 = methods[i10];
                if (p.d(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i10++;
            }
            getSuppressed = method;
        }
    }

    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        p.i(cause, "cause");
        p.i(exception, "exception");
        Method method = C0407a.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public Random b() {
        return new C5525b();
    }

    public MatchGroup c(MatchResult matchResult, String name) {
        throw null;
    }

    public Ma.a d() {
        throw null;
    }
}
