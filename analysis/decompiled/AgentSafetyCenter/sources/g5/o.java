package g5;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4334c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ AtomicBoolean f4335f;

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4334c;
        AtomicBoolean atomicBoolean = this.f4335f;
        switch (i) {
            case 0:
                atomicBoolean.set(true);
                break;
            default:
                atomicBoolean.set(true);
                break;
        }
    }
}
