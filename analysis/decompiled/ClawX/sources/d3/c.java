package d3;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1797a;

    public c(f fVar) {
        this.f1797a = fVar;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        f fVar;
        try {
            IInterface iInterface = this.f1797a.f1801a;
            if (iInterface != null) {
                iInterface.asBinder().unlinkToDeath(this, 0);
            }
        } catch (Exception unused) {
        }
        synchronized (this.f1797a.f1802b) {
            fVar = this.f1797a;
            fVar.f1801a = null;
        }
        synchronized (fVar.d) {
            fVar.d.removeIf(new a(2));
        }
    }
}
