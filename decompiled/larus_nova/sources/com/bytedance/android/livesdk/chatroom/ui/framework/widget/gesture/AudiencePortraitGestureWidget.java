package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.ui.x7;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.b41;
import com.bytedance.android.livesdk.config.c41;
import com.bytedance.android.livesdk.config.rs0;
import com.bytedance.android.livesdk.config.xk;
import com.bytedance.android.livesdk.config.zp0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.i4;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdk.widget.h0;
import com.bytedance.android.livesdk.widget.y;
import com.bytedance.android.livesdk.widgetdescriptor.data.FlingViewModel;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import zg1.h1;
import zg1.s;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/AudiencePortraitGestureWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/GestureWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePortraitGestureWidget extends GestureWidget {
    public static final /* synthetic */ int F = 0;
    public double A;
    public boolean B;
    public boolean C;
    public LiveVerticalViewPager D;
    public Disposable E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View.OnTouchListener f113348z;

    public static final class a {
    }

    public static final class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudiencePortraitGestureWidget f113349a;

        public b(AudiencePortraitGestureWidget r100) {
            this.f113349a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            AudiencePortraitGestureWidget r102 = this.f113349a;
            int r103 = AudiencePortraitGestureWidget.F;
            h70.b r104 = r102.getComponentContext();
            iy.d r105 = null;
            if (r104 == null) goto L5;
            gd0.k r106 = ho1.a.k(r104);
        L6:
            if (r106 == null) goto L8;
            r106.a(r100, r101);
        L8:
            h70.b r107 = this.f113349a.getComponentContext();
            if (r107 == null) goto L11;
            r105 = ho1.a.a(r107);
        L11:
            if (r105 == null) goto L15;
            r105.a(r100, r101);
            return false;
        L15:
            return false;
        L5:
            r106 = null;
            goto L6
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            xs2.b.a().post(new s(true));
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            xs2.b.a().post(new s(false));
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void er() {
        this.f113348z = null;
    }

    public AudiencePortraitGestureWidget() {
        this.f113348z = new b(this);
        this.A = 1.0d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Yq() {
        View r100 = Gq();
        if (r100 != null) goto L5;
        return;
    L5:
        float r101 = r100.getX();
        float r102 = r100.getWidth();
        b41 r103 = c41.f119922a;
        if (r103.b() == false) goto L8;
        float r104 = r103.d();
    L10:
        if (r101 < (r102 / r104)) goto L12;
        mr(200, 0.0f);
        return;
    L12:
        mr(-1.0f, 0.0f);
        return;
    L8:
        r104 = 2.0f;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        RoomContext r100 = Iq();
        LiveVerticalViewPager r101 = null;
        if (r100 == null) goto L10;
        this.E = r100.getGestureLayoutBehaviorEvent().onEvent().subscribe(new com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.c(this), com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.d.f113390a);
        List<gh1.a> r102 = r100.getStickyBehaviorEvents();
        r100.setStickyBehaviorEvents(null);
        if (r102 == null) goto L10;
        int r103 = r102.size();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        nr((gh1.a) ListProtector.get(r102, r104));
        r104 = r104 + 1;
    L10:
        super.onCreate();
        Double r105 = zp0.f121783a.getValue();
        if (r105.doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        return;
    L13:
        if (r105.doubleValue() >= 180.0d) goto L21;
        this.A = Math.tan(Math.toRadians(90.0d - (r105.doubleValue() / ((double) 2))));
        this.B = true;
        GestureDetectLayout r106 = this.f113354d;
        if (r106 == null) goto L17;
        r101 = jr(r106);
    L17:
        this.D = r101;
        return;
    }

    public final boolean or() {
        RoomContext r100 = Iq();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getRoom().getValue().isVrRoom() == true) goto L32;
        DataCenter r101 = this.dataCenter;
        if (r101 == null) goto L24;
        ym0.a r102 = (ym0.a) r101.get("cmd_current_camera_info", null);
        if (r102 == null) goto L24;
        if (r102.c() != 1) goto L16;
        boolean r103 = true;
    L18:
        if (r102.d() != 1) goto L20;
        boolean r104 = true;
    L21:
        if (r104 == true) goto L24;
        if (r103 == false) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == true) goto L32;
        if (pm1.f.l() == null) goto L31;
        nm1.m r106 = pm1.f.l();
        Intrinsics.checkNotNull(r106);
        if (r106.J(this.dataCenter) == true) goto L32;
    L31:
        boolean r107 = false;
    L33:
        if (r107 == true) goto L35;
        return false;
    L35:
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r108 = LiveVrContext.c.a();
        if (r108 != null) goto L38;
        return false;
    L38:
        boolean r109 = r108.isVrSensorOpen().getValue().booleanValue();
        DataCenter r110 = this.dataCenter;
        if (r110 != null) goto L41;
    L43:
        boolean r111 = false;
    L45:
        if (SettingKeyUtils.d() == true) goto L47;
    L49:
        boolean r112 = false;
    L50:
        if (r112 == false) goto L53;
        if (r111 == true) goto L53;
        boolean r113 = true;
    L55:
        if (VrUtils.h() == true) goto L62;
        if (r107 == false) goto L79;
        if (r109 == false) goto L59;
        if (r112 == true) goto L59;
        return false;
    L59:
        if (r113 == true) goto L81;
        return true;
    L81:
        return false;
    L79:
        return false;
    L62:
        if (r111 == false) goto L74;
        if (VrUtils.h() == true) goto L66;
    L70:
        boolean r114 = false;
    L71:
        if (r114 == false) goto L74;
        return r107;
    L66:
        if (VrUtils.m() != VrUtils.VRGestureDragType.NO_GESTURE_DRAG_VIEW_CLEANSCREEN_ONLY.getType()) goto L68;
    L69:
        r114 = true;
        goto L71
    L68:
        if (VrUtils.m() != VrUtils.VRGestureDragType.NO_GESTURE_DRAG_VIEW_ALWAYS.getType()) goto L70;
    L74:
        if (VrUtils.j() == false) goto L82;
        if (r107 == false) goto L83;
        if (r109 == true) goto L84;
        return true;
    L84:
        return false;
    L83:
        return false;
    L82:
        return false;
    L53:
        r113 = false;
        goto L55
    L47:
        if (SettingKeyUtils.c() == false) goto L49;
        r112 = true;
        goto L50
    L41:
        if (((Boolean) r110.get("data_hide_screen", Boolean.FALSE)).booleanValue() == false) goto L43;
        r111 = true;
        goto L45
    L20:
        r104 = false;
        goto L21
    L16:
        r103 = false;
    L24:
        r105 = false;
    L32:
        r107 = true;
        goto L33
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final View.OnTouchListener Fq() {
        return this.f113348z;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean D8(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        h70.b r101 = getComponentContext();
        h0 r102 = null;
        if (r101 == null) goto L5;
        h0 r103 = ho1.a.l(r101);
    L6:
        if (r103 == null) goto L17;
        if (r103.mb(r100) != true) goto L17;
        ALogger.e("GestureWidget", "onDiggTap isMagicClick is true ");
        h70.b r104 = getComponentContext();
        if (r104 == null) goto L12;
        r102 = ho1.a.l(r104);
    L12:
        if (r102 == null) goto L18;
        r102.T7();
        return false;
    L18:
        return false;
    L17:
        return super.D8(r100);
    L5:
        r103 = null;
        goto L6
    }

    public final LiveVerticalViewPager jr(ViewGroup r100) {
        if ((r100 instanceof LiveVerticalViewPager) == true) goto L5;
        ViewParent r101 = r100.getParent();
        if (r101 != null) goto L9;
        return null;
    L9:
        if ((r101 instanceof View) == true) goto L11;
        return null;
    L11:
        return jr((ViewGroup) r101);
    L5:
        return (LiveVerticalViewPager) r100;
    }

    public final void kr(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewPropertyAnimator r101 = r100.animate();
        if (ClearScreenHelper.c() == false) goto L7;
        r101.alpha(0.0f);
    L8:
        r101.setDuration(200).setInterpolator(new com.bytedance.android.live.core.widget.g()).start();
        return;
    L7:
        View r102 = Gq();
        Intrinsics.checkNotNull(r102);
        r101.x(r102.getWidth());
        goto L8
    }

    public final void lr(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewPropertyAnimator r101 = r100.animate();
        if (ClearScreenHelper.c() == false) goto L7;
        r101.alpha(1.0f);
    L8:
        r101.setDuration(200).setInterpolator(new com.bytedance.android.live.core.widget.g()).start();
        return;
    L7:
        r101.x(0.0f);
        goto L8
    }

    public final void nr(gh1.a r100) {
        if (r100 == null) goto L15;
        y r101 = r100.f481248b;
        if (r101 == null) goto L16;
        GestureDetectLayout r102 = this.f113354d;
        if (r102 == null) goto L17;
        int r103 = r100.f481247a;
        if (r103 != 1) goto L12;
        if (r102 == null) goto L18;
        r102.a(r101);
        return;
    L18:
        return;
    L12:
        if (r103 != 2) goto L20;
        r102.d(r101);
        return;
    L20:
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Cq(float r100, float r101) {
        if (r100 <= 0) goto L8;
        jo1.e r102 = Eq();
        if (r102 == null) goto L9;
        r102.da(r101);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q
    public final void I4(boolean r100, boolean r101) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r102 = this.f113351a;
        View r103 = null;
        if (r102 == null) goto L5;
        Fragment r104 = r102.getFragment();
    L6:
        Intrinsics.checkNotNull(r104);
        View r105 = Gq();
        Intrinsics.checkNotNull(r105);
        if (r100 == true) goto L9;
        ((FlingViewModel) ViewModelProviders.of(r104).get(FlingViewModel.class)).getStatus().setValue(new FlingViewModel.a(true, 0.0f, r101));
        com.bytedance.android.livesdk.chatroom.ui.framework.d r106 = this.f113352b;
        if (r106 == null) goto L36;
        View r107 = r106.A8();
    L37:
        lr(r107);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r108 = this.f113352b;
        if (r108 == null) goto L40;
        r103 = r108.de();
    L40:
        lr(r103);
        return;
    L36:
        r107 = null;
        goto L37
    L9:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == false) goto L25;
        int r109 = gs1.a.f482437a;
        com.bytedance.android.livesdk.clearscreen.h r110 = gs1.a.a(a0.p(getDataCenter()));
        if (r110 == null) goto L25;
        if (r110.g() == true) goto L25;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r111 = this.f113353c;
        if (r111 == null) goto L19;
        Intrinsics.checkNotNullParameter(r111, "$this$getClearScreenWaterInterface");
        Element<?> r112 = r111.w8(d90.d.a.H0);
        if (r112 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.tetris.portrait.a r113 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r112.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L20:
        if (r113 == null) goto L22;
        r113.l();
    L22:
        com.bytedance.android.livesdk.clearscreen.h r114 = gs1.a.a(a0.p(getDataCenter()));
        if (r114 == null) goto L25;
        r114.f((e0) getComponentContext());
    L19:
        r113 = null;
    L25:
        ((FlingViewModel) ViewModelProviders.of(r104).get(FlingViewModel.class)).getStatus().setValue(new FlingViewModel.a(false, r105.getWidth(), r101));
        com.bytedance.android.livesdk.chatroom.ui.framework.d r115 = this.f113352b;
        if (r115 == null) goto L28;
        View r116 = r115.A8();
    L29:
        kr(r116);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r117 = this.f113352b;
        if (r117 == null) goto L32;
        r103 = r117.de();
    L32:
        kr(r103);
        return;
    L28:
        r116 = null;
        goto L29
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.bytedance.android.livesdk.chatroom.tetris.portrait.a] */
    /* JADX WARN: Type inference failed for: r15v9 */
    public final boolean mr(float r110, float r111) {
        if (((Boolean) this.dataCenter.get("live_zoom_and_lock_notify", Boolean.FALSE)).booleanValue() == false) goto L6;
        return false;
    L6:
        if (isRecording() == false) goto L9;
        return false;
    L9:
        if (Sq() == true) goto L11;
    L17:
        boolean r100 = RTLUtil.isAppRTL(getContext());
        View r101 = Gq();
        Intrinsics.checkNotNull(r101);
        Room r102 = getRoom();
        Intrinsics.checkNotNull(r102);
        RoomContext r103 = Iq();
        int r104 = r101.getWidth();
        if (r100 == false) goto L21;
        r104 = -r104;
    L21:
        if (r100 == true) goto L23;
    L24:
        if (r100 == false) goto L26;
    L28:
        boolean r105 = false;
    L30:
        if (r111 != 0.0f) goto L32;
        boolean r112 = true;
    L33:
        ALogger.d("LiveDrawerContainerDialog", "onAudienceFling, isFromActionUp: " + r112 + ", flingRight: " + r105);
        if (r105 == false) goto L36;
    L38:
        boolean r113 = false;
    L40:
        if (fr() == false) goto L45;
        float r106 = r104;
        if (r101.getX() == r106) goto L44;
        I4(true, false);
        r101.setX(r106);
    L44:
        return false;
    L45:
        if (r105 == false) goto L47;
    L49:
        boolean r114 = false;
    L50:
        boolean r115 = or();
        if (r114 == false) goto L53;
    L56:
        if (r115 == false) goto L59;
    L57:
        return false;
    L59:
        if (r105 == true) goto L61;
    L118:
        if (r113 == false) goto L171;
        if (r112 == false) goto L121;
    L124:
        if (r103 == null) goto L134;
        com.bytedance.live.datacontext.n<IExternalConfigJudger> r107 = r103.getExternalConfigJudger();
        if (r107 == null) goto L134;
        IExternalConfigJudger r108 = r107.getValue();
        if (r108 == null) goto L134;
        if (r108.disable(EXTERNAL_CONFIG_TYPE.Gesture, GestureAction.rightScroll) != true) goto L134;
        return false;
    L134:
        if (r101.getX() != 0) goto L136;
        boolean r116 = true;
    L137:
        if (r116 == true) goto L171;
        I4(false, false);
        getActivity();
        r102.getId();
        r101.animate().x(0.0f).setDuration(c41.a()).setInterpolator(new com.bytedance.android.live.core.widget.g()).setListener(new d()).start();
        if (pX() == false) goto L149;
        h70.b r109 = getComponentContext();
        if (r109 == null) goto L145;
        IAbilityCenter r117 = r109.a();
        if (r117 == null) goto L145;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r118 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r117.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L146:
        if (r118 == null) goto L148;
        r118.sq(false);
    L148:
        ClearScreenLogUtils.Companion r119 = ClearScreenLogUtils.f119492a;
        DataCenter r120 = this.dataCenter;
        r119.getClass();
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r121 = null;
        ClearScreenLogUtils.Companion.f(r120, "draw", null);
        com.bytedance.android.livesdk.chatroom.utils.p.f114578b.getClass();
        com.bytedance.android.livesdk.chatroom.utils.p.a.a("draw");
    L150:
        h70.b r122 = getComponentContext();
        if (r122 == null) goto L155;
        IAbilityCenter r123 = r122.a();
        if (r123 == null) goto L155;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r124 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r123.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L156:
        if (r124 == null) goto L158;
        r124.F5(0);
    L158:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r125 = this.f113353c;
        if (r125 == null) goto L163;
        Intrinsics.checkNotNullParameter(r125, "$this$getClearScreenWaterInterface");
        Element<?> r126 = r125.w8(d90.d.a.H0);
        if (r126 == null) goto L163;
        ?? r127 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r126.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L164:
        if (r127 != 0) goto L166;
    L169:
        this.dataCenter.put("data_hide_screen", Boolean.valueOf(pX()));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r128 = com.bytedance.android.livesdk.sharedpref.b.V;
        Boolean r129 = Boolean.valueOf(pX());
        r128.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r128, r129);
        return true;
    L166:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == true) goto L168;
        r127.t(8);
        goto L169
    L168:
        r127.i();
    L163:
        r127 = r121;
    L155:
        r124 = r121;
    L145:
        r118 = null;
        goto L146
    L149:
        r121 = null;
        goto L150
    L136:
        r116 = false;
        goto L137
    L121:
        if (Math.abs(r110) >= 200) goto L124;
        return false;
    L171:
        jo1.e r130 = Eq();
        if (r130 != null) goto L174;
        return false;
    L174:
        if (r130.Uf(r101.getTranslationX(), r105, r110) != true) goto L178;
        return true;
    L178:
        return false;
    L61:
        if (Pq() == true) goto L63;
    L66:
        if (r103 == null) goto L76;
        com.bytedance.live.datacontext.n<IExternalConfigJudger> r131 = r103.getExternalConfigJudger();
        if (r131 == null) goto L76;
        IExternalConfigJudger r132 = r131.getValue();
        if (r132 == null) goto L76;
        if (r132.disable(EXTERNAL_CONFIG_TYPE.Gesture, GestureAction.rightScroll) != true) goto L76;
        return false;
    L76:
        if (r112 == false) goto L78;
    L81:
        float r133 = r104;
        if (r101.getX() != r133) goto L84;
        boolean r134 = true;
    L85:
        if (r134 == true) goto L118;
        I4(true, false);
        getActivity();
        r102.getId();
        r101.animate().x(r133).setDuration(c41.a()).setInterpolator(new com.bytedance.android.live.core.widget.g()).setListener(new c()).start();
        if (pX() == true) goto L97;
        h70.b r135 = getComponentContext();
        if (r135 == null) goto L93;
        IAbilityCenter r136 = r135.a();
        if (r136 == null) goto L93;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r137 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r136.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L94:
        if (r137 == null) goto L96;
        r137.sq(true);
    L96:
        ClearScreenLogUtils.Companion r138 = ClearScreenLogUtils.f119492a;
        DataCenter r139 = this.dataCenter;
        r138.getClass();
        ClearScreenLogUtils.Companion.d(r139, "draw", null);
        com.bytedance.android.livesdk.chatroom.utils.p.f114578b.getClass();
        com.bytedance.android.livesdk.chatroom.utils.p.f114577a = System.currentTimeMillis();
    L93:
        r137 = null;
    L97:
        h70.b r140 = getComponentContext();
        if (r140 == null) goto L102;
        IAbilityCenter r141 = r140.a();
        if (r141 == null) goto L102;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b r142 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b) r141.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b.class);
    L103:
        if (r142 == null) goto L105;
        r142.F5(8);
    L105:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r143 = this.f113353c;
        if (r143 == null) goto L110;
        Intrinsics.checkNotNullParameter(r143, "$this$getClearScreenWaterInterface");
        Element<?> r144 = r143.w8(d90.d.a.H0);
        if (r144 == null) goto L110;
        com.bytedance.android.livesdk.chatroom.tetris.portrait.a r145 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r144.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L111:
        if (r145 != null) goto L113;
    L116:
        this.dataCenter.put("data_hide_screen", Boolean.valueOf(pX()));
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r146 = com.bytedance.android.livesdk.sharedpref.b.V;
        Boolean r147 = Boolean.valueOf(pX());
        r146.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r146, r147);
        return true;
    L113:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == true) goto L115;
        r145.t(0);
        goto L116
    L115:
        r145.i();
    L110:
        r145 = null;
    L102:
        r142 = null;
        goto L103
    L84:
        r134 = false;
        goto L85
    L78:
        if (Math.abs(r110) >= 200) goto L81;
        return false;
    L63:
        if (wt2.a.d(Boolean.valueOf(isAnchor())) == false) goto L66;
        f2.b(R.string.ttlive_guest_block_screen_clear_tips, 0);
        ALogger.e("GestureWidget", "rejected screen clean for pure clean mode");
        mr(-1.0f, 0.0f);
        return true;
    L53:
        if (wt2.a.b(Boolean.valueOf(isAnchor())) == false) goto L57;
        if (ClearScreenHelper.a() == true) goto L57;
    L47:
        if (r101.getTranslationX() != 0.0f) goto L49;
        r114 = true;
        goto L50
    L36:
        if (r101.getTranslationX() <= 0) goto L38;
        r113 = true;
        goto L40
    L32:
        r112 = false;
        goto L33
    L26:
        if (r110 <= 0) goto L28;
    L27:
        r105 = true;
        goto L30
    L23:
        if (r110 < 0) goto L27;
    L11:
        if (g1() == false) goto L17;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.f162412e == false) goto L17;
        if (Tq() == true) goto L17;
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final boolean Zq(MotionEvent r100, MotionEvent r101, float r102, float r110) {
        if (((Boolean) this.dataCenter.get("live_zoom_and_lock_notify", Boolean.FALSE)).booleanValue() == false) goto L5;
        return false;
    L5:
        if (r100 == null) goto L24;
        if (r101 == null) goto L24;
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        boolean r104 = true;
        Logger.d("GestureWidget", String.format("onFling, Event1={%f, %f}, Event2={%f, %f}, deltaX=%f, deltaY=%f, velocityX=%f, velocityY=%f", Arrays.copyOf(new Object[]{Float.valueOf(r100.getX()), Float.valueOf(r100.getY()), Float.valueOf(r101.getX()), Float.valueOf(r101.getY()), Float.valueOf(r100.getX() - r101.getX()), Float.valueOf(r100.getY() - r101.getY()), Float.valueOf(r102), Float.valueOf(r110)}, 8)));
        float r105 = r101.getX() - r100.getX();
        float r106 = r101.getY() - r100.getY();
        float r107 = 100;
        if (Math.abs(r105) >= r107) goto L11;
    L13:
        boolean r108 = false;
    L15:
        if (Math.abs(r106) >= r107) goto L17;
    L19:
        r104 = false;
    L20:
        Logger.d("GestureWidget", "onFling" + r105 + r106 + r108 + r104);
        if (r108 == false) goto L24;
        return mr(r105, r102);
    L17:
        if (Math.abs(r110) < r107) goto L19;
    L11:
        if (Math.abs(r102) < r107) goto L13;
        r108 = true;
    L24:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.GestureWidget
    public final void Wq(float r110, float r111, float r112, float r113, float r210) {
        if (((Boolean) this.dataCenter.get("live_zoom_and_lock_notify", Boolean.FALSE)).booleanValue() == false) goto L5;
        return;
    L5:
        float r100 = r112 - r110;
        float r101 = r113 - r110;
        float r102 = r210 - r111;
        LiveVerticalViewPager r103 = this.D;
        RoomContext r104 = Iq();
        View r105 = Gq();
        Intrinsics.checkNotNull(r105);
        if (r103 != null) goto L8;
    L10:
        boolean r106 = false;
    L11:
        b41 r114 = c41.f119922a;
        if (r114.b() == true) goto L14;
    L16:
        boolean r115 = false;
    L17:
        if (r115 == false) goto L33;
        if (r103 == null) goto L33;
        if (this.B == false) goto L46;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r116 = this.f113351a;
        if (r116 == null) goto L24;
        boolean r117 = r116.isNestedOutside();
    L25:
        if (r117 == true) goto L46;
        if (r106 == true) goto L46;
        if (r100 >= 0) goto L46;
        if (Math.abs(r102) < (((double) Math.abs(r101)) * r103.getTanValue())) goto L46;
        return;
    L24:
        r117 = false;
    L46:
        if (Sq() == false) goto L55;
        if (g1() == false) goto L55;
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.f162412e == false) goto L55;
        if (Tq() == true) goto L55;
        return;
    L55:
        if (com.bytedance.android.livesdk.clearscreen.utils.e.d(this.dataCenter, getRoom()) == false) goto L58;
        ALogger.i("AudiencePortraitInteractionFragment", "onAudienceScroll return by slide clean mode");
        return;
    L58:
        boolean r107 = or();
        if (ClearScreenHelper.g() == false) goto L68;
        if (r104 == null) goto L68;
        com.bytedance.live.datacontext.m<Boolean> r108 = r104.isMultiTabRoom();
        if (r108 == null) goto L68;
        if (r108.getValue().booleanValue() == true) goto L68;
        if (rs0.f121155a.getValue().booleanValue() == false) goto L68;
        boolean r109 = true;
    L70:
        if (xk.f121612a.getValue().booleanValue() == true) goto L72;
    L74:
        boolean r118 = false;
    L75:
        if (r118 == false) goto L108;
        if (r107 == true) goto L108;
        if (r104 == null) goto L83;
        com.bytedance.live.datacontext.m<Integer> r119 = r104.getCleanMode();
        if (r119 == null) goto L83;
        if (r119.getValue().intValue() != 2) goto L83;
    L89:
        if (r104 == null) goto L108;
        com.bytedance.live.datacontext.m<Boolean> r120 = r104.isInZoom();
        if (r120 == null) goto L108;
        if (r120.getValue().booleanValue() == true) goto L108;
        float r121 = r110 - r113;
        float r122 = r111 - r210;
        if (r121 > (((double) r105.getWidth()) / 2.0d)) goto L97;
    L99:
        boolean r123 = false;
    L100:
        if (r123 == false) goto L108;
        if (this.C == true) goto L108;
        if (com.bytedance.android.livesdk.feedback.utils.a.b(this.dataCenter, 6) == false) goto L106;
        return;
    L106:
        Map<Long, Long> r124 = x7.f114306a;
        xs2.b.a().post(new h1(6));
        HashMap r125 = new HashMap();
        r125.put("leave_type", "draw");
        r125.put("is_clear_mode", "1");
        i4.c(r125);
        u.l().sendLog("live_leave", r125, new Object[]{x.class, Room.class});
        this.C = true;
        goto L108
    L97:
        if (Math.abs(r121) <= Math.abs(r122)) goto L99;
        r123 = true;
    L83:
        if (r104 == null) goto L88;
        com.bytedance.live.datacontext.m<Integer> r126 = r104.getCleanMode();
        if (r126 == null) goto L88;
        if (r126.getValue().intValue() == 13) goto L89;
    L88:
        if (r109 == true) goto L89;
    L108:
        if (isRecording() == false) goto L111;
        return;
    L111:
        if (Pq() == true) goto L113;
    L117:
        if (r104 == null) goto L125;
        com.bytedance.live.datacontext.n<IExternalConfigJudger> r127 = r104.getExternalConfigJudger();
        if (r127 == null) goto L125;
        IExternalConfigJudger r128 = r127.getValue();
        if (r128 == null) goto L125;
        if (r128.disable(EXTERNAL_CONFIG_TYPE.Gesture, GestureAction.rightScroll) != true) goto L125;
        return;
    L125:
        boolean r129 = or();
        if (wt2.a.b(Boolean.valueOf(isAnchor())) == false) goto L227;
        if (r129 == true) goto L229;
        float r130 = 0;
        if (r100 <= r130) goto L132;
    L134:
        int r131 = r105.getWidth();
        if (r105.getX() != 0.0f) goto L139;
        if (r100 <= r130) goto L139;
        return;
    L139:
        if (r105.getX() != r105.getWidth()) goto L143;
        if (r100 >= r130) goto L143;
        return;
    L143:
        if (fr() == false) goto L148;
        float r132 = r131;
        if (r105.getX() == r132) goto L226;
        I4(true, false);
        r105.setX(r132);
        return;
    L226:
        return;
    L148:
        float r133 = Math.min(Math.max(0.0f, r105.getX() - r100), r105.getWidth());
        View r134 = null;
        if (pX() == false) goto L166;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r135 = this.f113352b;
        if (r135 == null) goto L153;
        View r136 = r135.getRootView();
    L154:
        if (r136 != null) goto L156;
        return;
    L156:
        float r137 = r131;
        float r138 = Math.min(1.0f, Math.max(0.0f, (r133 - (r137 / 2.0f)) / (r137 * 0.5f)));
        com.bytedance.android.livesdk.chatroom.ui.framework.a r139 = this.f113353c;
        if (r139 == null) goto L161;
        Intrinsics.checkNotNullParameter(r139, "$this$getClearScreenWaterInterface");
        Element<?> r140 = r139.w8(d90.d.a.H0);
        if (r140 == null) goto L161;
        com.bytedance.android.livesdk.chatroom.tetris.portrait.a r141 = (com.bytedance.android.livesdk.chatroom.tetris.portrait.a) r140.f(com.bytedance.android.livesdk.chatroom.tetris.portrait.a.class);
    L162:
        if (r141 == null) goto L166;
        if (wt2.a.l() == false) goto L166;
        r141.C(r138);
    L161:
        r141 = null;
        goto L162
    L153:
        r136 = null;
    L166:
        r105.setX(r133);
        if (wt2.a.k() == true) goto L192;
        if (wt2.a.i() == true) goto L192;
        if (wt2.a.j() == true) goto L192;
        if (wt2.a.l() == true) goto L192;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r142 = this.f113353c;
        if (r142 == null) goto L178;
        ViewLayerDelegate<? extends h70.b> r143 = r142.hk();
    L179:
        if (r143 == null) goto L183;
        v70.a r144 = r143.s();
        if (r144 == null) goto L183;
        r144.setX(r133);
    L183:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r145 = this.f113353c;
        if (r145 == null) goto L186;
        ViewLayerDelegate<? extends h70.b> r146 = r145.E8();
    L187:
        if (r146 == null) goto L203;
        v70.a r147 = r146.s();
        if (r147 == null) goto L203;
        r147.setX(r133);
    L203:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == true) goto L212;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r148 = this.f113353c;
        if (r148 == null) goto L207;
        ViewLayerDelegate<? extends h70.b> r149 = r148.Ni();
    L208:
        if (r149 == null) goto L212;
        v70.a r150 = r149.s();
        if (r150 == null) goto L212;
        r150.setX(r133);
        goto L212
    L207:
        r149 = null;
    L212:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r151 = this.f113352b;
        if (r151 == null) goto L215;
        View r152 = r151.A8();
    L216:
        if (r152 == null) goto L218;
        r152.setX(r133);
    L218:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r153 = this.f113352b;
        if (r153 == null) goto L221;
        r134 = r153.de();
    L221:
        if (r134 == null) goto L228;
        r134.setX(r133);
        return;
    L228:
        return;
    L215:
        r152 = null;
        goto L216
    L186:
        r146 = null;
        goto L187
    L178:
        r143 = null;
    L192:
        if (com.bytedance.android.livesdk.clearscreen.a.f119362b == false) goto L199;
        Iterator<v70.a> r154 = com.bytedance.android.livesdk.clearscreen.a.f119361a.iterator();
    L196:
        if (r154.hasNext() == false) goto L199;
        r154.next().setX(r133);
    L199:
        if (isAnchor() == true) goto L201;
        boolean r155 = gs1.b.f482438a;
        gs1.b.a(a0.p(getDataCenter())).p(r133);
    L201:
        com.bytedance.android.livesdk.chatroom.utils.p.f114578b.getClass();
        boolean r156 = r105 instanceof ViewGroup;
        goto L203
    L132:
        if (ClearScreenHelper.a() == false) goto L134;
        return;
    L229:
        return;
    L227:
        return;
    L113:
        if (r100 > 0) goto L117;
        if (wt2.a.d(Boolean.valueOf(isAnchor())) == false) goto L117;
        return;
    L72:
        if (wt2.a.h() == false) goto L74;
        r118 = true;
    L68:
        r109 = false;
    L33:
        if (this.B == false) goto L46;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r157 = this.f113351a;
        if (r157 == null) goto L37;
        boolean r158 = r157.isNestedOutside();
    L38:
        if (r158 == true) goto L46;
        if (r106 == true) goto L46;
        if (r100 >= 0) goto L46;
        if (Math.abs(r102) < (((double) Math.abs(r101)) * this.A)) goto L46;
        return;
    L37:
        r158 = false;
        goto L38
    L14:
        if (r114.a() == false) goto L16;
        r115 = true;
        goto L17
    L8:
        if (r103.R == false) goto L10;
        r106 = true;
        goto L11
    }
}
