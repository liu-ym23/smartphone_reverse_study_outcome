package n0;

import android.view.Choreographer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3937a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f3938b;

    public /* synthetic */ b(Runnable runnable, int i8) {
        this.f3937a = i8;
        this.f3938b = runnable;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j4) {
        int i8 = this.f3937a;
        Runnable runnable = this.f3938b;
        switch (i8) {
            case 0:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
