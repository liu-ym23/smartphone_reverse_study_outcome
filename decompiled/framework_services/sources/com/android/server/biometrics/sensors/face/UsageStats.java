package com.android.server.biometrics.sensors.face;

import android.content.Context;
import android.hardware.face.FaceManager;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class UsageStats {
    private static final int EVENT_LOG_SIZE = 100;
    private int mAcceptCount;
    private long mAcceptLatency;
    private int mAuthAttemptCount;
    private ArrayDeque<AuthenticationEvent> mAuthenticationEvents;
    private Context mContext;
    private int mErrorCount;
    private SparseIntArray mErrorFrequencyMap;
    private long mErrorLatency;
    private SparseLongArray mErrorLatencyMap;
    private int mRejectCount;
    private long mRejectLatency;

    public static final class AuthenticationEvent {
        private boolean mAuthenticated;
        private int mError;
        private long mLatency;
        private long mStartTime;
        private int mUser;
        private int mVendorError;

        /* JADX INFO: renamed from: -$$Nest$fgetmAuthenticated, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2645$$Nest$fgetmAuthenticated(AuthenticationEvent r0) {
            return r0.mAuthenticated;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmError, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m2646$$Nest$fgetmError(AuthenticationEvent r0) {
            return r0.mError;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLatency, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m2647$$Nest$fgetmLatency(AuthenticationEvent r2) {
            return r2.mLatency;
        }

        public AuthenticationEvent(long startTime, long latency, boolean authenticated, int error, int vendorError, int user) {
            this.mStartTime = startTime;
            this.mLatency = latency;
            this.mAuthenticated = authenticated;
            this.mError = error;
            this.mVendorError = vendorError;
            this.mUser = user;
        }

        public String toString(Context context) {
            return "Start: " + this.mStartTime + "\tLatency: " + this.mLatency + "\tAuthenticated: " + this.mAuthenticated + "\tError: " + this.mError + "\tVendorCode: " + this.mVendorError + "\tUser: " + this.mUser + "\t" + FaceManager.getErrorString(context, this.mError, this.mVendorError);
        }
    }

    public UsageStats(Context context) {
        this.mAuthenticationEvents = new ArrayDeque();
        this.mErrorFrequencyMap = new SparseIntArray();
        this.mErrorLatencyMap = new SparseLongArray();
        this.mContext = context;
    }

    public void addEvent(AuthenticationEvent event) {
        this.mAuthAttemptCount++;
        if (this.mAuthenticationEvents.size() < 100) goto L5;
        this.mAuthenticationEvents.removeFirst();
    L5:
        this.mAuthenticationEvents.add(event);
        if (AuthenticationEvent.m2645$$Nest$fgetmAuthenticated(event) == false) goto L9;
        this.mAcceptCount++;
        this.mAcceptLatency += AuthenticationEvent.m2647$$Nest$fgetmLatency(event);
        return;
    L9:
        if (AuthenticationEvent.m2646$$Nest$fgetmError(event) != 0) goto L11;
        this.mRejectCount++;
        this.mRejectLatency += AuthenticationEvent.m2647$$Nest$fgetmLatency(event);
        return;
    L11:
        this.mErrorCount++;
        this.mErrorLatency += AuthenticationEvent.m2647$$Nest$fgetmLatency(event);
        this.mErrorFrequencyMap.put(AuthenticationEvent.m2646$$Nest$fgetmError(event), this.mErrorFrequencyMap.get(AuthenticationEvent.m2646$$Nest$fgetmError(event), 0) + 1);
        this.mErrorLatencyMap.put(AuthenticationEvent.m2646$$Nest$fgetmError(event), this.mErrorLatencyMap.get(AuthenticationEvent.m2646$$Nest$fgetmError(event), 0) + AuthenticationEvent.m2647$$Nest$fgetmLatency(event));
    }

    public void print(PrintWriter pw) {
        pw.println("Printing most recent events since last reboot(" + this.mAuthenticationEvents.size() + " events)");
        Iterator<AuthenticationEvent> r0 = this.mAuthenticationEvents.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AuthenticationEvent event = r0.next();
        pw.println(event.toString(this.mContext));
        goto L4
    L6:
        pw.println("");
        StringBuilder r1 = new StringBuilder();
        r1.append("Accept Count: ");
        r1.append(this.mAcceptCount);
        r1.append("\tLatency: ");
        r1.append(this.mAcceptLatency);
        r1.append("\tAverage: ");
        if (this.mAcceptCount <= 0) goto L9;
        long r7 = this.mAcceptLatency / ((long) this.mAcceptCount);
    L10:
        r1.append(r7);
        pw.println(r1.toString());
        StringBuilder r2 = new StringBuilder();
        r2.append("Reject Count: ");
        r2.append(this.mRejectCount);
        r2.append("\tLatency: ");
        r2.append(this.mRejectLatency);
        r2.append("\tAverage: ");
        if (this.mRejectCount <= 0) goto L13;
        long r8 = this.mRejectLatency / ((long) this.mRejectCount);
    L14:
        r2.append(r8);
        pw.println(r2.toString());
        StringBuilder r3 = new StringBuilder();
        r3.append("Total Error Count: ");
        r3.append(this.mErrorCount);
        r3.append("\tLatency: ");
        r3.append(this.mErrorLatency);
        r3.append("\tAverage: ");
        if (this.mErrorCount <= 0) goto L17;
        long r9 = this.mErrorLatency / ((long) this.mErrorCount);
    L18:
        r3.append(r9);
        pw.println(r3.toString());
        pw.println("Total Attempts: " + this.mAuthAttemptCount);
        pw.println("");
        int i = 0;
    L20:
        if (i >= this.mErrorFrequencyMap.size()) goto L27;
        int key = this.mErrorFrequencyMap.keyAt(i);
        int count = this.mErrorFrequencyMap.get(key);
        StringBuilder r10 = new StringBuilder();
        r10.append("Error");
        r10.append(key);
        r10.append("\tCount: ");
        r10.append(count);
        r10.append("\tLatency: ");
        r10.append(this.mErrorLatencyMap.get(key, 0));
        r10.append("\tAverage: ");
        if (count <= 0) goto L24;
        long r11 = this.mErrorLatencyMap.get(key, 0) / ((long) count);
    L25:
        r10.append(r11);
        r10.append("\t");
        r10.append(FaceManager.getErrorString(this.mContext, key, 0));
        pw.println(r10.toString());
        i = i + 1;
        goto L20
    L24:
        r11 = 0;
        goto L25
    L27:
        return;
    L17:
        r9 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r7 = 0;
        goto L10
    }
}
