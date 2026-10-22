package N5;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"LN5/m;", "", "", "app", p7.b.TYPE_WEB, "LN5/l;", "list", "<init>", "(Ljava/lang/String;Ljava/lang/String;LN5/l;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "LN5/l;", "getList", "()LN5/l;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: N5.m, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class CardLinks {
    private final String app;
    private final CardLink list;
    private final String web;

    public CardLinks() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getApp() {
        return this.app;
    }

    /* renamed from: b, reason: from getter */
    public final String getWeb() {
        return this.web;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardLinks)) {
            return false;
        }
        CardLinks cardLinks = (CardLinks) other;
        return kotlin.jvm.internal.p.d(this.app, cardLinks.app) && kotlin.jvm.internal.p.d(this.web, cardLinks.web) && kotlin.jvm.internal.p.d(this.list, cardLinks.list);
    }

    public int hashCode() {
        String str = this.app;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.web;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        CardLink cardLink = this.list;
        return iHashCode2 + (cardLink != null ? cardLink.hashCode() : 0);
    }

    public String toString() {
        return "CardLinks(app=" + this.app + ", web=" + this.web + ", list=" + this.list + ")";
    }

    public CardLinks(String str, String str2, CardLink cardLink) {
        this.app = str;
        this.web = str2;
        this.list = cardLink;
    }

    public /* synthetic */ CardLinks(String str, String str2, CardLink cardLink, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : cardLink);
    }
}
