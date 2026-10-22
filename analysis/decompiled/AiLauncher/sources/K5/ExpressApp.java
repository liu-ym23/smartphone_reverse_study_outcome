package K5;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"LK5/a;", "", "", "pkg", "ruleName", "LK5/c;", "mapper", "<init>", "(Ljava/lang/String;Ljava/lang/String;LK5/c;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "LK5/c;", Const.INTENT_KEY_APIKEY, "()LK5/c;", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K5.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ExpressApp {
    private final c mapper;
    private final String pkg;
    private final String ruleName;

    public ExpressApp(String pkg, String ruleName, c mapper) {
        p.i(pkg, "pkg");
        p.i(ruleName, "ruleName");
        p.i(mapper, "mapper");
        this.pkg = pkg;
        this.ruleName = ruleName;
        this.mapper = mapper;
    }

    /* renamed from: a, reason: from getter */
    public final c getMapper() {
        return this.mapper;
    }

    /* renamed from: b, reason: from getter */
    public final String getPkg() {
        return this.pkg;
    }

    /* renamed from: c, reason: from getter */
    public final String getRuleName() {
        return this.ruleName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExpressApp)) {
            return false;
        }
        ExpressApp expressApp = (ExpressApp) other;
        return p.d(this.pkg, expressApp.pkg) && p.d(this.ruleName, expressApp.ruleName) && p.d(this.mapper, expressApp.mapper);
    }

    public int hashCode() {
        return (((this.pkg.hashCode() * 31) + this.ruleName.hashCode()) * 31) + this.mapper.hashCode();
    }

    public String toString() {
        return "ExpressApp(pkg=" + this.pkg + ", ruleName=" + this.ruleName + ", mapper=" + this.mapper + ")";
    }
}
