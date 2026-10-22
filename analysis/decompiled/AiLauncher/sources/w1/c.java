package w1;

import coil.decode.DataSource;
import coil.decode.e;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u0012\u0010\u001a¨\u0006\u001b"}, d2 = {"Lw1/c;", "Lw1/b;", "Lcoil/decode/e;", "source", "", "mimeType", "Lcoil/decode/DataSource;", "dataSource", "<init>", "(Lcoil/decode/e;Ljava/lang/String;Lcoil/decode/DataSource;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", Const.INTENT_KEY_APIKEY, "Lcoil/decode/e;", "c", "()Lcoil/decode/e;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "()Ljava/lang/String;", "Lcoil/decode/DataSource;", "()Lcoil/decode/DataSource;", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final e source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String mimeType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final DataSource dataSource;

    public c(e eVar, String str, DataSource dataSource) {
        super(null);
        this.source = eVar;
        this.mimeType = str;
        this.dataSource = dataSource;
    }

    /* renamed from: a, reason: from getter */
    public final DataSource getDataSource() {
        return this.dataSource;
    }

    /* renamed from: b, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: c, reason: from getter */
    public final e getSource() {
        return this.source;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return p.d(this.source, cVar.source) && p.d(this.mimeType, cVar.mimeType) && this.dataSource == cVar.dataSource;
    }

    public int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        String str = this.mimeType;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.dataSource.hashCode();
    }
}
