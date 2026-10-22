package com.obric.callsummary.model.aikernel;

import android.content.Context;
import android.content.Intent;
import com.GlobalProxyLancet;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.callsummary.CallSummaryGenerateManager;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.callsummary.bean.CallSummary;
import com.obric.callsummary.bean.CallSummaryResult;
import com.obric.components.ContactsTaskService;
import com.obric.contactprovider.ObricCallLogProviderHelper;
import com.obric.contactprovider.bean.CallSummaryASRMessageBean;
import com.obric.database.DatabaseHelper;
import com.obric.database.entity.CallSummaryComposeBetaEntity;
import com.obric.database.helper.CallSummaryCompressDBHelper;
import com.obric.init.ObricInitHelper;
import com.obric.model.CallFeatureModel;
import com.obric.settings.SettingsProviderHelper;
import com.obric.utils.GlobalUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: AISummary.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u00012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0011\u0010\u001e\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eH\u0007J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0004H\u0002J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020\u0017JF\u0010,\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u00101\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lcom/obric/callsummary/model/aikernel/AISummary;", "", "()V", "DOWNLOAD_STATUS_COMPLETED", "", "getDOWNLOAD_STATUS_COMPLETED", "()I", "DOWNLOAD_STATUS_DOWNLOADED", "getDOWNLOAD_STATUS_DOWNLOADED", "DOWNLOAD_STATUS_DOWNLOADING", "getDOWNLOAD_STATUS_DOWNLOADING", "DOWNLOAD_STATUS_ERROR", "getDOWNLOAD_STATUS_ERROR", "TAG", "", "downloadStatusListeners", "", "Lcom/obric/callsummary/model/aikernel/AISummary$DownloadStatusListener;", "modelDownloadCheckCompleted", "", "modelDownloadCheckJob", "Lkotlinx/coroutines/Job;", "callSummaryComposeByPart", "", "context", "Landroid/content/Context;", "isFinished", "callCreateTime", "", "phoneNumber", "getModelDownloadStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSummaryResult", "isLocalModel", "isLocalSuccess", "data", "Lcom/obric/callsummary/bean/CallSummary;", "isModelDownloadCompleted", "isOnlineModel", "notifyDownloadStatus", "downloadStatus", "registerDownloadStatusListener", "listener", "startModelDownloadCheck", "summaryUpdateOrInsert", "id", "start", TraceStatsConsts.STATS_KEY_END, "isUpdate", "unregisterDownloadStatusListener", "DownloadStatusListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AISummary {
    private static final int DOWNLOAD_STATUS_COMPLETED = 0;
    private static final int DOWNLOAD_STATUS_DOWNLOADED = 0;
    private static final int DOWNLOAD_STATUS_DOWNLOADING = 0;
    private static final int DOWNLOAD_STATUS_ERROR = 0;
    public static final AISummary INSTANCE = null;
    private static final String TAG = "AISummary";
    private static final Set<DownloadStatusListener> downloadStatusListeners = null;
    private static boolean modelDownloadCheckCompleted;
    private static Job modelDownloadCheckJob;

    /* JADX INFO: compiled from: AISummary.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/callsummary/model/aikernel/AISummary$DownloadStatusListener;", "", "onDownloadStatus", "", "downloadStatus", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface DownloadStatusListener {
        void onDownloadStatus(int r1);
    }

    /* JADX INFO: renamed from: com.obric.callsummary.model.aikernel.AISummary$getModelDownloadStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: AISummary.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.model.aikernel.AISummary", f = "AISummary.kt", i = {0, 0}, l = {128}, m = "getModelDownloadStatus", n = {"errorOccurred", "downloadCompleted"}, s = {"I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AISummary this$0;

        AnonymousClass1(AISummary r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return AISummary.access$getModelDownloadStatus(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.callsummary.model.aikernel.AISummary$isModelDownloadCompleted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AISummary.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.model.aikernel.AISummary$isModelDownloadCompleted$1", f = "AISummary.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    static final class C02411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C02411(Continuation<? super C02411> r2) {
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02411(r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return ((C02411) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            if (((Number) r4).intValue() == AISummary.INSTANCE.getDOWNLOAD_STATUS_COMPLETED()) goto L16;
            r2 = false;
        L16:
            return Boxing.boxBoolean(r2);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            r4 = AISummary.access$getModelDownloadStatus(AISummary.INSTANCE, this);
            if (r4 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.callsummary.model.aikernel.AISummary$startModelDownloadCheck$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AISummary.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.callsummary.model.aikernel.AISummary$startModelDownloadCheck$1", f = "AISummary.kt", i = {}, l = {78, 88}, m = "invokeSuspend", n = {}, s = {})
    static final class C02421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02421(Continuation<? super C02421> r2) {
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02421(r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C02421) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0064 -> B:11:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L14:
            int r8 = ((Number) r7).intValue();
            AISummary.access$notifyDownloadStatus(AISummary.INSTANCE, r8);
            if (r8 != AISummary.INSTANCE.getDOWNLOAD_STATUS_DOWNLOADING()) goto L17;
        L24:
            this.label = 2;
            if (DelayKt.delay(1000, this) == r0) goto L26;
        L11:
            this.label = 1;
            r7 = AISummary.access$getModelDownloadStatus(AISummary.INSTANCE, this);
            if (r7 != r0) goto L14;
            return r0;
        L26:
            return r0;
        L17:
            if (r8 != AISummary.INSTANCE.getDOWNLOAD_STATUS_COMPLETED()) goto L20;
            AISummary r6 = AISummary.INSTANCE;
            AISummary.access$setModelDownloadCheckCompleted$p(true);
        L23:
            return Unit.INSTANCE;
        L20:
            if (r8 == AISummary.INSTANCE.getDOWNLOAD_STATUS_ERROR()) goto L23;
        L10:
            ResultKt.throwOnFailure(r7);
            goto L11
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$TI1p7DFUjNV-oyhKN8IqjhV1F3w, reason: not valid java name */
    public static /* synthetic */ void m334$r8$lambda$TI1p7DFUjNVoyhKN8IqjhV1F3w(String r0, long r1, Context r3, boolean r4) {
        callSummaryComposeByPart$lambda$3(r0, r1, r3, r4);
    }

    private AISummary() {
    }

    public static final /* synthetic */ Object access$getModelDownloadStatus(AISummary r0, Continuation r1) {
        return r0.getModelDownloadStatus(r1);
    }

    public static final /* synthetic */ void access$notifyDownloadStatus(AISummary r0, int r1) {
        r0.notifyDownloadStatus(r1);
    }

    public static final /* synthetic */ void access$setModelDownloadCheckCompleted$p(boolean r0) {
        modelDownloadCheckCompleted = r0;
    }

    public final int getDOWNLOAD_STATUS_DOWNLOADING() {
        return DOWNLOAD_STATUS_DOWNLOADING;
    }

    static {
        INSTANCE = new AISummary();
        DOWNLOAD_STATUS_COMPLETED = 1;
        DOWNLOAD_STATUS_ERROR = 2;
        DOWNLOAD_STATUS_DOWNLOADED = 3;
        downloadStatusListeners = new LinkedHashSet();
    }

    public final int getDOWNLOAD_STATUS_COMPLETED() {
        return DOWNLOAD_STATUS_COMPLETED;
    }

    public final int getDOWNLOAD_STATUS_ERROR() {
        return DOWNLOAD_STATUS_ERROR;
    }

    public final int getDOWNLOAD_STATUS_DOWNLOADED() {
        return DOWNLOAD_STATUS_DOWNLOADED;
    }

    public final boolean isModelDownloadCompleted(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (modelDownloadCheckCompleted == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "modelDownloadCheckCompleted");
        return true;
    L6:
        ObricInitHelper.INSTANCE.waitForInitDone();
        return ((Boolean) BuildersKt.runBlocking$default(null, new C02411(null), 1, null)).booleanValue();
    }

    public final void startModelDownloadCheck() {
        if (modelDownloadCheckCompleted == false) goto L7;
        notifyDownloadStatus(DOWNLOAD_STATUS_DOWNLOADED);
        return;
    L7:
        if (modelDownloadCheckJob != null) goto L10;
        modelDownloadCheckJob = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C02421(null), 3, null);
        return;
    }

    public final boolean isLocalModel(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (SettingsProviderHelper.INSTANCE.getSummaryModelType(r1) != CallSummaryGenerateManager.MODEL.AI_KERNEL_LOCAL.getTypeValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOnlineModel(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (SettingsProviderHelper.INSTANCE.getSummaryModelType(r1) != CallSummaryGenerateManager.MODEL.AI_KERNEL_ONLINE.getTypeValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void registerDownloadStatusListener(DownloadStatusListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        downloadStatusListeners.add(r1);
    }

    public final void unregisterDownloadStatusListener(DownloadStatusListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        downloadStatusListeners.remove(r1);
    }

    private final void notifyDownloadStatus(int r2) {
        Iterator<DownloadStatusListener> r1 = downloadStatusListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onDownloadStatus(r2);
        goto L4
    }

    private final Object getModelDownloadStatus(Continuation<? super Integer> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r4 = r0;
        Object r9 = r4.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r4.label;
        boolean r7 = false;
        int r8 = 1;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        int r12 = r4.I$1;
        int r2 = r4.I$0;
        ResultKt.throwOnFailure(r9);
        Object r13 = ((Result) r9).m812unboximpl();
    L19:
        if (Result.m809isFailureimpl(r13) == false) goto L25;
        StringBuilder r3 = new StringBuilder("getModelDownloadStatus ret.isFailure ");
        if (Result.m809isFailureimpl(r13) == false) goto L23;
        r13 = null;
    L23:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r3.append(r13).toString());
    L48:
        if (r8 != 0) goto L50;
        if (r12 == 0) goto L53;
        int r14 = DOWNLOAD_STATUS_COMPLETED;
    L55:
        return Boxing.boxInt(r14);
    L53:
        r14 = DOWNLOAD_STATUS_DOWNLOADING;
        goto L55
    L50:
        return Boxing.boxInt(DOWNLOAD_STATUS_ERROR);
    L25:
        if (Result.m809isFailureimpl(r13) == false) goto L27;
        r13 = null;
    L27:
        PackageResource r15 = (PackageResource) r13;
        if (r15 != null) goto L30;
    L32:
        boolean r5 = false;
    L33:
        if (r5 == true) goto L35;
        if (r15 != null) goto L41;
    L43:
        if (r7 == true) goto L46;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getModelDownloadStatus 不支持的算法包");
        goto L48
    L46:
        if (r15.isDownloaded() == false) goto L47;
    L38:
        r8 = r2;
        goto L48
    L47:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getModelDownloadStatus 算法包资源待下载");
        goto L48
    L41:
        if (r15.isProvisioned() != true) goto L43;
        r7 = true;
        goto L43
    L35:
        if (r15.isDownloaded() == true) goto L37;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getModelDownloadStatus 有新版本可以更新");
    L37:
        r12 = 1;
        goto L38
    L30:
        if (r15.isAvailable() != true) goto L32;
        r5 = true;
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        IAIKernelManager r6 = AIKernelManager.INSTANCE.invoke();
        r4.I$0 = 0;
        r4.I$1 = 0;
        r4.label = 1;
        r13 = IAIKernelManager.DefaultImpls.m313getPackage0E7RQCE$default(r6, ABSAIKernelCallSummaryModel.MODEL_NAME_LOCAL, null, r4, 2, null);
        if (r13 != r11) goto L17;
        return r11;
    L17:
        r12 = 0;
        r2 = 0;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    public final synchronized void callSummaryComposeByPart(final Context r9, final boolean r10, final long r11, final String r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "context");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r13, "phoneNumber");     // Catch: Throwable -> L11
        if (isLocalModel(r9) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "compose start date=" + r11 + " isFinished=" + r10);     // Catch: Throwable -> L11
        GlobalUtils.INSTANCE.execute(new AISummary$$ExternalSyntheticLambda0(r13, r11, r9, r10));     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static final void callSummaryComposeByPart$lambda$3(String r19, long r20, Context r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r19, "$phoneNumber");
        Intrinsics.checkNotNullParameter(r22, "$context");
        String r0 = "phone_number = " + r19 + " AND call_create_time = " + r20 + " AND compress_result = " + CallSummaryComposeBetaEntity.CompressResult.FAILURE.ordinal();
        CallSummaryCompressDBHelper r1 = DatabaseHelper.INSTANCE.getCallSummaryCompressDBHelper();
        Integer r15 = null;
        if (r1 == null) goto L5;
        List<CallSummaryComposeBetaEntity> r2 = r1.getData(r0);
    L6:
        boolean r16 = false;
        if (r2 == null) goto L23;
        Iterator<T> r3 = r2.iterator();
        if (r3.hasNext() == true) goto L11;
        Object r4 = null;
    L20:
        CallSummaryComposeBetaEntity r5 = (CallSummaryComposeBetaEntity) r4;
        if (r5 == null) goto L23;
        int r17 = r5.getCompressEndId();
    L24:
        if (r2 == null) goto L29;
        Iterator<T> r18 = r2.iterator();
    L27:
        if (r18.hasNext() == false) goto L29;
        CallSummaryComposeBetaEntity r6 = (CallSummaryComposeBetaEntity) r18.next();
        INSTANCE.summaryUpdateOrInsert(r22, r6.getId(), r6.getCallCreateTime(), r6.getPhoneNumber(), r6.getCompressStartId(), r6.getCompressEndId(), true, false);
    L29:
        INSTANCE.summaryUpdateOrInsert(r22, -1, r20, r19, r17, Integer.MAX_VALUE, false, r23);
        if (r23 == false) goto L58;
        String r7 = getSummaryResult(r22, r20, r19);
        String r8 = r7;
        if (r8 != null) goto L34;
    L35:
        r16 = true;
    L37:
        if (r16 == true) goto L53;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "compose resultReady date=" + r20 + " resultLen=" + r7.length());
        CallSummaryResult r9 = CallSummaryGenerateManager.INSTANCE.generateAndSaveCallSummaryLocalModel(r22, r20, r19, r7, false);
        if (r9 != null) goto L41;
    L42:
        StringBuilder r10 = new StringBuilder("compose finalGenerateFail date=").append(r20).append(" resultError=");
        if (r9 == null) goto L45;
        Integer r11 = Integer.valueOf(r9.getErrorCode());
    L46:
        StringBuilder r12 = r10.append(r11).append(" summaryError=");
        if (r9 == null) goto L51;
        CallSummary r13 = r9.getData();
        if (r13 == null) goto L51;
        r15 = Integer.valueOf(r13.getErrorCode());
    L51:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, r12.append(r15).toString());
    L52:
        CallFeatureModel.INSTANCE.callSummaryFinished(new Pair(Long.valueOf(r20), r19), r9);
        return;
    L45:
        r11 = null;
        goto L46
    L41:
        if (r9.getErrorCode() == 0) goto L52;
    L53:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "compose fallbackService date=" + r20);
        Intent r14 = new Intent();
        r14.setAction(ContactsTaskService.ACTION_START_CALL_SUMMARY_TASK);
        r14.putExtra("call_create_time", r20);
        r14.putExtra("phone_number", r19);
        r14.setClass(r22, ContactsTaskService.class);
        r22.startService(r14);
        return;
    L34:
        if (r8.length() != 0) goto L37;
    L58:
        return;
    L11:
        r4 = r3.next();
        if (r3.hasNext() == false) goto L20;
        int r21 = ((CallSummaryComposeBetaEntity) r4).getCompressEndId();
    L15:
        Object r24 = r3.next();
        int r25 = ((CallSummaryComposeBetaEntity) r24).getCompressEndId();
        if (r21 >= r25) goto L19;
        r4 = r24;
        r21 = r25;
    L19:
        if (r3.hasNext() == true) goto L15;
    L23:
        r17 = 0;
        goto L24
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final String getSummaryResult(Context r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "phoneNumber");
        if (INSTANCE.isLocalModel(r3) == true) goto L5;
        return null;
    L5:
        String r5 = "phone_number = " + r6 + " AND call_create_time = " + r4;
        CallSummaryCompressDBHelper r7 = DatabaseHelper.INSTANCE.getCallSummaryCompressDBHelper();
        if (r7 == null) goto L8;
        List<CallSummaryComposeBetaEntity> r8 = r7.getData(r5);
    L9:
        boolean r9 = false;
        if (r8 == null) goto L24;
        List<CallSummaryComposeBetaEntity> r10 = r8;
        if ((r10 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r11 = r10.iterator();
    L18:
        if (r11.hasNext() == false) goto L15;
        if (((CallSummaryComposeBetaEntity) r11.next()).getCompressResult() != CallSummaryComposeBetaEntity.CompressResult.SUCCESS.ordinal()) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == true) goto L18;
    L22:
        r12 = false;
    L15:
        r9 = true;
        goto L24
    L14:
        if (r10.isEmpty() == false) goto L16;
    L24:
        if (r9 == false) goto L39;
        String r13 = "";
        if (r8 == null) goto L32;
        Iterator<T> r14 = r8.iterator();
    L29:
        if (r14.hasNext() == false) goto L32;
        r13 = r13 + ((CallSummaryComposeBetaEntity) r14.next()).getCompressContext();
    L32:
        return r13;
    L39:
        return null;
    L8:
        r8 = null;
        goto L9
    }

    public final void summaryUpdateOrInsert(Context r16, long r17, long r19, String r21, int r22, int r23, boolean r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r21, "phoneNumber");
        Pair<List<CallSummaryASRMessageBean>, Integer> r1 = ObricCallLogProviderHelper.INSTANCE.getCallSummaryASRMessageBeanFromStartToEnd(r16, r19, r21, r22, r23);
        List<CallSummaryASRMessageBean> r2 = r1.component1();
        int r3 = r1.component2().intValue();
        if (r25 == false) goto L5;
        ABSAIKernelCallSummaryModel.PowerMode r4 = ABSAIKernelCallSummaryModel.PowerMode.BALANCED;
    L6:
        CallSummaryResult r5 = CallSummaryGenerateManager.INSTANCE.generateCallSimplify(r16, r2, r4);
        if (isLocalSuccess(r16, r5.getData()) == true) goto L9;
        int r6 = CallSummaryComposeBetaEntity.CompressResult.SUCCESS.ordinal();
    L10:
        int r7 = r6;
        if (isLocalSuccess(r16, r5.getData()) == false) goto L16;
        String r0 = r5.getData().getSummary();
        Iterator<T> r8 = r5.getData().getItems().iterator();
    L14:
        if (r8.hasNext() == false) goto L17;
        r0 = r0 + ((String) r8.next());
    L17:
        String r9 = r0;
        if (r24 == false) goto L22;
        CallSummaryCompressDBHelper r10 = DatabaseHelper.INSTANCE.getCallSummaryCompressDBHelper();
        if (r10 == null) goto L27;
        r10.updateData(r17, new CallSummaryComposeBetaEntity(r21, r19, r7, r9, r22, r3, 0, 64, null).toContentValues());
        return;
    L27:
        return;
    L22:
        CallSummaryCompressDBHelper r11 = DatabaseHelper.INSTANCE.getCallSummaryCompressDBHelper();
        if (r11 == null) goto L29;
        r11.insertData(new CallSummaryComposeBetaEntity(r21, r19, r7, r9, r22, r3, 0, 64, null).toContentValues());
        return;
    L29:
        return;
    L16:
        r0 = "";
        goto L17
    L9:
        r6 = CallSummaryComposeBetaEntity.CompressResult.FAILURE.ordinal();
        goto L10
    L5:
        r4 = ABSAIKernelCallSummaryModel.PowerMode.POWER_SAVER;
        goto L6
    }

    public final boolean isLocalSuccess(Context r2, CallSummary r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isEmpty() == false) goto L8;
        return false;
    L8:
        if (r3.isUnableToSummarize(r2) == true) goto L12;
        return true;
    L12:
        return false;
    }
}
