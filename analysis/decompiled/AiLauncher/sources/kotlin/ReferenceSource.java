package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"LK6/A;", "", "", "siteName", "pageTitle", "url", "iconUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.A, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ReferenceSource {
    private final String iconUrl;
    private final String pageTitle;
    private final String siteName;
    private final String url;

    public ReferenceSource() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: b, reason: from getter */
    public final String getPageTitle() {
        return this.pageTitle;
    }

    /* renamed from: c, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    /* renamed from: d, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReferenceSource)) {
            return false;
        }
        ReferenceSource referenceSource = (ReferenceSource) other;
        return p.d(this.siteName, referenceSource.siteName) && p.d(this.pageTitle, referenceSource.pageTitle) && p.d(this.url, referenceSource.url) && p.d(this.iconUrl, referenceSource.iconUrl);
    }

    public int hashCode() {
        return (((((this.siteName.hashCode() * 31) + this.pageTitle.hashCode()) * 31) + this.url.hashCode()) * 31) + this.iconUrl.hashCode();
    }

    public String toString() {
        return "ReferenceSource(siteName=" + this.siteName + ", pageTitle=" + this.pageTitle + ", url=" + this.url + ", iconUrl=" + this.iconUrl + ")";
    }

    public ReferenceSource(String siteName, String pageTitle, String url, String iconUrl) {
        p.i(siteName, "siteName");
        p.i(pageTitle, "pageTitle");
        p.i(url, "url");
        p.i(iconUrl, "iconUrl");
        this.siteName = siteName;
        this.pageTitle = pageTitle;
        this.url = url;
        this.iconUrl = iconUrl;
    }

    public /* synthetic */ ReferenceSource(String str, String str2, String str3, String str4, int i10, i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4);
    }
}
