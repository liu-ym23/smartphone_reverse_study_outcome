package com.bytedance.android.livesdk.asr;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/asr/ButtonStatus;", "", "", "buttonText", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "Recognizing", "StartRecognize", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ButtonStatus extends Enum<ButtonStatus> {
    public static final ButtonStatus Recognizing = null;
    public static final ButtonStatus StartRecognize = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonStatus[] f103938a = null;
    private final String buttonText;

    static {
        ButtonStatus r100 = new ButtonStatus("Recognizing", 0, "识别中");
        Recognizing = r100;
        ButtonStatus r101 = new ButtonStatus("StartRecognize", 1, "开始识别");
        StartRecognize = r101;
        f103938a = new ButtonStatus[]{r100, r101};
    }

    public static ButtonStatus valueOf(String r100) {
        return (ButtonStatus) r27.a.a(ButtonStatus.class, r100);
    }

    public static ButtonStatus[] values() {
        return (ButtonStatus[]) f103938a.clone();
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public ButtonStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.buttonText = r102;
    }
}
