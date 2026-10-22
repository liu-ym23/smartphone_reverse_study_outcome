package m4;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import h.m;
import java.lang.invoke.VarHandle;
import java.util.Random;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Choreographer.FrameCallback {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8226c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f8227f;

    public /* synthetic */ g(int i) {
        this.f8226c = i;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j10) {
        int i = this.f8226c;
        Object obj = this.f8227f;
        switch (i) {
            case 0:
                Handler handlerCreateAsync = Handler.createAsync(Looper.getMainLooper());
                int iNextInt = new Random().nextInt(Math.max(1000, 1));
                m mVar = new m(1);
                mVar.f4853f = (Context) obj;
                VarHandle.storeStoreFence();
                handlerCreateAsync.postDelayed(mVar, iNextInt + 5000);
                break;
            default:
                ((Runnable) obj).run();
                break;
        }
    }
}
