package com.bytedance.android.live.liveinteract.digitavatar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarRecognitionScene;", "", "VIDEO_TALK", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DigitAvatarRecognitionScene extends Enum<DigitAvatarRecognitionScene> {
    public static final DigitAvatarRecognitionScene VIDEO_TALK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DigitAvatarRecognitionScene[] f72591a = null;

    static {
        DigitAvatarRecognitionScene r100 = new DigitAvatarRecognitionScene();
        VIDEO_TALK = r100;
        f72591a = new DigitAvatarRecognitionScene[]{r100};
    }

    public static DigitAvatarRecognitionScene valueOf(String r100) {
        return (DigitAvatarRecognitionScene) r27.a.a(DigitAvatarRecognitionScene.class, r100);
    }

    public static DigitAvatarRecognitionScene[] values() {
        return (DigitAvatarRecognitionScene[]) f72591a.clone();
    }

    public DigitAvatarRecognitionScene() {
        super("VIDEO_TALK", 0);
    }
}
