package Mb;

import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\f8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u001e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014¨\u0006\u0016"}, d2 = {"LMb/B;", "", "<init>", "()V", "LMb/b;", Const.INTENT_KEY_PKGNAME, "()LMb/b;", "node", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LMb/b;)V", "e", "", "vacantIndex", Const.INTENT_KEY_UMID, "(ILMb/b;)V", "c", "I", ContentDisposition.Parameters.Size, "", "[LMb/b;", "array", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int size;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public C0964b[] array = new C0964b[8];

    public final void a(C0964b node) {
        kotlin.jvm.internal.p.i(node, "node");
        int i10 = this.size + 1;
        this.size = i10;
        C0964b[] c0964bArr = this.array;
        if (i10 == c0964bArr.length) {
            C0964b[] c0964bArr2 = new C0964b[i10 * 2];
            C1168p.n(c0964bArr, c0964bArr2, 0, 0, 0, 14, null);
            this.array = c0964bArr2;
        }
        d(i10, node);
    }

    public final C0964b b() {
        return this.array[1];
    }

    public final void c(int vacantIndex, C0964b node) {
        C0964b c0964b;
        while (true) {
            int i10 = vacantIndex << 1;
            int i11 = i10 + 1;
            int i12 = this.size;
            if (i11 > i12) {
                if (i10 > i12) {
                    break;
                }
                c0964b = this.array[i10];
                kotlin.jvm.internal.p.f(c0964b);
            } else {
                c0964b = this.array[i10];
                kotlin.jvm.internal.p.f(c0964b);
                C0964b c0964b2 = this.array[i11];
                kotlin.jvm.internal.p.f(c0964b2);
                if (kotlin.jvm.internal.p.l(0L, c0964b2.getTimeoutAt() - c0964b.getTimeoutAt()) >= 0) {
                    c0964b = c0964b2;
                }
            }
            if (kotlin.jvm.internal.p.l(0L, c0964b.getTimeoutAt() - node.getTimeoutAt()) <= 0) {
                break;
            }
            int i13 = c0964b.index;
            c0964b.index = vacantIndex;
            this.array[vacantIndex] = c0964b;
            vacantIndex = i13;
        }
        this.array[vacantIndex] = node;
        node.index = vacantIndex;
    }

    public final void d(int vacantIndex, C0964b node) {
        while (true) {
            int i10 = vacantIndex >> 1;
            if (i10 == 0) {
                break;
            }
            C0964b c0964b = this.array[i10];
            kotlin.jvm.internal.p.f(c0964b);
            if (kotlin.jvm.internal.p.l(0L, node.getTimeoutAt() - c0964b.getTimeoutAt()) <= 0) {
                break;
            }
            c0964b.index = vacantIndex;
            this.array[vacantIndex] = c0964b;
            vacantIndex = i10;
        }
        this.array[vacantIndex] = node;
        node.index = vacantIndex;
    }

    public final void e(C0964b node) {
        kotlin.jvm.internal.p.i(node, "node");
        int i10 = node.index;
        if (i10 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i11 = this.size;
        C0964b c0964b = this.array[i11];
        kotlin.jvm.internal.p.f(c0964b);
        node.index = -1;
        this.array[i11] = null;
        this.size = i11 - 1;
        if (node == c0964b) {
            return;
        }
        int iL = kotlin.jvm.internal.p.l(0L, c0964b.getTimeoutAt() - node.getTimeoutAt());
        if (iL == 0) {
            this.array[i10] = c0964b;
            c0964b.index = i10;
        } else if (iL < 0) {
            c(i10, c0964b);
        } else {
            d(i10, c0964b);
        }
    }
}
