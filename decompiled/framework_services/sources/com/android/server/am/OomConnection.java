package com.android.server.am;

import android.os.OomKillRecord;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public final class OomConnection {
    private static final String TAG = "OomConnection";
    private final OomConnectionThread mOomConnectionThread;
    private final OomConnectionListener mOomListener;

    public interface OomConnectionListener {
        void handleOomEvent(OomKillRecord[] r1);
    }

    private final class OomConnectionThread extends Thread {
        final /* synthetic */ OomConnection this$0;

        /* synthetic */ OomConnectionThread(OomConnection r1, OomConnectionIA r2) {
            this(r1);
        }

        private OomConnectionThread(OomConnection r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L8:
            OomKillRecord[] oom_kills = OomConnection.m1531$$Nest$smwaitOom();     // Catch: RuntimeException -> L5
            OomConnection.m1530$$Nest$fgetmOomListener(this.this$0).handleOomEvent(oom_kills);     // Catch: RuntimeException -> L5
        L5:
            e = move-exception;
            Slog.e(OomConnection.TAG, "failed waiting for OOM events: " + e);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOomListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ OomConnectionListener m1530$$Nest$fgetmOomListener(OomConnection r0) {
        return r0.mOomListener;
    }

    /* JADX INFO: renamed from: -$$Nest$smwaitOom, reason: not valid java name */
    static /* bridge */ /* synthetic */ OomKillRecord[] m1531$$Nest$smwaitOom() {
        return waitOom();
    }

    private static native OomKillRecord[] waitOom();

    public OomConnection(OomConnectionListener listener) {
        this.mOomListener = listener;
        this.mOomConnectionThread = new OomConnectionThread(this, null);
        this.mOomConnectionThread.start();
    }
}
