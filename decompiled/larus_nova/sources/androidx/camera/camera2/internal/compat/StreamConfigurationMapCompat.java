package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import androidx.camera.core.Logger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class StreamConfigurationMapCompat {
    private static final String TAG = "StreamConfigurationMapCompat";
    private final Map<Class<?>, Size[]> mCachedClassOutputSizes;
    private final Map<Integer, Size[]> mCachedFormatHighResolutionOutputSizes;
    private final Map<Integer, Size[]> mCachedFormatOutputSizes;
    private final StreamConfigurationMapCompatImpl mImpl;
    private final OutputSizesCorrector mOutputSizesCorrector;

    public interface StreamConfigurationMapCompatImpl {
        Size[] getHighResolutionOutputSizes(int r100);

        int[] getOutputFormats();

        Size[] getOutputSizes(int r100);

        <T> Size[] getOutputSizes(Class<T> r100);

        StreamConfigurationMap unwrap();
    }

    public int[] getOutputFormats() {
        int[] r100 = this.mImpl.getOutputFormats();
        if (r100 != null) goto L6;
        return null;
    L6:
        return (int[]) r100.clone();
    }

    public StreamConfigurationMap toStreamConfigurationMap() {
        return this.mImpl.unwrap();
    }

    public Size[] getHighResolutionOutputSizes(int r100) {
        if (this.mCachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(r100)) == true) goto L5;
        Size[] r101 = this.mImpl.getHighResolutionOutputSizes(r100);
        if (r101 != null) goto L12;
    L14:
        this.mCachedFormatHighResolutionOutputSizes.put(Integer.valueOf(r100), r101);
        if (r101 != null) goto L17;
        return null;
    L17:
        return (Size[]) r101.clone();
    L12:
        if (r101.length <= 0) goto L14;
        r101 = this.mOutputSizesCorrector.applyQuirks(r101, r100);
        goto L14
    L5:
        if (this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(r100)) != null) goto L8;
        return null;
    L8:
        return (Size[]) this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(r100)).clone();
    }

    public Size[] getOutputSizes(int r100) {
        if (this.mCachedFormatOutputSizes.containsKey(Integer.valueOf(r100)) == true) goto L5;
        Size[] r101 = this.mImpl.getOutputSizes(r100);
        if (r101 != null) goto L12;
    L16:
        Logger.w(TAG, "Retrieved output sizes array is null or empty for format " + r100);
        return r101;
    L12:
        if (r101.length == 0) goto L16;
        Size[] r102 = this.mOutputSizesCorrector.applyQuirks(r101, r100);
        this.mCachedFormatOutputSizes.put(Integer.valueOf(r100), r102);
        return (Size[]) r102.clone();
    L5:
        if (this.mCachedFormatOutputSizes.get(Integer.valueOf(r100)) != null) goto L8;
        return null;
    L8:
        return (Size[]) this.mCachedFormatOutputSizes.get(Integer.valueOf(r100)).clone();
    }

    public <T> Size[] getOutputSizes(Class<T> r100) {
        if (this.mCachedClassOutputSizes.containsKey(r100) == true) goto L5;
        Size[] r101 = this.mImpl.getOutputSizes(r100);
        if (r101 != null) goto L12;
    L16:
        Logger.w(TAG, "Retrieved output sizes array is null or empty for class " + r100);
        return r101;
    L12:
        if (r101.length == 0) goto L16;
        Size[] r102 = this.mOutputSizesCorrector.applyQuirks(r101, r100);
        this.mCachedClassOutputSizes.put(r100, r102);
        return (Size[]) r102.clone();
    L5:
        if (this.mCachedClassOutputSizes.get(r100) != null) goto L8;
        return null;
    L8:
        return (Size[]) this.mCachedClassOutputSizes.get(r100).clone();
    }

    private StreamConfigurationMapCompat(StreamConfigurationMap r100, OutputSizesCorrector r101) {
        this.mCachedFormatOutputSizes = new HashMap();
        this.mCachedFormatHighResolutionOutputSizes = new HashMap();
        this.mCachedClassOutputSizes = new HashMap();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.mImpl = new StreamConfigurationMapCompatApi23Impl(r100);
    L6:
        this.mOutputSizesCorrector = r101;
        return;
    L5:
        this.mImpl = new StreamConfigurationMapCompatBaseImpl(r100);
        goto L6
    }

    public static StreamConfigurationMapCompat toStreamConfigurationMapCompat(StreamConfigurationMap r100, OutputSizesCorrector r101) {
        return new StreamConfigurationMapCompat(r100, r101);
    }
}
