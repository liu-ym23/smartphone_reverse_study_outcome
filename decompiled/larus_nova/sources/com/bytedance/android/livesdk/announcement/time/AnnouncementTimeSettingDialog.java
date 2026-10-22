package com.bytedance.android.livesdk.announcement.time;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.config.vb;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/time/AnnouncementTimeSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementTimeSettingDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f103570l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f103571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f103572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f103573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f103574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IAnnouncementService.TimeDialogListener f103575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.livesdk.announce.b f103576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f103577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f103578k;

    public static final class a {
        public a() {
        }

        public static void a(AnnouncementTimeSettingDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "AnnouncementTimeSettingDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "AnnouncementTimeSettingDialog");
        }

        public static /* synthetic */ void c(Context r100, com.bytedance.android.livesdk.announce.b r101, IAnnouncementService.TimeDialogListener r102, boolean r103, String r110) {
            b(r100, r101, r102, r103, r110, false);
        }

        @JvmStatic
        public static void b(Context r100, com.bytedance.android.livesdk.announce.b r101, IAnnouncementService.TimeDialogListener r102, boolean r103, String r104, boolean r105) {
            Intrinsics.checkNotNullParameter(r104, "requestPage");
            if ((r100 instanceof FragmentActivity) == false) goto L16;
            FragmentManager r106 = ((FragmentActivity) r100).getSupportFragmentManager();
            if ((r106.findFragmentByTag("AnnouncementTimeSettingDialog") instanceof AnnouncementTimeSettingDialog) == false) goto L14;
            Fragment r107 = r106.findFragmentByTag("AnnouncementTimeSettingDialog");
            if (r107 == null) goto L13;
            AnnouncementTimeSettingDialog r108 = (AnnouncementTimeSettingDialog) r107;
            if (r108.isAdded() == false) goto L11;
            return;
        L11:
            a(r108, r106);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.announcement.time.AnnouncementTimeSettingDialog");
        L14:
            AnnouncementTimeSettingDialog r109 = new AnnouncementTimeSettingDialog();
            r109.f103574g = r104;
            r109.f103576i = r101;
            r109.f103573f = r103;
            r109.f103578k = r105;
            a(r109, r106);
            r109.f103575h = r102;
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f103579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f103580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f103581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f103582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f103583e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f103584f;

        public b() {
            this(0);
        }

        public /* synthetic */ b(int r100) {
            this(s1.m(R.drawable.ttlive_bg_prelive_setting), s1.h(R.color.ttlive_douyin_dark_TextPrimary), s1.h(R.color.ttlive_douyin_dark_TextPrimary), ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED), ColorProtector.parseColor("#B3FFFFFF"), s1.h(R.color.ttlive_douyin_dark_DialogDivider));
        }

        public b(Drawable r100, int r101, int r102, int r103, int r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "bgColorRes");
            this.f103579a = r100;
            this.f103580b = r101;
            this.f103581c = r102;
            this.f103582d = r103;
            this.f103583e = r104;
            this.f103584f = r105;
        }
    }

    static {
        new a();
    }

    public final b T90() {
        return (b) this.f103572e.getValue();
    }

    public AnnouncementTimeSettingDialog() {
        this.f103571d = new LinkedHashMap();
        setNoTitleAndCancelOutside(true);
        this.f103572e = LazyKt.lazy(new AnnouncementTimeSettingDialog$themeInfo$2(this));
        this.f103574g = "";
        this.f103577j = LazyKt.lazy(new AnnouncementTimeSettingDialog$timeSelectWidget$2(this));
        this.f103578k = true;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f103571d.clear();
    }

    public final View S90(int r100) {
        if (this.f103571d != null) goto L5;
        this.f103571d = new LinkedHashMap();
    L5:
        View r101 = this.f103571d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f103571d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void U90(boolean r100) {
        if (r100 == false) goto L5;
        ((LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogSave)).setEnabled(r100);
        ((LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogSave)).setTextColor(T90().f103582d);
        return;
    L5:
        ((LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogSave)).setTextColor(T90().f103583e);
        ((LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogSave)).setEnabled(r100);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setGravity(80);
        r102.setLayout(-1, s1.w() - s1.A());
        r102.clearFlags(1024);
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        r102.addFlags(Integer.MIN_VALUE);
        r102.addFlags(2);
        r102.setDimAmount(0.5f);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog_normal);
        setShouldUseNewPanel(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ALogger.d("announcement", "announce time select widget view create");
        WidgetManager.of(this, getView()).load(R.id.time_select_widget_container, (AnnouncementTimeSelectWidget) this.f103577j.getValue());
        if (vb.f121434a.getValue().booleanValue() == false) goto L7;
        LiveDoubleColorBallAnimationView r102 = (LiveDoubleColorBallAnimationView) S90(R.id.douyin_loading);
        if (r102 == null) goto L10;
        UtilityKotlinExtentionsKt.u(r102);
    L10:
        LiveTextView r103 = (LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogCancel);
        if (r103 == null) goto L13;
        r103.setOnClickListener(new f(this));
    L13:
        LiveTextView r104 = (LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogSave);
        if (r104 == null) goto L16;
        r104.setOnClickListener(new g(this));
    L16:
        ((ConstraintLayout) S90(R.id.mAnnouncementTimeSettingDialogContainer)).setBackground(T90().f103579a);
        ((LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogTitle)).setTextColor(T90().f103580b);
        ((LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogCancel)).setTextColor(T90().f103581c);
        ((LiveTextView) S90(R.id.mTvAnnouncementTimeSettingDialogSave)).setTextColor(T90().f103582d);
        S90(R.id.mAnnouncementTimeSettingDialogDivider).setBackgroundColor(T90().f103584f);
        AnnouncementTimeSelectWidget r105 = (AnnouncementTimeSelectWidget) this.f103577j.getValue();
        r105.f103550e = new h(this);
        com.bytedance.android.livesdk.announce.b r106 = this.f103576i;
        if (r106 != null) goto L19;
    L25:
        U90(true);
    L26:
        int r107 = com.bytedance.android.livesdk.announcement.f.f103363a;
        String r108 = this.f103574g;
        Intrinsics.checkNotNullParameter(r108, "requestPage");
        String r109 = ((IUserService) k.n(IUserService.class)).user().n();
        HashMap r110 = new HashMap();
        r110.put("enter_from", r108);
        r110.put("author_id", r109);
        u.l().sendLog("livesdk_live_announce_setting_show", r110, new Object[0]);
        return;
    L19:
        if (r106.e() != true) goto L25;
        com.bytedance.android.livesdk.announce.b r111 = this.f103576i;
        if (r111 == null) goto L25;
        if (r111.d() == true) goto L25;
        ALogger.d("announcement", "announce time select widget disable save button");
        U90(false);
        goto L26
    L7:
        LiveDoubleColorBallAnimationView r112 = (LiveDoubleColorBallAnimationView) S90(R.id.douyin_loading);
        if (r112 == null) goto L10;
        UtilityKotlinExtentionsKt.w(r112);
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_announcement_time_setting, r101, false);
    }
}
