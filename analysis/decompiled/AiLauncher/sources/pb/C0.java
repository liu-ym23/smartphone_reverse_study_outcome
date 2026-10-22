package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.C4852c;
import kotlin.time.Instant;
import kotlin.uuid.Uuid;
import kotlinx.serialization.KSerializer;
import lb.InterfaceC4884b;
import mb.C4931a;
import o9.C5013a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000L\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aM\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\n\b\u0001\u0010\t*\u0004\u0018\u00018\u0000*\u0012\u0012\u0004\u0012\u00028\u00010\nj\b\u0012\u0004\u0012\u00028\u0001`\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0011\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aO\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00060\r\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aO\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00162\"\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00060\r\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aO\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00162\"\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00060\r\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0018\u001a%\u0010\u001a\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u001c\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001e\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001d\u001aQ\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u00162\"\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00060\r\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0002¢\u0006\u0004\b \u0010\u0018\u001aM\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\"\u0010\u0013\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00060\r\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0006H\u0002¢\u0006\u0004\b\"\u0010#\u001a!\u0010&\u001a\u0004\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'\u001a)\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002¢\u0006\u0004\b(\u0010)\u001a+\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002¢\u0006\u0004\b*\u0010)\u001a\u001d\u0010,\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0000¢\u0006\u0004\b,\u0010\u0005\u001a#\u0010.\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060-H\u0000¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "", "l", "(Lw9/d;)Z", "Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_PKGNAME, "(Lw9/d;)Lkotlinx/serialization/KSerializer;", ExifInterface.LONGITUDE_EAST, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "", "q", "(Ljava/util/ArrayList;Lw9/d;)[Ljava/lang/Object;", "", "p", "(Lw9/d;)Ljava/lang/Void;", "args", Const.INTENT_KEY_UMID, "(Lw9/d;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "Ljava/lang/Class;", "c", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Class;)Ljava/lang/Object;", "m", "(Ljava/lang/Class;)Z", "n", "jClass", "k", "companion", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Object;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "companionName", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "e", "(Ljava/lang/Class;)Lkotlinx/serialization/KSerializer;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "rootClass", "o", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/Map;", "kotlinx-serialization-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class C0 {
    public static final Object a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final <T> KSerializer<T> b(InterfaceC5745d<T> interfaceC5745d) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        return d(interfaceC5745d, new KSerializer[0]);
    }

    public static final <T> KSerializer<T> c(Class<T> cls, KSerializer<Object>... args) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.p.i(cls, "<this>");
        kotlin.jvm.internal.p.i(args, "args");
        if (cls.isEnum() && m(cls)) {
            return e(cls);
        }
        KSerializer<T> kSerializerK = k(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (kSerializerK != null) {
            return kSerializerK;
        }
        KSerializer<T> kSerializerH = h(cls);
        if (kSerializerH != null) {
            return kSerializerH;
        }
        KSerializer<T> kSerializerF = f(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (kSerializerF != null) {
            return kSerializerF;
        }
        if (n(cls)) {
            return new lb.e(C5013a.e(cls));
        }
        return null;
    }

    public static final <T> KSerializer<T> d(InterfaceC5745d<T> interfaceC5745d, KSerializer<Object>... args) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        kotlin.jvm.internal.p.i(args, "args");
        return c(C5013a.b(interfaceC5745d), (KSerializer[]) Arrays.copyOf(args, args.length));
    }

    public static final <T> KSerializer<T> e(Class<T> cls) {
        T[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        kotlin.jvm.internal.p.h(canonicalName, "getCanonicalName(...)");
        kotlin.jvm.internal.p.g(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new H(canonicalName, (Enum[]) enumConstants);
    }

    public static final <T> KSerializer<T> f(Class<T> cls, KSerializer<Object>... kSerializerArr) {
        Field field;
        KSerializer<T> kSerializerJ;
        Object objG = g(cls);
        if (objG != null && (kSerializerJ = j(objG, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length))) != null) {
            return kSerializerJ;
        }
        try {
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            kotlin.jvm.internal.p.h(declaredClasses, "getDeclaredClasses(...)");
            int length = declaredClasses.length;
            int i10 = 0;
            Class<?> cls2 = null;
            boolean z10 = false;
            while (true) {
                if (i10 < length) {
                    Class<?> cls3 = declaredClasses[i10];
                    if (kotlin.jvm.internal.p.d(cls3.getSimpleName(), "$serializer")) {
                        if (z10) {
                            break;
                        }
                        z10 = true;
                        cls2 = cls3;
                    }
                    i10++;
                } else if (!z10) {
                }
            }
            cls2 = null;
            Object obj = (cls2 == null || (field = cls2.getField("INSTANCE")) == null) ? null : field.get(null);
            if (obj instanceof KSerializer) {
                return (KSerializer) obj;
            }
        } catch (NoSuchFieldException unused) {
        }
        return null;
    }

    public static final <T> Object g(Class<T> cls) {
        Class<?> cls2;
        Class<?>[] declaredClasses = cls.getDeclaredClasses();
        kotlin.jvm.internal.p.h(declaredClasses, "getDeclaredClasses(...)");
        int length = declaredClasses.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                cls2 = null;
                break;
            }
            cls2 = declaredClasses[i10];
            if (cls2.getAnnotation(InterfaceC5113o0.class) != null) {
                break;
            }
            i10++;
        }
        if (cls2 == null) {
            return null;
        }
        String simpleName = cls2.getSimpleName();
        kotlin.jvm.internal.p.h(simpleName, "getSimpleName(...)");
        return a(cls, simpleName);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> kotlinx.serialization.KSerializer<T> h(java.lang.Class<T> r11) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            java.lang.String r0 = r11.getCanonicalName()
            r1 = 0
            if (r0 == 0) goto Lae
            java.lang.String r2 = "java."
            r3 = 0
            r4 = 2
            boolean r2 = La.D.X(r0, r2, r3, r4, r1)
            if (r2 != 0) goto Lae
            java.lang.String r2 = "kotlin."
            boolean r0 = La.D.X(r0, r2, r3, r4, r1)
            if (r0 == 0) goto L1b
            goto Lae
        L1b:
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r2 = "getDeclaredFields(...)"
            kotlin.jvm.internal.p.h(r0, r2)
            int r2 = r0.length
            r6 = r1
            r4 = r3
            r5 = r4
        L28:
            r7 = 1
            if (r4 >= r2) goto L56
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.p.d(r9, r10)
            if (r9 == 0) goto L53
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.p.d(r9, r11)
            if (r9 == 0) goto L53
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L53
            if (r5 == 0) goto L51
        L4f:
            r6 = r1
            goto L59
        L51:
            r5 = r7
            r6 = r8
        L53:
            int r4 = r4 + 1
            goto L28
        L56:
            if (r5 != 0) goto L59
            goto L4f
        L59:
            if (r6 != 0) goto L5c
            return r1
        L5c:
            java.lang.Object r0 = r6.get(r1)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r2 = "getMethods(...)"
            kotlin.jvm.internal.p.h(r11, r2)
            int r2 = r11.length
            r5 = r1
            r4 = r3
        L6c:
            if (r3 >= r2) goto L9d
            r6 = r11[r3]
            java.lang.String r8 = r6.getName()
            java.lang.String r9 = "serializer"
            boolean r8 = kotlin.jvm.internal.p.d(r8, r9)
            if (r8 == 0) goto L9a
            java.lang.Class[] r8 = r6.getParameterTypes()
            java.lang.String r9 = "getParameterTypes(...)"
            kotlin.jvm.internal.p.h(r8, r9)
            int r8 = r8.length
            if (r8 != 0) goto L9a
            java.lang.Class r8 = r6.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r9 = kotlinx.serialization.KSerializer.class
            boolean r8 = kotlin.jvm.internal.p.d(r8, r9)
            if (r8 == 0) goto L9a
            if (r4 == 0) goto L98
        L96:
            r5 = r1
            goto La0
        L98:
            r5 = r6
            r4 = r7
        L9a:
            int r3 = r3 + 1
            goto L6c
        L9d:
            if (r4 != 0) goto La0
            goto L96
        La0:
            if (r5 != 0) goto La3
            return r1
        La3:
            java.lang.Object r11 = r5.invoke(r0, r1)
            boolean r0 = r11 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto Lae
            kotlinx.serialization.KSerializer r11 = (kotlinx.serialization.KSerializer) r11
            return r11
        Lae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.C0.h(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final Map<InterfaceC5745d<?>, KSerializer<?>> i() {
        Map mapC = Z8.Q.c();
        mapC.put(kotlin.jvm.internal.t.b(String.class), C4931a.H(kotlin.jvm.internal.y.f34840a));
        mapC.put(kotlin.jvm.internal.t.b(Character.TYPE), C4931a.B(kotlin.jvm.internal.e.f34825a));
        mapC.put(kotlin.jvm.internal.t.b(char[].class), C4931a.d());
        mapC.put(kotlin.jvm.internal.t.b(Double.TYPE), C4931a.C(kotlin.jvm.internal.j.f34830a));
        mapC.put(kotlin.jvm.internal.t.b(double[].class), C4931a.e());
        mapC.put(kotlin.jvm.internal.t.b(Float.TYPE), C4931a.D(kotlin.jvm.internal.k.f34831a));
        mapC.put(kotlin.jvm.internal.t.b(float[].class), C4931a.f());
        mapC.put(kotlin.jvm.internal.t.b(Long.TYPE), C4931a.F(kotlin.jvm.internal.r.f34833a));
        mapC.put(kotlin.jvm.internal.t.b(long[].class), C4931a.i());
        mapC.put(kotlin.jvm.internal.t.b(Y8.o.class), C4931a.w(Y8.o.INSTANCE));
        mapC.put(kotlin.jvm.internal.t.b(Integer.TYPE), C4931a.E(kotlin.jvm.internal.o.f34832a));
        mapC.put(kotlin.jvm.internal.t.b(int[].class), C4931a.g());
        mapC.put(kotlin.jvm.internal.t.b(Y8.m.class), C4931a.v(Y8.m.INSTANCE));
        mapC.put(kotlin.jvm.internal.t.b(Short.TYPE), C4931a.G(kotlin.jvm.internal.w.f34838a));
        mapC.put(kotlin.jvm.internal.t.b(short[].class), C4931a.n());
        mapC.put(kotlin.jvm.internal.t.b(Y8.r.class), C4931a.x(Y8.r.INSTANCE));
        mapC.put(kotlin.jvm.internal.t.b(Byte.TYPE), C4931a.A(kotlin.jvm.internal.d.f34824a));
        mapC.put(kotlin.jvm.internal.t.b(byte[].class), C4931a.c());
        mapC.put(kotlin.jvm.internal.t.b(Y8.k.class), C4931a.u(Y8.k.INSTANCE));
        mapC.put(kotlin.jvm.internal.t.b(Boolean.TYPE), C4931a.z(C4852c.f34823a));
        mapC.put(kotlin.jvm.internal.t.b(boolean[].class), C4931a.b());
        mapC.put(kotlin.jvm.internal.t.b(Y8.t.class), C4931a.y(Y8.t.f7040a));
        mapC.put(kotlin.jvm.internal.t.b(Void.class), C4931a.l());
        try {
            mapC.put(kotlin.jvm.internal.t.b(kotlin.time.a.class), C4931a.I(kotlin.time.a.INSTANCE));
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            mapC.put(kotlin.jvm.internal.t.b(Y8.p.class), C4931a.r());
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            mapC.put(kotlin.jvm.internal.t.b(Y8.n.class), C4931a.q());
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            mapC.put(kotlin.jvm.internal.t.b(Y8.s.class), C4931a.s());
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            mapC.put(kotlin.jvm.internal.t.b(Y8.l.class), C4931a.p());
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            mapC.put(kotlin.jvm.internal.t.b(Uuid.class), C4931a.K(Uuid.INSTANCE));
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        try {
            mapC.put(kotlin.jvm.internal.t.b(Instant.class), C4931a.J(Instant.INSTANCE));
        } catch (ClassNotFoundException | NoClassDefFoundError unused7) {
        }
        return Z8.Q.b(mapC);
    }

    public static final <T> KSerializer<T> j(Object obj, KSerializer<Object>... kSerializerArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] clsArr;
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i10 = 0; i10 < length; i10++) {
                    clsArr2[i10] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object objInvoke = obj.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(obj, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (objInvoke instanceof KSerializer) {
                return (KSerializer) objInvoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause == null) {
                throw e10;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e10.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    public static final <T> KSerializer<T> k(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        Object objA = a(cls, "Companion");
        if (objA == null) {
            return null;
        }
        return j(objA, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final <T> boolean l(InterfaceC5745d<T> interfaceC5745d) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        return C5013a.b(interfaceC5745d).isInterface();
    }

    public static final <T> boolean m(Class<T> cls) {
        return cls.getAnnotation(lb.l.class) == null && cls.getAnnotation(InterfaceC4884b.class) == null;
    }

    public static final <T> boolean n(Class<T> cls) {
        if (cls.getAnnotation(InterfaceC4884b.class) != null) {
            return true;
        }
        lb.l lVar = (lb.l) cls.getAnnotation(lb.l.class);
        return lVar != null && kotlin.jvm.internal.p.d(kotlin.jvm.internal.t.b(lVar.with()), kotlin.jvm.internal.t.b(lb.e.class));
    }

    public static final boolean o(InterfaceC5745d<Object> rootClass) {
        kotlin.jvm.internal.p.i(rootClass, "rootClass");
        return C5013a.b(rootClass).isArray();
    }

    public static final Void p(InterfaceC5745d<?> interfaceC5745d) {
        kotlin.jvm.internal.p.i(interfaceC5745d, "<this>");
        D0.f(interfaceC5745d);
        throw new KotlinNothingValueException();
    }

    public static final <T, E extends T> E[] q(ArrayList<E> arrayList, InterfaceC5745d<T> eClass) throws NegativeArraySizeException {
        kotlin.jvm.internal.p.i(arrayList, "<this>");
        kotlin.jvm.internal.p.i(eClass, "eClass");
        Object objNewInstance = Array.newInstance((Class<?>) C5013a.b(eClass), arrayList.size());
        kotlin.jvm.internal.p.g(objNewInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) objNewInstance);
        kotlin.jvm.internal.p.h(eArr, "toArray(...)");
        return eArr;
    }
}
