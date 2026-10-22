package k0;

import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ i0 f6915c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ s0.d f6916f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ p.z f6917g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ int f6918h;

    @Override // xb.l
    public final Object invoke(Object obj) {
        i0 i0Var = this.f6915c;
        s0.d dVar = this.f6916f;
        p.z zVar = this.f6917g;
        int i = this.f6918h;
        if (obj == i0Var) {
            od.f.e("A derived state calculation cannot read itself");
            return null;
        }
        if (obj instanceof u0.v) {
            int i3 = dVar.f11175a - i;
            int iD = zVar.d(obj);
            zVar.h(Math.min(i3, iD >= 0 ? zVar.f9652c[iD] : Reader.READ_DONE), obj);
        }
        return jb.v.f6774a;
    }
}
