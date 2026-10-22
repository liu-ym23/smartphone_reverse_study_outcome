package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.floatwindow;

import android.content.Context;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.j;
import com.bytedance.android.livesdk.vscore_api.paidlive.k;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdk.vscore_api.paidlive.n;
import com.bytedance.android.livesdk.vscore_api.paidlive.scope.g;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f160177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f160178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f160179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f160180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f160181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<PaidSceneEnum, Function1<StateMachine.c<? extends l, ? extends j, ? extends k>, Unit>> f160182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.b f160183g;

    private final TextView getDebugPaidStatusView() {
        return (TextView) this.f160180d.getValue();
    }

    private final TextView getFloatWindowTempText() {
        return (TextView) this.f160178b.getValue();
    }

    private final View getFloatWindowWatchEndArea() {
        return (View) this.f160179c.getValue();
    }

    private final FrameLayout getFloatWindowWatchEndBg() {
        return (FrameLayout) this.f160177a.getValue();
    }

    public final void c() {
        this.f160181e = true;
        Iterator<Map.Entry<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.e>> r100 = getPaidManagerService().A1().entrySet().iterator();
    L3:
        l r101 = null;
        if (r100.hasNext() == false) goto L49;
        final PaidSceneEnum r102 = r100.next().getKey();
        com.bytedance.android.livesdk.vscore_api.paidlive.e r103 = getPaidManagerService().E1(r102);
        if (r103 == null) goto L12;
        PaidSceneContext r104 = r103.Xb();
        if (r104 == null) goto L12;
        m<n> r105 = r104.getSceneStateMachine();
        if (r105 == null) goto L12;
        n r106 = r105.getValue();
    L13:
        if (r106 == null) goto L15;
        r101 = r106.b();
    L15:
        if (r101 != null) goto L17;
    L18:
        if (r101 != null) goto L20;
    L22:
        if (r101 != null) goto L24;
    L34:
        if (r101 != null) goto L36;
    L46:
        if (r106 == null) goto L3;
        Function1<StateMachine.c<? extends l, ? extends j, ? extends k>, Unit> r107 = new PaidInRoomFloatWindowView$registerSceneTransition$$inlined$forEach$lambda$1(r102, this);
        this.f160182f.put(r102, r107);
        r106.a(r107);
        b("register transition Listener for " + r102.name());
        goto L3
    L36:
        if ((r101 instanceof l.f) != true) goto L46;
        UtilityKotlinExtentionsKt.w(this);
        TextView r108 = getFloatWindowTempText();
        if (r108 == null) goto L40;
        UtilityKotlinExtentionsKt.w(r108);
    L40:
        View r109 = getFloatWindowWatchEndArea();
        if (r109 == null) goto L43;
        UtilityKotlinExtentionsKt.t(r109);
    L43:
        FrameLayout r110 = getFloatWindowWatchEndBg();
        if (r110 == null) goto L46;
        UtilityKotlinExtentionsKt.t(r110);
        goto L46
    L24:
        if ((r101 instanceof l.e) != true) goto L34;
        UtilityKotlinExtentionsKt.w(this);
        TextView r111 = getFloatWindowTempText();
        if (r111 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r111);
    L28:
        View r112 = getFloatWindowWatchEndArea();
        if (r112 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r112);
    L31:
        FrameLayout r113 = getFloatWindowWatchEndBg();
        if (r113 == null) goto L46;
        UtilityKotlinExtentionsKt.w(r113);
        goto L46
    L20:
        if (r101.a() != true) goto L22;
    L21:
        UtilityKotlinExtentionsKt.t(this);
        goto L46
    L17:
        if ((r101 instanceof l.a) == true) goto L21;
    L12:
        r106 = null;
        goto L13
    L49:
        if (Build.VERSION.SDK_INT < 31) goto L53;
        FrameLayout r114 = getFloatWindowWatchEndBg();
        if (r114 == null) goto L56;
        r114.setRenderEffect(RenderEffect.createBlurEffect(10.0f, 10.0f, Shader.TileMode.CLAMP));
    L56:
        Iterator<Map.Entry<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.e>> r115 = getPaidManagerService().D2().entrySet().iterator();
    L58:
        if (r115.hasNext() == false) goto L85;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r116 = getPaidManagerService().E1(r115.next().getKey());
        if (r116 == null) goto L66;
        PaidSceneContext r117 = r116.Xb();
        if (r117 == null) goto L66;
        m<n> r118 = r117.getSceneStateMachine();
        if (r118 == null) goto L66;
        n r119 = r118.getValue();
    L67:
        if (r119 == null) goto L58;
        l r120 = r119.b();
        if (r120 == null) goto L58;
        if ((r120 instanceof l.a) == true) goto L58;
        l r121 = r119.b();
        if (r121 == null) goto L58;
        if ((r121 instanceof l.e) != true) goto L58;
        UtilityKotlinExtentionsKt.w(this);
        TextView r122 = getFloatWindowTempText();
        if (r122 == null) goto L79;
        UtilityKotlinExtentionsKt.t(r122);
    L79:
        View r123 = getFloatWindowWatchEndArea();
        if (r123 == null) goto L82;
        UtilityKotlinExtentionsKt.w(r123);
    L82:
        FrameLayout r124 = getFloatWindowWatchEndBg();
        if (r124 == null) goto L58;
        UtilityKotlinExtentionsKt.w(r124);
    L66:
        r119 = null;
        goto L67
    L85:
        return;
    L53:
        FrameLayout r125 = getFloatWindowWatchEndBg();
        if (r125 == null) goto L56;
        r125.setBackgroundColor(-16777216);
        goto L56
    }

    public final void d() {
        this.f160181e = false;
        Iterator<Map.Entry<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.e>> r100 = getPaidManagerService().A1().entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L17;
        PaidSceneEnum r101 = r100.next().getKey();
        com.bytedance.android.livesdk.vscore_api.paidlive.e r102 = getPaidManagerService().E1(r101);
        if (r102 == null) goto L12;
        PaidSceneContext r103 = r102.Xb();
        if (r103 == null) goto L12;
        m<n> r104 = r103.getSceneStateMachine();
        if (r104 == null) goto L12;
        n r105 = r104.getValue();
    L13:
        if (r105 == null) goto L4;
        Function1 r106 = (Function1) ((LinkedHashMap) this.f160182f).get(r101);
        if (r106 == null) goto L4;
        Intrinsics.checkNotNullParameter(r106, "l");
        ((ArrayList) r105.f159478b).remove(r106);
        b("unregister transition Listener for " + r101.name());
    L12:
        r105 = null;
        goto L13
    L17:
        ((LinkedHashMap) this.f160182f).clear();
    }

    private final com.bytedance.android.livesdk.vscore_api.paidlive.c getPaidManagerService() {
        return g.b(this.f160183g);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("PaidInRoomFloatWindowView(" + hashCode() + ')', r100);
    }

    public a(com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f160183g = r100;
        this.f160177a = LazyKt.lazy(new PaidInRoomFloatWindowView$floatWindowWatchEndBg$2(this));
        this.f160178b = LazyKt.lazy(new PaidInRoomFloatWindowView$floatWindowTempText$2(this));
        this.f160179c = LazyKt.lazy(new PaidInRoomFloatWindowView$floatWindowWatchEndArea$2(this));
        this.f160180d = LazyKt.lazy(new PaidInRoomFloatWindowView$debugPaidStatusView$2(this));
        Objects.toString(r100.w0());
        this.f160182f = new LinkedHashMap();
        LayoutInflater.from(r101).inflate(R.layout.ttlive_paid_in_room_float_window_view, this, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(a r110, PaidSceneEnum r111, StateMachine.c r112) {
        if (r110.f160181e == false) goto L89;
        Long r100 = null;
        j r101 = null;
        r100 = null;
        r100 = null;
        if ((r112 instanceof StateMachine.c.b) == true) goto L8;
        StateMachine.c r102 = null;
    L9:
        StateMachine.c.b r103 = (StateMachine.c.b) r102;
        if (r103 == null) goto L12;
        l r113 = (l) r103.f66099a;
        l r114 = (l) r103.f66101c;
        j r104 = (j) r103.f66100b;
        com.bytedance.android.livesdk.vscore_api.paidlive.e r105 = r110.getPaidManagerService().E1(r111);
        if (r105 == null) goto L25;
        PaidSceneContext r106 = r105.Xb();
    L26:
        if (r106 == null) goto L33;
        m<Triple<Long, Long, Long>> r107 = r106.getPaidTempWatchRemainTime();
        if (r107 == null) goto L33;
        Triple<Long, Long, Long> r108 = r107.getValue();
        if (r108 == null) goto L33;
        r100 = r108.getThird();
    L33:
        if (r100 != null) goto L35;
    L37:
        r114.getClass();
        boolean r109 = r114 instanceof l.a;
        int r115 = 2;
        if (r109 == false) goto L41;
        UtilityKotlinExtentionsKt.t(r110);
    L86:
        r110.b("onTransition for " + r111 + ", curState = " + r115 + ", remainTime = " + r100);
        return;
    L41:
        if (r114.a() == false) goto L52;
        if (r109 == true) goto L52;
        UtilityKotlinExtentionsKt.t(r110);
        if (r106 == null) goto L50;
        m<Boolean> r116 = r106.getNeedDeliveryNotice();
        if (r116 == null) goto L50;
        if (r116.getValue().booleanValue() != true) goto L50;
        r115 = 3;
    L50:
        r115 = 4;
    L52:
        if ((r114 instanceof l.e) == false) goto L63;
        UtilityKotlinExtentionsKt.w(r110);
        TextView r117 = r110.getFloatWindowTempText();
        if (r117 == null) goto L56;
        UtilityKotlinExtentionsKt.t(r117);
    L56:
        View r118 = r110.getFloatWindowWatchEndArea();
        if (r118 == null) goto L59;
        UtilityKotlinExtentionsKt.w(r118);
    L59:
        FrameLayout r119 = r110.getFloatWindowWatchEndBg();
        if (r119 == null) goto L62;
        UtilityKotlinExtentionsKt.w(r119);
    L62:
        r115 = 1;
        goto L86
    L63:
        UtilityKotlinExtentionsKt.w(r110);
        TextView r120 = r110.getFloatWindowTempText();
        if (r120 == null) goto L66;
        UtilityKotlinExtentionsKt.w(r120);
    L66:
        View r121 = r110.getFloatWindowWatchEndArea();
        if (r121 == null) goto L69;
        UtilityKotlinExtentionsKt.t(r121);
    L69:
        FrameLayout r122 = r110.getFloatWindowWatchEndBg();
        if (r122 == null) goto L73;
        UtilityKotlinExtentionsKt.t(r122);
    L73:
        if (r100 != null) goto L75;
    L76:
        if (r100 != null) goto L79;
    L77:
        String r123 = s1.B(R.string.ttlive_pay_live_temp_watch_label_2);
    L82:
        TextView r124 = r110.getFloatWindowTempText();
        if (r124 == null) goto L85;
        r124.setText(r123);
    L85:
        r115 = 0;
        goto L86
    L79:
        if (r100.longValue() > 0) goto L81;
        r123 = s1.B(R.string.ttlive_pay_live_temp_watch_end_label);
        goto L82
    L81:
        long r125 = r100.longValue();
        StringCompanionObject r126 = StringCompanionObject.INSTANCE;
        long r127 = 60;
        r123 = s1.C(R.string.ttlive_pay_live_temp_watch_label, new Object[]{String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf((r125 / r127) % r127), Long.valueOf(r125 % r127)}, 2))});
        goto L82
    L75:
        if (r100.longValue() == (-1)) goto L77;
    L35:
        if (r100.longValue() >= 0) goto L37;
        r100 = 0L;
        r110.b("adjust remain time to 0 ");
        goto L37
    L25:
        r106 = null;
        goto L26
    L12:
        if ((r112 instanceof StateMachine.c.a) == true) goto L14;
        r112 = null;
    L14:
        StateMachine.c.a r128 = (StateMachine.c.a) r112;
        StringBuilder r129 = new StringBuilder("onStateTransition, InValid transition from: ");
        if (r128 == null) goto L17;
        l r130 = (l) r128.f66097a;
    L18:
        r129.append(r130);
        r129.append(",event: ");
        if (r128 == null) goto L21;
        r101 = (j) r128.f66098b;
    L21:
        r129.append(r101);
        r110.b(r129.toString());
        return;
    L17:
        r130 = null;
        goto L18
    L8:
        r102 = r112;
        goto L9
    }
}
