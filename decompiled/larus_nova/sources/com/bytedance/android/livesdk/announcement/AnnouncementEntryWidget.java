package com.bytedance.android.livesdk.announcement;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementEntryWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementEntryWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f103152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f103153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f103154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f103155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f103156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f103157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f103158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f103159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f103160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnnouncementViewModel f103161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f103162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f103163l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IAnnouncementService.DialogCloseAction f103164m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f103165n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f103166o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f103167p;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f103168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f103169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f103170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Drawable f103171d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f103172e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Drawable f103173f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Drawable f103174g;

        public a() {
            this(0);
        }

        public /* synthetic */ a(int r100) {
            int r101 = s1.h(R.color.ttlive_douyin_dark_TextPrimary);
            int r102 = s1.h(R.color.ttlive_douyin_dark_TextTertiary);
            s1.h(R.color.ttlive_douyin_dark_Link);
            int r103 = s1.h(R.color.ttlive_douyin_dark_TextTertiary);
            Drawable r104 = s1.m(R.drawable.ttlive_bg_announcement_auditing);
            int r105 = s1.h(R.color.ttlive_douyin_dark_ConstTextInverse);
            Drawable r106 = s1.m(R.drawable.ttlive_bg_announcement_light_audit_failed);
            Drawable r107 = s1.m(R.drawable.ttlive_ic_announcement_entry_arrow);
            s1.h(R.color.ttlive_douyin_dark_switch);
            this(r101, r102, r103, r104, r105, r106, r107);
        }

        public a(int r100, int r101, int r102, Drawable r103, int r104, Drawable r105, Drawable r106) {
            Intrinsics.checkNotNullParameter(r103, "auditingBgDrawable");
            Intrinsics.checkNotNullParameter(r105, "auditFailedBgDrawable");
            Intrinsics.checkNotNullParameter(r106, "arrowDrawable");
            this.f103168a = r100;
            this.f103169b = r101;
            this.f103170c = r102;
            this.f103171d = r103;
            this.f103172e = r104;
            this.f103173f = r105;
            this.f103174g = r106;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementEntryWidget f103175a;

        public b(AnnouncementEntryWidget r100) {
            this.f103175a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ALogger.d("announcement", "announce entry widget observe announce info changed");
            AnnouncementEntryWidget r101 = this.f103175a;
            r101.Aq((AnnouncementInfo) r100);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementEntryWidget f103176a;

        public c(AnnouncementEntryWidget r100) {
            this.f103176a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AnnouncementViewModel.b r101 = (AnnouncementViewModel.b) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f103311a == false) goto L8;
            ((LiveDoubleColorBallAnimationView) this.f103176a.f103158g.getValue()).setVisibility(0);
            ((LinearLayout) this.f103176a.f103159h.getValue()).setVisibility(8);
        L10:
            if (r101.f103313c == false) goto L12;
            ((TextView) this.f103176a.f103160i.getValue()).setVisibility(0);
            ((LinearLayout) this.f103176a.f103159h.getValue()).setVisibility(8);
            return;
        L12:
            ((TextView) this.f103176a.f103160i.getValue()).setVisibility(8);
            return;
        L8:
            ((LinearLayout) this.f103176a.f103159h.getValue()).setVisibility(0);
            ((LiveDoubleColorBallAnimationView) this.f103176a.f103158g.getValue()).setVisibility(8);
            goto L10
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementEntryWidget f103177a;

        public d(AnnouncementEntryWidget r100) {
            this.f103177a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AnnouncementEntryWidget.wq(this.f103177a);
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_announcement_entry;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public final TextView xq() {
        return (TextView) this.f103156e.getValue();
    }

    public final TextView yq() {
        return (TextView) this.f103154c.getValue();
    }

    public final a zq() {
        return (a) this.f103152a.getValue();
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        this.f103164m = null;
    }

    public static final void wq(AnnouncementEntryWidget r110) {
        AnnouncementViewModel r100 = r110.f103161j;
        if (r100 == null) goto L11;
        NextLiveData<AnnouncementInfo> r101 = r100.getAnnouncementInfo();
        if (r101 == null) goto L11;
        AnnouncementInfo r102 = r101.getValue();
        if (r102 == null) goto L11;
        if (r102.auditStatus != 1) goto L11;
        ALogger.d("announcement", "openSettingDialog: auditing,skip open");
        f2.c("公告审核中，请勿重复提交", 0);
        return;
    L11:
        boolean r103 = ((IAnnouncementService) jc1.k.n(IAnnouncementService.class)).getNeedShowFanGroupEntry();
        IAnnouncementService.DialogCloseAction r104 = r110.f103164m;
        if (r104 == null) goto L14;
        r104.close();
    L14:
        AnnouncementSettingDialog2.a r105 = AnnouncementSettingDialog2.f103227y;
        AnnouncementSettingDialog2.a.b(r110.context, r110.f103162k, r110.f103163l, "livepage", r110.f103165n, false, r103, false, r110.f103166o, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_from_page", "setting_panel"), TuplesKt.to(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_take_page")}), new com.bytedance.android.livesdk.announcement.b(r110));
        int r111 = f.f103363a;
        Intrinsics.checkNotNullParameter("livepage", "enterFrom");
        String r112 = ((IUserService) jc1.k.n(IUserService.class)).user().n();
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("anchor_id", r112);
        r106.put("enter_from_merge", "livepage");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_announce_entrance_click", r106, new Object[0]);
    }

    public final void Aq(AnnouncementInfo r100) {
        if (isAlive() == true) goto L6;
        ALogger.d("announcement", "entry widget isAlive -> false !");
        return;
    L6:
        UtilityKotlinExtentionsKt.w(this.containerView);
        if (r100 != null) goto L9;
    L27:
        UtilityKotlinExtentionsKt.t(this.containerView);
        return;
    L9:
        if (r100.available == false) goto L27;
        if (r100.isValid() == true) goto L15;
        UtilityKotlinExtentionsKt.t((RelativeLayout) this.f103153b.getValue());
        UtilityKotlinExtentionsKt.w(yq());
        yq().setText("未设置");
        yq().setOnClickListener(new com.bytedance.android.livesdk.announcement.c(this));
        return;
    L15:
        if (r100.bannedStatus != 1) goto L17;
        long r101 = r100.banFinishTime;
        int r102 = r100.banType;
        UtilityKotlinExtentionsKt.t((RelativeLayout) this.f103153b.getValue());
        UtilityKotlinExtentionsKt.w(yq());
        UtilityKotlinExtentionsKt.t(xq());
        yq().setText("已封禁");
        yq().setClickable(false);
        this.containerView.setOnClickListener(new com.bytedance.android.livesdk.announcement.d(r102, r101));
        return;
    L17:
        UtilityKotlinExtentionsKt.w(yq());
        yq().setClickable(true);
        yq().setText("修改");
        String r103 = r100.scheduledTimeText + " | " + r100.content;
        UtilityKotlinExtentionsKt.w((RelativeLayout) this.f103153b.getValue());
        ((TextView) this.f103155d.getValue()).setText(r103);
        int r104 = r100.auditStatus;
        if (r104 != 1) goto L20;
        UtilityKotlinExtentionsKt.w(xq());
        xq().setText("审核中");
        xq().setBackground(zq().f103171d);
        xq().setTextColor(zq().f103170c);
        return;
    L20:
        if (r104 != 2) goto L22;
        UtilityKotlinExtentionsKt.w(xq());
        xq().setText("未通过");
        yq().setText("去填写");
        ((TextView) this.f103155d.getValue()).setText("上次提交内容未通过审核，请重新填写");
        xq().setBackground(zq().f103173f);
        xq().setTextColor(zq().f103172e);
        return;
    L22:
        if (r104 == 4) goto L24;
        UtilityKotlinExtentionsKt.t(xq());
        return;
    L24:
        yq().setText("去填写");
        ((TextView) this.f103155d.getValue()).setText("上次提交内容已过期，请重新填写");
        ALogger.w("announcement", "AnnouncementEntryWidget: announcement set out-dated,switch:" + r100.switchStatus);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ALogger.d("announcement", "load announce entry widget : request page -> " + this.f103163l + "; live type -> " + this.f103165n + "; light theme : " + this.f103162k);
        UtilityKotlinExtentionsKt.w(this.containerView);
        AnnouncementViewModel.a r101 = AnnouncementViewModel.Companion;
        Context r102 = this.context;
        r101.getClass();
        AnnouncementViewModel r103 = AnnouncementViewModel.a.a(r102);
        if (r103 != null) goto L5;
        r103 = null;
    L22:
        this.f103161j = r103;
        ((TextView) this.f103157f.getValue()).setTextColor(zq().f103168a);
        ((TextView) this.f103155d.getValue()).setTextColor(zq().f103169b);
        ((TextView) this.f103160i.getValue()).setTextColor(zq().f103168a);
        Drawable r104 = zq().f103174g;
        r104.setBounds(0, 0, r104.getIntrinsicWidth(), r104.getIntrinsicHeight());
        yq().setCompoundDrawables(null, null, r104, null);
        yq().setTextColor(zq().f103169b);
        UtilityKotlinExtentionsKt.w(yq());
        yq().setOnClickListener(new d(this));
        this.containerView.setFocusable(true);
        this.containerView.setClickable(true);
        return;
    L5:
        if (this.f103167p == false) goto L7;
        Aq(r103.getAnnouncementInfo().getValue());
    L7:
        AnnouncementViewModel.fetchAnnouncementInfo$default(r103, false, 1, null);
        if ((this.context instanceof LifecycleOwner) == false) goto L20;
        NextLiveData<AnnouncementInfo> r105 = r103.getAnnouncementInfo();
        Object r106 = this.context;
        if (r106 == null) goto L19;
        r105.observe((LifecycleOwner) r106, new b(this));
        if (this.f103167p == true) goto L20;
        NextLiveData<AnnouncementViewModel.b> r107 = r103.getPageStatus();
        Object r108 = this.context;
        if (r108 == null) goto L17;
        r107.observe((LifecycleOwner) r108, new c(this));
        goto L20
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L20:
        Unit r109 = Unit.INSTANCE;
        goto L22
    }

    public AnnouncementEntryWidget(boolean r100, String r101, IAnnouncementService.DialogCloseAction r102, String r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "requestPage");
        Intrinsics.checkNotNullParameter(r103, "liveType");
        this.f103162k = r100;
        this.f103163l = r101;
        this.f103164m = r102;
        this.f103165n = r103;
        this.f103166o = r104;
        this.f103167p = r105;
        this.f103152a = LazyKt.lazy(new AnnouncementEntryWidget$themeInfo$2(this));
        this.f103153b = LazyKt.lazy(new AnnouncementEntryWidget$mLlDescContainer$2(this));
        this.f103154c = LazyKt.lazy(new AnnouncementEntryWidget$mTvStatusGuideDesc$2(this));
        this.f103155d = LazyKt.lazy(new AnnouncementEntryWidget$mTvAnnounceContent$2(this));
        this.f103156e = LazyKt.lazy(new AnnouncementEntryWidget$mTvAnnounceStatus$2(this));
        this.f103157f = LazyKt.lazy(new AnnouncementEntryWidget$mTvAnnouncementTitle$2(this));
        this.f103158g = LazyKt.lazy(new AnnouncementEntryWidget$mDcbLoadingView$2(this));
        this.f103159h = LazyKt.lazy(new AnnouncementEntryWidget$mLLContainer$2(this));
        this.f103160i = LazyKt.lazy(new AnnouncementEntryWidget$mTvNetErrorView$2(this));
    }
}
