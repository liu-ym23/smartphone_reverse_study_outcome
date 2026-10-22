package y9;

import A9.g;
import J9.f;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.k;
import o9.C5013a;
import w9.InterfaceC5744c;
import w9.InterfaceC5745d;
import w9.InterfaceC5747f;
import w9.InterfaceC5748g;
import w9.InterfaceC5749h;
import w9.InterfaceC5752k;
import w9.InterfaceC5755n;
import x9.C5856a;
import z9.c1;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a+\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\n\"\u001b\u0010\u000f\u001a\u0004\u0018\u00010\f*\u0006\u0012\u0002\b\u00030\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u000b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"/\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001b\"\u0004\b\u0000\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000\b8F¢\u0006\f\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d\"\u0015\u0010%\u001a\u00020\"*\u00020!8F¢\u0006\u0006\u001a\u0004\b#\u0010$\"\u001b\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Ljava/lang/reflect/Member;", "Lw9/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/reflect/Member;)Lw9/f;", "", "Lw9/c;", "Ljava/lang/reflect/Method;", "method", "Lw9/g;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Collection;Ljava/lang/reflect/Method;)Lw9/g;", "Lw9/k;", "Ljava/lang/reflect/Field;", "c", "(Lw9/k;)Ljava/lang/reflect/Field;", "javaField", Const.INTENT_KEY_UMID, "(Lw9/k;)Ljava/lang/reflect/Method;", "javaGetter", "Lw9/h;", "f", "(Lw9/h;)Ljava/lang/reflect/Method;", "javaSetter", "e", "(Lw9/g;)Ljava/lang/reflect/Method;", "javaMethod", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/reflect/Constructor;", Const.INTENT_KEY_PKGNAME, "(Lw9/g;)Ljava/lang/reflect/Constructor;", "getJavaConstructor$annotations", "(Lw9/g;)V", "javaConstructor", "Lw9/n;", "Ljava/lang/reflect/Type;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw9/n;)Ljava/lang/reflect/Type;", "javaType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/reflect/Method;)Lw9/g;", "kotlinFunction", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f44000a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f44000a = iArr;
        }
    }

    public static final InterfaceC5748g<?> a(Collection<? extends InterfaceC5744c<?>> collection, Method method) {
        for (InterfaceC5744c<?> interfaceC5744c : collection) {
            if (interfaceC5744c instanceof InterfaceC5748g) {
                InterfaceC5748g<?> interfaceC5748g = (InterfaceC5748g) interfaceC5744c;
                if (p.d(interfaceC5748g.getName(), method.getName()) && p.d(e(interfaceC5748g), method)) {
                    return interfaceC5748g;
                }
            }
        }
        for (InterfaceC5744c<?> interfaceC5744c2 : collection) {
            if (interfaceC5744c2 instanceof InterfaceC5748g) {
                InterfaceC5748g<?> interfaceC5748g2 = (InterfaceC5748g) interfaceC5744c2;
                if (!p.d(interfaceC5748g2.getName(), method.getName()) && p.d(e(interfaceC5748g2), method)) {
                    return interfaceC5748g2;
                }
            }
        }
        return null;
    }

    public static final <T> Constructor<T> b(InterfaceC5748g<? extends T> interfaceC5748g) {
        g<?> gVarW;
        p.i(interfaceC5748g, "<this>");
        kotlin.reflect.jvm.internal.d<?> dVarB = c1.b(interfaceC5748g);
        Member member = (dVarB == null || (gVarW = dVarB.W()) == null) ? null : gVarW.getMember();
        if (member instanceof Constructor) {
            return (Constructor) member;
        }
        return null;
    }

    public static final Field c(InterfaceC5752k<?> interfaceC5752k) {
        p.i(interfaceC5752k, "<this>");
        kotlin.reflect.jvm.internal.p<?> pVarD = c1.d(interfaceC5752k);
        if (pVarD != null) {
            return pVarD.o0();
        }
        return null;
    }

    public static final Method d(InterfaceC5752k<?> interfaceC5752k) {
        p.i(interfaceC5752k, "<this>");
        return e(interfaceC5752k.n0());
    }

    public static final Method e(InterfaceC5748g<?> interfaceC5748g) {
        g<?> gVarW;
        p.i(interfaceC5748g, "<this>");
        kotlin.reflect.jvm.internal.d<?> dVarB = c1.b(interfaceC5748g);
        Member member = (dVarB == null || (gVarW = dVarB.W()) == null) ? null : gVarW.getMember();
        if (member instanceof Method) {
            return (Method) member;
        }
        return null;
    }

    public static final Method f(InterfaceC5749h<?> interfaceC5749h) {
        p.i(interfaceC5749h, "<this>");
        return e(interfaceC5749h.getSetter());
    }

    public static final Type g(InterfaceC5755n interfaceC5755n) {
        p.i(interfaceC5755n, "<this>");
        return TypesJVMKt.f(interfaceC5755n);
    }

    public static final InterfaceC5747f h(Member member) {
        KotlinClassHeader kotlinClassHeaderB;
        f.a aVar = f.f3793c;
        Class<?> declaringClass = member.getDeclaringClass();
        p.h(declaringClass, "getDeclaringClass(...)");
        f fVarA = aVar.a(declaringClass);
        KotlinClassHeader.Kind kindC = (fVarA == null || (kotlinClassHeaderB = fVarA.b()) == null) ? null : kotlinClassHeaderB.c();
        int i10 = kindC == null ? -1 : a.f44000a[kindC.ordinal()];
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            return null;
        }
        Class<?> declaringClass2 = member.getDeclaringClass();
        p.h(declaringClass2, "getDeclaringClass(...)");
        return new k(declaringClass2);
    }

    public static final InterfaceC5748g<?> i(Method method) {
        InterfaceC5748g<?> interfaceC5748gA;
        p.i(method, "<this>");
        if (Modifier.isStatic(method.getModifiers())) {
            InterfaceC5747f interfaceC5747fH = h(method);
            if (interfaceC5747fH != null) {
                return a(interfaceC5747fH.b(), method);
            }
            Class<?> declaringClass = method.getDeclaringClass();
            p.h(declaringClass, "getDeclaringClass(...)");
            InterfaceC5745d<?> interfaceC5745dA = C5856a.a(C5013a.e(declaringClass));
            if (interfaceC5745dA != null) {
                Class clsB = C5013a.b(interfaceC5745dA);
                String name = method.getName();
                p.h(name, "getName(...)");
                Class<?>[] parameterTypes = method.getParameterTypes();
                Method methodI = c1.i(clsB, name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
                if (methodI != null && (interfaceC5748gA = a(C5856a.b(interfaceC5745dA), methodI)) != null) {
                    return interfaceC5748gA;
                }
            }
        }
        Class<?> declaringClass2 = method.getDeclaringClass();
        p.h(declaringClass2, "getDeclaringClass(...)");
        return a(C5856a.b(C5013a.e(declaringClass2)), method);
    }
}
