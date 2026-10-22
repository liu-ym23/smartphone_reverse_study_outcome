package com.android.ttcjpaysdk.thirdparty.voiceprint;

import android.content.Context;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayNetWorkCallback;
import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.ResponseBean;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.ResponseCode;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintConfig;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintOperation;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintResult;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import com.android.ttcjpaysdk.thirdparty.voiceprint.interfaces.VoicePrintCallbackDispatcher;
import com.android.ttcjpaysdk.thirdparty.voiceprint.record.AudioHelper;
import com.android.ttcjpaysdk.thirdparty.voiceprint.record.VoiceSealedAudio;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 a2\u00020\u0001:\u0001aB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010+\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\b/J\b\u00100\u001a\u00020*H\u0002J\b\u00101\u001a\u00020*H\u0016J\b\u00102\u001a\u00020*H\u0002J\u0015\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u000eH\u0000¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0000¢\u0006\u0002\b9J<\u0010:\u001a\u0004\u0018\u00010\f\"\u0004\b\u0000\u0010;2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020.2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H;0@H\u0082@¢\u0006\u0002\u0010AJ\u001c\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010.2\b\u0010D\u001a\u0004\u0018\u00010.H\u0002J\u0012\u0010E\u001a\u00020*2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\u0012\u0010H\u001a\u00020*2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\r\u0010I\u001a\u00020*H\u0000¢\u0006\u0002\bJJ\b\u0010K\u001a\u00020\u0010H\u0002J\u0015\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020.H\u0000¢\u0006\u0002\bNJ\u0018\u0010O\u001a\u0004\u0018\u00010\f2\u0006\u0010=\u001a\u00020.H\u0082@¢\u0006\u0002\u0010PJ\u0018\u0010Q\u001a\u0004\u0018\u00010\f2\u0006\u0010=\u001a\u00020.H\u0082@¢\u0006\u0002\u0010PJ\u0017\u0010R\u001a\u00020*2\b\u0010S\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\bTJ#\u0010U\u001a\u00020*2\u0014\u0010V\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(H\u0000¢\u0006\u0002\bWJ\u0015\u0010X\u001a\u00020*2\u0006\u0010Y\u001a\u00020ZH\u0000¢\u0006\u0002\b[J!\u0010\\\u001a\u00020*2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020*0(H\u0000¢\u0006\u0002\b^J\u000e\u0010_\u001a\u00020.H\u0082@¢\u0006\u0002\u0010`R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/VoicePrintSession;", "Ljava/lang/AutoCloseable;", "config", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintConfig;", "(Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintConfig;)V", "audioHelper", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/AudioHelper;", "callbackDispatcher", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/interfaces/VoicePrintCallbackDispatcher;", "coroutineJob", "Lkotlinx/coroutines/CompletableJob;", "currentRequest", "Lcom/android/ttcjpaysdk/base/network/ICJPayRequest;", "initError", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintResult;", "isActuallyDenoised", "", "isActuallyDenoised$bdpay_voiceprint_release", "()Ljava/lang/Boolean;", "setActuallyDenoised$bdpay_voiceprint_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isRecording", "lastRecordDurationMs", "", "getLastRecordDurationMs$bdpay_voiceprint_release", "()Ljava/lang/Long;", "setLastRecordDurationMs$bdpay_voiceprint_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", WikiFolderPushPlugin.OPT, "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintOperation;", "pendingSealedAudio", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/record/VoiceSealedAudio;", "recordStartAt", "recordTimeoutJob", "Lkotlinx/coroutines/Job;", "volumeListener", "Lkotlin/Function1;", "", "", "cancelRecording", "isTimeout", "cancelReason", "", "cancelRecording$bdpay_voiceprint_release", "clearPendingSealedAudioSecurely", "close", "deleteRecordingFilesAsync", "dispatchResult", "result", "dispatchResult$bdpay_voiceprint_release", "dispatchState", "state", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintState;", "dispatchState$bdpay_voiceprint_release", "doVoiceVerify", ExifInterface.GPS_DIRECTION_TRUE, "cfg", "voicePath", e.f25671s, "callback", "Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;", "(Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintConfig;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/network/ICJPayNetWorkCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNetworkFailure", "errorCode", "errorMessage", "handleOpenResponse", "response", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/ResponseBean;", "handleVerifyResponse", "initIfNeeded", "initIfNeeded$bdpay_voiceprint_release", "isInitialized", "recognizeVoicePrint", "path", "recognizeVoicePrint$bdpay_voiceprint_release", "requestOpenOrUpdate", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestVerify", "setCallbackDispatcher", "dispatcher", "setCallbackDispatcher$bdpay_voiceprint_release", "setOnVolumeChangeListener", "listener", "setOnVolumeChangeListener$bdpay_voiceprint_release", "startRecording", "appContext", "Landroid/content/Context;", "startRecording$bdpay_voiceprint_release", "stopRecordingAsync", "onFinished", "stopRecordingAsync$bdpay_voiceprint_release", "stopRecordingInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintSession implements AutoCloseable {
    public static final Companion Companion = null;
    private static final String IN_MEMORY_AUDIO_PATH = "voice_print_in_memory://session";
    private static final long MAX_RECORD_DURATION_MS = 10000;
    private static final long MIN_RECORD_DURATION_MS = 1000;
    private static final String OPEN_VOICE_METHOD = "bytepay.member_verify.register_member_voice";
    private static final String TAG = "VoicePrintSession";
    private static final String VERIFY_VOICE_METHOD = "bytepay.member_verify.verify_member_voice";
    private AudioHelper audioHelper;
    private VoicePrintCallbackDispatcher callbackDispatcher;
    private final VoicePrintConfig config;
    private final CompletableJob coroutineJob;
    private ICJPayRequest currentRequest;
    private final VoicePrintResult initError;
    private Boolean isActuallyDenoised;
    private boolean isRecording;
    private Long lastRecordDurationMs;
    private final CoroutineScope mainScope;
    private final VoicePrintOperation operation;
    private VoiceSealedAudio pendingSealedAudio;
    private long recordStartAt;
    private Job recordTimeoutJob;
    private Function1<? super Float, Unit> volumeListener;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/VoicePrintSession$Companion;", "", "()V", "IN_MEMORY_AUDIO_PATH", "", "MAX_RECORD_DURATION_MS", "", "MIN_RECORD_DURATION_MS", "OPEN_VOICE_METHOD", "TAG", "VERIFY_VOICE_METHOD", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession$deleteRecordingFilesAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession$deleteRecordingFilesAsync$1", f = "VoicePrintSession.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_ABR_SWITCH_PENALTY_PARAMETER}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VoicePrintSession this$0;

        public AnonymousClass1(VoicePrintSession r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            AudioHelper r103 = VoicePrintSession.access$getAudioHelper$p(this.this$0);
            if (r103 == null) goto L14;
            this.label = 1;
            if (r103.deleteOutputFiles(this) != r101) goto L14;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession$doVoiceVerify$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession", f = "VoicePrintSession.kt", i = {0, 0, 0}, l = {345}, m = "doVoiceVerify", n = {"cfg", e.f25671s, "callback"}, s = {"L$0", "L$1", "L$2"})
    public static final class C97071<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ VoicePrintSession this$0;

        public C97071(VoicePrintSession r100, Continuation<? super C97071> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return VoicePrintSession.access$doVoiceVerify(this.this$0, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession$stopRecordingInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession", f = "VoicePrintSession.kt", i = {}, l = {188, 202, 215, 229}, m = "stopRecordingInternal", n = {}, s = {})
    public static final class C97091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ VoicePrintSession this$0;

        public C97091(VoicePrintSession r100, Continuation<? super C97091> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return VoicePrintSession.access$stopRecordingInternal(this.this$0, this);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void clearPendingSealedAudioSecurely() {
        VoiceSealedAudio r100 = this.pendingSealedAudio;
        if (r100 != null) goto L15;
        return;
    L15:
        r100.zeroize$bdpay_voiceprint_release();     // Catch: Throwable -> L8
    L7:
        this.pendingSealedAudio = null;
        return;
    L8:
        th = move-exception;
        CJLogger.c(TAG, "clearPendingSealedAudioSecurely fail", th);     // Catch: Throwable -> L12
        CJLogger.e(TAG, "clearPendingSealedAudioSecurely: zeroize failed, drop reference anyway");
    L12:
        th = move-exception;
        CJLogger.e(TAG, "clearPendingSealedAudioSecurely: zeroize failed, drop reference anyway");
        this.pendingSealedAudio = null;
        throw th;
    }

    private final boolean isInitialized() {
        if (this.initError == null) goto L5;
    L9:
        return false;
    L5:
        if (this.operation == null) goto L9;
        if (this.audioHelper == null) goto L9;
        return true;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        ICJPayRequest r100 = this.currentRequest;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.currentRequest = null;
        Job r101 = this.recordTimeoutJob;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.recordTimeoutJob = null;
        this.volumeListener = null;
        Job.DefaultImpls.cancel$default(this.coroutineJob, null, 1, null);
        VoicePrintCallbackDispatcher r102 = this.callbackDispatcher;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        this.callbackDispatcher = null;
        clearPendingSealedAudioSecurely();
        AudioHelper r103 = this.audioHelper;
        if (r103 == null) goto L14;
        r103.clear();
    L14:
        this.audioHelper = null;
    }

    public final void initIfNeeded$bdpay_voiceprint_release() {
        VoicePrintResult r100 = this.initError;
        if (r100 == null) goto L6;
        dispatchResult$bdpay_voiceprint_release(r100);
        return;
    L6:
        dispatchState$bdpay_voiceprint_release(VoicePrintState.INITIALIZED);
    }

    private final void deleteRecordingFilesAsync() {
        clearPendingSealedAudioSecurely();
        BuildersKt.launch$default(this.mainScope, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final Long getLastRecordDurationMs$bdpay_voiceprint_release() {
        return this.lastRecordDurationMs;
    }

    public final Boolean isActuallyDenoised$bdpay_voiceprint_release() {
        return this.isActuallyDenoised;
    }

    public VoicePrintSession(VoicePrintConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.config = r100;
        AudioHelper r101 = null;
        CompletableJob r102 = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.coroutineJob = r102;
        this.mainScope = CoroutineScopeKt.CoroutineScope(r102.plus(Dispatchers.getMain()));
        VoicePrintOperation r103 = VoicePrintOperation.Companion.fromValue(r100.getVerifyType());
        this.operation = r103;
        if (r103 != null) goto L6;
        VoicePrintResult r104 = VoicePrintResult.Companion.invalidParams$default(VoicePrintResult.Companion, "unsupported verify type", null, 2, null);
    L9:
        this.initError = r104;
        if (r104 != null) goto L12;
        r101 = new AudioHelper(r100.getUseDenoise());
        r101.setOnVolumeChanged(new VoicePrintSession$audioHelper$1$1(this));
    L12:
        this.audioHelper = r101;
        return;
    L6:
        if (r100.isInvalid() == false) goto L8;
        r104 = VoicePrintResult.Companion.invalidParams$default(VoicePrintResult.Companion, null, null, 3, null);
        goto L9
    L8:
        r104 = null;
        goto L9
    }

    public static final /* synthetic */ AudioHelper access$getAudioHelper$p(VoicePrintSession r100) {
        return r100.audioHelper;
    }

    public static final /* synthetic */ VoiceSealedAudio access$getPendingSealedAudio$p(VoicePrintSession r100) {
        return r100.pendingSealedAudio;
    }

    public static final /* synthetic */ Job access$getRecordTimeoutJob$p(VoicePrintSession r100) {
        return r100.recordTimeoutJob;
    }

    public static final /* synthetic */ Function1 access$getVolumeListener$p(VoicePrintSession r100) {
        return r100.volumeListener;
    }

    public static final /* synthetic */ boolean access$isRecording$p(VoicePrintSession r100) {
        return r100.isRecording;
    }

    private final void handleOpenResponse(ResponseBean r110) {
        if (r110 != null) goto L6;
        dispatchState$bdpay_voiceprint_release(VoicePrintState.VERIFY_FAILED);
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.VERIFY_FAILED_DISABLE_RETRY, "服务端返回为空", null, 4, null));
        deleteRecordingFilesAsync();
        return;
    L6:
        if (Intrinsics.areEqual(r110.code, ResponseCode.SUCCESS.getValue()) == false) goto L9;
        dispatchState$bdpay_voiceprint_release(VoicePrintState.VERIFY_SUCCESS);
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.success$default(VoicePrintResult.Companion, null, 1, null));
    L23:
        deleteRecordingFilesAsync();
        return;
    L9:
        if (Intrinsics.areEqual(r110.code, ResponseCode.CONTINUE_VERIFY.getValue()) == false) goto L12;
        VoicePrintState r100 = VoicePrintState.SUC_CONTINUE_VERIFY;
        r100.getExt().clear();
        r100.getExt().put(VoicePrintState.EXT_KEY_TIPS, r110.msg);
        r100.getExt().put(VoicePrintState.EXT_KEY_TEXT, r110.voice_text);
        dispatchState$bdpay_voiceprint_release(r100);
        goto L23
    L12:
        if (StringsKt.startsWith$default(r110.code, ResponseCode.RECOGNIZE_FAIL.getValue(), false, 2, null) == false) goto L18;
        VoicePrintState r101 = VoicePrintState.FAIL_CONTINUE_VERIFY;
        r101.getExt().clear();
        r101.getExt().put(VoicePrintState.EXT_KEY_TIPS, r110.msg);
        r101.getExt().put(VoicePrintState.EXT_KEY_TEXT, r110.voice_text);
        r101.getExt().put(VoicePrintState.EXT_KEY_RESPONSE_CODE, r110.code);
        dispatchState$bdpay_voiceprint_release(r101);
        VoicePrintResult.Companion r102 = VoicePrintResult.Companion;
        VoicePrintResult.DetailCode r103 = VoicePrintResult.DetailCode.VERIFY_FAILED_ENABLE_RETRY;
        String r111 = r110.msg;
        if (StringsKt.isBlank(r111) == false) goto L16;
        String r104 = "failed";
    L17:
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(r102, r103, r104, null, 4, null));
        goto L23
    L16:
        r104 = r111;
        goto L17
    L18:
        dispatchState$bdpay_voiceprint_release(VoicePrintState.VERIFY_FAILED);
        VoicePrintResult.Companion r105 = VoicePrintResult.Companion;
        VoicePrintResult.DetailCode r106 = VoicePrintResult.DetailCode.VERIFY_FAILED_DISABLE_RETRY;
        String r112 = r110.msg;
        if (StringsKt.isBlank(r112) == false) goto L21;
        String r107 = "failed";
    L22:
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(r105, r106, r107, null, 4, null));
        goto L23
    L21:
        r107 = r112;
        goto L22
    }

    private final void handleVerifyResponse(ResponseBean r110) {
        if (r110 != null) goto L6;
        dispatchState$bdpay_voiceprint_release(VoicePrintState.VERIFY_FAILED);
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.VERIFY_FAILED_DISABLE_RETRY, "服务端返回为空", null, 4, null));
        deleteRecordingFilesAsync();
        return;
    L6:
        if (Intrinsics.areEqual(r110.code, ResponseCode.SUCCESS.getValue()) == false) goto L9;
        dispatchState$bdpay_voiceprint_release(VoicePrintState.VERIFY_SUCCESS);
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.success$default(VoicePrintResult.Companion, null, 1, null));
    L23:
        deleteRecordingFilesAsync();
        return;
    L9:
        if (Intrinsics.areEqual(r110.code, ResponseCode.CONTINUE_VERIFY.getValue()) == false) goto L12;
        VoicePrintState r100 = VoicePrintState.SUC_CONTINUE_VERIFY;
        r100.getExt().clear();
        r100.getExt().put(VoicePrintState.EXT_KEY_TIPS, r110.msg);
        r100.getExt().put(VoicePrintState.EXT_KEY_TEXT, r110.voice_text);
        dispatchState$bdpay_voiceprint_release(r100);
        goto L23
    L12:
        if (StringsKt.startsWith$default(r110.code, ResponseCode.RECOGNIZE_FAIL.getValue(), false, 2, null) == false) goto L18;
        VoicePrintState r101 = VoicePrintState.FAIL_CONTINUE_VERIFY;
        r101.getExt().clear();
        r101.getExt().put(VoicePrintState.EXT_KEY_TIPS, r110.msg);
        r101.getExt().put(VoicePrintState.EXT_KEY_TEXT, r110.voice_text);
        r101.getExt().put(VoicePrintState.EXT_KEY_RESPONSE_CODE, r110.code);
        dispatchState$bdpay_voiceprint_release(r101);
        VoicePrintResult.Companion r102 = VoicePrintResult.Companion;
        VoicePrintResult.DetailCode r103 = VoicePrintResult.DetailCode.VERIFY_FAILED_ENABLE_RETRY;
        String r111 = r110.msg;
        if (StringsKt.isBlank(r111) == false) goto L16;
        String r104 = "failed";
    L17:
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(r102, r103, r104, null, 4, null));
        goto L23
    L16:
        r104 = r111;
        goto L17
    L18:
        dispatchState$bdpay_voiceprint_release(VoicePrintState.VERIFY_FAILED);
        VoicePrintResult.Companion r105 = VoicePrintResult.Companion;
        VoicePrintResult.DetailCode r106 = VoicePrintResult.DetailCode.VERIFY_FAILED_DISABLE_RETRY;
        String r112 = r110.msg;
        if (StringsKt.isBlank(r112) == false) goto L21;
        String r107 = "failed";
    L22:
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(r105, r106, r107, null, 4, null));
        goto L23
    L21:
        r107 = r112;
        goto L22
    }

    private final Object stopRecordingInternal(Continuation<? super String> r110) {
        if ((r110 instanceof C97091) == false) goto L7;
        C97091 r100 = (C97091) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L23;
        if (r103 == 1) goto L19;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        ResultKt.throwOnFailure(r111);
    L95:
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.UNKNOWN_ERROR, "音频路径为空", null, 4, null));
        return "";
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r111);
    L72:
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.UNKNOWN_ERROR, "音频为空", null, 4, null));
        return "";
    L18:
        ResultKt.throwOnFailure(r111);
    L44:
        VoicePrintState r112 = VoicePrintState.DURATION_TOO_SHORT;
        r112.getExt().clear();
        r112.getExt().put(VoicePrintState.EXT_KEY_TIPS, "录音时间过短，请重新朗读一次");
        dispatchState$bdpay_voiceprint_release(r112);
        return "";
    L19:
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L21
    L37:
        long r105 = SystemClock.elapsedRealtime() - this.recordStartAt;
        this.lastRecordDurationMs = Boxing.boxLong(r105);
        if (r105 >= 1000) goto L46;
        CJLogger.e(TAG, "stopRecordingInternal fail: duration too short: (" + r105 + " ms)");
        AudioHelper r113 = this.audioHelper;
        if (r113 == null) goto L44;
        r100.label = 2;
        if (r113.cancelRecordAudio(r100) != r102) goto L44;
        return r102;
    L46:
        AudioHelper r114 = this.audioHelper;
        if (r114 != null) goto L49;
    L51:
        r104 = false;
    L52:
        Boolean r115 = null;
        if (r104 == false) goto L74;
        AudioHelper r106 = this.audioHelper;
        if (r106 == null) goto L57;
        VoiceSealedAudio r107 = r106.getOutputBytes();
    L58:
        if (r107 != null) goto L60;
    L67:
        CJLogger.b(TAG, "stopRecordingInternal fail: in-memory audio empty");
        AudioHelper r116 = this.audioHelper;
        if (r116 == null) goto L72;
        r100.label = 3;
        if (r116.cancelRecordAudio(r100) != r102) goto L72;
        return r102;
    L60:
        if (r107.getBytes().length <= 44) goto L67;
        AudioHelper r108 = this.audioHelper;
        if (r108 == null) goto L65;
        r115 = Boxing.boxBoolean(r108.isActuallyDenoised());
    L65:
        this.isActuallyDenoised = r115;
        clearPendingSealedAudioSecurely();
        this.pendingSealedAudio = r107;
        return IN_MEMORY_AUDIO_PATH;
    L57:
        r107 = null;
        goto L58
    L74:
        AudioHelper r109 = this.audioHelper;
        if (r109 == null) goto L77;
        String r117 = r109.getOutputPath();
    L78:
        if (r117 != null) goto L81;
        r117 = "";
    L81:
        if (StringsKt.isBlank(r117) == false) goto L83;
    L90:
        CJLogger.b(TAG, "stopRecordingInternal fail: audio file path is blank or file does not exist. path: ".concat(r117));
        AudioHelper r118 = this.audioHelper;
        if (r118 == null) goto L95;
        r100.label = 4;
        if (r118.cancelRecordAudio(r100) != r102) goto L95;
        return r102;
    L83:
        if (new PolarisFileWrapper(r117).exists() == false) goto L90;
        AudioHelper r119 = this.audioHelper;
        if (r119 == null) goto L88;
        r115 = Boxing.boxBoolean(r119.isActuallyDenoised());
    L88:
        this.isActuallyDenoised = r115;
        return r117;
    L77:
        r117 = null;
        goto L78
    L49:
        if (r114.isInMemoryOnly() != true) goto L51;
    L23:
        ResultKt.throwOnFailure(r111);
        Function0<Unit> r120 = new VoicePrintSession$stopRecordingInternal$clearRecordingState$1(this);
        if (isInitialized() == true) goto L28;
        CJLogger.e(TAG, "stopRecordingInternal fail: session not initialized");
        r120.invoke();
        return "";
    L28:
        if (this.isRecording == true) goto L31;
        CJLogger.e(TAG, "stopRecordingInternal fail: not recording");
        r120.invoke();
        return "";
    L31:
        r120.invoke();
        AudioHelper r121 = this.audioHelper;     // Catch: Throwable -> L21
        if (r121 == null) goto L37;
        r100.label = 1;     // Catch: Throwable -> L21
        if (r121.stopRecordAudio(r100) != r102) goto L37;
        return r102;
    L21:
        th = move-exception;
        CJLogger.c(TAG, "stopRecordAudio fail", th);
        return "";
    L7:
        r100 = new C97091(this, r110);
        goto L8
    }

    public final void dispatchResult$bdpay_voiceprint_release(VoicePrintResult r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        CJLogger.d(TAG, "dispatchResult: " + r100);
        VoicePrintCallbackDispatcher r101 = this.callbackDispatcher;
        if (r101 == null) goto L6;
        r101.dispatchResult(r100);
        return;
    }

    public final void dispatchState$bdpay_voiceprint_release(VoicePrintState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if ((!r100.getExt().isEmpty()) == false) goto L5;
        StringBuilder r101 = new StringBuilder("dispatchState: ");
        r101.append(r100);
        r101.append(", ext: ");
        r101.append(r100.getExt());
    L6:
        CJLogger.d(TAG, r101.toString());
        VoicePrintCallbackDispatcher r102 = this.callbackDispatcher;
        if (r102 == null) goto L10;
        r102.dispatchState(r100);
        return;
    L10:
        return;
    L5:
        r101 = new StringBuilder("dispatchState: ");
        r101.append(r100);
        goto L6
    }

    public final void recognizeVoicePrint$bdpay_voiceprint_release(String r110) {
        Intrinsics.checkNotNullParameter(r110, "path");
        if (isInitialized() == true) goto L6;
        return;
    L6:
        if (StringsKt.isBlank(r110) == false) goto L10;
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.UNKNOWN_ERROR, "音频路径为空", null, 4, null));
        return;
    L10:
        if (Intrinsics.areEqual(r110, IN_MEMORY_AUDIO_PATH) == true) goto L12;
    L15:
        VoicePrintOperation r100 = this.operation;
        if (r100 != null) goto L19;
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.invalidParams$default(VoicePrintResult.Companion, "unsupported verify type", null, 2, null));
        return;
    L19:
        dispatchState$bdpay_voiceprint_release(VoicePrintState.START_VERIFY);
        ICJPayRequest r101 = this.currentRequest;
        if (r101 == null) goto L22;
        r101.cancel();
    L22:
        BuildersKt.launch$default(this.mainScope, null, null, new VoicePrintSession$recognizeVoicePrint$1(this, r100, r110, null), 3, null);
        return;
    L12:
        if (this.pendingSealedAudio != null) goto L15;
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.UNKNOWN_ERROR, "内存音频缺失", null, 4, null));
    }

    public final void setActuallyDenoised$bdpay_voiceprint_release(Boolean r100) {
        this.isActuallyDenoised = r100;
    }

    public final void setCallbackDispatcher$bdpay_voiceprint_release(VoicePrintCallbackDispatcher r100) {
        this.callbackDispatcher = r100;
    }

    public final void setLastRecordDurationMs$bdpay_voiceprint_release(Long r100) {
        this.lastRecordDurationMs = r100;
    }

    public final void setOnVolumeChangeListener$bdpay_voiceprint_release(Function1<? super Float, Unit> r100) {
        this.volumeListener = r100;
        AudioHelper r101 = this.audioHelper;
        if (r101 == null) goto L7;
        r101.setOnVolumeChanged(new VoicePrintSession$setOnVolumeChangeListener$1(this));
        return;
    }

    public final void startRecording$bdpay_voiceprint_release(Context r110) {
        Intrinsics.checkNotNullParameter(r110, "appContext");
        if (isInitialized() == true) goto L6;
        return;
    L6:
        if (this.isRecording == false) goto L8;
        return;
    L8:
        this.isRecording = true;
        this.recordStartAt = SystemClock.elapsedRealtime();
        this.lastRecordDurationMs = null;
        dispatchState$bdpay_voiceprint_release(VoicePrintState.START_RECORDING);
        Job r100 = this.recordTimeoutJob;
        if (r100 == null) goto L11;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L11:
        Context r111 = r110.getApplicationContext();
        BuildersKt.launch$default(this.mainScope, null, null, new VoicePrintSession$startRecording$1(this, r111, null), 3, null);
        this.recordTimeoutJob = BuildersKt.launch$default(this.mainScope, null, null, new VoicePrintSession$startRecording$2(this, null), 3, null);
    }

    public final void stopRecordingAsync$bdpay_voiceprint_release(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onFinished");
        BuildersKt.launch$default(this.mainScope, null, null, new VoicePrintSession$stopRecordingAsync$1(r100, this, null), 3, null);
    }

    public static final /* synthetic */ void access$handleOpenResponse(VoicePrintSession r100, ResponseBean r101) {
        r100.handleOpenResponse(r101);
    }

    public static final /* synthetic */ void access$handleVerifyResponse(VoicePrintSession r100, ResponseBean r101) {
        r100.handleVerifyResponse(r101);
    }

    public static final /* synthetic */ void access$setCurrentRequest$p(VoicePrintSession r100, ICJPayRequest r101) {
        r100.currentRequest = r101;
    }

    public static final /* synthetic */ void access$setRecordStartAt$p(VoicePrintSession r100, long r101) {
        r100.recordStartAt = r101;
    }

    public static final /* synthetic */ void access$setRecording$p(VoicePrintSession r100, boolean r101) {
        r100.isRecording = r101;
    }

    public static final /* synthetic */ Object access$stopRecordingInternal(VoicePrintSession r100, Continuation r101) {
        return r100.stopRecordingInternal(r101);
    }

    private final void handleNetworkFailure(String r100, String r101) {
        dispatchState$bdpay_voiceprint_release(VoicePrintState.VERIFY_FAILED);
        StringBuilder r102 = new StringBuilder("code: ");
        r102.append(r100);
        r102.append(", msg: ");
        if (r101 != null) goto L5;
        r101 = null;
    L8:
        r102.append(r101);
        String r103 = r102.toString();
        dispatchResult$bdpay_voiceprint_release(VoicePrintResult.Companion.failed$default(VoicePrintResult.Companion, VoicePrintResult.DetailCode.VERIFY_FAILED_DISABLE_RETRY, r103, null, 4, null));
        deleteRecordingFilesAsync();
        return;
    L5:
        if (StringsKt.isBlank(r101) == false) goto L8;
        r101 = SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR;
        goto L8
    }

    private final Object requestOpenOrUpdate(String r100, Continuation<? super ICJPayRequest> r101) {
        return doVoiceVerify(this.config, r100, OPEN_VOICE_METHOD, new AnonymousClass2(this), r101);
    }

    private final Object requestVerify(String r100, Continuation<? super ICJPayRequest> r101) {
        return doVoiceVerify(this.config, r100, VERIFY_VOICE_METHOD, new C97082(this), r101);
    }

    public final void cancelRecording$bdpay_voiceprint_release(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "cancelReason");
        if (isInitialized() == true) goto L5;
        return;
    L5:
        this.isRecording = false;
        Job r100 = this.recordTimeoutJob;
        if (r100 == null) goto L9;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L9:
        if (this.recordStartAt <= 0) goto L11;
        this.lastRecordDurationMs = Long.valueOf(SystemClock.elapsedRealtime() - this.recordStartAt);
    L11:
        this.recordStartAt = 0;
        if (r110 == false) goto L14;
        VoicePrintState r112 = VoicePrintState.DURATION_TOO_LONG;
        r112.getExt().clear();
        r112.getExt().put(VoicePrintState.EXT_KEY_TIPS, "录音时间过长，请重新朗读一次");
        dispatchState$bdpay_voiceprint_release(r112);
    L14:
        VoicePrintState r113 = VoicePrintState.CANCEL_RECORDING;
        r113.getExt().clear();
        r113.getExt().put(VoicePrintState.EXT_KEY_CANCEL_REASON, r111);
        dispatchState$bdpay_voiceprint_release(r113);
        clearPendingSealedAudioSecurely();
        BuildersKt.launch$default(this.mainScope, null, null, new VoicePrintSession$cancelRecording$3(this, null), 3, null);
    }

    public static final /* synthetic */ void access$handleNetworkFailure(VoicePrintSession r100, String r101, String r102) {
        r100.handleNetworkFailure(r101, r102);
    }

    public static final /* synthetic */ Object access$requestOpenOrUpdate(VoicePrintSession r100, String r101, Continuation r102) {
        return r100.requestOpenOrUpdate(r101, r102);
    }

    public static final /* synthetic */ Object access$requestVerify(VoicePrintSession r100, String r101, Continuation r102) {
        return r100.requestVerify(r101, r102);
    }

    public static /* synthetic */ void cancelRecording$bdpay_voiceprint_release$default(VoicePrintSession r100, boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = "";
    L8:
        r100.cancelRecording$bdpay_voiceprint_release(r101, r102);
    }

    private final <T> Object doVoiceVerify(VoicePrintConfig r100, String r101, String r102, ICJPayNetWorkCallback<T> r103, Continuation<? super ICJPayRequest> r110) {
        if ((r110 instanceof C97071) == false) goto L7;
        C97071 r104 = (C97071) r110;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r111 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r103 = (ICJPayNetWorkCallback) r104.L$2;
        r102 = (String) r104.L$1;
        r100 = (VoicePrintConfig) r104.L$0;
        ResultKt.throwOnFailure(r111);
    L17:
        JSONObject r112 = (JSONObject) r111;
        if (r112 != null) goto L21;
        handleNetworkFailure("-1", "build bizContentParams fail");
        return null;
    L21:
        String r108 = CJPayParamsUtils.getHttpUrl(r102, CJPayParamsUtils.HostAPI.BDPAY);
        Map<String, String> r109 = CJPayParamsUtils.getHttpData(r102, r112.toString(), r100.getAppId(), r100.getMerchantId());
        r109.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return CJPayNetworkManager.postForm(r108, r109, CJPayParamsUtils.getNetHeaderData(r108, r102, null), r103);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        CoroutineDispatcher r113 = Dispatchers.getIO();
        VoicePrintSession$doVoiceVerify$bizContentParams$1 r114 = new VoicePrintSession$doVoiceVerify$bizContentParams$1(r100, r101, this, null);
        r104.L$0 = r100;
        r104.L$1 = r102;
        r104.L$2 = r103;
        r104.label = 1;
        r111 = BuildersKt.withContext(r113, r114, r104);
        if (r111 != r106) goto L17;
        return r106;
    L7:
        r104 = new C97071(this, r110);
        goto L8
    }

    public static final /* synthetic */ Object access$doVoiceVerify(VoicePrintSession r100, VoicePrintConfig r101, String r102, String r103, ICJPayNetWorkCallback r104, Continuation r105) {
        return r100.doVoiceVerify(r101, r102, r103, r104, r105);
    }
}
