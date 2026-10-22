package kotlin.jvm.internal;

import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KVariance;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001\u0010B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\t\u0010$R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lkotlin/jvm/internal/A;", "Lw9/o;", "", "container", "", "name", "Lkotlin/reflect/KVariance;", "variance", "", "isReified", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "", "Lw9/n;", "upperBounds", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getName", "c", "Lkotlin/reflect/KVariance;", "l", "()Lkotlin/reflect/KVariance;", Const.INTENT_KEY_UMID, "Z", "()Z", "e", "Ljava/util/List;", "bounds", "getUpperBounds", "()Ljava/util/List;", "getUpperBounds$annotations", "()V", "f", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class A implements InterfaceC5756o {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final KVariance variance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean isReified;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public volatile List<? extends InterfaceC5755n> bounds;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/jvm/internal/A$a;", "", "<init>", "()V", "Lw9/o;", "typeParameter", "", Const.INTENT_KEY_APIKEY, "(Lw9/o;)Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.jvm.internal.A$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: kotlin.jvm.internal.A$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0430a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f34806a;

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
                f34806a = iArr;
            }
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final String a(InterfaceC5756o typeParameter) {
            p.i(typeParameter, "typeParameter");
            StringBuilder sb2 = new StringBuilder();
            int i10 = C0430a.f34806a[typeParameter.getVariance().ordinal()];
            if (i10 == 1) {
                Y8.t tVar = Y8.t.f7040a;
            } else if (i10 == 2) {
                sb2.append("in ");
            } else {
                if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                sb2.append("out ");
            }
            sb2.append(typeParameter.getName());
            return sb2.toString();
        }

        public Companion() {
        }
    }

    public A(Object obj, String name, KVariance variance, boolean z10) {
        p.i(name, "name");
        p.i(variance, "variance");
        this.container = obj;
        this.name = name;
        this.variance = variance;
        this.isReified = z10;
    }

    public final void a(List<? extends InterfaceC5755n> upperBounds) {
        p.i(upperBounds, "upperBounds");
        if (this.bounds == null) {
            this.bounds = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public boolean equals(Object other) {
        if (!(other instanceof A)) {
            return false;
        }
        A a10 = (A) other;
        return p.d(this.container, a10.container) && p.d(getName(), a10.getName());
    }

    @Override // w9.InterfaceC5756o
    public String getName() {
        return this.name;
    }

    @Override // w9.InterfaceC5756o
    public List<InterfaceC5755n> getUpperBounds() {
        List list = this.bounds;
        if (list != null) {
            return list;
        }
        List<InterfaceC5755n> listE = C1172u.e(t.g(Object.class));
        this.bounds = listE;
        return listE;
    }

    public int hashCode() {
        Object obj = this.container;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @Override // w9.InterfaceC5756o
    /* renamed from: l, reason: from getter */
    public KVariance getVariance() {
        return this.variance;
    }

    public String toString() {
        return INSTANCE.a(this);
    }
}
