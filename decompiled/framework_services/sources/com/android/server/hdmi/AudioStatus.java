package com.android.server.hdmi;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class AudioStatus {
    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 0;
    boolean mMute;
    int mVolume;

    public AudioStatus(int volume, boolean mute) {
        this.mVolume = Math.max(Math.min(volume, 100), 0);
        this.mMute = mute;
    }

    public int getVolume() {
        return this.mVolume;
    }

    public boolean getMute() {
        return this.mMute;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof AudioStatus) == true) goto L5;
        return false;
    L5:
        AudioStatus other = (AudioStatus) obj;
        if (this.mVolume == other.mVolume) goto L8;
        return false;
    L8:
        if (this.mMute != other.mMute) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mVolume), Boolean.valueOf(this.mMute)});
    }

    public String toString() {
        return "AudioStatus mVolume:" + this.mVolume + " mMute:" + this.mMute;
    }
}
