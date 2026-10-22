package com.bytedance.android.livesdk.livecommerce.message;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.room.api.d;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.j;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.utils.ECCartMonitor;
import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import hh2.f;
import hh2.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sg2.e0;
import sg2.f0;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends c0 implements td.a, IExternalMessageListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f149388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e0> f149389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f149390e;

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        d r100 = this.f149388c;
        if (r100 == null) goto L6;
        r100.b(this);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        monitor-enter(this);
        ((ArrayList) this.f149389d).clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void H(ee.b r110) {
        String r100 = String.valueOf(r110.getMsgType());
        String r101 = String.valueOf(r110.getMessageId2());
        xh.b.d r102 = new xh.b.d();
        r102.c(r101);
        if (ECAppInfoService.f48114e.isLocalTest() == false) goto L5;
        ee.b r103 = r110;
    L6:
        r102.a(r103);
        int r104 = 4;
        if (CollectionsKt.listOf(new Integer[]{10, 11, 13, 14}).contains(Integer.valueOf(r110.getMsgType())) == true) goto L10;
        r104 = 2;
    L10:
        xh.c.a("Live").h(null, r100, r102, r104);
        int r105 = ri2.a.f537877a;
        List<String> r106 = r110.getTargetUid();
        List<String> r107 = r110.getSecTargetUid();
        List<String> r108 = r106;
        if (r108 != null) goto L13;
    L16:
        boolean r109 = true;
    L17:
        if (r109 == false) goto L27;
        List<String> r111 = r107;
        if (r111 != null) goto L21;
    L24:
        boolean r112 = true;
    L25:
        if (r112 == false) goto L27;
    L52:
        boolean r113 = true;
    L54:
        if (r113 == true) goto L56;
        return;
    L56:
        boolean r114 = ECCartMonitor.f153028a;
        ECCartMonitor.g(r110.getMsgType(), r110.getMessageId2());
        Intrinsics.checkNotNullParameter(r110, "message");
        monitor-enter(this);     // Catch: Exception -> L79
    L76:
        th = move-exception;
        throw th;     // Catch: Exception -> L79
    L59:
        if (((ArrayList) this.f149389d).isEmpty() == false) goto L61;
        List<e0> r115 = this.f149389d;     // Catch: Throwable -> L76
        int r116 = c.f149391a;     // Catch: Throwable -> L76
        ((ArrayList) r115).addAll(c.a(false, A()));     // Catch: Throwable -> L76
    L61:
        ArrayList r117 = (ArrayList) this.f149389d;     // Catch: Throwable -> L76
        Iterator r118 = r117.iterator();     // Catch: Throwable -> L76
    L63:
        if (r118.hasNext() == false) goto L71;
        e0 r119 = (e0) r118.next();     // Catch: Throwable -> L76
        if ((r119 instanceof qi2.a) == true) goto L67;
        r119 = null;
    L67:
        qi2.a r120 = (qi2.a) r119;     // Catch: Throwable -> L76
        if (r120 == null) goto L63;
        r120.c(this.f149390e);     // Catch: Throwable -> L76
        goto L63
    L71:
        if (r117.size() <= 0) goto L74;
        ((e0) ListProtector.get(r117, 0)).a(new f0(r117, 1, r110));     // Catch: Throwable -> L76
    L74:
        monitor-exit(this);     // Catch: Exception -> L79
        return;
    L79:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L21:
        if (r111.isEmpty() == true) goto L24;
        r112 = false;
    L27:
        r r121 = r.f48132a;
        String r122 = r121.getCurrentUserId();
        g r123 = f.f485165a.f485167a;
        if (r123 == null) goto L32;
        Boolean r124 = r123.p();
        if (r124 == null) goto L32;
        boolean r125 = r124.booleanValue();
    L33:
        if (r125 == false) goto L42;
        int r126 = ECContextContainer.f151896b;
        ECContext r127 = ECContextContainer.a.b();
        if (r106 == null) goto L52;
        if (r106.contains(r122) == true) goto L52;
        if (r127 != null) goto L40;
    L53:
        r113 = false;
        goto L54
    L40:
        if (r106.contains(r127.getAnchorId().getValue()) == false) goto L53;
    L42:
        String r128 = r121.f();
        if (TextUtils.isEmpty(r128) == true) goto L48;
        if (r107 == null) goto L48;
        if (r107.contains(r128) == true) goto L52;
    L48:
        if (TextUtils.isEmpty(r122) == true) goto L53;
        if (r106 == null) goto L53;
        if (r106.contains(r122) == false) goto L53;
    L32:
        r125 = false;
        goto L33
    L13:
        if (r108.isEmpty() == true) goto L16;
        r109 = false;
        goto L17
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void g(d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        this.f149388c = r100;
        r100.a(1002, this);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof ce.a) == false) goto L6;
        H(new ee.b((ce.a) r100));
        return;
    }

    public b(RealRoomController$roomResources$1 r100, RealRoomController.d r101) {
        Intrinsics.checkNotNullParameter(r100, "roomResources");
        Intrinsics.checkNotNullParameter(r101, "roomStateProvider");
        super(r100);
        this.f149390e = r101;
        this.f149389d = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101) {
        super.c(r100, r101);
        monitor-enter(this);
        ((ArrayList) this.f149389d).clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // td.a
    public final void f(ee.a r100, boolean r101) {
        if ((r100 instanceof ee.b) == false) goto L6;
        H((ee.b) r100);
        return;
    }
}
