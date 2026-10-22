package m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7904a;

    /* renamed from: b, reason: collision with root package name */
    public int f7905b;

    /* renamed from: c, reason: collision with root package name */
    public int f7906c;

    /* renamed from: d, reason: collision with root package name */
    public int f7907d;

    /* renamed from: e, reason: collision with root package name */
    public int f7908e;

    /* renamed from: f, reason: collision with root package name */
    public int f7909f;

    /* renamed from: g, reason: collision with root package name */
    public int f7910g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7911h;
    public boolean i;

    public final void a(int i, int i3) {
        switch (this.f7904a) {
            case 0:
                this.f7907d = i;
                this.f7908e = i3;
                this.i = true;
                if (!this.f7911h) {
                    if (i != Integer.MIN_VALUE) {
                        this.f7905b = i;
                    }
                    if (i3 != Integer.MIN_VALUE) {
                        this.f7906c = i3;
                        break;
                    }
                } else {
                    if (i3 != Integer.MIN_VALUE) {
                        this.f7905b = i3;
                    }
                    if (i != Integer.MIN_VALUE) {
                        this.f7906c = i;
                        break;
                    }
                }
                break;
            default:
                this.f7907d = i;
                this.f7908e = i3;
                this.i = true;
                if (!this.f7911h) {
                    if (i != Integer.MIN_VALUE) {
                        this.f7905b = i;
                    }
                    if (i3 != Integer.MIN_VALUE) {
                        this.f7906c = i3;
                        break;
                    }
                } else {
                    if (i3 != Integer.MIN_VALUE) {
                        this.f7905b = i3;
                    }
                    if (i != Integer.MIN_VALUE) {
                        this.f7906c = i;
                        break;
                    }
                }
                break;
        }
    }
}
