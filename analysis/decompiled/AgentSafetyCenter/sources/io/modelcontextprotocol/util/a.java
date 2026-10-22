package io.modelcontextprotocol.util;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6368c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ KeepAliveScheduler f6369f;

    public /* synthetic */ a(int i) {
        this.f6368c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6368c;
        KeepAliveScheduler keepAliveScheduler = this.f6369f;
        switch (i) {
            case 0:
                keepAliveScheduler.lambda$start$3();
                break;
            default:
                keepAliveScheduler.lambda$start$4();
                break;
        }
    }
}
