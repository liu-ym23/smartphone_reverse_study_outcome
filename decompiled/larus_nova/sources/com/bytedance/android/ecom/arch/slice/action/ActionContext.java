package com.bytedance.android.ecom.arch.slice.action;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ActionContext {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f49965h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Function0<l<SlcCommonAction>>> f49966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m> f49967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<k> f49968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f49969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function3<? super c, ? super Map<String, ? extends Object>, ? super Integer, ? extends Map<String, ? extends Object>> f49970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Activity f49971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f49972g;

    public static final class a {
    }

    static {
    }

    public final Activity getActivity() {
        return this.f49971f;
    }

    public ActionContext(FragmentActivity r100, FragmentManager r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Intrinsics.checkNotNullParameter(r102, "actionService");
        this.f49971f = r100;
        this.f49972g = r102;
        this.f49966a = new HashMap();
        this.f49967b = new ArrayList();
        this.f49968c = new ArrayList();
    }

    public final void a(IAction r100, final c r101, Map<String, ? extends Object> r102) {
        Function0<l<SlcCommonAction>> r103 = this.f49966a.get(r100.getType());
        String r104 = null;
        if (r103 == null) goto L5;
        l<SlcCommonAction> r105 = r103.invoke();
    L7:
        if ((r105 instanceof l) == true) goto L9;
        r105 = null;
    L9:
        boolean r106 = r100 instanceof SlcCommonAction;
        if (r106 == true) goto L12;
        IAction r107 = null;
    L13:
        SlcCommonAction r108 = (SlcCommonAction) r107;
        if (r108 == null) goto L18;
        Map<String, Object> r109 = r108.getData();
        if (r109 == null) goto L18;
        Object r110 = r109.get(TeaEventTrack.ACTION_DRAMA_NEXT);
    L20:
        if ((r110 instanceof Map) == true) goto L22;
        r110 = null;
    L22:
        final Map r111 = (Map) r110;
        if (r106 == true) goto L25;
        IAction r112 = null;
    L26:
        SlcCommonAction r113 = (SlcCommonAction) r112;
        if (r113 == null) goto L31;
        Map<String, Object> r114 = r113.getData();
        if (r114 == null) goto L31;
        Object r115 = r114.get("monitor_id");
    L33:
        if ((r115 instanceof String) == true) goto L35;
        r115 = null;
    L35:
        final Map<String, Object> r116 = com.bytedance.android.ecom.arch.slice.action.a.a(r102, r100.getType(), ".", (String) r115);
        i r117 = new i(new ActionContext$doHandleAction$executeContext$1(this, r111, r116, r101), r116);
        if (r105 == null) goto L39;
        r105.handle(this, r100, r101, r117);
        return;
    L39:
        HashMap<String, Function0<l<SlcCommonAction>>> r118 = ActionTypes.f49974a;
        Intrinsics.checkNotNullParameter(r100, "action");
        String r119 = r100.getType();
        switch(r119.hashCode()) {
            case -1067395272: goto L55;
            case 2433880: goto L52;
            case 69076575: goto L49;
            case 80979463: goto L46;
            case 332589195: goto L43;
            default: goto L85;
        };
    L85:
        l<SlcCommonAction> r120 = null;
    L58:
        if (r120 != null) goto L65;
        Function0<l<SlcCommonAction>> r121 = ActionTypes.f49974a.get(r100.getType());
        if (r121 == null) goto L63;
        r120 = r121.invoke();
        goto L65
    L63:
        r120 = null;
    L65:
        if ((r120 instanceof l) == true) goto L67;
        r120 = null;
    L67:
        if (r120 == null) goto L69;
        r120.handle(this, r100, r101, r117);
        return;
    L69:
        p r122 = this.f49972g;
        HashMap r123 = new HashMap();
        r123.put("code", AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M);
        Map<String, Object> r124 = r117.f49992b;
        if (r124 == null) goto L72;
        Object r125 = r124.get(SlcCommonAction.KEY_ACTION_CHAIN_PATH);
    L74:
        if ((r125 instanceof String) == true) goto L76;
        r125 = null;
    L76:
        r123.put("path", (String) r125);
        Map<String, Object> r126 = r117.f49992b;
        if (r126 == null) goto L79;
        r104 = mq.b.d(r126, SlcCommonAction.KEY_ACTION_MONITOR_ID, null);
    L79:
        r123.put(SlcCommonAction.KEY_ACTION_MONITOR_ID, r104);
        r123.put("action_type", r100.getType());
        r122.d(r100, r101, r123, 1);
        return;
    L72:
        r125 = null;
        goto L74
    L43:
        if (r119.equals("openSchema") == false) goto L57;
        r120 = new hq.b();
        goto L58
    L57:
        r120 = null;
        goto L58
    L46:
        if (r119.equals("Toast") == false) goto L81;
        r120 = new iq.a();
        goto L58
    L81:
        r120 = null;
        goto L58
    L49:
        if (r119.equals("Group") == false) goto L82;
        r120 = new fq.a();
        goto L58
    L82:
        r120 = null;
        goto L58
    L52:
        if (r119.equals("None") == false) goto L83;
        r120 = new gq.a();
        goto L58
    L83:
        r120 = null;
        goto L58
    L55:
        if (r119.equals(com.bytedance.android.ec.core.event.a.KEY_TRACKER) == false) goto L84;
        r120 = new jq.b();
        goto L58
    L84:
        r120 = null;
    L31:
        r115 = null;
        goto L33
    L25:
        r112 = r100;
    L18:
        r110 = null;
        goto L20
    L12:
        r107 = r100;
        goto L13
    L5:
        r105 = null;
        goto L7
    }

    public final void b(IAction r100, c r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        o r103 = this.f49969d;
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof SlcCommonAction) == false) goto L18;
        SlcCommonAction r104 = (SlcCommonAction) r100;
        if (r104.getHasDynamicProp() == false) goto L18;
        SlcCommonAction.a r105 = SlcCommonAction.Companion;
        Map<String, ? extends Object> r106 = r104.getData();
        Intrinsics.checkNotNullParameter(r106, "actionTemplate");
        Function3<? super c, ? super Map<String, ? extends Object>, ? super Integer, ? extends Map<String, ? extends Object>> r107 = this.f49970e;
        if (r107 != null) goto L13;
        nq.a.c(null, ActionContext$evalActionTemplate$1.INSTANCE, 1);
    L14:
        r105.getClass();
        SlcCommonAction r108 = SlcCommonAction.a.b(r106);
        if (r108 == null) goto L18;
        r100 = r108;
        goto L18
    L13:
        r106 = r107.invoke(r101, r106, 2);
    L18:
        if (r100.getDisable() == true) goto L39;
        Iterator r109 = ((ArrayList) this.f49967b).iterator();
    L22:
        if (r109.hasNext() == false) goto L27;
        if (((m) r109.next()).onIntercept() == false) goto L22;
        return;
    L27:
        if (((ArrayList) this.f49968c).isEmpty() == false) goto L29;
        a(r100, r101, r102);
        return;
    L29:
        Iterator r110 = ((ArrayList) this.f49968c).iterator();
        if (r110.hasNext() == false) goto L32;
        k r111 = (k) r110.next();
        new ActionContext$doProcessAsyncInterceptor$1(this, r110, r100, r101);
        r111.a();
        return;
    L32:
        a(r100, r101, null);
        return;
    }

    public static /* synthetic */ void c(ActionContext r100, IAction r101, c r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.b(r101, r102, null);
    }
}
