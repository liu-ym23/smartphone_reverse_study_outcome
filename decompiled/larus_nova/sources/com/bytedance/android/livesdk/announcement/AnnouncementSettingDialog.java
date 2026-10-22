package com.bytedance.android.livesdk.announcement;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.announce.AnnouncementInfo;
import com.bytedance.android.livesdk.announcement.entities.AnnouncementRandomContent;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated(message = "使用AnnouncementSettingDialog 本来要开实验结果又不开了我去")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/announcement/AnnouncementSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementSettingDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f103196j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f103197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f103198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f103199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f103200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f103201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnnouncementViewModel f103202i;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f103203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f103204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f103205c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f103206d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f103207e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f103208f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f103209g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Drawable f103210h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f103211i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f103212j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f103213k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Drawable f103214l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Drawable f103215m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f103216n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f103217o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Drawable f103218p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f103219q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Drawable f103220r;

        public b() {
            this(0);
        }

        public /* synthetic */ b(int r210) {
            this(s1.m(R.drawable.ttlive_bg_prelive_setting), s1.h(R.color.ttlive_douyin_dark_TextPrimary), s1.h(R.color.ttlive_douyin_dark_TextReverse3), s1.h(R.color.ttlive_douyin_dark_TextPrimary), s1.h(R.color.ttlive_douyin_dark_TextPrimary), s1.h(R.color.ttlive_douyin_dark_TextPrimary), s1.h(R.color.ttlive_douyin_dark_TextPrimary), s1.m(R.drawable.ttlive_bg_announcement_submit_btn_selector), s1.h(R.color.ttlive_white), s1.h(R.color.ttlive_douyin_dark_DialogDivider), s1.h(R.color.ttlive_douyin_dark_Link), s1.m(R.drawable.ttlive_bg_announcement_content_edit_text), s1.m(R.drawable.ttlive_ic_announcement_entry_arrow), s1.h(R.color.ttlive_douyin_dark_announce_audit_bg), s1.h(R.color.ttlive_douyin_dark_TextTertiary), s1.m(R.drawable.ttlive_ic_announcement_dark_audit_stauts_tip), s1.h(R.color.ttlive_douyin_dark_TextPrimary), s1.m(R.drawable.ttlive_ic_announcement_dark_content_switch));
        }

        public b(Drawable r100, int r110, int r111, int r112, int r113, int r114, int r115, Drawable r116, int r117, int r118, int r119, Drawable r210, Drawable r211, int r212, int r213, Drawable r214, int r215, Drawable r216) {
            Intrinsics.checkNotNullParameter(r100, "bgColorRes");
            Intrinsics.checkNotNullParameter(r116, "submitBtnBgRes");
            Intrinsics.checkNotNullParameter(r210, "editBgDrawable");
            Intrinsics.checkNotNullParameter(r211, "timeArrowDrawable");
            Intrinsics.checkNotNullParameter(r214, "auditStatusLeftDrawable");
            Intrinsics.checkNotNullParameter(r216, "switchLeftDrawable");
            this.f103203a = r100;
            this.f103204b = r110;
            this.f103205c = r111;
            this.f103206d = r112;
            this.f103207e = r113;
            this.f103208f = r114;
            this.f103209g = r115;
            this.f103210h = r116;
            this.f103211i = r117;
            this.f103212j = r118;
            this.f103213k = r119;
            this.f103214l = r210;
            this.f103215m = r211;
            this.f103216n = r212;
            this.f103217o = r213;
            this.f103218p = r214;
            this.f103219q = r215;
            this.f103220r = r216;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementSettingDialog f103221a;

        public c(AnnouncementSettingDialog r100) {
            this.f103221a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            AnnouncementInfo r111 = (AnnouncementInfo) r110;
            ALogger.d("announcement", "announce setting dialog observe announce info changed");
            UtilityKotlinExtentionsKt.w(this.f103221a.S90(R.id.mLlAnnouncementDialogContainer));
            AnnouncementSettingDialog r100 = this.f103221a;
            if (r111 != null) goto L5;
            r100.getClass();
        L33:
            AnnouncementViewModel r112 = this.f103221a.f103202i;
            if (r112 == null) goto L39;
            r112.checkSubmitBtnStatus();
            return;
        L39:
            return;
        L5:
            ((EditText) r100.S90(R.id.mEtAnnouncementDialogContent)).setText(r111.content);
            ((EditText) r100.S90(R.id.mEtAnnouncementDialogContent)).setSelection(((EditText) r100.S90(R.id.mEtAnnouncementDialogContent)).getText().length());     // Catch: Exception -> L8
        L11:
            if (r111.getTip().length() <= 0) goto L13;
            boolean r101 = true;
        L14:
            if (r101 == false) goto L24;
            SpannableStringBuilder r102 = new SpannableStringBuilder(r111.getTip());
            if (r111.getTipUrl().length() <= 0) goto L18;
            boolean r103 = true;
        L20:
            if (r103 == false) goto L22;
            String r104 = " " + r111.getUrlDesc();
            int r105 = r102.length();
            int r106 = r104.length() + r105;
            r102.append(r104);
            r102.setSpan(new p(r100), r105, r106, 34);
            ((AppCompatTextView) r100.S90(R.id.mTvAnnouncementTip)).setMovementMethod(LinkMovementMethod.getInstance());
        L22:
            ((AppCompatTextView) r100.S90(R.id.mTvAnnouncementTip)).setText(r102);
            goto L24
        L18:
            r103 = false;
        L24:
            if (r111.reachMaxUpdateLimit == false) goto L26;
            ((EditText) r100.S90(R.id.mEtAnnouncementDialogContent)).setFocusable(false);
            ((EditText) r100.S90(R.id.mEtAnnouncementDialogContent)).setFocusableInTouchMode(false);
            ((EditText) r100.S90(R.id.mEtAnnouncementDialogContent)).setOnClickListener(o.f103533a);
            UtilityKotlinExtentionsKt.t(r100.S90(R.id.mTtAnnouncementSwitchContent));
            UtilityKotlinExtentionsKt.t(r100.S90(R.id.mTvAnnouncementInputTip));
        L26:
            int r113 = r111.auditStatus;
            if (r113 != 1) goto L29;
            UtilityKotlinExtentionsKt.w(r100.S90(R.id.mTvAnnouncementDialogAuditStatus));
            ((TextView) r100.S90(R.id.mTvAnnouncementDialogAuditStatus)).setText("直播公告审核中");
            goto L33
        L29:
            if (r113 == 2) goto L31;
            UtilityKotlinExtentionsKt.t(r100.S90(R.id.mTvAnnouncementDialogAuditStatus));
            goto L33
        L31:
            UtilityKotlinExtentionsKt.w(r100.S90(R.id.mTvAnnouncementDialogAuditStatus));
            ((TextView) r100.S90(R.id.mTvAnnouncementDialogAuditStatus)).setText("直播公告审核不通过");
            goto L33
        L13:
            r101 = false;
        L8:
            e = move-exception;
            e.printStackTrace();
            goto L11
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementSettingDialog f103222a;

        public d(AnnouncementSettingDialog r100) {
            this.f103222a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AnnouncementViewModel.b r101 = (AnnouncementViewModel.b) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f103311a == false) goto L8;
            UtilityKotlinExtentionsKt.w(this.f103222a.S90(R.id.mDcbLoadingView));
            ((LiveDoubleColorBallAnimationView) this.f103222a.S90(R.id.mDcbLoadingView)).b();
        L10:
            if (r101.f103312b == false) goto L19;
            this.f103222a.dismiss();     // Catch: Exception -> L14
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L19;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        L19:
            if (r101.f103313c == false) goto L21;
            UtilityKotlinExtentionsKt.u(this.f103222a.S90(R.id.mLlAnnouncementDialogContainer));
            UtilityKotlinExtentionsKt.w(this.f103222a.S90(R.id.mTvNetError));
            return;
        L21:
            UtilityKotlinExtentionsKt.w(this.f103222a.S90(R.id.mLlAnnouncementDialogContainer));
            UtilityKotlinExtentionsKt.t(this.f103222a.S90(R.id.mTvNetError));
            return;
        L8:
            UtilityKotlinExtentionsKt.t(this.f103222a.S90(R.id.mDcbLoadingView));
            ((LiveDoubleColorBallAnimationView) this.f103222a.S90(R.id.mDcbLoadingView)).c();
            goto L10
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementSettingDialog f103223a;

        public e(AnnouncementSettingDialog r100) {
            this.f103223a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.livesdk.announce.b r101 = (com.bytedance.android.livesdk.announce.b) r100;
            if (r101 == null) goto L14;
            AppCompatTextView r102 = (AppCompatTextView) this.f103223a.S90(R.id.mTvAnnouncementDialogTimeDesc);
            if (r101.f103132c.length() <= 0) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            String r104 = r101.f103132c;
        L12:
            r102.setText(r104);
            return;
        L11:
            r104 = r101.b();
            goto L12
        L8:
            r103 = false;
            goto L9
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementSettingDialog f103224a;

        public f(AnnouncementSettingDialog r100) {
            this.f103224a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AnnouncementRandomContent r101 = (AnnouncementRandomContent) r100;
            EditText r102 = (EditText) this.f103224a.S90(R.id.mEtAnnouncementDialogContent);
            if (r101 == null) goto L6;
            String r103 = r101.getContent();
            if (r103 == null) goto L6;
        L7:
            r102.setText(r103);
            ((ConstraintLayout) this.f103224a.S90(R.id.mEtAnnouncementDialogEtContentParent)).requestFocus();
            return;
        L6:
            r103 = "";
            goto L7
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementSettingDialog f103225a;

        public g(AnnouncementSettingDialog r100) {
            this.f103225a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AnnouncementSettingDialog r101 = this.f103225a;
            boolean r102 = Intrinsics.areEqual((Boolean) r100, Boolean.TRUE);
            int r103 = AnnouncementSettingDialog.f103196j;
            if (r102 == false) goto L5;
            ((AppCompatTextView) r101.S90(R.id.mTvAnnouncementSubmitBtn)).setAlpha(1.0f);
            return;
        L5:
            ((AppCompatTextView) r101.S90(R.id.mTvAnnouncementSubmitBtn)).setAlpha(0.5f);
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnouncementSettingDialog f103226a;

        public h(AnnouncementSettingDialog r100) {
            this.f103226a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AnnouncementViewModel.c r101 = (AnnouncementViewModel.c) r100;
            if (this.f103226a.getContext() == null) goto L10;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.f103315b == false) goto L8;
            lm3.c r102 = new lm3.c();
            r102.f509864b = "取消";
            lm3.c r103 = new lm3.c();
            r103.f509864b = "确认";
            r103.f509865c = new n(this);
            Context r104 = this.f103226a.getContext();
            Intrinsics.checkNotNull(r104);
            lm3.d.a r105 = new lm3.d.a(r104);
            r105.f509871b = r101.f103314a;
            r105.f509874e = CollectionsKt.listOf(new lm3.c[]{r102, r103});
            r105.a();
            return;
        L8:
            f2.c(r101.f103314a, 0);
            return;
        }
    }

    static {
    }

    public final b T90() {
        return (b) this.f103199f.getValue();
    }

    public AnnouncementSettingDialog() {
        this.f103197d = new LinkedHashMap();
        setNoTitleAndCancelOutside(true);
        this.f103198e = "";
        this.f103199f = LazyKt.lazy(new AnnouncementSettingDialog$themeInfo$2(this));
        this.f103200g = "";
        this.f103201h = 40;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
    L8:
        AnnouncementViewModel r100 = this.f103202i;
        if (r100 == null) goto L16;
        NextLiveData<AnnouncementInfo> r101 = r100.getAnnouncementInfo();
        if (r101 == null) goto L16;
        AnnouncementInfo r102 = r101.getValue();
        if (r102 == null) goto L16;
        if (r102.getEditTime() != true) goto L16;
        return;
    L16:
        AnnouncementViewModel r103 = this.f103202i;
        if (r103 == null) goto L27;
        NextLiveData<AnnouncementInfo> r104 = r103.getAnnouncementInfo();
        if (r104 == null) goto L28;
        AnnouncementInfo r105 = r104.getValue();
        if (r105 == null) goto L29;
        r105.getEditContent();
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r106 = DialogFragmentLancet.sLastShowStack;
        if (r106 == null) goto L8;
        com.bytedance.crash.d.d(r106, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f103197d.clear();
    }

    public final View S90(int r100) {
        if (this.f103197d != null) goto L5;
        this.f103197d = new LinkedHashMap();
    L5:
        View r101 = this.f103197d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f103197d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L10;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L11;
        r102.setGravity(80);
        r102.setLayout(-1, fm3.e.b(getContext()));
        r102.setSoftInputMode(16);
        r102.clearFlags(1024);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        if (IAnnouncementService.Companion.dimDialogBackground(this.f103200g) == false) goto L12;
        r102.addFlags(2);
        r102.setDimAmount(0.5f);
        return;
    L12:
        return;
    L11:
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
        ALogger.d("announcement", "announce setting dialog view create");
        AppCompatTextView r102 = (AppCompatTextView) S90(R.id.mTvAnnouncementDialogTimeDesc);
        if (r102 == null) goto L5;
        r102.setOnClickListener(new com.bytedance.android.livesdk.announcement.h(this));
    L5:
        ((EditText) S90(R.id.mEtAnnouncementDialogContent)).addTextChangedListener(new i(this));
        m r103 = new m(this);
        EditText r104 = (EditText) S90(R.id.mEtAnnouncementDialogContent);
        boolean r105 = true;
        if (r104 == null) goto L8;
        r104.setFilters(new InputFilter[]{r103, new InputFilter.LengthFilter(this.f103201h)});
    L8:
        ((EditText) S90(R.id.mEtAnnouncementDialogContent)).getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
        ((TextView) S90(R.id.mTtAnnouncementSwitchContent)).setOnClickListener(new k(this));
        ((AppCompatTextView) S90(R.id.mTvAnnouncementSubmitBtn)).setOnClickListener(new l(this));
        ((FrameLayout) S90(R.id.mLlAnnouncementDialogRoot)).setBackground(T90().f103203a);
        ((AppCompatTextView) S90(R.id.mTvAnnouncementDialogTitle)).setTextColor(T90().f103204b);
        ((AppCompatTextView) S90(R.id.mTvAnnouncementTip)).setTextColor(T90().f103205c);
        ((AppCompatTextView) S90(R.id.mTvAnnouncementDialogTimeTitle)).setTextColor(T90().f103206d);
        ((AppCompatTextView) S90(R.id.mTvAnnouncementDialogTimeDesc)).setTextColor(T90().f103207e);
        ((AppCompatTextView) S90(R.id.mTvAnnouncementDialogContentTitle)).setTextColor(T90().f103208f);
        ((EditText) S90(R.id.mEtAnnouncementDialogContent)).setTextColor(T90().f103209g);
        ((AppCompatTextView) S90(R.id.mTvAnnouncementSubmitBtn)).setBackground(T90().f103210h);
        ((AppCompatTextView) S90(R.id.mTvAnnouncementSubmitBtn)).setTextColor(T90().f103211i);
        S90(R.id.mTvAnnouncementDialogDividerLine1).setBackgroundColor(T90().f103212j);
        S90(R.id.mTvAnnouncementDialogDividerLine2).setBackgroundColor(T90().f103212j);
        ((EditText) S90(R.id.mEtAnnouncementDialogContent)).setBackground(T90().f103214l);
        Drawable r106 = T90().f103215m;
        r106.setBounds(0, 0, r106.getIntrinsicWidth(), r106.getIntrinsicHeight());
        AnnouncementViewModel r107 = null;
        ((AppCompatTextView) S90(R.id.mTvAnnouncementDialogTimeDesc)).setCompoundDrawables(null, null, r106, null);
        ((AppCompatTextView) S90(R.id.mTvAnnouncementDialogTimeDesc)).setCompoundDrawablePadding(s1.f(8.0f));
        ((TextView) S90(R.id.mTvAnnouncementDialogAuditStatus)).setBackgroundColor(T90().f103216n);
        Drawable r108 = T90().f103220r;
        r108.setBounds(0, 0, r108.getIntrinsicWidth(), r108.getIntrinsicHeight());
        ((TextView) S90(R.id.mTtAnnouncementSwitchContent)).setCompoundDrawables(r108, null, null, null);
        ((TextView) S90(R.id.mTtAnnouncementSwitchContent)).setTextColor(T90().f103219q);
        Drawable r109 = T90().f103218p;
        r109.setBounds(0, 0, r109.getIntrinsicWidth(), r109.getIntrinsicHeight());
        ((TextView) S90(R.id.mTvAnnouncementDialogAuditStatus)).setCompoundDrawables(r109, null, null, null);
        ((TextView) S90(R.id.mTvAnnouncementDialogAuditStatus)).setTextColor(T90().f103217o);
        AnnouncementViewModel.a r110 = AnnouncementViewModel.Companion;
        FragmentActivity r111 = getActivity();
        r110.getClass();
        AnnouncementViewModel r112 = AnnouncementViewModel.a.a(r111);
        if (r112 == null) goto L11;
        r112.setRequestPage(this.f103200g);
        r112.setLiveType(this.f103198e);
        AnnouncementViewModel.fetchAnnouncementInfo$default(r112, false, 1, null);
        r112.getAnnouncementInfo().observe(this, new c(this));
        r112.getPageStatus().observe(this, new d(this));
        r112.getDateInfo().observe(this, new e(this));
        r112.getRandomContent().observe(this, new f(this));
        r112.getSubmitBtnEnable().observe(this, new g(this));
        r112.getSubmitTip().observe(this, new h(this));
        Unit r113 = Unit.INSTANCE;
        r107 = r112;
    L11:
        this.f103202i = r107;
        int r114 = com.bytedance.android.livesdk.announcement.f.f103363a;
        String r115 = this.f103200g;
        String r116 = this.f103198e;
        Intrinsics.checkNotNullParameter(r115, "requestPage");
        Intrinsics.checkNotNullParameter(r116, "liveType");
        Intrinsics.checkNotNullParameter("", "enterFrom");
        String r117 = ((IUserService) jc1.k.n(IUserService.class)).user().n();
        HashMap r118 = new HashMap();
        r118.put("anchor_id", r117);
        r118.put("request_page", r115);
        if (r116.length() > 0) goto L15;
        r105 = false;
    L15:
        if (r105 == false) goto L17;
        r118.put("live_type", r116);
    L17:
        r118.put("enter_from_merge", "");
        r118.put("enter_from", "");
        r118.put("choose_video_cnt", String.valueOf(0));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_announce_setting_all_show", r118, new Object[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_announcement_setting, r101, false);
    }
}
