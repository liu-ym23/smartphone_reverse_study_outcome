package kb;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends a {

    /* renamed from: g, reason: collision with root package name */
    public int f7412g;

    /* renamed from: h, reason: collision with root package name */
    public int f7413h;
    public /* synthetic */ a0 i;

    @Override // kb.a
    public final void a() {
        a0 a0Var = this.i;
        int i = this.f7412g;
        if (i == 0) {
            this.f7379c = 2;
            return;
        }
        Object[] objArr = a0Var.f7381f;
        int i3 = this.f7413h;
        this.f7380f = objArr[i3];
        this.f7379c = 1;
        this.f7413h = (i3 + 1) % a0Var.f7382g;
        this.f7412g = i - 1;
    }
}
