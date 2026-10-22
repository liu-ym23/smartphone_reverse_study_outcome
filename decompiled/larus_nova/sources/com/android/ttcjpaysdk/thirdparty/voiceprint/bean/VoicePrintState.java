package com.android.ttcjpaysdk.thirdparty.voiceprint.bean;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u001d\b\u0002\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u0004\u0018\u0001H\n\"\u0006\b\u0000\u0010\n\u0018\u00012\u0006\u0010\u000b\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintState;", "", "ext", "", "", "", "(Ljava/lang/String;ILjava/util/Map;)V", "getExt", "()Ljava/util/Map;", "getExtValue", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "INITIALIZED", "SESSION_REPLACED", "PERMISSION_DENIED", "PERMISSION_GRANTED", "PERMISSION_PREVIOUSLY_DENIED", "START_RECORDING", "STOP_RECORDING", "CANCEL_RECORDING", "DURATION_TOO_SHORT", "DURATION_TOO_LONG", "START_VERIFY", "SUC_CONTINUE_VERIFY", "FAIL_CONTINUE_VERIFY", "VERIFY_SUCCESS", "VERIFY_FAILED", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum VoicePrintState extends Enum<VoicePrintState> {
    private static final /* synthetic */ VoicePrintState[] $VALUES = null;
    public static final VoicePrintState CANCEL_RECORDING = null;
    public static final Companion Companion = null;
    public static final VoicePrintState DURATION_TOO_LONG = null;
    public static final VoicePrintState DURATION_TOO_SHORT = null;
    public static final String EXT_KEY_CANCEL_REASON = "cancel_reason";
    public static final String EXT_KEY_RESPONSE_CODE = "response_code";
    public static final String EXT_KEY_TEXT = "voice_text";
    public static final String EXT_KEY_TIPS = "voice_tips";
    public static final VoicePrintState FAIL_CONTINUE_VERIFY = null;
    public static final VoicePrintState INITIALIZED = null;
    public static final VoicePrintState PERMISSION_DENIED = null;
    public static final VoicePrintState PERMISSION_GRANTED = null;
    public static final VoicePrintState PERMISSION_PREVIOUSLY_DENIED = null;
    public static final VoicePrintState SESSION_REPLACED = null;
    public static final VoicePrintState START_RECORDING = null;
    public static final VoicePrintState START_VERIFY = null;
    public static final VoicePrintState STOP_RECORDING = null;
    public static final VoicePrintState SUC_CONTINUE_VERIFY = null;
    public static final VoicePrintState VERIFY_FAILED = null;
    public static final VoicePrintState VERIFY_SUCCESS = null;
    private final Map<String, Object> ext;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintState$Companion;", "", "()V", "EXT_KEY_CANCEL_REASON", "", "EXT_KEY_RESPONSE_CODE", "EXT_KEY_TEXT", "EXT_KEY_TIPS", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    private static final /* synthetic */ VoicePrintState[] $values() {
        return new VoicePrintState[]{INITIALIZED, SESSION_REPLACED, PERMISSION_DENIED, PERMISSION_GRANTED, PERMISSION_PREVIOUSLY_DENIED, START_RECORDING, STOP_RECORDING, CANCEL_RECORDING, DURATION_TOO_SHORT, DURATION_TOO_LONG, START_VERIFY, SUC_CONTINUE_VERIFY, FAIL_CONTINUE_VERIFY, VERIFY_SUCCESS, VERIFY_FAILED};
    }

    public static VoicePrintState valueOf(String r100) {
        return (VoicePrintState) a.a(VoicePrintState.class, r100);
    }

    public static VoicePrintState[] values() {
        return (VoicePrintState[]) $VALUES.clone();
    }

    static {
        INITIALIZED = new VoicePrintState("INITIALIZED", 0, null, 1, null);
        Map r110 = null;
        int r111 = 1;
        DefaultConstructorMarker r112 = null;
        SESSION_REPLACED = new VoicePrintState("SESSION_REPLACED", 1, r110, r111, r112);
        Map r100 = null;
        int r101 = 1;
        DefaultConstructorMarker r102 = null;
        PERMISSION_DENIED = new VoicePrintState("PERMISSION_DENIED", 2, r100, r101, r102);
        PERMISSION_GRANTED = new VoicePrintState("PERMISSION_GRANTED", 3, r110, r111, r112);
        PERMISSION_PREVIOUSLY_DENIED = new VoicePrintState("PERMISSION_PREVIOUSLY_DENIED", 4, r100, r101, r102);
        START_RECORDING = new VoicePrintState("START_RECORDING", 5, r110, r111, r112);
        STOP_RECORDING = new VoicePrintState("STOP_RECORDING", 6, r100, r101, r102);
        CANCEL_RECORDING = new VoicePrintState("CANCEL_RECORDING", 7, r110, r111, r112);
        DURATION_TOO_SHORT = new VoicePrintState("DURATION_TOO_SHORT", 8, r100, r101, r102);
        DURATION_TOO_LONG = new VoicePrintState("DURATION_TOO_LONG", 9, r110, r111, r112);
        START_VERIFY = new VoicePrintState("START_VERIFY", 10, r100, r101, r102);
        SUC_CONTINUE_VERIFY = new VoicePrintState("SUC_CONTINUE_VERIFY", 11, r110, r111, r112);
        FAIL_CONTINUE_VERIFY = new VoicePrintState("FAIL_CONTINUE_VERIFY", 12, r100, r101, r102);
        VERIFY_SUCCESS = new VoicePrintState("VERIFY_SUCCESS", 13, r110, r111, r112);
        VERIFY_FAILED = new VoicePrintState("VERIFY_FAILED", 14, r100, r101, r102);
        $VALUES = $values();
        Companion = new Companion(null);
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final /* synthetic */ <T> T getExtValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) getExt().get(r100);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return r101;
    }

    private VoicePrintState(String r100, int r101, Map r102) {
        super(r100, r101);
        this.ext = r102;
    }

    public /* synthetic */ VoicePrintState(String r100, int r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = new LinkedHashMap();
    L5:
        this(r100, r101, r102);
    }
}
