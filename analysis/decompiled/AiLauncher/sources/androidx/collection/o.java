package androidx.collection;

import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import c0.C1481a;
import c0.C1484d;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/collection/o;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/q;", "", "initialCapacity", "<init>", "(I)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "capacity", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "()V", "I", "growthLimit", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o<K, V> extends q<K, V> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int growthLimit;

    public o(int i10) {
        super(null);
        if (!(i10 >= 0)) {
            C1484d.a("Capacity must be a positive value.");
        }
        h(r.d(i10));
    }

    public final void f() {
        this.growthLimit = r.a(get_capacity()) - this._size;
    }

    public final void g(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = r.f11740a;
        } else {
            long[] jArr2 = new long[((capacity + 15) & (-8)) >> 3];
            C1168p.A(jArr2, -9187201950435737472L, 0, 0, 6, null);
            int i10 = capacity >> 3;
            long j10 = 255 << ((capacity & 7) << 3);
            jArr2[i10] = (jArr2[i10] & (~j10)) | j10;
            jArr = jArr2;
        }
        this.metadata = jArr;
        f();
    }

    public final void h(int initialCapacity) {
        int iMax = initialCapacity > 0 ? Math.max(7, r.c(initialCapacity)) : 0;
        this._capacity = iMax;
        g(iMax);
        this.keys = iMax == 0 ? C1481a.f15398c : new Object[iMax];
        this.values = iMax == 0 ? C1481a.f15398c : new Object[iMax];
    }
}
