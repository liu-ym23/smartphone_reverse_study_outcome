package com.bytedance.applet.audio.inner;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/audio/inner/InnerAudioEventName;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CANPLAY", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "PAUSE", "STOP", "ENDED", "TIMEUPDATE", "ERROR", "WAITING", "SEEKING", "SEEKED", "DESTROY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InnerAudioEventName extends Enum<InnerAudioEventName> {
    public static final InnerAudioEventName CANPLAY = null;
    public static final InnerAudioEventName DESTROY = null;
    public static final InnerAudioEventName ENDED = null;
    public static final InnerAudioEventName ERROR = null;
    public static final InnerAudioEventName PAUSE = null;
    public static final InnerAudioEventName PLAY = null;
    public static final InnerAudioEventName SEEKED = null;
    public static final InnerAudioEventName SEEKING = null;
    public static final InnerAudioEventName STOP = null;
    public static final InnerAudioEventName TIMEUPDATE = null;
    public static final InnerAudioEventName WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InnerAudioEventName[] f191447a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f191448b = null;
    private final String value;

    public static EnumEntries<InnerAudioEventName> getEntries() {
        return f191448b;
    }

    static {
        InnerAudioEventName r100 = new InnerAudioEventName("CANPLAY", 0, "canplay");
        CANPLAY = r100;
        InnerAudioEventName r101 = new InnerAudioEventName(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 1, "play");
        PLAY = r101;
        InnerAudioEventName r102 = new InnerAudioEventName("PAUSE", 2, "pause");
        PAUSE = r102;
        InnerAudioEventName r103 = new InnerAudioEventName("STOP", 3, "stop");
        STOP = r103;
        InnerAudioEventName r104 = new InnerAudioEventName("ENDED", 4, "ended");
        ENDED = r104;
        InnerAudioEventName r105 = new InnerAudioEventName("TIMEUPDATE", 5, "timeupdate");
        TIMEUPDATE = r105;
        InnerAudioEventName r110 = new InnerAudioEventName("ERROR", 6, "error");
        ERROR = r110;
        InnerAudioEventName r111 = new InnerAudioEventName("WAITING", 7, "waiting");
        WAITING = r111;
        InnerAudioEventName r112 = new InnerAudioEventName("SEEKING", 8, "seeking");
        SEEKING = r112;
        InnerAudioEventName r113 = new InnerAudioEventName("SEEKED", 9, "seeked");
        SEEKED = r113;
        InnerAudioEventName r114 = new InnerAudioEventName("DESTROY", 10, MapMonitorConst.EVENT_DESTROY);
        DESTROY = r114;
        InnerAudioEventName[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f191447a = r106;
        f191448b = EnumEntriesKt.enumEntries(r106);
    }

    public static InnerAudioEventName[] values() {
        return (InnerAudioEventName[]) f191447a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static InnerAudioEventName valueOf(String r100) {
        return (InnerAudioEventName) a.a(InnerAudioEventName.class, r100);
    }

    public InnerAudioEventName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
