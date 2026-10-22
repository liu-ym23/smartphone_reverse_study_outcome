package com.obric.autoaction.app.launcherpage.module.view;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.module.a.i;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.layout.OUIRelativeLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AutoActionTaskListItemTaskView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionTaskListItemTaskView extends OUIRelativeLayout {
    public static final a Companion = null;
    private static final String KEY_MSG_ID = "msg_id";
    private static final String KEY_TASK_ID = "omni_task_id";
    private static final String OMNI_FEEDBACK_ACTIVITY = "com.obric.assistant.tipoff.ObricTipOffDialogActivity";
    private static final String O_AUTO_PACKAGE_NAME = "com.larus.nova";
    private final OTextView content;
    private final View mBtnRelaunchTask;
    private final View mBtnTaskFeedback;
    private final View mBtnTaskShare;
    private final ConstraintLayout mFirstLine;
    private long mTimeOfLastFailedRetryAttempt;
    private final View mView;
    private final OTextView title;

    /* JADX INFO: compiled from: AutoActionTaskListItemTaskView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AutoActionTaskListItemTaskView.kt */
    @d.c.b.a.f(b = "AutoActionTaskListItemTaskView.kt", c = {BDImageUploader.MessageIsPreHeatResultUsed}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.module.view.AutoActionTaskListItemTaskView$fitData$2$1$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f24282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autoaction.app.launcherpage.module.a.a.h f24283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AutoActionTaskListItemTaskView f24284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f24285e;

        b(View r3, com.obric.autoaction.app.launcherpage.module.a.a.h r4, AutoActionTaskListItemTaskView r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24282b = r3;
            this.f24283c = r4;
            this.f24284d = r5;
            super(2, r7);
        }

        private static final String a() {
            return "url=  (fetched-anew)";
        }

        public static /* synthetic */ String lambda$TzuPhE407pz_h1ijVuNjgZk9SEA(String r0) {
            return a(r0);
        }

        public static /* synthetic */ String lambda$WJrpEVBg2qr3Qi66hXIkVWhODWg() {
            return a();
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f24282b, this.f24283c, this.f24284d, r7);
            r0.f24285e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f24281a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            am r2 = (am) ZeusTransformUtils.preCheckCast(this.f24285e, am.class, "com.obric.aiagent.plugin");
            o.a(r12);
        L12:
            IAutoActionAgentApi.SessionShareInfo r13 = (IAutoActionAgentApi.SessionShareInfo) ZeusTransformUtils.preCheckCast(r12, IAutoActionAgentApi.SessionShareInfo.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L15;
            final String r5 = r13.getShareUrl();
        L16:
            if (r5 != null) goto L19;
            this.f24282b.setEnabled(true);
            return x.f38692a;
        L19:
            if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L21;
            this.f24282b.setEnabled(false);
            AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.agent_task_share_url_fetch_empty, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_share_url_fetch_empty"), false, 4, null);
            return x.f38692a;
        L21:
            this.f24282b.setEnabled(true);
            this.f24283c.a(r5);
            Loog.INSTANCE.ip(LogUtil.INSTANCE.getCLAZZ_TAG(r2), new $$Lambda$AutoActionTaskListItemTaskView$b$TzuPhE407pz_h1ijVuNjgZk9SEA(r5), $$Lambda$AutoActionTaskListItemTaskView$b$WJrpEVBg2qr3Qi66hXIkVWhODWg.INSTANCE);
            IAutoActionPresentationApi r3 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L27;
            Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f24284d.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.c(r11, "getContext(...)");
            r3.openSharingWebView(r11, r5, r13.getSessionId(), "oauto_task_list_page");
            return x.f38692a;
        L27:
            return null;
        L15:
            r5 = null;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            am r14 = (am) ZeusTransformUtils.preCheckCast(this.f24285e, am.class, "com.obric.aiagent.plugin");
            this.f24282b.setEnabled(false);
            AutoActionAgent r4 = AutoActionAgent.INSTANCE;
            String r6 = this.f24283c.h();
            d.c.d<? super IAutoActionAgentApi.SessionShareInfo> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f24285e = r14;
            this.f24281a = 1;
            Object r8 = r4.fetchSessionShareUrl(r6, r7);
            if (r8 != r0) goto L11;
            return r0;
        L11:
            r2 = r14;
            r12 = r8;
            goto L12
        }

        private static final String a(String r2) {
            return "url=" + r2 + " (fetched-anew)";
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoActionTaskListItemTaskView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AutoActionTaskListItemTaskView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    private static final String fitData$lambda$7$lambda$6$lambda$5() {
        return "url=";
    }

    /* JADX INFO: renamed from: lambda$-9erX6ziaI-xBpQp6aFGgbdO89o, reason: not valid java name */
    public static /* synthetic */ void m551lambda$9erX6ziaIxBpQp6aFGgbdO89o(com.obric.autoaction.app.launcherpage.module.a.a.h r0, AutoActionTaskListItemTaskView r1, String r2, View r3) {
        fitData$lambda$7$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$HeDHK3P3WB7kNeGsWlm7_p0iFWU(AutoActionTaskListItemTaskView r0, com.obric.autoaction.app.launcherpage.module.a.a.h r1, View r2) {
        fitData$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ String lambda$hJ2I75nG9v7Q0lhlS5JAvdb0uIU() {
        return fitData$lambda$7$lambda$6$lambda$5();
    }

    public static /* synthetic */ void lambda$uy0W1b9Nhv6nmFdGDPi_PfeXZMM(AutoActionTaskListItemTaskView r0, String r1, String r2, View r3) {
        fitData$lambda$3$lambda$2(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$wVNctDpxnBekNNRoFEeYXwldj-E, reason: not valid java name */
    public static /* synthetic */ String m552lambda$wVNctDpxnBekNNRoFEeYXwldjE(String r0) {
        return fitData$lambda$7$lambda$6$lambda$4(r0);
    }

    public /* synthetic */ AutoActionTaskListItemTaskView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public AutoActionTaskListItemTaskView(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        super(r13, r4, r12, null, 8, null);
        View r14 = ZeusTransformUtils.inflate(LayoutInflater.from(r13), ZeusTransformUtils.mapRes(R.layout.autoaction_task_list_item, "layout", "autoaction_task_list_item"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        d.h.b.o.c(r14, "inflate(...)");
        this.mView = r14;
        this.mFirstLine = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r14.findViewById(ZeusTransformUtils.mapRes(R.id.first_line_group, DbHelper.COL_ID, "first_line_group")), ConstraintLayout.class, "com.obric.aiagent.plugin");
        View r15 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE));
        d.h.b.o.c(r15, "findViewById(...)");
        this.title = (OTextView) ZeusTransformUtils.preCheckCast(r15, OTextView.class, "com.obric.aiagent.plugin");
        View r16 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.content, DbHelper.COL_ID, "content"));
        d.h.b.o.c(r16, "findViewById(...)");
        this.content = (OTextView) ZeusTransformUtils.preCheckCast(r16, OTextView.class, "com.obric.aiagent.plugin");
        this.mBtnTaskFeedback = r14.findViewById(ZeusTransformUtils.mapRes(R.id.btn_tli_task_feedback, DbHelper.COL_ID, "btn_tli_task_feedback"));
        View r17 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.btn_tli_task_share, DbHelper.COL_ID, "btn_tli_task_share"));
        d.h.b.o.a(r17);
        if (f.f24296a.a() == false) goto L5;
        int r3 = 0;
    L6:
        r17.setVisibility(r3);
        this.mBtnTaskShare = r17;
        this.mBtnRelaunchTask = r14.findViewById(ZeusTransformUtils.mapRes(R.id.btn_tli_task_relaunch, DbHelper.COL_ID, "btn_tli_task_relaunch"));
        setChangeAlphaWhenPress(false);
        OStateGradientDrawable r18 = new OStateGradientDrawable();
        ColorStateList r5 = androidx.core.content.a.b(r13, ZeusTransformUtils.mapRes(R.color.o_card_list_item_content_bg_color, "color", "o_card_list_item_content_bg_color"));
        if (r5 == null) goto L9;
        r18.setSolidColors(r5);
    L9:
        r14.findViewById(ZeusTransformUtils.mapRes(R.id.task_view_root_container, DbHelper.COL_ID, "task_view_root_container")).setBackground((Drawable) ZeusTransformUtils.preCheckCast(r18, Drawable.class, "com.obric.aiagent.plugin"));
        setBackgroundColor(p.b(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, "color", "oui_fill_list_item_card"), r13, null, 2, null));
        setRadius(d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final ConstraintLayout getMFirstLine() {
        return this.mFirstLine;
    }

    public final OTextView getContent() {
        return this.content;
    }

    public final OTextView getTitle() {
        return this.title;
    }

    public final void fitData(final com.obric.autoaction.app.launcherpage.module.a.a.h r9, i r10) {
        i r11 = (i) ZeusTransformUtils.wrapperContextForParams(r10, i.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "data");
        final String r0 = r9.i();
        final String r2 = r9.s();
        View r3 = this.mBtnTaskFeedback;
        int r5 = 0;
        if (r3 != null) goto L5;
    L41:
        View r1 = this.mBtnTaskShare;
        if (r1 == null) goto L51;
        final String r4 = r9.h();
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L46;
    L49:
        boolean r7 = true;
    L50:
        r1.setEnabled(!r7);
        r1.setOnClickListener(new $$Lambda$AutoActionTaskListItemTaskView$9erX6ziaIxBpQp6aFGgbdO89o(r9, this, r4));
        goto L51
    L46:
        if (r6.length() == 0) goto L49;
        r7 = false;
    L51:
        View r8 = this.mBtnRelaunchTask;
        if (r8 == null) goto L54;
        r8.setOnClickListener(new $$Lambda$AutoActionTaskListItemTaskView$HeDHK3P3WB7kNeGsWlm7_p0iFWU(this, r9));
    L54:
        if (r11 == null) goto L63;
        View r12 = this.mBtnRelaunchTask;
        if (r12 != null) goto L58;
        return;
    L58:
        if (r11.b() == true) goto L61;
        r5 = 8;
    L61:
        r12.setVisibility(r5);
        return;
    L63:
        return;
    L5:
        if (com.obric.autogui.common.b.a.f29000a.a(r9.e(), 0) == true) goto L23;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == true) goto L23;
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L17;
    L20:
        boolean r16 = true;
    L21:
        if (r16 == true) goto L23;
        boolean r17 = true;
    L24:
        r3.setEnabled(r17);
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L27;
    L30:
        boolean r19 = true;
    L31:
        if (r19 == true) goto L41;
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r20 != null) goto L35;
    L38:
        boolean r21 = true;
    L39:
        if (r21 == true) goto L41;
        r3.setOnClickListener(new $$Lambda$AutoActionTaskListItemTaskView$uy0W1b9Nhv6nmFdGDPi_PfeXZMM(this, r0, r2));
        goto L41
    L35:
        if (d.o.o.d(r20) == true) goto L38;
        r21 = false;
        goto L39
    L27:
        if (d.o.o.d(r18) == true) goto L30;
        r19 = false;
        goto L31
    L17:
        if (d.o.o.d(r15) == true) goto L20;
        r16 = false;
        goto L21
    L9:
        if (d.o.o.d(r13) == true) goto L12;
        r14 = false;
    L23:
        r17 = false;
        goto L24
    }

    private static final void fitData$lambda$3$lambda$2(AutoActionTaskListItemTaskView r4, String r5, String r6, View r7) {
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new Intent().setComponent(new ComponentName("com.larus.nova", OMNI_FEEDBACK_ACTIVITY)).putExtra(KEY_TASK_ID, r5).putExtra(KEY_MSG_ID, r6), "com.obric.aiagent.plugin");
    }

    private static final void fitData$lambda$7$lambda$6(com.obric.autoaction.app.launcherpage.module.a.a.h r4, AutoActionTaskListItemTaskView r5, String r6, View r7) {
        final String r0 = r4.n();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new b(r7, r4, r5, null), m.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        Loog.INSTANCE.ip(LogUtil.INSTANCE.getCLAZZ_TAG(r5), new $$Lambda$AutoActionTaskListItemTaskView$wVNctDpxnBekNNRoFEeYXwldjE(r0), $$Lambda$AutoActionTaskListItemTaskView$hJ2I75nG9v7Q0lhlS5JAvdb0uIU.INSTANCE);
        IAutoActionPresentationApi r8 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L16;
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r9, "getContext(...)");
        d.h.b.o.a(r6);
        r8.openSharingWebView(r9, r0, r6, "oauto_task_list_page");
        return;
    L16:
        return;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private static final String fitData$lambda$7$lambda$6$lambda$4(String r2) {
        return "url=" + r2;
    }

    private static final void fitData$lambda$8(AutoActionTaskListItemTaskView r11, com.obric.autoaction.app.launcherpage.module.a.a.h r12, View r13) {
        if (AutoActionAgent.INSTANCE.hasOngoingTask() == true) goto L5;
        f r1 = f.f24296a;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.c(r2, "getContext(...)");
        f.a(r1, r2, r12.k(), null, null, null, false, 5, 28, null);
        return;
    L5:
        if (r11.mTimeOfLastFailedRetryAttempt <= 0) goto L10;
        long r14 = AOSystemTools.INSTANCE.nowTimeMillis() - r11.mTimeOfLastFailedRetryAttempt;
        if (r14 >= WsConstants.EXIT_DELAY_TIME) goto L10;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r11), "relaunch task failed - too frequent! it's only " + r14 + " before last request.");
        return;
    L10:
        r11.mTimeOfLastFailedRetryAttempt = AOSystemTools.INSTANCE.nowTimeMillis();
        AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.agent_task_running_cannot_restart, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_running_cannot_restart"), true);
    }
}
