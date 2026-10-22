package kotlin.reflect.jvm.internal;

import E9.InterfaceC0797b;
import E9.InterfaceC0803h;
import E9.O;
import E9.P;
import E9.Q;
import F9.g;
import H9.L;
import H9.M;
import S9.C1013l;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import fa.AbstractC4067d;
import fa.C4071h;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import ka.C4827g;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.internal.c;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.u;
import w9.InterfaceC5748g;
import w9.InterfaceC5749h;
import w9.InterfaceC5752k;
import y9.C5964a;
import z9.A0;
import z9.B0;
import z9.C0;
import z9.C6454z0;
import z9.D0;
import z9.E0;
import z9.X0;
import z9.c1;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b \u0018\u0000 P*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004QRSTB5\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u0010B+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010#R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b+\u0010)\u001a\u0004\b,\u0010#R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\"\u00108\u001a\u0010\u0012\f\u0012\n 5*\u0004\u0018\u00010\t0\t048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0013\u0010@\u001a\u0004\u0018\u0001008F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000A8&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0018\u0010H\u001a\u0006\u0012\u0002\b\u00030E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001a\u0010J\u001a\b\u0012\u0002\b\u0003\u0018\u00010E8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010GR\u0014\u0010K\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010<R\u0014\u0010L\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010<R\u0014\u0010M\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010<R\u0014\u0010\u000f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006U"}, d2 = {"Lkotlin/reflect/jvm/internal/p;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/d;", "Lw9/k;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "name", "signature", "LE9/O;", "descriptorInitialValue", "", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/reflect/Member;", "j0", "()Ljava/lang/reflect/Member;", "fieldOrMethod", "receiver1", "receiver2", "l0", "(Ljava/lang/reflect/Member;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "X", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/lang/String;", "getName", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "p0", "k", "Ljava/lang/Object;", "LY8/h;", "Ljava/lang/reflect/Field;", "l", "LY8/h;", "_javaField", "Lkotlin/reflect/jvm/internal/u$a;", "kotlin.jvm.PlatformType", "m", "Lkotlin/reflect/jvm/internal/u$a;", "_descriptor", "k0", "()Ljava/lang/Object;", "d0", "()Z", "isBound", "o0", "()Ljava/lang/reflect/Field;", "javaField", "Lkotlin/reflect/jvm/internal/p$c;", "n0", "()Lkotlin/reflect/jvm/internal/p$c;", "getter", "LA9/g;", ExifInterface.LONGITUDE_WEST, "()LA9/g;", "caller", "Y", "defaultCaller", "isLateinit", "isConst", "isSuspend", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "n", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class p<V> extends kotlin.reflect.jvm.internal.d<V> implements InterfaceC5752k<V> {

    /* renamed from: o, reason: collision with root package name */
    public static final Object f36138o = new Object();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final KDeclarationContainerImpl container;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final String signature;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Object rawBoundReceiver;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Field> _javaField;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final u.a<O> _descriptor;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010 \u001a\u00020\u001d8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/p$a;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/d;", "Lw9/k$a;", "Lw9/g;", "<init>", "()V", "Lkotlin/reflect/jvm/internal/p;", "g0", "()Lkotlin/reflect/jvm/internal/p;", "property", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "X", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "LA9/g;", "Y", "()LA9/g;", "defaultCaller", "", "d0", "()Z", "isBound", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "Lkotlin/reflect/jvm/internal/impl/descriptors/f;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "descriptor", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class a<PropertyType, ReturnType> extends kotlin.reflect.jvm.internal.d<ReturnType> implements InterfaceC5748g<ReturnType>, InterfaceC5752k.a<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.d
        /* renamed from: X */
        public KDeclarationContainerImpl getContainer() {
            return l().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.d
        public A9.g<?> Y() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.d
        public boolean d0() {
            return l().d0();
        }

        public abstract kotlin.reflect.jvm.internal.impl.descriptors.f f0();

        /* renamed from: g0 */
        public abstract p<PropertyType> l();

        @Override // w9.InterfaceC5748g
        public boolean isExternal() {
            return f0().isExternal();
        }

        @Override // w9.InterfaceC5748g
        public boolean isInfix() {
            return f0().isInfix();
        }

        @Override // w9.InterfaceC5748g
        public boolean isInline() {
            return f0().isInline();
        }

        @Override // w9.InterfaceC5748g
        public boolean isOperator() {
            return f0().isOperator();
        }

        @Override // w9.InterfaceC5744c
        public boolean isSuspend() {
            return f0().isSuspend();
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\b¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/p$c;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/p$a;", "Lw9/k$b;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "LE9/P;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lkotlin/reflect/jvm/internal/u$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor", "LA9/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/h;", ExifInterface.LONGITUDE_WEST, "()LA9/g;", "caller", "getName", "name", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class c<V> extends a<V, V> implements InterfaceC5752k.b<V> {

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC5752k<Object>[] f36145j = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(c.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", 0))};

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final u.a descriptor = u.c(new B0(this));

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final Y8.h caller = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C0(this));

        public static final A9.g j0(c cVar) {
            return q.b(cVar, true);
        }

        public static final P k0(c cVar) {
            P getter = cVar.l().f0().getGetter();
            if (getter != null) {
                return getter;
            }
            L lD = C4827g.d(cVar.l().f0(), F9.g.f2609m0.b());
            kotlin.jvm.internal.p.h(lD, "createDefaultGetter(...)");
            return lD;
        }

        @Override // kotlin.reflect.jvm.internal.d
        public A9.g<?> W() {
            return (A9.g) this.caller.getValue();
        }

        public boolean equals(Object other) {
            return (other instanceof c) && kotlin.jvm.internal.p.d(l(), ((c) other).l());
        }

        @Override // w9.InterfaceC5744c
        public String getName() {
            return "<get-" + l().getName() + '>';
        }

        public int hashCode() {
            return l().hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.p.a
        /* renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public P f0() {
            T tB = this.descriptor.b(this, f36145j[0]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (P) tB;
        }

        public String toString() {
            return "getter of " + l();
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\t¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/p$d;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/p$a;", "LY8/t;", "Lw9/h$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "LE9/Q;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lkotlin/reflect/jvm/internal/u$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor", "LA9/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LY8/h;", ExifInterface.LONGITUDE_WEST, "()LA9/g;", "caller", "getName", "name", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class d<V> extends a<V, Y8.t> implements InterfaceC5749h.a<V> {

        /* renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC5752k<Object>[] f36148j = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(d.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", 0))};

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final u.a descriptor = u.c(new D0(this));

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final Y8.h caller = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new E0(this));

        public static final A9.g j0(d dVar) {
            return q.b(dVar, false);
        }

        public static final Q k0(d dVar) {
            Q setter = dVar.l().f0().getSetter();
            if (setter != null) {
                return setter;
            }
            O oF0 = dVar.l().f0();
            g.a aVar = F9.g.f2609m0;
            M mE = C4827g.e(oF0, aVar.b(), aVar.b());
            kotlin.jvm.internal.p.h(mE, "createDefaultSetter(...)");
            return mE;
        }

        @Override // kotlin.reflect.jvm.internal.d
        public A9.g<?> W() {
            return (A9.g) this.caller.getValue();
        }

        public boolean equals(Object other) {
            return (other instanceof d) && kotlin.jvm.internal.p.d(l(), ((d) other).l());
        }

        @Override // w9.InterfaceC5744c
        public String getName() {
            return "<set-" + l().getName() + '>';
        }

        public int hashCode() {
            return l().hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.p.a
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public Q f0() {
            T tB = this.descriptor.b(this, f36148j[0]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Q) tB;
        }

        public String toString() {
            return "setter of " + l();
        }
    }

    public p(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, O o10, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.name = str;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this._javaField = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6454z0(this));
        u.a<O> aVarB = u.b(o10, new A0(this));
        kotlin.jvm.internal.p.h(aVarB, "lazySoft(...)");
        this._descriptor = aVarB;
    }

    public static final O f0(p pVar) {
        return pVar.getContainer().D(pVar.getName(), pVar.signature);
    }

    public static final Field g0(p pVar) {
        Class<?> enclosingClass;
        kotlin.reflect.jvm.internal.c cVarF = v.f36168a.f(pVar.f0());
        if (!(cVarF instanceof c.C0434c)) {
            if (cVarF instanceof c.a) {
                return ((c.a) cVarF).getField();
            }
            if ((cVarF instanceof c.b) || (cVarF instanceof c.d)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        c.C0434c c0434c = (c.C0434c) cVarF;
        O oB = c0434c.getDescriptor();
        AbstractC4067d.a aVarD = C4071h.d(C4071h.f32594a, c0434c.getProto(), c0434c.getNameResolver(), c0434c.getTypeTable(), false, 8, null);
        if (aVarD == null) {
            return null;
        }
        if (C1013l.e(oB) || C4071h.f(c0434c.getProto())) {
            enclosingClass = pVar.getContainer().m().getEnclosingClass();
        } else {
            InterfaceC0803h interfaceC0803hB = oB.b();
            enclosingClass = interfaceC0803hB instanceof InterfaceC0797b ? c1.r((InterfaceC0797b) interfaceC0803hB) : pVar.getContainer().m();
        }
        if (enclosingClass == null) {
            return null;
        }
        try {
            return enclosingClass.getDeclaredField(aVarD.e());
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.d
    public A9.g<?> W() {
        return n0().W();
    }

    @Override // kotlin.reflect.jvm.internal.d
    /* renamed from: X, reason: from getter */
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.d
    public A9.g<?> Y() {
        return n0().Y();
    }

    @Override // kotlin.reflect.jvm.internal.d
    public boolean d0() {
        return this.rawBoundReceiver != CallableReference.NO_RECEIVER;
    }

    public boolean equals(Object other) {
        p<?> pVarD = c1.d(other);
        return pVarD != null && kotlin.jvm.internal.p.d(getContainer(), pVarD.getContainer()) && kotlin.jvm.internal.p.d(getName(), pVarD.getName()) && kotlin.jvm.internal.p.d(this.signature, pVarD.signature) && kotlin.jvm.internal.p.d(this.rawBoundReceiver, pVarD.rawBoundReceiver);
    }

    @Override // w9.InterfaceC5744c
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((getContainer().hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
    }

    @Override // w9.InterfaceC5752k
    public boolean isConst() {
        return f0().isConst();
    }

    @Override // w9.InterfaceC5752k
    public boolean isLateinit() {
        return f0().t0();
    }

    @Override // w9.InterfaceC5744c
    public boolean isSuspend() {
        return false;
    }

    public final Member j0() {
        if (!f0().z()) {
            return null;
        }
        kotlin.reflect.jvm.internal.c cVarF = v.f36168a.f(f0());
        if (cVarF instanceof c.C0434c) {
            c.C0434c c0434c = (c.C0434c) cVarF;
            if (c0434c.getSignature().D()) {
                JvmProtoBuf.JvmMethodSignature jvmMethodSignatureX = c0434c.getSignature().x();
                if (!jvmMethodSignatureX.x() || !jvmMethodSignatureX.w()) {
                    return null;
                }
                return getContainer().C(c0434c.getNameResolver().getString(jvmMethodSignatureX.v()), c0434c.getNameResolver().getString(jvmMethodSignatureX.u()));
            }
        }
        return o0();
    }

    public final Object k0() {
        return A9.n.h(this.rawBoundReceiver, f0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object l0(Member fieldOrMethod, Object receiver1, Object receiver2) throws IllegalPropertyDelegateAccessException, SecurityException {
        try {
            Object obj = f36138o;
            if ((receiver1 == obj || receiver2 == obj) && f0().K() == null) {
                throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object objK0 = d0() ? k0() : receiver1;
            if (objK0 == obj) {
                objK0 = null;
            }
            if (!d0()) {
                receiver1 = receiver2;
            }
            if (receiver1 == obj) {
                receiver1 = null;
            }
            AccessibleObject accessibleObject = fieldOrMethod instanceof AccessibleObject ? (AccessibleObject) fieldOrMethod : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(C5964a.a(this));
            }
            if (fieldOrMethod == 0) {
                return null;
            }
            if (fieldOrMethod instanceof Field) {
                return ((Field) fieldOrMethod).get(objK0);
            }
            if (!(fieldOrMethod instanceof Method)) {
                throw new AssertionError("delegate field/method " + fieldOrMethod + " neither field nor method");
            }
            int length = ((Method) fieldOrMethod).getParameterTypes().length;
            if (length == 0) {
                return ((Method) fieldOrMethod).invoke(null, null);
            }
            if (length == 1) {
                Method method = (Method) fieldOrMethod;
                if (objK0 == null) {
                    Class<?> cls = ((Method) fieldOrMethod).getParameterTypes()[0];
                    kotlin.jvm.internal.p.h(cls, "get(...)");
                    objK0 = c1.g(cls);
                }
                return method.invoke(null, objK0);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + fieldOrMethod + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) fieldOrMethod;
            if (receiver1 == null) {
                Class<?> cls2 = ((Method) fieldOrMethod).getParameterTypes()[1];
                kotlin.jvm.internal.p.h(cls2, "get(...)");
                receiver1 = c1.g(cls2);
            }
            return method2.invoke(null, objK0, receiver1);
        } catch (IllegalAccessException e10) {
            throw new IllegalPropertyDelegateAccessException(e10);
        }
    }

    @Override // kotlin.reflect.jvm.internal.d
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public O f0() {
        O oInvoke = this._descriptor.invoke();
        kotlin.jvm.internal.p.h(oInvoke, "invoke(...)");
        return oInvoke;
    }

    public abstract c<V> n0();

    public final Field o0() {
        return this._javaField.getValue();
    }

    /* renamed from: p0, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    public String toString() {
        return X0.f45332a.w(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public p(KDeclarationContainerImpl container, O descriptor) {
        kotlin.jvm.internal.p.i(container, "container");
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        String strB = descriptor.getName().b();
        kotlin.jvm.internal.p.h(strB, "asString(...)");
        this(container, strB, v.f36168a.f(descriptor).getString(), descriptor, CallableReference.NO_RECEIVER);
    }
}
