package com.obric.Intelligentcall.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.GlobalProxyLancet;
import com.airbnb.lottie.LottieAnimationView;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.network.request.intelligentvoice.IntelligentVoiceHelper;
import com.obric.network.request.intelligentvoice.SoundCopyResponseBody;
import com.obric.network.request.intelligentvoice.SoundFailResponseBody;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.ToolsExtKt;
import com.obric.oui.dialog.DialogUtils;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.oui.titlebar.optimize.OCTitleBarExtKt;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.OldOPageStatus;
import com.obric.utils.AudioRecord;
import com.obric.utils.ViewAnimationUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 U2\u00020\u0001:\u0003TUVB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u001cH\u0002J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020\bH\u0002J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\bH\u0002J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020\bH\u0002J'\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0002\u00102J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\bH\u0002J \u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020\"2\u0006\u00104\u001a\u00020\bH\u0002J\u0012\u00108\u001a\u00020$2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u000201H\u0016J\b\u0010=\u001a\u00020$H\u0014J\u0010\u0010>\u001a\u00020$2\u0006\u0010<\u001a\u000201H\u0016J\b\u0010?\u001a\u00020$H\u0002J\b\u0010@\u001a\u00020$H\u0002J\b\u0010A\u001a\u00020$H\u0002J\b\u0010B\u001a\u00020$H\u0002J\b\u0010C\u001a\u00020$H\u0002J\u001c\u0010D\u001a\u00020$2\u0006\u0010.\u001a\u00020\b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010F\u001a\u00020$2\u0006\u0010G\u001a\u000201H\u0002J\b\u0010H\u001a\u00020$H\u0002J\b\u0010I\u001a\u00020$H\u0002J8\u0010J\u001a\u00020$2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010K\u001a\u00020\u00142\u0006\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020NH\u0002J\u001c\u0010O\u001a\u00020$2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010P\u001a\u000201H\u0002J\b\u0010Q\u001a\u00020$H\u0002J\u001a\u0010R\u001a\u00020$2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010S\u001a\u00020\u0014H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentSoundPanelActivity;", "Lcom/android/contacts/BaseActivity;", "()V", "bottomLottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "centerView", "Landroid/view/View;", "currentPromptText", "", Params.FILE_PATH, "imageIcon", "Landroid/widget/ImageView;", "imageRetryBtn", "Lcom/obric/oui/button/OButton;", "imageSubtitle", "Landroid/widget/TextView;", "imageTitle", "intelligentSoundPanelLayout", "Landroid/view/ViewGroup;", "isDialogFinished", "", "isPromptReady", "isRecording", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onRetryClickListener", "Landroid/view/View$OnClickListener;", "onRetryNetworkErrClickListener", "promptSource", "Lcom/obric/Intelligentcall/activity/IntelligentSoundPanelActivity$PromptSource;", "recordPromptTextView", "recordSuccess", "recordUtils", "Lcom/obric/utils/AudioRecord;", "status", "Lcom/obric/Intelligentcall/activity/IntelligentSoundPanelActivity$CenterViewStatus;", "applyPromptText", "", "promptText", "source", "clearPromptText", "ensurePromptTextForSubmit", "fallbackToLocalPrompt", "reason", "finish", "getFallbackPromptText", "handleCreateSoundCopyFailure", "fileUrl", "soundName", "errCode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "logExitState", "scene", "logStatusTransition", "from", "to", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "onPause", "onStatusBarHeightChanged", "releaseRecord", "requestPromptAndEnterStart", "retryCurrentStage", "retryRecord", "showExitDialog", "showNameEditDialog", "initialName", "showSoundCopyFailureToast", "messageResId", "startRecord", "stopRecord", "submitSoundCopyFromDialog", "isPositive", "hasSubmitted", "dialog", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog;", "updateCenterView", "recordErrorSubtitleResId", "updatePromptTextViews", "uploadFile", "isRetry", "CenterViewStatus", "Companion", "PromptSource", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentSoundPanelActivity extends BaseActivity {
    public static final Companion Companion = null;
    private static final String TAG = "IntelligentSoundPanelActivity";
    private LottieAnimationView bottomLottieView;
    private View centerView;
    private String currentPromptText;
    private String filePath;
    private ImageView imageIcon;
    private OButton imageRetryBtn;
    private TextView imageSubtitle;
    private TextView imageTitle;
    private ViewGroup intelligentSoundPanelLayout;
    private boolean isDialogFinished;
    private boolean isPromptReady;
    private final AtomicBoolean isRecording;
    private final View.OnClickListener onRetryClickListener;
    private final View.OnClickListener onRetryNetworkErrClickListener;
    private PromptSource promptSource;
    private TextView recordPromptTextView;
    private boolean recordSuccess;
    private final AudioRecord recordUtils;
    private CenterViewStatus status;

    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentSoundPanelActivity$CenterViewStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "PROMPT_LOADING", "START", "RECORDING", "LOAD_RECORD", "RECORD_SUCCESS", "RECORD_ERROR", "NETWORK_ERROR", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum CenterViewStatus extends Enum<CenterViewStatus> {
        private static final /* synthetic */ CenterViewStatus[] $VALUES = null;
        public static final CenterViewStatus LOAD_RECORD = null;
        public static final CenterViewStatus NETWORK_ERROR = null;
        public static final CenterViewStatus PROMPT_LOADING = null;
        public static final CenterViewStatus RECORDING = null;
        public static final CenterViewStatus RECORD_ERROR = null;
        public static final CenterViewStatus RECORD_SUCCESS = null;
        public static final CenterViewStatus START = null;
        private final int value;

        private static final /* synthetic */ CenterViewStatus[] $values() {
            return new CenterViewStatus[]{PROMPT_LOADING, START, RECORDING, LOAD_RECORD, RECORD_SUCCESS, RECORD_ERROR, NETWORK_ERROR};
        }

        public static CenterViewStatus valueOf(String r1) {
            return (CenterViewStatus) Enum.valueOf(CenterViewStatus.class, r1);
        }

        public static CenterViewStatus[] values() {
            return (CenterViewStatus[]) $VALUES.clone();
        }

        private CenterViewStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            PROMPT_LOADING = new CenterViewStatus("PROMPT_LOADING", 0, 0);
            START = new CenterViewStatus("START", 1, 1);
            RECORDING = new CenterViewStatus("RECORDING", 2, 2);
            LOAD_RECORD = new CenterViewStatus("LOAD_RECORD", 3, 3);
            RECORD_SUCCESS = new CenterViewStatus("RECORD_SUCCESS", 4, 4);
            RECORD_ERROR = new CenterViewStatus("RECORD_ERROR", 5, 5);
            NETWORK_ERROR = new CenterViewStatus("NETWORK_ERROR", 6, 6);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentSoundPanelActivity$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentSoundPanelActivity$PromptSource;", "", "(Ljava/lang/String;I)V", "REMOTE", "FALLBACK", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum PromptSource extends Enum<PromptSource> {
        private static final /* synthetic */ PromptSource[] $VALUES = null;
        public static final PromptSource FALLBACK = null;
        public static final PromptSource REMOTE = null;

        private static final /* synthetic */ PromptSource[] $values() {
            return new PromptSource[]{REMOTE, FALLBACK};
        }

        public static PromptSource valueOf(String r1) {
            return (PromptSource) Enum.valueOf(PromptSource.class, r1);
        }

        public static PromptSource[] values() {
            return (PromptSource[]) $VALUES.clone();
        }

        private PromptSource(String r1, int r2) {
            super(r1, r2);
        }

        static {
            REMOTE = new PromptSource("REMOTE", 0);
            FALLBACK = new PromptSource("FALLBACK", 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[IntelligentVoiceHelper.SoundCopyFailureType.values().length];
            r0[IntelligentVoiceHelper.SoundCopyFailureType.VOICE_REVIEW_REJECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[IntelligentVoiceHelper.SoundCopyFailureType.NAME_REVIEW_REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[IntelligentVoiceHelper.SoundCopyFailureType.COPY_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[IntelligentVoiceHelper.SoundCopyFailureType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$requestPromptAndEnterStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "promptText", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02151 extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ IntelligentSoundPanelActivity this$0;

        /* JADX INFO: renamed from: $r8$lambda$Yzms-nj0dU2WnWQklGfr0QlM6Kk, reason: not valid java name */
        public static /* synthetic */ void m299$r8$lambda$Yzmsnj0dU2WnWQklGfr0QlM6Kk(IntelligentSoundPanelActivity r0, String r1) {
            invoke$lambda$0(r0, r1);
        }

        C02151(IntelligentSoundPanelActivity r1) {
            this.this$0 = r1;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final String r2) {
            Intrinsics.checkNotNullParameter(r2, "promptText");
            final IntelligentSoundPanelActivity r1 = this.this$0;
            r1.runOnUiThread(new IntelligentSoundPanelActivity$requestPromptAndEnterStart$1$$ExternalSyntheticLambda0(r1, r2));
        }

        private static final void invoke$lambda$0(IntelligentSoundPanelActivity r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "this$0");
            Intrinsics.checkNotNullParameter(r4, "$promptText");
            IntelligentSoundPanelActivity.access$applyPromptText(r3, r4, PromptSource.REMOTE);
            IntelligentSoundPanelActivity.updateCenterView$default(r3, CenterViewStatus.START, 0, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$requestPromptAndEnterStart$2, reason: invalid class name */
    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        final /* synthetic */ IntelligentSoundPanelActivity this$0;

        public static /* synthetic */ void $r8$lambda$MtkpBCi2Stk3IaDqVvJYXJ0T1pA(IntelligentSoundPanelActivity r0) {
            invoke$lambda$0(r0);
        }

        AnonymousClass2(IntelligentSoundPanelActivity r1) {
            this.this$0 = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final IntelligentSoundPanelActivity r1 = this.this$0;
            r1.runOnUiThread(new IntelligentSoundPanelActivity$requestPromptAndEnterStart$2$$ExternalSyntheticLambda0(r1));
        }

        private static final void invoke$lambda$0(IntelligentSoundPanelActivity r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            IntelligentSoundPanelActivity.access$fallbackToLocalPrompt(r1, "empty");
        }
    }

    /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$requestPromptAndEnterStart$3, reason: invalid class name */
    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", NotificationCompat.CATEGORY_ERROR, "", "invoke", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda implements Function3<Integer, String, Throwable, Unit> {
        final /* synthetic */ IntelligentSoundPanelActivity this$0;

        public static /* synthetic */ void $r8$lambda$rpjj6sdmje_cuuz1Tw289uHwtDw(IntelligentSoundPanelActivity r0) {
            invoke$lambda$0(r0);
        }

        AnonymousClass3(IntelligentSoundPanelActivity r1) {
            this.this$0 = r1;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer r1, String r2, Throwable r3) {
            invoke2(r1, r2, r3);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Integer r3, String r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_ERROR);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(IntelligentSoundPanelActivity.TAG, "requestPromptAndEnterStart fallback code=" + r3 + ", msg=" + r4, r5);
            final IntelligentSoundPanelActivity r2 = this.this$0;
            r2.runOnUiThread(new IntelligentSoundPanelActivity$requestPromptAndEnterStart$3$$ExternalSyntheticLambda0(r2));
        }

        private static final void invoke$lambda$0(IntelligentSoundPanelActivity r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            IntelligentSoundPanelActivity.access$fallbackToLocalPrompt(r1, "failure");
        }
    }

    /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$submitSoundCopyFromDialog$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/network/request/intelligentvoice/SoundCopyResponseBody;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02162 extends Lambda implements Function1<SoundCopyResponseBody, Unit> {
        final /* synthetic */ IntelligentSoundPanelActivity this$0;

        public static /* synthetic */ void $r8$lambda$OoZCZj37aP6rJha0Zvn77UkolTU(IntelligentSoundPanelActivity r0) {
            invoke$lambda$0(r0);
        }

        C02162(IntelligentSoundPanelActivity r1) {
            this.this$0 = r1;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SoundCopyResponseBody r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SoundCopyResponseBody r2) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntelligentSoundPanelActivity.TAG, "拷贝成功");
            final IntelligentSoundPanelActivity r1 = this.this$0;
            r1.runOnUiThread(new IntelligentSoundPanelActivity$submitSoundCopyFromDialog$2$$ExternalSyntheticLambda0(r1));
        }

        private static final void invoke$lambda$0(IntelligentSoundPanelActivity r4) {
            Intrinsics.checkNotNullParameter(r4, "this$0");
            IntelligentSoundPanelActivity.updateCenterView$default(r4, CenterViewStatus.RECORD_SUCCESS, 0, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$submitSoundCopyFromDialog$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", NotificationCompat.CATEGORY_ERROR, "", "invoke", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02173 extends Lambda implements Function3<Integer, String, Throwable, Unit> {
        final /* synthetic */ String $fileUrl;
        final /* synthetic */ String $soundName;
        final /* synthetic */ IntelligentSoundPanelActivity this$0;

        public static /* synthetic */ void $r8$lambda$tttNbj9QMStrsa8B9JIRBpk1GKY(Integer r0, String r1, Throwable r2, IntelligentSoundPanelActivity r3, String r4, String r5) {
            invoke$lambda$0(r0, r1, r2, r3, r4, r5);
        }

        C02173(IntelligentSoundPanelActivity r1, String r2, String r3) {
            this.this$0 = r1;
            this.$fileUrl = r2;
            this.$soundName = r3;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer r1, String r2, Throwable r3) {
            invoke2(r1, r2, r3);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final Integer r9, final String r10, final Throwable r11) {
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_ERROR);
            final IntelligentSoundPanelActivity r0 = this.this$0;
            final String r6 = this.$fileUrl;
            final String r7 = this.$soundName;
            r0.runOnUiThread(new IntelligentSoundPanelActivity$submitSoundCopyFromDialog$3$$ExternalSyntheticLambda0(r9, r10, r11, r0, r6, r7));
        }

        private static final void invoke$lambda$0(Integer r2, String r3, Throwable r4, IntelligentSoundPanelActivity r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r4, "$err");
            Intrinsics.checkNotNullParameter(r5, "this$0");
            Intrinsics.checkNotNullParameter(r6, "$fileUrl");
            Intrinsics.checkNotNullParameter(r7, "$soundName");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntelligentSoundPanelActivity.TAG, "拷贝失败 " + r2 + ", " + r3 + ", " + r4);
            IntelligentSoundPanelActivity.access$handleCreateSoundCopyFailure(r5, r6, r7, r2);
        }
    }

    /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$updateCenterView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02181 extends Lambda implements Function0<Unit> {
        final /* synthetic */ int $recordErrorSubtitleResId;
        final /* synthetic */ CenterViewStatus $status;
        final /* synthetic */ IntelligentSoundPanelActivity this$0;

        /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$updateCenterView$1$WhenMappings */
        /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[CenterViewStatus.values().length];
                r0[CenterViewStatus.PROMPT_LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r0[CenterViewStatus.START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r0[CenterViewStatus.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[CenterViewStatus.LOAD_RECORD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r0[CenterViewStatus.RECORD_SUCCESS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r0[CenterViewStatus.RECORD_ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r0[CenterViewStatus.NETWORK_ERROR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                $EnumSwitchMapping$0 = r0;
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$3ZSxDlpz9ffmFk6YW_z-Q98VNWk, reason: not valid java name */
        public static /* synthetic */ void m301$r8$lambda$3ZSxDlpz9ffmFk6YW_zQ98VNWk(IntelligentSoundPanelActivity r0, View r1) {
            invoke$lambda$6$lambda$5(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$NcOPIP5CqxcY2H3zy8Hd6yEbyvI(IntelligentSoundPanelActivity r0, View r1) {
            invoke$lambda$19$lambda$18(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$jS5fzF8sMPvqgF2eLOMLG21a34k(IntelligentSoundPanelActivity r0, View r1) {
            invoke$lambda$15$lambda$14(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$k9zVDdMcF2QQAIraa_fxYP8h49g(IntelligentSoundPanelActivity r0, View r1) {
            invoke$lambda$8$lambda$7(r0, r1);
        }

        C02181(IntelligentSoundPanelActivity r1, CenterViewStatus r2, int r3) {
            this.this$0 = r1;
            this.$status = r2;
            this.$recordErrorSubtitleResId = r3;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CenterViewStatus r0 = IntelligentSoundPanelActivity.access$getStatus$p(this.this$0);
            IntelligentSoundPanelActivity.access$setStatus$p(this.this$0, this.$status);
            IntelligentSoundPanelActivity.access$logStatusTransition(this.this$0, r0, this.$status, "updateCenterView");
            View r1 = this.this$0.findViewById(R.id.center_text_view);
            Intrinsics.checkNotNull(r1);
            View r2 = this.this$0.findViewById(R.id.center_image_view);
            Intrinsics.checkNotNull(r2);
            OldOPageStatus r3 = (OldOPageStatus) r2;
            View r4 = this.this$0.findViewById(R.id.bottom_btn_primary);
            Intrinsics.checkNotNull(r4);
            OButton r5 = (OButton) r4;
            View r6 = this.this$0.findViewById(R.id.bottom_btn_neutral);
            Intrinsics.checkNotNull(r6);
            OButton r7 = (OButton) r6;
            IntelligentSoundPanelActivity r8 = this.this$0;
            View r9 = r8.findViewById(R.id.bottom_lottie_view);
            Intrinsics.checkNotNull(r9);
            IntelligentSoundPanelActivity.access$setBottomLottieView$p(r8, (LottieAnimationView) r9);
            View r10 = this.this$0.findViewById(R.id.bottom_lottie_container);
            Intrinsics.checkNotNull(r10);
            View r11 = this.this$0.findViewById(R.id.bottom_tips);
            IntelligentSoundPanelActivity.access$updatePromptTextViews(this.this$0);
            CenterViewStatus r12 = IntelligentSoundPanelActivity.access$getStatus$p(this.this$0);
            switch(WhenMappings.$EnumSwitchMapping$0[r12.ordinal()]) {
                case 1: goto L204;
                case 2: goto L166;
                case 3: goto L156;
                case 4: goto L124;
                case 5: goto L91;
                case 6: goto L52;
                case 7: goto L5;
                default: goto L244;
            };
        L5:
            r1.setVisibility(8);
            r3.setVisibility(0);
            if (r11 == null) goto L10;
            r11.setVisibility(8);
        L10:
            if (IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0) != null) goto L12;
            IntelligentSoundPanelActivity.access$setImageIcon$p(this.this$0, r3.setTopImage(R.drawable.record_network_err));
        L16:
            if (IntelligentUtils.INSTANCE.isNetworkAvailable(this.this$0) == false) goto L18;
            String r13 = this.this$0.getString(R.string.intelligent_sound_panel_network_err_title);
        L19:
            Intrinsics.checkNotNullExpressionValue(r13, "if(IntelligentUtils.isNe…ps)\n                    }");
            if (IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0) != null) goto L22;
            IntelligentSoundPanelActivity r14 = this.this$0;
            TextView r15 = r3.setMessage(r13);
            r15.setTextColor(r15.getResources().getColor(R.color.oui_text_3));
            Unit r16 = Unit.INSTANCE;
            IntelligentSoundPanelActivity.access$setImageSubtitle$p(r14, r15);
        L26:
            if (IntelligentSoundPanelActivity.access$getImageRetryBtn$p(this.this$0) != null) goto L28;
            IntelligentSoundPanelActivity r17 = this.this$0;
            OButton r18 = OButton.Companion.createNeutralButton(this.this$0, r3);
            r18.setText(this.this$0.getString(R.string.intelligent_sound_panel_center_btn_network_err));
            Unit r19 = Unit.INSTANCE;
            IntelligentSoundPanelActivity.access$setImageRetryBtn$p(r17, r18);
        L28:
            OButton r20 = IntelligentSoundPanelActivity.access$getImageRetryBtn$p(this.this$0);
            if (r20 != null) goto L31;
        L35:
            TextView r21 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r21 == null) goto L39;
            r21.setVisibility(0);
        L39:
            OButton r22 = IntelligentSoundPanelActivity.access$getImageRetryBtn$p(this.this$0);
            if (r22 == null) goto L43;
            r22.setVisibility(0);
        L43:
            TextView r23 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r23 == null) goto L47;
            r23.setVisibility(8);
        L47:
            r5.setVisibility(8);
            LottieAnimationView r110 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(this.this$0);
            if (r110 == null) goto L51;
            r110.setVisibility(8);
        L51:
            r10.setVisibility(8);
            r7.setVisibility(8);
            return;
        L31:
            if (IntelligentUtils.INSTANCE.isNetworkAvailable(this.this$0) == false) goto L33;
            View.OnClickListener r24 = IntelligentSoundPanelActivity.access$getOnRetryClickListener$p(this.this$0);
        L34:
            r20.setOnClickListener(r24);
            Unit r25 = Unit.INSTANCE;
            goto L35
        L33:
            r24 = IntelligentSoundPanelActivity.access$getOnRetryNetworkErrClickListener$p(this.this$0);
            goto L34
        L22:
            TextView r26 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r26 == null) goto L26;
            r26.setText(r13);
            r26.setTextColor(r26.getResources().getColor(R.color.oui_text_3));
            goto L26
        L18:
            r13 = this.this$0.getString(R.string.intelligent_sound_network_err_no_network_tips);
            goto L19
        L12:
            ImageView r27 = IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0);
            if (r27 == null) goto L16;
            r27.setImageResource(R.drawable.record_network_err);
            Unit r28 = Unit.INSTANCE;
            goto L16
        L52:
            IntelligentSoundPanelActivity.access$releaseRecord(this.this$0);
            r1.setVisibility(8);
            r3.setVisibility(0);
            if (r11 == null) goto L57;
            r11.setVisibility(8);
        L57:
            if (IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0) != null) goto L59;
            IntelligentSoundPanelActivity.access$setImageIcon$p(this.this$0, r3.setTopImage(R.drawable.record_error));
        L63:
            if (IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0) != null) goto L65;
            IntelligentSoundPanelActivity r29 = this.this$0;
            String r30 = r29.getString(R.string.intelligent_sound_panel_record_err_title);
            Intrinsics.checkNotNullExpressionValue(r30, "getString(R.string.intel…d_panel_record_err_title)");
            TextView r31 = r3.setTitle(r30);
            r31.setTextColor(r31.getResources().getColor(R.color.oui_text_1));
            Unit r32 = Unit.INSTANCE;
            IntelligentSoundPanelActivity.access$setImageTitle$p(r29, r31);
        L69:
            if (IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0) != null) goto L71;
            IntelligentSoundPanelActivity r33 = this.this$0;
            String r34 = r33.getString(this.$recordErrorSubtitleResId);
            Intrinsics.checkNotNullExpressionValue(r34, "getString(recordErrorSubtitleResId)");
            IntelligentSoundPanelActivity.access$setImageSubtitle$p(r33, r3.setMessage(r34));
        L74:
            TextView r35 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r35 == null) goto L78;
            r35.setVisibility(0);
        L78:
            OButton r36 = IntelligentSoundPanelActivity.access$getImageRetryBtn$p(this.this$0);
            if (r36 == null) goto L82;
            r36.setVisibility(8);
        L82:
            TextView r37 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r37 == null) goto L86;
            r37.setVisibility(0);
        L86:
            r5.setVisibility(8);
            LottieAnimationView r38 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(this.this$0);
            if (r38 == null) goto L90;
            r38.setVisibility(8);
        L90:
            r10.setVisibility(8);
            final IntelligentSoundPanelActivity r111 = this.this$0;
            r7.setEnabled(true);
            r7.setVisibility(0);
            r7.setText(r111.getString(R.string.intelligent_sound_panel_bottom_btn_record_err));
            r7.setOnClickListener(new IntelligentSoundPanelActivity$updateCenterView$1$$ExternalSyntheticLambda3(r111));
            return;
        L71:
            TextView r39 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r39 == null) goto L74;
            r39.setText(this.this$0.getString(this.$recordErrorSubtitleResId));
            Unit r40 = Unit.INSTANCE;
            goto L74
        L65:
            TextView r41 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r41 == null) goto L69;
            r41.setText(this.this$0.getString(R.string.intelligent_sound_panel_record_err_title));
            r41.setTextColor(r41.getResources().getColor(R.color.oui_text_1));
            goto L69
        L59:
            ImageView r42 = IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0);
            if (r42 == null) goto L63;
            r42.setImageResource(R.drawable.record_error);
            Unit r43 = Unit.INSTANCE;
            goto L63
        L91:
            IntelligentSoundPanelActivity.access$setRecordSuccess$p(this.this$0, true);
            IntelligentSoundPanelActivity.access$setDialogFinished$p(this.this$0, false);
            r1.setVisibility(8);
            r3.setVisibility(0);
            if (r11 == null) goto L96;
            r11.setVisibility(8);
        L96:
            if (IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0) != null) goto L98;
            IntelligentSoundPanelActivity.access$setImageIcon$p(this.this$0, r3.setTopImage(R.drawable.record_success));
        L102:
            if (IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0) != null) goto L104;
            IntelligentSoundPanelActivity r44 = this.this$0;
            String r45 = r44.getString(R.string.intelligent_sound_panel_record_success_title);
            Intrinsics.checkNotNullExpressionValue(r45, "getString(R.string.intel…nel_record_success_title)");
            TextView r46 = r3.setTitle(r45);
            r46.setTextColor(r46.getResources().getColor(R.color.oui_text_1));
            Unit r47 = Unit.INSTANCE;
            IntelligentSoundPanelActivity.access$setImageTitle$p(r44, r46);
        L107:
            OButton r48 = IntelligentSoundPanelActivity.access$getImageRetryBtn$p(this.this$0);
            if (r48 == null) goto L111;
            r48.setVisibility(8);
        L111:
            TextView r49 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r49 == null) goto L115;
            r49.setVisibility(8);
        L115:
            TextView r50 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r50 == null) goto L119;
            r50.setVisibility(0);
        L119:
            final IntelligentSoundPanelActivity r51 = this.this$0;
            r5.setVisibility(0);
            r5.setEnabled(true);
            r5.setText(r51.getString(R.string.common_done));
            r5.setOnClickListener(new IntelligentSoundPanelActivity$updateCenterView$1$$ExternalSyntheticLambda2(r51));
            LottieAnimationView r112 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(this.this$0);
            if (r112 == null) goto L123;
            r112.setVisibility(8);
        L123:
            r10.setVisibility(8);
            r7.setVisibility(8);
            return;
        L104:
            TextView r52 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r52 == null) goto L107;
            r52.setText(this.this$0.getString(R.string.intelligent_sound_panel_record_success_title));
            r52.setTextColor(r52.getResources().getColor(R.color.oui_text_1));
            goto L107
        L98:
            ImageView r53 = IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0);
            if (r53 == null) goto L102;
            r53.setImageResource(R.drawable.record_success);
            Unit r54 = Unit.INSTANCE;
            goto L102
        L124:
            r1.setVisibility(8);
            r3.setVisibility(0);
            if (IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0) != null) goto L127;
            IntelligentSoundPanelActivity.access$setImageIcon$p(this.this$0, r3.setTopImage(R.drawable.record_loading));
        L131:
            if (IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0) != null) goto L133;
            IntelligentSoundPanelActivity r55 = this.this$0;
            String r56 = r55.getString(R.string.intelligent_sound_panel_record_loading_title);
            Intrinsics.checkNotNullExpressionValue(r56, "getString(R.string.intel…nel_record_loading_title)");
            TextView r57 = r3.setTitle(r56);
            r57.setTextColor(r57.getResources().getColor(R.color.oui_text_1));
            Unit r58 = Unit.INSTANCE;
            IntelligentSoundPanelActivity.access$setImageTitle$p(r55, r57);
        L136:
            OButton r59 = IntelligentSoundPanelActivity.access$getImageRetryBtn$p(this.this$0);
            if (r59 == null) goto L140;
            r59.setVisibility(8);
        L140:
            TextView r60 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r60 == null) goto L144;
            r60.setVisibility(8);
        L144:
            TextView r61 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r61 == null) goto L148;
            r61.setVisibility(0);
        L148:
            if (r11 == null) goto L151;
            r11.setVisibility(8);
        L151:
            IntelligentSoundPanelActivity r62 = this.this$0;
            r5.setVisibility(0);
            r5.setEnabled(false);
            r5.setText(r62.getString(R.string.intelligent_sound_panel_bottom_btn_loading));
            LottieAnimationView r113 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(this.this$0);
            if (r113 == null) goto L155;
            r113.setVisibility(8);
        L155:
            r10.setVisibility(8);
            r7.setVisibility(8);
            return;
        L133:
            TextView r63 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r63 == null) goto L136;
            r63.setText(this.this$0.getString(R.string.intelligent_sound_panel_record_loading_title));
            r63.setTextColor(r63.getResources().getColor(R.color.oui_text_1));
            goto L136
        L127:
            ImageView r64 = IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0);
            if (r64 == null) goto L131;
            r64.setImageResource(R.drawable.record_loading);
            Unit r65 = Unit.INSTANCE;
            goto L131
        L156:
            r1.setVisibility(0);
            r3.setVisibility(8);
            r5.setVisibility(8);
            r7.setVisibility(8);
            final IntelligentSoundPanelActivity r66 = this.this$0;
            r10.setEnabled(true);
            r10.setVisibility(0);
            r10.setOnClickListener(new IntelligentSoundPanelActivity$updateCenterView$1$$ExternalSyntheticLambda1(r66));
            LottieAnimationView r67 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(this.this$0);
            if (r67 == null) goto L160;
            r67.setVisibility(0);
        L160:
            if (r11 == null) goto L163;
            r11.setVisibility(0);
        L163:
            LottieAnimationView r114 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(this.this$0);
            if (r114 == null) goto L241;
            r114.pauseAnimation();
            Unit r115 = Unit.INSTANCE;
            return;
        L241:
            return;
        L166:
            r1.setVisibility(8);
            r3.setVisibility(0);
            if (IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0) != null) goto L169;
            IntelligentSoundPanelActivity.access$setImageIcon$p(this.this$0, r3.setTopImage(R.drawable.record_start));
        L173:
            if (IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0) != null) goto L175;
            IntelligentSoundPanelActivity r68 = this.this$0;
            String r69 = r68.getString(R.string.intelligent_sound_panel_start_title);
            Intrinsics.checkNotNullExpressionValue(r69, "getString(R.string.intel…_sound_panel_start_title)");
            TextView r70 = r3.setTitle(r69);
            r70.setTextColor(r70.getResources().getColor(R.color.oui_text_1));
            Unit r71 = Unit.INSTANCE;
            IntelligentSoundPanelActivity.access$setImageTitle$p(r68, r70);
        L179:
            if (IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0) != null) goto L181;
            IntelligentSoundPanelActivity r72 = this.this$0;
            String r73 = r72.getString(R.string.intelligent_sound_panel_start_subtitle);
            Intrinsics.checkNotNullExpressionValue(r73, "getString(R.string.intel…und_panel_start_subtitle)");
            IntelligentSoundPanelActivity.access$setImageSubtitle$p(r72, r3.setMessage(r73));
        L184:
            TextView r74 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r74 == null) goto L188;
            r74.setVisibility(0);
        L188:
            OButton r75 = IntelligentSoundPanelActivity.access$getImageRetryBtn$p(this.this$0);
            if (r75 == null) goto L192;
            r75.setVisibility(8);
        L192:
            TextView r76 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r76 == null) goto L196;
            r76.setVisibility(0);
        L196:
            LottieAnimationView r77 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(this.this$0);
            if (r77 == null) goto L200;
            r77.setVisibility(8);
        L200:
            if (r11 == null) goto L203;
            r11.setVisibility(8);
        L203:
            r10.setVisibility(8);
            r7.setVisibility(8);
            final IntelligentSoundPanelActivity r116 = this.this$0;
            r5.setEnabled(IntelligentSoundPanelActivity.access$isPromptReady$p(r116));
            r5.setVisibility(0);
            r5.setText(r116.getString(R.string.intelligent_sound_panel_bottom_btn_start));
            r5.setOnClickListener(new IntelligentSoundPanelActivity$updateCenterView$1$$ExternalSyntheticLambda0(r116));
            return;
        L181:
            TextView r78 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r78 == null) goto L184;
            r78.setText(this.this$0.getString(R.string.intelligent_sound_panel_start_subtitle));
            Unit r79 = Unit.INSTANCE;
            goto L184
        L175:
            TextView r80 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r80 == null) goto L179;
            r80.setText(this.this$0.getString(R.string.intelligent_sound_panel_start_title));
            r80.setTextColor(r80.getResources().getColor(R.color.oui_text_1));
            goto L179
        L169:
            ImageView r81 = IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0);
            if (r81 == null) goto L173;
            r81.setImageResource(R.drawable.record_start);
            Unit r82 = Unit.INSTANCE;
            goto L173
        L204:
            r1.setVisibility(8);
            r3.setVisibility(0);
            if (IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0) != null) goto L207;
            IntelligentSoundPanelActivity.access$setImageIcon$p(this.this$0, r3.setTopImage(R.drawable.record_loading));
        L211:
            if (IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0) != null) goto L213;
            IntelligentSoundPanelActivity r83 = this.this$0;
            String r84 = r83.getString(R.string.intelligent_sound_panel_prompt_loading_title);
            Intrinsics.checkNotNullExpressionValue(r84, "getString(R.string.intel…nel_prompt_loading_title)");
            TextView r85 = r3.setTitle(r84);
            r85.setTextColor(r85.getResources().getColor(R.color.oui_text_1));
            Unit r86 = Unit.INSTANCE;
            IntelligentSoundPanelActivity.access$setImageTitle$p(r83, r85);
        L216:
            OButton r87 = IntelligentSoundPanelActivity.access$getImageRetryBtn$p(this.this$0);
            if (r87 == null) goto L220;
            r87.setVisibility(8);
        L220:
            TextView r88 = IntelligentSoundPanelActivity.access$getImageSubtitle$p(this.this$0);
            if (r88 == null) goto L224;
            r88.setVisibility(8);
        L224:
            TextView r89 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r89 == null) goto L228;
            r89.setVisibility(0);
        L228:
            if (r11 == null) goto L231;
            r11.setVisibility(8);
        L231:
            IntelligentSoundPanelActivity r90 = this.this$0;
            r5.setVisibility(0);
            r5.setEnabled(false);
            r5.setText(r90.getString(R.string.intelligent_sound_panel_bottom_btn_loading));
            LottieAnimationView r117 = IntelligentSoundPanelActivity.access$getBottomLottieView$p(this.this$0);
            if (r117 == null) goto L235;
            r117.setVisibility(8);
        L235:
            r10.setVisibility(8);
            r7.setVisibility(8);
            return;
        L213:
            TextView r91 = IntelligentSoundPanelActivity.access$getImageTitle$p(this.this$0);
            if (r91 == null) goto L216;
            r91.setText(this.this$0.getString(R.string.intelligent_sound_panel_prompt_loading_title));
            r91.setTextColor(r91.getResources().getColor(R.color.oui_text_1));
            goto L216
        L207:
            ImageView r92 = IntelligentSoundPanelActivity.access$getImageIcon$p(this.this$0);
            if (r92 == null) goto L211;
            r92.setImageResource(R.drawable.record_loading);
            Unit r93 = Unit.INSTANCE;
            goto L211
        }

        private static final void invoke$lambda$6$lambda$5(IntelligentSoundPanelActivity r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntelligentSoundPanelActivity.TAG, "updateCenterView 开始录制");
            IntelligentSoundPanelActivity.access$startRecord(r1);
        }

        private static final void invoke$lambda$8$lambda$7(IntelligentSoundPanelActivity r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntelligentSoundPanelActivity.TAG, "updateCenterView 停止录制");
            IntelligentSoundPanelActivity.access$stopRecord(r1);
        }

        private static final void invoke$lambda$15$lambda$14(IntelligentSoundPanelActivity r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntelligentSoundPanelActivity.TAG, "完成");
            r1.finish();
        }

        private static final void invoke$lambda$19$lambda$18(IntelligentSoundPanelActivity r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntelligentSoundPanelActivity.TAG, "重新录制");
            IntelligentSoundPanelActivity.access$startRecord(r1);
        }
    }

    /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/network/request/intelligentvoice/SoundFailResponseBody;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02191 extends Lambda implements Function1<SoundFailResponseBody, Unit> {
        final /* synthetic */ boolean $isRetry;
        final /* synthetic */ IntelligentSoundPanelActivity this$0;

        public static /* synthetic */ void $r8$lambda$nvNASopkP_Wu4S0kBRvhid_d90I(SoundFailResponseBody r0, boolean r1, IntelligentSoundPanelActivity r2) {
            invoke$lambda$1(r0, r1, r2);
        }

        C02191(IntelligentSoundPanelActivity r1, boolean r2) {
            this.this$0 = r1;
            this.$isRetry = r2;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SoundFailResponseBody r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final SoundFailResponseBody r3) {
            final IntelligentSoundPanelActivity r0 = this.this$0;
            final boolean r2 = this.$isRetry;
            r0.runOnUiThread(new IntelligentSoundPanelActivity$uploadFile$1$$ExternalSyntheticLambda0(r3, r2, r0));
        }

        private static final void invoke$lambda$1(SoundFailResponseBody r3, boolean r4, IntelligentSoundPanelActivity r5) {
            Intrinsics.checkNotNullParameter(r5, "this$0");
            StringBuilder r0 = new StringBuilder("uploadFile success fileUrl=");
            if (r3 == null) goto L5;
            String r2 = r3.getFileUrl();
        L6:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntelligentSoundPanelActivity.TAG, r0.append(r2).append(", isRetry=").append(r4).append(", status=").append(IntelligentSoundPanelActivity.access$getStatus$p(r5)).toString());
            if (r3 == null) goto L12;
            String r6 = r3.getFileUrl();
            if (r6 == null) goto L13;
            IntelligentSoundPanelActivity.showNameEditDialog$default(r5, r6, null, 2, null);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.Intelligentcall.activity.IntelligentSoundPanelActivity$uploadFile$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: IntelligentSoundPanelActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", NotificationCompat.CATEGORY_ERROR, "", "invoke", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C02202 extends Lambda implements Function3<Integer, String, Throwable, Unit> {
        final /* synthetic */ boolean $isRetry;
        final /* synthetic */ IntelligentSoundPanelActivity this$0;

        public static /* synthetic */ void $r8$lambda$a64EwHPV1t9vKx512WZ3XJTPyls(Integer r0, String r1, boolean r2, IntelligentSoundPanelActivity r3) {
            invoke$lambda$0(r0, r1, r2, r3);
        }

        C02202(IntelligentSoundPanelActivity r1, boolean r2) {
            this.this$0 = r1;
            this.$isRetry = r2;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer r1, String r2, Throwable r3) {
            invoke2(r1, r2, r3);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final Integer r2, final String r3, Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_ERROR);
            final IntelligentSoundPanelActivity r5 = this.this$0;
            final boolean r1 = this.$isRetry;
            r5.runOnUiThread(new IntelligentSoundPanelActivity$uploadFile$2$$ExternalSyntheticLambda0(r2, r3, r1, r5));
        }

        private static final void invoke$lambda$0(Integer r2, String r3, boolean r4, IntelligentSoundPanelActivity r5) {
            Intrinsics.checkNotNullParameter(r5, "this$0");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(IntelligentSoundPanelActivity.TAG, "uploadFile failed errCode=" + r2 + ", errMsg=" + r3 + ", isRetry=" + r4 + ", status=" + IntelligentSoundPanelActivity.access$getStatus$p(r5));
            if (r4 == true) goto L5;
            IntelligentSoundPanelActivity.updateCenterView$default(r5, CenterViewStatus.NETWORK_ERROR, 0, 2, null);
            return;
        L5:
            IntelligentSoundPanelActivity.updateCenterView$default(r5, CenterViewStatus.RECORD_ERROR, 0, 2, null);
        }
    }

    public static /* synthetic */ void $r8$lambda$7RmaaSzXFcyF1RXBxYr2ZLvvGSI(AbstractDialog r0, DialogInterface r1) {
        showExitDialog$lambda$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$BuGCXEfTca4Ed4gsCZlIQ_swWsQ(IntelligentSoundPanelActivity r0, View r1) {
        onRetryNetworkErrClickListener$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$DBuNfhMhUXPrXm7caqIN1hwP51Q(IntelligentSoundPanelActivity r0, View r1) {
        onRetryClickListener$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$FVKoypJKH49lsimq70uw-9JN5vs, reason: not valid java name */
    public static /* synthetic */ void m298$r8$lambda$FVKoypJKH49lsimq70uw9JN5vs(IntelligentSoundPanelActivity r0, View r1) {
        onCreate$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$F_P9TrGgZqsJPGXAvUIw_cedQCs(Ref.ObjectRef r0) {
        showNameEditDialog$lambda$9(r0);
    }

    public static /* synthetic */ void $r8$lambda$Yh_jep7pl5rjYUPkbdJ1Kj8lu_g(IntelligentSoundPanelActivity r0) {
        stopRecord$lambda$6(r0);
    }

    public static /* synthetic */ void $r8$lambda$hmgkMawWkgPXcRr67As1kEfFgio(IntelligentSoundPanelActivity r0) {
        startRecord$lambda$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$sWyHq7zOmhLIZrgEyArgS1E2ZcA(IntelligentSoundPanelActivity r0, String r1, String r2, AtomicBoolean r3, Ref.ObjectRef r4, DialogInterface r5) {
        showNameEditDialog$lambda$8(r0, r1, r2, r3, r4, r5);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public IntelligentSoundPanelActivity() {
        this.status = CenterViewStatus.PROMPT_LOADING;
        this.recordUtils = new AudioRecord();
        this.isRecording = new AtomicBoolean(false);
        this.filePath = "";
        this.onRetryNetworkErrClickListener = new IntelligentSoundPanelActivity$$ExternalSyntheticLambda4(this);
        this.onRetryClickListener = new IntelligentSoundPanelActivity$$ExternalSyntheticLambda5(this);
    }

    public static final /* synthetic */ void access$applyPromptText(IntelligentSoundPanelActivity r0, String r1, PromptSource r2) {
        r0.applyPromptText(r1, r2);
    }

    public static final /* synthetic */ void access$clearPromptText(IntelligentSoundPanelActivity r0) {
        r0.clearPromptText();
    }

    public static final /* synthetic */ void access$fallbackToLocalPrompt(IntelligentSoundPanelActivity r0, String r1) {
        r0.fallbackToLocalPrompt(r1);
    }

    public static final /* synthetic */ void access$finish$s1134055712(IntelligentSoundPanelActivity r0) {
        super.finish();
    }

    public static final /* synthetic */ LottieAnimationView access$getBottomLottieView$p(IntelligentSoundPanelActivity r0) {
        return r0.bottomLottieView;
    }

    public static final /* synthetic */ ImageView access$getImageIcon$p(IntelligentSoundPanelActivity r0) {
        return r0.imageIcon;
    }

    public static final /* synthetic */ OButton access$getImageRetryBtn$p(IntelligentSoundPanelActivity r0) {
        return r0.imageRetryBtn;
    }

    public static final /* synthetic */ TextView access$getImageSubtitle$p(IntelligentSoundPanelActivity r0) {
        return r0.imageSubtitle;
    }

    public static final /* synthetic */ TextView access$getImageTitle$p(IntelligentSoundPanelActivity r0) {
        return r0.imageTitle;
    }

    public static final /* synthetic */ View.OnClickListener access$getOnRetryClickListener$p(IntelligentSoundPanelActivity r0) {
        return r0.onRetryClickListener;
    }

    public static final /* synthetic */ View.OnClickListener access$getOnRetryNetworkErrClickListener$p(IntelligentSoundPanelActivity r0) {
        return r0.onRetryNetworkErrClickListener;
    }

    public static final /* synthetic */ boolean access$getRecordSuccess$p(IntelligentSoundPanelActivity r0) {
        return r0.recordSuccess;
    }

    public static final /* synthetic */ CenterViewStatus access$getStatus$p(IntelligentSoundPanelActivity r0) {
        return r0.status;
    }

    public static final /* synthetic */ void access$handleCreateSoundCopyFailure(IntelligentSoundPanelActivity r0, String r1, String r2, Integer r3) {
        r0.handleCreateSoundCopyFailure(r1, r2, r3);
    }

    public static final /* synthetic */ boolean access$isPromptReady$p(IntelligentSoundPanelActivity r0) {
        return r0.isPromptReady;
    }

    public static final /* synthetic */ AtomicBoolean access$isRecording$p(IntelligentSoundPanelActivity r0) {
        return r0.isRecording;
    }

    public static final /* synthetic */ void access$logStatusTransition(IntelligentSoundPanelActivity r0, CenterViewStatus r1, CenterViewStatus r2, String r3) {
        r0.logStatusTransition(r1, r2, r3);
    }

    public static final /* synthetic */ void access$releaseRecord(IntelligentSoundPanelActivity r0) {
        r0.releaseRecord();
    }

    public static final /* synthetic */ void access$setBottomLottieView$p(IntelligentSoundPanelActivity r0, LottieAnimationView r1) {
        r0.bottomLottieView = r1;
    }

    public static final /* synthetic */ void access$setDialogFinished$p(IntelligentSoundPanelActivity r0, boolean r1) {
        r0.isDialogFinished = r1;
    }

    public static final /* synthetic */ void access$setImageIcon$p(IntelligentSoundPanelActivity r0, ImageView r1) {
        r0.imageIcon = r1;
    }

    public static final /* synthetic */ void access$setImageRetryBtn$p(IntelligentSoundPanelActivity r0, OButton r1) {
        r0.imageRetryBtn = r1;
    }

    public static final /* synthetic */ void access$setImageSubtitle$p(IntelligentSoundPanelActivity r0, TextView r1) {
        r0.imageSubtitle = r1;
    }

    public static final /* synthetic */ void access$setImageTitle$p(IntelligentSoundPanelActivity r0, TextView r1) {
        r0.imageTitle = r1;
    }

    public static final /* synthetic */ void access$setRecordSuccess$p(IntelligentSoundPanelActivity r0, boolean r1) {
        r0.recordSuccess = r1;
    }

    public static final /* synthetic */ void access$setStatus$p(IntelligentSoundPanelActivity r0, CenterViewStatus r1) {
        r0.status = r1;
    }

    public static final /* synthetic */ void access$startRecord(IntelligentSoundPanelActivity r0) {
        r0.startRecord();
    }

    public static final /* synthetic */ void access$stopRecord(IntelligentSoundPanelActivity r0) {
        r0.stopRecord();
    }

    public static final /* synthetic */ void access$submitSoundCopyFromDialog(IntelligentSoundPanelActivity r0, String r1, String r2, String r3, boolean r4, AtomicBoolean r5, OSimpleFormDialog r6) {
        r0.submitSoundCopyFromDialog(r1, r2, r3, r4, r5, r6);
    }

    public static final /* synthetic */ void access$updatePromptTextViews(IntelligentSoundPanelActivity r0) {
        r0.updatePromptTextViews();
    }

    private final void logStatusTransition(CenterViewStatus r3, CenterViewStatus r4, String r5) {
        StringBuilder r6 = new StringBuilder("statusTransition scene=").append(r5).append(", from=").append(r3).append(", to=").append(r4).append(", isPromptReady=").append(this.isPromptReady).append(", promptSource=").append(this.promptSource).append(", filePathEmpty=");
        if (this.filePath.length() != 0) goto L5;
        boolean r7 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r6.append(r7).append(", recordSuccess=").append(this.recordSuccess).append(", isDialogFinished=").append(this.isDialogFinished).toString());
        return;
    L5:
        r7 = false;
        goto L6
    }

    private final void logExitState(String r3) {
        StringBuilder r4 = new StringBuilder("pageExit scene=").append(r3).append(", status=").append(this.status).append(", isPromptReady=").append(this.isPromptReady).append(", promptSource=").append(this.promptSource).append(", filePathEmpty=");
        if (this.filePath.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r4.append(r0).append(", recordSuccess=").append(this.recordSuccess).append(", isDialogFinished=").append(this.isDialogFinished).append(", isRecording=").append(this.recordUtils.isRecording()).toString());
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static final void onRetryNetworkErrClickListener$lambda$0(IntelligentSoundPanelActivity r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "重试");
        IntelligentSoundPanelActivity r0 = r1;
        if (IntelligentUtils.INSTANCE.isNetworkAvailable(r0) == false) goto L5;
        r1.retryCurrentStage();
        return;
    L5:
        Toast.makeText(r0, r1.getString(R.string.intelligent_sound_network_err), 0).show();
    }

    private static final void onRetryClickListener$lambda$1(IntelligentSoundPanelActivity r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "重试");
        IntelligentSoundPanelActivity r0 = r3;
        if (IntelligentUtils.INSTANCE.isNetworkAvailable(r0) == false) goto L5;
        r3.retryCurrentStage();
        return;
    L5:
        Toast.makeText(r0, r3.getString(R.string.intelligent_sound_network_err), 0).show();
        updateCenterView$default(r3, CenterViewStatus.NETWORK_ERROR, 0, 2, null);
    }

    public void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        IntelligentSoundPanelActivity r1 = this;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onCreate networkAvailable=" + IntelligentUtils.INSTANCE.isNetworkAvailable(r1));
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_intelligent_sound_panel_layout);
        this.intelligentSoundPanelLayout = (ViewGroup) findViewById(R.id.intelligent_sound_panel_layout);
        this.centerView = findViewById(R.id.header_container);
        this.recordPromptTextView = (TextView) findViewById(R.id.record_prompt_text);
        updateCenterView$default(this, CenterViewStatus.PROMPT_LOADING, 0, 2, null);
        IntelligentSoundPanelActivity r0 = this;
        UiUtils.setWindowColorStatusBar(r0);
        DialogUtils.clearDimBeforeDialogShow(r0);
        getWindow().setStatusBarColor(getColor(android.R.color.transparent));
        ViewAnimationUtils.INSTANCE.showPageAnimationWithBGAlpha(this.intelligentSoundPanelLayout, this.centerView, ContextCompat.getColor(getBaseContext(), R.color.oui_advanced_scrim_sheet));
        OCTitleBar r2 = (OCTitleBar) findViewById(R.id.title_bar);
        if (r2 == null) goto L6;
        OButton r4 = OCTitleBarExtKt.createNeutralButton(r2, r1);
        r4.setMIcon(getDrawable(R.drawable.icon_cancel_22_22));
        r4.setOnClickListener(new IntelligentSoundPanelActivity$$ExternalSyntheticLambda0(this));
        r2.addLeftView(r4);
    L6:
        if (IntelligentUtils.INSTANCE.isNetworkAvailable(r1) == true) goto L9;
        updateCenterView$default(this, CenterViewStatus.NETWORK_ERROR, 0, 2, null);
        return;
    L9:
        requestPromptAndEnterStart();
    }

    private static final void onCreate$lambda$3$lambda$2(IntelligentSoundPanelActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final void requestPromptAndEnterStart() {
        StringBuilder r0 = new StringBuilder("requestPromptAndEnterStart status=").append(this.status).append(", networkAvailable=").append(IntelligentUtils.INSTANCE.isNetworkAvailable(this)).append(", filePathEmpty=");
        if (this.filePath.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(r1).toString());
        updateCenterView$default(this, CenterViewStatus.PROMPT_LOADING, 0, 2, null);
        IntelligentVoiceHelper.INSTANCE.getSoundCopyText(new C02151(this), new AnonymousClass2(this), new AnonymousClass3(this));
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final void fallbackToLocalPrompt(String r4) {
        applyPromptText(getFallbackPromptText(), PromptSource.FALLBACK);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "fallbackToLocalPrompt reason=" + r4 + ", promptSource=" + this.promptSource);
        updateCenterView$default(this, CenterViewStatus.START, 0, 2, null);
    }

    private final void applyPromptText(String r2, PromptSource r3) {
        this.currentPromptText = r2;
        this.isPromptReady = true;
        this.promptSource = r3;
        updatePromptTextViews();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "applyPromptText source=" + r3 + ", length=" + r2.length());
    }

    private final void clearPromptText() {
        this.currentPromptText = null;
        this.isPromptReady = false;
        this.promptSource = null;
        updatePromptTextViews();
    }

    private final void updatePromptTextViews() {
        String r0 = this.currentPromptText;
        if (r0 != null) goto L5;
        r0 = getFallbackPromptText();
    L5:
        TextView r1 = this.recordPromptTextView;
        if (r1 == null) goto L10;
        r1.setText(r0);
        return;
    }

    private final String getFallbackPromptText() {
        String r1 = getString(R.string.intelligent_sound_panel_recording_value);
        Intrinsics.checkNotNullExpressionValue(r1, "getString(R.string.intel…nd_panel_recording_value)");
        return r1;
    }

    private final String ensurePromptTextForSubmit() {
        String r0 = this.currentPromptText;
        String r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "ensurePromptTextForSubmit missing prompt, fallback locally");
        String r3 = getFallbackPromptText();
        applyPromptText(r3, PromptSource.FALLBACK);
        return r3;
    L12:
        return r0;
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final void retryCurrentStage() {
        StringBuilder r0 = new StringBuilder("retryCurrentStage status=").append(this.status).append(", isPromptReady=").append(this.isPromptReady).append(", filePathEmpty=");
        boolean r2 = true;
        if (this.filePath.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(r1).toString());
        if (this.isPromptReady == true) goto L9;
    L14:
        requestPromptAndEnterStart();
        return;
    L9:
        if (this.filePath.length() > 0) goto L12;
        r2 = false;
    L12:
        if (r2 == false) goto L14;
        retryRecord();
        return;
    L5:
        r1 = false;
        goto L6
    }

    static /* synthetic */ void updateCenterView$default(IntelligentSoundPanelActivity r0, CenterViewStatus r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = CenterViewStatus.START;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = R.string.intelligent_sound_panel_record_err_subtitle;
    L8:
        r0.updateCenterView(r1, r2);
    }

    private final void updateCenterView(CenterViewStatus r2, int r3) {
        ToolsExtKt.runInUIThread(new C02181(this, r2, r3));
    }

    private final void startRecord() {
        if (this.isPromptReady == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "startRecord ignored because prompt is not ready");
        requestPromptAndEnterStart();
        return;
    L6:
        runOnUiThread(new IntelligentSoundPanelActivity$$ExternalSyntheticLambda7(this));
    }

    private static final void startRecord$lambda$4(IntelligentSoundPanelActivity r12) {
        Intrinsics.checkNotNullParameter(r12, "this$0");
        StringBuilder r0 = new StringBuilder("startRecord begin promptSource=").append(r12.promptSource).append(", promptLength=");
        String r1 = r12.currentPromptText;
        if (r1 == null) goto L5;
        int r2 = r1.length();
    L6:
        StringBuilder r3 = r0.append(r2).append(", previousFilePathEmpty=");
        if (r12.filePath.length() != 0) goto L9;
        boolean r4 = true;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r3.append(r4).toString());
        r12.isDialogFinished = true;
        updateCenterView$default(r12, CenterViewStatus.RECORDING, 0, 2, null);
        AudioRecord.deleteRecordingFile$default(r12.recordUtils, TAG, null, 2, null);
        r12.filePath = AudioRecord.startRecord$default(r12.recordUtils, null, TAG, new IntelligentSoundPanelActivity$startRecord$1$1(r12), new IntelligentSoundPanelActivity$startRecord$1$2(r12), 1, null);
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    private final void stopRecord() {
        runOnUiThread(new IntelligentSoundPanelActivity$$ExternalSyntheticLambda3(this));
        updateCenterView$default(this, CenterViewStatus.LOAD_RECORD, 0, 2, null);
        uploadFile$default(this, this.filePath, false, 2, null);
    }

    private static final void stopRecord$lambda$6(IntelligentSoundPanelActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "stopRecord stopRecording currentFilePath=" + r2.filePath + ", isRecording=" + r2.recordUtils.isRecording());
        LottieAnimationView r0 = r2.bottomLottieView;
        if (r0 == null) goto L5;
        r0.pauseAnimation();
        r0.setProgress(0.0f);
    L5:
        r2.recordUtils.stopRecord();
    }

    private final void retryRecord() {
        if (this.filePath.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "retryRecord ignored because filePath is empty");
        requestPromptAndEnterStart();
        return;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "retryRecord filePath=" + this.filePath);
        updateCenterView$default(this, CenterViewStatus.LOAD_RECORD, 0, 2, null);
        uploadFile(this.filePath, true);
        return;
    L5:
        r0 = false;
        goto L7
    }

    static /* synthetic */ void uploadFile$default(IntelligentSoundPanelActivity r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.uploadFile(r1, r2);
    }

    private final void uploadFile(String r4, boolean r5) {
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "uploadFile ignored because filePath is empty");
        updateCenterView$default(this, CenterViewStatus.RECORD_ERROR, 0, 2, null);
        return;
    L10:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "uploadFile start filePath=" + r4 + ", isRetry=" + r5 + ", promptSource=" + this.promptSource + ", isPromptReady=" + this.isPromptReady);
        IntelligentVoiceHelper.INSTANCE.uploadFile(r4, new C02191(this, r5), new C02202(this, r5));
        return;
    L5:
        r0 = false;
        goto L7
    }

    private final void showSoundCopyFailureToast(int r2) {
        Toast.makeText(this, getString(r2), 0).show();
    }

    private final void handleCreateSoundCopyFailure(String r3, String r4, Integer r5) {
        IntelligentVoiceHelper.SoundCopyFailureType r6 = IntelligentVoiceHelper.INSTANCE.getSoundCopyFailureType(r5);
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r7 != 1) goto L5;
        updateCenterView(CenterViewStatus.RECORD_ERROR, R.string.intelligent_sound_copy_voice_review_rejected_subtitle);
        return;
    L5:
        if (r7 != 2) goto L7;
        showSoundCopyFailureToast(R.string.intelligent_sound_copy_name_review_rejected_toast);
        showNameEditDialog$default(this, r3, null, 2, null);
        return;
    L7:
        if (r7 != 3) goto L9;
        updateCenterView$default(this, CenterViewStatus.RECORD_ERROR, 0, 2, null);
        return;
    L9:
        if (r7 != 4) goto L19;
        updateCenterView$default(this, CenterViewStatus.NETWORK_ERROR, 0, 2, null);
        return;
    }

    private final void submitSoundCopyFromDialog(String r8, String r9, String r10, boolean r11, AtomicBoolean r12, OSimpleFormDialog r13) {
        boolean r0 = false;
        if (r12.compareAndSet(false, true) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "nameEditDialog action ignored duplicate confirmed=" + r11);
        return;
    L6:
        StringBuilder r14 = new StringBuilder("nameEditDialog action confirmed=").append(r11).append(", finalName=").append(r9).append(", changed=").append(!Intrinsics.areEqual(r9, r10)).append(", hasFileUrl=");
        if (r8.length() <= 0) goto L9;
        r0 = true;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r14.append(r0).toString());
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L12
        IntelligentSoundPanelActivity r16 = this;     // Catch: Throwable -> L12
        r13.dismiss();     // Catch: Throwable -> L12
        Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        IntelligentVoiceHelper.INSTANCE.soundCopy(r8, r9, null, ensurePromptTextForSubmit(), new C02162(this), new C02173(this, r8, r9));
        return;
    L12:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    static /* synthetic */ void showNameEditDialog$default(IntelligentSoundPanelActivity r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.showNameEditDialog(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [T, com.obric.oui.dialog.v2.misc.OSimpleFormDialog] */
    private final void showNameEditDialog(final String r26, String r27) {
        IntelligentSoundPanelActivity r8 = this;
        int r0 = IntelligentUtils.INSTANCE.getCustomSoundList(r8).size();
        if (r0 != 0) goto L5;
        String r3 = "";
    L13:
        if (r27 != null) goto L15;
        final String r10 = getString(R.string.common_custom_tone) + r3;
    L16:
        StringBuilder r1 = new StringBuilder("showNameEditDialog customSize=").append(r0).append(", initialName=").append(r10).append(", hasInitialName=");
        String r4 = r27;
        if (r4 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        StringBuilder r2 = r1.append(!r5).append(", hasFileUrl=");
        if (r26.length() <= 0) goto L26;
        boolean r6 = true;
    L27:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r2.append(r6).toString());
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        final AtomicBoolean r12 = new AtomicBoolean(false);
        OSimpleFormDialog.InputViewConfig r15 = new OSimpleFormDialog.InputViewConfig(true, false, new IntelligentSoundPanelActivity$showNameEditDialog$input$1(r10, r7));
        String r9 = getString(R.string.intelligent_sound_edit_dialog_title);
        Intrinsics.checkNotNullExpressionValue(r9, "getString(R.string.intel…_sound_edit_dialog_title)");
        OSimpleFormDialog.InputViewConfig r13 = new OSimpleFormDialog.InputViewConfig(false, false, IntelligentSoundPanelActivity$showNameEditDialog$modifier$1.INSTANCE);
        String r14 = getString(R.string.common_done);
        Intrinsics.checkNotNullExpressionValue(r14, "getString(R.string.common_done)");
        final String r16 = r10;
        OBaseDialog.ButtonConfig r24 = new OBaseDialog.ButtonConfig(r14, new IntelligentSoundPanelActivity$showNameEditDialog$modifier$2(r7, r16, this, r26, r12, r11), null, 4, null);
        String r17 = getString(R.string.common_cancel);
        Intrinsics.checkNotNullExpressionValue(r17, "getString(R.string.common_cancel)");
        final String r18 = r10;
        r11.element = new OSimpleFormDialog(r8, new OSimpleFormDialog.Modifier(r9, "", r15, r13, r24, new OBaseDialog.ButtonConfig(r17, new IntelligentSoundPanelActivity$showNameEditDialog$modifier$3(this, r26, r18, r12, r11), null, 4, null)));
        OSimpleFormDialog r19 = null;
        if (r11.element != 0) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        OSimpleFormDialog r20 = null;
    L31:
        r20.setCancelable(true);
        if (r11.element != 0) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
    L35:
        final String r21 = r10;
        r19.setOnCancelListener(new IntelligentSoundPanelActivity$$ExternalSyntheticLambda1(this, r26, r21, r12, r11));
        runOnUiThread(new IntelligentSoundPanelActivity$$ExternalSyntheticLambda2(r11));
        return;
    L34:
        r19 = (OSimpleFormDialog) r11.element;
        goto L35
    L30:
        r20 = (OSimpleFormDialog) r11.element;
        goto L31
    L26:
        r6 = false;
        goto L27
    L19:
        if (StringsKt.isBlank(r4) == true) goto L22;
        r5 = false;
        goto L23
    L15:
        r10 = r27;
        goto L16
    L5:
        if (1 <= r0) goto L7;
    L9:
        boolean r22 = false;
    L10:
        if (r22 == false) goto L12;
        r3 = "0" + r0;
        goto L13
    L12:
        r3 = String.valueOf(r0);
        goto L13
    L7:
        if (r0 >= 10) goto L9;
        r22 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void showNameEditDialog$lambda$8(IntelligentSoundPanelActivity r7, String r8, String r9, AtomicBoolean r10, Ref.ObjectRef r11, DialogInterface r12) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        Intrinsics.checkNotNullParameter(r8, "$fileUrl");
        Intrinsics.checkNotNullParameter(r9, "$before");
        Intrinsics.checkNotNullParameter(r10, "$hasSubmitted");
        Intrinsics.checkNotNullParameter(r11, "$dialog");
        if (r11.element != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        OSimpleFormDialog r13 = null;
    L6:
        r7.submitSoundCopyFromDialog(r8, r9, r9, false, r10, r13);
        return;
    L5:
        r13 = (OSimpleFormDialog) r11.element;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void showNameEditDialog$lambda$9(Ref.ObjectRef r1) {
        Intrinsics.checkNotNullParameter(r1, "$dialog");
        if (r1.element != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        OSimpleFormDialog r2 = null;
    L6:
        r2.show();
        return;
    L5:
        r2 = (OSimpleFormDialog) r1.element;
        goto L6
    }

    public void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity__onPause$___twin___() {
        super.onPause();
        logExitState("onPause_beforeFinish");
        this.isDialogFinished = false;
        finish();
    }

    public void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity__finish$___twin___() {
        logExitState("finish_called");
        if (this.isDialogFinished == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "finish intercepted by showExitDialog");
        showExitDialog();
        return;
    L5:
        ViewAnimationUtils.INSTANCE.hidePageAnimationWithBGAlpha(this.intelligentSoundPanelLayout, this.centerView, ContextCompat.getColor(getBaseContext(), R.color.oui_advanced_scrim_sheet), new AnonymousClass1(this));
    }

    private final void releaseRecord() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "releaseRecord stopRecording filePath=" + this.filePath + ", isRecording=" + this.recordUtils.isRecording());
        if (this.recordUtils.isRecording() == false) goto L5;
        this.recordUtils.stopRecord();
    L5:
        AudioRecord.deleteRecordingFile$default(this.recordUtils, TAG, null, 2, null);
        this.filePath = "";
    }

    private final void showExitDialog() {
        StringBuilder r0 = new StringBuilder("showExitDialog status=").append(this.status).append(", filePathEmpty=");
        if (this.filePath.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(r1).toString());
        final OAlertDialog r4 = new OAlertDialogBuilder(this).title(getString(R.string.intelligent_sound_panel_dialog_title), true).horizontalButton(true).negativeButton(android.R.string.cancel, IntelligentSoundPanelActivity$showExitDialog$dialog$1.INSTANCE).positiveButton(R.string.common_leave, new IntelligentSoundPanelActivity$showExitDialog$dialog$2(this)).build();
        r4.setCancelable(true);
        r4.setCanceledOnTouchOutside(true);
        r4.setOnCancelListener(new IntelligentSoundPanelActivity$$ExternalSyntheticLambda6(r4));
        r4.show();
        return;
    L5:
        r1 = false;
        goto L6
    }

    private static final void showExitDialog$lambda$10(AbstractDialog r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "$dialog");
        r0.dismiss();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_obric_privacyhook_PrivacyHook_onCreate(IntelligentSoundPanelActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSoundPanelActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(IntelligentSoundPanelActivity r1) {
        com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_obric_privacyhook_PrivacyHook_onPause(IntelligentSoundPanelActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSoundPanelActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_obric_privacyhook_PrivacyHook_onStop(IntelligentSoundPanelActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSoundPanelActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity_com_obric_privacyhook_PrivacyHook_finish(IntelligentSoundPanelActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSoundPanelActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentSoundPanelActivity__finish$___twin___();
    }
}
