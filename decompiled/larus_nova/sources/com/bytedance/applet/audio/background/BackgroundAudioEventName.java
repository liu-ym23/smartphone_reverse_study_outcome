package com.bytedance.applet.audio.background;

import com.byted.cast.common.TeaEventTrack;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applet/audio/background/BackgroundAudioEventName;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CANPLAY", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "PAUSE", "STOP", "ENDED", "TIMEUPDATE", "ERROR", "WAITING", "SEEKING", "SEEKED", "PREV", "NEXT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BackgroundAudioEventName extends Enum<BackgroundAudioEventName> {
    public static final BackgroundAudioEventName CANPLAY = null;
    public static final BackgroundAudioEventName ENDED = null;
    public static final BackgroundAudioEventName ERROR = null;
    public static final BackgroundAudioEventName NEXT = null;
    public static final BackgroundAudioEventName PAUSE = null;
    public static final BackgroundAudioEventName PLAY = null;
    public static final BackgroundAudioEventName PREV = null;
    public static final BackgroundAudioEventName SEEKED = null;
    public static final BackgroundAudioEventName SEEKING = null;
    public static final BackgroundAudioEventName STOP = null;
    public static final BackgroundAudioEventName TIMEUPDATE = null;
    public static final BackgroundAudioEventName WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BackgroundAudioEventName[] f191443a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f191444b = null;
    private final String value;

    public static EnumEntries<BackgroundAudioEventName> getEntries() {
        return f191444b;
    }

    static {
        BackgroundAudioEventName r100 = new BackgroundAudioEventName("CANPLAY", 0, "canplay");
        CANPLAY = r100;
        BackgroundAudioEventName r101 = new BackgroundAudioEventName(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 1, "play");
        PLAY = r101;
        BackgroundAudioEventName r102 = new BackgroundAudioEventName("PAUSE", 2, "pause");
        PAUSE = r102;
        BackgroundAudioEventName r103 = new BackgroundAudioEventName("STOP", 3, "stop");
        STOP = r103;
        BackgroundAudioEventName r104 = new BackgroundAudioEventName("ENDED", 4, "ended");
        ENDED = r104;
        BackgroundAudioEventName r105 = new BackgroundAudioEventName("TIMEUPDATE", 5, "timeupdate");
        TIMEUPDATE = r105;
        BackgroundAudioEventName r110 = new BackgroundAudioEventName("ERROR", 6, "error");
        ERROR = r110;
        BackgroundAudioEventName r111 = new BackgroundAudioEventName("WAITING", 7, "waiting");
        WAITING = r111;
        BackgroundAudioEventName r112 = new BackgroundAudioEventName("SEEKING", 8, "seeking");
        SEEKING = r112;
        BackgroundAudioEventName r113 = new BackgroundAudioEventName("SEEKED", 9, "seeked");
        SEEKED = r113;
        BackgroundAudioEventName r114 = new BackgroundAudioEventName("PREV", 10, "prev");
        PREV = r114;
        BackgroundAudioEventName r106 = new BackgroundAudioEventName("NEXT", 11, TeaEventTrack.ACTION_DRAMA_NEXT);
        NEXT = r106;
        BackgroundAudioEventName[] r107 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
        f191443a = r107;
        f191444b = EnumEntriesKt.enumEntries(r107);
    }

    public static BackgroundAudioEventName[] values() {
        return (BackgroundAudioEventName[]) f191443a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static BackgroundAudioEventName valueOf(String r100) {
        return (BackgroundAudioEventName) r27.a.a(BackgroundAudioEventName.class, r100);
    }

    public BackgroundAudioEventName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
