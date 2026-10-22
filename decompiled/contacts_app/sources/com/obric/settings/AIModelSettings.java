package com.obric.settings;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.callsummary.CallSummaryGenerateManager;
import com.obric.callsummary.model.aikernel.ABSAIKernelCallSummaryModel;
import com.obric.callsummary.model.aikernel.AISummary;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.oui.toast.OToast;
import com.obric.privacy.PrivacyUtils;
import com.obric.utils.GlobalUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: AIModelSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J7\u0010 \u001a\u00020\u00162\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\"2\u0006\u0010#\u001a\u00020\u001a2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160%H\u0002¢\u0006\u0002\u0010&J\u0016\u0010'\u001a\u00020\u00162\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)H\u0002J\b\u0010*\u001a\u00020\u0016H\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006,"}, d2 = {"Lcom/obric/settings/AIModelSettings;", "Lcom/android/contacts/BaseActivity;", "Lcom/obric/callsummary/model/aikernel/AISummary$DownloadStatusListener;", "()V", "aiModelSummaryLocal", "Lcom/obric/oui/lisitem/OListItemGeneral;", "getAiModelSummaryLocal", "()Lcom/obric/oui/lisitem/OListItemGeneral;", "setAiModelSummaryLocal", "(Lcom/obric/oui/lisitem/OListItemGeneral;)V", "isModelDownloading", "", "()Z", "setModelDownloading", "(Z)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "finish", "", "loadLocalSummaryModel", "localSummaryModelIsDownloading", "id", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDownloadStatus", "downloadStatus", "setGroup", "ids", "", "selected", "callback", "Lkotlin/Function1;", "([Ljava/lang/Integer;ILkotlin/jvm/functions/Function1;)V", "showLocalModelDialog", "positiveCallback", "Lkotlin/Function0;", "updateLocalSummaryModelStatus", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AIModelSettings extends BaseActivity implements AISummary.DownloadStatusListener {
    public static final Companion Companion = null;
    public static final String SP_KEY_SUMMARY_MODEL_TYPE = "summary_model_typ";
    private static final int TITLE_BAR_CLICK_COUNT_LIMIT = 5;
    private OListItemGeneral aiModelSummaryLocal;
    private boolean isModelDownloading;
    private TextView textView;

    /* JADX INFO: compiled from: AIModelSettings.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/settings/AIModelSettings$Companion;", "", "()V", "SP_KEY_SUMMARY_MODEL_TYPE", "", "TITLE_BAR_CLICK_COUNT_LIMIT", "", "modelTypeIndex2ModelEnum", "Lcom/obric/callsummary/CallSummaryGenerateManager$MODEL;", "index", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final CallSummaryGenerateManager.MODEL modelTypeIndex2ModelEnum(int r1) {
            if (r1 != CallSummaryGenerateManager.MODEL.AI_KERNEL_LOCAL.getTypeValue()) goto L6;
            return CallSummaryGenerateManager.MODEL.AI_KERNEL_LOCAL;
        L6:
            return CallSummaryGenerateManager.MODEL.AI_KERNEL_ONLINE;
        }
    }

    /* JADX INFO: renamed from: com.obric.settings.AIModelSettings$loadLocalSummaryModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: AIModelSettings.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.settings.AIModelSettings$loadLocalSummaryModel$1", f = "AIModelSettings.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            if (((IBaseModel) r11) == null) goto L15;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("AIModelSettings", "onNotReady");
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            this.label = 1;
            r11 = IAIKernelManager.DefaultImpls.loadPackage$default(AIKernelManager.INSTANCE, ABSAIKernelCallSummaryModel.MODEL_NAME_LOCAL, false, new RequestParams(null, null, 3, null), this, 2, null);
            if (r11 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-0fvYBdr88i7YqGNw49z44-JliE, reason: not valid java name */
    public static /* synthetic */ void m762$r8$lambda$0fvYBdr88i7YqGNw49z44JliE(AIModelSettings r0) {
        updateLocalSummaryModelStatus$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$9S_mKQv31B_7M9aXivO6NqxAlB0(Function0 r0, DialogInterface r1, int r2) {
        showLocalModelDialog$lambda$9(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$DW4asyjdAu0V-qcJDBhTIpndC8g, reason: not valid java name */
    public static /* synthetic */ void m763$r8$lambda$DW4asyjdAu0VqcJDBhTIpndC8g(AIModelSettings r0) {
        updateLocalSummaryModelStatus$lambda$5(r0);
    }

    public static /* synthetic */ void $r8$lambda$a2XG2orEx6Ovhb7Y8k9YV26928w(AIModelSettings r0, Integer[] r1, int r2, Function1 r3, int r4, List r5, OListItemGeneral r6, View r7) {
        setGroup$lambda$8$lambda$7(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: $r8$lambda$tjuijr-H58edJhilsqV_h9Ako-c, reason: not valid java name */
    public static /* synthetic */ void m764$r8$lambda$tjuijrH58edJhilsqV_h9Akoc(AIModelSettings r0) {
        updateLocalSummaryModelStatus$lambda$5$lambda$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$wVF36OB6EogwObzPj7cgpW9rwiY(AIModelSettings r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_obric_settings_AIModelSettings__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_obric_settings_AIModelSettings_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_settings_AIModelSettings_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_settings_AIModelSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public AIModelSettings() {
    }

    public static final /* synthetic */ boolean access$localSummaryModelIsDownloading(AIModelSettings r0, int r1) {
        return r0.localSummaryModelIsDownloading(r1);
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final void setTextView(TextView r1) {
        this.textView = r1;
    }

    public final OListItemGeneral getAiModelSummaryLocal() {
        return this.aiModelSummaryLocal;
    }

    public final void setAiModelSummaryLocal(OListItemGeneral r1) {
        this.aiModelSummaryLocal = r1;
    }

    public final boolean isModelDownloading() {
        return this.isModelDownloading;
    }

    public final void setModelDownloading(boolean r1) {
        this.isModelDownloading = r1;
    }

    public void com_obric_settings_AIModelSettings__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.ai_model_settings_activity);
        UiUtils.setWindowColorStatusBar(this);
        OCTitleBar r8 = (OCTitleBar) findViewById(R.id.title_bar);
        if (r8 == null) goto L5;
        r8.getMLeftActionBack().setOnClickListener(new AIModelSettings$$ExternalSyntheticLambda1(this));
    L5:
        this.aiModelSummaryLocal = (OListItemGeneral) findViewById(R.id.ai_model_summary_local);
        AIModelSettings r4 = this;
        setGroup(new Integer[]{Integer.valueOf(R.id.ai_model_summary_cloud), Integer.valueOf(R.id.ai_model_summary_local)}, SettingsProviderHelper.INSTANCE.getSummaryModelType(r4), new AnonymousClass2(this));
        int r9 = SettingsProviderHelper.INSTANCE.getVoiceModelType(r4, 0);
        if (r9 < 0) goto L9;
        if (r9 >= 2) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        r9 = 0;
    L12:
        setGroup(new Integer[]{Integer.valueOf(R.id.ai_model_asr_cloud), Integer.valueOf(R.id.ai_model_asr_local)}, r9, new AnonymousClass3(this));
        updateLocalSummaryModelStatus();
        return;
    L9:
        r1 = false;
        goto L10
    }

    private static final void onCreate$lambda$1$lambda$0(AIModelSettings r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final void updateLocalSummaryModelStatus() {
        GlobalUtils.INSTANCE.execute(new AIModelSettings$$ExternalSyntheticLambda5(this));
    }

    private static final void updateLocalSummaryModelStatus$lambda$5(final AIModelSettings r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (AISummary.INSTANCE.isModelDownloadCompleted(r2) == true) goto L5;
        r2.loadLocalSummaryModel();
        r2.runOnUiThread(new AIModelSettings$$ExternalSyntheticLambda2(r2));
        AISummary.INSTANCE.registerDownloadStatusListener(r2);
        AISummary.INSTANCE.startModelDownloadCheck();
        return;
    L5:
        r2.runOnUiThread(new AIModelSettings$$ExternalSyntheticLambda3(r2));
    }

    private static final void updateLocalSummaryModelStatus$lambda$5$lambda$3(AIModelSettings r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        r3.isModelDownloading = true;
        if (r3.textView != null) goto L5;
        TextView r0 = new TextView(r3);
        r0.setText(r3.getString(R.string.settings_ai_model_local_downloading));
        r0.setTextSize((int) 12.5d);
        r0.setTextColor(r3.getColor(R.color.oui_text_3b));
        r3.textView = r0;
    L5:
        OListItemGeneral r1 = r3.aiModelSummaryLocal;
        if (r1 == null) goto L9;
        r1.setTrailingView(r3.textView);
        return;
    }

    private static final void updateLocalSummaryModelStatus$lambda$5$lambda$4(AIModelSettings r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        int r0 = SettingsProviderHelper.INSTANCE.getSummaryModelType(r5);
        int r1 = 0;
        r5.isModelDownloading = false;
        TextView r2 = r5.textView;
        if (r2 == null) goto L6;
        r2.setVisibility(8);
    L6:
        OListItemGeneral r3 = r5.aiModelSummaryLocal;
        if (r3 == null) goto L9;
        r3.setTrailingImageView(r5.getDrawable(R.drawable.o_radio_check));
    L9:
        OListItemGeneral r6 = r5.aiModelSummaryLocal;
        if (r6 == null) goto L12;
        FrameLayout r7 = r6.getMTrailingElement();
    L13:
        if (r7 == null) goto L24;
        FrameLayout r8 = r7;
        if (Companion.modelTypeIndex2ModelEnum(r0) != CallSummaryGenerateManager.MODEL.AI_KERNEL_LOCAL) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == true) goto L22;
        r1 = 8;
    L22:
        r8.setVisibility(r1);
        return;
    L18:
        r4 = false;
        goto L19
    L24:
        return;
    L12:
        r7 = null;
        goto L13
    }

    private static final void setGroup$lambda$8$lambda$7(final AIModelSettings r12, Integer[] r13, final int r14, final Function1 r15, int r16, final List r17, final OListItemGeneral r18, View r19) {
        Intrinsics.checkNotNullParameter(r12, "this$0");
        Intrinsics.checkNotNullParameter(r13, "$ids");
        Intrinsics.checkNotNullParameter(r15, "$callback");
        Intrinsics.checkNotNullParameter(r17, "$views");
        if (r12.localSummaryModelIsDownloading(r13[r14].intValue()) == false) goto L5;
        r12.loadLocalSummaryModel();
        String r5 = r12.getString(R.string.settings_ai_model_local_downloading_toast);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.setti…_local_downloading_toast)");
        new OToast(r12, r5, 0, false, null, 0, 60, null).show();
        r15.invoke(Integer.valueOf(r16));
        return;
    L5:
        Function0<Unit> r8 = new AIModelSettings$setGroup$1$1$action$1(r17, r15, r14, r12, r18);
        if (r13[r14].intValue() != R.id.ai_model_asr_local) goto L8;
        r12.showLocalModelDialog(r8);
        return;
    L8:
        r8.invoke();
    }

    @Override // com.obric.callsummary.model.aikernel.AISummary.DownloadStatusListener
    public void onDownloadStatus(int r2) {
        if (r2 != AISummary.INSTANCE.getDOWNLOAD_STATUS_DOWNLOADED()) goto L6;
        updateLocalSummaryModelStatus();
        return;
    }

    public void com_obric_settings_AIModelSettings__finish$___twin___() {
        super.finish();
        AISummary.INSTANCE.unregisterDownloadStatusListener(this);
    }

    private final boolean localSummaryModelIsDownloading(int r2) {
        if (r2 == R.id.ai_model_summary_local) goto L7;
        return false;
    L7:
        return this.isModelDownloading;
    }

    private final void loadLocalSummaryModel() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    }

    private final void showLocalModelDialog(final Function0<Unit> r14) {
        OAlertDialogBuilder.negativeButton$default(OAlertDialogBuilder.positiveButton$default(new OAlertDialogBuilder(this).title(R.string.title_use_local_model).message(getString(R.string.title_use_local_model_tip)), R.string.common_ok, new AIModelSettings$$ExternalSyntheticLambda4(r14), null, 4, null), R.string.common_cancel, null, null, 4, null).build().show();
    }

    private static final void showLocalModelDialog$lambda$9(Function0 r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "$positiveCallback");
        r0.invoke();
    }

    private final void setGroup(final Integer[] r17, final int r18, final Function1<? super Integer, Unit> r19) {
        ArrayList r0 = new ArrayList(r17.length);
        int r1 = r17.length;
        int r10 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add((OListItemGeneral) findViewById(r17[r2].intValue()));
        r2 = r2 + 1;
        goto L3
    L5:
        final ArrayList r11 = r0;
        Iterator r12 = r11.iterator();
        final int r3 = 0;
    L7:
        if (r12.hasNext() == false) goto L33;
        Object r4 = r12.next();
        int r13 = r3 + 1;
        if (r3 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        final OListItemGeneral r14 = (OListItemGeneral) r4;
        FrameLayout r5 = null;
        if (localSummaryModelIsDownloading(r17[r3].intValue()) == false) goto L18;
        if (r14 == null) goto L15;
        r5 = r14.getMTrailingElement();
    L15:
        if (r5 == null) goto L30;
        r5.setVisibility(r10);
    L30:
        if (r14 == null) goto L32;
        r14.setOnClickListener(new AIModelSettings$$ExternalSyntheticLambda0(this, r17, r3, r19, r18, r11, r14));
    L32:
        r3 = r13;
        r10 = 0;
        goto L7
    L18:
        if (r14 == null) goto L20;
        r5 = r14.getMTrailingElement();
    L20:
        if (r5 == null) goto L30;
        FrameLayout r6 = r5;
        if (r3 == r18) goto L25;
        int r7 = 1;
    L26:
        if (r7 == 0) goto L28;
        int r8 = 8;
    L29:
        r6.setVisibility(r8);
        goto L30
    L28:
        r8 = r10;
        goto L29
    L25:
        r7 = r10;
        goto L26
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_settings_AIModelSettings_com_obric_privacyhook_PrivacyHook_onCreate(AIModelSettings r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AIModelSettings r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_settings_AIModelSettings__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_settings_AIModelSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(AIModelSettings r1) {
        com_obric_settings_AIModelSettings_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_settings_AIModelSettings_com_obric_privacyhook_PrivacyHook_onStop(AIModelSettings r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AIModelSettings r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_settings_AIModelSettings__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_obric_settings_AIModelSettings_com_obric_privacyhook_PrivacyHook_finish(AIModelSettings r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        AIModelSettings r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_obric_settings_AIModelSettings__finish$___twin___();
    }
}
