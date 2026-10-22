package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;

/* JADX INFO: compiled from: KCallablesJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KCallablesJvm {
    public static final boolean isAccessible(KCallable<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KMutableProperty) == false) goto L21;
        KProperty r0 = (KProperty) r5;
        Field r3 = ReflectJvmMapping.getJavaField(r0);
        if (r3 == null) goto L7;
        boolean r4 = r3.isAccessible();
    L8:
        if (r4 == false) goto L85;
        Method r1 = ReflectJvmMapping.getJavaGetter(r0);
        if (r1 == null) goto L12;
        boolean r2 = r1.isAccessible();
    L13:
        if (r2 == false) goto L88;
        Method r6 = ReflectJvmMapping.getJavaSetter((KMutableProperty) r5);
        if (r6 == null) goto L17;
        boolean r7 = r6.isAccessible();
    L18:
        if (r7 == true) goto L92;
        return false;
    L92:
        return true;
    L17:
        r7 = true;
        goto L18
    L88:
        return false;
    L12:
        r2 = true;
        goto L13
    L85:
        return false;
    L7:
        r4 = true;
        goto L8
    L21:
        if ((r5 instanceof KProperty) == false) goto L34;
        KProperty r8 = (KProperty) r5;
        Field r9 = ReflectJvmMapping.getJavaField(r8);
        if (r9 == null) goto L25;
        boolean r10 = r9.isAccessible();
    L26:
        if (r10 == false) goto L90;
        Method r11 = ReflectJvmMapping.getJavaGetter(r8);
        if (r11 == null) goto L30;
        boolean r12 = r11.isAccessible();
    L31:
        if (r12 == true) goto L92;
        return false;
    L30:
        r12 = true;
        goto L31
    L90:
        return false;
    L25:
        r10 = true;
        goto L26
    L34:
        if ((r5 instanceof KProperty.Getter) == false) goto L47;
        Field r13 = ReflectJvmMapping.getJavaField(((KProperty.Getter) r5).getProperty());
        if (r13 == null) goto L38;
        boolean r14 = r13.isAccessible();
    L39:
        if (r14 == false) goto L93;
        Method r15 = ReflectJvmMapping.getJavaMethod((KFunction) r5);
        if (r15 == null) goto L43;
        boolean r16 = r15.isAccessible();
    L44:
        if (r16 == true) goto L92;
        return false;
    L43:
        r16 = true;
        goto L44
    L93:
        return false;
    L38:
        r14 = true;
        goto L39
    L47:
        if ((r5 instanceof KMutableProperty.Setter) == false) goto L60;
        Field r17 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) r5).getProperty());
        if (r17 == null) goto L51;
        boolean r18 = r17.isAccessible();
    L52:
        if (r18 == false) goto L95;
        Method r19 = ReflectJvmMapping.getJavaMethod((KFunction) r5);
        if (r19 == null) goto L56;
        boolean r20 = r19.isAccessible();
    L57:
        if (r20 == true) goto L92;
        return false;
    L56:
        r20 = true;
        goto L57
    L95:
        return false;
    L51:
        r18 = true;
        goto L52
    L60:
        if ((r5 instanceof KFunction) == false) goto L87;
        KFunction r21 = (KFunction) r5;
        Method r22 = ReflectJvmMapping.getJavaMethod(r21);
        if (r22 == null) goto L64;
        boolean r23 = r22.isAccessible();
    L65:
        if (r23 == false) goto L97;
        KCallableImpl<?> r24 = UtilKt.asKCallableImpl(r5);
        AccessibleObject r25 = null;
        if (r24 == null) goto L71;
        Caller<?> r26 = r24.getDefaultCaller();
        if (r26 == null) goto L71;
        Member r27 = r26.mo2075getMember();
    L73:
        if ((r27 instanceof AccessibleObject) == false) goto L75;
        r25 = (AccessibleObject) r27;
    L75:
        if (r25 == null) goto L77;
        boolean r28 = r25.isAccessible();
    L78:
        if (r28 == false) goto L98;
        Constructor r29 = ReflectJvmMapping.getJavaConstructor(r21);
        if (r29 == null) goto L82;
        boolean r30 = r29.isAccessible();
    L83:
        if (r30 == true) goto L92;
        return false;
    L82:
        r30 = true;
        goto L83
    L98:
        return false;
    L77:
        r28 = true;
    L71:
        r27 = null;
        goto L73
    L97:
        return false;
    L64:
        r23 = true;
        goto L65
    L87:
        throw new UnsupportedOperationException("Unknown callable: " + r5 + " (" + r5.getClass() + ')');
    }

    public static final void setAccessible(KCallable<?> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof KMutableProperty) == false) goto L17;
        KProperty r0 = (KProperty) r3;
        Field r1 = ReflectJvmMapping.getJavaField(r0);
        if (r1 == null) goto L8;
        r1.setAccessible(r4);
    L8:
        Method r2 = ReflectJvmMapping.getJavaGetter(r0);
        if (r2 == null) goto L12;
        r2.setAccessible(r4);
    L12:
        Method r5 = ReflectJvmMapping.getJavaSetter((KMutableProperty) r3);
        if (r5 == null) goto L75;
        r5.setAccessible(r4);
        return;
    L75:
        return;
    L17:
        if ((r3 instanceof KProperty) == false) goto L27;
        KProperty r6 = (KProperty) r3;
        Field r7 = ReflectJvmMapping.getJavaField(r6);
        if (r7 == null) goto L22;
        r7.setAccessible(r4);
    L22:
        Method r8 = ReflectJvmMapping.getJavaGetter(r6);
        if (r8 == null) goto L76;
        r8.setAccessible(r4);
        return;
    L76:
        return;
    L27:
        if ((r3 instanceof KProperty.Getter) == false) goto L37;
        Field r9 = ReflectJvmMapping.getJavaField(((KProperty.Getter) r3).getProperty());
        if (r9 == null) goto L32;
        r9.setAccessible(r4);
    L32:
        Method r10 = ReflectJvmMapping.getJavaMethod((KFunction) r3);
        if (r10 == null) goto L77;
        r10.setAccessible(r4);
        return;
    L77:
        return;
    L37:
        if ((r3 instanceof KMutableProperty.Setter) == false) goto L47;
        Field r11 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) r3).getProperty());
        if (r11 == null) goto L42;
        r11.setAccessible(r4);
    L42:
        Method r12 = ReflectJvmMapping.getJavaMethod((KFunction) r3);
        if (r12 == null) goto L78;
        r12.setAccessible(r4);
        return;
    L78:
        return;
    L47:
        if ((r3 instanceof KFunction) == false) goto L70;
        KFunction r13 = (KFunction) r3;
        Method r14 = ReflectJvmMapping.getJavaMethod(r13);
        if (r14 == null) goto L52;
        r14.setAccessible(r4);
    L52:
        KCallableImpl<?> r15 = UtilKt.asKCallableImpl(r3);
        AccessibleObject r16 = null;
        if (r15 == null) goto L57;
        Caller<?> r17 = r15.getDefaultCaller();
        if (r17 == null) goto L57;
        Member r18 = r17.mo2075getMember();
    L59:
        if ((r18 instanceof AccessibleObject) == false) goto L61;
        r16 = (AccessibleObject) r18;
    L61:
        if (r16 == null) goto L64;
        r16.setAccessible(true);
    L64:
        Constructor r19 = ReflectJvmMapping.getJavaConstructor(r13);
        if (r19 == null) goto L79;
        r19.setAccessible(r4);
        return;
    L79:
        return;
    L57:
        r18 = null;
        goto L59
    L70:
        throw new UnsupportedOperationException("Unknown callable: " + r3 + " (" + r3.getClass() + ')');
    }
}
