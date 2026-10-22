package G;

import D.C0761b0;
import D.o0;
import F.b;
import I.b;
import I.c;
import K.InterfaceC0898v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u000e"}, d2 = {"LG/a;", "", "", "LF/b;", "features", "<init>", "(Ljava/util/Set;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/Set;", "()Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: G.a, reason: from toString */
/* loaded from: classes.dex */
public final class ResolvedFeatureGroup {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Set<b> features;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LG/a$a;", "", "<init>", "()V", "LD/o0;", "LK/v;", "cameraInfoInternal", "LI/c;", "resolver", "LG/a;", Const.INTENT_KEY_PKGNAME, "(LD/o0;LK/v;LI/c;)LG/a;", "", "TAG", "Ljava/lang/String;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: G.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ ResolvedFeatureGroup c(Companion companion, o0 o0Var, InterfaceC0898v interfaceC0898v, c cVar, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                cVar = new I.a(interfaceC0898v);
            }
            return companion.b(o0Var, interfaceC0898v, cVar);
        }

        public final ResolvedFeatureGroup a(o0 o0Var, InterfaceC0898v cameraInfoInternal) {
            p.i(o0Var, "<this>");
            p.i(cameraInfoInternal, "cameraInfoInternal");
            return c(this, o0Var, cameraInfoInternal, null, 2, null);
        }

        public final ResolvedFeatureGroup b(o0 o0Var, InterfaceC0898v cameraInfoInternal, c resolver) throws IllegalStateException {
            p.i(o0Var, "<this>");
            p.i(cameraInfoInternal, "cameraInfoInternal");
            p.i(resolver, "resolver");
            C0761b0.a("ResolvedFeatureGroup", "resolveFeatureGroup: sessionConfig = " + o0Var + ", lensFacing = " + cameraInfoInternal.k());
            if (o0Var.j().isEmpty() && o0Var.h().isEmpty()) {
                return null;
            }
            I.b bVarA = resolver.a(o0Var);
            if (bVarA instanceof b.Supported) {
                ResolvedFeatureGroup resolvedFeatureGroupA = ((b.Supported) bVarA).getResolvedFeatureGroup();
                C0761b0.a("ResolvedFeatureGroup", "resolvedFeatureGroup = " + resolvedFeatureGroupA);
                return resolvedFeatureGroupA;
            }
            if (bVarA instanceof b.C0053b) {
                throw new IllegalArgumentException("Feature group is not supported");
            }
            if (bVarA instanceof b.UnsupportedUseCase) {
                throw new IllegalArgumentException(((b.UnsupportedUseCase) bVarA).getUnsupportedUseCase() + " is not supported");
            }
            if (!(bVarA instanceof b.UseCaseMissing)) {
                throw new NoWhenBranchMatchedException();
            }
            StringBuilder sb2 = new StringBuilder();
            b.UseCaseMissing dVar = (b.UseCaseMissing) bVarA;
            sb2.append(dVar.getRequiredUseCases());
            sb2.append(" must be added for ");
            sb2.append(dVar.getFeatureRequiring());
            throw new IllegalArgumentException(sb2.toString());
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResolvedFeatureGroup(Set<? extends F.b> features) {
        p.i(features, "features");
        this.features = features;
    }

    public static final ResolvedFeatureGroup b(o0 o0Var, InterfaceC0898v interfaceC0898v) {
        return INSTANCE.a(o0Var, interfaceC0898v);
    }

    public final Set<F.b> a() {
        return this.features;
    }

    public String toString() {
        return "ResolvedFeatureGroup(features=" + this.features + ')';
    }
}
