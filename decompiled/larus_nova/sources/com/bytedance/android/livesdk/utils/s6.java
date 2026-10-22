package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;
import com.bytedance.android.livesdkapi.ws.LiveWsMessage;
import com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class s6 implements OnLiveWsMessageReceiveListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s6 f159161a = null;

    public s6() {
    }

    @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
    public final void onReceiveConnectEvent(LiveWsConnectState r100, JSONObject r101) {
    }

    static {
        f159161a = new s6();
    }

    public static void a(List r110) {
        Intrinsics.checkNotNullParameter(r110, "keys");
        ALogger.i("TraceFuseMessageReceiver", "addFilterRules: key=" + r110);
        long r100 = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis((long) LiveInfraSettingKeys.LIVE_TRACE_MONITOR_CONFIG.getValue().d());
        ArrayList r101 = new ArrayList();
        Iterator r111 = r110.iterator();
    L3:
        boolean r102 = true;
        if (r111.hasNext() == false) goto L14;
        String r103 = (String) r111.next();
        if (r103.length() > 0) goto L9;
        r102 = false;
    L9:
        if (r102 == false) goto L11;
        a60.c r104 = new a60.c(r103, 0);
        r104.f1933a = r100;
    L12:
        if (r104 == null) goto L3;
        r101.add(r104);
        goto L3
    L11:
        r104 = null;
        goto L12
    L14:
        boolean r112 = TraceMonitor.f64964a;
        Intrinsics.checkNotNullParameter(r101, "rules");
        c60.a r105 = TraceMonitor.f64966c;
        if (r105 == null) goto L33;
        Intrinsics.checkNotNullParameter(r101, "rules");
        Iterator r113 = r101.iterator();
    L18:
        if (r113.hasNext() == false) goto L48;
        a60.c r106 = (a60.c) r113.next();
        String r107 = r106.a();
        if (r107 != null) goto L22;
    L25:
        boolean r108 = true;
    L27:
        if (r108 == true) goto L28;
        if ((r106.f1933a - System.currentTimeMillis()) > 0) goto L31;
        ALogger.w("FuseEventFilter", "failed to add an expired rule " + r106);
        goto L18
    L31:
        ((ConcurrentHashMap) r105.f22527a).put(r107, r106);
        ALogger.i("FuseEventFilter", "add rule " + r106);
        goto L18
    L28:
        ALogger.w("FuseEventFilter", "failed to add rule " + r106 + " with empty key");
        goto L18
    L22:
        if (r107.length() == 0) goto L25;
        r108 = false;
        goto L27
    L48:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.ws.OnLiveWsMessageReceiveListener
    public final void onReceiveMsg(LiveWsMessage r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if ((!Intrinsics.areEqual(r110.getPayloadType(), "im_uplink_rate_limit")) == false) goto L7;
        return;
    L7:
        if (r110.getMsgHeaders() != null) goto L9;
        ALogger.i("TraceFuseMessageReceiver", "msgHeaders is null");
    L22:
        String r100 = null;
    L24:
        if (r100 != null) goto L26;
        return;
    L26:
        List r111 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator r112 = r111.iterator();
    L28:
        if (r112.hasNext() == false) goto L34;
        String r102 = (String) r112.next();
        if (r102 == null) goto L33;
        r101.add(StringsKt.trim(r102).toString());
        goto L28
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L34:
        a(r101);
        return;
    L9:
        Iterator<T> r113 = r110.getMsgHeaders().iterator();
    L11:
        if (r113.hasNext() == false) goto L15;
        Object r103 = r113.next();
        if (Intrinsics.areEqual(((LiveWsMessage.MsgHeader) r103).getKey(), "IM-Uplink-Rate-Limit-Keys") == false) goto L11;
    L16:
        LiveWsMessage.MsgHeader r104 = (LiveWsMessage.MsgHeader) r103;
        if (r104 != null) goto L19;
        ALogger.i("TraceFuseMessageReceiver", "no key in msgHeaders is IM-Uplink-Rate-Limit-Keys");
        goto L22
    L19:
        String r114 = r104.getValue();
        if (r114 != null) goto L23;
        ALogger.i("TraceFuseMessageReceiver", "fuse config is null");
        goto L22
    L23:
        r100 = r114;
        goto L24
    L15:
        r103 = null;
        goto L16
    }
}
