package com.bytedance.android.livesdk.chatroom.vs_base.log;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeBaseInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import fq1.t;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f118014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f118015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f118016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f118017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f118018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f118019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f118020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f118021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f118022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f118023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f118024k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f118025l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f118026m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f118027n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DataCenter f118028o;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f118029a;

        public final void a() {
            if (this.f118029a.f118020g == false) goto L5;
            long r100 = SystemClock.elapsedRealtime();
            g r101 = this.f118029a;
            long r102 = 60000 - (((r100 - r101.f118024k) - r101.f118023j) % 60000);
            r101.f118020g = false;
        L6:
            this.f118029a.f118014a.postDelayed(this, r102);
            g r103 = this.f118029a;
            if (r103.f118022i == false) goto L9;
        L13:
            r103.f118022i = false;
            return;
        L9:
            if (r102 != 60000) goto L13;
            d.a(r103.f118028o).d("watch_onemin", null, new Object[0]);
            return;
        L5:
            r102 = 60000;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(g r100) {
            this.f118029a = r100;
        }
    }

    public final void b() {
        if (this.f118018e == false) goto L5;
        return;
    L5:
        this.f118026m = true;
        if (this.f118024k != (-1)) goto L8;
        return;
    L8:
        if (this.f118021h == true) goto L13;
        this.f118025l = SystemClock.elapsedRealtime();
        this.f118014a.removeCallbacksAndMessages(null);
        this.f118020g = true;
        return;
    }

    public g(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f118028o = r100;
        this.f118014a = new Handler(Looper.getMainLooper());
        this.f118022i = true;
        this.f118024k = -1;
        this.f118025l = -1;
        this.f118027n = new a(this);
    }

    public final void c(boolean r100) {
        if (this.f118018e == false) goto L5;
        return;
    L5:
        this.f118026m = false;
        if (this.f118025l != (-1)) goto L8;
        return;
    L8:
        if (this.f118021h == true) goto L32;
        if (r100 == false) goto L24;
        ReplayDataContext.a r101 = ReplayDataContext.Companion;
        DataCenter r102 = this.f118028o;
        r101.getClass();
        ReplayDataContext r103 = ReplayDataContext.a.b(r102);
        if (r103 == null) goto L18;
        m<Long> r104 = r103.getTotalStopTime();
        if (r104 == null) goto L18;
        Long r105 = r104.getValue();
        if (r105 == null) goto L18;
        long r106 = r105.longValue();
    L19:
        this.f118023j = (r106 + SystemClock.elapsedRealtime()) - this.f118025l;
        ReplayDataContext r107 = ReplayDataContext.a.b(this.f118028o);
        if (r107 == null) goto L29;
        m<Long> r108 = r107.getTotalStopTime();
        if (r108 == null) goto L29;
        r108.setValue(Long.valueOf(this.f118023j));
    L29:
        this.f118025l = -1;
        this.f118014a.post(this.f118027n);
        return;
    L18:
        r106 = this.f118023j;
        goto L19
    L24:
        this.f118023j = 0;
        ReplayDataContext.a r109 = ReplayDataContext.Companion;
        DataCenter r110 = this.f118028o;
        r109.getClass();
        ReplayDataContext r111 = ReplayDataContext.a.b(r110);
        if (r111 == null) goto L29;
        m<Long> r112 = r111.getTotalStopTime();
        if (r112 == null) goto L29;
        r112.setValue(Long.valueOf(this.f118023j));
        goto L29
    }

    public final void a(boolean r100, boolean r101) {
        if (this.f118015b == true) goto L5;
    L7:
        if (r100 == false) goto L9;
        this.f118015b = r100;
    L9:
        if (r101 == false) goto L12;
        this.f118016c = r101;
    L12:
        if (this.f118015b == true) goto L14;
        return;
    L14:
        if (this.f118016c == true) goto L16;
        return;
    L16:
        if (this.f118017d == true) goto L55;
        this.f118017d = true;
        ReplayDataContext.a r102 = ReplayDataContext.Companion;
        DataCenter r103 = this.f118028o;
        r102.getClass();
        ReplayDataContext r104 = ReplayDataContext.a.b(r103);
        Pair[] r105 = new Pair[1];
        if (r104 == null) goto L25;
        m<Integer> r106 = r104.getSeekType();
        if (r106 == null) goto L25;
        Integer r107 = r106.getValue();
        if (r107 == null) goto L25;
        String r108 = String.valueOf(r107.intValue());
    L26:
        r105[0] = TuplesKt.to("seek_type", String.valueOf(r108));
        Map<String, String> r109 = MapsKt.mutableMapOf(r105);
        fq1.a r110 = fq1.b.a();
        if (r110 == null) goto L51;
        Episode r111 = r110.f478400a;
        if (r111 == null) goto L51;
        IMainEpisode r112 = (IMainEpisode) r111.castToOrNull(IMainEpisode.class);
        if (r112 == null) goto L51;
        PrivilegeInfo r113 = r112.subscribeReplayInfo();
        if (r113 == null) goto L51;
        PrivilegeBaseInfo r114 = r113.paidLiveInfo;
        if (r114 != null) goto L37;
    L39:
        String r115 = "inactive";
    L40:
        r109.put("member_status", r115);
        fq1.a r116 = fq1.b.a();
        if (r116 == null) goto L49;
        Episode r117 = r116.f478400a;
        if (r117 == null) goto L49;
        String r118 = EpisodeExtKt.getOwnerIdString(r117);
        if (r118 == null) goto L49;
        if (r118.equals(t.a().getCurrentUserId()) != true) goto L49;
        String r119 = "1";
    L50:
        r109.put(IPerformanceManager.Params.is_anchor, r119);
    L49:
        r119 = "0";
        goto L50
    L37:
        if (r114.hasViewRight() != true) goto L39;
        r115 = "active";
    L51:
        d.a(this.f118028o).d("play", r109, new Object[0]);
        return;
    L25:
        r108 = null;
        goto L26
    L55:
        return;
    L5:
        if (this.f118016c == false) goto L7;
    }
}
