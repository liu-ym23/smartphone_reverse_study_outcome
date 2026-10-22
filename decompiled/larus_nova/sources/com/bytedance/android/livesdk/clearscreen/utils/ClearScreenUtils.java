package com.bytedance.android.livesdk.clearscreen.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.element.tetris.TetrisElement;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.g;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$AnimType;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.clearscreen.h;
import com.bytedance.android.livesdk.clearscreen.i;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class ClearScreenUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f119494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<i> f119495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<i> f119496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<i> f119497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<i> f119498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, i> f119499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<i, String> f119500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray<HashSet<String>> f119501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseArray<HashSet<String>> f119502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<String> f119503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f119504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f119505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f119506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f119507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f119508o;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f119509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClearScreenUtils f119510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f119511c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f119511c == false) goto L45;
            i r101 = this.f119509a;
            ArrayList<String> r102 = this.f119510b.f119503j;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "clearGoneList");
            if (LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE.getValue().booleanValue() == true) goto L7;
            return;
        L7:
            if (LiveInfraSettingKeys.LIVE_CLEAR_SCREEN_WIDGET_GONE_OPTIMIZE_SWITCHER.getValue().booleanValue() == false) goto L88;
            boolean r103 = r101.f119427e;
            if (r103 == true) goto L21;
            Element<?> r104 = r101.f119423a;
            if ((r104 instanceof WidgetElement) == false) goto L21;
            if (r104 == null) goto L20;
            com.bytedance.android.livesdk.common.i r105 = (com.bytedance.android.livesdk.common.i) ((WidgetElement) r104).f(com.bytedance.android.livesdk.common.i.class);
            if (r105 == null) goto L79;
            String r106 = r105.Lg();
            if (r106 == null) goto L80;
            r102.add(r106);
            return;
        L80:
            return;
        L79:
            return;
        L20:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement");
        L21:
            if (r103 == true) goto L82;
            Element<?> r107 = r101.f119423a;
            if ((r107 instanceof TetrisElement) == false) goto L83;
            if (r107 == null) goto L44;
            List<Element<?>> r108 = ((TetrisElement) r107).f65698m;
            ArrayList r109 = new ArrayList();
            Iterator r110 = ((ArrayList) r108).iterator();
        L27:
            if (r110.hasNext() == false) goto L31;
            Object r111 = r110.next();
            if ((((Element) r111) instanceof WidgetElement) == false) goto L27;
            r109.add(r111);
            goto L27
        L31:
            Iterator r112 = r109.iterator();
        L33:
            if (r112.hasNext() == false) goto L89;
            Element r113 = (Element) r112.next();
            if (r113 == null) goto L42;
            com.bytedance.android.livesdk.common.i r114 = (com.bytedance.android.livesdk.common.i) ((WidgetElement) r113).f(com.bytedance.android.livesdk.common.i.class);
            if (r114 == null) goto L33;
            String r115 = r114.Lg();
            if (r115 == null) goto L33;
            r102.add(r115);
            goto L33
        L42:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement");
        L89:
            return;
        L44:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.element.tetris.TetrisElement");
        L83:
            return;
        L82:
            return;
        L88:
            return;
        L45:
            Room r116 = null;
            RoomContext r117 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r117 == null) goto L51;
            m<Room> r118 = r117.getRoom();
            if (r118 == null) goto L51;
            r116 = r118.getValue();
        L51:
            if (VrUtils.x(r116) == false) goto L58;
            if (this.f119509a.c() == true) goto L58;
            if (VrUtils.B() == false) goto L58;
            this.f119509a.e(0);
            return;
        L58:
            if (this.f119511c == false) goto L60;
            return;
        L60:
            if (this.f119509a.c() == false) goto L62;
            return;
        L62:
            if (((Boolean) ClearScreenHelper.f119490g.getValue()).booleanValue() == false) goto L87;
            this.f119509a.e(0);
            return;
        }

        public a(i r100, ClearScreenUtils r101, boolean r102) {
            this.f119509a = r100;
            this.f119510b = r101;
            this.f119511c = r102;
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f119512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f119513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f119514c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if ((!Intrinsics.areEqual(this.f119512a.a(), this.f119513b)) == false) goto L13;
            i r101 = this.f119512a;
            float r102 = this.f119513b;
            if (r101.f119427e == false) goto L9;
            View r103 = r101.f119425c;
            if (r103 == null) goto L13;
            r103.setAlpha(r102);
            goto L13
        L9:
            v70.c r104 = r101.f119424b;
            if (r104 == null) goto L13;
            r104.setAlpha(r102);
        L13:
            if (this.f119514c == false) goto L16;
            this.f119512a.e(8);
            return;
        L16:
            if (this.f119512a.c() == true) goto L20;
            this.f119512a.e(0);
            return;
        }

        public b(i r100, float r101, boolean r102) {
            this.f119512a = r100;
            this.f119513b = r101;
            this.f119514c = r102;
        }
    }

    public final long f() {
        return ((Number) this.f119504k.getValue()).longValue();
    }

    public final HashMap<ClearScreenConst$InteractType, jg1.a> g() {
        return (HashMap) this.f119507n.getValue();
    }

    public final boolean h() {
        return ((Boolean) this.f119506m.getValue()).booleanValue();
    }

    public final void m() {
        Iterator<T> r100 = this.f119496c.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        i r101 = (i) r100.next();
        ViewPropertyAnimator r102 = r101.f119428f;
        if (r102 == null) goto L8;
        r102.setListener(null);
    L8:
        ViewPropertyAnimator r103 = r101.f119428f;
        if (r103 == null) goto L4;
        r103.cancel();
        goto L4
    L11:
        this.f119496c.clear();
        this.f119498e.clear();
        this.f119497d.clear();
        this.f119495b.clear();
        this.f119500g.clear();
        this.f119499f.clear();
        if (wt2.a.g() == false) goto L14;
        HashMap<ClearScreenConst$InteractType, jg1.a> r104 = g();
        ClearScreenUtils$reset$2 r105 = ClearScreenUtils$reset$2.INSTANCE;
        CollectionsKt.removeAll(r104.entrySet(), r105);
    L15:
        int r106 = 0;
        this.f119494a = false;
        this.f119503j.clear();
        if (h() == false) goto L18;
        ALogger.i("ClearScreenManager", "CleanScreenUtils的reset方法");
    L18:
        int r107 = this.f119502i.size();
        int r108 = 0;
    L19:
        if (r108 >= r107) goto L21;
        int r109 = this.f119502i.keyAt(r108);
        this.f119502i.get(r109).clear();
        r108 = r108 + 1;
        goto L19
    L21:
        int r110 = this.f119501h.size();
    L22:
        if (r106 >= r110) goto L24;
        int r111 = this.f119501h.keyAt(r106);
        this.f119501h.get(r111).clear();
        r106 = r106 + 1;
        goto L22
    L24:
        return;
    L14:
        g().clear();
        goto L15
    }

    public ClearScreenUtils(String r100) {
        this.f119508o = r100;
        this.f119495b = new HashSet();
        this.f119496c = new HashSet();
        this.f119497d = new HashSet();
        this.f119498e = new HashSet();
        this.f119499f = new HashMap();
        this.f119500g = new HashMap();
        this.f119501h = new SparseArray();
        this.f119502i = new SparseArray();
        this.f119503j = new ArrayList();
        this.f119504k = LazyKt.lazy(ClearScreenUtils$animDuration$2.INSTANCE);
        this.f119506m = LazyKt.lazy(ClearScreenUtils$inTestChannel$2.INSTANCE);
        this.f119507n = LazyKt.lazy(ClearScreenUtils$clearAssistants$2.INSTANCE);
    }

    public final Pair<Boolean, ClearScreenConst$InteractType> b(boolean r100) {
        Iterator<jg1.a> r101 = g().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L25;
        jg1.a r102 = r101.next();
        if (r102 == null) goto L4;
        if (r102.e(new jg1.b.a()) != true) goto L4;
        if (r100 == false) goto L16;
        int r103 = gs1.a.f482437a;
        h r104 = gs1.a.a(this.f119508o);
        if (r104 == null) goto L14;
        r104.e(r102.getInteractType());
    L14:
        if (h() == false) goto L23;
        ALogger.d("ClearScreenManager", "被拦截，进入清屏，当前状态变为 " + r102.getInteractType());
    L23:
        return new Pair(Boolean.FALSE, r102.getInteractType());
    L16:
        int r105 = gs1.a.f482437a;
        h r106 = gs1.a.a(this.f119508o);
        if (r106 == null) goto L20;
        r106.e(ClearScreenConst$InteractType.INTERACT_SHOW);
    L20:
        if (h() == false) goto L23;
        ALogger.d("ClearScreenManager", "被拦截，退出清屏，当前状态变为 NON_CLEAR");
        goto L23
    L25:
        if (h() == false) goto L28;
        ALogger.d("ClearScreenManager", "没被拦截");
    L28:
        return new Pair(Boolean.TRUE, ClearScreenConst$InteractType.INTERACT_SHOW);
    }

    public final void i(boolean r100) {
        HashSet<i> r101 = this.f119495b;
        if (r101 == null) goto L25;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L39;
        i r103 = (i) r102.next();
        if (r100 == false) goto L10;
        int r104 = 8;
    L11:
        r103.e(r104);
        ViewPropertyAnimator r105 = r103.b();
        if (r105 == null) goto L6;
        if (r100 == false) goto L15;
        float r106 = 0.0f;
    L16:
        ViewPropertyAnimator r107 = r105.alpha(r106);
        if (r107 == null) goto L6;
        ViewPropertyAnimator r108 = r107.setListener(null);
        if (r108 == null) goto L6;
        ViewPropertyAnimator r109 = r108.setDuration(f());
        if (r109 == null) goto L6;
        ViewPropertyAnimator r110 = r109.setInterpolator(new g());
        if (r110 == null) goto L6;
        r110.start();
        goto L6
    L15:
        r106 = 1.0f;
        goto L16
    L10:
        r104 = 0;
        goto L11
    L39:
        return;
    }

    public final void p(float r100) {
        HashSet<i> r101 = this.f119496c;
        ArrayList r102 = new ArrayList();
        Iterator<i> r103 = r101.iterator();
    L3:
        boolean r104 = false;
        if (r103.hasNext() == false) goto L10;
        i r105 = r103.next();
        if (r105.f119426d != ClearScreenConst$AnimType.TRANS) goto L8;
        r104 = true;
    L8:
        if (r104 == false) goto L3;
        r102.add(r105);
        goto L3
    L10:
        Iterator r106 = r102.iterator();
    L12:
        if (r106.hasNext() == false) goto L34;
        i r107 = (i) r106.next();
        if (this.f119503j.size() == 0) goto L17;
        r107.d(this.f119503j);
    L17:
        if (r107.f119427e == false) goto L21;
        View r108 = r107.f119425c;
        if (r108 == null) goto L24;
        int r109 = r108.getLeft();
    L25:
        float r110 = r109 + r100;
        if (r107.f119427e == true) goto L27;
        v70.c r111 = r107.f119424b;
        if (r111 == null) goto L12;
        r111.setX(r110);
        goto L12
    L27:
        View r112 = r107.f119425c;
        if (r112 == null) goto L12;
        r112.setX(r110);
    L24:
        r109 = 0;
        goto L25
    L21:
        v70.c r113 = r107.f119424b;
        if (r113 == null) goto L24;
        r109 = r113.f553414a.getLeft();
        goto L25
    L34:
        if (this.f119503j.size() == 0) goto L52;
        ClearScreenLogUtils.Companion r114 = ClearScreenLogUtils.f119492a;
        ArrayList<String> r115 = this.f119503j;
        r114.getClass();
        ClearScreenLogUtils.Companion.g(r115);
        this.f119503j.clear();
        return;
    }

    public static boolean q(HashSet r100, i r101) {
        d90.d r102 = r101.f119431i;
        DataCenter r103 = null;
        if (r102 != null) goto L12;
        Element<?> r104 = r101.f119423a;
        if (r104 == null) goto L7;
        h70.b r105 = r104.f65669k;
    L9:
        if ((r105 instanceof d90.d) == true) goto L11;
        r105 = null;
    L11:
        r102 = (d90.d) r105;
        goto L12
    L7:
        r105 = null;
    L12:
        boolean r106 = false;
        if (r100.contains(r101) == true) goto L15;
    L46:
        ALogger.d("ClearScreenManager", "shouldClearWhenScan " + r106 + "， view:" + r101.f119429g);
        return r106;
    L15:
        if (gs1.b.f482438a == false) goto L46;
        if (r102 == null) goto L46;
        MiddlewareRoomContext r107 = d90.e.l(r102);
        if (r107 == null) goto L46;
        m<Integer> r108 = r107.getCleanMode();
        if (r108 == null) goto L46;
        Integer r109 = r108.getValue();
        if (r109 == null) goto L46;
        if (r109.intValue() == ClearScreenConst$InteractType.SCROLL_CLEAR.getId()) goto L26;
        boolean r110 = true;
    L27:
        if (r110 != true) goto L46;
        DataCenter r111 = r101.f119430h;
        if (r111 != null) goto L42;
        d90.d r112 = r101.f119431i;
        if (r112 != null) goto L40;
        Element<?> r113 = r101.f119423a;
        if (r113 == null) goto L35;
        h70.b r114 = r113.f65669k;
    L37:
        if ((r114 instanceof d90.d) == true) goto L39;
        r114 = null;
    L39:
        r112 = (d90.d) r114;
        goto L40
    L35:
        r114 = null;
    L40:
        if (r112 == null) goto L44;
        r103 = r112.f467480h;
    L44:
        if (ClearScreenHelper.i(r103) == false) goto L46;
        r106 = true;
        goto L46
    L42:
        r103 = r111;
        goto L44
    L26:
        r110 = false;
        goto L27
    }

    public final boolean c(i r100, SparseArray<HashSet<String>> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "map");
        String r102 = this.f119500g.get(r100);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        return false;
    L11:
        HashSet<String> r104 = r101.get(wt2.a.o());
        if (r104 == null) goto L19;
        Iterator<String> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(r102, r105.next()) == false) goto L15;
        return true;
    L19:
        return false;
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public final void k(int r100, j70.f r101) {
        Intrinsics.checkNotNullParameter(r101, "element");
        a(r100, r101, this.f119502i);
    }

    public final void l(int r100, j70.f r101) {
        Intrinsics.checkNotNullParameter(r101, "element");
        a(r100, r101, this.f119501h);
    }

    public static void a(int r100, j70.f r101, SparseArray r102) {
        Intrinsics.checkNotNullParameter(r101, "element");
        Intrinsics.checkNotNullParameter(r102, "map");
        if (r102.get(r100) != null) goto L5;
        r102.put(r100, new HashSet());
    L5:
        HashSet r103 = (HashSet) r102.get(r100);
        if (r103 == null) goto L9;
        r103.add(r101.f497558a);
        return;
    }

    public static boolean e(int r100, j70.f r101, SparseArray r102) {
        Intrinsics.checkNotNullParameter(r101, "elementType");
        Intrinsics.checkNotNullParameter(r102, "map");
        if (r102.get(r100) != null) goto L5;
        return false;
    L5:
        Object r103 = r102.get(r100);
        Intrinsics.checkNotNull(r103);
        if (((HashSet) r103).contains(r101.f497558a) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final void j(String r100, View r101, e0 r102) {
        Intrinsics.checkNotNullParameter(r100, "description");
        Intrinsics.checkNotNullParameter(r101, "view");
        i r103 = new i(r101, ClearScreenConst$AnimType.ALPHA, r100, r102);
        this.f119499f.put(r100, r103);
        this.f119500g.put(r103, r100);
    }

    public final void o(j70.f r100, View r101, e0 r102) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Intrinsics.checkNotNullParameter(r101, "view");
        i r103 = new i(r101, ClearScreenConst$AnimType.ALPHA, r100.f497558a, r102);
        this.f119499f.put(r100.f497558a, r103);
        this.f119500g.put(r103, r100.f497558a);
        int r104 = wt2.a.o();
        Intrinsics.checkNotNullParameter(r100, "elementType");
        if (e(r104, r100, this.f119502i) == false) goto L6;
        this.f119495b.add(r103);
    L6:
        if (q(this.f119495b, r103) == false) goto L9;
        r103.e(0);
        return;
    }

    public final void n(Element<?> r100, ClearScreenConst$AnimType r101, boolean r102, Function1<? super Element<?>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "element");
        Intrinsics.checkNotNullParameter(r101, "animType");
        Intrinsics.checkNotNullParameter(r103, "otherAddView");
        i r104 = new i(r100, r101);
        r104.f119432j = r102;
        this.f119499f.put(r100.f65662d.f497558a, r104);
        this.f119500g.put(r104, r100.f65662d.f497558a);
        int r105 = wt2.a.o();
        j70.f r106 = r100.f65662d;
        Intrinsics.checkNotNullParameter(r106, "elementType");
        if (e(r105, r106, this.f119501h) == true) goto L24;
        this.f119496c.add(r104);
        if (h() == false) goto L7;
        ALogger.d("ClearScreenManager", "当前添加元素为 " + r104.f119429g);
    L7:
        r103.invoke(r100);
        Room r107 = null;
        RoomContext r108 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r108 == null) goto L13;
        m<Room> r109 = r108.getRoom();
        if (r109 == null) goto L13;
        r107 = r109.getValue();
    L13:
        if (VrUtils.x(r107) == true) goto L15;
    L22:
        r104.e(0);
        goto L24
    L15:
        if (VrUtils.B() == false) goto L22;
        if (r108 == null) goto L22;
        m<Boolean> r110 = r108.getVrInImmersedMode();
        if (r110 == null) goto L22;
        if (r110.getValue().booleanValue() != true) goto L22;
        r104.e(8);
    L24:
        if (q(this.f119496c, r104) == false) goto L27;
        r104.e(8);
        return;
    }

    public final void d(i r100, float r110, boolean r111, boolean r112, ClearScreenConst$AnimType r113, long r114) {
        Intrinsics.checkNotNullParameter(r113, "animType");
        if (r100 == null) goto L7;
        List r101 = CollectionsKt.listOf(r100);
        if (r101 == null) goto L7;
        List r102 = r101;
    L8:
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L9:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L18;
        Object r106 = r104.next();
        i r107 = (i) r106;
        if (r112 == false) goto L14;
    L15:
        r105 = true;
    L16:
        if (r105 == false) goto L9;
        r103.add(r106);
        goto L9
    L14:
        if (r107.f119426d != r113) goto L16;
    L18:
        Iterator r108 = r103.iterator();
    L20:
        if (r108.hasNext() == false) goto L93;
        i r109 = (i) r108.next();
        boolean r115 = r109.f119432j;
        if (r115 == false) goto L31;
        if (r115 == false) goto L20;
        Element<?> r116 = r109.f119423a;
        if (r116 == null) goto L29;
        com.bytedance.android.live.room.api.visibilitycontrol.b r117 = (com.bytedance.android.live.room.api.visibilitycontrol.b) r116.f(com.bytedance.android.live.room.api.visibilitycontrol.b.class);
        if (r117 == null) goto L29;
        boolean r118 = r117.canControlByClearScreenService();
    L30:
        if (r118 == false) goto L20;
    L29:
        r118 = true;
    L31:
        ViewPropertyAnimator r119 = r109.b();
        if (r119 == null) goto L34;
        r119.cancel();
    L34:
        int r120 = com.bytedance.android.livesdk.clearscreen.utils.b.f119517a[r113.ordinal()];
        if (r120 != 1) goto L37;
        if (r111 == false) goto L59;
    L76:
        ViewPropertyAnimator r121 = r109.b();
        if (r121 == null) goto L91;
        if (r111 == false) goto L80;
        float r122 = r110;
    L81:
        ViewPropertyAnimator r123 = r121.translationX(r122);
        if (r123 == null) goto L91;
        ViewPropertyAnimator r124 = r123.setDuration(r114);
        if (r124 == null) goto L91;
        ViewPropertyAnimator r125 = r124.setInterpolator(new g());
        if (r125 == null) goto L91;
        ViewPropertyAnimator r126 = r125.setListener(new a(r109, this, r111));
        if (r126 == null) goto L91;
        r126.start();
        goto L91
    L80:
        r122 = 0.0f;
    L91:
        if (h() == false) goto L20;
        ALogger.i("ClearScreenManager", "当前要操作的元素内容 " + r109.f119429g + ", enableCustom: " + r112 + ", animType: " + r113.getId() + ", isClear: " + r111);
        goto L20
    L59:
        if (this.f119503j.size() == 0) goto L74;
        HashSet<i> r127 = this.f119496c;
        ArrayList r128 = new ArrayList();
        Iterator<i> r129 = r127.iterator();
    L62:
        if (r129.hasNext() == false) goto L69;
        i r130 = r129.next();
        if (r130.f119426d != ClearScreenConst$AnimType.TRANS) goto L66;
        boolean r131 = true;
    L67:
        if (r131 == false) goto L62;
        r128.add(r130);
        goto L62
    L66:
        r131 = false;
        goto L67
    L69:
        Iterator r132 = r128.iterator();
    L71:
        if (r132.hasNext() == false) goto L74;
        ((i) r132.next()).d(this.f119503j);
    L74:
        if (this.f119503j.size() == 0) goto L76;
        ClearScreenLogUtils.Companion r133 = ClearScreenLogUtils.f119492a;
        ArrayList<String> r134 = this.f119503j;
        r133.getClass();
        ClearScreenLogUtils.Companion.g(r134);
        this.f119503j.clear();
        goto L76
    L37:
        if (r120 != 2) goto L39;
        if (r111 == true) goto L46;
        r109.e(0);
    L46:
        float r135 = 1 - (r110 / x1.h());
        ViewPropertyAnimator r136 = r109.b();
        if (r136 == null) goto L91;
        ViewPropertyAnimator r137 = r136.alpha(r135);
        if (r137 == null) goto L91;
        ViewPropertyAnimator r138 = r137.setDuration(r114);
        if (r138 == null) goto L91;
        ViewPropertyAnimator r139 = r138.setInterpolator(new g());
        if (r139 == null) goto L91;
        ViewPropertyAnimator r140 = r139.setListener(new b(r109, r135, r111));
        if (r140 == null) goto L91;
        r140.start();
        goto L91
    L39:
        if (r120 != 3) goto L91;
        if (r111 == false) goto L43;
        r109.e(8);
        goto L91
    L43:
        r109.e(0);
        goto L91
    L93:
        return;
    L7:
        r102 = this.f119496c;
        goto L8
    }
}
