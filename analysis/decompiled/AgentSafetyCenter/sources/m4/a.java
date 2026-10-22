package m4;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8197c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f8198f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f8199g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f8200h;

    public /* synthetic */ a(int i) {
        this.f8197c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8197c) {
            case 0:
                b bVar = (b) this.f8200h;
                ((e) bVar.f8203c).c(this.f8198f, this.f8199g);
                break;
            default:
                ((a1.g) this.f8200h).c(this.f8198f, this.f8199g);
                break;
        }
    }
}
