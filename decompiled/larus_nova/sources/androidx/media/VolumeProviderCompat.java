package androidx.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public static abstract class Callback {
        public Callback() {
        }

        public abstract void onVolumeChanged(VolumeProviderCompat r100);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public void onAdjustVolume(int r100) {
    }

    public void onSetVolumeTo(int r100) {
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderObj != null) goto L6;
        this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, this.mCurrentVolume, new AnonymousClass1(this));
    L6:
        return this.mVolumeProviderObj;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public void setCallback(Callback r100) {
        this.mCallback = r100;
    }

    public final void setCurrentVolume(int r100) {
        this.mCurrentVolume = r100;
        Object r101 = getVolumeProvider();
        if (r101 == null) goto L5;
        VolumeProviderCompatApi21.setCurrentVolume(r101, r100);
    L5:
        Callback r102 = this.mCallback;
        if (r102 == null) goto L9;
        r102.onVolumeChanged(this);
        return;
    }

    public VolumeProviderCompat(int r100, int r101, int r102) {
        this.mControlType = r100;
        this.mMaxVolume = r101;
        this.mCurrentVolume = r102;
    }
}
