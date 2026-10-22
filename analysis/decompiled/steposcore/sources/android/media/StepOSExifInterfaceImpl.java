package android.media;

import android.util.Log;

/* loaded from: classes.dex */
public class StepOSExifInterfaceImpl implements StepOSExifInterfaceStub {
    private static final String TAG = "StepOSExifInterface";

    public long getValidatedStripByteCount(int streamLength, long[] stripByteCounts) {
        long totalStripByteCount = 0;
        for (long stripByteCount : stripByteCounts) {
            if (stripByteCount < 0 || stripByteCount > 2147483647L || (streamLength > 0 && stripByteCount > streamLength)) {
                Log.w(TAG, "Invalid strip byte count " + stripByteCount + " for stream length " + streamLength);
                return -1L;
            }
            totalStripByteCount += stripByteCount;
        }
        if (totalStripByteCount <= 0 || totalStripByteCount > 2147483647L || (streamLength > 0 && totalStripByteCount > streamLength)) {
            Log.w(TAG, "Invalid total strip byte count " + totalStripByteCount + " for stream length " + streamLength);
            return -1L;
        }
        return totalStripByteCount;
    }
}
