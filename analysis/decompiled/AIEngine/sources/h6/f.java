package h6;

import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9305a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModelManagerFragment f9306b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f9307c;

    public /* synthetic */ f(ModelManagerFragment modelManagerFragment, List list, int i10) {
        this.f9305a = i10;
        this.f9306b = modelManagerFragment;
        this.f9307c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9305a) {
            case 0:
                ModelManagerFragment.reload$lambda$24$lambda$22(this.f9306b, this.f9307c);
                break;
            case 1:
                ModelManagerFragment.refreshRowsInPlace$lambda$29$lambda$28(this.f9306b, this.f9307c);
                break;
            default:
                ModelManagerFragment.schedulePresetFallback$lambda$25(this.f9306b, this.f9307c);
                break;
        }
    }
}
