package i0;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011R\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Li0/c;", "", "", ContentDisposition.Parameters.Size, "", "keys", "", "values", "<init>", "(I[J[Ljava/lang/Object;)V", "", "key", Const.INTENT_KEY_PKGNAME, "(J)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(J)I", "I", "[J", "c", "[Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int size;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long[] keys;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object[] values;

    public c(int i10, long[] jArr, Object[] objArr) {
        this.size = i10;
        this.keys = jArr;
        this.values = objArr;
    }

    public final int a(long key) {
        int i10 = this.size - 1;
        if (i10 != -1) {
            int i11 = 0;
            if (i10 != 0) {
                while (i11 <= i10) {
                    int i12 = (i11 + i10) >>> 1;
                    long j10 = this.keys[i12] - key;
                    if (j10 < 0) {
                        i11 = i12 + 1;
                    } else {
                        if (j10 <= 0) {
                            return i12;
                        }
                        i10 = i12 - 1;
                    }
                }
                return -(i11 + 1);
            }
            long j11 = this.keys[0];
            if (j11 == key) {
                return 0;
            }
            if (j11 > key) {
                return -2;
            }
        }
        return -1;
    }

    public final Object b(long key) {
        int iA = a(key);
        if (iA >= 0) {
            return this.values[iA];
        }
        return null;
    }
}
