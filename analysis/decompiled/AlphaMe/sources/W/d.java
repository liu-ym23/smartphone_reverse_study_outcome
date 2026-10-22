package W;

import Z2.InterfaceC0126g;
import android.view.Choreographer;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1938a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1939b;

    public /* synthetic */ d(int i4, Object obj) {
        this.f1938a = i4;
        this.f1939b = obj;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j4) {
        int i4 = this.f1938a;
        Object obj = this.f1939b;
        switch (i4) {
            case 0:
                ((Runnable) obj).run();
                break;
            case 1:
                ((Runnable) obj).run();
                break;
            default:
                HandlerDispatcherKt.postFrameCallback$lambda$6((InterfaceC0126g) obj, j4);
                break;
        }
    }
}
