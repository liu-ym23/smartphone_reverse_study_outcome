package z1;

import android.view.ScrollCaptureSession;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public ScrollCaptureSession f16146c;

    /* renamed from: f, reason: collision with root package name */
    public o2.j f16147f;

    /* renamed from: g, reason: collision with root package name */
    public int f16148g;

    /* renamed from: h, reason: collision with root package name */
    public int f16149h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d f16150j;

    /* renamed from: k, reason: collision with root package name */
    public int f16151k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, pb.c cVar) {
        super(cVar);
        this.f16150j = dVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.f16151k |= Integer.MIN_VALUE;
        return d.a(this.f16150j, null, null, this);
    }
}
