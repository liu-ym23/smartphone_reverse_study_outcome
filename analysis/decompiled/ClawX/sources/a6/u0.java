package a6;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u0 implements e1 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f220a;

    public u0(boolean z) {
        this.f220a = z;
    }

    @Override // a6.e1
    public final boolean a() {
        return this.f220a;
    }

    @Override // a6.e1
    public final q1 d() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f220a ? "Active" : "New");
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
