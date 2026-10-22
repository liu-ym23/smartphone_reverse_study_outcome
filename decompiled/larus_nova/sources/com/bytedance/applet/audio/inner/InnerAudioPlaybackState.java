package com.bytedance.applet.audio.inner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/audio/inner/InnerAudioPlaybackState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "STOPPED", "PAUSED", "PLAYING", "INTERRUPTED", "ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InnerAudioPlaybackState extends Enum<InnerAudioPlaybackState> {
    public static final InnerAudioPlaybackState ERROR = null;
    public static final InnerAudioPlaybackState INTERRUPTED = null;
    public static final InnerAudioPlaybackState PAUSED = null;
    public static final InnerAudioPlaybackState PLAYING = null;
    public static final InnerAudioPlaybackState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InnerAudioPlaybackState[] f191449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f191450b = null;
    private final String value;

    public static EnumEntries<InnerAudioPlaybackState> getEntries() {
        return f191450b;
    }

    static {
        InnerAudioPlaybackState r100 = new InnerAudioPlaybackState("STOPPED", 0, "stopped");
        STOPPED = r100;
        InnerAudioPlaybackState r101 = new InnerAudioPlaybackState("PAUSED", 1, "paused");
        PAUSED = r101;
        InnerAudioPlaybackState r102 = new InnerAudioPlaybackState("PLAYING", 2, "playing");
        PLAYING = r102;
        InnerAudioPlaybackState r103 = new InnerAudioPlaybackState("INTERRUPTED", 3, "interrupted");
        INTERRUPTED = r103;
        InnerAudioPlaybackState r104 = new InnerAudioPlaybackState("ERROR", 4, "error");
        ERROR = r104;
        InnerAudioPlaybackState[] r105 = {r100, r101, r102, r103, r104};
        f191449a = r105;
        f191450b = EnumEntriesKt.enumEntries(r105);
    }

    public static InnerAudioPlaybackState[] values() {
        return (InnerAudioPlaybackState[]) f191449a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static InnerAudioPlaybackState valueOf(String r100) {
        return (InnerAudioPlaybackState) a.a(InnerAudioPlaybackState.class, r100);
    }

    public InnerAudioPlaybackState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
