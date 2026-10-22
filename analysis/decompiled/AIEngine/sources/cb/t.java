package cb;

import android.content.Context;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.tonyodev.fetch2.Download;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3397a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3398b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3399c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3400d;

    public /* synthetic */ t(ya.f fVar, Download download, boolean z) {
        this.f3399c = fVar;
        this.f3400d = download;
        this.f3398b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3397a) {
            case 0:
                ((ya.f) this.f3399c).onQueued((Download) this.f3400d, this.f3398b);
                break;
            default:
                ModelManagerFragment.reload$lambda$24(this.f3398b, (Context) this.f3399c, (ModelManagerFragment) this.f3400d);
                break;
        }
    }

    public /* synthetic */ t(boolean z, Context context, ModelManagerFragment modelManagerFragment) {
        this.f3398b = z;
        this.f3399c = context;
        this.f3400d = modelManagerFragment;
    }
}
