package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$GuideType;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst$InteractType;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;
import com.bytedance.android.livesdk.chatroom.widget.TapGuideView;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.w8;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widget.n3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/GestureGuideCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Ljo1/f;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GestureGuideCompositeWidget extends MiddlewareRoomWidget implements jo1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f113112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f113113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.c f113114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.ui.framework.d f113115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TapGuideView f113116e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureGuideCompositeWidget f113117a;

        public a(GestureGuideCompositeWidget r100) {
            this.f113117a = r100;
        }

        public final void a() {
            com.bytedance.android.livesdk.chatroom.ui.framework.c r100 = this.f113117a.f113114c;
            if (r100 == null) goto L5;
            Room r101 = r100.getRoom();
        L7:
            if (r101 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r102 = this.f113117a.f113114c;
            if (r102 == null) goto L11;
            Room r103 = r102.getRoom();
        L12:
            if (r103 == null) goto L16;
            if (r103.isVrRoom() != true) goto L16;
            return;
        L11:
            r103 = null;
        L16:
            DataCenter r104 = this.f113117a.dataCenter;
            if (r104 == null) goto L19;
            boolean r105 = ClearScreenHelper.h(r104);
        L20:
            if (r105 == false) goto L28;
            RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r106 == null) goto L27;
            com.bytedance.live.datacontext.m<Boolean> r107 = r106.isInZoom();
            if (r107 == null) goto L27;
            if (r107.getValue().booleanValue() == true) goto L28;
        L27:
            w8 r108 = new w8(n3.f161871a, s1.B(R.string.ttlive_clear_zoom_guide_text));
            r108.f160661e = 10L;
            r108.f160660d = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/clear_screen_scale_guide.webp";
            r108.f160657a = "live.pref.PREF_CLEARSCREEN_ZOOM_GUIDE";
            r108.f160658b = 1;
            xs2.b.a().post(r108);
        L28:
            ALogger.d("ZOOM_GUIDE_TAG", "发送LiveShowGuideEvent，展示Guide");
            return;
        L19:
            r105 = false;
            goto L20
        L5:
            r101 = null;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureGuideCompositeWidget f113118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SharedPrefHelper f113119b;

        public static final class a implements SlideGuideView.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f113120a;

            public a(b r100) {
                this.f113120a = r100;
            }

            @Override // com.bytedance.android.livesdk.chatroom.widget.SlideGuideView.e
            public final void onClick() {
                TapGuideView r100 = this.f113120a.f113118a.f113116e;
                boolean r101 = false;
                if (r100 == null) goto L5;
                r100.setClickable(false);
            L5:
                GestureGuideCompositeWidget.wq(this.f113120a.f113118a);
                int r102 = gs1.a.f482437a;
                DataCenter r103 = this.f113120a.f113118a.getDataCenter();
                if (r103 == null) goto L8;
                String r104 = com.bytedance.android.live.core.utils.a0.p(r103);
            L9:
                com.bytedance.android.livesdk.clearscreen.h r105 = gs1.a.a(r104);
                if (r105 == null) goto L18;
                com.bytedance.android.livesdk.chatroom.ui.framework.c r106 = this.f113120a.f113118a.f113114c;
                if (r106 != null) goto L14;
            L16:
                r105.c(r101);
                return;
            L14:
                if (r106.dg() != true) goto L16;
                r101 = true;
                goto L16
            L18:
                return;
            L8:
                r104 = null;
                goto L9
            }
        }

        public b(GestureGuideCompositeWidget r100, SharedPrefHelper r101) {
            this.f113118a = r100;
            this.f113119b = r101;
        }

        public final void a() {
            SharedPrefHelper r100 = this.f113119b;
            r100.l("live.pref.SHOW_CLEARSCREEN_MODE_CHECK_TIPS", 1);
            r100.a();
            GestureGuideCompositeWidget r101 = this.f113118a;
            ClearScreenConst$GuideType r102 = ClearScreenConst$GuideType.CLEAR_MODE_CHECK;
            a r103 = new a(this);
            if (r101.f113116e == null) goto L7;
            ViewGroup r104 = r101.xq();
            if (r104 == null) goto L7;
            r104.removeView(r101.f113116e);
        L7:
            Context r105 = r101.getContext();
            if (r105 == null) goto L49;
            Integer r106 = wt2.a.f561182a;
            TapGuideView r107 = new TapGuideView(r105);
            r101.f113116e = r107;
            r107.a(r102);
            int r108 = k.f113418a[r102.ordinal()];
            if (r108 != 1) goto L12;
            TapGuideView r109 = r101.f113116e;
            if (r109 == null) goto L23;
            r109.setMultiLine(true);
        L23:
            TapGuideView r110 = r101.f113116e;
            if (r110 == null) goto L26;
            r110.setAnimResourceGecko("tap_check_mode.zip");
        L26:
            RoomContext.a r111 = RoomContext.Companion;
            if (RoomContext.a.c(r111, null, 0, 3) == null) goto L37;
            RoomContext r112 = RoomContext.a.c(r111, null, 0, 3);
            if (r112 == null) goto L37;
            com.bytedance.live.datacontext.m<Integer> r113 = r112.getCleanMode();
            if (r113 == null) goto L37;
            if (r113.getValue().intValue() != ClearScreenConst$InteractType.PURE_CLEAR.getId()) goto L37;
            TapGuideView r114 = r101.f113116e;
            if (r114 == null) goto L40;
            r114.setDestText(s1.B(R.string.ttlive_clearscreen_pure2simple_tips));
        L40:
            TapGuideView r115 = r101.f113116e;
            if (r115 == null) goto L43;
            r115.e();
        L43:
            TapGuideView r116 = r101.f113116e;
            if (r116 == null) goto L46;
            r116.setClickListener(r103);
        L46:
            ViewGroup r117 = r101.xq();
            if (r117 == null) goto L49;
            r117.addView(r101.f113116e);
        L37:
            TapGuideView r118 = r101.f113116e;
            if (r118 == null) goto L40;
            r118.setDestText(s1.B(R.string.ttlive_clearscreen_simple2pure_tips));
            goto L40
        L12:
            if (r108 != 2) goto L40;
            ALogger.d("CLEAR_GUIDE_TAG", "展示清屏引导");
            TapGuideView r119 = r101.f113116e;
            if (r119 == null) goto L17;
            r119.setAnimResourceGecko("swipe_right.zip");
        L17:
            TapGuideView r120 = r101.f113116e;
            if (r120 == null) goto L40;
            r120.setDestText("");
        L49:
            long r121 = 5000;
            ViewGroup r122 = r101.xq();
            if (r122 == null) goto L53;
            r122.postDelayed(new l(r101), r121);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    public final ViewGroup xq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r100 = this.f113115d;
        if (r100 == null) goto L5;
        GestureDetectLayout r101 = r100.oh();
    L7:
        if ((r101 instanceof ViewGroup) == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r100 = getComponentContext();
        if (r100 == null) goto L5;
        ho1.a.p(r100, jo1.f.class, this);
    L5:
        this.f113114c = ho1.a.d(getComponentContext());
        this.f113115d = ho1.a.i(getComponentContext());
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        if (xq() != null) goto L5;
    L14:
        this.f113112a = null;
        this.f113113b = null;
        h70.b r100 = getComponentContext();
        if (r100 == null) goto L18;
        ho1.a.q(r100, jo1.f.class);
        return;
    L18:
        return;
    L5:
        if (this.f113112a == null) goto L10;
        ViewGroup r101 = xq();
        if (r101 == null) goto L10;
        r101.removeCallbacks(this.f113112a);
    L10:
        if (this.f113113b == null) goto L14;
        ViewGroup r102 = xq();
        if (r102 == null) goto L14;
        r102.removeCallbacks(this.f113113b);
        goto L14
    }

    public GestureGuideCompositeWidget() {
    }

    public static final void wq(GestureGuideCompositeWidget r100) {
        TapGuideView r101 = r100.f113116e;
        if (r101 == null) goto L7;
        r101.f();
        ViewGroup r102 = r100.xq();
        if (r102 == null) goto L7;
        r102.postDelayed(new m(r100), 320);
    L7:
        com.bytedance.android.livesdk.e.b().d();
        Integer r103 = wt2.a.f561182a;
    }

    @Override // jo1.f
    public final void J5(int r100) {
        if (r100 != 8) goto L19;
        Lazy r101 = ClearScreenHelper.f119484a;
        if (ClearScreenHelper.h(this.dataCenter) == false) goto L19;
        if (SharedPrefHelper.b(getContext()).h("live.pref.PREF_CLEARSCREEN_ZOOM_GUIDE", 0) == 0) goto L9;
    L25:
        if (r100 != 8) goto L49;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r102 = this.f113114c;
        if (r102 == null) goto L31;
        boolean r103 = true;
        if (r102.dg() != true) goto L31;
    L33:
        if (wt2.a.e(Boolean.valueOf(r103)) == false) goto L49;
        if (wt2.a.c() == false) goto L49;
        SharedPrefHelper r104 = SharedPrefHelper.b(getContext());
        if (r104.h("live.pref.SHOW_CLEARSCREEN_MODE_CHECK_TIPS", 0) == 0) goto L39;
        return;
    L39:
        if (xq() != null) goto L41;
    L45:
        this.f113112a = new b(this, r104);
        ViewGroup r105 = xq();
        if (r105 == null) goto L57;
        r105.postDelayed(this.f113112a, 6000);
        return;
    L57:
        return;
    L41:
        if (this.f113112a == null) goto L45;
        ViewGroup r106 = xq();
        if (r106 == null) goto L45;
        r106.removeCallbacks(this.f113112a);
    L31:
        r103 = false;
    L49:
        if (xq() != null) goto L51;
        return;
    L51:
        if (this.f113112a == null) goto L60;
        ViewGroup r107 = xq();
        if (r107 == null) goto L61;
        r107.removeCallbacks(this.f113112a);
        return;
    L61:
        return;
    L60:
        return;
    L9:
        if (xq() != null) goto L11;
    L15:
        this.f113113b = new a(this);
        ViewGroup r108 = xq();
        if (r108 == null) goto L25;
        r108.postDelayed(this.f113113b, 30000);
        goto L25
    L11:
        if (this.f113113b == null) goto L15;
        ViewGroup r109 = xq();
        if (r109 == null) goto L15;
        r109.removeCallbacks(this.f113113b);
    L19:
        if (xq() == null) goto L25;
        if (this.f113113b == null) goto L25;
        ViewGroup r110 = xq();
        if (r110 == null) goto L25;
        r110.removeCallbacks(this.f113113b);
        goto L25
    }
}
