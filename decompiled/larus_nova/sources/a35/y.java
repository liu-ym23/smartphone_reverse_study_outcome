package a35;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.offline.sync.OfflineDbConfig;
import com.bytedance.ee.bear.document.offline.sync.sync.SyncStatusModel;
import com.larksuite.framework.thread.CoreThreadPool;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class y implements d0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static OfflineDbConfig f1550w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static volatile y f1551x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f1552y = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfflineDoc f1554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OfflineDoc f1555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f1556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f1557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a0 f1558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<OfflineDoc> f1559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LiveData<List<String>> f1560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b0 f1561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f1562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.contract.n.e> f1564l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<com.bytedance.ee.bear.contract.n.a> f1565m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.ee.bear.contract.j f1566n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public h0 f1567o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ee.bear.contract.d f1568p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LiveData<ConnectionService.NetworkState> f1569q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1570r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1571s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f1572t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f1573u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a35.a f1574v;

    public class a implements Observer<List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f1575a;

        public a(y r100) {
            this.f1575a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(List<String> r100) {
            final List<String> r101 = r100;
            Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new w(this, r101), new x());
        }
    }

    public class b implements Observer<ConnectionService.NetworkState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y f1576a;

        public b(y r100) {
            this.f1576a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(ConnectionService.NetworkState r100) {
            ConnectionService.NetworkState r101 = r100;
            tt5.a.b("SyncOfflineDataManager", "network changed!");
            this.f1576a.f1570r = r101.a();
            y r102 = this.f1576a;
            if (r102.f1571s == false) goto L5;
            y.c(r102);
        L5:
            this.f1576a.f1571s = !r101.a();
        }
    }

    static {
        f1550w = new OfflineDbConfig();
        f1552y = com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.mobile.background.sync.opt");
    }

    public static y e() {
        if (f1551x != null) goto L15;
        monitor-enter(y.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1551x != null) goto L9;
        f1551x = new y();     // Catch: Throwable -> L11
    L9:
        monitor-exit(y.class);     // Catch: Throwable -> L11
    L15:
        return f1551x;
    }

    public final boolean f() {
        boolean r100 = this.f1559g.isEmpty();
        if (r100 == true) goto L6;
        tt5.a.h("SyncOfflineDataManager", "hasSyncTask(): " + this.f1559g.size());
    L6:
        return !r100;
    }

    public final void h() {
        a0 r100 = this.f1558f;
        if (r100 == null) goto L6;
        r100.sendEmptyMessage(1);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [a35.a] */
    public y() {
        OfflineDoc r100 = new OfflineDoc();
        this.f1554b = r100;
        this.f1555c = r100;
        this.f1557e = new Handler(Looper.getMainLooper());
        this.f1559g = Collections.synchronizedList(new LinkedList());
        this.f1561i = new b0();
        this.f1562j = new CopyOnWriteArrayList();
        this.f1564l = new ArrayList();
        this.f1565m = new ArrayList();
        this.f1571s = true;
        this.f1572t = new a(this);
        this.f1573u = new b(this);
        this.f1574v = new a35.a(this);
        this.f1553a = eu5.b.f474075a;
        com.bytedance.ee.bear.contract.j r101 = com.bytedance.ee.bear.contract.j.a.f217090a;
        this.f1566n = r101;
        this.f1569q = r101.a();
        this.f1568p = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        this.f1558f = new a0(this, CoreThreadPool.getBackgroundHandler().getLooper());
        h0 r102 = (h0) org.koin.java.a.a(h0.class);
        this.f1567o = r102;
        r102.Pe(new p(this));
        com.bytedance.ee.util.ui.m.a(new q(this));
        OfflineDbConfig r103 = (OfflineDbConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("offline_db_config", OfflineDbConfig.class, new OfflineDbConfig());
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.offline_db_size <= 0) goto L9;
        f1550w = r103;
        tt5.a.h("SyncOfflineDataManager", "OfflineDbConfig " + f1550w);
        return;
    }

    public static void c(final y r100) {
        if (r100.f1570r == false) goto L6;
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).map(new s()).subscribe(new t(r100), new u());
        return;
    }

    @Override // a35.d0
    public final void a(SyncStatusModel r100) {
        if (r100 != null) goto L7;
        tt5.a.b("SyncOfflineDataManager", "sync status data is empty -- ignore");
        return;
    L7:
        if (TextUtils.equals(r100.objToken, this.f1555c.getObj_token()) == false) goto L9;
    L12:
        com.bytedance.apm.util.n<Boolean, Integer> r101 = this.f1561i.b(this.f1555c);
        tt5.a.h("SyncOfflineDataManager", "notifySyncStatus    FEdata.status: " + r100.status + "    FEdata.objToken: " + du5.b.e(r100.objToken) + "    mCurrentOpenDoc.token: " + du5.b.e(this.f1555c.getObj_token()) + "    mRetryTime: " + r101.f190677b + "    code: " + r100.code);
        int r102 = r100.status;
        if (r102 != 0) goto L16;
        c0.a(this.f1568p, this.f1555c, r101.f190677b.intValue(), 0);
        this.f1561i.f(this.f1555c.getObj_token());
        this.f1557e.removeCallbacks(this.f1574v);
        g(3);
        OfflineDoc r103 = this.f1555c;
        this.f1555c = this.f1554b;
        this.f1559g.remove(r103);
        this.f1556d = false;
        h();
        return;
    L16:
        if (r102 == 1) goto L18;
        if (r102 == 2) goto L38;
        if (r102 != 3) goto L37;
        g(2);
        return;
    L37:
        return;
    L38:
        return;
    L18:
        if (TextUtils.equals(d25.d.f466517d, r100.objToken) == false) goto L20;
    L21:
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).l(r100.code, null);
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.a(com.bytedance.ee.bear.quoto.t.class)).h(r100.code, null, false);
    L22:
        c0.a(this.f1568p, this.f1555c, r101.f190677b.intValue(), 1);
        this.f1557e.removeCallbacks(this.f1574v);
        if (r101.f190676a.booleanValue() == false) goto L25;
        tt5.a.b("SyncOfflineDataManager", "doc :" + du5.b.e(this.f1555c.getObj_token()) + " able to retry");
        this.f1561i.a(this.f1555c);
        g(1);
    L26:
        OfflineDoc r104 = this.f1555c;
        this.f1555c = this.f1554b;
        this.f1559g.remove(r104);
        this.f1556d = false;
        h();
        if (this.f1558f.hasMessages(2) == true) goto L35;
        this.f1558f.sendEmptyMessageDelayed(2, 60000);
        return;
    L35:
        return;
    L25:
        tt5.a.b("SyncOfflineDataManager", "doc :" + du5.b.e(this.f1555c.getObj_token()) + " exceed retry limit, mark failed");
        g(4);
        goto L26
    L20:
        if (TextUtils.equals(d25.d.f466518e, r100.objToken) == false) goto L22;
    L9:
        if (r100.status != 0) goto L12;
        this.f1561i.f(r100.objToken);
    }

    public final Flowable<Long> d(final long r100) {
        return Flowable.just("").observeOn(fo5.d.b()).map(new l(this, r100)).doOnError(new o());
    }

    public final void g(int r100) {
        tt5.a.h("SyncOfflineDataManager", "notifySyncStateChanged... status = " + r100);
        OfflineDoc r101 = this.f1555c;
        if (r101 != this.f1554b) goto L6;
        tt5.a.h("SyncOfflineDataManager", "notifySyncStateChanged: mCurrentOpenDoc == EMPTY_OFFLINE_DOC");
        return;
    L6:
        r101.setSyncState(r100);
        List<com.bytedance.ee.bear.contract.n.a> r102 = this.f1565m;
        if (r102 == null) goto L14;
        Iterator r103 = new ArrayList(r102).iterator();
    L10:
        if (r103.hasNext() == false) goto L20;
        com.bytedance.ee.bear.contract.n.a r104 = (com.bytedance.ee.bear.contract.n.a) r103.next();
        if (r104 == null) goto L10;
        r104.a(this.f1555c);
        goto L10
    L20:
        return;
    }

    public final void i(List<OfflineDoc> r100) {
        tt5.a.h("SyncOfflineDataManager", "uploadDocs... raw docList size: " + r100.size());
        Flowable.fromIterable(r100).subscribeOn(fo5.d.a()).filter(new e(this)).collect(new f(this), new g(this)).subscribe(new h(this), new i());
    }

    public static void b(final y r100, String r101, List r102, final OfflineDoc r103) {
        r100.getClass();
        if (r103 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals(r101, r103.getObj_token()) == false) goto L9;
        tt5.a.k("SyncOfflineDataManager", "beginSync() equals with foreground webview mCurrentToken " + du5.b.g(r103.getObj_token()));
        r100.f1561i.f(r103.getObj_token());
        r100.f1559g.remove(r103);
        r100.h();
        return;
    L9:
        if (f1552y == false) goto L16;
        if (hu5.a.f(r102) == false) goto L16;
        if (((CopyOnWriteArrayList) r102).contains(r103.getObj_token()) == false) goto L16;
        tt5.a.k("SyncOfflineDataManager", "beginSync() equals with foreground webview  v2 mCurrentToken " + du5.b.g(r103.getObj_token()));
        r100.f1561i.f(r103.getObj_token());
        r100.f1559g.remove(r103);
        r100.h();
        return;
    L16:
        if (((CopyOnWriteArrayList) r100.f1562j).contains(r103.getObj_token()) == true) goto L18;
        tt5.a.k("SyncOfflineDataManager", "beginSync() mNeedSyncTokens not contain mCurrentToken " + du5.b.g(r103.getObj_token()));
        r100.f1559g.remove(r103);
        r100.h();
        return;
    L18:
        final com.bytedance.apm.util.n<Boolean, Integer> r104 = r100.f1561i.b(r103);
        if (r104.f190676a.booleanValue() == true) goto L21;
        tt5.a.k("SyncOfflineDataManager", "beginSync() retry recorder rejects :" + du5.b.g(r103.getObj_token()));
        r100.f1559g.remove(r103);
        r100.h();
        return;
    L21:
        r100.f1556d = true;
        r100.f1555c = r103;
        tt5.a.h("SyncOfflineDataManager", "startRnSync " + du5.b.g(r103.getObj_token()) + " : " + du5.b.g(r101));
        ((com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class)).d(new n(r100, r103, r104)).subscribe(new k(), new m());
    }
}
