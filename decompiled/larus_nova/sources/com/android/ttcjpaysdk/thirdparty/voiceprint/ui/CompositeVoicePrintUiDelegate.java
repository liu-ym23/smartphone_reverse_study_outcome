package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/CompositeVoicePrintUiDelegate;", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoicePrintUiDelegate;", "delegates", "", "(Ljava/util/List;)V", "closeActivity", "", "getCurrentVerifyStep", "", "()Ljava/lang/Integer;", "getCurrentVerifyType", "", "getRecordingTips", "incrementIndicator", "state", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/bean/VoicePrintState;", "setRecordButtonEnabled", "enabled", "", "setRecordButtonVisible", "visible", "showPermissionDialog", "showRecognizeLoading", "show", "updateTips", "updateVoiceText", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CompositeVoicePrintUiDelegate implements VoicePrintUiDelegate {
    private final List<VoicePrintUiDelegate> delegates;

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void closeActivity() {
        Iterator<T> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((VoicePrintUiDelegate) r100.next()).closeActivity();
        goto L4
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public Integer getCurrentVerifyStep() {
        Iterator<T> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Integer r101 = ((VoicePrintUiDelegate) r100.next()).getCurrentVerifyStep();
        if (r101 == null) goto L4;
        return Integer.valueOf(r101.intValue());
    L9:
        return null;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public String getCurrentVerifyType() {
        Iterator<T> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        String r101 = ((VoicePrintUiDelegate) r100.next()).getCurrentVerifyType();
        if ((!StringsKt.isBlank(r101)) == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L4;
        return r101;
    L11:
        return "";
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public String getRecordingTips() {
        Iterator<T> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        String r101 = ((VoicePrintUiDelegate) r100.next()).getRecordingTips();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L4;
        return r101;
    L8:
        if (StringsKt.isBlank(r101) == true) goto L11;
        r102 = false;
        goto L12
    L14:
        return null;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void showPermissionDialog() {
        Iterator<T> r100 = this.delegates.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((VoicePrintUiDelegate) r100.next()).showPermissionDialog();
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeVoicePrintUiDelegate(List<? extends VoicePrintUiDelegate> r100) {
        Intrinsics.checkNotNullParameter(r100, "delegates");
        this.delegates = r100;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void incrementIndicator(VoicePrintState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator<T> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((VoicePrintUiDelegate) r101.next()).incrementIndicator(r100);
        goto L4
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void setRecordButtonEnabled(boolean r100) {
        Iterator<T> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((VoicePrintUiDelegate) r101.next()).setRecordButtonEnabled(r100);
        goto L4
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void setRecordButtonVisible(boolean r100) {
        Iterator<T> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((VoicePrintUiDelegate) r101.next()).setRecordButtonVisible(r100);
        goto L4
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void showRecognizeLoading(boolean r100) {
        Iterator<T> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((VoicePrintUiDelegate) r101.next()).showRecognizeLoading(r100);
        goto L4
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void updateTips(VoicePrintState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator<T> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((VoicePrintUiDelegate) r101.next()).updateTips(r100);
        goto L4
    }

    @Override // com.android.ttcjpaysdk.thirdparty.voiceprint.ui.VoicePrintUiDelegate
    public void updateVoiceText(VoicePrintState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator<T> r101 = this.delegates.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((VoicePrintUiDelegate) r101.next()).updateVoiceText(r100);
        goto L4
    }
}
