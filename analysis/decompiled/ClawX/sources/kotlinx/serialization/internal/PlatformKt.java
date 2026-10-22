package kotlinx.serialization.internal;

import a6.w;
import b5.a0;
import b5.n;
import b5.s;
import b5.u;
import b5.y;
import com.stepos.stepclaw.SecurePrefs;
import d5.g;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.z;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000`\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0088\u0004¢\u0006\u0002\u0010\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0088\u0004\u001a\u001e\u0010\b\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\nH\u0080\u0080\u0004\u001a&\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\nH\u0080\u0080\u0004\u001aM\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0002\"\b\b\u0000\u0010\u0001*\u00020\t\"\n\b\u0001\u0010\u000e*\u0004\u0018\u0001H\u0001*\u0012\u0012\u0004\u0012\u0002H\u000e0\u000fj\b\u0012\u0004\u0012\u0002H\u000e`\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0080\u0080\u0004¢\u0006\u0002\u0010\u0012\u001a\u0012\u0010\u0013\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030\nH\u0080\u0080\u0004\u001a\u0012\u0010\u0015\u001a\u00020\u0014*\u0006\u0012\u0002\b\u00030\u0016H\u0080\u0080\u0004\u001aO\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\n2\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0080\u0080\u0004¢\u0006\u0002\u0010\u0019\u001aO\u0010\u0017\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0080\u0080\u0004¢\u0006\u0002\u0010\u001a\u001aO\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0082\u0080\u0004¢\u0006\u0002\u0010\u001a\u001a \u0010\u001c\u001a\u0004\u0018\u00010\t\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0082\u0080\u0004\u001a\u001e\u0010\u001d\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0082\u0080\u0004\u001a\u001e\u0010\u001e\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0082\u0080\u0004\u001aQ\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u00162\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0082\u0080\u0004¢\u0006\u0002\u0010\u001a\u001aM\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t2\u0006\u0010\"\u001a\u00020\t2\"\u0010\u0018\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f0\u0002\"\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\fH\u0082\u0080\u0004¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010%\u001a\u00020&H\u0082\u0080\u0004\u001a$\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0082\u0080\u0004\u001a&\u0010(\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\f\"\b\b\u0000\u0010\u0001*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00010\u0016H\u0082\u0080\u0004\u001a\u0018\u0010)\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\nH\u0080\u0080\u0004\u001a\u001e\u0010+\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0,H\u0080\u0080\u0004\u001a\u0018\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.00H\u0082\u0088\u0004¨\u00061"}, d2 = {"getChecked", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "index", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "([Ljava/lang/Object;I)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isInterface", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/reflect/KClass;", "compiledSerializerImpl", "Lkotlinx/serialization/KSerializer;", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "platformSpecificSerializerNotRegistered", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serializerNotRegistered", "Ljava/lang/Class;", "constructSerializerForGivenTypeArgs", "args", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "findInNamedCompanion", "findNamedCompanionByAnnotation", "isNotAnnotated", "isPolymorphicSerializer", "invokeSerializerOnDefaultCompanion", "jClass", "invokeSerializerOnCompanion", "companion", "(Ljava/lang/Object;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "companionOrNull", "companionName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "createEnumSerializer", "findObjectSerializer", "isReferenceArray", "rootClass", "initBuiltins", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "loadSafe", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "block", "Lkotlin/Function0;", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformKt {
    private static final Object companionOrNull(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final <T> KSerializer<T> compiledSerializerImpl(v5.c cVar) {
        p.e(cVar, "<this>");
        return constructSerializerForGivenTypeArgs(cVar, (KSerializer<Object>[]) new KSerializer[0]);
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(v5.c cVar, KSerializer<Object>... args) {
        p.e(cVar, "<this>");
        p.e(args, "args");
        return constructSerializerForGivenTypeArgs(v.I(cVar), (KSerializer<Object>[]) Arrays.copyOf(args, args.length));
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> cls) {
        T[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        p.d(canonicalName, "getCanonicalName(...)");
        p.c(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    private static final <T> KSerializer<T> findInNamedCompanion(Class<T> cls, KSerializer<Object>... kSerializerArr) {
        Field field;
        KSerializer<T> kSerializerInvokeSerializerOnCompanion;
        Object objFindNamedCompanionByAnnotation = findNamedCompanionByAnnotation(cls);
        if (objFindNamedCompanionByAnnotation != null && (kSerializerInvokeSerializerOnCompanion = invokeSerializerOnCompanion(objFindNamedCompanionByAnnotation, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length))) != null) {
            return kSerializerInvokeSerializerOnCompanion;
        }
        try {
            Class<?>[] declaredClasses = cls.getDeclaredClasses();
            p.d(declaredClasses, "getDeclaredClasses(...)");
            int length = declaredClasses.length;
            int i8 = 0;
            Class<?> cls2 = null;
            boolean z = false;
            while (true) {
                if (i8 < length) {
                    Class<?> cls3 = declaredClasses[i8];
                    if (cls3.getSimpleName().equals("$serializer")) {
                        if (z) {
                            break;
                        }
                        z = true;
                        cls2 = cls3;
                    }
                    i8++;
                } else if (!z) {
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

    private static final <T> Object findNamedCompanionByAnnotation(Class<T> cls) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        p.d(declaredFields, "getDeclaredFields(...)");
        int length = declaredFields.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                field = null;
                break;
            }
            field = declaredFields[i8];
            if (Modifier.isStatic(field.getModifiers()) && field.getType().getAnnotation(NamedCompanion.class) != null) {
                break;
            }
            i8++;
        }
        if (field == null) {
            return null;
        }
        try {
            field.setAccessible(true);
            return field.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0095, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final <T> kotlinx.serialization.KSerializer<T> findObjectSerializer(java.lang.Class<T> r11) throws java.lang.IllegalAccessException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            java.lang.String r0 = r11.getCanonicalName()
            r1 = 0
            if (r0 == 0) goto Lad
            java.lang.String r2 = "java."
            r3 = 0
            boolean r2 = x5.u.c1(r0, r2, r3)
            if (r2 != 0) goto Lad
            java.lang.String r2 = "kotlin."
            boolean r0 = x5.u.c1(r0, r2, r3)
            if (r0 == 0) goto L1a
            goto Lad
        L1a:
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r2 = "getDeclaredFields(...)"
            kotlin.jvm.internal.p.d(r0, r2)
            int r2 = r0.length
            r6 = r1
            r4 = r3
            r5 = r4
        L27:
            r7 = 1
            if (r4 >= r2) goto L55
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.p.a(r9, r10)
            if (r9 == 0) goto L52
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.p.a(r9, r11)
            if (r9 == 0) goto L52
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L52
            if (r5 == 0) goto L50
        L4e:
            r6 = r1
            goto L58
        L50:
            r5 = r7
            r6 = r8
        L52:
            int r4 = r4 + 1
            goto L27
        L55:
            if (r5 != 0) goto L58
            goto L4e
        L58:
            if (r6 != 0) goto L5b
            goto Lad
        L5b:
            java.lang.Object r0 = r6.get(r1)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r2 = "getMethods(...)"
            kotlin.jvm.internal.p.d(r11, r2)
            int r2 = r11.length
            r5 = r1
            r4 = r3
        L6b:
            if (r3 >= r2) goto L9c
            r6 = r11[r3]
            java.lang.String r8 = r6.getName()
            java.lang.String r9 = "serializer"
            boolean r8 = kotlin.jvm.internal.p.a(r8, r9)
            if (r8 == 0) goto L99
            java.lang.Class[] r8 = r6.getParameterTypes()
            java.lang.String r9 = "getParameterTypes(...)"
            kotlin.jvm.internal.p.d(r8, r9)
            int r8 = r8.length
            if (r8 != 0) goto L99
            java.lang.Class r8 = r6.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r9 = kotlinx.serialization.KSerializer.class
            boolean r8 = kotlin.jvm.internal.p.a(r8, r9)
            if (r8 == 0) goto L99
            if (r4 == 0) goto L97
        L95:
            r5 = r1
            goto L9f
        L97:
            r5 = r6
            r4 = r7
        L99:
            int r3 = r3 + 1
            goto L6b
        L9c:
            if (r4 != 0) goto L9f
            goto L95
        L9f:
            if (r5 != 0) goto La2
            goto Lad
        La2:
            java.lang.Object r11 = r5.invoke(r0, r1)
            boolean r0 = r11 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto Lad
            kotlinx.serialization.KSerializer r11 = (kotlinx.serialization.KSerializer) r11
            return r11
        Lad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.findObjectSerializer(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final <T> T getChecked(T[] tArr, int i8) {
        p.e(tArr, "<this>");
        return tArr[i8];
    }

    public static final Map<v5.c, KSerializer<?>> initBuiltins() {
        g gVar = new g();
        gVar.put(z.a(String.class), BuiltinSerializersKt.serializer(c0.f3665a));
        gVar.put(z.a(Character.TYPE), BuiltinSerializersKt.serializer(f.f3669a));
        gVar.put(z.a(char[].class), BuiltinSerializersKt.CharArraySerializer());
        gVar.put(z.a(Double.TYPE), BuiltinSerializersKt.serializer(j.f3675a));
        gVar.put(z.a(double[].class), BuiltinSerializersKt.DoubleArraySerializer());
        gVar.put(z.a(Float.TYPE), BuiltinSerializersKt.serializer(k.f3676a));
        gVar.put(z.a(float[].class), BuiltinSerializersKt.FloatArraySerializer());
        gVar.put(z.a(Long.TYPE), BuiltinSerializersKt.serializer(r.f3680a));
        gVar.put(z.a(long[].class), BuiltinSerializersKt.LongArraySerializer());
        gVar.put(z.a(u.class), BuiltinSerializersKt.serializer(u.f914b));
        gVar.put(z.a(Integer.TYPE), BuiltinSerializersKt.serializer(o.f3677a));
        gVar.put(z.a(int[].class), BuiltinSerializersKt.IntArraySerializer());
        gVar.put(z.a(b5.r.class), BuiltinSerializersKt.serializer(b5.r.f911b));
        gVar.put(z.a(Short.TYPE), BuiltinSerializersKt.serializer(b0.f3663a));
        gVar.put(z.a(short[].class), BuiltinSerializersKt.ShortArraySerializer());
        gVar.put(z.a(y.class), BuiltinSerializersKt.serializer(y.f918b));
        gVar.put(z.a(Byte.TYPE), BuiltinSerializersKt.serializer(kotlin.jvm.internal.c.f3664a));
        gVar.put(z.a(byte[].class), BuiltinSerializersKt.ByteArraySerializer());
        gVar.put(z.a(n.class), BuiltinSerializersKt.serializer(n.f905b));
        gVar.put(z.a(Boolean.TYPE), BuiltinSerializersKt.serializer(kotlin.jvm.internal.b.f3662a));
        gVar.put(z.a(boolean[].class), BuiltinSerializersKt.BooleanArraySerializer());
        gVar.put(z.a(a0.class), BuiltinSerializersKt.serializer(a0.f883a));
        gVar.put(z.a(Void.class), BuiltinSerializersKt.NothingSerializer());
        try {
            gVar.put(z.a(y5.b.class), BuiltinSerializersKt.serializer(y5.b.f6335b));
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            gVar.put(z.a(b5.v.class), BuiltinSerializersKt.ULongArraySerializer());
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            gVar.put(z.a(s.class), BuiltinSerializersKt.UIntArraySerializer());
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            gVar.put(z.a(b5.z.class), BuiltinSerializersKt.UShortArraySerializer());
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            gVar.put(z.a(b5.p.class), BuiltinSerializersKt.UByteArraySerializer());
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            gVar.put(z.a(z5.b.class), BuiltinSerializersKt.serializer(z5.b.f6542c));
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        try {
            gVar.put(z.a(y5.f.class), BuiltinSerializersKt.serializer(y5.f.f6347c));
        } catch (ClassNotFoundException | NoClassDefFoundError unused7) {
        }
        return gVar.b();
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Object obj, KSerializer<Object>... kSerializerArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class[] clsArr;
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i8 = 0; i8 < length; i8++) {
                    clsArr2[i8] = KSerializer.class;
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
        } catch (InvocationTargetException e9) {
            Throwable cause = e9.getCause();
            if (cause == null) {
                throw e9;
            }
            String message = cause.getMessage();
            if (message == null) {
                message = e9.getMessage();
            }
            throw new InvocationTargetException(cause, message);
        }
    }

    private static final <T> KSerializer<T> invokeSerializerOnDefaultCompanion(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        Object objCompanionOrNull = companionOrNull(cls, "Companion");
        if (objCompanionOrNull == null) {
            return null;
        }
        return invokeSerializerOnCompanion(objCompanionOrNull, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final <T> boolean isInterface(v5.c cVar) {
        p.e(cVar, "<this>");
        return v.I(cVar).isInterface();
    }

    private static final <T> boolean isNotAnnotated(Class<T> cls) {
        return cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null;
    }

    private static final <T> boolean isPolymorphicSerializer(Class<T> cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        return serializable != null && z.a(serializable.with()).equals(z.a(PolymorphicSerializer.class));
    }

    public static final boolean isReferenceArray(v5.c rootClass) {
        p.e(rootClass, "rootClass");
        return v.I(rootClass).isArray();
    }

    private static final void loadSafe(p5.a aVar) {
        try {
            aVar.invoke();
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
    }

    public static final Void platformSpecificSerializerNotRegistered(v5.c cVar) {
        p.e(cVar, "<this>");
        Platform_commonKt.serializerNotRegistered(cVar);
        throw new w();
    }

    public static final Void serializerNotRegistered(Class<?> cls) {
        p.e(cls, "<this>");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(z.a(cls)));
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> arrayList, v5.c eClass) throws NegativeArraySizeException {
        p.e(arrayList, "<this>");
        p.e(eClass, "eClass");
        Object objNewInstance = Array.newInstance((Class<?>) v.I(eClass), arrayList.size());
        p.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] eArr = (E[]) arrayList.toArray((Object[]) objNewInstance);
        p.d(eArr, "toArray(...)");
        return eArr;
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(Class<T> cls, KSerializer<Object>... args) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        p.e(cls, "<this>");
        p.e(args, "args");
        if (cls.isEnum() && isNotAnnotated(cls)) {
            return createEnumSerializer(cls);
        }
        KSerializer<T> kSerializerInvokeSerializerOnDefaultCompanion = invokeSerializerOnDefaultCompanion(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (kSerializerInvokeSerializerOnDefaultCompanion != null) {
            return kSerializerInvokeSerializerOnDefaultCompanion;
        }
        KSerializer<T> kSerializerFindObjectSerializer = findObjectSerializer(cls);
        if (kSerializerFindObjectSerializer != null) {
            return kSerializerFindObjectSerializer;
        }
        KSerializer<T> kSerializerFindInNamedCompanion = findInNamedCompanion(cls, (KSerializer[]) Arrays.copyOf(args, args.length));
        if (kSerializerFindInNamedCompanion != null) {
            return kSerializerFindInNamedCompanion;
        }
        if (isPolymorphicSerializer(cls)) {
            return new PolymorphicSerializer(z.a(cls));
        }
        return null;
    }

    public static final boolean getChecked(boolean[] zArr, int i8) {
        p.e(zArr, "<this>");
        return zArr[i8];
    }
}
