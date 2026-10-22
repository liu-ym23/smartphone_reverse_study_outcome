package B1;

import B1.c;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"LB1/g;", "", "LB1/c;", "width", "height", "<init>", "(LB1/c;LB1/c;)V", Const.INTENT_KEY_APIKEY, "()LB1/c;", Const.INTENT_KEY_PKGNAME, "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LB1/c;", Const.INTENT_KEY_UMID, "c", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: B1.g, reason: from toString */
/* loaded from: classes.dex */
public final /* data */ class Size {

    /* renamed from: d, reason: collision with root package name */
    public static final Size f1423d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final c width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final c height;

    static {
        c.b bVar = c.b.f1417a;
        f1423d = new Size(bVar, bVar);
    }

    public Size(c cVar, c cVar2) {
        this.width = cVar;
        this.height = cVar2;
    }

    /* renamed from: a, reason: from getter */
    public final c getWidth() {
        return this.width;
    }

    /* renamed from: b, reason: from getter */
    public final c getHeight() {
        return this.height;
    }

    public final c c() {
        return this.height;
    }

    public final c d() {
        return this.width;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Size)) {
            return false;
        }
        Size size = (Size) other;
        return p.d(this.width, size.width) && p.d(this.height, size.height);
    }

    public int hashCode() {
        return (this.width.hashCode() * 31) + this.height.hashCode();
    }

    public String toString() {
        return "Size(width=" + this.width + ", height=" + this.height + ')';
    }
}
