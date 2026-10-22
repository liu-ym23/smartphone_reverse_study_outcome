package kotlin.jvm.internal;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KVariance;
import o9.C5013a;
import p9.InterfaceC5074l;
import w9.C5757p;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001\u001dB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0015*\u00020\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010%\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R \u0010\t\u001a\u00020\b8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b*\u0010+\u0012\u0004\b-\u0010)\u001a\u0004\b,\u0010\u0014R\u0014\u0010\r\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001c\u00103\u001a\u00020\u0015*\u0006\u0012\u0002\b\u0003008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lkotlin/jvm/internal/C;", "Lw9/n;", "Lw9/e;", "classifier", "", "Lw9/p;", "arguments", "platformTypeUpperBound", "", "flags", "<init>", "(Lw9/e;Ljava/util/List;Lw9/n;I)V", "", "isMarkedNullable", "(Lw9/e;Ljava/util/List;Z)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "convertPrimitiveToWrapper", "o", "(Z)Ljava/lang/String;", "m", "(Lw9/p;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lw9/e;", "c", "()Lw9/e;", Const.INTENT_KEY_PKGNAME, "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "Lw9/n;", "u", "()Lw9/n;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", Const.INTENT_KEY_UMID, "I", "s", "getFlags$kotlin_stdlib$annotations", "e", "()Z", "Ljava/lang/Class;", "r", "(Ljava/lang/Class;)Ljava/lang/String;", "arrayClassName", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class C implements InterfaceC5755n {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5746e classifier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<C5757p> arguments;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5755n platformTypeUpperBound;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int flags;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34813a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f34813a = iArr;
        }
    }

    public C(InterfaceC5746e classifier, List<C5757p> arguments, InterfaceC5755n interfaceC5755n, int i10) {
        p.i(classifier, "classifier");
        p.i(arguments, "arguments");
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = interfaceC5755n;
        this.flags = i10;
    }

    public static final CharSequence p(C c10, C5757p it) {
        p.i(it, "it");
        return c10.m(it);
    }

    @Override // w9.InterfaceC5755n
    /* renamed from: c, reason: from getter */
    public InterfaceC5746e getClassifier() {
        return this.classifier;
    }

    @Override // w9.InterfaceC5755n
    public boolean e() {
        return (this.flags & 1) != 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C)) {
            return false;
        }
        C c10 = (C) other;
        return p.d(getClassifier(), c10.getClassifier()) && p.d(g(), c10.g()) && p.d(this.platformTypeUpperBound, c10.platformTypeUpperBound) && this.flags == c10.flags;
    }

    @Override // w9.InterfaceC5755n
    public List<C5757p> g() {
        return this.arguments;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + g().hashCode()) * 31) + Integer.hashCode(this.flags);
    }

    public final String m(C5757p c5757p) {
        String strValueOf;
        if (c5757p.d() == null) {
            return "*";
        }
        InterfaceC5755n interfaceC5755nC = c5757p.c();
        C c10 = interfaceC5755nC instanceof C ? (C) interfaceC5755nC : null;
        if (c10 == null || (strValueOf = c10.o(true)) == null) {
            strValueOf = String.valueOf(c5757p.c());
        }
        int i10 = b.f34813a[c5757p.d().ordinal()];
        if (i10 == 1) {
            return strValueOf;
        }
        if (i10 == 2) {
            return "in " + strValueOf;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + strValueOf;
    }

    public final String o(boolean convertPrimitiveToWrapper) {
        String name;
        InterfaceC5746e classifier = getClassifier();
        InterfaceC5745d interfaceC5745d = classifier instanceof InterfaceC5745d ? (InterfaceC5745d) classifier : null;
        Class<?> clsB = interfaceC5745d != null ? C5013a.b(interfaceC5745d) : null;
        if (clsB == null) {
            name = getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsB.isArray()) {
            name = r(clsB);
        } else if (convertPrimitiveToWrapper && clsB.isPrimitive()) {
            InterfaceC5746e classifier2 = getClassifier();
            p.g(classifier2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = C5013a.c((InterfaceC5745d) classifier2).getName();
        } else {
            name = clsB.getName();
        }
        String str = name + (g().isEmpty() ? "" : F.A0(g(), ", ", "<", ">", 0, null, new InterfaceC5074l() { // from class: kotlin.jvm.internal.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C.p(this.f34807a, (C5757p) obj);
            }
        }, 24, null)) + (e() ? "?" : "");
        InterfaceC5755n interfaceC5755n = this.platformTypeUpperBound;
        if (interfaceC5755n instanceof C) {
            String strO = ((C) interfaceC5755n).o(true);
            if (!p.d(strO, str)) {
                if (p.d(strO, str + '?')) {
                    return str + '!';
                }
                return '(' + str + ".." + strO + ')';
            }
        }
        return str;
    }

    public final String r(Class<?> cls) {
        return p.d(cls, boolean[].class) ? "kotlin.BooleanArray" : p.d(cls, char[].class) ? "kotlin.CharArray" : p.d(cls, byte[].class) ? "kotlin.ByteArray" : p.d(cls, short[].class) ? "kotlin.ShortArray" : p.d(cls, int[].class) ? "kotlin.IntArray" : p.d(cls, float[].class) ? "kotlin.FloatArray" : p.d(cls, long[].class) ? "kotlin.LongArray" : p.d(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* renamed from: s, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    public String toString() {
        return o(false) + " (Kotlin reflection is not available)";
    }

    /* renamed from: u, reason: from getter */
    public final InterfaceC5755n getPlatformTypeUpperBound() {
        return this.platformTypeUpperBound;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C(InterfaceC5746e classifier, List<C5757p> arguments, boolean z10) {
        this(classifier, arguments, null, z10 ? 1 : 0);
        p.i(classifier, "classifier");
        p.i(arguments, "arguments");
    }
}
