package com.bes.sdk.utils;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum AudioChannel extends Enum<AudioChannel> {
    public static final AudioChannel NONE_CHANNEL = null;
    public static final AudioChannel STEREO_LEFT = null;
    public static final AudioChannel STEREO_RIGHT = null;
    public static final AudioChannel UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioChannel[] f33667a = null;
    private String mName;
    private int mValue;

    static {
        AudioChannel r100 = new AudioChannel("UNKNOWN", 0, -1, "Unknown");
        UNKNOWN = r100;
        AudioChannel r101 = new AudioChannel("NONE_CHANNEL", 1, 0, "NONE_CHANNEL");
        NONE_CHANNEL = r101;
        AudioChannel r102 = new AudioChannel("STEREO_LEFT", 2, 1, "LEFT_CHANNEL");
        STEREO_LEFT = r102;
        AudioChannel r103 = new AudioChannel("STEREO_RIGHT", 3, 2, "RIGHT_CHANNEL");
        STEREO_RIGHT = r103;
        f33667a = new AudioChannel[]{r100, r101, r102, r103};
    }

    public static AudioChannel[] values() {
        return (AudioChannel[]) f33667a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "AudioChannel{mValue=" + this.mValue + ", mName='" + this.mName + "'}";
    }

    public String getName() {
        return this.mName;
    }

    public int getValue() {
        return this.mValue;
    }

    public static AudioChannel getChannel(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return UNKNOWN;
    L10:
        return STEREO_RIGHT;
    L12:
        return STEREO_LEFT;
    L14:
        return NONE_CHANNEL;
    }

    public static AudioChannel valueOf(String r100) {
        return (AudioChannel) a.a(AudioChannel.class, r100);
    }

    public AudioChannel(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.mValue = r102;
        this.mName = r103;
    }
}
