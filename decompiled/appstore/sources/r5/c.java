package r5;

import android.os.MessageQueue;

/* JADX INFO: loaded from: classes.dex */
public class c implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MessageQueue.IdleHandler f23766a;

    public c(MessageQueue.IdleHandler r10) {
        this.f23766a = r10;
    }

    public MessageQueue.IdleHandler a() {
        return this.f23766a;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        String r10 = this.f23766a.getClass().getName();
        a.b(">>>>> Dispatching to IdleTask " + r10);
        long r11 = System.currentTimeMillis();
        boolean r12 = this.f23766a.queueIdle();
        a.b("<<<<< Finished to IdleTask " + r10);
        b.b().a().upload(r10, System.currentTimeMillis() - r11);
        return r12;
    }
}
