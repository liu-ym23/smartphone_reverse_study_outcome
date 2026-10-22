package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J8\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H&J<\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "certSign", "", "ctx", "Landroid/content/Context;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICertSignCallback;", "isTokenValid", "", "token", "", "onTouchEvent", "rootView", "Landroid/view/ViewGroup;", "event", "Landroid/view/MotionEvent;", "prefetchForIDaaSAuth", "appId", "merchantId", "source", "sourceId", "", "startVerify", "verifyId", "verifyToken", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback;", "config", "Lcom/android/ttcjpaysdk/base/service/CustomizedConfig;", "IDyVerifyCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayDyVerifyService extends ICJPayService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onTouchEvent(ICJPayDyVerifyService r100, ViewGroup r101, MotionEvent r102) {
            Intrinsics.checkNotNullParameter(r101, "rootView");
            Intrinsics.checkNotNullParameter(r102, "event");
        }

        public static /* synthetic */ void startVerify$default(ICJPayDyVerifyService r100, Context r101, String r102, String r103, IDyVerifyCallback r110, CustomizedConfig r111, int r112, Object r113) {
            if (r113 != null) goto L9;
            if ((r112 & 16) == 0) goto L6;
            r111 = null;
        L6:
            r100.startVerify(r101, r102, r103, r110, r111);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startVerify");
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006\u0016\u0017\u0018\u0019\u001a\u001bJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J,\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback;", "", "onCertStage", "", "stage", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$CertStage;", "defaultProcess", "Lkotlin/Function0;", "onFaceStage", "Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStage;", "onFingerprintStage", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$FingerprintStage;", "onResult", "code", "", "msg", "", "curVerifyProduct", "ext", "onVoiceState", "state", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$VoiceVerifyState;", "CertStage", "CertStageType", "DyVerifyProductStageStatus", "FingerprintStage", "FingerprintStageType", "VoiceVerifyState", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IDyVerifyCallback {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$CertStage;", "", "status", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$DyVerifyProductStageStatus;", "type", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$CertStageType;", "(Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$DyVerifyProductStageStatus;Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$CertStageType;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class CertStage {
            public DyVerifyProductStageStatus status;
            public CertStageType type;

            /* JADX WARN: Multi-variable type inference failed */
            public CertStage() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public CertStage(DyVerifyProductStageStatus r100, CertStageType r101) {
                this.status = r100;
                this.type = r101;
            }

            public /* synthetic */ CertStage(DyVerifyProductStageStatus r100, CertStageType r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$CertStageType;", "", "value", "", "label", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getValue", "()I", "SIGN_VERIFY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum CertStageType extends Enum<CertStageType> {
            private static final /* synthetic */ CertStageType[] $VALUES = null;
            public static final CertStageType SIGN_VERIFY = null;
            private final String label;
            private final int value;

            private static final /* synthetic */ CertStageType[] $values() {
                return new CertStageType[]{SIGN_VERIFY};
            }

            public static CertStageType valueOf(String r100) {
                return (CertStageType) a.a(CertStageType.class, r100);
            }

            public static CertStageType[] values() {
                return (CertStageType[]) $VALUES.clone();
            }

            static {
                SIGN_VERIFY = new CertStageType("SIGN_VERIFY", 0, 1, "签名");
                $VALUES = $values();
            }

            public final String getLabel() {
                return this.label;
            }

            public final int getValue() {
                return this.value;
            }

            private CertStageType(String r100, int r101, int r102, String r103) {
                super(r100, r101);
                this.value = r102;
                this.label = r103;
            }
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onCertStage(IDyVerifyCallback r100, CertStage r101, Function0<Unit> r102) {
                Intrinsics.checkNotNullParameter(r101, "stage");
                Intrinsics.checkNotNullParameter(r102, "defaultProcess");
                r102.invoke();
            }

            public static void onFaceStage(IDyVerifyCallback r100, ICJPayFaceCheckCallback.FaceStage r101, Function0<Unit> r102) {
                Intrinsics.checkNotNullParameter(r101, "stage");
                Intrinsics.checkNotNullParameter(r102, "defaultProcess");
                r102.invoke();
            }

            public static void onFingerprintStage(IDyVerifyCallback r100, FingerprintStage r101, Function0<Unit> r102) {
                Intrinsics.checkNotNullParameter(r101, "stage");
                Intrinsics.checkNotNullParameter(r102, "defaultProcess");
                r102.invoke();
            }

            public static void onVoiceState(IDyVerifyCallback r100, VoiceVerifyState r101, Function0<Unit> r102) {
                Intrinsics.checkNotNullParameter(r101, "state");
                Intrinsics.checkNotNullParameter(r102, "defaultProcess");
                r102.invoke();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void onVoiceState$default(IDyVerifyCallback r100, VoiceVerifyState r101, Function0 r102, int r103, Object r104) {
                if (r104 != null) goto L9;
                if ((r103 & 2) == 0) goto L6;
                r102 = ICJPayDyVerifyService$IDyVerifyCallback$onVoiceState$1.INSTANCE;
            L6:
                r100.onVoiceState(r101, r102);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onVoiceState");
            }

            public static /* synthetic */ void onResult$default(IDyVerifyCallback r100, int r101, String r102, String r103, String r104, int r105, Object r106) {
                if (r106 != null) goto L9;
                if ((r105 & 8) == 0) goto L6;
                r104 = null;
            L6:
                r100.onResult(r101, r102, r103, r104);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResult");
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$DyVerifyProductStageStatus;", "", "value", "", "label", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getValue", "()I", "STAGE_START", "STAGE_END", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum DyVerifyProductStageStatus extends Enum<DyVerifyProductStageStatus> {
            private static final /* synthetic */ DyVerifyProductStageStatus[] $VALUES = null;
            public static final DyVerifyProductStageStatus STAGE_END = null;
            public static final DyVerifyProductStageStatus STAGE_START = null;
            private final String label;
            private final int value;

            private static final /* synthetic */ DyVerifyProductStageStatus[] $values() {
                return new DyVerifyProductStageStatus[]{STAGE_START, STAGE_END};
            }

            public static DyVerifyProductStageStatus valueOf(String r100) {
                return (DyVerifyProductStageStatus) a.a(DyVerifyProductStageStatus.class, r100);
            }

            public static DyVerifyProductStageStatus[] values() {
                return (DyVerifyProductStageStatus[]) $VALUES.clone();
            }

            static {
                STAGE_START = new DyVerifyProductStageStatus("STAGE_START", 0, 1, "阶段开始");
                STAGE_END = new DyVerifyProductStageStatus("STAGE_END", 1, 2, "阶段结束");
                $VALUES = $values();
            }

            public final String getLabel() {
                return this.label;
            }

            public final int getValue() {
                return this.value;
            }

            private DyVerifyProductStageStatus(String r100, int r101, int r102, String r103) {
                super(r100, r101);
                this.value = r102;
                this.label = r103;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$FingerprintStage;", "", "status", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$DyVerifyProductStageStatus;", "type", "Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$FingerprintStageType;", "(Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$DyVerifyProductStageStatus;Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$FingerprintStageType;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class FingerprintStage {
            public DyVerifyProductStageStatus status;
            public FingerprintStageType type;

            /* JADX WARN: Multi-variable type inference failed */
            public FingerprintStage() {
                Object[] r100 = 0 == true ? 1 : 0;
                this(null, r100, 3, 0 == true ? 1 : 0);
            }

            public FingerprintStage(DyVerifyProductStageStatus r100, FingerprintStageType r101) {
                this.status = r100;
                this.type = r101;
            }

            public /* synthetic */ FingerprintStage(DyVerifyProductStageStatus r100, FingerprintStageType r101, int r102, DefaultConstructorMarker r103) {
                if ((r102 & 1) == 0) goto L6;
                r100 = null;
            L6:
                if ((r102 & 2) == 0) goto L8;
                r101 = null;
            L8:
                this(r100, r101);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$FingerprintStageType;", "", "value", "", "label", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getValue", "()I", "OTP_VERIFY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum FingerprintStageType extends Enum<FingerprintStageType> {
            private static final /* synthetic */ FingerprintStageType[] $VALUES = null;
            public static final FingerprintStageType OTP_VERIFY = null;
            private final String label;
            private final int value;

            private static final /* synthetic */ FingerprintStageType[] $values() {
                return new FingerprintStageType[]{OTP_VERIFY};
            }

            public static FingerprintStageType valueOf(String r100) {
                return (FingerprintStageType) a.a(FingerprintStageType.class, r100);
            }

            public static FingerprintStageType[] values() {
                return (FingerprintStageType[]) $VALUES.clone();
            }

            static {
                OTP_VERIFY = new FingerprintStageType("OTP_VERIFY", 0, 1, "OTP一致性判断");
                $VALUES = $values();
            }

            public final String getLabel() {
                return this.label;
            }

            public final int getValue() {
                return this.value;
            }

            private FingerprintStageType(String r100, int r101, int r102, String r103) {
                super(r100, r101);
                this.value = r102;
                this.label = r103;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayDyVerifyService$IDyVerifyCallback$VoiceVerifyState;", "", "(Ljava/lang/String;I)V", "STARTED", "VERIFYING", "DURATION_TOO_SHORT", "DURATION_TOO_LONG", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum VoiceVerifyState extends Enum<VoiceVerifyState> {
            private static final /* synthetic */ VoiceVerifyState[] $VALUES = null;
            public static final VoiceVerifyState DURATION_TOO_LONG = null;
            public static final VoiceVerifyState DURATION_TOO_SHORT = null;
            public static final VoiceVerifyState STARTED = null;
            public static final VoiceVerifyState VERIFYING = null;

            private static final /* synthetic */ VoiceVerifyState[] $values() {
                return new VoiceVerifyState[]{STARTED, VERIFYING, DURATION_TOO_SHORT, DURATION_TOO_LONG};
            }

            public static VoiceVerifyState valueOf(String r100) {
                return (VoiceVerifyState) a.a(VoiceVerifyState.class, r100);
            }

            public static VoiceVerifyState[] values() {
                return (VoiceVerifyState[]) $VALUES.clone();
            }

            static {
                STARTED = new VoiceVerifyState("STARTED", 0);
                VERIFYING = new VoiceVerifyState("VERIFYING", 1);
                DURATION_TOO_SHORT = new VoiceVerifyState("DURATION_TOO_SHORT", 2);
                DURATION_TOO_LONG = new VoiceVerifyState("DURATION_TOO_LONG", 3);
                $VALUES = $values();
            }

            private VoiceVerifyState(String r100, int r101) {
                super(r100, r101);
            }
        }

        void onCertStage(CertStage r100, Function0<Unit> r101);

        void onFaceStage(ICJPayFaceCheckCallback.FaceStage r100, Function0<Unit> r101);

        void onFingerprintStage(FingerprintStage r100, Function0<Unit> r101);

        void onResult(int r100, String r101, String r102, String r103);

        void onVoiceState(VoiceVerifyState r100, Function0<Unit> r101);
    }

    void certSign(Context r100, ICertSignCallback r101);

    boolean isTokenValid(String r100);

    void onTouchEvent(ViewGroup r100, MotionEvent r101);

    void prefetchForIDaaSAuth(Context r100, String r101, String r102, String r103, int r104);

    void startVerify(Context r100, String r101, String r102, IDyVerifyCallback r103, CustomizedConfig r104);
}
