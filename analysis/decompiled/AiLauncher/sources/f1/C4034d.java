package f1;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0010\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lf1/d;", "", "", "id", "sequence", "", "from", "to", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "other", Const.INTENT_KEY_APIKEY, "(Lf1/d;)I", "I", "c", "()I", Const.INTENT_KEY_PKGNAME, "getSequence", "Ljava/lang/String;", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "e", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: f1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4034d implements Comparable<C4034d> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int sequence;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String from;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String to;

    public C4034d(int i10, int i11, String from, String to) {
        p.i(from, "from");
        p.i(to, "to");
        this.id = i10;
        this.sequence = i11;
        this.from = from;
        this.to = to;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4034d other) {
        p.i(other, "other");
        int i10 = this.id - other.id;
        return i10 == 0 ? this.sequence - other.sequence : i10;
    }

    /* renamed from: b, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* renamed from: c, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final String getTo() {
        return this.to;
    }
}
