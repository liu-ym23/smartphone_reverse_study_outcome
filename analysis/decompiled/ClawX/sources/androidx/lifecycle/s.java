package androidx.lifecycle;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public m f720a;

    /* renamed from: b, reason: collision with root package name */
    public p f721b;

    public final void a(r rVar, l lVar) {
        m mVarA = lVar.a();
        m state1 = this.f720a;
        kotlin.jvm.internal.p.e(state1, "state1");
        if (mVarA.compareTo(state1) < 0) {
            state1 = mVarA;
        }
        this.f720a = state1;
        this.f721b.a(rVar, lVar);
        this.f720a = mVarA;
    }
}
