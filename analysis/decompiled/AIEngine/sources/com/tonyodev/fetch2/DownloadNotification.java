package com.tonyodev.fetch2;

import android.os.Parcel;
import android.os.Parcelable;
import com.tonyodev.fetch2.Status;
import h0.e;
import java.io.Serializable;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DownloadNotification implements Parcelable, Serializable {
    public static final a CREATOR = new a();
    private Status status = Status.f8189c;
    private int progress = -1;
    private int notificationId = -1;
    private int groupId = -1;
    private long etaInMilliSeconds = -1;
    private long downloadedBytesPerSecond = -1;
    private long total = -1;
    private long downloaded = -1;
    private String namespace = "LibGlobalFetchLib";
    private String title = "";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<DownloadNotification> {
        @Override // android.os.Parcelable.Creator
        public final DownloadNotification createFromParcel(Parcel source) {
            g.f(source, "source");
            Status.a aVar = Status.f8188b;
            int i10 = source.readInt();
            aVar.getClass();
            Status statusA = Status.a.a(i10);
            int i11 = source.readInt();
            int i12 = source.readInt();
            int i13 = source.readInt();
            long j10 = source.readLong();
            long j11 = source.readLong();
            long j12 = source.readLong();
            long j13 = source.readLong();
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            String string2 = source.readString();
            String str = string2 != null ? string2 : "";
            DownloadNotification downloadNotification = new DownloadNotification();
            downloadNotification.setStatus(statusA);
            downloadNotification.setProgress(i11);
            downloadNotification.setNotificationId(i12);
            downloadNotification.setGroupId(i13);
            downloadNotification.setEtaInMilliSeconds(j10);
            downloadNotification.setDownloadedBytesPerSecond(j11);
            downloadNotification.setTotal(j12);
            downloadNotification.setDownloaded(j13);
            downloadNotification.setNamespace(string);
            downloadNotification.setTitle(str);
            return downloadNotification;
        }

        @Override // android.os.Parcelable.Creator
        public final DownloadNotification[] newArray(int i10) {
            return new DownloadNotification[i10];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.DownloadNotification");
        DownloadNotification downloadNotification = (DownloadNotification) obj;
        return this.status == downloadNotification.status && this.progress == downloadNotification.progress && this.notificationId == downloadNotification.notificationId && this.groupId == downloadNotification.groupId && this.etaInMilliSeconds == downloadNotification.etaInMilliSeconds && this.downloadedBytesPerSecond == downloadNotification.downloadedBytesPerSecond && this.total == downloadNotification.total && this.downloaded == downloadNotification.downloaded && g.b(this.namespace, downloadNotification.namespace) && g.b(this.title, downloadNotification.title);
    }

    public final long getDownloaded() {
        return this.downloaded;
    }

    public final long getDownloadedBytesPerSecond() {
        return this.downloadedBytesPerSecond;
    }

    public final long getEtaInMilliSeconds() {
        return this.etaInMilliSeconds;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final int getNotificationId() {
        return this.notificationId;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final boolean getProgressIndeterminate() {
        return this.total == -1;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getTotal() {
        return this.total;
    }

    public int hashCode() {
        return this.title.hashCode() + d.a(a0.a.c(a0.a.c(a0.a.c(a0.a.c(((((((this.status.hashCode() * 31) + this.progress) * 31) + this.notificationId) * 31) + this.groupId) * 31, this.etaInMilliSeconds, 31), this.downloadedBytesPerSecond, 31), this.total, 31), this.downloaded, 31), 31, this.namespace);
    }

    public final boolean isActive() {
        Status status = this.status;
        return status == Status.f8190d || status == Status.f8191e;
    }

    public final boolean isCancelled() {
        return this.status == Status.f8193k;
    }

    public final boolean isCancelledNotification() {
        int iOrdinal = this.status.ordinal();
        return iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 8;
    }

    public final boolean isCompleted() {
        return this.status == Status.f8192j;
    }

    public final boolean isDeleted() {
        return this.status == Status.f8196n;
    }

    public final boolean isDownloading() {
        return this.status == Status.f8191e;
    }

    public final boolean isFailed() {
        return this.status == Status.f8194l;
    }

    public final boolean isOnGoingNotification() {
        int iOrdinal = this.status.ordinal();
        return iOrdinal == 1 || iOrdinal == 2;
    }

    public final boolean isPaused() {
        return this.status == Status.h;
    }

    public final boolean isQueued() {
        return this.status == Status.f8190d;
    }

    public final boolean isRemovableNotification() {
        switch (this.status.ordinal()) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public final boolean isRemoved() {
        return this.status == Status.f8195m;
    }

    public final void setDownloaded(long j10) {
        this.downloaded = j10;
    }

    public final void setDownloadedBytesPerSecond(long j10) {
        this.downloadedBytesPerSecond = j10;
    }

    public final void setEtaInMilliSeconds(long j10) {
        this.etaInMilliSeconds = j10;
    }

    public final void setGroupId(int i10) {
        this.groupId = i10;
    }

    public final void setNamespace(String str) {
        g.f(str, "<set-?>");
        this.namespace = str;
    }

    public final void setNotificationId(int i10) {
        this.notificationId = i10;
    }

    public final void setProgress(int i10) {
        this.progress = i10;
    }

    public final void setStatus(Status status) {
        g.f(status, "<set-?>");
        this.status = status;
    }

    public final void setTitle(String str) {
        g.f(str, "<set-?>");
        this.title = str;
    }

    public final void setTotal(long j10) {
        this.total = j10;
    }

    public String toString() {
        Status status = this.status;
        int i10 = this.progress;
        int i11 = this.notificationId;
        int i12 = this.groupId;
        long j10 = this.etaInMilliSeconds;
        long j11 = this.downloadedBytesPerSecond;
        long j12 = this.total;
        long j13 = this.downloaded;
        String str = this.namespace;
        String str2 = this.title;
        StringBuilder sb2 = new StringBuilder("DownloadNotification(status=");
        sb2.append(status);
        sb2.append(", progress=");
        sb2.append(i10);
        sb2.append(", notificationId=");
        e.l(sb2, i11, ", groupId=", i12, ", etaInMilliSeconds=");
        sb2.append(j10);
        a0.a.s(j11, ", downloadedBytesPerSecond=", ", total=", sb2);
        sb2.append(j12);
        a0.a.s(j13, ", downloaded=", ", namespace='", sb2);
        return com.stepos.core.ota.d.j(sb2, str, "', title='", str2, "')");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.status.f8199a);
        dest.writeInt(this.progress);
        dest.writeInt(this.notificationId);
        dest.writeInt(this.groupId);
        dest.writeLong(this.etaInMilliSeconds);
        dest.writeLong(this.downloadedBytesPerSecond);
        dest.writeLong(this.total);
        dest.writeLong(this.downloaded);
        dest.writeString(this.namespace);
        dest.writeString(this.title);
    }
}
