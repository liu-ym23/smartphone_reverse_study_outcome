package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ToolbarOperateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f115954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f115955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<s> f115956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f115957d;

    public final boolean e() {
        return ((Boolean) this.f115954a.getValue()).booleanValue();
    }

    public ToolbarOperateManager(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f115957d = r100;
        this.f115954a = LazyKt.lazy(new ToolbarOperateManager$isAnchor$2(this));
        this.f115956c = new ArrayList();
    }

    public final void a(final s r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        if (c(r100, "toMore") == true) goto L6;
        return;
    L6:
        if (h21.f120333a.getValue().booleanValue() == false) goto L15;
        k r101 = this.f115955b;
        if (r101 == null) goto L15;
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        a0 r102 = r101.f116117a.get(r100.f116191a);
        if (r102 == null) goto L12;
        boolean r103 = r102.o();
    L13:
        if (r103 != true) goto L15;
        d("more", r100, new ToolbarOperateManager$addToMorePanel$1(this, r100));
        return;
    L12:
        r103 = false;
    L15:
        f(true, true, r100, new ToolbarOperateManager$addToMorePanel$2(y3.f(this.f115957d)));
    }

    public final void b(s r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        if (c(r100, "toToolbar") == true) goto L6;
        HashMap<String, String> r101 = q.f116173a;
        q.a(r100.f116191a, ToolbarReasonTag.NORMAL, " by orientation check");
        return;
    L6:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r102 = y3.m(this.f115957d);
        if (r102 == null) goto L11;
        f(false, true, r100, new ToolbarOperateManager$addToToolbar$1((x3) r102));
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    public final void g(s r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        f(true, false, r100, new ToolbarOperateManager$removeFromMorePanel$1(y3.f(this.f115957d)));
    }

    public final void h(s r100) {
        Intrinsics.checkNotNullParameter(r100, "toolbarButton");
        this.f115956c.remove(r100);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r101 = y3.m(this.f115957d);
        if (r101 == null) goto L7;
        f(false, false, r100, new ToolbarOperateManager$removeFromToolbar$1((x3) r101));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    public final boolean c(s r100, String r101) {
        Boolean r102 = (Boolean) this.f115957d.get("data_is_portrait", Boolean.TRUE);
        if (r100.f116197g != 2) goto L14;
        if (r102.booleanValue() == false) goto L14;
        if (r100.f116191a == 38) goto L9;
    L11:
        ALogger.d("NewToolbarLog", r100 + " is only horizon " + r101);
        return false;
    L9:
        if (e5.n() == false) goto L11;
        return true;
    L14:
        if (r100.f116197g == 1) goto L16;
    L19:
        return true;
    L16:
        if (r102.booleanValue() == true) goto L19;
        ALogger.d("NewToolbarLog", r100 + " is only portrait " + r101);
        return false;
    }

    public final void d(final String r110, final s r111, final Function1<? super s, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "actionName");
        Intrinsics.checkNotNullParameter(r111, "toolbarButton");
        Intrinsics.checkNotNullParameter(r112, "action");
        final long r100 = System.currentTimeMillis();
        HashMap<String, String> r101 = q.f116173a;
        q.f116175c = r111.f116191a;
        ALogger.i("NewToolbarLog", "checkThenDoAction " + r110 + " - " + r111 + " - " + r100);
        Lazy r102 = ToolbarComponentCheckManager.f115947a;
        DataCenter r103 = this.f115957d;
        final Function0<Unit> r104 = new ToolbarOperateManager$checkThenDo$1(r110, r111, r100, r112);
        final Function1<String, Unit> r113 = new ToolbarOperateManager$checkThenDo$2(r111, r110, r100);
        Intrinsics.checkNotNullParameter(r111, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r104, "loadButton");
        Intrinsics.checkNotNullParameter(r113, "stopLoadCallback");
        ToolbarComponentCheckManager.h(r103, new ToolbarComponentCheckManager$doubleCheckThenLoad$1(r111, r104, r113), new ToolbarComponentCheckManager$doubleCheckThenLoad$2(r111, r104, r113));
    }

    public final void f(boolean r210, boolean r211, s r212, Function2<? super s, ? super com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, Unit> r213) {
        k r110 = this.f115955b;
        if (r110 == null) goto L60;
        r212.f116202l.f116103a = Boolean.valueOf(r210);
        if (r211 == false) goto L7;
        String r100 = "cmd_specific_behavior_loaded";
    L8:
        String r111 = r100;
        if (r211 == false) goto L11;
        Function3 r101 = new ToolbarOperateManager$realInvokeFunc$1$getBehaviorFunc$1(r110);
    L12:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r112 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b) r101.invoke(r212, Boolean.valueOf(r210), Boolean.valueOf(e()));
        String r113 = "null";
        if (r112 == null) goto L45;
        r213.invoke(r212, r112);
        boolean r102 = e();
        Intrinsics.checkNotNullParameter(r212, "toolbarButton");
        a0 r103 = r110.f116117a.get(r212.f116191a);
        if (r103 == null) goto L20;
        String r104 = r103.i(r210, r102);
        if (r104 == null) goto L20;
        String r105 = r104;
    L21:
        DataCenter r106 = this.f115957d;
        boolean r107 = r212.f116202l.f116104b;
        int r108 = r212.f116191a;
        String r109 = r212.f116194d;
        py.k r114 = r212.f116193c;
        String r214 = "more";
        String r115 = NewBroadcastMonitor.STAGE.TOOLBAR;
        r106.put(r111, new ToolbarBehaviorData(r105, r210, r107, r108, r109, r114));
        if (r211 == false) goto L26;
        boolean r116 = e();
        Intrinsics.checkNotNullParameter(r212, "toolbarButton");
        Intrinsics.checkNotNullParameter(r112, "behavior");
        a0 r117 = r110.f116117a.get(r212.f116191a);
        if (r117 == null) goto L29;
        r117.a(r110.c(r212, r210, r116));
    L29:
        com.bytedance.android.livesdk.sharedpref.e<Long> r118 = b.f115967a;
        boolean r119 = e();
        Intrinsics.checkNotNullParameter(r212, "toolbarButton");
        if (r211 == false) goto L32;
        String r120 = "load";
    L33:
        String r121 = String.valueOf(r212.f116191a);
        if (r210 == false) goto L36;
        String r122 = r214;
    L37:
        if (r119 == false) goto L39;
        String r123 = "anchor";
    L41:
        if (r212.f116202l.f116104b == false) goto L43;
        String r124 = "msg";
    L44:
        xs2.b.a().post(new zg1.h("ToolbarCheck", "path: " + r120 + ' ' + r121 + ' ' + r122 + ' ' + r123 + ' ' + r124));
    L46:
        String r125 = r212.toString();
        if (r112 == null) goto L50;
        r113 = r112.getClass().getSimpleName();
    L50:
        String r126 = r113;
        if (r210 == false) goto L53;
        String r127 = r214;
    L54:
        String r128 = " in ".concat(r127);
        if (r211 == false) goto L57;
        String r129 = "load";
    L58:
        ALogger.i("NewToolbarLog", "realInvokeFunc " + r125 + ' ' + r129 + ' ' + r126 + ' ' + r128);
        return;
    L57:
        r129 = "unload";
        goto L58
    L53:
        r127 = r115;
        goto L54
    L43:
        r124 = "room";
        goto L44
    L39:
        r123 = SourceType.DEFAULT;
        goto L41
    L36:
        r122 = r115;
        goto L37
    L32:
        r120 = "unload";
        goto L33
    L26:
        boolean r130 = e();
        Intrinsics.checkNotNullParameter(r212, "toolbarButton");
        Intrinsics.checkNotNullParameter(r112, "behavior");
        a0 r131 = r110.f116117a.get(r212.f116191a);
        if (r131 == null) goto L29;
        r131.b(r110.c(r212, r210, r130));
    L20:
        r105 = "null";
        goto L21
    L45:
        r214 = "more";
        r115 = NewBroadcastMonitor.STAGE.TOOLBAR;
        r112 = null;
        goto L46
    L11:
        r101 = new ToolbarOperateManager$realInvokeFunc$1$getBehaviorFunc$2(r110);
        goto L12
    L7:
        r100 = "cmd_specific_behavior_un_loaded";
        goto L8
    }
}
