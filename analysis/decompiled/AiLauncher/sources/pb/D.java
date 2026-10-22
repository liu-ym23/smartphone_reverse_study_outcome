package pb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\fB)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001b¨\u0006\u001d"}, d2 = {"Lpb/D;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlin/Function2;", "", "", "readIfAbsent", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lp9/p;)V", "index", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", Const.INTENT_KEY_UMID, "()I", "elementsCount", "", "e", "(I)[J", Const.INTENT_KEY_PKGNAME, "c", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lp9/p;", "", "J", "lowerMarks", "[J", "highMarksArray", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class D {

    /* renamed from: f, reason: collision with root package name */
    public static final long[] f38265f = new long[0];

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SerialDescriptor descriptor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final p9.p<SerialDescriptor, Integer, Boolean> readIfAbsent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public long lowerMarks;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final long[] highMarksArray;

    /* JADX WARN: Multi-variable type inference failed */
    public D(SerialDescriptor descriptor, p9.p<? super SerialDescriptor, ? super Integer, Boolean> readIfAbsent) {
        kotlin.jvm.internal.p.i(descriptor, "descriptor");
        kotlin.jvm.internal.p.i(readIfAbsent, "readIfAbsent");
        this.descriptor = descriptor;
        this.readIfAbsent = readIfAbsent;
        int iD = descriptor.d();
        if (iD <= 64) {
            this.lowerMarks = iD != 64 ? (-1) << iD : 0L;
            this.highMarksArray = f38265f;
        } else {
            this.lowerMarks = 0L;
            this.highMarksArray = e(iD);
        }
    }

    public final void a(int index) {
        if (index < 64) {
            this.lowerMarks |= 1 << index;
        } else {
            b(index);
        }
    }

    public final void b(int index) {
        int i10 = (index >>> 6) - 1;
        long[] jArr = this.highMarksArray;
        jArr[i10] = jArr[i10] | (1 << (index & 63));
    }

    public final int c() {
        int length = this.highMarksArray.length;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            int i12 = i11 * 64;
            long j10 = this.highMarksArray[i10];
            while (j10 != -1) {
                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j10);
                j10 |= 1 << iNumberOfTrailingZeros;
                int i13 = iNumberOfTrailingZeros + i12;
                if (this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(i13)).booleanValue()) {
                    this.highMarksArray[i10] = j10;
                    return i13;
                }
            }
            this.highMarksArray[i10] = j10;
            i10 = i11;
        }
        return -1;
    }

    public final int d() {
        int iNumberOfTrailingZeros;
        int iD = this.descriptor.d();
        do {
            long j10 = this.lowerMarks;
            if (j10 == -1) {
                if (iD > 64) {
                    return c();
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j10);
            this.lowerMarks |= 1 << iNumberOfTrailingZeros;
        } while (!this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(iNumberOfTrailingZeros)).booleanValue());
        return iNumberOfTrailingZeros;
    }

    public final long[] e(int elementsCount) {
        long[] jArr = new long[(elementsCount - 1) >>> 6];
        if ((elementsCount & 63) != 0) {
            jArr[Z8.r.e0(jArr)] = (-1) << elementsCount;
        }
        return jArr;
    }
}
