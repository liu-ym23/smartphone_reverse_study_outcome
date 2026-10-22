package j0;

import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0016R$\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u001d\u001a\u00060\u001aj\u0002`\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0016\u0010\r\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017¨\u0006\""}, d2 = {"Lj0/d;", "", "<init>", "()V", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "default", Const.INTENT_KEY_UMID, "(J)J", UxipConstants.f30680s, "", Const.INTENT_KEY_APIKEY, "(J)I", "index", "LY8/t;", "e", "(I)V", Const.INTENT_KEY_PKGNAME, "f", "(II)V", "atLeast", "c", "()I", "I", "getSize", ContentDisposition.Parameters.Size, "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "[J", "values", "", "[I", "handles", "firstFreeHandle", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: j0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4746d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int size;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long[] values = C4748f.b(16);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int[] index = new int[16];

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int[] handles;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int firstFreeHandle;

    public C4746d() {
        int[] iArr = new int[16];
        int i10 = 0;
        while (i10 < 16) {
            int i11 = i10 + 1;
            iArr[i10] = i11;
            i10 = i11;
        }
        this.handles = iArr;
    }

    public final int a(long value) {
        c(this.size + 1);
        int i10 = this.size;
        this.size = i10 + 1;
        int iB = b();
        this.values[i10] = value;
        this.index[i10] = iB;
        this.handles[iB] = i10;
        e(i10);
        return iB;
    }

    public final int b() {
        int length = this.handles.length;
        if (this.firstFreeHandle >= length) {
            int i10 = length * 2;
            int[] iArr = new int[i10];
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i11 + 1;
                iArr[i11] = i12;
                i11 = i12;
            }
            C1168p.l(this.handles, iArr, 0, 0, 0, 14, null);
            this.handles = iArr;
        }
        int i13 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[i13];
        return i13;
    }

    public final void c(int atLeast) {
        int length = this.values.length;
        if (atLeast <= length) {
            return;
        }
        int i10 = length * 2;
        long[] jArrB = C4748f.b(i10);
        int[] iArr = new int[i10];
        C1168p.m(this.values, jArrB, 0, 0, 0, 12, null);
        C1168p.l(this.index, iArr, 0, 0, 0, 14, null);
        this.values = jArrB;
        this.index = iArr;
    }

    public final long d(long j10) {
        return this.size > 0 ? this.values[0] : j10;
    }

    public final void e(int index) {
        long[] jArr = this.values;
        long j10 = jArr[index];
        while (index > 0) {
            int i10 = ((index + 1) >> 1) - 1;
            if (kotlin.jvm.internal.p.l(jArr[i10], j10) <= 0) {
                return;
            }
            f(i10, index);
            index = i10;
        }
    }

    public final void f(int a10, int b10) {
        long[] jArr = this.values;
        int[] iArr = this.index;
        int[] iArr2 = this.handles;
        long j10 = jArr[a10];
        jArr[a10] = jArr[b10];
        jArr[b10] = j10;
        int i10 = iArr[a10];
        int i11 = iArr[b10];
        iArr[a10] = i11;
        iArr[b10] = i10;
        iArr2[i11] = a10;
        iArr2[i10] = b10;
    }
}
