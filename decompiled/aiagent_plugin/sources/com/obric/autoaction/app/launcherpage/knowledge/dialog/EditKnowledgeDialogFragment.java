package com.obric.autoaction.app.launcherpage.knowledge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.q;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.a.t;
import com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment;
import com.obric.autoaction.app.launcherpage.utils.p;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.event.task.base.report.k;
import com.obric.eventkit.ITaskManagerApi;
import com.obric.eventkit.e;
import com.obric.eventkit.g;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: EditKnowledgeDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EditKnowledgeDialogFragment extends BaseOSheetDialogFragment<String> {
    public static final a Companion = null;
    private static final String KEY_INITIAL_KNOWLEDGE = "initial_knowledge";
    private static final String KEY_TASK_ID = "task_id";
    private static final String KEY_TASK_TYPE = "task_type";
    private static final String TAG = "EditKnowledgeDialogFragment";
    private t _binding;
    private OInputLayout knowledgeInput;
    private final b securityChecker;

    /* JADX INFO: compiled from: EditKnowledgeDialogFragment.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final EditKnowledgeDialogFragment a(String r3, String r4, int r5) {
            o.e(r3, "initialKnowledge");
            o.e(r4, DBDefinition.TASK_ID);
            EditKnowledgeDialogFragment r2 = new EditKnowledgeDialogFragment();
            Bundle r0 = new Bundle();
            r0.putString(EditKnowledgeDialogFragment.KEY_INITIAL_KNOWLEDGE, r3);
            r0.putString("task_id", r4);
            r0.putInt("task_type", r5);
            r2.setArguments(r0);
            return r2;
        }

        public final Object a(AppCompatActivity r3, String r4, String r5, int r6, d<? super String> r7) {
            AppCompatActivity r8 = (AppCompatActivity) ZeusTransformUtils.wrapperContextForParams(r3, AppCompatActivity.class, "com.obric.aiagent.plugin");
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            return BaseOSheetDialogFragment.Companion.a((BaseOSheetDialogFragment) ZeusTransformUtils.preCheckCast(a(r4, r5, r6), BaseOSheetDialogFragment.class, "com.obric.aiagent.plugin"), (FragmentActivity) ZeusTransformUtils.preCheckCast(r8, FragmentActivity.class, "com.obric.aiagent.plugin"), EditKnowledgeDialogFragment.TAG, r9);
        }
    }

    /* JADX INFO: compiled from: EditKnowledgeDialogFragment.kt */
    public static final class b implements e {
        b() {
        }

        @Override // com.obric.eventkit.e
        public boolean a(String r1) {
            o.e(r1, "content");
            return AOPlatformTools.INSTANCE.security().checkSensitiveWord(r1);
        }
    }

    /* JADX INFO: compiled from: EditKnowledgeDialogFragment.kt */
    @f(b = "EditKnowledgeDialogFragment.kt", c = {92}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.knowledge.dialog.EditKnowledgeDialogFragment$setupViews$2$1$1")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f23948c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23949d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f23950e;
        final /* synthetic */ EditKnowledgeDialogFragment f;

        c(String r3, String r4, String r5, int r6, EditKnowledgeDialogFragment r7, d<? super c> r8) {
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r8, d.class, "com.obric.aiagent.plugin");
            this.f23947b = r3;
            this.f23948c = r4;
            this.f23949d = r5;
            this.f23950e = r6;
            this.f = r7;
            super(2, r9);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r9, d<?> r10) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r10, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f23947b, this.f23948c, this.f23949d, this.f23950e, this.f, r7), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23946a;
            String r3 = null;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r20);
            Object r4 = r20;
        L13:
            g r5 = (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin");
        L16:
            if (r5 != null) goto L18;
        L20:
            boolean r6 = false;
        L21:
            if (r6 == false) goto L23;
            EditKnowledgeDialogFragment.access$deliverResultAndDismiss(this.f, this.f23947b);
        L29:
            k r7 = k.f32860a;
            if (r5 != null) goto L32;
        L34:
            boolean r8 = false;
        L35:
            if (r5 == null) goto L37;
            r3 = r5.b();
        L37:
            k.a(r7, r8, r3, false, null, 12, null);
            return x.f38692a;
        L32:
            if (r5.a() != true) goto L34;
            r8 = true;
            goto L35
        L23:
            if (r5 == null) goto L25;
            String r0 = r5.b();
        L27:
            if (o.a(r0, "sensitive_words_check_fail") == false) goto L29;
            AOUserInterfaceTools.INSTANCE.showAppToast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.sensitive_words_remind_tips, WsChannelMultiProcessSharedProvider.STRING_TYPE, "sensitive_words_remind_tips"), true);
            goto L29
        L25:
            r0 = null;
            goto L27
        L18:
            if (r5.a() != true) goto L20;
            r6 = true;
            goto L21
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r20);
            boolean r15 = !o.a(this.f23947b, this.f23948c);
            ITaskManagerApi r9 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L14;
            String r10 = this.f23949d;
            int r11 = this.f23950e;
            String r12 = this.f23947b;
            e r13 = (e) ZeusTransformUtils.preCheckCast(EditKnowledgeDialogFragment.access$getSecurityChecker$p(this.f), e.class, "com.obric.aiagent.plugin");
            d r16 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f23946a = 1;
            r4 = ITaskManagerApi.b.a(r9, r10, r11, null, r12, null, true, r13, null, r15, r16, 16, null);
            if (r4 != r1) goto L13;
            return r1;
        L14:
            r5 = null;
            goto L16
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$6sfjbXfocIWM7KVzizVtF1wOfGI(EditKnowledgeDialogFragment r0, com.obric.autoaction.common.base.a r1) {
        return configExtension$lambda$0(r0, r1);
    }

    public static /* synthetic */ void lambda$o9t74RzV2ZOvWrZaa4yUJMglfN0(EditKnowledgeDialogFragment r0, String r1, String r2, int r3, View r4) {
        setupViews$lambda$5(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$tG8foNaQh3dDl5s2PSJAe7uOVxs(EditKnowledgeDialogFragment r0, View r1) {
        setupViews$lambda$3(r0, r1);
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public String getPageEnterPageName() {
        return "edit_knowledge_sheet";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        o.e(r1, "inflater");
        return null;
    }

    public EditKnowledgeDialogFragment() {
        this.securityChecker = new b();
    }

    public static final /* synthetic */ void access$deliverResultAndDismiss(EditKnowledgeDialogFragment r0, String r1) {
        r0.deliverResultAndDismiss(r1);
    }

    public static final /* synthetic */ b access$getSecurityChecker$p(EditKnowledgeDialogFragment r0) {
        return r0.securityChecker;
    }

    private final t getBinding() {
        t r0 = this._binding;
        o.a(r0);
        return r0;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public d.h.a.b<com.obric.autoaction.common.base.a, x> configExtension() {
        return new $$Lambda$EditKnowledgeDialogFragment$6sfjbXfocIWM7KVzizVtF1wOfGI(this);
    }

    private static final x configExtension$lambda$0(EditKnowledgeDialogFragment r4, com.obric.autoaction.common.base.a r5) {
        o.e(r5, "<this>");
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b(r4.getPageEnterPageName(), false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    @Override // com.obric.autoaction.app.launcherpage.detail.base.BaseOSheetDialogFragment
    public void configureSheet(OSheet r3, Bundle r4) {
        o.e(r3, "sheet");
        this._binding = t.a(getLayoutInflater());
        r3.setBodyView((View) ZeusTransformUtils.preCheckCast(getBinding().b(), View.class, "com.obric.aiagent.plugin"));
        setupViews(r3);
        reportPageEnterSuccessOnPreDraw((View) ZeusTransformUtils.preCheckCast(getBinding().b(), View.class, "com.obric.aiagent.plugin"));
    }

    private final void setupViews(OSheet r10) {
        Bundle r11 = getArguments();
        final String r0 = "";
        if (r11 == null) goto L6;
        final String r12 = r11.getString(KEY_INITIAL_KNOWLEDGE);
        if (r12 == null) goto L6;
    L7:
        Bundle r1 = getArguments();
        if (r1 == null) goto L13;
        String r2 = r1.getString("task_id");
        if (r2 == null) goto L13;
        r0 = r2;
    L13:
        Bundle r3 = getArguments();
        if (r3 == null) goto L16;
        final int r4 = r3.getInt("task_type");
    L17:
        View r5 = ZeusTransformUtils.inflate(getLayoutInflater(), ZeusTransformUtils.mapRes(R.layout.autoaction_knowledge_input, "layout", "autoaction_knowledge_input"), (ViewGroup) ZeusTransformUtils.preCheckCast(getBinding().f22859a, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        o.a(r5, "null cannot be cast to non-null type com.obric.oui.forms.OInputLayout");
        OInputLayout r6 = (OInputLayout) ZeusTransformUtils.preCheckCast(r5, OInputLayout.class, "com.obric.aiagent.plugin");
        r6.setType(1);
        this.knowledgeInput = r6;
        getBinding().f22859a.setCustomStartView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        OFloatingTitleBar r7 = getBinding().f22860b;
        o.c(r7, "titleBar");
        com.obric.autoaction.app.launcherpage.knowledge.a.a.a(r7, new $$Lambda$EditKnowledgeDialogFragment$tG8foNaQh3dDl5s2PSJAe7uOVxs(this), new $$Lambda$EditKnowledgeDialogFragment$o9t74RzV2ZOvWrZaa4yUJMglfN0(this, r12, r0, r4));
        p.b((View) ZeusTransformUtils.preCheckCast(r6.getVInput(), View.class, "com.obric.aiagent.plugin"));
        r6.getVInput().setInputType(131073);
        r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
        r6.setType(1);
        r6.getVInput().setGravity(48);
        r6.getVInput().setSelection(r12.length());
        r6.setVisibility(0);
        r6.getVInput().setFocusable(true);
        r6.getVInput().setFocusableInTouchMode(true);
        p.c((View) ZeusTransformUtils.preCheckCast(r6.getVInput(), View.class, "com.obric.aiagent.plugin"));
        return;
    L16:
        r4 = 0;
    L6:
        r12 = "";
        goto L7
    }

    private static final void setupViews$lambda$3(EditKnowledgeDialogFragment r0, View r1) {
        OInputLayout r2 = r0.knowledgeInput;
        if (r2 == null) goto L6;
        r2.getVInput().clearFocus();
        r0.deliverResultAndDismiss(null);
        return;
    }

    private static final void setupViews$lambda$5(EditKnowledgeDialogFragment r14, String r15, String r16, int r17, View r18) {
        OInputLayout r0 = r14.knowledgeInput;
        if (r0 == null) goto L11;
        r0.getVInput().clearFocus();
        Editable r1 = r0.getVInput().getText();
        if (r1 == null) goto L8;
        String r2 = r1.toString();
        if (r2 == null) goto L8;
    L9:
        String r3 = r2;
        i.a((am) ZeusTransformUtils.preCheckCast(q.a((androidx.lifecycle.p) ZeusTransformUtils.preCheckCast(r14, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r3, r15, r16, r17, r14, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L8:
        r2 = "";
        goto L9
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.knowledgeInput = null;
        this._binding = null;
    }
}
