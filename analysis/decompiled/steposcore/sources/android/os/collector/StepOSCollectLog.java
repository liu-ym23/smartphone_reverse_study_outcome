package android.os.collector;

import android.os.collector.StepOSCollectEvent;
import android.util.Log;

/* loaded from: classes.dex */
public final class StepOSCollectLog {
    private static final boolean DEBUG = true;
    private static final String TAG = "StepOSCollectLog";

    private static native void writeImpl(byte[] bArr, int i, int i2);

    static {
        System.loadLibrary("collectd_jni");
    }

    private StepOSCollectLog() {
        throw new AssertionError("StepOSCollectLog cannot be instantiated");
    }

    private static void write(int code, int arg1, int arg2) {
        StepOSCollectEvent.Builder builder = StepOSCollectEvent.newBuilder();
        builder.setAtomId(code);
        builder.writeInt(arg1);
        builder.writeInt(arg2);
        builder.usePooledBuffer();
        write(builder.build());
    }

    public static void write(int code, int userid, int pid, String processname, int flag, String annotation) {
        if (processname == null) {
            processname = "";
        }
        if (annotation == null) {
            annotation = "";
        }
        StepOSCollectEvent.Builder builder = StepOSCollectEvent.newBuilder();
        builder.setAtomId(code);
        builder.writeInt(userid);
        builder.writeInt(pid);
        builder.writeString(processname);
        builder.writeInt(flag);
        builder.writeString(annotation);
        builder.usePooledBuffer();
        StepOSCollectEvent event = builder.build();
        write(event);
    }

    private static void write(int code, int arg1, int arg2, String arg3) {
        if (arg3 == null) {
            arg3 = "";
        }
        StepOSCollectEvent.Builder builder = StepOSCollectEvent.newBuilder();
        builder.setAtomId(code);
        builder.writeInt(arg1);
        builder.writeInt(arg2);
        builder.writeString(arg3);
        builder.usePooledBuffer();
        write(builder.build());
    }

    public static StepOSCollectEvent buildCollectorEvent(int code, int arg1, int arg2) {
        StepOSCollectEvent.Builder builder = StepOSCollectEvent.newBuilder();
        builder.setAtomId(code);
        builder.writeInt(arg1);
        builder.writeInt(arg2);
        return builder.build();
    }

    public static void write(StepOSCollectEvent collectorEvent) {
        if (collectorEvent == null) {
            Log.e(TAG, "Cannot write null collector event");
            return;
        }
        Log.d(TAG, "Writing event: atomId=" + collectorEvent.getAtomId() + ", numBytes=" + collectorEvent.getNumBytes());
        try {
            try {
                writeImpl(collectorEvent.getBytes(), collectorEvent.getNumBytes(), collectorEvent.getAtomId());
            } catch (Exception e) {
                Log.e(TAG, "Failed to write collector event: " + e.getMessage(), e);
            }
        } finally {
            collectorEvent.release();
        }
    }
}
