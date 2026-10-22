package androidx.core.net;

import android.net.TrafficStats;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes17.dex */
public final class TrafficStatsCompat {

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void tagDatagramSocket(DatagramSocket r100) throws SocketException {
            TrafficStats.tagDatagramSocket(r100);
        }

        public static void untagDatagramSocket(DatagramSocket r100) throws SocketException {
            TrafficStats.untagDatagramSocket(r100);
        }
    }

    private TrafficStatsCompat() {
    }

    public static int getThreadStatsTag() {
        return TrafficStats.getThreadStatsTag();
    }

    public static void clearThreadStatsTag() {
        TrafficStats.clearThreadStatsTag();
    }

    public static void incrementOperationCount(int r100) {
        TrafficStats.incrementOperationCount(r100);
    }

    public static void setThreadStatsTag(int r100) {
        TrafficStats.setThreadStatsTag(r100);
    }

    public static void tagDatagramSocket(DatagramSocket r100) throws SocketException {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.tagDatagramSocket(r100);
        return;
    L5:
        ParcelFileDescriptor r101 = ParcelFileDescriptor.fromDatagramSocket(r100);
        TrafficStats.tagSocket(new DatagramSocketWrapper(r100, r101.getFileDescriptor()));
        r101.detachFd();
    }

    public static void tagSocket(Socket r100) throws SocketException {
        TrafficStats.tagSocket(r100);
    }

    public static void untagDatagramSocket(DatagramSocket r100) throws SocketException {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Api24Impl.untagDatagramSocket(r100);
        return;
    L5:
        ParcelFileDescriptor r101 = ParcelFileDescriptor.fromDatagramSocket(r100);
        TrafficStats.untagSocket(new DatagramSocketWrapper(r100, r101.getFileDescriptor()));
        r101.detachFd();
    }

    public static void untagSocket(Socket r100) throws SocketException {
        TrafficStats.untagSocket(r100);
    }

    public static void incrementOperationCount(int r100, int r101) {
        TrafficStats.incrementOperationCount(r100, r101);
    }
}
