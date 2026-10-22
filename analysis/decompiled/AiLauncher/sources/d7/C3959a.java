package d7;

import Y8.j;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.datacenter.util.ReflectionException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000b\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0017\u001a\u00020\u00162\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ld7/a;", "", "<init>", "()V", "", "className", "Ljava/lang/Class;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/Class;", ExifInterface.GPS_DIRECTION_TRUE, "methodName", "", "args", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "clazz", "parameterTypes", "Ljava/lang/reflect/Method;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "source", "target", "", "c", "(Ljava/lang/Class;Ljava/lang/Class;)Z", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: d7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3959a {

    /* renamed from: a, reason: collision with root package name */
    public static final C3959a f32137a = new C3959a();

    public final <T> T a(String className, String methodName, Object... args) throws SecurityException {
        p.i(className, "className");
        p.i(methodName, "methodName");
        p.i(args, "args");
        try {
            Class<?> clsD = d(className);
            ArrayList arrayList = new ArrayList(args.length);
            int length = args.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = args[i10];
                arrayList.add(obj != null ? obj.getClass() : Object.class);
            }
            Method methodB = b(clsD, methodName, (Class[]) arrayList.toArray(new Class[0]));
            if (methodB != null) {
                methodB.setAccessible(true);
                return (T) methodB.invoke(null, Arrays.copyOf(args, args.length));
            }
            throw new ReflectionException("静态方法未找到: " + methodName, null, 2, null);
        } catch (Exception e10) {
            throw new ReflectionException("调用Java静态方法失败: " + className + "." + methodName, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.reflect.Method b(java.lang.Class<?> r12, java.lang.String r13, java.lang.Class<java.lang.Object>[] r14) throws java.lang.SecurityException {
        /*
            r11 = this;
            int r11 = r14.length     // Catch: java.lang.NoSuchMethodException -> Lc
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r14, r11)     // Catch: java.lang.NoSuchMethodException -> Lc
            java.lang.Class[] r11 = (java.lang.Class[]) r11     // Catch: java.lang.NoSuchMethodException -> Lc
            java.lang.reflect.Method r11 = r12.getDeclaredMethod(r13, r11)     // Catch: java.lang.NoSuchMethodException -> Lc
            return r11
        Lc:
            java.lang.reflect.Method[] r11 = r12.getDeclaredMethods()
            java.lang.String r12 = "getDeclaredMethods(...)"
            kotlin.jvm.internal.p.h(r11, r12)
            int r12 = r11.length
            r0 = 0
            r1 = r0
        L18:
            if (r1 >= r12) goto L95
            r2 = r11[r1]
            java.lang.String r3 = r2.getName()
            boolean r3 = kotlin.jvm.internal.p.d(r3, r13)
            if (r3 == 0) goto L92
            int r3 = r2.getParameterCount()
            int r4 = r14.length
            if (r3 != r4) goto L92
            java.lang.Class[] r3 = r2.getParameterTypes()
            java.lang.String r4 = "getParameterTypes(...)"
            kotlin.jvm.internal.p.h(r3, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r3.length
            r4.<init>(r5)
            int r5 = r3.length
            r6 = r0
            r7 = r6
        L3f:
            if (r6 >= r5) goto L69
            r8 = r3[r6]
            int r9 = r7 + 1
            r10 = r14[r7]
            boolean r10 = r10.isAssignableFrom(r8)
            if (r10 != 0) goto L5d
            d7.a r10 = d7.C3959a.f32137a
            r7 = r14[r7]
            kotlin.jvm.internal.p.f(r8)
            boolean r7 = r10.c(r7, r8)
            if (r7 == 0) goto L5b
            goto L5d
        L5b:
            r7 = r0
            goto L5e
        L5d:
            r7 = 1
        L5e:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r4.add(r7)
            int r6 = r6 + 1
            r7 = r9
            goto L3f
        L69:
            boolean r3 = r4.isEmpty()
            if (r3 == 0) goto L70
            goto L87
        L70:
            java.util.Iterator r3 = r4.iterator()
        L74:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L87
            java.lang.Object r4 = r3.next()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L74
            goto L92
        L87:
            int r3 = r2.getModifiers()
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)
            if (r3 == 0) goto L92
            goto L96
        L92:
            int r1 = r1 + 1
            goto L18
        L95:
            r2 = 0
        L96:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.C3959a.b(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public final boolean c(Class<?> source, Class<?> target) {
        Class cls = Integer.TYPE;
        Pair pairA = j.a(cls, cls);
        Class cls2 = Long.TYPE;
        Pair pairA2 = j.a(cls2, cls2);
        Class cls3 = Double.TYPE;
        Pair pairA3 = j.a(cls3, cls3);
        Class cls4 = Float.TYPE;
        Pair pairA4 = j.a(cls4, cls4);
        Class cls5 = Boolean.TYPE;
        Pair pairA5 = j.a(cls5, cls5);
        Class cls6 = Character.TYPE;
        Pair pairA6 = j.a(cls6, cls6);
        Class cls7 = Byte.TYPE;
        Pair pairA7 = j.a(cls7, cls7);
        Class cls8 = Short.TYPE;
        Map mapM = kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, pairA7, j.a(cls8, cls8));
        return p.d(mapM.get(source), target) || p.d(mapM.get(target), source);
    }

    public final Class<?> d(String className) {
        p.i(className, "className");
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e10) {
            throw new ReflectionException("Java类未找到: " + className, e10);
        }
    }
}
