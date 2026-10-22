package com.bytedance.android.livesdk.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.cs0;
import com.bytedance.android.livesdk.config.ds0;
import com.bytedance.android.livesdk.config.es0;
import com.bytedance.android.livesdk.config.fs0;
import com.bytedance.android.livesdk.config.gs0;
import com.bytedance.android.livesdk.config.hs0;
import com.bytedance.android.livesdk.config.is0;
import com.bytedance.android.livesdk.config.js0;
import com.bytedance.android.livesdk.config.sq0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/widget/ScreenShotShareDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenShotShareDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f161268t = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f161269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f161270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f161271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f161272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f161273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f161274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f161275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f161276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<LottieAnimationView> f161277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f161278m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f161279n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f161280o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f161281p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DataCenter f161282q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f161283r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f161284s;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f161285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f161286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f161287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LottieAnimationView f161288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f161289e;

        public b(View r100, ImageView r101, ImageView r102, LottieAnimationView r103, TextView r104) {
            Intrinsics.checkNotNullParameter(r100, "contentView");
            this.f161285a = r100;
            this.f161286b = r101;
            this.f161287c = r102;
            this.f161288d = r103;
            this.f161289e = r104;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenShotShareDialog f161290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f161291b;

        public c(ScreenShotShareDialog r100, List r101) {
            this.f161290a = r100;
            this.f161291b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            Iterator r102 = ((ArrayList) this.f161290a.f161277l).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((LottieAnimationView) r102.next()).playAnimation();
            goto L4
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScreenShotShareDialog f161292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f161293b;

        public d(ScreenShotShareDialog r100, View r101) {
            this.f161292a = r100;
            this.f161293b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            ScreenShotShareDialog r102 = this.f161292a;
            View r103 = this.f161293b;
            int r104 = ScreenShotShareDialog.f161268t;
            r102.getClass();
            u4.c(new ScreenShotShareDialog$getMultiSearchAnimController$1(r103)).c();
        }
    }

    static {
    }

    public ScreenShotShareDialog() {
        this.f161269d = cs0.f119976a.getValue();
        this.f161270e = js0.f120549a.getValue();
        this.f161271f = ds0.f120061a.getValue();
        this.f161272g = hs0.f120401a.getValue();
        this.f161273h = is0.f120477a.getValue();
        this.f161274i = es0.f120151a.getValue();
        this.f161275j = gs0.f120311a.getValue();
        this.f161276k = fs0.f120228a.getValue();
        this.f161277l = new ArrayList();
        this.f161281p = "";
        this.f161284s = new CompositeDisposable();
        setNoTitleAndCancelOutside(true);
    }

    public final b V90() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_screen_shot_dialog_item, null);
        return new b(r100, (ImageView) r100.findViewById(R.id.screen_shot_item_img), (ImageView) r100.findViewById(R.id.screen_shot_item_img_inner), (LottieAnimationView) r100.findViewById(R.id.screen_shot_item_img_inner_lottie), (TextView) r100.findViewById(R.id.screen_shot_item_title));
    }

    public static void S90(ScreenShotShareDialog r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void U90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Disposable r101 = this.f161283r;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f161284s.clear();
        super.onDismiss(r100);
        FragmentManager r102 = getFragmentManager();     // Catch: Exception -> L14 IllegalStateException -> L16
        if (r102 == null) goto L21;
        FragmentTransaction r103 = r102.beginTransaction();     // Catch: Exception -> L14 IllegalStateException -> L16
        if (r103 == null) goto L22;
        FragmentTransaction r104 = r103.remove(this);     // Catch: Exception -> L14 IllegalStateException -> L16
        if (r104 == null) goto L23;
        r104.commit();     // Catch: Exception -> L14 IllegalStateException -> L16
    L25:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L16:
        e = move-exception;
        ALogger.e("ScreenShotShareDialog", e);
        return;
    L14:
        e = move-exception;
        ALogger.e("ScreenShotShareDialog", e);
    }

    public final void W90(View r100) {
        RxUtilKt.c(Observable.just("").delay(1000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r100)), this.f161284s);
    }

    public final void X90(b r100) {
        Integer r101 = this.f161269d;
        if (r101 != null) goto L6;
    L10:
        TextView r102 = r100.f161289e;
        if (r102 == null) goto L16;
        r102.setTextColor(ColorProtector.parseColor("#99161823"));
        return;
    L16:
        return;
    L6:
        if (r101.intValue() != 0) goto L10;
        TextView r103 = r100.f161289e;
        if (r103 == null) goto L14;
        r103.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (sq0.f121246a.getValue().booleanValue() == true) goto L5;
        setStyle(1, R.style.ttlive_common_bottom_dialog);
        return;
    L5:
        if (this.f161270e.booleanValue() == false) goto L7;
        setStyle(1, R.style.ttlive_screen_shot_bottom_dialog_new);
        return;
    L7:
        setStyle(1, R.style.ttlive_screen_shot_bottom_dialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        U90(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f161278m = (ViewGroup) r110.findViewById(R.id.screen_shot_dialog_root_view);
        this.f161279n = (TextView) r110.findViewById(R.id.title);
        this.f161280o = r110.findViewById(R.id.divider_line);
        PolarisFileWrapper r112 = new PolarisFileWrapper(this.f161281p);
        HSImageView r100 = (HSImageView) r110.findViewById(R.id.screen_shot_img);
        if (r100 == null) goto L5;
        r100.setImageURI(Uri.fromFile(r112).toString());
    L5:
        ArrayList r113 = new ArrayList();
        b r101 = V90();
        if (this.f161270e.booleanValue() == false) goto L8;
        int r102 = R.drawable.ttlive_ic_share_friends_new;
    L9:
        ImageView r103 = r101.f161286b;
        if (r103 == null) goto L12;
        r103.setBackgroundResource(r102);
    L12:
        TextView r104 = r101.f161289e;
        if (r104 == null) goto L15;
        r104.setText("私信好友");
    L15:
        X90(r101);
        r101.f161285a.setOnClickListener(new h2(this));
        T90(r113, r101.f161285a, -1);
        View r105 = null;
        r105 = null;
        String r106 = null;
        r106 = null;
        r105 = null;
        r105 = null;
        if (puc.a.isInstalledApp(getContext(), "com.tencent.mm") == true) goto L18;
        View r107 = null;
    L29:
        T90(r113, r107, -1);
        b r108 = V90();
        DataCenter r109 = this.f161282q;
        if (r109 == null) goto L48;
        Room r114 = com.bytedance.android.live.core.utils.z.o(r109);
        if (r114 == null) goto L48;
        User r115 = r114.mo8271getOwner();
        if (r115 == null) goto L48;
        if (this.f161270e.booleanValue() == false) goto L40;
        int r116 = R.drawable.ttlive_ic_share_report_new;
    L41:
        ImageView r117 = r108.f161286b;
        if (r117 == null) goto L44;
        r117.setBackgroundResource(r116);
    L44:
        TextView r118 = r108.f161289e;
        if (r118 == null) goto L47;
        r118.setText("举报");
    L47:
        X90(r108);
        r108.f161285a.setOnClickListener(new i2(this, r114, r115));
        View r119 = r108.f161285a;
    L49:
        T90(r113, r119, -1);
        if (this.f161272g.booleanValue() == false) goto L119;
        RoomContext r120 = RoomContext.a.c(RoomContext.Companion, this.f161282q, 0, 2);
        if (r120 == null) goto L56;
        if (r120.isMediaRoom() == true) goto L119;
    L56:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.f161282q).Y0(PaidSceneEnum.ALL) == true) goto L119;
        if (PadConfigUtils.c() == true) goto L119;
        b r121 = V90();
        DataCenter r122 = this.f161282q;
        if (r122 == null) goto L65;
        Boolean r123 = (Boolean) r122.get("DATA_COMMERCE_COMPAT_AUDIENCE_BTN_ATTACH", Boolean.FALSE);
        if (r123 == null) goto L65;
        boolean r124 = r123.booleanValue();
    L66:
        if (r124 == false) goto L68;
        String r125 = "搜同款";
    L69:
        TextView r126 = r121.f161289e;
        if (r126 == null) goto L72;
        r126.setText(r125);
    L72:
        X90(r121);
        Boolean r127 = this.f161270e;
        Boolean r128 = this.f161271f;
        if (r127.booleanValue() == true) goto L89;
        if (r128.booleanValue() == true) goto L89;
        ImageView r129 = r121.f161286b;
        if (r129 == null) goto L79;
        GradientDrawable r130 = new GradientDrawable();
        r130.setColor(ColorProtector.parseColor("#FF861E"));
        r130.setShape(1);
        Unit r131 = Unit.INSTANCE;
        r129.setBackground(r130);
    L79:
        ImageView r132 = r121.f161287c;
        if (r132 == null) goto L82;
        r132.setBackgroundResource(R.drawable.ttlive_ic_multi_search);
    L82:
        ImageView r133 = r121.f161287c;
        if (r133 == null) goto L85;
        UtilityKotlinExtentionsKt.w(r133);
    L85:
        ImageView r134 = r121.f161287c;
        if (r134 == null) goto L113;
        W90(r134);
    L113:
        com.bytedance.android.livesdk.log.filter.o r135 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r135 == null) goto L118;
        Map<String, String> r136 = r135.getMap();
        if (r136 == null) goto L118;
        r106 = r136.get("enter_from_merge");
    L118:
        Map<String, String> r137 = MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", String.valueOf(r106)), TuplesKt.to("enter_method", "visual_live_screenshot_entrance"), TuplesKt.to("words_content", r125)});
        com.bytedance.android.livesdk.log.u.l().h("show_search_icon", r137, new Object[0]);
        r121.f161285a.setOnClickListener(new j2(this, r137));
        r105 = r121.f161285a;
    L89:
        if (r127.booleanValue() == true) goto L91;
    L104:
        ImageView r138 = r121.f161286b;
        if (r138 == null) goto L107;
        r138.setBackgroundResource(R.drawable.ttlive_ic_share_pic_search_new_bg);
    L107:
        LottieAnimationView r139 = r121.f161288d;
        if (r139 == null) goto L110;
        UtilityKotlinExtentionsKt.w(r139);
    L110:
        LottieAnimationView r140 = r121.f161288d;
        if (r140 == null) goto L113;
        r140.setAnimation("ttlive_shot_screen_pic_search_animation.json");
        ((ArrayList) this.f161277l).add(r140);
        goto L113
    L91:
        if (r128.booleanValue() == true) goto L104;
        ImageView r141 = r121.f161286b;
        if (r141 == null) goto L95;
        r141.setBackgroundResource(R.drawable.ttlive_ic_share_pic_search_new_bg);
    L95:
        ImageView r142 = r121.f161287c;
        if (r142 == null) goto L98;
        r142.setBackgroundResource(R.drawable.ttlive_ic_multi_search);
    L98:
        ImageView r143 = r121.f161287c;
        if (r143 == null) goto L101;
        UtilityKotlinExtentionsKt.w(r143);
    L101:
        ImageView r144 = r121.f161287c;
        if (r144 == null) goto L113;
        W90(r144);
        goto L113
    L68:
        r125 = "识别图片";
    L65:
        r124 = false;
    L119:
        T90(r113, r105, this.f161273h.intValue());
        LinearLayout r145 = (LinearLayout) r110.findViewById(R.id.screen_shot_grid);
        if (r145 == null) goto L139;
        r145.removeAllViews();
        float r146 = ((com.bytedance.android.live.core.utils.s1.y() - UIUtils.dip2Px(getContext(), 71.0f)) - (UIUtils.dip2Px(getContext(), 64.0f) * r113.size())) / (r113.size() + 1);
        Iterator r147 = r113.iterator();
        final int r148 = 0;
    L123:
        if (r147.hasNext() == false) goto L135;
        Object r149 = r147.next();
        int r150 = r148 + 1;
        if (r148 >= 0) goto L127;
        CollectionsKt.throwIndexOverflow();
    L127:
        final View r151 = (View) r149;
        int r152 = (int) r146;
        if (r151 == null) goto L133;
        LinearLayout.LayoutParams r153 = new LinearLayout.LayoutParams((int) UIUtils.dip2Px(getContext(), 64.0f), -2);
        r153.leftMargin = r152;
        r145.addView(r151, r153);
        if (this.f161271f.booleanValue() == false) goto L133;
        u4.c(new ScreenShotShareDialog$addView$1(this, r151, r148)).c();
        r151.setAlpha(0.0f);
        r151.setTranslationY(UtilityKotlinExtentionsKt.i(43));
        r151.setScaleX(0.8f);
        r151.setScaleY(0.8f);
    L133:
        r148 = r150;
        goto L123
    L135:
        if (this.f161271f.booleanValue() == false) goto L139;
        if ((!((ArrayList) this.f161277l).isEmpty()) == false) goto L139;
        RxUtilKt.c(Observable.timer((this.f161274i.longValue() + (this.f161275j.longValue() * ((long) (r113.size() - 1)))) + this.f161276k.longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r113)), this.f161284s);
    L139:
        Integer r154 = this.f161269d;
        if (r154 != null) goto L143;
    L153:
        ViewGroup r155 = this.f161278m;
        if (r155 == null) goto L156;
        r155.setBackgroundResource(R.drawable.ttlive_screenshot_dialog_bg_white);
    L156:
        TextView r156 = this.f161279n;
        if (r156 == null) goto L159;
        r156.setTextColor(ColorProtector.parseColor("#161823"));
    L159:
        View r157 = this.f161280o;
        if (r157 == null) goto L162;
        r157.setBackgroundColor(ColorProtector.parseColor("#1E161823"));
    L162:
        this.f161283r = Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new g2(this));
        com.bytedance.android.livesdk.log.g r158 = com.bytedance.android.livesdk.log.u.l();
        HashMap r159 = new HashMap();
        r159.put("request_page", "live_screenshot");
        r158.sendLog("livesdk_screenshot_pannel_show", r159, new Object[]{Room.class, am2.x.class});
        return;
    L143:
        if (r154.intValue() != 0) goto L153;
        ViewGroup r160 = this.f161278m;
        if (r160 == null) goto L147;
        r160.setBackgroundResource(R.drawable.ttlive_screenshot_dialog_bg);
    L147:
        TextView r161 = this.f161279n;
        if (r161 == null) goto L150;
        r161.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
    L150:
        View r162 = this.f161280o;
        if (r162 == null) goto L162;
        r162.setBackgroundColor(ColorProtector.parseColor("#1EFFFFFF"));
        goto L162
    L40:
        r116 = R.drawable.ttlive_ic_share_report;
    L48:
        r119 = null;
        goto L49
    L18:
        b r163 = V90();
        if (this.f161270e.booleanValue() == false) goto L21;
        int r164 = R.drawable.ttlive_ic_share_wechat_new;
    L22:
        ImageView r165 = r163.f161286b;
        if (r165 == null) goto L25;
        r165.setBackgroundResource(r164);
    L25:
        TextView r166 = r163.f161289e;
        if (r166 == null) goto L28;
        r166.setText("分享微信");
    L28:
        X90(r163);
        r163.f161285a.setOnClickListener(new k2(this));
        r107 = r163.f161285a;
        goto L29
    L21:
        r164 = R.drawable.ttlive_ic_share_wechat;
        goto L22
    L8:
        r102 = R.drawable.ttlive_ic_share_friends;
        goto L9
    }

    public static void T90(List r100, View r101, int r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r102 > 0) goto L6;
    L9:
        ((ArrayList) r100).add(r101);
        return;
    L6:
        if (r102 > ((ArrayList) r100).size()) goto L9;
        ListProtector.add(r100, r102 - 1, r101);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (r102 == null) goto L6;
        S90(this);
    L6:
        if (this.f161270e.booleanValue() == false) goto L8;
        int r103 = R.layout.ttlive_screen_shot_dialog_alert_new;
    L10:
        return r100.inflate(r103, r101, false);
    L8:
        r103 = R.layout.ttlive_screen_shot_dialog_alert;
        goto L10
    }
}
