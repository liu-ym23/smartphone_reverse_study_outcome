package b0;

import android.os.Handler;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public f f841a;

    /* renamed from: b, reason: collision with root package name */
    public g f842b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f843c;

    @Override // java.lang.Runnable
    public final void run() {
        Object objCall;
        try {
            objCall = this.f841a.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.f843c.post(new a(this.f842b, 1, objCall));
    }
}
