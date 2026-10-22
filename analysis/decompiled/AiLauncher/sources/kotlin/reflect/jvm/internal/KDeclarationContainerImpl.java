package kotlin.reflect.jvm.internal;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.O;
import K9.C0925f;
import La.D;
import La.H;
import Z8.F;
import Z8.Q;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import h9.InterfaceC4149a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.u;
import kotlin.text.Regex;
import w9.InterfaceC5752k;
import z9.C6401Y;
import z9.C6402Z;
import z9.C6404a0;
import z9.C6408c0;
import z9.C6423k;
import z9.P0;
import z9.c1;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000 K2\u00020\u0001:\u0004LMNKB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\tJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010 J'\u0010#\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u001b\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010%2\u0006\u0010\u001d\u001a\u00020\u0017¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010%2\u0006\u0010\u001d\u001a\u00020\u0017¢\u0006\u0004\b(\u0010'JG\u0010.\u001a\u0004\u0018\u00010\u001e*\u0006\u0012\u0002\b\u00030)2\u0006\u0010\u0005\u001a\u00020\u00172\u0010\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0*2\n\u0010,\u001a\u0006\u0012\u0002\b\u00030)2\u0006\u0010-\u001a\u00020!H\u0002¢\u0006\u0004\b.\u0010/J?\u00100\u001a\u0004\u0018\u00010\u001e*\u0006\u0012\u0002\b\u00030)2\u0006\u0010\u0005\u001a\u00020\u00172\u0010\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0*2\n\u0010,\u001a\u0006\u0012\u0002\b\u00030)H\u0002¢\u0006\u0004\b0\u00101J/\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u00010%*\u0006\u0012\u0002\b\u00030)2\u0010\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)02H\u0002¢\u0006\u0004\b3\u00104J;\u0010:\u001a\u0002092\u0010\u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)052\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)022\u0006\u00108\u001a\u00020!H\u0002¢\u0006\u0004\b:\u0010;J\u001f\u0010>\u001a\u00020=2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010<\u001a\u00020!H\u0002¢\u0006\u0004\b>\u0010?J+\u0010B\u001a\u0006\u0012\u0002\b\u00030)2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0002¢\u0006\u0004\bB\u0010CR\u0018\u0010F\u001a\u0006\u0012\u0002\b\u00030)8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020G0\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006O"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/f;", "<init>", "()V", "Lga/e;", "name", "", "LE9/O;", "M", "(Lga/e;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "I", "", "index", "J", "(I)LE9/O;", "Lra/k;", "scope", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "belonginess", "Lkotlin/reflect/jvm/internal/d;", "K", "(Lra/k;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;)Ljava/util/Collection;", "", "signature", "D", "(Ljava/lang/String;Ljava/lang/String;)LE9/O;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/reflect/jvm/internal/impl/descriptors/e;", Const.JSON_KEY_DESC, "Ljava/lang/reflect/Method;", "C", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/reflect/Method;", "", "isMember", "z", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Constructor;", "x", "(Ljava/lang/String;)Ljava/lang/reflect/Constructor;", "y", "Ljava/lang/Class;", "", "parameterTypes", "returnType", "isStaticDefault", "N", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "R", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "", "Q", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Constructor;", "", "result", "valueParameters", "isConstructor", "LY8/t;", "w", "(Ljava/util/List;Ljava/util/List;Z)V", "parseReturnType", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$c;", "O", "(Ljava/lang/String;Z)Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$c;", "begin", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "P", "(Ljava/lang/String;II)Ljava/lang/Class;", "L", "()Ljava/lang/Class;", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/descriptors/c;", "H", "()Ljava/util/Collection;", "constructorDescriptors", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "MemberBelonginess", "c", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KDeclarationContainerImpl implements kotlin.jvm.internal.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?> f34868b = kotlin.jvm.internal.i.class;

    /* renamed from: c, reason: collision with root package name */
    public static final Regex f34869c = new Regex("<v#(\\d+)>");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0084\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MemberBelonginess {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ MemberBelonginess[] $VALUES;
        public static final MemberBelonginess DECLARED = new MemberBelonginess("DECLARED", 0);
        public static final MemberBelonginess INHERITED = new MemberBelonginess("INHERITED", 1);

        private static final /* synthetic */ MemberBelonginess[] $values() {
            return new MemberBelonginess[]{DECLARED, INHERITED};
        }

        static {
            MemberBelonginess[] memberBelonginessArr$values = $values();
            $VALUES = memberBelonginessArr$values;
            $ENTRIES = kotlin.enums.a.a(memberBelonginessArr$values);
        }

        private MemberBelonginess(String str, int i10) {
        }

        public static MemberBelonginess valueOf(String str) {
            return (MemberBelonginess) Enum.valueOf(MemberBelonginess.class, str);
        }

        public static MemberBelonginess[] values() {
            return (MemberBelonginess[]) $VALUES.clone();
        }

        public final boolean accept(CallableMemberDescriptor member) {
            kotlin.jvm.internal.p.i(member, "member");
            return member.getKind().isReal() == (this == DECLARED);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0012\u0012\u0002\b\u0003 \n*\b\u0012\u0002\b\u0003\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$a;", "", "<init>", "()V", "Lkotlin/text/Regex;", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", Const.INTENT_KEY_APIKEY, "()Lkotlin/text/Regex;", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Regex a() {
            return KDeclarationContainerImpl.f34869c;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$b;", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "LJ9/k;", Const.INTENT_KEY_APIKEY, "Lkotlin/reflect/jvm/internal/u$a;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public abstract class b {

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC5752k<Object>[] f34870c = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0))};

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final u.a moduleData;

        public b() {
            this.moduleData = u.c(new C6408c0(KDeclarationContainerImpl.this));
        }

        public static final J9.k c(KDeclarationContainerImpl kDeclarationContainerImpl) {
            return P0.a(kDeclarationContainerImpl.m());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final J9.k b() {
            T tB = this.moduleData.b(this, f34870c[0]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (J9.k) tB;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$c;", "", "", "Ljava/lang/Class;", "parameters", "returnType", "<init>", "(Ljava/util/List;Ljava/lang/Class;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Class;", "()Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<Class<?>> parameters;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Class<?> returnType;

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends Class<?>> parameters, Class<?> cls) {
            kotlin.jvm.internal.p.i(parameters, "parameters");
            this.parameters = parameters;
            this.returnType = cls;
        }

        public final List<Class<?>> a() {
            return this.parameters;
        }

        public final Class<?> b() {
            return this.returnType;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$d", "Lz9/k;", "Lkotlin/reflect/jvm/internal/impl/descriptors/c;", "descriptor", "LY8/t;", "data", "Lkotlin/reflect/jvm/internal/d;", "visitConstructorDescriptor", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;LY8/t;)Lkotlin/reflect/jvm/internal/d;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends C6423k {
        public d(KDeclarationContainerImpl kDeclarationContainerImpl) {
            super(kDeclarationContainerImpl);
        }

        @Override // H9.C0836o, E9.InterfaceC0805j
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.d<?> k(kotlin.reflect.jvm.internal.impl.descriptors.c descriptor, Y8.t data) {
            kotlin.jvm.internal.p.i(descriptor, "descriptor");
            kotlin.jvm.internal.p.i(data, "data");
            throw new IllegalStateException("No constructors should appear here: " + descriptor);
        }
    }

    public static final CharSequence B(kotlin.reflect.jvm.internal.impl.descriptors.e descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return kotlin.reflect.jvm.internal.impl.renderer.b.f35920k.M(descriptor) + " | " + v.f36168a.g(descriptor).get_signature();
    }

    public static final int E(AbstractC0811p abstractC0811p, AbstractC0811p abstractC0811p2) {
        Integer numD = C0810o.d(abstractC0811p, abstractC0811p2);
        if (numD != null) {
            return numD.intValue();
        }
        return 0;
    }

    public static final int F(p9.p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    public static final CharSequence G(O descriptor) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        return kotlin.reflect.jvm.internal.impl.renderer.b.f35920k.M(descriptor) + " | " + v.f36168a.f(descriptor).getString();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e A(java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.A(java.lang.String, java.lang.String):kotlin.reflect.jvm.internal.impl.descriptors.e");
    }

    public final Method C(String name, String desc) throws NoSuchMethodException, SecurityException {
        Method methodN;
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(desc, "desc");
        if (kotlin.jvm.internal.p.d(name, "<init>")) {
            return null;
        }
        c cVarO = O(desc, true);
        Class<?>[] clsArr = (Class[]) cVarO.a().toArray(new Class[0]);
        Class<?> clsB = cVarO.b();
        kotlin.jvm.internal.p.f(clsB);
        Method methodN2 = N(L(), name, clsArr, clsB, false);
        if (methodN2 != null) {
            return methodN2;
        }
        if (!L().isInterface() || (methodN = N(Object.class, name, clsArr, clsB, false)) == null) {
            return null;
        }
        return methodN;
    }

    public final O D(String name, String signature) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(signature, "signature");
        La.m mVarJ = f34869c.j(signature);
        if (mVarJ != null) {
            String str = mVarJ.b().getMatch().c().get(1);
            O oJ = J(Integer.parseInt(str));
            if (oJ != null) {
                return oJ;
            }
            throw new KotlinReflectionInternalError("Local property #" + str + " not found in " + m());
        }
        ga.e eVarJ = ga.e.j(name);
        kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
        Collection<O> collectionM = M(eVarJ);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionM) {
            if (kotlin.jvm.internal.p.d(v.f36168a.f((O) obj).getString(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (O) F.X0(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            AbstractC0811p visibility = ((O) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        Collection collectionValues = Q.h(linkedHashMap, new C6402Z(C6401Y.f45334a)).values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        List list = (List) F.B0(collectionValues);
        if (list.size() == 1) {
            kotlin.jvm.internal.p.f(list);
            return (O) F.q0(list);
        }
        ga.e eVarJ2 = ga.e.j(name);
        kotlin.jvm.internal.p.h(eVarJ2, "identifier(...)");
        String strA0 = F.A0(M(eVarJ2), "\n", null, null, 0, null, C6404a0.f45337a, 30, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Property '");
        sb2.append(name);
        sb2.append("' (JVM signature: ");
        sb2.append(signature);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(':');
        sb2.append(strA0.length() == 0 ? " no members found" : '\n' + strA0);
        throw new KotlinReflectionInternalError(sb2.toString());
    }

    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> H();

    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> I(ga.e name);

    public abstract O J(int index);

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Collection<kotlin.reflect.jvm.internal.d<?>> K(ra.InterfaceC5238k r7, kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r8) {
        /*
            r6 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.p.i(r7, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.p.i(r8, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$d r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$d
            r0.<init>(r6)
            r6 = 3
            r1 = 0
            java.util.Collection r6 = ra.InterfaceC5241n.a.a(r7, r1, r1, r6, r1)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L20:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L55
            java.lang.Object r2 = r6.next()
            E9.h r2 = (E9.InterfaceC0803h) r2
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r3 == 0) goto L4e
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            E9.p r4 = r3.getVisibility()
            E9.p r5 = E9.C0810o.f2476h
            boolean r4 = kotlin.jvm.internal.p.d(r4, r5)
            if (r4 != 0) goto L4e
            boolean r3 = r8.accept(r3)
            if (r3 == 0) goto L4e
            Y8.t r3 = Y8.t.f7040a
            java.lang.Object r2 = r2.v(r0, r3)
            kotlin.reflect.jvm.internal.d r2 = (kotlin.reflect.jvm.internal.d) r2
            goto L4f
        L4e:
            r2 = r1
        L4f:
            if (r2 == 0) goto L20
            r7.add(r2)
            goto L20
        L55:
            java.util.List r6 = Z8.F.m1(r7)
            java.util.Collection r6 = (java.util.Collection) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.K(ra.k, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    public Class<?> L() {
        Class<?> clsK = C0925f.k(m());
        return clsK == null ? m() : clsK;
    }

    public abstract Collection<O> M(ga.e name);

    public final Method N(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z10) throws NoSuchMethodException, SecurityException {
        KDeclarationContainerImpl kDeclarationContainerImpl;
        String str2;
        Class<?>[] clsArr2;
        Class<?> cls3;
        boolean z11;
        if (z10) {
            clsArr[0] = cls;
        }
        Method methodR = R(cls, str, clsArr, cls2);
        if (methodR != null) {
            return methodR;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            Method methodN = N(superclass, str, clsArr, cls2, z10);
            kDeclarationContainerImpl = this;
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z11 = z10;
            if (methodN != null) {
                return methodN;
            }
        } else {
            kDeclarationContainerImpl = this;
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z11 = z10;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kotlin.jvm.internal.p.h(interfaces, "getInterfaces(...)");
        for (Class<?> cls4 : interfaces) {
            kotlin.jvm.internal.p.f(cls4);
            Method methodN2 = kDeclarationContainerImpl.N(cls4, str2, clsArr2, cls3, z11);
            if (methodN2 != null) {
                return methodN2;
            }
            if (z11) {
                Class<?> clsA = J9.e.a(C0925f.j(cls4), cls4.getName() + "$DefaultImpls");
                if (clsA != null) {
                    clsArr2[0] = cls4;
                    Method methodR2 = kDeclarationContainerImpl.R(clsA, str2, clsArr2, cls3);
                    if (methodR2 != null) {
                        return methodR2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public final c O(String desc, boolean parseReturnType) {
        String str;
        int iT0;
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        while (true) {
            if (desc.charAt(i10) == ')') {
                String str2 = desc;
                return new c(arrayList, parseReturnType ? P(str2, i10 + 1, str2.length()) : null);
            }
            int i11 = i10;
            while (desc.charAt(i11) == '[') {
                i11++;
            }
            char cCharAt = desc.charAt(i11);
            if (H.f0("VZCBSIFJD", cCharAt, false, 2, null)) {
                int i12 = i11 + 1;
                str = desc;
                iT0 = i12;
            } else {
                if (cCharAt != 'L') {
                    throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
                }
                str = desc;
                iT0 = H.t0(str, ';', i10, false, 4, null) + 1;
            }
            arrayList.add(P(str, i10, iT0));
            i10 = iT0;
            desc = str;
        }
    }

    public final Class<?> P(String desc, int begin, int end) throws ClassNotFoundException {
        char cCharAt = desc.charAt(begin);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader classLoaderJ = C0925f.j(m());
            String strSubstring = desc.substring(begin + 1, end - 1);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            Class<?> clsLoadClass = classLoaderJ.loadClass(D.S(strSubstring, JsonPointer.SEPARATOR, '.', false, 4, null));
            kotlin.jvm.internal.p.h(clsLoadClass, "loadClass(...)");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class<?> TYPE = Void.TYPE;
            kotlin.jvm.internal.p.h(TYPE, "TYPE");
            return TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return c1.f(P(desc, begin + 1, end));
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
        }
    }

    public final Constructor<?> Q(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method R(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) throws NoSuchMethodException, SecurityException {
        Method declaredMethod;
        try {
            declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
        }
        if (kotlin.jvm.internal.p.d(declaredMethod.getReturnType(), cls2)) {
            return declaredMethod;
        }
        Method[] declaredMethods = cls.getDeclaredMethods();
        kotlin.jvm.internal.p.h(declaredMethods, "getDeclaredMethods(...)");
        for (Method method : declaredMethods) {
            if (kotlin.jvm.internal.p.d(method.getName(), str) && kotlin.jvm.internal.p.d(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    public final void w(List<Class<?>> result, List<? extends Class<?>> valueParameters, boolean isConstructor) {
        if (kotlin.jvm.internal.p.d(F.E0(valueParameters), f34868b)) {
            valueParameters = valueParameters.subList(0, valueParameters.size() - 1);
        }
        result.addAll(valueParameters);
        int size = (valueParameters.size() + 31) / 32;
        for (int i10 = 0; i10 < size; i10++) {
            Class<?> TYPE = Integer.TYPE;
            kotlin.jvm.internal.p.h(TYPE, "TYPE");
            result.add(TYPE);
        }
        Class cls = isConstructor ? f34868b : Object.class;
        kotlin.jvm.internal.p.f(cls);
        result.add(cls);
    }

    public final Constructor<?> x(String desc) {
        kotlin.jvm.internal.p.i(desc, "desc");
        return Q(m(), O(desc, false).a());
    }

    public final Constructor<?> y(String desc) {
        kotlin.jvm.internal.p.i(desc, "desc");
        Class<?> clsM = m();
        ArrayList arrayList = new ArrayList();
        w(arrayList, O(desc, false).a(), true);
        Y8.t tVar = Y8.t.f7040a;
        return Q(clsM, arrayList);
    }

    public final Method z(String name, String desc, boolean isMember) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(desc, "desc");
        if (kotlin.jvm.internal.p.d(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (isMember) {
            arrayList.add(m());
        }
        c cVarO = O(desc, true);
        w(arrayList, cVarO.a(), false);
        Class<?> clsL = L();
        String str = name + "$default";
        Class<?>[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Class<?> clsB = cVarO.b();
        kotlin.jvm.internal.p.f(clsB);
        return N(clsL, str, clsArr, clsB, isMember);
    }
}
