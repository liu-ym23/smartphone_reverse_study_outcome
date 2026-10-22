package com.bytedance.android.live.liveinteract.animation.universalwidget.effect;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import ca0.h;
import ca0.i;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.ttvideoengine.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import org.json.JSONArray;
import org.json.JSONObject;
import rj0.l;
import uf2.d0;
import vm2.k;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Random f71336i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f71337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f71338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<bd0.b> f71339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f71340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f71341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final cd0.a f71342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f71343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f71344h;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.animation.universalwidget.effect.a$a, reason: collision with other inner class name */
    public static final class C1152a {
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f71345a;

        public b(a r100) {
            this.f71345a = r100;
        }

        @Override // ca0.h
        public final void onResult(int r100) {
            this.f71345a.f71341e.g(true);
        }
    }

    public static final class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f71346a;

        public c(a r100) {
            this.f71346a = r100;
        }

        @Override // ca0.h
        public final void onResult(int r100) {
            this.f71346a.f71341e.g(false);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f71347a;

        public d(a r100) {
            this.f71347a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DataCenter r100 = this.f71347a.f71343g;     // Catch: Throwable -> L10
            if (r100 == null) goto L5;
            nh0.f r101 = (nh0.f) r100.get("data_multi_link_dynamic_layout_info_change");     // Catch: Throwable -> L10
        L6:
            DataCenter r102 = this.f71347a.f71343g;     // Catch: Throwable -> L10
            if (r102 == null) goto L13;
            r102.put("data_multi_link_dynamic_layout_info_change", r101);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L5:
            r101 = null;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class e implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f71348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f71349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f71350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1 f71351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f71352e;

        @Override // ca0.h
        public final void onResult(int r110) {
            ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.f71349b + ". Enable onResult:" + r110);
            boolean r100 = true;
            if (this.f71350c == false) goto L27;
            Pair<Integer, Integer> r111 = this.f71348a.d();
            vc0.a r101 = this.f71348a.a();
            if (r101 == null) goto L7;
            Object r102 = r101.f554080b;
        L9:
            if ((r102 instanceof d0) == true) goto L11;
            r102 = null;
        L11:
            d0 r103 = (d0) r102;
            if (r103 == null) goto L14;
            View r104 = r103.Y();
        L16:
            if ((r104 instanceof SurfaceView) == true) goto L18;
            r104 = null;
        L18:
            SurfaceView r105 = (SurfaceView) r104;
            i r106 = this.f71348a.f71341e;
            if (r105 == null) goto L21;
            int r107 = r105.getMeasuredWidth();
        L22:
            if (r105 == null) goto L24;
            int r108 = r105.getMeasuredHeight();
        L25:
            r106.k(r107, r108, true);
            ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.f71349b + ". Enable use LiveCore, setMixOutput:" + r111);
            goto L27
        L24:
            r108 = r111.getSecond().intValue();
            goto L25
        L21:
            r107 = r111.getFirst().intValue();
            goto L22
        L14:
            r104 = null;
            goto L16
        L7:
            r102 = null;
        L27:
            if (((ArrayList) this.f71348a.f71339c).isEmpty() == true) goto L38;
            Iterator r112 = ((ArrayList) this.f71348a.f71339c).iterator();
        L30:
            if (r112.hasNext() == false) goto L36;
            bd0.b r109 = (bd0.b) r112.next();
            float r113 = 0;
            if (r109.f18626d <= r113) goto L35;
            if (r109.f18627e > r113) goto L30;
        L35:
            boolean r114 = false;
        L37:
            if (r114 == false) goto L38;
        L42:
            if (((ArrayList) this.f71348a.f71339c).isEmpty() == true) goto L44;
        L48:
            List<bd0.b> r115 = this.f71348a.f71339c;
            JSONObject r116 = new JSONObject();
            JSONArray r117 = new JSONArray();
            Iterator r118 = ((ArrayList) r115).iterator();
        L50:
            if (r118.hasNext() == false) goto L52;
            bd0.b r119 = (bd0.b) r118.next();
            r119.getClass();
            JSONObject r120 = new JSONObject();
            r120.put("areaKey", r119.f18623a);
            r120.put("x", Float.valueOf(r119.f18624b));
            r120.put("y", Float.valueOf(r119.f18625c));
            r120.put("w", Float.valueOf(r119.f18626d));
            r120.put("h", Float.valueOf(r119.f18627e));
            r117.put(r120);
            goto L50
        L52:
            r116.put("LiveGrids", r117);
            String r121 = r116.toString();
            this.f71348a.f71341e.j(r121, this.f71350c);
            ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.f71349b + ". Enable setRenderCacheStringValue:" + r121);
            this.f71351d.invoke(Boolean.TRUE);
            boolean r122 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a;
            if (this.f71352e == 1) goto L56;
            r100 = false;
        L56:
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a = r100;
            return;
        L44:
            if (((Boolean) k.f556328h.getValue(null, k.f556321a[6])).booleanValue() == true) goto L47;
            ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.f71349b + ". Enable mStreamRegions is empty.", new Throwable());
            this.f71351d.invoke(Boolean.FALSE);
            boolean r123 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a;
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a = false;
            return;
        L47:
            ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.f71349b + ". Enable mStreamRegions is empty. do not return", new Throwable());
            goto L48
        L36:
            r114 = true;
        L38:
            cd0.a r124 = this.f71348a.f71342f;
            if (r124 == null) goto L42;
            r124.Kc();
            goto L42
        }

        public e(a r100, long r101, boolean r102, Function1 r103, int r104) {
            this.f71348a = r100;
            this.f71349b = r101;
            this.f71350c = r102;
            this.f71351d = r103;
            this.f71352e = r104;
        }
    }

    public static final class f implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f71353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f71354b;

        public f(long r100, Function1 r101) {
            this.f71353a = r100;
            this.f71354b = r101;
        }

        @Override // ca0.h
        public final void onResult(int r100) {
            ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + this.f71353a + ". Disable onResult:" + r100);
            this.f71354b.invoke(Boolean.TRUE);
            boolean r101 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a;
            com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a = false;
        }
    }

    public static final class g implements ca0.f {
        public g(long r100) {
        }
    }

    static {
        f71336i = RandomKt.Random(System.currentTimeMillis());
    }

    public final vc0.a a() {
        if (this.f71340d == false) goto L13;
        com.bytedance.android.live.liveinteract.plantform.base.a.f75481g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r100 = com.bytedance.android.live.liveinteract.plantform.base.a.C1183a.a();
        if (r100 == null) goto L44;
        hg6.g r101 = r100.R1();
        if (r101 == null) goto L44;
        ec6.b r102 = r101.R();
        if (r102 == null) goto L44;
        com.bytedance.android.live.pushstream.d r103 = gc6.b.a(r102);
        if (r103 == null) goto L44;
        d0 r104 = r103.getLiveCore();
    L45:
        if (r104 != null) goto L48;
        return null;
    L48:
        return new vc0.a(r104);
    L44:
        r104 = null;
        goto L45
    L13:
        l.f537955n2.getClass();
        l r105 = l.a.a();
        if (r105 == null) goto L18;
        com.bytedance.android.live.pushstream.d r106 = r105.getLiveStream();
        if (r106 == null) goto L18;
        d0 r107 = r106.getLiveCore();
    L20:
        if (r107 == null) goto L22;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "acquireLiveCoreInstance not null");
    L22:
        l r108 = l.a.a();
        if (r108 == null) goto L27;
        com.bytedance.android.live.pushstream.d r109 = r108.getLiveStream();
        if (r109 == null) goto L27;
        r104 = r109.getLiveCore();
    L28:
        com.bytedance.android.live.liveinteract.plantform.base.b.f75483h0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.b r110 = com.bytedance.android.live.liveinteract.plantform.base.b.a.a();
        if (r110 == null) goto L37;
        hg6.g r111 = r110.P2();
        if (r111 == null) goto L37;
        ec6.b r112 = r111.R();
        if (r112 == null) goto L37;
        com.bytedance.android.live.pushstream.d r113 = gc6.b.a(r112);
        if (r113 == null) goto L37;
        d0 r114 = r113.getLiveCore();
    L38:
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "acquireLiveCoreInstance " + r104 + ' ' + r114 + " null null");
        if (r104 != null) goto L41;
        r104 = r114;
    L41:
        if (r104 != null) goto L43;
        r104 = null;
    L43:
        if (r104 != null) goto L45;
    L37:
        r114 = null;
    L27:
        r104 = null;
    L18:
        r107 = null;
        goto L20
    }

    public final void b() {
        i r100 = this.f71341e;
        if (r100 == null) goto L5;
        i.a.a(r100, false, null, new b(this), true, null, 48);
    L5:
        i r101 = this.f71341e;
        if (r101 == null) goto L8;
        i.a.a(r101, false, null, new c(this), false, null, 48);
    L8:
        boolean r102 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c() {
        if (this.f71340d == true) goto L11;
        Integer r100 = (Integer) hd0.c.f().f481009b;
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.intValue() != 2) goto L10;
    L11:
        return true;
    }

    public final Pair<Integer, Integer> d() {
        ViewGroup r100 = (ViewGroup) this.f71344h.findViewById(R.id.single_input_mode_container);
        View r101 = this.f71344h.findViewById(R.id.surface_view_container);
        int r102 = 0;
        if (r100.getChildCount() <= 0) goto L5;
        r101 = r100.getChildAt(0);
    L5:
        if (r101 == null) goto L7;
        int r103 = r101.getHeight();
    L8:
        if (r101 == null) goto L10;
        r102 = r101.getWidth();
    L10:
        if (r103 <= 0) goto L12;
        if (r102 <= 0) goto L12;
    L21:
        return TuplesKt.to(Integer.valueOf(r102), Integer.valueOf(r103));
    L12:
        r103 = ScreenUtils.getScreenHeight();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L15;
    L19:
        r102 = ScreenUtils.getScreenWidth();
        goto L21
    L15:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L19;
        Context r104 = s1.getContext();
        if (r104 == null) goto L19;
        r103 = r103 - StatusBarUtil.getStatusBarHeight(r104);
        goto L19
    L7:
        r103 = 0;
        goto L8
    }

    public a(boolean r100, i r101, cd0.a r102, DataCenter r103, ViewGroup r104) {
        Intrinsics.checkNotNullParameter(r104, "mLinkRootView");
        this.f71340d = r100;
        this.f71341e = r101;
        this.f71342f = r102;
        this.f71343g = r103;
        this.f71344h = r104;
        this.f71338b = "";
        this.f71339c = new ArrayList();
    }

    public final void e(boolean r110, int r111, String r112, boolean r210, Function1<? super Boolean, Unit> r211) {
        Intrinsics.checkNotNullParameter(r112, "scene");
        Intrinsics.checkNotNullParameter(r211, "cb");
        long r100 = f71336i.nextLong();
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r100 + ". enable:" + r110);
        boolean r113 = false;
        if (this.f71341e != null) goto L7;
        ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r100 + ". failed, effect interface is null.", new Throwable());
        boolean r101 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a = false;
        r211.invoke(Boolean.FALSE);
        return;
    L7:
        if (r210 == true) goto L27;
        if (r110 == false) goto L18;
        if (this.f71338b.length() <= 0) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L16;
        r211.invoke(Boolean.FALSE);
        return;
    L16:
        this.f71338b = r112;
    L30:
        boolean r114 = c();
        if (r114 == false) goto L41;
        ALogger.i("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r100 + ". Use LiveCore.");
        vc0.a r103 = a();
        if (((Boolean) k.f556328h.getValue(null, k.f556321a[6])).booleanValue() == true) goto L38;
        if (r103 != null) goto L37;
        ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r100 + ". failed, LiveCore instance is null.", new Throwable());
        r211.invoke(Boolean.FALSE);
        boolean r104 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.a.f79070a = false;
        return;
    L37:
        this.f71341e.e(r103);
        goto L41
    L38:
        if (r103 != null) goto L40;
        ALogger.e("MicseatMixer#MultiLinkEffectManager", "setEffectEnable.session:" + r100 + ". failed, LiveCore instance is null. do not return", new Throwable());
        goto L41
    L40:
        this.f71341e.e(r103);
    L41:
        if (r110 == false) goto L43;
        i.a.a(this.f71341e, true, new g(r100), new e(this, r100, r114, r211, r111), r114, r112, 32);
    L44:
        i r105 = this.f71341e;
        if (r111 != 1) goto L47;
        r113 = true;
    L47:
        r105.m(r113, r114, r112, r210);
        this.f71344h.post(new d(this));
        return;
    L43:
        this.f71341e.l(false, null, new f(r100, r211), r114, r112, r210);
        goto L44
    L12:
        r102 = false;
        goto L13
    L18:
        if (this.f71338b.length() <= 0) goto L20;
        boolean r115 = true;
    L21:
        if (r115 == true) goto L23;
    L26:
        this.f71338b = "";
        goto L30
    L23:
        if ((!Intrinsics.areEqual(this.f71338b, r112)) == false) goto L26;
        r211.invoke(Boolean.FALSE);
        return;
    L20:
        r115 = false;
        goto L21
    L27:
        if (r110 == false) goto L29;
        this.f71338b = r112;
        goto L30
    L29:
        this.f71338b = "";
        goto L30
    }
}
