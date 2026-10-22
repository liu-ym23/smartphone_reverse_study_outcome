package i6;

import f6.q;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k extends q {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f3169e;

    public k(long j4, k kVar, int i8) {
        super(j4, kVar, i8);
        this.f3169e = new AtomicReferenceArray(j.f3168f);
    }

    @Override // f6.q
    public final int g() {
        return j.f3168f;
    }

    @Override // f6.q
    public final void h(int i8, f5.h hVar) {
        this.f3169e.set(i8, j.f3167e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f2659c + ", hashCode=" + hashCode() + AbstractJsonLexerKt.END_LIST;
    }
}
