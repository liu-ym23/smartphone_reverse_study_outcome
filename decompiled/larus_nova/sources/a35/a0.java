package a35;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class a0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f1527a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        if (r100.what != 1) goto L19;
        if (this.f1527a.f1556d == true) goto L19;
        String r101 = d25.d.f466518e;
        List<String> r102 = d25.d.f466516c;
        y r103 = this.f1527a;
        if (r103.f1570r == true) goto L9;
    L17:
        com.bytedance.ee.util.ui.m.a(new z());
        tt5.a.h("SyncOfflineDataManager", "MSG_HANDLE_SYNC_DOC  size: " + this.f1527a.f1559g.size() + "   appIsVisible: " + ((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a() + "   mIsConnected: " + this.f1527a.f1570r);
    L23:
        super.handleMessage(r100);
        return;
    L9:
        if (r103.f1559g.isEmpty() == true) goto L17;
        if (((com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class)).a() == false) goto L17;
        y r104 = this.f1527a;     // Catch: Exception -> L15
        y.b(r104, r101, r102, (OfflineDoc) ListProtector.get(r104.f1559g, 0));     // Catch: Exception -> L15
    L15:
        e = move-exception;
        this.f1527a.f1556d = false;
        tt5.a.f("SyncOfflineDataManager", e, false);
    L19:
        if (r100.what != 2) goto L23;
        tt5.a.h("SyncOfflineDataManager", "MSG_RETRY  mUploadOfflineDocList: " + this.f1527a.f1559g.size() + "   mNeedSyncTokens: " + ((CopyOnWriteArrayList) this.f1527a.f1562j).size());
        if (((CopyOnWriteArrayList) this.f1527a.f1562j).size() <= 0) goto L23;
        y.c(this.f1527a);
        goto L23
    }

    public a0(y r100, Looper r101) {
        this.f1527a = r100;
        super(r101);
    }
}
