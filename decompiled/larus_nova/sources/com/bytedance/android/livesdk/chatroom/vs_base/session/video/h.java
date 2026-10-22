package com.bytedance.android.livesdk.chatroom.vs_base.session.video;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.model.ReplayRoomState;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mq1.d0;

/* JADX INFO: loaded from: classes8.dex */
public final class h {
    public Bundle A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<? extends Fragment> f118127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReplayRoomState f118128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.vs_base.session.video.a f118129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReplayEventHub f118130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReplayVideoMetrics f118131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Episode f118132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f118133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f118134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f118135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f118136j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f118137k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f118138l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f118139m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f118140n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f118141o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f118142p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f118143q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f118144r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public vq1.b f118145s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public vq1.b f118146t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public pq1.a f118147u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f118148v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f118149w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f118150x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final DataCenter f118151y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final LifecycleOwner f118152z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f118153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f118154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f118155c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public DataCenter f118156d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public LifecycleOwner f118157e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bundle f118158f;

        public a() {
            this.f118153a = ((IMiddleWareHostContext) k.n(IMiddleWareHostContext.class)).context();
            this.f118155c = "0";
            this.f118158f = new Bundle();
        }
    }

    public final Context getContext() {
        return this.f118148v;
    }

    public final void a(ReplayRoomState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f118128b = r100;
    }

    public final void b(Episode r100) {
        d0 r101 = ReplayRoomFragmentScopeUtil.b();
        if (r101 == null) goto L11;
        if (r100 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        r101.d(r102);
        goto L11
    L6:
        if (r100.style != 2) goto L9;
        r102 = false;
    L11:
        Episode r103 = this.f118132f;
        if (r103 == null) goto L14;
        String r104 = r103.getPlayVideoModel();
    L15:
        this.f118143q = r104;
        this.f118132f = r100;
        return;
    L14:
        r104 = null;
        goto L15
    }

    public final boolean c(Bundle r100) {
        if (this.f118149w <= 0) goto L5;
        return false;
    L5:
        if (q0.a(this.f118150x) == true) goto L23;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.containsKey(VSConstants.EXTRA_ITEM_ID) == false) goto L11;
        this.f118149w = r100.getLong(VSConstants.EXTRA_ITEM_ID, 0);
    L11:
        if (r100.containsKey(VSConstants.EXTRA_USER_ID) == false) goto L14;
        this.f118150x = o0.a.d(o0.f58946a, r100, VSConstants.EXTRA_USER_ID);
    L14:
        if (r100.containsKey(VSConstants.EXTRA_ENTER_FROM_USER_ID) == false) goto L17;
        com.bytedance.android.livesdk.chatroom.vs_base.session.video.a r101 = this.f118129c;
        r100.getLong(VSConstants.EXTRA_ENTER_FROM_USER_ID, 0);
        r101.getClass();
    L17:
        if (r100.containsKey("live.SCREEN_ORIENTATION") == false) goto L19;
        this.f118136j = r100.getInt("live.SCREEN_ORIENTATION");
    L19:
        this.A = r100;
        return true;
    L23:
        return false;
    }

    public h(Context r100, long r101, String r102, DataCenter r103, LifecycleOwner r104, Bundle r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        Intrinsics.checkNotNullParameter(r105, "extra");
        this.f118148v = r100;
        this.f118149w = r101;
        this.f118150x = r102;
        this.f118151y = r103;
        this.f118152z = r104;
        this.A = r105;
        if (r101 == 0) goto L5;
    L8:
        ReplayRoomState r106 = ReplayRoomState.INITIALIZED;
    L9:
        this.f118128b = r106;
        this.f118129c = new com.bytedance.android.livesdk.chatroom.vs_base.session.video.a(this.A);
        ReplayEventHub r107 = new ReplayEventHub();
        this.f118130d = r107;
        this.f118131e = new ReplayVideoMetrics(this, r107);
        List<String> r108 = this.A.getStringArrayList(VSConstants.EXTRA_BG_URLS);
        if (r108 != null) goto L13;
        r108 = CollectionsKt.emptyList();
    L13:
        this.f118134h = r108;
        List<String> r109 = this.A.getStringArrayList(VSConstants.EXTRA_VS_EPISODE_COVER_URL);
        if (r109 != null) goto L17;
        r109 = CollectionsKt.emptyList();
    L17:
        this.f118135i = r109;
        this.f118136j = this.A.getInt(VSConstants.EXTRA_VS_ORIENTATION, 1);
        this.f118137k = this.A.getBoolean(VSConstants.EXTRA_VS_SHARE_VIEW);
        mq1.c r110 = q.a();
        if (r110 == null) goto L20;
        String r111 = r110.getCachedVideoId(this.f118149w);
    L21:
        this.f118142p = r111;
        this.f118143q = this.A.getString(VSConstants.EXTRA_VIDEO_MODEL);
        this.f118144r = this.A.getString(VSConstants.EXTRA_VS_VIDEO_ID);
        if (this.f118129c.f118109m == true) goto L24;
        return;
    L24:
        if (q0.a(this.f118150x) == false) goto L28;
        this.f118149w = 0;
        return;
    L28:
        return;
    L20:
        r111 = null;
        goto L21
    L5:
        if (q0.a(r102) == true) goto L8;
        r106 = ReplayRoomState.IDLE;
        goto L9
    }
}
