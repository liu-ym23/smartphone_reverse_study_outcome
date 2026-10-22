package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base;

import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/video/base/AudioState;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "MUTE", "UNMUTE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudioState extends Enum<AudioState> {
    public static final AudioState MUTE = null;
    public static final AudioState UNMUTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioState[] f166805a = null;
    private final String value;

    static {
        AudioState r100 = new AudioState("MUTE", 0, ITTVideoEngineEventSource.KEY_MUTE);
        MUTE = r100;
        AudioState r101 = new AudioState("UNMUTE", 1, "unmute");
        UNMUTE = r101;
        f166805a = new AudioState[]{r100, r101};
    }

    public static AudioState valueOf(String r100) {
        return (AudioState) a.a(AudioState.class, r100);
    }

    public static AudioState[] values() {
        return (AudioState[]) f166805a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public AudioState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
