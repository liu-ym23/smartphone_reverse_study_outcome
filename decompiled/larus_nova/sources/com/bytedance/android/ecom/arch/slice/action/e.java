package com.bytedance.android.ecom.arch.slice.action;

import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class e<ActionParams> implements l<SlcCommonAction> {
    public e() {
    }

    public abstract d<ActionParams> checkParam(SlcCommonAction r100, Map<String, ? extends Object> r101, c r102);

    public abstract void onHandle(ActionContext r100, SlcCommonAction r101, ActionParams r102, c r103);

    public final Map<String, String> generateActionParams(SlcCommonAction r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        HashMap r102 = new HashMap();
        String r103 = null;
        if (r101 == null) goto L7;
        Map<String, Object> r104 = r101.f49992b;
        if (r104 == null) goto L7;
        Object r105 = r104.get(SlcCommonAction.KEY_ACTION_CHAIN_PATH);
    L9:
        if ((r105 instanceof String) == true) goto L11;
        r105 = null;
    L11:
        r102.put("path", (String) r105);
        if (r101 == null) goto L16;
        Map<String, Object> r106 = r101.f49992b;
        if (r106 == null) goto L16;
        r103 = mq.b.d(r106, SlcCommonAction.KEY_ACTION_MONITOR_ID, null);
    L16:
        r102.put(SlcCommonAction.KEY_ACTION_MONITOR_ID, r103);
        r102.put("action_type", r100.getType());
        return r102;
    L7:
        r105 = null;
        goto L9
    }

    private final void reportError(ActionContext r100, String r101, SlcCommonAction r102) {
        if (nq.a.g() == false) goto L6;
        if (r101 == null) goto L11;
        r100.f49972g.e(r100.getActivity(), new iq.b(r101, true));
        return;
    L11:
        return;
    L6:
        HashMap r103 = new HashMap();
        if (r101 == null) goto L9;
        r103.put("ec_action_type", r102.getType());
        r103.put("ec_action_error_msg", r101);
    L9:
        r100.f49972g.a(new jq.a("ec_action_error", r103, 222), null, null);
    }

    public final void handle(ActionContext r110, SlcCommonAction r111, c r112, i r210) {
        Intrinsics.checkNotNullParameter(r110, "actionContext");
        Intrinsics.checkNotNullParameter(r111, "action");
        Map<String, String> r100 = generateActionParams(r111, r210);
        boolean r101 = false;
        r110.f49972g.d(r111, r112, r100, 0);
        if (Intrinsics.areEqual(r111.getType(), "None") == false) goto L5;
        return;
    L5:
        d<ActionParams> r113 = checkParam(r111, r111.getParams(), r112);
        String r102 = r113.f49985b;
        if (r102 != null) goto L8;
    L9:
        r101 = true;
    L10:
        if (r101 == true) goto L13;
        reportActionError$default(this, r113.f49985b, r110, r111, r112, r210, null, null, 96, null);
    L13:
        if (r113.f49984a == true) goto L16;
        reportError(r110, r113.f49985b, r111);
        return;
    L16:
        onHandle(r110, r111, r113.f49986c, r112, r210);
        return;
    L8:
        if (r102.length() != 0) goto L10;
        goto L9
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.l
    public /* bridge */ /* synthetic */ void handle(ActionContext r100, IAction r101, c r102, i r103) {
        handle(r100, (SlcCommonAction) r101, r102, r103);
    }

    public void onHandle(ActionContext r100, SlcCommonAction r101, ActionParams r102, c r103, i r104) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, "action");
        onHandle(r100, r101, r102, r103);
    }

    public final void reportActionError(String r100, ActionContext r101, SlcCommonAction r102, c r103, i r104, String r105, Map<String, String> r106) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        Intrinsics.checkNotNullParameter(r101, "actionContext");
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r105, "errorCode");
        Map<String, String> r107 = generateActionParams(r102, r104);
        r107.put("message", r100);
        r107.put("code", r105);
        if (r106 == null) goto L5;
        r107.putAll(r106);
    L5:
        r101.f49972g.d(r102, r103, r107, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportActionError$default(e r110, String r111, ActionContext r112, SlcCommonAction r113, c r114, i r115, String r116, Map r117, int r118, Object r119) {
        if (r119 != null) goto L22;
        if ((r118 & 8) == 0) goto L6;
        c r100 = null;
    L8:
        if ((r118 & 16) == 0) goto L10;
        i r101 = null;
    L12:
        if ((r118 & 32) == 0) goto L14;
        String r102 = AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
    L16:
        if ((r118 & 64) == 0) goto L18;
        Map r103 = null;
    L19:
        r110.reportActionError(r111, r112, r113, r100, r101, r102, r103);
        return;
    L18:
        r103 = r117;
        goto L19
    L14:
        r102 = r116;
        goto L16
    L10:
        r101 = r115;
        goto L12
    L6:
        r100 = r114;
        goto L8
    L22:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportActionError");
    }
}
