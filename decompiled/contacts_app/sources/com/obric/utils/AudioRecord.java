package com.obric.utils;

import android.os.Environment;
import com.GlobalProxyLancet;
import com.obric.audiocodecsdk.encoder.AudioEncoder;
import com.obric.audiocodecsdk.encoder.EncoderFactory;
import com.obric.audiocodecsdk.encoder.EncoderType;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.path.PathsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: AudioRecord.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ4\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\"J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010%\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020 J4\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\"JD\u0010'\u001a\u00020 2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\"H\u0007J\u0006\u0010-\u001a\u00020 J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/utils/AudioRecord;", "", "()V", "_recordingStatus", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "audioEncoder", "Lcom/obric/audiocodecsdk/encoder/AudioEncoder;", "audioFormat", "", "audioRecord", "Landroid/media/AudioRecord;", "bufferSize", "channel", "channelConfig", "<set-?>", "isRecording", "()Z", "recordingThread", "Ljava/lang/Thread;", "convertToWaveform", "", "", "audioData", "", "sampleSize", "deleteRecordingFile", "filename", "", "type", "Lcom/obric/audiocodecsdk/encoder/EncoderType;", "detectSpeech", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function0;", "stop", "getFullRecorderPath", "getRecordFileTypeStr", "pauseRecord", "startRecord", "fileName", "sampleRate", "bitrate", "encoderType", "outputFilepath", "stopRecord", "updateRecordingStatus", "recording", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AudioRecord {
    public static final Companion Companion = null;
    private static final int DEFAULT_BIT_RATE = 128000;
    private static final int DEFAULT_SAMPLE_RATE_IN_HZ = 24000;
    private static final String MERGE_RECORD_FILE_SUFFIX_M4A = ".m4a";
    private static final String MERGE_RECORD_FILE_SUFFIX_MP3 = ".mp3";
    private static final String MERGE_RECORD_FILE_SUFFIX_WAV = ".wav";
    private static final int MIN_BUFFER_SIZE_FACTOR = 5;
    private static final String RECORDER_FOLDER_PATH = "/Recordings/contacts";
    private static final int RECORD_AUDIO_FORMAT = 2;
    private static final int RECORD_CHANNEL_CONFIG = 12;
    private static final double VOLUME_THRESHOLD = 0.1d;
    private final MutableSharedFlow<Boolean> _recordingStatus;
    private AudioEncoder audioEncoder;
    private final int audioFormat;
    private android.media.AudioRecord audioRecord;
    private int bufferSize;
    private final int channel;
    private final int channelConfig;
    private boolean isRecording;
    private Thread recordingThread;

    /* JADX INFO: compiled from: AudioRecord.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/utils/AudioRecord$Companion;", "", "()V", "DEFAULT_BIT_RATE", "", "DEFAULT_SAMPLE_RATE_IN_HZ", "MERGE_RECORD_FILE_SUFFIX_M4A", "", "MERGE_RECORD_FILE_SUFFIX_MP3", "MERGE_RECORD_FILE_SUFFIX_WAV", "MIN_BUFFER_SIZE_FACTOR", "RECORDER_FOLDER_PATH", "RECORD_AUDIO_FORMAT", "RECORD_CHANNEL_CONFIG", "VOLUME_THRESHOLD", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: AudioRecord.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[EncoderType.values().length];
            r0[EncoderType.MP3.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EncoderType.WAV.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.utils.AudioRecord$updateRecordingStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: AudioRecord.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.utils.AudioRecord$updateRecordingStatus$1", f = "AudioRecord.kt", i = {}, l = {225}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioRecord this$0;

        AnonymousClass1(AudioRecord r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(this.this$0, r2);
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
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            if (AudioRecord.access$get_recordingStatus$p(this.this$0).emit(Boxing.boxBoolean(this.this$0.isRecording()), this) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$GkMAo6ddsHoC_8zg3GiUentakyk(AudioRecord r0, Function0 r1, Function0 r2) {
        startRecord$lambda$1(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public final void pauseRecord() {
    }

    public AudioRecord() {
        this.channelConfig = 16;
        this.channel = 1;
        this.audioFormat = 2;
        this.bufferSize = android.media.AudioRecord.getMinBufferSize(24000, 12, 2) * 5;
        this._recordingStatus = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public static final /* synthetic */ MutableSharedFlow access$get_recordingStatus$p(AudioRecord r0) {
        return r0._recordingStatus;
    }

    public final boolean isRecording() {
        return this.isRecording;
    }

    public static /* synthetic */ String getRecordFileTypeStr$default(AudioRecord r0, EncoderType r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = EncoderType.WAV;
    L6:
        return r0.getRecordFileTypeStr(r1);
    }

    public final String getRecordFileTypeStr(EncoderType r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
        int r0 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r0 != 1) goto L5;
        return MERGE_RECORD_FILE_SUFFIX_MP3;
    L5:
        if (r0 == 2) goto L7;
        return MERGE_RECORD_FILE_SUFFIX_M4A;
    L7:
        return MERGE_RECORD_FILE_SUFFIX_WAV;
    }

    public static /* synthetic */ String getFullRecorderPath$default(AudioRecord r0, String r1, EncoderType r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = EncoderType.WAV;
    L6:
        return r0.getFullRecorderPath(r1, r2);
    }

    public final String getFullRecorderPath(String r3, EncoderType r4) {
        Intrinsics.checkNotNullParameter(r3, "filename");
        Intrinsics.checkNotNullParameter(r4, "type");
        String r5 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Recordings/contacts/" + r3;
        File r0 = new File(r5);
        if (r0.exists() == false) goto L5;
    L8:
        StringBuilder r6 = new StringBuilder().append(r5).append('/');
        Path r1 = r0.toPath().getFileName();
        Intrinsics.checkNotNullExpressionValue(r1, "file.toPath().fileName");
        return r6.append(PathsKt.getNameWithoutExtension(r1)).append(getRecordFileTypeStr(r4)).toString();
    L5:
        if (r0.mkdirs() == true) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("TAG", "mkdir failed! Return! path: " + r5);
        return "";
    }

    public static /* synthetic */ void detectSpeech$default(AudioRecord r0, byte[] r1, int r2, Function0 r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r2 = r1.length;
    L5:
        r0.detectSpeech(r1, r2, r3, r4);
    }

    public final void detectSpeech(byte[] r3, int r4, Function0<Unit> r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "audioData");
        Intrinsics.checkNotNullParameter(r5, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r6, "stop");
        Iterator<Double> r2 = convertToWaveform(r3, r4).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r2.next().doubleValue() <= 0.1d) goto L4;
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        r5.invoke();
        return;
    L11:
        r6.invoke();
        return;
    L8:
        r7 = false;
        goto L9
    }

    private final List<Double> convertToWaveform(byte[] r12, int r13) {
        ArrayList r11 = new ArrayList();
        int r0 = r12.length / 2;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        int r3 = RangesKt.coerceAtMost(r13, r0 - r2);
        double r4 = 0.0d;
        int r6 = 0;
    L5:
        if (r6 >= r3) goto L7;
        int r7 = (r2 + r6) * 2;
        r4 = Math.max(r4, ((double) Math.abs((r12[r7 + 1] << 8) | (r12[r7] & 255))) / 32768.0d);
        r6 = r6 + 1;
        goto L5
    L7:
        r11.add(Double.valueOf(r4));
        r2 = r2 + r13;
        goto L3
    L8:
        return r11;
    }

    public static /* synthetic */ String startRecord$default(AudioRecord r0, EncoderType r1, String r2, Function0 r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = EncoderType.WAV;
    L6:
        return r0.startRecord(r1, r2, r3, r4);
    }

    public final String startRecord(EncoderType r9, String r10, Function0<Unit> r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "fileName");
        Intrinsics.checkNotNullParameter(r11, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r12, "stop");
        String r13 = getFullRecorderPath(r10, r9);
        startRecord(24000, DEFAULT_BIT_RATE, r9, r13, r11, r12);
        return r13;
    }

    public final void startRecord(int r8, int r9, EncoderType r10, String r11, final Function0<Unit> r12, final Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "encoderType");
        Intrinsics.checkNotNullParameter(r11, "outputFilepath");
        Intrinsics.checkNotNullParameter(r12, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r13, "stop");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("AudioRecord", "startRecord isRecording: " + this.isRecording);
        if (this.isRecording == false) goto L5;
        return;
    L5:
        updateRecordingStatus(true);
        AudioEncoder r14 = EncoderFactory.createEncoder(r10, r8, this.channel, this.bufferSize, r9, r11);
        this.audioEncoder = r14;
        if (r14 == null) goto L8;
        r14.start();
    L8:
        android.media.AudioRecord r15 = new android.media.AudioRecord(1, r8, this.channelConfig, this.audioFormat, this.bufferSize);
        this.audioRecord = r15;
        r15.startRecording();
        Thread r16 = new Thread(new AudioRecord$$ExternalSyntheticLambda0(this, r12, r13));
        this.recordingThread = r16;
        r16.start();
    }

    private static final void startRecord$lambda$1(AudioRecord r4, Function0 r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$action");
        Intrinsics.checkNotNullParameter(r6, "$stop");
        int r0 = r4.bufferSize;
        byte[] r1 = new byte[r0];
    L4:
        if (r4.isRecording == false) goto L14;
        android.media.AudioRecord r2 = r4.audioRecord;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("audioRecord");
        r2 = null;
    L8:
        int r3 = r2.read(r1, 0, r0);
        if (r3 <= 0) goto L4;
        AudioEncoder r7 = r4.audioEncoder;
        if (r7 == null) goto L13;
        r7.encode(r1, r0);
    L13:
        r4.detectSpeech(r1, r3, r5, r6);
        goto L4
    }

    public final void stopRecord() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("AudioRecord", "stopRecord isRecording: " + this.isRecording);
        if (this.isRecording == false) goto L18;
        updateRecordingStatus(false);
        android.media.AudioRecord r0 = this.audioRecord;
        Thread r2 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("audioRecord");
        r0 = null;
    L7:
        r0.stop();
        android.media.AudioRecord r1 = this.audioRecord;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("audioRecord");
        r1 = null;
    L10:
        r1.release();
        Thread r3 = this.recordingThread;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recordingThread");
    L14:
        r2.join();
        AudioEncoder r4 = this.audioEncoder;
        if (r4 == null) goto L19;
        r4.stop();
        return;
    L19:
        return;
    L13:
        r2 = r3;
        goto L14
    }

    private final void updateRecordingStatus(boolean r7) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("AudioRecord", "updateRecordingStatus isRecording: " + this.isRecording + " , recording: " + r7);
        if (this.isRecording == r7) goto L6;
        this.isRecording = r7;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    public static /* synthetic */ boolean deleteRecordingFile$default(AudioRecord r0, String r1, EncoderType r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = EncoderType.WAV;
    L6:
        return r0.deleteRecordingFile(r1, r2);
    }

    public final boolean deleteRecordingFile(String r2, EncoderType r3) {
        Intrinsics.checkNotNullParameter(r2, "filename");
        Intrinsics.checkNotNullParameter(r3, "type");
        File r0 = new File(getFullRecorderPath(r2, r3));
        if (r0.exists() == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("AudioRecord", "deleteRecordingFile success filePath: " + r0.getAbsolutePath());
        return r0.delete();
    L5:
        return false;
    }
}
