package com.bytedance.android.shopping.anchorv4.event_chain;

import android.content.Context;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.bytedance.kmp.ec.yata.common.utils.YataConcurrentHashMap;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes12.dex */
public abstract class AbsCommonChainEventImpl<EventFields> extends t96.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f166536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f166537d;

    public static final class a {
    }

    static {
    }

    public abstract b<EventFields> c(Map<String, ? extends Object> r100);

    public abstract void e(EventContext r100, EventFields r101, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r102);

    public final Map<String, String> d(EventContext r100) {
        Object r101 = r100.d().get("chain_path_info");
        String r102 = null;
        if (TypeIntrinsics.isMutableMap(r101) == true) goto L5;
        r101 = null;
    L5:
        Map r103 = (Map) r101;
        HashMap r104 = new HashMap();
        if (r103 == null) goto L8;
        String r105 = mq.b.d(r103, SlcCommonAction.KEY_ACTION_CHAIN_PATH, null);
    L9:
        r104.put("path", r105);
        if (r103 == null) goto L12;
        r102 = mq.b.d(r103, SlcCommonAction.KEY_ACTION_MONITOR_ID, null);
    L12:
        r104.put(SlcCommonAction.KEY_ACTION_MONITOR_ID, r102);
        r104.put("chain_name", r100.f251274g);
        r104.put("action_type", this.f545098a);
        return r104;
    L8:
        r105 = null;
        goto L9
    }

    @Override // t96.a
    public final void b(EventContext r110, final Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "eventContext");
        Intrinsics.checkNotNullParameter(r111, "completion");
        boolean r100 = false;
        this.f166536c.c(r110, d(r110), 0);
        String r101 = r110.f251275h;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        int r112 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r111.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "event_name_is_empty", null, null, 57));
        return;
    L12:
        b<EventFields> r103 = c(r110.f251278k);
        String r104 = r103.f166548b;
        if (r104 != null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        String r106 = null;
        if (r105 == true) goto L23;
        g(this, r103.f166548b, r110, null, 12);
    L23:
        if (r103.f166547a == true) goto L34;
        String r113 = r103.f166548b;
        if (nq.a.g() == false) goto L28;
        if (r113 == null) goto L32;
        this.f166536c.e(this.f166537d, new iq.b(r113, true));
    L32:
        int r114 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r111.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, r103.f166548b, null, null, 57));
        return;
    L28:
        HashMap r107 = new HashMap();
        if (r113 == null) goto L31;
        r107.put("ec_action_type", this.f545098a);
        r107.put("ec_action_error_msg", r113);
    L31:
        this.f166536c.a(new jq.a("ec_action_error", r107, 222), null, null);
        goto L32
    L34:
        Intrinsics.checkNotNullParameter(r110, "$this$getMonitorId");
        YataConcurrentHashMap<Object, Object> r108 = r110.d();
        if (r108 == null) goto L37;
        Object r109 = r108.get("monitor_id");
    L39:
        if ((r109 instanceof String) == true) goto L41;
        r109 = null;
    L41:
        String r115 = (String) r109;
        String r116 = this.f545098a;
        Object r117 = r110.d().get("chain_path_info");
        if (TypeIntrinsics.isMutableMap(r117) == true) goto L44;
        r117 = null;
    L44:
        Map r118 = (Map) r117;
        if (r118 != null) goto L47;
        r118 = new LinkedHashMap();
    L47:
        String r119 = mq.b.d(r118, SlcCommonAction.KEY_ACTION_CHAIN_PATH, null);
        if (r119 != null) goto L50;
    L53:
        boolean r120 = true;
    L54:
        if (r120 == false) goto L56;
        r118.put(SlcCommonAction.KEY_ACTION_CHAIN_PATH, r116);
    L57:
        if (r115 != null) goto L59;
    L60:
        r100 = true;
    L62:
        if ((true ^ r100) == false) goto L64;
        r106 = r115;
    L64:
        if (r106 != null) goto L66;
    L68:
        e(r110, r103.f166549c, new AbsCommonChainEventImpl$handle$2(r111));
        return;
    L66:
        if (r118.containsKey(SlcCommonAction.KEY_ACTION_MONITOR_ID) == true) goto L68;
        r118.put(SlcCommonAction.KEY_ACTION_MONITOR_ID, r115);
        goto L68
    L59:
        if (r115.length() != 0) goto L62;
    L56:
        r118.put(SlcCommonAction.KEY_ACTION_CHAIN_PATH, r119 + "." + r116);
        goto L57
    L50:
        if (r119.length() == 0) goto L53;
        r120 = false;
        goto L54
    L37:
        r109 = null;
        goto L39
    L15:
        if (r104.length() == 0) goto L18;
        r105 = false;
        goto L19
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public AbsCommonChainEventImpl(String r100, v r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f166536c = r101;
        this.f166537d = r102;
    }

    public final void f(String r100, EventContext r101, String r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Intrinsics.checkNotNullParameter(r101, "eventContext");
        Intrinsics.checkNotNullParameter(r102, "errorCode");
        Map<String, String> r104 = d(r101);
        HashMap r105 = (HashMap) r104;
        r105.put("message", r100);
        r105.put("code", r102);
        if (r103 == null) goto L5;
        r105.putAll(r103);
    L5:
        this.f166536c.c(r101, r104, 1);
    }

    public static /* synthetic */ void g(AbsCommonChainEventImpl r100, String r101, EventContext r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r103 = AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
    L5:
        r100.f(r101, r102, r103, null);
    }
}
