package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ao;
import com.obric.autoaction.app.launcherpage.donation.model.Question;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.oui.button.OButton;
import com.obric.oui.coachmark.OCoachmarkTipView;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.markdown.OMarkdownView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: DataDonationQuestionDescActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DataDonationQuestionDescActivity extends AppCompatActivity {
    public static final a Companion = null;
    private static final String KEY_QUESTION = "key_question";
    private static final String TAG = "DataDonationQuestionDes";
    private ao binding;
    private Question question;
    private final d.f targetInput$delegate;

    /* JADX INFO: compiled from: DataDonationQuestionDescActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final void startActivity(Context r3, Question r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            o.e(r4, "question");
            Intent r5 = new Intent(r2, DataDonationQuestionDescActivity.class);
            r5.putExtra(DataDonationQuestionDescActivity.KEY_QUESTION, (Serializable) ZeusTransformUtils.preCheckCast(r4, Serializable.class, "com.obric.aiagent.plugin"));
            com.obric.autoaction.app.launcherpage.b.b.f22905a.a(r2);
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: DataDonationQuestionDescActivity.kt */
    @d.c.b.a.f(b = "DataDonationQuestionDescActivity.kt", c = {155}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DataDonationQuestionDescActivity$initView$6$1$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataDonationQuestionDescActivity f23672b;

        b(DataDonationQuestionDescActivity r3, d.c.d<? super b> r4) {
            DataDonationQuestionDescActivity r5 = (DataDonationQuestionDescActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataDonationQuestionDescActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23672b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23672b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23671a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            Question r7 = DataDonationQuestionDescActivity.access$getQuestion$p(this.f23672b);
            if (r7 == null) goto L14;
            com.obric.autoaction.app.launcherpage.donation.b.f23724a.a(r7, String.valueOf(DataDonationQuestionDescActivity.access$getTargetInput(this.f23672b).getVInput().getText()));
            this.f23672b.finish();
            return x.f38692a;
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23671a = 1;
            if (ax.a(300, r8) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ void lambda$TOeCCfpeQePpqxZEUu7_9IykxMQ(OMarkdownView r0) {
        initView$lambda$18$lambda$17(r0);
    }

    public static /* synthetic */ OInputLayout lambda$hRvAzMyd50ugiX024ib6yfx14L4(DataDonationQuestionDescActivity r0) {
        return targetInput_delegate$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$m6EooI4T46sI7hxtaqmv2IRoRiI(DataDonationQuestionDescActivity r0, View r1) {
        initView$lambda$6$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$q8kkV6xDBwR4-beJjjAjE4wNiVs, reason: not valid java name */
    public static /* synthetic */ al m498lambda$q8kkV6xDBwR4beJjjAjE4wNiVs(DataDonationQuestionDescActivity r0, View r1, al r2) {
        return setupKeyboardListener$lambda$22(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$xVh9WZ8OJbNKXt0KlEhwdfiyIwE(DataDonationQuestionDescActivity r0, View r1) {
        initView$lambda$21$lambda$20(r0, r1);
    }

    public DataDonationQuestionDescActivity() {
        this.targetInput$delegate = d.g.a(new $$Lambda$DataDonationQuestionDescActivity$hRvAzMyd50ugiX024ib6yfx14L4(this));
    }

    public static final /* synthetic */ ao access$getBinding$p(DataDonationQuestionDescActivity r2) {
        return ((DataDonationQuestionDescActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationQuestionDescActivity.class, "com.obric.aiagent.plugin")).binding;
    }

    public static final /* synthetic */ Question access$getQuestion$p(DataDonationQuestionDescActivity r2) {
        return ((DataDonationQuestionDescActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationQuestionDescActivity.class, "com.obric.aiagent.plugin")).question;
    }

    public static final /* synthetic */ OInputLayout access$getTargetInput(DataDonationQuestionDescActivity r2) {
        return ((DataDonationQuestionDescActivity) ZeusTransformUtils.wrapperContextForParams(r2, DataDonationQuestionDescActivity.class, "com.obric.aiagent.plugin")).getTargetInput();
    }

    private final OInputLayout getTargetInput() {
        return (OInputLayout) ZeusTransformUtils.preCheckCast(this.targetInput$delegate.b(), OInputLayout.class, "com.obric.aiagent.plugin");
    }

    private static final OInputLayout targetInput_delegate$lambda$1(DataDonationQuestionDescActivity r5) {
        DataDonationQuestionDescActivity r6 = (DataDonationQuestionDescActivity) ZeusTransformUtils.wrapperContextForParams(r5, DataDonationQuestionDescActivity.class, "com.obric.aiagent.plugin");
        LayoutInflater r0 = r6.getLayoutInflater();
        int r2 = ZeusTransformUtils.mapRes(R.layout.autoaction_donation_query_input, "layout", "autoaction_donation_query_input");
        ao r7 = r6.binding;
        if (r7 != null) goto L5;
        o.c("binding");
        r7 = null;
    L5:
        View r8 = ZeusTransformUtils.inflate(r0, r2, (ViewGroup) ZeusTransformUtils.preCheckCast(r7.h, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        o.a(r8, "null cannot be cast to non-null type com.obric.oui.forms.OInputLayout");
        OInputLayout r9 = (OInputLayout) ZeusTransformUtils.preCheckCast(r8, OInputLayout.class, "com.obric.aiagent.plugin");
        r9.setType(1);
        return r9;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r6) {
        super.onCreate(r6);
        ao r7 = ao.a(getLayoutInflater());
        o.c(r7, "inflate(...)");
        this.binding = r7;
        Question r0 = null;
        if (r7 != null) goto L5;
        o.c("binding");
        r7 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r7.b(), View.class, "com.obric.aiagent.plugin"));
        BaseActivity.a.a(BaseActivity.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 1, null);
        Serializable r8 = getIntent().getSerializableExtra(KEY_QUESTION);
        if (ZeusTransformUtils.instanceOf(r8, Question.class) == false) goto L8;
        r0 = (Question) ZeusTransformUtils.preCheckCast(r8, Question.class, "com.obric.aiagent.plugin");
    L8:
        if (r0 != null) goto L11;
        finish();
        return;
    L11:
        this.question = r0;
        initView();
        setupKeyboardListener();
    }

    private final void initView() {
        ao r1 = this.binding;
        ao r3 = null;
        if (r1 != null) goto L5;
        o.c("binding");
        r1 = null;
    L5:
        OFloatingTitleBar r2 = r1.i;
        Question r4 = this.question;
        if (r4 == null) goto L18;
        String r5 = r4.getName();
        if (r5 == null) goto L18;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        r2.setCenterTitle(r5);
        goto L18
    L12:
        r6 = false;
    L18:
        r2.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        OFloatingTitleBar.addStartAction$default(r2, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$DataDonationQuestionDescActivity$m6EooI4T46sI7hxtaqmv2IRoRiI(this), 2, null);
        o.a(r2);
        com.obric.autoaction.app.launcherpage.b.c.a(r2);
        ao r7 = this.binding;
        if (r7 != null) goto L21;
        o.c("binding");
        r7 = null;
    L21:
        OCoachmarkTipView r8 = r7.f;
        Question r9 = this.question;
        if (r9 == null) goto L37;
        String r10 = r9.getReward();
        if (r10 == null) goto L37;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == true) goto L32;
        r10 = null;
    L32:
        if (r10 == null) goto L37;
        OTextView r14 = (OTextView) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(R.id.tv_desc, DbHelper.COL_ID, "tv_desc")), OTextView.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L36;
        r14.setTextColor(p.b(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1"), (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), null, 2, null));
        r14.setTextSize(1, 14.0f);
    L36:
        setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.reward_desc_text, WsChannelMultiProcessSharedProvider.STRING_TYPE, "reward_desc_text"), new Object[]{r10}), CharSequence.class, "com.obric.aiagent.plugin"));
        r8.setVisibility(0);
        goto L37
    L28:
        r13 = false;
    L37:
        ao r11 = this.binding;
        if (r11 != null) goto L40;
        o.c("binding");
        r11 = null;
    L40:
        OCoachmarkTipView r12 = r11.f;
        o.c(r12, "rewardDesc");
        if (com.obric.oui.common.util.k.d((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin")) == true) goto L49;
        ao r15 = this.binding;
        if (r15 != null) goto L45;
        o.c("binding");
        r15 = null;
    L45:
        OSectionTitleBar r16 = r15.f22763e;
        o.c(r16, "queryTitle");
        View r17 = (View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r19 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).topMargin = 0;
        r17.setLayoutParams(r19);
        ao r20 = this.binding;
        if (r20 != null) goto L48;
        o.c("binding");
        r20 = null;
    L48:
        r20.f22763e.setTitleTextColor(p.b(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3"), (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), null, 2, null));
    L49:
        ao r21 = this.binding;
        if (r21 != null) goto L52;
        o.c("binding");
        r21 = null;
    L52:
        final OMarkdownView r22 = r21.f22762d;
        com.obric.oui.markdown.d r23 = new com.obric.oui.markdown.d((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, false, 0, 0, 0, 8388606, null);
        HashMap<String, Object> r24 = r23.b();
        r24.put("fontSize", Float.valueOf(14.0f));
        r24.put("paragraphSpace", 10);
        r24.put("lineHeight", 21);
        HashMap<String, Object> r25 = r23.e();
        r25.put("fontSize", Float.valueOf(16.0f));
        r25.put("paragraphSpace", 10);
        r25.put("lineHeight", 22);
        r25.put("color", com.obric.oui.markdown.e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
        r22.setStyle(r23);
        Question r26 = this.question;
        if (r26 == null) goto L56;
        String r27 = r26.getProcess();
        if (r27 == null) goto L56;
    L57:
        r22.setMarkdownContent(r27);
        r22.post(new $$Lambda$DataDonationQuestionDescActivity$TOeCCfpeQePpqxZEUu7_9IykxMQ(r22));
        ao r28 = this.binding;
        if (r28 != null) goto L60;
        o.c("binding");
        r28 = null;
    L60:
        r28.h.setCustomStartView((View) ZeusTransformUtils.preCheckCast(getTargetInput(), View.class, "com.obric.aiagent.plugin"));
        OInputLayout r29 = getTargetInput();
        r29.getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new DataDonationQuestionDescActivity$initView$5$1(this), TextWatcher.class, "com.obric.aiagent.plugin"));
        r29.getVInput().setPadding(r29.getVInput().getPaddingLeft(), d.i.a.a(TypedValue.applyDimension(1, 9, Resources.getSystem().getDisplayMetrics())), r29.getVInput().getPaddingRight(), r29.getVInput().getPaddingBottom());
        r29.setHint((CharSequence) ZeusTransformUtils.preCheckCast(p.a(ZeusTransformUtils.mapRes(R.string.query_hint, WsChannelMultiProcessSharedProvider.STRING_TYPE, "query_hint"), null, 1, null), CharSequence.class, "com.obric.aiagent.plugin"));
        ao r30 = this.binding;
        if (r30 != null) goto L63;
        o.c("binding");
    L64:
        OButton r31 = r3.g;
        CharSequence r32 = (CharSequence) ZeusTransformUtils.preCheckCast(getTargetInput().getVInput().getText(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r32 != null) goto L67;
    L70:
        boolean r110 = true;
    L71:
        r31.setEnabled(!r110);
        r31.setOnClickListener(new $$Lambda$DataDonationQuestionDescActivity$xVh9WZ8OJbNKXt0KlEhwdfiyIwE(this));
        getTargetInput().getVInput().setGravity(48);
        return;
    L67:
        if (r32.length() == 0) goto L70;
        r110 = false;
        goto L71
    L63:
        r3 = r30;
    L56:
        r27 = "";
        goto L57
    }

    private static final void initView$lambda$6$lambda$5(DataDonationQuestionDescActivity r1, View r2) {
        ((DataDonationQuestionDescActivity) ZeusTransformUtils.wrapperContextForParams(r1, DataDonationQuestionDescActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private static final void initView$lambda$18$lambda$17(OMarkdownView r3) {
        View r0 = r3.getChildAt(0);
        if (r0 == null) goto L6;
        o.a(r3);
        View r4 = (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r1.height = r0.getHeight();
        r4.setLayoutParams(r1);
        return;
    }

    private static final void initView$lambda$21$lambda$20(DataDonationQuestionDescActivity r8, View r9) {
        DataDonationQuestionDescActivity r10 = (DataDonationQuestionDescActivity) ZeusTransformUtils.wrapperContextForParams(r8, DataDonationQuestionDescActivity.class, "com.obric.aiagent.plugin");
        if (com.obric.autoaction.app.launcherpage.donation.b.f23724a.b() == false) goto L5;
        com.obric.autoaction.app.launcherpage.donation.b.f23724a.c();
        return;
    L5:
        AOSystemTools.INSTANCE.returnToLauncher((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"));
        kotlinx.coroutines.i.a(an.a(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void setupKeyboardListener() {
        ao r0 = this.binding;
        if (r0 != null) goto L5;
        o.c("binding");
        r0 = null;
    L5:
        ViewCompat.a((View) ZeusTransformUtils.preCheckCast(r0.b(), View.class, "com.obric.aiagent.plugin"), new $$Lambda$DataDonationQuestionDescActivity$q8kkV6xDBwR4beJjjAjE4wNiVs(this));
    }

    private static final al setupKeyboardListener$lambda$22(DataDonationQuestionDescActivity r3, View r4, al r5) {
        DataDonationQuestionDescActivity r6 = (DataDonationQuestionDescActivity) ZeusTransformUtils.wrapperContextForParams(r3, DataDonationQuestionDescActivity.class, "com.obric.aiagent.plugin");
        o.e(r4, "<unused var>");
        o.e(r5, "insets");
        int r7 = r5.a(al.m.c()).f1213e;
        if (r7 <= 0) goto L5;
        boolean r0 = true;
    L6:
        ao r1 = null;
        if (r0 == false) goto L13;
        ao r8 = r6.binding;
        if (r8 != null) goto L11;
        o.c("binding");
    L12:
        r1.f22760b.setTranslationY(-r7);
    L18:
        return r5;
    L11:
        r1 = r8;
        goto L12
    L13:
        ao r9 = r6.binding;
        if (r9 != null) goto L16;
        o.c("binding");
    L17:
        r1.f22760b.setTranslationY(0.0f);
        goto L18
    L16:
        r1 = r9;
        goto L17
    L5:
        r0 = false;
        goto L6
    }
}
