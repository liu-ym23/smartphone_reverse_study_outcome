package com.bytedance.android.livesdk.room;

import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.LiveSessionState;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00012\u00020\u0005B\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J$\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J@\u0010\u0017\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u00132\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u0013H\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/room/LiveSessionStateManager;", "Lcom/bytedance/android/livesdk/room/a;", "Lls2/d;", "Lcom/bytedance/android/livesdk/room/state/LiveSessionState;", "Los2/d;", "Ljava/io/Serializable;", "", "initState", "", "nodeName", "", "isNeedRecordNode", "", "extra", "isCanReportLog", "state", "getNodeName", "Lcom/bytedance/android/livesdk/room/LiveScope;", "getCurrentScope", "", "list", "Lcom/bytedance/android/livesdk/room/Task/base/a;", "Lls2/c;", "handlerState", PerfLog.PARAM_KEY_CONTEXT_ID, "Lks2/b;", "config", "<init>", "(Lls2/d;Lks2/b;)V", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSessionStateManager extends a<ls2.d, LiveSessionState, os2.d<?>> implements Serializable {
    @Override // com.bytedance.android.livesdk.room.a
    public void initState() {
        setInit(true);
    }

    @Override // com.bytedance.android.livesdk.room.a
    public LiveScope getCurrentScope() {
        return LiveScope.SESSION;
    }

    public String getNodeName(LiveSessionState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100.getContainerLifecycle() == null) goto L10;
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getDes());
        r101.append('_');
        ContainerLifecycle r102 = r100.getContainerLifecycle();
        if (r102 == null) goto L7;
        String r103 = r102.name();
    L8:
        r101.append(r103);
        return r101.toString();
    L7:
        r103 = null;
        goto L8
    L10:
        return String.valueOf(r100.getDes());
    }

    @Override // com.bytedance.android.livesdk.room.a
    public boolean isNeedRecordNode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        LiveSessionState r101 = LiveSessionState.SESSION_CONTAINER_STATE_CHANGED;
        r101.getContainerLifecycle();
        ContainerLifecycle r102 = ContainerLifecycle.ON_CREATE_VIEW;
        Unit r103 = Unit.INSTANCE;
        if (Intrinsics.areEqual(r100, getNodeName(r101)) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, getNodeName(LiveSessionState.SESSION_EXIT_CONTAINER)) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdk.room.a
    public /* bridge */ /* synthetic */ String getNodeName(ts2.b r100) {
        return getNodeName((LiveSessionState) r100);
    }

    public LiveSessionStateManager(ls2.d r100, ks2.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.room.a
    public boolean isCanReportLog(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        return Intrinsics.areEqual(r100, getNodeName(LiveSessionState.SESSION_EXIT_CONTAINER));
    }

    public static final void access$handleSessionTask(LiveSessionStateManager r100, List r101, List r102) {
        r100.getClass();
        if (r102 == null) goto L8;
        Iterator r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.room.Task.base.a r104 = (com.bytedance.android.livesdk.room.Task.base.a) r103.next();
        r101.add(r104);
        r104.f157564e = r100.getMContext();
        goto L6
    L10:
        return;
    }

    public static final /* synthetic */ void access$reportError(LiveSessionStateManager r100, Throwable r101, String r102) {
        r100.reportError(r101, r102);
    }

    public List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ? extends ls2.c>> handlerState(LiveSessionState r100, String r101, List<? extends os2.d<?>> r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "nodeName");
        ks2.c r103 = getRoomConfig();
        if (r103 == null) goto L8;
        if (r103.f505903a != true) goto L8;
        int r104 = ps2.c.f530435a;
        ps2.c.a(LiveScope.SESSION, String.valueOf(hashCode()), "[" + getMContext().f510516e + '_' + getMContext().f510517f + "]-->" + r100);
    L8:
        switch(f.f157647a[r100.ordinal()]) {
            case 1: goto L69;
            case 2: goto L57;
            case 3: goto L45;
            case 4: goto L32;
            case 5: goto L20;
            case 6: goto L10;
            default: goto L79;
        };
    L10:
        ArrayList r105 = new ArrayList();
        if (r102 == null) goto L124;
        Iterator<T> r106 = r102.iterator();
    L14:
        if (r106.hasNext() == false) goto L129;
        ((os2.d) r106.next()).i(getMContext());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        ps2.c.b(th);
        access$reportError(this, th, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        goto L14
    L129:
        return r105;
    L124:
        return r105;
    L20:
        ArrayList r107 = new ArrayList();
        if (r102 == null) goto L125;
        Iterator<T> r108 = r102.iterator();
    L24:
        if (r108.hasNext() == false) goto L125;
        List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> r109 = ((os2.d) r108.next()).f(getMContext(), r100.getContainerScrollStateChanged(), r100.getExtraContainerData());     // Catch: Throwable -> L30
        if (r109 == null) goto L24;
        access$handleSessionTask(this, r107, r109);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        ps2.c.b(th);
        access$reportError(this, th, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
    L125:
        return r107;
    L32:
        r107 = new ArrayList();
        if (r102 == null) goto L125;
        Iterator<T> r110 = r102.iterator();
    L36:
        if (r110.hasNext() == false) goto L125;
        List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> r111 = ((os2.d) r110.next()).g(getMContext(), r100.getContainerLifecycle(), r100.getExtraContainerData());     // Catch: Throwable -> L42
        if (r111 == null) goto L36;
        access$handleSessionTask(this, r107, r111);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        ps2.c.b(th);
        access$reportError(this, th, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        goto L36
    L45:
        ArrayList r112 = new ArrayList();
        if (r102 == null) goto L126;
        Iterator<T> r113 = r102.iterator();
    L49:
        if (r113.hasNext() == false) goto L130;
        List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> r114 = ((os2.d) r113.next()).h(getMContext());     // Catch: Throwable -> L55
        if (r114 == null) goto L49;
        access$handleSessionTask(this, r112, r114);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        ps2.c.b(th);
        access$reportError(this, th, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        goto L49
    L130:
        return r112;
    L126:
        return r112;
    L57:
        ArrayList r115 = new ArrayList();
        if (r102 == null) goto L127;
        Iterator<T> r116 = r102.iterator();
    L61:
        if (r116.hasNext() == false) goto L131;
        List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> r117 = ((os2.d) r116.next()).l(getMContext());     // Catch: Throwable -> L67
        if (r117 == null) goto L61;
        access$handleSessionTask(this, r115, r117);     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        ps2.c.b(th);
        access$reportError(this, th, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        goto L61
    L131:
        return r115;
    L127:
        return r115;
    L69:
        ArrayList r118 = new ArrayList();
        if (r102 == null) goto L128;
        Iterator<T> r119 = r102.iterator();
    L73:
        if (r119.hasNext() == false) goto L132;
        os2.d r120 = (os2.d) r119.next();
        ls2.d r121 = getMContext();     // Catch: Throwable -> L77
        r120.getClass();     // Catch: Throwable -> L77
        Intrinsics.checkNotNullParameter(r121, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        ps2.c.b(th);
        access$reportError(this, th, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        goto L73
    L132:
        return r118;
    L128:
        return r118;
    L79:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.room.a
    public /* bridge */ /* synthetic */ List handlerState(ts2.b r100, String r101, List r102) {
        return handlerState((LiveSessionState) r100, r101, r102);
    }
}
