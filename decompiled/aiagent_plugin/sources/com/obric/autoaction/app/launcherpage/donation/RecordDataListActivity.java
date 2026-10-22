package com.obric.autoaction.app.launcherpage.donation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.ax;
import com.obric.autoaction.app.launcherpage.donation.model.Question;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.x;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.w;

/* JADX INFO: compiled from: RecordDataListActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RecordDataListActivity extends AppCompatActivity implements com.obric.autoaction.app.launcherpage.b.a {
    public static final a Companion = null;
    public static final int DEFAULT_STATUS = -1;
    private static final String KEY_DONATION_TASK_ID = "key_donation_task_id";
    private static final String KEY_QUESTION = "key_question";
    private static final String KEY_REJECT_REASON = "key_reject_reason";
    private static final String KEY_SORT = "key_sort";
    private static final String KEY_STATUS = "key_status";
    private static final String KEY_TARGET = "key_target";
    private static final String TAG = "RecordDataListActivity";
    private static List<com.obric.autoaction.app.launcherpage.donation.model.c> currentOperations;
    private ax binding;
    private String currentDonationTaskId;
    private String currentSort;
    private int currentStatus;
    private String currentTarget;
    private Question question;
    private String rejectReason;

    /* JADX INFO: compiled from: RecordDataListActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final void a(List<com.obric.autoaction.app.launcherpage.donation.model.c> r2) {
            RecordDataListActivity.access$setCurrentOperations$cp((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"));
        }

        public static /* synthetic */ void a(a r10, Context r11, Question r12, String r13, List r14, int r15, String r16, String r17, int r18, Object r19) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
            List<com.obric.autoaction.app.launcherpage.donation.model.c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
            if ((r18 & 16) == 0) goto L5;
            int r7 = -1;
        L7:
            if ((r18 & 32) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r18 & 64) == 0) goto L13;
            String r9 = null;
        L14:
            r10.a(r3, r12, r13, r6, r7, r8, r9);
            return;
        L13:
            r9 = r17;
            goto L14
        L9:
            r8 = r16;
            goto L11
        L5:
            r7 = r15;
            goto L7
        }

        public final void a(Context r4, Question r5, String r6, List<com.obric.autoaction.app.launcherpage.donation.model.c> r7, int r8, String r9, String r10) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "context");
            o.e(r11, "operations");
            Intent r12 = new Intent(r3, RecordDataListActivity.class);
            RecordDataListActivity.Companion.a(p.g((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")));
            if (ZeusTransformUtils.instanceOf(r3, Activity.class) == true) goto L5;
            r12.addFlags(268435456);
        L5:
            r12.putExtra(RecordDataListActivity.KEY_QUESTION, (Serializable) ZeusTransformUtils.preCheckCast(r5, Serializable.class, "com.obric.aiagent.plugin"));
            r12.putExtra(RecordDataListActivity.KEY_TARGET, r6);
            r12.putExtra(RecordDataListActivity.KEY_STATUS, r8);
            if (r9 == null) goto L8;
            r12.putExtra(RecordDataListActivity.KEY_REJECT_REASON, r9);
        L8:
            if (r10 == null) goto L10;
            r12.putExtra(RecordDataListActivity.KEY_DONATION_TASK_ID, r10);
        L10:
            com.obric.autoaction.app.launcherpage.b.b.f22905a.a(r3);
            ZeusTransformUtils.startActivity(r3, r12, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: RecordDataListActivity.kt */
    public static final class b extends androidx.activity.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecordDataListActivity f23688a;

        /* JADX INFO: renamed from: lambda$7VIVmoiF13IS4Y1rsmpMEW-P-Bo, reason: not valid java name */
        public static /* synthetic */ x m502lambda$7VIVmoiF13IS4Y1rsmpMEWPBo(RecordDataListActivity r0) {
            return a(r0);
        }

        b(RecordDataListActivity r3) {
            this.f23688a = (RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecordDataListActivity.class, "com.obric.aiagent.plugin");
            super(true);
        }

        @Override // androidx.activity.c
        public void c() {
            if (RecordDataListActivity.access$canEdit(this.f23688a) == true) goto L6;
            this.f23688a.finish();
            return;
        L6:
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(this.f23688a, Context.class, "com.obric.aiagent.plugin");
            String r2 = this.f23688a.getString(ZeusTransformUtils.mapRes(R.string.confirm_finish, WsChannelMultiProcessSharedProvider.STRING_TYPE, "confirm_finish"));
            o.c(r2, "getString(...)");
            String r4 = this.f23688a.getString(ZeusTransformUtils.mapRes(R.string.finish, WsChannelMultiProcessSharedProvider.STRING_TYPE, "finish"));
            o.c(r4, "getString(...)");
            com.obric.autoaction.app.launcherpage.donation.a r0 = new com.obric.autoaction.app.launcherpage.donation.a(r1, r2, r4);
            final RecordDataListActivity r8 = this.f23688a;
            r0.a(new $$Lambda$RecordDataListActivity$b$7VIVmoiF13IS4Y1rsmpMEWPBo(r8));
            r0.a();
        }

        private static final x a(RecordDataListActivity r2) {
            ((RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecordDataListActivity.class, "com.obric.aiagent.plugin")).finish();
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: RecordDataListActivity.kt */
    @d.c.b.a.f(b = "RecordDataListActivity.kt", c = {105}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.RecordDataListActivity$onCreate$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecordDataListActivity f23690b;

        c(RecordDataListActivity r3, d.c.d<? super c> r4) {
            RecordDataListActivity r5 = (RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecordDataListActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23690b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23690b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23689a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            d.o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            w<com.obric.autoaction.app.launcherpage.donation.model.a> r7 = m.f23777a.a();
            final RecordDataListActivity r3 = this.f23690b;
            kotlinx.coroutines.b.i<? super com.obric.autoaction.app.launcherpage.donation.model.a> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23689a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$s7xy_ED4mr8sv3zj5fra7Mz__wo(l r0, List r1, RecordDataListActivity r2) {
        return initView$lambda$4$lambda$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$uLN-THyXyNva27LlMaWNQv-lIA0, reason: not valid java name */
    public static /* synthetic */ void m500lambda$uLNTHyXyNva27LlMaWNQvlIA0(RecordDataListActivity r0, View r1) {
        initView$lambda$7$lambda$6(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$zj0stCNi_Ri81znYCULHe1Ynv-Q, reason: not valid java name */
    public static /* synthetic */ void m501lambda$zj0stCNi_Ri81znYCULHe1YnvQ(RecordDataListActivity r0, View r1) {
        initView$lambda$2$lambda$1(r0, r1);
    }

    public RecordDataListActivity() {
        this.currentStatus = -1;
    }

    public static final /* synthetic */ boolean access$canEdit(RecordDataListActivity r2) {
        return ((RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecordDataListActivity.class, "com.obric.aiagent.plugin")).canEdit();
    }

    public static final /* synthetic */ String access$getCurrentDonationTaskId$p(RecordDataListActivity r2) {
        return ((RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecordDataListActivity.class, "com.obric.aiagent.plugin")).currentDonationTaskId;
    }

    public static final /* synthetic */ List access$getCurrentOperations$cp() {
        return currentOperations;
    }

    public static final /* synthetic */ void access$initView(RecordDataListActivity r2) {
        ((RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecordDataListActivity.class, "com.obric.aiagent.plugin")).initView();
    }

    public static final /* synthetic */ void access$setCurrentOperations$cp(List r2) {
        currentOperations = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setCurrentStatus$p(RecordDataListActivity r2, int r3) {
        ((RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecordDataListActivity.class, "com.obric.aiagent.plugin")).currentStatus = r3;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r6) {
        super.onCreate(r6);
        ax r7 = ax.a(getLayoutInflater());
        o.c(r7, "inflate(...)");
        this.binding = r7;
        if (r7 != null) goto L5;
        o.c("binding");
        r7 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r7.b(), View.class, "com.obric.aiagent.plugin"));
        BaseActivity.a.a(BaseActivity.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 1, null);
        this.currentSort = getIntent().getStringExtra(KEY_SORT);
        this.currentDonationTaskId = getIntent().getStringExtra(KEY_DONATION_TASK_ID);
        this.currentTarget = getIntent().getStringExtra(KEY_TARGET);
        this.currentStatus = getIntent().getIntExtra(KEY_STATUS, -1);
        this.rejectReason = getIntent().getStringExtra(KEY_REJECT_REASON);
        this.question = (Question) ZeusTransformUtils.preCheckCast(getIntent().getSerializableExtra(KEY_QUESTION), Question.class, "com.obric.aiagent.plugin");
        if (this.currentTarget != null) goto L8;
    L12:
        finish();
        return;
    L8:
        if (currentOperations == null) goto L12;
        initView();
        q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(this, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).b((d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    private final void initView() {
        final List<com.obric.autoaction.app.launcherpage.donation.model.c> r0 = currentOperations;
        if (r0 != null) goto L6;
        finish();
        return;
    L6:
        getOnBackPressedDispatcher().a((androidx.activity.c) ZeusTransformUtils.preCheckCast(new b(this), androidx.activity.c.class, "com.obric.aiagent.plugin"));
        boolean r1 = showUploadBtn();
        ax r2 = this.binding;
        ax r5 = null;
        if (r2 != null) goto L9;
        o.c("binding");
        r2 = null;
    L9:
        OFloatingTitleBar r3 = r2.f;
        Question r6 = this.question;
        if (r6 == null) goto L12;
        String r7 = r6.getName();
    L13:
        r3.setCenterTitle(r7);
        int r12 = 0;
        OFloatingTitleBar.removeAllStartAction$default(r3, false, 1, null);
        r3.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        OFloatingTitleBar.addStartAction$default(r3, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$RecordDataListActivity$zj0stCNi_Ri81znYCULHe1YnvQ(this), 2, null);
        o.a(r3);
        com.obric.autoaction.app.launcherpage.b.c.a(r3);
        ax r4 = this.binding;
        if (r4 != null) goto L16;
        o.c("binding");
        r4 = null;
    L16:
        RecyclerView r8 = r4.f22794c;
        final l r9 = new l(this.currentTarget, this.currentStatus, r0, this.rejectReason);
        r8.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(new androidx.recyclerview.widget.g(new RecyclerView.a[]{r9, new k(canEdit(), r0, new $$Lambda$RecordDataListActivity$s7xy_ED4mr8sv3zj5fra7Mz__wo(r9, r0, this))}), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        r8.addItemDecoration((RecyclerView.g) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.app.launcherpage.module.view.b(d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()))), RecyclerView.g.class, "com.obric.aiagent.plugin"));
        r8.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")), RecyclerView.h.class, "com.obric.aiagent.plugin"));
        ax r10 = this.binding;
        if (r10 != null) goto L19;
        o.c("binding");
        r10 = null;
    L19:
        OButton r11 = r10.f22796e;
        r11.setOnClickListener(new $$Lambda$RecordDataListActivity$uLNTHyXyNva27LlMaWNQvlIA0(this));
        if (this.currentStatus != m.a.d.f23789a.a()) goto L22;
        int r13 = ZeusTransformUtils.mapRes(R.string.restart_to_upload, WsChannelMultiProcessSharedProvider.STRING_TYPE, "restart_to_upload");
    L23:
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(r13), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r1 == false) goto L26;
        int r14 = 0;
    L27:
        r11.setVisibility(r14);
        ax r15 = this.binding;
        if (r15 != null) goto L30;
        o.c("binding");
        r15 = null;
    L30:
        LinearLayout r16 = r15.f22793b;
        if (r1 == false) goto L33;
        int r17 = 0;
    L34:
        r16.setVisibility(r17);
        ax r18 = this.binding;
        if (r18 != null) goto L37;
        o.c("binding");
        r18 = null;
    L37:
        OTextView r19 = r18.f22795d;
        if (r1 == false) goto L40;
        int r20 = 0;
    L41:
        r19.setVisibility(r20);
        ax r21 = this.binding;
        if (r21 != null) goto L44;
        o.c("binding");
        r21 = null;
    L44:
        View r22 = r21.f22792a;
        if (r1 == true) goto L48;
        r12 = 8;
    L48:
        r22.setVisibility(r12);
        ax r23 = this.binding;
        if (r23 != null) goto L51;
        o.c("binding");
    L52:
        final OTextView r24 = r5.f22795d;
        final String r25 = getString(ZeusTransformUtils.mapRes(R.string.donation_license_link, WsChannelMultiProcessSharedProvider.STRING_TYPE, "donation_license_link"));
        o.c(r25, "getString(...)");
        String r26 = getString(ZeusTransformUtils.mapRes(R.string.donation_upload_confirm_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "donation_upload_confirm_tips"));
        o.c(r26, "getString(...)");
        ClickableSpan r27 = new RecordDataListActivity$initView$4$clickableSpan$1(this, r25, r24);
        SpannableString r110 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin"));
        r110.setSpan(r27, d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin"), r25, 0, false, 6, null), d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin"), r25, 0, false, 6, null) + r25.length(), 33);
        r24.setText((CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.aiagent.plugin"));
        r24.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L51:
        r5 = r23;
        goto L52
    L40:
        r20 = 8;
        goto L41
    L33:
        r17 = 8;
        goto L34
    L26:
        r14 = 8;
        goto L27
    L22:
        r13 = ZeusTransformUtils.mapRes(R.string.start_to_upload, WsChannelMultiProcessSharedProvider.STRING_TYPE, "start_to_upload");
        goto L23
    L12:
        r7 = null;
        goto L13
    }

    private static final void initView$lambda$2$lambda$1(RecordDataListActivity r1, View r2) {
        ((RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r1, RecordDataListActivity.class, "com.obric.aiagent.plugin")).onBackPressed();
    }

    private static final x initView$lambda$4$lambda$3(l r2, List r3, RecordDataListActivity r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        RecordDataListActivity r6 = (RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r4, RecordDataListActivity.class, "com.obric.aiagent.plugin");
        r2.d(0);
        if (r5.isEmpty() == false) goto L6;
        r6.finish();
    L6:
        return x.f38692a;
    }

    private static final void initView$lambda$7$lambda$6(RecordDataListActivity r13, View r14) {
        RecordDataListActivity r15 = (RecordDataListActivity) ZeusTransformUtils.wrapperContextForParams(r13, RecordDataListActivity.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "start upload");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(currentOperations, Collection.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L5;
    L8:
        boolean r17 = true;
    L9:
        if (r17 == false) goto L13;
        Loog.INSTANCE.e(TAG, "currentOperations is empty");
        r15.finish();
        return;
    L13:
        if (r15.currentStatus != (-1)) goto L21;
        m r18 = m.f23777a;
        String r3 = UUID.randomUUID().toString();
        o.c(r3, "toString(...)");
        String r1 = r15.currentTarget;
        if (r1 != null) goto L17;
        r1 = "";
    L17:
        String r4 = r1;
        Question r5 = r15.question;
        List<com.obric.autoaction.app.launcherpage.donation.model.c> r2 = currentOperations;
        if (r2 != null) goto L20;
        r2 = p.b();
    L20:
        List<com.obric.autoaction.app.launcherpage.donation.model.c> r6 = r2;
        long r8 = System.currentTimeMillis() / ((long) 1000);
        r18.a(new com.obric.autoaction.app.launcherpage.donation.model.a(r3, r4, r5, r6, m.a.f.f23791a.a(), r8, null, 64, null));
        UploadRecordActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r15, Context.class, "com.obric.aiagent.plugin"));
    L24:
        r15.finish();
        return;
    L21:
        String r19 = r15.currentDonationTaskId;
        if (r19 == null) goto L24;
        m.f23777a.a(r19);
        goto L24
    L5:
        if (r16.isEmpty() == true) goto L8;
        r17 = false;
        goto L9
    }

    private final boolean showUploadBtn() {
        int r1 = this.currentStatus;
        if (r1 != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (r1 == m.a.d.f23789a.a()) goto L8;
        return false;
    }

    private final boolean canEdit() {
        if (this.currentStatus != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.autoaction.app.launcherpage.b.a
    public OFloatingTitleBar getFloatingTransitionSourceTitleBar() {
        ax r1 = this.binding;
        if (r1 == null) goto L8;
        if (r1 != null) goto L7;
        o.c("binding");
        r1 = null;
    L7:
        return r1.f;
    L8:
        return null;
    }
}
