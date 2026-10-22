package com.android.server.am;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.MutableLong;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class AppTimeTracker {
    private final ArrayMap<String, MutableLong> mPackageTimes;
    private final PendingIntent mReceiver;
    private String mStartedPackage;
    private MutableLong mStartedPackageTime;
    private long mStartedTime;
    private long mTotalTime;

    public AppTimeTracker(PendingIntent receiver) {
        this.mPackageTimes = new ArrayMap();
        this.mReceiver = receiver;
    }

    public void start(String packageName) {
        long now = SystemClock.elapsedRealtime();
        if (this.mStartedTime != 0) goto L6;
        this.mStartedTime = now;
    L6:
        if (packageName.equals(this.mStartedPackage) == false) goto L8;
        return;
    L8:
        if (this.mStartedPackageTime == null) goto L10;
        long elapsedTime = now - this.mStartedTime;
        this.mStartedPackageTime.value += elapsedTime;
        this.mTotalTime += elapsedTime;
    L10:
        this.mStartedPackage = packageName;
        this.mStartedPackageTime = this.mPackageTimes.get(packageName);
        if (this.mStartedPackageTime != null) goto L15;
        this.mStartedPackageTime = new MutableLong(0);
        this.mPackageTimes.put(packageName, this.mStartedPackageTime);
        return;
    }

    public void stop() {
        if (this.mStartedTime == 0) goto L9;
        long elapsedTime = SystemClock.elapsedRealtime() - this.mStartedTime;
        this.mTotalTime += elapsedTime;
        if (this.mStartedPackageTime == null) goto L7;
        this.mStartedPackageTime.value += elapsedTime;
    L7:
        this.mStartedPackage = null;
        this.mStartedPackageTime = null;
        return;
    }

    public void deliverResult(Context context) {
        stop();
        Bundle extras = new Bundle();
        extras.putLong("android.activity.usage_time", this.mTotalTime);
        Bundle pkgs = new Bundle();
        int i = this.mPackageTimes.size() - 1;
    L3:
        if (i < 0) goto L5;
        pkgs.putLong(this.mPackageTimes.keyAt(i), this.mPackageTimes.valueAt(i).value);
        i = i - 1;
        goto L3
    L5:
        extras.putBundle("android.usage_time_packages", pkgs);
        Intent fillinIntent = new Intent();
        fillinIntent.putExtras(extras);
        this.mReceiver.send(context, 0, fillinIntent);     // Catch: PendingIntent.CanceledException -> L8
        return;
    }

    public void dumpWithHeader(PrintWriter pw, String prefix, boolean details) {
        pw.print(prefix);
        pw.print("AppTimeTracker #");
        pw.print(Integer.toHexString(System.identityHashCode(this)));
        pw.println(":");
        dump(pw, prefix + "  ", details);
    }

    public void dump(PrintWriter pw, String prefix, boolean details) {
        pw.print(prefix);
        pw.print("mReceiver=");
        pw.println(this.mReceiver);
        pw.print(prefix);
        pw.print("mTotalTime=");
        TimeUtils.formatDuration(this.mTotalTime, pw);
        pw.println();
        int i = 0;
    L4:
        if (i >= this.mPackageTimes.size()) goto L7;
        pw.print(prefix);
        pw.print("mPackageTime:");
        pw.print(this.mPackageTimes.keyAt(i));
        pw.print("=");
        TimeUtils.formatDuration(this.mPackageTimes.valueAt(i).value, pw);
        pw.println();
        i = i + 1;
        goto L4
    L7:
        if (details == true) goto L9;
        return;
    L9:
        if (this.mStartedTime == 0) goto L14;
        pw.print(prefix);
        pw.print("mStartedTime=");
        TimeUtils.formatDuration(SystemClock.elapsedRealtime(), this.mStartedTime, pw);
        pw.println();
        pw.print(prefix);
        pw.print("mStartedPackage=");
        pw.println(this.mStartedPackage);
        return;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId, boolean details) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, this.mReceiver.toString());
        proto.write(1112396529666L, this.mTotalTime);
        int i = 0;
    L4:
        if (i >= this.mPackageTimes.size()) goto L7;
        long ptoken = proto.start(2246267895811L);
        proto.write(1138166333441L, this.mPackageTimes.keyAt(i));
        proto.write(1112396529666L, this.mPackageTimes.valueAt(i).value);
        proto.end(ptoken);
        i = i + 1;
        goto L4
    L7:
        if (details == true) goto L9;
    L11:
        ProtoOutputStream proto2 = proto;
    L12:
        proto2.end(token);
        return;
    L9:
        if (this.mStartedTime == 0) goto L11;
        proto2 = proto;
        ProtoUtils.toDuration(proto2, 1146756268036L, this.mStartedTime, SystemClock.elapsedRealtime());
        proto2.write(1138166333445L, this.mStartedPackage);
        goto L12
    }
}
