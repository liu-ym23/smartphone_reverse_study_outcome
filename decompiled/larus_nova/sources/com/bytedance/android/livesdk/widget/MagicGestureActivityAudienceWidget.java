package com.bytedance.android.livesdk.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.camera.core.RetryPolicy;
import androidx.camera.video.AudioStats;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.config.bg1;
import com.bytedance.android.livesdk.config.v91;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.MobConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/widget/MagicGestureActivityAudienceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/widget/h0;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MagicGestureActivityAudienceWidget extends LiveRecyclableWidget implements h0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f161203i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f161204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y1 f161205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GestureDetectLayout f161206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Room f161207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f161208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f161209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f161210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f161211h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f161212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f161213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f161214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f161215d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f161216e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f161217f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f161218g;

        public b() {
            this.f161212a = "";
            this.f161217f = "";
            this.f161218g = "0";
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.widget.h0
    public final void T7() {
        ALogger.e("MagicGestureActivityAudienceWidget", "magicActivity is running ");
        int r100 = this.f161208e.f161213b;
        if (r100 != 1) goto L5;
    L6:
        ILiveService r101 = TTLiveService.getLiveService();
        if (r101 == null) goto L9;
        r101.handleSchema(getContext(), UriProtector.parse(this.f161208e.f161212a));
    L9:
        xq("livesdk_activity_gesture_click");
    L10:
        GestureDetectLayout r102 = this.f161206c;
        if (r102 == null) goto L14;
        r102.removeView(this.f161205b);
        return;
    L14:
        return;
    L5:
        if (r100 != 2) goto L10;
        goto L6
    }

    public final void yq() {
        if (v91.f121430a.getValue().booleanValue() == false) goto L23;
        y1 r100 = this.f161205b;
        if (r100 == null) goto L7;
        r100.f162260a = this.f161204a;
    L7:
        ViewParent r101 = null;
        if (r100 == null) goto L10;
        ViewParent r102 = r100.getParent();
    L11:
        if (r102 == null) goto L19;
        y1 r103 = this.f161205b;
        if (r103 == null) goto L15;
        r101 = r103.getParent();
    L15:
        if (r101 == null) goto L18;
        ((ViewGroup) r101).removeView(this.f161205b);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L19:
        GestureDetectLayout r104 = this.f161206c;
        if (r104 == null) goto L24;
        r104.addView(this.f161205b);
        return;
    L24:
        return;
    L10:
        r102 = null;
        goto L11
    }

    public MagicGestureActivityAudienceWidget() {
        this.f161208e = new b();
        this.f161211h = bg1.b();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), h0.class);
        Disposable r100 = this.f161210g;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.h0
    public final boolean mb(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Rect r101 = this.f161204a;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.contains((int) r100.getX(), (int) r100.getY());
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f161205b = new y1(getContext());
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L6;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), h0.class, this);
        return;
    }

    public final void xq(String r100) {
        HashMap r101 = new HashMap();
        r101.put("user_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        Room r102 = this.f161207d;
        Long r103 = null;
        if (r102 == null) goto L7;
        IUser r104 = r102.author();
        if (r104 == null) goto L7;
        String r105 = r104.getIdString();
    L8:
        r101.put("anchor_id", r105);
        Room r106 = this.f161207d;
        if (r106 == null) goto L11;
        r103 = Long.valueOf(r106.f162599id);
    L11:
        r101.put("room_id", String.valueOf(r103));
        r101.put("gesture_id", this.f161208e.f161217f);
        com.bytedance.android.livesdk.log.u.l().sendLog(r100, r101, new Object[0]);
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.widget.h0
    public final void w7(String r110, GestureDetectLayout r210, Room r211) {
        Intrinsics.checkNotNullParameter(r110, "sei");
        Intrinsics.checkNotNullParameter(r210, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r211, "room");
    L69:
        e = move-exception;
        ALogger.e("MagicGestureActivityAudienceWidget", e);
        return;
    L4:
        Integer r111 = null;
        int r112 = 0;
        if (this.f161211h == true) goto L8;
    L10:
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L69
        JSONObject r113 = LiveSeiUtil.c(r110).optJSONObject("magic_gesture_activity_sei");     // Catch: Exception -> L69
        if (r113 == null) goto L73;
        ALogger.e("MagicGestureActivityAudienceWidget", "seiData:".concat(r110));     // Catch: Exception -> L69
        wq(r113, r210, r211);     // Catch: Exception -> L69
        if (com.bytedance.android.live.base.model.user.q0.a(r211.getOwnerUserIdString()) == true) goto L15;
    L67:
        ALogger.e("MagicGestureActivityAudienceWidget", "processMagicData room.ownerUserId " + r211.getOwnerUserIdString() + "，mMagicGestureData.anchorId " + this.f161208e.f161218g);     // Catch: Exception -> L69
        return;
    L15:
        if (Intrinsics.areEqual(r211.getOwnerUserIdString(), this.f161208e.f161218g) == false) goto L67;
        boolean r100 = true;
        if (r113.optInt("status") != 1) goto L61;
        int r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();     // Catch: Exception -> L69
        ALogger.e("MagicGestureActivityAudienceWidget", "linkMode:" + r101);     // Catch: Exception -> L69
        if (gd0.v.a(r101, 4) == false) goto L21;
    L43:
        boolean r102 = gd0.v.a(r101, 4);     // Catch: Exception -> L69
        if (r102 == false) goto L46;
        int r103 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().G().f524848b;     // Catch: Exception -> L69
    L47:
        if (r102 == false) goto L49;
        int r104 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().G().f524849c;     // Catch: Exception -> L69
    L50:
        if (r102 == false) goto L52;
        int r105 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().G().f524847a;     // Catch: Exception -> L69
    L53:
        ALogger.e("MagicGestureActivityAudienceWidget", "pkTopY: " + r105);     // Catch: Exception -> L69
        double r106 = (double) r103;     // Catch: Exception -> L69
        b r107 = this.f161208e;     // Catch: Exception -> L69
        r112 = (int) (r106 * r107.f161214c);     // Catch: Exception -> L69
        int r108 = r105 + ((int) (((double) r104) * r107.f161215d));     // Catch: Exception -> L69
        int r109 = r107.f161216e;     // Catch: Exception -> L69
        int r114 = r109 / 2;     // Catch: Exception -> L69
        int r115 = r109 / 2;     // Catch: Exception -> L69
        ALogger.e("MagicGestureActivityAudienceWidget", "连麦情况下：pointX：" + r112 + " pointY：" + r108 + "radiusX： " + r114 + "radiusY： " + r115);     // Catch: Exception -> L69
        int r116 = r108;
        int r117 = r114;
        int r118 = r115;
    L54:
        this.f161204a = new Rect(r112 - r117, r116 - r118, r112 + r117, r116 + r118);     // Catch: Exception -> L69
        yq();     // Catch: Exception -> L69
        if (Intrinsics.areEqual(this.f161208e.f161217f, this.f161209f) == false) goto L57;
        return;
    L57:
        this.f161209f = this.f161208e.f161217f;     // Catch: Exception -> L69
        Disposable r119 = this.f161210g;     // Catch: Exception -> L69
        if (r119 == null) goto L60;
        r119.dispose();     // Catch: Exception -> L69
    L60:
        this.f161210g = Observable.timer(RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new z1(this), a2.f161412a);     // Catch: Exception -> L69
        xq("livesdk_activity_gesture_show");     // Catch: Exception -> L69
        return;
    L52:
        r105 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiAnchorServiceExternal().b().a();     // Catch: Exception -> L69
        goto L53
    L49:
        r104 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiAnchorServiceExternal().b().getVideoHeight();     // Catch: Exception -> L69
        goto L50
    L46:
        r103 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiAnchorServiceExternal().b().getVideoWidth();     // Catch: Exception -> L69
        goto L47
    L21:
        if (gd0.v.a(r101, 64) == true) goto L23;
    L25:
        boolean r120 = false;
    L26:
        if (r120 == true) goto L43;
        if (r101 != 0) goto L30;
    L33:
        if (r100 == false) goto L42;
        GestureDetectLayout r121 = this.f161206c;     // Catch: Exception -> L69
        if (r121 == null) goto L37;
        Integer r122 = Integer.valueOf(r121.getWidth());     // Catch: Exception -> L69
    L38:
        Intrinsics.checkNotNull(r122);     // Catch: Exception -> L69
        r112 = (int) (((double) r122.intValue()) * this.f161208e.f161214c);     // Catch: Exception -> L69
        GestureDetectLayout r123 = this.f161206c;     // Catch: Exception -> L69
        if (r123 == null) goto L41;
        r111 = Integer.valueOf(r123.getHeight());     // Catch: Exception -> L69
    L41:
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L69
        double r124 = r111.intValue();     // Catch: Exception -> L69
        b r125 = this.f161208e;     // Catch: Exception -> L69
        r116 = (int) (r124 * r125.f161215d);     // Catch: Exception -> L69
        r117 = r125.f161216e;     // Catch: Exception -> L69
        ALogger.e("MagicGestureActivityAudienceWidget", "单人情况下： mPointX：" + r112 + "mPointY：" + r116 + "mRadius： " + this.f161208e.f161216e);     // Catch: Exception -> L69
        r118 = r117;
        goto L54
    L37:
        r122 = null;
        goto L38
    L42:
        r117 = 0;
        r116 = 0;
        r118 = 0;
        goto L54
    L30:
        if (gd0.v.a(r101, 2) == true) goto L33;
        r100 = false;
        goto L33
    L23:
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiAnchorServiceExternal().g() != 2) goto L25;
        r120 = true;
        goto L26
    L61:
        ALogger.e("MagicGestureActivityAudienceWidget", "magic status is 0, clear click rect");     // Catch: Exception -> L69
        Disposable r126 = this.f161210g;     // Catch: Exception -> L69
        if (r126 == null) goto L64;
        r126.dispose();     // Catch: Exception -> L69
    L64:
        ALogger.e("MagicGestureActivityAudienceWidget", "clearMagicClickRect is running ");     // Catch: Exception -> L69
        this.f161204a = null;     // Catch: Exception -> L69
        this.f161209f = null;     // Catch: Exception -> L69
        GestureDetectLayout r127 = this.f161206c;     // Catch: Exception -> L69
        if (r127 == null) goto L75;
        r127.removeView(this.f161205b);     // Catch: Exception -> L69
        return;
    L75:
        return;
    L73:
        return;
    L8:
        if (StringsKt.contains$default(r110, "magic_gesture_activity_sei", false, 2, null) == true) goto L10;
    }

    public final void wq(JSONObject r100, GestureDetectLayout r101, Room r110) {
        b r102 = this.f161208e;
        String r103 = r100.optString(MobConstants.EFFECT_ID);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f161217f = r103;
        b r104 = this.f161208e;
        r104.f161213b = r100.optInt("action_type");
        b r105 = this.f161208e;
        String r106 = r100.optString("action_schema");
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f161212a = r106;
        b r107 = this.f161208e;
        r107.f161214c = r100.optDouble("point_x", AudioStats.AUDIO_AMPLITUDE_NONE);
        b r108 = this.f161208e;
        r108.f161215d = r100.optDouble("point_y", AudioStats.AUDIO_AMPLITUDE_NONE);
        b r109 = this.f161208e;
        r109.f161216e = r100.optInt("radius", 0);
        b r111 = this.f161208e;
        String r112 = com.bytedance.android.live.base.model.user.o0.a.e(com.bytedance.android.live.base.model.user.o0.f58946a, r100, "anchor_id");
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r111.f161218g = r112;
        this.f161206c = r101;
        this.f161207d = r110;
    }
}
