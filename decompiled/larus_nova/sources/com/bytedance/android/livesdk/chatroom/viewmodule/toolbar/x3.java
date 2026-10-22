package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.a8;
import com.bytedance.android.livesdk.chatroom.utils.l4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class x3 implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f116827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f116828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ExtendedToolbarButton, View> f116829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ExtendedToolbarButton, c0.b> f116830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<ExtendedToolbarButton, c0.b> f116831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<ExtendedToolbarButton, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s> f116832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<ExtendedToolbarButton, String> f116833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PublishSubject<c0.c> f116834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PublishSubject<c0.d> f116835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.utils.c0 f116836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f116837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f116838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f116839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f116840n;

    public final void B() {
        if (this.f116838l == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.chatroom.utils.c0 r100 = this.f116836j;
        if (r100 != null) goto L8;
        return;
    L8:
        ArrayList<ExtendedToolbarButton> r101 = r100.h();
        if (r101 != null) goto L11;
        return;
    L11:
        int r102 = 0;
    L13:
        if (r102 >= r101.size()) goto L15;
        com.bytedance.android.livesdk.chatroom.utils.o1 r103 = com.bytedance.android.livesdk.chatroom.utils.o1.d();
        ExtendedToolbarButton r104 = (ExtendedToolbarButton) ListProtector.get(r101, r102);
        r103.getClass();
        com.bytedance.android.livesdk.chatroom.utils.o1.g("livesdk_toolbar_icon_show", r104, r102);
        r102 = r102 + 1;
        goto L13
    }

    public final boolean z() {
        List<ExtendedToolbarButton> r100 = l4.f114552c;
        Iterator<ExtendedToolbarButton> r101 = l4.f114552c.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (y(r101.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public x3(boolean r100) {
        this.f116829c = new HashMap();
        this.f116830d = new HashMap();
        this.f116831e = new HashMap();
        this.f116832f = new HashMap();
        this.f116833g = new HashMap();
        this.f116834h = PublishSubject.create();
        this.f116835i = PublishSubject.create();
        this.f116837k = false;
        this.f116838l = false;
        this.f116839m = false;
        this.f116840n = false;
        this.f116827a = r100;
        if (r100 == false) goto L6;
        this.f116837k = com.bytedance.android.livesdk.chatroom.setting.j.f111528a.getValue().booleanValue();
        return;
    }

    public final void E(DataCenter r100) {
        if (r100 != null) goto L4;
        String r101 = "null";
    L6:
        if (this.f116827a == false) goto L8;
        String r102 = "unfold";
    L9:
        String r103 = r102 + " tm dataCenter " + r101 + " tm:" + String.valueOf(hashCode());
        int r104 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i0.f116115a;
        Intrinsics.checkNotNullParameter(r103, "string");
        ALogger.i("NewToolbarLog", r103);
        this.f116828b = r100;
        if (this.f116839m == false) goto L18;
        if (r100 != null) goto L13;
        return;
    L13:
        if (((Boolean) r100.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L15;
        boolean r105 = false;
    L16:
        this.f116838l = r105;
        return;
    L15:
        r105 = LiveInfraSettingKeys.LIVE_DYNAMIC_TOOLBAR_MODIFY_PERMUTATION.getValue().booleanValue();
        goto L16
    L18:
        return;
    L8:
        r102 = "fold";
        goto L9
    L4:
        r101 = String.valueOf(r100.hashCode());
        goto L6
    }

    public final void H(boolean r100) {
        Iterator r101 = ((HashMap) this.f116829c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L25;
        Map.Entry r102 = (Map.Entry) r101.next();
        Map<ExtendedToolbarButton, View> r103 = this.f116829c;
        HashMap r104 = (HashMap) r103;
        if (((View) r104.get(r102.getKey())) == null) goto L4;
        C((ExtendedToolbarButton) r102.getKey(), (View) r102.getValue());
        if (r100 == false) goto L4;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L4;
        ExtendedToolbarButton r105 = (ExtendedToolbarButton) r102.getKey();
        c0.b r106 = (c0.b) ((HashMap) this.f116831e).get(r105);
        if (this.f116838l == true) goto L17;
        if (a8.f102998a.getValue().booleanValue() == false) goto L17;
        r106 = (c0.b) ((HashMap) this.f116830d).get(r105);
    L17:
        if (((HashMap) this.f116832f).get(r105) == null) goto L21;
        if (r106 == null) goto L21;
        ((HashMap) this.f116832f).remove(r105);
        r106.onHide(false);
    L21:
        if ((r106 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.t) == false) goto L4;
        if (this.f116828b == null) goto L4;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.t) r106).onDestroy();
        goto L4
    L25:
        ((HashMap) this.f116829c).clear();
        if (LiveInfraSettingKeys.FIX_TOOLBAR_MANAGER_LEAK_CONTEXT.getValue().booleanValue() == false) goto L28;
        ((HashMap) this.f116832f).clear();
    L28:
        if (r100 == false) goto L44;
        ((HashMap) this.f116830d).clear();
        ((HashMap) this.f116831e).clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void c(ExtendedToolbarButton r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L7;
    L9:
        q(true, r100);
        return;
    L7:
        if (r(r100, "show ") == false) goto L9;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final boolean g(ToolbarButton r100) {
        ExtendedToolbarButton.f115618h.getClass();
        return x(ExtendedToolbarButton.a.a(r100));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void h(ExtendedToolbarButton r100) {
        ((HashMap) this.f116833g).remove(r100);
        this.f116835i.onNext(new c0.d(r100, false));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void i(ExtendedToolbarButton r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.f().equals("FAST_GIFT");
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L7;
    L9:
        q(false, r100);
        return;
    L7:
        if (r(r100, "dismiss ") == false) goto L9;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final String j(ToolbarButton r100) {
        ExtendedToolbarButton.f115618h.getClass();
        return u(ExtendedToolbarButton.a.a(r100));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void m(com.bytedance.android.livesdk.chatroom.utils.c0 r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.chatroom.utils.c0) == false) goto L6;
        this.f116836j = r100;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final boolean n(ToolbarButton r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Map<ExtendedToolbarButton, View> r101 = this.f116829c;
        ExtendedToolbarButton.f115618h.getClass();
        HashMap r102 = (HashMap) r101;
        View r103 = (View) r102.get(ExtendedToolbarButton.a.a(r100));
        if (r103 != null) goto L8;
        return false;
    L8:
        if (r103.getVisibility() != 0) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void o(ToolbarButton r100) {
        ExtendedToolbarButton.f115618h.getClass();
        h(ExtendedToolbarButton.a.a(r100));
    }

    public c0.b s(ExtendedToolbarButton r100) {
        return (c0.b) ((HashMap) this.f116830d).get(r100);
    }

    public final c0.b t(ToolbarButton r100) {
        ExtendedToolbarButton.f115618h.getClass();
        return s(ExtendedToolbarButton.a.a(r100));
    }

    public final String u(ExtendedToolbarButton r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (((HashMap) this.f116833g).containsKey(r100) == true) goto L8;
        String r101 = r100.g();
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return "";
    L12:
        Iterator r102 = ((HashMap) this.f116833g).entrySet().iterator();
    L14:
        if (r102.hasNext() == false) goto L19;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (TextUtils.equals(r101, ((ExtendedToolbarButton) r103.getKey()).g()) == false) goto L14;
        return (String) r103.getValue();
    L19:
        return "";
    L8:
        return (String) ((HashMap) this.f116833g).get(r100);
    }

    public final int v(ExtendedToolbarButton r100) {
        com.bytedance.android.livesdk.chatroom.utils.c0 r101 = this.f116836j;
        if (r101 != null) goto L5;
        return -1;
    L5:
        return r101.i(r100);
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s w(ExtendedToolbarButton r100) {
        Map<ExtendedToolbarButton, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s> r101 = this.f116832f;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) ((HashMap) r101).get(r100);
    }

    public final boolean x(ExtendedToolbarButton r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (((HashMap) this.f116833g).containsKey(r100) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof ExtendedToolbarButton.b) == false) goto L11;
        return false;
    L11:
        String r101 = r100.g();
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return false;
    L14:
        Iterator r102 = ((HashMap) this.f116833g).keySet().iterator();
    L16:
        if (r102.hasNext() == false) goto L21;
        if (TextUtils.equals(r101, ((ExtendedToolbarButton) r102.next()).g()) == false) goto L16;
        return true;
    L21:
        return ((HashMap) this.f116833g).containsKey(r100);
    }

    public final boolean y(ExtendedToolbarButton r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        View r101 = (View) ((HashMap) this.f116829c).get(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.getVisibility() != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public final void A(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, c0.b r101) {
        ALogger.e("dzy-toolbar", "ToolbarManager#loadNetButton, buttonId = " + r100.toString());
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L5;
        return;
    L5:
        DataCenter r102 = this.f116828b;
        if (r102 != null) goto L9;
        String r103 = "dataCenter is null, when tm:" + String.valueOf(hashCode());
        int r104 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i0.f116115a;
        Intrinsics.checkNotNullParameter(r103, "string");
        ALogger.e("NewToolbarLog", r103);
        HashMap<String, String> r105 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.f116173a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a(r100.f116191a, ToolbarReasonTag.TOOLBAR_MANAGER_ERROR, "dataCenter is null");
        return;
    L9:
        boolean r106 = ((Boolean) r102.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        boolean r107 = !this.f116827a;
        Intrinsics.checkNotNullParameter(r100, "$this$toLocalExtData");
        ToolbarButton r108 = f3.b(r100, r106, r107);
        if (r108 == null) goto L12;
        ExtendedToolbarButton r109 = r108.extended();
    L13:
        if (r109 != null) goto L16;
        HashMap<String, String> r110 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.f116173a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a(r100.f116191a, ToolbarReasonTag.TOOLBAR_MANAGER_ERROR, "local button is null");
        return;
    L16:
        ((HashMap) this.f116832f).put(r109, r100);
        if (((HashMap) this.f116829c).get(r109) == null) goto L19;
    L21:
        p(r109, r101);
        return;
    L19:
        if (this.f116827a == false) goto L21;
        String r111 = "view is null, when tm:" + String.valueOf(hashCode());
        int r112 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i0.f116115a;
        Intrinsics.checkNotNullParameter(r111, "string");
        ALogger.e("NewToolbarLog", r111);
        HashMap<String, String> r113 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.f116173a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q.a(r100.f116191a, ToolbarReasonTag.TOOLBAR_MANAGER_ERROR, "view is null");
        goto L21
    L12:
        r109 = null;
        goto L13
    }

    public final void C(ExtendedToolbarButton r100, View r101) {
        if (this.f116838l == false) goto L5;
        return;
    L5:
        c0.b r102 = (c0.b) ((HashMap) this.f116830d).get(r100);
        if (r102 == null) goto L12;
        DataCenter r103 = this.f116828b;
        if (r103 == null) goto L10;
        r102.R9(r101, r103);
    L10:
        r101.setVisibility(8);
        r101.setOnClickListener(null);
        return;
    }

    public final void D(final ExtendedToolbarButton r100, final View r101) {
        final c0.b r102 = (c0.b) ((HashMap) this.f116830d).get(r100);
        boolean r103 = true;
        LocalTestManager.a(new Class[]{wy.a.class});
        if (this.f116838l == false) goto L5;
        return;
    L5:
        if (r102 != null) goto L7;
    L30:
        if (r102 != null) goto L34;
        r103 = false;
    L34:
        if ((r100 instanceof ExtendedToolbarButton.b) == false) goto L45;
        ToolbarButton r104 = ((ExtendedToolbarButton.b) r100).f115626i;
        if (r104 != ToolbarButton.GIFT) goto L39;
        ALogger.i("ToolbarManager", "Gift onToolbarButtonReady(), behavior valid: " + r103);
        return;
    L39:
        if (r104 != ToolbarButton.FAST_GIFT) goto L42;
        ALogger.i("ToolbarManager", "FastGift onToolbarButtonReady(), behavior valid: " + r103);
        return;
    L42:
        if (r104 != ToolbarButton.COMMERCE) goto L48;
        ALogger.i("ToolbarManager", "Commerce onToolbarButtonReady(), behavior valid: " + r103);
        return;
    L48:
        return;
    L45:
        return;
    L7:
        if ((r102 instanceof c0.a) == true) goto L9;
        r101.setVisibility(0);
    L9:
        q(true, r100);
        if (r100 != ToolbarButton.COMMERCE.extended()) goto L12;
        ALogger.i("ToolbarPreload", "commerce new set");
    L12:
        r101.setOnClickListener(new v3(this, r100, r102));
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L15;
        r101.setOnLongClickListener(new w3(this, r101));
    L15:
        long r105 = SystemClock.uptimeMillis();
        DataCenter r106 = this.f116828b;
        if (r106 == null) goto L27;
        r102.p4(r101, r106);
        if (this.f116837k == false) goto L23;
        if (r100.f115623e == false) goto L23;
        r102.Bh(((ExtendedToolbarButton.b) r100).f115626i);
    L23:
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L27;
        if (((HashMap) this.f116832f).get(r100) == null) goto L27;
        r102.SY((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) ((HashMap) this.f116832f).get(r100));
    L27:
        long r107 = SystemClock.uptimeMillis() - r105;
        if (r107 < 10) goto L30;
        ((ILiveUxTracer) jc1.k.f(ILiveUxTracer.class)).traceDirectDuration("toolbar_loading_" + r100.f(), r107);
        goto L30
    }

    public final void F(ExtendedToolbarButton r100, int r101) {
        View r102 = (View) ((HashMap) this.f116829c).get(r100);
        if (r102 == null) goto L31;
        if (r100 != null) goto L6;
        return;
    L6:
        if (((HashMap) this.f116830d).get(r100) == null) goto L36;
        UIUtils.setViewVisibility(r102, r101);
        if (this.f116828b == null) goto L21;
        if (r101 != 0) goto L21;
        if (TextUtils.equals(r100.f(), "GIFT") == false) goto L14;
    L19:
        this.f116828b.put("data_toolbar_visible", r100.f());
        goto L21
    L14:
        if (TextUtils.equals(r100.f(), "FAST_GIFT") == true) goto L19;
        if (TextUtils.equals(r100.f(), "COMMERCE") == true) goto L19;
        if (TextUtils.equals(r100.f(), "GROUP_PURCHASE") == true) goto L19;
    L21:
        if ((r100 instanceof ExtendedToolbarButton.b) == false) goto L24;
        b(((ExtendedToolbarButton.b) r100).f115626i, new pp1.m(r101));
    L24:
        if (this.f116827a == false) goto L33;
        DataCenter r103 = this.f116828b;
        if (r103 != null) goto L28;
        return;
    L28:
        if (((Boolean) r103.get("cmd_hide_other_toolbar", Boolean.FALSE)).booleanValue() == false) goto L35;
        this.f116828b.put("cmd_toolbar_visibility_controller", new Pair(r100, Integer.valueOf(r101)));
        return;
    L35:
        return;
    L33:
        return;
    L36:
        return;
    }

    public final void G(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, c0.b r101) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L5;
        return;
    L5:
        DataCenter r102 = this.f116828b;
        if (r102 != null) goto L8;
        return;
    L8:
        Boolean r103 = Boolean.FALSE;
        boolean r104 = ((Boolean) r102.get("data_is_anchor", r103)).booleanValue();
        boolean r105 = !this.f116827a;
        Intrinsics.checkNotNullParameter(r100, "$this$toLocalExtData");
        ToolbarButton r106 = f3.b(r100, r104, r105);
        if (r106 == null) goto L11;
        ExtendedToolbarButton r107 = r106.extended();
    L12:
        if (r107 != null) goto L15;
        return;
    L15:
        if (r100.f116191a == 26) goto L17;
    L19:
        f(r107, r101);
        if (((HashMap) this.f116832f).get(r107) == null) goto L27;
        ((HashMap) this.f116832f).remove(r107);
        if (this.f116838l == false) goto L24;
        return;
    L24:
        if (r101 == null) goto L28;
        r101.onHide(r100.f116202l.f116104b);
        return;
    L28:
        return;
    L27:
        return;
    L17:
        if (((Boolean) this.f116828b.get("data_has_interact_more", r103)).booleanValue() == false) goto L19;
        i(ToolbarButton.INTERACTION.extended());
        goto L19
    L11:
        r107 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void a(ToolbarButton r100, String r101) {
        ExtendedToolbarButton.f115618h.getClass();
        l(ExtendedToolbarButton.a.a(r100), r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void b(ToolbarButton r100, e r101) {
        ALogger.i("ToolbarCommand", r101.getClass().getSimpleName());
        Map<ExtendedToolbarButton, c0.b> r102 = this.f116830d;
        ExtendedToolbarButton.f115618h.getClass();
        HashMap r103 = (HashMap) r102;
        c0.b r104 = (c0.b) r103.get(ExtendedToolbarButton.a.a(r100));
        if (r104 == null) goto L6;
        r104.dv(r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void d(ToolbarButton r100, c0.b r101) {
        ExtendedToolbarButton.f115618h.getClass();
        f(ExtendedToolbarButton.a.a(r100), r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100, c0.b r101) {
        if (this.f116838l == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L9;
        return;
    L9:
        if (((HashMap) this.f116830d).containsValue(r101) == false) goto L12;
        r101.Mr(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void f(ExtendedToolbarButton r100, c0.b r101) {
        View r102 = (View) ((HashMap) this.f116829c).get(r100);
        if (r102 == null) goto L5;
        C(r100, r102);
    L5:
        c0.b r103 = (c0.b) ((HashMap) this.f116830d).remove(r100);
        if (r100.f115623e == false) goto L13;
        DataCenter r104 = this.f116828b;
        if (r104 == null) goto L10;
        r104.put("tool_bar_button_unload", r100);
    L10:
        if (r101 != null) goto L12;
        r101 = r103;
    L12:
        this.f116834h.onNext(new c0.c(r100, r101, false));
    L13:
        q(false, r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void k(ToolbarButton r100, c0.b r101) {
        ExtendedToolbarButton.f115618h.getClass();
        p(ExtendedToolbarButton.a.a(r100), r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void l(ExtendedToolbarButton r100, String r101) {
        ((HashMap) this.f116833g).put(r100, r101);
        this.f116835i.onNext(new c0.d(r100, true));
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public void p(ExtendedToolbarButton r100, c0.b r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        View r102 = (View) ((HashMap) this.f116829c).get(r100);
        if (r102 == null) goto L7;
        C(r100, r102);
    L7:
        ((HashMap) this.f116830d).put(r100, r101);
        if (r102 == null) goto L11;
        D(r100, r102);
    L11:
        if ((r100 instanceof ExtendedToolbarButton.b) == false) goto L26;
        ToolbarButton r103 = ((ExtendedToolbarButton.b) r100).f115626i;
        if (r103 != ToolbarButton.GIFT) goto L16;
        ALogger.i("ttlive_gift", "load Gift icon");
    L21:
        DataCenter r104 = this.f116828b;
        if (r104 == null) goto L24;
        r104.put("tool_bar_button_load", r100);
    L24:
        this.f116834h.onNext(new c0.c(r100, r101, true));
        return;
    L16:
        if (r103 != ToolbarButton.FAST_GIFT) goto L19;
        ALogger.i("ttlive_gift", "load FastGift icon");
        goto L21
    L19:
        if (r103 != ToolbarButton.COMMERCE) goto L21;
        ALogger.i("ttlive_gift", "load commerce icon");
        goto L21
    }

    public final void q(boolean r100, ExtendedToolbarButton r101) {
        if (this.f116827a == false) goto L14;
        com.bytedance.android.livesdk.chatroom.utils.c0 r102 = this.f116836j;
        if (r102 == null) goto L14;
        if (this.f116838l == false) goto L10;
        return;
    L10:
        if (r100 == false) goto L12;
        r102.a(this, r101);
        return;
    L12:
        r102.d(this, r101);
        return;
    L14:
        if (r100 == false) goto L16;
        int r103 = 0;
    L17:
        F(r101, r103);
        if (this.f116827a == false) goto L22;
        int r104 = u3.f116787a;
        u3.a("mutex is null when handle " + r101.f() + ", show: " + r100);
        return;
    L22:
        return;
    L16:
        r103 = 8;
        goto L17
    }

    public final boolean r(ExtendedToolbarButton r100, String r101) {
        if (this.f116838l == false) goto L7;
        int r102 = com.bytedance.android.livesdk.config.setting.s.f121216a;
        if (LiveInfraSettingKeys.LIVE_STOP_TOOLBAR_MANAGER_SHOW_DISMISS.getValue().booleanValue() == false) goto L7;
    L8:
        ALogger.i("COMMON_SLOT_FILTER", "stop " + r101 + r100.f());
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L15;
        ALogger.stacktrace(4, "COMMON_SLOT_FILTER", ThreadMethodProxy.currentThread().getStackTrace());
        return true;
    L15:
        return true;
    L7:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.j.f116116a.contains(r100.f()) == true) goto L8;
        return false;
    }
}
