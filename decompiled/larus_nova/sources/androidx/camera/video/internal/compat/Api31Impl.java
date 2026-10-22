package androidx.camera.video.internal.compat;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodecInfo;
import android.util.Range;

/* JADX INFO: loaded from: classes2.dex */
public final class Api31Impl {
    private Api31Impl() {
    }

    public static Range<Integer>[] getInputChannelCountRanges(MediaCodecInfo.AudioCapabilities r100) {
        return r100.getInputChannelCountRanges();
    }

    public static int getMinInputChannelCount(MediaCodecInfo.AudioCapabilities r100) {
        return r100.getMinInputChannelCount();
    }

    public static void setContext(AudioRecord.Builder r100, Context r101) {
        r100.setContext(r101);
    }
}
