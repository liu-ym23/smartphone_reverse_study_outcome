package com.bytedance.android.livesdk.announcement;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdk.announce.AnnouncementVideo;
import com.bytedance.android.livesdk.announce.AnnouncementVideoList;
import com.bytedance.android.livesdk.announcement.viewholder.VideoBindViewBinder;
import com.bytedance.android.livesdk.announcement.viewholder.VideoBindViewTipsBinder;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.config.xd;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementSettingVideoDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementSettingVideoDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f103289p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f103290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f103291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnnouncementInfo f103292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IAnnouncementService.VideoBindDialogListener f103293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f103294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MultiTypeAdapter f103295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f103296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IAnnouncementService.AnnouncementDialogCallback f103297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f103298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<Long> f103299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f103300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f103301o;

    public static final class a {
        public static void a(AnnouncementSettingVideoDialog r100, FragmentManager r101) {
            LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "AnnouncementSettingVideoDialog", r102);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
            return;
        L9:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            r100.showNow(r101, "AnnouncementSettingVideoDialog");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f103302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f103303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f103304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f103305d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f103306e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Drawable f103307f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Drawable f103308g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Drawable f103309h;

        public b() {
            this(null, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, 33554431);
        }

        public b(Drawable r110, Drawable r111, int r210, int r211, Drawable r212, Drawable r213, Drawable r214, Drawable r215, int r216, int r217, Drawable r218, Drawable r219, Drawable r310, Drawable r311, int r312) {
            if ((r312 & 1) == 0) goto L5;
            Drawable r100 = s1.m(R.drawable.ttlive_bg_prelive_setting);
        L7:
            if ((r312 & 2) == 0) goto L9;
            Drawable r101 = s1.m(R.drawable.ttlive_bg_prelive_setting_without_radius);
        L11:
            if ((r312 & 4) == 0) goto L13;
            int r102 = s1.h(R.color.ttlive_douyin_dark_TextPrimary);
        L15:
            if ((r312 & 8) == 0) goto L18;
            s1.h(R.color.ttlive_std_text_white_4);
        L18:
            if ((r312 & 16) == 0) goto L21;
            s1.h(R.color.ttlive_douyin_dark_TextPrimary);
        L21:
            if ((r312 & 32) == 0) goto L24;
            s1.h(R.color.ttlive_std_text_white_3);
        L24:
            if ((r312 & 64) == 0) goto L27;
            s1.h(R.color.ttlive_std_text_white_4);
        L27:
            if ((r312 & 128) == 0) goto L29;
            int r103 = s1.h(R.color.ttlive_douyin_dark_TextPrimary);
        L31:
            if ((r312 & 256) == 0) goto L34;
            s1.h(R.color.ttlive_douyin_dark_TextPrimary);
        L34:
            if ((r312 & 512) == 0) goto L36;
            Drawable r104 = s1.m(R.drawable.ttlive_bg_announcement_submit_btn_selector2);
        L38:
            if ((r312 & 1024) == 0) goto L41;
            s1.h(R.color.ttlive_white);
        L41:
            if ((r312 & 2048) == 0) goto L44;
            s1.h(R.color.ttlive_douyin_dark_DialogDivider);
        L44:
            if ((r312 & 4096) == 0) goto L47;
            s1.h(R.color.ttlive_douyin_dark_Link);
        L47:
            if ((r312 & 8192) == 0) goto L49;
            Drawable r105 = s1.m(R.drawable.ttlive_bg_announcement_fan_group_card);
        L51:
            if ((r312 & 16384) == 0) goto L53;
            Drawable r112 = s1.m(R.drawable.ttlive_bg_announcement_content_edit_text);
        L55:
            if ((32768 & r312) == 0) goto L57;
            Drawable r113 = s1.m(R.drawable.ttlive_ic_announcement_entry_arrow);
        L59:
            if ((65536 & r312) == 0) goto L61;
            int r114 = s1.h(R.color.ttlive_douyin_dark_announce_audit_bg);
        L63:
            if ((131072 & r312) == 0) goto L65;
            int r115 = s1.h(R.color.ttlive_douyin_dark_TextTertiary);
        L67:
            if ((262144 & r312) == 0) goto L69;
            Drawable r116 = s1.m(R.drawable.ttlive_ic_announcement_dark_audit_stauts_tip);
        L71:
            if ((524288 & r312) == 0) goto L74;
            s1.h(R.color.ttlive_douyin_dark_TextPrimary);
        L74:
            if ((1048576 & r312) == 0) goto L76;
            Drawable r106 = s1.m(R.drawable.ttlive_ic_announcement_dark_content_switch);
        L78:
            if ((2097152 & r312) == 0) goto L81;
            s1.h(R.color.ttlive_douyin_dark_switch);
        L81:
            if ((4194304 & r312) == 0) goto L83;
            Drawable r107 = s1.m(R.drawable.ttlive_bg_announcement_fan_group_card);
        L85:
            if ((8388608 & r312) == 0) goto L87;
            Drawable r117 = s1.m(R.drawable.ttlive_bg_announcement_submit_btn_enable);
        L89:
            if ((r312 & 16777216) == 0) goto L91;
            Drawable r108 = s1.m(R.drawable.ttlive_dynamic_back);
        L92:
            Intrinsics.checkNotNullParameter(r100, "bgColorRes");
            Intrinsics.checkNotNullParameter(r101, "bgColorResWithOutRadius");
            Intrinsics.checkNotNullParameter(r104, "submitBtnBgRes");
            Intrinsics.checkNotNullParameter(r105, "fanGroupChooseAreaBg");
            Intrinsics.checkNotNullParameter(r112, "editBgDrawable");
            Intrinsics.checkNotNullParameter(r113, "timeArrowDrawable");
            Intrinsics.checkNotNullParameter(r116, "auditStatusLeftDrawable");
            Intrinsics.checkNotNullParameter(r106, "switchLeftDrawable");
            Intrinsics.checkNotNullParameter(r107, "submitButtonDisable");
            Intrinsics.checkNotNullParameter(r117, "submitButtonEnable");
            Intrinsics.checkNotNullParameter(r108, "backIvDrawable");
            this.f103302a = r100;
            this.f103303b = r102;
            this.f103304c = r103;
            this.f103305d = r114;
            this.f103306e = r115;
            this.f103307f = r107;
            this.f103308g = r117;
            this.f103309h = r108;
            return;
        L91:
            r108 = r311;
            goto L92
        L87:
            r117 = null;
            goto L89
        L83:
            r107 = r310;
            goto L85
        L76:
            r106 = r219;
            goto L78
        L69:
            r116 = r218;
            goto L71
        L65:
            r115 = r217;
            goto L67
        L61:
            r114 = r216;
            goto L63
        L57:
            r113 = r215;
            goto L59
        L53:
            r112 = r214;
            goto L55
        L49:
            r105 = r213;
            goto L51
        L36:
            r104 = r212;
            goto L38
        L29:
            r103 = r211;
            goto L31
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    static {
    }

    public final b T90() {
        return (b) this.f103301o.getValue();
    }

    public AnnouncementSettingVideoDialog() {
        this.f103290d = new LinkedHashMap();
        this.f103291e = true;
        this.f103294h = -1L;
        new ArrayList();
        this.f103299m = new LinkedHashSet();
        this.f103301o = LazyKt.lazy(new AnnouncementSettingVideoDialog$themeInfo$2(this));
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f103290d.clear();
    }

    public final View S90(int r100) {
        if (this.f103290d != null) goto L5;
        this.f103290d = new LinkedHashMap();
    L5:
        View r101 = this.f103290d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f103290d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void U90(BaseResponse<AnnouncementVideoList, Extra> r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        AnnouncementVideoList r100 = r110.data;
        String r101 = "related_annoucement";
        if (r100 != null) goto L14;
        ((AppCompatTextView) S90(R.id.no_video_tv)).setVisibility(0);
        ((Button) S90(R.id.confirm_btn)).setBackground(T90().f103307f);
        ((Button) S90(R.id.confirm_btn)).setEnabled(false);
        com.bytedance.android.livesdk.log.g r111 = com.bytedance.android.livesdk.log.u.l();
        int r112 = f.f103363a;
        HashMap r113 = new HashMap();
        r113.put("able_video_cnt", "0");
        if (this.f103298l == false) goto L7;
        Object r114 = "related_annoucement";
    L8:
        r113.put("enter_from", r114);
        Unit r115 = Unit.INSTANCE;
        Integer r116 = this.f103300n;
        if (r116 == null) goto L11;
        int r117 = r116.intValue();
    L12:
        f.a(r113, r117);
        r111.sendLog("livesdk_live_announce_setting_add_video_show", r113, new Object[0]);
        goto L14
    L11:
        r117 = 0;
        goto L12
    L7:
        r114 = "create_annoucement";
    L14:
        if (r100 == null) goto L52;
        List<AnnouncementVideo> r118 = r100.getVideoList();
        if (r118 == null) goto L52;
        Iterator<AnnouncementVideo> r119 = r118.iterator();
    L19:
        if (r119.hasNext() == false) goto L23;
        AnnouncementVideo r120 = r119.next();
        if (this.f103299m.contains(Long.valueOf(r120.getItemId())) == false) goto L19;
        r120.setSelected(true);
        goto L19
    L23:
        ArrayList r121 = new ArrayList();
        r121.addAll(r100.getVideoList());
        if (((AnnouncementVideo) CollectionsKt.firstOrNull(r118)) == null) goto L26;
        r121.add("");
    L26:
        MultiTypeAdapter r102 = this.f103295i;
        if (r102 == null) goto L29;
        r102.f513437a = r121;
    L29:
        if (r102 == null) goto L31;
        r102.notifyDataSetChanged();
    L31:
        AppCompatTextView r103 = (AppCompatTextView) S90(R.id.no_video_tv);
        List<AnnouncementVideo> r104 = r118;
        if ((!r104.isEmpty()) == false) goto L34;
        int r122 = 8;
    L35:
        r103.setVisibility(r122);
        Button r105 = (Button) S90(R.id.confirm_btn);
        if ((!r104.isEmpty()) == false) goto L38;
        Drawable r123 = T90().f103308g;
    L39:
        r105.setBackground(r123);
        Button r106 = (Button) S90(R.id.confirm_btn);
        if ((!r104.isEmpty()) != true) goto L42;
        boolean r107 = true;
    L43:
        r106.setEnabled(r107);
        com.bytedance.android.livesdk.log.g r108 = com.bytedance.android.livesdk.log.u.l();
        int r109 = f.f103363a;
        HashMap r124 = new HashMap();
        r124.put("able_video_cnt", String.valueOf(r118.size()));
        if (this.f103298l == true) goto L47;
        r101 = "create_annoucement";
    L47:
        r124.put("enter_from", r101);
        Unit r125 = Unit.INSTANCE;
        Integer r126 = this.f103300n;
        if (r126 == null) goto L50;
        int r127 = r126.intValue();
    L51:
        f.a(r124, r127);
        r108.sendLog("livesdk_live_announce_setting_add_video_show", r124, new Object[0]);
        goto L52
    L50:
        r127 = 0;
        goto L51
    L42:
        r107 = false;
        goto L43
    L38:
        r123 = T90().f103307f;
        goto L39
    L34:
        r122 = 0;
    L52:
        AppCompatTextView r128 = (AppCompatTextView) S90(R.id.selected_count_tv);
        if (r128 == null) goto L61;
        r128.setText(s1.C(R.string.ttlive_annocement_startlive_selected, new Object[]{Integer.valueOf(this.f103299m.size())}));
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        Dialog r101 = getDialog();
        if (r101 == null) goto L5;
        r101.setCanceledOnTouchOutside(true);
    L5:
        super.onActivityCreated(r100);
        Dialog r102 = getDialog();
        if (r102 == null) goto L11;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L12;
        r103.setGravity(80);
        WindowManager.LayoutParams r104 = r103.getAttributes();
        r104.width = -1;
        r104.height = s1.w() - s1.A();
        r103.setAttributes(r104);
        r103.setSoftInputMode(32);
        r103.clearFlags(1024);
        com.bytedance.android.live.core.utils.statusbar.a.f66401b.a();
        r103.addFlags(Integer.MIN_VALUE);
        r103.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog_normal);
        setShouldUseNewPanel(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.requestFeature(1);
    L7:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
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
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        ((RecyclerView) S90(R.id.video_bind_list)).setOverScrollMode(2);
        SSGridLayoutManager r111 = new SSGridLayoutManager(getContext(), 3);
        ((RecyclerView) S90(R.id.video_bind_list)).setLayoutManager(r111);
        MultiTypeAdapter r101 = new MultiTypeAdapter();
        r101.z2(AnnouncementVideo.class, new VideoBindViewBinder(this.f103299m, new AnnouncementSettingVideoDialog$initViews$$inlined$apply$lambda$1(this)));
        r101.z2(String.class, new VideoBindViewTipsBinder());
        Unit r102 = Unit.INSTANCE;
        this.f103295i = r101;
        r111.setSpanSizeLookup(new AnnouncementSettingVideoDialog$initViews$2(this));
        ((RecyclerView) S90(R.id.video_bind_list)).addItemDecoration(new AnnouncementSettingVideoDialog$initViews$3());
        ((RecyclerView) S90(R.id.video_bind_list)).setAdapter(this.f103295i);
        new LinearLayoutManager(getContext()).setOrientation(0);
        ((Button) S90(R.id.confirm_btn)).setOnClickListener(new q0(this));
        ((ImageView) S90(R.id.mIvBack)).setOnClickListener(new r0(this));
        ((FrameLayout) S90(R.id.mLlAnnouncementDialogRoot)).setBackground(T90().f103302a);
        ((AppCompatTextView) S90(R.id.video_bind_title_tv)).setTextColor(T90().f103303b);
        ((AppCompatTextView) S90(R.id.selected_count_tv)).setTextColor(T90().f103304c);
        ((ImageView) S90(R.id.mIvBack)).setImageDrawable(T90().f103309h);
        ((TextView) S90(R.id.tip_text)).setBackgroundColor(T90().f103305d);
        ((TextView) S90(R.id.tip_text)).setTextColor(T90().f103306e);
        ((AppCompatTextView) S90(R.id.no_video_tv)).setTextColor(T90().f103304c);
        AnnouncementInfo r103 = this.f103292f;
        if (r103 == null) goto L18;
        this.f103299m.addAll(r103.getSelectedVideoItemIds());
        xd r104 = xd.f121594a;
        if (r104.getValue().booleanValue() == false) goto L7;
        ((TextView) S90(R.id.tip_text)).setVisibility(8);
    L10:
        AppCompatTextView r105 = (AppCompatTextView) S90(R.id.selected_count_tv);
        if (r105 == null) goto L14;
        r105.setText(s1.C(R.string.ttlive_annocement_startlive_selected, new Object[]{Integer.valueOf(this.f103299m.size())}));
    L14:
        if (r104.getValue().booleanValue() == false) goto L16;
        ((AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class)).getAnnouncementVideoList(r103.announcementId, 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new m0(this), o0.f103534a);
        return;
    L16:
        AnnouncementApi.CC.getAnnouncementVideoList$default((AnnouncementApi) com.bytedance.android.live.network.c.b().e(AnnouncementApi.class), r103.announcementId, 0, 2, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new n0(this), p0.f103536a);
        return;
    L7:
        Long r106 = this.f103294h;
        if (r106 == null) goto L10;
        long r107 = r106.longValue();
        ((TextView) S90(R.id.tip_text)).setText(s1.C(R.string.ttlive_annocement_startlive_tips, new Object[]{com.bytedance.android.livesdk.announce.c.a(r107)}));
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_announcement_setting_video, r101, false);
    }
}
