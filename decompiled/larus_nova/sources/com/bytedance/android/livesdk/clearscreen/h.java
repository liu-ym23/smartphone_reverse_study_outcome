package com.bytedance.android.livesdk.clearscreen;

import am2.x;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.widgets.y;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$AnimType;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenUtils;
import com.bytedance.android.livesdk.config.uk;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements jg1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f119411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup.LayoutParams f119412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f119413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f119414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<ToolbarButton, Pair<j70.f, String>> f119415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f119416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f119417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f119418h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f119419i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f119420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f119421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f119422l;

    public final boolean g() {
        int r100 = this.f119416f;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 != 3) goto L9;
        return true;
    L9:
        if (r100 == 13) goto L16;
        return false;
    L16:
        return true;
    }

    public final void k() {
        long r100 = System.currentTimeMillis();
        int r101 = this.f119416f;
        if (r101 != 2) goto L5;
        this.f119419i += r100 - this.f119417g;
    L12:
        int r102 = (int) this.f119418h;
        if (r102 == 0) goto L15;
    L18:
        ClearScreenLogUtils.Companion r103 = ClearScreenLogUtils.f119492a;
        int r104 = (int) this.f119419i;
        int r105 = (int) this.f119420j;
        r103.getClass();
        HashMap r106 = new HashMap();
        if (r102 != 0) goto L23;
        if (r104 != 0) goto L23;
        r106.put("simple_mode_duration", "0");
        r106.put("pure_mode_duration", "0");
        r106.put("duration", String.valueOf(r105));
    L24:
        RoomContext r107 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r107 == null) goto L30;
        com.bytedance.live.datacontext.m<String> r108 = r107.getEnterClearType();
        if (r108 == null) goto L30;
        String r109 = r108.getValue();
        if (r109 == null) goto L30;
    L31:
        r106.put("clear_type", r109);
        u.l().sendLog("livesdk_live_duration_under_screen_clear", r106, new Object[]{new x(), Room.class});
        return;
    L30:
        r109 = "";
    L23:
        r106.put("simple_mode_duration", String.valueOf(r102));
        r106.put("pure_mode_duration", String.valueOf(r104));
        r106.put("duration", String.valueOf(r102 + r104));
        goto L24
    L15:
        if (((int) this.f119419i) != 0) goto L18;
        if (((int) this.f119420j) != 0) goto L18;
        return;
    L5:
        if (r101 != 3) goto L8;
        this.f119418h += r100 - this.f119417g;
        goto L12
    L8:
        if (r101 != 13) goto L10;
        this.f119418h += r100 - this.f119417g;
        goto L12
    L10:
        if (r101 != 1) goto L12;
        this.f119420j += r100 - this.f119417g;
        goto L12
    }

    public final void l() {
        k();
        e(ClearScreenConst$InteractType.INTERACT_SHOW);
        if (uk.f121381a.getValue().booleanValue() == false) goto L18;
        boolean r100 = gs1.b.f482438a;
        HashMap<String, i> r101 = gs1.b.a(this.f119422l).f119499f;
        if (r101 == null) goto L9;
        i r102 = r101.get("T_ICON_CONTAINER");
        if (r102 == null) goto L9;
        View r103 = r102.f119425c;
    L10:
        ViewGroup r104 = (ViewGroup) r103;
        if (r104 == null) goto L18;
        Sequence<View> r105 = UtilityKotlinExtentionsKt.g(r104);
        if (r105 == null) goto L18;
        Iterator<View> r106 = r105.iterator();
    L16:
        if (r106.hasNext() == false) goto L18;
        r104.removeView(r106.next());
    L9:
        r103 = null;
    L18:
        this.f119411a = null;
        this.f119412b = null;
        this.f119414d = -1;
        this.f119413c = null;
        this.f119421k = "none";
        this.f119418h = 0;
        this.f119419i = 0;
        this.f119417g = 0;
        this.f119420j = 0;
        boolean r107 = gs1.b.f482438a;
        gs1.b.a(this.f119422l).m();
    }

    public h(String r100) {
        this.f119422l = r100;
        this.f119414d = -1;
        this.f119415e = new HashMap();
        this.f119421k = "none";
    }

    public static void h(SparseArray r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        if (r100.get(1) != null) goto L6;
        r100.put(1, new HashSet());
    L6:
        if (r100.get(3) != null) goto L9;
        r100.put(3, new HashSet());
    L9:
        if (uk.f121381a.getValue().booleanValue() == false) goto L14;
        if (r100.get(13) != null) goto L14;
        r100.put(13, new HashSet());
    L14:
        if (r100.get(2) != null) goto L17;
        r100.put(2, new HashSet());
        return;
    }

    @Override // jg1.b
    public final void a(ClearScreenConst$InteractType r100) {
        Intrinsics.checkNotNullParameter(r100, "interactType");
        boolean r101 = gs1.b.f482438a;
        HashMap<ClearScreenConst$InteractType, jg1.a> r102 = gs1.b.a(this.f119422l).g();
        if (r102 == null) goto L6;
        jg1.a r103 = r102.remove(r100);
        return;
    }

    @Override // jg1.b
    public final void b(jg1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "assistant");
        boolean r101 = gs1.b.f482438a;
        HashMap<ClearScreenConst$InteractType, jg1.a> r102 = gs1.b.a(this.f119422l).g();
        if (r102 == null) goto L6;
        jg1.a r103 = r102.put(r100.getInteractType(), r100);
        return;
    }

    public final void c(boolean r110) {
        if (wt2.a.e(Boolean.valueOf(r110)) == true) goto L5;
    L9:
        boolean r111 = false;
    L10:
        if (r111 == true) goto L12;
        return;
    L12:
        int r112 = this.f119416f;
        byte r100 = -1;
        if (r112 == 3) goto L22;
        if (r112 == 13) goto L22;
        if (r112 == 2) goto L18;
        int r101 = -1;
    L23:
        long r102 = System.currentTimeMillis();
        if (r112 != 2) goto L30;
        this.f119419i += r102 - this.f119417g;
        if (r101 != 3) goto L28;
        ClearScreenLogUtils.Companion r103 = ClearScreenLogUtils.f119492a;
        String r113 = this.f119421k;
        r103.getClass();
        ClearScreenLogUtils.Companion.e(r113);
    L28:
        if (r101 != 13) goto L34;
        ClearScreenLogUtils.Companion r104 = ClearScreenLogUtils.f119492a;
        String r114 = this.f119421k;
        r104.getClass();
        ClearScreenLogUtils.Companion.e(r114);
    L34:
        this.f119417g = r102;
        ClearScreenLogUtils.Companion r105 = ClearScreenLogUtils.f119492a;
        if (r112 != 2) goto L38;
        if (r101 != 3) goto L38;
    L40:
        r100 = 1;
    L47:
        r105.getClass();
        if (r100 != 1) goto L50;
        String r106 = "pure_to_simple";
    L52:
        HashMap r107 = new HashMap();
        r107.put("transform_type", r106);
        u.l().sendLog("livesdk_clear_mode_transform", r107, new Object[]{new x(), Room.class});
    L53:
        if (r112 < 0) goto L205;
        if (r101 < 0) goto L206;
        boolean r108 = gs1.b.f482438a;
        ClearScreenUtils r109 = gs1.b.a(this.f119422l);
        HashSet<String> r115 = r109.f119501h.get(r112);
        HashSet<String> r116 = r109.f119501h.get(r101);
        HashSet<String> r117 = r109.f119502i.get(r112);
        HashSet<String> r118 = r109.f119502i.get(r101);
        ArrayList r119 = new ArrayList();
        ArrayList r120 = new ArrayList();
        if (r115 == null) goto L67;
        Iterator<T> r121 = r115.iterator();
    L59:
        if (r121.hasNext() == false) goto L67;
        String r122 = (String) r121.next();
        if (r116 == null) goto L59;
        if (r116.contains(r122) == true) goto L59;
        i r123 = r109.f119499f.get(r122);
        if (r123 == null) goto L59;
        ClearScreenConst$AnimType r124 = ClearScreenConst$AnimType.ALPHA;
        Intrinsics.checkNotNullParameter(r124, "<set-?>");
        r123.f119426d = r124;
        r109.f119496c.add(r123);
        r109.f119497d.add(r123);
        r109.f119498e.remove(r123);
        r120.add(r123);
    L67:
        if (r116 == null) goto L78;
        Iterator<T> r125 = r116.iterator();
    L70:
        if (r125.hasNext() == false) goto L78;
        String r126 = (String) r125.next();
        if (r115 == null) goto L70;
        if (r115.contains(r126) == true) goto L70;
        i r127 = r109.f119499f.get(r126);
        if (r127 == null) goto L70;
        r109.f119496c.remove(r127);
        r109.f119497d.remove(r127);
        r109.f119498e.add(r127);
        r119.add(r127);
    L78:
        if (r117 == null) goto L89;
        Iterator<T> r128 = r117.iterator();
    L81:
        if (r128.hasNext() == false) goto L89;
        String r129 = (String) r128.next();
        if (r118 == null) goto L81;
        if (r118.contains(r129) == true) goto L81;
        i r130 = r109.f119499f.get(r129);
        if (r130 == null) goto L81;
        r109.f119495b.remove(r130);
        r120.add(r130);
    L89:
        if (r118 == null) goto L102;
        Iterator<T> r131 = r118.iterator();
    L92:
        if (r131.hasNext() == false) goto L102;
        String r132 = (String) r131.next();
        if (r117 == null) goto L92;
        if (r117.contains(r132) == true) goto L92;
        i r133 = r109.f119499f.get(r132);
        if (r133 != null) goto L100;
        r118.remove(r132);
    L100:
        if (r133 == null) goto L92;
        r109.f119495b.add(r133);
        r119.add(r133);
    L102:
        Iterator r134 = r119.iterator();
    L104:
        if (r134.hasNext() == false) goto L131;
        i r135 = (i) r134.next();
        if (r135.f119427e == false) goto L110;
        View r136 = r135.f119425c;
        if (r136 == null) goto L113;
        int r137 = r136.getLeft();
    L114:
        float r138 = r137 * 1.0f;
        if (r135.f119427e == false) goto L119;
        View r139 = r135.f119425c;
        if (r139 == null) goto L122;
        r139.setX(r138);
    L122:
        r135.e(0);
        ViewPropertyAnimator r140 = r135.b();
        if (r140 == null) goto L104;
        ViewPropertyAnimator r141 = r140.alpha(1.0f);
        if (r141 == null) goto L104;
        ViewPropertyAnimator r142 = r141.setDuration(r109.f());
        if (r142 == null) goto L104;
        ViewPropertyAnimator r143 = r142.setInterpolator(new com.bytedance.android.live.core.widget.g());
        if (r143 == null) goto L104;
        r143.start();
        goto L104
    L119:
        v70.c r144 = r135.f119424b;
        if (r144 == null) goto L122;
        r144.setX(r138);
    L113:
        r137 = 0;
        goto L114
    L110:
        v70.c r145 = r135.f119424b;
        if (r145 == null) goto L113;
        r137 = r145.f553414a.getLeft();
        goto L114
    L131:
        Iterator r146 = r120.iterator();
    L133:
        if (r146.hasNext() == false) goto L143;
        i r147 = (i) r146.next();
        r147.e(8);
        ViewPropertyAnimator r148 = r147.b();
        if (r148 == null) goto L133;
        ViewPropertyAnimator r149 = r148.alpha(0.0f);
        if (r149 == null) goto L133;
        ViewPropertyAnimator r150 = r149.setDuration(r109.f());
        if (r150 == null) goto L133;
        ViewPropertyAnimator r151 = r150.setInterpolator(new com.bytedance.android.live.core.widget.g());
        if (r151 == null) goto L133;
        r151.start();
        goto L133
    L143:
        int r152 = gs1.a.f482437a;
        h r153 = gs1.a.a(r109.f119508o);
        if (r153 == null) goto L207;
        r153.d(r101);
        return;
    L207:
        return;
    L206:
        return;
    L205:
        return;
    L50:
        if (r100 != 2) goto L53;
        r106 = "simple_to_pure";
    L38:
        if (r112 != 2) goto L41;
        if (r101 == 13) goto L40;
    L41:
        if (r112 != 3) goto L44;
        if (r101 != 2) goto L44;
    L46:
        r100 = 2;
    L44:
        if (r112 != 13) goto L47;
        if (r101 != 2) goto L47;
    L30:
        if (r112 != 3) goto L32;
        this.f119418h += r102 - this.f119417g;
        goto L34
    L32:
        if (r112 != 13) goto L34;
        this.f119418h += r102 - this.f119417g;
        goto L34
    L18:
        if (uk.f121381a.getValue().booleanValue() == false) goto L20;
        r101 = 13;
        goto L23
    L20:
        r101 = 3;
    L22:
        r101 = 2;
        goto L23
    L5:
        if (wt2.a.c() == false) goto L9;
        if (g() == false) goto L9;
        r111 = true;
        goto L10
    }

    @Deprecated(message = "推荐使用另外一个传ClearType的方法，外部不要使用该方法")
    public final void d(int r100) {
        ClearScreenConst$InteractType[] r101 = ClearScreenConst$InteractType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        ClearScreenConst$InteractType r104 = r101[r103];
        if (r100 == r104.getId()) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        e(r104);
        return;
    }

    public final void e(ClearScreenConst$InteractType r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        this.f119416f = r100.getId();
        RoomContext.a r101 = RoomContext.Companion;
        RoomContext r102 = RoomContext.a.c(r101, null, 0, 3);
        if (r102 == null) goto L7;
        com.bytedance.live.datacontext.m<Integer> r103 = r102.getCleanMode();
        if (r103 == null) goto L7;
        r103.setValue(Integer.valueOf(r100.getId()));
    L7:
        RoomContext r104 = RoomContext.a.c(r101, null, 0, 3);
        if (r104 == null) goto L12;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.isCleanMode();
        if (r105 == null) goto L12;
        Lazy r106 = ClearScreenHelper.f119484a;
        Intrinsics.checkNotNullParameter(r100, "type");
        r105.setValue(Boolean.valueOf(r100.getCanShowClearLayer()));
    L12:
        ILinkServiceExternal r107 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r107 == null) goto L15;
        r107.notifyCleanModeChanged(r100.getId());
    L15:
        ILinkServiceExternal r108 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r108 == null) goto L18;
        Lazy r109 = ClearScreenHelper.f119484a;
        Intrinsics.checkNotNullParameter(r100, "type");
        r108.notifyIsCleanModeChanged(r100.getCanShowClearLayer());
    L18:
        Lazy r110 = ClearScreenHelper.f119484a;
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100.getCanShowClearLayer() == false) goto L33;
        if (LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER.getValue().booleanValue() == true) goto L24;
        xs2.b.a().post(new y(true, 1));
    L24:
        if (jc1.k.f(IPerformanceManager.class) != null) goto L26;
        return;
    L26:
        if (r100 != ClearScreenConst$InteractType.ORIGIN_CLEAR) goto L28;
    L31:
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onEnterFullScreenClean();
        return;
    L28:
        if (r100 == ClearScreenConst$InteractType.PURE_CLEAR) goto L31;
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onLeaveFullScreenClean();
        return;
    L33:
        if (r100 == ClearScreenConst$InteractType.INTERACT_SHOW) goto L35;
        return;
    L35:
        if (LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER.getValue().booleanValue() == true) goto L38;
        xs2.b.a().post(new y(false, 1));
    L38:
        if (jc1.k.f(IPerformanceManager.class) == null) goto L45;
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onLeaveFullScreenClean();
        return;
    }

    public final void f(e0 r100) {
        if (r100 == null) goto L6;
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L6;
        View r102 = j(r101);
    L7:
        this.f119413c = r102;
        if (r102 == null) goto L20;
        boolean r103 = gs1.b.f482438a;
        gs1.b.a(this.f119422l).k(3, new j70.f("T_ICON_CONTAINER", ""));
        if (uk.f121381a.getValue().booleanValue() == false) goto L12;
        gs1.b.a(this.f119422l).k(13, new j70.f("T_ICON_CONTAINER", ""));
    L12:
        HashMap<String, i> r104 = gs1.b.a(this.f119422l).f119499f;
        if (r104 == null) goto L21;
        i r105 = r104.get("T_ICON_CONTAINER");
        if (r105 == null) goto L22;
        View r106 = r105.f119425c;
        if (r106 == null) goto L23;
        gs1.b.a(this.f119422l).o(new j70.f("T_ICON_CONTAINER", ""), r106, r100);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L6:
        r102 = null;
        goto L7
    }

    public final void i(boolean r100) {
        boolean r101 = gs1.b.f482438a;
        HashMap<String, i> r102 = gs1.b.a(this.f119422l).f119499f;
        ViewParent r103 = null;
        if (r102 == null) goto L7;
        i r104 = r102.get("T_ICON_CONTAINER");
        if (r104 == null) goto L7;
        View r105 = r104.f119425c;
    L8:
        ViewGroup r106 = (ViewGroup) r105;
        if (r100 == false) goto L40;
        View r107 = this.f119413c;
        if (r107 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r107.getParent(), r106) == false) goto L15;
        return;
    L15:
        View r108 = this.f119413c;
        if (r108 == null) goto L18;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L19:
        this.f119412b = r109;
        View r110 = this.f119413c;
        if (r110 == null) goto L22;
        ViewParent r111 = r110.getParent();
    L24:
        if ((r111 instanceof ViewGroup) == false) goto L27;
        r103 = r111;
    L27:
        ViewGroup r112 = (ViewGroup) r103;
        this.f119411a = r112;
        if (r112 == null) goto L30;
        int r113 = r112.indexOfChild(this.f119413c);
    L31:
        this.f119414d = r113;
        ViewGroup r114 = this.f119411a;
        if (r114 == null) goto L35;
        r114.removeView(this.f119413c);
    L35:
        if (uk.f121381a.getValue().booleanValue() == false) goto L38;
        if (r106 == null) goto L38;
        UtilityKotlinExtentionsKt.w(r106);
    L38:
        if (r106 == null) goto L62;
        r106.addView(this.f119413c);
        return;
    L62:
        return;
    L30:
        r113 = 1;
        goto L31
    L22:
        r111 = null;
        goto L24
    L18:
        r109 = null;
        goto L19
    L40:
        if (r106 == null) goto L64;
        Sequence<View> r115 = UtilityKotlinExtentionsKt.g(r106);
        if (r115 == null) goto L65;
        Iterator<View> r116 = r115.iterator();
    L45:
        if (r116.hasNext() == false) goto L66;
        View r117 = r116.next();
        r106.removeView(r117);
        ViewGroup.LayoutParams r118 = this.f119412b;
        if (r118 == null) goto L49;
        r117.setLayoutParams(r118);
    L49:
        int r119 = this.f119414d;
        if (r119 == (-1)) goto L45;
        ViewGroup r120 = this.f119411a;
        if (r120 == null) goto L45;
        r120.addView(r117, r119);
        goto L45
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L7:
        r105 = null;
        goto L8
    }

    public final View j(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        c0 r101 = y3.m(r100);
        if (r101 == null) goto L28;
        x3 r102 = (x3) r101;
        Iterator<Map.Entry<ToolbarButton, Pair<j70.f, String>>> r103 = this.f119415e.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L25;
        Map.Entry<ToolbarButton, Pair<j70.f, String>> r104 = r103.next();
        ToolbarButton r105 = r104.getKey();
        Pair<j70.f, String> r106 = r104.getValue();
        if (r102.n(r105) == true) goto L11;
        if (uk.f121381a.getValue().booleanValue() == false) goto L6;
    L11:
        boolean r107 = gs1.b.f482438a;
        gs1.b.a(this.f119422l).l(3, r106.getFirst());
        if (uk.f121381a.getValue().booleanValue() == false) goto L15;
        gs1.b.a(this.f119422l).l(13, r106.getFirst());
    L15:
        if (wt2.a.l() == false) goto L23;
        HashMap<String, i> r108 = gs1.b.a(this.f119422l).f119499f;
        if (r108 == null) goto L23;
        i r109 = r108.get(r106.getFirst().f497558a);
        if (r109 == null) goto L23;
        HashSet<i> r110 = gs1.b.a(this.f119422l).f119496c;
        if (r110 == null) goto L23;
        r110.remove(r109);
    L23:
        this.f119421k = r106.getSecond();
        Map<ExtendedToolbarButton, View> r111 = r102.f116829c;
        ExtendedToolbarButton.f115618h.getClass();
        HashMap r112 = (HashMap) r111;
        return (View) r112.get(ExtendedToolbarButton.a.a(r105));
    L25:
        return null;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }
}
