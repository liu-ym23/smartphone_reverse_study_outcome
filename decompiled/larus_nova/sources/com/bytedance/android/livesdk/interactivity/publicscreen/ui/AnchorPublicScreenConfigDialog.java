package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import am2.x;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.mock.FakeMessageListAdapter;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import ec2.e1;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/AnchorPublicScreenConfigDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPublicScreenConfigDialog extends DialogFragment implements com.bytedance.android.livesdk.interactivity.api.publicscreen.a {
    public static final /* synthetic */ int B = 0;
    public final boolean A;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.a.InterfaceC2106a f140150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f140151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f140152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SpaceItemDecoration f140153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FakeMessageListAdapter f140154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g52.e f140155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PublicScreenConfigSliderView f140156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PublicScreenConfigSliderView f140157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f140158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f140159m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HSImageView f140160n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f140161o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HSImageView f140162p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<tb2.d> f140163q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f140164r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f140165s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f140166t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f140167u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f140168v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f140169w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f140170x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f140171y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f140172z;

    public static final class a {
    }

    static {
    }

    public AnchorPublicScreenConfigDialog() {
        this(false, null);
    }

    public final Map<String, String> S90() {
        HashMap r100 = new HashMap();
        if (jc1.k.f(IRoomContextService.class) != null) goto L5;
    L6:
        r100.put("anchor_id", ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n());
        r100.put("live_type", "video_live");
    L7:
        return r100;
    L5:
        if (IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 0, 3).h2() == true) goto L7;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.a
    public final void dismissDialog() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L9
        Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L9
        if (r100 == null) goto L16;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L9
        return;
    L16:
        return;
    L9:
        e = move-exception;
        SafetyGuard.a("dismiss AnchorPublicScreenConfigDialog failed", e, null);
    }

    public final void onCancel() {
        j0.l().sendLog("livesdk_anchor_screen_message_setting_exit_click", S90(), new Object[]{IRoom.class, x.class});
        dismiss();     // Catch: Exception -> L5
    L9:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.a.InterfaceC2106a r100 = this.f140150d;
        if (r100 == null) goto L15;
        r100.onCancel();
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L9;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ((ArrayList) this.f140163q).clear();
    }

    public final void U90(int r100) {
        RecyclerView r101 = this.f140152f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L11;
        r102.height = r100;
        RecyclerView r103 = this.f140152f;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        r103.setLayoutParams(r102);
    L11:
        RecyclerView r104 = this.f140152f;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L14:
        r104.scrollToPosition(CollectionsKt.getLastIndex(this.f140163q));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.a
    public final void V4(FragmentManager r100) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
    L13:
        e = move-exception;
        SafetyGuard.a("open AnchorPublicScreenConfigDialog failed", e, null);
        return;
    L4:
        if (r100.isDestroyed() == false) goto L6;
        return;
    L6:
        if (r100.isStateSaved() == true) goto L22;
        LandscapeRestrictionOperation r101 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "AnchorPublicScreenConfigDialog", r101);     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r101) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        show(r100, "AnchorPublicScreenConfigDialog");     // Catch: Exception -> L13
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.a
    public final void fP(com.bytedance.android.livesdk.interactivity.api.publicscreen.a.InterfaceC2106a r100) {
        this.f140150d = r100;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        onCancel();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(0, R.style.ttlive_anchor_public_screen_config_dialog);
        this.f140164r = q.c(true, true);
        this.f140165s = PublicScreenStyleHelper.a();
        int r101 = PublicScreenStyleHelper.c();
        this.f140166t = r101;
        this.f140167u = this.f140165s;
        this.f140168v = r101;
    }

    public AnchorPublicScreenConfigDialog(boolean r100, Integer r101) {
        this.A = r100;
        this.f140163q = new ArrayList();
        if (PadConfigUtils.c() == false) goto L5;
        int r102 = (int) (s1.w() * 0.28f);
    L6:
        this.f140169w = r102;
        if (PadConfigUtils.c() == false) goto L9;
        int r103 = UtilityKotlinExtentionsKt.i(64);
    L10:
        this.f140170x = r103;
        if (r100 == true) goto L13;
        int r104 = (((s1.w() - s1.A()) - UtilityKotlinExtentionsKt.i(322)) - r102) - r103;
    L20:
        this.f140171y = r104;
        int r105 = PublicScreenStyleHelper.f133611a;
        this.f140172z = 0.28571427f;
        return;
    L13:
        if (r101 == null) goto L17;
        int r106 = (s1.w() - s1.A()) - r101.intValue();
        InteractionWidgetsPosContext.Companion.getClass();
        r104 = ((r106 - InteractionWidgetsPosContext.access$getENTER_ANIMATION_HEIGHT$cp()) - r102) - r103;
        if (r104 > 0) goto L20;
        ALogger.e("AnchorPublicScreenConfigDialog", "landscape video bottom too low, bottom pos: " + r101 + ", height: " + r104);
    L18:
        r104 = 0;
        goto L20
    L17:
        ALogger.e("AnchorPublicScreenConfigDialog", "null landscape video bottom");
        goto L18
    L9:
        r103 = UtilityKotlinExtentionsKt.i(60);
        goto L10
    L5:
        r102 = y.a();
        goto L6
    }

    public final void T90(List r100, com.bytedance.android.livesdk.interactivity.service.textrender.core.y r101) {
        ((SingleSubscribeProxy) Single.create(new f(r100, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new g(this), h.f140246a);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        SmoothLinearLayoutManager r100 = new SmoothLinearLayoutManager(getContext());
        r100.p(1.0f);
        this.f140153g = new SpaceItemDecoration(1, q.e(true, true), false);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r101 = com.bytedance.android.livesdk.interactivity.api.q.i();
        if (r101 == null) goto L9;
        e52.a r102 = r101.getTextConfig();
        if (r102 == null) goto L9;
        n42.a r103 = r102.h();
        if (r103 == null) goto L9;
        Rect r104 = r103.f517041d;
        g52.e r110 = new g52.e(r103.f517038a, r103.f517040c, r103.f517039b, UtilityKotlinExtentionsKt.i(r104.left), UtilityKotlinExtentionsKt.i(r104.top), UtilityKotlinExtentionsKt.i(r104.right), UtilityKotlinExtentionsKt.i(r104.bottom), PublicScreenStyleHelper.f133617g, this.f140164r);
    L10:
        this.f140155i = r110;
        FakeMessageListAdapter r105 = new FakeMessageListAdapter();
        g52.e r106 = this.f140155i;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("textConfig");
    L13:
        r105.f140260b = r106;
        Unit r107 = Unit.INSTANCE;
        this.f140154h = r105;
        RecyclerView r108 = this.f140152f;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L16:
        r108.setLayoutManager(r100);
        FakeMessageListAdapter r109 = this.f140154h;
        if (r109 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L19:
        r108.setAdapter(r109);
        SpaceItemDecoration r111 = this.f140153g;
        if (r111 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("spaceItemDecoration");
    L22:
        r108.addItemDecoration(r111);
        if (e1.f472014a.getValue().booleanValue() == true) goto L28;
        RecyclerView r112 = this.f140152f;
        if (r112 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L27:
        r112.setVerticalFadingEdgeEnabled(false);
    L28:
        r108.addOnItemTouchListener(new AnchorPublicScreenConfigDialog$configViews$2$1());
        View r113 = this.f140158l;
        if (r113 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
    L31:
        r113.setOnClickListener(new d(this));
        View r114 = this.f140158l;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
    L34:
        r3.c(r114, s1.B(R.string.ttlive_anchor_setting_label_back), true);
        View r115 = this.f140159m;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("btnComplete");
    L37:
        r115.setOnClickListener(new e(this));
        String r116 = i2.f114501a;
        HSImageView r117 = this.f140160n;
        if (r117 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("giftTray1");
    L40:
        i2.h(r117, "/publicscreen/mock/ttlive_gift_tray_mock1.png");
        HSImageView r118 = this.f140161o;
        if (r118 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("giftTray2");
    L43:
        i2.h(r118, "/publicscreen/mock/ttlive_gift_tray_mock2.png");
        HSImageView r119 = this.f140162p;
        if (r119 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("enterAnim");
    L46:
        i2.h(r119, "/publicscreen/mock/ttlive_enter_anim_mock.png");
        PublicScreenConfigSliderView r120 = this.f140156j;
        if (r120 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
    L49:
        r120.b(this.f140165s, false);
        PublicScreenConfigSliderView r121 = this.f140156j;
        if (r121 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
    L52:
        r121.setCallback(new com.bytedance.android.livesdk.interactivity.publicscreen.ui.a(this));
        if (this.A == false) goto L55;
    L74:
        PublicScreenConfigSliderView r122 = this.f140157k;
        if (r122 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L77:
        r122.b(this.f140166t, false);
        PublicScreenConfigSliderView r123 = this.f140157k;
        if (r123 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L80:
        r123.setCallback(new b(this));
    L82:
        if (PadConfigUtils.c() == false) goto L108;
        View r124 = this.f140151e;
        if (r124 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException(NewBroadcastMonitor.STAGE.TOOLBAR);
    L86:
        a1.k(r124, this.f140170x);
        RecyclerView r125 = this.f140152f;
        if (r125 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L89:
        ViewParent r126 = r125.getParent();
        if ((r126 instanceof ConstraintLayout) == true) goto L92;
        r126 = null;
    L92:
        ConstraintLayout r127 = (ConstraintLayout) r126;
        if (r127 == null) goto L108;
        ConstraintSet r128 = new ConstraintSet();
        r128.clone(r127);
        r128.clear(R.id.public_screen);
        RecyclerView r129 = this.f140152f;
        if (r129 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L98:
        r128.constrainWidth(r129.getId(), (int) (s1.y() * 0.4f));
        RecyclerView r130 = this.f140152f;
        if (r130 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L101:
        r128.connect(r130.getId(), 1, 0, 1, UtilityKotlinExtentionsKt.i(16));
        RecyclerView r131 = this.f140152f;
        if (r131 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L104:
        int r132 = r131.getId();
        View r133 = this.f140151e;
        if (r133 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException(NewBroadcastMonitor.STAGE.TOOLBAR);
    L107:
        r128.connect(r132, 4, r133.getId(), 3, UtilityKotlinExtentionsKt.i(14));
        r128.applyTo(r127);
    L108:
        int r134 = this.f140168v;
        if (r134 != 0) goto L111;
        int r135 = this.f140169w;
    L118:
        U90(r135);
    L119:
        IBaseUser r136 = (IBaseUser) vh7.f.c(IBaseUser.class);
        r136.setNickName("用户昵称");
        tb2.c r137 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r136, null, true, false);
        tb2.c r138 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r136, null, false, false);
        yb2.a r139 = w.a();
        tb2.d r140 = new tb2.d();
        r140.c(r137);
        r140.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("评论内容"));
        r140.f545243b = r139;
        int r141 = 0;
    L121:
        if (r141 >= 17) goto L123;
        ((ArrayList) this.f140163q).add(r140);
        r141 = r141 + 1;
        goto L121
    L123:
        tb2.d r142 = new tb2.d();
        r142.c(r138);
        r142.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 关注了主播"));
        yb2.a r143 = w.a();
        r143.f567065d = s1.h(R.color.ttlive_hs_s38);
        Unit r144 = Unit.INSTANCE;
        r142.f545243b = r143;
        ((ArrayList) this.f140163q).add(r142);
        tb2.d r145 = new tb2.d();
        r145.c(r137);
        r145.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("送出摩天大厦 "));
        py.k r146 = (py.k) vh7.f.c(py.k.class);
        r146.setUri("webcast/dbdf519c73851373747e13f92b114013.png");
        r146.setUrls(CollectionsKt.listOf(new String[]{"https://p3-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image", "https://p6-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image", "https://p9-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image"}));
        r146.setAvgColor("#DCF4FA");
        r145.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b("$*", r146, UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(16)));
        r145.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" x1"));
        yb2.a r147 = w.a();
        r147.f567065d = s1.h(R.color.ttlive_hs_s40);
        r145.f545243b = r147;
        ((ArrayList) this.f140163q).add(r145);
        vh7.c r148 = vh7.f.c(py.k.class);
        py.k r149 = (py.k) r148;
        r149.setUrls(CollectionsKt.listOf(new String[]{"https://p3-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image", "https://p6-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image", "https://p9-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image"}));
        r149.setImageType(1);
        r149.setHeight(16);
        r149.setWidth(32);
        py.k.b r150 = (py.k.b) vh7.f.c(py.k.b.class);
        r150.setLevel(22);
        r150.setAccessibilityText("荣誉等级22级勋章");
        r149.setContent(r150);
        List r151 = CollectionsKt.listOf(r148);
        tb2.d r152 = new tb2.d();
        r152.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r136, null, true, false));
        r152.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("评论内容"));
        r152.f545243b = r139;
        r152.d(com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.b(r151));
        ((ArrayList) this.f140163q).add(r152);
        tb2.d r153 = new tb2.d();
        r153.c(r138);
        r153.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 来了"));
        yb2.a r154 = w.a();
        r154.f567065d = s1.h(R.color.ttlive_hs_s41);
        r153.f545243b = r154;
        ((ArrayList) this.f140163q).add(r153);
        T90(this.f140163q, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(this.f140164r));
        return;
    L111:
        if (r134 == 1) goto L115;
        if (r134 != 2) goto L119;
        int r155 = this.f140169w;
        int r156 = this.f140171y;
    L116:
        r135 = r155 + r156;
        goto L118
    L115:
        r155 = this.f140169w;
        r156 = this.f140171y / 2;
        goto L116
    L55:
        if (this.f140171y > 0) goto L57;
    L64:
        PublicScreenStyleHelper.f(0);
        PublicScreenConfigSliderView r157 = this.f140157k;
        if (r157 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L67:
        r157.setDisable(true);
        PublicScreenConfigSliderView r158 = this.f140157k;
        if (r158 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L70:
        r158.b(0, false);
        PublicScreenConfigSliderView r159 = this.f140157k;
        if (r159 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L73:
        r159.setDisableSettingCallback(new c());
        goto L82
    L57:
        if (PublicScreenStyleHelper.f133624n == true) goto L59;
    L61:
        boolean r160 = false;
    L62:
        if (r160 == true) goto L64;
    L59:
        if (PublicScreenStyleHelper.b().f() == false) goto L61;
        r160 = true;
    L9:
        r110 = new g52.e(w2.a(14.0f), (int) s1.b(24.0f), Typeface.DEFAULT_BOLD, UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(3), UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(3), PublicScreenStyleHelper.f133617g, this.f140164r);
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_public_screen_config_dialog, r101, false);
        this.f140158l = r103.findViewById(R.id.btn_close);
        this.f140159m = r103.findViewById(R.id.btn_complete);
        this.f140152f = (RecyclerView) r103.findViewById(R.id.public_screen);
        this.f140156j = (PublicScreenConfigSliderView) r103.findViewById(R.id.slider_font);
        this.f140157k = (PublicScreenConfigSliderView) r103.findViewById(R.id.slider_height);
        this.f140160n = (HSImageView) r103.findViewById(R.id.gift_tray_1);
        this.f140161o = (HSImageView) r103.findViewById(R.id.gift_tray_2);
        this.f140162p = (HSImageView) r103.findViewById(R.id.enter_anim);
        this.f140151e = r103.findViewById(R.id.toolbar);
        return r103;
    }
}
