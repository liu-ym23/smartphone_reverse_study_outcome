package g;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    public int f2787a;

    /* renamed from: b, reason: collision with root package name */
    public int f2788b;

    /* renamed from: c, reason: collision with root package name */
    public int f2789c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f2790e;

    /* renamed from: f, reason: collision with root package name */
    public int f2791f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2792g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2793h;

    public final void a(int i8, int i9) {
        this.f2789c = i8;
        this.d = i9;
        this.f2793h = true;
        if (this.f2792g) {
            if (i9 != Integer.MIN_VALUE) {
                this.f2787a = i9;
            }
            if (i8 != Integer.MIN_VALUE) {
                this.f2788b = i8;
                return;
            }
            return;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f2787a = i8;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.f2788b = i9;
        }
    }
}
