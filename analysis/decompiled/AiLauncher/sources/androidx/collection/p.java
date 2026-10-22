package androidx.collection;

import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import c0.C1481a;
import c0.C1484d;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0017\u0010\fJ\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0019\u0010\u0006R\u0016\u0010\u001c\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/collection/p;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ScatterSet;", "", "initialCapacity", "<init>", "(I)V", "LY8/t;", "m", "capacity", "l", "k", "()V", "element", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Object;)I", "hash1", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)I", "", "f", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "newCapacity", "n", "e", "I", "growthLimit", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class p<E> extends ScatterSet<E> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int growthLimit;

    public p(int i10) {
        super(null);
        if (!(i10 >= 0)) {
            C1484d.a("Capacity must be a positive value.");
        }
        m(r.d(i10));
    }

    public final boolean f(E element) {
        int i10 = get_size();
        this.elements[i(element)] = element;
        return get_size() != i10;
    }

    public final void g() {
        if (this._capacity <= 8 || Long.compareUnsigned(Y8.o.b(Y8.o.b(this._size) * 32), Y8.o.b(Y8.o.b(this._capacity) * 25)) > 0) {
            n(r.b(this._capacity));
        } else {
            h();
        }
    }

    public final void h() {
        long j10;
        long[] jArr = this.metadata;
        int i10 = this._capacity;
        Object[] objArr = this.elements;
        int i11 = (i10 + 7) >> 3;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            long j11 = jArr[i13] & (-9187201950435737472L);
            jArr[i13] = (-72340172838076674L) & ((~j11) + (j11 >>> 7));
        }
        int iE0 = Z8.r.e0(jArr);
        int i14 = iE0 - 1;
        long j12 = 72057594037927935L;
        jArr[i14] = (jArr[i14] & 72057594037927935L) | (-72057594037927936L);
        jArr[iE0] = jArr[0];
        int i15 = 0;
        while (i15 != i10) {
            int i16 = i15 >> 3;
            int i17 = (i15 & 7) << 3;
            long j13 = (jArr[i16] >> i17) & 255;
            if (j13 != 128 && j13 == 254) {
                Object obj = objArr[i15];
                int iHashCode = (obj != null ? obj.hashCode() : i12) * (-862048943);
                int i18 = (iHashCode ^ (iHashCode << 16)) >>> 7;
                int iJ = j(i18);
                int i19 = i18 & i10;
                int i20 = i12;
                if (((iJ - i19) & i10) / 8 == ((i15 - i19) & i10) / 8) {
                    jArr[i16] = ((r7 & 127) << i17) | ((~(255 << i17)) & jArr[i16]);
                    jArr[Z8.r.e0(jArr)] = (jArr[i20] & j12) | Long.MIN_VALUE;
                    i15++;
                    i12 = i20;
                } else {
                    int i21 = iJ >> 3;
                    long j14 = jArr[i21];
                    int i22 = (iJ & 7) << 3;
                    if (((j14 >> i22) & 255) == 128) {
                        j10 = j12;
                        jArr[i21] = ((r7 & 127) << i22) | (j14 & (~(255 << i22)));
                        jArr[i16] = (jArr[i16] & (~(255 << i17))) | (128 << i17);
                        objArr[iJ] = objArr[i15];
                        objArr[i15] = null;
                    } else {
                        j10 = j12;
                        jArr[i21] = ((r7 & 127) << i22) | (j14 & (~(255 << i22)));
                        Object obj2 = objArr[iJ];
                        objArr[iJ] = objArr[i15];
                        objArr[i15] = obj2;
                        i15--;
                    }
                    jArr[Z8.r.e0(jArr)] = (jArr[i20] & j10) | Long.MIN_VALUE;
                    i15++;
                    i12 = i20;
                    j12 = j10;
                }
            } else {
                i15++;
            }
        }
        k();
    }

    public final int i(E element) {
        int iHashCode = (element != null ? element.hashCode() : 0) * (-862048943);
        int i10 = iHashCode ^ (iHashCode << 16);
        int i11 = i10 >>> 7;
        int i12 = i10 & 127;
        int i13 = this._capacity;
        int i14 = i11 & i13;
        int i15 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j10 = ((jArr[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr[i16] >>> i17);
            long j11 = i12;
            int i18 = i12;
            long j12 = j10 ^ (j11 * 72340172838076673L);
            for (long j13 = (~j12) & (j12 - 72340172838076673L) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                int iNumberOfTrailingZeros = (i14 + (Long.numberOfTrailingZeros(j13) >> 3)) & i13;
                if (kotlin.jvm.internal.p.d(this.elements[iNumberOfTrailingZeros], element)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j10) << 6) & j10 & (-9187201950435737472L)) != 0) {
                int iJ = j(i11);
                if (this.growthLimit == 0 && ((this.metadata[iJ >> 3] >> ((iJ & 7) << 3)) & 255) != 254) {
                    g();
                    iJ = j(i11);
                }
                this._size++;
                int i19 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i20 = iJ >> 3;
                long j14 = jArr2[i20];
                int i21 = (iJ & 7) << 3;
                this.growthLimit = i19 - (((j14 >> i21) & 255) == 128 ? 1 : 0);
                int i22 = this._capacity;
                long j15 = ((~(255 << i21)) & j14) | (j11 << i21);
                jArr2[i20] = j15;
                jArr2[(((iJ - 7) & i22) + (i22 & 7)) >> 3] = j15;
                return iJ;
            }
            i15 += 8;
            i14 = (i14 + i15) & i13;
            i12 = i18;
        }
    }

    public final int j(int hash1) {
        int i10 = this._capacity;
        int i11 = hash1 & i10;
        int i12 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            long j10 = ((jArr[i13 + 1] << (64 - i14)) & ((-i14) >> 63)) | (jArr[i13] >>> i14);
            long j11 = j10 & ((~j10) << 7) & (-9187201950435737472L);
            if (j11 != 0) {
                return (i11 + (Long.numberOfTrailingZeros(j11) >> 3)) & i10;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
        }
    }

    public final void k() {
        this.growthLimit = r.a(get_capacity()) - this._size;
    }

    public final void l(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = r.f11740a;
        } else {
            long[] jArr2 = new long[((capacity + 15) & (-8)) >> 3];
            C1168p.A(jArr2, -9187201950435737472L, 0, 0, 6, null);
            jArr = jArr2;
        }
        this.metadata = jArr;
        int i10 = capacity >> 3;
        long j10 = 255 << ((capacity & 7) << 3);
        jArr[i10] = (jArr[i10] & (~j10)) | j10;
        k();
    }

    public final void m(int initialCapacity) {
        int iMax = initialCapacity > 0 ? Math.max(7, r.c(initialCapacity)) : 0;
        this._capacity = iMax;
        l(iMax);
        this.elements = iMax == 0 ? C1481a.f15398c : new Object[iMax];
    }

    public final void n(int newCapacity) {
        long[] jArr = this.metadata;
        Object[] objArr = this.elements;
        int i10 = this._capacity;
        m(newCapacity);
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.elements;
        int i11 = this._capacity;
        for (int i12 = 0; i12 < i10; i12++) {
            if (((jArr[i12 >> 3] >> ((i12 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i12];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
                int i13 = iHashCode ^ (iHashCode << 16);
                int iJ = j(i13 >>> 7);
                long j10 = i13 & 127;
                int i14 = iJ >> 3;
                int i15 = (iJ & 7) << 3;
                long j11 = (jArr2[i14] & (~(255 << i15))) | (j10 << i15);
                jArr2[i14] = j11;
                jArr2[(((iJ - 7) & i11) + (i11 & 7)) >> 3] = j11;
                objArr2[iJ] = obj;
            }
        }
    }

    public /* synthetic */ p(int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 6 : i10);
    }
}
