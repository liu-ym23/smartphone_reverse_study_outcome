package W3;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0010\u0010\b¨\u0006\u0013"}, d2 = {"LW3/c;", "", "", "ruleName", "packageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: W3.c, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class MonitorRule {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String ruleName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String packageName;

    public MonitorRule(String ruleName, String packageName) {
        p.i(ruleName, "ruleName");
        p.i(packageName, "packageName");
        this.ruleName = ruleName;
        this.packageName = packageName;
    }

    /* renamed from: a, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: b, reason: from getter */
    public final String getRuleName() {
        return this.ruleName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MonitorRule)) {
            return false;
        }
        MonitorRule monitorRule = (MonitorRule) other;
        return p.d(this.ruleName, monitorRule.ruleName) && p.d(this.packageName, monitorRule.packageName);
    }

    public int hashCode() {
        return (this.ruleName.hashCode() * 31) + this.packageName.hashCode();
    }

    public String toString() {
        return "MonitorRule(ruleName=" + this.ruleName + ", packageName=" + this.packageName + ")";
    }
}
