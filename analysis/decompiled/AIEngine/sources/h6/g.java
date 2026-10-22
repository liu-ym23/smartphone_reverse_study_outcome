package h6;

import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9308a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ModelManagerFragment f9309b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f9310c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f9311d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List f9312e;

    public /* synthetic */ g(ModelManagerFragment modelManagerFragment, List list, List list2, boolean z) {
        this.f9309b = modelManagerFragment;
        this.f9311d = list;
        this.f9312e = list2;
        this.f9310c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9308a) {
            case 0:
                ModelManagerFragment.reload$lambda$24$lambda$23(this.f9309b, this.f9311d, this.f9312e, this.f9310c);
                break;
            default:
                ModelManagerFragment.performUninstall$lambda$66$lambda$65(this.f9309b, this.f9310c, this.f9311d, this.f9312e);
                break;
        }
    }

    public /* synthetic */ g(ModelManagerFragment modelManagerFragment, boolean z, List list, List list2) {
        this.f9309b = modelManagerFragment;
        this.f9310c = z;
        this.f9311d = list;
        this.f9312e = list2;
    }
}
