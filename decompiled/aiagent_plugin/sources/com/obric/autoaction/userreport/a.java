package com.obric.autoaction.userreport;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.common.api.userreport.AutoActionUserReport;
import com.obric.autogui.common.api.userreport.IAutoActionUserReportApi;
import com.obric.autogui.common.api.userreport.UserReportInfo;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.k;
import com.obric.oui.forms.OInputView;
import com.obric.oui.lisitem.OListItemCheck;
import com.obric.oui.selection.OSelectionPanelBtnView;
import com.obric.oui.selection.OSelectionPanelView;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import org.json.JSONObject;

/* JADX INFO: compiled from: EndOfSessionUserReportController.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f25158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.h.a.a<x> f25159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.h.a.b<? super Boolean, x> f25160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OInputView f25162e;
    private OButton f;
    private OInsetSheetTitleBar g;
    private OCheckBox h;
    private final f i;
    private final f j;
    private C0604a k;

    /* JADX INFO: renamed from: com.obric.autoaction.userreport.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EndOfSessionUserReportController.kt */
    public static final class C0604a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f25163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f25164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f25165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f25166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f25167e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0604a.class) == true) goto L8;
            return false;
        L8:
            C0604a r6 = (C0604a) ZeusTransformUtils.preCheckCast(r5, C0604a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f25163a, r6.f25163a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f25164b, r6.f25164b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f25165c, r6.f25165c) == true) goto L18;
            return false;
        L18:
            if (this.f25166d == r6.f25166d) goto L21;
            return false;
        L21:
            if (o.a(this.f25167e, r6.f25167e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f25163a.hashCode() * 31) + this.f25164b.hashCode()) * 31;
            String r1 = this.f25165c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + Integer.hashCode(this.f25166d)) * 31) + this.f25167e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TaskReportDetail(sessionId=" + this.f25163a + ", sessionKey=" + this.f25164b + ", journalPath=" + this.f25165c + ", taskTermType=" + this.f25166d + ", taskQuery=" + this.f25167e + ')';
        }

        public C0604a(String r2, String r3, String r4, int r5, String r6) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r3, "sessionKey");
            o.e(r6, "taskQuery");
            this.f25163a = r2;
            this.f25164b = r3;
            this.f25165c = r4;
            this.f25166d = r5;
            this.f25167e = r6;
        }

        public final String a() {
            return this.f25163a;
        }

        public final String b() {
            return this.f25164b;
        }

        public final String c() {
            return this.f25165c;
        }

        public final int d() {
            return this.f25166d;
        }

        public final String e() {
            return this.f25167e;
        }
    }

    /* JADX INFO: compiled from: EndOfSessionUserReportController.kt */
    @d.c.b.a.f(b = "EndOfSessionUserReportController.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.userreport.EndOfSessionUserReportController$performUpload$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f25169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ C0604a f25170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f25171d;

        b(int r3, C0604a r4, String r5, d<? super b> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f25169b = r3;
            this.f25170c = r4;
            this.f25171d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f25169b, this.f25170c, this.f25171d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f25168a != 0) goto L7;
            d.o.a(r9);
            IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
            JSONObject r2 = new JSONObject();
            int r10 = this.f25169b;
            C0604a r1 = this.f25170c;
            String r8 = this.f25171d;
            r2.put("user_opinion", r10);
            r2.put("session_id", r1.a());
            r2.put("session_key", r1.b());
            r2.put("user_suggestion", r8);
            r2.put("term_type", r1.d());
            x r11 = x.f38692a;
            IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "userreport_upload", r2, false, false, null, 28, null);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void lambda$Fqp4Ih1ygNtTjJh5v1Mz5TteJCc(OInsetSheet r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ List lambda$OYhh9XAjcCcp7pLOHWPAzhn0Exw(a r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$SmGQNB3gDf1qdHJyX-9fSQ9m3HI, reason: not valid java name */
    public static /* synthetic */ void m645lambda$SmGQNB3gDf1qdHJyX9fSQ9m3HI(a r0, OInsetSheet r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$YXW9JSQQiqDAnljxsSnyhCjjcKw(OCheckBox r0, View r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$kg15lAhcvW3zrM480J6CO7VoLuY(OInsetSheet r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ OInsetSheet lambda$xPi4nZrblRvxKEuW7ZhquYd2ITA(a r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$zcXT52CIthPbk-foxDy1eMfOJB0, reason: not valid java name */
    public static /* synthetic */ void m646lambda$zcXT52CIthPbkfoxDy1eMfOJB0(List r0, a r1, OListItemCheck r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this.f25158a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f25161d = -1;
        this.i = g.a(new $$Lambda$a$xPi4nZrblRvxKEuW7ZhquYd2ITA(this));
        this.j = g.a(new $$Lambda$a$OYhh9XAjcCcp7pLOHWPAzhn0Exw(this));
    }

    public final Context getContext() {
        return this.f25158a;
    }

    private final void a(Dialog r3) {
        Window r2 = r3.getWindow();
        if (r2 == null) goto L6;
        r2.setLayout(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels - 15, -2);
        return;
    }

    public final void a(d.h.a.a<x> r4, d.h.a.b<? super Boolean, x> r5) {
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super Boolean, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (a(this.f25158a) == true) goto L6;
        com.obric.autoaction.userreport.b.f25172a.a(r6);
        com.obric.autoaction.userreport.b.f25172a.a(r7);
        com.obric.autoaction.userreport.b.f25172a.a(this.k);
        Intent r8 = new Intent(this.f25158a, TransparentReportActivity.class);
        r8.addFlags(268435456);
        ZeusTransformUtils.startActivity(this.f25158a, r8, "com.obric.aiagent.plugin");
        return;
    L6:
        C0604a r0 = this.k;
        if (r0 == null) goto L9;
        String r1 = r0.a();
    L10:
        this.f25159b = r6;
        this.f25160c = r7;
        OInsetSheet r9 = b();
        r9.setContainerView(d());
        OButton r10 = this.f;
        if (r10 == null) goto L13;
        r10.setEnabled(false);
    L13:
        OInsetSheetTitleBar r11 = this.g;
        if (r11 == null) goto L17;
        if (r1 != null) goto L17;
        r11.setSubTitleText("");
    L17:
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r12, "getContext(...)");
        if (a(r12) == true) goto L20;
        b((Dialog) ZeusTransformUtils.preCheckCast(r9, Dialog.class, "com.obric.aiagent.plugin"));
    L20:
        r9.show();
        return;
    L9:
        r1 = null;
        goto L10
    }

    private final boolean a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Activity.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ContextWrapper.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L9;
        r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r2, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "getBaseContext(...)");
        goto L6
    L9:
        return true;
    L11:
        return false;
    }

    private final void b(Dialog r4) {
        int r3 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
        Window r1 = r4.getWindow();
        if (r1 == null) goto L5;
        r1.setType(2038);
    L5:
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setGravity(80);
        r5.setLayout(r3, -2);
        r5.getDecorView().setBackground(null);
        r5.setBackgroundDrawable((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(0), Drawable.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void a() {
        a(null, null);
    }

    public final OInsetSheet b() {
        return (OInsetSheet) ZeusTransformUtils.preCheckCast(this.i.b(), OInsetSheet.class, "com.obric.aiagent.plugin");
    }

    private static final OInsetSheet a(final a r10) {
        final OInsetSheet r0 = new OInsetSheet(r10.f25158a);
        r0.setRootWidth(OInsetSheet.b.f36197b);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "getContext(...)");
        OInsetSheetTitleBar r1 = new OInsetSheetTitleBar(r3, null, 0, 6, null);
        r1.setShowLeftBack(false);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "getContext(...)");
        OButton r5 = r1.createNeutralButton(r4, (ViewGroup) ZeusTransformUtils.preCheckCast(r1.getMLeftContainer(), ViewGroup.class, "com.obric.aiagent.plugin"));
        r5.setButtonSourceBitmap(ZeusTransformUtils.mapRes(R.drawable.o_ic_close, "drawable", "o_ic_close"));
        r5.setOnClickListener(new $$Lambda$a$Fqp4Ih1ygNtTjJh5v1Mz5TteJCc(r0));
        r1.getMLeftActionBack().setOnClickListener(new $$Lambda$a$kg15lAhcvW3zrM480J6CO7VoLuY(r0));
        r1.setTitleText(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.userreport_sheet_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "userreport_sheet_title")));
        r10.g = r1;
        r0.setHeaderView((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "getContext(...)");
        OSelectionPanelBtnView r2 = new OSelectionPanelBtnView(r6, null, 2, null);
        OButton r7 = r2.getBtnPositive();
        r10.f = r7;
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.userreport_sheet_submit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "userreport_sheet_submit")), CharSequence.class, "com.obric.aiagent.plugin"));
        r7.setEnabled(false);
        r7.setOnClickListener(new $$Lambda$a$SmGQNB3gDf1qdHJyX9fSQ9m3HI(r10, r0));
        k.b(r2.getHorizontal_space());
        k.b((View) ZeusTransformUtils.preCheckCast(r2.getBtnNegative(), View.class, "com.obric.aiagent.plugin"));
        r0.setFooterView((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        r10.a((Dialog) ZeusTransformUtils.preCheckCast(r0, Dialog.class, "com.obric.aiagent.plugin"));
        return r0;
    }

    private static final void a(OInsetSheet r0, View r1) {
        r0.dismiss();
    }

    private static final void b(OInsetSheet r0, View r1) {
        r0.dismiss();
    }

    private static final void a(a r6, OInsetSheet r7, View r8) {
        C0604a r1 = r6.k;
        if (r1 == null) goto L15;
        int r2 = r6.f25161d;
        OInputView r9 = r6.f25162e;
        if (r9 == null) goto L8;
        String r10 = r9.getText();
        if (r10 == null) goto L8;
    L9:
        String r3 = r10;
        OCheckBox r11 = r6.h;
        boolean r4 = false;
        if (r11 != null) goto L12;
    L14:
        r6.a(r1, r2, r3, r4, r6.f25160c);
        goto L15
    L12:
        if (r11.isChecked() != true) goto L14;
        r4 = true;
    L8:
        r10 = "";
    L15:
        C0604a r12 = r6.k;
        if (r12 == null) goto L18;
        r12.a();
    L18:
        d.h.a.a<x> r13 = r6.f25159b;
        if (r13 == null) goto L21;
        r13.invoke();
    L21:
        r7.dismiss();
    }

    private static final List b(a r15) {
        return p.b(new OSelectionPanelView.c[]{new OSelectionPanelView.c(null, r15.f25158a.getString(ZeusTransformUtils.mapRes(R.string.userreport_sheet_task_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "userreport_sheet_task_success")), null, 5, null), new OSelectionPanelView.c(null, r15.f25158a.getString(ZeusTransformUtils.mapRes(R.string.userreport_sheet_task_almost_success, WsChannelMultiProcessSharedProvider.STRING_TYPE, "userreport_sheet_task_almost_success")), null, 5, null), new OSelectionPanelView.c(null, r15.f25158a.getString(ZeusTransformUtils.mapRes(R.string.userreport_sheet_task_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "userreport_sheet_task_failed")), null, 5, null)});
    }

    private final View d() {
        View r0 = ZeusTransformUtils.inflate(LayoutInflater.from(this.f25158a), ZeusTransformUtils.mapRes(R.layout.end_of_session_user_report_sheet, "layout", "end_of_session_user_report_sheet"), null, false, "com.obric.aiagent.plugin");
        if (r0 == null) goto L14;
        final List r1 = p.b(new OListItemCheck[]{(OListItemCheck) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.check1, DbHelper.COL_ID, "check1")), OListItemCheck.class, "com.obric.aiagent.plugin"), (OListItemCheck) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.check2, DbHelper.COL_ID, "check2")), OListItemCheck.class, "com.obric.aiagent.plugin"), (OListItemCheck) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.check3, DbHelper.COL_ID, "check3")), OListItemCheck.class, "com.obric.aiagent.plugin")});
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        final OListItemCheck r5 = (OListItemCheck) ZeusTransformUtils.preCheckCast(r3.next(), OListItemCheck.class, "com.obric.aiagent.plugin");
        r5.setOnClickListener(new $$Lambda$a$zcXT52CIthPbkfoxDy1eMfOJB0(r1, this, r5));
        goto L6
    L8:
        this.f25162e = (OInputView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.tv_user_suggestion, DbHelper.COL_ID, "tv_user_suggestion")), OInputView.class, "com.obric.aiagent.plugin");
        final OCheckBox r2 = (OCheckBox) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.chk_report_screenshot, DbHelper.COL_ID, "chk_report_screenshot")), OCheckBox.class, "com.obric.aiagent.plugin");
        this.h = r2;
        OTextView r8 = (OTextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.chk_report_screenshot_text, DbHelper.COL_ID, "chk_report_screenshot_text")), OTextView.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L12;
        r8.setOnClickListener(new $$Lambda$a$YXW9JSQQiqDAnljxsSnyhCjjcKw(r2));
    L12:
        return r0;
    L14:
        return null;
    }

    private static final void a(List r3, a r4, OListItemCheck r5, View r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        OListItemCheck r1 = (OListItemCheck) ZeusTransformUtils.preCheckCast(r8.next(), OListItemCheck.class, "com.obric.aiagent.plugin");
        r1.setChecked(o.a(r1, r5));
        goto L4
    L6:
        r4.f25161d = r7.indexOf(r5);
        OButton r9 = r4.f;
        if (r9 == null) goto L25;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        boolean r11 = false;
        if (ZeusTransformUtils.instanceOf(r10, Collection.class) == true) goto L11;
    L13:
        Iterator r12 = r10.iterator();
    L15:
        if (r12.hasNext() == false) goto L19;
        if (((OListItemCheck) ZeusTransformUtils.preCheckCast(r12.next(), OListItemCheck.class, "com.obric.aiagent.plugin")).isChecked() == false) goto L15;
        r11 = true;
    L19:
        r9.setEnabled(r11);
        return;
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L13;
    }

    private static final void a(OCheckBox r0, View r1) {
        r0.toggle();
    }

    private final void a(C0604a r10, int r11, String r12, boolean r13, d.h.a.b<? super Boolean, x> r14) {
        d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new b(r11, r10, r12, null), m.class, "com.obric.aiagent.plugin"));
        AutoActionUserReport r16 = AutoActionUserReport.INSTANCE;
        Context r0 = this.f25158a;
        String r2 = r10.a();
        String r3 = r10.e();
        if (r11 != 0) goto L5;
        UserReportInfo.UserSpecifiedTaskStatus r17 = UserReportInfo.UserSpecifiedTaskStatus.TaskSucceeded;
    L12:
        IAutoActionUserReportApi.UploadingStatus r18 = r16.uploadUserReport(r0, new UserReportInfo(r2, r3, r17, r12, r13, p.b(r10.c())));
        if (r18 != IAutoActionUserReportApi.UploadingStatus.Success) goto L15;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "UserReport uploaded posted.");
        return;
    L15:
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), "UserReport upload failed. Reason=" + r18);
        return;
    L5:
        if (r11 != 1) goto L7;
        r17 = UserReportInfo.UserSpecifiedTaskStatus.TaskSucceededPartly;
        goto L12
    L7:
        if (r11 == 2) goto L9;
        r17 = UserReportInfo.UserSpecifiedTaskStatus.Unspecified;
        goto L12
    L9:
        r17 = UserReportInfo.UserSpecifiedTaskStatus.TaskFailed;
        goto L12
    }

    public final void c() {
        b().dismiss();
    }

    public final void a(C0604a r2) {
        o.e(r2, "detail");
        this.k = r2;
    }
}
