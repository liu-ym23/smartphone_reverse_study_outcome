package I;

import G.ResolvedFeatureGroup;
import androidx.camera.core.UseCase;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"LI/b;", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, "LI/b$a;", "LI/b$b;", "LI/b$c;", "LI/b$d;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface b {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"LI/b$a;", "LI/b;", "LG/a;", "resolvedFeatureGroup", "<init>", "(LG/a;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "LG/a;", "()LG/a;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: I.b$a, reason: from toString */
    public static final /* data */ class Supported implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final ResolvedFeatureGroup resolvedFeatureGroup;

        public Supported(ResolvedFeatureGroup resolvedFeatureGroup) {
            p.i(resolvedFeatureGroup, "resolvedFeatureGroup");
            this.resolvedFeatureGroup = resolvedFeatureGroup;
        }

        /* renamed from: a, reason: from getter */
        public final ResolvedFeatureGroup getResolvedFeatureGroup() {
            return this.resolvedFeatureGroup;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Supported) && p.d(this.resolvedFeatureGroup, ((Supported) other).resolvedFeatureGroup);
        }

        public int hashCode() {
            return this.resolvedFeatureGroup.hashCode();
        }

        public String toString() {
            return "Supported(resolvedFeatureGroup=" + this.resolvedFeatureGroup + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LI/b$b;", "LI/b;", "<init>", "()V", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: I.b$b, reason: collision with other inner class name */
    public static final class C0053b implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final C0053b f3249a = new C0053b();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"LI/b$c;", "LI/b;", "Landroidx/camera/core/UseCase;", "unsupportedUseCase", "<init>", "(Landroidx/camera/core/UseCase;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/core/UseCase;", "()Landroidx/camera/core/UseCase;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: I.b$c, reason: from toString */
    public static final /* data */ class UnsupportedUseCase implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final UseCase unsupportedUseCase;

        public UnsupportedUseCase(UseCase unsupportedUseCase) {
            p.i(unsupportedUseCase, "unsupportedUseCase");
            this.unsupportedUseCase = unsupportedUseCase;
        }

        /* renamed from: a, reason: from getter */
        public final UseCase getUnsupportedUseCase() {
            return this.unsupportedUseCase;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UnsupportedUseCase) && p.d(this.unsupportedUseCase, ((UnsupportedUseCase) other).unsupportedUseCase);
        }

        public int hashCode() {
            return this.unsupportedUseCase.hashCode();
        }

        public String toString() {
            return "UnsupportedUseCase(unsupportedUseCase=" + this.unsupportedUseCase + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016¨\u0006\u0017"}, d2 = {"LI/b$d;", "LI/b;", "", "requiredUseCases", "LF/b;", "featureRequiring", "<init>", "(Ljava/lang/String;LF/b;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "LF/b;", "()LF/b;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: I.b$d, reason: from toString */
    public static final /* data */ class UseCaseMissing implements b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String requiredUseCases;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final F.b featureRequiring;

        public UseCaseMissing(String requiredUseCases, F.b featureRequiring) {
            p.i(requiredUseCases, "requiredUseCases");
            p.i(featureRequiring, "featureRequiring");
            this.requiredUseCases = requiredUseCases;
            this.featureRequiring = featureRequiring;
        }

        /* renamed from: a, reason: from getter */
        public final F.b getFeatureRequiring() {
            return this.featureRequiring;
        }

        /* renamed from: b, reason: from getter */
        public final String getRequiredUseCases() {
            return this.requiredUseCases;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UseCaseMissing)) {
                return false;
            }
            UseCaseMissing useCaseMissing = (UseCaseMissing) other;
            return p.d(this.requiredUseCases, useCaseMissing.requiredUseCases) && p.d(this.featureRequiring, useCaseMissing.featureRequiring);
        }

        public int hashCode() {
            return (this.requiredUseCases.hashCode() * 31) + this.featureRequiring.hashCode();
        }

        public String toString() {
            return "UseCaseMissing(requiredUseCases=" + this.requiredUseCases + ", featureRequiring=" + this.featureRequiring + ')';
        }
    }
}
