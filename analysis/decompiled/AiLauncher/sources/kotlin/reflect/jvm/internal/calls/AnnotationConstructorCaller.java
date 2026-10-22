package kotlin.reflect.jvm.internal.calls;

import A9.e;
import A9.g;
import A9.i;
import K9.C0925f;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.enums.a;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002)*BA\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u0015\u0010\u001eR\u001e\u0010!\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0018R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0016\u0010%\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010$R\u0014\u0010(\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "LA9/g;", "", "Ljava/lang/Class;", "jClass", "", "", "parameterNames", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "origin", "Ljava/lang/reflect/Method;", SystemDeleteBroadcastReceiver.EXTRA_METHODS, "<init>", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Ljava/lang/Class;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", "c", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", Const.INTENT_KEY_UMID, "Ljava/lang/reflect/Type;", "e", "()Ljava/util/List;", "parameterTypes", "f", "erasedParameterTypes", Const.INTENT_KEY_BACKGROUND_COMMAND, "defaultValues", "()Ljava/lang/Void;", "member", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnnotationConstructorCaller implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Class<?> jClass;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<String> parameterNames;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CallMode callMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<Method> methods;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final List<Type> parameterTypes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final List<Class<?>> erasedParameterTypes;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final List<Object> defaultValues;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "<init>", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CallMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ CallMode[] $VALUES;
        public static final CallMode CALL_BY_NAME = new CallMode("CALL_BY_NAME", 0);
        public static final CallMode POSITIONAL_CALL = new CallMode("POSITIONAL_CALL", 1);

        private static final /* synthetic */ CallMode[] $values() {
            return new CallMode[]{CALL_BY_NAME, POSITIONAL_CALL};
        }

        static {
            CallMode[] callModeArr$values = $values();
            $VALUES = callModeArr$values;
            $ENTRIES = a.a(callModeArr$values);
        }

        private CallMode(String str, int i10) {
        }

        public static CallMode valueOf(String str) {
            return (CallMode) Enum.valueOf(CallMode.class, str);
        }

        public static CallMode[] values() {
            return (CallMode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Origin {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Origin[] $VALUES;
        public static final Origin JAVA = new Origin("JAVA", 0);
        public static final Origin KOTLIN = new Origin("KOTLIN", 1);

        private static final /* synthetic */ Origin[] $values() {
            return new Origin[]{JAVA, KOTLIN};
        }

        static {
            Origin[] originArr$values = $values();
            $VALUES = originArr$values;
            $ENTRIES = a.a(originArr$values);
        }

        private Origin(String str, int i10) {
        }

        public static Origin valueOf(String str) {
            return (Origin) Enum.valueOf(Origin.class, str);
        }

        public static Origin[] values() {
            return (Origin[]) $VALUES.clone();
        }
    }

    public AnnotationConstructorCaller(Class<?> jClass, List<String> parameterNames, CallMode callMode, Origin origin, List<Method> methods) {
        p.i(jClass, "jClass");
        p.i(parameterNames, "parameterNames");
        p.i(callMode, "callMode");
        p.i(origin, "origin");
        p.i(methods, "methods");
        this.jClass = jClass;
        this.parameterNames = parameterNames;
        this.callMode = callMode;
        this.methods = methods;
        List<Method> list = methods;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.parameterTypes = arrayList;
        List<Method> list2 = this.methods;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            p.f(returnType);
            Class<?> clsK = C0925f.k(returnType);
            if (clsK != null) {
                returnType = clsK;
            }
            arrayList2.add(returnType);
        }
        this.erasedParameterTypes = arrayList2;
        List<Method> list3 = this.methods;
        ArrayList arrayList3 = new ArrayList(C1174w.x(list3, 10));
        Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.defaultValues = arrayList3;
        if (this.callMode == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && !F.O0(this.parameterNames, UxipConstants.f30680s).isEmpty()) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // A9.g
    public List<Type> a() {
        return this.parameterTypes;
    }

    @Override // A9.g
    public /* bridge */ boolean b() {
        return e();
    }

    public /* bridge */ void c(Object[] objArr) {
        d(objArr);
    }

    @Override // A9.g
    public Object call(Object[] args) {
        p.i(args, "args");
        c(args);
        ArrayList arrayList = new ArrayList(args.length);
        int length = args.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            Object obj = args[i10];
            int i12 = i11 + 1;
            Object objQ = (obj == null && this.callMode == CallMode.CALL_BY_NAME) ? this.defaultValues.get(i11) : e.q(obj, this.erasedParameterTypes.get(i11));
            if (objQ == null) {
                e.p(i11, this.parameterNames.get(i11), this.erasedParameterTypes.get(i11));
                throw new KotlinNothingValueException();
            }
            arrayList.add(objQ);
            i10++;
            i11 = i12;
        }
        return e.g(this.jClass, kotlin.collections.a.y(F.w1(this.parameterNames, arrayList)), this.methods);
    }

    public void d(Object[] args) {
        p.i(args, "args");
        if (i.a(this) == args.length) {
            return;
        }
        throw new IllegalArgumentException("Callable expects " + i.a(this) + " arguments, but " + args.length + " were provided.");
    }

    public boolean e() {
        return false;
    }

    public Void f() {
        return null;
    }

    @Override // A9.g
    public /* bridge */ /* synthetic */ Member getMember() {
        return (Member) f();
    }

    @Override // A9.g
    public Type getReturnType() {
        return this.jClass;
    }

    public /* synthetic */ AnnotationConstructorCaller(Class cls, List list, CallMode callMode, Origin origin, List list2, int i10, kotlin.jvm.internal.i iVar) {
        List list3;
        if ((i10 & 16) != 0) {
            List list4 = list;
            ArrayList arrayList = new ArrayList(C1174w.x(list4, 10));
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list3 = arrayList;
        } else {
            list3 = list2;
        }
        this(cls, list, callMode, origin, list3);
    }
}
