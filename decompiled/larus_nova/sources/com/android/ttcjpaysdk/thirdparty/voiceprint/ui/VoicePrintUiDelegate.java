package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintUiDelegate;", "", "closeActivity", "", "getCurrentVerifyStep", "", "()Ljava/lang/Integer;", "getCurrentVerifyType", "", "getRecordingTips", "incrementIndicator", "state", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintState;", "setRecordButtonEnabled", "enabled", "", "setRecordButtonVisible", "visible", "showPermissionDialog", "showRecognizeLoading", "show", "updateTips", "updateVoiceText", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VoicePrintUiDelegate {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void closeActivity(VoicePrintUiDelegate r100) {
        }

        public static Integer getCurrentVerifyStep(VoicePrintUiDelegate r100) {
            return null;
        }

        public static String getCurrentVerifyType(VoicePrintUiDelegate r100) {
            return "";
        }

        public static String getRecordingTips(VoicePrintUiDelegate r100) {
            return null;
        }

        public static void incrementIndicator(VoicePrintUiDelegate r100, VoicePrintState r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
        }

        public static void setRecordButtonEnabled(VoicePrintUiDelegate r100, boolean r101) {
        }

        public static void setRecordButtonVisible(VoicePrintUiDelegate r100, boolean r101) {
        }

        public static void showPermissionDialog(VoicePrintUiDelegate r100) {
        }

        public static void showRecognizeLoading(VoicePrintUiDelegate r100, boolean r101) {
        }

        public static void updateTips(VoicePrintUiDelegate r100, VoicePrintState r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
        }

        public static void updateVoiceText(VoicePrintUiDelegate r100, VoicePrintState r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
        }
    }

    void closeActivity();

    Integer getCurrentVerifyStep();

    String getCurrentVerifyType();

    String getRecordingTips();

    void incrementIndicator(VoicePrintState r100);

    void setRecordButtonEnabled(boolean r100);

    void setRecordButtonVisible(boolean r100);

    void showPermissionDialog();

    void showRecognizeLoading(boolean r100);

    void updateTips(VoicePrintState r100);

    void updateVoiceText(VoicePrintState r100);
}
