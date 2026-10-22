package com.android.ttcjpaysdk.base.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\b\u0010\n\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback;", "", "isInvokeVerifyFullPageExpected", "", "onFaceStage", "", "stage", "Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStage;", "defaultProcess", "Lkotlin/Function0;", "onGetTicket", "FaceStage", "FaceStageStatus", "FaceStageType", "ICJFaceDialogCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayFaceCheckCallback {

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isInvokeVerifyFullPageExpected(ICJPayFaceCheckCallback r100) {
            return false;
        }

        public static void onFaceStage(ICJPayFaceCheckCallback r100, FaceStage r101, Function0<Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, "stage");
            Intrinsics.checkNotNullParameter(r102, "defaultProcess");
            r102.invoke();
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStage;", "", "status", "Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStageStatus;", "type", "Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStageType;", "result", "", "(Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStageStatus;Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStageType;Ljava/lang/String;)V", "isResultSuccess", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceStage {
        public String result;
        public FaceStageStatus status;
        public FaceStageType type;

        public FaceStage() {
            this(null, null, null, 7, null);
        }

        public final boolean isResultSuccess() {
            return Intrinsics.areEqual(this.result, "MP000000");
        }

        public FaceStage(FaceStageStatus r100, FaceStageType r101, String r102) {
            this.status = r100;
            this.type = r101;
            this.result = r102;
        }

        public /* synthetic */ FaceStage(FaceStageStatus r100, FaceStageType r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStageStatus;", "", "value", "", "label", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getValue", "()I", "POINT", "STAGE_START", "STAGE_END", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum FaceStageStatus extends Enum<FaceStageStatus> {
        private static final /* synthetic */ FaceStageStatus[] $VALUES = null;
        public static final FaceStageStatus POINT = null;
        public static final FaceStageStatus STAGE_END = null;
        public static final FaceStageStatus STAGE_START = null;
        private final String label;
        private final int value;

        private static final /* synthetic */ FaceStageStatus[] $values() {
            return new FaceStageStatus[]{POINT, STAGE_START, STAGE_END};
        }

        public static FaceStageStatus valueOf(String r100) {
            return (FaceStageStatus) a.a(FaceStageStatus.class, r100);
        }

        public static FaceStageStatus[] values() {
            return (FaceStageStatus[]) $VALUES.clone();
        }

        static {
            POINT = new FaceStageStatus("POINT", 0, 0, "流程节点");
            STAGE_START = new FaceStageStatus("STAGE_START", 1, 1, "阶段开始");
            STAGE_END = new FaceStageStatus("STAGE_END", 2, 2, "阶段结束");
            $VALUES = $values();
        }

        public final String getLabel() {
            return this.label;
        }

        public final int getValue() {
            return this.value;
        }

        private FaceStageStatus(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.value = r102;
            this.label = r103;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$FaceStageType;", "", "value", "", "label", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getValue", "()I", "FACE_PRE", "TICKET_GET", "RESULT_CHECK", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum FaceStageType extends Enum<FaceStageType> {
        private static final /* synthetic */ FaceStageType[] $VALUES = null;
        public static final FaceStageType FACE_PRE = null;
        public static final FaceStageType RESULT_CHECK = null;
        public static final FaceStageType TICKET_GET = null;
        private final String label;
        private final int value;

        private static final /* synthetic */ FaceStageType[] $values() {
            return new FaceStageType[]{FACE_PRE, TICKET_GET, RESULT_CHECK};
        }

        public static FaceStageType valueOf(String r100) {
            return (FaceStageType) a.a(FaceStageType.class, r100);
        }

        public static FaceStageType[] values() {
            return (FaceStageType[]) $VALUES.clone();
        }

        static {
            FACE_PRE = new FaceStageType("FACE_PRE", 0, 0, "活体前置流程节点");
            TICKET_GET = new FaceStageType("TICKET_GET", 1, 1, "获取票据阶段");
            RESULT_CHECK = new FaceStageType("RESULT_CHECK", 2, 2, "二次核验阶段");
            $VALUES = $values();
        }

        public final String getLabel() {
            return this.label;
        }

        public final int getValue() {
            return this.value;
        }

        private FaceStageType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.value = r102;
            this.label = r103;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback$ICJFaceDialogCallback;", "Lcom/android/ttcjpaysdk/base/service/ICJPayFaceCheckCallback;", "onClickTryAgain", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ICJFaceDialogCallback extends ICJPayFaceCheckCallback {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static boolean isInvokeVerifyFullPageExpected(ICJFaceDialogCallback r100) {
                return DefaultImpls.isInvokeVerifyFullPageExpected(r100);
            }

            public static void onFaceStage(ICJFaceDialogCallback r100, FaceStage r101, Function0<Unit> r102) {
                Intrinsics.checkNotNullParameter(r101, "stage");
                Intrinsics.checkNotNullParameter(r102, "defaultProcess");
                DefaultImpls.onFaceStage(r100, r101, r102);
            }
        }

        void onClickTryAgain();
    }

    boolean isInvokeVerifyFullPageExpected();

    void onFaceStage(FaceStage r100, Function0<Unit> r101);

    void onGetTicket();
}
