package kotlin.reflect.jvm.internal.calls;

import com.google.common.net.HttpHeaders;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002 !B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016¢\u0006\u0002\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", HttpHeaders.ORIGIN, "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnnotationConstructorCaller implements Caller {
    private final CallMode callMode;
    private final List<Object> defaultValues;
    private final List<Class<?>> erasedParameterTypes;
    private final Class<?> jClass;
    private final List<Method> methods;
    private final List<String> parameterNames;
    private final List<Type> parameterTypes;

    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum CallMode extends Enum<CallMode> {
        private static final /* synthetic */ CallMode[] $VALUES = null;
        public static final CallMode CALL_BY_NAME = null;
        public static final CallMode POSITIONAL_CALL = null;

        private static final /* synthetic */ CallMode[] $values() {
            return new CallMode[]{CALL_BY_NAME, POSITIONAL_CALL};
        }

        public static CallMode valueOf(String r1) {
            return (CallMode) Enum.valueOf(CallMode.class, r1);
        }

        public static CallMode[] values() {
            return (CallMode[]) $VALUES.clone();
        }

        static {
            CALL_BY_NAME = new CallMode("CALL_BY_NAME", 0);
            POSITIONAL_CALL = new CallMode("POSITIONAL_CALL", 1);
            $VALUES = $values();
        }

        private CallMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Origin extends Enum<Origin> {
        private static final /* synthetic */ Origin[] $VALUES = null;
        public static final Origin JAVA = null;
        public static final Origin KOTLIN = null;

        private static final /* synthetic */ Origin[] $values() {
            return new Origin[]{JAVA, KOTLIN};
        }

        public static Origin valueOf(String r1) {
            return (Origin) Enum.valueOf(Origin.class, r1);
        }

        public static Origin[] values() {
            return (Origin[]) $VALUES.clone();
        }

        static {
            JAVA = new Origin("JAVA", 0);
            KOTLIN = new Origin("KOTLIN", 1);
            $VALUES = $values();
        }

        private Origin(String r1, int r2) {
            super(r1, r2);
        }
    }

    public Void getMember() {
        return null;
    }

    public AnnotationConstructorCaller(Class<?> r2, List<String> r3, CallMode r4, Origin r5, List<Method> r6) {
        Intrinsics.checkNotNullParameter(r2, "jClass");
        Intrinsics.checkNotNullParameter(r3, "parameterNames");
        Intrinsics.checkNotNullParameter(r4, "callMode");
        Intrinsics.checkNotNullParameter(r5, "origin");
        Intrinsics.checkNotNullParameter(r6, "methods");
        this.jClass = r2;
        this.parameterNames = r3;
        this.callMode = r4;
        this.methods = r6;
        List<Method> r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r8.add(((Method) r9.next()).getGenericReturnType());
        goto L4
    L6:
        this.parameterTypes = r8;
        List<Method> r10 = this.methods;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r12 = r10.iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        Class<?> r13 = ((Method) r12.next()).getReturnType();
        Intrinsics.checkNotNullExpressionValue(r13, "it");
        Class<?> r0 = ReflectClassUtilKt.getWrapperByPrimitive(r13);
        if (r0 == null) goto L13;
        r13 = r0;
    L13:
        r11.add(r13);
        goto L8
    L14:
        this.erasedParameterTypes = r11;
        List<Method> r14 = this.methods;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L16:
        if (r16.hasNext() == false) goto L18;
        r15.add(((Method) r16.next()).getDefaultValue());
        goto L16
    L18:
        this.defaultValues = r15;
        if (this.callMode == CallMode.POSITIONAL_CALL) goto L21;
        return;
    L21:
        if (r5 == Origin.JAVA) goto L23;
        return;
    L23:
        if ((!CollectionsKt.minus(this.parameterNames, "value").isEmpty()) == true) goto L26;
        return;
    L26:
        throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
    }

    public void checkArguments(Object[] r1) {
        Caller.DefaultImpls.checkArguments(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo2075getMember() {
        return (Member) getMember();
    }

    public /* synthetic */ AnnotationConstructorCaller(Class r7, List r8, CallMode r9, Origin r10, ArrayList r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L9;
        List r14 = r8;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r16 = r14.iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        r15.add(r7.getDeclaredMethod((String) r16.next(), new Class[0]));
        goto L6
    L8:
        r11 = r15;
    L9:
        this(r7, r8, r9, r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] r9) {
        Intrinsics.checkNotNullParameter(r9, "args");
        checkArguments(r9);
        ArrayList r0 = new ArrayList(r9.length);
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L15;
        Object r4 = r9[r2];
        int r5 = r3 + 1;
        if (r4 == null) goto L7;
    L9:
        Object r6 = AnnotationConstructorCallerKt.access$transformKotlinToJvm(r4, this.erasedParameterTypes.get(r3));
    L10:
        if (r6 == null) goto L12;
        r0.add(r6);
        r2 = r2 + 1;
        r3 = r5;
        goto L3
    L12:
        AnnotationConstructorCallerKt.access$throwIllegalArgumentType(r3, this.parameterNames.get(r3), this.erasedParameterTypes.get(r3));
        throw null;
    L7:
        if (this.callMode != CallMode.CALL_BY_NAME) goto L9;
        r6 = this.defaultValues.get(r3);
        goto L10
    L15:
        return AnnotationConstructorCallerKt.createAnnotationInstance(this.jClass, MapsKt.toMap(CollectionsKt.zip(this.parameterNames, r0)), this.methods);
    }
}
