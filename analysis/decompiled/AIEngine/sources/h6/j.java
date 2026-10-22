package h6;

import com.stepos.aiengine.modelmanager.ModelManagerFragment;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9320a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModelManagerFragment f9321b;

    public /* synthetic */ j(ModelManagerFragment modelManagerFragment, int i10) {
        this.f9320a = i10;
        this.f9321b = modelManagerFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f9320a;
        ModelManagerFragment modelManagerFragment = this.f9321b;
        switch (i10) {
            case 0:
                ModelManagerFragment.doRetry$lambda$48$lambda$47(modelManagerFragment);
                break;
            case 1:
                ModelManagerFragment.doStartOrResume$lambda$52$lambda$51(modelManagerFragment);
                break;
            case 2:
                ModelManagerFragment.presetInstalledRefresh$lambda$2(modelManagerFragment);
                break;
            case 3:
                ModelManagerFragment.installedDataRefresh$lambda$4(modelManagerFragment);
                break;
            default:
                ModelManagerFragment.onViewCreated$lambda$12$lambda$11(modelManagerFragment);
                break;
        }
    }
}
