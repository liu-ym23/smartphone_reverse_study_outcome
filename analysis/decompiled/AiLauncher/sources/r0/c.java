package r0;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\u0018\u00002\u00020\u0001B?\b\u0000\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010%\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b!\u0010#\u001a\u0004\b$\u0010\u0014¨\u0006&"}, d2 = {"Lr0/c;", "", "", "id", "", "alias", "", "", "manuallyTestedFingerprints", "Lkotlin/Function0;", "", "precondition", "<init>", "(JLjava/lang/Integer;Ljava/util/Set;Lp9/a;)V", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "J", "getId", "()J", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "Ljava/util/Set;", Const.INTENT_KEY_UMID, "()Ljava/util/Set;", "Lp9/a;", "e", "()Lp9/a;", "Ljava/lang/String;", "getUrl", "url", "core-backported-fixes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Integer alias;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Set<String> manuallyTestedFingerprints;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<Boolean> precondition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String url;

    public c(long j10, Integer num, Set<String> manuallyTestedFingerprints, InterfaceC5063a<Boolean> precondition) {
        p.i(manuallyTestedFingerprints, "manuallyTestedFingerprints");
        p.i(precondition, "precondition");
        this.id = j10;
        this.alias = num;
        this.manuallyTestedFingerprints = manuallyTestedFingerprints;
        this.precondition = precondition;
        this.url = "https://issuetracker.google.com/issues/" + j10;
    }

    public static final boolean b() {
        return true;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getAlias() {
        return this.alias;
    }

    public final Set<String> d() {
        return this.manuallyTestedFingerprints;
    }

    public final InterfaceC5063a<Boolean> e() {
        return this.precondition;
    }

    public boolean equals(Object other) {
        return (other instanceof c) && this.id == ((c) other).id;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }

    public String toString() {
        if (this.alias == null) {
            return this.id + " without alias";
        }
        return this.id + " with alias " + this.alias.intValue();
    }

    public /* synthetic */ c(long j10, Integer num, Set set, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this(j10, num, (i10 & 4) != 0 ? Y.e() : set, (i10 & 8) != 0 ? new InterfaceC5063a() { // from class: r0.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(c.b());
            }
        } : interfaceC5063a);
    }
}
