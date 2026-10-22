package w9;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KVariance;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u000bB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001a"}, d2 = {"Lw9/p;", "", "Lkotlin/reflect/KVariance;", "variance", "Lw9/n;", "type", "<init>", "(Lkotlin/reflect/KVariance;Lw9/n;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Lkotlin/reflect/KVariance;", Const.INTENT_KEY_PKGNAME, "()Lw9/n;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/reflect/KVariance;", Const.INTENT_KEY_UMID, "Lw9/n;", "c", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w9.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final /* data */ class C5757p {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final C5757p f43129d = new C5757p(null, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final KVariance variance;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5755n type;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lw9/p$a;", "", "<init>", "()V", "Lw9/n;", "type", "Lw9/p;", Const.INTENT_KEY_UMID, "(Lw9/n;)Lw9/p;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "()Lw9/p;", "STAR", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: w9.p$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5757p a(InterfaceC5755n type) {
            kotlin.jvm.internal.p.i(type, "type");
            return new C5757p(KVariance.IN, type);
        }

        public final C5757p b(InterfaceC5755n type) {
            kotlin.jvm.internal.p.i(type, "type");
            return new C5757p(KVariance.OUT, type);
        }

        public final C5757p c() {
            return C5757p.f43129d;
        }

        public final C5757p d(InterfaceC5755n type) {
            kotlin.jvm.internal.p.i(type, "type");
            return new C5757p(KVariance.INVARIANT, type);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: w9.p$b */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43132a;

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
            f43132a = iArr;
        }
    }

    public C5757p(KVariance kVariance, InterfaceC5755n interfaceC5755n) {
        String str;
        this.variance = kVariance;
        this.type = interfaceC5755n;
        if ((kVariance == null) == (interfaceC5755n == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    /* renamed from: a, reason: from getter */
    public final KVariance getVariance() {
        return this.variance;
    }

    /* renamed from: b, reason: from getter */
    public final InterfaceC5755n getType() {
        return this.type;
    }

    public final InterfaceC5755n c() {
        return this.type;
    }

    public final KVariance d() {
        return this.variance;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof C5757p)) {
            return false;
        }
        C5757p c5757p = (C5757p) other;
        return this.variance == c5757p.variance && kotlin.jvm.internal.p.d(this.type, c5757p.type);
    }

    public int hashCode() {
        KVariance kVariance = this.variance;
        int iHashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        InterfaceC5755n interfaceC5755n = this.type;
        return iHashCode + (interfaceC5755n != null ? interfaceC5755n.hashCode() : 0);
    }

    public String toString() {
        KVariance kVariance = this.variance;
        int i10 = kVariance == null ? -1 : b.f43132a[kVariance.ordinal()];
        if (i10 == -1) {
            return "*";
        }
        if (i10 == 1) {
            return String.valueOf(this.type);
        }
        if (i10 == 2) {
            return "in " + this.type;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + this.type;
    }
}
