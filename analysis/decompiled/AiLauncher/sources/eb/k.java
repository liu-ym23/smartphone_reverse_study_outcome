package eb;

import Za.z;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00178\u0006¨\u0006\u0019"}, d2 = {"Leb/k;", "LZa/z;", "", "id", "prev", "", "pointers", "<init>", "(JLeb/k;I)V", "index", "", "cause", "Lkotlin/coroutines/d;", "context", "LY8/t;", "s", "(ILjava/lang/Throwable;Lkotlin/coroutines/d;)V", "", "toString", "()Ljava/lang/String;", "r", "()I", "numberOfSlots", "", "acquirers", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class k extends z<k> {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f32443e;

    public k(long j10, k kVar, int i10) {
        super(j10, kVar, i10);
        this.f32443e = new AtomicReferenceArray(j.f32442f);
    }

    @Override // Za.z
    public int r() {
        return j.f32442f;
    }

    @Override // Za.z
    public void s(int index, Throwable cause, kotlin.coroutines.d context) {
        getF32443e().set(index, j.f32441e);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + hashCode() + ']';
    }

    /* renamed from: v, reason: from getter */
    public final /* synthetic */ AtomicReferenceArray getF32443e() {
        return this.f32443e;
    }
}
