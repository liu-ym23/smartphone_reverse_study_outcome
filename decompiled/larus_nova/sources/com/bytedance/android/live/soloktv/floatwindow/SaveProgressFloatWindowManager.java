package com.bytedance.android.live.soloktv.floatwindow;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.timeline.SoloKtvTimelineManager;
import com.bytedance.android.live.soloktv.util.l;
import com.bytedance.android.live.soloktv.util.r;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.jh1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class SaveProgressFloatWindowManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f101076k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f101077l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f101078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.soloktv.floatwindow.b f101079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f101080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f101081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SoloKtvTimelineManager f101082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f101083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function3<Boolean, String, String, Unit> f101084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f101085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<Integer, Unit> f101086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function2<String, Long, Unit> f101087j;

    public static final class a extends com.bytedance.android.live.soloktv.floatwindow.c {
        public a() {
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            a r101 = SaveProgressFloatWindowManager.f101076k;
            if (b.a().f101080c == false) goto L6;
            b.a().d(null);
            return;
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
        public final void appEnterBackground(boolean r100, boolean r101) {
            a r102 = SaveProgressFloatWindowManager.f101076k;
            if (b.a().f101080c == false) goto L8;
            com.bytedance.android.live.soloktv.floatwindow.b r103 = b.a().f101079b;
            if (r103 == null) goto L9;
            UtilityKotlinExtentionsKt.t(r103);
            return;
        L9:
            return;
        }
    }

    public static final class b {
        public static SaveProgressFloatWindowManager a() {
            return (SaveProgressFloatWindowManager) SaveProgressFloatWindowManager.f101077l.getValue();
        }
    }

    public static final class c implements njc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SaveProgressFloatWindowManager f101088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f101089b;

        @Override // njc.a
        public final void onCompleted() {
            ALogger.i(bb0.b.b(), "SaveProgressFloatWindowManager :export onCompleted, invoke class :".concat(c.class.getSimpleName()));
            SaveProgressFloatWindowManager r100 = this.f101088a;
            a r101 = SaveProgressFloatWindowManager.f101076k;
            r100.c(true, null, null);
            String r102 = rm3.c.f538539a;
            rm3.c.d(this.f101089b, R.string.ttlive_solo_ktv_export_success, R.drawable.ttlive_solo_ktv_export_success_ic);
        }

        public c(SaveProgressFloatWindowManager r100, Context r101) {
            this.f101088a = r100;
            this.f101089b = r101;
        }

        @Override // njc.a
        public final void a(int r100, String r101, Throwable r102) {
            String r103 = "export onFailed: code=" + r100 + ", msg=" + r101 + ", throwable=" + Log.getStackTraceString(r102);
            ALogger.i(bb0.b.b(), "SaveProgressFloatWindowManager :" + r103 + ", invoke class :" + c.class.getSimpleName());
            this.f101088a.c(false, r101, VSConstants.EXTRA_SHOW_MSG_BOARD_FROM_PASSIVE_ACTION);
            String r104 = rm3.c.f538539a;
            rm3.c.d(this.f101089b, R.string.ttlive_solo_ktv_export_failed, R.drawable.ttlive_solo_ktv_export_fail_ic);
        }
    }

    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f101090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f101091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f101092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f101093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f101094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f101095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f101096g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ObjectAnimator f101097h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ SaveProgressFloatWindowManager f101098i;

        public d(SaveProgressFloatWindowManager r100) {
            this.f101098i = r100;
            int r101 = s1.f(60);
            int r102 = s1.f(12) + s1.f(72);
            float r103 = 16;
            int r104 = s1.f(r103) + s1.f(54);
            this.f101093d = s1.A() + r101;
            this.f101094e = s1.w() - r102;
            this.f101095f = s1.f(r103);
            this.f101096g = s1.y() - r104;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r101, "event");
            int r102 = r101.getAction();
            if (r102 == 0) goto L46;
            float r103 = 0.0f;
            if (r102 == 1) goto L32;
            if (r102 != 2) goto L8;
            com.bytedance.android.live.soloktv.floatwindow.b r104 = this.f101098i.f101079b;
            if (r104 == null) goto L13;
            float r105 = r104.getY();
        L14:
            float r106 = (r105 + r101.getY()) - this.f101091b;
            if (r106 >= this.f101093d) goto L17;
        L21:
            com.bytedance.android.live.soloktv.floatwindow.b r107 = this.f101098i.f101079b;
            if (r107 == null) goto L24;
            r103 = r107.getX();
        L24:
            float r108 = (r103 + r101.getX()) - this.f101090a;
            if (r108 >= this.f101095f) goto L27;
        L49:
            return true;
        L27:
            if (r108 > this.f101096g) goto L49;
            com.bytedance.android.live.soloktv.floatwindow.b r109 = this.f101098i.f101079b;
            if (r109 == null) goto L49;
            r109.setX(r108);
            goto L49
        L17:
            if (r106 > this.f101094e) goto L21;
            com.bytedance.android.live.soloktv.floatwindow.b r110 = this.f101098i.f101079b;
            if (r110 == null) goto L21;
            r110.setY(r106);
            goto L21
        L13:
            r105 = 0.0f;
            goto L14
        L8:
            if (r102 != 3) goto L49;
        L32:
            if (Math.abs(r101.getRawY() - this.f101092c) > 3.0f) goto L34;
            r100.performClick();
            goto L49
        L34:
            int r111 = s1.y() / 2;
            com.bytedance.android.live.soloktv.floatwindow.b r112 = this.f101098i.f101079b;
            if (r112 == null) goto L37;
            float r113 = r112.getX();
        L38:
            float r114 = r111;
            if (r113 <= r114) goto L41;
            int r115 = this.f101096g;
            int r116 = s1.f(16);
        L42:
            int r117 = r115 - r116;
            com.bytedance.android.live.soloktv.floatwindow.b r118 = this.f101098i.f101079b;
            if (r118 == null) goto L45;
            r103 = r118.getX();
        L45:
            float r119 = r117;
            float r120 = (Math.abs(r103 - r119) / r114) * 400;
            ObjectAnimator r121 = ObjectAnimator.ofFloat(this.f101098i.f101079b, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r119});
            r121.setDuration((long) r120);
            r121.start();
            Unit r122 = Unit.INSTANCE;
            this.f101097h = r121;
            goto L49
        L41:
            r115 = this.f101095f;
            r116 = s1.f(16);
            goto L42
        L37:
            r113 = 0.0f;
            goto L38
        L46:
            this.f101090a = r101.getX();
            this.f101091b = r101.getY();
            this.f101092c = r101.getRawY();
            ObjectAnimator r123 = this.f101097h;
            if (r123 == null) goto L49;
            r123.cancel();
            goto L49
        }
    }

    static {
        f101076k = new a();
        f101077l = LazyKt.lazy(SaveProgressFloatWindowManager$Companion$instance$2.INSTANCE);
    }

    public SaveProgressFloatWindowManager() {
        this.f101083f = new d(this);
        this.f101084g = new SaveProgressFloatWindowManager$releaseFloatWindowCB$1(this);
        this.f101085h = new SaveProgressFloatWindowManager$cancelExportCB$1(this);
        this.f101086i = new SaveProgressFloatWindowManager$updateProgressCB$1(this);
        this.f101087j = new SaveProgressFloatWindowManager$publishOrSaveDraftCB$1(this);
    }

    public final void d(Activity r100) {
        f101076k.getClass();
        if (this.f101079b != null) goto L9;
        com.bytedance.android.live.soloktv.floatwindow.b r101 = new com.bytedance.android.live.soloktv.floatwindow.b(jc1.a.b());
        this.f101079b = r101;
        r101.c();
        com.bytedance.android.live.soloktv.floatwindow.b r102 = this.f101079b;
        if (r102 == null) goto L7;
        r102.setOnTouchListener(this.f101083f);
    L7:
        if (r100 == null) goto L9;
        this.f101080c = true;
        com.bytedance.android.live.soloktv.floatwindow.d.a(r100);
    L9:
        com.bytedance.android.live.soloktv.floatwindow.b r103 = this.f101079b;
        if (r103 == null) goto L13;
        UtilityKotlinExtentionsKt.w(r103);
        return;
    }

    public final void a(Context r100, Bitmap r101) {
        com.bytedance.android.live.soloktv.floatwindow.b r102 = this.f101079b;
        if (r102 == null) goto L14;
        Bitmap r103 = r102.b(r101);
        if (r103 == null) goto L9;
        HSImageView r104 = r102.f101101c;
        if (r104 == null) goto L9;
        r104.setImageBitmap(r103);
    L9:
        Bitmap r105 = r102.b(r101);
        if (r105 == null) goto L14;
        HSImageView r106 = r102.f101102d;
        if (r106 == null) goto L14;
        r106.setImageBitmap(r105);
    L14:
        com.bytedance.android.live.soloktv.floatwindow.b r107 = this.f101079b;
        if (r107 == null) goto L17;
        r107.setCancelListener(new SaveProgressFloatWindowManager$export$1(this));
    L17:
        this.f101081d = System.currentTimeMillis();
        SoloKtvTimelineManager r108 = this.f101082e;
        if (r108 == null) goto L21;
        c r109 = new c(this, r100);
        int r110 = SoloKtvTimelineManager.f101467u;
        r108.f(r109, true, null);
        return;
    }

    public final void b(Context r110, Bitmap r111, l.b r112) {
        Intrinsics.checkNotNullParameter(r112, "state");
        SoloKtvContext.Companion.getClass();
        n<MusicPanel> r100 = SoloKtvContext.a.a().getCurMusicPanel();
        String r101 = "";
        if (r100 == null) goto L27;
        MusicPanel r102 = r100.getValue();
        if (r102 == null) goto L27;
        if ((r112 instanceof l.b.a) == false) goto L10;
        String r103 = "publish";
    L13:
        cb1.a r104 = cb1.a.f22994a;
        String r105 = SoloKtvContext.a.a().getFromSource();
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        Intrinsics.checkNotNullParameter(r105, "enterFrom");
        Intrinsics.checkNotNullParameter(r103, "buttonType");
        LinkedHashMap r106 = new LinkedHashMap();
        KtvMusic r107 = r102.f153577a;
        if (r107 == null) goto L20;
        String r108 = String.valueOf(r107.getMId());
        if (r108 == null) goto L20;
    L21:
        r106.put("song_id", r108);
        KtvMusic r109 = r102.f153577a;
        if (r109 == null) goto L25;
        String r113 = r109.getMTitle();
        if (r113 == null) goto L25;
    L26:
        r106.put("song_name", r113);
        r106.put("enter_from", r105);
        r106.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r103);
        cb1.a.A(r106);
        j0.l().sendLog("livesdk_solo_enter_video_edit_page_click", r106, new Object[0]);
    L25:
        r113 = "";
    L20:
        r108 = "";
        goto L21
    L10:
        if ((r112 instanceof l.b.C1546b) == false) goto L12;
        r103 = "save_draft";
        goto L13
    L12:
        r103 = "";
    L27:
        com.bytedance.android.live.soloktv.floatwindow.b r114 = this.f101079b;
        if (r114 == null) goto L39;
        Bitmap r115 = r114.b(r111);
        if (r115 == null) goto L34;
        HSImageView r116 = r114.f101101c;
        if (r116 == null) goto L34;
        r116.setImageBitmap(r115);
    L34:
        Bitmap r117 = r114.b(r111);
        if (r117 == null) goto L39;
        HSImageView r118 = r114.f101102d;
        if (r118 == null) goto L39;
        r118.setImageBitmap(r117);
    L39:
        com.bytedance.android.live.soloktv.floatwindow.b r119 = this.f101079b;
        if (r119 == null) goto L42;
        r119.setCancelListener(new SaveProgressFloatWindowManager$publishOrSaveToDraft$2(this));
    L42:
        this.f101081d = System.currentTimeMillis();
        n<MusicPanel> r120 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r120 == null) goto L66;
        MusicPanel r121 = r120.getValue();
        if (r121 == null) goto L67;
        IMiddlewareUserService r122 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r122 == null) goto L54;
        e r123 = r122.user();
        if (r123 == null) goto L54;
        IBaseUser r124 = r123.b();
        if (r124 == null) goto L54;
        String r125 = r124.getIdString();
        if (r125 == null) goto L54;
    L55:
        String r126 = r121.f153577a.getMAuthor();
        if (r126 != null) goto L58;
        r126 = "";
    L58:
        String r127 = String.valueOf(r121.f153577a.getId());
        String r128 = r121.f153577a.getMTitle();
        if (r128 == null) goto L62;
        r101 = r128;
    L62:
        l.a r129 = new l.a(r126, r127, r101, r125);
        List<jh1> r130 = l.f101618a;
        SoloKtvTimelineManager r131 = this.f101082e;
        Function3<Boolean, String, String, Unit> r132 = this.f101084g;
        Function1<Integer, Unit> r133 = this.f101086i;
        Function2<String, Long, Unit> r134 = this.f101087j;
        Intrinsics.checkNotNullParameter(r112, "state");
        Intrinsics.checkNotNullParameter(r132, "releaseFloatWindowCB");
        Intrinsics.checkNotNullParameter(r133, "updateProgressCB");
        Intrinsics.checkNotNullParameter(r134, "publishOrSaveDraftCB");
        l.f101622e = r129;
        l.f101621d = r112;
        if (r131 == null) goto L68;
        r131.f(new r(r132, r110, r133), false, r134);
        return;
    L68:
        return;
    L54:
        r125 = "";
        goto L55
    L67:
        return;
    }

    public final void c(boolean r110, String r111, String r112) {
        if (this.f101080c == true) goto L5;
        return;
    L5:
        SoloKtvContext.Companion.getClass();
        n<MusicPanel> r100 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r100 == null) goto L20;
        MusicPanel r101 = r100.getValue();
        if (r101 == null) goto L20;
        if (r110 == false) goto L12;
        cb1.a r113 = cb1.a.f22994a;
        long r102 = System.currentTimeMillis() - this.f101081d;
        Intrinsics.checkNotNullParameter(r101, "music");
        HashMap r114 = new HashMap();
        r114.put("from_request_type", r101.f153580d);
        cb1.a.z(r114, r101);
        r114.put("duration", String.valueOf(r102));
        j0.l().sendLog("livesdk_solo_ktv_save_duration", r114, new Object[]{IRoom.class});
        String r115 = "1";
    L13:
        cb1.a r103 = cb1.a.f22994a;
        Intrinsics.checkNotNullParameter(r101, "music");
        Intrinsics.checkNotNullParameter(r115, "saveResult");
        HashMap r104 = new HashMap();
        r104.put("from_request_type", r101.f153580d);
        cb1.a.z(r104, r101);
        r104.put("save_result", r115);
        if (r111 != null) goto L16;
        r111 = "";
    L16:
        r104.put("fail_reason", r111);
        if (r112 != null) goto L19;
        r112 = "";
    L19:
        r104.put(BdpAppEventConstant.PARAMS_FAIL_TYPE, r112);
        j0.l().sendLog("livesdk_solo_ktv_save_result", r104, new Object[]{IRoom.class});
        goto L20
    L12:
        r115 = "0";
    L20:
        ALogger.i(bb0.b.b(), "releaseFloatWindow, invoke class :".concat(SaveProgressFloatWindowManager.class.getSimpleName()));
        SoloKtvTimelineManager r116 = this.f101082e;
        if (r116 == null) goto L23;
        r116.e();
    L23:
        this.f101080c = false;
        com.bytedance.android.live.soloktv.floatwindow.b r117 = this.f101079b;
        if (r117 == null) goto L26;
        UtilityKotlinExtentionsKt.t(r117);
    L26:
        FrameLayout.LayoutParams r118 = com.bytedance.android.live.soloktv.floatwindow.d.f101104a;
        com.bytedance.android.live.soloktv.floatwindow.b r119 = b.a().f101079b;
        if (r119 != null) goto L30;
    L37:
        this.f101079b = null;
        this.f101082e = null;
        this.f101081d = 0;
        this.f101078a = null;
        return;
    L30:
        if (r119.getParent() == null) goto L37;
        ViewParent r120 = r119.getParent();
        if ((r120 instanceof ViewGroup) == true) goto L34;
        r120 = null;
    L34:
        ViewGroup r121 = (ViewGroup) r120;
        if (r121 == null) goto L37;
        r121.removeView(r119);
        goto L37
    }
}
