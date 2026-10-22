package com.bytedance.android.format.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/format/model/EnterSceneType;", "", "", "scene", "I", "getScene", "()I", "Default", "PreviewExperience", "FeedBreatheCircle", "PersonalPageBreatheCircle", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnterSceneType extends Enum<EnterSceneType> {
    public static final EnterSceneType Default = null;
    public static final EnterSceneType FeedBreatheCircle = null;
    public static final EnterSceneType PersonalPageBreatheCircle = null;
    public static final EnterSceneType PreviewExperience = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterSceneType[] f51329a = null;
    private final int scene;

    static {
        EnterSceneType r100 = new EnterSceneType("Default", 0, 0);
        Default = r100;
        EnterSceneType r101 = new EnterSceneType("PreviewExperience", 1, 1);
        PreviewExperience = r101;
        EnterSceneType r102 = new EnterSceneType("FeedBreatheCircle", 2, 2);
        FeedBreatheCircle = r102;
        EnterSceneType r103 = new EnterSceneType("PersonalPageBreatheCircle", 3, 3);
        PersonalPageBreatheCircle = r103;
        f51329a = new EnterSceneType[]{r100, r101, r102, r103};
    }

    public static EnterSceneType valueOf(String r100) {
        return (EnterSceneType) r27.a.a(EnterSceneType.class, r100);
    }

    public static EnterSceneType[] values() {
        return (EnterSceneType[]) f51329a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public EnterSceneType(String r100, int r101, int r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
