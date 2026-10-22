package v3;

import G3.f;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import t3.e;
import t3.h;

/* loaded from: classes2.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f15724a;

    /* renamed from: b, reason: collision with root package name */
    public final u3.b f15725b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f15726c;

    public b(Handler handler) {
        this.f15724a = handler;
        AtomicReference atomicReference = u3.a.f15491b.f15492a;
        if (atomicReference.get() == null) {
            atomicReference.compareAndSet(null, u3.b.f15493a);
        }
        this.f15725b = (u3.b) atomicReference.get();
    }

    @Override // t3.h
    public final boolean a() {
        return this.f15726c;
    }

    @Override // t3.e
    public final h b(x3.a aVar) {
        return d(aVar, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // t3.h
    public final void c() {
        this.f15726c = true;
        this.f15724a.removeCallbacksAndMessages(this);
    }

    @Override // t3.e
    public final h d(x3.a aVar, long j4, TimeUnit timeUnit) {
        boolean z4 = this.f15726c;
        G3.e eVar = f.f653a;
        if (z4) {
            return eVar;
        }
        this.f15725b.getClass();
        Handler handler = this.f15724a;
        c cVar = new c(aVar, handler);
        Message messageObtain = Message.obtain(handler, cVar);
        messageObtain.obj = this;
        this.f15724a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j4));
        if (!this.f15726c) {
            return cVar;
        }
        this.f15724a.removeCallbacks(cVar);
        return eVar;
    }
}
