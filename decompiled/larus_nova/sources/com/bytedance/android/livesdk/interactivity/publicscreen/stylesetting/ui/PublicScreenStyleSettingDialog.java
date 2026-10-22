package com.bytedance.android.livesdk.interactivity.publicscreen.stylesetting.ui;

import android.content.DialogInterface;
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
import com.bytedance.android.livesdk.chatroom.ui.SmoothLinearLayoutManager;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.s;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.mock.FakeMessageListAdapter;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import ec2.e1;
import g52.e;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ma2.b;
import na2.c;
import na2.f;
import na2.g;
import py.k;
import tb2.d;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/stylesetting/ui/PublicScreenStyleSettingDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/n;", "Lma2/b$b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenStyleSettingDialog extends DialogFragment implements n, b.InterfaceC6787b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f139653u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n.a f139654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f139655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f139656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SpaceItemDecoration f139657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FakeMessageListAdapter f139658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f139659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PublicScreenConfigSliderView f139660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PublicScreenConfigSliderView f139661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f139662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f139663m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public HSImageView f139664n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f139665o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HSImageView f139666p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<d> f139667q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f139668r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DataCenter f139669s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f139670t;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n
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

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ((ArrayList) this.f139667q).clear();
        this.f139670t.f512678a = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n
    public final void RE(n.a r100) {
        this.f139654d = r100;
    }

    public final void T90(int r100) {
        int r101 = s.f133650a;
        String r102 = "fake public screen use height: " + r100;
        Intrinsics.checkNotNullParameter(r102, "string");
        ALogger.i("PublicScreenStyleSetting", r102);
        RecyclerView r103 = this.f139656f;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L11;
        r104.height = r100;
        RecyclerView r105 = this.f139656f;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        r105.setLayoutParams(r104);
    L11:
        RecyclerView r106 = this.f139656f;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L14:
        r106.scrollToPosition(CollectionsKt.getLastIndex(this.f139667q));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.n
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        dismiss();     // Catch: Exception -> L5
    L9:
        this.f139670t.g();
        n.a r101 = this.f139654d;
        if (r101 == null) goto L15;
        r101.onCancel();
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L9;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(0, R.style.ttlive_anchor_public_screen_config_dialog);
        b r101 = this.f139670t;
        r101.f512678a = this;
        r101.f();
    }

    public PublicScreenStyleSettingDialog(DataCenter r100, ma2.a r101) {
        Intrinsics.checkNotNullParameter(r101, "presenter");
        this.f139669s = r100;
        this.f139670t = r101;
        this.f139667q = new ArrayList();
        if (PadConfigUtils.c() == false) goto L5;
        int r102 = UtilityKotlinExtentionsKt.i(64);
    L6:
        this.f139668r = r102;
        return;
    L5:
        r102 = UtilityKotlinExtentionsKt.i(60);
        goto L6
    }

    public final void S90(List r100, y r101) {
        ((SingleSubscribeProxy) Single.create(new na2.e(r100, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new f(this), g.f518445a);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        SmoothLinearLayoutManager r112 = new SmoothLinearLayoutManager(getContext());
        r112.p(1.0f);
        this.f139657g = new SpaceItemDecoration(1, q.e(gb2.a.a(this.f139669s, false), true), false);
        l r113 = com.bytedance.android.livesdk.interactivity.api.q.i();
        if (r113 == null) goto L13;
        e52.a r114 = r113.getTextConfig();
        if (r114 == null) goto L13;
        DataCenter r100 = this.f139669s;
        if (r100 == null) goto L11;
        Boolean r101 = (Boolean) r100.get("data_is_anchor");
        if (r101 == null) goto L11;
        boolean r102 = r101.booleanValue();
    L12:
        e r115 = q.a(r114, true, r102);
    L20:
        this.f139659i = r115;
        FakeMessageListAdapter r116 = new FakeMessageListAdapter();
        e r103 = this.f139659i;
        if (r103 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("textConfig");
    L23:
        r116.f140260b = r103;
        Unit r104 = Unit.INSTANCE;
        this.f139658h = r116;
        RecyclerView r117 = this.f139656f;
        if (r117 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L26:
        r117.setLayoutManager(r112);
        FakeMessageListAdapter r118 = this.f139658h;
        if (r118 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L29:
        r117.setAdapter(r118);
        SpaceItemDecoration r119 = this.f139657g;
        if (r119 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("spaceItemDecoration");
    L32:
        r117.addItemDecoration(r119);
        if (e1.f472014a.getValue().booleanValue() == true) goto L38;
        RecyclerView r120 = this.f139656f;
        if (r120 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L37:
        r120.setVerticalFadingEdgeEnabled(false);
    L38:
        r117.addOnItemTouchListener(new PublicScreenStyleSettingDialog$configViews$2$1());
        View r121 = this.f139662l;
        if (r121 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
    L41:
        r121.setOnClickListener(new c(this));
        View r122 = this.f139663m;
        if (r122 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("btnComplete");
    L44:
        r122.setOnClickListener(new na2.d(this));
        String r123 = i2.f114501a;
        HSImageView r124 = this.f139664n;
        if (r124 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("giftTray1");
    L47:
        i2.h(r124, "/publicscreen/mock/ttlive_gift_tray_mock1.png");
        HSImageView r125 = this.f139665o;
        if (r125 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("giftTray2");
    L50:
        i2.h(r125, "/publicscreen/mock/ttlive_gift_tray_mock2.png");
        HSImageView r126 = this.f139666p;
        if (r126 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("enterAnim");
    L53:
        i2.h(r126, "/publicscreen/mock/ttlive_enter_anim_mock.png");
        PublicScreenConfigSliderView r127 = this.f139660j;
        if (r127 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
    L56:
        d52.a r105 = (d52.a) this.f139670t.a(d52.a.class);
        if (r105 == null) goto L59;
        int r106 = r105.a();
    L60:
        r127.b(r106, false);
        PublicScreenConfigSliderView r128 = this.f139660j;
        if (r128 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
    L63:
        r128.setCallback(new na2.a(this));
        PublicScreenConfigSliderView r129 = this.f139661k;
        if (r129 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L66:
        d52.b r107 = (d52.b) this.f139670t.a(d52.b.class);
        if (r107 == null) goto L69;
        int r108 = r107.a();
    L70:
        r129.b(r108, false);
        PublicScreenConfigSliderView r130 = this.f139661k;
        if (r130 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L73:
        r130.setCallback(new na2.b(this));
        this.f139670t.j(this.f139669s);
        if (PadConfigUtils.c() == false) goto L100;
        View r131 = this.f139655e;
        if (r131 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException(NewBroadcastMonitor.STAGE.TOOLBAR);
    L78:
        a1.k(r131, this.f139668r);
        RecyclerView r132 = this.f139656f;
        if (r132 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L81:
        ViewParent r133 = r132.getParent();
        if ((r133 instanceof ConstraintLayout) == true) goto L84;
        r133 = null;
    L84:
        ConstraintLayout r134 = (ConstraintLayout) r133;
        if (r134 == null) goto L100;
        ConstraintSet r135 = new ConstraintSet();
        r135.clone(r134);
        r135.clear(R.id.public_screen);
        RecyclerView r109 = this.f139656f;
        if (r109 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L90:
        r135.constrainWidth(r109.getId(), (int) (s1.y() * 0.4f));
        RecyclerView r136 = this.f139656f;
        if (r136 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L93:
        r135.connect(r136.getId(), 1, 0, 1, UtilityKotlinExtentionsKt.i(16));
        RecyclerView r137 = this.f139656f;
        if (r137 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L96:
        int r138 = r137.getId();
        View r139 = this.f139655e;
        if (r139 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException(NewBroadcastMonitor.STAGE.TOOLBAR);
    L99:
        r135.connect(r138, 4, r139.getId(), 3, UtilityKotlinExtentionsKt.i(14));
        r135.applyTo(r134);
    L100:
        Integer r140 = (Integer) this.f139670t.b(d52.b.class, Integer.TYPE);
        if (r140 == null) goto L103;
        T90(r140.intValue());
    L103:
        IBaseUser r141 = (IBaseUser) vh7.f.c(IBaseUser.class);
        r141.setNickName("用户昵称");
        tb2.c r142 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r141, null, true, false);
        tb2.c r143 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r141, null, false, false);
        yb2.a r144 = w.a();
        d r145 = new d();
        r145.c(r142);
        r145.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("评论内容"));
        r145.f545243b = r144;
        int r146 = 0;
    L105:
        if (r146 >= 17) goto L107;
        ((ArrayList) this.f139667q).add(r145);
        r146 = r146 + 1;
        goto L105
    L107:
        d r147 = new d();
        r147.c(r143);
        r147.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 关注了主播"));
        yb2.a r148 = w.a();
        r148.f567065d = s1.h(R.color.ttlive_hs_s38);
        Unit r149 = Unit.INSTANCE;
        r147.f545243b = r148;
        ((ArrayList) this.f139667q).add(r147);
        d r150 = new d();
        r150.c(r142);
        r150.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("送出摩天大厦 "));
        k r151 = (k) vh7.f.c(k.class);
        r151.setUri("webcast/dbdf519c73851373747e13f92b114013.png");
        r151.setUrls(CollectionsKt.listOf(new String[]{"https://p3-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image", "https://p6-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image", "https://p9-webcast.douyinpic.com/img/webcast/public_area_setting_gift.png~tplv-obj.image"}));
        r151.setAvgColor("#DCF4FA");
        r150.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b("$*", r151, UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(16)));
        r150.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" x1"));
        yb2.a r152 = w.a();
        r152.f567065d = s1.h(R.color.ttlive_hs_s40);
        r150.f545243b = r152;
        ((ArrayList) this.f139667q).add(r150);
        vh7.c r153 = vh7.f.c(k.class);
        k r154 = (k) r153;
        r154.setUrls(CollectionsKt.listOf(new String[]{"https://p3-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image", "https://p6-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image", "https://p9-webcast.douyinpic.com/img/webcast/public_area_setting_user_grade_level.png~tplv-obj.image"}));
        r154.setImageType(1);
        r154.setHeight(16);
        r154.setWidth(32);
        k.b r155 = (k.b) vh7.f.c(k.b.class);
        r155.setLevel(22);
        r155.setAccessibilityText("荣誉等级22级勋章");
        r154.setContent(r155);
        List r156 = CollectionsKt.listOf(r153);
        d r157 = new d();
        r157.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r141, null, true, false));
        r157.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("评论内容"));
        r157.f545243b = r144;
        r157.d(com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.b(r156));
        ((ArrayList) this.f139667q).add(r157);
        d r158 = new d();
        r158.c(r143);
        r158.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 来了"));
        yb2.a r159 = w.a();
        r159.f567065d = s1.h(R.color.ttlive_hs_s41);
        r158.f545243b = r159;
        ((ArrayList) this.f139667q).add(r158);
        Float r160 = (Float) this.f139670t.b(d52.a.class, Float.TYPE);
        if (r160 == null) goto L112;
        S90(this.f139667q, new y(r160.floatValue() * q.d(true, false)));
        return;
    L112:
        return;
    L69:
        r108 = 0;
        goto L70
    L59:
        r106 = 0;
    L11:
        r102 = false;
    L13:
        float r161 = w2.a(14.0f);
        int r162 = (int) s1.b(24.0f);
        Typeface r163 = Typeface.DEFAULT_BOLD;
        int r164 = UtilityKotlinExtentionsKt.i(8);
        int r165 = UtilityKotlinExtentionsKt.i(3);
        int r166 = UtilityKotlinExtentionsKt.i(8);
        int r167 = UtilityKotlinExtentionsKt.i(3);
        float r168 = PublicScreenStyleHelper.f133617g;
        DataCenter r169 = this.f139669s;
        if (r169 == null) goto L18;
        Boolean r170 = (Boolean) r169.get("data_is_anchor");
        if (r170 == null) goto L18;
        boolean r171 = r170.booleanValue();
    L19:
        r115 = new e(r161, r162, r163, r164, r165, r166, r167, r168, q.c(r171, true));
    L18:
        r171 = false;
        goto L19
    }

    @Override // ma2.b.InterfaceC6787b
    public final void Cn(Class r100, d52.b r101, la2.a r102) {
        Intrinsics.checkNotNullParameter(r100, "styleType");
        Intrinsics.checkNotNullParameter(r101, "defaultStyle");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (Intrinsics.areEqual(r100, d52.b.class) == false) goto L8;
        PublicScreenConfigSliderView r103 = this.f139661k;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("heightSlider");
    L12:
        r103.setDisable(true);
        r103.b(r101.a(), false);
        r103.setDisableSettingCallback(r102);
        return;
    L8:
        if (Intrinsics.areEqual(r100, d52.a.class) == false) goto L14;
        r103 = this.f139660j;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("fontSlider");
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_public_screen_config_dialog, r101, false);
        this.f139662l = r103.findViewById(R.id.btn_close);
        this.f139663m = r103.findViewById(R.id.btn_complete);
        this.f139656f = (RecyclerView) r103.findViewById(R.id.public_screen);
        this.f139660j = (PublicScreenConfigSliderView) r103.findViewById(R.id.slider_font);
        this.f139661k = (PublicScreenConfigSliderView) r103.findViewById(R.id.slider_height);
        this.f139664n = (HSImageView) r103.findViewById(R.id.gift_tray_1);
        this.f139665o = (HSImageView) r103.findViewById(R.id.gift_tray_2);
        this.f139666p = (HSImageView) r103.findViewById(R.id.enter_anim);
        this.f139655e = r103.findViewById(R.id.toolbar);
        return r103;
    }
}
