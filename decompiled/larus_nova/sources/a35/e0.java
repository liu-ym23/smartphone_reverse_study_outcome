package a35;

import com.bytedance.ee.bear.document.offline.sync.sync.SyncStatusModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes16.dex */
public final class e0 implements tb5.i<SyncStatusModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<d0> f1533a;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public e0(d0 r100) {
        this.f1533a = new WeakReference(r100);
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, tb5.m r101) {
        SyncStatusModel r102 = (SyncStatusModel) r100;
        WeakReference<d0> r103 = this.f1533a;
        if (r103 == null) goto L8;
        d0 r104 = r103.get();
        if (r104 == null) goto L9;
        r104.a(r102);
        return;
    L9:
        return;
    }
}
