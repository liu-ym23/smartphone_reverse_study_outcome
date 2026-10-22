package com.bytedance.android.livesdk.room;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ls2.c;
import os2.a;
import ts2.b;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a<T extends ls2.c, R extends ts2.b, C extends os2.a<?>> {
    private int index;
    private boolean isInit;
    private os2.c<C> lifeCycleManager;
    private T mContext;
    private R mCurrentState;
    private final qs2.a<T> mLiveEnterRoomMonitor;
    private fs2.a mLiveTaskManager;
    private ks2.c roomConfig;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.room.a$a, reason: collision with other inner class name */
    public static final class C2412a extends qs2.a<T> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ a f157607j;

        @Override // qs2.a
        public final boolean c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "nodeName");
            return this.f157607j.isNeedRecordNode(r100);
        }

        @Override // qs2.a
        public final boolean a(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "nodeName");
            Intrinsics.checkNotNullParameter(r101, "extra");
            return this.f157607j.isCanReportLog(r100, r101);
        }

        public C2412a(a r100, ls2.c r101, LiveScope r102, ks2.c r103) {
            this.f157607j = r100;
            super(r101, r102, r103);
        }
    }

    public static final class b implements gs2.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f157608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f157609b;

        @Override // gs2.c
        public final void b() {
        }

        @Override // gs2.c
        public final void a() {
            this.f157608a.getMLiveEnterRoomMonitor().g(this.f157609b);
        }

        public b(a r100, String r101) {
            this.f157608a = r100;
            this.f157609b = r101;
        }
    }

    public abstract LiveScope getCurrentScope();

    public abstract List<com.bytedance.android.livesdk.room.Task.base.a<T, ? extends ls2.c>> handlerState(R r100, String r101, List<? extends C> r102);

    public abstract void initState();

    public boolean isCanReportLog(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        return false;
    }

    public boolean isNeedRecordNode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        return false;
    }

    public final T getContext() {
        return this.mContext;
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getMContext() {
        return this.mContext;
    }

    public final R getMCurrentState() {
        return this.mCurrentState;
    }

    public final qs2.a<T> getMLiveEnterRoomMonitor() {
        return this.mLiveEnterRoomMonitor;
    }

    public final ks2.c getRoomConfig() {
        return this.roomConfig;
    }

    public final boolean isInit() {
        return this.isInit;
    }

    public final void addBusinessUnit(List<? extends C> r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeList");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L17;
        os2.a r102 = (os2.a) r101.next();
        os2.c<C> r103 = this.lifeCycleManager;
        if (r103 == null) goto L9;
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        ((ArrayList) r103.f526495a).add(r102);
    L9:
        if (r102.e() == false) goto L4;
        T r104 = r102.f526494a;
        if (r104 == null) goto L4;
        T r105 = this.mContext;
        String r106 = r102.b();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "businessTagId");
        Intrinsics.checkNotNullParameter(r104, "data");
        if (r105.f510512a.containsKey(r106) == true) goto L16;
        r105.f510512a.put(r106, r104);
        goto L4
    L16:
        throw new RuntimeException(r106 + " 已经注册过");
    }

    public String getNodeName(R r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return r100.toString();
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setInit(boolean r100) {
        this.isInit = r100;
    }

    public final void setMContext(T r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mContext = r100;
    }

    public final void setMCurrentState(R r100) {
        this.mCurrentState = r100;
    }

    public final void setRoomConfig(ks2.c r100) {
        this.roomConfig = r100;
    }

    public void transition(R r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        os2.c<C> r101 = this.lifeCycleManager;     // Catch: Throwable -> L13
        if (r101 == null) goto L6;
        Intrinsics.checkNotNullParameter(getCurrentScope(), "scope");     // Catch: Throwable -> L13
        List<C> r102 = r101.f526495a;     // Catch: Throwable -> L13
    L7:
        String r103 = getNodeName(r100);     // Catch: Throwable -> L13
        this.mLiveEnterRoomMonitor.e(r103);     // Catch: Throwable -> L13
        List<com.bytedance.android.livesdk.room.Task.base.a<T, ? extends ls2.c>> r104 = handlerState(r100, r103, r102);     // Catch: Throwable -> L13
        if (r104.isEmpty() == false) goto L11;
        this.mLiveEnterRoomMonitor.g(r103);     // Catch: Throwable -> L13
        return;
    L11:
        fs2.a r105 = this.mLiveTaskManager;     // Catch: Throwable -> L13
        b r106 = new b(this, r103);     // Catch: Throwable -> L13
        r105.getClass();     // Catch: Throwable -> L13
        fs2.a.a(r103, r104, r106);     // Catch: Throwable -> L13
        return;
    L6:
        r102 = null;
    L13:
        th = move-exception;
        ps2.c.b(th);
        reportError(th, "1");
    }

    public a(T r100, ks2.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.mContext = r100;
        this.lifeCycleManager = new os2.c();
        this.mLiveTaskManager = new fs2.a();
        this.roomConfig = r101;
        this.mLiveEnterRoomMonitor = new C2412a(this, this.mContext, getCurrentScope(), r101);
    }

    public final void reportError(Throwable r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "e");
        LiveScope r102 = getCurrentScope();
        String r103 = null;
        if (r102 != LiveScope.ROOM) goto L27;
        T r104 = this.mContext;
        if ((r104 instanceof ls2.b) == true) goto L7;
        r104 = null;
    L7:
        ls2.b r105 = (ls2.b) r104;
        if (r105 == null) goto L12;
        Long r106 = r105.f510496c;
        if (r106 == null) goto L12;
        String r107 = String.valueOf(r106.longValue());
    L13:
        T r108 = this.mContext;
        boolean r109 = r108 instanceof ls2.b;
        if (r109 == true) goto L16;
        T r110 = null;
    L17:
        ls2.b r111 = (ls2.b) r110;
        if (r111 == null) goto L20;
        String r112 = r111.f510499f;
    L21:
        if (r109 == true) goto L23;
        r108 = null;
    L23:
        ls2.b r113 = (ls2.b) r108;
        if (r113 == null) goto L26;
        r103 = r113.f510500g;
    L26:
        String r114 = r107;
        String r115 = r103;
    L48:
        ps2.d.b(r100, r101, r102, r114, r112, r115);
        return;
    L20:
        r112 = null;
        goto L21
    L16:
        r110 = r108;
    L12:
        r107 = null;
        goto L13
    L27:
        T r116 = this.mContext;
        boolean r117 = r116 instanceof ls2.d;
        if (r117 == true) goto L30;
        T r118 = null;
    L31:
        ls2.d r119 = (ls2.d) r118;
        if (r119 == null) goto L34;
        String r120 = r119.f510516e;
    L35:
        if (r117 == true) goto L37;
        T r121 = null;
    L38:
        ls2.d r122 = (ls2.d) r121;
        if (r122 == null) goto L41;
        String r123 = r122.f510517f;
    L42:
        if (r117 == true) goto L44;
        r116 = null;
    L44:
        ls2.d r124 = (ls2.d) r116;
        if (r124 == null) goto L47;
        r103 = String.valueOf(r124.f510515d);
    L47:
        r115 = r123;
        r112 = r120;
        r114 = r103;
        goto L48
    L41:
        r123 = null;
        goto L42
    L37:
        r121 = r116;
        goto L38
    L34:
        r120 = null;
        goto L35
    L30:
        r118 = r116;
        goto L31
    }
}
